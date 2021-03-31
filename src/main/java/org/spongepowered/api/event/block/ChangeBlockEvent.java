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
package org.spongepowered.api.event.block;

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.block.transaction.BlockTransaction;
import org.spongepowered.api.block.transaction.BlockTransactionReceipt;
import org.spongepowered.api.block.transaction.Operation;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Plain event for when one or many {@link BlockState BlockStates} may be
 * changing within a {@link org.spongepowered.api.world.server.ServerWorld}.
 * Ideally, the {@link All#transactions()} will contain a full list in order
 * of which the changes are taking place, but the overall list may not be the
 * full breadth of what changes take place during some complex operations. To
 * record the entirety of all transactions taking place, {@link Post} provides
 * additional aide with knowing which {@link BlockTransactionReceipt}s are
 * recorded in a particluar {@link org.spongepowered.api.world.server.ServerWorld}
 * without the additional cost of having multiple events thrown throughout.
 * <p>To determine whether a particular {@link BlockTransaction} is a
 * {@code break}, {@code place}, {@code modify}, etc. please refer to the
 * {@link BlockTransaction#operation()}</p>
 */
public interface ChangeBlockEvent extends Event {

    /**
     * Gets the world this event is affecting.
     *
     * @return The world encompassing these block changes
     */
    ServerWorld world();

    /**
     * Called before running specific block logic at one or more 
     * {@link ServerLocation}'s such as {@link BlockTypes#WATER}.
     */
    interface Pre extends ChangeBlockEvent, Cancellable {

        /**
         * Represents a list of one or more {@link ServerLocation}'s where
         * {@link BlockState} changes can occur.
         *
         * <p>Canceling this event will prevent block logic from running
         * and also stop {@link BlockSnapshot}'s from being generated.</p>
         *
         * <p>Note: This event is not intended to always be fired before
         * changing a {@link BlockState} but rather it is primarily used to
         * prevent one or more {@link BlockState}'s from being changed.</p>
         *
         * @return The immutable list of one or more locations that can change
         */
        List<ServerLocation> locations();
    }

    interface All extends ChangeBlockEvent, Cancellable {

        /**
         * Gets a list of the {@link Transaction}s for this event. If a
         * transaction is requested to be marked as "invalid",
         * {@link Transaction#setValid(boolean)} can be used.
         *
         * @return The unmodifiable list of transactions
         */
        List<BlockTransaction> transactions();

        /**
         * Gets a {@link Stream} of {@link BlockTransaction BlockTransactions}
         * filtered by a particular {@link Operation block operation}. The difference
         * between this and {@link #transactions()} is that while the general transactions
         * is still an ordered {@link List}, this is a filtered stream of that list, equally
         * unmodifiable. The {@link BlockTransaction transactions} themselves are still
         * modifiable with {@code BlockTransaction#setCustom(BlockSnapshot)}, but altering
         * the customized snapshot will <strong>NOT</strong> alter the {@link Operation}
         * being performed. As a logical perspective, there is no functional difference
         * between any two {@link Operation operations}, but it can be important to
         * differentiate between the two in some contexts.
         *
         * @param operation The operation being performed
         * @return The stream filtering on the given operation, may be empty
         */
        default Stream<BlockTransaction> transactions(final Operation operation) {
            Objects.requireNonNull(operation, "Operation cannot be null");
            return this.transactions()
                .stream()
                .filter(transaction -> transaction.operation().equals(operation));
        }

        /**
         * Applies the provided {@link Predicate} to the {@link List} of
         * {@link Transaction}s from {@link #transactions()} such that
         * any time that {@link Predicate#test(Object)} returns {@code false}
         * on the location of the {@link Transaction}, the {@link Transaction} is
         * marked as "invalid" and will not apply post event.
         *
         * <p>{@link Transaction#original()} is used to get the {@link ServerLocation}</p>
         *
         * @param predicate The predicate to use for filtering
         * @return The transactions for which the predicate returned
         *     {@code false}
         */
        default List<BlockTransaction> invalidate(final Predicate<ServerLocation> predicate) {
            return this.transactions()
                .stream()
                .filter(blockTransaction -> {
                    if (!predicate.test(blockTransaction.original().location().get())) {
                        blockTransaction.setValid(false);
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());
        }

        /**
         * Invalidates the list as such that all {@link Transaction}s are
         * marked as "invalid" and will not apply post event.
         */
        default void invalidateAll() {
            this.transactions().forEach(BlockTransaction::invalidate);
        }
    }

    /**
     * Called when there are multiple block changes due to a
     * {@link BlockType} having "ticked", in which the {@link Cause} will
     * have a {@link BlockSnapshot}, or, in the case that an {@link Entity}
     * has "ticked", in which the {@link Cause} will have an {@link Entity},
     * or, in the case that a {@link BlockEntity} "ticked", the {@link Cause}
     * will have the {@link BlockEntity}.
     *
     * <p>The {@link Cause} may contain {@link Event}s, such as {@link All},
     * {@link NotifyNeighborBlockEvent}, and {@link Pre}. These events may be
     * cancelled, or have their transactions modified, just like normal events,
     * but this event is set in stone (pun intended) with regards to the
     * representative state the world is in. Any Post is considered the "truth"
     * of what happened, after all {@link All} events may have been thrown for
     * a particular cause, during some logic, so as to simplify how many
     * batched events need to be thrown compared to the work being performed.
     * </p>
     *
     * <p>For example, a piston extension would cause this event to be fired.
     * A piston extension involves multiple distinct transactions -
     * the piston head moving, and the adjacent block being set in a new
     * position.</p>
     *
     * <p>Note: This event is fired after processing all other
     * ChangeBlockEvent's.</p>
     */
    interface Post extends ChangeBlockEvent {

        List<BlockTransactionReceipt> receipts();

    }
}
