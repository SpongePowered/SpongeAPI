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
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.mutable.RotationalData;
import org.spongepowered.api.data.manipulator.mutable.WetData;
import org.spongepowered.api.data.manipulator.mutable.AttachedData;
import org.spongepowered.api.data.manipulator.mutable.AxisData;
import org.spongepowered.api.data.manipulator.mutable.BigMushroomPoresData;
import org.spongepowered.api.data.manipulator.mutable.ChestAttachmentData;
import org.spongepowered.api.data.manipulator.mutable.ConnectedDirectionData;
import org.spongepowered.api.data.manipulator.mutable.DecayableData;
import org.spongepowered.api.data.manipulator.mutable.DelayableData;
import org.spongepowered.api.data.manipulator.mutable.DirectionalData;
import org.spongepowered.api.data.manipulator.mutable.DisarmedData;
import org.spongepowered.api.data.manipulator.mutable.DropData;
import org.spongepowered.api.data.manipulator.mutable.ExtendedData;
import org.spongepowered.api.data.manipulator.mutable.FilledData;
import org.spongepowered.api.data.manipulator.mutable.FluidLevelData;
import org.spongepowered.api.data.manipulator.mutable.GrowthData;
import org.spongepowered.api.data.manipulator.mutable.HingeData;
import org.spongepowered.api.data.manipulator.mutable.InWallData;
import org.spongepowered.api.data.manipulator.mutable.LayeredData;
import org.spongepowered.api.data.manipulator.mutable.LitData;
import org.spongepowered.api.data.manipulator.mutable.MoistureData;
import org.spongepowered.api.data.manipulator.mutable.OccupiedData;
import org.spongepowered.api.data.manipulator.mutable.OpenData;
import org.spongepowered.api.data.manipulator.mutable.PortionData;
import org.spongepowered.api.data.manipulator.mutable.PoweredData;
import org.spongepowered.api.data.manipulator.mutable.RailDirectionData;
import org.spongepowered.api.data.manipulator.mutable.RedstonePoweredData;
import org.spongepowered.api.data.manipulator.mutable.SlabPortionData;
import org.spongepowered.api.data.manipulator.mutable.SnowedData;
import org.spongepowered.api.data.manipulator.mutable.StairShapeData;
import org.spongepowered.api.data.manipulator.mutable.WireAttachmentData;
import org.spongepowered.api.data.type.RailDirection;
import org.spongepowered.api.data.type.SlabPortion;
import org.spongepowered.api.data.type.StairShape;
import org.spongepowered.api.data.type.WireAttachmentType;
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
    public static final Class<BigMushroomPoresData> BIG_MUSHROOM_DATA = BigMushroomPoresData.class;
    /**
     * Represents attachment data related to {@link BlockTypes#CHEST} and
     * {@link BlockTypes#TRAPPED_CHEST}.
     */
    public static final Class<ChestAttachmentData> CHEST_ATTACHMENT_DATA = ChestAttachmentData.class;
    /**
     * Signifies that a block is "connected" to a particular {@link Direction}.
     * Usually applies to {@link BlockTypes#GLASS_PANE}, stained glass panes,
     * walls (e.g. {@link BlockTypes#COBBLESTONE_WALL}), etc.
     */
    public static final Class<ConnectedDirectionData> CONNECTED_DIRECTION_DATA = ConnectedDirectionData.class;
    /**
     * Signifies that a block will "decay" or be removed after a certain time.
     * Usually applicable to leaves, for example {@link BlockTypes#OAK_LEAVES}.
     */
    public static final Class<DecayableData> DECAYABLE_DATA = DecayableData.class;
    /**
     * Represents the delay of a redstone repeater.
     */
    public static final Class<DelayableData> DELAYABLE_DATA = DelayableData.class;
    /**
     * Signifies that a block has a {@link Direction}. Usually applies
     * to "rotational" blocks, such as {@link BlockTypes#DISPENSER}, shulker boxes
     * (for example {@link BlockTypes#WHITE_SHULKER_BOX}), etc.
     */
    public static final Class<DirectionalData> DIRECTIONAL_DATA = DirectionalData.class;
    /**
     * Signifies that a block is "disarmed". Usually applies to
     * {@link BlockTypes#TRIPWIRE_HOOK}s.
     */
    public static final Class<DisarmedData> DISARMED_DATA = DisarmedData.class;
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
     * applicable to doors and trapdoors. For example {@link BlockTypes#OAK_DOOR}
     * or {@link BlockTypes#OAK_TRAPDOOR}.
     */
    public static final Class<HingeData> HINGE_DATA = HingeData.class;
    /**
     * Signifies that the owner is "connected" to a wall. Usually applicable to
     * fence gates, for example {@link BlockTypes#OAK_FENCE_GATE}.
     */
    public static final Class<InWallData> IN_WALL_DATA = InWallData.class;
    /**
     * Represents the "layer" of an owner. Usually applicable to
     * {@link BlockTypes#CAKE}, {@link BlockTypes#SNOW}, etc.
     */
    public static final Class<LayeredData> LAYERED_DATA = LayeredData.class;
    /**
     * Represents the {@link DataManipulator} for the state that something is "lit",
     * for example a {@link BlockTypes#FURNACE} or {@link BlockTypes#REDSTONE_TORCH}.
     */
    public static final Class<LitData> LIT_DATA = LitData.class;
    /**
     * Represents the "moisture" level of a block. Usually applicable to
     * {@link BlockTypes#FARMLAND}.
     */
    public static final Class<MoistureData> MOISTURE_DATA = MoistureData.class;
    /**
     * Signifies that the owner will not drop anything. Usually applicable
     * skulls or heads, for example {@link BlockTypes#PLAYER_HEAD}.
     */
    public static final Class<DropData> NO_DROP_DATA = DropData.class;
    /**
     * Signifies that the block is considered "occupied". Usually applicable to
     * beds, for example {@link BlockTypes#WHITE_BED}.
     */
    public static final Class<OccupiedData> OCCUPIED_DATA = OccupiedData.class;
    /**
     * Signifies that a block is "open". Usually applies to all doors.
     */
    public static final Class<OpenData> OPEN_DATA = OpenData.class;
    /**
     * Represents the "portion" of a block such as the top or bottom half of a
     * door. Usually applies to all doors and double plants.
     */
    public static final Class<PortionData> PORTION_DATA = PortionData.class;
    /**
     * Signifies that a block is "powered".
     */
    public static final Class<PoweredData> POWERED_DATA = PoweredData.class;
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
     * Represents the {@link SlabPortion} of a slab block,
     * for example {@link BlockTypes#STONE_SLAB}.
     */
    public static final Class<SlabPortionData> SLAB_PORTION_DATA = SlabPortionData.class;
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
     * Signifies that a block is considered "wet". Usually applicable to
     * {@link BlockTypes#SPONGE}.
     */
    public static final Class<WetData> WET_DATA = WetData.class;
    /**
     * Represents the {@link WireAttachmentType}s for the four cardinal directions of a
     * piece of {@link BlockTypes#REDSTONE_WIRE}.
     */
    public static final Class<WireAttachmentData> WIRE_ATTACHMENT_DATA = WireAttachmentData.class;

    private CatalogBlockData() {
    }

}
