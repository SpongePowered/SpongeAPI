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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.merge.MergeFunction;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * A ValueContainer is a holder of a particular set of {@link Value}s. While
 * there exists a {@link CompositeValueStore} and {@link ImmutableValueStore},
 * the emphasis of {@link ValueContainer} is that it only contains "data". It
 * is not known whether a {@code ValueContainer} is mutable or immutable.
 *
 * <p>Being that a {@code ValueContainer} is literally a container of
 * {@link Value}s, it itself does not contain the underlying values of
 * data. A {@link ValueContainer} may not always be parented by another
 * {@link ValueContainer}, such as the case for {@link DataManipulator}s and
 * {@link DataHolder}s, it is recommended to knowingly understand the
 * fundamental differences between them.</p>
 *
 * @param <C> The type of container for fluency
 */
public interface ValueContainer<C extends ValueContainer<C>> {

    /**
     * Attempts to get the underlying value backed by a {@link Value}
     * linked to the provided {@link Key}. If the {@link Key} is not
     * supported, {@link Optional#empty()} is returned. It is important
     * to check for support of a {@link Key} by either calling
     * {@link #supports(Value)} or {@link #supports(Key)}.
     *
     * @param key The key linking the
     * @param <E> The type of value
     * @return The value, if available
     */
    <E> Optional<E> get(Key<? extends Value<E>> key);

    /**
     * Attempts to get the underlying value backed by a {@link Value}
     * linked to the provided {@link Key}.
     *
     * <p>If the {@link Key} is not supported or
     * available, {@link NoSuchElementException} will be thrown.</p>
     *
     * @param key The key
     * @param <E> The type of value
     * @return The value
     * @throws NoSuchElementException If the value is not supported or present
     */
    default <E> E require(Key<? extends Value<E>> key) {
        final Optional<E> optional = this.get(key);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NoSuchElementException(String.format("Could not retrieve value for key '%s'", key.getId()));
    }

    /**
     * Attempts to get the underlying value if available and supported. If the
     * {@link Value} is not supported whatsoever by this
     * {@link ValueContainer}, an exception is thrown.
     *
     * @param key The {@link Key} backing the {@link Value}
     * @param <E> The type of value
     * @return The value, or null if not set
     */
    @Nullable
    default <E> E getOrNull(Key<? extends Value<E>> key) {
        Optional<E> value = get(key);
        if (value.isPresent()) {
            return value.get();
        }
        if (!supports(key)) {
            throw new UnsupportedOperationException("Key not supported. Key: " + key);
        }
        return null;
    }

    /**
     * Attempts to get the underlying value if available. If the value is not
     * set, the given {@code defaultValue} is returned, if the
     * {@link Value} is even supported.
     *
     * @param key The key backing the {@link Value}
     * @param defaultValue The value to default to if not set
     * @param <E> The type of value
     * @return The value, or default if not set
     */
    default <E> E getOrElse(Key<? extends Value<E>> key, E defaultValue) {
        return get(key).orElse(checkNotNull(defaultValue, "Provided a null default value for 'getOrElse(Key, null)'!"));
    }

    /**
     * Gets the {@link Value} for the given {@link Key}.
     *
     * @param key The key linked to the {@link Value}
     * @param <E> The type of the return type
     * @param <V> The type of value
     * @return The value, if available
     */
    <E, V extends Value<E>> Optional<V> getValue(Key<V> key);

    /**
     * Checks if the given {@link Key} is supported by this
     * {@link ValueContainer}.
     *
     * @param key The key to check
     * @return True if the key and value backed by the key is supported
     */
    boolean supports(Key<?> key);

    /**
     * Checks if the provided {@link Value} is supported.
     *
     * @param value The base value to check
     * @return True if the base value is supported
     */
    default boolean supports(Value<?> value) {
        return supports(value.getKey());
    }

    /**
     * Creates a clone copy of this {@link ValueContainer} as a new
     * {@link ValueContainer} such that all the {@link Value}s are
     * safely duplicated to the new instance.
     *
     * @return The new copy
     */
    C copy();

    /**
     * Gets all applicable {@link Key}s for this {@link ValueContainer}.
     * Changes can not be made to the set to alter the {@link ValueContainer},
     * nor can the {@link Value}s be changed with the provided
     * {@link ImmutableSet}.
     *
     * @return An immutable set of known {@link Key}s
     */
    Set<Key<?>> getKeys();

    /**
     * Gets all applicable {@link Value}s associated with this
     * {@link ValueContainer}. As the data backed by the values are copied,
     * any modifications to the {@link Value}s will not be reflected onto
     * this {@link ValueContainer}.
     *
     * @return An immutable set of copied values
     */
    Set<Value.Immutable<?>> getValues();

    /**
     * Represents a {@link ValueContainer} that contains a various bundle of
     * {@link ValueContainer}s of type declared by the extension that can be
     * manipulated separately from this {@link CompositeValueStore}.
     *
     * @param <S> The type of composite store, for self referencing
     * @param <H> The type of {@link ValueContainer} to restrict accessing of
     *     values to
     */
    interface CompositeValueStore<S extends CompositeValueStore<S, H>, H extends ValueContainer<?>> extends ValueContainer<S> {

        /**
         * <p>Gets the desired {@link ValueContainer} of type <code>H</code> if the
         * {@link ValueContainer} is compatible. Since the return type is an
         * {@link Optional}, a short way of checking compatibility and presence
         * of the requested data is to mimic the following:</p>
         *
         * <blockquote><code>// MyCompositeValueStore extends
         * CompositeValueStore&lt;MyCompositeValueStore,
         * DataManipulator&lt;?&gt;&gt;<br />
         * MyCompositeValueStore valueStore;<br />
         * final Optional&lt;DisplayNameData&gt; displayOptional =
         * valueStore.get(DisplayNameData.class);<br />
         * if (displayOptional.isPresent()) {<br />
         * &nbsp; &nbsp; // We know that we have a present DataManipulator and it's
         * supported<br />&nbsp; &nbsp;
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
         * <code>null</code> {@link ValueContainer}.</p>
         *
         *
         * @param containerClass The container class
         * @param <T> The type of {@link ValueContainer}
         * @return The value container, if available
         */
        <T extends H> Optional<T> get(Class<T> containerClass);

        /**
         * Gets the desired {@link ValueContainer} of type <code>H</code> if the
         * {@link ValueContainer} is compatible.
         *
         * <p>If the container class is not supported or
         * available, {@link NoSuchElementException} will be thrown.</p>
         *
         * @param containerClass The container class
         * @param <T> The type of {@link ValueContainer}
         * @return The value
         * @throws NoSuchElementException If the value is not supported or present
         */
        default <T extends H> T require(Class<T> containerClass) {
            final Optional<T> optional = this.get(containerClass);
            if (optional.isPresent()) {
                return optional.get();
            }
            throw new NoSuchElementException(String.format("Could not retrieve value for container class '%s'", containerClass.getName()));
        }

        /**
         * <p>Gets the desired {@link ValueContainer} of type <code>H</code> if the
         * {@link ValueContainer} is compatible. If insufficient data is available
         * to provide a {@link ValueContainer} with all {@link Value.Mutable}s preset, a
         * new instance of the {@link ValueContainer} is returned with "default"
         * values. Since the return type is an {@link Optional}, a short way of
         * checking compatibility and presence of the requested data is to mimic
         * the following:</p>
         *
         * <blockquote><code>// MyCompositeValueStore extends
         * CompositeValueStore&lt;MyCompositeValueStore,
         * DataManipulator&lt;?&gt;&gt;<br />
         * MyCompositeValueStore valueStore;<br />
         * final Optional&lt;DisplayNameData&gt; displayOptional =
         * valueStore.getOrCreate(DisplayNameData.class);<br />
         * if (displayOptional.isPresent()) {<br />
         * &nbsp; &nbsp; // We know that we have a present DataManipulator and it's
         * supported<br />&nbsp; &nbsp;
         * System.out.println(displayOptional.get().displayName().get().toString()
         * );<br />}</code></blockquote>
         *
         * <p>This is the equivalent to performing the following:</p>
         *
         * <blockquote><code>MyCompositeValueStore valueStore;<br />
         * if (valueStore.supports(DisplayNameData.class)) {<br />&nbsp; &nbsp;
         * System.out.println(valueStore.get(DisplayNameData.class
         * ).get().displayName().get().toString());<br />}</code></blockquote>
         *
         * <p>The advantage of this returning an {@link Optional} is that the
         * {@link ValueContainer} may be unsupported, the required data missing
         * and ignoring the possibility of {@code null}s, it is a guarantee that if
         * the {@link Optional#isPresent()} is {@code true}, the
         * {@link ValueContainer} not only is supported, but some default values
         * can be generated to create the desired {@link ValueContainer}.</p>
         *
         * <p>If it is necessary to ignore the {@link Optional},
         * {@link Optional#orElse(Object)} can be used to return a potentially
         * <code>null</code> {@link ValueContainer}.</p>
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
         * Applies a transformation on the provided {@link Value} such that
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
        default <E> DataTransactionResult transform(Key<? extends Value<E>> key, Function<E, E> function) {
            if (supports(key)) {
                return offer(key, checkNotNull(function.apply(get(key).orElse(null))));
            }
            return DataTransactionResult.failNoData();
        }

        /**
         * Offers the given {@code value} as defined by the provided {@link Key}
         * such that a {@link DataTransactionResult} is returned for any
         * successful, rejected, and replaced {@link Value}s from this
         * {@link CompositeValueStore}.
         *
         * @param key The key to the value to set
         * @param value The value to set
         * @param <E> The type of value
         * @return The transaction result
         */
        <E> DataTransactionResult offer(Key<? extends Value<E>> key, E value);

        /**
         * Offers the given {@link Value} as defined by the provided
         * {@link Key} such that a {@link DataTransactionResult} is returned for
         * any successful, rejected, and replaced {@link Value}s from this
         * {@link CompositeValueStore}.
         *
         * @param value The value to set
         * @param <E> The type of the element wrapped by the value
         * @return The transaction result
         */
        default <E> DataTransactionResult offer(Value<E> value) {
            return offer(value.getKey(), value.get());
        }

        /**
         * Offers the given {@link ValueContainer} such that all of the available
         * {@link Value}s from the given {@link ValueContainer} are offered
         * to this {@link CompositeValueStore}. The end result of the values
         * successfully offered, rejected, and replaced are stored in the returned
         * {@link DataTransactionResult}.
         *
         * @param valueContainer The value to set
         * @return The transaction result
         */
        default DataTransactionResult offer(H valueContainer) {
            return offer(valueContainer, MergeFunction.IGNORE_ALL);
        }

        /**
         * Offers the given {@link ValueContainer} such that all of the available
         * {@link Value}s from the given {@link ValueContainer} are offered
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
        default DataTransactionResult offer(Iterable<H> valueContainers) {
            return offer(valueContainers, MergeFunction.IGNORE_ALL);
        }


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
        default DataTransactionResult offer(Iterable<H> valueContainers, MergeFunction function) {
            final DataTransactionResult.Builder builder = DataTransactionResult.builder();
            for (H valueContainer : valueContainers) {
                builder.absorbResult(offer(valueContainer, function));
            }
            return builder.build();
        }

        /**
         * Offers the given {@code value} as defined by the provided {@link Key}
         * such that a {@link DataTransactionResult} is returned for any
         * successful {@link Value}s from this {@link CompositeValueStore}.
         * Intentionally, however, this differs from {@link #offer(Key, Object)}
         * as it will intentionally throw an exception if the result was a failure.
         *
         * @param key The key to the value to set
         * @param value The value to set
         * @param <E> The type of value
         * @return The transaction result
         * @throws IllegalArgumentException If the result is a failure likely due to
         *     incompatibility
         */
        default <E> DataTransactionResult tryOffer(Key<? extends Value<E>> key, E value) throws IllegalArgumentException {
            final DataTransactionResult result = offer(key, value);
            if (!result.isSuccessful()) {
                throw new IllegalArgumentException("Failed offer transaction!");
            }
            return result;
        }

        /**
         * Offers the given {@code value} as defined by the provided {@link Key}
         * such that a {@link DataTransactionResult} is returned for any
         * successful {@link Value}s from this {@link CompositeValueStore}.
         * Intentionally, however, this differs from {@link #offer(Key, Object)}
         * as it will intentionally throw an exception if the result was a failure.
         *
         * @param value The value to set
         * @param <E> The type of value
         * @return The transaction result
         * @throws IllegalArgumentException If the result is a failure likely due to
         *     incompatibility
         */
        default <E> DataTransactionResult tryOffer(Value<E> value) throws IllegalArgumentException {
            final DataTransactionResult result = offer(value.getKey(), value.get());
            if (!result.isSuccessful()) {
                throw new IllegalArgumentException("Failed offer transaction!");
            }
            return result;
        }

        /**
         * Offers the given {@link ValueContainer} such that all of the available
         * {@link Value}s from the given {@link ValueContainer} are offered
         * to this {@link CompositeValueStore}. Intentionally, however, this differs
         * from {@link #offer(ValueContainer)} as it will intentionally throw an
         * exception if the result was a failure.
         *
         * @param valueContainer The value to set
         * @return The transaction result
         * @throws IllegalArgumentException If the result is a failure likely due to
         *     incompatibility
         */
        default DataTransactionResult tryOffer(H valueContainer) {
            final DataTransactionResult result = offer(valueContainer, MergeFunction.IGNORE_ALL);
            if (!result.isSuccessful()) {
                throw new IllegalArgumentException("Failed offer transaction!");
            }
            return result;
        }

        /**
         * Offers the given {@link ValueContainer} such that all of the available
         * {@link Value}s from the given {@link ValueContainer} are offered
         * to this {@link CompositeValueStore}. Any overlaps of data are merged via
         * the {@link MergeFunction}. Intentionally, however, this differs
         * from {@link #offer(ValueContainer)} as it will intentionally throw an
         * exception if the result was a failure.
         *
         * @param valueContainer The value to set
         * @param function The merge function
         * @return The transaction result
         * @throws IllegalArgumentException If the result is a failure likely due to
         *     incompatibility
         */
        default DataTransactionResult tryOffer(H valueContainer, MergeFunction function) throws IllegalArgumentException {
            final DataTransactionResult result = offer(valueContainer, function);
            if (!result.isSuccessful()) {
                throw new IllegalArgumentException("Failed offer transaction!");
            }
            return result;
        }

        /**
         * Attempts to remove all {@link Value.Mutable}s associated with the class of the
         * provided {@link ValueContainer} class. All values that were successfully
         * removed will be provided in
         * {@link DataTransactionResult#getReplacedData()}. If the data can not be
         * removed, the result will be an expected
         * {@link DataTransactionResult.Type#FAILURE}.
         *
         * @param containerClass The container class
         * @return The transaction result
         */
        DataTransactionResult remove(Class<? extends H> containerClass);

        /**
         * Attempts to remove the provided {@link Value}. All values that were
         * successfully removed will be provided in
         * {@link DataTransactionResult#getReplacedData()}. If the data can not be
         * removed, the result will be an expected
         * {@link DataTransactionResult.Type#FAILURE}.
         *
         * @param value The value to remove
         * @return The transaction result
         */
        default DataTransactionResult remove(Value<?> value) {
            return remove(value.getKey());
        }

        /**
         * Attempts to remove the data associated with the provided {@link Key}.
         * All values that were successfully removed will be provided in
         * {@link DataTransactionResult#getReplacedData()}. If the data can not be
         * removed, the result will be an expected
         * {@link DataTransactionResult.Type#FAILURE}.
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
         * Performs an absolute copy of all {@link Value.Mutable}s and
         * {@link ValueContainer}s to this {@link CompositeValueStore} such that
         * any overlapping {@link Value.Mutable}s are offered for replacement. The
         * result is provided as a {@link DataTransactionResult}.
         *
         * @param that The other {@link CompositeValueStore} to copy values from
         * @return The transaction result
         */
        default DataTransactionResult copyFrom(S that) {
            return copyFrom(that, MergeFunction.IGNORE_ALL);
        }

        /**
         * Performs an absolute copy of all {@link Value.Mutable}s and
         * {@link ValueContainer}s to this {@link CompositeValueStore} such that
         * any overlapping {@link Value.Mutable}s are offered for replacement. The
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
    interface ImmutableValueStore<I extends ImmutableValueStore<I, H>, H extends ValueContainer<?>> extends ValueContainer<I> {

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
         * to provide a {@link ValueContainer} with all {@link Value.Immutable}s
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
         * Applies a transformation on the provided {@link Value} such that
         * the return value of {@link Function#apply(Object)} will become the end
         * resulting value set into the newly created {@link ImmutableValueStore}.
         *
         * @param key The key linked to
         * @param function The function to manipulate the value
         * @param <E> The type of value
         * @return The newly created immutable value store
         */
        <E> Optional<I> transform(Key<? extends Value<E>> key, Function<E, E> function);

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
        <E> Optional<I> with(Key<? extends Value<E>> key, E value);

        /**
         * Offers the given {@code value} as defined by the provided {@link Key}
         * such that if the {@link Key} is supported, a new
         * {@link ImmutableValueStore} is created.
         *
         * @param value The value to set
         * @return The new immutable value store
         */
        Optional<I> with(Value<?> value);

        /**
         * Offers the given {@link ValueContainer} such that all of the available
         * {@link Value}s from the given {@link ValueContainer} are offered
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
         * Attempts to merge the {@link Value.Immutable}s from this
         * {@link ImmutableValueStore} and the given {@link ImmutableValueStore} to
         * produce a new instance of the merged result.
         *
         * @param that The other immutable value store to gather values from
         * @return The new immutable value store instance
         */
        I merge(I that);

        /**
         * Attempts to merge the {@link Value.Immutable}s from this
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
}
