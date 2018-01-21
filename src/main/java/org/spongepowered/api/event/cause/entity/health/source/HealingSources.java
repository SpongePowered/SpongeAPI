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
package org.spongepowered.api.event.cause.entity.health.source;

import org.spongepowered.api.data.manipulator.mutable.entity.IgniteableData;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;
import org.spongepowered.api.world.Location;

/**
 * A static collection of various {@link HealingSource}s that remain static, or
 * otherwise "ambiguous" with regards to the actual source. Examples include:
 * in the event an {@link Entity} is being damaged due to falling through the
 * "void", an {@link Entity} being damaged for being "on fire" in which case
 * an {@link IgniteableData} may be present from the {@link Entity}, etc.
 *
 * <p>{@link HealingSource}s that rely on live instances of various objects,
 * including other {@link Entity} instances, or a block at a specific
 * {@link Location} rely on the various other types of {@link HealingSource}s.
 * </p>
 */
public final class HealingSources {

    // SORTFIELDS:ON

    public static final HealingSource FOOD = DummyObjectProvider.createFor(HealingSource.class, "FOOD");

    public static final HealingSource GENERIC = DummyObjectProvider.createFor(HealingSource.class, "GENERIC");

    public static final HealingSource MAGIC = DummyObjectProvider.createFor(HealingSource.class, "MAGIC");

    // SORTFIELDS:OFF


    // Suppress default constructor to ensure non-instantiability.
    private HealingSources() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
