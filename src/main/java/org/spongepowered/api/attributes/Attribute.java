package org.spongepowered.api.attributes;

interface Attribute {

    /**
     * Gets the ID of this attribute as a string.
     * 
     * @return The ID of this attribute as a string.
     */
    String getStringId();

    /**
     * Gets the minimum value for this attribute.
     * 
     * @return The minimum value for this attribute.
     */
    double getMinimum();

    /**
     * Gets the maximum value for this attribute.
     * 
     * @return The maximum value for this attribute.
     */
    double getMaximum();

    /**
     * Gets the default value for this attribute.
     * 
     * @return The default value for this attribute.
     */
    double getDefaultBase();

    /**
     * Gets the target of this attribute.
     * 
     * @return The target of this attribute.
     */
    AttributeTarget getTarget();

}
