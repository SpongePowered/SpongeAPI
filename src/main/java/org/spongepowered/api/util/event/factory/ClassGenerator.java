/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.util.event.factory;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.objectweb.asm.Opcodes.ACC_BRIDGE;
import static org.objectweb.asm.Opcodes.ACC_PRIVATE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ACC_SYNTHETIC;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ARETURN;
import static org.objectweb.asm.Opcodes.ASTORE;
import static org.objectweb.asm.Opcodes.ATHROW;
import static org.objectweb.asm.Opcodes.CHECKCAST;
import static org.objectweb.asm.Opcodes.DLOAD;
import static org.objectweb.asm.Opcodes.DRETURN;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.FLOAD;
import static org.objectweb.asm.Opcodes.FRETURN;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.IFNE;
import static org.objectweb.asm.Opcodes.IFNONNULL;
import static org.objectweb.asm.Opcodes.IFNULL;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.IRETURN;
import static org.objectweb.asm.Opcodes.LLOAD;
import static org.objectweb.asm.Opcodes.LRETURN;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.PUTFIELD;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V1_6;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.spongepowered.api.util.reflect.AccessorFirstStrategy;
import org.spongepowered.api.util.reflect.Property;
import org.spongepowered.api.util.reflect.PropertySearchStrategy;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

/**
 * Generates the bytecode for classes needed by
 * {@link ClassGeneratorProvider}.
 */
class ClassGenerator {

    private final PropertySearchStrategy propertySearch = new AccessorFirstStrategy();
    private NullPolicy nullPolicy = NullPolicy.DISABLE_PRECONDITIONS;
    private final List<String> primitivePropertyExceptions = ImmutableList.of("cancelled");

    /**
     * Insert the necessary methods to unbox a primitive type (if the given type
     * is a primitive).
     *
     * @param mv The method visitor
     * @param type The type to unbox
     */
    private static void visitUnboxingMethod(MethodVisitor mv, Class<?> type) {
        if (type == boolean.class) {
            mv.visitTypeInsn(CHECKCAST, "java/lang/Boolean");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
        } else if (type == int.class) {
            mv.visitTypeInsn(CHECKCAST, "java/lang/Integer");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
        } else if (type == byte.class) {
            mv.visitTypeInsn(CHECKCAST, "java/lang/Byte");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Byte", "byteValue", "()B", false);
        } else if (type == short.class) {
            mv.visitTypeInsn(CHECKCAST, "java/lang/Short");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Short", "shortValue", "()S", false);
        } else if (type == long.class) {
            mv.visitTypeInsn(CHECKCAST, "java/lang/Long");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Long", "longValue", "()J", false);
        } else if (type == float.class) {
            mv.visitTypeInsn(CHECKCAST, "java/lang/Float");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Float", "floatValue", "()F", false);
        } else if (type == double.class) {
            mv.visitTypeInsn(CHECKCAST, "java/lang/Double");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Double", "doubleValue", "()D", false);
        } else if (type == char.class) {
            mv.visitTypeInsn(CHECKCAST, "java/lang/Character");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Character", "charValue", "()C", false);
        } else {
            mv.visitTypeInsn(CHECKCAST, Type.getInternalName(type));
        }

    }

    /**
     * Get the opcode used for loading a local variable.
     *
     * @param type The type being loaded
     * @return The opcode
     */
    private static int getLoadOpcode(Class<?> type) {
        if (long.class.isAssignableFrom(type)) {
            return LLOAD;
        } else if (float.class.isAssignableFrom(type)) {
            return FLOAD;
        } else if (double.class.isAssignableFrom(type)) {
            return DLOAD;
        } else if (Object.class.isAssignableFrom(type)) {
            return ALOAD;
        } else {
            return ILOAD;
        }
    }

    /**
     * Get the opcode used for returning from a method.
     *
     * @param type The type being returned
     * @return The opcode
     */
    private static int getReturnOpcode(Class<?> type) {
        if (long.class.isAssignableFrom(type)) {
            return LRETURN;
        } else if (float.class.isAssignableFrom(type)) {
            return FRETURN;
        } else if (double.class.isAssignableFrom(type)) {
            return DRETURN;
        } else if (Object.class.isAssignableFrom(type)) {
            return ARETURN;
        } else {
            return IRETURN;
        }
    }

    /**
     * Tests whether a method has been implemented.
     *
     * @param type The type
     * @param method The method
     * @return Whether the method has been implemented
     */
    public static boolean hasImplementation(@Nullable Class<?> type, final Method method) {
        while (type != null) {
            try {
                Method found = type.getMethod(method.getName(), method.getParameterTypes());
                if (!Modifier.isAbstract(found.getModifiers())) {
                    return true;
                }
            } catch (NoSuchMethodException ignored) {
                // Try the superclass
            }

            type = type.getSuperclass();
        }

        return false;
    }

    /**
     * Get the policy regarding how null parameters are handled.
     *
     * @return The null policy
     */
    public NullPolicy getNullPolicy() {
        return this.nullPolicy;
    }

    /**
     * Set the policy regarding how null parameters are handled.
     *
     * @param nullPolicy The null policy
     */
    public void setNullPolicy(NullPolicy nullPolicy) {
        checkNotNull(nullPolicy, "nullPolicy");
        this.nullPolicy = nullPolicy;
    }

    /**
     * Create the event class.
     *
     * @param type The type
     * @param name The canonical of the generated class
     * @param parentType The parent type
     * @return The class' contents, to be loaded via a {@link ClassLoader}
     */
    public byte[] createClass(final Class<?> type, final String name, final Class<?> parentType) {
        checkNotNull(type, "type");
        checkNotNull(name, "name");
        checkNotNull(parentType, "parentType");

        final ImmutableSet<? extends Property> properties = this.propertySearch.findProperties(type);
        final String internalName = name.replace('.', '/');

        final ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, internalName, null, Type.getInternalName(parentType), new String[]{Type.getInternalName(type)});

        // Create the fields
        for (Property property : properties) {
            FieldVisitor fv = cw.visitField(ACC_PRIVATE, property.getName(), Type.getDescriptor(property.getType()), null, null);
            fv.visitEnd();
        }

        // Create the constructor
        {
            MethodVisitor mv =
                    cw.visitMethod(ACC_PUBLIC, "<init>", "(Ljava/util/Map;)V", "(Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;)V", null);
            mv.visitCode();

            // super()
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, Type.getInternalName(parentType), "<init>", "()V", false);

            for (Property property : properties) {
                if (hasImplementation(parentType, property.getAccessor())) {
                    continue;
                }

                // Object value = map.get("key")
                mv.visitVarInsn(ALOAD, 1);
                mv.visitLdcInsn(property.getName());
                mv.visitMethodInsn(INVOKEINTERFACE, "java/util/Map", "remove", "(Ljava/lang/Object;)Ljava/lang/Object;", true);
                mv.visitVarInsn(ASTORE, 2);

                // Only if we have a null policy:
                // if (value == null) throw new NullPointerException(...)
                if (this.nullPolicy != NullPolicy.DISABLE_PRECONDITIONS) {
                    boolean useNullTest = (this.nullPolicy == NullPolicy.NON_NULL_BY_DEFAULT && !property.hasNullable())
                            || (this.nullPolicy == NullPolicy.NULL_BY_DEFAULT && property.hasNonnull());

                    if (useNullTest && (!property.getType().isPrimitive() || !this.primitivePropertyExceptions.contains(property.getName()))) {
                        Label afterNullTest = new Label();
                        mv.visitVarInsn(ALOAD, 2);
                        mv.visitJumpInsn(IFNONNULL, afterNullTest);
                        mv.visitTypeInsn(NEW, "java/lang/NullPointerException");
                        mv.visitInsn(DUP);
                        mv.visitLdcInsn(property.getName());
                        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/NullPointerException", "<init>", "(Ljava/lang/String;)V", false);
                        mv.visitInsn(ATHROW);
                        mv.visitLabel(afterNullTest);
                    }
                }

                Label afterPut = new Label();

                // if (value != null) {
                mv.visitVarInsn(ALOAD, 2);
                mv.visitJumpInsn(IFNULL, afterPut);

                // stack: -> this
                mv.visitVarInsn(ALOAD, 0);

                // ProperObject newValue = (ProperObject) value
                mv.visitVarInsn(ALOAD, 2);
                visitUnboxingMethod(mv, property.getType());

                // this.field = newValue
                mv.visitFieldInsn(PUTFIELD, internalName, property.getName(), Type.getDescriptor(property.getType()));
                // }

                mv.visitLabel(afterPut);
            }

            // if (!map.isEmpty()) throw new IllegalArgumentException(...)
            {
                Label afterException = new Label();

                mv.visitVarInsn(ALOAD, 1);
                mv.visitMethodInsn(INVOKEINTERFACE, "java/util/Map", "isEmpty", "()Z", true);
                mv.visitJumpInsn(IFNE, afterException);

                mv.visitTypeInsn(NEW, "java/lang/IllegalArgumentException");
                mv.visitInsn(DUP);
                mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
                mv.visitInsn(DUP);
                mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
                mv.visitLdcInsn("Some parameters are unused: ");
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false);
                mv.visitVarInsn(ALOAD, 1);
                mv.visitMethodInsn(INVOKEINTERFACE, "java/util/Map", "keySet", "()Ljava/util/Set;", true);
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/Object;)Ljava/lang/StringBuilder;", false);
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);
                mv.visitMethodInsn(INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "(Ljava/lang/String;)V", false);
                mv.visitInsn(ATHROW);

                mv.visitLabel(afterException);
            }

            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        // Create the accessors and mutators
        for (Property property : properties) {
            if (!hasImplementation(parentType, property.getAccessor())) {
                Method accessor = property.getAccessor();

                MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, accessor.getName(), Type.getMethodDescriptor(accessor), null, null);
                mv.visitCode();
                mv.visitVarInsn(ALOAD, 0);
                mv.visitFieldInsn(GETFIELD, internalName, property.getName(), Type.getDescriptor(property.getType()));
                mv.visitInsn(getReturnOpcode(property.getType()));
                mv.visitMaxs(0, 0);
                mv.visitEnd();
            }

            Optional<Method> mutatorOptional = property.getMutator();
            if (mutatorOptional.isPresent() && !hasImplementation(parentType, mutatorOptional.get())) {
                Method mutator = mutatorOptional.get();

                MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, mutator.getName(), Type.getMethodDescriptor(mutator), null, null);
                mv.visitCode();
                mv.visitVarInsn(ALOAD, 0);
                mv.visitVarInsn(getLoadOpcode(property.getType()), 1);
                mv.visitFieldInsn(PUTFIELD, internalName, property.getName(), Type.getDescriptor(property.getType()));
                mv.visitInsn(RETURN);
                mv.visitMaxs(0, 0);
                mv.visitEnd();
            }
        }

        cw.visitEnd();

        return cw.toByteArray();
    }

    /**
     * Create the factory for an event class.
     *
     * @param type The event class
     * @param name The canonical name of the factory class
     * @return The factory class' bytes
     */
    public byte[] createFactory(final Class<?> type, final String name) {
        checkNotNull(type, "type");

        String internalName = name.replace('.', '/');

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, internalName, null, "java/lang/Object", new String[]{Type.getInternalName(EventFactory.class)});

        // Create the constructor
        {
            MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv.visitInsn(RETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        // Main apply()
        {
            MethodVisitor mv = cw.visitMethod(ACC_PUBLIC,
                    "apply",
                    "(Ljava/util/Map;)" + Type.getDescriptor(type),
                    "(Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;)" + Type.getDescriptor(type),
                    null);
            mv.visitCode();
            mv.visitTypeInsn(NEW, Type.getInternalName(type));
            mv.visitInsn(DUP);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKESPECIAL, Type.getInternalName(type), "<init>", "(Ljava/util/Map;)V", false);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        // Bridge apply()
        {
            MethodVisitor mv = cw.visitMethod(
                    ACC_PUBLIC + ACC_BRIDGE + ACC_SYNTHETIC,
                    "apply",
                    "(Ljava/lang/Object;)Ljava/lang/Object;",
                    null,
                    null);
            mv.visitCode();
            mv.visitVarInsn(ALOAD, 0);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitTypeInsn(CHECKCAST, "java/util/Map");
            mv.visitMethodInsn(
                    INVOKEVIRTUAL,
                    internalName,
                    "apply",
                    "(Ljava/util/Map;)" + Type.getDescriptor(type),
                    false);
            mv.visitInsn(ARETURN);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }

        cw.visitEnd();

        return cw.toByteArray();
    }

}
