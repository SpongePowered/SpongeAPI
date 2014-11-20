package org.spongepowered.api.entity;

import com.google.common.base.Optional;

public interface Tameable {

    /**
     * Checks if this is tamed
     * <p>If something is tamed then no other tamer is able to tame this
     * entity through normal methods.</p>
     *
     * @return true if this has been tamed
     */
    boolean isTamed();

    /**
     * Sets if this has been tamed. Not necessary if the method setOwner has
     * been used, as it tames automatically.
     * <p>If something is tamed then no other tamer is able to tame this
     * entity through normal methods.</p>
     *
     * @param tame true if tame
     */
    void setTamed(boolean tame);

    /**
     * Gets the current owning Tamer
     *
     * @return an optional for the Tamer
     */
    Optional<Tamer> getOwner();

    /**
     * Sets this to be owned by given Tamer.
     * <p>If the tamer is null, this entity will become untamed and become
     * tameable by other tamers.</p>
     *
     * @param tamer the Tamer who should own this
     */
    void setOwner(Tamer tamer);

}
