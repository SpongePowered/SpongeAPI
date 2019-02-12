package org.spongepowered.api.world.volume.composite;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.tileentity.TileEntity;
import org.spongepowered.api.fluid.FluidState;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.api.world.volume.block.ReadableBlockVolume;
import org.spongepowered.api.world.volume.tileentity.ReadableTileEntityVolume;

/**
 * A special {@link Volume} that assumes no guarantees about the instances of
 * {@link BlockState}s, and {@link TileEntity TileEntities}. While this is
 * partially utilized for the sake of retrieving {@link BlockState}s,
 * {@link FluidState}s, and {@link TileEntity TileEntities}, there are chances
 * the volume itself is not associated with a {@link World} and the
 * {@link TileEntity} instances may yet to be fully loaded for usage by players.
 */
public interface ReadableCompositeVolume extends ReadableBlockVolume, ReadableTileEntityVolume {

}
