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
package org.spongepowered.api.block.transaction;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.Queries;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * A specialized {@link Transaction Transaction&lt;BlockSnapshot&gt;} that covers
 * the required changes of one {@link BlockSnapshot} to another, with the added benefit
 * of a contextual understanding of what sort of {@link Operation operation} is being
 * performed to change from one block to another. It is possible to serialize a
 * particular transaction, but to associate a transaction with it's "post" state, refer
 * to {@link BlockTransactionReceipt the receipt variant} that exposes only what
 * was and what is the final result.
 */
public final class BlockTransaction extends Transaction<BlockSnapshot> {

    private final Operation operation;

    public BlockTransaction(final BlockSnapshot original, final BlockSnapshot defaultReplacement,
        final Operation operation
    ) {
        super(original, defaultReplacement);
        this.operation = operation;
    }

    public BlockTransaction(final BlockSnapshot original, final BlockSnapshot defaultReplacement,
        final @Nullable List<? extends BlockSnapshot> intermediary,
        final Operation operation
    ) {
        super(original, defaultReplacement, intermediary);
        this.operation = operation;
    }

    public Operation operation() {
        return this.operation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.operation);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        final BlockTransaction other = (BlockTransaction) obj;
        return Objects.equals(this.original(), other.original())
            && Objects.equals(this.defaultReplacement(), other.defaultReplacement())
            && this.isValid() == other.isValid()
            && Objects.equals(this.custom(), other.custom())
            && Objects.equals(this.operation, other.operation);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BlockTransaction.class.getSimpleName() + "[", "]")
            .add("operation=" + this.operation)
            .add("original=" + this.original())
            .add("default=" + this.defaultReplacement())
            .add("custom=" + this.custom())
            .add("valid=" + this.isValid())
            .toString();
    }

    @Override
    public int contentVersion() {
        return 1;
    }

    @Override
    public DataContainer toContainer() {
        return super.toContainer().set(Queries.BLOCK_OPERATION, this.operation);
    }
}
