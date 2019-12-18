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
package org.spongepowered.api.item.inventory.equipment;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * All built-in equipment types.
 */
public final class EquipmentTypes {

    /**
     * Any type, all other types should subclass this to allow instanceof
     * checks to succeed.
     */
    public static final Supplier<EquipmentType> ANY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EquipmentType.class, "ANY");

    /**
     * Held or otherwise equipped items.
     */
    public static final Supplier<EquipmentType> EQUIPPED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EquipmentType.class, "EQUIPPED");

    /**
     * Any held types like MAINHAND and OFFHAND.
     */
    public static final Supplier<HeldEquipmentType> HELD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(HeldEquipmentType.class, "HELD");

    public static final Supplier<HeldEquipmentType> MAIN_HAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(HeldEquipmentType.class, "MAINHAND");

    public static final Supplier<HeldEquipmentType> OFF_HAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(HeldEquipmentType.class, "OFFHAND");

    /**
     * Any worn types like HEADWEAR, CHESTPLATE, LEGGINGS and BOOTS.
     */
    public static final Supplier<WornEquipmentType> WORN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(WornEquipmentType.class, "WORN");

    public static final Supplier<WornEquipmentType> BOOTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(WornEquipmentType.class, "BOOTS");

    public static final Supplier<WornEquipmentType> CHESTPLATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(WornEquipmentType.class, "CHESTPLATE");

    public static final Supplier<WornEquipmentType> HEADWEAR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(WornEquipmentType.class, "HEADWEAR");

    public static final Supplier<WornEquipmentType> LEGGINGS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(WornEquipmentType.class, "LEGGINGS");

    // Suppress default constructor to ensure non-instantiability.
    private EquipmentTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
