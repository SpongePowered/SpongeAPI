package org.spongepowered.api.world.gen;

import org.spongepowered.api.world.biome.ImmutableBiomeVolume;
import org.spongepowered.api.world.chunk.ProtoChunk;

import java.util.Random;

public interface SurfaceBuilder {

    /**
     * Takes the provided {@link ProtoChunk} and fills in a base surface layer
     * with extra information provided by the {@link ImmutableBiomeVolume}.
     * @param chunk
     * @param biomes
     * @param random
     * @param seaLevel
     */
    void buildSurface(ProtoChunk<?> chunk, ImmutableBiomeVolume biomes, Random random, int seaLevel);

}
