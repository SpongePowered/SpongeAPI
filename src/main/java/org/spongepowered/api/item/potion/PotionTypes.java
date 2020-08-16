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

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * An enumeration of all possible {@link PotionType}s in vanilla Minecraft.
 */
public final class PotionTypes {

    // SORTFIELDS:ON

    public static final Supplier<PotionType> AWKWARD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "awkward");

    public static final Supplier<PotionType> EMPTY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "empty");

    public static final Supplier<PotionType> FIRE_RESISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "fire_resistance");

    public static final Supplier<PotionType> HARMING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "harming");

    public static final Supplier<PotionType> HEALING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "healing");

    public static final Supplier<PotionType> INVISIBILITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "invisibility");

    public static final Supplier<PotionType> LEAPING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "leaping");

    public static final Supplier<PotionType> LONG_FIRE_RESISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "long_fire_resistance");

    public static final Supplier<PotionType> LONG_INVISIBILITY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "long_invisibility");

    public static final Supplier<PotionType> LONG_LEAPING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "long_leaping");

    public static final Supplier<PotionType> LONG_NIGHT_VISION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "long_night_vision");

    public static final Supplier<PotionType> LONG_POISON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "long_poison");

    public static final Supplier<PotionType> LONG_REGENERATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "long_regeneration");

    public static final Supplier<PotionType> LONG_SLOWNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "long_slowness");

    public static final Supplier<PotionType> LONG_SLOW_FALLING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "long_slow_falling");

    public static final Supplier<PotionType> LONG_STRENGTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "long_strength");

    public static final Supplier<PotionType> LONG_SWIFTNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "long_swiftness");

    public static final Supplier<PotionType> LONG_TURTLE_MASTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "long_turtle_master");

    public static final Supplier<PotionType> LONG_WATER_BREATHING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "long_water_breathing");

    public static final Supplier<PotionType> LONG_WEAKNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "long_weakness");

    public static final Supplier<PotionType> LUCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "luck");

    public static final Supplier<PotionType> MUNDANE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "mundane");

    public static final Supplier<PotionType> NIGHT_VISION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "night_vision");

    public static final Supplier<PotionType> POISON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "poison");

    public static final Supplier<PotionType> REGENERATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "regeneration");

    public static final Supplier<PotionType> SLOWNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "slowness");

    public static final Supplier<PotionType> SLOW_FALLING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "slow_falling");

    public static final Supplier<PotionType> STRENGTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "strength");

    public static final Supplier<PotionType> STRONG_HARMING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "strong_harming");

    public static final Supplier<PotionType> STRONG_HEALING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "strong_healing");

    public static final Supplier<PotionType> STRONG_LEAPING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "strong_leaping");

    public static final Supplier<PotionType> STRONG_POISON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "strong_poison");

    public static final Supplier<PotionType> STRONG_REGENERATION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "strong_regeneration");

    public static final Supplier<PotionType> STRONG_SLOWNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "strong_slowness");

    public static final Supplier<PotionType> STRONG_STRENGTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "strong_strength");

    public static final Supplier<PotionType> STRONG_SWIFTNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "strong_swiftness");

    public static final Supplier<PotionType> STRONG_TURTLE_MASTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "strong_turtle_master");

    public static final Supplier<PotionType> SWIFTNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "swiftness");

    public static final Supplier<PotionType> THICK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "thick");

    public static final Supplier<PotionType> TURTLE_MASTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "turtle_master");

    public static final Supplier<PotionType> WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "water");

    public static final Supplier<PotionType> WATER_BREATHING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "water_breathing");

    public static final Supplier<PotionType> WEAKNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(PotionType.class, "weakness");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private PotionTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
