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
package org.spongepowered.api.event.entity.living.human;

import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.event.entity.living.LivingChangeBlockEvent;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.world.Location;

/**
 * Called when a {@link Human} changes a {@link Location}.
 */
public interface HumanChangeBlockEvent extends HumanEvent, LivingChangeBlockEvent {

    /**
     * Gets the direction of the block face that the human is changing.
     *
     * <p>Example, if a human is breaking a block and the block is infront of
     * the human while the human is facing EAST, the block face will be WEST.</p>
     *
     * @return The direction of the block face
     */
    Direction getBlockFaceDirection();
}
