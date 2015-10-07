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

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.type.GameMode;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;

import java.util.Collection;

/**
 * A representation of the settings which define a world for creation.
 */
public interface WorldCreationSettings {

    /**
     * Gets the name of the world.
     * 
     * @return The name
     */
    String getWorldName();

    /**
     * Gets whether this world is enabled. A world which is enabled but unloaded
     * may be loaded automatically if an attempt is made to transfer an entity
     * to the world using {@link Entity#transferToWorld} .
     * 
     * @return Is enabled
     */
    boolean isEnabled();

    /**
     * Gets whether this world will load when the server starts up.
     * 
     * @return Loads on startup
     */
    boolean loadOnStartup();

    /**
     * Returns whether spawn chunks of this world remain loaded when no players
     * are present.
     *
     * @return True if spawn chunks of this world remain loaded without players,
     *         false if not
     */
    boolean doesKeepSpawnLoaded();

    /**
     * Gets the seed of the world.
     * 
     * @return The seed
     */
    long getSeed();

    /**
     * Gets the default gamemode of the world.
     * 
     * @return The gamemode
     */
    GameMode getGameMode();

    /**
     * Gets the type of the generator for the world.
     * 
     * @return The generator type
     */
    GeneratorType getGeneratorType();

    /**
     * Gets an immutable collection of the world generator modifiers applied
     * to this world.
     * @return The modifiers
     */
    Collection<WorldGeneratorModifier> getGeneratorModifiers();

    /**
     * Gets whether map features are enabled to be generated into the world.
     * 
     * @return Are map features enabled
     */
    boolean usesMapFeatures();

    /**
     * Gets whether hardcore mode is enabled in this world.
     * 
     * @return Is hardcore
     */
    boolean isHardcore();

    /**
     * Gets whether commands are allowed in this world.
     * 
     * @return Are commands allowed
     */
    boolean commandsAllowed();

    /**
     * Gets whether the bonus chest should be created in this world.
     * 
     * @return Should create bonus chest
     */
    boolean bonusChestEnabled();

    /**
     * Gets the dimension type for the world.
     * 
     * @return The dimension type
     */
    DimensionType getDimensionType();

    /**
     * Gets a {@link DataContainer} of any extra settings required by the
     * generator.
     *
     * @return The generator settings
     */
    DataContainer getGeneratorSettings();

}
