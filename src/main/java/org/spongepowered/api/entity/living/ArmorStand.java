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
package org.spongepowered.api.entity.living;

import org.spongepowered.api.entity.ArmorEquipable;
import org.spongepowered.api.math.EulerDirection;

/**
 * Represents an armor stand.
 */
public interface ArmorStand extends LivingEntity, ArmorEquipable {

    /**
     * Gets the direction the headpiece is aiming at.
     *
     * @return The direction the headpiece is aiming at
     */
    EulerDirection getHeadDirection();

    /**
     * Sets the direction of the head.
     *
     * @param direction The direction of the head
     */
    void setHeadDirection(EulerDirection direction);

    /**
     * Gets the direction the body is aiming at.
     *
     * @return The direction the body is aiming at
     */
    EulerDirection getBodyRotation();

    /**
     * Sets the direction of the body.
     *
     * @param direction The direction of the body
     */
    void setBodyDirection(EulerDirection direction);

    /**
     * Gets the direction the left arm is aiming at.
     *
     * @return The direction the left arm is aiming at
     */
    EulerDirection getLeftArmDirection();

    /**
     * Sets the direction of the left arm.
     *
     * @param direction The direction of the left arm
     */
    void setLeftArmDirection(EulerDirection direction);

    /**
     * Gets the direction the right arm is aiming at.
     *
     * @return The direction the right arm is aiming at
     */
    EulerDirection getRightArmDirection();

    /**
     * Sets the direction of the right arm.
     *
     * @param direction The direction of the right arm
     */
    void setRightArmDirection(EulerDirection direction);

    /**
     * Gets the direction the left leg is aiming at.
     *
     * @return The direction the left leg is aiming at
     */
    EulerDirection getLeftLegDirection();

    /**
     * Sets the direction of the left leg.
     *
     * @param direction The direction of the left leg
     */
    void setLeftLegDirection(EulerDirection direction);

    /**
     * Gets the direction the right leg is aiming at.
     *
     * @return The direction the right leg is aiming at
     */
    EulerDirection getRightLegDirection();

    /**
     * Sets the direction of the right leg.
     *
     * @param direction The direction of the right leg
     */
    void setRightLegDirection(EulerDirection direction);

    /**
     * Returns whether this armor stand is a small armor stand or not.
     *
     * @return Whether this is a small armor stand
     */
    boolean isSmall();

    /**
     * Sets this armor stand to be small or not.
     * <p>Small armor stands may have different bounding box sizes.</p>
     *
     * @param small Whether this is to be a small armor stand or not
     */
    void setSmall(boolean small);

    /**
     * Returns whether this armor stand is rendered invisible.
     *
     * @return Whether this armor stand is invisible
     */
    boolean isInvisible();

    /**
     * Sets whether this armor stand is invisible or not.
     *
     * @param invisible Whether this armor stand is invisible or not
     */
    void setInvisible(boolean invisible);

    /**
     * Returns whether this armor stand shows arms or not.
     * <p>Arms that do not show may also not show an item in hand.</p>
     *
     * @return Whether this armor stand shows its arms
     */
    boolean doesShowArms();

    /**
     * Sets whether this armor stand will show its arms or not.
     * <p>Arms that do not show may also not show an item in hand.</p>
     *
     * @param showArms Whether to show arms or not
     */
    void setShowArms(boolean showArms);

    /**
     * Gets whether this armor stand has a visible base plate or not.
     *
     * @return Whether this armor stand has a visible base plate
     */
    boolean hasBasePlate();

    /**
     * Sets this armor stand to have a base plate or not.
     *
     * @param baseplate Whether this armor stand is to have a base plate
     */
    void setHasBasePlate(boolean baseplate);
}
