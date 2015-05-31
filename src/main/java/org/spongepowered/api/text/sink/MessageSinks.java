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
package org.spongepowered.api.text.sink;

import org.spongepowered.api.util.command.CommandSource;

import java.util.Set;

/**
 * Useful building blocks for message sinks.
 */
public class MessageSinks {
    private static final MessageSinkFactory factory = null;

    /**
     * A message sink that targets all subjects with the given permission.
     *
     * @param permission The permission to target
     * @return The sink
     */
    public static MessageSink toPermission(String permission) {
        return factory.toPermission(permission);
    }

    /**
     * A message sink that targets all subjects currently active.
     *
     * @return The sink
     */
    public static MessageSink toAll() {
        return factory.toAll();
    }

    /**
     * A message sink that targets all subjects contained within the given targets.
     *
     * @param sinks The sinks to combine
     * @return The sink
     */
    public static MessageSink combined(MessageSink... sinks) {
        return factory.combined(sinks);
    }

    /**
     * Get a message sink that targets the given sources.
     *
     * @param sources The sources to have as recipients
     * @return The sink
     */
    public static MessageSink to(Set<CommandSource> sources) {
        return factory.to(sources);
    }
}
