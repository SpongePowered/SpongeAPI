package org.spongepowered.api.potion;

import java.util.List;

public interface PotionType {

	/**
	 * Gets a list of all the {@link PotionEffect}'s the potion type applies.
	 * 
	 * @return List<PotionEffect> The effects.
	 */
	public List<PotionEffect> getEffects();
	
	/**
	 * Gets the unique identifier.
	 * 
	 * @return int The ID.
	 */
	public int getId();
	
	/**
	 * Gets the name of the type.
	 * 
	 * @return String The name.
	 */
	public String getName();
	
}
