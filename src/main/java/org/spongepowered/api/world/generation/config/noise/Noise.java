package org.spongepowered.api.world.generation.config.noise;

import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.List;

@CatalogedBy(Noises.class)
public interface Noise {

    /**
     * Returns the first octave
     *
     * @return The first octave
     */
    int octave();

    /**
     * Returns the amplitudes
     *
     * @return The amplitudes
     */
    List<Double> amplitudes();
}
