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

import com.google.common.base.Predicate;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockTransaction;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.event.impl.AbstractChangeBlockEvent;
import org.spongepowered.api.event.world.TargetWorldEvent;
import org.spongepowered.api.eventgencore.annotation.ImplementedBy;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.List;

/**
 * Base event for when {@link BlockState}s at {@link Location<World>}s are being
 * changed.
 */
@ImplementedBy(AbstractChangeBlockEvent.class)
public interface ChangeBlockEvent extends TargetWorldEvent, Cancellable, CauseTracked {

    /**
     * Gets a list of the {@link BlockTransaction}s for this event. If a
     * transaction is requested to be marked as "invalid",
     * {@link BlockTransaction#setIsValid(boolean)} can be used.
     *
     * @return The unmodifiable list of transactions
     */
    List<BlockTransaction> getTransactions();

    /**
     * Applies the provided {@link Predicate} to the {@link List} of
     * {@link BlockTransaction}s from {@link #getTransactions()} such that
     * any time that {@link Predicate#apply(Object)} returns <code>false</code>
     * on a {@link BlockTransaction}, the {@link BlockTransaction} is
     * marked as "invalid" and will not apply post event.
     *
     * @param predicate The predicate to use for filtering
     * @return The filtered transactions
     */
    List<BlockTransaction> filter(Predicate<Location<World>> predicate);

}
