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

import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.monster.boss.dragon.EnderDragon;
import org.spongepowered.api.entity.living.monster.piglin.Piglin;
import org.spongepowered.api.entity.living.monster.zombie.ZombifiedPiglin;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.fluid.FluidTypes;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.raid.Raid;
import org.spongepowered.api.tag.Tag;
import org.spongepowered.api.util.MinecraftDayTime;
import org.spongepowered.api.util.Range;
import org.spongepowered.api.world.portal.PortalLogic;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;

import java.util.Optional;

public interface WorldTypeDataFetcher extends DataHolder {

    /**
     * Gets the {@link WorldTypeEffect effect} that will play for a {@link ServerPlayer player}
     * traveling in a {@link ServerWorld world} of this type.
     *
     * @return The effect
     */
    default WorldTypeEffect effect() {
        return this.require(Keys.WORLD_TYPE_EFFECT);
    }

    /**
     * Gets if {@link BlockTypes#WATER} will evaporate or {@link BlockTypes#WET_SPONGE} will
     * become a {@link BlockTypes#SPONGE}. Additionally {@link FluidTypes#FLOWING_LAVA} will
     * spread faster and thinner.
     *
     * @return True if scorching, false if not
     */
    default boolean scorching() {
        return this.require(Keys.SCORCHING);
    }

    /**
     * Gets if the world type is considered natural.
     * <p>Natural worlds allow
     * sleeping in beds and setting the respawn point,
     * {@link BlockTypes#NETHER_PORTAL} portals to spawn {@link ZombifiedPiglin} and
     * {@link ItemTypes#COMPASS} to work</p>
     *
     * @return True if natural, false if not
     */
    default boolean natural() {
        return this.require(Keys.NATURAL_WORLD_TYPE);
    }

    /**
     * Gets the coordinate scale applied to the coordinates of a {@link ServerPlayer player}
     * traveling in a {@link ServerWorld world} of this type.
     * <p>
     * Best seen when transferring that player from one world to another (as the player's
     * coordinates will adjust to the scale of the destination world's).
     *
     * @return The scale
     */
    default double coordinateMultiplier() {
        return this.require(Keys.COORDINATE_MULTIPLIER);
    }

    /**
     * Gets if a {@link ServerWorld world} of this type will have global lighting, used
     * in game mechanics such as {@link Entity} spawning.
     * <p>In Vanilla, used in weather, lighting engine, and respawning mechanics</p>
     *
     * @return True if skylight, false if not
     */
    default boolean hasSkylight() {
        return this.require(Keys.HAS_SKYLIGHT);
    }

    /**
     * Gets if a {@link ServerWorld world} of this type is generated with a ceiling at some
     * pre-determined y value composed of {@link BlockTypes#BEDROCK}. Most notable usage of
     * this is for the {@link WorldTypes#THE_NETHER type}.
     *
     * <p>In Vanilla, used in weather, map items, and respawning mechanics</p>
     *
     * @return True if a ceiling is present, false if not
     */
    default boolean hasCeiling() {
        return this.require(Keys.HAS_CEILING);
    }

    /**
     * Gets the amount of lighting a client will play as an effect while traversing a
     * {@link ServerWorld world} of this type.
     *
     * <p>In Vanilla, the value will be between {@code 0.0} and {@code 1.0}</p>
     *
     * @return The lighting value
     */
    default float ambientLighting() {
        return this.require(Keys.AMBIENT_LIGHTING);
    }

    /**
     * Gets if a {@link ServerWorld world} of this type will be fixed at a particular
     * {@link MinecraftDayTime time} or flow naturally
     *
     * @return If present, a fixed day time. Otherwise, free flowing time
     */
    default Optional<MinecraftDayTime> fixedTime() {
        return this.get(Keys.FIXED_TIME);
    }

    /**
     * Gets if, when {@code False}, a {@link Piglin} will transform into a {@link ZombifiedPiglin},
     * over time, while existing in a {@link ServerWorld world} of this type.
     *
     * @return True if piglin are safe, false if they will zombify
     */
    default boolean piglinSafe() {
        return this.require(Keys.PIGLIN_SAFE);
    }

    /**
     * Gets if {@link ServerPlayer players} can sleep in a bed while existing in a
     * {@link ServerWorld world} of this type.
     * <p>When bed usage is not allowed beds will instead explode.</p>
     *
     * @return True if beds are usable, false if not
     */
    default boolean bedsUsable() {
        return this.require(Keys.BEDS_USABLE);
    }

    /**
     * Gets if {@link ServerPlayer players} can charge and use {@link BlockTypes#RESPAWN_ANCHOR}
     * while existing in a {@link ServerWorld world} of this type.
     *
     * @return True if respawn anchors are usable, false if not
     */
    default boolean respawnAnchorsUsable() {
        return this.require(Keys.RESPAWN_ANCHOR_USABLE);
    }

    /**
     * Gets if {@link ServerPlayer players} who have the {@link PotionEffectTypes#BAD_OMEN} effect
     * could cause a {@link Raid} while existing in a {@link ServerWorld world} of this type.
     *
     * @return True if bad omens could case a raid, false if not
     */
    default boolean hasRaids() {
        return this.require(Keys.HAS_RAIDS);
    }

    /**
     * Gets the minimum {@code Y} value that blocks can exist within a world of this type.
     * <p>In vanilla this is a multiple of 16 between -2032 and 2016</p>
     *
     * @return The minimum height
     */
    default int floor() {
        return this.require(Keys.WORLD_FLOOR);
    }

    /**
     * Gets the total height in which blocks can exist within a world of this type.
     * <p>In vanilla this is a multiple of 16 between 16 and 4064. {@link #floor()} + {@link #height()} may not be more than 2032</p>
     *
     * @return The maximum height
     */
    default int height() {
        return this.require(Keys.WORLD_HEIGHT);
    }

    /**
     * Gets the maximum height that teleportation logic performed via
     * {@link ItemTypes#CHORUS_FRUIT} or {@link PortalLogic portal types} may use to determine
     * the exit {@link ServerLocation location} of the teleport or the generation of a portal
     * itself.
     *
     * @return The logical height
     */
    default int logicalHeight() {
        return this.require(Keys.WORLD_LOGICAL_HEIGHT);
    }

    /**
     * Gets the tag for blocks that burn indefinitely in a world of this type.
     *
     * @return The infiniburn tag
     */
    default Tag<BlockType> infiniburn() {
        return this.require(Keys.INFINIBURN);
    }

    /**
     * Gets if {@link ServerWorld worlds} of this type will spawn the {@link EnderDragon dragon}
     * fight mechanics.
     *
     * @return True if dragon fight spawns, false if not
     */
    default boolean createDragonFight() {
        return this.require(Keys.CREATE_DRAGON_FIGHT);
    }

    /**
     * Returns the light level needed to block monster spawning.
     *
     * @return spawn light limit
     */
    default int spawnLightLimit() {
        return this.require(Keys.SPAWN_LIGHT_LIMIT);
    }

    /**
     * Returns the light level range needed to block monster spawning.
     *
     * @return the spawn light range
     */
    default Range<Integer> spawnLightRange() {
        return this.require(Keys.SPAWN_LIGHT_RANGE);
    }
}
