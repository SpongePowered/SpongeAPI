package org.spongepowered.api.potion;

import org.spongepowered.api.entity.Entity;

public interface Potion {

	/**
	 * Gets the type of potion.
	 * 
	 * @return PotionType The PotionType.
	 */
	public PotionType getType();
	
	/**
	 * Applies the potion effects to the entity.
	 * 
	 * @param entity The entity to apply the effects to.
	 */
	public void apply(Entity entity);
	
	/** 
	 * Gets the amount of time the potion has to affect the entity.
	 * 
	 * @return int The duration.
	 */
	public int getDuration();
	
	/** 
	 * Gets the level the potion is. 
	 *
	 * @return int The level.
	 */
	public int getLevel();
	
}
