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

import org.checkerframework.checker.nullness.qual.NonNull;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.data.KeyValueMatcher;
import org.spongepowered.api.fluid.FluidState;
import org.spongepowered.api.fluid.FluidType;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * A {@link StateMatcher} that will match various {@link State}s
 * according to a pre-built list of {@link StateProperty}s and their
 * values, such that not all {@link StateProperty}s contained in a
 * {@link State} must be matched.
 */
public interface StateMatcher<S extends State<S>> extends Predicate<S> {

    /**
     * Creates a new {@link Builder} for matching {@link BlockState}s.
     *
     * @return The builder
     */
    static Builder<BlockState, BlockType> blockStateMatcherBuilder() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(StateMatcher.Factory.class).blockStateMatcherBuilder();
    }

    /**
     * Creates a new {@link Builder} for matching {@link FluidState}s.
     *
     * @return The builder
     */
    static Builder<FluidState, FluidType> fluidStateMatcherBuilder() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(StateMatcher.Factory.class).fluidStateMatcherBuilder();
    }

    /**
     * Gets a {@code true} return value if the provided {@link State}
     * sufficiently matches the pre-defined {@link StateProperty} values
     * and {@link KeyValueMatcher}s.
     *
     * @param state The state in question
     * @return True if the state sufficiently matches
     */
    boolean matches(S state);

    /**
     * Gets a {@link List} of compatible {@link State}s.
     *
     * @return The list of compatible states
     */
    List<S> getCompatibleStates();

    @Override
    default boolean test(final S state) {
        return this.matches(state);
    }

    /**
     * Factories for generating builders.
     */
    interface Factory {

        /**
         * Gets a {@link Builder} for {@link BlockState} matching.
         *
         * @return The builder
         */
        Builder<BlockState, BlockType> blockStateMatcherBuilder();

        /**
         * Gets a {@link Builder} for {@link FluidState} matching.
         *
         * @return The builder
         */
        Builder<FluidState, FluidType> fluidStateMatcherBuilder();

    }

    /**
     * A builder for {@link StateMatcher}s.
     */
    interface Builder<S extends State<S>, T extends StateContainer<S>> extends CopyableBuilder<StateMatcher<S>, Builder<S, T>> {

        /**
         * Sets the root {@link StateContainer} for the {@link StateMatcher}.
         *
         * @param type The {@link StateContainer} to use
         * @return This builder, for chaining
         */
        default Builder<S, T> type(final Supplier<? extends T> type) {
            return this.type(type.get());
        }

        /**
         * Sets the root {@link StateContainer} for the {@link StateMatcher}.
         *
         * @param type The {@link StateContainer} to use
         * @return This builder, for chaining
         */
        Builder<S, T> type(T type);

        /**
         * Adds a {@link StateProperty} that needs to be present
         * on a {@link State} to match.
         *
         * <p>{@link #type(StateContainer)} or {@link #type(Supplier)}
         * <strong>must</strong> be called before this is called as supported
         * {@link StateProperty state properties} are specific to the type</p>
         *
         * @param stateProperty The state property
         * @return This builder, for chaining
         */
        Builder<S, T> supportsStateProperty(StateProperty<@NonNull ?> stateProperty);

        /**
         * Adds a {@link StateProperty} that needs to be present
         * on a {@link State} to match.
         *
         * <p>{@link #type(StateContainer)} or {@link #type(Supplier)}
         * <strong>must</strong> be called before this is called as supported
         * {@link StateProperty state properties} are specific to the type</p>
         *
         * @param stateProperty The state property
         * @return This builder, for chaining
         */
        default Builder<S, T> supportsStateProperty(final Supplier<? extends StateProperty<@NonNull ?>> stateProperty) {
            return this.supportsStateProperty(stateProperty.get());
        }

        /**
         * Adds a {@link StateProperty} and value that needs to
         * match on a {@link State} to match.
         *
         * <p>{@link #type(StateContainer)} or {@link #type(Supplier)}
         * <strong>must</strong> be called before this is called as supported
         * {@link StateProperty state properties} are specific to the type</p>
         *
         * @param stateProperty The state property
         * @param value The value to match
         * @param <V> The value type
         * @return This builder, for chaining
         */
        <V extends Comparable<V>> Builder<S, T> stateProperty(StateProperty<V> stateProperty, V value);

        /**
         * Adds a {@link StateProperty} and value that needs to
         * match on a {@link State} to match.
         *
         * @param stateProperty The state property
         * @param value The value to match
         * @param <V> The value type
         * @return This builder, for chaining
         */
        default <V extends Comparable<V>> Builder<S, T> stateProperty(final Supplier<? extends StateProperty<V>> stateProperty, final V value) {
            return this.stateProperty(stateProperty.get(), value);
        }

        /**
         * Adds a {@link KeyValueMatcher} that the {@link State}
         * needs to match with.
         *
         * @param matcher The matcher
         * @return This builder, for chaining
         */
        Builder<S, T> matcher(KeyValueMatcher<?> matcher);

        /**
         * Builds a {@link StateMatcher}.
         *
         * @return The built state matcher
         */
        StateMatcher<S> build();

    }

}
