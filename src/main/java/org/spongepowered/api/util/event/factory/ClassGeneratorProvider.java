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

/**
 * Creates event implementations by generating the necessary event class
 * and event factory at runtime.
 */
public class ClassGeneratorProvider implements FactoryProvider {

    private final LocalClassLoader classLoader = new LocalClassLoader(ClassGeneratorProvider.class.getClassLoader());
    private final ClassGenerator builder = new ClassGenerator();
    private final String targetPackage;

    /**
     * Create a new instance.
     *
     * @param targetPackage The target package to place generated event classes in
     */
    public ClassGeneratorProvider(String targetPackage) {
        checkNotNull(targetPackage, "targetPackage");
        this.targetPackage = targetPackage;
    }

    @Override
    public NullPolicy getNullPolicy() {
        return this.builder.getNullPolicy();
    }

    @Override
    public void setNullPolicy(NullPolicy nullPolicy) {
        this.builder.setNullPolicy(nullPolicy);
    }

    /**
     * Get the canonical name used for a generated event class.
     *
     * @param clazz The class
     * @param classifier The classifier
     * @return Canonical name
     */
    protected String getClassName(Class<?> clazz, String classifier) {
        return this.targetPackage + "." + clazz.getSimpleName() + "$" + classifier;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> EventFactory<T> create(final Class<T> type, Class<?> parentType) {
        String eventName = getClassName(type, "Impl");
        String factoryName = getClassName(type, "Factory");

        Class<?> eventClass = this.classLoader.defineClass(eventName, this.builder.createClass(type, eventName, parentType));
        Class<?> factoryClass = this.classLoader.defineClass(factoryName, this.builder.createFactory(eventClass, factoryName));

        try {
            return (EventFactory<T>) factoryClass.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException("Failed to create event factory", e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to create event factory", e);
        }
    }

    /**
     * Class loader to use to call {@link #defineClass(String, byte[])}.
     */
    private static class LocalClassLoader extends ClassLoader {

        public LocalClassLoader(ClassLoader parent) {
            super(parent);
        }

        public Class<?> defineClass(String name, byte[] b) {
            return defineClass(name, b, 0, b.length);
        }
    }

}
