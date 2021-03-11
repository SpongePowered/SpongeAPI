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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.monster.boss.dragon.EnderDragon;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.projectile.explosive.fireball.DragonFireball;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of {@link DragonPhaseType}s.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class DragonPhaseTypes {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * The {@link EnderDragon} is charging towards a {@link Player}.
     */
    public static final DefaultedRegistryReference<DragonPhaseType> CHARGING_PLAYER = DragonPhaseTypes.key(ResourceKey.sponge("charging_player"));

    /**
     * The {@link EnderDragon} is flying to the End Portal to die.
     */
    public static final DefaultedRegistryReference<DragonPhaseType> DYING = DragonPhaseTypes.key(ResourceKey.sponge("dying"));

    /**
     * The {@link EnderDragon} is circling around.
     */
    public static final DefaultedRegistryReference<DragonPhaseType> HOLDING_PATTERN = DragonPhaseTypes.key(ResourceKey.sponge("holding_pattern"));

    /**
     * The {@link EnderDragon} is hovering.
     *
     * <p>This is the default state when summoned using the {@code /summon} command.</p>
     */
    public static final DefaultedRegistryReference<DragonPhaseType> HOVER = DragonPhaseTypes.key(ResourceKey.sponge("hover"));

    /**
     * The {@link EnderDragon} is landing on the End Portal.
     *
     * <p>This is part of the transition to a landed state.</p>
     */
    public static final DefaultedRegistryReference<DragonPhaseType> LANDING = DragonPhaseTypes.key(ResourceKey.sponge("landing"));

    /**
     * The {@link EnderDragon} is flying to the End Portal to land.
     *
     * <p>This is part of the transition to a landed state.</p>
     */
    public static final DefaultedRegistryReference<DragonPhaseType> LANDING_APPROACH = DragonPhaseTypes.key(ResourceKey.sponge("landing_approach"));

    /**
     * The {@link EnderDragon} is growling before performing a dragon breath attack.
     */
    public static final DefaultedRegistryReference<DragonPhaseType> SITTING_ATTACKING = DragonPhaseTypes.key(ResourceKey.sponge("sitting_attacking"));

    /**
     * The {@link EnderDragon} is performing a dragon breath attack.
     *
     * <p>This is part of the landed state.</p>
     */
    public static final DefaultedRegistryReference<DragonPhaseType> SITTING_FLAMING = DragonPhaseTypes.key(ResourceKey.sponge("sitting_flaming"));

    /**
     * The {@link EnderDragon} is looking for a {@link Player} to peform a dragon breath attack.
     */
    public static final DefaultedRegistryReference<DragonPhaseType> SITTING_SCANNING = DragonPhaseTypes.key(ResourceKey.sponge("sitting_scanning"));

    /**
     * The {@link EnderDragon} is preparing to shoot a {@link DragonFireball}.
     */
    public static final DefaultedRegistryReference<DragonPhaseType> STRAFE_PLAYER = DragonPhaseTypes.key(ResourceKey.sponge("strafe_player"));

    /**
     * The {@link EnderDragon} is taking off from the End Portal.
     *
     * <p>This is part of the transition out of a landed state.</p>
     */
    public static final DefaultedRegistryReference<DragonPhaseType> TAKEOFF = DragonPhaseTypes.key(ResourceKey.sponge("takeoff"));

    // SORTFIELDS:OFF

    // @formatter:on

    private DragonPhaseTypes() {
    }

    private static DefaultedRegistryReference<DragonPhaseType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.DRAGON_PHASE_TYPE, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
