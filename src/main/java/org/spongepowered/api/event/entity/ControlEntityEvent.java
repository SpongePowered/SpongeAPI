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
package org.spongepowered.api.event.entity;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.cause.CauseTracked;

/**
 * Raised when an {@link Entity} is being steered by a mounted {@link Player}.
 * 
 * <p>This event does not raise for when an entity mounted by another entity
 * moves; it is only thrown when a player attempts to steer a mounted
 * entity.</p>
 */
public interface ControlEntityEvent extends TargetEntityEvent, CauseTracked {

    /**
     * Returns the forward speed, a float value between -1 and 1, at which the
     * mounted {@link Player} is attempting to move at.
     * 
     * <p>Positive values represent movement in the direction the mounted player
     * is looking at (holding Move Forward), negative values represent movement
     * in the opposite direction. A value of 0 represents no steering movement
     * forwards or backwards.</p>
     * 
     * <p>A notchian client will, in most cases usually send a value of 0.98
     * going forwards or backwards; 0.3 (rounded up from 0.29400003) while
     * sneaking.</p>
     * 
     * @return a float value between -1 and 1 as the forward speed of the
     *         control event
     */
    float getForwardSpeed();

    /**
     * Sets the forward speed of control within this control event.
     * 
     * <p>The forward speed must be a value between -1 and 1. Positive values go
     * forward, negatives go backward.</p>
     * 
     * @param speed the speed at which the forward control movement is going
     */
    void setForwardSpeed(float speed);

    /**
     * Returns the strafing speed, a value between -1 and 1, at which the
     * mounted {@link Player} is attempting to move at.
     * 
     * <p>Positive values represent strafing to the left of the mounted player,
     * negative values represent strafing to the right. A value of 0 represents
     * no steering movement sideways.</p>
     * 
     * <p>A notchian client will, in most cases usually send a value of 0.98
     * going sideways; 0.3 (rounded up from 0.29400003) while sneaking.</p>
     * 
     * @return a float value between -1 and 1 as the strafe speed of the control
     *         event
     */
    float getStrafeSpeed();

    /**
     * Sets the strafe speed of control within this control event.
     * 
     * <p>The strafe speed must be a value between -1 and 1. Positive values
     * strafe left, negative values strafe right.</p>
     * 
     * @param speed the speed at which the strafing control movement is going
     */
    void setStrafeSpeed(float speed);

    /**
     * Returns whether or not the mounted player was sneaking during this
     * control event.
     * 
     * @return a boolean as whether or not the mounted player was sneaking
     */
    boolean isSneaking();

    /**
     * Sets whether or not the mounted player was sneaking during this control
     * event.
     * 
     * @param flag whether or not the player was sneaking
     */
    void setSneaking(boolean flag);

    /**
     * Returns whether or not the mounted player jumped during this control
     * event.
     * 
     * @return a boolean as whether or not the mounted player was jumping
     */
    boolean isJumping();

    /**
     * Sets whether or not the mounted player was jumping during this control
     * event.
     * 
     * @param flag whether or not the player was jumping
     */
    void setJumping(boolean flag);
}
