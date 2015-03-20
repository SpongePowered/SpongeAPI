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
package org.spongepowered.api.block.tile.carrier;

import com.google.common.base.Optional;
import org.spongepowered.api.Nameable;
import org.spongepowered.api.block.tile.TileDataTransactionResult;
import org.spongepowered.api.block.tile.TileEntity;
import org.spongepowered.api.block.tile.data.LockableData;
import org.spongepowered.api.block.tile.data.NameableData;
import org.spongepowered.api.item.inventory.Carrier;
import org.spongepowered.api.item.inventory.types.TileEntityInventory;

import javax.annotation.Nullable;

/**
 * Represents a {@link TileEntity} that is a carrier of {@link
 * TileEntityInventory}. Adding to the inventory, a {@link TileEntityCarrier}
 * may also have {@link NameableData} and {@link LockableData}.
 *
 * <p>Additional information regarding the {@link TileEntityCarrier} is
 * dependent on the {@link TileEntity} itself.</p>
 */
public interface TileEntityCarrier extends TileEntity, Carrier {

    /**
     * Gets the current {@link LockableData} for this carrier.
     *
     * <p>{@link LockableData} represents that this {@link TileEntityCarrier}
     * may be opened only by a matching lock token. The {@link LockableData}
     * may not exist by default.</p>
     *
     * @return The lockable data, if available
     */
    Optional<LockableData> getLockableData();

    /**
     * Sets the current {@link LockableData} for this carrier. Setting to null
     * removes the current {@link LockableData}, if it is present.
     *
     * <p>{@link LockableData} represents that this {@link TileEntityCarrier}
     * may be opened only by a matching lock token. The {@link LockableData}
     * may not exist by default.</p>
     *
     * @param data The lockable data
     * @return The transaction result
     */
    TileDataTransactionResult setLockableData(@Nullable LockableData data);

    /**
     * Gets the current {@link NameableData} for this carrier.
     *
     * <p>{@link NameableData} represents that this {@link TileEntityCarrier}
     * may have an alternate name displayed when used by a player or in chat.
     * The name data may not exist by default.</p>
     *
     * @return The nameable data, if available
     */
    Optional<Nameable> getNameableData();

    /**
     * Sets the current {@link NameableData} for this carrier. Setting to null
     * removes the current {@link NameableData}, if it is present.
     *
     * <p>{@link NameableData} represents that this {@link TileEntityCarrier}
     * may have an alternate name displayed when used by a player or in chat.
     * The name data may not exist by default.</p>
     *
     * @param data The nameable data
     * @return The transaction result
     */
    TileDataTransactionResult setNameableData(@Nullable NameableData data);

    @Override
    TileEntityInventory<TileEntityCarrier> getInventory();
}
