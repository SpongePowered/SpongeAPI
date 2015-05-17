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
package org.spongepowered.api.data.value;

import com.flowpowered.math.vector.Vector3d;
import com.google.common.base.Optional;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.Exp;
import org.spongepowered.api.data.marker.AchievementData;
import org.spongepowered.api.data.marker.AgeData;
import org.spongepowered.api.data.marker.ArtData;
import org.spongepowered.api.data.marker.BanData;
import org.spongepowered.api.data.marker.BlockTypeData;
import org.spongepowered.api.data.marker.BreathingData;
import org.spongepowered.api.data.marker.DamageableData;
import org.spongepowered.api.data.marker.DamagingData;
import org.spongepowered.api.data.marker.EntityTypeData;
import org.spongepowered.api.data.marker.ExperienceHolderData;
import org.spongepowered.api.data.marker.EyeLocationData;
import org.spongepowered.api.data.marker.FallingBlockData;
import org.spongepowered.api.data.marker.FoodData;
import org.spongepowered.api.data.marker.GameData;
import org.spongepowered.api.data.marker.HorseData;
import org.spongepowered.api.data.marker.IgniteableData;
import org.spongepowered.api.data.marker.InvisibilityData;
import org.spongepowered.api.data.marker.JoinData;
import org.spongepowered.api.data.marker.PartRotationData;
import org.spongepowered.api.data.marker.SizeData;
import org.spongepowered.api.data.marker.StatisticData;
import org.spongepowered.api.data.types.Art;
import org.spongepowered.api.data.types.BigMushroomType;
import org.spongepowered.api.data.types.BrickType;
import org.spongepowered.api.data.types.Career;
import org.spongepowered.api.data.types.Comparison;
import org.spongepowered.api.data.types.DirtType;
import org.spongepowered.api.data.types.DisguisedBlockType;
import org.spongepowered.api.data.types.DoubleSizePlantType;
import org.spongepowered.api.data.types.Hinge;
import org.spongepowered.api.data.types.HorseColor;
import org.spongepowered.api.data.types.HorseStyle;
import org.spongepowered.api.data.types.HorseVariant;
import org.spongepowered.api.data.types.InstrumentType;
import org.spongepowered.api.data.types.OcelotType;
import org.spongepowered.api.data.types.PistonType;
import org.spongepowered.api.data.types.PortionType;
import org.spongepowered.api.data.types.PrismarineType;
import org.spongepowered.api.data.types.QuartzType;
import org.spongepowered.api.data.types.RabbitType;
import org.spongepowered.api.data.types.RailDirection;
import org.spongepowered.api.data.types.SandType;
import org.spongepowered.api.data.types.SandstoneType;
import org.spongepowered.api.data.types.ShrubType;
import org.spongepowered.api.data.types.SkeletonType;
import org.spongepowered.api.data.types.SlabType;
import org.spongepowered.api.data.types.StairShape;
import org.spongepowered.api.data.types.StoneType;
import org.spongepowered.api.data.types.TreeType;
import org.spongepowered.api.data.types.WallType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.Tamer;
import org.spongepowered.api.entity.hanging.Painting;
import org.spongepowered.api.entity.living.*;
import org.spongepowered.api.entity.living.animal.Animal;
import org.spongepowered.api.entity.living.monster.Creeper;
import org.spongepowered.api.entity.living.monster.Zombie;
import org.spongepowered.api.entity.player.Player;
import org.spongepowered.api.entity.player.User;
import org.spongepowered.api.entity.player.gamemode.GameMode;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.merchant.TradeOffer;
import org.spongepowered.api.stats.Statistic;
import org.spongepowered.api.stats.achievement.Achievement;
import org.spongepowered.api.util.Axis;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.ban.Ban;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.world.Location;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class Values {
    private Values() {}

    // Block props

    // TODO missing Dyeable?
    // TODO missing Rotation
    // TODO missing Wet
    // TODO missing base manipulators in data.manipulators.*
    // TODO collection props

    /**
     * Represents whether a block that is "attached" or "hanging" on a block.
     *
     * <p>Mainly for {@link BlockTypes#TRIPWIRE}.</p>
     *
     * @see BlockTypes#TRIPWIRE
     */
    public static final Value<Boolean, GameData> IS_ATTACHED = null;

    /**
     * Represents the {@link Axis} that a block that is aligned upon.
     *
     * <p>Mainly for {@link BlockTypes#HAY_BLOCK}, {@link BlockTypes#LOG}, and {@link BlockTypes#LOG2}.</p>
     *
     * @see BlockTypes#HAY_BLOCK
     * @see BlockTypes#LOG
     * @see BlockTypes#LOG2
     */
    public static final Value<Axis, GameData> AXIS = null;

    /**
     * Represents the {@link Axis} that a block is aligned vertically to.
     * Can be {@link Axis#X} or {@link Axis#Z}.
     *
     * <p>Mainly for {@link BlockTypes#PORTAL}.</p>
     *
     * @see BlockTypes#PORTAL
     */
    public static final Value<Axis, GameData> VERTICAL_AXIS = null;

    /**
     * Represents the {@link BigMushroomType} of a block.
     *
     * <p>Mainly for big mushroom blocks, including
     * {@link BlockTypes#BROWN_MUSHROOM_BLOCK} and {@link BlockTypes#RED_MUSHROOM_BLOCK}</p>
     *
     * @see BlockTypes#BROWN_MUSHROOM_BLOCK
     * @see BlockTypes#RED_MUSHROOM_BLOCK
     */
    public static final Value<BigMushroomType, BlockTypeData> BIG_MUSHROOM_TYPE = null;

    /**
     * Represents the {@link BrickType} of a block.
     *
     * <p>Mainly for {@link BlockTypes#STONEBRICK}</p>
     *
     * @see BlockTypes#STONEBRICK
     */
    public static final Value<BrickType, BlockTypeData> BRICK_TYPE = null;

    /**
     * Represents the type of {@link Comparison} of a block.
     *
     * <p>Mainly for {@link BlockTypes#POWERED_COMPARATOR} and {@link BlockTypes#UNPOWERED_COMPARATOR}.</p>
     *
     * @see BlockTypes#POWERED_COMPARATOR
     * @see BlockTypes#UNPOWERED_COMPARATOR
     */
    public static final Value<Comparison, BlockTypeData> COMPARISON_TYPE = null;

    /**
     * Represents the {@link Direction}s a block is "connected" to.
     *
     * <p>Mainly for {@link BlockTypes#GLASS_PANE}, {@link BlockTypes#STAINED_GLASS_PANE}, and
     * {@link BlockTypes#IRON_BARS}.</p>
     *
     * @see BlockTypes#GLASS_PANE
     * @see BlockTypes#STAINED_GLASS_PANE
     * @see BlockTypes#IRON_BARS
     */
    public static final Value<List<Direction>, GameData> CONNECTED_DIRECTIONS = null;

    /**
     * Represents that a block will "decay" or be removed after a certain time.
     *
     * <p>Mainly for leaves, including {@link BlockTypes#LEAVES} and {@link BlockTypes#LEAVES2}.</p>
     *
     * @see BlockTypes#LEAVES
     * @see BlockTypes#LEAVES2
     */
    public static final Value<Boolean, GameData> IS_DECAYABLE = null;

    /**
     * Represents what {@link Direction} a block is facing.
     * The available directions can vary.
     *
     * <p>Mainly for "rotational" blocks, including {@link BlockTypes#DISPENSER} and
     * {@link BlockTypes#LOG2} etc.</p>
     *
     * @see BlockTypes#LOG
     * @see BlockTypes#LOG2
     */
    public static final Value<Direction, GameData> FACING = null;

    /**
     * Represents the {@link DirtType} for a block.
     *
     * <p>Mainly for {@link BlockTypes#DIRT}.</p>
     *
     * @see BlockTypes#DIRT
     */
    public static final Value<DirtType, BlockTypeData> DIRT_TYPE = null;

    /**
     * Represents that a block is "disarmed" and won't activate.
     *
     * <p>Mainly for {@link BlockTypes#TRIPWIRE_HOOK}s</p>
     *
     * @see BlockTypes#TRIPWIRE_HOOK
     */
    public static final Value<Boolean, GameData> IS_DISARMED = null;

    /**
     * Represents the {@link DisguisedBlockType} of a block.
     *
     * <p>Mainly for {@link BlockTypes#MONSTER_EGG}.</p>
     *
     * @see BlockTypes#MONSTER_EGG
     */
    public static final Value<DisguisedBlockType, BlockTypeData> DISGUISED_BLOCK_TYPE = null;

    /**
     * Represents the {@link DoubleSizePlantType} of a block.
     *
     * <p>Mainly for {@link BlockTypes#DOUBLE_PLANT}.</p>
     *
     * @see BlockTypes#DOUBLE_PLANT
     */
    public static final Value<DoubleSizePlantType, BlockTypeData> DOUBLE_PLANT_TYPE = null;

    /**
     * Represents whether a block is "extended" and takes up extra space.
     *
     * <p>Mainly for {@link BlockTypes#PISTON} or {@link BlockTypes#STICKY_PISTON}.</p>
     *
     * @see BlockTypes#PISTON
     * @see BlockTypes#STICKY_PISTON
     */
    public static final Value<Boolean, GameData> IS_EXTENDED = null;

    /**
     * Represents that a block is in its "filled" state.
     *
     * <p>Mainly for {@link BlockTypes#END_PORTAL_FRAME}.</p>
     *
     * @see BlockTypes#END_PORTAL_FRAME
     */
    public static final Value<Boolean, GameData> IS_FILLED = null;

    /**
     * Represents the "fluid level" or height of a liquid block.
     *
     * <p>Mainly for liquid blocks, like {@link BlockTypes#WATER}, {@link BlockTypes#FLOWING_WATER},
     * {@link BlockTypes#LAVA}, and {@link BlockTypes#FLOWING_LAVA}.</p>
     *
     * @see BlockTypes#WATER
     * @see BlockTypes#FLOWING_WATER
     * @see BlockTypes#LAVA
     * @see BlockTypes#FLOWING_LAVA
     */
    public static final BoundedValue<Integer, GameData> FLUID_LEVEL = null;

    /**
     * Represents the "growth" or "age" of a block.
     *
     * <p>Mainly for growable blocks, like {@link BlockTypes#SAPLING}, {@link BlockTypes#WHEAT},
     * {@link BlockTypes#CACTUS}, {@link BlockTypes#REEDS}, {@link BlockTypes#PUMPKIN_STEM},
     * {@link BlockTypes#NETHER_WART}, {@link BlockTypes#CARROTS}, or {@link BlockTypes#POTATOES}.</p>
     *
     * @see BlockTypes#SAPLING
     * @see BlockTypes#WHEAT
     * @see BlockTypes#CACTUS
     * @see BlockTypes#REEDS
     * @see BlockTypes#PUMPKIN_STEM
     * @see BlockTypes#NETHER_BRICK
     * @see BlockTypes#CARROTS
     * @see BlockTypes#POTATOES
     */
    public static final BoundedValue<Integer, GameData> GROWTH_STAGE = null;

    // naming
    /**
     * Represents the "side" that a "hinge" is facing on a door. Usually
     * applicable to {@link BlockTypes#TRAPDOOR} and other doors.
     */
    public static final Value<Hinge, GameData> HINGE = null;

    /**
     * Represents the {@link InstrumentType}. Usually applicable to
     * {@link BlockTypes#NOTEBLOCK}.
     */
    public static final Value<InstrumentType, BlockTypeData> INSTRUMENT_TYPE = null;

    /**
     * Signifies that the owner is "connected" to a wall. Usually applicable to
     * {@link BlockTypes#FENCE_GATE}.
     */
    public static final Value<Boolean, GameData> IS_IN_WALL = null;

    /**
     * Represents the "layer" of an owner. Usually applicable to
     * {@link BlockTypes#CAKE}, {@link BlockTypes#SNOW_LAYER}, etc.
     */
    public static final BoundedValue<Integer, GameData> LAYER = null;

    /**
     * Represents the "moisture" level of a block. Usually applicable to
     * {@link BlockTypes#FARMLAND}.
     */
    public static final BoundedValue<Integer, GameData> MOISTURE = null;

    // WILL_NOT_DROP? Depends on default
    /**
     * Signifies that the owner will drop something. Usually applicable
     * to {@link BlockTypes#SKULL}.
     */
    public static final Value<Boolean, GameData> WILL_DROP = null;

    /**
     * Signifies that a block is considered "occupied". Usually applicable to
     * {@link BlockTypes#BED}.
     */
    public static final Value<Boolean, GameData> IS_OCCUPIED = null;

    /**
     * Signifies that a block is "open". Usually applies to all doors.
     */
    public static final Value<Boolean, GameData> IS_OPEN = null;

    /**
     * Represents the {@link PistonType} of a {@link BlockTypes#PISTON_HEAD}.
     */
    public static final Value<PistonType, BlockTypeData> PISTON_TYPE = null;

    /**
     * Represents the "portion" of a block such as the top or bottom half of a
     * door. Usually applies to all {@link BlockTypes#ACACIA_DOOR}, {@link BlockTypes#BIRCH_DOOR},
     * and other doors.
     */
    public static final Value<PortionType, GameData> PORTION = null;

    /**
     * Signifies that a block is "powered".
     */
    public static final Value<Boolean, GameData> IS_POWERED = null;

    /**
     * Represents the {@link PrismarineType} of a
     * {@link BlockTypes#PRISMARINE}.
     */
    public static final Value<PrismarineType, GameData> PRISMARINE_TYPE = null;

    /**
     * Represents the {@link QuartzType} of a
     * {@link BlockTypes#QUARTZ_BLOCK}.
     */
    public static final Value<QuartzType, GameData> QUARTZ_TYPE = null;

    /**
     * Represents the {@link RailDirection} of a {@link BlockTypes#RAIL} and
     * other types of rails.
     */
    public static final Value<RailDirection, GameData> RAIL_DIRECTION = null;

    // Also "Powered"?
    /**
     * Signifies that a block has some value of redstone power applied to it.
     * Usually applicable for all blocks.
     */
    public static final BoundedValue<Integer, GameData> REDSTONE_POWERED = null;

    /**
     * Signifies that a block is rotated with a {@link Rotation}.
     */
    public static final Value<SandType, BlockTypeData> SAND_TYPE = null;

    /**
     * Represents the {@link SandstoneType} of a sandstone based block. Usually
     * applicable to {@link BlockTypes#SANDSTONE} and
     * {@link BlockTypes#RED_SANDSTONE}.
     */
    public static final Value<SandstoneType, BlockTypeData> SANDSTONE_TYPE = null;

    /**
     * Signifies that a block is "seamless". Usually applicable to
     * {@link BlockTypes#DOUBLE_STONE_SLAB},
     * {@link BlockTypes#DOUBLE_STONE_SLAB2},
     * and {@link BlockTypes#DOUBLE_WOODEN_SLAB}.
     */
    public static final Value<Boolean, GameData> IS_SEAMLESS = null;

    /**
     * Represents the {@link ShrubType} of a {@link BlockTypes#TALLGRASS}.
     */
    public static final Value<ShrubType, BlockTypeData> SHRUB_TYPE = null;

    /**
     * Represents the signal strength of some redstone blocks, like {@link BlockTypes#DAYLIGHT_DETECTOR}.
     */
    public static final BoundedValue<Integer, GameData> SIGNAL_OUTPUT = null;

    /**
     * Represents the {@link SlabType} of slabs.
     */
    public static final Value<SlabType, BlockTypeData> SLAB_TYPE = null;

    // IS_SNOWED?
    /**
     * Signifies that a block is considered to be "snowed. Usually applicable
     * to {@link BlockTypes#GRASS}, {@link BlockTypes#DIRT}, and
     * {@link BlockTypes#MYCELIUM}.
     */
    public static final Value<Boolean, GameData> HAS_SNOW = null;

    /**
     * Represents the {@link StairShape} of a stair block.
     */
    public static final Value<StairShape, GameData> STAIR_SHAPE = null;

    /**
     * Represents the {@link StoneType} of a {@link BlockTypes#STONE}.
     */
    public static final Value<StoneType, BlockTypeData> STONE_TYPE = null;

    /**
     * Signifies that a block is "suspended". Usually applicable to
     * {@link BlockTypes#TRIPWIRE} and {@link BlockTypes#TRIPWIRE_HOOK}.
     */
    public static final Value<Boolean, GameData> IS_SUSPENDED = null;

    /**
     * Represents the {@link TreeType} for various tree based blocks. Usually
     * applicable to {@link BlockTypes#SAPLING}, {@link BlockTypes#LEAVES},
     * and {@link BlockTypes#LOG}.
     */
    public static final Value<TreeType, BlockTypeData> TREE_TYPE = null;

    /**
     * Represents the {@link WallType} of a
     * {@link BlockTypes#COBBLESTONE_WALL}.
     */
    public static final Value<WallType, BlockTypeData> WALL_TYPE = null;

    /**
     * The {@link AchievementData} class that can be applied to
     * {@link Player}s.
     */
    public static final Value<Set<Achievement>, AchievementData> ACHIEVEMENTS = null;

    /**
     * Represents age determining whether an
     * {@link Entity} is a child or an adult. Always exists for
     * {@link Ageable} entities.
     */
    public static final BoundedValue<Integer, AgeData> AGE = null;

    // TODO there are other ways to do this, but this is simplest
    /**
     * Represents whether the {@link Entity} is an adult. Always exists for
     * {@link Ageable} entities.
     */
    public static final Value<Boolean, AgeData> IS_ADULT = null;

    /**
     * Represents whether the {@link Entity} is a baby. Always exists for
     * {@link Ageable} entities.
     */
    public static final Value<Boolean, AgeData> IS_BABY = null;

    /**
     * Checks whether the {@link Entity} has AI enabled.
     * Usually applicable to {@link Agent}s.
     */
    public static final Value<Boolean, GameData> AI_ENABLED = null;

    /**
     * Checks whether the {@link Entity} is currently aggressive.
     * Usually applicable to {@link Agent}s.
     */
    public static final Value<Boolean, GameData> IS_AGGRESSIVE = null;

    /**
     * The time for an {@link Agent} that is currently angry to calm down.
     */
    public static final BoundedValue<Boolean, GameData> IS_ANGRY = null;

    /**
     * Represents the time for an {@link Agent} that is currently angry to calm down.
     */
    public static final BoundedValue<Integer, GameData> ANGER_LEVEL = null;

    /**
     * Represents what piece of {@link Art} is being
     * displayed. It is applicable for {@link Painting} entities.
     */
    public static final Value<Art, ArtData> ART = null;

    // TODO attribute data

    /**
     * Represents the bans made, mostly for {@link User}s.
     */
    public static final Value<Set<Ban.User>, BanData> BANS = null;

    /**
     * Represents the head rotation of an entity. Usually
     * applicable to {@link Human}s and {@link ArmorStand}s.
     */
    public static final Value<Vector3d, PartRotationData> HEAD_ROTATION = null;

    /**
     * Represents the body rotation of an entity. Usually
     * applicable to {@link Human}s and {@link ArmorStand}s.
     */
    public static final Value<Vector3d, PartRotationData> BODY_ROTATION = null;

    /**
     * Represents the rotation of the left arm of an entity. Usually
     * applicable to {@link Human}s and {@link ArmorStand}s.
     */
    public static final Value<Vector3d, PartRotationData> LEFT_ARM_ROTATION = null;

    /**
     * Represents the rotation of the right arm of an entity. Usually
     * applicable to {@link Human}s and {@link ArmorStand}s.
     */
    public static final Value<Vector3d, PartRotationData> RIGHT_ARM_ROTATION = null;

    /**
     * Represents the rotation of the left leg of an entity. Usually
     * applicable to {@link Human}s and {@link ArmorStand}s.
     */
    public static final Value<Vector3d, PartRotationData> LEFT_LEG_ROTATION = null;

    /**
     * Represents the rotation of the right leg of an entity. Usually
     * applicable to {@link Human}s and {@link ArmorStand}s.
     */
    public static final Value<Vector3d, PartRotationData> RIGHT_LEG_ROTATION = null;

    /**
     * Represents the remaining 'bubbles' of air left for an {@link Entity}.
     * Usually applies to {@link Living} entities but not {@link Aquatic} entities.
     */
    public static final Value<Integer, BreathingData> REMAINING_AIR = null;

    /**
     * Represents the max air 'bubbles' of air left for an {@link Entity}.
     * Usually applies to {@link Living} entities but not {@link Aquatic} entities.
     */
    public static final Value<Integer, BreathingData> MAX_AIR = null;

    /**
     * Represents that something is ready to breed. Usually applies to
     * {@link Animal}s, or sometimes for {@link Zombie}s to call
     * reinforcements.
     */
    public static final Value<Boolean, GameData> CAN_BREED = null;

    /**
     * Represents the {@link Career} of something.
     *
     * <p>Mainly for {@link Villager}, to describe their available trades and appearance.</p>
     *
     * @see Villager
     */
    public static final Value<Career, GameData> CAREER = null;

    /**
     * Represents whether something is "charged".
     *
     * <p>Mainly for {@link Creeper}s, who are charged naturally when struck with lightning.</p>
     *
     * @see Creeper
     */
    public static final Value<Boolean, GameData> IS_CHARGED = null;

    // TODO called CriticalHitData
    public static final Value<Boolean, GameData> WILL_PERFORM_CRITICAL_HIT = null;

    public static final Value<Living, DamageableData> LAST_ATTACKER = null;

    public static final Value<Double, DamageableData> LAST_DAMAGE = null;

    public static final Value<Integer, DamageableData> INVLUNLERABILITY_TICKS = null;

    public static final Value<Integer, DamageableData> MAX_INVLUNLERABILITY_TICKS = null;

    public static final Value<Double, DamagingData> DAMAGE = null;

    // TODO could do capitals, but is bad style
    public static Value<Double, DamagingData> damageForEntity(EntityType type) {
        return null;
    }

    // TODO also IS_ELDER?
    public static final Value<Boolean, GameData> IS_ELDER_GUARDIAN = null;

    public static final Value<Exp, ExperienceHolderData> EXPERIENCE = null;

    public static final Value<Integer, GameData> EXPIRATION_TICKS = null;

    public static final Value<Integer, GameData> EXPLOSION_RADIUS = null;

    public static final GetterValue<Double, EyeLocationData> EYE_HEIGHT = null;

    public static final GetterValue<Double, EyeLocationData> EYE_LOCATION = null;

    public static final Value<Double, FallingBlockData> FALL_DAMAGE_PER_BLOCK = null;

    public static final Value<Double, FallingBlockData> MAX_FALL_DAMAGE = null;

    public static final Value<BlockState, FallingBlockData> BLOCK_STATE = null;

    public static final Value<Boolean, FallingBlockData> CAN_PLACE_AS_BLOCK = null;

    public static final Value<Double, FallingBlockData> CAN_DROP_AS_ITEM = null;

    public static final Value<Boolean, GameData> FLAMMABLE = null;

    public static final Value<Double, GameData> FLYING = null;

    public static final Value<Double, FoodData> EXHAUSTION = null;

    public static final Value<Double, FoodData> SATURATION = null;

    public static final Value<Double, FoodData> FOOD_LEVEL = null;

    public static final Value<Integer, GameData> FUSE_DURATION = null;

    public static final Value<GameMode, GameData> GAME_MODE = null;

    public static final Value<Boolean, GameData> IS_HEALING_SOURCE = null;

    public static final Value<Integer, GameData> HEALTH = null;

    public static final Value<Integer, GameData> MAX_HEALTH = null;

    public static final Value<HorseStyle, HorseData> HORSE_STYLE = null;

    public static final Value<HorseColor, HorseData> HORSE_COLOR = null;

    public static final Value<HorseVariant, HorseData> HORSE_VARIANT = null;

    public static final GetterValue<Integer, IgniteableData> FIRE_DELAY = null;

    public static final GetterValue<Integer, IgniteableData> FIRE_TICKS = null;

    public static Value<Boolean, InvisibilityData> invisibleTo(Player player) {
        return null;
    }

    public static final Value<Integer, GameData> INVLUNERABILE_TICKS = null;

    public static final Value<Boolean, JoinData> HAS_JOINED_BEFORE = null;

    public static final GetterValue<Date, JoinData> GET_FIRST_PLAYED = null;

    public static final GetterValue<Date, JoinData> GET_LAST_PLAYED = null;

    public static final Value<Integer, GameData> KNOCKBACK_STRENGTH = null;

    public static final Value<Optional<Entity>, GameData> LEASH_HOLDER = null;

    public static final Value<OcelotType, EntityTypeData> OCELOT_TYPE = null;

    public static final Value<Integer, GameData> ORB_EXPERIENCE = null;

    public static final Value<Entity, GameData> VEHICLE = null;

    public static final GetterValue<Entity, GameData> BASE_VEHICLE = null;

    public static final Value<Boolean, GameData> WILL_PERSIST = null;

    public static final Value<Boolean, GameData> IS_PLAYER_CREATED = null;

    public static final Value<Boolean, GameData> PLAYER_DATA = null;

    public static final Value<RabbitType, EntityTypeData> RABBIT_TYPE = null;

    public static final Value<Location, GameData> RESPAWN_LOCATION = null;

    public static final Value<ItemStack, GameData> SADDLE = null;

    // meh on IS_SCREAMING
    public static final Value<Boolean, GameData> IS_GRIMACING = null;

    public static final GetterValue<Boolean, GameData> WILL_SHATTER = null;

    public static final GetterValue<Boolean, GameData> IS_SHEARED = null;

    public static final GetterValue<Boolean, GameData> IS_SITTING = null;

    public static final GetterValue<Float, SizeData> BASE = null;

    public static final GetterValue<Float, SizeData> HEIGHT = null;

    public static final GetterValue<Float, SizeData> SCALE = null;

    public static final Value<SkeletonType, EntityTypeData> SKELETON_TYPE = null;

    public static final Value<Boolean, GameData> IS_SLEEPING = null;

    public static final Value<Integer, GameData> SLIME_SIZE = null;

    public static final Value<Boolean, GameData> IS_SNEAKING = null;

    public static Value<Long, StatisticData> statistic(Statistic statistic) {
        return null;
    }

    public static final Value<Tamer, GameData> OWNER = null;

    public static final Value<List<Living>, GameData> TARGETS = null;

    public static final Value<List<TradeOffer>, GameData> TRADE_OFFERS = null;

    public static final Value<Entity, GameData> PASSENGER = null;

    public static final GetterValue<Entity, GameData> TOP_PASSENGER = null;

    public static final Value<Vector3d, GameData> VELOCITY = null;

    public static final Value<Boolean, GameData> IS_VILLAGER_ZOMBIE = null;

    // TODO naming, ON_WHITELIST?
    public static final GetterValue<Boolean, GameData> IS_WHITELISTED = null;

}
