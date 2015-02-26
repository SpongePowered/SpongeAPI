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
     * Gets the hunger value of this human entity.
     * <p>Hunger is a type of exhaustion such that when the exhaustion
     * depletes, saturation may begin to diminish.</p>
     *
     * @return The current hunger
     */
    float getHunger();

    /**
     * Sets the hunger value of this human entity.
     * <p>Hunger is a type of exhaustion such that when the exhaustion
     * depletes, saturation may begin to diminish.</p>
     *
     * @param hunger The hunger level
     */
    void setHunger(float hunger);

    /**
     * Gets the current food saturation of this human entity.
     * <p>Saturation has health effects, depending on game difficulty and
     * hunger levels. If the saturation is high enough, the human entity
     * may heal. If the saturation is at 0, the human entity may starve.</p>
     *
     * @return The current saturation level
     */
    float getSaturation();

    /**
     * Sets the current food saturation of this human entity.
     * <p>Saturation has health effects, depending on game difficulty and
     * hunger levels. If the saturation is high enough, the human entity
     * may heal. If the saturation is at 0, the human entity may starve.</p>
     *
     * @param saturation The saturation level to set
     */
    void setSaturation(float saturation);

    /**
     * Gets the current experience towards the next level.
     *
     * <p>This is not the total experience this human has.</p>
     *
     * @return The current experience towards the next level
     */
    int getExperience();

    /**
     * Sets the experience accumulated towards the next level.
     *
     * @param experience The experience
     */
    void setExperience(int experience);

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
    int getTotalExperinece();

    /**
     * Sets the total accumulated experience starting from zero.
     *
     * @param totalExperience The total experience
     */
    void setTotalExperience(int totalExperience);

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
