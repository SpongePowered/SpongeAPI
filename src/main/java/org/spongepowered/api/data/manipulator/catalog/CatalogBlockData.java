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
package org.spongepowered.api.data.manipulator.catalog;

import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.data.manipulator.DyeableData;
import org.spongepowered.api.data.manipulator.RotationalData;
import org.spongepowered.api.data.manipulator.WetData;
import org.spongepowered.api.data.manipulator.block.AttachedData;
import org.spongepowered.api.data.manipulator.block.AxisData;
import org.spongepowered.api.data.manipulator.block.BigMushroomData;
import org.spongepowered.api.data.manipulator.block.BrickData;
import org.spongepowered.api.data.manipulator.block.ConnectedDirectionData;
import org.spongepowered.api.data.manipulator.block.DecayableData;
import org.spongepowered.api.data.manipulator.block.DirectionalData;
import org.spongepowered.api.data.manipulator.block.DirtData;
import org.spongepowered.api.data.manipulator.block.DisarmedData;
import org.spongepowered.api.data.manipulator.block.DisguisedBlockData;
import org.spongepowered.api.data.manipulator.block.DoublePlantData;
import org.spongepowered.api.data.manipulator.block.ExtendedData;
import org.spongepowered.api.data.manipulator.block.FilledData;
import org.spongepowered.api.data.manipulator.block.FluidLevelData;
import org.spongepowered.api.data.manipulator.block.GrowthData;
import org.spongepowered.api.data.manipulator.block.HingeData;
import org.spongepowered.api.data.manipulator.block.InWallData;
import org.spongepowered.api.data.manipulator.block.InstrumentData;
import org.spongepowered.api.data.manipulator.block.LayeredData;
import org.spongepowered.api.data.manipulator.block.MoistureData;
import org.spongepowered.api.data.manipulator.block.NoDropData;
import org.spongepowered.api.data.manipulator.block.OccupiedData;
import org.spongepowered.api.data.manipulator.block.OpenData;
import org.spongepowered.api.data.manipulator.block.PistonData;
import org.spongepowered.api.data.manipulator.block.PortionData;
import org.spongepowered.api.data.manipulator.block.PoweredData;
import org.spongepowered.api.data.manipulator.block.PrismarineData;
import org.spongepowered.api.data.manipulator.block.QuartzData;
import org.spongepowered.api.data.manipulator.block.RailDirectionData;
import org.spongepowered.api.data.manipulator.block.RedstonePoweredData;
import org.spongepowered.api.data.manipulator.block.SandData;
import org.spongepowered.api.data.manipulator.block.SandstoneData;
import org.spongepowered.api.data.manipulator.block.SeamlessData;
import org.spongepowered.api.data.manipulator.block.ShrubData;
import org.spongepowered.api.data.manipulator.block.SlabData;
import org.spongepowered.api.data.manipulator.block.SnowedData;
import org.spongepowered.api.data.manipulator.block.StairShapeData;
import org.spongepowered.api.data.manipulator.block.StoneData;
import org.spongepowered.api.data.manipulator.block.SuspendedData;
import org.spongepowered.api.data.manipulator.block.TreeData;
import org.spongepowered.api.data.manipulator.block.WallData;
import org.spongepowered.api.data.type.BrickType;
import org.spongepowered.api.data.type.DisguisedBlockType;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.type.InstrumentType;
import org.spongepowered.api.data.type.PistonType;
import org.spongepowered.api.data.type.PrismarineType;
import org.spongepowered.api.data.type.QuartzType;
import org.spongepowered.api.data.type.RailDirection;
import org.spongepowered.api.data.type.SandType;
import org.spongepowered.api.data.type.SandstoneType;
import org.spongepowered.api.data.type.ShrubType;
import org.spongepowered.api.data.type.SlabType;
import org.spongepowered.api.data.type.StairShape;
import org.spongepowered.api.data.type.StoneType;
import org.spongepowered.api.data.type.TreeType;
import org.spongepowered.api.data.type.WallType;
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
     * Represents data related to {@link BlockTypes#BROWN_MUSHROOM_BLOCK} and
     * {@link BlockTypes#RED_MUSHROOM_BLOCK}.
     */
    public static final Class<BigMushroomData> BIG_MUSHROOM_DATA = BigMushroomData.class;
    /**
     * Represents the type of {@link BrickType} for a
     * {@link BlockTypes#STONEBRICK}.
     */
    public static final Class<BrickData> BRICK_DATA = BrickData.class;
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
     * Signifies that a block is "disarmed". Usually applies to
     * {@link BlockTypes#TRIPWIRE_HOOK}s.
     */
    public static final Class<DisarmedData> DISARMED_DATA = DisarmedData.class;
    /**
     * Represents the {@link DisguisedBlockType} of a block. Usually applies
     * to {@link BlockTypes#MONSTER_EGG}.
     */
    public static final Class<DisguisedBlockData> DISGUISED_BLOCK_DATA = DisguisedBlockData.class;
    /**
     * Represents the type of a double plant.
     */
    public static final Class<DoublePlantData> DOUBLE_PLANT_DATA = DoublePlantData.class;
    /**
     * Signifies that a block is "dyed" a certain {@link DyeColor}.
     * Usually applies to {@link BlockTypes#WOOL},
     * {@link BlockTypes#STAINED_GLASS},
     * {@link BlockTypes#STAINED_HARDENED_CLAY}, etc.
     */
    public static final Class<DyeableData> DYEABLE_DATA = DyeableData.class;
    /**
     * Signifies whether the block is "extended". Usually applicable to
     * {@link BlockTypes#PISTON}.
     */
    public static final Class<ExtendedData> EXTENDED_DATA = ExtendedData.class;
    /**
     * Signifies that the owner is "filled". Usually applicable to
     * {@link BlockTypes#END_PORTAL_FRAME}.
     */
    public static final Class<FilledData> FILLED_DATA = FilledData.class;
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
     * Represents the {@link InstrumentType}. Usually applicable to
     * {@link BlockTypes#NOTEBLOCK}.
     */
    public static final Class<InstrumentData> INSTRUMENT_DATA = InstrumentData.class;
    /**
     * Signifies that the owner is "connected" to a wall. Usually applicable to
     * {@link BlockTypes#FENCE_GATE}.
     */
    public static final Class<InWallData> IN_WALL_DATA = InWallData.class;
    /**
     * Represents the "layer" of an owner. Usually applicable to
     * {@link BlockTypes#CAKE}, {@link BlockTypes#SNOW_LAYER}, etc.
     */
    public static final Class<LayeredData> LAYERED_DATA = LayeredData.class;
    /**
     * Represents the "moisture" level of a block. Usually applicable to
     * {@link BlockTypes#FARMLAND}.
     */
    public static final Class<MoistureData> MOISTURE_DATA = MoistureData.class;
    /**
     * Signifies that the owner will not drop anything. Usually applicable
     * to {@link BlockTypes#SKULL}.
     */
    public static final Class<NoDropData> NO_DROP_DATA = NoDropData.class;
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
     * Represents the {@link PistonType} of a {@link BlockTypes#PISTON_HEAD}.
     */
    public static final Class<PistonData> PISTON_DATA = PistonData.class;
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
     * Represents the {@link SandType} of {@link BlockTypes#SAND}.
     */
    public static final Class<SandData> SAND_DATA = SandData.class;
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
     * Represents the {@link ShrubType} of a {@link BlockTypes#TALLGRASS}.
     */
    public static final Class<ShrubData> SHRUB_DATA = ShrubData.class;
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
