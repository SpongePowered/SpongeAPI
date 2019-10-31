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
package org.spongepowered.api.data.value;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.data.Key;

import java.util.Optional;
import java.util.function.Function;

public interface OptionalValue<E> extends Value<Optional<E>> {

    boolean isPresent();

    @Override
    Key<? extends OptionalValue<E>> getKey();

    /**
     * Constructs a mutable {@link OptionalValue} for the
     * given {@link Key} and element. The returned {@link Value}
     * is guaranteed {@link Mutable}, this means that calling
     * {@link #asMutable()} will return itself.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed value
     */
    static <E> OptionalValue.Mutable<E> mutableOf(Key<? extends OptionalValue<E>> key, Optional<E> element) {
        return Value.mutableOf(key, element);
    }

    /**
     * Constructs an immutable {@link OptionalValue} for the
     * given {@link Key} and element. The returned {@link Value}
     * is guaranteed {@link Immutable}, this means that calling
     * {@link #asImmutable()} will return itself.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed value
     */
    static <E> OptionalValue.Immutable<E> immutableOf(Key<? extends OptionalValue<E>> key, Optional<E> element) {
        return Value.immutableOf(key, element);
    }

    /**
     * Constructs a mutable {@link OptionalValue} for the
     * given {@link Key} and element. The returned {@link Value}
     * is guaranteed {@link Mutable}, this means that calling
     * {@link #asMutable()} will return itself.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed value
     */
    static <E> OptionalValue.Mutable<E> mutableOf(Key<? extends OptionalValue<E>> key, @Nullable E element) {
        return mutableOf(key, Optional.ofNullable(element));
    }

    /**
     * Constructs an immutable {@link OptionalValue} for the
     * given {@link Key} and element. The returned {@link Value}
     * is guaranteed {@link Immutable}, this means that calling
     * {@link #asImmutable()} will return itself.
     *
     * @param key The key
     * @param element The element
     * @param <E> The element type
     * @return The constructed value
     */
    static <E> OptionalValue.Immutable<E> immutableOf(Key<? extends OptionalValue<E>> key, @Nullable E element) {
        return immutableOf(key, Optional.ofNullable(element));
    }

    /**
     * Provides the value such that if the underlying value is
     * {@code null}, the default value is returned as a {@link Value}, if
     * the underlying value is present, the underlying value is returned
     * as a {@link Value}.
     *
     * @param defaultValue The value to substitute, if the underlying value is null
     * @return A new {@link org.spongepowered.api.data.value.Value.Mutable} with a non-null value
     */
    Value<E> orElse(E defaultValue);

    @Override
    OptionalValue.Mutable<E> asMutable();

    @Override
    OptionalValue.Mutable<E> asMutableCopy();

    @Override
    OptionalValue.Immutable<E> asImmutable();

    /**
     * Represents a {@link org.spongepowered.api.data.value.Value.Mutable} that can be {@link Optional} such that the
     * underlying value may be present or {@code null}.
     *
     * @param <E> The type of element
     */
    interface Mutable<E> extends OptionalValue<E>, Value.Mutable<Optional<E>> {

        /**
         * Sets the underlying value, may be null.
         *
         * @param value The value to set
         * @return This value, for chaining
         */
        default OptionalValue.Mutable<E> setElement(@Nullable E value) {
            return this.set(Optional.ofNullable(value));
        }

        @Override
        Value.Mutable<E> orElse(E defaultValue);

        @Override
        OptionalValue.Mutable<E> set(Optional<E> value);

        @Override
        OptionalValue.Mutable<E> transform(Function<Optional<E>, Optional<E>> function);

        @Override
        OptionalValue.Mutable<E> copy();

        @Override
        default OptionalValue.Mutable<E> asMutable() {
            return this;
        }

        @Override
        default OptionalValue.Mutable<E> asMutableCopy() {
            return this.copy();
        }

        @Override
        OptionalValue.Immutable<E> asImmutable();
    }

    /**
     * Represents a {@link org.spongepowered.api.data.value.Value.Immutable} that can be {@link Optional} such that
     * the underlying value may be present or {@code null}.
     *
     * @param <E> The type of element
     */
    interface Immutable<E> extends OptionalValue<E>, Value.Immutable<Optional<E>> {

        /**
         * Creates a new {@link org.spongepowered.api.data.value.OptionalValue.Immutable} with the provided element,may be null.
         *
         * @param value The value
         * @return The new value, for chaining
         */
        default OptionalValue.Immutable<E> withElement(@Nullable E value) {
            return this.with(Optional.ofNullable(value));
        }

        @Override
        Value.Immutable<E> orElse(E defaultValue);

        @Override
        OptionalValue.Immutable<E> with(Optional<E> value);

        @Override
        OptionalValue.Immutable<E> transform(Function<Optional<E>, Optional<E>> function);

        @Override
        OptionalValue.Mutable<E> asMutable();

        @Override
        default OptionalValue.Mutable<E> asMutableCopy() {
            return this.asMutable();
        }

        @Override
        default OptionalValue.Immutable<E> asImmutable() {
            return this;
        }
    }
}
