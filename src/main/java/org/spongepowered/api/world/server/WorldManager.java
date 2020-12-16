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
import org.spongepowered.api.world.WorldArchetype;
import org.spongepowered.api.world.storage.WorldProperties;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface WorldManager {

    /**
     * Gets the {@link Server}.
     *
     * @return The server
     */
    Server getServer();

    /**
     * Gets a loaded {@link ServerWorld} by it's {@link ResourceKey key}.
     *
     * @param key The key
     * @return The world, if found
     */
    Optional<ServerWorld> getWorld(ResourceKey key);

    /**
     * Gets all currently loaded {@link ServerWorld}s.
     *
     * @return A collection of loaded worlds
     */
    Collection<ServerWorld> getWorlds();

    /**
     * Gets the default loaded {@link ServerWorldProperties} or {@link Optional#empty()} if none has been loaded.
     *
     * <p>It is up to the implementation to determine when and if a default is loaded.</p>
     *
     * @return The world properties
     */
    default Optional<ServerWorldProperties> getDefaultProperties() {
        return this.getProperties(this.getServer().getDefaultWorldKey());
    }

    /**
     * Creates a new {@link ServerWorldProperties} from the given
     * {@link WorldArchetype}. For the creation of the {@link WorldArchetype} please see {@link WorldArchetype.Builder}.
     *
     * <p>It is up to the implementation to define an {@link Optional#empty()} result.</p>
     *
     * <p>The returned properties should be considered "virtual" as it will not exist on the disk nor will the manager consider it "offline data".
     *
     * To write it to the default storage container, use one of the following methods:
     * <ul> <li>{@link #loadWorld(ServerWorldProperties)}</li> <li>{@link #saveProperties(ServerWorldProperties)}</li> </ul>
     * </p>
     *
     * @param key The key
     * @param archetype The archetype for creation
     * @return The new world properties, if the creation was successful
     */
    CompletableFuture<ServerWorldProperties> createProperties(ResourceKey key, WorldArchetype archetype);

    /**
     * Loads a {@link ServerWorld} specified by a {@link ResourceKey key}. If a world with
     * the given name is already loaded then it is returned instead.
     *
     * @param key The key
     * @return The world
     */
    CompletableFuture<ServerWorld> loadWorld(ResourceKey key);

    /**
     * Loads a {@link ServerWorld} from the default storage container.
     *
     * <p>If the world associated with the given properties is already loaded then it is returned instead.</p>
     *
     * <p>If the given properties already has data within the default storage container it will be loaded instead.</p>
     *
     * <p>If none of the above, the properties will be wrote to the default storage container as a result of the load</p>
     *
     * @param properties The properties of the world to load
     * @return The world
     */
    CompletableFuture<ServerWorld> loadWorld(ServerWorldProperties properties);

    /**
     * Unloads the {@link ServerWorld} registered to the {@link ResourceKey key}.
     *
     * <p>The conditions for how and when a world may be unloaded are left up to the
     * implementation to define.</p>
     *
     * @param key The key to unload
     * @return Whether the operation was successful
     */
    CompletableFuture<Boolean> unloadWorld(ResourceKey key);

    /**
     * Unloads a {@link ServerWorld}.
     *
     * <p>The conditions for how and when a world may be unloaded are left up to the
     * implementation to define.</p>
     *
     * @param world The world to unload
     * @return Whether the operation was successful
     */
    CompletableFuture<Boolean> unloadWorld(ServerWorld world);

    /**
     * Gets the {@link ServerWorldProperties} by it's {@link ResourceKey key}. If a world with the given
     * name is loaded then this is equivalent to calling {@link ServerWorld#getProperties()}.
     *
     * However, if no loaded world is found then an attempt will be made to match to a known unloaded world.
     *
     * @param key The key
     * @return The world properties, if found
     */
    Optional<ServerWorldProperties> getProperties(ResourceKey key);

    /**
     * Gets the properties of all unloaded worlds.
     *
     * <p>It is left up to the implementation to determine it's offline worlds and no contract is enforced
     * that states that they must returns all unloaded worlds that actually exist.</p>
     *
     * @return A collection of world properties
     */
    Collection<ServerWorldProperties> getUnloadedProperties();

    /**
     * Gets the properties of all worlds, online and offline.
     *
     * <p>It is left up to the implementation to determine it's offline worlds and no contract is enforced
     * that states that they must returns all unloaded worlds that actually exist.</p>
     *
     * @return A collection of world properties
     */
    Collection<ServerWorldProperties> getAllProperties();

    /**
     * Persists the given {@link WorldProperties} to the world storage for it,
     * updating any modified values.
     *
     * @param properties The world properties to save
     * @return True if the save was successful, can fail exceptionally
     */
    CompletableFuture<Boolean> saveProperties(ServerWorldProperties properties);

    /**
     * Copies a {@link ServerWorldProperties properties} under the provided {@link ResourceKey key}.
     *
     * <p>If the world is already loaded then the following will occur:</p>
     *
     * <ul>
     *     <li>World is saved</li>
     *     <li>World saving is disabled</li>
     *     <li>World is copied</li>
     *     <li>World saving is enabled</li>
     * </ul>
     *
     * <p>It is left up to the implementation on exactly what is copied. The properties returned will not
     * represent a live world, it is recommended to call {@link WorldManager#loadWorld(ServerWorldProperties)}
     * if desired.</p>
     *
     * @param key The key
     * @param copyKey The copied key for the new properties
     * @return The copied properties
     */
    CompletableFuture<ServerWorldProperties> copyWorld(ResourceKey key, ResourceKey copyKey);

    /**
     * Moves a {@link ServerWorldProperties properties}.
     *
     * <p>If the world is loaded, the following will occur:</p>
     *
     * <ul>
     *     <li>World is saved</li>
     *     <li>World is unloaded</li>
     *     <li>World is moved, up to the implementation to determine how so</li>
     * </ul>
     *
     * <p>The default Minecraft worlds cannot be moved. Additionally, it is left up to the
     * implementation on exactly what is moved.</p>
     *
     * @param key The key
     * @param movedKey The moved key
     * @return The moved properties
     */
    CompletableFuture<ServerWorldProperties> moveWorld(ResourceKey key, ResourceKey movedKey);

    /**
     * Deletes a {@link ServerWorldProperties properties} by it's {@link ResourceKey key}.
     *
     * <p>If the world is loaded, the following will occur:</p>
     *
     * <u1>
     *     <li>World is unloaded</li>
     *     <li>World is deleted</li>
     * </u1>
     *
     * <p>The default Minecraft world, based on the implementation, cannot be deleted. Additionally,
     * it is left up to the implementation on what is deleted.</p>
     *
     * @param key The key
     * @return True if the deletion was successful.
     */
    CompletableFuture<Boolean> deleteWorld(ResourceKey key);
}
