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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of all possible {@link PotionType}s in vanilla Minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class PotionTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<PotionType> AWKWARD = PotionTypes.key(ResourceKey.sponge("awkward"));

    public static final DefaultedRegistryReference<PotionType> EMPTY = PotionTypes.key(ResourceKey.sponge("empty"));

    public static final DefaultedRegistryReference<PotionType> FIRE_RESISTANCE = PotionTypes.key(ResourceKey.sponge("fire_resistance"));

    public static final DefaultedRegistryReference<PotionType> HARMING = PotionTypes.key(ResourceKey.sponge("harming"));

    public static final DefaultedRegistryReference<PotionType> HEALING = PotionTypes.key(ResourceKey.sponge("healing"));

    public static final DefaultedRegistryReference<PotionType> INVISIBILITY = PotionTypes.key(ResourceKey.sponge("invisibility"));

    public static final DefaultedRegistryReference<PotionType> LEAPING = PotionTypes.key(ResourceKey.sponge("leaping"));

    public static final DefaultedRegistryReference<PotionType> LONG_FIRE_RESISTANCE = PotionTypes.key(ResourceKey.sponge("long_fire_resistance"));

    public static final DefaultedRegistryReference<PotionType> LONG_INVISIBILITY = PotionTypes.key(ResourceKey.sponge("long_invisibility"));

    public static final DefaultedRegistryReference<PotionType> LONG_LEAPING = PotionTypes.key(ResourceKey.sponge("long_leaping"));

    public static final DefaultedRegistryReference<PotionType> LONG_NIGHT_VISION = PotionTypes.key(ResourceKey.sponge("long_night_vision"));

    public static final DefaultedRegistryReference<PotionType> LONG_POISON = PotionTypes.key(ResourceKey.sponge("long_poison"));

    public static final DefaultedRegistryReference<PotionType> LONG_REGENERATION = PotionTypes.key(ResourceKey.sponge("long_regeneration"));

    public static final DefaultedRegistryReference<PotionType> LONG_SLOW_FALLING = PotionTypes.key(ResourceKey.sponge("long_slow_falling"));

    public static final DefaultedRegistryReference<PotionType> LONG_SLOWNESS = PotionTypes.key(ResourceKey.sponge("long_slowness"));

    public static final DefaultedRegistryReference<PotionType> LONG_STRENGTH = PotionTypes.key(ResourceKey.sponge("long_strength"));

    public static final DefaultedRegistryReference<PotionType> LONG_SWIFTNESS = PotionTypes.key(ResourceKey.sponge("long_swiftness"));

    public static final DefaultedRegistryReference<PotionType> LONG_TURTLE_MASTER = PotionTypes.key(ResourceKey.sponge("long_turtle_master"));

    public static final DefaultedRegistryReference<PotionType> LONG_WATER_BREATHING = PotionTypes.key(ResourceKey.sponge("long_water_breathing"));

    public static final DefaultedRegistryReference<PotionType> LONG_WEAKNESS = PotionTypes.key(ResourceKey.sponge("long_weakness"));

    public static final DefaultedRegistryReference<PotionType> LUCK = PotionTypes.key(ResourceKey.sponge("luck"));

    public static final DefaultedRegistryReference<PotionType> MUNDANE = PotionTypes.key(ResourceKey.sponge("mundane"));

    public static final DefaultedRegistryReference<PotionType> NIGHT_VISION = PotionTypes.key(ResourceKey.sponge("night_vision"));

    public static final DefaultedRegistryReference<PotionType> POISON = PotionTypes.key(ResourceKey.sponge("poison"));

    public static final DefaultedRegistryReference<PotionType> REGENERATION = PotionTypes.key(ResourceKey.sponge("regeneration"));

    public static final DefaultedRegistryReference<PotionType> SLOW_FALLING = PotionTypes.key(ResourceKey.sponge("slow_falling"));

    public static final DefaultedRegistryReference<PotionType> SLOWNESS = PotionTypes.key(ResourceKey.sponge("slowness"));

    public static final DefaultedRegistryReference<PotionType> STRENGTH = PotionTypes.key(ResourceKey.sponge("strength"));

    public static final DefaultedRegistryReference<PotionType> STRONG_HARMING = PotionTypes.key(ResourceKey.sponge("strong_harming"));

    public static final DefaultedRegistryReference<PotionType> STRONG_HEALING = PotionTypes.key(ResourceKey.sponge("strong_healing"));

    public static final DefaultedRegistryReference<PotionType> STRONG_LEAPING = PotionTypes.key(ResourceKey.sponge("strong_leaping"));

    public static final DefaultedRegistryReference<PotionType> STRONG_POISON = PotionTypes.key(ResourceKey.sponge("strong_poison"));

    public static final DefaultedRegistryReference<PotionType> STRONG_REGENERATION = PotionTypes.key(ResourceKey.sponge("strong_regeneration"));

    public static final DefaultedRegistryReference<PotionType> STRONG_SLOWNESS = PotionTypes.key(ResourceKey.sponge("strong_slowness"));

    public static final DefaultedRegistryReference<PotionType> STRONG_STRENGTH = PotionTypes.key(ResourceKey.sponge("strong_strength"));

    public static final DefaultedRegistryReference<PotionType> STRONG_SWIFTNESS = PotionTypes.key(ResourceKey.sponge("strong_swiftness"));

    public static final DefaultedRegistryReference<PotionType> STRONG_TURTLE_MASTER = PotionTypes.key(ResourceKey.sponge("strong_turtle_master"));

    public static final DefaultedRegistryReference<PotionType> SWIFTNESS = PotionTypes.key(ResourceKey.sponge("swiftness"));

    public static final DefaultedRegistryReference<PotionType> THICK = PotionTypes.key(ResourceKey.sponge("thick"));

    public static final DefaultedRegistryReference<PotionType> TURTLE_MASTER = PotionTypes.key(ResourceKey.sponge("turtle_master"));

    public static final DefaultedRegistryReference<PotionType> WATER = PotionTypes.key(ResourceKey.sponge("water"));

    public static final DefaultedRegistryReference<PotionType> WATER_BREATHING = PotionTypes.key(ResourceKey.sponge("water_breathing"));

    public static final DefaultedRegistryReference<PotionType> WEAKNESS = PotionTypes.key(ResourceKey.sponge("weakness"));

    // SORTFIELDS:OFF

    // @formatter:on

    private PotionTypes() {
    }

    private static DefaultedRegistryReference<PotionType> key(final ResourceKey location) {
        return RegistryKey.<PotionType>of(Registries.POTION_TYPE.registry(), location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
