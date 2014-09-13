package org.spongepowered.api.event.block;

import org.spongepowered.api.block.Block;
import org.spongepowered.api.entity.Player;
import org.spongepowered.api.event.Event;

/**
 * Describes events which contain a {@link org.spongepowered.api.block.Block}
 */
public interface BlockEvent extends Event {

    /**
     * Gets the {@link org.spongepowered.api.block.Block} involved
     *
     * @return {@link org.spongepowered.api.block.Block} involved
     */
    Block getBlock();
}
