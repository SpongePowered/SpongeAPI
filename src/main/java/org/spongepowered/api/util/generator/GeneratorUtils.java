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
package org.spongepowered.api.util.generator;

import static org.objectweb.asm.Opcodes.CHECKCAST;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.INVOKEVIRTUAL;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

public final class GeneratorUtils {

    /**
     * Gets a class name with the provided classifier.
     *
     * @param targetPackage The target package
     * @param clazz The parent class
     * @param classifier The classifier
     * @return The java class name equivalent with the provided classifier
     */
    public static String getClassName(String targetPackage, Class<?> clazz, String classifier) {
        String name = clazz.getSimpleName();
        while (clazz.getEnclosingClass() != null) {
            clazz = clazz.getEnclosingClass();
            name = clazz.getSimpleName() + "$" + name;
        }
        return targetPackage + "." + name + "$" + classifier;
    }

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


    public static class LocalClassLoader extends ClassLoader {

        /**
         * Creates a new {@link LocalClassLoader}.
         *
         * @param parent The parent class loader
         */
        public LocalClassLoader(ClassLoader parent) {
            super(parent);
        }

        /**
         * Defines the class by name and bytecode arrray.
         *
         * @param name The name of the class
         * @param b The bytecode array
         * @return The class
         */
        public Class<?> defineClass(String name, byte[] b) {
            return defineClass(name, b, 0, b.length);
        }
    }

    private GeneratorUtils() {
    }

}
