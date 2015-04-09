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

/**
 * Utility class to create {@link CommandResult}s.
 */
public class CommandResults {

    private static final CommandResult PROCESSED = new CommandResultBuilder().processed(true).build();
    private static final CommandResult NOT_PROCESSED = new CommandResultBuilder().processed(false).build();

    private CommandResults() {
    }

    /**
     * Returns a {@link CommandResultBuilder}.
     *
     * @return A new command result builder
     */
    public static CommandResultBuilder builder() {
        return new CommandResultBuilder();
    }

    /**
     * Returns a new {@link CommandResult} indicating that a command was
     * processed.
     *
     * @return The command result
     */
    public static CommandResult processed() {
        return PROCESSED;
    }

    /**
     * Returns a new {@link CommandResult} indicating that a command was not
     * processed.
     *
     * @return The command result
     */
    public static CommandResult notProcessed() {
        return NOT_PROCESSED;
    }

}
