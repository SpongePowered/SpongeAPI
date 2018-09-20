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
package org.spongepowered.api.effect.particle;

import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all possible {@link ParticleType}s in vanilla minecraft.
 */
public final class ParticleTypes {

    // SORTFIELDS:ON

    public static final ParticleType AMBIENT_ENTITY_EFFECT = DummyObjectProvider.createFor(ParticleType.class, "AMBIENT_ENTITY_EFFECT");

    public static final ParticleType ANGRY_VILLAGER = DummyObjectProvider.createFor(ParticleType.class, "ANGRY_VILLAGER");

    public static final ParticleType BARRIER = DummyObjectProvider.createFor(ParticleType.class, "BARRIER");

    public static final ParticleType BLOCK = DummyObjectProvider.createFor(ParticleType.class, "BLOCK");

    /**
     * This particle type will play the effect of a block that
     * is being broken and it's break sound.
     *
     * <p>This type has limited {@link ParticleOption}s, only
     * {@link ParticleOptions#BLOCK_STATE} and
     * {@link ParticleOptions#ITEM_STACK_SNAPSHOT} are supported.</p>
     */
    public static final ParticleType BREAK_BLOCK = DummyObjectProvider.createFor(ParticleType.class, "BREAK_BLOCK");

    public static final ParticleType BREAK_EYE_OF_ENDER = DummyObjectProvider.createFor(ParticleType.class, "BREAK_EYE_OF_ENDER");

    public static final ParticleType BREAK_SPLASH_POTION = DummyObjectProvider.createFor(ParticleType.class, "BREAK_SPLASH_POTION");

    public static final ParticleType BUBBLE = DummyObjectProvider.createFor(ParticleType.class, "BUBBLE");

    public static final ParticleType BUBBLE_COLUMN_UP = DummyObjectProvider.createFor(ParticleType.class, "BUBBLE_COLUMN_UP");

    public static final ParticleType BUBBLE_POP = DummyObjectProvider.createFor(ParticleType.class, "SQUID_INK");

    public static final ParticleType CLOUD = DummyObjectProvider.createFor(ParticleType.class, "CLOUD");

    public static final ParticleType CRITICAL_HIT = DummyObjectProvider.createFor(ParticleType.class, "CRITICAL_HIT");

    public static final ParticleType CURRENT_DOWN = DummyObjectProvider.createFor(ParticleType.class, "CURRENT_DOWN");

    public static final ParticleType DAMAGE_INDICATOR = DummyObjectProvider.createFor(ParticleType.class, "DAMAGE_INDICATOR");

    public static final ParticleType DOLPHIN_SPEED = DummyObjectProvider.createFor(ParticleType.class, "DOLPHIN_SPEED");

    public static final ParticleType DRAGON_BREATH = DummyObjectProvider.createFor(ParticleType.class, "DRAGON_BREATH");

    public static final ParticleType DRAGON_BREATH_ATTACK = DummyObjectProvider.createFor(ParticleType.class, "DRAGON_BREATH_ATTACK");

    public static final ParticleType DRIPPING_LAVA = DummyObjectProvider.createFor(ParticleType.class, "DRIPPING_LAVA");

    public static final ParticleType DRIPPING_WATER = DummyObjectProvider.createFor(ParticleType.class, "DRIPPING_WATER");

    /**
     * While this particle type the option {@link ParticleOptions#SCALE} supports, the maximum value
     * that is supported is {@code 4.0} and higher values will be limited to this maximum.
     */
    public static final ParticleType DUST = DummyObjectProvider.createFor(ParticleType.class, "DUST");

    /**
     * While this particle type the option {@link ParticleOptions#VELOCITY} supports, this
     * will only affect the velocity in the y direction.
     */
    public static final ParticleType EFFECT = DummyObjectProvider.createFor(ParticleType.class, "EFFECT");

    public static final ParticleType ELDER_GUARDIAN = DummyObjectProvider.createFor(ParticleType.class, "ELDER_GUARDIAN");

    public static final ParticleType ENCHANTED_HIT = DummyObjectProvider.createFor(ParticleType.class, "ENCHANTED_HIT");

    public static final ParticleType ENCHANTING_GLYPHS = DummyObjectProvider.createFor(ParticleType.class, "ENCHANTING_GLYPHS");

    public static final ParticleType END_ROD = DummyObjectProvider.createFor(ParticleType.class, "END_ROD");

    public static final ParticleType ENTITY_EFFECT = DummyObjectProvider.createFor(ParticleType.class, "ENTITY_EFFECT");

    public static final ParticleType EXPLOSION = DummyObjectProvider.createFor(ParticleType.class, "EXPLOSION");

    public static final ParticleType EXPLOSION_EMITTER = DummyObjectProvider.createFor(ParticleType.class, "EXPLOSION_EMITTER");

    public static final ParticleType FALLING_DUST = DummyObjectProvider.createFor(ParticleType.class, "FALLING_DUST");

    /**
     * This particle type will play the effect that will occur when
     * a {@link Player} uses bone meal on a plant to boost the growth,
     * this can only be played at a block location that isn't {@link BlockTypes#AIR}.
     * <p>This type has limited {@link ParticleOption}s, only
     * {@link ParticleOptions#QUANTITY} is supported.</p>
     *
     * <p>This type can no longer be spawned on air blocks. It will only
     * show up if spawned at the location of solid blocks.</p>
     */
    public static final ParticleType FERTILIZER = DummyObjectProvider.createFor(ParticleType.class, "FERTILIZER");

    /**
     * This particle type will play a fireworks effect.
     *
     * <p>This type has limited {@link ParticleOption}s, only
     * {@link ParticleOptions#FIREWORK_EFFECTS} is supported.</p>
     */
    public static final ParticleType FIREWORKS = DummyObjectProvider.createFor(ParticleType.class, "FIREWORKS");

    public static final ParticleType FIREWORKS_SPARK = DummyObjectProvider.createFor(ParticleType.class, "FIREWORKS_SPARK");

    /**
     * This particle type will play the smoke particles of a fire.
     * <p>This type has limited {@link ParticleOption}s, only
     * {@link ParticleOptions#DIRECTION} is supported.</p>
     */
    public static final ParticleType FIRE_SMOKE = DummyObjectProvider.createFor(ParticleType.class, "FIRE_SMOKE");

    public static final ParticleType FISHING = DummyObjectProvider.createFor(ParticleType.class, "FISHING");

    public static final ParticleType FLAME = DummyObjectProvider.createFor(ParticleType.class, "FLAME");

    public static final ParticleType HAPPY_VILLAGER = DummyObjectProvider.createFor(ParticleType.class, "HAPPY_VILLAGER");

    public static final ParticleType HEART = DummyObjectProvider.createFor(ParticleType.class, "HEART");

    /**
     * While this particle type the option {@link ParticleOptions#VELOCITY}
     * supports, this will only affect the velocity in the y direction.
     */
    public static final ParticleType INSTANT_EFFECT = DummyObjectProvider.createFor(ParticleType.class, "INSTANT_EFFECT");

    public static final ParticleType ITEM = DummyObjectProvider.createFor(ParticleType.class, "ITEM");

    public static final ParticleType ITEM_SLIME = DummyObjectProvider.createFor(ParticleType.class, "ITEM_SLIME");

    public static final ParticleType ITEM_SNOWBALL = DummyObjectProvider.createFor(ParticleType.class, "ITEM_SNOWBALL");

    public static final ParticleType LARGE_SMOKE = DummyObjectProvider.createFor(ParticleType.class, "LARGE_SMOKE");

    public static final ParticleType LAVA = DummyObjectProvider.createFor(ParticleType.class, "LAVA");

    public static final ParticleType MOBSPAWNER_FLAMES = DummyObjectProvider.createFor(ParticleType.class, "MOBSPAWNER_FLAMES");

    public static final ParticleType MYCELIUM = DummyObjectProvider.createFor(ParticleType.class, "MYCELIUM");

    public static final ParticleType NAUTILUS = DummyObjectProvider.createFor(ParticleType.class, "NAUTILUS");

    public static final ParticleType NOTE = DummyObjectProvider.createFor(ParticleType.class, "NOTE");

    public static final ParticleType PORTAL = DummyObjectProvider.createFor(ParticleType.class, "PORTAL");

    public static final ParticleType RAIN_SPLASH = DummyObjectProvider.createFor(ParticleType.class, "RAIN_SPLASH");

    public static final ParticleType SMOKE = DummyObjectProvider.createFor(ParticleType.class, "SMOKE");

    public static final ParticleType SNOWBALL_POOF = DummyObjectProvider.createFor(ParticleType.class, "SNOWBALL_POOF");

    public static final ParticleType SPIT = DummyObjectProvider.createFor(ParticleType.class, "SPIT");

    public static final ParticleType SQUID_INK = DummyObjectProvider.createFor(ParticleType.class, "SQUID_INK");

    public static final ParticleType SWEEP_ATTACK = DummyObjectProvider.createFor(ParticleType.class, "SWEEP_ATTACK");

    public static final ParticleType TOTEM_OF_UNDYING = DummyObjectProvider.createFor(ParticleType.class, "TOTEM_OF_UNDYING");

    public static final ParticleType UNDERWATER = DummyObjectProvider.createFor(ParticleType.class, "UNDERWATER");

    public static final ParticleType WATER_SPLASH = DummyObjectProvider.createFor(ParticleType.class, "WATER_SPLASH");

    /**
     * While this particle type the option {@link ParticleOptions#VELOCITY}
     * supports, this will only affect the velocity in the y direction.
     */
    public static final ParticleType WITCH_MAGIC = DummyObjectProvider.createFor(ParticleType.class, "WITCH_MAGIC");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private ParticleTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
