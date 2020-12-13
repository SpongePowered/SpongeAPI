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

import java.util.Objects;
import java.util.function.Function;

/**
 * Represents a unique form of {@link Function} that attempts to merge
 * two separate {@link Value}s into a singular {@link Value}.
 * A merge function is similar to a {@link Function} such that it can be reused
 * for multiple purposes and should be "stateless" on its own.
 */
@FunctionalInterface
public interface MergeFunction {

    /**
     * Performs a merge of a type of {@link Value} such that a merge has been
     * performed and the resulting merged {@link Value} is returned. It is
     * suffice to say that only one of the {@link Value}s may be {@code null},
     * such that <pre> {@code
     * if (original == null) {
     *     return checkNotNull(replacement);
     * } else if (replacement == null) {
     *     return original;
     * } else {
     *     // do something merging the necessary values
     * }
     * }</pre>
     * It can be therefor discerned that both values are passed in as copies
     * and therefor either one can be modified and returned.
     *
     * @param original The original {@link Value} from the value store
     * @param replacement The replacing value container
     * @param <V> The type of {@link Value} being passed in
     * @param <E> The type of {@code value} for the {@link Value}
     * @return The "merged" {@link Value}
     */
    <V extends Value<E>, E> V merge(@Nullable V original, @Nullable V replacement);

    /**
     * Creates a new {@link MergeFunction} chaining this current merge function
     * with the provided merge function. The order of the merge is this
     * performs {@link #merge(Value, Value)} then, the
     * provided {@link MergeFunction} merges the returned merged
     * {@link ValueContainer} and the {@code replacement}. This can be used to
     * apply a custom merge strategy after a pre-defined {@link MergeFunction}
     * is applied.
     *
     * @param that The {@link MergeFunction} to chain
     * @return The new {@link MergeFunction}
     */
    default MergeFunction andThen(final MergeFunction that) {
        final MergeFunction self = this;
        return new MergeFunction() {
            @Override
            public <V extends Value<E>, E> V merge(@Nullable V original, @Nullable V replacement) {
                return that.merge(self.merge(original, replacement), replacement);
            }
        };
    }

    /**
     * Represents a {@link MergeFunction} that ignores all merges and uses the
     * replacement, or the original if the replacement is {@code null}.
     */
    MergeFunction REPLACEMENT_PREFERRED = new MergeFunction() {
        @Override
        public <V extends Value<E>, E> V merge(@Nullable V original, @Nullable V replacement) {
            return replacement == null ? Objects.requireNonNull(original, "Original and replacement cannot be null!") : replacement;
        }
    };

    /**
     * Represents a {@link MergeFunction} that will preferr the original's
     * value if it is not {@code null} over the replacement.
     */
    MergeFunction ORIGINAL_PREFERRED = new MergeFunction() {
        @Override
        public <V extends Value<E>, E> V merge(@Nullable V original, @Nullable V replacement) {
            return original == null ? Objects.requireNonNull(replacement, "Replacement and original cannot be null!") : original;
        }
    };

}
