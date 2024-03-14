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
package org.spongepowered.api.world.server.storage;

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.key.KeyedValue;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.ResourceKeyed;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.trader.WanderingTrader;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.util.MinecraftDayTime;
import org.spongepowered.api.util.Nameable;
import org.spongepowered.api.util.Ticks;
import org.spongepowered.api.world.SerializationBehavior;
import org.spongepowered.api.world.WorldType;
import org.spongepowered.api.world.border.WorldBorder;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.generation.config.WorldGenerationConfig;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.api.world.weather.Weather;
import org.spongepowered.api.world.weather.WeatherUniverse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServerWorldProperties extends WorldProperties, Nameable, Identifiable, ResourceKeyed, WeatherUniverse.Mutable {

    /**
     * Gets the {@link ServerWorld} that correlates to this properties, if available.
     *
     * <p>The rules are that the world must be loaded and it's {@link ServerWorld#key()} matches
     * this properties' {@link #key()}. Lastly, the properties of that world and this properties
     * must be reference equal.</p>
     *
     * @return The world or {@link Optional#empty()} otherwise
     */
    Optional<ServerWorld> world();

    /**
     * Gets the {@link Component name}.
     *
     * @return The name
     */
    default Optional<Component> displayName() {
        return this.get(Keys.DISPLAY_NAME);
    }

    /**
     * Sets the {@link Component name}.
     *
     * @param name The name
     */
    default void setDisplayName(@Nullable Component name) {
        this.offer(Keys.DISPLAY_NAME, name);
    }

    /**
     * Gets if this has been initialized.
     *
     * @return Is initialized
     */
    default boolean initialized() {
        return this.require(Keys.INITIALIZED);
    }

    /**
     * Gets whether this world will load when the server starts up.
     *
     * @return Load on startup
     */
    default boolean loadOnStartup() {
        return this.require(Keys.IS_LOAD_ON_STARTUP);
    }

    /**
     * Sets whether this should load when the server starts up.
     *
     * @param loadOnStartup Load on startup
     */
    default void setLoadOnStartup(boolean loadOnStartup) {
        this.offer(Keys.IS_LOAD_ON_STARTUP, loadOnStartup);
    }

    /**
     * Gets whether logic surrounding a {@link org.spongepowered.math.vector.Vector3i spawn position} is performed.
     *
     * <p>It is up to the implementation on how this setting is handled. For Vanilla Minecraft, the following occurs:</p>
     *     <ul>
     *         <li>If the world is new, a spawn point is calculated</li>
     *         <li>The chunks around the spawn point within a radius are kept loaded in memory</li>
     *     </ul>
     *
     * @return performs spawn logic
     */
    default boolean performsSpawnLogic() {
        return this.require(Keys.PERFORM_SPAWN_LOGIC);
    }

    /**
     * Sets whether logic surrounding a {@link org.spongepowered.math.vector.Vector3i spawn position} is performed.
     *
     * <p>It is up to the implementation on how this setting is handled. For Vanilla Minecraft, the following occurs:</p>
     *     <ul>
     *         <li>If the world is new, a spawn point is calculated</li>
     *         <li>The chunks around the spawn point within a radius are kept loaded in memory</li>
     *     </ul>
     *
     * @param performsSpawnLogic Performs spawn logic
     */
    default void setPerformsSpawnLogic(boolean performsSpawnLogic) {
        this.offer(Keys.PERFORM_SPAWN_LOGIC, performsSpawnLogic);
    }

    /**
     * Gets the {@link WorldGenerationConfig}
     * @return The world generation settings
     */
    default WorldGenerationConfig worldGenerationConfig() {
        return this.require(Keys.WORLD_GEN_CONFIG);
    }

    /**
     * Sets the in-game time of day.
     *
     * @param time The time of day
     */
    void setDayTime(MinecraftDayTime time);

    /**
     * Gets the {@link WorldType}.
     *
     * @return The world type
     */
    default WorldType worldType() {
        return this.require(Keys.WORLD_TYPE);
    }

    /**
     * Sets the {@link WorldType}.
     *
     * @param worldType the type
     */
    default void setWorldType(WorldType worldType) {
        this.offer(Keys.WORLD_TYPE, worldType);
    }

    /**
     * Gets whether PVP combat is enabled.
     *
     * @return pvp
     */
    default boolean pvp() {
        return this.require(Keys.PVP);
    }

    /**
     * Sets whether PVP combat is enabled.
     *
     * @param pvp pvp
     */
    default void setPvp(boolean pvp) {
        this.offer(Keys.PVP, pvp);
    }

    /**
     * Gets the default {@link GameMode}.
     *
     * @return The game mode
     */
    default GameMode gameMode() {
        return this.require(Keys.GAME_MODE);
    }

    /**
     * Sets the {@link GameMode}.
     *
     * @param gameMode game mode
     */
    default void setGameMode(GameMode gameMode) {
        this.offer(Keys.GAME_MODE, gameMode);
    }

    /**
     * Sets if this is in hardcore mode.
     *
     * @param hardcore hardcore
     */
    default void setHardcore(boolean hardcore) {
        this.offer(Keys.HARDCORE, hardcore);
    }

    /**
     * Gets whether commands are enabled.
     *
     * <p>It is up to the implementation to determine how this is respected.</p>
     *
     * @return Commands
     */
    default boolean commands() {
        return this.require(Keys.COMMANDS);
    }

    /**
     * Sets whether commands are enabled.
     *
     * <p>It is up to the implementation to determine how this is respected.</p>
     *
     * @param commands commands
     */
    default void setCommands(boolean commands) {
        this.offer(Keys.COMMANDS, commands);
    }

    /**
     * Sets the {@link Difficulty}.
     *
     * @param difficulty The difficulty
     */
    default void setDifficulty(Difficulty difficulty) {
        this.offer(Keys.WORLD_DIFFICULTY, difficulty);
    }

    /**
     * Gets the {@link SerializationBehavior}.
     *
     * @return Serialization behavior
     */
    default SerializationBehavior serializationBehavior() {
        return this.require(Keys.SERIALIZATION_BEHAVIOR);
    }

    /**
     * Sets the {@link SerializationBehavior}.
     *
     * @param behavior serialization behavior
     */
    default void setSerializationBehavior(SerializationBehavior behavior) {
        this.offer(Keys.SERIALIZATION_BEHAVIOR, behavior);
    }

    /**
     * Gets the delay before a {@link WanderingTrader} will be spawned, in ticks.
     *
     * <p>
     *     In vanilla minecraft, 24,000 ticks is the default delay.
     * </p>
     *
     * @return The delay, in ticks
     */
    Ticks wanderingTraderSpawnDelay();

    /**
     * Sets the delay before a {@link WanderingTrader} will be spawned.
     *
     * @param delay The delay, in ticks
     * @throws IllegalArgumentException if the delay is infinite
     */
    void setWanderingTraderSpawnDelay(Ticks delay);

    /**
     * Gets the chance that a {@link WanderingTrader} will be spawned, as a percentage
     *
     * <p>
     *     In vanilla Minecraft, 25% is the default chance
     * </p>
     *
     * @return The delay, as a percentage
     */
    int wanderingTraderSpawnChance();

    /**
     * Sets the chance that a {@link WanderingTrader} will be spawned.
     *
     * @param chance The chance, as a percentage
     */
    void setWanderingTraderSpawnChance(int chance);

    /**
     * Gets the {@link UUID unique id} of the {@link WanderingTrader} that has been spawned.
     *
     * @return The unique id or {@link Optional#empty()} if one has not been spawned
     */
    Optional<UUID> wanderTraderUniqueId();

    /**
     * Sets the {@link WanderingTrader}.
     *
     * <p>
     *     In vanilla Minecraft, this will become the spawned trader.
     * </p>
     *
     * @param trader The trader
     */
    void setWanderingTrader(@Nullable WanderingTrader trader);

    /**
     * Gets the custom {@link BossBar bars}.
     *
     * @return The boss bars
     */
    List<KeyedValue<BossBar>> customBossBars();

    /**
     * Sets the custom {@link BossBar bars}.
     *
     * @param bars The boss bars
     */
    void setCustomBossBars(@Nullable List<KeyedValue<BossBar>> bars);

    /**
     * Gets the view distance.
     *
     * <p>In Vanilla Minecraft, this is in units of chunks and is considered the radius. Consult your specific
     * implementation vendor for further details.</p>
     *
     * @return View distance
     */
    default int viewDistance() {
        return this.require(Keys.VIEW_DISTANCE);
    }

    /**
     * Sets the view distance (in chunks).
     *
     * <p>In Vanilla Minecraft, this is in units of chunks and is considered the radius. Additionally it must be greater
     * than 3 and less than or equal to 32.</p>
     *
     * <p>Consult your specific implementation vendor for further details.</p>
     *
     * @param viewDistance The view distance
     */
    default void setViewDistance(@Nullable Integer viewDistance) {
        this.offer(Keys.VIEW_DISTANCE, viewDistance);
    }

    /**
     * Gets the saved {@link WorldBorder} for this world.
     *
     * @return The world border
     */
    default WorldBorder worldBorder() {
        return this.require(Keys.WORLD_BORDER);
    }

    @Override
    default Weather weather() {
        return this.require(Keys.WEATHER);
    }
}
