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
package org.spongepowered.api.world.storage;

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.util.TemporalUnits;
import org.spongepowered.api.world.DimensionType;
import org.spongepowered.api.world.SerializationBehavior;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldBorder;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.gamerule.GameRuleHolder;
import org.spongepowered.api.world.gen.GeneratorType;
import org.spongepowered.api.world.teleport.PortalAgentType;
import org.spongepowered.api.world.weather.WeatherUniverse;

import java.time.Duration;

/**
 * Represents the properties of a {@link World} which are persisted across runtime instances.
 */
public interface WorldProperties extends WeatherUniverse, DataSerializable, Identifiable, GameRuleHolder {

    /**
     * Gets whether this world has been initialized.
     *
     * @return Is initialized
     */
    boolean isInitialized();

    /**
     * Gets the name of the directory that this data exists in.
     *
     * @return The directory name
     */
    String getDirectoryName();

    /**
     * Gets the name of this world.
     *
     * @return The world name
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
     * Sets this world as enabled. A world which is enabled but unloaded may be
     * loaded automatically if an attempt is made to transfer an entity to the
     * world using {@link Entity#transferToWorld} .
     *
     * @param state The new state
     */
    void setEnabled(boolean state);

    /**
     * Gets whether this world will load when the server starts up.
     *
     * @return Loads on startup
     */
    boolean doesLoadOnStartup();

    /**
     * Sets whether this world should load when the server starts up.
     *
     * @param state Should load on startup
     */
    void setLoadOnStartup(boolean state);

    /**
     * Gets whether spawn chunks of this world remain loaded when no players are
     * present.
     *
     * @return True if spawn chunks of this world remain loaded without players,
     *         false if not
     */
    boolean doesKeepSpawnLoaded();

    /**
     * Sets whether the spawn chunks of the world should remain loaded when no
     * players are present.
     *
     * @param state Should keep spawn loaded
     */
    void setKeepSpawnLoaded(boolean state);

    /**
     * Gets whether spawn chunks of this world will generate on load.
     *
     * @return True if spawn chunks of this world generate on load.
     */
    boolean doesGenerateSpawnOnLoad();

    /**
     * Sets whether the spawn chunks of the world will generate on load.
     *
     * @param state Should generate spawn chunks on load.
     */
    void setGenerateSpawnOnLoad(boolean state);

    /**
     * Gets the default spawn position of this world.
     *
     * @return The spawn position
     */
    Vector3i getSpawnPosition();

    /**
     * Sets the default spawn position of this world.
     *
     * @param position The spawn position
     */
    void setSpawnPosition(Vector3i position);

    /**
     * Gets the {@link GeneratorType} of this world.
     *
     * @return The type
     */
    GeneratorType getGeneratorType();

    /**
     * Sets the {@link GeneratorType} of this world.
     *
     * @param type The generator type
     */
    void setGeneratorType(GeneratorType type);

    /**
     * Gets the seed of this world.
     *
     * @return The seed
     */
    long getSeed();

    /**
     * Sets the seed of this world.
     *
     * <p>Warning: this may cause the edge of currently generated chunks to no
     * longer align with newly generated chunks.</p>
     *
     * @param seed The new world seed
     */
    void setSeed(long seed);

    /**
     * Gets the time since the world was created.
     *
     * @return The total time
     */
    Duration getTotalTime();

    /**
     * Gets the time of day, in ticks. The amount of time that a minecraft day
     * takes can be determined with the unit {@link TemporalUnits#MINECRAFT_DAYS}.
     *
     * @return The time of day
     */
    Duration getWorldTime();

    /**
     * Sets the time of day. The amount of time that a minecraft day
     * takes can be determined with the unit {@link TemporalUnits#MINECRAFT_DAYS}.
     *
     * @param time The time of day
     */
    void setWorldTime(Duration time);

    /**
     * Gets the {@link DimensionType} of this world.
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
     * Gets whether PVP combat is enabled in this world.
     *
     * @return Whether PVP is enabled
     */
    boolean isPVPEnabled();

    /**
     * Sets whether PVP combat is enabled in this world.
     *
     * @param enabled Whether PVP is enabled
     */
    void setPVPEnabled(boolean enabled);

    /**
     * Gets the default {@link GameMode} of this world.
     *
     * @return The game mode
     */
    GameMode getGameMode();

    /**
     * Sets the default {@link GameMode} of this world.
     *
     * @param gamemode The game mode
     */
    void setGameMode(GameMode gamemode);

    /**
     * Gets whether this world will generate structures such as villages and
     * strongholds.
     *
     * @return Whether map features enabled
     */
    boolean areStructuresEnabled();

    /**
     * Sets whether this world will generate structures such as villages and
     * strongholds.
     *
     * @param state Whether map features enabled
     */
    void setStructuresEnabled(boolean state);

    /**
     * Gets whether this world is set to hardcore mode.
     *
     * @return Is hardcore
     */
    boolean isHardcore();

    /**
     * Sets whether this world is set to hardcore mode.
     *
     * @param state Is hardcore
     */
    void setHardcore(boolean state);

    /**
     * Gets whether commands are allowed within this world. May not be respected
     * when not in single player.
     *
     * @return Whether commands are allowed
     */
    boolean areCommandsAllowed();

    /**
     * Sets whether commands are allowed within this world. May not be respected
     * when not in single player.
     *
     * @param state Whether commands are allowed
     */
    void setCommandsAllowed(boolean state);

    /**
     * Gets the difficulty of this world.
     *
     * @return The difficulty
     */
    Difficulty getDifficulty();

    /**
     * Sets the difficulty of this world.
     *
     * @param difficulty The difficulty
     */
    void setDifficulty(Difficulty difficulty);

    /**
     * Gets the {@link SerializationBehavior} in use.
     *
     * @return The serialization behavior
     */
    SerializationBehavior getSerializationBehavior();

    /**
     * Sets the {@link SerializationBehavior} for use.
     *
     * @param behavior The serialization behavior
     */
    void setSerializationBehavior(SerializationBehavior behavior);

    /**
     * Gets the {@link WorldBorder}.
     *
     * @return The world border
     */
    WorldBorder getWorldBorder();

    /**
     * Gets the generator settings. These can be used by the generator type.
     *
     * @return The generator settings.
     */
    DataContainer getGeneratorSettings();
}
