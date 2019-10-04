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

/**
 * Represents a falling block. A falling block may harm entities where it lands,
 * and, optionally, may place a block, or drop an item.
 */
public interface FallingBlock extends Entity {

    /**
     * {@link Keys#BLOCK_STATE}
     */
    default Value.Mutable<BlockState> blockState() {
        return getValue(Keys.BLOCK_STATE).get().asMutable();
    }

    /**
     * {@link Keys#DAMAGE_PER_BLOCK}
     */
    default Value.Mutable<Double> damagePerBlock() {
        return getValue(Keys.DAMAGE_PER_BLOCK).get().asMutable();
    }

    /**
     * {@link Keys#MAX_FALL_DAMAGE}
     */
    default Value.Mutable<Double> maxFallDamage() {
        return getValue(Keys.MAX_FALL_DAMAGE).get().asMutable();
    }

    /**
     * {@link Keys#CAN_PLACE_AS_BLOCK}
     */
    default Value.Mutable<Boolean> placeAsBlock() {
        return getValue(Keys.CAN_PLACE_AS_BLOCK).get().asMutable();
    }

    /**
     * {@link Keys#CAN_DROP_AS_ITEM}
     */
    default Value.Mutable<Boolean> dropAsItem() {
        return getValue(Keys.CAN_DROP_AS_ITEM).get().asMutable();
    }

    /**
     * {@link Keys#FALL_TIME}
     */
    default Value.Mutable<Integer> fallTime() {
        return getValue(Keys.FALL_TIME).get().asMutable();
    }

    /**
     * {@link Keys#CAN_HURT_ENTITIES}
     */
    default Value.Mutable<Boolean> hurtEntities() {
        return getValue(Keys.CAN_HURT_ENTITIES).get().asMutable();
    }

}
