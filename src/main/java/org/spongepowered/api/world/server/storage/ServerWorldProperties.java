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
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.trader.WanderingTrader;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.util.MinecraftDayTime;
import org.spongepowered.api.world.SerializationBehavior;
import org.spongepowered.api.world.WorldBorder;
import org.spongepowered.api.world.WorldType;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.generation.config.WorldGenerationConfig;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.api.world.weather.WeatherUniverse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServerWorldProperties extends WorldProperties, Identifiable, ResourceKeyed, WeatherUniverse.Mutable {

    /**
     * Gets the {@link ServerWorld} that correlates to this properties, if available.
     *
     * <p>The rules are that the world must be loaded and it's {@link ServerWorld#getKey()} matches
     * this properties' {@link #getKey()}. Lastly, the properties of that world and this properties
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
    Optional<Component> displayName();

    /**
     * Sets the {@link Component name}.
     *
     * @param name The name
     */
    void setDisplayName(@Nullable Component name);

    /**
     * Gets if this has been initialized.
     *
     * @return Is initialized
     */
    boolean initialized();

    /**
     * Gets whether this world will load when the server starts up.
     *
     * @return Load on startup
     */
    boolean loadOnStartup();

    /**
     * Sets whether this should load when the server starts up.
     *
     * @param loadOnStartup Load on startup
     */
    void setLoadOnStartup(boolean loadOnStartup);

    /**
     * Gets whether logic surrounding a {@link org.spongepowered.math.vector.Vector3i spawn position} is performed.
     *
     * <p>It is up to the implementation on how this setting is handled. For Vanilla Minecraft, the following occurs:
     *     <u1>
     *         <li>If the world is new, a spawn point is calculated</li>
     *         <li>The chunks around the spawn point within a radius are kept loaded in memory</li>
     *     </u1>
     * </p>
     *
     * @return performs spawn logic
     */
    boolean performsSpawnLogic();

    /**
     * Sets whether logic surrounding a {@link org.spongepowered.math.vector.Vector3i spawn position} is performed.
     *
     * <p>It is up to the implementation on how this setting is handled. For Vanilla Minecraft, the following occurs:
     *     <u1>
     *         <li>If the world is new, a spawn point is calculated</li>
     *         <li>The chunks around the spawn point within a radius are kept loaded in memory</li>
     *     </u1>
     * </p>
     *
     * @param performsSpawnLogic Performs spawn logic
     */
    void setPerformsSpawnLogic(boolean performsSpawnLogic);

    /**
     * Gets the {@link WorldGenerationConfig}
     * @return The world generation settings
     */
    WorldGenerationConfig.Mutable worldGenerationConfig();

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
    WorldType worldType();

    /**
     * Sets the {@link WorldType}.
     *
     * @param worldType the type
     */
    void setWorldType(WorldType worldType);

    /**
     * Gets whether PVP combat is enabled.
     *
     * @return pvp
     */
    boolean pvp();

    /**
     * Sets whether PVP combat is enabled.
     *
     * @param pvp pvp
     */
    void setPvp(boolean pvp);

    /**
     * Gets the default {@link GameMode}.
     *
     * @return The game mode
     */
    GameMode gameMode();

    /**
     * Sets the {@link GameMode}.
     *
     * @param gameMode game mode
     */
    void setGameMode(GameMode gameMode);

    /**
     * Sets if this is in hardcore mode.
     *
     * @param hardcore hardcore
     */
    void setHardcore(boolean hardcore);

    /**
     * Gets whether commands are enabled.
     *
     * <p>It is up to the implementation to determine how this is respected.</p>
     *
     * @return Commands
     */
    boolean commands();

    /**
     * Sets whether commands are enabled.
     *
     * <p>It is up to the implementation to determine how this is respected.</p>
     *
     * @param commands commands
     */
    void setCommands(boolean commands);

    /**
     * Sets the {@link Difficulty}.
     *
     * @param difficulty The difficulty
     */
    void setDifficulty(Difficulty difficulty);

    /**
     * Gets the {@link SerializationBehavior}.
     *
     * @return Serialization behavior
     */
    SerializationBehavior serializationBehavior();

    /**
     * Sets the {@link SerializationBehavior}.
     *
     * @param behavior serialization behavior
     */
    void setSerializationBehavior(SerializationBehavior behavior);

    /**
     * Gets the delay before a {@link WanderingTrader} will be spawned, in ticks.
     *
     * <p>
     *     In vanilla minecraft, 24,000 ticks is the default delay.
     * </p>
     *
     * @return The delay, in ticks
     */
    int wanderingTraderSpawnDelay();

    /**
     * Sets the delay before a {@link WanderingTrader} will be spawned.
     *
     * @param delay The delay, in ticks
     */
    void setWanderingTraderSpawnDelay(int delay);

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
    int viewDistance();

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
    void setViewDistance(@Nullable Integer viewDistance);

    /**
     * Gets the {@link WorldBorder}.
     *
     * @return The world border
     */
    WorldBorder worldBorder();
}
