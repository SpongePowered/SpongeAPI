package org.spongepowered.api.util.provider;

import org.spongepowered.api.world.gen.PopulatorFactory;

public interface FactoryProvider extends Provider {
    /**
     * Gets the {@link PopulatorFactory} for creating {@link Populator}s and
     * {@link GeneratorPopulator}s.
     *
     * @return The populator factory
     */
    PopulatorFactory getPopulatorFactory();
}
