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

import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;

/**
 * Fired when a command is sent.
 */
public interface SendCommandEvent extends Event, Cancellable {

    /**
     * Gets the command as a string, without any sort of command prefix.
     *
     * <p>For example, if the message was {@code /example bob 3 -f}, then
     * the command would be {@code example}.</p>
     *
     * @return The command
     */
    String getCommand();

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
     * Gets the arguments as a string.
     *
     * <p>For example, if the message was {@code /example bob 3 -f}, then
     * the arguments would be {@code bob 3 -f}.</p>
     *
     * @return The arguments
     */
    String getArguments();

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
     * @return The result of the command
     */
    CommandResult getResult();

    /**
     * Sets the result of the command.
     *
     * @param result The result of the command
     */
    void setResult(CommandResult result);

}
