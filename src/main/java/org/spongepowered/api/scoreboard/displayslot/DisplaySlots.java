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

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * Display slot names which display an objective in a particular place in-game.
 */
public final class DisplaySlots {

    // SORTFIELDS:ON

    /**
     * Displays a player's score for the objective underneath their nametag
     * in-game, when a player is closer than 10 blocks.
     */
    public static final Supplier<DisplaySlot> BELOW_NAME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "below_name");

    /**
     * Displays scores for the objective next to players' names in the
     * player list (accessed by holding TAB).
     */
    public static final Supplier<DisplaySlot> LIST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "list");

    /**
     * Displays scores for the objective on the side of the screen in-game.
     */
    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_NO_COLOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_no_color");

    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_AQUA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_aqua");

    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_BLACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_black");

    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_BLUE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_blue");

    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_DARK_AQUA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_dark_aqua");

    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_DARK_BLUE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_dark_blue");

    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_DARK_GRAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_dark_gray");

    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_DARK_GREEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_dark_green");

    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_DARK_PURPLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_dark_purple");

    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_DARK_RED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_dark_red");

    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_GOLD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_gold");

    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_GRAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_gray");

    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_GREEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_green");

    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_LIGHT_PURPLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_light_purple");

    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_RED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_red");

    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_WHITE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_white");

    public static final Supplier<DisplaySlot> SIDEBAR_TEAM_YELLOW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DisplaySlot.class, "sidebar_team_yellow");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private DisplaySlots() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
