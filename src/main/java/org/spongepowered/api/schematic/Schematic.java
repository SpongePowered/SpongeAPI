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
package org.spongepowered.api.schematic;

import com.flowpowered.math.vector.Vector3i;
import com.google.common.collect.BiMap;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.world.World;

import java.util.Optional;

/**
 * Unless otherwise noted, "the specification" refers to the latest version of the Schematic Specification {@url https://github
 * .com/SpongePowered/Schematic-Specification}.
 */
public interface Schematic extends DataSerializable {

    /**
     * Gets the format version used. Correlates to the `Version` field of the specification.
     *
     * @return The format version used
     */
    int getVersion();

    /**
     * Gets the attached {@link DataContainer}. Correlates to the optional `Metadata` field of the specification.
     *
     * @return The attached {@link DataContainer} or {@link Optional#empty()} if none
     */
    Optional<DataContainer> getMetadata();

    /**
     * Gets the width of the Schematic. Correlates to the `Width` field of the specification.
     *
     * @return The width of the Schematic.
     */
    int getWidth();

    /**
     * Gets the height of the Schematic. Correlates to the `Height` field of the specification.
     *
     * @return The height of the Schematic.
     */
    int getHeight();

    /**
     * Gets the length of the Schematic. Correlates to the `Length` field of the specification.
     *
     * @return The length of the Schematic.
     */
    int getLength();

    /**
     * Gets the origin of the Schematic (relative to the minimum point) or the minimum point if none. Correlates to the `OffsetX`, `OffsetY`, and
     * `OffsetZ` fields of the specification.
     *
     * @return The origin of the Schematic
     */
    Vector3i getOrigin();

    /**
     * Gets the largest key in the palette.
     * @return
     */
    int getPaletteMax();
    
    /**
     * Gets the palette of the Schematic. Correlates backwards to the `Palette` field of the specification.
     *
     * @return The palette
     */
    BiMap<Integer, BlockState> getPalette();

    /**
     * Gets the {@link BlockState} at the relative location, or {@link Optional#empty()} if none.
     *
     * @param location The location (relative to the origin of the schematic) of the BlockSnapshot desired
     * @return The BlockState found
     */
    Optional<BlockState> getBlockAt(Vector3i location);

    /**
     * Gets all {@link BlockState}s in the Schematic.
     *
     * @return All BlockStates
     */
    BlockSnapshot[] getBlocks();

    /**
     * Gets all {@link SchematicEntity} in the Schematic.
     *
     * @return All entities
     */
    SchematicEntity[] getEntities();

    /**
     * Gets all TileEntities in the Schematic.
     *
     * @return All tile entities
     */
    SchematicTileEntity[] getTileEntities();

    

    interface Builder extends DataBuilder<Schematic> {


        /**
         * Adds the given {@link DataContainer} to the schematic's metadata.
         *
         * @param metadata The metadata to add
         * @return This schematic builder
         */
        Builder metadata(DataContainer metadata);

        /**
         * Sets the minimum point of the schematic.
         *
         * @param point The point to set
         * @return This schematic builder
         */
        Builder minimumPoint(Vector3i point);

        /**
         * Sets the maximum point of the schematic.
         *
         * @param point The point to set
         * @return This schematic builder
         */
        Builder maximumPoint(Vector3i point);

        /**
         * Sets the origin of the schematic. Correlates to the `OffsetX`, `OffsetY`, and `OffsetZ` fields of the Schematic Specification (v1.
         *
         * @param origin The origin point to set
         * @return This schematic builder
         */
        Builder origin(Vector3i origin);

        /**
         * Adds a {@link BlockState} to the palette. Duplicate BlockStates will be ignored.
         *
         * @param blockState
         * @return This schematic builder
         */
        Builder addToPalette(BlockState blockState);

        /**
         * Should offer automated conversions between versions.
         *
         * @param holder
         * @return This schematic builder
         */
        Builder from(Schematic holder);

        /**
         * Builds the schematic object
         *
         * @return The built Schematic object
         * @throws InvalidDataException if any required fields are not completed
         */
        Optional<Schematic> build() throws InvalidDataException;

        /**
         * Builds the schematic object using locations from the given world
         *
         * @param world
         * @return
         * @throws InvalidDataException
         */
        Optional<Schematic> build(World world) throws InvalidDataException;

    }

}
