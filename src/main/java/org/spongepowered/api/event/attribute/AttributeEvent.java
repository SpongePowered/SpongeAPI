package org.spongepowered.api.event.attribute;

import org.spongepowered.api.attribute.Attribute;
import org.spongepowered.api.attribute.AttributeHolder;
import org.spongepowered.api.util.event.Cancellable;

public interface AttributeEvent extends Cancellable {

    /**
     * Gets the {@link AttributeHolder} who's attributes are being changed.
     * 
     * @return The AttributeHolder who's attributes are being changed
     */
    AttributeHolder getHolder();

    /**
     * Gets the {@link Attribute} that is being changed.
     * 
     * @return The {@link Attribute} that is being changed
     */
    Attribute getAttribute();

}
