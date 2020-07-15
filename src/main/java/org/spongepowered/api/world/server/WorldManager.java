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

import org.spongepowered.api.Game;
import org.spongepowered.api.event.lifecycle.LifecycleEvent;
import org.spongepowered.api.world.WorldArchetype;
import org.spongepowered.api.world.storage.WorldProperties;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface WorldManager {

    /**
     * Gets the directory where the game will store save files.
     *
     * <p>This location differs based on the implementation and is therefore implementation-specific.</p>
     *
     * <p>To elaborate, this is how it is handled in Minecraft based on side:</p>
     *
     * <ul>
     *     <li>Client
     *      <ul><li>This directory will point to {@link Game#getGameDirectory()}.resolve("saves").resolve(currentSaveName)</li></ul>
     *     <li>Server
     *      <ul><li>This directory will be equivalent to {@link Game#getGameDirectory()}.resolve(level-name).</li></ul>
     * </ul>
     *
     * <p>Consult your specific implementation if they support placing this elsewhere.</p>
     *
     * @return The saves directory
     */
    Path getSavesDirectory();

    /**
     * Gets a loaded {@link ServerWorld} by its unique id ({@link UUID}), if it
     * exists.
     *
     * @param uniqueId UUID to lookup
     * @return The world, if found
     */
    Optional<ServerWorld> getWorld(UUID uniqueId);

    /**
     * Gets a loaded {@link ServerWorld} by it's directory name, if it exists.
     *
     * @param directoryName Name to lookup
     * @return The world, if found
     */
    Optional<ServerWorld> getWorld(String directoryName);

    /**
     * Gets all currently loaded {@link ServerWorld}s.
     *
     * @return A collection of loaded worlds
     */
    Collection<ServerWorld> getWorlds();

    /**
     * Gets the default {@link WorldProperties} name that the {@link WorldManager} creates and loads.
     *
     * @return The name
     */
    String getDefaultPropertiesName();

    /**
     * Gets the default loaded {@link WorldProperties} or {@link Optional#empty()} if none has been loaded.
     *
     * <p>It is up to the implementation to determine when and if a default is loaded.</p>
     *
     * @return The world properties
     */
    Optional<WorldProperties> getDefaultProperties();

    /**
     * Submits a registration, by directory name, for a world to be known to this {@link WorldManager} and an {@link WorldArchetype}
     * that will be used to load it.
     *
     * <p>
     *     Creating a {@link WorldProperties} or loading a {@link ServerWorld} will do this on the plugin developer's behalf but
     *     if the desire is present for the server to handle the loading in a more natural way during a server lifecycle, assuming the implementation
     *     behaves in that manner, then this is recommended to be used in the appropriate {@link LifecycleEvent event}.
     * </p>
     *
     * <p>
     *     The result of this method is left up to the implementation to define. In the vanilla implementation of this API, a false
     *     result means the registration already existed.
     * </p>
     * 
     * @param directoryName The directory name
     * @param archetype The archetype
     * @return True if successful, false otherwise
     */
    boolean submitRegistration(String directoryName, WorldArchetype archetype);

    /**
     * Creates a new {@link WorldProperties} from the given
     * {@link WorldArchetype}. For the creation of the {@link WorldArchetype} please see {@link WorldArchetype.Builder}.
     *
     * <p>It is up to the implementation to define an {@link Optional#empty()} result. In vanilla Minecraft, this would happen if the directory
     * already exists in the default world container or an IO error occurred when loading.</p>
     *
     * <p>The returned properties should be considered "virtual" as it will not exist on the disk nor will the manager consider it "offline data".
     *
     * To write it to the default storage container, use one of the following methods:
     * <ul> <li>{@link #loadWorld(WorldProperties)}</li> <li>{@link #saveProperties(WorldProperties)}</li> </ul>
     * </p>
     *
     * @param directoryName The directory name
     * @param archetype The archetype for creation
     * @return The new world properties, if the creation was successful
     */
    CompletableFuture<Optional<WorldProperties>> createProperties(String directoryName, WorldArchetype archetype);

    /**
     * Loads a {@link ServerWorld} from the default storage container. If a world with
     * the given name is already loaded then it is returned instead.
     *
     * @param directoryName The name to lookup
     * @return The world, if found
     */
    CompletableFuture<Optional<ServerWorld>> loadWorld(String directoryName);

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
     * @return The world, if found
     */
    CompletableFuture<Optional<ServerWorld>> loadWorld(WorldProperties properties) throws IOException;

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
     * Gets the {@link WorldProperties} of a world. If a world with the given
     * name is loaded then this is equivalent to calling {@link ServerWorld#getProperties()}.
     *
     * However, if no loaded world is found then an attempt will be made to match to a known unloaded world.
     *
     * @param directoryName The name to lookup
     * @return The world properties, if found
     */
    Optional<WorldProperties> getProperties(String directoryName);

    /**
     * Gets the {@link WorldProperties} of a world. If a world with the given
     * UUID is loaded then this is equivalent to calling
     * {@link ServerWorld#getProperties()}. However, if no loaded world is found then
     * an attempt will be made to match to a known unloaded world.
     *
     * @param uniqueId The UUID to lookup
     * @return The world properties, if found
     */
    Optional<WorldProperties> getProperties(UUID uniqueId);

    /**
     * Gets the properties of all unloaded worlds.
     *
     * <p>It is left up to the implementation to determine it's offline worlds and no contract is enforced
     * that states that they must returns all unloaded worlds that actually exist.</p>
     *
     * @return A collection of world properties
     */
    Collection<WorldProperties> getUnloadedProperties();

    /**
     * Gets the properties of all worlds, online and offline.
     *
     * <p>It is left up to the implementation to determine it's offline worlds and no contract is enforced
     * that states that they must returns all unloaded worlds that actually exist.</p>
     *
     * @return A collection of world properties
     */
    Collection<WorldProperties> getAllProperties();

    /**
     * Persists the given {@link WorldProperties} to the world storage for it,
     * updating any modified values.
     *
     * @param properties The world properties to save
     * @return True if the save was successful, can fail exceptionally
     */
    CompletableFuture<Boolean> saveProperties(WorldProperties properties);

    /**
     * Creates a world copy asynchronously using the new name given and returns
     * the new world properties if the copy was possible.
     *
     * <p>If the world is already loaded then the following will occur:</p>
     *
     * <ul>
     * <li>World is saved.</li>
     * <li>World saving is disabled.</li>
     * <li>World is copied. </li>
     * <li>World saving is enabled.</li>
     * </ul>
     *
     * @param directoryName The directory name
     * @param copyName The copies' name
     * @return An {@link Optional} containing the properties of the new world
     *         instance, if the copy was successful
     */
    CompletableFuture<Optional<WorldProperties>> copyWorld(String directoryName, String copyName);

    /**
     * Renames a {@link WorldProperties}.
     *
     * <p>If the properties represents an online world, an attempt will be made to unload it. Once unloaded and if
     * the attempt is successful, an attempt will be made to load it. It is left up to the implementation to determine
     * the conditions for a rename to be successful.</p>
     *
     * @param oldDirectoryName The old directory name
     * @param newDirectoryName The new directory name
     * @return An {@link Optional} containing the new {@link WorldProperties}
     *         if the rename was successful
     */
    CompletableFuture<Optional<WorldProperties>> renameWorld(String oldDirectoryName, String newDirectoryName);

    /**
     * Deletes the provided world's files asynchronously from the disk.
     *
     * @param directoryName The directory name to delete
     * @return True if the deletion was successful.
     */
    CompletableFuture<Boolean> deleteWorld(String directoryName);
}
