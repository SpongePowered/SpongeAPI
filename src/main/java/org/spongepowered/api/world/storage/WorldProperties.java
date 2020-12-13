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

import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.key.KeyedValue;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.entity.living.trader.WanderingTrader;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.util.MinecraftDayTime;
import org.spongepowered.api.world.SerializationBehavior;
import org.spongepowered.api.world.World;
import org.spongepowered.api.world.WorldBorder;
import org.spongepowered.api.world.difficulty.Difficulty;
import org.spongepowered.api.world.dimension.DimensionType;
import org.spongepowered.api.world.gamerule.GameRuleHolder;
import org.spongepowered.api.world.gen.GeneratorModifierType;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.api.world.weather.WeatherUniverse;
import org.spongepowered.math.vector.Vector3i;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * Represents the properties of a {@link World} which are persisted across runtime instances.
 */
public interface WorldProperties extends WeatherUniverse, Identifiable, GameRuleHolder {

    /**
     * Gets the {@link ServerWorld} that correlates to this properties, if available.
     *
     * <p>The rules are that the world must be loaded and it's {@link ServerWorld#getKey()} matches
     * this properties' {@link #getKey()}. Lastly, the properties of that world and this properties
     * must be reference equal.</p>
     * 
     * @return The world or {@link Optional#empty()} otherwise
     */
    Optional<ServerWorld> getWorld();

    /**
     * Gets the {@link ResourceKey key}.
     * @return The key
     */
    ResourceKey getKey();

    /**
     * Gets if this has been initialized.
     *
     * @return Is initialized
     */
    boolean isInitialized();

    /**
     * Gets whether this is enabled.
     *
     * @return Is enabled
     */
    boolean isEnabled();

    /**
     * Sets whether this is enabled.
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
     * Sets whether this should load when the server starts up.
     *
     * @param state Should load on startup
     */
    void setLoadOnStartup(boolean state);

    /**
     * Gets whether spawn chunks remain loaded when no players are
     * present.
     *
     * @return True if spawn chunks remain loaded without players,
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
     * Gets the default spawn position.
     *
     * @return The spawn position
     */
    Vector3i getSpawnPosition();

    /**
     * Sets the default spawn position.
     *
     * @param position The spawn position
     */
    void setSpawnPosition(Vector3i position);

    /**
     * Gets the {@link GeneratorModifierType}.
     *
     * @return The modifier
     */
    GeneratorModifierType getGeneratorModifierType();

    /**
     * Sets the {@link GeneratorModifierType}.
     *
     * @param modifier The generator modifier
     */
    default void setGeneratorModifierType(Supplier<? extends GeneratorModifierType> modifier) {
        this.setGeneratorModifierType(modifier.get());
    }

    /**
     * Sets the {@link GeneratorModifierType}.
     *
     * @param modifier The generator modifier
     */
    void setGeneratorModifierType(GeneratorModifierType modifier);

    /**
     * Gets the seed.
     *
     * @return The seed
     */
    long getSeed();

    /**
     * Sets the seed.
     * 
     * <p>Warning: this may cause the edge of currently generated chunks to no
     * longer align with newly generated chunks.</p>
     * 
     * @param seed The new seed
     */
    void setSeed(long seed);

    /**
     * Gets the {@link MinecraftDayTime} since the world was created.
     *
     * @return The total time
     */
    MinecraftDayTime getGameTime();

    /**
     * Gets the time of day.
     *
     * @return The time of day
     */
    MinecraftDayTime getDayTime();

    /**
     * Sets the in-game time of day.
     *
     * @param time The time of day
     */
    void setDayTime(MinecraftDayTime time);

    /**
     * Gets the {@link DimensionType}.
     *
     *
     * @return The dimension type
     */
    DimensionType getDimensionType();

    /**
     * Sets the {@link DimensionType}.
     *
     * @param dimensionType The dimension type
     */
    void setDimensionType(DimensionType dimensionType);

    /**
     * Gets whether PVP combat is enabled.
     *
     * @return Whether PVP is enabled
     */
    boolean isPVPEnabled();

    /**
     * Sets whether PVP combat is enabled.
     *
     * @param enabled Whether PVP is enabled
     */
    void setPVPEnabled(boolean enabled);

    /**
     * Gets the default {@link GameMode}.
     *
     * @return The game mode
     */
    GameMode getGameMode();

    /**
     * Sets the default {@link GameMode}.
     *
     * @param gameMode The game mode
     */
    default void setGameMode(Supplier<? extends GameMode> gameMode) {
        this.setGameMode(gameMode.get());
    }

    /**
     * Sets the default {@link GameMode}.
     *
     * @param gameMode The game mode
     */
    void setGameMode(GameMode gameMode);

    /**
     * Gets whether this will generate structures such as villages and
     * strongholds.
     *
     * @return Whether structure features enabled
     */
    boolean areStructuresEnabled();

    /**
     * Sets whether this will generate structures such as villages and
     * strongholds.
     *
     * @param state Whether structure features enabled
     */
    void setStructuresEnabled(boolean state);

    /**
     * Gets if this is in hardcore mode.
     *
     * @return Is hardcore
     */
    boolean isHardcore();

    /**
     * Sets if this is in hardcore mode.
     *
     * @param state Is hardcore
     */
    void setHardcore(boolean state);

    /**
     * Gets whether commands are enabled. May not be respected
     * when not in single player.
     *
     * @return Whether commands are allowed
     */
    boolean areCommandsEnabled();

    /**
     * Sets whether commands are enabled. May not be respected
     * when not in single player.
     *
     * @param state Whether commands are allowed
     */
    void setCommandsEnabled(boolean state);

    /**
     * Gets whether the bonus chest will generate.
     *
     * <p>
     *     Only will generate at spawn and never afterwards.
     * </p>
     *
     * @see <a href="https://minecraft.gamepedia.com/Chest#Bonus_chest">https://minecraft.gamepedia.com/Chest#Bonus_chest</a>
     * @return Whether the bonus chest will generate
     */
    boolean doesGenerateBonusChest();

    /**
     * Sets whether the bonus chest will generate.
     *
     * <p>
     *     Only will generate at spawn and never afterwards.
     * </p>
     *
     * @see <a href="https://minecraft.gamepedia.com/Chest#Bonus_chest">https://minecraft.gamepedia.com/Chest#Bonus_chest</a>
     * @param state Whether the bonus chest will generate
     */
    void setGenerateBonusChest(boolean state);

    /**
     * Gets the {@link Difficulty}.
     *
     * @return The difficulty
     */
    Difficulty getDifficulty();

    /**
     * Sets the {@link Difficulty}.
     *
     * @param difficulty The difficulty
     */
    default void setDifficulty(Supplier<? extends Difficulty> difficulty) {
        this.setDifficulty(difficulty.get());
    }

    /**
     * Sets the {@link Difficulty}.
     *
     * @param difficulty The difficulty
     */
    void setDifficulty(Difficulty difficulty);

    /**
     * Gets the {@link SerializationBehavior}.
     *
     * @return The serialization behavior
     */
    SerializationBehavior getSerializationBehavior();

    /**
     * Sets the {@link SerializationBehavior}.
     *
     * @param behavior The serialization behavior
     */
    default void setSerializationBehavior(Supplier<? extends SerializationBehavior> behavior) {
        this.setSerializationBehavior(behavior.get());
    }

    /**
     * Sets the {@link SerializationBehavior}.
     *
     * @param behavior The serialization behavior
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
    int getWanderingTraderSpawnDelay();

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
    int getWanderingTraderSpawnChance();

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
    Optional<UUID> getWanderTraderUniqueId();

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
    List<KeyedValue<BossBar>> getCustomBossBars();

    /**
     * Sets the custom {@link BossBar bars}.
     *
     * @param bars The boss bars
     */
    void setCustomBossBars(@Nullable List<KeyedValue<BossBar>> bars);

    /**
     * Gets the view distance (in chunks).
     *
     * @return The view distance
     */
    int getViewDistance();

    /**
     * Sets the view distance (in chunks).
     *
     * <p>The view distance must be greater than or equal to 3,
     * and less than or equal to 32.</p>
     *
     * @param viewDistance The view distance
     */
    void setViewDistance(int viewDistance);

    /**
     * Gets the {@link DataContainer} that represents the settings used by the generator.
     *
     * @return The data
     */
    DataContainer getGeneratorSettings();

    /**
     * Sets the {@link DataContainer} that represents the settings to be used by the generator.
     *
     * @param generatorSettings The data
     */
    void setGeneratorSettings(DataContainer generatorSettings);

    /**
     * Gets the {@link WorldBorder}.
     *
     * @return The world border
     */
    WorldBorder getWorldBorder();
}
