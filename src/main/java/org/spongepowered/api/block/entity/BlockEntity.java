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

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.data.SerializableDataHolder;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.LocatableBlock;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.schematic.Schematic;

/**
 * Represents a block entity. It is a functional block that is
 * continuously updated while residing in a world. It can perform specific
 * functions based on the data that it contains.
 *
 * <p>A {@link BlockEntity} is contained within a {@link Location} and will
 * continue to exists so long as the {@link Location} is of the correct
 * block type.</p>
 *
 * <p>Since a {@link BlockEntity} is performing various actions, all methods
 * that are purely functional methods reside in the {@link BlockEntity}, whereas
 * customizable data associated with a {@link BlockEntity} is represented by
 * {@link Value Values}.</p>
 */
public interface BlockEntity extends SerializableDataHolder.Mutable, Locatable {

    /**
     * Checks for whether the block entity is currently valid or not.
     *
     * <p>Use this method to check if processing should be run on this
     * {@link BlockEntity}. If it is valid, then processing can be run on it.
     * If not, then processing should wait until it becomes valid or is
     * destroyed.</p>
     *
     * @return True if the block entity is valid, false if not
     */
    boolean isValid();

    /**
     * Changes the validation of this block entity.
     *
     * <p>If the block entity is invalid, no processing will be done on this
     * {@link BlockEntity} until it either becomes valid or is reset on the next
     * tick.</p>
     *
     * <p>If the block entity is valid, then processing can continue and this
     * {@link BlockEntity} will not be reset on the next tick.</p>
     *
     * @param valid True if the block entity should be validated, or false if
     *     it should be invalidated
     */
    void setValid(boolean valid);

    /**
     * Gets the type of {@link BlockEntity} this is.
     *
     * @return The type of block entity
     */
    BlockEntityType getType();

    /**
     * Gets the {@link BlockState} that this {@link BlockEntity} represents.
     *
     * @return The blockstate
     */
    BlockState getBlock();

    /**
     * Creates a new {@link BlockEntityArchetype} for use with {@link Schematic}s
     * and placing the archetype in multiple locations.
     *
     * @return The created archetype for re-creating this block entity
     */
    BlockEntityArchetype createArchetype();

    /**
     * Creates a {@link LocatableBlock} for this {@link BlockEntity}. Can be used
     * as a simpler method of making them. Since this does not persist the
     * data of this {@link BlockEntity}, it should not be used in place of a
     * {@link BlockSnapshot} where data is being safely cloned.
     *
     * @return The created locatable block, not as a block snapshot
     */
    LocatableBlock getLocatableBlock();

    /**
     * Creates a new {@link BlockEntityArchetype} for use with {@link Schematic}s
     * and placing the archetype in multiple locations.
     *
     * @return The created archetype for re-creating this block entity
     */
    @Override
    BlockEntity copy();
}
