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
package org.spongepowered.api.data.component.catalog;

import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.Component;
import org.spongepowered.api.data.component.base.DyeableComponent;
import org.spongepowered.api.data.component.base.RotationalComponent;
import org.spongepowered.api.data.component.base.WetComponent;
import org.spongepowered.api.data.component.block.AttachedComponent;
import org.spongepowered.api.data.component.block.AxisComponent;
import org.spongepowered.api.data.component.block.BigMushroomComponent;
import org.spongepowered.api.data.component.block.BrickComponent;
import org.spongepowered.api.data.component.block.ConnectedDirectionComponent;
import org.spongepowered.api.data.component.block.DecayableComponent;
import org.spongepowered.api.data.component.block.DirectionalComponent;
import org.spongepowered.api.data.component.block.DirtComponent;
import org.spongepowered.api.data.component.block.DisarmedComponent;
import org.spongepowered.api.data.component.block.DisguisedBlockComponent;
import org.spongepowered.api.data.component.block.DoublePlantComponent;
import org.spongepowered.api.data.component.block.ExtendedComponent;
import org.spongepowered.api.data.component.block.FilledComponent;
import org.spongepowered.api.data.component.block.FluidLevelComponent;
import org.spongepowered.api.data.component.block.GrowthComponent;
import org.spongepowered.api.data.component.block.HingeComponent;
import org.spongepowered.api.data.component.block.InWallComponent;
import org.spongepowered.api.data.component.block.InstrumentComponent;
import org.spongepowered.api.data.component.block.LayeredComponent;
import org.spongepowered.api.data.component.block.MoistureComponent;
import org.spongepowered.api.data.component.block.NoDropComponent;
import org.spongepowered.api.data.component.block.OccupiedComponent;
import org.spongepowered.api.data.component.block.OpenComponent;
import org.spongepowered.api.data.component.block.PistonComponent;
import org.spongepowered.api.data.component.block.PortionComponent;
import org.spongepowered.api.data.component.block.PoweredComponent;
import org.spongepowered.api.data.component.block.PrismarineComponent;
import org.spongepowered.api.data.component.block.QuartzComponent;
import org.spongepowered.api.data.component.block.RailDirectionComponent;
import org.spongepowered.api.data.component.block.RedstonePoweredComponent;
import org.spongepowered.api.data.component.block.SandComponent;
import org.spongepowered.api.data.component.block.SandstoneComponent;
import org.spongepowered.api.data.component.block.SeamlessComponent;
import org.spongepowered.api.data.component.block.ShrubComponent;
import org.spongepowered.api.data.component.block.SlabComponent;
import org.spongepowered.api.data.component.block.SnowedComponent;
import org.spongepowered.api.data.component.block.StairShapeComponent;
import org.spongepowered.api.data.component.block.StoneComponent;
import org.spongepowered.api.data.component.block.SuspendedComponent;
import org.spongepowered.api.data.component.block.TreeComponent;
import org.spongepowered.api.data.component.block.WallComponent;
import org.spongepowered.api.data.component.block.WireAttachmentComponent;
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
import org.spongepowered.api.data.type.WireAttachmentType;
import org.spongepowered.api.util.Axis;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.rotation.Rotation;

/**
 * An enumeration of block related {@link Component}s.
 */
public final class CatalogBlockData {

    /**
     * Signifies that a block is "attached" or "hanging" on another block.
     * Usually applicable for {@link BlockTypes#TRIPWIRE}.
     */
    public static final Class<AttachedComponent> ATTACHED_COMPONENT = AttachedComponent.class;
    /**
     * Signifies that a block relies on {@link Axis}.
     */
    public static final Class<AxisComponent> AXIS_COMPONENT = AxisComponent.class;
    /**
     * Represents data related to {@link BlockTypes#BROWN_MUSHROOM_BLOCK} and
     * {@link BlockTypes#RED_MUSHROOM_BLOCK}.
     */
    public static final Class<BigMushroomComponent> BIG_MUSHROOM_COMPONENT = BigMushroomComponent.class;
    /**
     * Represents the type of {@link BrickType} for a
     * {@link BlockTypes#STONEBRICK}.
     */
    public static final Class<BrickComponent> BRICK_COMPONENT = BrickComponent.class;
    /**
     * Signifies that a block is "connected" to a particular {@link Direction}.
     * Usually applies to {@link BlockTypes#GLASS_PANE},
     * {@link BlockTypes#STAINED_GLASS_PANE}, and several others.
     */
    public static final Class<ConnectedDirectionComponent> CONNECTED_DIRECTION_COMPONENT = ConnectedDirectionComponent.class;
    /**
     * Signifies that a block will "decay" or be removed after a certain time.
     * Usually applicable to {@link BlockTypes#LEAVES} and
     * {@link BlockTypes#LEAVES2}.
     */
    public static final Class<DecayableComponent> DECAYABLE_COMPONENT = DecayableComponent.class;
    /**
     * Signifies that a block has a {@link Direction}. Usually applies
     * to "rotational" blocks, such as {@link BlockTypes#LOG} and
     * {@link BlockTypes#LOG2} etc.
     */
    public static final Class<DirectionalComponent> DIRECTIONAL_COMPONENT = DirectionalComponent.class;
    /**
     * Signifies that a {@link BlockTypes#DIRT} of it's sub types.
     */
    public static final Class<DirtComponent> DIRT_COMPONENT = DirtComponent.class;
    /**
     * Signifies that a block is "disarmed". Usually applies to
     * {@link BlockTypes#TRIPWIRE_HOOK}s.
     */
    public static final Class<DisarmedComponent> DISARMED_COMPONENT = DisarmedComponent.class;
    /**
     * Represents the {@link DisguisedBlockType} of a block. Usually applies
     * to {@link BlockTypes#MONSTER_EGG}.
     */
    public static final Class<DisguisedBlockComponent> DISGUISED_BLOCK_COMPONENT = DisguisedBlockComponent.class;
    /**
     * Represents the type of a double plant.
     */
    public static final Class<DoublePlantComponent> DOUBLE_PLANT_COMPONENT = DoublePlantComponent.class;
    /**
     * Signifies that a block is "dyed" a certain {@link DyeColor}.
     * Usually applies to {@link BlockTypes#WOOL},
     * {@link BlockTypes#STAINED_GLASS},
     * {@link BlockTypes#STAINED_HARDENED_CLAY}, etc.
     */
    public static final Class<DyeableComponent> DYEABLE_COMPONENT = DyeableComponent.class;
    /**
     * Signifies whether the block is "extended". Usually applicable to
     * {@link BlockTypes#PISTON}.
     */
    public static final Class<ExtendedComponent> EXTENDED_COMPONENT = ExtendedComponent.class;
    /**
     * Signifies that the owner is "filled". Usually applicable to
     * {@link BlockTypes#END_PORTAL_FRAME}.
     */
    public static final Class<FilledComponent> FILLED_COMPONENT = FilledComponent.class;
    /**
     * Represents the "fluid level" for a liquid block. Usually applicable
     * to {@link BlockTypes#WATER} and {@link BlockTypes#LAVA}
     */
    public static final Class<FluidLevelComponent> FLUID_LEVEL_COMPONENT = FluidLevelComponent.class;
    /**
     * Represents the "growth" of a block. Usually applicable to
     * {@link BlockTypes#WHEAT}, {@link BlockTypes#PUMPKIN_STEM}, etc.
     */
    public static final Class<GrowthComponent> GROWTH_COMPONENT = GrowthComponent.class;
    /**
     * Represents the "side" that a "hinge" is facing on a door. Usually
     * applicable to {@link BlockTypes#TRAPDOOR} and other doors.
     */
    public static final Class<HingeComponent> HINGE_COMPONENT = HingeComponent.class;
    /**
     * Represents the {@link InstrumentType}. Usually applicable to
     * {@link BlockTypes#NOTEBLOCK}.
     */
    public static final Class<InstrumentComponent> INSTRUMENT_COMPONENT = InstrumentComponent.class;
    /**
     * Signifies that the owner is "connected" to a wall. Usually applicable to
     * {@link BlockTypes#FENCE_GATE}.
     */
    public static final Class<InWallComponent> IN_WALL_COMPONENT = InWallComponent.class;
    /**
     * Represents the "layer" of an owner. Usually applicable to
     * {@link BlockTypes#CAKE}, {@link BlockTypes#SNOW_LAYER}, etc.
     */
    public static final Class<LayeredComponent> LAYERED_COMPONENT = LayeredComponent.class;
    /**
     * Represents the "moisture" level of a block. Usually applicable to
     * {@link BlockTypes#FARMLAND}.
     */
    public static final Class<MoistureComponent> MOISTURE_COMPONENT = MoistureComponent.class;
    /**
     * Signifies that the owner will not drop anything. Usually applicable
     * to {@link BlockTypes#SKULL}.
     */
    public static final Class<NoDropComponent> NO_DROP_COMPONENT = NoDropComponent.class;
    /**
     * Signifies that a block is considered "occupied". Usually applicable to
     * {@link BlockTypes#BED}.
     */
    public static final Class<OccupiedComponent> OCCUPIED_COMPONENT = OccupiedComponent.class;
    /**
     * Signifies that a block is "open". Usually applies to all doors.
     */
    public static final Class<OpenComponent> OPEN_COMPONENT = OpenComponent.class;
    /**
     * Represents the {@link PistonType} of a {@link BlockTypes#PISTON_HEAD}.
     */
    public static final Class<PistonComponent> PISTON_COMPONENT = PistonComponent.class;
    /**
     * Represents the "portion" of a block such as the top or bottom half of a
     * door. Usually applies to all doors.
     */
    public static final Class<PortionComponent> PORTION_COMPONENT = PortionComponent.class;
    /**
     * Signifies that a block is "powered".
     */
    public static final Class<PoweredComponent> POWERED_COMPONENT = PoweredComponent.class;
    /**
     * Represents the {@link PrismarineType} of a
     * {@link BlockTypes#PRISMARINE}.
     */
    public static final Class<PrismarineComponent> PRISMARINE_COMPONENT = PrismarineComponent.class;
    /**
     * Represents the {@link QuartzType} of a
     * {@link BlockTypes#QUARTZ_BLOCK}.
     */
    public static final Class<QuartzComponent> QUARTZ_COMPONENT = QuartzComponent.class;
    /**
     * Represents the {@link RailDirection} of a {@link BlockTypes#RAIL} and
     * other types of rails.
     */
    public static final Class<RailDirectionComponent> RAIL_DIRECTION_COMPONENT = RailDirectionComponent.class;
    /**
     * Signifies that a block has some value of redstone power applied to it.
     * Usually applicable for all blocks.
     */
    public static final Class<RedstonePoweredComponent> REDSTONE_POWERED_COMPONENT = RedstonePoweredComponent.class;
    /**
     * Signifies that a block is rotated with a {@link Rotation}.
     */
    public static final Class<RotationalComponent> ROTATIONAL_COMPONENT = RotationalComponent.class;
    /**
     * Represents the {@link SandType} of {@link BlockTypes#SAND}.
     */
    public static final Class<SandComponent> SAND_COMPONENT = SandComponent.class;
    /**
     * Represents the {@link SandstoneType} of a sandstone based block. Usually
     * applicable to {@link BlockTypes#SANDSTONE} and
     * {@link BlockTypes#RED_SANDSTONE}.
     */
    public static final Class<SandstoneComponent> SANDSTONE_COMPONENT = SandstoneComponent.class;
    /**
     * Signifies that a block is "seamless". Usually applicable to
     * {@link BlockTypes#DOUBLE_STONE_SLAB},
     * {@link BlockTypes#DOUBLE_STONE_SLAB2},
     * and {@link BlockTypes#DOUBLE_WOODEN_SLAB}.
     */
    public static final Class<SeamlessComponent> SEAMLESS_COMPONENT = SeamlessComponent.class;
    /**
     * Represents the {@link ShrubType} of a {@link BlockTypes#TALLGRASS}.
     */
    public static final Class<ShrubComponent> SHRUB_COMPONENT = ShrubComponent.class;
    /**
     * Represents the {@link SlabType} of slabs.
     */
    public static final Class<SlabComponent> SLAB_COMPONENT = SlabComponent.class;
    /**
     * Signifies that a block is considered to be "snowed. Usually applicable
     * to {@link BlockTypes#GRASS}, {@link BlockTypes#DIRT}, and
     * {@link BlockTypes#MYCELIUM}.
     */
    public static final Class<SnowedComponent> SNOWED_COMPONENT = SnowedComponent.class;
    /**
     * Represents the {@link StairShape} of a stair block.
     */
    public static final Class<StairShapeComponent> STAIR_SHAPE_COMPONENT = StairShapeComponent.class;
    /**
     * Represents the {@link StoneType} of a {@link BlockTypes#STONE}.
     */
    public static final Class<StoneComponent> STONE_COMPONENT = StoneComponent.class;
    /**
     * Signifies that a block is "suspended". Usually applicable to
     * {@link BlockTypes#TRIPWIRE} and {@link BlockTypes#TRIPWIRE_HOOK}.
     */
    public static final Class<SuspendedComponent> SUSPENDED_COMPONENT = SuspendedComponent.class;
    /**
     * Represents the {@link TreeType} for various tree based blocks. Usually
     * applicable to {@link BlockTypes#SAPLING}, {@link BlockTypes#LEAVES},
     * and {@link BlockTypes#LOG}.
     */
    public static final Class<TreeComponent> TREE_COMPONENT = TreeComponent.class;
    /**
     * Represents the {@link WallType} of a
     * {@link BlockTypes#COBBLESTONE_WALL}.
     */
    public static final Class<WallComponent> WALL_COMPONENT = WallComponent.class;
    /**
     * Signifies that a block is considered "wet". Usually applicable to
     * {@link BlockTypes#SPONGE}.
     */
    public static final Class<WetComponent> WET_COMPONENT = WetComponent.class;

    /**
     * Represents the {@link WireAttachmentType}s for the four cardinal directions of a
     * piece of {@link BlockTypes#REDSTONE_WIRE}.
     */
    public static final Class<WireAttachmentComponent> WIRE_ATTACHMENT_COMPONENT = WireAttachmentComponent.class;

    private CatalogBlockData() {
    }

}
