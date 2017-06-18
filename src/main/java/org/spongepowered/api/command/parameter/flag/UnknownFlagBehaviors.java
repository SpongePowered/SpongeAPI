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
package org.spongepowered.api.command.parameter.flag;

import org.spongepowered.api.command.parameter.ArgumentParseException;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

public final class UnknownFlagBehaviors {

    private UnknownFlagBehaviors() {}

    // SORTFIELDS:ON

    /**
     * Mark the flag as a non-value flag.
     */
    public static UnknownFlagBehavior ACCEPT_NONVALUE = DummyObjectProvider.createFor(UnknownFlagBehavior.class, "ACCEPT_NONVALUE");

    /**
     * Mark the flag as a string-valued flag.
     */
    public static UnknownFlagBehavior ACCEPT_VALUE = DummyObjectProvider.createFor(UnknownFlagBehavior.class, "ACCEPT_VALUE");

    /**
     * Throw an {@link ArgumentParseException} when an unknown flag is
     * encountered.
     */
    public static UnknownFlagBehavior ERROR = DummyObjectProvider.createFor(UnknownFlagBehavior.class, "ERROR");

    /**
     * Act as if the unknown flag is an ordinary argument.
     */
    public static UnknownFlagBehavior IGNORE = DummyObjectProvider.createFor(UnknownFlagBehavior.class, "IGNORE");

    /**
     * Skip this argument entirely.
     */
    public static UnknownFlagBehavior SKIP = DummyObjectProvider.createFor(UnknownFlagBehavior.class, "SKIP");

    // SORTFIELDS:OFF

}
