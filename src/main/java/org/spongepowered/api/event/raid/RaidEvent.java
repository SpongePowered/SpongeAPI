package org.spongepowered.api.event.raid;

import org.spongepowered.api.data.type.RaidStatuses;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.raid.Raid;
import org.spongepowered.api.raid.Wave;
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;

/**
 * An event when a raid changes it's current state. Always involves
 * a {@link Raid}.
 */
public interface RaidEvent extends Event {

	/**
	 * Gets the {@link Raid} involved with this event.
	 *
	 * @return The raid.
	 */
	Raid getRaid();

	/**
	 * An event where the {@link Raid} is started.
	 *
	 * <p>This is fired before any {@link Wave}s have started.</p>
	 */
	@GenerateFactoryMethod
	interface Start extends RaidEvent, Cancellable {}

	/**
	 * An event where a {@link Wave} in a {@link Raid} has started.
	 */
	@GenerateFactoryMethod
	interface StartWave extends RaidEvent, Cancellable {

		/**
		 * The {@link Wave} which is starting.
		 *
		 * @return The current wave.
		 */
		default Wave getWave() {
			return this.getRaid().getCurrentWave().get();
		}

	}

	/**
	 * An event for when a {@link Raid} has ended.
	 *
	 * <p>The raid's state could be either a {@link RaidStatuses#VICTORY}
	 * or {@link RaidStatuses#LOSS}</p>
	 */
	@GenerateFactoryMethod
	interface End extends RaidEvent {}
}
