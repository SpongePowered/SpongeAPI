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
package org.spongepowered.api.event.cause.entity.damage.source;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.world.server.ServerLocation;

/**
 * A static collection of various {@link DamageSource}s that remain static, or
 * otherwise "ambiguous" with regards to the actual source. Examples include:
 * in the event an {@link Entity} is being damaged due to falling through the
 * "void", an {@link Entity} being damaged for being "on fire" in which case
 * an {@link Keys#FIRE_TICKS} may be present from the {@link Entity}, etc.
 *
 * <p>{@link DamageSource}s that rely on live instances of various objects,
 * including other {@link Entity} instances, or a block at a specific
 * {@link ServerLocation} rely on the various other types of {@link DamageSource}s.
 * </p>
 */
public final class DamageSources {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DamageSource DROWNING = Sponge.game().getFactoryProvider().provide(DamageSource.Factory.class).drowning();

    public static final DamageSource DRYOUT = Sponge.game().getFactoryProvider().provide(DamageSource.Factory.class).dryout();

    public static final DamageSource FALLING = Sponge.game().getFactoryProvider().provide(DamageSource.Factory.class).falling();

    public static final DamageSource FIRE_TICK = Sponge.game().getFactoryProvider().provide(DamageSource.Factory.class).fireTick();

    public static final DamageSource GENERIC = Sponge.game().getFactoryProvider().provide(DamageSource.Factory.class).generic();

    public static final DamageSource MAGIC = Sponge.game().getFactoryProvider().provide(DamageSource.Factory.class).magic();

    public static final DamageSource STARVATION = Sponge.game().getFactoryProvider().provide(DamageSource.Factory.class).starvation();

    public static final DamageSource VOID = Sponge.game().getFactoryProvider().provide(DamageSource.Factory.class).voidSource();

    public static final DamageSource WITHER = Sponge.game().getFactoryProvider().provide(DamageSource.Factory.class).wither();

    // SORTFIELDS:OFF

    // @formatter:on

    private DamageSources() {
    }

}
