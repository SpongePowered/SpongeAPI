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
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V1_6;
import static org.objectweb.asm.Opcodes.ACC_PROTECTED;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.spongepowered.api.event.AbstractEvent;
import org.spongepowered.api.util.annotation.SetField;
import org.spongepowered.api.util.annotation.TransformResult;
import org.spongepowered.api.util.annotation.TransformWith;
import org.spongepowered.api.util.event.factory.ClassGenerator;
import org.spongepowered.api.util.event.factory.ClassGeneratorProvider;
import org.spongepowered.api.util.event.factory.EventFactoryPlugin;
import org.spongepowered.api.util.reflect.AccessorFirstStrategy;
import org.spongepowered.api.util.reflect.Property;
import org.spongepowered.api.util.reflect.PropertySearchStrategy;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * An event factory plugin to modify the return type of an accessor
 * by calling one of its methods.
 */
public class AccessorModifierEventFactoryPlugin implements EventFactoryPlugin {

    private static final PropertySearchStrategy propertySearch = new AccessorFirstStrategy();

    private final LoadingCache<Class<?>, Class<?>> superclasses = CacheBuilder.newBuilder()
            .build(
                    new CacheLoader<Class<?>, Class<?>>() {
                        @Override
                        public Class<?> load(Class<?> type) {
                            return generateSuperclass(type);
                        }
                    });


    private final String targetPackage;

    private ClassGeneratorProvider.LocalClassLoader classLoader;
    private Class<?> superClass;

    public AccessorModifierEventFactoryPlugin(String targetPackage) {
        this.targetPackage = targetPackage;
    }

    private boolean canGenerate(Class<?> eventClass) {
        final ImmutableSet<? extends Property> properties = propertySearch.findProperties(eventClass);
        Collection<MethodPair> pairs = this.getLinkedFields(properties);
        return !pairs.isEmpty();
    }

    private Class<?> generateSuperclass(Class<?> eventClass) {
        // MAGIC
        String name = this.targetPackage + "." + "Abstract" + eventClass.getSimpleName();
        String internalName = name.replace('.', '/');

        final ImmutableSet<? extends Property> properties = propertySearch.findProperties(eventClass);
        Collection<MethodPair> pairs = this.getLinkedFields(properties);
        if (pairs.isEmpty()) {
            return this.superClass;
        }

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, internalName, null, Type.getInternalName(AbstractEvent.class),
                 new String[]{Type.getInternalName(eventClass)});

        {
            MethodVisitor mv =
                    cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();

            // super()
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, Type.getInternalName(AbstractEvent.class), "<init>", "()V", false);

            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        for (MethodPair pair: pairs) {
            Property property = pair.getProperty();
            Method accessor = property.getAccessor();
            Method transformerMethod = pair.getTransfomrerMethod();

            if (property.isLeastSpecificType()) {
                FieldVisitor fv = cw.visitField(ACC_PROTECTED, property.getName(), Type.getDescriptor(property.getLeastSpecificType()), null, null);
                AnnotationVisitor visitor = fv.visitAnnotation(Type.getDescriptor(SetField.class), true);
                visitor.visit("isRequired", true);
                visitor.visitEnd();
                fv.visitEnd();
            }


            MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, accessor.getName(), Type.getMethodDescriptor(accessor), null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, internalName, property.getName(), Type.getDescriptor(property.getLeastSpecificType()));

            int opcode = INVOKESPECIAL;
            if (accessor.getReturnType().isInterface()) {
                opcode = INVOKEINTERFACE;
            }


            mv.visitMethodInsn(opcode, Type.getInternalName(accessor.getReturnType()), transformerMethod.getName(), Type.getMethodDescriptor(transformerMethod), opcode == INVOKESPECIAL ? false : true);

            mv.visitInsn(ClassGenerator.getReturnOpcode(property.getType()));
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }
        cw.visitEnd();
        return this.classLoader.defineClass(name, cw.toByteArray());
    }

    private Collection<MethodPair> getLinkedFields(Set<? extends Property> properties) {
        Map<Property, Map<String, MethodPair>> methodPairs = Maps.newHashMap();
        for (Property property: properties) {
            if (!methodPairs.containsKey(property)) {
                methodPairs.put(property, new HashMap<String, MethodPair>());
            }

            Method leastSpecificMethod = property.getLeastSpecificMethod();
            TransformResult result;
            TransformWith transformWith;

            if ((result = leastSpecificMethod.getAnnotation(TransformResult.class)) != null) {
                String name = result.value();
                // Since we that the modifier method (the one annotated with TransformWith) doesn't
                // use covariant types, we can call getMethods on the more specific version,
                // allowing the annotation to be present on a method defined there, as well as in
                // the least specific type.
                for (Method method: property.getAccessor().getReturnType().getMethods()) {
                    if ((transformWith = method.getAnnotation(TransformWith.class)) != null && transformWith.value().equals(name)) {
                        if (methodPairs.get(property).containsKey(name)) {
                            throw new RuntimeException("Multiple @TransformResult annotations were found with the name " +
                                                       name + ". One of them needs to be changed!");
                        }
                        methodPairs.get(property).put(name, new MethodPair(name, leastSpecificMethod, method, property));
                        break;
                    }
                }
                if (!methodPairs.get(property).containsKey(name)) {
                    throw new RuntimeException("Unable to locate a matching @TransformWith annotation with the name " +
                                              name + " for the method" + property.getAccessor());
                }
            }
        }
        Set<MethodPair> pairs = Sets.newHashSet();
        for (Map<String, MethodPair> map: methodPairs.values()) {
            pairs.addAll(map.values());
        }
        return pairs;
    }

    @Override
    public Class<?> resolveSuperClassFor(Class<?> eventClass, Class<?> superClass, ClassGeneratorProvider.LocalClassLoader classLoader) {
        this.classLoader = classLoader;
        this.superClass = superClass;
        return this.canGenerate(eventClass) ? this.superclasses.getUnchecked(eventClass) : null;
    }

    private static final class MethodPair {

        private final String name;

        private Method callerMethod;
        private Method transformerMethod;

        private Property property;

        public MethodPair(String name, Method callerMethod, Method transformerMethod, Property property) {
            this.name = name;
            this.callerMethod = callerMethod;
            this.transformerMethod = transformerMethod;
            this.property = property;
        }

        public String getName() {
            return name;
        }

        public Method getTransfomrerMethod() {
            return transformerMethod;
        }

        public Property getProperty() {
            return this.property;
        }
    }
}
