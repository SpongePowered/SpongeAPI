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
package org.spongepowered.api.keyboard;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all possible {@link KeyContext}s.
 */
public final class KeyContexts {

    // SORTFIELDS:ON

    /**
     * The gui key context, is active when a window is open.
     * For example: inventories, menus, books, ...
     */
    public static final KeyContext GUI = DummyObjectProvider.createFor(KeyContext.class, "GUI");

    /**
     * The default key context, is active when there aren't guis open.
     */
    public static final KeyContext IN_GAME = DummyObjectProvider.createFor(KeyContext.class, "IN_GAME");

    /**
     * The gui key context, is active when a inventory is open.
     */
    public static final KeyContext INVENTORY = DummyObjectProvider.createFor(KeyContext.class, "INVENTORY");

    /**
     * The default key context, is always active.
     */
    public static final KeyContext UNIVERSAL = DummyObjectProvider.createFor(KeyContext.class, "UNIVERSAL");

    // SORTFIELDS:OFF

    private KeyContexts() {
    }
}
