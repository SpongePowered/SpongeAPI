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
package org.spongepowered.api.world.gen;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all possible {@link PopulatorType}s available in vanilla
 * minecraft.
 */
public final class PopulatorTypes {

    // SORTFIELDS:ON

    public static final PopulatorType BIG_MUSHROOM = DummyObjectProvider.createFor(PopulatorType.class, "BIG_MUSHROOM");

    public static final PopulatorType BLOCK_BLOB = DummyObjectProvider.createFor(PopulatorType.class, "BLOCK_BLOB");

    public static final PopulatorType CACTUS = DummyObjectProvider.createFor(PopulatorType.class, "CACTUS");

    public static final PopulatorType CHORUS_FLOWER = DummyObjectProvider.createFor(PopulatorType.class, "CHORUS_FLOWER");

    public static final PopulatorType DEAD_BUSH = DummyObjectProvider.createFor(PopulatorType.class, "DEAD_BUSH");

    public static final PopulatorType DESERT_WELL = DummyObjectProvider.createFor(PopulatorType.class, "DESERT_WELL");

    public static final PopulatorType DOUBLE_PLANT = DummyObjectProvider.createFor(PopulatorType.class, "DOUBLE_PLANT");

    public static final PopulatorType DUNGEON = DummyObjectProvider.createFor(PopulatorType.class, "DUNGEON");

    public static final PopulatorType END_ISLAND = DummyObjectProvider.createFor(PopulatorType.class, "END_ISLAND");

    public static final PopulatorType FLOWER = DummyObjectProvider.createFor(PopulatorType.class, "FLOWER");

    public static final PopulatorType FOREST = DummyObjectProvider.createFor(PopulatorType.class, "FOREST");

    public static final PopulatorType FOSSIL = DummyObjectProvider.createFor(PopulatorType.class, "FOSSIL");

    public static final PopulatorType GENERIC_BLOCK = DummyObjectProvider.createFor(PopulatorType.class, "GENERIC_BLOCK");

    public static final PopulatorType GENERIC_OBJECT = DummyObjectProvider.createFor(PopulatorType.class, "GENERIC_OBJECT");

    public static final PopulatorType GLOWSTONE = DummyObjectProvider.createFor(PopulatorType.class, "GLOWSTONE");

    public static final PopulatorType ICE_PATH = DummyObjectProvider.createFor(PopulatorType.class, "ICE_PATH");

    public static final PopulatorType ICE_SPIKE = DummyObjectProvider.createFor(PopulatorType.class, "ICE_SPIKE");

    public static final PopulatorType LAKE = DummyObjectProvider.createFor(PopulatorType.class, "LAKE");

    public static final PopulatorType MELON = DummyObjectProvider.createFor(PopulatorType.class, "MELON");

    public static final PopulatorType MUSHROOM = DummyObjectProvider.createFor(PopulatorType.class, "MUSHROOM");

    public static final PopulatorType NETHER_FIRE = DummyObjectProvider.createFor(PopulatorType.class, "NETHER_FIRE");

    public static final PopulatorType ORE = DummyObjectProvider.createFor(PopulatorType.class, "ORE");

    public static final PopulatorType PUMPKIN = DummyObjectProvider.createFor(PopulatorType.class, "PUMPKIN");

    public static final PopulatorType REED = DummyObjectProvider.createFor(PopulatorType.class, "REED");

    public static final PopulatorType SEA_FLOOR = DummyObjectProvider.createFor(PopulatorType.class, "SEA_FLOOR");

    public static final PopulatorType SHRUB = DummyObjectProvider.createFor(PopulatorType.class, "SHRUB");

    public static final PopulatorType VINE = DummyObjectProvider.createFor(PopulatorType.class, "VINE");

    public static final PopulatorType WATER_LILY = DummyObjectProvider.createFor(PopulatorType.class, "WATER_LILY");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private PopulatorTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
