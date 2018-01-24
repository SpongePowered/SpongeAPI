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
package org.spongepowered.api.effect.potion;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all possible {@link PotionEffectType}s in vanilla Minecraft.
 */
public final class PotionEffectTypes {

    // SORTFIELDS:ON

    public static final PotionEffectType ABSORPTION = DummyObjectProvider.createFor(PotionEffectType.class, "ABSORPTION");

    public static final PotionEffectType BLINDNESS = DummyObjectProvider.createFor(PotionEffectType.class, "BLINDNESS");

    public static final PotionEffectType FIRE_RESISTANCE = DummyObjectProvider.createFor(PotionEffectType.class, "FIRE_RESISTANCE");

    public static final PotionEffectType GLOWING = DummyObjectProvider.createFor(PotionEffectType.class, "GLOWING");

    public static final PotionEffectType HASTE = DummyObjectProvider.createFor(PotionEffectType.class, "HASTE");

    public static final PotionEffectType HEALTH_BOOST = DummyObjectProvider.createFor(PotionEffectType.class, "HEALTH_BOOST");

    public static final PotionEffectType HUNGER = DummyObjectProvider.createFor(PotionEffectType.class, "HUNGER");

    public static final PotionEffectType INSTANT_DAMAGE = DummyObjectProvider.createFor(PotionEffectType.class, "INSTANT_DAMAGE");

    public static final PotionEffectType INSTANT_HEALTH = DummyObjectProvider.createFor(PotionEffectType.class, "INSTANT_HEALTH");

    public static final PotionEffectType INVISIBILITY = DummyObjectProvider.createFor(PotionEffectType.class, "INVISIBILITY");

    public static final PotionEffectType JUMP_BOOST = DummyObjectProvider.createFor(PotionEffectType.class, "JUMP_BOOST");

    public static final PotionEffectType LEVITATION = DummyObjectProvider.createFor(PotionEffectType.class, "LEVITATION");

    public static final PotionEffectType LUCK = DummyObjectProvider.createFor(PotionEffectType.class, "LUCK");

    public static final PotionEffectType MINING_FATIGUE = DummyObjectProvider.createFor(PotionEffectType.class, "MINING_FATIGUE");

    public static final PotionEffectType NAUSEA = DummyObjectProvider.createFor(PotionEffectType.class, "NAUSEA");

    public static final PotionEffectType NIGHT_VISION = DummyObjectProvider.createFor(PotionEffectType.class, "NIGHT_VISION");

    public static final PotionEffectType POISON = DummyObjectProvider.createFor(PotionEffectType.class, "POISON");

    public static final PotionEffectType REGENERATION = DummyObjectProvider.createFor(PotionEffectType.class, "REGENERATION");

    public static final PotionEffectType RESISTANCE = DummyObjectProvider.createFor(PotionEffectType.class, "RESISTANCE");

    public static final PotionEffectType SATURATION = DummyObjectProvider.createFor(PotionEffectType.class, "SATURATION");

    public static final PotionEffectType SLOWNESS = DummyObjectProvider.createFor(PotionEffectType.class, "SLOWNESS");

    public static final PotionEffectType SPEED = DummyObjectProvider.createFor(PotionEffectType.class, "SPEED");

    public static final PotionEffectType STRENGTH = DummyObjectProvider.createFor(PotionEffectType.class, "STRENGTH");

    public static final PotionEffectType UNLUCK = DummyObjectProvider.createFor(PotionEffectType.class, "UNLUCK");

    public static final PotionEffectType WATER_BREATHING = DummyObjectProvider.createFor(PotionEffectType.class, "WATER_BREATHING");

    public static final PotionEffectType WEAKNESS = DummyObjectProvider.createFor(PotionEffectType.class, "WEAKNESS");

    public static final PotionEffectType WITHER = DummyObjectProvider.createFor(PotionEffectType.class, "WITHER");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private PotionEffectTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
