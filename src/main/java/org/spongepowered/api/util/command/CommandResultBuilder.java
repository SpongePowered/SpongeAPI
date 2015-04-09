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

import com.google.common.collect.Maps;

import java.util.Map;

import javax.annotation.Nullable;

/**
 * A builder for {@link CommandResult}s.
 */
public class CommandResultBuilder {

    private boolean processed;
    private Integer successCount;
    private Integer affectedBlocks;
    private Integer affectedEntities;
    private Integer affectedItems;
    private Integer queryResult;
    private Map<String, Object> resultInfo;

    /**
     * Sets if the command has been processed.
     *
     * @param processed If the command has been processed
     * @return This builder, for chaining
     */
    public CommandResultBuilder processed(boolean processed) {
        this.processed = processed;
        return this;
    }

    /**
     * Sets if the command has been processed.
     *
     * @param successCount If the command has been processed
     * @return This builder, for chaining
     */
    public CommandResultBuilder successCount(@Nullable Integer successCount) {
        this.successCount = successCount;
        return this;
    }

    /**
     * Sets the amount of blocks affected by the command.
     *
     * @param affectedBlocks The amount of blocks affected by the command
     * @return This builder, for chaining
     */
    public CommandResultBuilder affectedBlocks(@Nullable Integer affectedBlocks) {
        this.affectedBlocks = affectedBlocks;
        return this;
    }

    /**
     * Sets the amount of entities affected by the command.
     *
     * @param affectedEntities The amount of entities affected by the command
     * @return This builder, for chaining
     */
    public CommandResultBuilder affectedEntities(@Nullable Integer affectedEntities) {
        this.affectedEntities = affectedEntities;
        return this;
    }

    /**
     * Sets the amount of items affected by the command.
     *
     * @param affectedItems The amount of items affected by the command
     * @return This builder, for chaining
     */
    public CommandResultBuilder affectedItems(@Nullable Integer affectedItems) {
        this.affectedItems = affectedItems;
        return this;
    }

    /**
     * Sets the query result of the command, e.g. the time of the day,
     * an amount of money or a player's amount of XP.
     *
     * @param queryResult The query result of the command
     * @return This builder, for chaining
     */
    public  CommandResultBuilder queryResult(@Nullable Integer queryResult) {
        this.queryResult = queryResult;
        return this;
    }

    /**
     * Adds a key-value pair to the result info map.
     *
     * @param key The key.
     * @param value The value.
     * @return This builder, for chaining
     */
    public CommandResultBuilder resultInfo(String key, Object value) {
        if (this.resultInfo == null) {
            this.resultInfo = Maps.<String, Object>newHashMap();
        }
        this.resultInfo.put(key, value);
        return this;
    }

    /**
     * Adds a set of key-value pairs result info map.
     *
     * @param resultInfo A map of several key-value pairs
     * @return This builder, for chaining
     */
    public CommandResultBuilder resultInfo(@Nullable Map<String, Object> resultInfo) {
        this.resultInfo = resultInfo;
        return this;
    }

    /**
     * Builds the {@link CommandResult}.
     *
     * @return A CommandResult with the specified settings
     */
    public CommandResult build() {
        return new CommandResult(this.processed, this.successCount, this.affectedBlocks, this.affectedEntities, this.affectedItems, this.queryResult,
                this.resultInfo);
    }
}
