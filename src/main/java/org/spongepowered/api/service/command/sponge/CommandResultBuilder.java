/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
