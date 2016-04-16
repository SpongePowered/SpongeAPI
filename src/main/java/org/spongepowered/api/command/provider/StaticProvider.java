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
package org.spongepowered.api.command.provider;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandArgs;

import java.lang.annotation.Annotation;
import java.util.Collection;

/**
 * A provider which provides a static instance.
 *
 * @param <T> The type of object this provider provides
 */
public final class StaticProvider<T> implements Provider<T> {

    private final T instance;

    /**
     * Constructs a new static provider.
     *
     * @param instance The instance to provide
     */
    public StaticProvider(T instance) {
        this.instance = checkNotNull(instance, "instance");
    }

    @Override
    public T get(CommandSource source, CommandArgs args, Collection<? extends Annotation> modifiers) {
        return this.instance;
    }

}
