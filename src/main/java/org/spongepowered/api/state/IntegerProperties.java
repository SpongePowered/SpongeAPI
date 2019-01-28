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

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * Represents all possible {@link IntegerProperty}s that are known to exist in
 * vanilla minecraft.
 */
public final class IntegerProperties {

    // SORTFIELDS:ON

    public static final IntegerProperty ANVIL_DAMAGE = DummyObjectProvider.createFor(IntegerProperty.class, "ANVIL_DAMAGE");

    public static final IntegerProperty CACTUS_AGE = DummyObjectProvider.createFor(IntegerProperty.class, "CACTUS_AGE");

    public static final IntegerProperty CAKE_BITES = DummyObjectProvider.createFor(IntegerProperty.class, "CAKE_BITES");

    public static final IntegerProperty CARROTS_AGE = DummyObjectProvider.createFor(IntegerProperty.class, "CARROTS_AGE");

    public static final IntegerProperty CAULDRON_LEVEL = DummyObjectProvider.createFor(IntegerProperty.class, "CAULDRON_LEVEL");

    public static final IntegerProperty COCOA_AGE = DummyObjectProvider.createFor(IntegerProperty.class, "COCOA_AGE");

    public static final IntegerProperty
        DAYLIGHT_DETECTOR_INVERTED_POWER = DummyObjectProvider.createFor(IntegerProperty.class, "DAYLIGHT_DETECTOR_INVERTED_POWER");

    public static final IntegerProperty DAYLIGHT_DETECTOR_POWER = DummyObjectProvider.createFor(IntegerProperty.class, "DAYLIGHT_DETECTOR_POWER");

    public static final IntegerProperty FARMLAND_MOISTURE = DummyObjectProvider.createFor(IntegerProperty.class, "FARMLAND_MOISTURE");

    public static final IntegerProperty FIRE_AGE = DummyObjectProvider.createFor(IntegerProperty.class, "FIRE_AGE");

    public static final IntegerProperty FLOWER_POT_LEGACY_DATA = DummyObjectProvider.createFor(IntegerProperty.class, "FLOWER_POT_LEGACY_DATA");

    public static final IntegerProperty FLOWING_LAVA_LEVEL = DummyObjectProvider.createFor(IntegerProperty.class, "FLOWING_LAVA_LEVEL");

    public static final IntegerProperty FLOWING_WATER_LEVEL = DummyObjectProvider.createFor(IntegerProperty.class, "FLOWING_WATER_LEVEL");

    public static final IntegerProperty
        HEAVY_WEIGHTED_PRESSURE_PLATE_POWER = DummyObjectProvider.createFor(IntegerProperty.class, "HEAVY_WEIGHTED_PRESSURE_PLATE_POWER");

    public static final IntegerProperty LAVA_LEVEL = DummyObjectProvider.createFor(IntegerProperty.class, "LAVA_LEVEL");

    public static final IntegerProperty
        LIGHT_WEIGHTED_PRESSURE_PLATE_POWER = DummyObjectProvider.createFor(IntegerProperty.class, "LIGHT_WEIGHTED_PRESSURE_PLATE_POWER");

    public static final IntegerProperty MELON_STEM_AGE = DummyObjectProvider.createFor(IntegerProperty.class, "MELON_STEM_AGE");

    public static final IntegerProperty NETHER_WART_AGE = DummyObjectProvider.createFor(IntegerProperty.class, "NETHER_WART_AGE");

    public static final IntegerProperty POTATOES_AGE = DummyObjectProvider.createFor(IntegerProperty.class, "POTATOES_AGE");

    public static final IntegerProperty POWERED_REPEATER_DELAY = DummyObjectProvider.createFor(IntegerProperty.class, "POWERED_REPEATER_DELAY");

    public static final IntegerProperty PUMPKIN_STEM_AGE = DummyObjectProvider.createFor(IntegerProperty.class, "PUMPKIN_STEM_AGE");

    public static final IntegerProperty REDSTONE_WIRE_POWER = DummyObjectProvider.createFor(IntegerProperty.class, "REDSTONE_WIRE_POWER");

    public static final IntegerProperty REEDS_AGE = DummyObjectProvider.createFor(IntegerProperty.class, "REEDS_AGE");

    public static final IntegerProperty SAPLING_STAGE = DummyObjectProvider.createFor(IntegerProperty.class, "SAPLING_STAGE");

    public static final IntegerProperty SNOW_LAYER_LAYERS = DummyObjectProvider.createFor(IntegerProperty.class, "SNOW_LAYER_LAYERS");

    public static final IntegerProperty STANDING_BANNER_ROTATION = DummyObjectProvider.createFor(IntegerProperty.class, "STANDING_BANNER_ROTATION");

    public static final IntegerProperty STANDING_SIGN_ROTATION = DummyObjectProvider.createFor(IntegerProperty.class, "STANDING_SIGN_ROTATION");

    public static final IntegerProperty UNPOWERED_REPEATER_DELAY = DummyObjectProvider.createFor(IntegerProperty.class, "UNPOWERED_REPEATER_DELAY");

    public static final IntegerProperty WATER_LEVEL = DummyObjectProvider.createFor(IntegerProperty.class, "WATER_LEVEL");

    public static final IntegerProperty WHEAT_AGE = DummyObjectProvider.createFor(IntegerProperty.class, "WHEAT_AGE");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private IntegerProperties() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
