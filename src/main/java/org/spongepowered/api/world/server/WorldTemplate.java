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
package org.spongepowered.api.world.server;

import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.ResourceKeyed;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.datapack.DataPackSerializable;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.registry.RegistryReference;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.ResourceKeyedBuilder;
import org.spongepowered.api.world.SerializationBehavior;
import org.spongepowered.api.world.WorldType;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.generation.ChunkGenerator;
import org.spongepowered.api.world.generation.config.WorldGenerationConfig;
import org.spongepowered.math.vector.Vector3i;

import java.util.Optional;

public interface WorldTemplate extends ResourceKeyed, DataPackSerializable {

    static WorldTemplate overworld() {
        return Sponge.game().factoryProvider().provide(Factory.class).overworld();
    }

    static WorldTemplate overworldCaves() {
        return Sponge.game().factoryProvider().provide(Factory.class).overworldCaves();
    }

    static WorldTemplate theNether() {
        return Sponge.game().factoryProvider().provide(Factory.class).theNether();
    }

    static WorldTemplate theEnd() {
        return Sponge.game().factoryProvider().provide(Factory.class).theEnd();
    }

    static WorldTemplate.Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class).reset();
    }

    Optional<Component> displayName();

    RegistryReference<WorldType> worldType();

    ChunkGenerator generator();

    WorldGenerationConfig generationConfig();

    Optional<RegistryReference<GameMode>> gameMode();

    Optional<RegistryReference<Difficulty>> difficulty();

    Optional<SerializationBehavior> serializationBehavior();

    boolean loadOnStartup();

    boolean performsSpawnLogic();

    Optional<Boolean> hardcore();

    Optional<Boolean> commands();

    Optional<Boolean> pvp();

    Optional<Integer> viewDistance();

    Optional<Vector3i> spawnPosition();

    default Builder asBuilder() {
        return Sponge.game().builderProvider().provide(Builder.class).from(this);
    }

    interface Builder extends ResourceKeyedBuilder<WorldTemplate, Builder>, CopyableBuilder<WorldTemplate, Builder> {

        Builder displayName(@Nullable Component displayName);

        Builder worldType(RegistryReference<WorldType> type);

        Builder generator(ChunkGenerator generator);

        Builder generationConfig(WorldGenerationConfig generationConfig);

        Builder gameMode(RegistryReference<GameMode> gameMode);

        Builder difficulty(RegistryReference<Difficulty> difficulty);

        Builder serializationBehavior(@Nullable SerializationBehavior behavior);

        Builder loadOnStartup(boolean loadOnStartup);

        Builder performsSpawnLogic(boolean performsSpawnLogic);

        Builder hardcore(@Nullable Boolean hardcore);

        Builder commands(@Nullable Boolean commands);

        Builder pvp(@Nullable Boolean pvp);

        Builder viewDistance(@Nullable Integer distance);

        Builder spawnPosition(@Nullable Vector3i position);
    }

    interface Factory {

        WorldTemplate overworld();

        WorldTemplate overworldCaves();

        WorldTemplate theNether();

        WorldTemplate theEnd();
    }
}
