package org.spongepowered.api.extra.modifier.empty;

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.biome.BiomeTypes;
import org.spongepowered.api.world.gen.WorldGenerator;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;
import org.spongepowered.api.world.storage.WorldProperties;

/**
 * A modifier that causes a {@link World} to generate with empty chunks. Useful for "lobby-like" worlds.
 */
public class VoidWorldGeneratorModifier implements WorldGeneratorModifier {

    @Override
    public void modifyWorldGenerator(WorldProperties world, DataContainer settings, WorldGenerator worldGenerator) {
        worldGenerator.getGenerationPopulators().clear();
        worldGenerator.getPopulators().clear();
        worldGenerator.setBaseGenerationPopulator((world1, buffer, biomes) -> {});
        worldGenerator.setBiomeGenerator(buffer -> buffer.getBiomeWorker().fill((x, z) -> BiomeTypes.VOID));
    }

    @Override
    public String getId() {
        return "sponge:modifier_void";
    }

    @Override
    public String getName() {
        return "Void Modifier";
    }
}
