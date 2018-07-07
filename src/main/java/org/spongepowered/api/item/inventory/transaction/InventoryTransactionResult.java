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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.List;

/**
 * An interface for data returned by inventory operations which encapsulates the
 * result of an attempted operation.
 */
public interface InventoryTransactionResult {

    /**
     * Begin building a new InventoryTransactionResult.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }
    
    /**
     * Returns a builder which indicates that the transaction succeeded, but the
     * transaction result was no-op.
     *
     * @return A new transaction result
     */
    static InventoryTransactionResult successNoTransactions() {
        return InventoryTransactionResult.builder().type(Type.SUCCESS).build();
    }

    /**
     * Returns a builder which indicates that the transaction failed, and the
     * transaction result was no-op.
     *
     * @return A new transaction result
     */
    static InventoryTransactionResult failNoTransactions() {
        return InventoryTransactionResult.builder().type(Type.ERROR).build();
    }

    /**
     * The type of InventoryTransactionResult.
     */
    enum Type {

        /**
         * The inventory operation succeeded.
         *
         * <p>The state of the inventory may have changed.</p>
         */
        SUCCESS,

        /**
         * The inventory operation failed for an <em>expected</em> reason (such
         * as the inventory being full, not accepting items of a supplied type
         * or a third party fully or partially canceling the transactions.
         *
         * <p>The state of the inventory may have changed.</p>
         */
        FAILURE,

        /**
         * The inventory operation failed because an <em>unexpected</em>
         * condition occurred.
         *
         * <p>The state of the inventory is undefined.</p>
         */
        ERROR

    }

    /**
     * Combines two transaction-results into one. All slot-transactions and rejected items are combined.
     * The resulting type is the first of this list to occur: {@link Type#ERROR}, {@link Type#FAILURE}, {@link Type#SUCCESS}
     *
     * @param other The other transaction-result.
     * @return The combined transaction-result.
     */
    InventoryTransactionResult and(InventoryTransactionResult other);

    /**
     * Reverts all SlotTransactions from this transaction-result
     */
    void revert();

    /**
     * Reverts all SlotTransactions from this transaction-result if it was a {@link Type#FAILURE}
     */
    void revertOnFailure();

    /**
     * Gets the type of result.
     *
     * @return the type of result
     */
    Type getType();

    /**
     * If items were supplied to the operation, this collection will return any
     * items which were rejected by the target inventory.
     *
     * @return any items which were rejected as part of the inventory operation
     */
    List<ItemStackSnapshot> getRejectedItems();

    /**
     * If the operation replaced items in the inventory, this collection returns
     * the ItemStacks which were replaced.
     *
     * @return any items which were ejected as part of the inventory operation
     */
    List<SlotTransaction> getSlotTransactions();

    interface Builder extends ResettableBuilder<InventoryTransactionResult, Builder> {

        /**
         * Sets the {@link Type} of transaction result being built.
         *
         * @param type The type of transaction result
         * @return This builder, for chaining
         */
        Builder type(final Type type);

        /**
         * Adds the provided {@link ItemStack itemstacks} as stacks that have been
         * "rejected".
         *
         * @param itemStacks The itemstacks being rejected
         * @return This builder, for chaining
         */
        Builder reject(ItemStack... itemStacks);

        /**
         * Adds the provided {@link ItemStack itemstacks} as stacks that have been
         * "rejected".
         *
         * @param itemStacks The itemstacks being rejected
         * @return This builder, for chaining
         */
        Builder reject(Iterable<ItemStackSnapshot> itemStacks);


        /**
         * Adds the provided {@link ItemStack itemstacks} as stacks that are
         * being replaced.
         *
         * @param slotTransactions The slotTransactions
         * @return This builder, for chaining
         */
        Builder transaction(SlotTransaction... slotTransactions);

        /**
         * Adds the provided {@link ItemStack itemstacks} as stacks that are
         * being replaced.
         *
         * @param slotTransactions The slotTransactions
         * @return This builder, for chaining
         */
        Builder transaction(Iterable<SlotTransaction> slotTransactions);

        /**
         * Creates a new {@link InventoryTransactionResult}.
         *
         * @return A new inventory transaction result
         */
        InventoryTransactionResult build();
    }
}
