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

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;
import org.spongepowered.api.world.gen.feature.config.BlockBlobConfig;
import org.spongepowered.api.world.gen.feature.config.BlockWithContextConfig;
import org.spongepowered.api.world.gen.feature.config.BuriedTreasureConfig;
import org.spongepowered.api.world.gen.feature.config.BushConfig;
import org.spongepowered.api.world.gen.feature.config.CountConfig;
import org.spongepowered.api.world.gen.feature.config.DesertPyramidConfig;
import org.spongepowered.api.world.gen.feature.config.DoublePlantConfig;
import org.spongepowered.api.world.gen.feature.config.EndCityConfig;
import org.spongepowered.api.world.gen.feature.config.EndGatewayConfig;
import org.spongepowered.api.world.gen.feature.config.FeatureRadiusConfig;
import org.spongepowered.api.world.gen.feature.config.FortressConfig;
import org.spongepowered.api.world.gen.feature.config.HellLavaConfig;
import org.spongepowered.api.world.gen.feature.config.IcebergConfig;
import org.spongepowered.api.world.gen.feature.config.IglooConfig;
import org.spongepowered.api.world.gen.feature.config.JunglePyramidConfig;
import org.spongepowered.api.world.gen.feature.config.LakesConfig;
import org.spongepowered.api.world.gen.feature.config.LiquidsConfig;
import org.spongepowered.api.world.gen.feature.config.MinableConfig;
import org.spongepowered.api.world.gen.feature.config.MineshaftConfig;
import org.spongepowered.api.world.gen.feature.config.NoFeatureConfig;
import org.spongepowered.api.world.gen.feature.config.OceanMonumentConfig;
import org.spongepowered.api.world.gen.feature.config.OceanRuinConfig;
import org.spongepowered.api.world.gen.feature.config.RandomDefaultFeatureListConfig;
import org.spongepowered.api.world.gen.feature.config.RandomFeatureListConfig;
import org.spongepowered.api.world.gen.feature.config.RandomFeatureWithConfigConfig;
import org.spongepowered.api.world.gen.feature.config.ReplaceBlockConfig;
import org.spongepowered.api.world.gen.feature.config.SeaGrassConfig;
import org.spongepowered.api.world.gen.feature.config.ShipwreckConfig;
import org.spongepowered.api.world.gen.feature.config.SphereReplaceConfig;
import org.spongepowered.api.world.gen.feature.config.StrongholdConfig;
import org.spongepowered.api.world.gen.feature.config.SwampHutConfig;
import org.spongepowered.api.world.gen.feature.config.TallGrassConfig;
import org.spongepowered.api.world.gen.feature.config.TwoFeatureChoiceConfig;
import org.spongepowered.api.world.gen.feature.config.VillageConfig;
import org.spongepowered.api.world.gen.feature.config.WoodlandMansionConfig;

public final class Features {

    // SORTFIELDS:ON

    public static final Feature<VillageConfig> VILLAGE = DummyObjectProvider.createExtendedFor(Feature.class, "VILLAGE");
    public static final Feature<MineshaftConfig> MINESHAFT = DummyObjectProvider.createExtendedFor(Feature.class, "MINESHAFT");
    public static final Feature<WoodlandMansionConfig> WOODLAND_MANSION = DummyObjectProvider.createExtendedFor(Feature.class, "WOODLAND_MANSION");
    public static final Feature<JunglePyramidConfig> JUNGLE_PYRAMID = DummyObjectProvider.createExtendedFor(Feature.class, "JUNGLE_PYRAMID");
    public static final Feature<DesertPyramidConfig> DESERT_PYRAMID = DummyObjectProvider.createExtendedFor(Feature.class, "DESERT_PYRAMID");
    public static final Feature<IglooConfig> IGLOO = DummyObjectProvider.createExtendedFor(Feature.class, "IGLOO");
    public static final Feature<ShipwreckConfig> SHIPWRECK = DummyObjectProvider.createExtendedFor(Feature.class, "SHIPWRECK");
    public static final Feature<SwampHutConfig> SWAMP_HUT = DummyObjectProvider.createExtendedFor(Feature.class, "SWAMP_HUT");
    public static final Feature<StrongholdConfig> STRONGHOLD = DummyObjectProvider.createExtendedFor(Feature.class, "STRONGHOLD");
    public static final Feature<OceanMonumentConfig> OCEAN_MONUMENT = DummyObjectProvider.createExtendedFor(Feature.class, "OCEAN_MONUMENT");
    public static final Feature<OceanRuinConfig> OCEAN_RUIN = DummyObjectProvider.createExtendedFor(Feature.class, "OCEAN_RUIN");
    public static final Feature<FortressConfig> FORTRESS = DummyObjectProvider.createExtendedFor(Feature.class, "FORTRESS");
    public static final Feature<EndCityConfig> END_CITY = DummyObjectProvider.createExtendedFor(Feature.class, "END_CITY");
    public static final Feature<BuriedTreasureConfig> BURIED_TREASURE = DummyObjectProvider.createExtendedFor(Feature.class, "BURIED_TREASURE");
    public static final Feature<NoFeatureConfig> BIG_TREE = DummyObjectProvider.createExtendedFor(Feature.class, "BIG_TREE");
    public static final Feature<NoFeatureConfig> BIRCH_TREE = DummyObjectProvider.createExtendedFor(Feature.class, "BIRCH_TREE");
    public static final Feature<NoFeatureConfig> TALL_BIRCH_TREE = DummyObjectProvider.createExtendedFor(Feature.class, "TALL_BIRCH_TREE");
    public static final Feature<NoFeatureConfig> SHRUB = DummyObjectProvider.createExtendedFor(Feature.class, "SHRUB");
    public static final Feature<NoFeatureConfig> JUNGLE_TREE = DummyObjectProvider.createExtendedFor(Feature.class, "JUNGLE_TREE");
    public static final Feature<NoFeatureConfig> POINTY_TAIGA_TREE = DummyObjectProvider.createExtendedFor(Feature.class, "POINTY_TAIGA_TREE");
    public static final Feature<NoFeatureConfig> CANOPY_TREE = DummyObjectProvider.createExtendedFor(Feature.class, "CANOPY_TREE");
    public static final Feature<NoFeatureConfig> SAVANNA_TREE = DummyObjectProvider.createExtendedFor(Feature.class, "SAVANNA_TREE");
    public static final Feature<NoFeatureConfig> TALL_TAIGA_TREE = DummyObjectProvider.createExtendedFor(Feature.class, "TALL_TAIGA_TREE");
    public static final Feature<NoFeatureConfig> SWAMP_TREE = DummyObjectProvider.createExtendedFor(Feature.class, "SWAMP_TREE");
    public static final Feature<NoFeatureConfig> TREE = DummyObjectProvider.createExtendedFor(Feature.class, "TREE");
    public static final Feature<NoFeatureConfig> MESA_JUNGLE = DummyObjectProvider.createExtendedFor(Feature.class, "MESA_JUNGLE");
    public static final Feature<NoFeatureConfig> MEGA_PINE_TREE_1 = DummyObjectProvider.createExtendedFor(Feature.class, "MEGA_PINE_TREE_1");
    public static final Feature<NoFeatureConfig> MEGA_PINE_TREE_2 = DummyObjectProvider.createExtendedFor(Feature.class, "MEGA_PINE_TREE_2");
    public static final Feature<NoFeatureConfig> DEFAULT_FLOWERS = DummyObjectProvider.createExtendedFor(Feature.class, "DEFAULT_FLOWERS");
    public static final Feature<NoFeatureConfig> FOREST_FLOWERS = DummyObjectProvider.createExtendedFor(Feature.class, "FOREST_FLOWERS");
    public static final Feature<NoFeatureConfig> PLAINS_FLOWERS = DummyObjectProvider.createExtendedFor(Feature.class, "PLAINS_FLOWERS");
    public static final Feature<NoFeatureConfig> SWAMP_FLOWERS = DummyObjectProvider.createExtendedFor(Feature.class, "SWAMP_FLOWERS");
    public static final Feature<NoFeatureConfig> JUNGLE_GRASS = DummyObjectProvider.createExtendedFor(Feature.class, "JUNGLE_GRASS");
    public static final Feature<NoFeatureConfig> TAIGA_GRASS = DummyObjectProvider.createExtendedFor(Feature.class, "TAIGA_GRASS");
    public static final Feature<TallGrassConfig> TALL_GRASS = DummyObjectProvider.createExtendedFor(Feature.class, "TALL_GRASS");
    public static final Feature<NoFeatureConfig> VOID_START_PLATFORM = DummyObjectProvider.createExtendedFor(Feature.class, "VOID_START_PLATFORM");
    public static final Feature<NoFeatureConfig> CACTUS = DummyObjectProvider.createExtendedFor(Feature.class, "CACTUS");
    public static final Feature<NoFeatureConfig> DEAD_BUSH = DummyObjectProvider.createExtendedFor(Feature.class, "DEAD_BUSH");
    public static final Feature<NoFeatureConfig> DESERT_WELLS = DummyObjectProvider.createExtendedFor(Feature.class, "DESERT_WELLS");
    public static final Feature<NoFeatureConfig> FOSSILS = DummyObjectProvider.createExtendedFor(Feature.class, "FOSSILS");
    public static final Feature<NoFeatureConfig> FIRE = DummyObjectProvider.createExtendedFor(Feature.class, "FIRE");
    public static final Feature<NoFeatureConfig> BIG_RED_MUSHROOM = DummyObjectProvider.createExtendedFor(Feature.class, "BIG_RED_MUSHROOM");
    public static final Feature<NoFeatureConfig> BIG_BROWN_MUSHROOM = DummyObjectProvider.createExtendedFor(Feature.class, "BIG_BROWN_MUSHROOM");
    public static final Feature<NoFeatureConfig> ICE_SPIKE = DummyObjectProvider.createExtendedFor(Feature.class, "ICE_SPIKE");
    public static final Feature<NoFeatureConfig> GLOWSTONE = DummyObjectProvider.createExtendedFor(Feature.class, "GLOWSTONE");
    public static final Feature<NoFeatureConfig> MELON = DummyObjectProvider.createExtendedFor(Feature.class, "MELON");
    public static final Feature<NoFeatureConfig> PUMPKIN = DummyObjectProvider.createExtendedFor(Feature.class, "PUMPKIN");
    public static final Feature<NoFeatureConfig> REED = DummyObjectProvider.createExtendedFor(Feature.class, "REED");
    public static final Feature<NoFeatureConfig> ICE_AND_SNOW = DummyObjectProvider.createExtendedFor(Feature.class, "ICE_AND_SNOW");
    public static final Feature<NoFeatureConfig> VINES = DummyObjectProvider.createExtendedFor(Feature.class, "VINES");
    public static final Feature<NoFeatureConfig> WATERLILY = DummyObjectProvider.createExtendedFor(Feature.class, "WATERLILY");
    public static final Feature<NoFeatureConfig> DUNGEONS = DummyObjectProvider.createExtendedFor(Feature.class, "DUNGEONS");
    public static final Feature<NoFeatureConfig> BLUE_ICE = DummyObjectProvider.createExtendedFor(Feature.class, "BLUE_ICE");
    public static final Feature<IcebergConfig> ICEBERG = DummyObjectProvider.createExtendedFor(Feature.class, "ICEBERG");
    public static final Feature<BlockBlobConfig> BLOCK_BLOB = DummyObjectProvider.createExtendedFor(Feature.class, "BLOCK_BLOB");
    public static final Feature<BushConfig> BUSH = DummyObjectProvider.createExtendedFor(Feature.class, "BUSH");
    public static final Feature<SphereReplaceConfig> SPHERE_REPLACE = DummyObjectProvider.createExtendedFor(Feature.class, "SPHERE_REPLACE");
    public static final Feature<DoublePlantConfig> DOUBLE_PLANT = DummyObjectProvider.createExtendedFor(Feature.class, "DOUBLE_PLANT");
    public static final Feature<HellLavaConfig> HELL_LAVA = DummyObjectProvider.createExtendedFor(Feature.class, "HELL_LAVA");
    public static final Feature<FeatureRadiusConfig> ICE_PATH = DummyObjectProvider.createExtendedFor(Feature.class, "ICE_PATH");
    public static final Feature<LakesConfig> LAKES = DummyObjectProvider.createExtendedFor(Feature.class, "LAKES");
    public static final Feature<MinableConfig> MINABLE = DummyObjectProvider.createExtendedFor(Feature.class, "MINABLE");
    public static final Feature<RandomFeatureListConfig> DEFAULT_RANDOM_FEATURE_LIST = DummyObjectProvider.createExtendedFor(Feature.class, "DEFAULT_RANDOM_FEATURE_LIST");
    public static final Feature<RandomDefaultFeatureListConfig> RANDOM_FEATURE_LIST = DummyObjectProvider.createExtendedFor(Feature.class, "RANDOM_FEATURE_LIST");
    public static final Feature<RandomFeatureWithConfigConfig> RANDOM_FEATURE_WITH_CONFIG = DummyObjectProvider.createExtendedFor(Feature.class, "RANDOM_FEATURE_WITH_CONFIG");
    public static final Feature<TwoFeatureChoiceConfig> TWO_FEATURE_CHOICE = DummyObjectProvider.createExtendedFor(Feature.class, "TWO_FEATURE_CHOICE");
    public static final Feature<ReplaceBlockConfig> REPLACE_BLOCK = DummyObjectProvider.createExtendedFor(Feature.class, "REPLACE_BLOCK");
    public static final Feature<LiquidsConfig> LIQUIDS = DummyObjectProvider.createExtendedFor(Feature.class, "LIQUIDS");
    public static final Feature<NoFeatureConfig> END_CRYSTAL_TOWER = DummyObjectProvider.createExtendedFor(Feature.class, "END_CRYSTAL_TOWER");
    public static final Feature<NoFeatureConfig> END_ISLAND = DummyObjectProvider.createExtendedFor(Feature.class, "END_ISLAND");
    public static final Feature<NoFeatureConfig> CHORUS_PLANT = DummyObjectProvider.createExtendedFor(Feature.class, "CHORUS_PLANT");
    public static final Feature<EndGatewayConfig> END_GATEWAY = DummyObjectProvider.createExtendedFor(Feature.class, "END_GATEWAY");
    public static final Feature<SeaGrassConfig> SEA_GRASS = DummyObjectProvider.createExtendedFor(Feature.class, "SEA_GRASS");
    public static final Feature<NoFeatureConfig> KELP = DummyObjectProvider.createExtendedFor(Feature.class, "KELP");
    public static final Feature<NoFeatureConfig> CORAL_TREE = DummyObjectProvider.createExtendedFor(Feature.class, "CORAL_TREE");
    public static final Feature<NoFeatureConfig> CORAL_MUSHROOM = DummyObjectProvider.createExtendedFor(Feature.class, "CORAL_MUSHROOM");
    public static final Feature<NoFeatureConfig> CORAL_CLAW = DummyObjectProvider.createExtendedFor(Feature.class, "CORAL_CLAW");
    public static final Feature<CountConfig> SEA_PICKLE = DummyObjectProvider.createExtendedFor(Feature.class, "SEA_PICKLE");
    public static final Feature<BlockWithContextConfig> BLOCK_WITH_CONTEXT = DummyObjectProvider.createExtendedFor(Feature.class, "BLOCK_WITH_CONTEXT");

    // SORTFIELDS:OFF

    private Features() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
