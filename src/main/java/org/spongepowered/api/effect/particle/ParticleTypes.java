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

    public static final Supplier<ParticleType> AMBIENT_ENTITY_EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "AMBIENT_ENTITY_EFFECT");

    public static final Supplier<ParticleType> ANGRY_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "ANGRY_VILLAGER");

    public static final Supplier<ParticleType> BARRIER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "BARRIER");

    public static final Supplier<ParticleType> BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "BLOCK");

    /**
     * This particle type will play the effect of a block that
     * is being broken and it's break sound.
     *
     * <p>This type has limited {@link ParticleOption}s, only
     * {@link ParticleOptions#BLOCK_STATE} and
     * {@link ParticleOptions#ITEM_STACK_SNAPSHOT} are supported.</p>
     */
    public static final Supplier<ParticleType> BREAK_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "BREAK_BLOCK");

    public static final Supplier<ParticleType> BREAK_EYE_OF_ENDER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "BREAK_EYE_OF_ENDER");

    public static final Supplier<ParticleType> BREAK_SPLASH_POTION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "BREAK_SPLASH_POTION");

    public static final Supplier<ParticleType> BUBBLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "BUBBLE");

    public static final Supplier<ParticleType> BUBBLE_COLUMN_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "BUBBLE_COLUMN_UP");

    public static final Supplier<ParticleType> BUBBLE_POP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "SQUID_INK");

    public static final Supplier<ParticleType> CLOUD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "CLOUD");

    public static final Supplier<ParticleType> CRITICAL_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "CRITICAL_HIT");

    public static final Supplier<ParticleType> CURRENT_DOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "CURRENT_DOWN");

    public static final Supplier<ParticleType> DAMAGE_INDICATOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "DAMAGE_INDICATOR");

    public static final Supplier<ParticleType> DOLPHIN_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "DOLPHIN_SPEED");

    public static final Supplier<ParticleType> DRAGON_BREATH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "DRAGON_BREATH");

    public static final Supplier<ParticleType> DRAGON_BREATH_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "DRAGON_BREATH_ATTACK");

    public static final Supplier<ParticleType> DRIPPING_LAVA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "DRIPPING_LAVA");

    public static final Supplier<ParticleType> DRIPPING_WATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "DRIPPING_WATER");

    /**
     * While this particle type the option {@link ParticleOptions#SCALE} supports, the maximum value
     * that is supported is {@code 4.0} and higher values will be limited to this maximum.
     */
    public static final Supplier<ParticleType> DUST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "DUST");

    /**
     * While this particle type the option {@link ParticleOptions#VELOCITY} supports, this
     * will only affect the velocity in the y direction.
     */
    public static final Supplier<ParticleType> EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "EFFECT");

    public static final Supplier<ParticleType> ELDER_GUARDIAN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "ELDER_GUARDIAN");

    public static final Supplier<ParticleType> ENCHANTED_HIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "ENCHANTED_HIT");

    public static final Supplier<ParticleType> ENCHANTING_GLYPHS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "ENCHANTING_GLYPHS");

    public static final Supplier<ParticleType> END_ROD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "END_ROD");

    public static final Supplier<ParticleType> ENTITY_EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "ENTITY_EFFECT");

    public static final Supplier<ParticleType> EXPLOSION = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "EXPLOSION");

    public static final Supplier<ParticleType> EXPLOSION_EMITTER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "EXPLOSION_EMITTER");

    public static final Supplier<ParticleType> FALLING_DUST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "FALLING_DUST");

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
    public static final Supplier<ParticleType> FERTILIZER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "FERTILIZER");

    /**
     * This particle type will play a fireworks effect.
     *
     * <p>This type has limited {@link ParticleOption}s, only
     * {@link ParticleOptions#FIREWORK_EFFECTS} is supported.</p>
     */
    public static final Supplier<ParticleType> FIREWORKS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "FIREWORKS");

    public static final Supplier<ParticleType> FIREWORKS_SPARK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "FIREWORKS_SPARK");

    /**
     * This particle type will play the smoke particles of a fire.
     * <p>This type has limited {@link ParticleOption}s, only
     * {@link ParticleOptions#DIRECTION} is supported.</p>
     */
    public static final Supplier<ParticleType> FIRE_SMOKE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "FIRE_SMOKE");

    public static final Supplier<ParticleType> FISHING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "FISHING");

    public static final Supplier<ParticleType> FLAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "FLAME");

    public static final Supplier<ParticleType> HAPPY_VILLAGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "HAPPY_VILLAGER");

    public static final Supplier<ParticleType> HEART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "HEART");

    /**
     * While this particle type the option {@link ParticleOptions#VELOCITY}
     * supports, this will only affect the velocity in the y direction.
     */
    public static final Supplier<ParticleType> INSTANT_EFFECT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "INSTANT_EFFECT");

    public static final Supplier<ParticleType> ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "ITEM");

    public static final Supplier<ParticleType> ITEM_SLIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "ITEM_SLIME");

    public static final Supplier<ParticleType> ITEM_SNOWBALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "ITEM_SNOWBALL");

    public static final Supplier<ParticleType> LARGE_SMOKE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "LARGE_SMOKE");

    public static final Supplier<ParticleType> LAVA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "LAVA");

    public static final Supplier<ParticleType> MOBSPAWNER_FLAMES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "MOBSPAWNER_FLAMES");

    public static final Supplier<ParticleType> MYCELIUM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "MYCELIUM");

    public static final Supplier<ParticleType> NAUTILUS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "NAUTILUS");

    public static final Supplier<ParticleType> NOTE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "NOTE");

    public static final Supplier<ParticleType> PORTAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "PORTAL");

    public static final Supplier<ParticleType> RAIN_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "RAIN_SPLASH");

    public static final Supplier<ParticleType> SMOKE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "SMOKE");

    public static final Supplier<ParticleType> SNOWBALL_POOF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "SNOWBALL_POOF");

    public static final Supplier<ParticleType> SPIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "SPIT");

    public static final Supplier<ParticleType> SQUID_INK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "SQUID_INK");

    public static final Supplier<ParticleType> SWEEP_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "SWEEP_ATTACK");

    public static final Supplier<ParticleType> TOTEM_OF_UNDYING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "TOTEM_OF_UNDYING");

    public static final Supplier<ParticleType> UNDERWATER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "UNDERWATER");

    public static final Supplier<ParticleType> WATER_SPLASH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "WATER_SPLASH");

    /**
     * While this particle type the option {@link ParticleOptions#VELOCITY}
     * supports, this will only affect the velocity in the y direction.
     */
    public static final Supplier<ParticleType> WITCH_MAGIC = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ParticleType.class, "WITCH_MAGIC");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private ParticleTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
