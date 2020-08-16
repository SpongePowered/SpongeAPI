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
package org.spongepowered.api.entity.living.player.gamemode;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * A list of the game modes that Minecraft provides in vanilla.
 */
public final class GameModes {

    // SORTFIELDS:ON

    public static final Supplier<GameMode> ADVENTURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(GameMode.class, "adventure");

    public static final Supplier<GameMode> CREATIVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(GameMode.class, "creative");

    public static final Supplier<GameMode> NOT_SET = Sponge.getRegistry().getCatalogRegistry().provideSupplier(GameMode.class, "not_set");

    public static final Supplier<GameMode> SPECTATOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(GameMode.class, "spectator");

    public static final Supplier<GameMode> SURVIVAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(GameMode.class, "survival");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private GameModes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
