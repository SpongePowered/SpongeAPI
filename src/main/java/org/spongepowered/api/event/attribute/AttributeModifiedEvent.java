package org.spongepowered.api.event.attribute;

import org.spongepowered.api.attribute.AttributeModifier;

public interface AttributeModifiedEvent extends AttributeEvent {

    /**
     * Gets the {@link AttributeModifer} that was added or removed in this event.
     * 
     * @return The AttributeModifer that was added or removed in this event
     */
    AttributeModifier getModifier();

    /**
     * Gets if this event represent the removal of the specified modifier.
     * 
     * @return If this event represent the removal of the specified modifier
     */
    boolean isRemoval();
}
