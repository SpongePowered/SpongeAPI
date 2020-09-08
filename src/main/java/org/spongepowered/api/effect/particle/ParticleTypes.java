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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.entity.living.player.Player;

import java.util.function.Supplier;

/**
 * An enumeration of all possible {@link ParticleType}s in vanilla minecraft.
 */
public final class ParticleTypes {

    // SORTFIELDS:ON

    public static final Supplier<ParticleType> AMBIENT_ENTITY_EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "ambient_entity_effect");

    public static final Supplier<ParticleType> ANGRY_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "angry_villager");

    public static final Supplier<ParticleType> BARRIER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "barrier");

    public static final Supplier<ParticleType> BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "block");

    /**
     * This particle type will play the effect of a block that
     * is being broken and it's break sound.
     *
     * <p>This type has limited {@link ParticleOption}s, only
     * {@link ParticleOptions#BLOCK_STATE} and
     * {@link ParticleOptions#ITEM_STACK_SNAPSHOT} are supported.</p>
     */
    public static final Supplier<ParticleType> BREAK_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "break_block");

    public static final Supplier<ParticleType> BREAK_EYE_OF_ENDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "break_eye_of_ender");

    public static final Supplier<ParticleType> BREAK_SPLASH_POTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "break_splash_potion");

    public static final Supplier<ParticleType> BUBBLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "bubble");

    public static final Supplier<ParticleType> BUBBLE_COLUMN_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "bubble_column_up");

    public static final Supplier<ParticleType> BUBBLE_POP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "squid_ink");

    public static final Supplier<ParticleType> CLOUD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "cloud");

    public static final Supplier<ParticleType> CRITICAL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "critical_hit");

    public static final Supplier<ParticleType> CURRENT_DOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "current_down");

    public static final Supplier<ParticleType> DAMAGE_INDICATOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "damage_indicator");

    public static final Supplier<ParticleType> DOLPHIN_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "dolphin_speed");

    public static final Supplier<ParticleType> DRAGON_BREATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "dragon_breath");

    public static final Supplier<ParticleType> DRAGON_BREATH_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "dragon_breath_attack");

    public static final Supplier<ParticleType> DRIPPING_HONEY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "dripping_honey");

    public static final Supplier<ParticleType> DRIPPING_LAVA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "dripping_lava");

    public static final Supplier<ParticleType> DRIPPING_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "dripping_water");

    /**
     * While this particle type the option {@link ParticleOptions#SCALE} supports, the maximum value
     * that is supported is {@code 4.0} and higher values will be limited to this maximum.
     */
    public static final Supplier<ParticleType> DUST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "dust");

    /**
     * While this particle type the option {@link ParticleOptions#VELOCITY} supports, this
     * will only affect the velocity in the y direction.
     */
    public static final Supplier<ParticleType> EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "effect");

    public static final Supplier<ParticleType> ELDER_GUARDIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "elder_guardian");

    public static final Supplier<ParticleType> ENCHANTED_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "enchanted_hit");

    public static final Supplier<ParticleType> ENCHANTING_GLYPHS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "enchanting_glyphs");

    public static final Supplier<ParticleType> END_ROD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "end_rod");

    public static final Supplier<ParticleType> ENTITY_EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "entity_effect");

    public static final Supplier<ParticleType> EXPLOSION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "explosion");

    public static final Supplier<ParticleType> EXPLOSION_EMITTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "explosion_emitter");

    public static final Supplier<ParticleType> FALLING_DUST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "falling_dust");

    public static final Supplier<ParticleType> FALLING_HONEY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "falling_honey");

    public static final Supplier<ParticleType> FALLING_NECTAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "falling_nectar");

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
    public static final Supplier<ParticleType> FERTILIZER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "fertilizer");

    /**
     * This particle type will play a fireworks effect.
     *
     * <p>This type has limited {@link ParticleOption}s, only
     * {@link ParticleOptions#FIREWORK_EFFECTS} is supported.</p>
     */
    public static final Supplier<ParticleType> FIREWORKS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "fireworks");

    public static final Supplier<ParticleType> FIREWORKS_SPARK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "fireworks_spark");

    /**
     * This particle type will play the smoke particles of a fire.
     * <p>This type has limited {@link ParticleOption}s, only
     * {@link ParticleOptions#DIRECTION} is supported.</p>
     */
    public static final Supplier<ParticleType> FIRE_SMOKE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "fire_smoke");

    public static final Supplier<ParticleType> FISHING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "fishing");

    public static final Supplier<ParticleType> FLAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "flame");

    public static final Supplier<ParticleType> HAPPY_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "happy_villager");

    public static final Supplier<ParticleType> HEART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "heart");

    /**
     * While this particle type the option {@link ParticleOptions#VELOCITY}
     * supports, this will only affect the velocity in the y direction.
     */
    public static final Supplier<ParticleType> INSTANT_EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "instant_effect");

    public static final Supplier<ParticleType> ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "item");

    public static final Supplier<ParticleType> ITEM_SLIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "item_slime");

    public static final Supplier<ParticleType> ITEM_SNOWBALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "item_snowball");

    public static final Supplier<ParticleType> LANDING_HONEY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "landing_honey");

    public static final Supplier<ParticleType> LARGE_SMOKE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "large_smoke");

    public static final Supplier<ParticleType> LAVA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "lava");

    public static final Supplier<ParticleType> MOBSPAWNER_FLAMES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "mobspawner_flames");

    public static final Supplier<ParticleType> MYCELIUM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "mycelium");

    public static final Supplier<ParticleType> NAUTILUS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "nautilus");

    public static final Supplier<ParticleType> NOTE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "note");

    public static final Supplier<ParticleType> PORTAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "portal");

    public static final Supplier<ParticleType> RAIN_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "rain_splash");

    public static final Supplier<ParticleType> SMOKE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "smoke");

    public static final Supplier<ParticleType> SNOWBALL_POOF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "snowball_poof");

    public static final Supplier<ParticleType> SPIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "spit");

    public static final Supplier<ParticleType> SQUID_INK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "squid_ink");

    public static final Supplier<ParticleType> SWEEP_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "sweep_attack");

    public static final Supplier<ParticleType> TOTEM_OF_UNDYING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "totem_of_undying");

    public static final Supplier<ParticleType> UNDERWATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "underwater");

    public static final Supplier<ParticleType> WATER_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "water_splash");

    /**
     * While this particle type the option {@link ParticleOptions#VELOCITY}
     * supports, this will only affect the velocity in the y direction.
     */
    public static final Supplier<ParticleType> WITCH_MAGIC = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "witch_magic");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private ParticleTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
