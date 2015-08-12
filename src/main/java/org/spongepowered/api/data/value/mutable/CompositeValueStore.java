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
package org.spongepowered.api.data.value.mutable;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.data.value.immutable.ImmutableValue;

import java.util.Collection;

/**
 * Represents a {@link ValueContainer} that contains a various bundle of
 * {@link ValueContainer}s of type declared by the extension that can be
 * manipulated separately from this {@link CompositeValueStore}.
 *
 * @param <S> The type of composite store, for self referencing
 * @param <H> The type of {@link ValueContainer} to restrict accessing of
 *     values to
 */
public interface CompositeValueStore<S extends CompositeValueStore<S, H>, H extends ValueContainer<?>> extends ValueContainer<S> {

    /**
     * Gets the desired {@link ValueContainer} of type <code>H</code> if the
     * {@link ValueContainer} is compatible. Since the return type is an
     * {@link Optional}, a short way of checking compatibility and presence
     * of the requested data is to mimic the following:
     * <pre>
     * {@code
     * // MyCompositeValueStore extends CompositeValueStore<MyCompositeValueStore, DataManipulator<?>>
     * MyCompositeValueStore valueStore;
     * final Optional<DisplayNameData> displayOptional = valueStore.get(DisplayNameData.class);
     * if (displayOptional.isPresent()) {
     *     // We know that we have a present DataManipulator and it's supported
     *     System.out.println(displayOptional.get().displayName().get().toString());
     * }
     * }
     * </pre>
     * This is the equivalent as performing the following:
     * <pre>
     * {@code
     * MyCompositeValueStore valueStore;
     * if (valueStore.supports(DisplayNameData.class)) {
     *     System.out.println(valueStore.getOrNull(DisplayNameData.class).displayName().get().toString());
     * }
     * }
     * </pre>
     *
     * <p>The advantage of this returning an {@link Optional} is that the
     * {@link ValueContainer} may be unsupported, the required data missing
     * and ignoring the possibility of {@code null}s, it is a guarantee that if
     * the {@link Optional#isPresent()} is {@code true}, the
     * {@link ValueContainer} not only is supported, but there is already pre-
     * existing data for the {@link ValueContainer}.</p>
     *
     * <p>If it is necessary to ignore the {@link Optional},
     * {@link Optional#orNull()} can be used to return a potentially
     * {@code null} {@link ValueContainer}.</p>
     *
     *
     * @param containerClass The container class
     * @param <T> The type of {@link ValueContainer}
     * @return The value container, if available
     */
    <T extends H> Optional<T> get(Class<T> containerClass);

    /**
     * Gets the desired {@link ValueContainer} of type <code>H</code> if the
     * {@link ValueContainer} is compatible. If insufficient data is available
     * to provide a {@link ValueContainer} with all {@link Value}s preset, a
     * new instance of the {@link ValueContainer} is returned with "default"
     * values. Since the return type is an {@link Optional}, a short way of
     * checking compatibility and presence of the requested data is to mimic
     * the following:
     * <pre>
     * {@code
     * // MyCompositeValueStore extends CompositeValueStore<MyCompositeValueStore, DataManipulator<?>>
     * MyCompositeValueStore valueStore;
     * final Optional<DisplayNameData> displayOptional = valueStore.getOrCreate(DisplayNameData.class);
     * if (displayOptional.isPresent()) {
     *     // We know that we have a present DataManipulator and it's supported
     *     System.out.println(displayOptional.get().displayName().get().toString());
     * }
     * }
     * </pre>
     * This is the equivalent as performing the following:
     * <pre>
     * {@code
     * MyCompositeValueStore valueStore;
     * if (valueStore.supports(DisplayNameData.class)) {
     *     System.out.println(valueStore.get(DisplayNameData.class).get().displayName().get().toString());
     * }
     * }
     * </pre>
     *
     * <p>The advantage of this returning an {@link Optional} is that the
     * {@link ValueContainer} may be unsupported, the required data missing
     * and ignoring the possibility of {@code null}s, it is a guarantee that if
     * the {@link Optional#isPresent()} is {@code true}, the
     * {@link ValueContainer} not only is supported, but there is already pre-
     * existing data for the {@link ValueContainer}.</p>
     *
     * <p>If it is necessary to ignore the {@link Optional},
     * {@link Optional#orNull()} can be used to return a potentially
     * {@code null} {@link ValueContainer}.</p>
     *
     *
     * @param containerClass The container class
     * @param <T> The type of {@link ValueContainer}
     * @return The value container, if compatible
     */
    <T extends H> Optional<T> getOrCreate(Class<T> containerClass);

    /**
     * Checks if the given {@link Class} of type {@link ValueContainer} is
     * supported by this {@link CompositeValueStore}.
     *
     * @param holderClass The container class
     * @return True if the class is supported
     */
    boolean supports(Class<? extends H> holderClass);

    /**
     * Applies a transformation on the provided {@link BaseValue} such that
     * the return value of {@link Function#apply(Object)} will become the end
     * resulting value set into this {@link CompositeValueStore}. It is not
     * necessary that the input is actually present, in which case the
     * {@link Key}ed data is compatible, but not necessarily present. Writing
     * a {@link Function} to properly handle the potential for a null input
     * is required for this method to execute without exception.
     *
     * @param key The key linked to
     * @param function The function to manipulate the value
     * @param <E> The type of value
     * @return The end resulting value
     */
    <E> DataTransactionResult transform(Key<? extends BaseValue<E>> key, Function<E, E> function);

    /**
     * Offers the given {@code value} as defined by the provided {@link Key}
     * such that a {@link DataTransactionResult} is returned for any
     * successful, rejected, and replaced {@link BaseValue}s from this
     * {@link CompositeValueStore}.
     *
     * @param key The key to the value to set
     * @param value The value to set
     * @param <E> The type of value
     * @return The transaction result
     */
    <E> DataTransactionResult offer(Key<? extends BaseValue<E>> key, E value);

    /**
     * Offers the given {@link BaseValue} as defined by the provided
     * {@link Key} such that a {@link DataTransactionResult} is returned for
     * any successful, rejected, and replaced {@link BaseValue}s from this
     * {@link CompositeValueStore}.
     *
     * @param value The value to set
     * @return The transaction result
     */
    DataTransactionResult offer(BaseValue<?> value);

    /**
     * Offers the given {@link ValueContainer} such that all of the available
     * {@link BaseValue}s from the given {@link ValueContainer} are offered
     * to this {@link CompositeValueStore}. The end result of the values
     * successfully offered, rejected, and replaced are stored in the returned
     * {@link DataTransactionResult}.
     *
     * @param valueContainer The value to set
     * @return The transaction result
     */
    DataTransactionResult offer(H valueContainer);

    /**
     * Offers the given {@link ValueContainer} such that all of the available
     * {@link BaseValue}s from the given {@link ValueContainer} are offered
     * to this {@link CompositeValueStore}. The end result of the values
     * successfully offered, rejected, and replaced are stored in the returned
     * {@link DataTransactionResult}. Any overlaps of data are merged via
     * the {@link MergeFunction}.
     *
     * @param valueContainer The value to set
     * @param function The merge function
     * @return The transaction result
     */
    DataTransactionResult offer(H valueContainer, MergeFunction function);

    /**
     * Offers all provided {@link ValueContainer}s to this
     * {@link CompositeValueStore} much like {@link #offer(ValueContainer)}
     * except all in a single batch. The end result of the values successfully
     * offered, rejected, and replaced are stored in the returned
     * {@link DataTransactionResult}.
     *
     * @param valueContainers The values to set
     * @return The transaction result
     */
    DataTransactionResult offer(Iterable<H> valueContainers);

    /**
     * Offers all provided {@link ValueContainer}s to this
     * {@link CompositeValueStore} much like {@link #offer(ValueContainer)}
     * except all in a single batch. The end result of the values successfully
     * offered, rejected, and replaced are stored in the returned
     * {@link DataTransactionResult}. Any merge conflicts are resolved through
     * the {@link MergeFunction}.
     *
     * @param valueContainers The values to set
     * @param function The function to resolve the values
     * @return The transaction result
     */
    DataTransactionResult offer(Iterable<H> valueContainers, MergeFunction function);

    /**
     * Attempts to remove all {@link Value}s associated with the class of the
     * provided {@link ValueContainer} class. All values that were successfully
     * removed will be provided in
     * {@link DataTransactionResult#getReplacedData()}. If the data can not be
     * removed, the result will be an expected
     * {@link org.spongepowered.api.data.DataTransactionResult.Type#FAILURE}.
     *
     * @param containerClass The container class
     * @return The transaction result
     */
    DataTransactionResult remove(Class<? extends H> containerClass);

    /**
     * Attempts to remove the provided {@link BaseValue}. All values that were
     * successfully removed will be provided in
     * {@link DataTransactionResult#getReplacedData()}. If the data can not be
     * removed, the result will be an expected
     * {@link org.spongepowered.api.data.DataTransactionResult.Type#FAILURE}.
     *
     * @param value The value to remove
     * @return The transaction result
     */
    DataTransactionResult remove(BaseValue<?> value);

    /**
     * Attempts to remove the data associated with the provided {@link Key}.
     * All values that were successfully removed will be provided in
     * {@link DataTransactionResult#getReplacedData()}. If the data can not be
     * removed, the result will be an expected
     * {@link org.spongepowered.api.data.DataTransactionResult.Type#FAILURE}.
     *
     * @param key The key of the data
     * @return The transaction result
     */
    DataTransactionResult remove(Key<?> key);

    /**
     * Attempts to "revert" a {@link DataTransactionResult} such that any
     * of the {@link DataTransactionResult#getReplacedData()} are offered
     * back, and any {@link DataTransactionResult#getSuccessfulData()} are
     * removed if they were not the same types as any exising in the
     * replaced values.
     *
     * @param result The result to undo
     * @return The result of the undo
     */
    DataTransactionResult undo(DataTransactionResult result);

    /**
     * Performs an absolute copy of all {@link Value}s and
     * {@link ValueContainer}s to this {@link CompositeValueStore} such that
     * any overlapping {@link Value}s are offered for replacement. The
     * result is provided as a {@link DataTransactionResult}.
     *
     * @param that The other {@link CompositeValueStore} to copy values from
     * @return The transaction result
     */
    DataTransactionResult copyFrom(S that);

    /**
     * Performs an absolute copy of all {@link Value}s and
     * {@link ValueContainer}s to this {@link CompositeValueStore} such that
     * any overlapping {@link Value}s are offered for replacement. The
     * result is provided as a {@link DataTransactionResult}.
     *
     * @param that The other {@link CompositeValueStore} to copy values from
     * @param function The function to resolve merge conflicts
     * @return The transaction result
     */
    DataTransactionResult copyFrom(S that, MergeFunction function);

    /**
     * Gets an copied collection of all known {@link ValueContainer}s
     * belonging to this {@link CompositeValueStore}. An individual
     * {@link ValueContainer} can be used for data processing for various
     * purposes.
     *
     * @return A collection of copied {@link ValueContainer}s originating
     *     from this value store
     */
    Collection<H> getContainers();

}
