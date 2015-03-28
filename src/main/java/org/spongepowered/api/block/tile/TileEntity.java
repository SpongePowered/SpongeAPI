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

import com.google.common.base.Optional;
import org.spongepowered.api.block.tile.data.TileEntityData;
import org.spongepowered.api.service.persistence.DataSerializable;
import org.spongepowered.api.service.persistence.InvalidDataException;
import org.spongepowered.api.service.persistence.data.DataContainer;
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
 * {@link TileEntityData}.</p>
 */
public interface TileEntity extends DataSerializable {

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

    /**
     * Gets the desired {@link TileEntityData} that may or may not exist on
     * this {@link TileEntity}.
     *
     * <p>Some types of {@link TileEntityData} are limited to apply to specific
     * types of {@link TileEntity}, so the returned may be an absent if the
     * data can not be created.</p>
     *
     * @param dataClass The data class of the tile data requested
     * @param <T> The {@link TileEntityData} type
     * @return The existing or newly created {@link TileEntityData}, if
     *     not, absent due to being incompatible
     */
    <T extends TileEntityData<?, T>> Optional<T> getTileData(Class<T> dataClass);

    /**
     * Sets the given {@link TileEntityData} onto this {@link TileEntity}.
     *
     * <p>Some data may not be compatible with this {@link TileEntity}, so it
     * should be noted that the {@link TileDataTransactionResult} is available
     * to check if the data was accepted, unless the {@link TileEntityData} is
     * already known to be a valid data for this {@link TileEntity}.</p>
     *
     * @param data The data to set
     * @param <T> The type of {@link TileEntityData}
     * @return The transaction result
     */
    <T extends TileEntityData<?, T>> TileDataTransactionResult setData(T data);

    /**
     * Validates the container with known data required to set the raw data to
     * this {@link TileEntity}. If the container is incomplete or contains
     * invalid data, <code>false</code> is returned.
     *
     * <p>This validation should be checked prior to calling
     * {@link #setRawData(DataContainer)} to avoid exceptions.</p>
     *
     * @param container The raw data to validate
     * @return True if the data is valid
     */
    boolean validateData(DataContainer container);

    /**
     * Attempts to set all data of this {@link TileEntity} according to the
     * {@link DataContainer}'s held information. Using this to modify known
     * {@link TileEntityData} is unsupported and if the data is invalid, an
     * {@link InvalidDataException} is thrown.
     *
     * <p>This setter is used to provide setting custom data that is not
     * represented by the Tile Entity API, including forge mods and other
     * unknown data. Attempts at validating known {@link TileEntityData}
     * contained in the data container are made with the assumption that all
     * necessary data exists.</p>
     *
     * @param container A container containing all raw data to set on this
     *     tile entity
     * @throws InvalidDataException If the container is missing or has invalid
     *     data that this stack will refuse
     */
    void setRawData(DataContainer container) throws InvalidDataException;
}
