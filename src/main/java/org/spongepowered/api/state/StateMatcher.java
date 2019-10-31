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
package org.spongepowered.api.state;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.KeyValueMatcher;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.function.Predicate;

/**
 * Can be used to match {@link State}s.
 */
public interface StateMatcher extends DataSerializable, Predicate<State<?>> {

    /**
     * Creates a new {@link Builder}.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets a {@code true} return value if the provided {@link State}
     * sufficiently matches the pre-defined {@link StateProperty} values
     * and {@link KeyValueMatcher}s.
     *
     * @param state The state in question
     * @return True if the state sufficiently matches
     */
    boolean matches(State<?> state);

    @Override
    default boolean test(State<?> state) {
        return this.matches(state);
    }

    /**
     * A builder for {@link StateMatcher}s.
     */
    interface Builder extends CopyableBuilder<StateMatcher, Builder> {

        /**
         * Adds a {@link StateProperty} that needs to be present
         * on a {@link State} to match.
         *
         * @param stateProperty The state property
         * @return This builder, for chaining
         */
        Builder supportsStateProperty(StateProperty<?> stateProperty);

        /**
         * Adds a {@link StateProperty} and value that needs to
         * match on a {@link State} to match.
         *
         * @param stateProperty The state property
         * @param value The value to match
         * @param <T> The value type
         * @return This builder, for chaining
         */
        <T extends Comparable<T>> Builder stateProperty(StateProperty<T> stateProperty, T value);

        /**
         * Adds a {@link KeyValueMatcher} that the {@link State}
         * needs to match with.
         *
         * @param matcher The matcher
         * @return This builder, for chaining
         */
        Builder matcher(KeyValueMatcher<?> matcher);

        /**
         * Builds a {@link StateMatcher}.
         *
         * @return The built state matcher
         */
        StateMatcher build();
    }
}
