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
package org.spongepowered.api.entity.living.golem;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.type.CopperOxidation;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueLike;

public interface CopperGolem extends Golem {

    /**
     * Gets the {@link Value.Mutable} value of the current {@link CopperOxidation} state
     * for this golem.
     *
     * @return The mutable value, to set it back, use {@link #offer(ValueLike)}
     * @see <a href="https://minecraft.wiki/w/Oxidation">Oxidation</a>
     */
    default Value.Mutable<CopperOxidation> oxidation() {
        return this.requireValue(Keys.COPPER_OXIDATION).asMutable();
    }

    /**
     * Gets the {@link Value.Mutable} value of the current waxed state.
     *
     * @return The mutable value, to set it back, use {@link #offer(ValueLike)}
     * @see <a href="https://minecraft.wiki/w/Oxidation#Waxing">Waxing</a>
     */
    default Value.Mutable<Boolean> waxed() {
        return this.requireValue(Keys.WAXED).asMutable();
    }
}
