package org.spongepowered.api.util.provider;

import org.spongepowered.api.data.type.Career;
import org.spongepowered.api.data.type.Profession;

import java.util.Collection;

public interface CareerProvider extends Provider {

    /**
     * Gets all available villager {@link Career}s for the given profession.
     *
     * @param profession The villager profession to collection careers from
     * @return A collection of all villager careers associated with the profession
     */
    Collection<Career> getCareers(Profession profession);
}
