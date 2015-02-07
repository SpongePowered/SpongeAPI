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

package org.spongepowered.api.entity.living;

import com.google.common.base.Optional;
import org.spongepowered.api.entity.ArmorEquipable;
import org.spongepowered.api.entity.Tamer;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;
import org.spongepowered.api.item.inventory.Carrier;
import org.spongepowered.api.item.inventory.Inventory;

/**
 * Represents a HumanEntity in game, such as {@link org.spongepowered.api.entity.player.Player}
 */
public interface Human extends Living, ProjectileSource, ArmorEquipable, Tamer, Carrier {

    /**
     * Gets the exhastion value of this human entity.
     * <p>When exhaustion level reaches 0, saturation may begin to diminish.
     * </p>
     *
     * @return The current exhaustion level
     */
    double getExhaustion();

    /**
     * Sets the exhaustion value of this human entity.
     * <p>When exhaustion level reaches 0, saturation may begin to diminish.
     * </p>
     *
     * @param exhaustion The new exhaustion level
     */
    void setExhaustion(float exhaustion);

    /**
     * Gets the current saturation level of this human entity.
     * <p>Saturation acts as a buffer for food level. Food level will not
     * decrease while the saturation level is greater than zero.</p>
     *
     * @return The current saturation level
     */
    double getSaturation();

    /**
     * Sets the saturation level of this human entity.
     * <p>Saturation acts as a buffer for food level. Food level will not
     * decrease while the saturation level is greater than zero.</p>
     *
     * @param saturation The new saturation level
     */
    void setSaturation(double saturation);

    /**
     * Gets the current food saturation of this human entity.
     * <p>Food level has health effects, depending on game difficulty and
     * hunger levels. If the food level is high enough, the human entity
     * may heal. If the food level is at 0, the human entity may starve.</p>
     *
     * @return The current food level
     */
    float getFoodLevel();

    /**
     * Sets the current food saturation of this human entity.
     *
     * <p>Food level has health effects, depending on game difficulty and
     * hunger levels. If the food level is high enough, the human entity
     * may heal. If the food level is at 0, the human entity may starve.</p>
     *
     * @param foodLevel The new food level
     */
    void setFoodLevel(float foodLevel);

    /**
     * Gets the current experience towards the next level.
     *
     * <p>This value ranges from 0 to 1, with the experience bar
     * being empty at 0, and the player leveling up at 1.</p>
     *
     * <p>This is not the total experience this human has.</p>
     *
     * @return The current experience towards the next level
     */
    double getExpereienceToLevel();

    /**
     * Sets the experience accumulated towards the next level.
     *
     * <p>This value ranges from 0 to 1, with the experience bar
     * being empty at 0, and the player leveling up at 1.</p>
     *
     * <p>This is not the total experience this human has.</p>
     *
     * @param experience The experience towards the next level
     */
    void setExpereienceToLevel(double experience);

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
     * Gets the total accumulated experience this human has, including
     * the experience to achieve the current experience level and the
     * experienced gained towards the next level.
     *
     * @return The current total accumulated experience
     */
    int getTotalExperience();

    /**
     * Sets the total accumulated experience starting from zero.
     *
     * @param totalExperience The total experience
     */
    void setTotalExperience(int totalExperience);

    /**
     * Returns whether this human entity is sneaking.
     *
     * @return Whether this human entity is sneaking
     */
    boolean isSneaking();

    /**
     * Sets whether this human entity is sneaking.
     *
     * @param sneaking Whether this human entity should be sneaking.
     */
    void setSneaking(boolean sneaking);

    /**
     * Gets whether this human entity is currently flying.
     *
     * @return Whether this human entity is currently flying
     */
    boolean isFlying();

    /**
     * Sets whether this human entity is currently flying.
     *
     * <p>Note: this will have no effect if {@link Human#isFlightAllowed()}
     * returns <code>false</code>.</p>
     *
     * @param flying Whether this human entity should be flying
     */
    void setFlying(boolean flying);

    /**
     * Returns whether this human entity is allowed to fly.
     *
     * @return Whether this human entity is allowed to fly
     */
    boolean isFlightAllowed();

    /**
     * Sets if this human entity is allowed to fly.
     *
     * @param allowFlight Whether this human entity is allowed to fly.
     */
    void setFlightAllowed(boolean allowFlight);

    /**
     * Gets the speed this human entity may fly at.
     *
     * @return the speed this human entity may fly at
     */
    double getFlySpeed();

    /**
     * Sets the speed this human entity may fly at.
     *
     * @param speed the speed this human entity may fly at
     */
    void setFlySpeed(double speed);

    /**
     * Gets the speed this human entity may walk at.
     *
     * @return the speed this human entity may walk at
     */
    double getWalkSpeed();

    /**
     * Sets the speed this human entity may walk at.
     *
     * @param speed the speed this human entity may walk at
     */
    void setWalkSpeed(double speed);

    /**
     * Returns whether this human entity has an open inventory at the moment
     * or not.
     *
     * @return Whether this human is viewing an inventory or not
     */
    boolean isViewingInventory();

    /**
     * Gets the currently viewed inventory of this human entity, if it is
     * currently viewing one.
     *
     * @return An inventory if this human entity is viewing one, otherwise
     * {@link Optional#absent()}
     */
    Optional<Inventory> getOpenInventory();

    /**
     * Opens the given Inventory for the player to view.
     *
     * @param inventory The inventory to view
     */
    void openInventory(Inventory inventory);

    /**
     * Closes the currently viewed entity of this human entity, if it is
     * currently viewing one.
     */
    void closeInventory();

}
