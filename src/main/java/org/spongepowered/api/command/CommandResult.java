/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
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
package org.spongepowered.api.command;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents the result of a command in Sponge.
 */
public class CommandResult {
    private static final CommandResult EMPTY = builder().build();
    private static final CommandResult SUCCESS = builder().successCount(1).build();
    private final Optional<Integer> successCount;
    private final Optional<Integer> affectedBlocks;
    private final Optional<Integer> affectedEntities;
    private final Optional<Integer> affectedItems;
    private final Optional<Integer> queryResult;
    private final Optional<Throwable> throwable;

    /**
     * Returns a {@link Builder}.
     *
     * @return A new command result builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Returns a new {@link CommandResult} indicating that a command was
     * processed.
     *
     * @return The command result
     */
    public static CommandResult empty() {
        return EMPTY;
    }

    /**
     * Returns a result indicating the command was processed with a single success.
     *
     * @return The result
     */
    public static CommandResult success() {
        return SUCCESS;
    }

    /**
     * Constructs a new command result.
     * @param successCount The success count
     * @param affectedBlocks The number of affected blocks
     * @param affectedEntities The number of affected entities
     * @param affectedItems The number of affected items
     * @param queryResult The query result
     * @param throwable The exception thrown
     */
    CommandResult(@Nullable Integer successCount, @Nullable Integer affectedBlocks, @Nullable Integer affectedEntities,
                  @Nullable Integer affectedItems, @Nullable Integer queryResult, @Nullable Throwable throwable) {
        this.successCount = Optional.ofNullable(successCount);
        this.affectedBlocks = Optional.ofNullable(affectedBlocks);
        this.affectedEntities = Optional.ofNullable(affectedEntities);
        this.affectedItems = Optional.ofNullable(affectedItems);
        this.queryResult = Optional.ofNullable(queryResult);
        this.throwable = Optional.ofNullable(throwable);
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
     * Gets the exception thrown from this command.
     *
     * @return The exception thrown from this command
     */
    public Optional<Throwable> getThrowable() {
        return throwable;
    }

    /**
     * A builder for {@link CommandResult}s.
     */
    public static class Builder {
        @Nullable
        private Integer successCount;
        @Nullable
        private Integer affectedBlocks;
        @Nullable
        private Integer affectedEntities;
        @Nullable
        private Integer affectedItems;
        @Nullable
        private Integer queryResult;
        @Nullable
        private Throwable throwable;

        private Builder() {}

        /**
         * Sets if the command has been processed.
         *
         * @param successCount If the command has been processed
         * @return This builder, for chaining
         */
        public Builder successCount(@Nullable Integer successCount) {
            this.successCount = successCount;
            return this;
        }

        /**
         * Sets the amount of blocks affected by the command.
         *
         * @param affectedBlocks The amount of blocks affected by the command
         * @return This builder, for chaining
         */
        public Builder affectedBlocks(@Nullable Integer affectedBlocks) {
            this.affectedBlocks = affectedBlocks;
            return this;
        }

        /**
         * Sets the amount of entities affected by the command.
         *
         * @param affectedEntities The amount of entities affected by the command
         * @return This builder, for chaining
         */
        public Builder affectedEntities(@Nullable Integer affectedEntities) {
            this.affectedEntities = affectedEntities;
            return this;
        }

        /**
         * Sets the amount of items affected by the command.
         *
         * @param affectedItems The amount of items affected by the command
         * @return This builder, for chaining
         */
        public Builder affectedItems(@Nullable Integer affectedItems) {
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
        public Builder queryResult(@Nullable Integer queryResult) {
            this.queryResult = queryResult;
            return this;
        }

        /**
         * Sets the exception thrown from this command.
         *
         * @param throwable the exception thrown from this command
         * @return This builder, for chaining
         */
        public Builder throwable(@Nullable Throwable throwable) {
            this.throwable = throwable;
            return this;
        }

        /**
         * Builds the {@link CommandResult}.
         *
         * @return A CommandResult with the specified settings
         */
        public CommandResult build() {
            return new CommandResult(this.successCount, this.affectedBlocks, this.affectedEntities, this.affectedItems, this.queryResult, this.throwable);
        }
    }
}
