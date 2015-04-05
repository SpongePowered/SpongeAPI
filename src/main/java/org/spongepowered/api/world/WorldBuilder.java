/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import com.google.common.base.Optional;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.player.gamemode.GameMode;
import org.spongepowered.api.entity.player.gamemode.GameModes;
import org.spongepowered.api.service.persistence.data.DataContainer;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;

/**
 * A builder for {@link World}s and {@link WorldCreationSettings}.
 */
public interface WorldBuilder {

    /**
     * Sets the name of the world.
     * 
     * @param name The name
     * @return The builder, for chaining
     */
    WorldBuilder name(String name);

    /**
     * Sets the world as enabled. A world which is enabled but unloaded may be
     * loaded automatically if an attempt is made to transfer an entity to the
     * world using {@link Entity#transferToWorld} .
     * 
     * @param state Should be enabled
     * @return The builder, for chaining
     */
    WorldBuilder enabled(boolean state);

    /**
     * Sets whether the world should load when the server starts up.
     * 
     * @param state Should load on startup
     * @return The builder, for chaining
     */
    WorldBuilder loadsOnStartup(boolean state);

    /**
     * Sets whether the spawn chunks of the world should remain loaded when no
     * players are present.
     * 
     * @param state Should keep spawn loaded
     * @return The builder, for chaining
     */
    WorldBuilder keepsSpawnLoaded(boolean state);

    /**
     * Sets the seed of the world. If not specified this will default to using a
     * random seed.
     * 
     * @param seed The seed
     * @return The builder, for chaining
     */
    WorldBuilder seed(long seed);

    /**
     * Sets the default {@link GameMode} of the world. If not specified this
     * will default to {@link GameModes#SURVIVAL}.
     * 
     * @param gameMode The gamemode
     * @return The builder, for chaining
     */
    WorldBuilder gameMode(GameMode gameMode);

    /**
     * Sets the generator type of the world.
     * 
     * @param type The type
     * @return The builder, for chaining
     */
    WorldBuilder generator(GeneratorType type);

    /**
     * Sets the generator modifiers to use for the world.
     *
     * @param modifier The modifiers
     * @return The builder, for chaining
     * @throws IllegalArgumentException If one of the modifiers is not
     *             registered in {@link GameRegistry}.
     */
    WorldBuilder generatorModifiers(WorldGeneratorModifier... modifier);

    /**
     * Sets the dimension type of the world.
     * 
     * @param type The type
     * @return The builder, for chaining
     */
    WorldBuilder dimensionType(DimensionType type);

    /**
     * Sets whether this world should generate map features such as villages and
     * strongholds. If not specified this will default to true.
     * 
     * @param enabled Are map features enabled
     * @return The builder, for chaining
     */
    WorldBuilder usesMapFeatures(boolean enabled);

    /**
     * Sets whether hardcore mode is enabled. On servers this will cause players
     * to be banned upon death, on clients the world will be deleted! If not
     * specified this will default to false.
     * 
     * @param enabled Is hardcore mode enabled
     * @return The builder, for chaining
     */
    WorldBuilder hardcore(boolean enabled);

    /**
     * Sets any extra settings required by the {@link GeneratorType} or by the
     * {@link WorldGeneratorModifier}s. If not specified these will default to
     * the settings within {@link GeneratorType#getGeneratorSettings()}.
     *
     * @param settings The generator settings
     * @return The builder, for chaining
     */
    WorldBuilder generatorSettings(DataContainer settings);

    /**
     * Resets this builder to a clean state.
     *
     * @return This builder, for chaining
     */
    WorldBuilder reset();

    /**
     * Attempts to create a {@link World} from the specified parameters.
     * 
     * @return The world, if successful
     * @throws IllegalStateException If any required parameters are missing
     */
    Optional<World> build() throws IllegalStateException;

    /**
     * Attempts to create a {@link WorldCreationSettings} which may be later
     * used to create a world.
     * 
     * @return The world settings
     * @throws IllegalStateException If any required parameters are missing
     */
    WorldCreationSettings buildSettings() throws IllegalStateException;

}
