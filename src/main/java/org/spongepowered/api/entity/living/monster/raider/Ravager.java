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
import org.spongepowered.api.util.Ticks;

/**
 * Represents a Ravager.
 */
public interface Ravager extends Raider {

    /**
     * {@link Keys#ATTACK_TIME}
     *
     * @return The time this ravager is attacking
     */
    default Value.Mutable<Ticks> attackTime() {
        return this.requireValue(Keys.ATTACK_TIME).asMutable();
    }

    /**
     * {@link Keys#ROARING_TIME}
     *
     * @return The time this ravager is roaring
     */
    default Value.Mutable<Ticks> roaringTime() {
        return this.requireValue(Keys.ROARING_TIME).asMutable();
    }

    /**
     * {@link Keys#STUNNED_TIME}
     *
     * @return The time this ravager is being stunned for
     */
    default Value.Mutable<Ticks> stunnedTime() {
        return this.requireValue(Keys.STUNNED_TIME).asMutable();
    }

    /**
     * {@link Keys#IS_IMMOBILIZED}
     *
     * <p>In vanilla, if {@link Ravager#attackTime()} &gt; 0 or {@link Ravager#roaringTime()}
     * &gt; 0 or {@link Ravager#stunnedTime()} &gt; 0 then the ravager is considered immobilized.</p>
     *
     * <p>In vanilla, this is read-only.</p>
     *
     * @return Whether this ravager is immobilized
     */
    default Value<Boolean> immobilized() {
        return this.requireValue(Keys.IS_IMMOBILIZED);
    }

    /**
     * {@link Keys#IS_ROARING}
     *
     * <p>In vanilla, this is {@link Ravager#roaringTime()} &gt; 0.</p>
     *
     * <p>When offering the roaring state in vanilla. If the value is true, this will
     * set {@link Ravager#roaringTime()} to 10. Otherwise, it will be set to 0.</p>
     *
     * @return Whether this ravager is roaring
     */
    default Value<Boolean> roaring() {
        return this.requireValue(Keys.IS_ROARING);
    }

    /**
     * {@link Keys#IS_STUNNED}
     *
     * <p>In vanilla, this is {@link Ravager#stunnedTime()} &gt; 0.</p>
     *
     * <p>When offering the roaring state in vanilla. If the value is true, this will
     * set {@link Ravager#stunnedTime()} to 40. Otherwise, it will be set to 0.</p>
     *
     * @return Whether this ravager is stunned
     */
    default Value<Boolean> stunned() {
        return this.requireValue(Keys.IS_STUNNED);
    }
}
