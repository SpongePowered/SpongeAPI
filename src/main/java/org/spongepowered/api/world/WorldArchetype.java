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

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.Server;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;
import org.spongepowered.api.registry.CatalogTypeAlreadyRegisteredException;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;
import org.spongepowered.api.world.storage.WorldProperties;

import java.util.Collection;

/**
 * A representation of the settings which define a {@link World} for creation.
 */
@CatalogedBy(WorldArchetypes.class)
public interface WorldArchetype extends CatalogType {

    /**
     * Gets a new Builder instance for {@link WorldArchetype}.
     * 
     * @return A new builder instance
     */
    static WorldArchetype.Builder builder() {
        return Sponge.getGame().getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets enabled status. Built worlds who are enabled but unloaded may
     * be loaded automatically if an attempt is made to transfer an entity
     * to the world using {@link Entity#transferToWorld} .
     *
     * @return True if enabled, false if not
     */
    boolean isEnabled();

    /**
     * Gets whether to load when the server starts.
     *
     * @return True to load when server starts, false if not
     */
    boolean loadOnStartup();

    /**
     * Gets whether spawn chunks remain loaded when no players are present.
     *
     * @return True to keep spawn chunks loaded, false if not
     */
    boolean doesKeepSpawnLoaded();

    /**
     * Gets whether spawn chunks will generate on load.
     *
     * @return True to generate spawn on load, false if not
     */
    boolean doesGenerateSpawnOnLoad();

    /**
     * Gets the seed.
     * 
     * @return The seed
     */
    long getSeed();

    /**
     * Gets if the seed will be randomized for each world generated.
     * 
     * @return If the seed is randomized
     */
    boolean isSeedRandomized();

    /**
     * Gets the gamemode.
     *
     * @return The gamemode
     */
    GameMode getGameMode();

    /**
     * Gets the generator type.
     * 
     * @return The generator type
     */
    GeneratorType getGeneratorType();

    /**
     * Gets an immutable collection of the world generator modifiers.
     * 
     * @return The modifiers
     */
    Collection<WorldGeneratorModifier> getGeneratorModifiers();

    /**
     * Gets whether map features are enabled.
     *
     * <p>Examples include Villages, Temples, etc.</p>
     * 
     * @return True if map features are enabled, false if not
     */
    boolean usesMapFeatures();

    /**
     * Gets whether hardcore mode is enabled.
     * 
     * @return True if hardcore mode is enabled, false if not
     */
    boolean isHardcore();

    /**
     * Gets whether commands are allowed.
     * 
     * @return True if commands are allowed, false if not
     */
    boolean areCommandsAllowed();

    /**
     * Gets whether the bonus chest should be generated.
     *
     * <p>This only applies on the initial load of the {@link World}
     * created via the {@link WorldProperties} created from this settings.</p>
     * 
     * @return True if bonus chest is generated, false if not
     */
    boolean doesGenerateBonusChest();

    /**
     * Gets the dimension type.
     * 
     * @return The dimension type
     */
    DimensionType getDimensionType();

    /**
     * Gets the {@link PortalAgentType} for the world.
     *
     * @return The portal agent type
     */
    PortalAgentType getPortalAgentType();

    /**
     * Gets the difficulty.
     *
     * @return The difficulty
     */
    Difficulty getDifficulty();

    /**
     * Gets whether PVP combat is enabled.
     *
     * @return True if PVP combat is enabled, false if not
     */
    boolean isPVPEnabled();

    /**
     * Gets a {@link DataContainer} of any extra settings required by the
     * generator.
     *
     * @return The generator settings
     */
    DataContainer getGeneratorSettings();

    /**
     * Gets the {@link SerializationBehavior} that worlds built from this will use.
     *
     * @return The serialization mode
     */
    SerializationBehavior getSerializationBehavior();

    interface Builder extends ResettableBuilder<WorldArchetype, Builder> {

        /**
         * Sets enabled status. Built worlds who are enabled but unloaded may
         * be loaded automatically if an attempt is made to transfer an entity
         * to the world using {@link Entity#transferToWorld} .
         *
         * @param state Should be enabled
         * @return The builder, for chaining
         */
        Builder enabled(boolean state);

        /**
         * Sets whether to load when the server starts.
         *
         * @param state Should load on startup
         * @return The builder, for chaining
         */
        Builder loadsOnStartup(boolean state);

        /**
         * Sets whether the spawn chunks should remain loaded when
         * no players are present.
         *
         * @param state Should keep spawn loaded
         * @return The builder, for chaining
         */
        Builder keepsSpawnLoaded(boolean state);

        /**
         * Sets whether the spawn chunks generate on load.
         *
         * @param state Should generate spawn chunks on load
         * @return The builder, for chaining
         */
        Builder generateSpawnOnLoad(boolean state);

        /**
         * Sets the seed. See {@link #randomSeed()} if a random seed is desired.
         *
         * @param seed The seed
         * @return The builder, for chaining
         */
        Builder seed(long seed);

        /**
         * Sets the seed to be randomized for each world created.
         * 
         * @return The builder, for chaining
         */
        Builder randomSeed();

        /**
         * Sets the default {@link GameMode}. If not specified this
         * will default to {@link GameModes#SURVIVAL}.
         *
         * @param gameMode The gamemode
         * @return The builder, for chaining
         */
        Builder gameMode(GameMode gameMode);

        /**
         * Sets the generator type. If not specified this will default
         * to {@link GeneratorTypes#DEFAULT}
         *
         * @param type The type
         * @return The builder, for chaining
         */
        Builder generator(GeneratorType type);

        /**
         * Sets the generator modifiers.
         *
         * @param modifier The modifiers
         * @return The builder, for chaining
         * @throws IllegalArgumentException If one of the modifiers is not
         *         registered in {@link GameRegistry}.
         */
        Builder generatorModifiers(WorldGeneratorModifier... modifier);

        /**
         * Sets the dimension type.
         *
         * @param type The type
         * @return The builder, for chaining
         */
        Builder dimension(DimensionType type);

        /**
         * Sets the difficulty.
         *
         * @param difficulty The difficulty
         * @return The builder, for chaining
         */
        Builder difficulty(Difficulty difficulty);

        /**
         * Sets whether this should generate map features such as villages
         * and strongholds. If not specified this will default to true.
         *
         * @param state Are map features enabled
         * @return The builder, for chaining
         */
        Builder usesMapFeatures(boolean state);

        /**
         * Sets whether hardcore mode is enabled. On servers this will cause
         * players to be banned upon death, on clients the world will be
         * deleted! If not specified this will default to false.
         *
         * @param state Is hardcore mode enabled
         * @return The builder, for chaining
         */
        Builder hardcore(boolean state);

        /**
         * Sets any extra settings required by the {@link GeneratorType} or by
         * the {@link WorldGeneratorModifier}s. If not specified these will
         * default to the settings within {@link GeneratorType#getGeneratorSettings()}.
         *
         * @param settings The generator settings
         * @return The builder, for chaining
         */
        Builder generatorSettings(DataContainer settings);

        /**
         * Sets the desired {@link PortalAgentType} for the world.
         *
         * @param type The type
         * @return This builder, for chaining
         */
        Builder portalAgent(PortalAgentType type);

        /**
         * Sets whether PVP combat is enabled in this world.
         *
         * @param state Whether PVP is enabled
         * @return The builder, for chaining
         */
        Builder pvp(boolean state);

        /**
         * Sets whether commands are allowed to be executed.
         *
         * @param state Whether commands are allowed
         * @return The builder, for chaining
         */
        Builder commandsAllowed(boolean state);

        /**
         * Sets whether the bonus chest should be created.
         *
         * @param state Whether bonus chest is enabled
         * @return The builder, for chaining
         */
        Builder generateBonusChest(boolean state);

        /**
         * Sets the serialization behavior that will be used when saving.
         *
         * @param behavior The serialization behavior
         * @return This builder, for chaining
         */
        Builder serializationBehavior(SerializationBehavior behavior);

        /**
         * Fills this {@link Builder} for creating {@link WorldArchetype}s,
         * the builder is then seeded with the values from the given
         * {@link WorldProperties} object.
         *
         * @param properties The seed properties
         * @return A new seeded builder
         */
        Builder from(WorldProperties properties);

        /**
         * Builds the {@link WorldArchetype} which can be used to create
         * a {@link World} in {@link Server#createWorldProperties(String, WorldArchetype)}.
         *
         * <p>This will also register the settings as a new type in the
         * {@link GameRegistry}.</p>
         *
         * @param id The id that this settings will be registered under
         * @param name The human readable name of this settings
         * @return The settings
         */
        WorldArchetype build(String id, String name) throws IllegalArgumentException, CatalogTypeAlreadyRegisteredException;
    }
}
