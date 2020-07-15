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

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;

import java.util.List;
import java.util.Optional;

/**
 * A Container is effectively a <em>ViewModel</em> for a particular set of
 * {@link Inventory} objects used to allow players to interact
 * with the Inventories, usually via a GUI (the View).
 */
public interface Container extends Inventory {

    /**
     * Returns whether given slot is part of the viewed inventories
     * but not part of the viewers own inventory.
     *
     * <p>Examples for viewed inventory slots:</p>
     * <p>All the slots of the opened chest and not the player grid below.</p>
     * <p>The slots of the crafting grid in the opened player inventory.</p>
     *
     * @param slot The slot to check.
     * @return {@code true} when the slot is part of the viewed inventories.
     */
    boolean isViewedSlot(Slot slot);

    /**
     * Returns the list of viewed inventories.
     * <p>This is usually at least the inventory a player opened and the players inventory.</p>
     * <p>It is not necessary, that all slots of the viewed inventories are visible or interactable with.</p>
     *
     * @return the list of viewed inventories.
     */
    List<Inventory> getViewed();

    /**
     * Sets the viewing players cursor item.
     * <p>Returns false when the container is no longer open.</p>
     *
     * @param item The item to set.
     *
     * @return true if the cursor was set.
     */
    boolean setCursor(ItemStack item);

    /**
     * Gets the viewing players cursor item.
     * <p>Returns {@link Optional#empty()} when the container was closed.</p>
     *
     * @return The players cursor item.
     */
    Optional<ItemStack> getCursor();

    /**
     * Gets the viewing {@link ServerPlayer player}.
     *
     * @return The viewing player
     */
    ServerPlayer getViewer();

    /**
     * Returns whether this Container is open.
     *
     * @return Whether this Container is open.
     */
    boolean isOpen();

    /**
     * Returns the {@link ContainerType} of this container.
     *
     * @return the ContainerType of this container.
     */
    ContainerType getType();

}
