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
package org.spongepowered.api.state;

import org.spongepowered.api.data.type.AttachmentSurface;
import org.spongepowered.api.data.type.BambooLeavesType;
import org.spongepowered.api.data.type.BellAttachmentType;
import org.spongepowered.api.data.type.ChestAttachmentType;
import org.spongepowered.api.data.type.ComparatorMode;
import org.spongepowered.api.data.type.DoorHinge;
import org.spongepowered.api.data.type.DripstoneSegment;
import org.spongepowered.api.data.type.InstrumentType;
import org.spongepowered.api.data.type.JigsawBlockOrientation;
import org.spongepowered.api.data.type.PistonType;
import org.spongepowered.api.data.type.PortionType;
import org.spongepowered.api.data.type.RailDirection;
import org.spongepowered.api.data.type.SculkSensorState;
import org.spongepowered.api.data.type.SlabPortion;
import org.spongepowered.api.data.type.StairShape;
import org.spongepowered.api.data.type.StructureMode;
import org.spongepowered.api.data.type.Tilt;
import org.spongepowered.api.data.type.WallType;
import org.spongepowered.api.data.type.WireAttachmentType;
import org.spongepowered.api.util.Axis;
import org.spongepowered.api.util.Direction;

/**
 * <!-- This file is automatically generated. Any manual changes will be overwritten. -->
 */
@SuppressWarnings("unused")
public final class EnumStateProperties {
    private EnumStateProperties() {
    }

    public static EnumStateProperty<AttachmentSurface> property_ATTACH_FACE() {
        return EnumStateProperty.of("ATTACH_FACE");
    }

    public static EnumStateProperty<Axis> property_AXIS() {
        return EnumStateProperty.of("AXIS");
    }

    public static EnumStateProperty<BambooLeavesType> property_BAMBOO_LEAVES() {
        return EnumStateProperty.of("BAMBOO_LEAVES");
    }

    public static EnumStateProperty<PortionType> property_BED_PART() {
        return EnumStateProperty.of("BED_PART");
    }

    public static EnumStateProperty<BellAttachmentType> property_BELL_ATTACHMENT() {
        return EnumStateProperty.of("BELL_ATTACHMENT");
    }

    public static EnumStateProperty<ChestAttachmentType> property_CHEST_TYPE() {
        return EnumStateProperty.of("CHEST_TYPE");
    }

    public static EnumStateProperty<DoorHinge> property_DOOR_HINGE() {
        return EnumStateProperty.of("DOOR_HINGE");
    }

    public static EnumStateProperty<PortionType> property_DOUBLE_BLOCK_HALF() {
        return EnumStateProperty.of("DOUBLE_BLOCK_HALF");
    }

    public static EnumStateProperty<DripstoneSegment> property_DRIPSTONE_THICKNESS() {
        return EnumStateProperty.of("DRIPSTONE_THICKNESS");
    }

    public static EnumStateProperty<WireAttachmentType> property_EAST_REDSTONE() {
        return EnumStateProperty.of("EAST_REDSTONE");
    }

    public static EnumStateProperty<WallType> property_EAST_WALL() {
        return EnumStateProperty.of("EAST_WALL");
    }

    public static EnumStateProperty<Direction> property_FACING() {
        return EnumStateProperty.of("FACING");
    }

    public static EnumStateProperty<Direction> property_FACING_HOPPER() {
        return EnumStateProperty.of("FACING_HOPPER");
    }

    public static EnumStateProperty<PortionType> property_HALF() {
        return EnumStateProperty.of("HALF");
    }

    public static EnumStateProperty<Axis> property_HORIZONTAL_AXIS() {
        return EnumStateProperty.of("HORIZONTAL_AXIS");
    }

    public static EnumStateProperty<Direction> property_HORIZONTAL_FACING() {
        return EnumStateProperty.of("HORIZONTAL_FACING");
    }

    public static EnumStateProperty<ComparatorMode> property_MODE_COMPARATOR() {
        return EnumStateProperty.of("MODE_COMPARATOR");
    }

    public static EnumStateProperty<WireAttachmentType> property_NORTH_REDSTONE() {
        return EnumStateProperty.of("NORTH_REDSTONE");
    }

    public static EnumStateProperty<WallType> property_NORTH_WALL() {
        return EnumStateProperty.of("NORTH_WALL");
    }

    public static EnumStateProperty<InstrumentType> property_NOTEBLOCK_INSTRUMENT() {
        return EnumStateProperty.of("NOTEBLOCK_INSTRUMENT");
    }

    public static EnumStateProperty<JigsawBlockOrientation> property_ORIENTATION() {
        return EnumStateProperty.of("ORIENTATION");
    }

    public static EnumStateProperty<PistonType> property_PISTON_TYPE() {
        return EnumStateProperty.of("PISTON_TYPE");
    }

    public static EnumStateProperty<RailDirection> property_RAIL_SHAPE() {
        return EnumStateProperty.of("RAIL_SHAPE");
    }

    public static EnumStateProperty<RailDirection> property_RAIL_SHAPE_STRAIGHT() {
        return EnumStateProperty.of("RAIL_SHAPE_STRAIGHT");
    }

    public static EnumStateProperty<SculkSensorState> property_SCULK_SENSOR_PHASE() {
        return EnumStateProperty.of("SCULK_SENSOR_PHASE");
    }

    public static EnumStateProperty<SlabPortion> property_SLAB_TYPE() {
        return EnumStateProperty.of("SLAB_TYPE");
    }

    public static EnumStateProperty<WireAttachmentType> property_SOUTH_REDSTONE() {
        return EnumStateProperty.of("SOUTH_REDSTONE");
    }

    public static EnumStateProperty<WallType> property_SOUTH_WALL() {
        return EnumStateProperty.of("SOUTH_WALL");
    }

    public static EnumStateProperty<StairShape> property_STAIRS_SHAPE() {
        return EnumStateProperty.of("STAIRS_SHAPE");
    }

    public static EnumStateProperty<StructureMode> property_STRUCTUREBLOCK_MODE() {
        return EnumStateProperty.of("STRUCTUREBLOCK_MODE");
    }

    public static EnumStateProperty<Tilt> property_TILT() {
        return EnumStateProperty.of("TILT");
    }

    public static EnumStateProperty<Direction> property_VERTICAL_DIRECTION() {
        return EnumStateProperty.of("VERTICAL_DIRECTION");
    }

    public static EnumStateProperty<WireAttachmentType> property_WEST_REDSTONE() {
        return EnumStateProperty.of("WEST_REDSTONE");
    }

    public static EnumStateProperty<WallType> property_WEST_WALL() {
        return EnumStateProperty.of("WEST_WALL");
    }
}
