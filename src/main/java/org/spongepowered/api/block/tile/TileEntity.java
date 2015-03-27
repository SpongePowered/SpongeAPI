/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.block.tile;

import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.world.Location;

/**
 * Represents an abstract Tile Entity. It is a functional block that is
 * continuously updated while residing in a world. It can perform specific
 * functions based on the data that it contains.
 *
 * <p>A {@link TileEntity} is contained within a {@link Location} and will
 * continue to exists so long as the {@link Location} is of the correct
 * block type.</p>
 *
 * <p>Since a {@link TileEntity} is performing various actions, all methods
 * that are purely functional methods reside in the {@link TileEntity}, whereas
 * customizable data associated with a {@link TileEntity} is represented by
 * {@link org.spongepowered.api.data.DataManipulator}.</p>
 */
public interface TileEntity extends DataHolder, DataSerializable {

    /**
     * Checks for whether the tile entity is currently valid or not.
     *
     * <p>Use this method to check if processing should be run on this
     * {@link TileEntity}. If it is valid, then processing can be run on it.
     * If not, then processing should wait until it becomes valid or is
     * destroyed.</p>
     *
     * @return True if the tile entity is valid, false if not
     */
    boolean isValid();

    /**
     * Changes the validation of this tile entity.
     *
     * <p>If the tile entity is invalid, no processing will be done on this
     * {@link TileEntity} until it either becomes valid or is reset on the next
     * tick.</p>
     *
     * <p>If the tile entity is valid, then processing can continue and this
     * {@link TileEntity} will not be reset on the next tick.</p>
     *
     * @param valid True if the tile entity should be validated, or false if
     *     it should be invalidated
     */
    void setValid(boolean valid);

    /**
     * Gets the type of {@link TileEntity} this is.
     *
     * @return The type of tile entity
     */
    TileEntityType getType();

    /**
     * Gets the parent {@link Location} that this {@link TileEntity} resides
     * in.
     *
     * <p>If the {@link Location}'s block type is changed, this
     * {@link TileEntity} may be removed as it has no parent
     * {@link Location}.</p>
     *
     * @return The parent {@link Location}
     */
    Location getBlock();

}
