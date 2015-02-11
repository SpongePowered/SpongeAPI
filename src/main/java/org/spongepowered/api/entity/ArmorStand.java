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

import com.flowpowered.math.vector.Vector3f;


public interface ArmorStand extends Entity, ArmorEquipable{
    
    /**
     * Gets if the provided {@link EquipableSlot} can be interacted with by
     * players on this armor stand.
     * 
     * @param slot The slot to check
     * @return If the provided slot is enabled
     */
    boolean isSlotEnabled(EquipableSlot slot);

    /**
     * Sets if the provided {@link EquipableSlot} can be interacted with by
     * players on this armor stand.
     * 
     * @param slot The slot to enable or disable
     * @param enabled If the slot should be enabled or disabled
     */
    void setSlotEnabled(EquipableSlot slot, boolean enabled);
    
    /**
     * Gets if this armor stand is used as a marker.
     * 
     * @return If this armor stand is used as a marker
     */
    boolean isMarker();

    /**
     * Sets if this armor stand is used as a marker.
     * 
     * @param marker If this armor stand is now used as a marker
     */
    void setMarker(boolean marker);

    /**
     * Gets if this armor stand is visible.
     * 
     * @return If this armor stand is visible
     */
    boolean isVisible();

    /**
     * Sets if this armor stand is visible.
     * 
     * @param invisible If this armor stand is now visible
     */
    void setVisible(boolean invisible);

    /**
     * Gets if the base plate of this armor stand should be shown.
     * 
     * @return If the base plate of this armor stand should be shown
     */
    boolean showBasePlate();

    /**
     * Sets if the base plate of this armor stand should be shown.
     * 
     * @param showBasePlate If the base plate of this armor stand should now be
     *        shown
     */
    void setShowBasePlate(boolean showBasePlate);

    /**
     * Gets if this armor stand should be affected by gravity.
     * 
     * @return If this armor stand should be affected by gravity
     */
    boolean isGravityEnabled();

    /**
     * Sets if this armor stand should be affected by gravity.
     * 
     * @param enabled If this armor stand should now be affected by gravity
     */
    void setGravityEnabled(boolean enabled);

    /**
     * Gets if the arms of this armor stand should be shown.
     * 
     * @return If the arms of this armor stand should be shown
     */
    boolean showArms();

    /**
     * Sets if the arms of this armor stand should be shown.
     * 
     * @param showArms If the arms of this armor stand should now be shown
     */
    void setShowArms(boolean showArms);

    /**
     * Gets if this armor stand is small.
     * 
     * @return If this armor stand is small
     */
    boolean isSmall();

    /**
     * Sets if this armor stand is small.
     * 
     * @param small If this armor stand is now small
     */
    void setSmall(boolean small);

    /**
     * Gets the rotation of this armor stand's body.
     * 
     * @return The rotation of this armor stand's body
     */
    Vector3f getBodyRotation();

    /**
     * Sets the rotation of this armor stand's body.
     * 
     * @param rotation The new rotation of this armor stand's body
     */
    void setBodyRotation(Vector3f rotation);

    /**
     * Gets the rotation of this armor stand's left arm.
     * 
     * @return The rotation of this armor stand's left arm
     */
    Vector3f getLeftArmRotation();

    /**
     * Sets the rotation of this armor stand's left arm.
     * 
     * @param rotation The new rotation of this armor stand's left arm
     */
    void setLeftArmRotation(Vector3f rotation);

    /**
     * Gets the rotation of this armor stand's right arm.
     * 
     * @return The rotation of this armor stand's right arm
     */
    Vector3f getRightArmRotation();

    /**
     * Sets the rotation of this armor stand's right arm.
     * 
     * @param rotation The new rotation of this armor stand's right arm
     */
    void setRightArmRotation(Vector3f rotation);

    /**
     * Gets the rotation of this armor stand's left leg.
     * 
     * @return The rotation of this armor stand's left leg
     */
    Vector3f getLeftLegRotation();

    /**
     * Sets the rotation of this armor stand's left leg.
     * 
     * @param rotation The new rotation of this armor stand's left leg
     */
    void setLeftLegRotation(Vector3f rotation);

    /**
     * Gets the rotation of this armor stand's right leg.
     * 
     * @return The rotation of this armor stand's right leg
     */
    Vector3f getRightLegRotation();

    /**
     * Sets the rotation of this armor stand's right leg.
     * 
     * @param rotation The new rotation of this armor stand's right leg
     */
    void setRightLegRotation(Vector3f rotation);

    /**
     * Gets the rotation of this armor stand's head.
     * 
     * @return The rotation of this armor stand's head
     */
    Vector3f getHeadRotation();

    /**
     * Sets the rotation of this armor stand's head.
     * 
     * @param rotation The new rotation of this armor stand's head
     */
    void setHeadRotation(Vector3f rotation);

}
