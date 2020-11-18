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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.persistence.Queries;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Transaction<T extends DataSerializable> implements DataSerializable {

    private final T original;
    private final T defaultReplacement;
    private boolean valid = true;
    @Nullable private final List<T> intermediary;
    @Nullable private T custom;

    /**
     * Creates a new transaction.
     *
     * @param original The original object being replaced
     * @param defaultReplacement The default replacement
     */
    public Transaction(T original, T defaultReplacement) {
        this.original = Objects.requireNonNull(original);
        this.defaultReplacement = Objects.requireNonNull(defaultReplacement);
        this.intermediary = null;
    }

    /**
     * Creates a new {@link Transaction} with the added possibility of
     * <i>intermediary</i> transactions that may have taken place between
     * what is {@link #getOriginal() original} and {@link #getDefault()
     * the default result}. The list may be {@code null}, however the list
     * will wrapped to become an unmodifiable list.
     *
     * <p>It is imperative that the provided list is not to be modified
     * outside this created {@link Transaction} synchronously and
     * asynchronously as consumers of the provided list will not be able
     * to react accordingly.</p>
     *
     * @param original The original
     * @param defaultReplacement The replacement
     * @param intermediary The intermediary results
     */
    public Transaction(T original, T defaultReplacement, @Nullable List<? extends T> intermediary) {
        this.original = Objects.requireNonNull(original, "Original cannot be null");
        this.defaultReplacement = Objects.requireNonNull(defaultReplacement, "Default replacement cannot be null");
        this.intermediary = intermediary == null ? null : Collections.unmodifiableList(intermediary);
    }

    /**
     * Gets the original snapshot.
     *
     * @return The original snapshot
     */
    public final T getOriginal() {
        return this.original;
    }

    /**
     * Gets the default replacement snapshot.
     *
     * @return The default replacement
     */
    public final T getDefault() {
        return this.defaultReplacement;
    }

    /**
     * Gets a {@link List} of any and all intermediary transactions that may
     * have taken place to get the final {@link Transaction} of
     * {@link #getOriginal() the original} and {@link #getDefault() the default}
     * results. This is exposed for monitoring purposes only, as the provided
     * list is not modifiable. The list may be {@link List#isEmpty() empty}
     * by default, but will never be {@code null}.
     *
     * <p>Note that special processing with this list may sometimes only take
     * place if {@link #getCustom() a custom} result has not been set by a plugin,
     * or if {@link #isValid()} returns {@code false}.</p>
     *
     * @return The intermediary list of transactions
     */
    public final List<? extends T> getIntermediary() {
        return this.intermediary == null ? Collections.emptyList() : this.intermediary;
    }

    /**
     * Gets the custom snapshot if one was set.
     *
     * @return The custom snapshot, if available
     */
    public final Optional<T> getCustom() {
        return Optional.ofNullable(this.custom);
    }

    /**
     * Sets the custom snapshot. If setting <code>null</code>, this will
     * reset to use the {@link #getDefault()} snapshot.
     *
     * @param custom The custom snapshot
     */
    public final void setCustom(@Nullable T custom) {
        this.custom = custom;
    }

    /**
     * Gets the proposed final snapshot, if the {@link #getCustom()} returns
     * {@link Optional#isPresent()}, the custom is returned, otherwise,
     * {@link #getDefault()} is returned.
     *
     * @return The proposed final snapshot
     */
    public final T getFinal() {
        return this.custom == null ? this.defaultReplacement : this.custom;
    }

    /**
     * Gets whether this transaction is marked as valid.
     *
     * @return The valid state of this transaction
     */
    public final boolean isValid() {
        return this.valid;
    }

    /**
     * Sets whether this transaction is valid or not.
     *
     * @param valid The valid state of this transaction
     */
    public final void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.original, this.defaultReplacement, this.valid, this.custom);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Transaction other = (Transaction) obj;
        return Objects.equals(this.original, other.original)
               && Objects.equals(this.defaultReplacement, other.defaultReplacement)
               && Objects.equals(this.valid, other.valid)
               && Objects.equals(this.custom, other.custom);
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("original", this.original)
                .add("default", this.defaultReplacement)
                .add("custom", this.custom)
                .add("valid", this.valid)
                .toString();
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public DataContainer toContainer() {
        final DataContainer container = DataContainer.createNew()
            .set(Queries.CONTENT_VERSION, getContentVersion())
            .set(Queries.TYPE_CLASS, this.original.getClass().getName())
            .set(Queries.ORIGINAL, this.original)
            .set(Queries.DEFAULT_REPLACEMENT, this.defaultReplacement)
            .set(Queries.VALID, this.valid);
        if (this.custom != null) {
            container.set(Queries.CUSTOM_REPLACEMENT, this.custom);
        }
        return container;
    }
}
