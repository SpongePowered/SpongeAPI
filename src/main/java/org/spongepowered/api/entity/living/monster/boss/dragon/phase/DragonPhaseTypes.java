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
package org.spongepowered.api.entity.living.monster.boss.dragon.phase;

import org.spongepowered.api.entity.living.monster.boss.dragon.EnderDragon;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.projectile.explosive.fireball.DragonFireball;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of {@link DragonPhaseType}s.
 */
public final class DragonPhaseTypes {

    // SORTFIELDS:ON

    /**
     * The {@link EnderDragon} is charging towards a {@link Player}.
     */
    public static final DragonPhaseType CHARGING_PLAYER = DummyObjectProvider.createFor(DragonPhaseType.class, "CHARGING_PLAYER");

    /**
     * The {@link EnderDragon} is flying to the End Portal to die.
     */
    public static final DragonPhaseType DYING = DummyObjectProvider.createFor(DragonPhaseType.class, "DYING");

    /**
     * The {@link EnderDragon} is circling around.
     */
    public static final DragonPhaseType HOLDING_PATTERN = DummyObjectProvider.createFor(DragonPhaseType.class, "HOLDING_PATTERN");

    /**
     * The {@link EnderDragon} is hovering.
     *
     * <p>This is the default state when summoned using the {@code /summon} command.</p>
     */
    public static final DragonPhaseType HOVER = DummyObjectProvider.createFor(DragonPhaseType.class, "HOVER");

    /**
     * The {@link EnderDragon} is landing on the End Portal.
     *
     * <p>This is part of the transition to a landed state.</p>
     */
    public static final DragonPhaseType LANDING = DummyObjectProvider.createFor(DragonPhaseType.class, "LANDING");

    /**
     * The {@link EnderDragon} is flying to the End Portal to land.
     *
     * <p>This is part of the transition to a landed state.</p>
     */
    public static final DragonPhaseType LANDING_APPROACH = DummyObjectProvider.createFor(DragonPhaseType.class, "LANDING_APPROACH");

    /**
     * The {@link EnderDragon} is growling before performing a dragon breath attack.
     */
    public static final DragonPhaseType SITTING_ATTACKING = DummyObjectProvider.createFor(DragonPhaseType.class, "SITTING_ATTACKING");

    /**
     * The {@link EnderDragon} is performing a dragon breath attack.
     *
     * <p>This is part of the landed state.</p>
     */
    public static final DragonPhaseType SITTING_FLAMING = DummyObjectProvider.createFor(DragonPhaseType.class, "SITTING_FLAMING");

    /**
     * The {@link EnderDragon} is looking for a {@link Player} to peform a dragon breath attack.
     */
    public static final DragonPhaseType SITTING_SCANNING = DummyObjectProvider.createFor(DragonPhaseType.class, "SITTING_SCANNING");

    /**
     * The {@link EnderDragon} is preparing to shoot a {@link DragonFireball}.
     */
    public static final DragonPhaseType STRAFE_PLAYER = DummyObjectProvider.createFor(DragonPhaseType.class, "STRAFE_PLAYER");

    /**
     * The {@link EnderDragon} is taking off from the End Portal.
     *
     * <p>This is part of the transition out of a landed state.</p>
     */
    public static final DragonPhaseType TAKEOFF = DummyObjectProvider.createFor(DragonPhaseType.class, "TAKEOFF");

    // SORTFIELDS:OFF

    private DragonPhaseTypes() {
    }

}
