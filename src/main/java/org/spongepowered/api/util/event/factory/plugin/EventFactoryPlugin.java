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

import org.objectweb.asm.ClassWriter;
import org.spongepowered.api.eventgencore.Property;

import java.lang.reflect.Method;

/**
 * Represents a class which modifies the behavior of an event generator.
 */
public interface EventFactoryPlugin {

    /**
     * Called to allow a plugin to override the generation of the field and method(s) for a {@link Property}.
     *
     * <p>If an event factory plugin does not have any special behavior for the provided {@link Property}, it
     * should return {@code false}, which passes on the property to other plugins for processing.</p>
     *
     * <p>Returning {@code true} stops the processing of the provided {@link Property}.</p>
     *
     * @param eventClass The {@link Class} of the event an implementation is being generated for
     * @param internalName The internal name of the event
     * @param classWriter The {@link ClassWriter} being used to generate the event class implementation
     * @param property The {@link Property} being processed
     *
     * @return whether the provided {@link Property} was processed.
     */
    boolean contributeProperty(Class<?> eventClass, String internalName, ClassWriter classWriter, Property<Class<?>, Method> property);

}
