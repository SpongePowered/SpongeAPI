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
package org.spongepowered.api.util.command;

import com.google.common.base.Optional;

import java.util.Collections;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Represents the result of a command in Sponge.
 */
public class CommandResult {

    private final boolean processed;
    private final Optional<Integer> successCount;
    private final Optional<Integer> affectedBlocks;
    private final Optional<Integer> affectedEntities;
    private final Optional<Integer> affectedItems;
    private final Optional<Integer> queryResult;
    private final Map<String, Object> resultInfo;

    /**
     * Constructs a new command result.
     * 
     * @param processed True if the command was processed
     * @param successCount The success count
     * @param affectedBlocks The number of affected blocks
     * @param affectedEntities The number of affected entities
     * @param affectedItems The number of affected items
     * @param queryResult The query result
     * @param resultInfo A map storing additional information
     */
    protected CommandResult(boolean processed, @Nullable Integer successCount, @Nullable Integer affectedBlocks, @Nullable Integer affectedEntities,
            @Nullable Integer affectedItems, @Nullable Integer queryResult, @Nullable Map<String, Object> resultInfo) {
        this.processed = processed;
        this.successCount = Optional.fromNullable(successCount);
        this.affectedBlocks = Optional.fromNullable(affectedBlocks);
        this.affectedEntities = Optional.fromNullable(affectedEntities);
        this.affectedItems = Optional.fromNullable(affectedItems);
        this.queryResult = Optional.fromNullable(queryResult);
        this.resultInfo = resultInfo != null ? Collections.unmodifiableMap(resultInfo) : Collections.<String, Object>emptyMap();
    }

    /**
     * Tests if the command was processed.
     *
     * @return True if the command was processed
     */
    public boolean wasProcessed() {
        return this.processed;
    }

    /**
     * Gets the success count of the command.
     * 
     * @return The success count of the command
     */
    public Optional<Integer> getSuccessCount() {
        return this.successCount;
    }

    /**
     * Gets the number of blocks affected by the command.
     *
     * @return The number of blocks affected by the command, if such a count
     *         exists
     */
    public Optional<Integer> getAffectedBlocks() {
        return this.affectedBlocks;
    }

    /**
     * Gets the number of entities affected by the command.
     *
     * @return The number of entities affected by the command, if such a count
     *         exists
     */
    public Optional<Integer> getAffectedEntities() {
        return this.affectedEntities;
    }

    /**
     * Gets the number of items affected by the command.
     *
     * @return The number of items affected by the command, if such a count
     *         exists
     */
    public Optional<Integer> getAffectedItems() {
        return this.affectedItems;
    }

    /**
     * Gets the query result of the command, e.g. the time of the day,
     * an amount of money or a player's amount of XP.
     *
     * @return The query result of the command, if one exists
     */
    public Optional<Integer> getQueryResult() {
        return this.queryResult;
    }

    /**
     * Gets a Map used by the command to store information about what it did.
     *
     * @return A Map used by the command to store information about what it did.
     */
    public Map<String, Object> getResultInfo() {
        return this.resultInfo;
    }

}
