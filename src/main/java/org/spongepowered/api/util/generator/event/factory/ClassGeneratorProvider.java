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

import org.spongepowered.api.util.generator.GeneratorUtils;
import org.spongepowered.api.util.generator.event.factory.plugin.EventFactoryPlugin;

import java.util.List;

/**
 * Creates event implementations by generating the necessary event class
 * and event factory at runtime.
 */
public class ClassGeneratorProvider implements FactoryProvider {

    private final GeneratorUtils.LocalClassLoader classLoader = new GeneratorUtils.LocalClassLoader(ClassGeneratorProvider.class.getClassLoader());
    private final ClassGenerator builder = new ClassGenerator();
    private final String targetPackage;

    /**
     * Create a new instance.
     *
     * @param targetPackage The target package to place generated event
     *     classes in
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
        String name = clazz.getSimpleName();
        while (clazz.getEnclosingClass() != null) {
            clazz = clazz.getEnclosingClass();
            name = clazz.getSimpleName() + "$" + name;
        }
        return this.targetPackage + "." + name + "$" + classifier;
    }

    public Class<?> createEventImpl(final Class<?> type, Class<?> parentType, List<? extends EventFactoryPlugin> plugins) {
        String eventName = getClassName(type, "Impl");
        return this.classLoader.defineClass(eventName, this.builder.createClass(type, eventName, parentType, plugins));
    }

    @Override
    public <T> T createFactoryInterfaceImpl(Class<T> clazz) {
        String name = getClassName(clazz, "Impl");
        Class<T> implClass = (Class<T>) this.classLoader.defineClass(name, FactoryInterfaceGenerator.createClass(clazz, name, this));

        try {
            return implClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to create event factory interface impl", e);
        }
    }
}
