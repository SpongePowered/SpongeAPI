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
package org.spongepowered.api.entity.player;

import org.spongepowered.api.block.BlockLoc;
import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.player.gamemode.GameMode;
import org.spongepowered.api.entity.player.gamemode.GameModes;

import com.google.common.base.Optional;

import javax.annotation.Nullable;

/**
 * Represents the persistent data associated with an {@link Human}.
 */
public interface HumanInfo {

    /**
     * Gets this human's score, as shown to them on death.
     * 
     * @return This human's score.
     */
    int getScore();

    /**
     * Sets this human's score, as shown to them on death.
     * 
     * @param score This human's new score.
     */
    void setScore(int score);

    /**
     * Gets the player's game mode.
     *
     * @return The player's game mode
     * @see GameModes
     */
    GameMode getGameMode();

    /**
     * Sets the players's game mode.
     *
     * @param gameMode The game mode to set
     * @see GameModes
     */
    void setGameMode(GameMode gameMode);

    /**
     * Gets the hunger value of this human entity. <p>Hunger is a type of
     * exhaustion such that when the exhaustion depletes, saturation may begin
     * to diminish.</p>
     *
     * @return The current hunger
     */
    float getHunger();

    /**
     * Sets the hunger value of this human entity. <p>Hunger is a type of
     * exhaustion such that when the exhaustion depletes, saturation may begin
     * to diminish.</p>
     *
     * @param hunger The hunger level
     */
    void setHunger(float hunger);

    /**
     * Gets the current food saturation of this human entity. <p>Saturation has
     * health effects, depending on game difficulty and hunger levels. If the
     * saturation is high enough, the human entity may heal. If the saturation
     * is at 0, the human entity may starve.</p>
     *
     * @return The current saturation level
     */
    float getSaturation();

    /**
     * Sets the current food saturation of this human entity. <p>Saturation has
     * health effects, depending on game difficulty and hunger levels. If the
     * saturation is high enough, the human entity may heal. If the saturation
     * is at 0, the human entity may starve.</p>
     *
     * @param saturation The saturation level to set
     */
    void setSaturation(float saturation);

    /**
     * Gets the exhaustion of this human.
     * 
     * @return The exhaustion of this human
     */
    float getExhaustion();

    /**
     * Sets the exhaustion of this human.
     * 
     * @param exhaustion The new exhaustion of this human
     */
    void setExhaustion(float exhaustion);

    /**
     * Gets the time until this player will take starving damage, or be healed
     * by their hunger, if either are applicable.
     * 
     * @return the time until this player will take starving damage, or be
     *         healed by their hunger, if either are applicable
     */
    int getTimeToFoodUpdate();

    /**
     * Gets the current experience towards the next level.
     *
     * <p>This is not the total experience this human has.</p>
     *
     * @return The current experience towards the next level
     */
    double getExperience();

    /**
     * Sets the experience accumulated towards the next level.
     *
     * @param experience The experience
     */
    void setExperience(double experience);

    /**
     * Gets the current experience level of this human.
     *
     * @return The current level
     */
    int getLevel();

    /**
     * Sets the level of experience.
     *
     * @param level The level of experience
     */
    void setLevel(int level);

    /**
     * Gets the total accumulated experience this human has, including the
     * experience to achieve the current experience level and the experience
     * gained towards the next level.
     *
     * @return The current total accumulated experience
     */
    double getTotalExperience();

    /**
     * Sets the total accumulated experience starting from zero.
     *
     * @param totalExperience The total experience
     */
    void setTotalExperience(double totalExperience);

    /**
     * Gets the seed used to generate enchantments for this player.
     * 
     * @return The seed used to generate enchantments for this player
     */
    int getEnchantmentSeed();

    /**
     * Sets the seed used to generate enchantments for this player.
     * 
     * @param seed The new enchantment seed for this player
     */
    void setEnchantmentSeed(int seed);

    /**
     * Sets this player's enchantment seed to a new, random value.
     * 
     * @see HumanInfo#setEnchantmentSeed(int)
     */
    void regenerateEnchantmentSeed();

    /**
     * Gets the spawn location of this human, if one is set.
     * 
     * @return The spawn location of this human, if one is set
     */
    Optional<BlockLoc> getSpawn();

    /**
     * Sets (or unsets) the spawn location of this human.
     * 
     * @param spawn The new spawn location of this human
     */
    void setSpawn(@Nullable BlockLoc spawn);

    /**
     * Gets if this human should always spawn at it's spawn coordinates, even
     * when a bed is not present at them.
     * 
     * @return If this human should always spawn at it's spawn coordinates, even
     *         when a bed is not present at them
     */
    boolean forceSpawn();

    /**
     * Sets if this human should always spawn at it's spawn coordinates, even
     * when a bed is not present at them.
     * 
     * @param force If this human should now always spawn at it's spawn
     *        coordinates, even when a bed is not present at them
     */
    void setForceSpawn(boolean force);

    /**
     * Returns whether the {@link Player} can fly via the fly key.
     *
     * @return {@code True} if the {@link Player} is allowed to fly
     */
    boolean getAllowFlight();

    /**
     * Sets if the {@link Player} can fly via the fly key.
     *
     * @param allowFlight {@code True} if the player is allowed to fly
     */
    void setAllowFlight(boolean allowFlight);

    /**
     * Gets the speed at which this human walks.
     * 
     * @return The speed at which this human walks
     */
    float getWalkSpeed();

    /**
     * Sets the speed at which this human walks.
     * 
     * @param speed The new speed at which this human walks
     */
    void setWalkSpeed(float speed);

    /**
     * Gets the speed at which this human flies.
     * 
     * @return The speed at which this human flies
     */
    float getFlySpeed();

    /**
     * Sets the speed at which this human flies.
     * 
     * @param speed The new speed at which this human flies
     */
    void setFlySpeed(float speed);

    /**
     * Gets if this human is invulnerable to non-void damage.
     * 
     * @return If this human is invulnerable to non-void damage
     */
    boolean isInvulnerable();

    /**
     * Gets if this human can build.
     * 
     * @return If this human can build.
     */
    boolean canBuild();

    /**
     * Sets if this human can build.
     * 
     * @param canBuild If this human can now build.
     */
    void setCanBuild(boolean canBuild);

    /**
     * Gets if this human can instantly destroy blocks.
     * 
     * @return If this human can instantly destroy blocks
     */
    boolean canInstantlyDestroy();

    /**
     * Sets if this human can instantly destroy blocks.
     * 
     * @param canBuild If this human can now instantly destroy blocks.
     */
    void setCanInstantlyDestroy(boolean canBuild);

}
