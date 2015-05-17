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

import org.spongepowered.api.data.manipulator.IntData;
import org.spongepowered.api.entity.living.monster.MagmaCube;
import org.spongepowered.api.entity.living.monster.Slime;

/**
 * Represents the size of a {@link Slime}. Usually applicable to all
 * {@link Slime}s and {@link MagmaCube}s.
 */
public interface SlimeData extends IntData<SlimeData> {

    /**
     * Gets the size of this slime. Size helps define the maximum health and
     * damage dealt by this slime.
     *
     * @return The current size of this slime
     */
    int getSize();

    /**
     * Sets the size of this slime.
     * <p>The size should always be 1 or more. Setting the size may affect
     * this slimes maximum health. Sizes should not be negative.</p>
     *
     * @param size The size of the slime
     * @return This instance, for chaining
     */
    SlimeData setSize(int size);
}
