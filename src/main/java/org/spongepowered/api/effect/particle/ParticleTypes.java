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

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all possible {@link ParticleType}s in vanilla minecraft.
 */
public final class ParticleTypes {

    // SORTFIELDS:ON

    public static final ParticleType AMBIENT_MOB_SPELL = DummyObjectProvider.createFor(ParticleType.class, "AMBIENT_MOB_SPELL");

    public static final ParticleType ANGRY_VILLAGER = DummyObjectProvider.createFor(ParticleType.class, "ANGRY_VILLAGER");

    public static final ParticleType BARRIER = DummyObjectProvider.createFor(ParticleType.class, "BARRIER");

    public static final ParticleType BLOCK_CRACK = DummyObjectProvider.createFor(ParticleType.class, "BLOCK_CRACK");

    public static final ParticleType BLOCK_DUST = DummyObjectProvider.createFor(ParticleType.class, "BLOCK_DUST");

    /**
     * This particle type will play the effect of a block that
     * is being broken and it's break sound.
     *
     * <p>This type has limited {@link ParticleOption}s, only
     * {@link ParticleOptions#BLOCK_STATE} and
     * {@link ParticleOptions#ITEM_STACK_SNAPSHOT} are supported.</p>
     */
    public static final ParticleType BREAK_BLOCK = DummyObjectProvider.createFor(ParticleType.class, "BREAK_BLOCK");

    public static final ParticleType CLOUD = DummyObjectProvider.createFor(ParticleType.class, "CLOUD");

    public static final ParticleType CRITICAL_HIT = DummyObjectProvider.createFor(ParticleType.class, "CRITICAL_HIT");

    public static final ParticleType DAMAGE_INDICATOR = DummyObjectProvider.createFor(ParticleType.class, "DAMAGE_INDICATOR");

    public static final ParticleType DRAGON_BREATH = DummyObjectProvider.createFor(ParticleType.class, "DRAGON_BREATH");

    public static final ParticleType DRAGON_BREATH_ATTACK = DummyObjectProvider.createFor(ParticleType.class, "DRAGON_BREATH_ATTACK");

    public static final ParticleType DRIP_LAVA = DummyObjectProvider.createFor(ParticleType.class, "DRIP_LAVA");

    public static final ParticleType DRIP_WATER = DummyObjectProvider.createFor(ParticleType.class, "DRIP_WATER");

    public static final ParticleType ENCHANTING_GLYPHS = DummyObjectProvider.createFor(ParticleType.class, "ENCHANTING_GLYPHS");

    public static final ParticleType ENDER_TELEPORT = DummyObjectProvider.createFor(ParticleType.class, "ENDER_TELEPORT");

    public static final ParticleType END_ROD = DummyObjectProvider.createFor(ParticleType.class, "END_ROD");

    public static final ParticleType EXPLOSION = DummyObjectProvider.createFor(ParticleType.class, "EXPLOSION");

    public static final ParticleType FALLING_DUST = DummyObjectProvider.createFor(ParticleType.class, "FALLING_DUST");

    /**
     * This particle type will play the effect that will occur when
     * a {@link Player} uses bone meal on a plant to boost the growth.
     *
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

    public static final ParticleType FLAME = DummyObjectProvider.createFor(ParticleType.class, "FLAME");

    public static final ParticleType FOOTSTEP = DummyObjectProvider.createFor(ParticleType.class, "FOOTSTEP");

    public static final ParticleType GUARDIAN_APPEARANCE = DummyObjectProvider.createFor(ParticleType.class, "GUARDIAN_APPEARANCE");

    public static final ParticleType HAPPY_VILLAGER = DummyObjectProvider.createFor(ParticleType.class, "HAPPY_VILLAGER");

    public static final ParticleType HEART = DummyObjectProvider.createFor(ParticleType.class, "HEART");

    public static final ParticleType HUGE_EXPLOSION = DummyObjectProvider.createFor(ParticleType.class, "HUGE_EXPLOSION");

    /**
     * While this particle type the option {@link ParticleOptions#VELOCITY}
     * supports, this will only affect the velocity in the y direction.
     */
    public static final ParticleType INSTANT_SPELL = DummyObjectProvider.createFor(ParticleType.class, "INSTANT_SPELL");

    public static final ParticleType ITEM_CRACK = DummyObjectProvider.createFor(ParticleType.class, "ITEM_CRACK");

    public static final ParticleType LARGE_EXPLOSION = DummyObjectProvider.createFor(ParticleType.class, "LARGE_EXPLOSION");

    public static final ParticleType LARGE_SMOKE = DummyObjectProvider.createFor(ParticleType.class, "LARGE_SMOKE");

    public static final ParticleType LAVA = DummyObjectProvider.createFor(ParticleType.class, "LAVA");

    public static final ParticleType MAGIC_CRITICAL_HIT = DummyObjectProvider.createFor(ParticleType.class, "MAGIC_CRITICAL_HIT");

    public static final ParticleType MOBSPAWNER_FLAMES = DummyObjectProvider.createFor(ParticleType.class, "MOBSPAWNER_FLAMES");

    public static final ParticleType MOB_SPELL = DummyObjectProvider.createFor(ParticleType.class, "MOB_SPELL");

    public static final ParticleType NOTE = DummyObjectProvider.createFor(ParticleType.class, "NOTE");

    public static final ParticleType PORTAL = DummyObjectProvider.createFor(ParticleType.class, "PORTAL");

    public static final ParticleType REDSTONE_DUST = DummyObjectProvider.createFor(ParticleType.class, "REDSTONE_DUST");

    public static final ParticleType SLIME = DummyObjectProvider.createFor(ParticleType.class, "SLIME");

    public static final ParticleType SMOKE = DummyObjectProvider.createFor(ParticleType.class, "SMOKE");

    public static final ParticleType SNOWBALL = DummyObjectProvider.createFor(ParticleType.class, "SNOWBALL");

    public static final ParticleType SNOW_SHOVEL = DummyObjectProvider.createFor(ParticleType.class, "SNOW_SHOVEL");

    /**
     * While this particle type the option {@link ParticleOptions#VELOCITY}
     * supports, this will only affect the velocity in the y direction.
     */
    public static final ParticleType SPELL = DummyObjectProvider.createFor(ParticleType.class, "SPELL");

    public static final ParticleType SPLASH_POTION = DummyObjectProvider.createFor(ParticleType.class, "SPLASH_POTION");

    public static final ParticleType SUSPENDED = DummyObjectProvider.createFor(ParticleType.class, "SUSPENDED");

    public static final ParticleType SUSPENDED_DEPTH = DummyObjectProvider.createFor(ParticleType.class, "SUSPENDED_DEPTH");

    public static final ParticleType SWEEP_ATTACK = DummyObjectProvider.createFor(ParticleType.class, "SWEEP_ATTACK");

    public static final ParticleType TOWN_AURA = DummyObjectProvider.createFor(ParticleType.class, "TOWN_AURA");

    public static final ParticleType WATER_BUBBLE = DummyObjectProvider.createFor(ParticleType.class, "WATER_BUBBLE");

    public static final ParticleType WATER_DROP = DummyObjectProvider.createFor(ParticleType.class, "WATER_DROP");

    public static final ParticleType WATER_SPLASH = DummyObjectProvider.createFor(ParticleType.class, "WATER_SPLASH");

    public static final ParticleType WATER_WAKE = DummyObjectProvider.createFor(ParticleType.class, "WATER_WAKE");

    /**
     * While this particle type the option {@link ParticleOptions#VELOCITY}
     * supports, this will only affect the velocity in the y direction.
     */
    public static final ParticleType WITCH_SPELL = DummyObjectProvider.createFor(ParticleType.class, "WITCH_SPELL");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private ParticleTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
