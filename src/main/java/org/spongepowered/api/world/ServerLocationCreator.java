package org.spongepowered.api.world;

import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3i;

public interface ServerLocationCreator extends LocationCreator<ServerWorld, ServerLocation> {

    /**
     * Gets a {@link LocatableBlock} for the desired {@link Vector3i} position.
     *
     * @param position The position to get the locatable block
     * @return The locatable block
     */
    default LocatableBlock getLocatableBlock(final Vector3i position) {
        return LocatableBlock.builder().location(this.getLocation(position)).build();
    }

    /**
     * Gets a {@link LocatableBlock} for the desired {@code x, y, z} coordinates.
     *
     * @param x The x position
     * @param y The y position
     * @param z The z position
     * @return The locatable block
     */
    default LocatableBlock getLocatableBlock(final int x, final int y, final int z) {
        return LocatableBlock.builder().location(this.getLocation(x, y, z)).build();
    }
}
