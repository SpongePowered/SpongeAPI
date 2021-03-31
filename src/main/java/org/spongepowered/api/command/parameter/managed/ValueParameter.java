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
package org.spongepowered.api.command.parameter.managed;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.registry.DefaultedRegistryValue;

/**
 * Combines the {@link ValueParser}, {@link ValueCompleter} and
 * {@link ValueUsage} into one object.
 *
 * @param <T> The type of object that is returned from the
 *            {@link ValueParser} upon successful parsing.
 *
 * @see org.spongepowered.api.command.parameter.managed.ValueCompleter
 * @see org.spongepowered.api.command.parameter.managed.ValueParser
 * @see org.spongepowered.api.command.parameter.managed.ValueUsage
 */
public interface ValueParameter<T> extends DefaultedRegistryValue, ValueCompleter, ValueParser<T>, ValueUsage {

    @Override
    default String usage(@NonNull final String key) {
        return key;
    }

}
