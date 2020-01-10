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
package org.spongepowered.api.entity.living.trader;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.type.Profession;
import org.spongepowered.api.data.type.VillagerType;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.living.Ageable;

/**
 * Represents a Villager.
 */
public interface Villager extends Trader, Ageable {

    /**
     * {@link Keys#VILLAGER_TYPE}
     * @return The villager type
     * @see org.spongepowered.api.data.type.VillagerTypes
     */
    default Value.Mutable<VillagerType> type() {
        return getValue(Keys.VILLAGER_TYPE).get().asMutable();
    }

    /**
     * {@link Keys#PROFESSION}
     * @return The profession of this villager
     * @see org.spongepowered.api.data.type.Professions
     */
    default Value.Mutable<Profession> profession() {
        return getValue(Keys.PROFESSION).get().asMutable();
    }

    /**
     * {@link Keys#PROFESSION_LEVEL}
     * @return The profession level of this villager
     */
    default Value.Mutable<Integer> professionLevel() {
        return getValue(Keys.PROFESSION_LEVEL).get().asMutable();
    }
}
