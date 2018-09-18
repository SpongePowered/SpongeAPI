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
package org.spongepowered.api.block.trait;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * Represents all possible {@link IntegerTrait}s that are known to exist in
 * vanilla minecraft.
 */
public final class IntegerTraits {

    // SORTFIELDS:ON

    public static final IntegerTrait ANVIL_DAMAGE = DummyObjectProvider.createFor(IntegerTrait.class, "ANVIL_DAMAGE");

    public static final IntegerTrait BEETROOT_AGE = DummyObjectProvider.createFor(IntegerTrait.class, "BEETROOT_AGE");

    public static final IntegerTrait CACTUS_AGE = DummyObjectProvider.createFor(IntegerTrait.class, "CACTUS_AGE");

    public static final IntegerTrait CAKE_BITES = DummyObjectProvider.createFor(IntegerTrait.class, "CAKE_BITES");

    public static final IntegerTrait CARROTS_AGE = DummyObjectProvider.createFor(IntegerTrait.class, "CARROTS_AGE");

    public static final IntegerTrait CAULDRON_LEVEL = DummyObjectProvider.createFor(IntegerTrait.class, "CAULDRON_LEVEL");

    public static final IntegerTrait COCOA_AGE = DummyObjectProvider.createFor(IntegerTrait.class, "COCOA_AGE");

    public static final IntegerTrait DAYLIGHT_DETECTOR_INVERTED_POWER = DummyObjectProvider.createFor(IntegerTrait.class, "DAYLIGHT_DETECTOR_INVERTED_POWER");

    public static final IntegerTrait DAYLIGHT_DETECTOR_POWER = DummyObjectProvider.createFor(IntegerTrait.class, "DAYLIGHT_DETECTOR_POWER");

    public static final IntegerTrait FARMLAND_MOISTURE = DummyObjectProvider.createFor(IntegerTrait.class, "FARMLAND_MOISTURE");

    public static final IntegerTrait FIRE_AGE = DummyObjectProvider.createFor(IntegerTrait.class, "FIRE_AGE");

    public static final IntegerTrait FLOWER_POT_LEGACY_DATA = DummyObjectProvider.createFor(IntegerTrait.class, "FLOWER_POT_LEGACY_DATA");

    public static final IntegerTrait FLOWING_LAVA_LEVEL = DummyObjectProvider.createFor(IntegerTrait.class, "FLOWING_LAVA_LEVEL");

    public static final IntegerTrait FLOWING_WATER_LEVEL = DummyObjectProvider.createFor(IntegerTrait.class, "FLOWING_WATER_LEVEL");

    public static final IntegerTrait HEAVY_WEIGHTED_PRESSURE_PLATE_POWER = DummyObjectProvider.createFor(IntegerTrait.class, "HEAVY_WEIGHTED_PRESSURE_PLATE_POWER");

    public static final IntegerTrait LAVA_LEVEL = DummyObjectProvider.createFor(IntegerTrait.class, "LAVA_LEVEL");

    public static final IntegerTrait LIGHT_WEIGHTED_PRESSURE_PLATE_POWER = DummyObjectProvider.createFor(IntegerTrait.class, "LIGHT_WEIGHTED_PRESSURE_PLATE_POWER");

    public static final IntegerTrait MELON_STEM_AGE = DummyObjectProvider.createFor(IntegerTrait.class, "MELON_STEM_AGE");

    public static final IntegerTrait NETHER_WART_AGE = DummyObjectProvider.createFor(IntegerTrait.class, "NETHER_WART_AGE");

    public static final IntegerTrait POTATOES_AGE = DummyObjectProvider.createFor(IntegerTrait.class, "POTATOES_AGE");

    public static final IntegerTrait POWERED_REPEATER_DELAY = DummyObjectProvider.createFor(IntegerTrait.class, "POWERED_REPEATER_DELAY");

    public static final IntegerTrait PUMPKIN_STEM_AGE = DummyObjectProvider.createFor(IntegerTrait.class, "PUMPKIN_STEM_AGE");

    public static final IntegerTrait REDSTONE_WIRE_POWER = DummyObjectProvider.createFor(IntegerTrait.class, "REDSTONE_WIRE_POWER");

    public static final IntegerTrait REEDS_AGE = DummyObjectProvider.createFor(IntegerTrait.class, "REEDS_AGE");

    public static final IntegerTrait SAPLING_STAGE = DummyObjectProvider.createFor(IntegerTrait.class, "SAPLING_STAGE");

    public static final IntegerTrait SNOW_LAYER_LAYERS = DummyObjectProvider.createFor(IntegerTrait.class, "SNOW_LAYER_LAYERS");

    public static final IntegerTrait STANDING_BANNER_ROTATION = DummyObjectProvider.createFor(IntegerTrait.class, "STANDING_BANNER_ROTATION");

    public static final IntegerTrait STANDING_SIGN_ROTATION = DummyObjectProvider.createFor(IntegerTrait.class, "STANDING_SIGN_ROTATION");

    public static final IntegerTrait UNPOWERED_REPEATER_DELAY = DummyObjectProvider.createFor(IntegerTrait.class, "UNPOWERED_REPEATER_DELAY");

    public static final IntegerTrait WATER_LEVEL = DummyObjectProvider.createFor(IntegerTrait.class, "WATER_LEVEL");

    public static final IntegerTrait WHEAT_AGE = DummyObjectProvider.createFor(IntegerTrait.class, "WHEAT_AGE");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private IntegerTraits() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
