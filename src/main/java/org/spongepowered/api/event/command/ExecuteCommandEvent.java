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
package org.spongepowered.api.event.command;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.command.CommandCause;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.Cause;

import java.util.Optional;

/**
 * Events that fire when commands are executed.
 */
public interface ExecuteCommandEvent extends Event {

    /**
     * Gets the {@link CommandCause} that is involved in this event.
     *
     * <p>{@link CommandCause#getCause()} returns the same {@link Cause} as
     * {@link #getCause()}.</p>
     *
     * @return The {@link CommandCause}
     */
    CommandCause getCommandCause();

    /**
     * Gets the command that were requested by the {@link Cause} before any
     * events were fired, without any sort of command prefix.
     *
     * <p>For example, if the message was {@code /example bob 3 -f}, then
     * the command would be {@code example}.</p>
     *
     * @return The original command
     */
    String getOriginalCommand();

    /**
     * Gets the command that will be/has been executed, without any prefix.
     *
     * @return The command
     */
    String getCommand();

    /**
     * Gets the arguments that were requested by the {@link Cause} before any
     * events were fired.
     *
     * <p>For example, if the message was {@code /example bob 3 -f}, then
     * the arguments would be {@code bob 3 -f}.</p>
     *
     * @return The original arguments
     */
    String getOriginalArguments();

    /**
     * Gets the arguments as a string.
     *
     * @return The arguments
     */
    String getArguments();

    /**
     * Fired before the command is executed.
     */
    interface Pre extends ExecuteCommandEvent, Cancellable {

        /**
         * Sets the command as a string, without any sort of command prefix.
         *
         * <p>For example, if the message was {@code /example bob 3 -f}, then
         * the command would be {@code example}.</p>
         *
         * @param command The command
         */
        void setCommand(String command);

        /**
         * Sets the arguments as a string.
         *
         * <p>For example, if the message was {@code /example bob 3 -f}, then
         * the arguments would be {@code bob 3 -f}.</p>
         *
         * @param arguments The arguments
         */
        void setArguments(String arguments);

        /**
         * The result of the command.
         *
         * <p>If set, this indicates cancellation of the command.</p>
         *
         * @return The result of the command, if set.
         */
        Optional<CommandResult> getResult();

        /**
         * Sets the result of the command.
         *
         * @param result The result of the command
         */
        void setResult(@Nullable CommandResult result);

        /**
         * If true, the command will not run and the {@link CommandResult}
         * given by {@link #getResult()} will be returned.
         *
         * @return The cancellation status of the event.
         */
        @Override
        boolean isCancelled();

        /**
         * Sets whether the command will run. If the command is cancelled using
         * this method, an appropriate {@link CommandResult} will be set (and
         * returned from {@link #getResult()}).
         *
         * @param cancel The new cancelled state
         */
        @Override
        void setCancelled(boolean cancel);

    }

    /**
     * Fired after the command is executed.
     */
    interface Post extends ExecuteCommandEvent {

        /**
         * The result of the command.
         *
         * @return The result
         */
        CommandResult getResult();

    }

}

