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
package org.spongepowered.api.event.cause.entity;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

public final class MovementTypes {

    // SORTFIELDS:ON

    public static final Supplier<MovementType> CHORUS_FRUIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MovementType.class, "chorus_fruit");

    public static final Supplier<MovementType> COMMAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MovementType.class, "command");

    public static final Supplier<MovementType> END_GATEWAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MovementType.class, "end_gateway");

    public static final Supplier<MovementType> ENDER_PEARL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MovementType.class, "ender_pearl");

    public static final Supplier<MovementType> ENTITY_TELEPORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MovementType.class, "entity_teleport");

    public static final Supplier<MovementType> NATURAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MovementType.class, "natural");

    public static final Supplier<MovementType> PLUGIN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MovementType.class, "plugin");

    public static final Supplier<MovementType> PORTAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(MovementType.class, "portal");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private MovementTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
