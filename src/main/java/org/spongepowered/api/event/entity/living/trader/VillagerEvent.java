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
package org.spongepowered.api.event.entity.living.trader;

import org.spongepowered.api.data.type.Profession;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Hostile;
import org.spongepowered.api.entity.living.golem.IronGolem;
import org.spongepowered.api.entity.living.monster.raider.Raider;
import org.spongepowered.api.entity.living.monster.zombie.ZombieEntity;
import org.spongepowered.api.entity.living.trader.Villager;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.raid.Raid;
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;

/**
 * An event which involves a {@link Villager}.
 */
public interface VillagerEvent extends Event {

	/**
	 * Gets the {@link Villager} involved with this event.
	 *
	 * @return The villager.
	 */
	Villager getVillager();

	/**
	 * Fired when a {@link Villager}'s profession changes.
	 *
	 * <p>This can include both gaining or losing a {@link Profession}.</p>
	 */
	@GenerateFactoryMethod
	interface ChangeProfession extends VillagerEvent, Cancellable {

		/**
		 * Gets the villager's original {@link Profession}.
		 *
		 * @return The {@link Profession} the {@link Villager}'s will take.
		 */
		Profession getOriginalProfession();

		/**
		 * Gets the {@link Profession} the villager will change to.
		 *
		 * @return The {@link Villager}'s next {@link Profession}.
		 */
		Profession getProfession();

		/**
		 * Sets the {@link Villager}'s next {@link Profession}.
         *
         * @param profession The desired next profession of the villager
		 */
		void setProfession(Profession profession);
	}

	/**
	 * Fired when a {@link Villager} levels up it's {@link Profession}.
	 */
	@GenerateFactoryMethod
	interface LevelUpProfession extends VillagerEvent, Cancellable {

		/**
		 * Gets the {@link Villager}'s original {@link Profession} level.
		 *
		 * @return The {@link Profession} level.
		 */
		int getOriginalProfessionLevel();

		/**
		 * Gets the {@link Profession} level this {@link Villager}'s will level up to.
		 *
		 * @return The {@link Profession} level.
		 */
		int getProfessionLevel();

		/**
		 * Sets the profession level of this {@link Villager} will reach.
		 *
		 * @param level The level to set the {@link Villager}'s {@link Profession} to.
		 *
		 * <p>Please note that any level above 5 usually does not define TradeOfferGenerators and is therefore ignored.</p>
		 */
		void setProfessionLevel(int level);
	}

	/**
	 * Fired when a {@link Villager} starts panicking.
	 *
	 * <p>This can occur because of a {@link Raid} or a {@link ZombieEntity}/{@link Raider}
	 * or both a {@link Raid} and {@link Entity}.</p>
	 *
	 * <p>The {@link Villager}'s Panic task will always prioritize the last {@link Entity} which attacked before considering any nearby
	 * {@link Hostile} agents.</p>
	 *
	 */
	@GenerateFactoryMethod
	interface Panic extends VillagerEvent, Cancellable {

		/**
		 * Checks if an {@link IronGolem} will be summoned.
		 *
		 * @return True if an {@link IronGolem} will be summoned.
		 */
		boolean willSpawnGolem();

		/**
		 * Sets if the {@link Villager} should summon an {@link IronGolem}.
		 *
		 * @param spawnGolem If the {@link Villager} should summon an {@link IronGolem}.
		 */
		void setShouldSpawnGolem(boolean spawnGolem);
	}
}
