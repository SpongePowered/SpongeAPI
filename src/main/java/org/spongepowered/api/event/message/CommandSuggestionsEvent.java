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
package org.spongepowered.api.event.message;

import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.util.command.CommandSource;

import java.util.List;

/**
 * Event called when suggestions are requested by a command source.
 */
public interface CommandSuggestionsEvent extends GameEvent, Cancellable {

    /**
     * Get the source of the command.
     *
     * @return The source of the command
     */
    CommandSource getSource();

    /**
     * Get the command as a string, without any sort of command prefix.
     *
     * <p>For example, if the message was {@code /example bob 3 -f}, then
     * the command would be {@code example}.</p>
     *
     * @return The commands
     */
    String getCommand();

    /**
     * Get the arguments as a string.
     *
     * <p>For example, if the message was {@code /example bob 3 -f}, then
     * the arguments would be {@code bob 3 -f}.</p>
     *
     * @return The arguments
     */
    String getArguments();

    /**
     * Get the list of available suggestions. This list is mutable, so any modifications should happen to this list.
     * All suggestions will replace the last word in the arguments on the client.
     *
     * @return The list of suggestion
     */
    List<String> getSuggestions();

}
