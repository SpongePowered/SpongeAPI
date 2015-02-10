/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.event.cause;

/**
 * An enumeration of standard {@link DamageCause}s.
 */
public final class HealthChangeCauses {

    public static final HealthChangeCause GENERIC = null;

    //Healing causes
    public static final HealthChangeCause FOOD = null;
    public static final HealthChangeCause PASSIVE = null;
    public static final HealthChangeCause LIFE_STEAL = null;

    //Damage causes
    public static final DamageCause IN_FIRE = null;
    public static final DamageCause ON_FIRE = null;
    public static final DamageCause LIGHTNING_BOLT = null;
    public static final DamageCause LAVA = null;
    public static final DamageCause IN_WALL = null;
    public static final DamageCause DROWN = null;
    public static final DamageCause STARVE = null;
    public static final DamageCause CACTUS = null;
    public static final DamageCause FALL = null;
    public static final DamageCause OUT_OF_WORLD = null;
    public static final DamageCause MAGIC = null;
    public static final DamageCause WITHER = null;
    public static final DamageCause ANVIL = null;
    public static final DamageCause FALLING_BLOCK = null;

    private HealthChangeCauses() {}

}
