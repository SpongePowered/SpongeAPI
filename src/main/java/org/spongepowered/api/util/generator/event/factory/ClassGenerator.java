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
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.IFNE;
import static org.objectweb.asm.Opcodes.IFNONNULL;
import static org.objectweb.asm.Opcodes.IFNULL;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.INSTANCEOF;
import static org.objectweb.asm.Opcodes.INVOKEINTERFACE;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;
import static org.objectweb.asm.Opcodes.IRETURN;
import static org.objectweb.asm.Opcodes.ISUB;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.PUTFIELD;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V1_6;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.spongepowered.api.eventgencore.AccessorFirstStrategy;
import org.spongepowered.api.eventgencore.Property;
import org.spongepowered.api.eventgencore.PropertySearchStrategy;
import org.spongepowered.api.eventgencore.PropertySorter;
import org.spongepowered.api.eventgencore.annotation.PropertySettings;
import org.spongepowered.api.eventgencore.annotation.UseField;
import org.spongepowered.api.eventgencore.classwrapper.reflection.ReflectionClassWrapper;
import org.spongepowered.api.util.generator.event.factory.plugin.EventFactoryPlugin;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Generates the bytecode for classes needed by {@link ClassGeneratorProvider}.
 */
public class ClassGenerator {

    private final PropertySearchStrategy<Class<?>, Method> propertySearch = new AccessorFirstStrategy<>();
    private NullPolicy nullPolicy = NullPolicy.DISABLE_PRECONDITIONS;
    private final List<String> primitivePropertyExceptions = ImmutableList.of("cancelled");

    /**
     * Insert the necessary methods to box a primitive type (if the given type
     * is a primitive object).
     *
     * @param mv The method visitor
     * @param type The type to unbox
     */
    public static void visitBoxingMethod(MethodVisitor mv, Type type) {
        if (type.getSort() == Type.BOOLEAN) {
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;", false);
        } else if (type.getSort() == Type.INT) {
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
        } else if (type.getSort() == Type.BYTE) {
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Byte", "valueOf", "(B)Ljava/lang/Byte;", false);
        } else if (type.getSort() == Type.SHORT) {
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;", false);
        } else if (type.getSort() == Type.LONG) {
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
        } else if (type.getSort() == Type.FLOAT) {
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;", false);
        } else if (type.getSort() == Type.DOUBLE) {
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;", false);
        } else if (type.getSort() == Type.CHAR) {
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;", false);
        }
    }

    /**
     * Insert the necessary methods to unbox a primitive type (if the given type
     * is a primitive).
     *
     * @param mv The method visitor
     * @param type The type to unbox
     */
    public static void visitUnboxingMethod(MethodVisitor mv, Type type) {
        if (type.getSort() == Type.BOOLEAN) {
            mv.visitTypeInsn(CHECKCAST, "java/lang/Boolean");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Boolean", "booleanValue", "()Z", false);
        } else if (type.getSort() == Type.INT) {
            mv.visitTypeInsn(CHECKCAST, "java/lang/Integer");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
        } else if (type.getSort() == Type.BYTE) {
            mv.visitTypeInsn(CHECKCAST, "java/lang/Byte");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Byte", "byteValue", "()B", false);
        } else if (type.getSort() == Type.SHORT) {
            mv.visitTypeInsn(CHECKCAST, "java/lang/Short");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Short", "shortValue", "()S", false);
        } else if (type.getSort() == Type.LONG) {
            mv.visitTypeInsn(CHECKCAST, "java/lang/Long");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Long", "longValue", "()J", false);
        } else if (type.getSort() == Type.FLOAT) {
            mv.visitTypeInsn(CHECKCAST, "java/lang/Float");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Float", "floatValue", "()F", false);
        } else if (type.getSort() == Type.DOUBLE) {
            mv.visitTypeInsn(CHECKCAST, "java/lang/Double");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Double", "doubleValue", "()D", false);
        } else if (type.getSort() == Type.CHAR) {
            mv.visitTypeInsn(CHECKCAST, "java/lang/Character");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Character", "charValue", "()C", false);
        } else {
            mv.visitTypeInsn(CHECKCAST, type.getInternalName());
        }
    }

    private static PropertySettings getPropertySettings(Property<Class<?>, Method> property) {
        return property.getAccessor().getAnnotation(PropertySettings.class);
    }

    private static boolean isRequired(Property<Class<?>, Method> property) {
        PropertySettings settings = getPropertySettings(property);
        if (settings != null) {
            return settings.requiredParameter();
        }
        return true;
    }

    private static boolean generateMethods(Property<Class<?>, Method> property) {
        PropertySettings settings = getPropertySettings(property);
        if (settings != null) {
            return settings.generateMethods();
        }
        return true;
    }

    private static UseField getUseField(Class<?> clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName).getAnnotation(UseField.class);
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    /**
     * Gets whether the desired {@link Class} type has the desired method by
     * {@code name} with the given {@code params}.
     *
     * @param type The type of class
     * @param name The name of the method
     * @param params The parameter array of parameter types
     * @return True if the class has a method of the defined method and type
     */
    public static boolean hasDeclaredMethod(Class<?> type, String name, Class<?>... params) {
        while (type != null) {
            try {
                type.getDeclaredMethod(name, params);
                return true;
            } catch (NoSuchMethodException ignored) {
                // Try the superclass
            }

            type = type.getSuperclass();
        }

        return false;
    }

    /**
     * Gets a {@link Field} from the desired {@link Class} by the
     * {@link String field name}. However, this will attempt to climb
     * superclasses to fetch a field from a superclass
     *
     * @see Class#getField(String)
     * @param type The class type
     * @param fieldName The name of the field
     * @return The field, or null
     */
    public static Field getField(Class<?> type, String fieldName) {
        while (type != null) {
            try {
                return type.getDeclaredField(fieldName);
            } catch (NoSuchFieldException ignored) {
                // Try the superclass
            }

            type = type.getSuperclass();
        }
        return null;
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

    private boolean hasNullable(Method method) {
        return method.getAnnotation(Nullable.class) != null;
    }

    private boolean hasNonnull(Method method) {
        return method.getAnnotation(Nonnull.class) != null;
    }

    /**
     * Creates a field with the provided {@link ClassWriter} and based on the provided
     * {@link Property}.
     *
     * @param classWriter The class writer to use
     * @param property The property containing various information
     */
    public static void generateField(ClassWriter classWriter, Property<Class<?>, Method> property) {
        FieldVisitor fv = classWriter.visitField(ACC_PRIVATE, property.getName(), Type.getDescriptor(property.getType()), null, null);
        fv.visitEnd();
    }

    private void contributeField(ClassWriter classWriter, Class<?> parentType, Property<Class<?>, Method> property) {
        if (property.isLeastSpecificType()) {
            Field field = getField(parentType, property.getName());
            if (field == null || field.getAnnotation(UseField.class) == null) {
                generateField(classWriter, property);
            } else if ((field.getModifiers() & Modifier.PRIVATE) != 0) {
                throw new RuntimeException("You've annotated the field " + property.getName() + " with @SetField, "
                        + "but it's private. This just won't work.");
            } else if (!property.getType().isAssignableFrom(property.getType())) {
                throw new RuntimeException("You've specified a field of type " + field.getType().getCanonicalName()
                        + "but the property has the type of " + property.getType().getCanonicalName());
            }
        }
    }

    private void generateConstructor(ClassWriter classWriter, String internalName, Class<?> parentType,
           List<? extends Property<Class<?>, Method>> properties) {

        List<? extends Property<Class<?>, Method>> requiredProperties = properties.stream().filter(p -> p.isLeastSpecificType() && isRequired(p)).collect(Collectors.toList());

        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for (Property<Class<?>, Method> property: properties) {
            if (!property.isMostSpecificType() || !isRequired(property)) {
                continue;
            }
            builder.append(Type.getDescriptor(property.getType()));
        }
        builder.append(")V");

        String methodDesc = builder.toString();

        MethodVisitor mv =
                classWriter.visitMethod(ACC_PUBLIC, "<init>", methodDesc, null, null);
        mv.visitCode();

        // super()
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, Type.getInternalName(parentType), "<init>", "()V", false);

        // 0 is 'this', parameters start at 1
        for (int i = 0, paramIndex = 1; i < requiredProperties.size(); i++, paramIndex++) {
            Property<Class<?>, Method> property = requiredProperties.get(i);

            Type type = Type.getType(property.getType());
            int loadOpcode = type.getOpcode(Opcodes.ILOAD);

            boolean isPrimitive = property.getType().isPrimitive();

            // Only if we have a null policy:
            // if (value == null) throw new NullPointerException(...)
            if (this.nullPolicy != NullPolicy.DISABLE_PRECONDITIONS) {
                boolean useNullTest = !isPrimitive && (((this.nullPolicy == NullPolicy.NON_NULL_BY_DEFAULT && !this.hasNullable(property.getAccessor()))
                        || (this.nullPolicy == NullPolicy.NULL_BY_DEFAULT && this.hasNonnull(property.getAccessor())))
                        && isRequired(property));

                if (useNullTest) {
                    Label afterNullTest = new Label();
                    mv.visitVarInsn(loadOpcode, paramIndex);
                    mv.visitJumpInsn(IFNONNULL, afterNullTest);
                    mv.visitTypeInsn(NEW, "java/lang/NullPointerException");
                    mv.visitInsn(DUP);
                    mv.visitLdcInsn("The property '" + property.getName() + "' was not provided!");
                    mv.visitMethodInsn(INVOKESPECIAL, "java/lang/NullPointerException", "<init>", "(Ljava/lang/String;)V", false);
                    mv.visitInsn(ATHROW);
                    mv.visitLabel(afterNullTest);
                }
            }

            final boolean hasUseField = getUseField(parentType, property.getName()) != null;

            Label afterPut = new Label();

            if (!isPrimitive) {
                // if (value != null) {
                mv.visitVarInsn(loadOpcode, paramIndex);
                mv.visitJumpInsn(IFNULL, afterPut);
            }

            // stack: -> this
            mv.visitVarInsn(ALOAD, 0);

            // ProperObject newValue = (ProperObject) value
            mv.visitVarInsn(loadOpcode, paramIndex);
            //visitUnboxingMethod(mv, Type.getType(property.getType()));

            // this.field = newValue
            if (hasUseField) {
                mv.visitFieldInsn(PUTFIELD, Type.getInternalName(parentType), property.getName(), Type.getDescriptor(property.getType()));
            } else {
                mv.visitFieldInsn(PUTFIELD, internalName, property.getName(), Type.getDescriptor(property.getType()));
            }
            // }

            mv.visitLabel(afterPut);

            if (type.getSize() > 1) {
                paramIndex++; // Skip empty slot
            }
        }

        // super.init();
        if (hasDeclaredMethod(parentType, "init")) {
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, Type.getInternalName(parentType), "init", "()V", false);
        }

        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }

    private void generateAccessor(ClassWriter cw, Class<?> parentType, String internalName, Property<Class<?>, Method> property) {
        Method accessor = property.getAccessor();

        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, accessor.getName(), Type.getMethodDescriptor(accessor), null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        mv.visitFieldInsn(GETFIELD, internalName, property.getName(), Type.getDescriptor(property.getLeastSpecificType()));

        if (!property.isLeastSpecificType()) {
            mv.visitTypeInsn(CHECKCAST, Type.getInternalName(property.getType()));
        }
        mv.visitInsn(Type.getType(property.getType()).getOpcode(IRETURN));
        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }

    /**
     * Generates a standard mutator method.
     *
     * <p>This method assumes that a standard field has been generated for the
     * provided {@link Property}</p>
     *
     * @param cw The {@link ClassWriter} to generate the mutator in
     * @param type The {@link Class} of the event that's having an
     *        implementation generated
     * @param internalName The internal name (slashes instead of periods in the
     *        package) of the new class being generated
     * @param fieldName The name of the field to mutate
     * @param fieldType The type of the field to mutate
     * @param property The {@link Property} containing the mutator method to
     *        generate for
     */
    public static void generateMutator(ClassWriter cw, Class<?> type, String internalName, String fieldName, Class<?> fieldType,
            Property<Class<?>, Method> property) {
        Method mutator = property.getMutator().get();

        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, mutator.getName(), Type.getMethodDescriptor(mutator), null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        mv.visitVarInsn(Type.getType(property.getType()).getOpcode(ILOAD), 1);

        if (property.getAccessor().getReturnType().equals(Optional.class)) {
            mv.visitMethodInsn(INVOKESTATIC, "java/util/Optional", "ofNullable",
                    "(Ljava/lang/Object;)Ljava/util/Optional;", false);
        }

        if (!property.getType().isPrimitive()) {
            Class<?> mostSpecificReturn;
            try {
                mostSpecificReturn =
                        type.getMethod(property.getAccessor().getName(), property.getAccessor().getParameterTypes()).getReturnType();
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("If you're seeing this, than something's REALLY wrong");
            }
            Label afterException = new Label();
            mv.visitInsn(DUP);
            mv.visitJumpInsn(IFNULL, afterException);
            mv.visitInsn(DUP);
            mv.visitTypeInsn(INSTANCEOF, Type.getInternalName(mostSpecificReturn));

            mv.visitJumpInsn(IFNE, afterException);

            mv.visitTypeInsn(NEW, "java/lang/RuntimeException");
            mv.visitInsn(DUP);

            mv.visitTypeInsn(NEW, "java/lang/StringBuilder");
            mv.visitInsn(DUP);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);

            mv.visitLdcInsn("You've attempted to call the method '" + mutator.getName() + "' with an object of type ");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/Object;)Ljava/lang/StringBuilder;", false);

            mv.visitVarInsn(Type.getType(property.getType()).getOpcode(ILOAD), 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Class", "getName", "()Ljava/lang/String;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/Object;)Ljava/lang/StringBuilder;", false);

            mv.visitLdcInsn(", instead of " + mostSpecificReturn.getName() + ". Though you may have been listening for a supertype of this "
                    + "event, it's actually a " + type.getName() + ". You need to ensure that the type of the event is what you think"
                    + " it is, before calling the method (e.g TileEntityChangeEvent#setNewData");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/Object;)Ljava/lang/StringBuilder;", false);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);

            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/RuntimeException", "<init>", "(Ljava/lang/String;)V", false);
            mv.visitInsn(ATHROW);

            mv.visitLabel(afterException);
        }

        mv.visitFieldInsn(PUTFIELD, internalName, property.getName(), Type.getDescriptor(property.getType()));
        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }

    private void generateAccessorsandMutator(ClassWriter cw, Class<?> type, Class<?> parentType, String internalName,
            Property<Class<?>, Method> property) {
        if (generateMethods(property)) {
            this.generateAccessor(cw, parentType, internalName, property);

            Optional<Method> mutatorOptional = property.getMutator();
            if (mutatorOptional.isPresent()) {
                generateMutator(cw, type, internalName, property.getName(), property.getType(), property);
            }
        }
    }

    private MethodVisitor initializeToString(ClassWriter cw, Class<?> type) {
        MethodVisitor toStringMv = cw.visitMethod(ACC_PUBLIC, "toString", "()Ljava/lang/String;", null, null);
        toStringMv.visitCode();
        toStringMv.visitTypeInsn(NEW, "java/lang/StringBuilder");
        toStringMv.visitInsn(DUP);
        toStringMv.visitMethodInsn(INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false);
        toStringMv.visitLdcInsn(type.getName() + "{");
        toStringMv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/Object;)Ljava/lang/StringBuilder;", false);

        toStringMv.visitVarInsn(ASTORE, 1);

        return toStringMv;
    }

    private void contributeToString(String internalName, Class<?> parentType, Property<Class<?>, Method> property, MethodVisitor toStringMv) {
        if (property.isLeastSpecificType()) {

            boolean overrideToString = false;
            UseField useField = getUseField(parentType, property.getName());
            if (useField != null) {
                overrideToString = useField.overrideToString();
            }

            Type returnType = Type.getReturnType(property.getAccessor());

            toStringMv.visitVarInsn(ALOAD, 0);

            toStringMv.visitVarInsn(ALOAD, 1);
            toStringMv.visitLdcInsn(property.getName());
            toStringMv
                    .visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/Object;)Ljava/lang/StringBuilder;", false);

            toStringMv.visitLdcInsn("=");
            toStringMv
                    .visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/Object;)Ljava/lang/StringBuilder;", false);

            toStringMv.visitVarInsn(ALOAD, 0);
            if (overrideToString) {
                toStringMv.visitFieldInsn(GETFIELD, internalName, property.getName(), Type.getDescriptor(property.getType()));
            } else {
                toStringMv.visitMethodInsn(INVOKESPECIAL, internalName, property.getAccessor().getName(),
                        Type.getMethodDescriptor(property.getAccessor()), false);
            }

            String desc = property.getType().isPrimitive() ? Type.getDescriptor(property.getType()) : "Ljava/lang/Object;";

            toStringMv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append",
                    "(" + desc + ")Ljava/lang/StringBuilder;", false);

            toStringMv.visitLdcInsn(", ");
            toStringMv
                    .visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/Object;)Ljava/lang/StringBuilder;", false);
        }
    }

    private void finalizeToString(MethodVisitor mv) {
        // The StringBuilder is on the top of the stack from the last append() -
        // duplicate it for call to replace()
        mv.visitVarInsn(ALOAD, 1);
        mv.visitInsn(DUP);

        // The replace starts at 2 characters before the end, to remove the
        // extra command and space added
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "length", "()I", false);
        mv.visitLdcInsn(2);
        mv.visitInsn(ISUB);

        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "length", "()I", false);

        mv.visitLdcInsn("}");

        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "replace", "(IILjava/lang/String;)Ljava/lang/StringBuilder;", false);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false);

        mv.visitInsn(ARETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }

    /**
     * Create the event class.
     *
     * @param type The type
     * @param name The canonical of the generated class
     * @param parentType The parent type
     * @param plugins Event factory plugins to use for this class creation
     * @return The class' contents, to be loaded via a {@link ClassLoader}
     */
    public byte[] createClass(final Class<?> type, final String name, final Class<?> parentType, List<? extends EventFactoryPlugin> plugins) {
        checkNotNull(type, "type");
        checkNotNull(name, "name");
        checkNotNull(parentType, "parentType");

        final List<? extends Property<Class<?>, Method>> properties = this.propertySearch.findProperties(new ReflectionClassWrapper(type));
        final String internalName = getInternalName(name);

        final ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER, internalName, null, Type.getInternalName(parentType), new String[] {Type.getInternalName(type)});

        MethodVisitor toStringMv = this.initializeToString(cw, type);

        this.generateWithPlugins(cw, type, parentType, internalName, properties, toStringMv, plugins);

        // Create the fields
        // this.contributeFields(cw, parentType, properties, plugins);

        // Create the constructor
        this.generateConstructor(cw, internalName, parentType, properties);

        // The return value of toString takes the form of
        // "ClassName{param1=value1, param2=value2, ...}"

        // Create the accessors and mutators, and fill out the toString method

        this.finalizeToString(toStringMv);

        cw.visitEnd();

        return cw.toByteArray();
    }

    private void generateWithPlugins(ClassWriter cw, Class<?> eventClass, Class<?> parentType, String internalName,
            List<? extends Property<Class<?>, Method>> properties, MethodVisitor toStringMv, List<? extends EventFactoryPlugin> plugins) {

        for (Property<Class<?>, Method> property : properties) {
            boolean processed = false;

            for (EventFactoryPlugin plugin : plugins) {
                processed = plugin.contributeProperty(eventClass, internalName, cw, property);
                if (processed) {
                    break;
                }
            }

            this.contributeToString(internalName, parentType, property, toStringMv);

            if (!processed) {
                this.contributeField(cw, parentType, property);
                this.generateAccessorsandMutator(cw, eventClass, parentType, internalName, property);
            }
        }
    }

    /**
     * Convert a java-style class name into a binary class name (replace dots
     * with slashes).
     *
     * @param name class name
     * @return class reference (binary name)
     */
    public static String getInternalName(String name) {
        return name.replace('.', '/');
    }
}
