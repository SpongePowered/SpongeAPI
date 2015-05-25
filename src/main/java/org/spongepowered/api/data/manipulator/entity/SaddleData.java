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
package org.spongepowered.api.data.manipulator.entity;

import org.spongepowered.api.data.manipulator.SingleValueData;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.animal.Horse;
import org.spongepowered.api.entity.living.animal.Pig;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Signifies that a {@link Entity} is currently "saddled". Usually applicable
 * to {@link Pig}s and {@link Horse}s.
 */
public interface SaddleData extends SingleValueData<ItemStack, SaddleData> {

    /**
     * Gets the current saddle this horse is equipped with.
     *
     * <p>A saddled horse is player rideable. Not all horses can be saddled.</p>
     *
     * @return The saddle, if available
     */
    ItemStack getSaddle();

    /**
     * Sets the horse to be equipped with the given saddle.
     *
     * <p>A saddled horse is player rideable. Not all horses can be saddled.</p>
     *
     * @param itemStack The saddle item
     * @return This instance, for chaining
     */
    SaddleData setSaddle(ItemStack itemStack);
}
