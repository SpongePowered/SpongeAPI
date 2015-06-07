package org.spongepowered.api.util.provider;

import com.google.common.base.Optional;
import org.spongepowered.api.resourcepack.ResourcePack;

public interface ResourcePackProvider extends Provider {

    /**
     * Gets a {@link ResourcePack} that's already been created by its ID.
     *
     * @param id The ID of the pack
     * @return The ResourcePack with the specified ID, or Optional.absent() if
     *         none could be found
     */
    Optional<ResourcePack> getById(String id);
}
