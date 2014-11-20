package org.spongepowered.api.entity;

import java.util.UUID;

public interface Tamer {

    /**
     * Gets the name of this tamer to reference on tamed entities or null
     * if it cannot be obtained.
     *
     * @return the name to reference this tamer
     */
    String getName();

    /**
     * Gets the UUID of this tamer to reference on tamed entities.
     *
     * @return the UUID to reference on tamed entities
     */
    UUID getUniqueId();
}
