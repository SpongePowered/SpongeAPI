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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Server;
import org.spongepowered.api.world.WorldType;
import org.spongepowered.api.world.server.storage.ServerWorldProperties;

import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public interface WorldManager {

    /**
     * Gets the {@link Server}.
     *
     * @return The server
     */
    Server server();

    /**
     * Gets a {@link ServerWorld world} by a {@link ResourceKey key}.
     *
     * @param key The key
     * @return The world, if found
     */
    Optional<ServerWorld> world(ResourceKey key);

    /**
     * Gets a {@link Path directory} that is used for the world's data
     * identified by {@link ResourceKey world key}. It is not guaranteed
     * the path will exist until the world is formally loaded by the game.
     *
     * @param key The world's identifier key
     * @return The directory to be used if it doesn't exist
     */
    Path worldDirectory(ResourceKey key);

    /**
     * Gets all currently loaded {@link ServerWorld worlds}.
     *
     * @return The worlds
     */
    Collection<ServerWorld> worlds();

    /**
     * Gets the {@link ResourceKey keys} of both online and offline {@link ServerWorld worlds}.
     *
     * <p>It is up to the implementation to determine how offline keys are provided to the developer.</p>
     *
     * @return The keys
     */
    List<ResourceKey> worldKeys();

    /**
     * Gets the {@link ResourceKey keys} of offline {@link ServerWorld worlds}.
     *
     * <p>It is up to the implementation to determine how offline keys are provided to the developer.</p>
     *
     * @return The keys
     */
    default List<ResourceKey> offlineWorldKeys() {
        return this.worldKeys()
            .stream()
            .filter(v -> !this.world(v).isPresent())
            .collect(Collectors.toList());
    }

    /**
     * Gets if a {@link ResourceKey key} exists as an actual world, offline or online.
     *
     * @param key The key
     * @return True if existed, false if not
     */
    boolean worldExists(ResourceKey key);

    /**
     * Gets a {@link ResourceKey key} by {@link UUID unique id}.
     *
     * @param uniqueId The unique id
     * @return The key or {@link Optional#empty()} if not found
     */
    Optional<ResourceKey> worldKey(UUID uniqueId);

    /**
     * Retrieves all {@link ServerWorld worlds} that are of a particular {@link WorldType type}.
     * @param type The type
     * @return The {@link Collection worlds}
     */
    Collection<ServerWorld> worldsOfType(WorldType type);

    /**
     * Loads a {@link ServerWorld world} by a {@link ResourceKey key}.
     *
     * <p>If a world with the given name is already loaded, the operation fails.</p>
     *
     * @param key The key
     * @return The world, if loaded.
     */
    default CompletableFuture<Optional<ServerWorld>> loadWorld(ResourceKey key) {
        return this.loadWorld(key, ServerWorldProperties.LoadOptions.load());
    }

    /**
     * Loads a {@link ServerWorld world} by a {@link ResourceKey key}
     * with the provided {@link ServerWorldProperties.LoadOptions load options}.
     *
     * @param key The key
     * @param propertiesLoadOptions The options used to load the {@link ServerWorldProperties properties}.
     * @return The world, if found.
     */
    CompletableFuture<Optional<ServerWorld>> loadWorld(ResourceKey key, ServerWorldProperties.LoadOptions propertiesLoadOptions);

    /**
     * Unloads a {@link ServerWorld world} by a {@link ResourceKey key}.
     *
     * <p>The default Minecraft world cannot be unloaded. Additional conditions for how and when a world may
     * be unloaded are left up to the implementation to define.</p>
     *
     * @param key The key to unload
     * @return Whether the operation was successful
     */
    CompletableFuture<Boolean> unloadWorld(ResourceKey key);

    /**
     * Unloads a {@link ServerWorld world}.
     *
     * <p>The default Minecraft world cannot be unloaded. Additional conditions for how and when a world may
     * be unloaded are left up to the implementation to define.</p>
     *
     * @param world The world to unload
     * @return Whether the operation was successful
     */
    CompletableFuture<Boolean> unloadWorld(ServerWorld world);

    /**
     * Loads the {@link ServerWorldProperties properties}.
     *
     * <p>It is left up to the implementation on what conditions cause a failure of loading properties.</p>
     *
     * @param key The key
     * @return The properties
     */
    default CompletableFuture<Optional<ServerWorldProperties>> loadProperties(ResourceKey key) {
        return this.loadProperties(key, ServerWorldProperties.LoadOptions.load());
    }

    /**
     * Loads the {@link ServerWorldProperties properties} with
     * the provided {@link ServerWorldProperties.LoadOptions load options}.
     *
     * @param key The key
     * @param propertiesLoadOptions The options used to load the {@link ServerWorldProperties properties}.
     * @return The properties
     */
    CompletableFuture<Optional<ServerWorldProperties>> loadProperties(ResourceKey key, ServerWorldProperties.LoadOptions propertiesLoadOptions);

    /**
     * Saves a {@link ServerWorldProperties properties}.
     *
     * @param properties The properties
     * @return True if successful, false if not
     */
    CompletableFuture<Boolean> saveProperties(ServerWorldProperties properties);

    /**
     * Copies world data under the provided {@link ResourceKey key} to a provided key.
     *
     * <p>If the world is loaded, the following will occur:</p>
     *
     * <ul>
     *     <li>World is saved</li>
     *     <li>World saving is disabled</li>
     *     <li>World is copied</li>
     *     <li>World saving is enabled</li>
     * </ul>
     *
     * <p>It is left up to the implementation on exactly what is copied.</p>
     *
     * @param key The key
     * @param copyKey The copied key for the new properties
     * @return The copied properties
     */
    CompletableFuture<Boolean> copyWorld(ResourceKey key, ResourceKey copyKey);

    /**
     * Moves world data under the provided {@link ResourceKey key} to another key.
     *
     * <p>If the world is loaded, the following will occur:</p>
     *
     * <ul>
     *     <li>World is saved</li>
     *     <li>World is unloaded</li>
     *     <li>World is moved</li>
     * </ul>
     *
     * <p>The default Minecraft world cannot be moved. Additionally, it is left up to the
     * implementation on exactly what is moved.</p>
     *
     * @param key The key
     * @param moveKey The move key
     * @return True if the move was successful
     */
    CompletableFuture<Boolean> moveWorld(ResourceKey key, ResourceKey moveKey);

    /**
     * Deletes world data under the provided {@link ResourceKey key}.
     *
     * <p>If the world is loaded, the following will occur:</p>
     *
     * <ul>
     *     <li>World is unloaded</li>
     *     <li>World is deleted</li>
     * </ul>
     *
     * <p>The default Minecraft world cannot be deleted. Additionally, it is left up to the
     * implementation on exactly what is deleted.</p>
     *
     * @param key The key
     * @return True if the deletion was successful.
     */
    CompletableFuture<Boolean> deleteWorld(ResourceKey key);
}
