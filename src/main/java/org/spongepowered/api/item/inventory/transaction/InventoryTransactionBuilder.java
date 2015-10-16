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

import org.spongepowered.api.item.inventory.ItemStack;

import java.util.Collection;
import java.util.Optional;

public final class InventoryTransactionBuilder {
    private InventoryTransactionResult.Type resultType;

    private InventoryTransactionBuilder() {}

    public static InventoryTransactionBuilder builder() {
        return new InventoryTransactionBuilder();
    }

    public static InventoryTransactionResult successNoTransactions() {
        return builder().result(InventoryTransactionResult.Type.SUCCESS).build();
    }

    public static InventoryTransactionResult failNoTransactions() {
        return builder().result(InventoryTransactionResult.Type.ERROR).build();
    }

    public InventoryTransactionBuilder result(final InventoryTransactionResult.Type type) {
        this.resultType = checkNotNull(type);
        return this;
    }

    public InventoryTransactionResult build() {
        checkState(this.resultType != null);
        return new BuilderResult(this);
    }

    private static final class BuilderResult implements InventoryTransactionResult {
        private final Type type;

        public BuilderResult(InventoryTransactionBuilder builder) {
            this.type = builder.resultType;
        }

        @Override
        public Type getType() {
            return type;
        }

        @Override
        public Optional<Collection<ItemStack>> getRejectedItems() {
            return Optional.empty();
        }

        @Override
        public Optional<Collection<ItemStack>> getReplacedItems() {
            return Optional.empty();
        }
    }
}
