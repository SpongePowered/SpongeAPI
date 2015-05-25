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

import org.spongepowered.api.event.Event;
import org.spongepowered.api.util.annotation.ImplementedBy;
import org.spongepowered.api.util.event.factory.ClassGeneratorProvider;
import org.spongepowered.api.util.event.factory.EventFactoryPlugin;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * An {@link EventFactoryPlugin} which examines the annotations on an {@link Event}
 * to determine its superclass.
 *
 * This is the base {@link EventFactoryPlugin}. If no other event factory plugins are able
 * to handle the specified event, then the annotation on the event interface is used
 * by this plugin to determine the superclass.
 */
public class AnnotationEventFactoryPlugin implements EventFactoryPlugin {

    @Override
    public Class<?> resolveSuperClassFor(Class<?> eventClass, Class<?> superClass, ClassGeneratorProvider.LocalClassLoader classLoader) {
        if (superClass != null) {
            return superClass;
        }
        ImplementedBy implementedBy = null;
        final Queue<Class<?>> queue = new ArrayDeque<Class<?>>();

        queue.add(eventClass);
        Class<?> scannedType;

        while ((scannedType = queue.poll()) != null) {
            if ((implementedBy = scannedType.getAnnotation(ImplementedBy.class)) != null) {
                break;
            }
            for (Class<?> implInterfaces : scannedType.getInterfaces()) {
                queue.offer(implInterfaces);
            }
        }

        if (implementedBy != null) {
            return implementedBy.value();
        }
        throw new RuntimeException("Congratulations. You've attempted to create an event which doesn't have "
                                   + "an @ImplementedBy annotation, on itself of any of its superinterfaces. "
                                   + "If your event extends Event, then, well, something's mess up pretty badly. "
                                   + "If not: *WHY* aren't you extending Event????");

    }
}
