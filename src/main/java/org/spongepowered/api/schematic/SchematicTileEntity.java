package org.spongepowered.api.schematic;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.block.tileentity.TileEntityType;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.persistence.DataBuilder;

public interface SchematicTileEntity extends DataContainer, DataSerializable {

    /**
     * Gets the type of tile entity.
     *
     * @return The type of tile entity
     */
    TileEntityType getType();

    /**
     * Gets the location of the entity relative to the origin.
     *
     * @return The location
     */
    Vector3i getLocation();

    interface Builder extends DataBuilder<SchematicEntity> {

        /**
         * Sets the EntityType for the SchematicEntity
         *
         * @param type The type to set
         * @return This SchematicEntity builder
         */
        Builder type(TileEntityType type);

        /**
         * Gets the location of the entity relative to the origin.
         *
         * @return The location
         */
        Builder location(Vector3i location);

    }

}