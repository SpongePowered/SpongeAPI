package org.spongepowered.api.potion;

public interface PotionEffect {

	/**
	 * Gets the unique identifier of the effect.
	 * 
	 * @return int The ID.
	 */
	public int getId();
	
	/** 
	 * Gets the level representing how often the effect takes place.
	 * 
	 * @return int The amplifier amount.
	 */
	public int getAmplifier();
	
	/**
	 * Gets the name of the effect.
	 * 
	 * @return String The name.
	 */
	public String getName();
	
}
