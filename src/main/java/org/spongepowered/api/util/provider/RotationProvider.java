package org.spongepowered.api.util.provider;

import com.google.common.base.Optional;
import org.spongepowered.api.util.rotation.Rotation;

public interface RotationProvider extends Provider {
    /**
     * Gets the {@link Rotation} with the provided degrees.
     *
     * @param degrees The degrees of the rotation
     * @return The {@link Rotation} with the given degrees or Optional.absent() if not found
     */
    Optional<Rotation> getRotationFromDegree(int degrees);
}
