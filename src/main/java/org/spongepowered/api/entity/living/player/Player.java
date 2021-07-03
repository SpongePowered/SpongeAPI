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
package org.spongepowered.api.entity.living.player;

import net.kyori.adventure.identity.Identified;
import org.spongepowered.api.block.entity.EnderChest;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.type.HandPreference;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.effect.Viewer;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.item.inventory.Carrier;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.entity.PlayerInventory;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.util.locale.LocaleSource;

/**
 * A Player is the representation of an actual unit playing the game.
 */
public interface Player extends Humanoid, Identified, LocaleSource, Viewer, Carrier {

    /**
     * Gets the associated {@link GameProfile} of this player.
     *
     * @return The user's profile
     */
    GameProfile profile();

    @Override
    default GameProfile identity() {
        return this.profile();
    }

    @Override
    PlayerInventory inventory();

    /**
     * Gets the {@link Inventory} available for this Player's shared {@link EnderChest}
     * contents.
     *
     * @return The ender chest inventory
     */
    Inventory enderChestInventory();

    /**
     * {@link Keys#AFFECTS_SPAWNING}
     *
     * @return Whether the player affects spawning
     */
    default Value.Mutable<Boolean> affectsSpawning() {
        return this.requireValue(Keys.AFFECTS_SPAWNING).asMutable();
    }

    /**
     * {@link Keys#CAN_FLY}
     *
     * @return Whether the player can fly
     */
    default Value.Mutable<Boolean> canFly() {
        return this.requireValue(Keys.CAN_FLY).asMutable();
    }

    /**
     * {@link Keys#DOMINANT_HAND}
     *
     * @return The dominant HandPreference of the player
     */
    default Value.Mutable<HandPreference> dominantHand() {
        return this.requireValue(Keys.DOMINANT_HAND).asMutable();
    }

    /**
     * {@link Keys#EXHAUSTION}
     *
     * @return The player's exhaustion
     */
    default Value.Mutable<Double> exhaustion() {
        return this.requireValue(Keys.EXHAUSTION).asMutable();
    }

    /**
     * {@link Keys#EXPERIENCE}
     *
     * @return The amount of experience the player has
     */
    default Value.Mutable<Integer> experience() {
        return this.requireValue(Keys.EXPERIENCE).asMutable();
    }

    /**
     * {@link Keys#EXPERIENCE_FROM_START_OF_LEVEL}
     *
     * @return The experience requires to advance from the current level to the next one
     */
    default Value<Integer> experienceFromStartToLevel() {
        return this.requireValue(Keys.EXPERIENCE_FROM_START_OF_LEVEL).asMutable();
    }

    /**
     * {@link Keys#EXPERIENCE_LEVEL}
     *
     * @return The current level the player has
     */
    default Value.Mutable<Integer> experienceLevel() {
        return this.requireValue(Keys.EXPERIENCE_LEVEL).asMutable();
    }

    /**
     * {@link Keys#EXPERIENCE_SINCE_LEVEL}
     *
     * @return The amount of experience the player has collected towards the next level
     */
    default Value.Mutable<Integer> experienceSinceLevel() {
        return this.requireValue(Keys.EXPERIENCE_SINCE_LEVEL).asMutable();
    }

    /**
     * {@link Keys#FLYING_SPEED}
     *
     * @return The speed at which the player flies
     */
    default Value.Mutable<Double> flyingSpeed() {
        return this.requireValue(Keys.FLYING_SPEED).asMutable();
    }

    /**
     * {@link Keys#FOOD_LEVEL}
     *
     * @return The player's food level
     */
    default Value.Mutable<Integer> foodLevel() {
        return this.requireValue(Keys.FOOD_LEVEL).asMutable();
    }

    /**
     * {@link Keys#IS_FLYING}
     *
     * @return Whether the entity is flying
     */
    default Value.Mutable<Boolean> flying() {
        return this.requireValue(Keys.IS_FLYING).asMutable();
    }

    /**
     * {@link Keys#IS_SLEEPING}
     *
     * @return Whether the player is sleeping
     */
    default Value<Boolean> sleeping() {
        return this.requireValue(Keys.IS_SLEEPING);
    }

    /**
     * {@link Keys#IS_SLEEPING_IGNORED}
     *
     * @return Whether this player is going to be ignored for sleeping to "reset" the day
     */
    default Value<Boolean> sleepingIgnored() {
        return this.requireValue(Keys.IS_SLEEPING_IGNORED);
    }

    /**
     * {@link Keys#MAX_EXHAUSTION}
     *
     * @return The maximum exhaustion of the player
     */
    default Value<Double> maxExhaustion() {
        return this.requireValue(Keys.MAX_EXHAUSTION);
    }

    /**
     * {@link Keys#MAX_FOOD_LEVEL}
     *
     * @return The maximum food level of the player
     */
    default Value<Integer> maxFoodLevel() {
        return this.requireValue(Keys.MAX_FOOD_LEVEL);
    }

    /**
     * {@link Keys#MAX_SATURATION}
     *
     * @return The maximum saturation of the player
     */
    default Value<Double> maxSaturation() {
        return this.requireValue(Keys.MAX_SATURATION);
    }

    /**
     * {@link Keys#SATURATION}
     *
     * @return The player's saturation
     */
    default Value.Mutable<Double> saturation() {
        return this.requireValue(Keys.SATURATION).asMutable();
    }

    /**
     * {@link Keys#SLEEP_TIMER}
     *
     * @return The sleep timer of the player
     */
    default Value.Mutable<Integer> sleepTimer() {
        return this.requireValue(Keys.SLEEP_TIMER).asMutable();
    }
}
