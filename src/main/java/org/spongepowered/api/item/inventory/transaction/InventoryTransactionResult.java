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
import java.util.List;

/**
 * An interface for structs returned by inventory operations which encapsulate
 * the result of an attempted operation.
 */
public final class InventoryTransactionResult {

    public static Builder builder() {
        return new Builder();
    }

    public static InventoryTransactionResult successNoTransactions() {
        return builder().result(Type.SUCCESS).build();
    }

    public static InventoryTransactionResult failNoTransactions() {
        return builder().result(Type.ERROR).build();
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

    private final Type type;
    private final ImmutableList<ItemStackSnapshot> rejected;
    private final ImmutableList<ItemStackSnapshot> replaced;

    private InventoryTransactionResult(Builder builder) {
        this.type = builder.resultType;
        this.rejected = ImmutableList.copyOf(builder.rejected);
        this.replaced = ImmutableList.copyOf(builder.replaced);
    }

    /**
     * Get the type of result.
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

    public static final class Builder implements ResettableBuilder<Builder> {
        private Type resultType;
        private List<ItemStackSnapshot> rejected;
        private List<ItemStackSnapshot> replaced;

        private Builder() {}

        public Builder result(final Type type) {
            this.resultType = checkNotNull(type);
            return this;
        }

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

        public InventoryTransactionResult build() {
            checkState(this.resultType != null);
            return new InventoryTransactionResult(this);
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
