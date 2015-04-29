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
package org.spongepowered.api.data.props;

import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.Prop;
import org.spongepowered.api.data.marker.BlockTypeData;
import org.spongepowered.api.data.marker.GameData;
import org.spongepowered.api.data.types.BigMushroomType;
import org.spongepowered.api.data.types.BrickType;
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
import org.spongepowered.api.util.Axis;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.rotation.Rotation;

import java.util.List;

public class Props {
    private Props() {}

    // Block props

    // TODO missing Dyeable?
    // TODO missing Rotation
    // TODO missing Wet
    // TODO missing base manipulators in data.manipulators.*

    //naming: IS_ATTACHED or ATTACHED
    /**
     * Signifies that a block is "attached" or "hanging" on another block.
     * Usually applicable for {@link BlockTypes#TRIPWIRE}.
     */
    public static final Prop<Boolean, GameData> IS_ATTACHED = null;

    /**
     * Signifies that a block relies on {@link Axis}.
     */
    public static final Prop<Axis, GameData> AXIS = null;

    /**
     * Represents data related to {@link BlockTypes#BROWN_MUSHROOM_BLOCK} and
     * {@link BlockTypes#RED_MUSHROOM_BLOCK}.
     */
    public static final Prop<BigMushroomType, BlockTypeData> BIG_MUSHROOM_TYPE = null;

    /**
     * Represents the type of {@link BrickType} for a
     * {@link BlockTypes#STONEBRICK}.
     */
    public static final Prop<BrickType, BlockTypeData> BRICK_TYPE = null;

    /**
     * Represents the type of {@link Comparison} for a
     * {@link BlockTypes#POWERED_COMPARATOR} or {@link BlockTypes#UNPOWERED_COMPARATOR}.
     */
    public static final Prop<Comparison, BlockTypeData> COMPARISON_TYPE = null;

    // TODO list props?
    /**
     * Signifies that a block is "connected" to a particular {@link Direction}.
     * Usually applies to {@link BlockTypes#GLASS_PANE},
     * {@link BlockTypes#STAINED_GLASS_PANE}, and several others.
     */
    public static final Prop<List<Direction>, GameData> CONNECTED_DIRECTIONS = null;

    /**
     * Signifies that a block will "decay" or be removed after a certain time.
     * Usually applicable to {@link BlockTypes#LEAVES} and
     * {@link BlockTypes#LEAVES2}.
     */
    public static final Prop<Boolean, GameData> IS_DECAYABLE = null;

    // naming
    /**
     * Signifies that a block has a {@link Direction}. Usually applies
     * to "rotational" blocks, such as {@link BlockTypes#LOG} and
     * {@link BlockTypes#LOG2} etc.
     */
    public static final Prop<Direction, GameData> DIRECTION = null;

    /**
     * Represents the type of {@link DirtType} for a
     * {@link BlockTypes#DIRT} block.
     */
    public static final Prop<DirtType, BlockTypeData> DIRT_TYPE = null;

    /**
     * Signifies that a block is "disarmed". Usually applies to
     * {@link BlockTypes#TRIPWIRE_HOOK}s.
     */
    public static final Prop<Boolean, GameData> IS_DISARMED = null;

    /**
     * Represents the {@link DisguisedBlockType} of a block. Usually applies
     * to {@link BlockTypes#MONSTER_EGG}.
     */
    public static final Prop<DisguisedBlockType, BlockTypeData> DISGUISED_BLOCK_TYPE = null;

    /**
     * Represents the type of a {@link BlockTypes#DOUBLE_PLANT}.
     */
    public static final Prop<DoubleSizePlantType, BlockTypeData> DOUBLE_PLANT_TYPE = null;

    /**
     * Signifies whether the block is "extended". Usually applicable to
     * {@link BlockTypes#PISTON}.
     */
    public static final Prop<Boolean, GameData> IS_EXTENDED = null;

    /**
     * Signifies that the owner is "filled". Usually applicable to
     * {@link BlockTypes#END_PORTAL_FRAME}.
     */
    public static final Prop<Boolean, GameData> IS_FILLED = null;

    /**
     * Represents the "fluid level" for a liquid block. Usually applicable
     * to {@link BlockTypes#WATER} and {@link BlockTypes#LAVA}
     */
    public static final Prop<Integer, GameData> FLUID_LEVEL = null;

    // TODO has bounds
    /**
     * Represents the "growth" of a block. Usually applicable to
     * {@link BlockTypes#WHEAT}, {@link BlockTypes#PUMPKIN_STEM}, etc.
     */
    public static final Prop<Integer, GameData> GROWTH_STAGE = null;

    // naming
    /**
     * Represents the "side" that a "hinge" is facing on a door. Usually
     * applicable to {@link BlockTypes#TRAPDOOR} and other doors.
     */
    public static final Prop<Hinge, GameData> HINGE = null;

    /**
     * Represents the {@link InstrumentType}. Usually applicable to
     * {@link BlockTypes#NOTEBLOCK}.
     */
    public static final Prop<InstrumentType, BlockTypeData> INSTRUMENT_TYPE = null;

    /**
     * Signifies that the owner is "connected" to a wall. Usually applicable to
     * {@link BlockTypes#FENCE_GATE}.
     */
    public static final Prop<Boolean, GameData> IS_IN_WALL = null;

    /**
     * Represents the "layer" of an owner. Usually applicable to
     * {@link BlockTypes#CAKE}, {@link BlockTypes#SNOW_LAYER}, etc.
     */
    public static final Prop<Integer, GameData> LAYER = null;

    /**
     * Represents the "moisture" level of a block. Usually applicable to
     * {@link BlockTypes#FARMLAND}.
     */
    public static final Prop<Integer, GameData> MOISTURE = null;

    // WILL_NOT_DROP? Depends on default
    /**
     * Signifies that the owner will drop something. Usually applicable
     * to {@link BlockTypes#SKULL}.
     */
    public static final Prop<Boolean, GameData> WILL_DROP = null;

    /**
     * Signifies that a block is considered "occupied". Usually applicable to
     * {@link BlockTypes#BED}.
     */
    public static final Prop<Boolean, GameData> IS_OCCUPIED = null;

    /**
     * Signifies that a block is "open". Usually applies to all doors.
     */
    public static final Prop<Boolean, GameData> IS_OPEN = null;

    /**
     * Represents the {@link PistonType} of a {@link BlockTypes#PISTON_HEAD}.
     */
    public static final Prop<PistonType, BlockTypeData> PISTON_TYPE = null;

    /**
     * Represents the "portion" of a block such as the top or bottom half of a
     * door. Usually applies to all {@link BlockTypes#ACACIA_DOOR}, {@link BlockTypes#BIRCH_DOOR},
     * and other doors.
     */
    public static final Prop<PortionType, GameData> PORTION = null;

    /**
     * Signifies that a block is "powered".
     */
    public static final Prop<Boolean, GameData> IS_POWERED = null;

    /**
     * Represents the {@link PrismarineType} of a
     * {@link BlockTypes#PRISMARINE}.
     */
    public static final Prop<PrismarineType, GameData> PRISMARINE_TYPE = null;

    /**
     * Represents the {@link QuartzType} of a
     * {@link BlockTypes#QUARTZ_BLOCK}.
     */
    public static final Prop<QuartzType, GameData> QUARTZ_TYPE = null;

    /**
     * Represents the {@link RailDirection} of a {@link BlockTypes#RAIL} and
     * other types of rails.
     */
    public static final Prop<RailDirection, GameData> RAIL_DIRECTION = null;

    // Also "Powered"?
    /**
     * Signifies that a block has some value of redstone power applied to it.
     * Usually applicable for all blocks.
     */
    public static final Prop<Integer, GameData> REDSTONE_POWERED = null;

    /**
     * Signifies that a block is rotated with a {@link Rotation}.
     */
    public static final Prop<SandType, BlockTypeData> SAND_TYPE = null;

    /**
     * Represents the {@link SandstoneType} of a sandstone based block. Usually
     * applicable to {@link BlockTypes#SANDSTONE} and
     * {@link BlockTypes#RED_SANDSTONE}.
     */
    public static final Prop<SandstoneType, BlockTypeData> SANDSTONE_TYPE = null;

    /**
     * Signifies that a block is "seamless". Usually applicable to
     * {@link BlockTypes#DOUBLE_STONE_SLAB},
     * {@link BlockTypes#DOUBLE_STONE_SLAB2},
     * and {@link BlockTypes#DOUBLE_WOODEN_SLAB}.
     */
    public static final Prop<Boolean, GameData> IS_SEAMLESS = null;

    /**
     * Represents the {@link ShrubType} of a {@link BlockTypes#TALLGRASS}.
     */
    public static final Prop<ShrubType, BlockTypeData> SHRUB_TYPE = null;

    /**
     * Represents the signal strength of some redstone blocks, like {@link BlockTypes#DAYLIGHT_DETECTOR}.
     */
    public static final Prop<Integer, GameData> SIGNAL_OUTPUT = null;

    /**
     * Represents the {@link SlabType} of slabs.
     */
    public static final Prop<SlabType, BlockTypeData> SLAB_TYPE = null;

    // IS_SNOWED?
    /**
     * Signifies that a block is considered to be "snowed. Usually applicable
     * to {@link BlockTypes#GRASS}, {@link BlockTypes#DIRT}, and
     * {@link BlockTypes#MYCELIUM}.
     */
    public static final Prop<Boolean, GameData> HAS_SNOW = null;

    /**
     * Represents the {@link StairShape} of a stair block.
     */
    public static final Prop<StairShape, GameData> STAIR_SHAPE = null;

    /**
     * Represents the {@link StoneType} of a {@link BlockTypes#STONE}.
     */
    public static final Prop<StoneType, BlockTypeData> STONE_TYPE = null;

    /**
     * Signifies that a block is "suspended". Usually applicable to
     * {@link BlockTypes#TRIPWIRE} and {@link BlockTypes#TRIPWIRE_HOOK}.
     */
    public static final Prop<Boolean, GameData> IS_SUSPENDED = null;

    /**
     * Represents the {@link TreeType} for various tree based blocks. Usually
     * applicable to {@link BlockTypes#SAPLING}, {@link BlockTypes#LEAVES},
     * and {@link BlockTypes#LOG}.
     */
    public static final Prop<TreeType, BlockTypeData> TREE_TYPE = null;

    /**
     * Represents the {@link WallType} of a
     * {@link BlockTypes#COBBLESTONE_WALL}.
     */
    public static final Prop<WallType, BlockTypeData> WALL_TYPE = null;

}
