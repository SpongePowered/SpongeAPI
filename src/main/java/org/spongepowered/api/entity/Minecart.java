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
package org.spongepowered.api.entity;

import org.spongepowered.api.item.ItemBlock;
import org.spongepowered.api.item.inventory.ItemStack;

public interface Minecart extends Entity {

    /**
     * Check if the minecart is riding or standing on rails.
     *
     * @return If the minecart is riding or standing on rails.
     */
    boolean isOnRails();

    /**
     * Get the current speed of the minecart.
     *
     * @return Speed of minecart on rails, 0 if not on rails or standing still.
     */
    double getSpeed();

    /**
     * Set the current speed of the minecart.
     * Speed is in blocks per second, and may not be higher then maximum speed.
     * Only applies if minecart is on rails.
     *
     * @param speed Speed of the minecart.
     */
    void setSpeed(double speed);

    /**
     * Get the minecart maximum speed on rails.
     *
     * @return Maximum speed of minecart.
     */
    double getMaxSpeed();

    /**
     * Set the minecart maximum speed on rails.
     * Max speed is in blocks per second, default is 0.4.
     *
     * @param maxSpeed Maximum movement speed of the minecart.
     */
    void setMaxSpeed(double maxSpeed);

    /**
     * Get the item which the cart drops when destroyed.
     *
     * @return Item which is dropped when the minecart is destroyed.
     */
    ItemStack getCartItem();

    /**
     * Get the block inside of the minecart.
     * Air by default.
     *
     * @return Block type inside of the minecart.
     */
    ItemBlock getMinecartBlock();

    /**
     * Set the block inside of the minecart.
     * Air by default.
     *
     * @param itemBlock Set the block that will be displayed inside of the minecart.
     */
    void setMinecartBlock(ItemBlock itemBlock);
}
