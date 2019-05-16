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
package org.spongepowered.api.world;

import org.spongepowered.api.Game;
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
     *      <ul>This directory will point to {@link Game#getGameDirectory()}.resolve("saves").resolve(currentSaveName)</ul>
     *     <li>Server
     *      <ul>This directory will be equivalent to {@link Game#getGameDirectory()}.resolve(level-name).</ul>
     * </ul>
     *
     * <p>Consult your specific implementation if they support placing this elsewhere.</p>
     *
     * @return The saves directory
     */
    Path getSavesDirectory();

    /**
     * Gets a loaded {@link World} by its unique id ({@link UUID}), if it
     * exists.
     *
     * @param uniqueId UUID to lookup
     * @return The world, if found
     */
    Optional<World> getWorld(UUID uniqueId);

    /**
     * Gets a loaded {@link World} by it's directory name, if it exists.
     *
     * @param directoryName Name to lookup
     * @return The world, if found
     */
    Optional<World> getWorld(String directoryName);

    /**
     * Gets all currently loaded {@link World}s.
     *
     * @return A collection of loaded worlds
     */
    Collection<World> getWorlds();

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
     * Submits a new {@link WorldRegistration} to be known to this {@link WorldManager}.
     *
     * <p>
     *     While {@link WorldManager#createProperties(WorldRegistration, WorldArchetype)} will do this on the
     *     plugin developer's behalf, it is wise to perform registration during a plugin's lifecycle events so
     *     that the directory of the future {@link WorldProperties} will be reserved.
     * </p>
     * @param registration The registration
     */
    void submitRegistration(WorldRegistration registration);

    /**
     * Creates a new {@link WorldProperties} from the given
     * {@link WorldArchetype}. For the creation of the WorldArchetype please see
     * {@link org.spongepowered.api.world.WorldArchetype.Builder}.
     *
     * <p>If the {@link World} exists at the directory name given, the properties
     * representing that directory name are returned instead.</p>
     *
     * <p>Although the world is created it is not loaded at this time. Please
     * see one of the following methods for loading the world.</p>
     *
     * <ul> <li>{@link #loadWorld(String)}</li> <li>{@link #loadWorld(WorldProperties)}</li> </ul>
     *
     * @param registration The world registration
     * @param archetype The archetype for creation
     * @return The new or existing world properties, if creation was successful
     * @throws IOException If there are any io issues creating the properties
     *      file
     */
    Optional<WorldProperties> createProperties(WorldRegistration registration, WorldArchetype archetype) throws IOException;

    /**
     * Loads a {@link World} from the default storage container. If a world with
     * the given name is already loaded then it is returned instead.
     *
     * @param directoryName The name to lookup
     * @return The world, if found
     */
    Optional<World> loadWorld(String directoryName);

    /**
     * Loads a {@link World} from the default storage container. If the world
     * associated with the given properties is already loaded then it is
     * returned instead.
     *
     * @param properties The properties of the world to load
     * @return The world, if found
     */
    Optional<World> loadWorld(WorldProperties properties);

    /**
     * Registers a {@link WorldRegistration}, creates the {@link WorldProperties} (if it doesn't exist), and loads the {@link World}
     * in one step.
     *
     * @param registration The registration
     * @param archetype The archetype
     * @return The {@link World} or {@link Optional#empty()} if it was not loaded
     * @throws IOException If the {@link WorldProperties} failed to create due to a filesystem error
     */
    default Optional<World> loadWorld(WorldRegistration registration, WorldArchetype archetype) throws IOException {
        return this.createProperties(registration, archetype).flatMap(this::loadWorld);
    }

    /**
     * Unloads a {@link World}.
     *
     * <p>The conditions for how and when a world may be unloaded are left up to the
     * implementation to define.</p>
     *
     * <p>Should the {@link WorldProperties} of the unloaded world return {@link WorldProperties#isEnabled()}
     * 'true' then this server will attempt to load the world during the next startup phase.</p>
     *
     * @param world The world to unload
     * @return Whether the operation was successful
     */
    boolean unloadWorld(World world);

    /**
     * Gets the {@link WorldProperties} of a world. If a world with the given
     * name is loaded then this is equivalent to calling
     * {@link World#getProperties()}. However, if no loaded world is found then
     * an attempt will be made to match to a known unloaded world.
     *
     * @param directoryName The name to lookup
     * @return The world properties, if found
     */
    Optional<WorldProperties> getProperties(String directoryName);

    /**
     * Gets the {@link WorldProperties} of a world. If a world with the given
     * UUID is loaded then this is equivalent to calling
     * {@link World#getProperties()}. However, if no loaded world is found then
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
     * Gets the properties of all worlds.
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
     * @return True if the save was successful
     */
    boolean saveProperties(WorldProperties properties);

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
    Optional<WorldProperties> renameWorld(String oldDirectoryName, String newDirectoryName);

    /**
     * Deletes the provided world's files asynchronously from the disk.
     *
     * @param directoryName The directory name to delete
     * @return True if the deletion was successful.
     */
    CompletableFuture<Boolean> deleteWorld(String directoryName);
}
