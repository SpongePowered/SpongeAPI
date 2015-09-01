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
package org.spongepowered.api.util.event.factory.plugin;

import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.spongepowered.api.eventgencore.Property;
import org.spongepowered.api.util.annotation.TransformResult;
import org.spongepowered.api.util.annotation.TransformWith;
import org.spongepowered.api.util.event.factory.ClassGenerator;

import java.lang.reflect.Method;

/**
 * An event factory plugin to modify the return type of an accessor
 * by calling one of its methods.
 */
public class AccessorModifierEventFactoryPlugin implements EventFactoryPlugin {

    private MethodPair getLinkedField(Property<Class<?>, Method> property) {

        Method leastSpecificMethod = property.getLeastSpecificMethod();
        TransformResult transformResult;
        Method transformWith = null;
        String name = null;

        if ((transformResult = leastSpecificMethod.getAnnotation(TransformResult.class)) != null) {
            name = transformResult.value();
            // Since we that the modifier method (the one annotated with TransformWith) doesn't
            // use covariant types, we can call getMethods on the more specific version,
            // allowing the annotation to be present on a method defined there, as well as in
            // the least specific type.
            for (Method method: property.getAccessor().getReturnType().getMethods()) {
                TransformWith annotation = method.getAnnotation(TransformWith.class);
                if (annotation != null && annotation.value().equals(name)) {
                    if (transformWith != null) {
                        throw new RuntimeException("Multiple @TransformResult annotations were found with the name "
                                + name + ". One of them needs to be changed!");
                    }
                    transformWith = method;
                }
            }
            if (transformWith == null) {
                throw new RuntimeException("Unable to locate a matching @TransformWith annotation with the name "
                        + name + " for the method" + property.getAccessor());
            }
        }

        if (transformWith != null) {
            return new MethodPair(name, leastSpecificMethod, transformWith, property);
        }
        return null;
    }

    private void generateTransformingAccessor(ClassWriter cw, String internalName, MethodPair pair, Property<Class<?>, Method> property) {

        Method accessor = property.getAccessor();

        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, accessor.getName(), Type.getMethodDescriptor(accessor), null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        mv.visitFieldInsn(GETFIELD, internalName, property.getName(), Type.getDescriptor(property.getLeastSpecificType()));

        Method transformerMethod = pair.getTransformerMethod();

        int opcode = INVOKEVIRTUAL;
        if (transformerMethod.getDeclaringClass().isInterface()) {
            opcode = INVOKEINTERFACE;
        }

        mv.visitMethodInsn(opcode, Type.getInternalName(transformerMethod.getDeclaringClass()), transformerMethod.getName(),
                Type.getMethodDescriptor(transformerMethod), opcode == INVOKEVIRTUAL ? false : true);

        mv.visitInsn(ClassGenerator.getReturnOpcode(property.getType()));
        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }

    @Override
    public boolean contributeProperty(Class<?> eventClass, String internalName, ClassWriter classWriter, Property<Class<?>, Method> property) {
        MethodPair methodPair = this.getLinkedField(property);
        if (methodPair == null) {
            return false;
        }

        ClassGenerator.generateField(classWriter, property);
        if (property.getMutator().isPresent()) {
            ClassGenerator.generateMutator(classWriter, eventClass, internalName, property.getName(), property.getType(), property);
        }

        this.generateTransformingAccessor(classWriter, internalName, methodPair, property);

        return true;
    }

    private static final class MethodPair {

        private final String name;

        private Method callerMethod;
        private Method transformerMethod;

        private Property<Class<?>, Method> property;

        public MethodPair(String name, Method callerMethod, Method transformerMethod, Property<Class<?>, Method> property) {
            this.name = name;
            this.callerMethod = callerMethod;
            this.transformerMethod = transformerMethod;
            this.property = property;
        }

        public String getName() {
            return this.name;
        }

        public Method getTransformerMethod() {
            return this.transformerMethod;
        }

        public Property<Class<?>, Method> getProperty() {
            return this.property;
        }
    }
}
