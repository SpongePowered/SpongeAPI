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

package org.spongepowered.api.item.inventory;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;
import com.google.common.base.Optional;

import javax.annotation.Nullable;

/**
 * A transaction of an {@link ItemStack} being offered to something. Normally,
 * this is useful for events where an {@link ItemStack} is being used in an
 * {@link ItemStackSnapshot} at which the outcome of the {@link ItemStack}
 * being used can be "invalidated" or changed.
 */
public final class ItemStackTransaction {

    private final ItemStackSnapshot snapshot;
    private boolean valid = true;
    @Nullable private ItemStackSnapshot custom;

    public ItemStackTransaction(ItemStackSnapshot snapshot) {
        this.snapshot = checkNotNull(snapshot);
    }

    /**
     * Gets the original {@link ItemStackSnapshot} proposed for use, this
     * is considered the "default" in {@link #getFinalSnapshot()} if the
     * custom snapshot is <code>null</code>.
     *
     * @return The original proposed snapshot
     */
    public ItemStackSnapshot getSnapshot() {
        return this.snapshot;
    }

    /**
     * Gets the custom {@link ItemStackSnapshot} for the proposed offer. If
     * the custom {@link ItemStackSnapshot} is <code>null</code>,
     * {@link Optional#absent()} is returned.
     *
     * @return The optional item stack snapshot
     */
    public Optional<ItemStackSnapshot> getCustom() {
        return Optional.fromNullable(this.custom);
    }

    /**
     * Sets the custom {@link ItemStackSnapshot} to be used in
     * {@link #getFinalSnapshot()}. If set to <code>null</code>, the
     * {@link #getSnapshot()} will be used instead.
     *
     * @param custom The custom snapshot
     */
    public void setCustom(@Nullable ItemStackSnapshot custom) {
        this.custom = custom;
    }

    /**
     * Gets the final {@link ItemStackSnapshot} to be used. If there is a valid
     * custom {@link ItemStackSnapshot}, it will be used, otherwise, the
     * original {@link #getSnapshot()} will be returned.
     *
     * @return The final proposed item stack snapshot
     */
    public ItemStackSnapshot getFinalSnapshot() {
        return this.custom == null ? this.snapshot : this.custom;
    }

    /**
     * Gets whether this transaction is considered "valid". If
     * <code>false</code> is returned, the transaction is not "valid".
     *
     * @return Whether this transaction is valid or not
     */
    public boolean isValid() {
        return this.valid;
    }

    /**
     * Sets whether this transaction is "valid" or not.
     *
     * @param valid Whether this transaction is valid or not
     */
    public void setIsValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.snapshot, this.valid, this.custom);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ItemStackTransaction other = (ItemStackTransaction) obj;
        return Objects.equal(this.snapshot, other.snapshot)
               && Objects.equal(this.valid, other.valid)
               && Objects.equal(this.custom, other.custom);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
            .add("snapshot", this.snapshot)
            .add("valid", this.valid)
            .add("custom", this.custom)
            .toString();
    }
}
