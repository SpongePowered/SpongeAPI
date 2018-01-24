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
package org.spongepowered.api.scoreboard.displayslot;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * Display slot names which display an objective in a particular place in-game.
 */
public final class DisplaySlots {

    // SORTFIELDS:ON

    /**
     * Displays a player's score for the objective underneath their nametag
     * in-game, when a player is closer than 10 blocks.
     */
    public static final DisplaySlot BELOW_NAME = DummyObjectProvider.createFor(DisplaySlot.class, "BELOW_NAME");

    /**
     * Displays scores for the objective next to players' names in the
     * player list (accessed by holding TAB).
     */
    public static final DisplaySlot LIST = DummyObjectProvider.createFor(DisplaySlot.class, "LIST");

    /**
     * Displays scores for the objective on the side of the screen in-game.
     */
    public static final DisplaySlot SIDEBAR = DummyObjectProvider.createFor(DisplaySlot.class, "SIDEBAR");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private DisplaySlots() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
