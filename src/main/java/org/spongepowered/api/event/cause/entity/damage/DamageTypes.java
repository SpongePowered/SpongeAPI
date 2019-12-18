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
package org.spongepowered.api.event.cause.entity.damage;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import java.util.function.Supplier;

public final class DamageTypes {

    // SORTFIELDS:ON

    public static final Supplier<DamageType> ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageType.class, "ATTACK");

    public static final Supplier<DamageType> CONTACT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageType.class, "CONTACT");

    public static final Supplier<DamageType> CUSTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageType.class, "CUSTOM");

    public static final Supplier<DamageType> DROWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageType.class, "DROWN");

    public static final Supplier<DamageType> DRYOUT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageType.class, "DRYOUT");

    public static final Supplier<DamageType> EXPLOSIVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageType.class, "EXPLOSIVE");

    public static final Supplier<DamageType> FALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageType.class, "FALL");

    public static final Supplier<DamageType> FIRE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageType.class, "FIRE");

    public static final Supplier<DamageType> GENERIC = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageType.class, "GENERIC");

    public static final Supplier<DamageType> HUNGER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageType.class, "HUNGER");

    public static final Supplier<DamageType> MAGIC = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageType.class, "MAGIC");

    public static final Supplier<DamageType> MAGMA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageType.class, "MAGMA");

    public static final Supplier<DamageType> PROJECTILE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageType.class, "PROJECTILE");

    public static final Supplier<DamageType> SUFFOCATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageType.class, "SUFFOCATE");

    public static final Supplier<DamageType> SWEEPING_ATTACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageType.class, "SWEEPING_ATTACK");

    public static final Supplier<DamageType> VOID = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DamageType.class, "VOID");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private DamageTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
