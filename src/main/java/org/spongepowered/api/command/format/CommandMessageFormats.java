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
package org.spongepowered.api.command.format;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

public final class CommandMessageFormats {

    private CommandMessageFormats() {}

    // SORTFIELDS:ON

    /**
     * Formats text to use the suggested formatting for a debug message.
     */
    public static final CommandMessageFormat DEBUG = DummyObjectProvider.createFor(CommandMessageFormat.class, "debug");

    /**
     * Formats text to use the suggested formatting for an error message.
     *
     * <p>This is not necessary when creating an exception to be thrown</p>
     */
    public static final CommandMessageFormat ERROR = DummyObjectProvider.createFor(CommandMessageFormat.class, "error");

    /**
     * Formats text to use the suggested formatting for a success message.
     */
    public static final CommandMessageFormat SUCCESS = DummyObjectProvider.createFor(CommandMessageFormat.class, "success");

    /**
     * Formats text to use the suggested formatting for a system message.
     */
    public static final CommandMessageFormat SYSTEM = DummyObjectProvider.createFor(CommandMessageFormat.class, "system");

    // SORTFIELDS:OFF

}
