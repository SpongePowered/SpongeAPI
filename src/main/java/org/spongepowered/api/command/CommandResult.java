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

import org.spongepowered.api.text.Text;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents the result of a command in Sponge.
 */
public class CommandResult {
    // results: success, fail, fail with tabcompletions
    // well, any result will provide a function to return tabcompletions. How to introspect resutlts though?
    // so commands return results?? then these results build a parse tree?

    /**
     * Returns a result indicating the command was processed with a single success.
     *
     * @return The result
     */
    public static <T> CommandResult.Success<T> success(T value) {
        return Success.builder(value).successCount(1).build();
    }

    public static CommandResult error(Text message) {
        return new Error(message, null);
    }

    public static class Error extends CommandResult {
        private final Text errorMessage;
        @Nullable
        private Throwable wrappedException;

        Error(Text errorMessage, @Nullable Throwable wrappedException) {
            this.errorMessage = errorMessage;
            this.wrappedException = wrappedException;
        }

        public Text getErrorMessage() {
            return errorMessage;
        }

        public Optional<Throwable> getWrappedException() {
            return Optional.ofNullable(wrappedException);
        }
    }

    public static class Success<T> extends CommandResult {
        private final T value;
        private final Optional<Integer> successCount;
        private final Optional<Integer> affectedBlocks;
        private final Optional<Integer> affectedEntities;
        private final Optional<Integer> affectedItems;
        private final Optional<Integer> queryResult;

        /**
         * Returns a {@link Builder}.
         *
         * @return A new command result builder
         */
        public static <T> Builder<T> builder(T value) {
            return new Builder<>(value);
        }

        /**
         * Returns a result indicating the command was processed with a single success.
         *
         * @param count The success count
         * @return The result
         */
        public static <T> CommandResult.Success<T> successCount(T value, int count) {
            return builder(value).successCount(count).build();
        }

        /**
         * Returns a result indicating the command was processed with an
         * amount of affected blocks.
         *
         * @param count The amount of blocks affected
         * @return The result
         */
        public static <T> CommandResult.Success<T> affectedBlocks(T value, int count) {
            return builder(value).affectedBlocks(count).build();
        }

        /**
         * Returns a result indicating the command was processed with an
         * amount of affected entities.
         *
         * @param count The amount of entities affected
         * @return The result
         */
        public static <T> CommandResult.Success<T> affectedEntities(T value, int count) {
            return builder(value).affectedEntities(count).build();
        }

        /**
         * Returns a result indicating the command was processed with an
         * amount of affected items.
         *
         * @param count The amount of items affected
         * @return The result
         */
        public static <T> CommandResult.Success<T> affectedItems(T value, int count) {
            return builder(value).affectedItems(count).build();
        }

        /**
         * Returns a result indicating the command was processed with an
         * amount of queries.
         *
         * @param count The amount of queries
         * @return The result
         */
        public static <T> CommandResult.Success<T> queryResult(T value, int count) {
            return builder(value).queryResult(count).build();
        }

        /**
         * Constructs a new command result.
         *  @param successCount The success count
         * @param affectedBlocks The number of affected blocks
         * @param affectedEntities The number of affected entities
         * @param affectedItems The number of affected items
         * @param queryResult The query result
         * @param value
         */
        Success(T value, @Nullable Integer successCount, @Nullable Integer affectedBlocks, @Nullable Integer affectedEntities,
                @Nullable Integer affectedItems, @Nullable Integer queryResult) {
            this.successCount = Optional.ofNullable(successCount);
            this.affectedBlocks = Optional.ofNullable(affectedBlocks);
            this.affectedEntities = Optional.ofNullable(affectedEntities);
            this.affectedItems = Optional.ofNullable(affectedItems);
            this.queryResult = Optional.ofNullable(queryResult);
            this.value = value;
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
         * A builder for {@link CommandResult}s.
         */
        public static class Builder<T> {
            private final T value;

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

            Builder(T value) {
                this.value = value;
            }

            /**
             * Sets if the command has been processed.
             *
             * @param successCount If the command has been processed
             * @return This builder, for chaining
             */
            public Builder<T> successCount(@Nullable Integer successCount) {
                this.successCount = successCount;
                return this;
            }

            /**
             * Sets the amount of blocks affected by the command.
             *
             * @param affectedBlocks The amount of blocks affected by the command
             * @return This builder, for chaining
             */
            public Builder<T> affectedBlocks(@Nullable Integer affectedBlocks) {
                this.affectedBlocks = affectedBlocks;
                return this;
            }

            /**
             * Sets the amount of entities affected by the command.
             *
             * @param affectedEntities The amount of entities affected by the command
             * @return This builder, for chaining
             */
            public Builder<T> affectedEntities(@Nullable Integer affectedEntities) {
                this.affectedEntities = affectedEntities;
                return this;
            }

            /**
             * Sets the amount of items affected by the command.
             *
             * @param affectedItems The amount of items affected by the command
             * @return This builder, for chaining
             */
            public Builder<T> affectedItems(@Nullable Integer affectedItems) {
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
            public Builder<T> queryResult(@Nullable Integer queryResult) {
                this.queryResult = queryResult;
                return this;
            }

            /**
             * Builds the {@link CommandResult}.
             *
             * @return A CommandResult with the specified settings
             */
            public CommandResult.Success<T> build() {
                return new CommandResult.Success<>(value, this.successCount, this.affectedBlocks, this.affectedEntities, this.affectedItems, this
                        .queryResult);
            }
        }

    }
}
