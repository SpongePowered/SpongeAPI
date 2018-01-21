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

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

public final class DamageTypes {

    // SORTFIELDS:ON

    public static final DamageType ATTACK = DummyObjectProvider.createFor(DamageType.class, "ATTACK");

    public static final DamageType CONTACT = DummyObjectProvider.createFor(DamageType.class, "CONTACT");

    public static final DamageType CUSTOM = DummyObjectProvider.createFor(DamageType.class, "CUSTOM");

    public static final DamageType DROWN = DummyObjectProvider.createFor(DamageType.class, "DROWN");

    public static final DamageType EXPLOSIVE = DummyObjectProvider.createFor(DamageType.class, "EXPLOSIVE");

    public static final DamageType FALL = DummyObjectProvider.createFor(DamageType.class, "FALL");

    public static final DamageType FIRE = DummyObjectProvider.createFor(DamageType.class, "FIRE");

    public static final DamageType GENERIC = DummyObjectProvider.createFor(DamageType.class, "GENERIC");

    public static final DamageType HUNGER = DummyObjectProvider.createFor(DamageType.class, "HUNGER");

    public static final DamageType MAGIC = DummyObjectProvider.createFor(DamageType.class, "MAGIC");

    public static final DamageType MAGMA = DummyObjectProvider.createFor(DamageType.class, "MAGMA");

    public static final DamageType PROJECTILE = DummyObjectProvider.createFor(DamageType.class, "PROJECTILE");

    public static final DamageType SUFFOCATE = DummyObjectProvider.createFor(DamageType.class, "SUFFOCATE");

    public static final DamageType SWEEPING_ATTACK = DummyObjectProvider.createFor(DamageType.class, "SWEEPING_ATTACK");

    public static final DamageType VOID = DummyObjectProvider.createFor(DamageType.class, "VOID");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private DamageTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
