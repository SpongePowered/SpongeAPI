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

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.CompositeValueStore;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.util.PEBKACException;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Represents a transaction taking place where a {@link DataHolder} is
 * accepting {@link DataManipulator}s.
 */
public final class DataTransactionResult {

    private static final DataTransactionResult SUCCESS_NODATA = builder().result(Type.SUCCESS).build();
    private static final DataTransactionResult FAIL_NODATA = builder().result(Type.FAILURE).build();


    /**
     * Gets a new {@link Builder} to build a new
     * {@link DataTransactionResult}.
     *
     * @return The new builder, for chaining
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Creates a {@link DataTransactionResult} with no data successfully added,
     * removed, or rejected, and with the
     * {@link Type} of
     * {@link Type#SUCCESS}
     * result type.
     *
     * @return A clean and empty data transaction
     */
    public static DataTransactionResult successNoData() {
        return SUCCESS_NODATA;
    }

    /**
     * Creates a new {@link DataTransactionResult} with the provided
     * {@link ImmutableValue} being the successful addition. The result type is
     * still {@link Type#SUCCESS}. If a {@link Value} is
     * necessary, use {@link Value#asImmutable()} to use this method. A
     * {@link DataTransactionResult} is always immutable once created, and any
     * {@link BaseValue}s should be provided as {@link ImmutableValue}s or
     * transformed into {@link ImmutableValue}s.
     *
     * @param value The successfully added immutable value
     * @return The new data transaction result
     */
    public static DataTransactionResult successResult(final ImmutableValue<?> value) {
        return builder().success(value).result(Type.SUCCESS).build();
    }

    /**
     * Creates a new {@link DataTransactionResult} with the provided
     * {@link ImmutableValue} being the successful addition. The result type is
     * still {@link Type#SUCCESS}. If a {@link Value} is
     * necessary, use {@link Value#asImmutable()} to use this method. A
     * {@link DataTransactionResult} is always immutable once created, and any
     * {@link BaseValue}s should be provided as {@link ImmutableValue}s or
     * transformed into {@link ImmutableValue}s.
     *
     * @param successful The successfully added immutable value
     * @param replaced The replaced value
     * @return The new data transaction result
     */
    public static DataTransactionResult successReplaceResult(final ImmutableValue<?> successful, final ImmutableValue<?> replaced) {
        return builder().result(Type.SUCCESS).success(successful).replace(replaced).build();
    }

    /**
     * Creates a new {@link DataTransactionResult} with the provided
     * {@link ImmutableValue}s being the successful additions and
     * the provided {@link ImmutableValue}s that were replaced. The result type
     * is still {@link Type#SUCCESS}. If a {@link Value}
     * is necessary, use {@link Value#asImmutable()} to use this method. A
     * {@link DataTransactionResult} is always immutable once created, and any
     * {@link BaseValue}s should be provided as {@link ImmutableValue}s or
     * transformed into {@link ImmutableValue}s.
     *
     * @param successful The successfully added immutable values
     * @param replaced The successfully replaced immutable values
     * @return The new data transaction result
     */
    public static DataTransactionResult successReplaceResult(Collection<ImmutableValue<?>> successful, Collection<ImmutableValue<?>> replaced) {
        return builder().success(successful).replace(replaced).result(Type.SUCCESS).build();
    }

    /**
     * Creates a {@link DataTransactionResult} with the provided
     * {@link ImmutableValue}s being successfully removed. The result type is
     * still {@link Type#SUCCESS}. If a {@link Value} is necessary, use
     * {@link Value#asImmutable()} to use this method. A {@link DataTransactionResult}
     * is always immutable once created, and any {@link BaseValue}s should be provided
     * as {@link ImmutableValue}s or transformed into {@link ImmutableValue}s.
     *
     * @param removed The successfully removed values
     * @return The new data transaction result
     */
    public static DataTransactionResult successRemove(Collection<ImmutableValue<?>> removed) {
        return builder().replace(removed).result(Type.SUCCESS).build();
    }

    /**
     * Creates a {@link DataTransactionResult} with the provided
     * {@link ImmutableValue} being successfully removed. The result type is
     * still {@link Type#SUCCESS}. If a {@link Value} is necessary, use
     * {@link Value#asImmutable()} to use this method. A
     * {@link DataTransactionResult} is always immutable once created, and a
     * {@link BaseValue} should be provided as an {@link ImmutableValue} or
     * transformed into an {@link ImmutableValue}.
     *
     * @param removed The successfully removed value
     * @return The new data transaction result
     */
    public static DataTransactionResult successRemove(ImmutableValue<?> removed) {
        return builder().replace(removed).result(Type.SUCCESS).build();
    }

    /**
     * Creates a new {@link DataTransactionResult} that ends in failure. The
     * provided {@link ImmutableValue} is considered "rejected" and was not
     * successfully added.
     *
     * @param value The value that was rejected
     * @return The new data transaction result
     */
    public static DataTransactionResult failResult(final ImmutableValue<?> value) {
        return builder().reject(value).result(Type.FAILURE).build();
    }

    /**
     * Creates a new {@link DataTransactionResult} that ends in failure. The
     * provided {@link ImmutableValue}s are considered "rejected" and were not
     * successfully added.
     *
     * @param values The values that were rejected
     * @return The new data transaction result
     */
    public static DataTransactionResult failResult(final Iterable<ImmutableValue<?>> values) {
        return builder().reject(values).result(Type.FAILURE).build();
    }

    /**
     * Creates a new {@link DataTransactionResult} that ends in failure. There
     * is no additional data to include.
     *
     * @return The new data transaction result
     */
    public static DataTransactionResult failNoData() {
        return FAIL_NODATA;
    }

    /**
     * Creates a new {@link DataTransactionResult} that ends in failure. The
     * provided {@link ImmutableValue} is considered "incompatible" and was not
     * successfully added.
     *
     * @param value The value that was incompatible or errored
     * @return The new data transaction result
     */
    public static DataTransactionResult errorResult(final ImmutableValue<?> value) {
        return builder().result(Type.ERROR).reject(value).build();
    }

    /**
     * The type of transaction result.
     */
    public enum Type {

        /**
         * The actual result of the operation is undefined, this probably
         * indicates that something went wrong with the operation that the
         * {@link DataManipulator} couldn't handle or didn't expect. The
         * state of the {@link DataManipulator} is undefined.
         */
        UNDEFINED,

        /**
         * The item data operation succeeded.
         */
        SUCCESS,

        /**
         * The {@link DataManipulator} operation failed for an
         * <em>expected</em> reason (such as the {@link DataManipulator} being
         * incompatible with the {@link DataHolder}. The condition of the
         * {@link DataManipulator} is unchanged.
         */
        FAILURE,

        /**
         * The {@link DataManipulator} operation failed because an
         * <em>unexpected</em> condition occurred. The state of the
         * {@link DataManipulator} is undefined.
         */
        ERROR,

        /**
         * An operation was cancelled by a third party (eg. a
         * {@link DataManipulator} event was cancelled). The condition of the
         * {@link DataManipulator} is unchanged.
         */
        CANCELLED,
        ;
    }

    final Type type;
    private final ImmutableList<ImmutableValue<?>> rejected;
    private final ImmutableList<ImmutableValue<?>> replaced;
    private final ImmutableList<ImmutableValue<?>> success;

    DataTransactionResult(final Builder builder) {
        this.type = builder.resultType;
        if (builder.rejected != null) {
            this.rejected = ImmutableList.copyOf(builder.rejected);
        } else {
            this.rejected = ImmutableList.of();
        }
        if (builder.replaced != null) {
            this.replaced = ImmutableList.copyOf(builder.replaced);
        } else {
            this.replaced = ImmutableList.of();
        }
        if (builder.successful != null) {
            this.success = ImmutableList.copyOf(builder.successful);
        } else {
            this.success = ImmutableList.of();
        }
    }


    /**
     * Gets the type of result.
     *
     * @return the type of result
     */
    public Type getType() {
        return this.type;
    }

    /**
     * Gets whether this {@link DataTransactionResult} was successful or not.
     *
     * @return True if this result was successful
     */
    public boolean isSuccessful() {
        return getType() == Type.SUCCESS;
    }

    /**
     * If any {@link BaseValue}s applied onto a {@link CompositeValueStore} were
     * successful, they'll be stored in the given list.
     *
     * @return An immutable list of the values successfully offered
     */
    public List<ImmutableValue<?>> getSuccessfulData() {
        return this.success;
    }

    /**
     * If {@link Value}s were supplied to the operation, this
     * collection will return any {@link ImmutableValue}s which were rejected
     * by the target {@link DataHolder}.
     *
     * @return Any data that was rejected from the operation
     */
    public List<ImmutableValue<?>> getRejectedData() {
        return this.rejected;
    }

    /**
     * If the operation replaced any {@link Value}s, this returns a collection
     * of the replaced {@link ImmutableValue}s.
     *
     * @return Any data that was replaced
     */
    public List<ImmutableValue<?>> getReplacedData() {
        return this.replaced;
    }

    /**
     * If this result of {@link #isSuccessful()} returns {@code true},
     * the provided {@link Consumer} is called provided a list of all
     * "successful" data as retrieved from {@link #getSuccessfulData()}.
     *
     * @param consumer The consumer to call
     */
    public void ifSucessful(Consumer<List<ImmutableValue<?>>> consumer) {
        if (isSuccessful()) {
            try {
                consumer.accept(this.success);
            } catch (Exception e) {
                // Because Callable throws exception in the signature.....
                new RuntimeException("Something went wrong trying to call a callable", e).printStackTrace();
            }
        }
    }

    /**
     * Used to call a {@link Supplier} for an {@link Exception} of type
     * {@code E} such that if this transaction's {@link #isSuccessful()}
     * returns {@code false}, the supplier's exception is thrown.
     *
     * @param supplier The supplier of the exception to throw
     * @param <E> The type of exception
     * @throws E The exception to throw if this transaction is not successful
     */
    public <E extends Exception> void ifNotSuccessful(Supplier<E> supplier) throws E {
        if (!isSuccessful()) {
            throw supplier.get();
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("resultType", this.type)
                .add("rejectedData", this.rejected)
                .add("replacedData", this.replaced)
                .add("successfulData", this.success)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DataTransactionResult that = (DataTransactionResult) o;
        return type == that.type
               && Objects.equal(rejected, that.rejected)
               && Objects.equal(replaced, that.replaced)
               && Objects.equal(success, that.success);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type, rejected, replaced, success);
    }

    /**
     * A type of builder for building {@link DataTransactionResult}s. The common
     * use is for both implementations of {@link DataHolder}s, and various
     * {@link org.spongepowered.api.event.data.ChangeDataHolderEvent.ValueChange}s.
     */
    public static final class Builder implements ResettableBuilder<DataTransactionResult, Builder> {

        List<ImmutableValue<?>> rejected;
        List<ImmutableValue<?>> replaced;
        List<ImmutableValue<?>> successful;
        Type resultType;

        Builder() {
        }

        /**
         * Sets the expectant {@link Type} to the provided
         * type. A {@link DataTransactionResult} must always have a type to mark
         * the transaction a "success" or "failure".
         *
         * @param type The type of the transaction result
         * @return This builder, for chaining
         */
        public Builder result(final Type type) {
            this.resultType = checkNotNull(type);
            return this;
        }

        /**
         * Adds the provided {@link ImmutableValue} to the {@link List} of
         * "replaced" {@link ImmutableValue}s. The replaced values are always
         * copied for every {@link DataTransactionResult} for referencing. It is
         * also possible to retrieve these replaced {@link ImmutableValue}s to
         * {@link DataHolder#undo(DataTransactionResult)} at a later point in
         * the lifespan of the {@link DataHolder}.
         *
         * @param value The value to replace
         * @return This builder, for chaining
         */
        public Builder replace(final ImmutableValue<?> value) {
            if (this.replaced == null) {
                this.replaced = Lists.newArrayList();
            }
            this.replaced.add(checkNotNull(value));
            return this;
        }

        /**
         * Adds the provided {@link ImmutableValue}s to the {@link List} of
         * "replaced" {@link ImmutableValue}s. The replaced values are always
         * copied for every {@link DataTransactionResult} for referencing. It is
         * also possible to retrieve these replaced {@link ImmutableValue}s to
         * {@link DataHolder#undo(DataTransactionResult)} at a later point in
         * the lifespan of the {@link DataHolder}.
         *
         * @param values The values to replace
         * @return This builder, for chaining
         */
        public Builder replace(final Iterable<ImmutableValue<?>> values) {
            for (ImmutableValue<?> value : values) {
                replace(checkNotNull(value));
            }
            return this;
        }

        /**
         * Adds the provided {@link ImmutableValue} to the {@link List} of
         * "rejected" {@link ImmutableValue}s. The rejected values are always
         * copied for every {@link DataTransactionResult} for referencing. It is
         * also possible to retrieve these rejected {@link ImmutableValue}s to
         * {@link DataHolder#undo(DataTransactionResult)} at a later point in
         * the lifespan of the {@link DataHolder}.
         *
         * @param value The values to reject
         * @return This builder, for chaining
         */
        public Builder reject(final ImmutableValue<?> value) {
            if (this.rejected == null) {
                this.rejected = Lists.newArrayList();
            }
            this.rejected.add(checkNotNull(value));
            return this;
        }

        /**
         * Adds the provided {@link ImmutableValue}s to the {@link List} of
         * "rejected" {@link ImmutableValue}s. The rejected values are always
         * copied for every {@link DataTransactionResult} for referencing. It is
         * also possible to retrieve these rejected {@link ImmutableValue}s to
         * {@link DataHolder#undo(DataTransactionResult)} at a later point in
         * the lifespan of the {@link DataHolder}.
         *
         * @param values The values to reject
         * @return This builder, for chaining
         */
        public Builder reject(final Iterable<ImmutableValue<?>> values) {
            for (ImmutableValue<?> value : values) {
                reject(checkNotNull(value));
            }
            return this;
        }

        /**
         * Adds the provided {@link ImmutableValue} to the {@link List} of
         * "successful" {@link ImmutableValue}s. The rejected values are always
         * copied for every {@link DataTransactionResult} for referencing. It is
         * also possible to retrieve these successful {@link ImmutableValue}s to
         * {@link DataHolder#undo(DataTransactionResult)} at a later point in
         * the lifespan of the {@link DataHolder}.
         *
         * @param value The value that was successfully provided
         * @return This builder, for chaining
         */
        public Builder success(final ImmutableValue<?> value) {
            if (this.successful == null) {
                this.successful = Lists.newArrayList();
            }
            this.successful.add(checkNotNull(value));
            return this;
        }

        /**
         * Adds the provided {@link ImmutableValue}s to the {@link List} of
         * "successful" {@link ImmutableValue}s. The rejected values are always
         * copied for every {@link DataTransactionResult} for referencing. It is
         * also possible to retrieve these successful {@link ImmutableValue}s to
         * {@link DataHolder#undo(DataTransactionResult)} at a later point in
         * the lifespan of the {@link DataHolder}.
         *
         * @param values The values that were successfully provided
         * @return This builder, for chaining
         */
        public Builder success(final Iterable<ImmutableValue<?>> values) {
            for (ImmutableValue<?> value : values) {
                success(checkNotNull(value));
            }
            return this;
        }

        /**
         * Combines the currently building {@link DataTransactionResult} with the
         * one provided. Usually, this means that there is some merging of the
         * {@link ImmutableValue}s based on {@link Key}. If this builder already
         * has an {@link ImmutableValue} as being successfully offered, and the
         * provided result shows the same key as being rejected, the rejected
         * {@link ImmutableValue} will remain in the final result.
         *
         * @param result The result to merge
         * @return This builder, for chaining
         */
        public Builder absorbResult(final DataTransactionResult result) {
            // First, let's handle the type:
            if (this.resultType == null) {
                this.resultType = result.getType();
            } else {
                if (this.resultType.compareTo(result.getType()) < 0) {
                    this.resultType = result.getType();
                }
            }
            final List<ImmutableValue<?>> newSuccessful = Lists.newArrayList();
            final List<ImmutableValue<?>> newReplaced = Lists.newArrayList();
            final List<ImmutableValue<?>> newRejected = Lists.newArrayList();
            // Now let's handle the successful data
            if (this.successful != null) {
                dance:
                for (final ImmutableValue<?> value : this.successful) {
                    for (final ImmutableValue<?> rejected : result.getRejectedData()) {
                        if (value.getKey().equals(rejected.getKey())) {
                            newRejected.add(rejected);
                            continue dance;
                        }
                    }
                    for (final ImmutableValue<?> replaced : result.getReplacedData()) {
                        if (value.getKey().equals(replaced.getKey())) {
                            newReplaced.add(value);
                            continue dance;
                        }
                    }
                    for (final ImmutableValue<?> successful : result.getSuccessfulData()) {
                        if (value.getKey().equals(successful.getKey())) {
                            newSuccessful.add(successful);
                            continue dance;
                        }
                    }
                    newSuccessful.add(value);
                }
            }
            if (this.replaced != null) {
                dance:
                for (final ImmutableValue<?> value : this.replaced) {
                    for (final ImmutableValue<?> rejected : result.getRejectedData()) {
                        if (value.getKey().equals(rejected.getKey())) {
                            newRejected.add(rejected);
                            continue dance;
                        }
                    }
                    for (final ImmutableValue<?> replaced : result.getReplacedData()) {
                        if (value.getKey().equals(replaced.getKey())) {
                            newReplaced.add(value);
                            continue dance;
                        }
                    }
                    for (final ImmutableValue<?> successful : result.getSuccessfulData()) {
                        if (value.getKey().equals(successful.getKey())) {
                            newSuccessful.add(successful);
                            continue dance;
                        }
                    }
                    newReplaced.add(value);
                }
            }
            if (this.rejected != null) {
                dance:
                for (final ImmutableValue<?> value : this.rejected) {
                    for (final ImmutableValue<?> rejected : result.getRejectedData()) {
                        if (value.getKey().equals(rejected.getKey())) {
                            newRejected.add(rejected);
                            continue dance;
                        }
                    }
                    for (final ImmutableValue<?> replaced : result.getReplacedData()) {
                        if (value.getKey().equals(replaced.getKey())) {
                            newReplaced.add(value);
                            continue dance;
                        }
                    }
                    for (final ImmutableValue<?> successful : result.getSuccessfulData()) {
                        if (value.getKey().equals(successful.getKey())) {
                            newSuccessful.add(successful);
                            continue dance;
                        }
                    }
                    newRejected.add(value);
                }
            }
            dance:
            for (final ImmutableValue<?> value : result.getSuccessfulData()) {
                for (final ImmutableValue<?> rejected : newRejected) {
                    if (value.getKey().equals(rejected.getKey())) {
                        continue dance;
                    }
                }
                for (final ImmutableValue<?> replaced : newReplaced) {
                    if (value.getKey().equals(replaced.getKey())) {
                        continue dance;
                    }
                }
                for (final ImmutableValue<?> successful : newSuccessful) {
                    if (value.getKey().equals(successful.getKey())) {
                        continue dance;
                    }
                }
                newSuccessful.add(value);
            }
            dance:
            for (final ImmutableValue<?> value : result.getRejectedData()) {
                for (final ImmutableValue<?> rejected : newRejected) {
                    if (value.getKey().equals(rejected.getKey())) {
                        continue dance;
                    }
                }
                for (final ImmutableValue<?> replaced : newReplaced) {
                    if (value.getKey().equals(replaced.getKey())) {
                        continue dance;
                    }
                }
                for (final ImmutableValue<?> successful : newSuccessful) {
                    if (value.getKey().equals(successful.getKey())) {
                        continue dance;
                    }
                }
                newRejected.add(value);
            }
            dance:
            for (final ImmutableValue<?> value : result.getReplacedData()) {
                for (final ImmutableValue<?> rejected : newRejected) {
                    if (value.getKey().equals(rejected.getKey())) {
                        continue dance;
                    }
                }
                for (final ImmutableValue<?> replaced : newReplaced) {
                    if (value.getKey().equals(replaced.getKey())) {
                        continue dance;
                    }
                }
                for (final ImmutableValue<?> successful : newSuccessful) {
                    if (value.getKey().equals(successful.getKey())) {
                        continue dance;
                    }
                }
                newReplaced.add(value);
            }
            this.replaced = newReplaced;
            this.rejected = newRejected;
            this.successful = newSuccessful;
            return this;
        }

        /**
         * Builds a new {@link DataTransactionResult} with the providing
         * {@link List}s of {@link ImmutableValue}s that are successfully
         * offered, {@link ImmutableValue}s that were replaced, and
         * {@link ImmutableValue}s that were rejected.
         *
         * @return The newly created transaction result
         */
        public DataTransactionResult build() {
            checkState(this.resultType != null);
            return new DataTransactionResult(this);
        }

        @Override
        public Builder from(DataTransactionResult value) {
            this.resultType = value.type;
            this.rejected = new ArrayList<>(value.getRejectedData());
            this.replaced = new ArrayList<>(value.getReplacedData());
            this.successful = new ArrayList<>(value.getSuccessfulData());
            return this;
        }

        @Override
        public Builder reset() {
            this.rejected = null;
            this.replaced = null;
            this.successful = null;
            this.resultType = null;
            return this;
        }

    }
}
