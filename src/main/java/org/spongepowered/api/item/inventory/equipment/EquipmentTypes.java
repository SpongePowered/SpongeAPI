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

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * All built-in equipment types.
 */
public final class EquipmentTypes {

    /**
     * Any type, all other types should subclass this to allow instanceof
     * checks to succeed.
     */
    public static final EquipmentType ANY = DummyObjectProvider.createFor(EquipmentType.class, "ANY");

    /**
     * Held or otherwise equipped items.
     */
    public static final EquipmentType EQUIPPED = DummyObjectProvider.createFor(EquipmentType.class, "EQUIPPED");

    /**
     * Any held types like MAINHAND and OFFHAND.
     */
    public static final HeldEquipmentType HELD = DummyObjectProvider.createFor(HeldEquipmentType.class, "HELD");

    public static final HeldEquipmentType MAIN_HAND = DummyObjectProvider.createFor(HeldEquipmentType.class, "MAINHAND");

    public static final HeldEquipmentType OFF_HAND = DummyObjectProvider.createFor(HeldEquipmentType.class, "OFFHAND");

    /**
     * Any worn types like HEADWEAR, CHESTPLATE, LEGGINGS and BOOTS.
     */
    public static final WornEquipmentType WORN = DummyObjectProvider.createFor(WornEquipmentType.class, "WORN");

    public static final WornEquipmentType BOOTS = DummyObjectProvider.createFor(WornEquipmentType.class, "BOOTS");

    public static final WornEquipmentType CHESTPLATE = DummyObjectProvider.createFor(WornEquipmentType.class, "CHESTPLATE");

    public static final WornEquipmentType HEADWEAR = DummyObjectProvider.createFor(WornEquipmentType.class, "HEADWEAR");

    public static final WornEquipmentType LEGGINGS = DummyObjectProvider.createFor(WornEquipmentType.class, "LEGGINGS");

    // Suppress default constructor to ensure non-instantiability.
    private EquipmentTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
