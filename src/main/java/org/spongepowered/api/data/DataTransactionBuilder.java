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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.event.data.ChangeDataHolderEvent;

import java.util.Collection;
import java.util.List;

/**
 * A type of builder for building {@link DataTransactionResult}s. The common
 * use is for both implementations of {@link DataHolder}s, and various
 * {@link ChangeDataHolderEvent.ValueChange}s.
 */
public final class DataTransactionBuilder {

    private List<ImmutableValue<?>> rejected;
    private List<ImmutableValue<?>> replaced;
    private List<ImmutableValue<?>> successful;
    private DataTransactionResult.Type resultType;

    private DataTransactionBuilder() {
    }

    /**
     * Gets a new {@link DataTransactionBuilder} to build a new
     * {@link DataTransactionResult}.
     *
     * @return The new builder, for chaining
     */
    public static DataTransactionBuilder builder() {
        return new DataTransactionBuilder();
    }

    /**
     * Creates a {@link DataTransactionResult} with no data successfully added,
     * removed, or rejected, and with the
     * {@link org.spongepowered.api.data.DataTransactionResult.Type} of
     * {@link org.spongepowered.api.data.DataTransactionResult.Type#SUCCESS}
     * result type.
     *
     * @return A clean and empty data transaction
     */
    public static DataTransactionResult successNoData() {
        return builder().result(DataTransactionResult.Type.SUCCESS).build();
    }

    /**
     * Creates a new {@link DataTransactionResult} with the provided
     * {@link ImmutableValue} being the successful addition. The result type is
     * still {@link DataTransactionResult.Type#SUCCESS}. If a {@link Value} is
     * necessary, use {@link Value#asImmutable()} to use this method. A
     * {@link DataTransactionResult} is always immutable once created, and any
     * {@link BaseValue}s should be provided as {@link ImmutableValue}s or
     * transformed into {@link ImmutableValue}s.
     *
     * @param value The successfully added immutable value
     * @return The new data transaction result
     */
    public static DataTransactionResult successResult(final ImmutableValue<?> value) {
        return builder().success(value).result(DataTransactionResult.Type.SUCCESS).build();
    }

    /**
     * Creates a new {@link DataTransactionResult} with the provided
     * {@link ImmutableValue} being the successful addition. The result type is
     * still {@link DataTransactionResult.Type#SUCCESS}. If a {@link Value} is
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
        return builder().result(DataTransactionResult.Type.SUCCESS).success(successful).replace(replaced).build();
    }

    /**
     * Creates a new {@link DataTransactionResult} with the provided
     * {@link ImmutableValue}s being the successful additions and
     * the provided {@link ImmutableValue}s that were replaced. The result type
     * is still {@link DataTransactionResult.Type#SUCCESS}. If a {@link Value}
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
        return builder().success(successful).replace(replaced).result(DataTransactionResult.Type.SUCCESS).build();
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
        return builder().reject(value).result(DataTransactionResult.Type.FAILURE).build();
    }

    /**
     * Creates a new {@link DataTransactionResult} that ends in failure. The
     * provided {@link ImmutableValue}s are considered "rejected" and were not
     * successfully added.
     *
     * @param values The values that were rejected
     * @return The new data transaction result
     */
    public static DataTransactionResult failResult(final ImmutableValue<?>... values) {
        return builder().reject(values).result(DataTransactionResult.Type.FAILURE).build();
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
        return builder().reject(values).result(DataTransactionResult.Type.FAILURE).build();
    }

    /**
     * Creates a new {@link DataTransactionResult} that ends in failure. There
     * is no additional data to include.
     *
     * @return The new data transaction result
     */
    public static DataTransactionResult failNoData() {
        return builder().result(DataTransactionResult.Type.FAILURE).build();
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
        return builder().result(DataTransactionResult.Type.ERROR).reject(value).build();
    }

    /**
     * Sets the expectant {@link DataTransactionResult.Type} to the provided
     * type. A {@link DataTransactionResult} must always have a type to mark
     * the transaction a "success" or "failure".
     *
     * @param type The type of the transaction result
     * @return This builder, for chaining
     */
    public DataTransactionBuilder result(final DataTransactionResult.Type type) {
        this.resultType = checkNotNull(type);
        return this;
    }

    /**
     * Adds the provided {@link ImmutableValue} to the {@link List} of
     * "replaced" {@link ImmutableValue}s. The replaced values are always
     * copied for every {@link DataTransactionResult} for referencing. It is
     * also possible ot retrieve these replaced {@link ImmutableValue}s to
     * {@link DataHolder#undo(DataTransactionResult)} at a later point in
     * the lifespan of the {@link DataHolder}.
     *
     * @param value The value to replace
     * @return This builder, for chaining
     */
    public DataTransactionBuilder replace(final ImmutableValue<?> value) {
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
    public DataTransactionBuilder replace(final ImmutableValue<?> value, final ImmutableValue<?>... values) {
        replace(checkNotNull(value));
        for (ImmutableValue<?> additional : values) {
            replace(checkNotNull(additional));
        }
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
    public DataTransactionBuilder replace(final Collection<ImmutableValue<?>> values) {
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
    public DataTransactionBuilder reject(final ImmutableValue<?> value) {
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
    public DataTransactionBuilder reject(final ImmutableValue<?>... values) {
        for (ImmutableValue<?> value : values) {
            reject(checkNotNull(value));
        }
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
    public DataTransactionBuilder reject(final Iterable<ImmutableValue<?>> values) {
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
    public DataTransactionBuilder success(final ImmutableValue<?> value) {
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
    public DataTransactionBuilder success(final ImmutableValue<?>... values) {
        for (ImmutableValue<?> value : values) {
            success(checkNotNull(value));
        }
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
    public DataTransactionBuilder success(final Iterable<ImmutableValue<?>> values) {
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
    public DataTransactionBuilder absorbResult(final DataTransactionResult result) {
        // First, let's handle the type:
        if (this.resultType == null) {
            this.resultType = result.getType();
        } else {
            if (this.resultType != DataTransactionResult.Type.SUCCESS && result.getType() == DataTransactionResult.Type.SUCCESS) {
                this.resultType = result.getType();
            }
        }
        final List<ImmutableValue<?>> newSuccessful = Lists.newArrayList();
        final List<ImmutableValue<?>> newReplaced = Lists.newArrayList();
        final List<ImmutableValue<?>> newRejected = Lists.newArrayList();
        // Now let's handle the successful data

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
        return new BuilderResult(this);
    }

    private static final class BuilderResult implements DataTransactionResult {

        private final Type type;
        private final ImmutableList<ImmutableValue<?>> rejected;
        private final ImmutableList<ImmutableValue<?>> replaced;
        private final ImmutableList<ImmutableValue<?>> success;

        BuilderResult(final DataTransactionBuilder builder) {
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

        @Override
        public Type getType() {
            return this.type;
        }

        @Override
        public ImmutableList<ImmutableValue<?>> getSuccessfulData() {
            return this.success;
        }

        @Override
        public ImmutableList<ImmutableValue<?>> getRejectedData() {
            return this.rejected;
        }

        @Override
        public ImmutableList<ImmutableValue<?>> getReplacedData() {
            return this.replaced;
        }
    }

}
