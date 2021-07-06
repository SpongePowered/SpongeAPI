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
import org.spongepowered.api.entity.living.monster.Patroller;
import org.spongepowered.api.raid.RaidWave;

import java.util.Optional;

public interface Raider extends Patroller {

    /**
     * {@link Keys#CAN_JOIN_RAID}
     *
     * @return Whether this raider can join a raid
     */
    default Value.Mutable<Boolean> canJoinRaid() {
        return this.requireValue(Keys.CAN_JOIN_RAID).asMutable();
    }

    /**
     * {@link Keys#RAID_WAVE}
     *
     * @return The raid wave of this raider
     */
    default Optional<Value<RaidWave>> raidWave() {
        return this.getValue(Keys.RAID_WAVE);
    }

    /**
     * {@link Keys#IS_CELEBRATING}
     *
     * @return Whether this raider is celebrating
     */
    default Value.Mutable<Boolean> celebrating() {
        return this.requireValue(Keys.IS_CELEBRATING).asMutable();
    }
}
