package org.spongepowered.api.item.data;

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.data.TileEntity;

import com.google.common.base.Optional;

import java.util.Set;

public interface ItemBlockData extends ItemData {

    Optional<Set<BlockType>> getPlaceableOn();

    Optional<TileEntity> getSavedTileEntity();

}
