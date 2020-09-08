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

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * Represents all possible {@link IntegerStateProperty}s that are known to exist in
 * vanilla minecraft.
 */
public final class IntegerStateProperties {

    // SORTFIELDS:ON

    public static final Supplier<IntegerStateProperty> ACACIA_LEAVES_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "acacia_leaves_distance");

    public static final Supplier<IntegerStateProperty> ACACIA_SAPLING_STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "acacia_sapling_stage");

    public static final Supplier<IntegerStateProperty> ACACIA_SIGN_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "acacia_sign_rotation");

    public static final Supplier<IntegerStateProperty> BAMBOO_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "bamboo_age");

    public static final Supplier<IntegerStateProperty> BAMBOO_STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "bamboo_stage");

    public static final Supplier<IntegerStateProperty> BEETROOTS_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "beetroots_age");

    public static final Supplier<IntegerStateProperty> BIRCH_LEAVES_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "birch_leaves_distance");

    public static final Supplier<IntegerStateProperty> BIRCH_SAPLING_STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "birch_sapling_stage");

    public static final Supplier<IntegerStateProperty> BIRCH_SIGN_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "birch_sign_rotation");

    public static final Supplier<IntegerStateProperty> BLACK_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "black_banner_rotation");

    public static final Supplier<IntegerStateProperty> BLUE_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "blue_banner_rotation");

    public static final Supplier<IntegerStateProperty> BROWN_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "brown_banner_rotation");

    public static final Supplier<IntegerStateProperty> CACTUS_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "cactus_age");

    public static final Supplier<IntegerStateProperty> CAKE_BITES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "cake_bites");

    public static final Supplier<IntegerStateProperty> CARROTS_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "carrots_age");

    public static final Supplier<IntegerStateProperty> CAULDRON_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "cauldron_level");

    public static final Supplier<IntegerStateProperty> CHORUS_FLOWER_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "chorus_flower_age");

    public static final Supplier<IntegerStateProperty> COCOA_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "cocoa_age");

    public static final Supplier<IntegerStateProperty> COMPOSTER_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "composter_level");

    public static final Supplier<IntegerStateProperty> CREEPER_HEAD_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "creeper_head_rotation");

    public static final Supplier<IntegerStateProperty> CYAN_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "cyan_banner_rotation");

    public static final Supplier<IntegerStateProperty> DARK_OAK_LEAVES_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "dark_oak_leaves_distance");

    public static final Supplier<IntegerStateProperty> DARK_OAK_SAPLING_STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "dark_oak_sapling_stage");

    public static final Supplier<IntegerStateProperty> DARK_OAK_SIGN_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "dark_oak_sign_rotation");

    public static final Supplier<IntegerStateProperty> DAYLIGHT_DETECTOR_POWER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "daylight_detector_power");

    public static final Supplier<IntegerStateProperty> DRAGON_HEAD_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "dragon_head_rotation");

    public static final Supplier<IntegerStateProperty> FARMLAND_MOISTURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "farmland_moisture");

    public static final Supplier<IntegerStateProperty> FIRE_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "fire_age");

    public static final Supplier<IntegerStateProperty> FROSTED_ICE_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "frosted_ice_age");

    public static final Supplier<IntegerStateProperty> GRAY_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "gray_banner_rotation");

    public static final Supplier<IntegerStateProperty> GREEN_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "green_banner_rotation");

    public static final Supplier<IntegerStateProperty> HEAVY_WEIGHTED_PRESSURE_PLATE_POWER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "heavy_weighted_pressure_plate_power");

    public static final Supplier<IntegerStateProperty> JUNGLE_LEAVES_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "jungle_leaves_distance");

    public static final Supplier<IntegerStateProperty> JUNGLE_SAPLING_STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "jungle_sapling_stage");

    public static final Supplier<IntegerStateProperty> JUNGLE_SIGN_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "jungle_sign_rotation");

    public static final Supplier<IntegerStateProperty> KELP_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "kelp_age");

    public static final Supplier<IntegerStateProperty> LAVA_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "lava_level");

    public static final Supplier<IntegerStateProperty> LIGHT_BLUE_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "light_blue_banner_rotation");

    public static final Supplier<IntegerStateProperty> LIGHT_GRAY_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "light_gray_banner_rotation");

    public static final Supplier<IntegerStateProperty> LIGHT_WEIGHTED_PRESSURE_PLATE_POWER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "light_weighted_pressure_plate_power");

    public static final Supplier<IntegerStateProperty> LIME_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "lime_banner_rotation");

    public static final Supplier<IntegerStateProperty> MAGENTA_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "magenta_banner_rotation");

    public static final Supplier<IntegerStateProperty> MELON_STEM_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "melon_stem_age");

    public static final Supplier<IntegerStateProperty> NETHER_WART_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "nether_wart_age");

    public static final Supplier<IntegerStateProperty> NOTE_BLOCK_NOTE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "note_block_note");

    public static final Supplier<IntegerStateProperty> OAK_LEAVES_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "oak_leaves_distance");

    public static final Supplier<IntegerStateProperty> OAK_SAPLING_STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "oak_sapling_stage");

    public static final Supplier<IntegerStateProperty> OAK_SIGN_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "oak_sign_rotation");

    public static final Supplier<IntegerStateProperty> ORANGE_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "orange_banner_rotation");

    public static final Supplier<IntegerStateProperty> PINK_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "pink_banner_rotation");

    public static final Supplier<IntegerStateProperty> PLAYER_HEAD_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "player_head_rotation");

    public static final Supplier<IntegerStateProperty> POTATOES_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "potatoes_age");

    public static final Supplier<IntegerStateProperty> PUMPKIN_STEM_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "pumpkin_stem_age");

    public static final Supplier<IntegerStateProperty> PURPLE_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "purple_banner_rotation");

    public static final Supplier<IntegerStateProperty> REDSTONE_WIRE_POWER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "redstone_wire_power");

    public static final Supplier<IntegerStateProperty> RED_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "red_banner_rotation");

    public static final Supplier<IntegerStateProperty> REPEATER_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "repeater_delay");

    public static final Supplier<IntegerStateProperty> SCAFFOLDING_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "scaffolding_distance");

    public static final Supplier<IntegerStateProperty> SEA_PICKLE_PICKLES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "sea_pickle_pickles");

    public static final Supplier<IntegerStateProperty> SKELETON_SKULL_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "skeleton_skull_rotation");

    public static final Supplier<IntegerStateProperty> SNOW_LAYERS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "snow_layers");

    public static final Supplier<IntegerStateProperty> SPRUCE_LEAVES_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "spruce_leaves_distance");

    public static final Supplier<IntegerStateProperty> SPRUCE_SAPLING_STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "spruce_sapling_stage");

    public static final Supplier<IntegerStateProperty> SPRUCE_SIGN_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "spruce_sign_rotation");

    public static final Supplier<IntegerStateProperty> SUGAR_CANE_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "sugar_cane_age");

    public static final Supplier<IntegerStateProperty> SWEET_BERRY_BUSH_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "sweet_berry_bush_age");

    public static final Supplier<IntegerStateProperty> TURTLE_EGG_EGGS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "turtle_egg_eggs");

    public static final Supplier<IntegerStateProperty> TURTLE_EGG_HATCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "turtle_egg_hatch");

    public static final Supplier<IntegerStateProperty> WATER_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "water_level");

    public static final Supplier<IntegerStateProperty> WHEAT_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "wheat_age");

    public static final Supplier<IntegerStateProperty> WHITE_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "white_banner_rotation");

    public static final Supplier<IntegerStateProperty> WITHER_SKELETON_SKULL_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "wither_skeleton_skull_rotation");

    public static final Supplier<IntegerStateProperty> YELLOW_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "yellow_banner_rotation");

    public static final Supplier<IntegerStateProperty> ZOMBIE_HEAD_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "zombie_head_rotation");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private IntegerStateProperties() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
