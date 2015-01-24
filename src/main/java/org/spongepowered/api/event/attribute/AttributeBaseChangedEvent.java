package org.spongepowered.api.event.attribute;

public interface AttributeBaseChangedEvent extends AttributeEvent {

    /**
     * Gets the old value of the changed {@link Attribute}.
     * 
     * @return The old value of the changed Attribute
     */
    double getOldValue();

    /**
     * Gets the new value of the changed {@link Attribute}.
     * 
     * @return The new value of the changed @link Attribute
     */
    double getNewValue();

}
