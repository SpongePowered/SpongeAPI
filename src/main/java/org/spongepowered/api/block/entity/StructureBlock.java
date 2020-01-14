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

import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.type.StructureMode;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;
import org.spongepowered.math.vector.Vector3i;

import java.util.Optional;

/**
 * Represents a StructureBlock.
 *
 * <p>StructureBlock blocks can be used to save and load
 * structures, alongside {@link BlockTypes#STRUCTURE_VOID structure void} blocks.</p>
 */
public interface StructureBlock extends BlockEntity {

    /**
     * {@link Keys#STRUCTURE_MODE}
     * @return The structure mode of this structure block.
     */
    default Value.Mutable<StructureMode> mode() {
        return this.requireValue(Keys.STRUCTURE_MODE).asMutable();
    }

    /**
     * {@link Keys#STRUCTURE_POWERED}
     * @return Whether this structure block is powered.
     */
    default Value.Mutable<Boolean> powered() {
        return this.requireValue(Keys.STRUCTURE_POWERED).asMutable();
    }

    /**
     * {@link Keys#STRUCTURE_SHOW_BOUNDING_BOX}
     *
     * <p>In vanilla, this is only visible to {@link Player}s whose
     * {@link GameMode} is {@link GameModes#CREATIVE} or
     * {@link GameModes#SPECTATOR}.</p>
     *
     * @return Whether the bounding box should be visible.
     */
    default Value.Mutable<Boolean> showBoundingBox() {
        return this.requireValue(Keys.STRUCTURE_SHOW_BOUNDING_BOX).asMutable();
    }

    /**
     * {@link Keys#STRUCTURE_SHOW_AIR}
     * @return Whether the air within the structure should be visible.
     */
    default Value.Mutable<Boolean> showAir() {
        return this.requireValue(Keys.STRUCTURE_SHOW_AIR).asMutable();
    }

    /**
     * {@link Keys#STRUCTURE_IGNORE_ENTITIES}
     * @return Whether this structure block should ignore entities.
     */
    default Value.Mutable<Boolean> ignoreEntities() {
        return this.requireValue(Keys.STRUCTURE_IGNORE_ENTITIES).asMutable();
    }

    /**
     * {@link Keys#STRUCTURE_SIZE}
     * @return The size of the structure.
     */
    default Value.Mutable<Vector3i> size() {
        return this.requireValue(Keys.STRUCTURE_SIZE).asMutable();
    }

    /**
     * {@link Keys#STRUCTURE_POSITION}
     * @return The position of the structure.
     */
    default Value.Mutable<Vector3i> position() {
        return this.requireValue(Keys.STRUCTURE_POSITION).asMutable();
    }

    /**
     * {@link Keys#STRUCTURE_SEED}
     * @return The seed of the structure to be generated.
     */
    default Value.Mutable<Long> seed() {
        return this.requireValue(Keys.STRUCTURE_SEED).asMutable();
    }

    /**
     * {@link Keys#STRUCTURE_INTEGRITY}
     * @return The integrity of the structure.
     */
    default Value.Mutable<Double> integrity() {
        return this.requireValue(Keys.STRUCTURE_INTEGRITY).asMutable();
    }

    /**
     * {@link Keys#STRUCTURE_AUTHOR}
     * @return The author of the structure loaded by the structure block.
     */
    default Optional<Value.Mutable<String>> author() {
        return this.getValue(Keys.STRUCTURE_AUTHOR).map(Value::asMutable);
    }
}
