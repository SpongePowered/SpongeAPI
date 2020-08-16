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
package org.spongepowered.api.world.teleport;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

public final class TeleportHelperFilters {

    // SORTFIELDS:ON

    /**
     * Designed to be combined with other filters, this filter determines if a
     * block is in the config blacklist and returns the appropriate result.
     */
    public static final Supplier<TeleportHelperFilter> CONFIG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TeleportHelperFilter.class, "config");

    /**
     * The default behavior for safe teleportation.
     *
     * <p>This filter attempts to find a location to teleport to that has
     * the following characteristics:</p>
     *
     * <ul>
     *     <li>The two blocks that the player would occupy (the target and the
     *     block above) are passable.</li>
     *     <li>The floor is a non-passable or liquid block which is not known
     *     to harm the player.</li>
     *     <li>The block in question is not blacklisted in the config for the
     *     floor or body (see {@link #CONFIG}).</li>
     * </ul>
     */
    public static final Supplier<TeleportHelperFilter> DEFAULT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TeleportHelperFilter.class, "default");

    /**
     * The flying safe teleportation behavior.
     *
     * <p>This filter attempts to find the following:</p>
     *
     * <ul>
     *     <li>A block that is air or a liquid which is not known by Sponge
     *     to harm the player.</li>
     *     <li>A similar block one block above the target.</li>
     *     <li>That floor blocks are not cacti (and thus, hurt).</li>
     * </ul>
     */
    public static final Supplier<TeleportHelperFilter> FLYING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TeleportHelperFilter.class, "flying");

    /**
     * This filter is the same as the {@link #DEFAULT} kernel, except that
     * portals are not valid targets.
     */
    public static final Supplier<TeleportHelperFilter> NO_PORTAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TeleportHelperFilter.class, "no_portal");

    /**
     * This filter is the same as the {@link #DEFAULT} kernel, except that
     * only targets that can see the sky are considered.
     */
    public static final Supplier<TeleportHelperFilter> SURFACE_ONLY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(TeleportHelperFilter.class, "surface_only");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private TeleportHelperFilters() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
