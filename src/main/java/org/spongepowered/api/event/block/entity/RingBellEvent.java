package org.spongepowered.api.event.block.entity;

import org.spongepowered.api.block.entity.Bell;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;

import java.util.List;

/**
 * An event when a {@link Bell} is rung.
 */
public interface RingBellEvent extends Event, Cancellable {

	/**
	 * The {@link Bell} which was rung.
	 *
	 * @return The bell which was rung.
	 */
	Bell getBell();

	/**
	 * The {@link Entity}s which will get a {@link PotionEffectTypes#GLOWING} effect because the {@link Bell} was rung.
	 *
	 * @return A list of Entities that will get the glowing effect.
	 */
	List<Entity> entitiesToGlow();

}
