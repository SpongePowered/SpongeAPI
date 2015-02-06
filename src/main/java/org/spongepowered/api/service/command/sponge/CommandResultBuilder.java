package org.spongepowered.api.service.command.sponge;

import java.util.Map;

import javax.annotation.Nullable;

/**
 * A builder for {@link CommandResult}s.
 */
public interface CommandResultBuilder {
    
    /**
     * Sets if the command has been processed.
     * 
     * @param processed If the command has been processed.
     * @return This builder, for chaining.
     */
    CommandResultBuilder processed(boolean processed);
    
    /**
     * Sets if the command has been processed.
     * 
     * @param successCount If the command has been processed.
     * @return This builder, for chaining.
     */
    CommandResultBuilder successCount(@Nullable Integer successCount);
    
    /**
     * Sets the amount of blocks affected by the command.
     * 
     * @param affectedBlocks The amount of blocks affected by the command.
     * @return This builder, for chaining.
     */
    CommandResultBuilder affectedBlocks(@Nullable Integer affectedBlocks);

    /**
     * Sets the amount of entities affected by the command.
     * 
     * @param affectedEntities The amount of entities affected by the command.
     * @return This builder, for chaining.
     */
    CommandResultBuilder affectedEntities(@Nullable Integer affectedEntities);

    /**
     * Sets the amount of items affected by the command.
     * 
     * @param affectedItems The amount of items affected by the command.
     * @return This builder, for chaining.
     */
    CommandResultBuilder affectedItems(@Nullable Integer affectedItems);

    /**
     * Sets the query result of the command.
     * 
     * @param queryResult The query result of the command.
     * @return This builder, for chaining.
     */
    CommandResultBuilder queryResult(@Nullable Integer queryResult);

    /**
     * Adds a key-value pair to the success info map.
     * 
     * @param key The key.
     * @param value The value.
     * @return This builder, for chaining.
     */
    CommandResultBuilder successInfo(String key, Object value);

    /**
     * Adds a set of key-value pairs success info map.
     * 
     * @param successInfo A map of several key-value pairs.
     * @return This builder, for chaining.
     */
    CommandResultBuilder successInfo(Map<String, Object> successInfo);

    /**
     * Builds the {@link CommandResult}.
     * 
     * @return A CommandResult with the specified settings.
     */
    CommandResult build();
    
}
