/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.util.generator.event.factory;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ARETURN;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V1_8;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.spongepowered.api.eventgencore.classwrapper.reflection.ReflectionUtils;
import org.spongepowered.api.util.generator.event.factory.plugin.AccessorModifierEventFactoryPlugin;
import org.spongepowered.api.util.generator.event.factory.plugin.EventFactoryPlugin;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactoryInterfaceGenerator {

    public static List<? extends EventFactoryPlugin> plugins = Lists.newArrayList(new AccessorModifierEventFactoryPlugin());

    public static byte[] createClass(final Class<?> factoryInterface, String name, ClassGeneratorProvider provider) {
        Preconditions.checkArgument(factoryInterface.isInterface(), "Provided factory interface class is not an interface! %s", factoryInterface);

        String internalName = ClassGenerator.getInternalName(name);

        final ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        cw.visit(V1_8, ACC_PUBLIC + ACC_SUPER, internalName, null, "java/lang/Object", new String[] {Type.getInternalName(factoryInterface)});

        createConstructor(cw);

        Map<Class<?>, Class<?>> eventInterfaceToImpl = new HashMap<>();
        for (Method method: factoryInterface.getMethods()) {
            generateMethodImpl(cw, method, eventInterfaceToImpl, provider);
        }

        cw.visitEnd();
        return cw.toByteArray();
    }

    private static void createConstructor(ClassWriter cw) {
        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();

        // super()
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);

        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }


    private static void generateMethodImpl(ClassWriter cw, Method method, Map<Class<?>, Class<?>> classCache, ClassGeneratorProvider provider) {
        Class<?> eventImpl = getEventImpl(method.getReturnType(), classCache, provider);

        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, method.getName(), Type.getMethodDescriptor(method), null, null);
        mv.visitCode();

        String internalEvent = Type.getInternalName(eventImpl);

        mv.visitTypeInsn(NEW, internalEvent);
        mv.visitInsn(DUP);

        Map<Parameter, Integer> argumentIndices = getParameterIndices(method);
        List<Parameter> sorted = getSortedParameters(method);

        // We push the parameters onto the stack in alphabetical order, to match the generated constructor
        for (int i = 0; i < sorted.size(); i++) {
            Parameter param = sorted.get(i);
            Type type = Type.getType(param.getType());
            mv.visitVarInsn(type.getOpcode(Opcodes.ILOAD), argumentIndices.get(param)); // Parameters start at slot 1
        }
        mv.visitMethodInsn(INVOKESPECIAL, internalEvent, "<init>", getMethodDesc(sorted), false);

        mv.visitInsn(ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }

    private static Map<Parameter, Integer> getParameterIndices(Method method) {
        Map<Parameter, Integer> map = new HashMap<>();
        Parameter[] params = method.getParameters();
        for (int i = 0, k = 1; i < params.length; i++, k++) { // Parameters start at 1 for instance methods
            Parameter param = params[i];
            Type type = Type.getType(param.getType());
            map.put(param, k);

            if (type.equals(Type.LONG_TYPE) || type.equals(Type.DOUBLE_TYPE)) {
                k++; // Skip over the following unuseable slot
            }
        }
        return map;
    }

    private static List<Parameter> getSortedParameters(Method method) {
        List<Parameter> parameters = Lists.newArrayList(method.getParameters());
        for (Parameter parameter: parameters) {
            if (!parameter.isNamePresent()) {
                throw new IllegalStateException(String.format("Parameter %s for methodd %s has no name!", parameter, method));
            }
        }
        parameters.sort(Comparator.comparing(Parameter::getName));

        return parameters;
    }

    private static String getMethodDesc(List<Parameter> parameters) {
        StringBuilder builder = new StringBuilder();
        builder.append('(');
        for (Parameter parameter: parameters) {
            builder.append(Type.getDescriptor(parameter.getType()));
        }
        builder.append(")V");
        return builder.toString();
    }

    private static Class<?> getEventImpl(Class<?> eventInterface, Map<Class<?>, Class<?>> classCache, ClassGeneratorProvider provider) {
        return classCache.computeIfAbsent(eventInterface, i -> provider.createEventImpl(eventInterface, ReflectionUtils.getBaseClass(eventInterface).getActualClass(), plugins));
    }

}
