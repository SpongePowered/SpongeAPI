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
package org.spongepowered.api.event.player;

import com.flowpowered.math.vector.Vector3f;
import org.spongepowered.api.block.BlockLoc;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.event.entity.EntityInteractBlockEvent;

/**
 * Called when a {@link Player} interacts with a {@link BlockLoc}.
 */
public interface PlayerInteractBlockEvent extends PlayerInteractEvent, EntityInteractBlockEvent {
    /**
     * Gets the position the player clicked on the block in 3d space. This is a @{link Vector3f} with the X, Y and Z
     * being the relative position to the block that was clicked.
     *
     * <p>This can be used to pick out which pixel of the texture the player clicked, allowing for some neat features.</p>
     *
     * <p>This may not be completely accurate, for some event types the client may not send enough information.</p>
     *
     * @return A @{Vector3f} of the position the player clicked on the block
     */
    Vector3f getHitPosition();
}
