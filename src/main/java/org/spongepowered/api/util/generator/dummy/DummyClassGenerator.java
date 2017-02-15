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
package org.spongepowered.api.util.generator.dummy;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static org.objectweb.asm.Opcodes.AASTORE;
import static org.objectweb.asm.Opcodes.ACC_PUBLIC;
import static org.objectweb.asm.Opcodes.ACC_SUPER;
import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ANEWARRAY;
import static org.objectweb.asm.Opcodes.ATHROW;
import static org.objectweb.asm.Opcodes.DUP;
import static org.objectweb.asm.Opcodes.GETFIELD;
import static org.objectweb.asm.Opcodes.INVOKESPECIAL;
import static org.objectweb.asm.Opcodes.INVOKESTATIC;
import static org.objectweb.asm.Opcodes.NEW;
import static org.objectweb.asm.Opcodes.PUTFIELD;
import static org.objectweb.asm.Opcodes.RETURN;
import static org.objectweb.asm.Opcodes.V1_8;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class DummyClassGenerator {

    private static final String FIELD_NAME = "fieldName";

    /**
     * Creates a new class prepared to be loaded into the {@link ClassLoader}.
     *
     * @param type The type of class to implement
     * @param name The name of the class
     * @param exceptionType The exception type to throw for all methods
     * @return The generated class
     */
    public byte[] createClass(final Class<?> type, final String name, final Class<?> exceptionType) {

        checkNotNull(type, "type");
        checkNotNull(name, "name");
        checkNotNull(exceptionType, "exception");

        checkState(type.isInterface(), String.format("Class %s is not an interface!", type));
        checkState(Throwable.class.isAssignableFrom(exceptionType), String.format("Class %s does not extend Throwable!", exceptionType));

        String internalName = name.replace('.', '/');
        List<Method> methods = this.getInterfaceMethods(type);

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        cw.visit(V1_8, ACC_PUBLIC + ACC_SUPER, internalName, null, Type.getInternalName(Object.class), new String[] {Type.getInternalName(type)});

        this.generateConstructor(cw, internalName);
        this.generateMethods(cw, internalName, methods, exceptionType);

        cw.visitEnd();

        return cw.toByteArray();
    }

    private void generateConstructor(ClassWriter cw, String internalName) {

        cw.visitField(Modifier.PRIVATE, FIELD_NAME, Type.getDescriptor(String.class), null, null);

        MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, "<init>", "(Ljava/lang/String;)V", null, null);

        // Load 'this'
        mv.visitVarInsn(ALOAD, 0);
        // Cal super()
        mv.visitMethodInsn(INVOKESPECIAL, Type.getInternalName(Object.class), "<init>", "()V", false);

        // Load 'this'
        mv.visitVarInsn(ALOAD, 0);
        // Load first method parameter (the fieldName)
        mv.visitVarInsn(ALOAD, 1);
        // Store first parameter in field FIELD_NAME
        mv.visitFieldInsn(PUTFIELD, internalName, FIELD_NAME, Type.getDescriptor(String.class));

        mv.visitInsn(RETURN);

        mv.visitMaxs(0, 0);
        mv.visitEnd();
    }

    private void generateMethods(ClassWriter cw, String internalName, List<Method> methods, Class<?> exceptionType) {
        for (Method method: methods) {
            MethodVisitor mv = cw.visitMethod(ACC_PUBLIC, method.getName(), Type.getMethodDescriptor(method), null, null);
            mv.visitCode();

            String internalException = Type.getInternalName(exceptionType);

            mv.visitTypeInsn(NEW, internalException);
            mv.visitInsn(DUP);

            // Load first argument to String.format
            mv.visitLdcInsn("A method was invoked on a dummy class, due to the static field %s not being initialized "
                    + "(most likely in a CatalogType-related class).\n"
                    + "Method: " + method);

            // Create new array
            mv.visitLdcInsn(1);
            mv.visitTypeInsn(ANEWARRAY, "java/lang/String");

            // Store in local var 2
            mv.visitVarInsn(Opcodes.ASTORE, 2);

            // AASTORE part 1 - array reference
            mv.visitVarInsn(Opcodes.ALOAD, 2);

            // AASTORE part 2 - array index
            mv.visitLdcInsn(0);

            // AASTORE part 3 = the actual value
            // Load formatter argument (the field FIELD_NAME)
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, internalName, FIELD_NAME, Type.getDescriptor(String.class));

            // Store in array
            mv.visitInsn(AASTORE);

            // Load array reference
            mv.visitVarInsn(ALOAD, 2);

            // Call String.format
            mv.visitMethodInsn(INVOKESTATIC, Type.getInternalName(String.class), "format",
                "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", false);

            // Invoke throwable constructor
            mv.visitMethodInsn(INVOKESPECIAL, internalException, "<init>", "(Ljava/lang/String;)V", false);
            mv.visitInsn(ATHROW);
            mv.visitMaxs(0, 0);
            mv.visitEnd();
        }
    }

    private List<Method> getInterfaceMethods(Class<?> clazz) {
        List<Method> methods = new ArrayList<>();

        Method[] allMethods = clazz.getMethods();
        for (Method method : allMethods) {
            if (!Modifier.isStatic(method.getModifiers())) {
                methods.add(method);
            }
        }
        return methods;
    }

}
