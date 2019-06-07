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
package org.spongepowered.api.block.entity;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Represents a jukebox, also know as a music disc player.
 */
public interface Jukebox extends BlockEntity {

    /**
     * Attempts to play the currently stored music disc according to the
     * {@link Keys#REPRESENTED_ITEM} of this {@link Jukebox}.
     */
    void play();

    /**
     * Stops the currently playing music disc, if any.
     */
    void stop();

    /**
     * Ejects the music disc item in this Jukebox into the world.
     */
    void eject();

    /**
     * Ejects the current music disc item in this Jukebox and inserts the given one.
     *
     * @param disc The music disc item to insert
     */
    void insert(ItemStack disc);
}
