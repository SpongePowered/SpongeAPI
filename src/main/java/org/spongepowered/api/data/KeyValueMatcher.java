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

import static java.util.Objects.requireNonNull;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.item.inventory.equipment.EquipmentTypes;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.Optional;

/**
 * Represents a matcher for {@link Key} values.
 *
 * <p>This matcher can only be serialized if the underlying
 * value {@link V} can also be serialized.</p>
 *
 * @param <V> The value type
 */
@SuppressWarnings("unchecked")
public interface KeyValueMatcher<V> extends DataSerializable {

    /**
     * Represents a operator to match the
     * values of a key query.
     */
    enum Operator {
        /**
         * Matches when the key and the matcher
         * values are equal.
         */
        EQUAL,
        /**
         * Matches when the key and the matcher
         * values are equal.
         */
        NOT_EQUAL,
        /**
         * Matches when the key value is greater
         * compared to the matcher value.
         */
        GREATER,
        /**
         * Matches when the key value is greater or
         * equal compared to the matcher value.
         */
        GREATER_OR_EQUAL,
        /**
         * Matches when the key value is less compared
         * to the matcher value.
         */
        LESS,
        /**
         * Matches when the key value is less or equal
         * compared to the matcher value.
         */
        LESS_OR_EQUAL,
        /**
         * Matches when the key value is included in the
         * matcher value. For example, the {@link EquipmentTypes#CHESTPLATE}
         * is included in the {@link EquipmentTypes#WORN} and
         * {@link EquipmentTypes#ANY} types.
         */
        INCLUDES,
        /**
         * Matches when the key is excluded from the
         * matcher value. This is the inverted operator of {@link #INCLUDES}.
         */
        EXCLUDES,
        ;
    }

    /**
     * Creates a {@link KeyValueMatcher} from the given key and value. The
     * default operator {@link Operator#EQUAL} will be used.
     *
     * @param key The key of which the value should be matched
     * @param value The matcher value that key values will be matched against
     * @param <V> The value type
     * @return The key value matcher
     */
    static <V> KeyValueMatcher<V> of(Key<? extends Value<V>> key, V value) {
        return of(key, value, Operator.EQUAL);
    }

    /**
     * Creates a {@link KeyValueMatcher} from the
     * given key, value and operator.
     *
     * @param key The key of which the value should be matched
     * @param value The matcher value that key values will be matched against
     * @param operator The operator how the value should be matched
     * @param <V> The value type
     * @return The key value matcher
     */
    static <V> KeyValueMatcher<V> of(Key<? extends Value<V>> key, V value, Operator operator) {
        return builder().key(key).value(value).operator(operator).build();
    }

    /**
     * Constructs a new {@link Builder} to create {@link KeyValueMatcher}s.
     *
     * @return The builder
     */
    static Builder<?> builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link Key} that is being used to
     * match key and matcher values.
     *
     * @return The key
     */
    Key<? extends Value<V>> getKey();

    /**
     * Gets the operator of the matcher.
     *
     * @return The operator
     */
    Operator getOperator();

    /**
     * Gets the value of the query. A empty optional represents
     * the property not being present.
     *
     * @return The value
     */
    Optional<V> getValue();

    /**
     * Checks whether the value of the {@link ValueContainer} is matched by this matcher.
     *
     * @param valueContainer The value container to get the key value from
     * @return Whether this matcher matches the key value
     */
    default boolean matcherContainer(ValueContainer valueContainer) {
        requireNonNull(valueContainer, "valueContainer");
        return this.matches(valueContainer.get(this.getKey()).orElse(null));
    }

    /**
     * Checks whether the given value is matched by this matcher.
     *
     * @param value The key value, a null value represents that the key doesn't exist
     * @return Whether this matcher matches the key value
     */
    boolean matches(@Nullable V value);

    /**
     * A builder to create {@link KeyValueMatcher}s.
     *
     * @param <V> The value type
     */
    interface Builder<V> extends CopyableBuilder<KeyValueMatcher<V>, Builder<V>>, DataBuilder<KeyValueMatcher<V>> {

        /**
         * Sets the {@link Key}.
         *
         * @param key The key
         * @param <NV> The key value type
         * @return This builder, for chaining
         */
        <NV> Builder<NV> key(Key<? extends Value<NV>> key);

        /**
         * Sets the {@link Operator}.
         *
         * @param operator The operator
         * @return This builder, for chaining
         */
        Builder<V> operator(Operator operator);

        /**
         * Sets the value.
         *
         * @param value The value
         * @return This builder, for chaining
         */
        Builder<V> value(@Nullable V value);

        /**
         * Sets the value.
         *
         * @param value The value
         * @return This builder, for chaining
         */
        Builder<V> value(@Nullable Value<? extends V> value);

        /**
         * Builds the {@link KeyValueMatcher}.
         *
         * @return The key value matcher
         */
        KeyValueMatcher<V> build();
    }
}
