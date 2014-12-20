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

package org.spongepowered.api.entity.living.monster;

import com.google.common.base.Optional;
import org.spongepowered.api.block.BlockState;

/**
 * Represents an Enderman.
 */
public interface Enderman extends Monster {

    /**
     * Gets the {@link BlockState} currently carried by the enderman.
     *
     * @return The {@link BlockState}, if available
     */
    Optional<BlockState> getCarriedBlock();

    /**
     * Sets the {@link BlockState} currently carried by the enderman.
     *
     * @param carriedBlock The carried {@link BlockState}
     */
    void setCarriedBlock(BlockState carriedBlock);

    /**
     * Gets if the enderman is currently screaming.
     * <p>This behaviour generally occurs when a player has been
     * targeted due to staring too long.</p>
     *
     * @return If the enderman is screaming
     */
    boolean isScreaming();

    /**
     * Sets if the enderman is currently screaming.
     * <p>This behaviour generally occurs when a player has been
     * targeted due to staring too long.</p>
     *
     * @param screaming If the enderman should be screaming
     */
    void setScreaming(boolean screaming);
}
