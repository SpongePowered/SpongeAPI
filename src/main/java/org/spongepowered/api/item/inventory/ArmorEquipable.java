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

import org.spongepowered.api.data.type.HandType;

import java.util.function.Supplier;

/**
 * <p>Represents something that can be equipped with armor, main hand and off hand items.
 * Each method here is a shorthand for the appropriate {@link #getEquipped}
 * or {@link #equip} method call.</p>
 *
 * <p>Classes implementing this interface should provide <b>all</b> of the
 * supplied equipment slot types. Classes which do not support all slot types in
 * this interface should instead implement {@link Equipable}.</p>
 */
public interface ArmorEquipable extends Equipable {

    /**
     * Gets the head.
     *
     * @return The head, if available
     */
    ItemStack getHead();

    /**
     * Sets the head.
     *
     * @param head The head
     */
    void setHead(ItemStack head);

    /**
     * Gets the chest.
     *
     * @return The chest, if available
     */
    ItemStack getChest();

    /**
     * Sets the chest.
     *
     * @param chest The chest
     */
    void setChest(ItemStack chest);

    /**
     * Gets the legs.
     *
     * @return The legs, if available
     */
    ItemStack getLegs();

    /**
     * Sets the legs.
     *
     * @param legs The legs
     */
    void setLegs(ItemStack legs);

    /**
     * Gets the feet.
     *
     * @return The feet, if available
     */
    ItemStack getFeet();

    /**
     * Sets the feet.
     *
     * @param feet The feet
     */
    void setFeet(ItemStack feet);

    /**
     * Gets the equipped item in hand.
     *
     * @param handType The hand type to retrieve from
     * @return The item in hand, if available
     */
    default ItemStack getItemInHand(Supplier<? extends HandType> handType) {
        return this.getItemInHand(handType.get());
    }

    /**
     * Gets the equipped item in hand.
     *
     * @param handType The hand type to retrieve from
     * @return The item in hand, if available
     */
    ItemStack getItemInHand(HandType handType);

    /**
     * Sets the equipped item in hand.
     *
     * @param handType The hand type to set to
     * @param itemInHand The item in hand
     */
    default void setItemInHand(Supplier<? extends HandType> handType, ItemStack itemInHand) {
        this.setItemInHand(handType.get(), itemInHand);
    }

    /**
     * Sets the equipped item in hand.
     *
     * @param handType The hand type to set to
     * @param itemInHand The item in hand
     */
    void setItemInHand(HandType handType, ItemStack itemInHand);
}
