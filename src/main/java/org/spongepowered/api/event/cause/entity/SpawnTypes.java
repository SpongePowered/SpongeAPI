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
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.chunk.Chunk;
import org.spongepowered.api.world.weather.Weather;
import org.spongepowered.plugin.PluginContainer;

import java.util.function.Supplier;

public final class SpawnTypes {

    // SORTFIELDS:ON

    /**
     * This is the equivalent to when a block break causes a normal entity to
     * spawn, such as {@link BlockTypes#INFESTED_STONE} where a
     * {@link EntityTypes#SILVERFISH} may spawn.
     */
    public static final Supplier<SpawnType> BLOCK_SPAWNING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "block_spawning");

    /**
     * This is the equivalent to when an {@link Entity} is spawned from a
     * breeding of two other {@link Entity} instances. Usually associated
     * with {@link Animal} entities.
     */
    public static final Supplier<SpawnType> BREEDING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "breeding");

    /**
     * An entity spawned due to a {@link Chunk} being loaded.
     */
    public static final Supplier<SpawnType> CHUNK_LOAD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "chunk_load");

    /**
     * Custom spawn type. Usually, Sponge can decipher the spawn type
     * but in some cases, the type is just unknown.
     */
    public static final Supplier<SpawnType> CUSTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "custom");

    /**
     * When a {@link BlockTypes#DISPENSER} or {@link BlockTypes#DROPPER} or
     * equivalent spawns an entity as it's normal function of "dispensing".
     */
    public static final Supplier<SpawnType> DISPENSE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "dispense");

    /**
     * When an {@link Item} entity is "dropped" as when a block is broken or
     * an {@link Entity} is killed.
     */
    public static final Supplier<SpawnType> DROPPED_ITEM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "dropped_item");

    /**
     * When an {@link ExperienceOrb} is spawned as a result of a "reward" from
     * an {@link Entity} granting experience for the kill, or a {@link Trader}
     * granting experience for a successful trade, or a block being mined.
     */
    public static final Supplier<SpawnType> EXPERIENCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "experience");

    /**
     * When a block becomes a {@link FallingBlock} entity due to normal gravity.
     */
    public static final Supplier<SpawnType> FALLING_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "falling_block");

    /**
     * When an {@link Entity} is spawned as a result of a
     * {@link BlockTypes#SPAWNER} or {@link SpawnerMinecart} entity
     * performs it's normal spawning.
     */
    public static final Supplier<SpawnType> MOB_SPAWNER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "mob_spawner");

    /**
     * Unknown for now.
     */
    public static final Supplier<SpawnType> PASSIVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "passive");

    /**
     * When an entity is placed into the world, likely from a command.
     */
    public static final Supplier<SpawnType> PLACEMENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "placement");

    /**
     * An entity spawned from a {@link PluginContainer plugin}, this can be for any reason
     * as dictated by the plugin.
     */
    public static final Supplier<SpawnType> PLUGIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "plugin");

    /**
     * When an entity is spawned as a projectile, either from
     * being "thrown" or "launched".
     */
    public static final Supplier<SpawnType> PROJECTILE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "projectile");

    /**
     * When an entity is spawned from any variant of spawn eggs.
     */
    public static final Supplier<SpawnType> SPAWN_EGG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "spawn_egg");

    /**
     * When an entity is spawned from a structure, usually during world/chunk generation.
     */
    public static final Supplier<SpawnType> STRUCTURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "structure");

    /**
     * When an entity is spawned from {@link BlockTypes#TNT}.
     */
    public static final Supplier<SpawnType> TNT_IGNITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "tnt_ignite");

    /**
     * When an entity is spawned from the current {@link Weather}
     * state of a {@link World}.
     */
    public static final Supplier<SpawnType> WEATHER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "weather");

    /**
     * An entity spawned from the normal world spawner (natural spawning).
     */
    public static final Supplier<SpawnType> WORLD_SPAWNER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SpawnType.class, "world_spawner");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private SpawnTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
