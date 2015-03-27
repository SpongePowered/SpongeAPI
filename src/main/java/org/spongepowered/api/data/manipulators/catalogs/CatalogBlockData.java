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

package org.spongepowered.api.data.manipulators.catalogs;

import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.manipulators.AttachedData;
import org.spongepowered.api.data.manipulators.AxisData;
import org.spongepowered.api.data.manipulators.ConnectedDirectionData;
import org.spongepowered.api.data.manipulators.DecayableData;
import org.spongepowered.api.data.manipulators.DirectionalData;
import org.spongepowered.api.data.manipulators.DirtData;
import org.spongepowered.api.data.manipulators.DisgusedBlockData;
import org.spongepowered.api.data.manipulators.DyeableData;
import org.spongepowered.api.data.manipulators.FluidLevelData;
import org.spongepowered.api.data.manipulators.GrowthData;
import org.spongepowered.api.data.manipulators.HingeData;
import org.spongepowered.api.data.manipulators.OccupiedData;
import org.spongepowered.api.data.manipulators.OpenData;
import org.spongepowered.api.data.manipulators.PortionData;
import org.spongepowered.api.data.manipulators.PoweredData;
import org.spongepowered.api.data.manipulators.PrismarineData;
import org.spongepowered.api.data.manipulators.QuartzData;
import org.spongepowered.api.data.manipulators.RailDirectionData;
import org.spongepowered.api.data.manipulators.RedstonePoweredData;
import org.spongepowered.api.data.manipulators.RotationalData;
import org.spongepowered.api.data.manipulators.SandstoneData;
import org.spongepowered.api.data.manipulators.SeamlessData;
import org.spongepowered.api.data.manipulators.SlabData;
import org.spongepowered.api.data.manipulators.SnowedData;
import org.spongepowered.api.data.manipulators.StairShapeData;
import org.spongepowered.api.data.manipulators.StoneData;
import org.spongepowered.api.data.manipulators.SuspendedData;
import org.spongepowered.api.data.manipulators.TreeData;
import org.spongepowered.api.data.manipulators.WallData;
import org.spongepowered.api.data.manipulators.WetData;
import org.spongepowered.api.data.types.DisgusedBlockType;
import org.spongepowered.api.data.types.DyeColor;
import org.spongepowered.api.data.types.PrismarineType;
import org.spongepowered.api.data.types.QuartzType;
import org.spongepowered.api.data.types.RailDirection;
import org.spongepowered.api.data.types.SandstoneType;
import org.spongepowered.api.data.types.SlabType;
import org.spongepowered.api.data.types.StairShape;
import org.spongepowered.api.data.types.StoneType;
import org.spongepowered.api.data.types.TreeType;
import org.spongepowered.api.data.types.WallType;
import org.spongepowered.api.util.Axis;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.rotation.Rotation;


/**
 * An enumeration of block related {@link DataManipulator}s.
 */
public final class CatalogBlockData {

    /**
     * Signifies that a block is "attached" or "hanging" on another block.
     * Usually applicable for {@link BlockTypes#TRIPWIRE}.
     */
    public static final Class<AttachedData> ATTACHED_DATA = AttachedData.class;
    /**
     * Signifies that a block relies on {@link Axis}.
     */
    public static final Class<AxisData> AXIS_DATA = AxisData.class;
    /**
     * Signifies that a block is "connected" to a particular {@link Direction}.
     * Usually applies to {@link BlockTypes#GLASS_PANE},
     * {@link BlockTypes#STAINED_GLASS_PANE}, and several others.
     */
    public static final Class<ConnectedDirectionData> CONNECTED_DIRECTION_DATA = ConnectedDirectionData.class;
    /**
     * Signifies that a block will "decay" or be removed after a certain time.
     * Usually applicable to {@link BlockTypes#LEAVES} and
     * {@link BlockTypes#LEAVES2}.
     */
    public static final Class<DecayableData> DECAYABLE_DATA = DecayableData.class;
    /**
     * Signifies that a block has a {@link Direction}. Usually applies
     * to "rotational" blocks, such as {@link BlockTypes#LOG} and
     * {@link BlockTypes#LOG2} etc.
     */
    public static final Class<DirectionalData> DIRECTIONAL_DATA = DirectionalData.class;
    /**
     * Signifies that a {@link BlockTypes#DIRT} of it's sub types.
     */
    public static final Class<DirtData> DIRT_DATA = DirtData.class;
    /**
     * Represents the {@link DisgusedBlockType} of a block. Usually applies
     * to {@link BlockTypes#MONSTER_EGG}.
     */
    public static final Class<DisgusedBlockData> DISGUSED_BLOCK_DATA = DisgusedBlockData.class;
    /**
     * Signifies that a block is "dyed" a certain {@link DyeColor}.
     * Usually applies to {@link BlockTypes#WOOL},
     * {@link BlockTypes#STAINED_GLASS},
     * {@link BlockTypes#STAINED_HARDENED_CLAY}, etc.
     */
    public static final Class<DyeableData> DYEABLE_DATA = DyeableData.class;
    /**
     * Represents the "fluid level" for a liquid block. Usually applicable
     * to {@link BlockTypes#WATER} and {@link BlockTypes#LAVA}
     */
    public static final Class<FluidLevelData> FLUID_LEVEL_DATA = FluidLevelData.class;
    /**
     * Represents the "growth" of a block. Usually applicable to
     * {@link BlockTypes#WHEAT}, {@link BlockTypes#PUMPKIN_STEM}, etc.
     */
    public static final Class<GrowthData> GROWTH_DATA = GrowthData.class;
    /**
     * Represents the "side" that a "hinge" is facing on a door. Usually
     * applicable to {@link BlockTypes#TRAPDOOR} and other doors.
     */
    public static final Class<HingeData> HINGE_DATA = HingeData.class;
    /**
     * Signifies that a block is considered "occupied". Usually applicable to
     * {@link BlockTypes#BED}.
     */
    public static final Class<OccupiedData> OCCUPIED_DATA = OccupiedData.class;
    /**
     * Signifies that a block is "open". Usually applies to all doors.
     */
    public static final Class<OpenData> OPEN_DATA = OpenData.class;
    /**
     * Represents the "portion" of a block such as the top or bottom half of a
     * door. Usually applies to all doors.
     */
    public static final Class<PortionData> PORTION_DATA = PortionData.class;
    /**
     * Signifies that a block is "powered".
     */
    public static final Class<PoweredData> POWERED_DATA = PoweredData.class;
    /**
     * Represents the {@link PrismarineType} of a
     * {@link BlockTypes#PRISMARINE}.
     */
    public static final Class<PrismarineData> PRISMARINE_DATA = PrismarineData.class;
    /**
     * Represents the {@link QuartzType} of a
     * {@link BlockTypes#QUARTZ_BLOCK}.
     */
    public static final Class<QuartzData> QUARTZ_DATA = QuartzData.class;
    /**
     * Represents the {@link RailDirection} of a {@link BlockTypes#RAIL} and
     * other types of rails.
     */
    public static final Class<RailDirectionData> RAIL_DIRECTION_DATA = RailDirectionData.class;
    /**
     * Signifies that a block has some value of redstone power applied to it.
     * Usually applicable for all blocks.
     */
    public static final Class<RedstonePoweredData> REDSTONE_POWERED_DATA = RedstonePoweredData.class;
    /**
     * Signifies that a block is rotated with a {@link Rotation}.
     */
    public static final Class<RotationalData> ROTATIONAL_DATA = RotationalData.class;
    /**
     * Represents the {@link SandstoneType} of a sandstone based block. Usually
     * applicable to {@link BlockTypes#SANDSTONE} and
     * {@link BlockTypes#RED_SANDSTONE}.
     */
    public static final Class<SandstoneData> SANDSTONE_DATA = SandstoneData.class;
    /**
     * Signifies that a block is "seamless". Usually applicable to
     * {@link BlockTypes#DOUBLE_STONE_SLAB},
     * {@link BlockTypes#DOUBLE_STONE_SLAB2},
     * and {@link BlockTypes#DOUBLE_WOODEN_SLAB}.
     */
    public static final Class<SeamlessData> SEAMLESS_DATA = SeamlessData.class;
    /**
     * Represents the {@link SlabType} of slabs.
     */
    public static final Class<SlabData> SLAB_DATA = SlabData.class;
    /**
     * Signifies that a block is considered to be "snowed. Usually applicable
     * to {@link BlockTypes#GRASS}, {@link BlockTypes#DIRT}, and
     * {@link BlockTypes#MYCELIUM}.
     */
    public static final Class<SnowedData> SNOWED_DATA = SnowedData.class;
    /**
     * Represents the {@link StairShape} of a stair block.
     */
    public static final Class<StairShapeData> STAIR_SHAPE_DATA = StairShapeData.class;
    /**
     * Represents the {@link StoneType} of a {@link BlockTypes#STONE}.
     */
    public static final Class<StoneData> STONE_DATA = StoneData.class;
    /**
     * Signifies that a block is "suspended". Usually applicable to
     * {@link BlockTypes#TRIPWIRE} and {@link BlockTypes#TRIPWIRE_HOOK}.
     */
    public static final Class<SuspendedData> SUSPENDED_DATA = SuspendedData.class;
    /**
     * Represents the {@link TreeType} for various tree based blocks. Usually
     * applicable to {@link BlockTypes#SAPLING}, {@link BlockTypes#LEAVES},
     * and {@link BlockTypes#LOG}.
     */
    public static final Class<TreeData> TREE_DATA = TreeData.class;
    /**
     * Represents the {@link WallType} of a
     * {@link BlockTypes#COBBLESTONE_WALL}.
     */
    public static final Class<WallData> WALL_DATA = WallData.class;
    /**
     * Signifies that a block is considered "wet". Usually applicable to
     * {@link BlockTypes#SPONGE}.
     */
    public static final Class<WetData> WET_DATA = WetData.class;

    private CatalogBlockData() {
    }

}
