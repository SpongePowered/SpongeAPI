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
package org.spongepowered.api.item.inventory.menu;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.item.inventory.Container;
import org.spongepowered.api.item.inventory.menu.handler.ClickHandler;
import org.spongepowered.api.item.inventory.menu.handler.CloseHandler;
import org.spongepowered.api.item.inventory.menu.handler.InventoryCallbackHandler;
import org.spongepowered.api.item.inventory.menu.handler.KeySwapHandler;
import org.spongepowered.api.item.inventory.menu.handler.SlotChangeHandler;
import org.spongepowered.api.item.inventory.menu.handler.SlotClickHandler;
import org.spongepowered.api.item.inventory.type.ViewableInventory;

import java.util.Optional;

/**
 * Helper for Menus based on Inventories.
 * <p>This helper provides simple callbacks that can be used instead of listening to inventory events.</p>
 * <p>InventoryMenus are by default readonly and automatically prevent any changes made by players in the menu.</p>
 */
public interface InventoryMenu {

    /**
     * Creates a new InventoryMenu based on given inventory.
     *
     * @param inventory the inventory
     *
     * @return the new menu.
     */
    static InventoryMenu of(ViewableInventory inventory) {
        return inventory.asMenu();
    }

    /**
     * Returns the current inventory used in this menu.
     *
     * @return the current inventory
     */
    ViewableInventory getInventory();

    /**
     * Sets a new inventory. If the ContainerType does not change the inventory will be swapped out silently.
     * <p>If the ContainerType is different all existing callbacks are cleared and open menus are closed and reopened with the new inventory.</p>
     *
     * @param inventory the new inventory
     */
    void setCurrentInventory(ViewableInventory inventory);

    /**
     * Sets the title of this menu.
     * <p>Any open menus are closed and reopened with the new title.</p>
     *
     * @param title the new title.
     */
    void setTitle(Component title);

    /**
     * Registers click callbacks. Unregisters previously registered handler of the same type.
     * <p>Return false in the handler to prevent changes.</p>
     * <p>Possible handlers: {@link ClickHandler}, {@link SlotClickHandler}, {@link KeySwapHandler}, {@link SlotChangeHandler}, {@link CloseHandler}</p>
     *
     * @param handler the handler
     */
    void registerHandler(InventoryCallbackHandler handler);

    /**
     * Registers a click callback. Unregisters previously registered handler of the same type.
     * <p>Return false in the handler to prevent changes.</p>
     *
     * @param handler the handler
     */
    void registerClick(ClickHandler handler);

    /**
     * Registers a slot click callback. Unregisters previously registered handler of the same type.
     * <p>Return false in the handler to prevent changes.</p>
     *
     * @param handler the handler
     */
    void registerSlotClick(SlotClickHandler handler);

    /**
     * Registers a key-swap click callback. Unregisters previously registered handler of the same type.
     * <p>Return false in the handler to prevent changes.</p>
     *
     * @param handler the handler
     */
    void registerKeySwap(KeySwapHandler handler);

    /**
     * Registers a change callback. Unregisters previously registered SlotChangeHandler.
     * <p>You can override the behaviour of {@link #setReadOnly(boolean)} with this.</p>
     * <p>Return false in the handler to prevent changes.</p>
     *
     * @param handler the callback handler
     */
    void registerChange(SlotChangeHandler handler);

    /**
     * Registers a callback for when this menu is closed. Unregisters previously registered handler.
     *
     * @param handler the callback handler
     */
    void registerClose(CloseHandler handler);

    /**
     * Unregisters all callback handlers.
     */
    void unregisterAll();

    /**
     * Sets the readonly mode for this menu.
     * <p>By default this is true and cancels any change in menu.</p>
     *
     * @param readOnly whether to make the menu readonly or not.
     *
     * @return this menu
     */
    InventoryMenu setReadOnly(boolean readOnly);

    /**
     * Opens this menu for given {@link ServerPlayer player}.
     *
     * @param player the player.
     *
     * @return the opened Container.
     */
    Optional<Container> open(ServerPlayer player);

}
