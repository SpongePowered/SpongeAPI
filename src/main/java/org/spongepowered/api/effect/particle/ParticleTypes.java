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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of all possible {@link ParticleType}s in vanilla minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class ParticleTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<ParticleType> AMBIENT_ENTITY_EFFECT = ParticleTypes.key(ResourceKey.sponge("ambient_entity_effect"));

    public static final DefaultedRegistryReference<ParticleType> ANGRY_VILLAGER = ParticleTypes.key(ResourceKey.sponge("angry_villager"));

    public static final DefaultedRegistryReference<ParticleType> ASH = ParticleTypes.key(ResourceKey.sponge("ash"));

    public static final DefaultedRegistryReference<ParticleType> BARRIER = ParticleTypes.key(ResourceKey.sponge("barrier"));

    public static final DefaultedRegistryReference<ParticleType> BLOCK = ParticleTypes.key(ResourceKey.sponge("block"));

    public static final DefaultedRegistryReference<ParticleType> BUBBLE = ParticleTypes.key(ResourceKey.sponge("bubble"));

    public static final DefaultedRegistryReference<ParticleType> BUBBLE_COLUMN_UP = ParticleTypes.key(ResourceKey.sponge("bubble_column_up"));

    public static final DefaultedRegistryReference<ParticleType> BUBBLE_POP = ParticleTypes.key(ResourceKey.sponge("bubble_pop"));

    public static final DefaultedRegistryReference<ParticleType> CAMPFIRE_COSY_SMOKE = ParticleTypes.key(ResourceKey.sponge("campfire_cosy_smoke"));

    public static final DefaultedRegistryReference<ParticleType> CAMPFIRE_SIGNAL_SMOKE = ParticleTypes.key(ResourceKey.sponge("campfire_signal_smoke"));

    public static final DefaultedRegistryReference<ParticleType> CLOUD = ParticleTypes.key(ResourceKey.sponge("cloud"));

    public static final DefaultedRegistryReference<ParticleType> COMPOSTER = ParticleTypes.key(ResourceKey.sponge("composter"));

    public static final DefaultedRegistryReference<ParticleType> CRIMSON_SPORE = ParticleTypes.key(ResourceKey.sponge("crimson_spore"));

    public static final DefaultedRegistryReference<ParticleType> CRIT = ParticleTypes.key(ResourceKey.sponge("crit"));

    public static final DefaultedRegistryReference<ParticleType> CURRENT_DOWN = ParticleTypes.key(ResourceKey.sponge("current_down"));

    public static final DefaultedRegistryReference<ParticleType> DAMAGE_INDICATOR = ParticleTypes.key(ResourceKey.sponge("damage_indicator"));

    public static final DefaultedRegistryReference<ParticleType> DOLPHIN = ParticleTypes.key(ResourceKey.sponge("dolphin"));

    public static final DefaultedRegistryReference<ParticleType> DRAGON_BREATH = ParticleTypes.key(ResourceKey.sponge("dragon_breath"));

    public static final DefaultedRegistryReference<ParticleType> DRIPPING_HONEY = ParticleTypes.key(ResourceKey.sponge("dripping_honey"));

    public static final DefaultedRegistryReference<ParticleType> DRIPPING_LAVA = ParticleTypes.key(ResourceKey.sponge("dripping_lava"));

    public static final DefaultedRegistryReference<ParticleType> DRIPPING_OBSIDIAN_TEAR = ParticleTypes.key(ResourceKey.sponge("dripping_obsidian_tear"));

    public static final DefaultedRegistryReference<ParticleType> DRIPPING_WATER = ParticleTypes.key(ResourceKey.sponge("dripping_water"));

    public static final DefaultedRegistryReference<ParticleType> DUST = ParticleTypes.key(ResourceKey.sponge("dust"));

    public static final DefaultedRegistryReference<ParticleType> EFFECT = ParticleTypes.key(ResourceKey.sponge("effect"));

    public static final DefaultedRegistryReference<ParticleType> ELDER_GUARDIAN = ParticleTypes.key(ResourceKey.sponge("elder_guardian"));

    public static final DefaultedRegistryReference<ParticleType> ENCHANT = ParticleTypes.key(ResourceKey.sponge("enchant"));

    public static final DefaultedRegistryReference<ParticleType> ENCHANTED_HIT = ParticleTypes.key(ResourceKey.sponge("enchanted_hit"));

    public static final DefaultedRegistryReference<ParticleType> END_ROD = ParticleTypes.key(ResourceKey.sponge("end_rod"));

    public static final DefaultedRegistryReference<ParticleType> ENTITY_EFFECT = ParticleTypes.key(ResourceKey.sponge("entity_effect"));

    public static final DefaultedRegistryReference<ParticleType> EXPLOSION = ParticleTypes.key(ResourceKey.sponge("explosion"));

    public static final DefaultedRegistryReference<ParticleType> EXPLOSION_EMITTER = ParticleTypes.key(ResourceKey.sponge("explosion_emitter"));

    public static final DefaultedRegistryReference<ParticleType> FALLING_DUST = ParticleTypes.key(ResourceKey.sponge("falling_dust"));

    public static final DefaultedRegistryReference<ParticleType> FALLING_HONEY = ParticleTypes.key(ResourceKey.sponge("falling_honey"));

    public static final DefaultedRegistryReference<ParticleType> FALLING_LAVA = ParticleTypes.key(ResourceKey.sponge("falling_lava"));

    public static final DefaultedRegistryReference<ParticleType> FALLING_NECTAR = ParticleTypes.key(ResourceKey.sponge("falling_nectar"));

    public static final DefaultedRegistryReference<ParticleType> FALLING_OBSIDIAN_TEAR = ParticleTypes.key(ResourceKey.sponge("falling_obsidian_tear"));

    public static final DefaultedRegistryReference<ParticleType> FALLING_WATER = ParticleTypes.key(ResourceKey.sponge("falling_water"));

    public static final DefaultedRegistryReference<ParticleType> FIREWORK = ParticleTypes.key(ResourceKey.sponge("firework"));

    public static final DefaultedRegistryReference<ParticleType> FISHING = ParticleTypes.key(ResourceKey.sponge("fishing"));

    public static final DefaultedRegistryReference<ParticleType> FLAME = ParticleTypes.key(ResourceKey.sponge("flame"));

    public static final DefaultedRegistryReference<ParticleType> FLASH = ParticleTypes.key(ResourceKey.sponge("flash"));

    public static final DefaultedRegistryReference<ParticleType> HAPPY_VILLAGER = ParticleTypes.key(ResourceKey.sponge("happy_villager"));

    public static final DefaultedRegistryReference<ParticleType> HEART = ParticleTypes.key(ResourceKey.sponge("heart"));

    public static final DefaultedRegistryReference<ParticleType> INSTANT_EFFECT = ParticleTypes.key(ResourceKey.sponge("instant_effect"));

    public static final DefaultedRegistryReference<ParticleType> ITEM = ParticleTypes.key(ResourceKey.sponge("item"));

    public static final DefaultedRegistryReference<ParticleType> ITEM_SLIME = ParticleTypes.key(ResourceKey.sponge("item_slime"));

    public static final DefaultedRegistryReference<ParticleType> ITEM_SNOWBALL = ParticleTypes.key(ResourceKey.sponge("item_snowball"));

    public static final DefaultedRegistryReference<ParticleType> LANDING_HONEY = ParticleTypes.key(ResourceKey.sponge("landing_honey"));

    public static final DefaultedRegistryReference<ParticleType> LANDING_LAVA = ParticleTypes.key(ResourceKey.sponge("landing_lava"));

    public static final DefaultedRegistryReference<ParticleType> LANDING_OBSIDIAN_TEAR = ParticleTypes.key(ResourceKey.sponge("landing_obsidian_tear"));

    public static final DefaultedRegistryReference<ParticleType> LARGE_SMOKE = ParticleTypes.key(ResourceKey.sponge("large_smoke"));

    public static final DefaultedRegistryReference<ParticleType> LAVA = ParticleTypes.key(ResourceKey.sponge("lava"));

    public static final DefaultedRegistryReference<ParticleType> MYCELIUM = ParticleTypes.key(ResourceKey.sponge("mycelium"));

    public static final DefaultedRegistryReference<ParticleType> NAUTILUS = ParticleTypes.key(ResourceKey.sponge("nautilus"));

    public static final DefaultedRegistryReference<ParticleType> NOTE = ParticleTypes.key(ResourceKey.sponge("note"));

    public static final DefaultedRegistryReference<ParticleType> POOF = ParticleTypes.key(ResourceKey.sponge("poof"));

    public static final DefaultedRegistryReference<ParticleType> PORTAL = ParticleTypes.key(ResourceKey.sponge("portal"));

    public static final DefaultedRegistryReference<ParticleType> RAIN = ParticleTypes.key(ResourceKey.sponge("rain"));

    public static final DefaultedRegistryReference<ParticleType> REVERSE_PORTAL = ParticleTypes.key(ResourceKey.sponge("reverse_portal"));

    public static final DefaultedRegistryReference<ParticleType> SMOKE = ParticleTypes.key(ResourceKey.sponge("smoke"));

    public static final DefaultedRegistryReference<ParticleType> SNEEZE = ParticleTypes.key(ResourceKey.sponge("sneeze"));

    public static final DefaultedRegistryReference<ParticleType> SOUL = ParticleTypes.key(ResourceKey.sponge("soul"));

    public static final DefaultedRegistryReference<ParticleType> SOUL_FIRE_FLAME = ParticleTypes.key(ResourceKey.sponge("soul_fire_flame"));

    public static final DefaultedRegistryReference<ParticleType> SPIT = ParticleTypes.key(ResourceKey.sponge("spit"));

    public static final DefaultedRegistryReference<ParticleType> SPLASH = ParticleTypes.key(ResourceKey.sponge("splash"));

    public static final DefaultedRegistryReference<ParticleType> SQUID_INK = ParticleTypes.key(ResourceKey.sponge("squid_ink"));

    public static final DefaultedRegistryReference<ParticleType> SWEEP_ATTACK = ParticleTypes.key(ResourceKey.sponge("sweep_attack"));

    public static final DefaultedRegistryReference<ParticleType> TOTEM_OF_UNDYING = ParticleTypes.key(ResourceKey.sponge("totem_of_undying"));

    public static final DefaultedRegistryReference<ParticleType> UNDERWATER = ParticleTypes.key(ResourceKey.sponge("underwater"));

    public static final DefaultedRegistryReference<ParticleType> WARPED_SPORE = ParticleTypes.key(ResourceKey.sponge("warped_spore"));

    public static final DefaultedRegistryReference<ParticleType> WHITE_ASH = ParticleTypes.key(ResourceKey.sponge("white_ash"));

    public static final DefaultedRegistryReference<ParticleType> WITCH = ParticleTypes.key(ResourceKey.sponge("witch"));

    // SORTFIELDS:OFF

    // @formatter:on

    private ParticleTypes() {
    }

    private static DefaultedRegistryReference<ParticleType> key(final ResourceKey location) {
        return RegistryKey.<ParticleType>of(Registries.PARTICLE_TYPE.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
