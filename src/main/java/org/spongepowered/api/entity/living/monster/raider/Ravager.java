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
package org.spongepowered.api.entity.living.monster.raider;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;

/**
 * Represents a Ravager.
 */
public interface Ravager extends Raider {

    /**
     * {@link Keys#ATTACK_TIME}
     * @return The time this ravager is attacking
     */
    default Value.Mutable<Integer> attackTime() {
        return this.getValue(Keys.ATTACK_TIME.get()).get().asMutable();
    }

    /**
     * {@link Keys#ROARING_TIME}
     * @return The time this ravager is roaring
     */
    default Value.Mutable<Integer> roaringTime() {
        return this.getValue(Keys.ROARING_TIME.get()).get().asMutable();
    }

    /**
     * {@link Keys#STUNNED_TIME}
     * @return The time this ravager is being stunned for
     */
    default Value.Mutable<Integer> stunnedTime() {
        return this.getValue(Keys.STUNNED_TIME.get()).get().asMutable();
    }

    /**
     * Determines if the ravager is immobilized. In vanilla, if {@link Ravager#attackTime()} &gt; 0 or
     * {@link Ravager#roaringTime()} &gt; 0 or {@link Ravager#stunnedTime()} &gt; 0 then the ravager is considered immobilized.
     *
     * @return True if immobilized, false if not
     */
    boolean isImmobilized();

    /**
     * Determines if the ravager is roaring. In vanilla, this is {@link Ravager#roaringTime()} &gt; 0.
     *
     * @return True if roaring, false if not
     */
    boolean isRoaring();

    /**
     * Instructs the ravager to roar or not. In vanilla, if true, this will set {@link Ravager#roaringTime()} to 10. Otherwise,
     * it will be set to 0.
     *
     * @param roaring True to roar, false to stop
     */
    void setRoaring(boolean roaring);

    /**
     * Determines if the ravager is stunned. In vanilla, this is {@link Ravager#stunnedTime()} &gt; 0.
     *
     * @return True if stunned, false if not
     */
    boolean isStunned();

    /**
     * Instructs the ravager to be stunned or not. In vanilla, if true, this will set {@link Ravager#stunnedTime()} to 40. Otherwise,
     * it will be set to 0.
     *
     * @param stunned True to be stunned, false to be not
     */
    void setStunned(boolean stunned);
}
