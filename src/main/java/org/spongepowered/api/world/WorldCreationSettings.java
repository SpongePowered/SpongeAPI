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

import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;
import org.spongepowered.api.world.storage.WorldProperties;

import java.util.Collection;

/**
 * A representation of the settings which define a {@link World} for creation.
 */
public interface WorldCreationSettings {

    static WorldCreationSettings.Builder builder() {
        return Sponge.getGame().getRegistry().createBuilder(Builder.class);
    }

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
     * Gets whether PVP combat is enabled in this world.
     *
     * @return Whether PVP is enabled
     */
    boolean isPVPEnabled();

    /**
     * Gets a {@link DataContainer} of any extra settings required by the
     * generator.
     *
     * @return The generator settings
     */
    DataContainer getGeneratorSettings();

    interface Builder extends ResettableBuilder<Builder> {
        /**
         * Fills this {@link Builder} for creating {@link World}s or
         * {@link WorldCreationSettings}s, the builder is then seeded with the
         * values from the given WorldCreationSettings object.
         *
         * @param settings The seed settings
         * @return A new seeded builder
         */
        Builder fill(WorldCreationSettings settings);

        /**
         * Fills this {@link Builder} for creating {@link World}s or
         * {@link WorldCreationSettings}s, the builder is then seeded with the
         * values from the given WorldProperties object.
         *
         * @param properties The seed properties
         * @return A new seeded builder
         */
        Builder fill(WorldProperties properties);

        /**
         * Sets the name of the world.
         *
         * @param name The name
         * @return The builder, for chaining
         */
        Builder name(String name);

        /**
         * Sets the world as enabled. A world which is enabled but unloaded may be
         * loaded automatically if an attempt is made to transfer an entity to the
         * world using {@link Entity#transferToWorld} .
         *
         * @param state Should be enabled
         * @return The builder, for chaining
         */
        Builder enabled(boolean state);

        /**
         * Sets whether the world should load when the server starts up.
         *
         * @param state Should load on startup
         * @return The builder, for chaining
         */
        Builder loadsOnStartup(boolean state);

        /**
         * Sets whether the spawn chunks of the world should remain loaded when no
         * players are present.
         *
         * @param state Should keep spawn loaded
         * @return The builder, for chaining
         */
        Builder keepsSpawnLoaded(boolean state);

        /**
         * Sets the seed of the world. If not specified this will default to using a
         * random seed.
         *
         * @param seed The seed
         * @return The builder, for chaining
         */
        Builder seed(long seed);

        /**
         * Sets the default {@link GameMode} of the world. If not specified this
         * will default to {@link GameModes#SURVIVAL}.
         *
         * @param gameMode The gamemode
         * @return The builder, for chaining
         */
        Builder gameMode(GameMode gameMode);

        /**
         * Sets the generator type of the world.
         *
         * @param type The type
         * @return The builder, for chaining
         */
        Builder generator(GeneratorType type);

        /**
         * Sets the generator modifiers to use for the world.
         *
         * @param modifier The modifiers
         * @return The builder, for chaining
         * @throws IllegalArgumentException If one of the modifiers is not
         *             registered in {@link GameRegistry}.
         */
        Builder generatorModifiers(WorldGeneratorModifier... modifier);

        /**
         * Sets the dimension type of the world.
         *
         * @param type The type
         * @return The builder, for chaining
         */
        Builder dimension(DimensionType type);

        /**
         * Sets whether this world should generate map features such as villages and
         * strongholds. If not specified this will default to true.
         *
         * @param enabled Are map features enabled
         * @return The builder, for chaining
         */
        Builder usesMapFeatures(boolean enabled);

        /**
         * Sets whether hardcore mode is enabled. On servers this will cause players
         * to be banned upon death, on clients the world will be deleted! If not
         * specified this will default to false.
         *
         * @param enabled Is hardcore mode enabled
         * @return The builder, for chaining
         */
        Builder hardcore(boolean enabled);

        /**
         * Sets any extra settings required by the {@link GeneratorType} or by the
         * {@link WorldGeneratorModifier}s. If not specified these will default to
         * the settings within {@link GeneratorType#getGeneratorSettings()}.
         *
         * @param settings The generator settings
         * @return The builder, for chaining
         */
        Builder generatorSettings(DataContainer settings);

        /**
         * Sets the desired {@link TeleporterAgent} for the world to be created.
         *
         * @param agent The agent
         * @return This builder, for chaining
         */
        Builder teleporterAgent(TeleporterAgent agent);

        /**
         * Sets whether PVP combat is enabled in this world.
         *
         * @param enabled Whether PVP is enabled
         * @return The builder, for chaining
         */
        Builder pvp(boolean enabled);

        /**
         * Builds the {@link WorldCreationSettings} which can be used to create a {@link World}
         * in {@link Server#createWorldProperties(WorldCreationSettings)}.
         *
         * @return The settings
         */
        WorldCreationSettings build();
    }
}
