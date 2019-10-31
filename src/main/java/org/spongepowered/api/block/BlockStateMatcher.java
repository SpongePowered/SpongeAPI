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
package org.spongepowered.api.block;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.state.StateProperty;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.List;
import java.util.function.Predicate;

/**
 * A {@link BlockState} matcher that will match various block states
 * according to a pre-built list of {@link StateProperty}s and their
 * values, such that not all {@link StateProperty}s contained in a
 * {@link BlockState} must be matched. (Such as if a block state
 * that contains 4 traits, and only 2 are wanting to be matched,
 * then the other two traits may be variable).
 */
public interface BlockStateMatcher extends Predicate<BlockState> {

    /**
     * Constructs a new {@link Builder} to construct a {@link BlockStateMatcher}.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets a {@code true} return value if the provided {@link BlockState}
     * sufficiently matches this matcher, such that the {@link BlockType}
     * matches, and the pre-defined {@link StateProperty} values match.
     *
     * @param state The block state in question
     * @return True if the state sufficiently matches
     */
    boolean matches(BlockState state);

    @Override
    default boolean test(BlockState blockState) {
        return matches(blockState);
    }

    /**
     * Gets a {@link List} of compatible {@link BlockState}s.
     * Since all {@link BlockState}s are known in the initialization
     * of a {@link BlockType}, the states are already deterministic
     * and cannot change themselves.
     *
     * @return The list of compatible block states
     */
    List<BlockState> getCompatibleStates();

    /**
     * A builder for building {@link BlockStateMatcher}s.
     */
    interface Builder extends CopyableBuilder<BlockStateMatcher, Builder> {

        /**
         * Sets the root {@link BlockType} for the {@link BlockStateMatcher}.
         * <p>Note that the {@link BlockType type} <b>must be set prior</b>
         * to setting various {@link StateProperty traits} and their values.</p>
         *
         * @param type The block type to use
         * @return This builder, for chaining
         */
        Builder type(BlockType type);

        /**
         * Adds the desired {@link StateProperty} and {code value} to this
         * builder, if the desired {@link StateProperty} does not belong to the
         * original {@link BlockType} as provided by {@link #type(BlockType)},
         * an exception is thrown. Likewise, if a {@code value} is not within
         * the possible values for the desired trait of the desired type, an
         * exception is thrown.
         *
         * @param trait The desired block trait
         * @param value the desired value
         * @param <T> The type of comparable
         * @return This builder
         * @throws IllegalArgumentException If the block trait does not match
         *     the block type, or if the value does not belong to the trait
         *     with the desired block type
         */
        <T extends Comparable<T>> Builder trait(StateProperty<T> trait, T value) throws IllegalArgumentException;

        /**
         * Creates a new {@link BlockStateMatcher}.
         *
         * @return The new state matcher
         * @throws IllegalStateException If there is no block type
         */
        BlockStateMatcher build() throws IllegalStateException;

    }
}
