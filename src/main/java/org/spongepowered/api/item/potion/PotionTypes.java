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
package org.spongepowered.api.item.potion;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all possible {@link PotionType}s in vanilla Minecraft.
 */
public final class PotionTypes {

    // SORTFIELDS:ON

    public static final PotionType AWKWARD = DummyObjectProvider.createFor(PotionType.class, "AWKWARD");

    public static final PotionType EMPTY = DummyObjectProvider.createFor(PotionType.class, "EMPTY");

    public static final PotionType FIRE_RESISTANCE = DummyObjectProvider.createFor(PotionType.class, "FIRE_RESISTANCE");

    public static final PotionType HARMING = DummyObjectProvider.createFor(PotionType.class, "HARMING");

    public static final PotionType HEALING = DummyObjectProvider.createFor(PotionType.class, "HEALING");

    public static final PotionType INVISIBILITY = DummyObjectProvider.createFor(PotionType.class, "INVISIBILITY");

    public static final PotionType LEAPING = DummyObjectProvider.createFor(PotionType.class, "LEAPING");

    public static final PotionType LONG_FIRE_RESISTANCE = DummyObjectProvider.createFor(PotionType.class, "LONG_FIRE_RESISTANCE");

    public static final PotionType LONG_INVISIBILITY = DummyObjectProvider.createFor(PotionType.class, "LONG_INVISIBILITY");

    public static final PotionType LONG_LEAPING = DummyObjectProvider.createFor(PotionType.class, "LONG_LEAPING");

    public static final PotionType LONG_NIGHT_VISION = DummyObjectProvider.createFor(PotionType.class, "LONG_NIGHT_VISION");

    public static final PotionType LONG_POISON = DummyObjectProvider.createFor(PotionType.class, "LONG_POISON");

    public static final PotionType LONG_REGENERATION = DummyObjectProvider.createFor(PotionType.class, "LONG_REGENERATION");

    public static final PotionType LONG_SLOWNESS = DummyObjectProvider.createFor(PotionType.class, "LONG_SLOWNESS");

    public static final PotionType LONG_STRENGTH = DummyObjectProvider.createFor(PotionType.class, "LONG_STRENGTH");

    public static final PotionType LONG_SWIFTNESS = DummyObjectProvider.createFor(PotionType.class, "LONG_SWIFTNESS");

    public static final PotionType LONG_WATER_BREATHING = DummyObjectProvider.createFor(PotionType.class, "LONG_WATER_BREATHING");

    public static final PotionType LONG_WEAKNESS = DummyObjectProvider.createFor(PotionType.class, "LONG_WEAKNESS");

    public static final PotionType MUNDANE = DummyObjectProvider.createFor(PotionType.class, "MUNDANE");

    public static final PotionType NIGHT_VISION = DummyObjectProvider.createFor(PotionType.class, "NIGHT_VISION");

    public static final PotionType POISON = DummyObjectProvider.createFor(PotionType.class, "POISON");

    public static final PotionType REGENERATION = DummyObjectProvider.createFor(PotionType.class, "REGENERATION");

    public static final PotionType SLOWNESS = DummyObjectProvider.createFor(PotionType.class, "SLOWNESS");

    public static final PotionType STRENGTH = DummyObjectProvider.createFor(PotionType.class, "STRENGTH");

    public static final PotionType STRONG_HARMING = DummyObjectProvider.createFor(PotionType.class, "STRONG_HARMING");

    public static final PotionType STRONG_HEALING = DummyObjectProvider.createFor(PotionType.class, "STRONG_HEALING");

    public static final PotionType STRONG_LEAPING = DummyObjectProvider.createFor(PotionType.class, "STRONG_LEAPING");

    public static final PotionType STRONG_POISON = DummyObjectProvider.createFor(PotionType.class, "STRONG_POISON");

    public static final PotionType STRONG_REGENERATION = DummyObjectProvider.createFor(PotionType.class, "STRONG_REGENERATION");

    public static final PotionType STRONG_STRENGTH = DummyObjectProvider.createFor(PotionType.class, "STRONG_STRENGTH");

    public static final PotionType STRONG_SWIFTNESS = DummyObjectProvider.createFor(PotionType.class, "STRONG_SWIFTNESS");

    public static final PotionType SWIFTNESS = DummyObjectProvider.createFor(PotionType.class, "SWIFTNESS");

    public static final PotionType THICK = DummyObjectProvider.createFor(PotionType.class, "THICK");

    public static final PotionType WATER = DummyObjectProvider.createFor(PotionType.class, "WATER");

    public static final PotionType WATER_BREATHING = DummyObjectProvider.createFor(PotionType.class, "WATER_BREATHING");

    public static final PotionType WEAKNESS = DummyObjectProvider.createFor(PotionType.class, "WEAKNESS");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private PotionTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
