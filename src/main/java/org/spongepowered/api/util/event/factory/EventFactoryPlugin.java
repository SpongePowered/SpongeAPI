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
package org.spongepowered.api.util.event.factory;

/**
 ** Represents a class which modifies the behavior of an event generator.
 */
public interface EventFactoryPlugin {

    /**
     * Gets the superclass to use for class generated for the specified
     * event interface.
     *
     * <p>All of the registered plugins have this method called in a chain, which each plugin receiving
     * the return value of the previous plugin as the {@param superClass} parameter.
     * The first plugin in the chain is passed <code>null</code> as its {@param superClass}.
     *
     * If a plugin is able to determine a superclass for an event interface, it should return it.
     * Otherwise, it should return the value it received as {@param superClass}.
     *
     * @param eventClass The interface to determine the superclass for
     * @param superClass The current superclass of the event interface
     * @param classLoader The classloader used to load the generated event class
     * @return The class to use as the event interface's superclass
     */
    Class<?> resolveSuperClassFor(Class<?> eventClass, Class<?> superClass, ClassGeneratorProvider.LocalClassLoader classLoader);

}
