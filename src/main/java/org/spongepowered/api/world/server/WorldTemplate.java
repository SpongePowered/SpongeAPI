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
import org.spongepowered.api.ResourceKeyed;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.datapack.DataPack;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.registry.RegistryReference;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.ResourceKeyedBuilder;
import org.spongepowered.api.world.SerializationBehavior;
import org.spongepowered.api.world.WorldType;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.generation.ChunkGenerator;
import org.spongepowered.api.world.server.storage.ServerWorldProperties;
import org.spongepowered.math.vector.Vector3i;

import java.io.IOException;
import java.util.Optional;

/**
 * A template for a {@link ServerWorld}.
 * <p>Serialized into a data pack at {@code data/<namespace>/dimension/<value>.json}</p>
 */
public interface WorldTemplate extends ResourceKeyed, DataPack.Persistent, DataHolder {

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

    default Optional<Component> displayName() {
        return this.get(Keys.DISPLAY_NAME);
    }

    default RegistryReference<WorldType> worldType() {
        return this.require(Keys.WORLD_TYPE);
    }

    default ChunkGenerator generator() {
        return this.require(Keys.CHUNK_GENERATOR);
    }

    default Optional<RegistryReference<GameMode>> gameMode() {
        return this.get(Keys.GAME_MODE_REFERENCE);
    }

    default Optional<RegistryReference<Difficulty>> difficulty() {
        return this.get(Keys.WORLD_DIFFICULTY);
    }

    default Optional<SerializationBehavior> serializationBehavior() {
        return this.get(Keys.SERIALIZATION_BEHAVIOR);
    }

    default boolean loadOnStartup() {
        return this.require(Keys.IS_LOAD_ON_STARTUP);
    }

    default boolean performsSpawnLogic() {
        return this.require(Keys.PERFORM_SPAWN_LOGIC);
    }

    default Optional<Boolean> hardcore() {
        return this.get(Keys.HARDCORE);
    }

    default Optional<Boolean> commands() {
        return this.get(Keys.COMMANDS);
    }

    default Optional<Boolean> pvp() {
        return this.get(Keys.PVP);
    }

    default Optional<Integer> viewDistance() {
        return this.get(Keys.VIEW_DISTANCE);
    }

    default Optional<Vector3i> spawnPosition() {
        return this.get(Keys.SPAWN_POSITION);
    }

    default Builder asBuilder() {
        return Sponge.game().builderProvider().provide(Builder.class).from(this);
    }

    interface Builder extends ResourceKeyedBuilder<WorldTemplate, Builder>, CopyableBuilder<WorldTemplate, Builder> {

        <V> Builder add(Key<? extends Value<V>> key, V value);

        /**
         * Creates a world template based on the given data view.
         * <p>The given data must be equivalent to a data-pack for world-templates (dimension)</p>
         *
         * @param pack the data
         * @return the created WorldTemplate
         */
        Builder fromDataPack(DataView pack) throws IOException;

        Builder from(ServerWorld world);

        Builder from(ServerWorldProperties worldProperties);
    }

    interface Factory {

        WorldTemplate overworld();

        WorldTemplate overworldCaves();

        WorldTemplate theNether();

        WorldTemplate theEnd();
    }
}
