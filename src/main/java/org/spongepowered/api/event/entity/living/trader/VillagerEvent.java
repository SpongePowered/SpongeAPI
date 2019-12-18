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
	 * Gets the {@link Villager} involved with this event.\
	 *
	 * @return The villager.
	 */
	Villager getVillager();

	/**
	 * Fired when a {@link Villager}'s profession changes.
	 *
	 * <p>This can include both gaining an losing a {@link Profession}.</p>
	 */
	@GenerateFactoryMethod
	interface ProfessionChange extends VillagerEvent, Cancellable {

		/**
		 * Gets the {@link Profession} the villager will change to.
		 *
		 * @return The {@link Villager}'s next {@link Profession}.
		 */
		Profession getNextProfession();

		/**
		 * Sets the {@link Villager}'s next {@link Profession}.
		 */
		void setNextProfession(Profession profession);
	}

	/**
	 * Fired when a {@link Villager} levels up it's {@link Profession}.
	 */
	@GenerateFactoryMethod
	interface ProfessionLevelUp extends VillagerEvent, Cancellable {

		/**
		 * Gets the {@link Villager}'s current {@link Profession} level.
		 *
		 * @return The {@link Profession} level.
		 */
		int getCurrentProfessionLevel();

		/**
		 * Gets the {@link Villager}'s next {@link Profession} level.
		 *
		 * @return The {@link Profession} level.
		 */
		int getNextProfessionLevel();

		/**
		 * Sets the profession level of this {@link Villager}.
		 *
		 * @param level The level to set the {@link Villager}'s {@link Profession} to.
		 *
		 * <p>Note that any level above 5 will usually be ignored.</p>
		 */
		void setProfessionLevel(int level);
	}

	/**
	 * Fired when a {@link Villager} starts panicking.
	 *
	 * <p>This can occur because of a {@link Raid} or a {@link ZombieEntity}/{@link Raider}
	 * or both a {@link Raid} and {@link Entity}.</p>
	 *
	 * <p>The {@link Villager}'s Panic task will always prioritize the last {@link Entity} which attacked before considering any nearby {@link Hostile} agents.</>
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
