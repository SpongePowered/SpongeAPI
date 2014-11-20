package org.spongepowered.api.entity;

import org.spongepowered.api.util.Identifiable;

public interface Tamer extends Identifiable {

    /**
     * Gets the name of this tamer to reference on tamed entities or null
     * if it cannot be obtained.
     *
     * @return the name to reference this tamer
     */
    String getName();

}
