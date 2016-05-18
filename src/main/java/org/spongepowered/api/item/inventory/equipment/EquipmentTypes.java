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

    // SORTFIELDS:ON

    /**
     * Any type, all other types should subclass this to allow instanceof checks
     * to succeed.
     */
    public static final EquipmentType ANY = DummyObjectProvider.createFor(EquipmentType.class, "ANY");

    /**
     * Held or otherwise equipped items.
     */
    public static final EquipmentType EQUIPPED = DummyObjectProvider.createFor(EquipmentType.class, "EQUIPPED");

    /**
     * Armor types, HEADWEAR, CHESTPLATE, LEGGINGS and BOOTS should subclass
     * this.
     */
    public static final EquipmentTypeWorn WORN = DummyObjectProvider.createFor(EquipmentTypeWorn.class, "WORN");

    // SORTFIELDS:OFF

    // SORTFIELDS:ON

    public static final EquipmentTypeWorn BOOTS = DummyObjectProvider.createFor(EquipmentTypeWorn.class, "BOOTS");

    public static final EquipmentTypeWorn CHESTPLATE = DummyObjectProvider.createFor(EquipmentTypeWorn.class, "CHESTPLATE");

    // Armor
    public static final EquipmentTypeWorn HEADWEAR = DummyObjectProvider.createFor(EquipmentTypeWorn.class, "HEADWEAR");

    public static final EquipmentTypeWorn LEGGINGS = DummyObjectProvider.createFor(EquipmentTypeWorn.class, "LEGGINGS");

    // SORTFIELDS:OFF

    /**
     * No subclasses for you.
     */
    private EquipmentTypes() {}

}
