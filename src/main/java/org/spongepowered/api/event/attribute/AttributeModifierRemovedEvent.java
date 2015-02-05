package org.spongepowered.api.event.attribute;

import org.spongepowered.api.attribute.AttributeModifier;


public interface AttributeModifierRemovedEvent extends AttributeEvent {

    /**
     * Gets the {@link AttributeModifier} that was removed in this event.
     * 
     * @return The AttributeModifier that was removed in this event
     */
    AttributeModifier getModifier();
}
