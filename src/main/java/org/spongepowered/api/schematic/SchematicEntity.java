package org.spongepowered.api.schematic;

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.entity.EntityType;

public interface SchematicEntity extends DataContainer, DataSerializable {

    /**
     * Gets the type of entity.
     *
     * @return The type of entity
     */
    EntityType getType();

    /**
     * Gets the location of the entity relative to the origin.
     *
     * @return The location
     */
    Vector3d getLocation();

    interface Builder extends DataBuilder<SchematicEntity> {

        /**
         * Sets the EntityType for the SchematicEntity
         *
         * @param type The type to set
         * @return This SchematicEntity builder
         */
        Builder type(EntityType type);

        /**
         * Gets the location of the entity relative to the origin.
         *
         * @return The location
         */
        Builder location(Vector3d location);

    }

}