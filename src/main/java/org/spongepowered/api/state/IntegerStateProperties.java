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
package org.spongepowered.api.state;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * Represents all possible {@link IntegerStateProperty}s that are known to exist in
 * vanilla minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class IntegerStateProperties {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<IntegerStateProperty> ACACIA_LEAVES_DISTANCE = IntegerStateProperties.key(ResourceKey.sponge("acacia_leaves_distance"));

    public static final DefaultedRegistryReference<IntegerStateProperty> ACACIA_SAPLING_STAGE = IntegerStateProperties.key(ResourceKey.sponge("acacia_sapling_stage"));

    public static final DefaultedRegistryReference<IntegerStateProperty> ACACIA_SIGN_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("acacia_sign_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> BAMBOO_AGE = IntegerStateProperties.key(ResourceKey.sponge("bamboo_age"));

    public static final DefaultedRegistryReference<IntegerStateProperty> BAMBOO_STAGE = IntegerStateProperties.key(ResourceKey.sponge("bamboo_stage"));

    public static final DefaultedRegistryReference<IntegerStateProperty> BEETROOTS_AGE = IntegerStateProperties.key(ResourceKey.sponge("beetroots_age"));

    public static final DefaultedRegistryReference<IntegerStateProperty> BIRCH_LEAVES_DISTANCE = IntegerStateProperties.key(ResourceKey.sponge("birch_leaves_distance"));

    public static final DefaultedRegistryReference<IntegerStateProperty> BIRCH_SAPLING_STAGE = IntegerStateProperties.key(ResourceKey.sponge("birch_sapling_stage"));

    public static final DefaultedRegistryReference<IntegerStateProperty> BIRCH_SIGN_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("birch_sign_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> BLACK_BANNER_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("black_banner_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> BLUE_BANNER_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("blue_banner_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> BROWN_BANNER_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("brown_banner_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> CACTUS_AGE = IntegerStateProperties.key(ResourceKey.sponge("cactus_age"));

    public static final DefaultedRegistryReference<IntegerStateProperty> CAKE_BITES = IntegerStateProperties.key(ResourceKey.sponge("cake_bites"));

    public static final DefaultedRegistryReference<IntegerStateProperty> CARROTS_AGE = IntegerStateProperties.key(ResourceKey.sponge("carrots_age"));

    public static final DefaultedRegistryReference<IntegerStateProperty> CAULDRON_LEVEL = IntegerStateProperties.key(ResourceKey.sponge("cauldron_level"));

    public static final DefaultedRegistryReference<IntegerStateProperty> CHORUS_FLOWER_AGE = IntegerStateProperties.key(ResourceKey.sponge("chorus_flower_age"));

    public static final DefaultedRegistryReference<IntegerStateProperty> COCOA_AGE = IntegerStateProperties.key(ResourceKey.sponge("cocoa_age"));

    public static final DefaultedRegistryReference<IntegerStateProperty> COMPOSTER_LEVEL = IntegerStateProperties.key(ResourceKey.sponge("composter_level"));

    public static final DefaultedRegistryReference<IntegerStateProperty> CREEPER_HEAD_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("creeper_head_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> CYAN_BANNER_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("cyan_banner_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> DARK_OAK_LEAVES_DISTANCE = IntegerStateProperties.key(ResourceKey.sponge("dark_oak_leaves_distance"));

    public static final DefaultedRegistryReference<IntegerStateProperty> DARK_OAK_SAPLING_STAGE = IntegerStateProperties.key(ResourceKey.sponge("dark_oak_sapling_stage"));

    public static final DefaultedRegistryReference<IntegerStateProperty> DARK_OAK_SIGN_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("dark_oak_sign_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> DAYLIGHT_DETECTOR_POWER = IntegerStateProperties.key(ResourceKey.sponge("daylight_detector_power"));

    public static final DefaultedRegistryReference<IntegerStateProperty> DRAGON_HEAD_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("dragon_head_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> FARMLAND_MOISTURE = IntegerStateProperties.key(ResourceKey.sponge("farmland_moisture"));

    public static final DefaultedRegistryReference<IntegerStateProperty> FIRE_AGE = IntegerStateProperties.key(ResourceKey.sponge("fire_age"));

    public static final DefaultedRegistryReference<IntegerStateProperty> FROSTED_ICE_AGE = IntegerStateProperties.key(ResourceKey.sponge("frosted_ice_age"));

    public static final DefaultedRegistryReference<IntegerStateProperty> GRAY_BANNER_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("gray_banner_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> GREEN_BANNER_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("green_banner_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> HEAVY_WEIGHTED_PRESSURE_PLATE_POWER = IntegerStateProperties.key(ResourceKey.sponge("heavy_weighted_pressure_plate_power"));

    public static final DefaultedRegistryReference<IntegerStateProperty> JUNGLE_LEAVES_DISTANCE = IntegerStateProperties.key(ResourceKey.sponge("jungle_leaves_distance"));

    public static final DefaultedRegistryReference<IntegerStateProperty> JUNGLE_SAPLING_STAGE = IntegerStateProperties.key(ResourceKey.sponge("jungle_sapling_stage"));

    public static final DefaultedRegistryReference<IntegerStateProperty> JUNGLE_SIGN_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("jungle_sign_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> KELP_AGE = IntegerStateProperties.key(ResourceKey.sponge("kelp_age"));

    public static final DefaultedRegistryReference<IntegerStateProperty> LAVA_LEVEL = IntegerStateProperties.key(ResourceKey.sponge("lava_level"));

    public static final DefaultedRegistryReference<IntegerStateProperty> LIGHT_BLUE_BANNER_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("light_blue_banner_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> LIGHT_GRAY_BANNER_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("light_gray_banner_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> LIGHT_WEIGHTED_PRESSURE_PLATE_POWER = IntegerStateProperties.key(ResourceKey.sponge("light_weighted_pressure_plate_power"));

    public static final DefaultedRegistryReference<IntegerStateProperty> LIME_BANNER_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("lime_banner_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> MAGENTA_BANNER_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("magenta_banner_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> MELON_STEM_AGE = IntegerStateProperties.key(ResourceKey.sponge("melon_stem_age"));

    public static final DefaultedRegistryReference<IntegerStateProperty> NETHER_WART_AGE = IntegerStateProperties.key(ResourceKey.sponge("nether_wart_age"));

    public static final DefaultedRegistryReference<IntegerStateProperty> NOTE_BLOCK_NOTE = IntegerStateProperties.key(ResourceKey.sponge("note_block_note"));

    public static final DefaultedRegistryReference<IntegerStateProperty> OAK_LEAVES_DISTANCE = IntegerStateProperties.key(ResourceKey.sponge("oak_leaves_distance"));

    public static final DefaultedRegistryReference<IntegerStateProperty> OAK_SAPLING_STAGE = IntegerStateProperties.key(ResourceKey.sponge("oak_sapling_stage"));

    public static final DefaultedRegistryReference<IntegerStateProperty> OAK_SIGN_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("oak_sign_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> ORANGE_BANNER_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("orange_banner_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> PINK_BANNER_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("pink_banner_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> PLAYER_HEAD_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("player_head_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> POTATOES_AGE = IntegerStateProperties.key(ResourceKey.sponge("potatoes_age"));

    public static final DefaultedRegistryReference<IntegerStateProperty> PUMPKIN_STEM_AGE = IntegerStateProperties.key(ResourceKey.sponge("pumpkin_stem_age"));

    public static final DefaultedRegistryReference<IntegerStateProperty> PURPLE_BANNER_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("purple_banner_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> REDSTONE_WIRE_POWER = IntegerStateProperties.key(ResourceKey.sponge("redstone_wire_power"));

    public static final DefaultedRegistryReference<IntegerStateProperty> RED_BANNER_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("red_banner_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> REPEATER_DELAY = IntegerStateProperties.key(ResourceKey.sponge("repeater_delay"));

    public static final DefaultedRegistryReference<IntegerStateProperty> SCAFFOLDING_DISTANCE = IntegerStateProperties.key(ResourceKey.sponge("scaffolding_distance"));

    public static final DefaultedRegistryReference<IntegerStateProperty> SEA_PICKLE_PICKLES = IntegerStateProperties.key(ResourceKey.sponge("sea_pickle_pickles"));

    public static final DefaultedRegistryReference<IntegerStateProperty> SKELETON_SKULL_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("skeleton_skull_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> SNOW_LAYERS = IntegerStateProperties.key(ResourceKey.sponge("snow_layers"));

    public static final DefaultedRegistryReference<IntegerStateProperty> SPRUCE_LEAVES_DISTANCE = IntegerStateProperties.key(ResourceKey.sponge("spruce_leaves_distance"));

    public static final DefaultedRegistryReference<IntegerStateProperty> SPRUCE_SAPLING_STAGE = IntegerStateProperties.key(ResourceKey.sponge("spruce_sapling_stage"));

    public static final DefaultedRegistryReference<IntegerStateProperty> SPRUCE_SIGN_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("spruce_sign_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> SUGAR_CANE_AGE = IntegerStateProperties.key(ResourceKey.sponge("sugar_cane_age"));

    public static final DefaultedRegistryReference<IntegerStateProperty> SWEET_BERRY_BUSH_AGE = IntegerStateProperties.key(ResourceKey.sponge("sweet_berry_bush_age"));

    public static final DefaultedRegistryReference<IntegerStateProperty> TURTLE_EGG_EGGS = IntegerStateProperties.key(ResourceKey.sponge("turtle_egg_eggs"));

    public static final DefaultedRegistryReference<IntegerStateProperty> TURTLE_EGG_HATCH = IntegerStateProperties.key(ResourceKey.sponge("turtle_egg_hatch"));

    public static final DefaultedRegistryReference<IntegerStateProperty> WATER_LEVEL = IntegerStateProperties.key(ResourceKey.sponge("water_level"));

    public static final DefaultedRegistryReference<IntegerStateProperty> WHEAT_AGE = IntegerStateProperties.key(ResourceKey.sponge("wheat_age"));

    public static final DefaultedRegistryReference<IntegerStateProperty> WHITE_BANNER_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("white_banner_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> WITHER_SKELETON_SKULL_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("wither_skeleton_skull_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> YELLOW_BANNER_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("yellow_banner_rotation"));

    public static final DefaultedRegistryReference<IntegerStateProperty> ZOMBIE_HEAD_ROTATION = IntegerStateProperties.key(ResourceKey.sponge("zombie_head_rotation"));

    // SORTFIELDS:OFF

    // @formatter:on

    private IntegerStateProperties() {
    }

    private static DefaultedRegistryReference<IntegerStateProperty> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.INTEGER_STATE_PROPERTY, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
