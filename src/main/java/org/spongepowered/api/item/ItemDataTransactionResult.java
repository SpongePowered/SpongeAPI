/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.item;

import com.google.common.base.Optional;
import org.spongepowered.api.item.data.ItemData;

import java.util.Collection;

/**
 * Represents a transaction result when either an {@link org.spongepowered.api.item.inventory.ItemStack}
 * or {@link ItemData} is changed. Item stacks sometimes require validation
 * for certain {@link ItemData} based on the properties of the item.
 */
public interface ItemDataTransactionResult {


    public enum Type {

        /**
         * The actual result of the operation is undefined, this probably
         * indicates that something went wrong with the operation that the
         * item data couldn't handle or didn't expect. The state of the
         * item data is undefined.
         */
        UNDEFINED,

        /**
         * The item data operation succeeded.
         */
        SUCCESS,

        /**
         * The item data operation failed for an <em>expected</em> reason (such
         * as the item data being incompatible with the item stack.
         * The condition of the item data is unchanged.
         */
        FAILURE,

        /**
         * The item data operation failed because an <em>unexpected</em>
         * condition occurred. The state of the item data is undefined.
         */
        ERROR,

        /**
         * An operation was cancelled by a third party (eg. an item data event
         * was cancelled). The condition of the item data is unchanged.
         */
        CANCELLED;
    }

    /**
     * Get the type of result.
     *
     * @return the type of result
     */
    Type getType();

    /**
     * If items were supplied to the operation, this collection will return any
     * items which were rejected by the target item stack.
     *
     * @return Any item data that was rejected from the operation
     */
    Optional<Collection<ItemData<?>>> getRejectedData();

    /**
     * If the operation replaced {@link ItemData}, this returns a collection of
     * the replaced {@link ItemData}.
     *
     * @return Any item data that were replaced
     */
    Optional<Collection<ItemData<?>>> getReplacedData();

}
