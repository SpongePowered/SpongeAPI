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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.query.QueryOperation;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * A transformation can filter and order an inventory.
 *
 * <p>See {@link InventoryTransformations} for some predefined
 * transformations</p>
 *
 * <p>Transformations built from the {@link Builder} use a combination of
 * {@link Inventory#query(QueryOperation[])} and
 * {@link Inventory#union(Inventory)}. Thus the transformed inventory will
 * consist of only slots and will never contain duplicate slots.</p>
 */
public interface InventoryTransformation {

    /**
     * Transforms an Inventory
     *
     * @param inventory The inventory to transform
     *
     * @return The transformed inventory
     */
    Inventory transform(Inventory inventory);

    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Creates a new transformation based on QueryOperations.
     *
     * @param operations The QueryOperations
     *
     * @return The new transformation
     */
    @SuppressWarnings("rawtypes")
    static InventoryTransformation of(QueryOperation... operations) {
        if (operations.length == 0) {
            return InventoryTransformations.NO_OP;
        }
        return builder().append(operations).build();
    }

    interface Builder extends ResettableBuilder<InventoryTransformation, Builder> {

        /**
         * Appends one or more {@link QueryOperation}s
         *
         * @param operation The operations to add
         *
         * @return Fluent pattern
         */
        @SuppressWarnings("rawtypes")
        Builder append(QueryOperation... operation);

        /**
         * Builds the transformation
         *
         * @return The built transformation
         */
        InventoryTransformation build();

    }
}
