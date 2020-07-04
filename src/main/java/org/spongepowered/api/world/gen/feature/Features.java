/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.world.gen.feature;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.world.gen.feature.config.BigMushroomFeatureConfig;
import org.spongepowered.api.world.gen.feature.config.BlockBlobConfig;
import org.spongepowered.api.world.gen.feature.config.BlockWithContextConfig;
import org.spongepowered.api.world.gen.feature.config.BuriedTreasureConfig;
import org.spongepowered.api.world.gen.feature.config.BushConfig;
import org.spongepowered.api.world.gen.feature.config.CountConfig;
import org.spongepowered.api.world.gen.feature.config.DoublePlantConfig;
import org.spongepowered.api.world.gen.feature.config.EndGatewayConfig;
import org.spongepowered.api.world.gen.feature.config.FeatureRadiusConfig;
import org.spongepowered.api.world.gen.feature.config.HellLavaConfig;
import org.spongepowered.api.world.gen.feature.config.IcebergConfig;
import org.spongepowered.api.world.gen.feature.config.LakesConfig;
import org.spongepowered.api.world.gen.feature.config.LiquidsConfig;
import org.spongepowered.api.world.gen.feature.config.MinableConfig;
import org.spongepowered.api.world.gen.feature.config.MineshaftConfig;
import org.spongepowered.api.world.gen.feature.config.NoFeatureConfig;
import org.spongepowered.api.world.gen.feature.config.OceanRuinConfig;
import org.spongepowered.api.world.gen.feature.config.RandomDefaultFeatureListConfig;
import org.spongepowered.api.world.gen.feature.config.RandomFeatureListConfig;
import org.spongepowered.api.world.gen.feature.config.RandomFeatureWithConfigConfig;
import org.spongepowered.api.world.gen.feature.config.ReplaceBlockConfig;
import org.spongepowered.api.world.gen.feature.config.SeaGrassConfig;
import org.spongepowered.api.world.gen.feature.config.ShipwreckConfig;
import org.spongepowered.api.world.gen.feature.config.TallGrassConfig;
import org.spongepowered.api.world.gen.feature.config.TwoFeatureChoiceConfig;
import org.spongepowered.api.world.gen.feature.config.VillageConfig;

import java.util.function.Supplier;

public final class Features {

    // SORTFIELDS:ON

    public static final Supplier<Feature<BigMushroomFeatureConfig>> BIG_BROWN_MUSHROOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "BIG_BROWN_MUSHROOM");

    public static final Supplier<Feature<BigMushroomFeatureConfig>> BIG_RED_MUSHROOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "BIG_RED_MUSHROOM");

    public static final Supplier<Feature<NoFeatureConfig>> BIG_TREE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "BIG_TREE");

    public static final Supplier<Feature<NoFeatureConfig>> BIRCH_TREE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "BIRCH_TREE");

    public static final Supplier<Feature<BlockBlobConfig>> BLOCK_BLOB = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "BLOCK_BLOB");

    public static final Supplier<Feature<BlockWithContextConfig>> BLOCK_WITH_CONTEXT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "BLOCK_WITH_CONTEXT");

    public static final Supplier<Feature<NoFeatureConfig>> BLUE_ICE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "BLUE_ICE");

    public static final Supplier<Feature<BuriedTreasureConfig>> BURIED_TREASURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "BURIED_TREASURE");

    public static final Supplier<Feature<BushConfig>> BUSH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "BUSH");

    public static final Supplier<Feature<NoFeatureConfig>> CACTUS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "CACTUS");

    public static final Supplier<Feature<NoFeatureConfig>> CANOPY_TREE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "CANOPY_TREE");

    public static final Supplier<Feature<NoFeatureConfig>> CHORUS_PLANT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "CHORUS_PLANT");

    public static final Supplier<Feature<NoFeatureConfig>> CORAL_CLAW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "CORAL_CLAW");

    public static final Supplier<Feature<NoFeatureConfig>> CORAL_MUSHROOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "CORAL_MUSHROOM");

    public static final Supplier<Feature<NoFeatureConfig>> CORAL_TREE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "CORAL_TREE");

    public static final Supplier<Feature<NoFeatureConfig>> DEAD_BUSH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "DEAD_BUSH");

    public static final Supplier<Feature<NoFeatureConfig>> DEFAULT_FLOWERS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "DEFAULT_FLOWERS");

    public static final Supplier<Feature<RandomFeatureListConfig>> DEFAULT_RANDOM_FEATURE_LIST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "DEFAULT_RANDOM_FEATURE_LIST");

    public static final Supplier<Feature<NoFeatureConfig>> DESERT_PYRAMID = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "DESERT_PYRAMID");

    public static final Supplier<Feature<NoFeatureConfig>> DESERT_WELLS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "DESERT_WELLS");

    public static final Supplier<Feature<DoublePlantConfig>> DOUBLE_PLANT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "DOUBLE_PLANT");

    public static final Supplier<Feature<NoFeatureConfig>> DUNGEONS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "DUNGEONS");

    public static final Supplier<Feature<NoFeatureConfig>> END_CITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "END_CITY");

    public static final Supplier<Feature<NoFeatureConfig>> END_CRYSTAL_TOWER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "END_CRYSTAL_TOWER");

    public static final Supplier<Feature<EndGatewayConfig>> END_GATEWAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "END_GATEWAY");

    public static final Supplier<Feature<NoFeatureConfig>> END_ISLAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "END_ISLAND");

    public static final Supplier<Feature<NoFeatureConfig>> FIRE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "FIRE");

    public static final Supplier<Feature<NoFeatureConfig>> FOREST_FLOWERS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "FOREST_FLOWERS");

    public static final Supplier<Feature<NoFeatureConfig>> FORTRESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "FORTRESS");

    public static final Supplier<Feature<NoFeatureConfig>> FOSSILS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "FOSSILS");

    public static final Supplier<Feature<NoFeatureConfig>> GLOWSTONE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "GLOWSTONE");

    public static final Supplier<Feature<HellLavaConfig>> HELL_LAVA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "HELL_LAVA");

    public static final Supplier<Feature<IcebergConfig>> ICEBERG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "ICEBERG");

    public static final Supplier<Feature<NoFeatureConfig>> ICE_AND_SNOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "ICE_AND_SNOW");

    public static final Supplier<Feature<FeatureRadiusConfig>> ICE_PATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "ICE_PATH");

    public static final Supplier<Feature<NoFeatureConfig>> ICE_SPIKE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "ICE_SPIKE");

    public static final Supplier<Feature<NoFeatureConfig>> IGLOO = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "IGLOO");

    public static final Supplier<Feature<NoFeatureConfig>> JUNGLE_GRASS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "JUNGLE_GRASS");

    public static final Supplier<Feature<NoFeatureConfig>> JUNGLE_PYRAMID = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "JUNGLE_PYRAMID");

    public static final Supplier<Feature<NoFeatureConfig>> JUNGLE_TREE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "JUNGLE_TREE");

    public static final Supplier<Feature<NoFeatureConfig>> KELP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "KELP");

    public static final Supplier<Feature<LakesConfig>> LAKES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "LAKES");

    public static final Supplier<Feature<LiquidsConfig>> LIQUIDS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "LIQUIDS");

    public static final Supplier<Feature<NoFeatureConfig>> MEGA_PINE_TREE_1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "MEGA_PINE_TREE_1");

    public static final Supplier<Feature<NoFeatureConfig>> MEGA_PINE_TREE_2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "MEGA_PINE_TREE_2");

    public static final Supplier<Feature<NoFeatureConfig>> MELON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "MELON");

    public static final Supplier<Feature<NoFeatureConfig>> MESA_JUNGLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "MESA_JUNGLE");

    public static final Supplier<Feature<MinableConfig>> MINABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "MINABLE");

    public static final Supplier<Feature<MineshaftConfig>> MINESHAFT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "MINESHAFT");

    public static final Supplier<Feature<NoFeatureConfig>> OCEAN_MONUMENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "OCEAN_MONUMENT");

    public static final Supplier<Feature<OceanRuinConfig>> OCEAN_RUIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "OCEAN_RUIN");

    public static final Supplier<Feature<NoFeatureConfig>> PILLAGER_OUTPOST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "PILLAGER_OUTPOST");

    public static final Supplier<Feature<NoFeatureConfig>> PLAINS_FLOWERS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "PLAINS_FLOWERS");

    public static final Supplier<Feature<NoFeatureConfig>> POINTY_TAIGA_TREE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "POINTY_TAIGA_TREE");

    public static final Supplier<Feature<NoFeatureConfig>> PUMPKIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "PUMPKIN");

    public static final Supplier<Feature<RandomDefaultFeatureListConfig>> RANDOM_FEATURE_LIST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "RANDOM_FEATURE_LIST");

    public static final Supplier<Feature<RandomFeatureWithConfigConfig>> RANDOM_FEATURE_WITH_CONFIG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "RANDOM_FEATURE_WITH_CONFIG");

    public static final Supplier<Feature<NoFeatureConfig>> REED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "REED");

    public static final Supplier<Feature<ReplaceBlockConfig>> REPLACE_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "REPLACE_BLOCK");

    public static final Supplier<Feature<NoFeatureConfig>> SAVANNA_TREE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "SAVANNA_TREE");

    public static final Supplier<Feature<SeaGrassConfig>> SEA_GRASS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "SEA_GRASS");

    public static final Supplier<Feature<CountConfig>> SEA_PICKLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "SEA_PICKLE");

    public static final Supplier<Feature<ShipwreckConfig>> SHIPWRECK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "SHIPWRECK");

    public static final Supplier<Feature<NoFeatureConfig>> SHRUB = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "SHRUB");

    public static final Supplier<Feature<NoFeatureConfig>> SPHERE_REPLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "SPHERE_REPLACE");

    public static final Supplier<Feature<NoFeatureConfig>> STRONGHOLD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "STRONGHOLD");

    public static final Supplier<Feature<NoFeatureConfig>> SWAMP_FLOWERS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "SWAMP_FLOWERS");

    public static final Supplier<Feature<NoFeatureConfig>> SWAMP_HUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "SWAMP_HUT");

    public static final Supplier<Feature<NoFeatureConfig>> SWAMP_TREE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "SWAMP_TREE");

    public static final Supplier<Feature<NoFeatureConfig>> TAIGA_GRASS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "TAIGA_GRASS");

    public static final Supplier<Feature<NoFeatureConfig>> TALL_BIRCH_TREE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "TALL_BIRCH_TREE");

    public static final Supplier<Feature<TallGrassConfig>> TALL_GRASS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "TALL_GRASS");

    public static final Supplier<Feature<NoFeatureConfig>> TALL_TAIGA_TREE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "TALL_TAIGA_TREE");

    public static final Supplier<Feature<NoFeatureConfig>> TREE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "TREE");

    public static final Supplier<Feature<TwoFeatureChoiceConfig>> TWO_FEATURE_CHOICE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "TWO_FEATURE_CHOICE");

    public static final Supplier<Feature<VillageConfig>> VILLAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "VILLAGE");

    public static final Supplier<Feature<NoFeatureConfig>> VINES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "VINES");

    public static final Supplier<Feature<NoFeatureConfig>> VOID_START_PLATFORM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "VOID_START_PLATFORM");

    public static final Supplier<Feature<NoFeatureConfig>> WATERLILY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "WATERLILY");

    public static final Supplier<Feature<NoFeatureConfig>> WOODLAND_MANSION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Feature.class, "WOODLAND_MANSION");

    // SORTFIELDS:OFF

    private Features() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
