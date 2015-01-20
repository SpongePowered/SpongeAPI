package org.spongepowered.api.attributes;

public interface Attribute {
	
	/**
	 * Gets the ID of this attribute as a string.
	 * @return The ID of this attribute as a string.
	 */
	public String getStringId();
	
	/**
	 * Gets the minimum value for this attribute.
	 * @return The minimum value for this attribute.
	 */
	public double getMinimum();
	
	/**
	 * Gets the maximum value for this attribute.
	 * @return The maximum value for this attribute.
	 */
	public double getMaximum();
	
	/**
	 * Gets the default value for this attribute.
	 * @return The default value for this attribute.
	 */
	public double getDefaultBase();
	
	/**
	 * Gets the target of this attribute.
	 * @return The target of this attribute.
	 */
	public AttributeTarget getTarget();
	
	
}
