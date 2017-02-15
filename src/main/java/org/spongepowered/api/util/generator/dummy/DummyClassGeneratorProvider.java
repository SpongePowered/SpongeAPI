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

import org.spongepowered.api.util.generator.GeneratorUtils;

public class DummyClassGeneratorProvider {

    private final GeneratorUtils.LocalClassLoader classLoader = new GeneratorUtils.LocalClassLoader(DummyClassGenerator.class.getClassLoader());
    private final DummyClassGenerator generator = new DummyClassGenerator();
    private final String targetPackage;

    /**
     * Creates a new dummy class provider.
     *
     * @param targetPackage The target package
     */
    public DummyClassGeneratorProvider(String targetPackage) {
        this.targetPackage = targetPackage;
    }

    /**
     * Creates a new class extended based on the provided {@code type} with the
     * provided {@code exceptionType} to throw for all methods provided by the
     * target class.
     *
     * @param type The type of class to generate
     * @param exceptionType The exception to throw
     * @param <T> The type of class
     * @return The generated class
     */
    @SuppressWarnings("unchecked")
    public <T> Class<T> create(final Class<T> type, Class<? extends Throwable> exceptionType) {
        String name = GeneratorUtils.getClassName(this.targetPackage, type, "DummyClass");

        return (Class<T>) this.classLoader.defineClass(name, this.generator.createClass(type, name, exceptionType));
    }
}
