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
package org.spongepowered.api.event.cause.entity.spawn;

import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.entity.ExperienceOrb;
import org.spongepowered.api.entity.FallingBlock;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.living.Villager;
import org.spongepowered.api.entity.living.animal.Animal;
import org.spongepowered.api.entity.vehicle.minecart.MobSpawnerMinecart;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;
import org.spongepowered.api.world.Chunk;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.gen.Populator;
import org.spongepowered.api.world.weather.Weather;

public final class SpawnTypes {

    // SORTFIELDS:ON

    /**
     * This is the equivalent to when a block break causes a normal entity to
     * spawn, such as {@link BlockTypes#MONSTER_EGG} where a
     * {@link EntityTypes#SILVERFISH} may spawn.
     */
    public static final SpawnType BLOCK_SPAWNING = DummyObjectProvider.createFor(SpawnType.class, "BLOCK_SPAWNING");

    /**
     * This is the equivalent to when an {@link Entity} is spawned from a
     * breeding of two other {@link Entity} instances. Usually associated
     * with {@link Animal} entities.
     */
    public static final SpawnType BREEDING = DummyObjectProvider.createFor(SpawnType.class, "BREEDING");

    /**
     * An entity spawned due to a {@link Chunk} being loaded.
     */
    public static final SpawnType CHUNK_LOAD = DummyObjectProvider.createFor(SpawnType.class, "CHUNK_LOAD");

    /**
     * Custom spawn type. Usually, Sponge can decipher the spawn type
     * but in some cases, the type is just unknown.
     */
    public static final SpawnType CUSTOM = DummyObjectProvider.createFor(SpawnType.class, "CUSTOM");

    /**
     * When a {@link BlockTypes#DISPENSER} or {@link BlockTypes#DROPPER} or
     * equivalent spawns an entity as it's normal function of "dispensing".
     */
    public static final SpawnType DISPENSE = DummyObjectProvider.createFor(SpawnType.class, "DISPENSE");

    /**
     * When an {@link Item} entity is "dropped" as when a block is broken or
     * an {@link Entity} is killed.
     */
    public static final SpawnType DROPPED_ITEM = DummyObjectProvider.createFor(SpawnType.class, "DROPPED_ITEM");

    /**
     * When an {@link ExperienceOrb} is spawned as a result of a "reward" from
     * an {@link Entity} granting experience for the kill, or a {@link Villager}
     * granting experience for a successful trade, or a block being mined.
     */
    public static final SpawnType EXPERIENCE = DummyObjectProvider.createFor(SpawnType.class, "EXPERIENCE");

    /**
     * When a block becomes a {@link FallingBlock} entity due to normal gravity.
     */
    public static final SpawnType FALLING_BLOCK = DummyObjectProvider.createFor(SpawnType.class, "FALLING_BLOCK");

    /**
     * When an {@link Entity} is spawned as a result of a
     * {@link BlockTypes#MOB_SPAWNER} or {@link MobSpawnerMinecart} entity
     * performs it's normal spawning.
     */
    public static final SpawnType MOB_SPAWNER = DummyObjectProvider.createFor(SpawnType.class, "MOB_SPAWNER");

    /**
     * Unknown for now.
     */
    public static final SpawnType PASSIVE = DummyObjectProvider.createFor(SpawnType.class, "PASSIVE");

    /**
     * When an entity is placed into the world, likely from a command.
     */
    public static final SpawnType PLACEMENT = DummyObjectProvider.createFor(SpawnType.class, "PLACEMENT");

    /**
     * An entity spawned from a {@link Plugin}, this can be for any reason
     * as dictated by the plugin.
     */
    public static final SpawnType PLUGIN = DummyObjectProvider.createFor(SpawnType.class, "PLUGIN");

    /**
     * When an entity is spawned as a projectile, either from
     * being "thrown" or "launched".
     */
    public static final SpawnType PROJECTILE = DummyObjectProvider.createFor(SpawnType.class, "PROJECTILE");

    /**
     * When an entity is spawned from an {@link ItemTypes#SPAWN_EGG}.
     */
    public static final SpawnType SPAWN_EGG = DummyObjectProvider.createFor(SpawnType.class, "SPAWN_EGG");

    /**
     * When an entity is spawned from a structure or {@link Populator}, usually
     * during world/chunk generation.
     */
    public static final SpawnType STRUCTURE = DummyObjectProvider.createFor(SpawnType.class, "STRUCTURE");

    /**
     * When an entity is spawned from {@link BlockTypes#TNT}.
     */
    public static final SpawnType TNT_IGNITE = DummyObjectProvider.createFor(SpawnType.class, "TNT_IGNITE");

    /**
     * When an entity is spawned from the current {@link Weather}
     * state of a {@link World}.
     */
    public static final SpawnType WEATHER = DummyObjectProvider.createFor(SpawnType.class, "WEATHER");

    /**
     * An entity spawned from the normal world spawner (natural spawning).
     */
    public static final SpawnType WORLD_SPAWNER = DummyObjectProvider.createFor(SpawnType.class, "WORLD_SPAWNER");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private SpawnTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
