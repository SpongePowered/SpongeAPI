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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.inventory.Container;
import org.spongepowered.api.item.inventory.menu.handler.ClickHandler;
import org.spongepowered.api.item.inventory.menu.handler.KeySwapHandler;
import org.spongepowered.api.item.inventory.menu.handler.SlotClickHandler;

import java.util.function.Supplier;

/**
 * An enumeration of the click types in {@link Container}s.
 */
public class ClickTypes {

    // SORTFIELDS:ON

    /**
     * Left click on a slot.
     */
    public static final Supplier<ClickType<SlotClickHandler>> CLICK_LEFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClickType.class, "click_left");

    /**
     * Left click outside of inventory.
     */
    public static final Supplier<ClickType<ClickHandler>> CLICK_LEFT_OUTSIDE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClickType.class, "click_left_outside");

    /**
     * Used to clone the clicked item onto the cursor in creative.
     */
    public static final Supplier<ClickType<SlotClickHandler>> CLICK_MIDDLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClickType.class, "click_middle");

    /**
     * Right click on a slot.
     */
    public static final Supplier<ClickType<SlotClickHandler>> CLICK_RIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClickType.class, "click_right");

    /**
     * Right click outside of inventory.
     */
    public static final Supplier<ClickType<ClickHandler>> CLICK_RIGHT_OUTSIDE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClickType.class, "click_right_outside");

    /**
     * Collects as much items of the same type as possible to the cursor.
     */
    public static final Supplier<ClickType<SlotClickHandler>> DOUBLE_CLICK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClickType.class, "double_click");

    /**
     * Stopping drag motion. This distributes items on the cursor in all previously added slots.
     */
    public static final Supplier<ClickType<ClickHandler>> DRAG_END = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClickType.class, "drag_end");

    /**
     * Left-click drag motion.
     */
    public static final Supplier<ClickType<SlotClickHandler>> DRAG_LEFT_ADD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClickType.class, "drag_left_add");

    /**
     * Middle-click drag motion.
     */
    public static final Supplier<ClickType<SlotClickHandler>> DRAG_MIDDLE_ADD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClickType.class, "drag_middle_add");

    /**
     * Right-click drag motion.
     */
    public static final Supplier<ClickType<SlotClickHandler>> DRAG_RIGHT_ADD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClickType.class, "drag_right_add");

    /**
     * Starting drag motion.
     */
    public static final Supplier<ClickType<ClickHandler>> DRAG_START = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClickType.class, "drag_start");

    /**
     * This click-type is used when using a number key-press to swap the corresponding hotbar slot with the slot hovered over.
     * <p>The primary slot is the hovered slot.</p>
     * <p>The secondary slot is the hotbar slot.</p>
     */
    public static final Supplier<ClickType<KeySwapHandler>> KEY_SWAP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClickType.class, "key_swap");

    /**
     * Throwing all items in the hovered slot using the throw item key.
     */
    public static final Supplier<ClickType<SlotClickHandler>> KEY_THROW_ALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClickType.class, "key_throw_all");

    /**
     * Throwing one item in the hovered slot using the throw item key.
     */
    public static final Supplier<ClickType<SlotClickHandler>> KEY_THROW_ONE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClickType.class, "key_throw_one");

    /**
     * Shift-Left click on a slot.
     */
    public static final Supplier<ClickType<SlotClickHandler>> SHIFT_CLICK_LEFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClickType.class, "shift_click_left");

    /**
     * Shift-Right click on a slot.
     */
    public static final Supplier<ClickType<SlotClickHandler>> SHIFT_CLICK_RIGHT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ClickType.class, "shift_click_right");

    // SORTFIELDS:OFF
}

