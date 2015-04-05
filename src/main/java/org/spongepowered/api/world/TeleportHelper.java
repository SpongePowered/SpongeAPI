package org.spongepowered.api.world;

import com.google.common.base.Optional;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.annotation.NonnullByDefault;

/**
 * Finds safe {@link Location}s for {@link Entity}s (typically ones that won't hurt them).
 */
@NonnullByDefault
public interface TeleportHelper {

    /** The default height radius to scan for safe locations */
    int DEFAULT_HEIGHT = 3;
    /** The default width radius to scan for safe locations */
    int DEFAULT_WIDTH = 9;

    /**
     * Gets the next safe {@link Location} around the given location.
     *
     * Safe entails that the returned location will not be somewhere that would harm an {@link Entity}.
     * This method will use the default height and width for a search area.
     *
     * Its possible the same location will be returned that was passed in. This means it was safe.
     *
     * @param location The location to search nearby.
     * @return A safe location near the original location or the original location if it is deemed safe. If no safe
     * location can be found, {@link Optional#absent} will be returned.
     */
    Optional<Location> getSafeLocation(Location location);

    /**
     * Gets the next safe {@link Location} around the given location with a given tolerance and search radius.
     *
     * Safe entails that the returned location will not be somewhere that would harm a player.
     *
     * Its possible the same location will be returned that was passed in. This means it was safe.
     *
     * @param location The location to search nearby.
     * @param height The radius of blocks on the y-axis to search.
     * @param width The radius of blocks on the x and z-axis to search.
     * @return A safe location near the original location or the original location if it is deemed safe. If no safe
     * location can be found, {@link Optional#absent} will be returned
     */
    Optional<Location> getSafeLocation(Location location, int height, int width);
}

