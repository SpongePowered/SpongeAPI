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
package org.spongepowered.api.entity.living.monster;

import org.spongepowered.api.entity.ArmorEquipable;
import org.spongepowered.api.entity.living.Ageable;

/**
 * Represents a Zombie.
 */
public interface Zombie extends Monster, ArmorEquipable, Ageable {

    /**
     * Gets the
     * {@link org.spongepowered.api.data.manipulator.mutable.entity.ZombieData}
     * representing the type of the zombie, as well as its profession
     * (if it has one).
     *
     * @return The zombie data
     * @deprecated Since Zombies are no longer separated by
     *     {@link org.spongepowered.api.data.type.ZombieType}, the
     *     proper discrimination is checking for {@link Husk} and
     *     {@link ZombieVillager}
     */
    @Deprecated
    @SuppressWarnings("deprecation")
    default org.spongepowered.api.data.manipulator.mutable.entity.ZombieData getZombieData() {
        return get(org.spongepowered.api.data.manipulator.mutable.entity.ZombieData.class).get();
    }

}
