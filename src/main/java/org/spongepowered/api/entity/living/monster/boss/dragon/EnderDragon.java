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
package org.spongepowered.api.entity.living.monster.boss.dragon;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.explosive.EnderCrystal;
import org.spongepowered.api.entity.living.Aerial;
import org.spongepowered.api.entity.living.ComplexLiving;
import org.spongepowered.api.entity.living.Monster;
import org.spongepowered.api.entity.living.Ranger;
import org.spongepowered.api.entity.living.monster.boss.Boss;
import org.spongepowered.api.entity.living.monster.boss.dragon.phase.DragonPhase;
import org.spongepowered.api.entity.living.monster.boss.dragon.phase.DragonPhaseManager;

import java.util.Optional;

/**
 * Represents an Ender Dragon.
 */
public interface EnderDragon extends ComplexLiving<EnderDragonPart>, Boss, Monster, Aerial, Ranger {

    /**
     * {@link Keys#HEALING_CRYSTAL}
     * @return The current crystal healing this dragon
     */
    default Optional<Value.Mutable<EnderCrystal>> healingCrystal() {
        return this.getValue(Keys.HEALING_CRYSTAL).map(Value::asMutable);
    }

    /**
     * Gets the phase manager.
     *
     * <p>The phase manager controls the active {@link DragonPhase} of
     * the dragon in The End.</p>
     *
     * @return The phase manager
     */
    DragonPhaseManager getPhaseManager();
}
