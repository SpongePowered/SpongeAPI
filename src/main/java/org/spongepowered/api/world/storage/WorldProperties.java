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

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.world.DimensionType;
import org.spongepowered.api.world.GeneratorType;
import org.spongepowered.api.world.PortalAgentType;
import org.spongepowered.api.world.SerializationBehavior;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.gen.WorldGeneratorModifier;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * Represents the properties of a {@link World} which are persisted across runtime instances.
 */
public interface WorldProperties extends DataSerializable {

    /**
     * Gets whether this world has been initialized.
     *
     * @return Is initialized
     */
    boolean isInitialized();

    /**
     * Gets the name of this world.
     *
     * @return The name
     */
    String getWorldName();

    /**
     * Gets the {@link UUID} of the world.
     *
     * @return The unique Id
     */
    UUID getUniqueId();

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
    boolean loadOnStartup();

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
     * Gets the number of ticks which have occurred since the world was created.
     *
     * @return The total time in ticks
     */
    long getTotalTime();

    /**
     * Gets the time of day, in ticks. The total number of ticks in a day is
     * 24000, however this value does not reset to zero at the start of each day
     * but rather keeps counting passed 24000.
     *
     * @return The time of day
     */
    long getWorldTime();

    /**
     * Sets the time of day, in ticks. The total number of ticks in a day is
     * 24000, however this value does not reset to zero at the start of each day
     * but rather keeps counting passed 24000.
     *
     * @param time The time of day
     */
    void setWorldTime(long time);

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
     * Gets whether this world is currently experiencing rain/snow/cloud-cover
     * (depending on the biome of a specific location).
     *
     * @return Is raining
     */
    boolean isRaining();

    /**
     * Sets whether this world is currently experiencing rain/snow/cloud-cover
     * (depending on the biome of a specific location).
     *
     * @param state Is raining
     */
    void setRaining(boolean state);

    /**
     * Gets the number of ticks until the weather is next toggled to a new
     * random value.
     *
     * @return The time until the weather changes
     */
    int getRainTime();

    /**
     * Sets the number of ticks until the weather is next toggled to a new
     * random value.
     *
     * @param time The time until the weather changes
     */
    void setRainTime(int time);

    /**
     * Gets whether this world is currently experiencing a lightning storm.
     *
     * @return Is thundering
     */
    boolean isThundering();

    /**
     * Sets whether this world is currently experiencing a lightning storm.
     *
     * @param state Is thundering
     */
    void setThundering(boolean state);

    /**
     * Gets the number of ticks until the {@link #isThundering()} state is
     * toggled to a new random value.
     *
     * @return The time until the thundering state changes
     */
    int getThunderTime();

    /**
     * Sets the number of ticks until the {@link #isThundering()} state is
     * toggled to a new random value.
     *
     * @param time The time until the thundering state changes
     */
    void setThunderTime(int time);

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
     * Gets whether this world will generate map features such as villages and
     * strongholds.
     *
     * @return Whether map features enabled
     */
    boolean usesMapFeatures();

    /**
     * Sets whether this world will generate map features such as villages and
     * strongholds.
     *
     * @param state Whether map features enabled
     */
    void setMapFeaturesEnabled(boolean state);

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
     * Gets whether the bonus chest should be generated.
     *
     * <p>This only applies on the initial load of the {@link World}
     * created via this properties.</p>
     *
     * @return True if bonus chest is generated, false if not
     */
    boolean doesGenerateBonusChest();

    /**
     * Gets the center of the world border.
     *
     * <p>The returned position is three-dimensional. As the world border
     * extends over the entire y-axis, the returned position will always have a
     * {@code y} set to 0.</p>
     *
     * @return The center
     */
    Vector3d getWorldBorderCenter();

    /**
     * Sets the center of the world border.
     *
     * @param x The x-axis center of the world border
     * @param z The z-axis center of the world border
     */
    void setWorldBorderCenter(double x, double z);

    /**
     * Gets the diameter of the world border.
     *
     * <p>The returned diameter applies to the x and z axis. The world border
     * extends over the entire y-axis.</p>
     *
     * @return The diameter
     */
    double getWorldBorderDiameter();

    /**
     * Sets the diameter of the world border.
     *
     * <p>The specified diameter applies to the x and z axis. The world border
     * extends over the entire y-axis.</p>
     *
     * @param diameter The diameter
     */
    void setWorldBorderDiameter(double diameter);

    /**
     * Gets the time remaining until the world border stops expanding or
     * contracting.
     *
     * @return The time remaining, in milliseconds
     */
    long getWorldBorderTimeRemaining();

    /**
     * Sets the time remaining until the world border stops expanding or
     * contracting.
     *
     * @param time The new remaining time
     */
    void setWorldBorderTimeRemaining(long time);

    /**
     * Gets the diameter the world border is expanding or contracting to.
     *
     * <p>This will return the same value as {@link #getWorldBorderDiameter}
     * unless {@link #getWorldBorderTimeRemaining} is greater than 0.</p>
     *
     * @return The diameter being changed to
     */
    double getWorldBorderTargetDiameter();

    /**
     * Sets the target diameter of the world border.
     *
     * <p>The world border diameter increases/decrease linearly over time
     * specified in {@link #getWorldBorderTimeRemaining()}. The specified
     * diameter applies to the x and z axis. The world border extends over the
     * entire y-axis.</p>
     *
     * @param diameter The diameter where the border will expand/contract to
     */
    void setWorldBorderTargetDiameter(double diameter);

    /**
     * Gets the distance a player may be outside the world border before taking
     * damage.
     *
     * @return The distance
     */
    double getWorldBorderDamageThreshold();

    /**
     * Sets the distance a player may be be outside the world border before
     * taking damage.
     *
     * @param distance The distance
     */
    void setWorldBorderDamageThreshold(double distance);

    /**
     * Gets the damage done to a player per block per tick when outside the
     * buffer.
     *
     * @return The damage amount
     */
    double getWorldBorderDamageAmount();

    /**
     * Sets the damage done to a player per block per tick when outside the
     * buffer.
     *
     * @param damage The damage amount
     */
    void setWorldBorderDamageAmount(double damage);

    /**
     * Gets the time when a contracting world border will warn a player for whom
     * the world border will reach in {@code time} seconds.
     *
     * <p>In Minecraft, the warning is displayed in the form of a reddish
     * tint.</p>
     *
     * @return The time, in seconds
     */
    int getWorldBorderWarningTime();

    /**
     * Sets the time when a contracting world border will warn a player for whom
     * the world border will reach in {@code time} seconds.
     *
     * <p>In Minecraft, the warning is displayed in the form of a reddish
     * tint.</p>
     *
     * @param time The time, in seconds
     */
    void setWorldBorderWarningTime(int time);

    /**
     * Gets the distance when a contracting world border will warn a player for
     * whom the world border is {@code distance} blocks away.
     *
     * <p>In Minecraft, the warning is displayed in the form of a reddish
     * tint.</p>
     *
     * @return The distance, in blocks
     */
    int getWorldBorderWarningDistance();

    /**
     * Sets the distance when a contracting world border will warn a player for
     * whom the world border is {@code distance} blocks away.
     *
     * <p>In Minecraft, the warning is displayed in the form of a reddish
     * tint.</p>
     *
     * @param distance The distance, in blocks
     */
    void setWorldBorderWarningDistance(int distance);

    /**
     * Gets the specified GameRule value.
     **
     * @param gameRule The name of the GameRule.
     * @return The GameRule value, if it exists.
     */
    Optional<String> getGameRule(String gameRule);

    /**
     * Gets a map of the currently set game rules and their values.
     *
     * @return An immutable map of the game rules
     */
    Map<String, String> getGameRules();

    /**
     * Sets the specified GameRule value. If one with this name does not exist,
     * it will be created.
     *
     * @param gameRule The name of the GameRule.
     * @param value The value to set the GameRule to.
     */
    void setGameRule(String gameRule, String value);

    /**
     * Removes custom GameRule.
     *
     * @param gameRule The name of the GameRule.
     * @return True if GameRule was deleted, false if not
     */
    boolean removeGameRule(String gameRule);

    /**
     * Gets a {@link DataContainer} containing any additional properties for
     * this world. The returned data is a snapshot of the data and is not live.
     *
     * @return Any additional properties
     */
    DataContainer getAdditionalProperties();

    /**
     * Gets a section of the additional properties returned by
     * {@link #getAdditionalProperties()}. The returned data is a snapshot of
     * the data and is not live.
     *
     * @param path The path for the section.
     * @return The data view representing the requested section
     */
    Optional<DataView> getPropertySection(DataQuery path);

    /**
     * Sets a path within the additional data to the given {@link DataView}. If
     * you are using this to store data related to your mod/plugin is is HIGHLY
     * recommended that the identifier you pass in be your mod/plugin id.
     *
     * @param path The path for the section
     * @param data The new data
     */
    void setPropertySection(DataQuery path, DataView data);

    /**
     * Gets an immutable collection of the world generator modifiers currently
     * in use.
     * 
     * @return The world generator modifiers in use.
     */
    Collection<WorldGeneratorModifier> getGeneratorModifiers();

    /**
     * Sets the given world generator modifiers to be used.
     *
     * @param modifiers The modifiers to set.
     * @throws IllegalArgumentException If any of the modifiers has not been
     *         registered in the {@link GameRegistry}.
     */
    void setGeneratorModifiers(Collection<WorldGeneratorModifier> modifiers);

    /**
     * Gets the generator settings. These can be used by the generator type
     * and/or by the generator modifiers.
     *
     * @return The generator settings.
     */
    DataContainer getGeneratorSettings();

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
}
