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
package org.spongepowered.api.data.merge;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.mutable.CompositeValueStore;

import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * Represents a unique form of {@link Function} that attempts to merge
 * two separate {@link ValueContainer}s into a singular {@link ValueContainer}.
 * A merge function is similar to a {@link Function} such that it can be reused
 * for multiple purposes and should be "stateless" on its own.
 */
@FunctionalInterface
public interface MergeFunction {

    /**
     * Performs a merge of a type of {@link ValueContainer} such that a merge
     * of the contained {@link BaseValue}s has been performed and the resulting
     * merged {@link ValueContainer} is returned. It is suffice to say that
     * only one of the {@link ValueContainer} containers may be {@code null},
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
     * <p>Since
     * {@link CompositeValueStore#copyFrom(CompositeValueStore, MergeFunction)}
     * accepts only a single {@link MergeFunction}, and a
     * {@link CompositeValueStore} may have multiple {@link ValueContainer}s,
     * as provided by {@link CompositeValueStore#getContainers()}, the merge
     * function may be called for every single number of {@link ValueContainer}.
     * This way, a {@link MergeFunction} can be fully customized to merge
     * specific {@link ValueContainer}s of matching types.</p>
     *
     * @param original The original {@link ValueContainer} from the value store
     * @param replacement The replacing value container
     * @param <C> The type of {@link ValueContainer}
     * @return The "merged" {@link ValueContainer}
     */
    <C extends ValueContainer<?>> C merge(@Nullable C original, @Nullable C replacement);

    /**
     * Creates a new {@link MergeFunction} chaining this current merge function
     * with the provided merge function. The order of the merge is this
     * performs {@link #merge(ValueContainer, ValueContainer)} then, the
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
            public <C extends ValueContainer<?>> C merge(C original, C replacement) {
                return that.merge(self.merge(original, replacement), replacement);
            }
        };
    }

    /**
     * Represents a {@link MergeFunction} that ignores all merges and uses the
     * replacement, or the original if the replacement is {@code null}.
     */
    MergeFunction IGNORE_ALL = new MergeFunction() {
        @Override
        public <C extends ValueContainer<?>> C merge(@Nullable C original, @Nullable C replacement) {
            return replacement == null ? checkNotNull(original, "Original and replacement cannot be null!") : replacement;
        }
    };

    /**
     * Represents a {@link MergeFunction} that forces no merges and uses the
     * original, or proposed replacement if the original is {@code null}.
     */
    MergeFunction FORCE_NOTHING = new MergeFunction() {
        @Override
        public <C extends ValueContainer<?>> C merge(@Nullable C original, @Nullable C replacement) {
            return original == null ? checkNotNull(replacement, "Replacement and original cannot be null!") : original;
        }
    };

}
