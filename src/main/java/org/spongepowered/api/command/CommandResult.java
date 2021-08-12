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

import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;

import java.util.Optional;

/**
 * Represents the result of a command in Sponge.
 */
public interface CommandResult {

    /**
     * Creates a builder that creates {@link CommandResult}s.
     *
     * @return The {@link Builder}
     */
    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Builds a result that indicates success (where {@link Builder#result(int)}
     * is set to 1.
     *
     * <p>Note that a successful result is one where the command has done what
     * is expected of it. This should be used in place of "empty" from previous
     * API iterations. If an error condition should be reported, use
     * {@link #error(Component)} instead, which will allow the system to react
     * accordingly.</p>
     *
     * @return The {@link CommandResult}
     */
    static CommandResult success() {
        return Sponge.game().factoryProvider().provide(Factory.class).success();
    }

    /**
     * Builds an empty result that will prompt the command manager to send an
     * error message without throwing an exception.
     *
     * @param errorMessage The error message to send
     * @return The {@link CommandResult}
     */
    static CommandResult error(final Component errorMessage) {
        return CommandResult.builder().error(errorMessage).build();
    }

    /**
     * Gets whether the command executed successfully.
     *
     * @return {@code true} if so.
     */
    boolean isSuccess();

    /**
     * Gets the integer result returned by the command that executed.
     *
     * @return The result.
     */
    int result();

    /**
     * If present, returns the error message associated with this result.
     *
     * @return The error {@link Component}
     */
    Optional<Component> errorMessage();

    /**
     * Builds {@link CommandResult}s.
     */
    interface Builder extends org.spongepowered.api.util.Builder<CommandResult, Builder> {

        /**
         * Sets an integer value that indicates the states of the
         * command.
         *
         * <ul>
         *     <li>A positive value indicates successful execution,</li>
         *     <li>Zero (generally) indicates the command didn't fulfil its
         *     task, though that is not necessarily an error condition.</li>
         *     <li>A negative value is undefined in the API, if returned, the
         *     effects are implementation specific.</li>
         * </ul>
         *
         * @param result The integer result to set
         * @return This builder, for chaining
         */
        Builder result(int result);

        /**
         * Sets the built result to report an error, with an optional error
         * message.
         *
         * <p>If this is set, then the command parser will send this message to
         * the command invoker. Otherwise, the parser will report an unknown
         * exception.</p>
         *
         * @param errorMessage The message to send to the user.
         * @return This builder, for chaining
         */
        Builder error(@Nullable Component errorMessage);

        /**
         * Builds the {@link CommandResult}.
         *
         * @return A CommandResult with the specified settings
         */
        @Override
        CommandResult build();

    }

    interface Factory {

        CommandResult success();

    }

}
