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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Represents a transaction taking place where a {@link DataHolder.Mutable} is
 * accepting {@link Value}s.
 */
public final class DataTransactionResult {

    private static final DataTransactionResult SUCCESS_NODATA = DataTransactionResult.builder().result(Type.SUCCESS).build();
    private static final DataTransactionResult FAIL_NODATA = DataTransactionResult.builder().result(Type.FAILURE).build();
    private static final Collector<DataTransactionResult, DataTransactionResult.Builder, DataTransactionResult> COLLECTOR = new Collector<DataTransactionResult, Builder, DataTransactionResult>() {
        @Override
        public Supplier<Builder> supplier() {
            return DataTransactionResult::builder;
        }

        @Override
        public BiConsumer<Builder, DataTransactionResult> accumulator() {
            return Builder::absorbResult;
        }

        @Override
        public BinaryOperator<Builder> combiner() {
            return (left, right) -> { left.absorbResult(right.build()); return left; };
        }

        @Override
        public Function<Builder, DataTransactionResult> finisher() {
            return DataTransactionResult.Builder::build;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return ImmutableSet.of();
        }
    };

    public static Collector<DataTransactionResult, DataTransactionResult.Builder, DataTransactionResult> toTransaction() {
        return DataTransactionResult.COLLECTOR;
    }

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
        return DataTransactionResult.SUCCESS_NODATA;
    }

    /**
     * Creates a new {@link DataTransactionResult} with the provided
     * {@link Value.Immutable} being the successful addition. The result type is
     * still {@link Type#SUCCESS}. If a {@link Value.Mutable} is
     * necessary, use {@link Value.Mutable}#asImmutable()} to use this method. A
     * {@link DataTransactionResult} is always immutable once created, and any
     * {@link Value}s should be provided as {@link Value.Immutable}s or
     * transformed into {@link Value.Immutable}s.
     *
     * @param value The successfully added immutable value
     * @return The new data transaction result
     */
    public static DataTransactionResult successResult(final Value.Immutable<?> value) {
        return DataTransactionResult.builder().success(value).result(Type.SUCCESS).build();
    }

    /**
     * Creates a new {@link DataTransactionResult} with the provided
     * {@link Value.Immutable} being the successful addition. The result type is
     * still {@link Type#SUCCESS}. If a {@link Value.Mutable} is
     * necessary, use {@link Value.Mutable}#asImmutable()} to use this method. A
     * {@link DataTransactionResult} is always immutable once created, and any
     * {@link Value}s should be provided as {@link Value.Immutable}s or
     * transformed into {@link Value.Immutable}s.
     *
     * @param successful The successfully added immutable value
     * @param replaced The replaced value
     * @return The new data transaction result
     */
    public static DataTransactionResult successReplaceResult(final Value.Immutable<?> successful, final Value.Immutable<?> replaced) {
        return DataTransactionResult.builder().result(Type.SUCCESS).success(successful).replace(replaced).build();
    }

    /**
     * Creates a new {@link DataTransactionResult} with the provided
     * {@link Value.Immutable}s being the successful additions and
     * the provided {@link Value.Immutable}s that were replaced. The result type
     * is still {@link Type#SUCCESS}. If a {@link Value.Mutable}
     * is necessary, use {@link Value.Mutable}#asImmutable()} to use this method. A
     * {@link DataTransactionResult} is always immutable once created, and any
     * {@link Value}s should be provided as {@link Value.Immutable}s or
     * transformed into {@link Value.Immutable}s.
     *
     * @param successful The successfully added immutable values
     * @param replaced The successfully replaced immutable values
     * @return The new data transaction result
     */
    public static DataTransactionResult successReplaceResult(final Collection<Value.Immutable<?>> successful, final Collection<Value.Immutable<?>> replaced) {
        return DataTransactionResult.builder().success(successful).replace(replaced).result(Type.SUCCESS).build();
    }

    /**
     * Creates a {@link DataTransactionResult} with the provided
     * {@link Value.Immutable}s being successfully removed. The result type is
     * still {@link Type#SUCCESS}. If a {@link Value.Mutable} is necessary, use
     * {@link Value.Mutable}#asImmutable()} to use this method. A {@link DataTransactionResult}
     * is always immutable once created, and any {@link Value}s should be provided
     * as {@link Value.Immutable}s or transformed into {@link Value.Immutable}s.
     *
     * @param removed The successfully removed values
     * @return The new data transaction result
     */
    public static DataTransactionResult successRemove(final Collection<Value.Immutable<?>> removed) {
        return DataTransactionResult.builder().replace(removed).result(Type.SUCCESS).build();
    }

    /**
     * Creates a {@link DataTransactionResult} with the provided
     * {@link Value.Immutable} being successfully removed. The result type is
     * still {@link Type#SUCCESS}. If a {@link Value.Mutable} is necessary, use
     * {@link Value.Mutable}#asImmutable()} to use this method. A
     * {@link DataTransactionResult} is always immutable once created, and a
     * {@link Value} should be provided as an {@link Value.Immutable} or
     * transformed into an {@link Value.Immutable}.
     *
     * @param removed The successfully removed value
     * @return The new data transaction result
     */
    public static DataTransactionResult successRemove(final Value.Immutable<?> removed) {
        return DataTransactionResult.builder().replace(removed).result(Type.SUCCESS).build();
    }

    /**
     * Creates a new {@link DataTransactionResult} that ends in failure. The
     * provided {@link Value.Immutable} is considered "rejected" and was not
     * successfully added.
     *
     * @param value The value that was rejected
     * @return The new data transaction result
     */
    public static DataTransactionResult failResult(final Value.Immutable<?> value) {
        return DataTransactionResult.builder().reject(value).result(Type.FAILURE).build();
    }

    /**
     * Creates a new {@link DataTransactionResult} that ends in failure. The
     * provided {@link Value.Immutable}s are considered "rejected" and were not
     * successfully added.
     *
     * @param values The values that were rejected
     * @return The new data transaction result
     */
    public static DataTransactionResult failResult(final Iterable<Value.Immutable<?>> values) {
        return DataTransactionResult.builder().reject(values).result(Type.FAILURE).build();
    }

    /**
     * Creates a new {@link DataTransactionResult} that ends in failure. There
     * is no additional data to include.
     *
     * @return The new data transaction result
     */
    public static DataTransactionResult failNoData() {
        return DataTransactionResult.FAIL_NODATA;
    }

    /**
     * Creates a new {@link DataTransactionResult} that ends in failure. The
     * provided {@link Value.Immutable} is considered "incompatible" and was not
     * successfully added.
     *
     * @param value The value that was incompatible or errored
     * @return The new data transaction result
     */
    public static DataTransactionResult errorResult(final Value.Immutable<?> value) {
        return DataTransactionResult.builder().result(Type.ERROR).reject(value).build();
    }

    /**
     * The type of transaction result.
     */
    public enum Type {

        /**
         * The actual result of the operation is undefined, this probably
         * indicates that something went wrong with the operation that the
         * {@link Value} couldn't handle or didn't expect. The
         * state of the {@link Value} is undefined.
         */
        UNDEFINED,

        /**
         * The item data operation succeeded.
         */
        SUCCESS,

        /**
         * The {@link Value} operation failed for an
         * <em>expected</em> reason (such as the {@link Value} being
         * incompatible with the {@link DataHolder}. The condition of the
         * {@link Value} is unchanged.
         */
        FAILURE,

        /**
         * The {@link Value} operation failed because an
         * <em>unexpected</em> condition occurred. The state of the
         * {@link Value} is undefined.
         */
        ERROR,

        /**
         * An operation was cancelled by a third party (eg. a
         * {@link Value} event was cancelled). The condition of the
         * {@link Value} is unchanged.
         */
        CANCELLED,
        ;
    }

    final Type type;
    private final ImmutableList<Value.Immutable<?>> rejected;
    private final ImmutableList<Value.Immutable<?>> replaced;
    private final ImmutableList<Value.Immutable<?>> success;

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
        return this.getType() == Type.SUCCESS;
    }

    /**
     * If any {@link Value}s applied onto a {@link DataHolder} were
     * successful, they'll be stored in the given list.
     *
     * @return An immutable list of the values successfully offered
     */
    public List<Value.Immutable<?>> getSuccessfulData() {
        return this.success;
    }

    /**
     * If {@link Value.Mutable}s were supplied to the operation, this
     * collection will return any {@link Value.Immutable}s which were rejected
     * by the target {@link DataHolder}.
     *
     * @return Any data that was rejected from the operation
     */
    public List<Value.Immutable<?>> getRejectedData() {
        return this.rejected;
    }

    /**
     * If the operation replaced any {@link Value.Mutable}s, this returns a collection
     * of the replaced {@link Value.Immutable}s.
     *
     * @return Any data that was replaced
     */
    public List<Value.Immutable<?>> getReplacedData() {
        return this.replaced;
    }

    /**
     * If this result of {@link #isSuccessful()} returns {@code true},
     * the provided {@link Consumer} is called provided a list of all
     * "successful" data as retrieved from {@link #getSuccessfulData()}.
     *
     * @param consumer The consumer to call
     */
    public void ifSuccessful(final Consumer<List<Value.Immutable<?>>> consumer) {
        if (this.isSuccessful()) {
            consumer.accept(this.success);
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
    public <E extends Exception> void ifNotSuccessful(final Supplier<E> supplier) throws E {
        if (!this.isSuccessful()) {
            throw supplier.get();
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DataTransactionResult.class.getSimpleName() + "[", "]")
            .add("type=" + this.type)
            .add("rejected=" + this.rejected)
            .add("replaced=" + this.replaced)
            .add("success=" + this.success)
            .toString();
    }

    @Override
    public boolean equals(final @Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final DataTransactionResult that = (DataTransactionResult) o;
        return this.type == that.type
            && Objects.equals(this.rejected, that.rejected)
            && Objects.equals(this.replaced, that.replaced)
            && Objects.equals(this.success, that.success);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.rejected, this.replaced, this.success);
    }

    /**
     * A type of builder for building {@link DataTransactionResult}s. The common
     * use is for both implementations of {@link DataHolder}s, and various
     * {@link org.spongepowered.api.event.data.ChangeDataHolderEvent.ValueChange}s.
     */
    public static final class Builder implements CopyableBuilder<DataTransactionResult, Builder> {

        @MonotonicNonNull List<Value.Immutable<?>> rejected;
        @MonotonicNonNull List<Value.Immutable<?>> replaced;
        @MonotonicNonNull List<Value.Immutable<?>> successful;
        @MonotonicNonNull Type resultType;

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
            this.resultType = Objects.requireNonNull(type);
            return this;
        }

        /**
         * Adds the provided {@link Value.Immutable} to the {@link List} of
         * "replaced" {@link Value.Immutable}s. The replaced values are always
         * copied for every {@link DataTransactionResult} for referencing.
         *
         * @param value The value to replace
         * @return This builder, for chaining
         */
        public Builder replace(final Value.Immutable<?> value) {
            if (this.replaced == null) {
                this.replaced = new ArrayList<>();
            }
            this.replaced.add(Objects.requireNonNull(value));
            return this;
        }

        /**
         * Adds the provided {@link Value.Immutable}s to the {@link List} of
         * "replaced" {@link Value.Immutable}s. The replaced values are always
         * copied for every {@link DataTransactionResult} for referencing.
         *
         * @param values The values to replace
         * @return This builder, for chaining
         */
        public Builder replace(final Iterable<Value.Immutable<?>> values) {
            for (final Value.Immutable<?> value : values) {
                this.replace(Objects.requireNonNull(value));
            }
            return this;
        }

        /**
         * Adds the provided {@link Value.Immutable} to the {@link List} of
         * "rejected" {@link Value.Immutable}s. The rejected values are always
         * copied for every {@link DataTransactionResult} for referencing.
         *
         * @param value The values to reject
         * @return This builder, for chaining
         */
        public Builder reject(final Value.Immutable<?> value) {
            if (this.rejected == null) {
                this.rejected = new ArrayList<>();
            }
            this.rejected.add(Objects.requireNonNull(value));
            return this;
        }

        /**
         * Adds the provided {@link Value.Immutable}s to the {@link List} of
         * "rejected" {@link Value.Immutable}s. The rejected values are always
         * copied for every {@link DataTransactionResult} for referencing.
         *
         * @param values The values to reject
         * @return This builder, for chaining
         */
        public Builder reject(final Iterable<Value.Immutable<?>> values) {
            for (final Value.Immutable<?> value : values) {
                this.reject(Objects.requireNonNull(value));
            }
            return this;
        }

        /**
         * Adds the provided {@link Value.Immutable} to the {@link List} of
         * "successful" {@link Value.Immutable}s. The successful values are always
         * copied for every {@link DataTransactionResult} for referencing.
         *
         * @param value The value that was successfully provided
         * @return This builder, for chaining
         */
        public Builder success(final Value.Immutable<?> value) {
            if (this.successful == null) {
                this.successful = new ArrayList<>();
            }
            this.successful.add(Objects.requireNonNull(value));
            return this;
        }

        /**
         * Adds the provided {@link Value.Immutable}s to the {@link List} of
         * "successful" {@link Value.Immutable}s. The rejected values are always
         * copied for every {@link DataTransactionResult} for referencing.
         *
         * @param values The values that were successfully provided
         * @return This builder, for chaining
         */
        public Builder success(final Iterable<Value.Immutable<?>> values) {
            for (final Value.Immutable<?> value : values) {
                this.success(Objects.requireNonNull(value));
            }
            return this;
        }

        /**
         * Combines the currently building {@link DataTransactionResult} with the
         * one provided. Usually, this means that there is some merging of the
         * {@link Value.Immutable}s based on {@link Key}. If this builder already
         * has an {@link Value.Immutable} as being successfully offered, and the
         * provided result shows the same key as being rejected, the rejected
         * {@link Value.Immutable} will remain in the final result.
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
            final List<Value.Immutable<?>> newSuccessful = new ArrayList<>();
            final List<Value.Immutable<?>> newReplaced = new ArrayList<>();
            final List<Value.Immutable<?>> newRejected = new ArrayList<>();
            // Now let's handle the successful data
            if (this.successful != null) {
                dance:
                for (final Value.Immutable<?> value : this.successful) {
                    for (final Value.Immutable<?> rejected : result.getRejectedData()) {
                        if (value.getKey().equals(rejected.getKey())) {
                            newRejected.add(rejected);
                            continue dance;
                        }
                    }
                    for (final Value.Immutable<?> replaced : result.getReplacedData()) {
                        if (value.getKey().equals(replaced.getKey())) {
                            newReplaced.add(value);
                            continue dance;
                        }
                    }
                    for (final Value.Immutable<?> successful : result.getSuccessfulData()) {
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
                for (final Value.Immutable<?> value : this.replaced) {
                    for (final Value.Immutable<?> rejected : result.getRejectedData()) {
                        if (value.getKey().equals(rejected.getKey())) {
                            newRejected.add(rejected);
                            continue dance;
                        }
                    }
                    for (final Value.Immutable<?> replaced : result.getReplacedData()) {
                        if (value.getKey().equals(replaced.getKey())) {
                            newReplaced.add(value);
                            continue dance;
                        }
                    }
                    for (final Value.Immutable<?> successful : result.getSuccessfulData()) {
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
                for (final Value.Immutable<?> value : this.rejected) {
                    for (final Value.Immutable<?> rejected : result.getRejectedData()) {
                        if (value.getKey().equals(rejected.getKey())) {
                            newRejected.add(rejected);
                            continue dance;
                        }
                    }
                    for (final Value.Immutable<?> replaced : result.getReplacedData()) {
                        if (value.getKey().equals(replaced.getKey())) {
                            newReplaced.add(value);
                            continue dance;
                        }
                    }
                    for (final Value.Immutable<?> successful : result.getSuccessfulData()) {
                        if (value.getKey().equals(successful.getKey())) {
                            newSuccessful.add(successful);
                            continue dance;
                        }
                    }
                    newRejected.add(value);
                }
            }
            dance:
            for (final Value.Immutable<?> value : result.getSuccessfulData()) {
                for (final Value.Immutable<?> rejected : newRejected) {
                    if (value.getKey().equals(rejected.getKey())) {
                        continue dance;
                    }
                }
                for (final Value.Immutable<?> replaced : newReplaced) {
                    if (value.getKey().equals(replaced.getKey())) {
                        continue dance;
                    }
                }
                for (final Value.Immutable<?> successful : newSuccessful) {
                    if (value.getKey().equals(successful.getKey())) {
                        continue dance;
                    }
                }
                newSuccessful.add(value);
            }
            dance:
            for (final Value.Immutable<?> value : result.getRejectedData()) {
                for (final Value.Immutable<?> rejected : newRejected) {
                    if (value.getKey().equals(rejected.getKey())) {
                        continue dance;
                    }
                }
                for (final Value.Immutable<?> replaced : newReplaced) {
                    if (value.getKey().equals(replaced.getKey())) {
                        continue dance;
                    }
                }
                for (final Value.Immutable<?> successful : newSuccessful) {
                    if (value.getKey().equals(successful.getKey())) {
                        continue dance;
                    }
                }
                newRejected.add(value);
            }
            dance:
            for (final Value.Immutable<?> value : result.getReplacedData()) {
                for (final Value.Immutable<?> rejected : newRejected) {
                    if (value.getKey().equals(rejected.getKey())) {
                        continue dance;
                    }
                }
                for (final Value.Immutable<?> replaced : newReplaced) {
                    if (value.getKey().equals(replaced.getKey())) {
                        continue dance;
                    }
                }
                for (final Value.Immutable<?> successful : newSuccessful) {
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
         * {@link List}s of {@link Value.Immutable}s that are successfully
         * offered, {@link Value.Immutable}s that were replaced, and
         * {@link Value.Immutable}s that were rejected.
         *
         * @return The newly created transaction result
         */
        public DataTransactionResult build() {
            if (this.resultType == null) {
                throw new IllegalStateException("ResultType must be set!");
            }
            return new DataTransactionResult(this);
        }

        @Override
        public Builder from(final DataTransactionResult value) {
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
