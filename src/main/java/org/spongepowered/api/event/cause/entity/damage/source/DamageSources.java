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
package org.spongepowered.api.event.cause.entity.damage.source;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.world.ServerLocation;

/**
 * A static collection of various {@link DamageSource}s that remain static, or
 * otherwise "ambiguous" with regards to the actual source. Examples include:
 * in the event an {@link Entity} is being damaged due to falling through the
 * "void", an {@link Entity} being damaged for being "on fire" in which case
 * an {@link Keys#FIRE_TICKS} may be present from the {@link Entity}, etc.
 *
 * <p>{@link DamageSource}s that rely on live instances of various objects,
 * including other {@link Entity} instances, or a block at a specific
 * {@link ServerLocation} rely on the various other types of {@link DamageSource}s.
 * </p>
 */
public final class DamageSources {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<DamageSource> DROWNING = DamageSources.key(ResourceKey.sponge("drowning"));

    public static final DefaultedRegistryReference<DamageSource> DRYOUT = DamageSources.key(ResourceKey.sponge("dryout"));

    public static final DefaultedRegistryReference<DamageSource> FALLING = DamageSources.key(ResourceKey.sponge("falling"));

    public static final DefaultedRegistryReference<DamageSource> FIRE_TICK = DamageSources.key(ResourceKey.sponge("fire_tick"));

    public static final DefaultedRegistryReference<DamageSource> GENERIC = DamageSources.key(ResourceKey.sponge("generic"));

    public static final DefaultedRegistryReference<DamageSource> MAGIC = DamageSources.key(ResourceKey.sponge("magic"));

    public static final DefaultedRegistryReference<DamageSource> STARVATION = DamageSources.key(ResourceKey.sponge("starvation"));

    public static final DefaultedRegistryReference<DamageSource> VOID = DamageSources.key(ResourceKey.sponge("void"));

    public static final DefaultedRegistryReference<DamageSource> WITHER = DamageSources.key(ResourceKey.sponge("wither"));

    // SORTFIELDS:OFF

    // @formatter:on

    private DamageSources() {
    }

    private static DefaultedRegistryReference<DamageSource> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.DAMAGE_SOURCE, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }

}
