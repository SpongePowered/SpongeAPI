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
package org.spongepowered.api.event.cause.entity;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.ExperienceOrb;
import org.spongepowered.api.entity.FallingBlock;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.living.animal.Animal;
import org.spongepowered.api.entity.living.trader.Trader;
import org.spongepowered.api.entity.vehicle.minecart.SpawnerMinecart;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.weather.WeatherType;
import org.spongepowered.plugin.PluginContainer;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class SpawnTypes {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * This is the equivalent to when a block break causes a normal entity to
     * spawn, such as {@link BlockTypes#INFESTED_STONE} where a
     * {@link EntityTypes#SILVERFISH} may spawn.
     */
    public static final DefaultedRegistryReference<SpawnType> BLOCK_SPAWNING = SpawnTypes.key(ResourceKey.sponge("block_spawning"));

    /**
     * This is the equivalent to when an {@link Entity} is spawned from a
     * breeding of two other {@link Entity} instances. Usually associated
     * with {@link Animal} entities.
     */
    public static final DefaultedRegistryReference<SpawnType> BREEDING = SpawnTypes.key(ResourceKey.sponge("breeding"));

    /**
     * An entity spawned due to a {@link Chunk} being loaded.
     */
    public static final DefaultedRegistryReference<SpawnType> CHUNK_LOAD = SpawnTypes.key(ResourceKey.sponge("chunk_load"));

    /**
     * Custom spawn type. Usually, Sponge can decipher the spawn type
     * but in some cases, the type is just unknown.
     */
    public static final DefaultedRegistryReference<SpawnType> CUSTOM = SpawnTypes.key(ResourceKey.sponge("custom"));

    /**
     * When a {@link BlockTypes#DISPENSER} or {@link BlockTypes#DROPPER} or
     * equivalent spawns an entity as it's normal function of "dispensing".
     */
    public static final DefaultedRegistryReference<SpawnType> DISPENSE = SpawnTypes.key(ResourceKey.sponge("dispense"));

    /**
     * When an {@link Item} entity is "dropped" as when a block is broken or
     * an {@link Entity} is killed.
     */
    public static final DefaultedRegistryReference<SpawnType> DROPPED_ITEM = SpawnTypes.key(ResourceKey.sponge("dropped_item"));

    /**
     * When an {@link ExperienceOrb} is spawned as a result of a "reward" from
     * an {@link Entity} granting experience for the kill, or a {@link Trader}
     * granting experience for a successful trade, or a block being mined.
     */
    public static final DefaultedRegistryReference<SpawnType> EXPERIENCE = SpawnTypes.key(ResourceKey.sponge("experience"));

    /**
     * When a block becomes a {@link FallingBlock} entity due to normal gravity.
     */
    public static final DefaultedRegistryReference<SpawnType> FALLING_BLOCK = SpawnTypes.key(ResourceKey.sponge("falling_block"));

    /**
     * When an {@link Entity} is spawned as a result of a
     * {@link BlockTypes#SPAWNER} or {@link SpawnerMinecart} entity
     * performs it's normal spawning.
     */
    public static final DefaultedRegistryReference<SpawnType> MOB_SPAWNER = SpawnTypes.key(ResourceKey.sponge("mob_spawner"));

    /**
     * Unknown for now.
     */
    public static final DefaultedRegistryReference<SpawnType> PASSIVE = SpawnTypes.key(ResourceKey.sponge("passive"));

    /**
     * When an entity is placed into the world, likely from a command.
     */
    public static final DefaultedRegistryReference<SpawnType> PLACEMENT = SpawnTypes.key(ResourceKey.sponge("placement"));

    /**
     * An entity spawned from a {@link PluginContainer plugin}, this can be for any reason
     * as dictated by the plugin.
     */
    public static final DefaultedRegistryReference<SpawnType> PLUGIN = SpawnTypes.key(ResourceKey.sponge("plugin"));

    /**
     * When an entity is spawned as a projectile, either from
     * being "thrown" or "launched".
     */
    public static final DefaultedRegistryReference<SpawnType> PROJECTILE = SpawnTypes.key(ResourceKey.sponge("projectile"));

    /**
     * When an entity is spawned from any variant of spawn eggs.
     */
    public static final DefaultedRegistryReference<SpawnType> SPAWN_EGG = SpawnTypes.key(ResourceKey.sponge("spawn_egg"));

    /**
     * When an entity is spawned from a structure, usually during world/chunk generation.
     */
    public static final DefaultedRegistryReference<SpawnType> STRUCTURE = SpawnTypes.key(ResourceKey.sponge("structure"));

    /**
     * When an entity is spawned from {@link BlockTypes#TNT}.
     */
    public static final DefaultedRegistryReference<SpawnType> TNT_IGNITE = SpawnTypes.key(ResourceKey.sponge("tnt_ignite"));

    /**
     * When an entity is spawned from the current {@link WeatherType}
     * state of a {@link World}.
     */
    public static final DefaultedRegistryReference<SpawnType> WEATHER = SpawnTypes.key(ResourceKey.sponge("weather"));

    /**
     * An entity spawned from the normal world spawner (natural spawning).
     */
    public static final DefaultedRegistryReference<SpawnType> WORLD_SPAWNER = SpawnTypes.key(ResourceKey.sponge("world_spawner"));

    // SORTFIELDS:OFF

    // @formatter:on

    private SpawnTypes() {
    }

    private static DefaultedRegistryReference<SpawnType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.SPAWN_TYPE, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
