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
package org.spongepowered.api.entity.living.monster;

import org.spongepowered.api.boss.ServerBossBar;
import org.spongepowered.api.entity.explosive.FusedExplosive;
import org.spongepowered.api.entity.living.Aerial;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.Ranger;

import java.util.List;

/**
 * Represents the Wither.
 */
public interface Wither extends Monster, Ranger, Boss, Aerial, FusedExplosive {

    /**
     * Gets the list of {@link Living} targets that this wither is targeting.
     * Usually, as an {@link Agent}, {@link #getTarget()} would be sufficient,
     * however, due to a Wither having the possibility of 3 targets, this
     * is preferred use.
     *
     * @return The list of living targets
     */
    List<Living> getTargets();

    /**
     * Sets the list of living targets.
     *
     * @param targets The targets
     */
    void setTargets(List<Living> targets);

    /**
     * Gets the boss bar this wither uses.
     *
     * @return The boss bar
     */
    ServerBossBar getBossBar();

}
