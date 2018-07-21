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
package org.spongepowered.api.data.property;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.equipment.EquipmentTypes;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents a matcher for {@link Property}s.
 *
 * @param <V> The value type
 */
@SuppressWarnings("unchecked")
public interface PropertyMatcher<V> {

    /**
     * Represents a operator to match the
     * values of a property query.
     */
    enum Operator {
        /**
         * Matches when the property and the query values are equal.
         */
        EQUAL,
        /**
         * Matches when the property and the query values are equal.
         */
        NOT_EQUAL,
        /**
         * Matches when the query value compared to the
         * property values is greater then 0.
         */
        GREATER,
        /**
         * Matches when the query value compared to the
         * property values is greater then or equal to 0.
         */
        GREATER_OR_EQUAL,
        /**
         * Matches when the query value compared to the
         * property values is lesser then 0.
         */
        LESS,
        /**
         * Matches when the query value compared to the
         * property values is lesser then or equal to 0.
         */
        LESS_OR_EQUAL,
        /**
         * Matches when the property is included in the
         * query value. For example, the {@link EquipmentTypes#CHESTPLATE}
         * is included in the {@link EquipmentTypes#WORN} and
         * {@link EquipmentTypes#ANY} types.
         */
        INCLUDES,
        /**
         * Matches when the property is excluded from the
         * query value. This is the inverted operator of {@link #INCLUDES}.
         */
        EXCLUDES,
        ;
    }

    /**
     * Creates a {@link PropertyMatcher} from the given property and value. The
     * default operator {@link Operator#EQUAL} will be used.
     *
     * @param property The property of which the value should be matched
     * @param value The query value that the property value will be matched against
     * @param <V> The value type
     * @return The property query
     */
    static <V> PropertyMatcher<V> of(Property<V> property, V value) {
        return of(property, value, Operator.EQUAL);
    }

    /**
     * Creates a {@link PropertyMatcher} from the
     * given property, value and operator.
     *
     * @param property The property of which the value should be matched
     * @param value The query value that the property value will be matched against
     * @param operator The operator how the value should be matched
     * @param <V> The value type
     * @return The property query
     */
    static <V> PropertyMatcher<V> of(Property<V> property, V value, Operator operator) {
        return builder().property(property).value(value).operator(operator).build();
    }

    /**
     * Constructs a new {@link Builder} to create {@link PropertyMatcher}s.
     *
     * @return The builder
     */
    static Builder<?> builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link Property} that is being queried for.
     *
     * @return The property
     */
    Property<V> getProperty();

    /**
     * Gets the operator of the query.
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
     * Matches this query against the given property value.
     *
     * @param value The property value, a null value represents that the property doesn't exist
     * @return Whether this query matches the property value
     */
    boolean matches(@Nullable V value);

    /**
     * A builder to create {@link PropertyMatcher}s.
     *
     * @param <V> The value type
     */
    interface Builder<V> extends ResettableBuilder<PropertyMatcher<V>, Builder<V>> {

        /**
         * Sets the {@link Property}.
         *
         * @param property The property
         * @param <NV> The property value type
         * @return This builder, for chaining
         */
        <NV> Builder<NV> property(Property<NV> property);

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
         * Builds the {@link PropertyMatcher}.
         *
         * @return The property query
         */
        PropertyMatcher<V> build();
    }
}
