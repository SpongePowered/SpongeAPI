package org.spongepowered.api.block.tile;

import com.google.common.base.Optional;
import org.spongepowered.api.service.persistence.DataSerializable;

/**
 * Represents data held by a Tile Entity.
 */
public interface TileEntityData extends DataSerializable {

    /**
     * Retrieves the tile entity that is backing this tile entity data, if a tile entity is backing this data.
     *
     * @return The backing tile entity, or {@link Optional#absent()}
     */
    Optional<TileEntity> getTileEntity();

    /**
     * Checks for whether this data is backed by a tile entity.
     *
     * @return True if there is a tile entity, false otherwise
     */
    boolean hasTileEntity();

}
