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
package org.spongepowered.api.event.inventory;

import com.google.common.collect.Lists;
import org.spongepowered.api.block.BlockTransaction;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackTransaction;

import java.util.List;
import java.util.function.Predicate;

/**
 * Fired when {@link ItemStack}s are generated into a {@link Inventory}
 */
public interface AffectItemStackEvent extends TargetInventoryEvent, Cancellable, CauseTracked {

    /**
     * Gets a list of the {@link ItemStackTransaction}s for this event. If a
     * transaction is requested to be marked as "invalid",
     * {@link ItemStackTransaction#setIsValid(boolean)} can be used.
     *
     * @return The unmodifiable list of transactions
     */
    List<ItemStackTransaction> getTransactions();

    /**
     * Applies the provided {@link Predicate} to the {@link List} of
     * {@link ItemStackTransaction}s from {@link #getTransactions()} such that
     * any time that {@link Predicate#test(Object)} returns <code>false</code>
     * on a {@link ItemStackTransaction}, the {@link ItemStackTransaction} is
     * marked as "invalid" and will not apply post event.
     *
     * <p>{@link ItemStackTransaction#getSnapshot()} is used to construct
     * the {@link ItemStack} to pass to the predicate</p>
     *
     * @param predicate The predicate to use for filtering
     * @return The transactions for which the predicate returned <code>false</code>
     */
    default List<ItemStackTransaction> filter(Predicate<ItemStack> predicate) {
        List<ItemStackTransaction> invalidatedTransactions = Lists.newArrayList();
        for (ItemStackTransaction transaction: this.getTransactions()) {
            if (!predicate.test(transaction.getSnapshot().createStack())) {
                transaction.setIsValid(false);
                invalidatedTransactions.add(transaction);
            }
        }
        return invalidatedTransactions;
    }

}
