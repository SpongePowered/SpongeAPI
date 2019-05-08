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
package org.spongepowered.api.item.inventory.type;

import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.item.inventory.Carrier;
import org.spongepowered.api.item.inventory.Inventory;

import java.util.Optional;

/**
 * An {@link Inventory} which is owned by a
 * {@link BlockEntity}. In Sponge, a BE is never seen as an Inventory itself and
 * Block Entities are instead considered to "own" their own Inventory (much like
 * equipable entities do). Underlying implementations are of course completely
 * at liberty to return the BE object directly but as far as consumers are
 * concerned the BE instance and the inventory are separate things.
 *
 * <p>This is intended to provide a consistent way of dealing with inventories
 * regardless of the "owner" of the inventory. Thus, any code capable of dealing
 * with a {@link Carrier} is intrinsically able to deal with a BE inventory just
 * as they would with any Entity inventory or any other type of Carrier for that
 * matter.</p>
 *
 * <p>This separation of inventory logic from the BE itself also serves to
 * provide some flexibility for implementors, since it is possible that not all
 * implementations may take the view that a BE embodies its own inventory.</p>
 *
 * @param <T> Block entity type, the specified BE must be a {@link Carrier}
 */
public interface BlockEntityInventory<T extends BlockEntity & Carrier>
        extends PersistentInventory, ViewableInventory, CarriedInventory<T> {

    /**
     * Returns the owner of this Inventory.
     *
     * @return This inventory's carrier
     */
    Optional<T> getBlockEntity();

}
