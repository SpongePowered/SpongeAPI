package org.spongepowered.api.world.extent;

import org.spongepowered.api.world.TileTick;

import com.flowpowered.math.vector.Vector3i;

import java.util.Collection;

/**
 * 
 * A block volume containing {@link TileTick}s.
 *
 */
public interface TileTickVolume extends BlockVolume {

    /**
     * Gets a collection of all {@link TileTick}s in this volume.
     * 
     * @return A collection of all TileTicks in this volume
     */
    Collection<TileTick> getTileTicks();

    /**
     * Gets a collection of all {@link TileTick}s in the specified position.
     * 
     * @param position The position to check
     * @return A collection of all TileTicks in the specified position
     */
    Collection<TileTick> getTileTicksAt(Vector3i position);

    /**
     * Adds a new {@link TileTick} to this volume. The block type is not an
     * argument, as it will be inferred from the block at the specified
     * position.
     * 
     * @param position The position to put the TileTick at
     * @param ticks How many ticks until the TileTick should be processed
     * @param priority The priority of the TileTick
     * @return The newly created TileTick
     */
    TileTick addTileTick(Vector3i position, int ticks, int priority);

    /**
     * Removes a {@link TileTick} from this volume.
     * 
     * @param tick The TileTick to remove.
     */
    void removeTileTick(TileTick tick);

}
