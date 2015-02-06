package org.spongepowered.api.service.command.sponge;

import com.google.common.base.Optional;

import java.util.Map;

/**
 * Represents the result of a command in Sponge.
 */
public interface CommandResult {

    /**
     * Gets if the command was processed.
     * 
     * @return If the command was processed
     */
    boolean wasProcessed();

    /**
     * Gets the success count of the command, if one exists.
     * 
     * @return The success count of the command
     */
    Optional<Integer> getSuccessCount();

    /**
     * Gets the number of blocks affected by the command, if such a count
     * exists.
     * 
     * @return The number of blocks affected by the command, if such a count
     *         exists
     */
    Optional<Integer> getAffectedBlocks();

    /**
     * Gets the number of entities affected by the command, if such a count
     * exists.
     * 
     * @return The number of entities affected by the command, if such a count
     *         exists
     */
    Optional<Integer> getAffectedEntities();

    /**
     * Gets the number of items affected by the command, if such a count exists.
     * 
     * @return The number of items affected by the command, if such a count
     *         exists
     */
    Optional<Integer> getAffectedItems();

    /**
     * Gets the query result of the command, if one exists.
     * 
     * @return The query result of the command, if one exists
     */
    Optional<Integer> getQueryResult();

    /**
     * Gets a Map used by the command to store information about what it did.
     * 
     * @return A Map used by the command to store information about what it did.
     */
    Map<String, Object> getResultInfo();

}
