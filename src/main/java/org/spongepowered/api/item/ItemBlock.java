package org.spongepowered.api.item;

import org.spongepowered.api.block.Block;

/**
 * Represents a {@link org.spongepowered.api.block.Block} as an {@link org.spongepowered.api.item.Item}
 */
public interface ItemBlock extends Item {
    /**
     * Gets the {@link org.spongepowered.api.block.Block} this item places on interaction
     * @return The block
     */
    Block getBlock();
}
