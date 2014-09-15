package org.spongepowered.api.potion;

public interface Potion {

	public PotionType getType();
	
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
