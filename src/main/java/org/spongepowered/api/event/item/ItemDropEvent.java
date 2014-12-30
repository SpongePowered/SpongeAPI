package org.spongepowered.api.event.item;

import org.spongepowered.api.entity.Item;
import org.spongepowered.api.event.GameEvent;

import java.util.Collection;

/**
 * Handles when any item or items are dropped on the ground.
 */
public interface ItemDropEvent extends GameEvent {
    /**
     * Gets the items that are being dropped.
     *
     * @return The dropped item entities
     */
    Collection<Item> getDroppedItems();
}
