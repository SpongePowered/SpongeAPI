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
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.Exp;
import org.spongepowered.api.data.marker.*;
import org.spongepowered.api.data.types.Art;
import org.spongepowered.api.data.types.BigMushroomType;
import org.spongepowered.api.data.types.BrickType;
import org.spongepowered.api.data.types.Career;
import org.spongepowered.api.data.types.Comparison;
import org.spongepowered.api.data.types.DirtType;
import org.spongepowered.api.data.types.DisguisedBlockType;
import org.spongepowered.api.data.types.DoubleSizePlantType;
import org.spongepowered.api.data.types.Hinge;
import org.spongepowered.api.data.types.InstrumentType;
import org.spongepowered.api.data.types.PistonType;
import org.spongepowered.api.data.types.PortionType;
import org.spongepowered.api.data.types.PrismarineType;
import org.spongepowered.api.data.types.QuartzType;
import org.spongepowered.api.data.types.RailDirection;
import org.spongepowered.api.data.types.SandType;
import org.spongepowered.api.data.types.SandstoneType;
import org.spongepowered.api.data.types.ShrubType;
import org.spongepowered.api.data.types.SlabType;
import org.spongepowered.api.data.types.StairShape;
import org.spongepowered.api.data.types.StoneType;
import org.spongepowered.api.data.types.TreeType;
import org.spongepowered.api.data.types.WallType;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.stats.achievement.Achievement;
import org.spongepowered.api.util.Axis;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.ban.Ban;
import org.spongepowered.api.util.rotation.Rotation;

import java.util.List;
import java.util.Set;

public class Values {
    private Values() {}

    // Block props

    // TODO missing Dyeable?
    // TODO missing Rotation
    // TODO missing Wet
    // TODO missing base manipulators in data.manipulators.*

    /**
     * Signifies that a block is "attached" or "hanging" on another block.
     * Usually applicable for {@link BlockTypes#TRIPWIRE}.
     */
    public static final Value<Boolean, GameData> IS_ATTACHED = null;

    /**
     * Signifies that a block relies on {@link Axis}.
     */
    public static final Value<Axis, GameData> AXIS = null;

    /**
     * Represents data related to {@link BlockTypes#BROWN_MUSHROOM_BLOCK} and
     * {@link BlockTypes#RED_MUSHROOM_BLOCK}.
     */
    public static final Value<BigMushroomType, BlockTypeData> BIG_MUSHROOM_TYPE = null;

    /**
     * Represents the type of {@link BrickType} for a
     * {@link BlockTypes#STONEBRICK}.
     */
    public static final Value<BrickType, BlockTypeData> BRICK_TYPE = null;

    /**
     * Represents the type of {@link Comparison} for a
     * {@link BlockTypes#POWERED_COMPARATOR} or {@link BlockTypes#UNPOWERED_COMPARATOR}.
     */
    public static final Value<Comparison, BlockTypeData> COMPARISON_TYPE = null;

    // TODO list props?
    /**
     * Signifies that a block is "connected" to a particular {@link Direction}.
     * Usually applies to {@link BlockTypes#GLASS_PANE},
     * {@link BlockTypes#STAINED_GLASS_PANE}, and several others.
     */
    public static final Value<List<Direction>, GameData> CONNECTED_DIRECTIONS = null;

    /**
     * Signifies that a block will "decay" or be removed after a certain time.
     * Usually applicable to {@link BlockTypes#LEAVES} and
     * {@link BlockTypes#LEAVES2}.
     */
    public static final Value<Boolean, GameData> IS_DECAYABLE = null;

    // naming
    /**
     * Signifies that a block has a {@link Direction}. Usually applies
     * to "rotational" blocks, such as {@link BlockTypes#LOG} and
     * {@link BlockTypes#LOG2} etc.
     */
    public static final Value<Direction, GameData> DIRECTION = null;

    /**
     * Represents the type of {@link DirtType} for a
     * {@link BlockTypes#DIRT} block.
     */
    public static final Value<DirtType, BlockTypeData> DIRT_TYPE = null;

    /**
     * Signifies that a block is "disarmed". Usually applies to
     * {@link BlockTypes#TRIPWIRE_HOOK}s.
     */
    public static final Value<Boolean, GameData> IS_DISARMED = null;

    /**
     * Represents the {@link DisguisedBlockType} of a block. Usually applies
     * to {@link BlockTypes#MONSTER_EGG}.
     */
    public static final Value<DisguisedBlockType, BlockTypeData> DISGUISED_BLOCK_TYPE = null;

    /**
     * Represents the type of a {@link BlockTypes#DOUBLE_PLANT}.
     */
    public static final Value<DoubleSizePlantType, BlockTypeData> DOUBLE_PLANT_TYPE = null;

    /**
     * Signifies whether the block is "extended". Usually applicable to
     * {@link BlockTypes#PISTON}.
     */
    public static final Value<Boolean, GameData> IS_EXTENDED = null;

    /**
     * Signifies that the owner is "filled". Usually applicable to
     * {@link BlockTypes#END_PORTAL_FRAME}.
     */
    public static final Value<Boolean, GameData> IS_FILLED = null;

    /**
     * Represents the "fluid level" for a liquid block. Usually applicable
     * to {@link BlockTypes#WATER} and {@link BlockTypes#LAVA}
     */
    public static final BoundedValue<Integer, GameData> FLUID_LEVEL = null;

    /**
     * Represents the "growth" of a block. Usually applicable to
     * {@link BlockTypes#WHEAT}, {@link BlockTypes#PUMPKIN_STEM}, etc.
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

    public static final Value<Set<Achievement>, AchievementData> ACHIEVEMENTS = null;

    public static final BoundedValue<Integer, AgeData> AGE = null;

    // TODO there are other ways to do this, but this is simplest
    public static final Value<Boolean, AgeData> IS_ADULT = null;
    public static final Value<Boolean, AgeData> IS_BABY = null;

    public static final Value<Boolean, GameData> AGGRESSIVE = null;

    public static final BoundedValue<Integer, GameData> ANGER_LEVEL = null;

    public static final Value<Art, ArtData> ART = null;

    public static final Value<Set<Ban.User>, BanData> BANS = null;

    public static final Value<Vector3d, PartRotationData> HEAD_ROTATION = null;

    public static final Value<Vector3d, PartRotationData> BODY_ROTATION = null;

    public static final Value<Vector3d, PartRotationData> LEFT_ARM_ROTATION = null;

    public static final Value<Vector3d, PartRotationData> RIGHT_ARM_ROTATION = null;

    public static final Value<Vector3d, PartRotationData> LEFT_LEG_ROTATION = null;

    public static final Value<Vector3d, PartRotationData> RIGHT_LEG_ROTATION = null;

    public static final Value<Integer, BreathingData> REMAINING_AIR = null;

    public static final Value<Integer, BreathingData> MAX_AIR = null;

    // TODO name, READY_TO_BREED ?
    public static final Value<Boolean, GameData> CAN_BREED = null;

    public static final Value<Career, GameData> CAREER = null;

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

}
