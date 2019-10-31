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
package org.spongepowered.api.data;

import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.util.CopyableBuilder;

public interface DataHolderBuilder<H extends DataHolder, B extends DataHolderBuilder<H, B>> extends CopyableBuilder<H, B> {

    /**
     * Adds the given {@link Value} to the builder. The
     * {@link Value} is copied when the {@link DataHolder}
     * is created.
     *
     * @param value The value to add
     * @return This builder, for chaining
     */
    @SuppressWarnings("unchecked")
    default B add(Value<?> value) {
        return (B) this.add((Key) value.getKey(), value.get());
    }

    /**
     * Adds all the {@link Value}s to the builder. The
     * {@link Value}s are copied when the {@link DataHolder}
     * is created.
     *
     * @param values The values to add
     * @return This builder, for chaining
     */
    @SuppressWarnings("unchecked")
    default B add(Iterable<? extends Value<?>> values) {
        values.forEach(this::add);
        return (B) this;
    }

    /**
     * Adds all the {@link Value}s from the {@link DataManipulator}
     * to the builder. The {@link Value}s are copied when the
     * {@link DataHolder} is created.
     *
     * @param manipulator The manipulator to add
     * @return This builder, for chaining
     */
    default B add(DataManipulator manipulator) {
        return this.add(manipulator.getValues());
    }

    /**
     * Adds all the {@link Value}s from the {@link DataHolder}
     * to the builder. The {@link Value}s are copied when the
     * {@link DataHolder} is created.
     *
     * @param dataHolder The data holder to add data from
     * @return This builder, for chaining
     */
    default B addFrom(DataHolder dataHolder) {
        return this.add(dataHolder.getValues());
    }

    /**
     * Adds the given {@link Key} with the given value.
     *
     * @param key The key to assign the value with
     * @param value The value to assign with the key
     * @param <V> The type of the value
     * @return This builder, for chaining
     */
    <V> B add(Key<? extends Value<V>> key, V value);

    /**
     * Copies all known {@link DataManipulator}s from the given
     * {@link DataHolder} of type {@link H}. This is a
     * defensive copy as {@link DataManipulator} is mutable.
     *
     * @param holder The {@link DataHolder} to copy from
     * @return This builder for chaining
     */
    @Override
    B from(H holder);

    /**
     * Attempts to build a new {@link DataHolder} of type {@link H}.
     *
     * @return The new data holder
     */
    H build();

    @Override
    B reset();

    interface Mutable<H extends DataHolder.Mutable, B extends Mutable<H, B>> extends DataHolderBuilder<H, B> {

    }

    interface Immutable<H extends DataHolder.Immutable<H>, B extends Immutable<H, B>> extends DataHolderBuilder<H, B> {

    }
}
