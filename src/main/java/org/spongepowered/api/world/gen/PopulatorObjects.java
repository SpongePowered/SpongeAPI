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
 * A pseudo-enum of {@link PopulatorObject}s.
 */
public final class PopulatorObjects {

    // Populators
    // SORTFIELDS:ON

    public static final PopulatorObject DESERT_WELL = DummyObjectProvider.createFor(PopulatorObject.class, "DESERT_WELL");

    // SORTFIELDS:OFF

    // Trees
    // SORTFIELDS:ON

    public static final PopulatorObject BIRCH = DummyObjectProvider.createFor(PopulatorObject.class, "BIRCH");

    public static final PopulatorObject CANOPY = DummyObjectProvider.createFor(PopulatorObject.class, "CANOPY");

    public static final PopulatorObject JUNGLE = DummyObjectProvider.createFor(PopulatorObject.class, "JUNGLE");

    public static final PopulatorObject JUNGLE_BUSH = DummyObjectProvider.createFor(PopulatorObject.class, "JUNGLE_BUSH");

    public static final PopulatorObject MEGA_BIRCH = DummyObjectProvider.createFor(PopulatorObject.class, "MEGA_BIRCH");

    public static final PopulatorObject MEGA_JUNGLE = DummyObjectProvider.createFor(PopulatorObject.class, "MEGA_JUNGLE");

    public static final PopulatorObject MEGA_OAK = DummyObjectProvider.createFor(PopulatorObject.class, "MEGA_OAK");

    public static final PopulatorObject MEGA_POINTY_TAIGA = DummyObjectProvider.createFor(PopulatorObject.class, "MEGA_POINTY_TAIGA");

    public static final PopulatorObject MEGA_TALL_TAIGA = DummyObjectProvider.createFor(PopulatorObject.class, "MEGA_TALL_TAIGA");

    public static final PopulatorObject OAK = DummyObjectProvider.createFor(PopulatorObject.class, "OAK");

    public static final PopulatorObject POINTY_TAIGA = DummyObjectProvider.createFor(PopulatorObject.class, "POINTY_TAIGA");

    public static final PopulatorObject SAVANNA = DummyObjectProvider.createFor(PopulatorObject.class, "SAVANNA");

    public static final PopulatorObject SWAMP = DummyObjectProvider.createFor(PopulatorObject.class, "SWAMP");

    public static final PopulatorObject TALL_TAIGA = DummyObjectProvider.createFor(PopulatorObject.class, "TALL_TAIGA");

    // SORTFIELDS:OFF

    // Mushrooms
    // SORTFIELDS:ON

    public static final PopulatorObject BROWN = DummyObjectProvider.createFor(PopulatorObject.class, "BROWN");

    public static final PopulatorObject RED = DummyObjectProvider.createFor(PopulatorObject.class, "RED");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private PopulatorObjects() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
