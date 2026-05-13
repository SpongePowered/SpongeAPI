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
package org.spongepowered.api.block.entity;

import org.spongepowered.api.data.BlockStateKeys;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.util.Ticks;

/**
 * Represents a geyser-like, periodically erupting block that applies a
 * nausea effect to nearby living entities while a suitable noxious source
 * exists above it, and may launch entities upward during an eruption.
 *
 * <p>The countdown exposed by {@link #eruptionCountdown()} advances each
 * server tick the block entity finds a valid source; when it elapses the
 * block toggles between its dormant and erupting block-state forms (see
 * {@link BlockStateKeys#POTENT_SULFUR_STATE}).</p>
 *
 * @see <a href="https://minecraft.wiki/w/Potent_Sulfur">Potent Sulfur</a>
 */
public interface PotentSulfur extends BlockEntity {

    /**
     * {@link Keys#ERUPTION_COUNTDOWN}
     *
     * <p>The remaining ticks until the next state flip. When the block
     * entity has not yet evaluated its surroundings (or no suitable
     * noxious source is present), this value is absent.</p>
     *
     * @return The mutable eruption countdown.
     */
    default Value.Mutable<Ticks> eruptionCountdown() {
        return this.requireValue(Keys.ERUPTION_COUNTDOWN).asMutable();
    }

    /**
     * Clears the eruption countdown, forcing the block entity to
     * re-evaluate its surroundings on the next server tick.
     */
    default void resetCountdown() {
        this.remove(Keys.ERUPTION_COUNTDOWN);
    }
}
