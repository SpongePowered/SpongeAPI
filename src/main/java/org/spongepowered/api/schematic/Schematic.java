package org.spongepowered.api.schematic;


import com.flowpowered.math.vector.Vector3i;
import com.google.common.collect.BiMap;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.extent.Extent;
import org.spongepowered.api.world.extent.worker.MutableBlockVolumeWorker;

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
    int version();

    /**
     * Gets the attached {@link DataContainer}. Correlates to the optional `Metadata` field of the specification.
     *
     * @return The attached {@link DataContainer} or {@link Optional#empty()} if none
     */
    Optional<DataContainer> metadata();

    /**
     * Gets the width of the Schematic. Correlates to the `Width` field of the specification.
     *
     * @return The width of the Schematic.
     */
    int width();

    /**
     * Gets the height of the Schematic. Correlates to the `Height` field of the specification.
     *
     * @return The height of the Schematic.
     */
    int height();

    /**
     * Gets the length of the Schematic. Correlates to the `Length` field of the specification.
     *
     * @return The length of the Schematic.
     */
    int length();

    /**
     * Gets the origin of the Schematic (relative to the minimum point) or the minimum point if none. Correlates to the `OffsetX`, `OffsetY`, and
     * `OffsetZ` fields of the specification.
     *
     * @return The origin of the Schematic
     */
    Vector3i origin();

    /**
     * Gets the largest key in the palette.
     * @return
     */
    int paletteMax();

    // TODO how to say the position in the set == the palette value

    /**
     * Gets the palette of the Schematic. Correlates backwards to the `Palette` field of the specification.
     *
     * @return The palette
     */
    BiMap<Integer, BlockState> palette();

    /**
     * Gets the {@link BlockState} at the relative location, or {@link Optional#empty()} if none.
     *
     * @param location The location (relative to the origin of the schematic) of the BlockSnapshot desired
     * @return The BlockState found
     */
    Optional<BlockState> blockAt(Vector3i location);

    /**
     * Gets all {@link BlockState}s in the Schematic.
     *
     * @return All BlockStates
     */
    BlockSnapshot[] blocks();

    /**
     * Gets all {@link SchematicEntity} in the Schematic.
     *
     * @return All entities
     */
    SchematicEntity[] entities();

    /**
     * Gets all TileEntities in the Schematic.
     *
     * @return All tile entities
     */
    SchematicTileEntity[] tileEntities();

    

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
