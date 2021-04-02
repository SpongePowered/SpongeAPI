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
package org.spongepowered.api.metrics.meter;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.util.Builder;

public abstract class MeterBuilder<T, B extends MeterBuilder<T, B>> implements Builder<T, B> {

    private String[] name;
    private String help;
    private String[] labelNames;

    @SuppressWarnings("unchecked")
    public B name(String... name) {
        this.name = name;
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B help(String help) {
        this.help = help;
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B labelNames(String... names) {
        this.labelNames = names;
        return (B) this;
    }

    protected abstract @NonNull T build(Metadata metadata);

    @Override
    public final @NonNull T build() {
        if (this.name == null || name.length == 0) {
            throw new IllegalStateException("name is required!");
        }
        if (this.help == null) {
            throw new IllegalStateException("help is required!");
        }
        if (this.labelNames == null) {
            throw new IllegalStateException("labels are required!");
        }

        return build(new Metadata(name, help, labelNames));
    }
}
