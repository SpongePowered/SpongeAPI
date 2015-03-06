package org.spongepowered.api.world;

import org.spongepowered.api.block.BlockType;

import com.flowpowered.math.vector.Vector3i;

/**
 * 
 * Represents a tile tick. Tile ticks cause a block to update after a certain
 * number of ticks. Tile ticks with higher priorities are processed first.
 *
 */
public interface TileTick {

    /**
     * Gets the block type used to update the block.
     * 
     * @return The block type used to update the block
     */
    BlockType getBlockType();

    /**
     * Gets the amount of ticks until this tile tick should update.
     * 
     * @return The amount of ticks until this tile tick should update
     */
    int getTicks();

    /**
     * Sets the amount of ticks until this tile tick should update.
     * 
     * @param ticks The new amount of ticks until this tile tick should update
     */
    void setTicks(int ticks);

    /**
     * Gets the priority of this tile tick.
     * 
     * @return The priority of this tile tick
     */
    int getPriority();

    /**
     * Sets the priority of this tile tick.
     * 
     * @param priority The new priority of this tile tick
     */
    void setPriority(int priority);

    /**
     * Gets the position of this tile tick.
     * 
     * @return the position of this tile tick
     */
    Vector3i getPosition();

}
