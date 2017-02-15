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
