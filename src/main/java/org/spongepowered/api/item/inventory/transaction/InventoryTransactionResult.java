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
package org.spongepowered.api.item.inventory.transaction;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.common.collect.ImmutableList;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

/**
 * An interface for data returned by inventory operations which encapsulates the
 * result of an attempted operation.
 */
public final class InventoryTransactionResult {

    /**
     * Begin building a new InventoryTransactionResult.
     *
     * @return A new builder
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Returns a builder which indicates that the transaction succeeded, but the
     * transaction result was no-op.
     *
     * @return A new transaction result
     */
    public static InventoryTransactionResult successNoTransactions() {
        return InventoryTransactionResult.builder().type(Type.SUCCESS).build();
    }

    /**
     * Returns a builder which indicates that the transaction failed, and the
     * transaction result was no-op.
     *
     * @return A new transaction result
     */
    public static InventoryTransactionResult failNoTransactions() {
        return InventoryTransactionResult.builder().type(Type.ERROR).build();
    }

    public enum Type {

        /**
         * The actual result of the operation is undefined, this probably
         * indicates that something went wrong with the operation that the
         * inventory couldn't handle or didn't expect. The state of the
         * inventory is undefined.
         */
        UNDEFINED,

        /**
         * The inventory operation succeeded.
         */
        SUCCESS,

        /**
         * The inventory operation failed for an <em>expected</em> reason (such
         * as the inventory being full or not accepting items of a supplied
         * type. The condition of the inventory is unchanged.
         */
        FAILURE,

        /**
         * The inventory operation failed because an <em>unexpected</em>
         * condition occurred. The state of the inventory is undefined.
         */
        ERROR,

        /**
         * An operation was cancelled by a third party (eg. an inventory event
         * was cancelled). The condition of the inventory is unchanged.
         */
        CANCELLED
        
    }

    final Type type;
    private final List<ItemStackSnapshot> rejected;
    private final List<ItemStackSnapshot> replaced;

    InventoryTransactionResult(Builder builder) {
        this.type = checkNotNull(builder.resultType, "Result type");
        this.rejected = builder.rejected != null ? ImmutableList.copyOf(builder.rejected) : Collections.emptyList();
        this.replaced = builder.replaced != null ? ImmutableList.copyOf(builder.replaced) : Collections.emptyList();
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
     * If items were supplied to the operation, this collection will return any
     * items which were rejected by the target inventory.
     *
     * @return any items which were rejected as part of the inventory operation
     */
    public Collection<ItemStackSnapshot> getRejectedItems() {
        return this.rejected;
    }

    /**
     * If the operation replaced items in the inventory, this collection returns
     * the ItemStacks which were replaced.
     *
     * @return any items which were ejected as part of the inventory operation
     */
    public Collection<ItemStackSnapshot> getReplacedItems() {
        return this.replaced;
    }

    public static final class Builder implements ResettableBuilder<InventoryTransactionResult, Builder> {

        @Nullable Type resultType;
        @Nullable List<ItemStackSnapshot> rejected;
        @Nullable List<ItemStackSnapshot> replaced;

        Builder() {}

        /**
         * Sets the {@link Type} of transaction result being built.
         *
         * @param type The type of transaction result
         * @return This builder, for chaining
         */
        public Builder type(final Type type) {
            this.resultType = checkNotNull(type, "Type cannot be null!");
            return this;
        }

        /**
         * Adds the provided {@link ItemStack itemstacks} as stacks that have been
         * "rejected".
         *
         * @param itemStacks The itemstacks being rejected
         * @return This builder, for chaining
         */
        public Builder reject(ItemStack... itemStacks) {
            if (this.rejected == null) {
                this.rejected = new ArrayList<>();
            }
            for (ItemStack itemStack1 : itemStacks) {
                if (itemStack1 != null) {
                    this.rejected.add(itemStack1.createSnapshot());
                }
            }
            return this;
        }

        /**
         * Adds the provided {@link ItemStack itemstacks} as stacks that are
         * being replaced.
         *
         * @param itemStacks The itemstacks being replaced
         * @return This builder, for chaining
         */
        public Builder replace(ItemStack... itemStacks) {
            if (this.replaced == null) {
                this.replaced = new ArrayList<>();
            }
            for (ItemStack itemStack1 : itemStacks) {
                if (itemStack1 != null) {
                    this.replaced.add(itemStack1.createSnapshot());
                }
            }
            return this;
        }

        /**
         * Creates a new {@link InventoryTransactionResult}.
         *
         * @return A new inventory transaction result
         */
        public InventoryTransactionResult build() {
            checkState(this.resultType != null, "ResultType cannot be null!");
            return new InventoryTransactionResult(this);
        }

        @Override
        public Builder from(InventoryTransactionResult value) {
            checkNotNull(value, "InventoryTransactionResult cannot be null!");
            this.resultType = checkNotNull(value.type, "ResultType cannot be null!");
            this.replaced = new ArrayList<>(value.getReplacedItems());
            this.rejected = new ArrayList<>(value.getRejectedItems());
            return this;
        }

        @Override
        public Builder reset() {
            this.resultType = null;
            this.rejected = null;
            this.replaced = null;
            return this;
        }

    }
}
