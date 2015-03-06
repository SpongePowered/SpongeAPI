package org.spongepowered.api.block;

import com.flowpowered.math.vector.Vector3i;

/**
 * 
 * Represents a scheduled block update. SBUs with higher priorities are
 * processed first.
 *
 */
public interface ScheduledBlockUpdate {

    /**
     * Gets the block type used to update the block.
     * 
     * @return The block type used to update the block
     */
    BlockType getBlockType();

    /**
     * Gets the amount of ticks until this SBU should cause the block to update.
     * 
     * @return The amount of ticks until this SBU should cause the block to
     *         update.
     */
    int getTicks();

    /**
     * Sets the amount of ticks until this SBU should cause the block to update.
     * 
     * @param ticks The new amount of ticks until this SBU should cause the
     *        block to update.
     */
    void setTicks(int ticks);

    /**
     * Gets the priority of this scheduled block update.
     * 
     * @return The priority of this scheduled block update
     */
    int getPriority();

    /**
     * Sets the priority of this scheduled block update.
     * 
     * @param priority The new priority of this scheduled block update
     */
    void setPriority(int priority);

    /**
     * Gets the position of this scheduled block update.
     * 
     * @return the position of this scheduled block update
     */
    Vector3i getPosition();

}