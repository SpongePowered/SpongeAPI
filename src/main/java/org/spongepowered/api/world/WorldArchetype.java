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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.dimension.DimensionType;
import org.spongepowered.api.world.dimension.DimensionTypes;
import org.spongepowered.api.world.gen.WorldGenerationSettings;
import org.spongepowered.api.world.server.ServerWorldProperties;
import org.spongepowered.api.world.storage.WorldProperties;

import java.util.function.Supplier;

/**
 * A representation of the settings which define a {@link WorldProperties} for creation.
 */
@CatalogedBy(WorldArchetypes.class)
public interface WorldArchetype {

    /**
     * Gets a new Builder instance for {@link WorldArchetype}.
     * 
     * @return A new builder instance
     */
    static WorldArchetype.Builder builder() {
        return Sponge.getGame().getBuilderProvider().provide(Builder.class);
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
    boolean doesLoadOnStartup();

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
     * Gets the {@link WorldGenerationSettings}.
     *
     @return The world generation settings
     */
    WorldGenerationSettings getWorldGeneratorSettings();

    /**
     * Gets the {@link GameMode}.
     *
     * @return The gamemode
     */
    GameMode getGameMode();

    /**
     * Gets the {@link DimensionType}.
     *
     * @return The dimension type
     */
    DimensionType getDimensionType();

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
    boolean areCommandsEnabled();

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
     * Gets the {@link SerializationBehavior} that worlds built from this will use.
     *
     * @return The serialization mode
     */
    SerializationBehavior getSerializationBehavior();

    /**
     * A builder to create {@link WorldArchetype}s.
     */
    interface Builder extends CopyableBuilder<WorldArchetype, Builder>, org.spongepowered.api.util.Builder<WorldArchetype, Builder> {

        /**
         * Sets enabled status. Built worlds who are enabled but unloaded may
         * be loaded automatically if an attempt is made to transfer an entity
         * to the world using {@link Entity#transferToWorld}.
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
        Builder loadOnStartup(boolean state);

        /**
         * Sets whether the spawn chunks should remain loaded when
         * no players are present.
         *
         * @param state Should keep spawn loaded
         * @return The builder, for chaining
         */
        Builder keepSpawnLoaded(boolean state);

        /**
         * Sets whether the spawn chunks generate on load.
         *
         * @param state Should generate spawn chunks on load
         * @return The builder, for chaining
         */
        Builder generateSpawnOnLoad(boolean state);

        /**
         * Sets the {@link WorldGenerationSettings}.
         *
         * @param worldGenerationSettings The world generation settings
         * @return This builder, for chaining
         */
        Builder worldGenerationSettings(final WorldGenerationSettings worldGenerationSettings);

        /**
         * Sets the default {@link GameMode}. If not specified this
         * will default to {@link GameModes#SURVIVAL}.
         *
         * @param gameMode The gamemode
         * @return The builder, for chaining
         */
        default Builder gameMode(Supplier<? extends GameMode> gameMode) {
            return this.gameMode(gameMode.get());
        }

        /**
         * Sets the default {@link GameMode}. If not specified this
         * will default to {@link GameModes#SURVIVAL}.
         *
         * @param gameMode The gamemode
         * @return The builder, for chaining
         */
        Builder gameMode(GameMode gameMode);

        /**
         * Sets the {@link DimensionType}. If not specified this will default
         * to {@link DimensionTypes#OVERWORLD}
         *
         * @param type The type
         * @return The builder, for chaining
         */
        default Builder dimensionType(Supplier<? extends DimensionType> type) {
            return this.dimensionType(type.get());
        }

        /**
         * Sets the {@link DimensionType}. If not specified this will default
         * to {@link DimensionTypes#OVERWORLD}
         *
         * @param type The type
         * @return The builder, for chaining
         */
        Builder dimensionType(DimensionType type);

        /**
         * Sets the difficulty.
         *
         * @param difficulty The difficulty
         * @return The builder, for chaining
         */
        default Builder difficulty(Supplier<? extends Difficulty> difficulty) {
            return this.difficulty(difficulty.get());
        }

        /**
         * Sets the difficulty.
         *
         * @param difficulty The difficulty
         * @return The builder, for chaining
         */
        Builder difficulty(Difficulty difficulty);

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
         * Sets whether PVP combat is enabled in this world.
         *
         * @param state Whether PVP is enabled
         * @return The builder, for chaining
         */
        Builder pvpEnabled(boolean state);

        /**
         * Sets whether commands are allowed to be executed.
         *
         * @param state Whether commands are allowed
         * @return The builder, for chaining
         */
        Builder commandsEnabled(boolean state);

        /**
         * Sets the {@link SerializationBehavior} that will be used when saving.
         *
         * @param behavior The serialization behavior
         * @return This builder, for chaining
         */
        default Builder serializationBehavior(Supplier<? extends SerializationBehavior> behavior) {
            return this.serializationBehavior(behavior.get());
        }

        /**
         * Sets the {@link SerializationBehavior} that will be used when saving.
         *
         * @param behavior The serialization behavior
         * @return This builder, for chaining
         */
        Builder serializationBehavior(SerializationBehavior behavior);

        /**
         * Fills this {@link Builder} for creating {@link WorldArchetype}s,
         * the builder is then seeded with the values from the given
         * {@link ServerWorldProperties} object.
         *
         * @param properties The seed properties
         * @return This builder, for chaining
         */
        Builder from(ServerWorldProperties properties);

        /**
         * Builds the {@link WorldArchetype archetype}.
         *
         * @return The archetype
         */
        @Override
        WorldArchetype build();
    }
}
