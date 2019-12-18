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

    public static final Supplier<IntegerStateProperty> ACACIA_LEAVES_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "ACACIA_LEAVES_DISTANCE");

    public static final Supplier<IntegerStateProperty> ACACIA_SAPLING_STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "ACACIA_SAPLING_STAGE");

    public static final Supplier<IntegerStateProperty> ACACIA_SIGN_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "ACACIA_SIGN_ROTATION");

    public static final Supplier<IntegerStateProperty> BAMBOO_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "BAMBOO_AGE");

    public static final Supplier<IntegerStateProperty> BAMBOO_STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "BAMBOO_STAGE");

    public static final Supplier<IntegerStateProperty> BEETROOTS_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "BEETROOTS_AGE");

    public static final Supplier<IntegerStateProperty> BIRCH_LEAVES_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "BIRCH_LEAVES_DISTANCE");

    public static final Supplier<IntegerStateProperty> BIRCH_SAPLING_STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "BIRCH_SAPLING_STAGE");

    public static final Supplier<IntegerStateProperty> BIRCH_SIGN_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "BIRCH_SIGN_ROTATION");

    public static final Supplier<IntegerStateProperty> BLACK_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "BLACK_BANNER_ROTATION");

    public static final Supplier<IntegerStateProperty> BLUE_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "BLUE_BANNER_ROTATION");

    public static final Supplier<IntegerStateProperty> BROWN_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "BROWN_BANNER_ROTATION");

    public static final Supplier<IntegerStateProperty> CACTUS_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "CACTUS_AGE");

    public static final Supplier<IntegerStateProperty> CAKE_BITES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "CAKE_BITES");

    public static final Supplier<IntegerStateProperty> CARROTS_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "CARROTS_AGE");

    public static final Supplier<IntegerStateProperty> CAULDRON_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "CAULDRON_LEVEL");

    public static final Supplier<IntegerStateProperty> CHORUS_FLOWER_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "CHORUS_FLOWER_AGE");

    public static final Supplier<IntegerStateProperty> COCOA_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "COCOA_AGE");

    public static final Supplier<IntegerStateProperty> COMPOSTER_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "COMPOSTER_LEVEL");

    public static final Supplier<IntegerStateProperty> CREEPER_HEAD_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "CREEPER_HEAD_ROTATION");

    public static final Supplier<IntegerStateProperty> CYAN_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "CYAN_BANNER_ROTATION");

    public static final Supplier<IntegerStateProperty> DARK_OAK_LEAVES_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "DARK_OAK_LEAVES_DISTANCE");

    public static final Supplier<IntegerStateProperty> DARK_OAK_SAPLING_STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "DARK_OAK_SAPLING_STAGE");

    public static final Supplier<IntegerStateProperty> DARK_OAK_SIGN_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "DARK_OAK_SIGN_ROTATION");

    public static final Supplier<IntegerStateProperty> DAYLIGHT_DETECTOR_POWER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "DAYLIGHT_DETECTOR_POWER");

    public static final Supplier<IntegerStateProperty> DRAGON_HEAD_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "DRAGON_HEAD_ROTATION");

    public static final Supplier<IntegerStateProperty> FARMLAND_MOISTURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "FARMLAND_MOISTURE");

    public static final Supplier<IntegerStateProperty> FIRE_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "FIRE_AGE");

    public static final Supplier<IntegerStateProperty> FROSTED_ICE_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "FROSTED_ICE_AGE");

    public static final Supplier<IntegerStateProperty> GRAY_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "GRAY_BANNER_ROTATION");

    public static final Supplier<IntegerStateProperty> GREEN_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "GREEN_BANNER_ROTATION");

    public static final Supplier<IntegerStateProperty> HEAVY_WEIGHTED_PRESSURE_PLATE_POWER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "HEAVY_WEIGHTED_PRESSURE_PLATE_POWER");

    public static final Supplier<IntegerStateProperty> JUNGLE_LEAVES_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "JUNGLE_LEAVES_DISTANCE");

    public static final Supplier<IntegerStateProperty> JUNGLE_SAPLING_STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "JUNGLE_SAPLING_STAGE");

    public static final Supplier<IntegerStateProperty> JUNGLE_SIGN_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "JUNGLE_SIGN_ROTATION");

    public static final Supplier<IntegerStateProperty> KELP_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "KELP_AGE");

    public static final Supplier<IntegerStateProperty> LAVA_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "LAVA_LEVEL");

    public static final Supplier<IntegerStateProperty> LIGHT_BLUE_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "LIGHT_BLUE_BANNER_ROTATION");

    public static final Supplier<IntegerStateProperty> LIGHT_GRAY_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "LIGHT_GRAY_BANNER_ROTATION");

    public static final Supplier<IntegerStateProperty> LIGHT_WEIGHTED_PRESSURE_PLATE_POWER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "LIGHT_WEIGHTED_PRESSURE_PLATE_POWER");

    public static final Supplier<IntegerStateProperty> LIME_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "LIME_BANNER_ROTATION");

    public static final Supplier<IntegerStateProperty> MAGENTA_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "MAGENTA_BANNER_ROTATION");

    public static final Supplier<IntegerStateProperty> MELON_STEM_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "MELON_STEM_AGE");

    public static final Supplier<IntegerStateProperty> NETHER_WART_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "NETHER_WART_AGE");

    public static final Supplier<IntegerStateProperty> NOTE_BLOCK_NOTE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "NOTE_BLOCK_NOTE");

    public static final Supplier<IntegerStateProperty> OAK_LEAVES_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "OAK_LEAVES_DISTANCE");

    public static final Supplier<IntegerStateProperty> OAK_SAPLING_STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "OAK_SAPLING_STAGE");

    public static final Supplier<IntegerStateProperty> OAK_SIGN_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "OAK_SIGN_ROTATION");

    public static final Supplier<IntegerStateProperty> ORANGE_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "ORANGE_BANNER_ROTATION");

    public static final Supplier<IntegerStateProperty> PINK_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "PINK_BANNER_ROTATION");

    public static final Supplier<IntegerStateProperty> PLAYER_HEAD_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "PLAYER_HEAD_ROTATION");

    public static final Supplier<IntegerStateProperty> POTATOES_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "POTATOES_AGE");

    public static final Supplier<IntegerStateProperty> PUMPKIN_STEM_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "PUMPKIN_STEM_AGE");

    public static final Supplier<IntegerStateProperty> PURPLE_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "PURPLE_BANNER_ROTATION");

    public static final Supplier<IntegerStateProperty> REDSTONE_WIRE_POWER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "REDSTONE_WIRE_POWER");

    public static final Supplier<IntegerStateProperty> RED_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "RED_BANNER_ROTATION");

    public static final Supplier<IntegerStateProperty> REPEATER_DELAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "REPEATER_DELAY");

    public static final Supplier<IntegerStateProperty> SCAFFOLDING_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "SCAFFOLDING_DISTANCE");

    public static final Supplier<IntegerStateProperty> SEA_PICKLE_PICKLES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "SEA_PICKLE_PICKLES");

    public static final Supplier<IntegerStateProperty> SKELETON_SKULL_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "SKELETON_SKULL_ROTATION");

    public static final Supplier<IntegerStateProperty> SNOW_LAYERS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "SNOW_LAYERS");

    public static final Supplier<IntegerStateProperty> SPRUCE_LEAVES_DISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "SPRUCE_LEAVES_DISTANCE");

    public static final Supplier<IntegerStateProperty> SPRUCE_SAPLING_STAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "SPRUCE_SAPLING_STAGE");

    public static final Supplier<IntegerStateProperty> SPRUCE_SIGN_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "SPRUCE_SIGN_ROTATION");

    public static final Supplier<IntegerStateProperty> SUGAR_CANE_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "SUGAR_CANE_AGE");

    public static final Supplier<IntegerStateProperty> SWEET_BERRY_BUSH_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "SWEET_BERRY_BUSH_AGE");

    public static final Supplier<IntegerStateProperty> TURTLE_EGG_EGGS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "TURTLE_EGG_EGGS");

    public static final Supplier<IntegerStateProperty> TURTLE_EGG_HATCH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "TURTLE_EGG_HATCH");

    public static final Supplier<IntegerStateProperty> WATER_LEVEL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "WATER_LEVEL");

    public static final Supplier<IntegerStateProperty> WHEAT_AGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "WHEAT_AGE");

    public static final Supplier<IntegerStateProperty> WHITE_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "WHITE_BANNER_ROTATION");

    public static final Supplier<IntegerStateProperty> WITHER_SKELETON_SKULL_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "WITHER_SKELETON_SKULL_ROTATION");

    public static final Supplier<IntegerStateProperty> YELLOW_BANNER_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "YELLOW_BANNER_ROTATION");

    public static final Supplier<IntegerStateProperty> ZOMBIE_HEAD_ROTATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(IntegerStateProperty.class, "ZOMBIE_HEAD_ROTATION");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private IntegerStateProperties() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
