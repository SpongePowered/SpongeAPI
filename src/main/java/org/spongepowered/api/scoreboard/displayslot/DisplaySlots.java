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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * Display slot names which display an objective in a particular place in-game.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class DisplaySlots {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * Displays a player's score for the objective underneath their nametag
     * in-game, when a player is closer than 10 blocks.
     */
    public static final DefaultedRegistryReference<DisplaySlot> BELOW_NAME = DisplaySlots.key(ResourceKey.sponge("below_name"));

    /**
     * Displays scores for the objective next to players' names in the
     * player list (accessed by holding TAB).
     */
    public static final DefaultedRegistryReference<DisplaySlot> LIST = DisplaySlots.key(ResourceKey.sponge("list"));

    /**
     * Displays scores for the objective on the side of the screen in-game.
     */
    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR = DisplaySlots.key(ResourceKey.sponge("sidebar"));

    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR_TEAM_AQUA = DisplaySlots.key(ResourceKey.sponge("sidebar_team_aqua"));

    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR_TEAM_BLACK = DisplaySlots.key(ResourceKey.sponge("sidebar_team_black"));

    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR_TEAM_BLUE = DisplaySlots.key(ResourceKey.sponge("sidebar_team_blue"));

    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR_TEAM_DARK_AQUA = DisplaySlots.key(ResourceKey.sponge("sidebar_team_dark_aqua"));

    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR_TEAM_DARK_BLUE = DisplaySlots.key(ResourceKey.sponge("sidebar_team_dark_blue"));

    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR_TEAM_DARK_GRAY = DisplaySlots.key(ResourceKey.sponge("sidebar_team_dark_gray"));

    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR_TEAM_DARK_GREEN = DisplaySlots.key(ResourceKey.sponge("sidebar_team_dark_green"));

    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR_TEAM_DARK_PURPLE = DisplaySlots.key(ResourceKey.sponge("sidebar_team_dark_purple"));

    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR_TEAM_DARK_RED = DisplaySlots.key(ResourceKey.sponge("sidebar_team_dark_red"));

    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR_TEAM_GOLD = DisplaySlots.key(ResourceKey.sponge("sidebar_team_gold"));

    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR_TEAM_GRAY = DisplaySlots.key(ResourceKey.sponge("sidebar_team_gray"));

    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR_TEAM_GREEN = DisplaySlots.key(ResourceKey.sponge("sidebar_team_green"));

    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR_TEAM_LIGHT_PURPLE = DisplaySlots.key(ResourceKey.sponge("sidebar_team_light_purple"));

    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR_TEAM_RED = DisplaySlots.key(ResourceKey.sponge("sidebar_team_red"));

    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR_TEAM_WHITE = DisplaySlots.key(ResourceKey.sponge("sidebar_team_white"));

    public static final DefaultedRegistryReference<DisplaySlot> SIDEBAR_TEAM_YELLOW = DisplaySlots.key(ResourceKey.sponge("sidebar_team_yellow"));

    // SORTFIELDS:OFF

    // @formatter:on

    private DisplaySlots() {
    }

    private static DefaultedRegistryReference<DisplaySlot> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.DISPLAY_SLOT, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
