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
package org.spongepowered.api.world;

import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.monster.boss.dragon.EnderDragon;
import org.spongepowered.api.entity.living.monster.piglin.Piglin;
import org.spongepowered.api.entity.living.monster.zombie.ZombifiedPiglin;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.fluid.FluidTypes;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.raid.Raid;
import org.spongepowered.api.registry.DefaultedRegistryValue;
import org.spongepowered.api.service.context.ContextSource;
import org.spongepowered.api.util.MinecraftDayTime;
import org.spongepowered.api.util.annotation.CatalogedBy;
import org.spongepowered.api.world.portal.PortalType;
import org.spongepowered.api.world.portal.PortalTypes;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;

import java.util.Optional;

@CatalogedBy(WorldTypes.class)
public interface WorldType extends DefaultedRegistryValue, ContextSource {

    /**
     * Gets the {@link WorldTypeEffect effect} that will play for a {@link Player player}
     * traveling in a {@link ServerWorld world} of this type.
     *
     * @return The effect
     */
    WorldTypeEffect effect();

    /**
     * Gets if {@link BlockTypes#WATER} will evaporate or {@link BlockTypes#WET_SPONGE} will
     * become a {@link BlockTypes#SPONGE}. Additionally {@link FluidTypes#FLOWING_LAVA} will
     * spread faster and thinner.
     *
     * @return True if scorching, false if not
     */
    boolean scorching();

    /**
     * Gets if portals created via the standard {@link PortalTypes#NETHER}, both via the API
     * or game mechanics, will spawn {@link ZombifiedPiglin} randomly. Otherwise,
     * the {@link ItemTypes#COMPASS} will not function and spin randomly.
     *
     * @return True if natural, false if not
     */
    boolean natural();

    /**
     * Gets the coordinate scale applied to the coordinates of a {@link ServerPlayer player}
     * traveling in a {@link ServerWorld world} of this type.
     *
     * Best seen when transferring that player from one world to another (as the player's
     * coordinates will adjust to the scale of the destination world's).
     *
     * @return The scale
     */
    double coordinateMultiplier();

    /**
     * Gets if a {@link ServerWorld world} of this type will have lighting global lighting, used
     * in game mechanics such as {@link Entity} spawning.
     *
     * <p>In Vanilla, used in weather, lighting engine, and respawning mechanics</p>
     *
     * @return True if skylight, false if not
     */
    boolean hasSkylight();

    /**
     * Gets if a {@link ServerWorld world} of this type is generated with a ceiling at some
     * pre-determined y value composed of {@link BlockTypes#BEDROCK}. Most notable usage of
     * this is for the {@link WorldTypes#THE_NETHER type}.
     *
     * <p>In Vanilla, used in weather, map items, and respawning mechanics</p>
     *
     * @return True if a ceiling is present, false if not
     */
    boolean hasCeiling();

    /**
     * Gets the amount of lighting a client will play as an effect while traversing a
     * {@link ServerWorld world} of this type.
     *
     * <p>In Vanilla, the value will be between {@code 0.0} and {@code 1.0}</p>
     *
     * @return The lighting value
     */
    float ambientLighting();

    /**
     * Gets if a {@link ServerWorld world} of this type will be fixed at a particular
     * {@link MinecraftDayTime time} or flow naturally
     *
     * @return If present, a fixed day time. Otherwise, free flowing time
     */
    Optional<MinecraftDayTime> fixedTime();

    /**
     * Gets if, when {@code False}, a {@link Piglin} will transform into a {@link ZombifiedPiglin},
     * over time, while existing in a {@link ServerWorld world} of this type.
     *
     * @return True if piglin are safe, false if they will zombify
     */
    boolean piglinSafe();

    /**
     * Gets if {@link ServerPlayer players} can sleep in a bed while existing in a
     * {@link ServerWorld world} of this type.
     *
     * @return True if beds are usable, false if not
     */
    boolean bedsUsable();

    /**
     * Gets if {@link ServerPlayer players} can charge and use {@link BlockTypes#RESPAWN_ANCHOR}
     * while existing in a {@link ServerWorld world} of this type.
     *
     * @return True if respawn anchors are usable, false if not
     */
    boolean respawnAnchorsUsable();

    /**
     * Gets if {@link ServerPlayer players} who have the {@link PotionEffectTypes#BAD_OMEN} effect
     * could cause a {@link Raid} while existing in a {@link ServerWorld world} of this type.
     *
     * @return True if bad omens could case a raid, false if not
     */
    boolean hasRaids();

    /**
     * Gets the maximum {@code Y} value that teleportation logic performed via
     * {@link ItemTypes#CHORUS_FRUIT} or {@link PortalType portal types} may use to determine
     * the exit {@link ServerLocation location} of the teleport or the generation of a portal
     * itself.
     *
     * @return The logical height
     */
    int logicalHeight();

    WorldTypeTemplate asTemplate();
}
