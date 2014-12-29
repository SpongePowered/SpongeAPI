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

package org.spongepowered.api.entity.living.monster;

import org.spongepowered.api.entity.living.Aerial;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.projectile.source.ProjectileSource;

import java.util.List;

/**
 * Represents the Wither.
 */
public interface Wither extends Monster, ProjectileSource, Boss, Aerial {

    /**
     * Gets the amount of ticks that the Wither should stay
     * invulnerable for.
     *
     * @return The invulnerable time in ticks
     */
    int getInvulnerableTicks();

    /**
     * Sets the amount of ticks that the Wither should stay
     * invulnerable for.
     *
     * <b>Note: This causes an explosion when the time runs out.</b>
     *
     * @param invulnerableTicks The invulnerable time in ticks
     */
    void setInvulnerableTicks(int invulnerableTicks);

    /**
     * Gets the entities currently being targeted by this wither.
     * <p>This list should contain a maximum of 3 entities.</p>
     *
     * @return The Wither's targets
     */
    List<Living> getTargets();
}
