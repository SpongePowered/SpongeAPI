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

import com.google.common.collect.Lists;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.event.world.TargetWorldEvent;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.function.Predicate;

/**
 * Base event for when {@link BlockState}s at {@link Location<World>}s are being
 * changed.
 */
public interface ChangeBlockEvent extends TargetWorldEvent, Cancellable, CauseTracked {

    /**
     * Gets a list of the {@link Transaction}s for this event. If a
     * transaction is requested to be marked as "invalid",
     * {@link Transaction<BlockSnapshot>#setIsValid(boolean)} can be used.
     *
     * @return The unmodifiable list of transactions
     */
    List<Transaction<BlockSnapshot>> getTransactions();

    /**
     * Applies the provided {@link Predicate} to the {@link List} of
     * {@link Transaction}s from {@link #getTransactions()} such that
     * any time that {@link Predicate#test(Object)} returns <code>false</code>
     * on the location of the {@link Transaction}, the {@link Transaction} is
     * marked as "invalid" and will not apply post event.
     *
     * <p>{@link Transaction#getOriginal()} is used to get the {@link Location}</p>
     *
     * @param predicate The predicate to use for filtering
     * @return The transactions for which the predicate returned <code>false</code>
     */
    default List<Transaction<BlockSnapshot>> filter(Predicate<Location<World>> predicate) {
        List<Transaction<BlockSnapshot>> invalidatedTransactions = Lists.newArrayList();
        for (Transaction<BlockSnapshot> transaction: this.getTransactions()) {
            if (!predicate.test(transaction.getOriginal().getLocation().get())) {
                transaction.setValid(false);
                invalidatedTransactions.add(transaction);
            }
        }
        return invalidatedTransactions;
    }

    /**
     * Invalidates the list as such that all {@link Transaction}s are
     * marked as "invalid" and will not apply post event.
     */
    default void filterAll() {
        for (Transaction<BlockSnapshot> transaction: this.getTransactions()) {
            transaction.setValid(false);
        }
    }

    /**
     * Called when there are block changes due to a {@link BlockType}
     * having "ticked", in which the {@link Cause} will have a
     * {@link BlockSnapshot}, or, in the case that an {@link Entity}
     * has "ticked", in which the {@link Cause} will have an {@link Entity},
     * or, in the case that a {@link TileEntity} "ticked", the {@link Cause}
     * will have the {@link TileEntity}. Note that this event is fired before
     * processing a {@link Break} or {@link Place} event.
     *
     * <p>The idea is that  a block, entity, or tile entity "ticks" in which
     * during that "tick", they make a block change. If the block change is
     * purely "placing" of blocks, the {@link Place} event is thrown. If the
     * block changes are purely "breaking" of blocks, the {@link Break} event
     * is thrown.</p>
     */
    interface Post extends ChangeBlockEvent {}

    /**
     * Called when specific {@link BlockType}s have a notion of "decaying"
     * for various reasons such that the changes are always caused by
     * themselves. This is also called after a {@link Tick} event.
     */
    interface Decay extends Post {}

    /**
     * Called when a {@link BlockType} decides to "grow" either other
     * blocks or itself or both. Usually considered to be plants or crops,
     * this is called after a {@link Tick} event.
     */
    interface Grow extends Post {}

    /**
     * Called when {@link BlockState}s at {@link Location <World>}s are
     * being broke. This usually occurs, whenever a {@link BlockState} changes
     * to {@link BlockTypes#AIR}
     *
     * <p>Note: This does not include fluids. See ChangeBlockEvent#Fluid</p>
     */
    interface Break extends Post {}

    /**
     * Called when one or more {@link BlockType}s are added to the world.
     *
     * <p>Note: This does not include fluids. See ChangeBlockEvent#Fluid</p>
     */
    interface Place extends Post {}

    /**
     * Called when one or more {@link BlockType}s are modified in the world.
     *
     * <p>Note: This does not include fluids. See ChangeBlockEvent#Fluid</p>
     */
    interface Modify extends Post {}

    /**
     * Called when one or more {@link BlockType}s are affected in the
     * world by a fluid.
     */
    interface Fluid extends Post {}

}
