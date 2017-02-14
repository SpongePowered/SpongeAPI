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
package org.spongepowered.api.data.value.immutable;

import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.ValueContainer;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Represents a {@link ValueContainer} that is immutable once created and
 * contains a various bundle of {@link ValueContainer}s of type declared by
 * the extension that can be managed separately from this immutable value
 * store.
 *
 * @param <I> The type of immutable value store, for self referencing
 * @param <H> The type of {@link ValueContainer} to restrict accessing of
 *     values to
 */
public interface ImmutableValueStore<I extends ImmutableValueStore<I, H>, H extends ValueContainer<?>> extends ValueContainer<I> {

    /**
     * <p>Gets the desired {@link ValueContainer} of type <code>H</code> if the
     * {@link ValueContainer} is compatible. Since the return type is an
     * {@link Optional}, a short way of checking compatibility and presence
     * of the requested data is to mimic the following:</p>
     *
     * <blockquote><code>// MyCompositeValueStore extends
     * CompositeValueStore&lt;MyCompositeValueStore,
     * DataManipulator&lt;?&gt;&gt;<br />MyCompositeValueStore valueStore;<br />
     * final Optional&lt;DisplayNameData&gt; displayOptional =
     * valueStore.get(DisplayNameData.class);<br />
     * if (displayOptional.isPresent()) {<br />&nbsp; &nbsp;
     * // We know that we have a present DataManipulator and it's supported
     * <br />&nbsp; &nbsp; System.out.println(
     * displayOptional.get().displayName().get().toString());<br />
     * }</code></blockquote>
     *
     * <p>This is the equivalent to performing the following:</p>
     *
     * <blockquote><code>
     * MyCompositeValueStore valueStore;<br />
     * if (valueStore.supports(DisplayNameData.class)) {<br />
     * &nbsp; &nbsp;
     * System.out.println(valueStore.getOrNull(DisplayNameData.class
     * ).displayName().get().toString());<br />}</code></blockquote>
     *
     * <p>The advantage of this returning an {@link Optional} is that the
     * {@link ValueContainer} may be unsupported, the required data missing
     * and ignoring the possibility of {@code null}s, it is a guarantee that if
     * the {@link Optional#isPresent()} is {@code true}, the
     * {@link ValueContainer} not only is supported, but there is already pre-
     * existing data for the {@link ValueContainer}.</p>
     *
     * <p>If it is necessary to ignore the {@link Optional},
     * {@link Optional#orElse(Object)} can be used to return a potentially
     * {@code null} {@link ValueContainer}.</p>
     *
     *
     * @param containerClass The container class
     * @param <T> The type of {@link ValueContainer}
     * @return The value container, if available
     */
    <T extends H> Optional<T> get(Class<T> containerClass);

    /**
     * <p>Gets the desired {@link ValueContainer} of type <code>H</code> if the
     * {@link ValueContainer} is compatible. If insufficient data is available
     * to provide a {@link ValueContainer} with all {@link ImmutableValue}s
     * preset, a new instance of the {@link ValueContainer} is returned with
     * "default" values. Since the return type is an {@link Optional}, a short
     * way of checking compatibility and presence of the requested data is to
     * mimic the following:</p>
     *
     * <blockquote><code>// MyCompositeValueStore extends
     * CompositeValueStore&lt;MyCompositeValueStore,
     * DataManipulator&lt;?&gt;&gt;<br />
     * MyCompositeValueStore valueStore;<br />
     * final Optional&lt;DisplayNameData&gt; displayOptional =
     * valueStore.getOrCreate(DisplayNameData.class);<br />
     * if (displayOptional.isPresent()) {<br />&nbsp; &nbsp; // We know that we
     * have a present DataManipulator and it's supported<br />&nbsp; &nbsp;
     * System.out.println(displayOptional.get().displayName().get().toString());
     * <br />}</code></blockquote>
     *
     * <p>This is the equivalent to performing the following:</p>
     *
     * <blockquote><code>MyCompositeValueStore valueStore;<br />
     * if (valueStore.supports(DisplayNameData.class)) {<br />&nbsp; &nbsp;
     * System.out.println(valueStore.getOrNull(DisplayNameData.class
     * ).displayName().get().toString());<br />}</code></blockquote>
     *
     * <p>The advantage of this returning an {@link Optional} is that the
     * {@link ValueContainer} may be unsupported, the required data missing
     * and ignoring the possibility of {@code null}s, it is a guarantee that if
     * the {@link Optional#isPresent()} is {@code true}, the
     * {@link ValueContainer} not only is supported, but there is already pre-
     * existing data for the {@link ValueContainer}.</p>
     *
     * <p>If it is necessary to ignore the {@link Optional},
     * {@link Optional#orElse(Object)} can be used to return a potentially
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
     * supported by this {@link ImmutableValueStore}.
     *
     * @param containerClass The container class
     * @return True if the class is supported
     */
    boolean supports(Class<? extends H> containerClass);

    /**
     * Applies a transformation on the provided {@link BaseValue} such that
     * the return value of {@link Function#apply(Object)} will become the end
     * resulting value set into the newly created {@link ImmutableValueStore}.
     *
     * @param key The key linked to
     * @param function The function to manipulate the value
     * @param <E> The type of value
     * @return The newly created immutable value store
     */
    <E> Optional<I> transform(Key<? extends BaseValue<E>> key, Function<E, E> function);

    /**
     * Creates a new {@link ImmutableValueStore} with the provided
     * value by {@link Key}. If the key is supported by this value store,
     * the returned value store will be present.
     *
     * @param key The key to the value to set
     * @param value The value to set
     * @param <E> The type of value
     * @return The new immutable value store
     */
    <E> Optional<I> with(Key<? extends BaseValue<E>> key, E value);

    /**
     * Offers the given {@code value} as defined by the provided {@link Key}
     * such that if the {@link Key} is supported, a new
     * {@link ImmutableValueStore} is created.
     *
     * @param value The value to set
     * @return The new immutable value store
     */
    Optional<I> with(BaseValue<?> value);

    /**
     * Offers the given {@link ValueContainer} such that all of the available
     * {@link BaseValue}s from the given {@link ValueContainer} are offered
     * to the newly created {@link ImmutableValueStore}.
     *
     * @param valueContainer The value to set
     * @return The transaction result
     */
    Optional<I> with(H valueContainer);

    /**
     * Gets an altered copy of this {@link ImmutableValueStore} with the given
     * {@link DataManipulator} modified data. If the data is not compatible for
     * any reason, {@link Optional#empty()} is returned.
     *
     * <p>This does not alter the current {@link ImmutableValueStore}.</p>
     *
     * @param valueContainers The new manipulator containing data
     * @return A new immutable value store with the given value holders
     */
    Optional<I> with(Iterable<H> valueContainers);

    /**
     * Gets an altered copy of this {@link ImmutableValueStore} without the
     * given {@link ValueContainer} class. If the data represented by the
     * manipulator can not exist without a "default state" of the
     * {@link ValueContainer}, the {@link ValueContainer} is reset to the
     * "default" state.
     *
     * @param containerClass The value holders to ignore
     * @return A new immutable data holder without the given manipulator
     */
    Optional<I> without(Class<? extends H> containerClass);

    /**
     * Attempts to merge the {@link ImmutableValue}s from this
     * {@link ImmutableValueStore} and the given {@link ImmutableValueStore} to
     * produce a new instance of the merged result.
     *
     * @param that The other immutable value store to gather values from
     * @return The new immutable value store instance
     */
    I merge(I that);

    /**
     * Attempts to merge the {@link ImmutableValue}s from this
     * {@link ImmutableValueStore} and the given {@link ImmutableValueStore} to
     * produce a new instance of the merged result. Any overlapping
     * {@link ValueContainer}s are merged through the {@link MergeFunction}.
     *
     * @param that The other immutable value store to gather values from
     * @param function The function to resolve merge conflicts
     * @return The new immutable value store instance
     */
    I merge(I that, MergeFunction function);

    /**
     * Gets an copied collection of all known {@link ValueContainer}s
     * belonging to this {@link ImmutableValueStore}. An individual
     * {@link ValueContainer} can be used for data processing for various
     * purposes.
     *
     * @return A collection of copied {@link ValueContainer}s originating
     *     from this value store
     */
    List<H> getContainers();

}
