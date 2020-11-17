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
package org.spongepowered.api.event.entity.explosive;

import org.spongepowered.api.entity.explosive.Explosive;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.world.explosion.Explosion;
import org.spongepowered.api.world.explosion.Explosion.Builder;

/**
 * Event called immediately before an {@link Explosive} explodes.
 */
public interface DetonateExplosiveEvent extends Event, Cancellable {

    /**
     * Gets the {@link Explosive}.
     *
     * @return The explosive
     */
    Explosive getExplosive();

    /**
     * Returns the explosion of the vanilla behavior that this event was
     * initialized with.
     *
     * @return Original explosion
     */
    Explosion getOriginalExplosion();

    /**
     * Returns the {@link Builder} that will be used to build the
     * explosion for the impending detonation.
     *
     * @return Explosion builder for detonation
     */
    Explosion.Builder getExplosionBuilder();

}
