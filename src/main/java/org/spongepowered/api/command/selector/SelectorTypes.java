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
package org.spongepowered.api.command.selector;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * All {@link SelectorType}s available in Minecraft.
 */
public final class SelectorTypes {

    // SORTFIELDS:ON

    /**
     * Selects all entities.
     *
     * <p>Equivalent to {@code @e}.</p>
     */
    public static final Supplier<SelectorType> ALL_ENTITIES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SelectorType.class, "all_entities");

    /**
     * Selects all players.
     *
     * <p>Equivalent to {@code @a}.</p>
     */
    public static final Supplier<SelectorType> ALL_PLAYERS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SelectorType.class, "all_players");

    /**
     * Selects the nearest player.
     *
     * <p>Equivalent to {@code @p}.</p>
     */
    public static final Supplier<SelectorType> NEAREST_PLAYER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SelectorType.class, "nearest_player");

    /**
     * Selects the nearest player.
     *
     * <p>Equivalent to {@code @r}.</p>
     */
    public static final Supplier<SelectorType> RANDOM_PLAYER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SelectorType.class, "random_player");

    /**
     * Selects the context of the selector, if the context is an entity.
     *
     * <p>Equivalent to {@code @s}.</p>
     */
    public static final Supplier<SelectorType> SOURCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(SelectorType.class, "source");

    // SORTFIELDS:OFF

    private SelectorTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class");
    }

}
