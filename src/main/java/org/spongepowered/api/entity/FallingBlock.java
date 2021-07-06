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
package org.spongepowered.api.entity;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.util.Ticks;

/**
 * Represents a falling block. A falling block may harm entities where it lands,
 * and, optionally, may place a block, or drop an item.
 */
public interface FallingBlock extends Entity {

    /**
     * {@link Keys#BLOCK_STATE}
     *
     * @return The block state of the falling block
     */
    default Value.Mutable<BlockState> blockState() {
        return this.requireValue(Keys.BLOCK_STATE).asMutable();
    }

    /**
     * {@link Keys#DAMAGE_PER_BLOCK}
     *
     * @return The rate of damage increase per block fallen
     */
    default Value.Mutable<Double> damagePerBlock() {
        return this.requireValue(Keys.DAMAGE_PER_BLOCK).asMutable();
    }

    /**
     * {@link Keys#MAX_FALL_DAMAGE}
     *
     * @return The maximum fall damage
     */
    default Value.Mutable<Double> maxFallDamage() {
        return this.requireValue(Keys.MAX_FALL_DAMAGE).asMutable();
    }

    /**
     * {@link Keys#CAN_PLACE_AS_BLOCK}
     *
     * @return Whether this can place a block on landing or not
     */
    default Value.Mutable<Boolean> placeAsBlock() {
        return this.requireValue(Keys.CAN_PLACE_AS_BLOCK).asMutable();
    }

    /**
     * {@link Keys#CAN_DROP_AS_ITEM}
     *
     * @return Whether this will drop as an item or not
     */
    default Value.Mutable<Boolean> dropAsItem() {
        return this.requireValue(Keys.CAN_DROP_AS_ITEM).asMutable();
    }

    /**
     * {@link Keys#FALL_TIME}
     *
     * @return The fall time
     */
    default Value.Mutable<Ticks> fallTime() {
        return this.requireValue(Keys.FALL_TIME).asMutable();
    }

    /**
     * {@link Keys#CAN_HURT_ENTITIES}
     *
     * @return Whether this block will hurt entities on it's way down
     */
    default Value.Mutable<Boolean> hurtEntities() {
        return this.requireValue(Keys.CAN_HURT_ENTITIES).asMutable();
    }

}
