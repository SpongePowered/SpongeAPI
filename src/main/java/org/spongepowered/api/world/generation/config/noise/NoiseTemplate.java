package org.spongepowered.api.world.generation.config.noise;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.datapack.DataPack;
import org.spongepowered.api.datapack.DataPackEntry;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.ResourceKeyedBuilder;

import java.util.List;

/**
 * Noise used in world generation
 */
public interface NoiseTemplate extends DataPackEntry<NoiseTemplate> {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    Noise noise();

    interface Builder extends ResourceKeyedBuilder<NoiseTemplate, Builder>, CopyableBuilder<NoiseTemplate, Builder> {

        Builder from(Noise noise);
        Builder octave(int octave);
        Builder amplitudes(double... amplitudes);
        Builder amplitudes(List<Double> amplitudes);

        Builder pack(DataPack<NoiseTemplate> pack);

    }
}
