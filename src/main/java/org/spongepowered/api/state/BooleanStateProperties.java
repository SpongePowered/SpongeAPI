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

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * Represents all possible {@link BooleanStateProperty}s that are known to exist in
 * vanilla minecraft.
 */
public final class BooleanStateProperties {

    // SORTFIELDS:ON

    public static final Supplier<BooleanStateProperty> ACACIA_BUTTON_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_button_powered");

    public static final Supplier<BooleanStateProperty> ACACIA_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_door_open");

    public static final Supplier<BooleanStateProperty> ACACIA_DOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_door_powered");

    public static final Supplier<BooleanStateProperty> ACACIA_FENCE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_fence_east");

    public static final Supplier<BooleanStateProperty> ACACIA_FENCE_GATE_IN_WALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_fence_gate_in_wall");

    public static final Supplier<BooleanStateProperty> ACACIA_FENCE_GATE_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_fence_gate_open");

    public static final Supplier<BooleanStateProperty> ACACIA_FENCE_GATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_fence_gate_powered");

    public static final Supplier<BooleanStateProperty> ACACIA_FENCE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_fence_north");

    public static final Supplier<BooleanStateProperty> ACACIA_FENCE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_fence_south");

    public static final Supplier<BooleanStateProperty> ACACIA_FENCE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_fence_waterlogged");

    public static final Supplier<BooleanStateProperty> ACACIA_FENCE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_fence_west");

    public static final Supplier<BooleanStateProperty> ACACIA_LEAVES_PERSISTENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_leaves_persistent");

    public static final Supplier<BooleanStateProperty> ACACIA_PRESSURE_PLATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_pressure_plate_powered");

    public static final Supplier<BooleanStateProperty> ACACIA_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_sign_waterlogged");

    public static final Supplier<BooleanStateProperty> ACACIA_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> ACACIA_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> ACACIA_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_trapdoor_open");

    public static final Supplier<BooleanStateProperty> ACACIA_TRAPDOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_trapdoor_powered");

    public static final Supplier<BooleanStateProperty> ACACIA_TRAPDOOR_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_trapdoor_waterlogged");

    public static final Supplier<BooleanStateProperty> ACACIA_WALL_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "acacia_wall_sign_waterlogged");

    public static final Supplier<BooleanStateProperty> ACTIVATOR_RAIL_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "activator_rail_powered");

    public static final Supplier<BooleanStateProperty> ANDESITE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "andesite_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> ANDESITE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "andesite_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> ANDESITE_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "andesite_wall_east");

    public static final Supplier<BooleanStateProperty> ANDESITE_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "andesite_wall_north");

    public static final Supplier<BooleanStateProperty> ANDESITE_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "andesite_wall_south");

    public static final Supplier<BooleanStateProperty> ANDESITE_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "andesite_wall_up");

    public static final Supplier<BooleanStateProperty> ANDESITE_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "andesite_wall_waterlogged");

    public static final Supplier<BooleanStateProperty> ANDESITE_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "andesite_wall_west");

    public static final Supplier<BooleanStateProperty> BARREL_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "barrel_open");

    public static final Supplier<BooleanStateProperty> BIRCH_BUTTON_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_button_powered");

    public static final Supplier<BooleanStateProperty> BIRCH_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_door_open");

    public static final Supplier<BooleanStateProperty> BIRCH_DOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_door_powered");

    public static final Supplier<BooleanStateProperty> BIRCH_FENCE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_fence_east");

    public static final Supplier<BooleanStateProperty> BIRCH_FENCE_GATE_IN_WALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_fence_gate_in_wall");

    public static final Supplier<BooleanStateProperty> BIRCH_FENCE_GATE_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_fence_gate_open");

    public static final Supplier<BooleanStateProperty> BIRCH_FENCE_GATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_fence_gate_powered");

    public static final Supplier<BooleanStateProperty> BIRCH_FENCE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_fence_north");

    public static final Supplier<BooleanStateProperty> BIRCH_FENCE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_fence_south");

    public static final Supplier<BooleanStateProperty> BIRCH_FENCE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_fence_waterlogged");

    public static final Supplier<BooleanStateProperty> BIRCH_FENCE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_fence_west");

    public static final Supplier<BooleanStateProperty> BIRCH_LEAVES_PERSISTENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_leaves_persistent");

    public static final Supplier<BooleanStateProperty> BIRCH_PRESSURE_PLATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_pressure_plate_powered");

    public static final Supplier<BooleanStateProperty> BIRCH_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_sign_waterlogged");

    public static final Supplier<BooleanStateProperty> BIRCH_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> BIRCH_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> BIRCH_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_trapdoor_open");

    public static final Supplier<BooleanStateProperty> BIRCH_TRAPDOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_trapdoor_powered");

    public static final Supplier<BooleanStateProperty> BIRCH_TRAPDOOR_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_trapdoor_waterlogged");

    public static final Supplier<BooleanStateProperty> BIRCH_WALL_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "birch_wall_sign_waterlogged");

    public static final Supplier<BooleanStateProperty> BLACK_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "black_bed_occupied");

    public static final Supplier<BooleanStateProperty> BLACK_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "black_stained_glass_pane_east");

    public static final Supplier<BooleanStateProperty> BLACK_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "black_stained_glass_pane_north");

    public static final Supplier<BooleanStateProperty> BLACK_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "black_stained_glass_pane_south");

    public static final Supplier<BooleanStateProperty> BLACK_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "black_stained_glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> BLACK_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "black_stained_glass_pane_west");

    public static final Supplier<BooleanStateProperty> BLAST_FURNACE_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "blast_furnace_lit");

    public static final Supplier<BooleanStateProperty> BLUE_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "blue_bed_occupied");

    public static final Supplier<BooleanStateProperty> BLUE_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "blue_stained_glass_pane_east");

    public static final Supplier<BooleanStateProperty> BLUE_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "blue_stained_glass_pane_north");

    public static final Supplier<BooleanStateProperty> BLUE_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "blue_stained_glass_pane_south");

    public static final Supplier<BooleanStateProperty> BLUE_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "blue_stained_glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> BLUE_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "blue_stained_glass_pane_west");

    public static final Supplier<BooleanStateProperty> BRAIN_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brain_coral_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> BRAIN_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brain_coral_wall_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> BRAIN_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brain_coral_waterlogged");

    public static final Supplier<BooleanStateProperty> BREWING_STAND_HAS_BOTTLE_0 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BREWING_STAND_HAS_BOTTLE_0");

    public static final Supplier<BooleanStateProperty> BREWING_STAND_HAS_BOTTLE_1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BREWING_STAND_HAS_BOTTLE_1");

    public static final Supplier<BooleanStateProperty> BREWING_STAND_HAS_BOTTLE_2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BREWING_STAND_HAS_BOTTLE_2");

    public static final Supplier<BooleanStateProperty> BRICK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brick_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> BRICK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brick_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> BRICK_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brick_wall_east");

    public static final Supplier<BooleanStateProperty> BRICK_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brick_wall_north");

    public static final Supplier<BooleanStateProperty> BRICK_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brick_wall_south");

    public static final Supplier<BooleanStateProperty> BRICK_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brick_wall_up");

    public static final Supplier<BooleanStateProperty> BRICK_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brick_wall_waterlogged");

    public static final Supplier<BooleanStateProperty> BRICK_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brick_wall_west");

    public static final Supplier<BooleanStateProperty> BROWN_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brown_bed_occupied");

    public static final Supplier<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_DOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brown_mushroom_block_down");

    public static final Supplier<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brown_mushroom_block_east");

    public static final Supplier<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brown_mushroom_block_north");

    public static final Supplier<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brown_mushroom_block_south");

    public static final Supplier<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brown_mushroom_block_up");

    public static final Supplier<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brown_mushroom_block_west");

    public static final Supplier<BooleanStateProperty> BROWN_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brown_stained_glass_pane_east");

    public static final Supplier<BooleanStateProperty> BROWN_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brown_stained_glass_pane_north");

    public static final Supplier<BooleanStateProperty> BROWN_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brown_stained_glass_pane_south");

    public static final Supplier<BooleanStateProperty> BROWN_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brown_stained_glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> BROWN_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "brown_stained_glass_pane_west");

    public static final Supplier<BooleanStateProperty> BUBBLE_COLUMN_DRAG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "bubble_column_drag");

    public static final Supplier<BooleanStateProperty> BUBBLE_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "bubble_coral_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> BUBBLE_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "bubble_coral_wall_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> BUBBLE_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "bubble_coral_waterlogged");

    public static final Supplier<BooleanStateProperty> CAMPFIRE_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "campfire_lit");

    public static final Supplier<BooleanStateProperty> CAMPFIRE_SIGNAL_FIRE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "campfire_signal_fire");

    public static final Supplier<BooleanStateProperty> CAMPFIRE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "campfire_waterlogged");

    public static final Supplier<BooleanStateProperty> CHAIN_COMMAND_BLOCK_CONDITIONAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "chain_command_block_conditional");

    public static final Supplier<BooleanStateProperty> CHEST_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "chest_waterlogged");

    public static final Supplier<BooleanStateProperty> CHORUS_PLANT_DOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "chorus_plant_down");

    public static final Supplier<BooleanStateProperty> CHORUS_PLANT_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "chorus_plant_east");

    public static final Supplier<BooleanStateProperty> CHORUS_PLANT_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "chorus_plant_north");

    public static final Supplier<BooleanStateProperty> CHORUS_PLANT_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "chorus_plant_south");

    public static final Supplier<BooleanStateProperty> CHORUS_PLANT_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "chorus_plant_up");

    public static final Supplier<BooleanStateProperty> CHORUS_PLANT_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "chorus_plant_west");

    public static final Supplier<BooleanStateProperty> COBBLESTONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "cobblestone_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> COBBLESTONE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "cobblestone_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> COBBLESTONE_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "cobblestone_wall_east");

    public static final Supplier<BooleanStateProperty> COBBLESTONE_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "cobblestone_wall_north");

    public static final Supplier<BooleanStateProperty> COBBLESTONE_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "cobblestone_wall_south");

    public static final Supplier<BooleanStateProperty> COBBLESTONE_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "cobblestone_wall_up");

    public static final Supplier<BooleanStateProperty> COBBLESTONE_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "cobblestone_wall_waterlogged");

    public static final Supplier<BooleanStateProperty> COBBLESTONE_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "cobblestone_wall_west");

    public static final Supplier<BooleanStateProperty> COMMAND_BLOCK_CONDITIONAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "command_block_conditional");

    public static final Supplier<BooleanStateProperty> COMPARATOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "comparator_powered");

    public static final Supplier<BooleanStateProperty> CONDUIT_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "conduit_waterlogged");

    public static final Supplier<BooleanStateProperty> CUT_RED_SANDSTONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "cut_red_sandstone_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> CUT_SANDSTONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "cut_sandstone_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> CYAN_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "cyan_bed_occupied");

    public static final Supplier<BooleanStateProperty> CYAN_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "cyan_stained_glass_pane_east");

    public static final Supplier<BooleanStateProperty> CYAN_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "cyan_stained_glass_pane_north");

    public static final Supplier<BooleanStateProperty> CYAN_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "cyan_stained_glass_pane_south");

    public static final Supplier<BooleanStateProperty> CYAN_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "cyan_stained_glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> CYAN_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "cyan_stained_glass_pane_west");

    public static final Supplier<BooleanStateProperty> DARK_OAK_BUTTON_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_button_powered");

    public static final Supplier<BooleanStateProperty> DARK_OAK_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_door_open");

    public static final Supplier<BooleanStateProperty> DARK_OAK_DOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_door_powered");

    public static final Supplier<BooleanStateProperty> DARK_OAK_FENCE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_fence_east");

    public static final Supplier<BooleanStateProperty> DARK_OAK_FENCE_GATE_IN_WALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_fence_gate_in_wall");

    public static final Supplier<BooleanStateProperty> DARK_OAK_FENCE_GATE_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_fence_gate_open");

    public static final Supplier<BooleanStateProperty> DARK_OAK_FENCE_GATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_fence_gate_powered");

    public static final Supplier<BooleanStateProperty> DARK_OAK_FENCE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_fence_north");

    public static final Supplier<BooleanStateProperty> DARK_OAK_FENCE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_fence_south");

    public static final Supplier<BooleanStateProperty> DARK_OAK_FENCE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_fence_waterlogged");

    public static final Supplier<BooleanStateProperty> DARK_OAK_FENCE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_fence_west");

    public static final Supplier<BooleanStateProperty> DARK_OAK_LEAVES_PERSISTENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_leaves_persistent");

    public static final Supplier<BooleanStateProperty> DARK_OAK_PRESSURE_PLATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_pressure_plate_powered");

    public static final Supplier<BooleanStateProperty> DARK_OAK_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_sign_waterlogged");

    public static final Supplier<BooleanStateProperty> DARK_OAK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> DARK_OAK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> DARK_OAK_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_trapdoor_open");

    public static final Supplier<BooleanStateProperty> DARK_OAK_TRAPDOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_trapdoor_powered");

    public static final Supplier<BooleanStateProperty> DARK_OAK_TRAPDOOR_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_trapdoor_waterlogged");

    public static final Supplier<BooleanStateProperty> DARK_OAK_WALL_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_oak_wall_sign_waterlogged");

    public static final Supplier<BooleanStateProperty> DARK_PRISMARINE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_prismarine_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> DARK_PRISMARINE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dark_prismarine_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> DAYLIGHT_DETECTOR_INVERTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "daylight_detector_inverted");

    public static final Supplier<BooleanStateProperty> DEAD_BRAIN_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dead_brain_coral_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> DEAD_BRAIN_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dead_brain_coral_wall_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> DEAD_BRAIN_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dead_brain_coral_waterlogged");

    public static final Supplier<BooleanStateProperty> DEAD_BUBBLE_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dead_bubble_coral_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> DEAD_BUBBLE_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dead_bubble_coral_wall_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> DEAD_BUBBLE_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dead_bubble_coral_waterlogged");

    public static final Supplier<BooleanStateProperty> DEAD_FIRE_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dead_fire_coral_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> DEAD_FIRE_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dead_fire_coral_wall_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> DEAD_FIRE_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dead_fire_coral_waterlogged");

    public static final Supplier<BooleanStateProperty> DEAD_HORN_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dead_horn_coral_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> DEAD_HORN_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dead_horn_coral_wall_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> DEAD_HORN_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dead_horn_coral_waterlogged");

    public static final Supplier<BooleanStateProperty> DEAD_TUBE_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dead_tube_coral_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> DEAD_TUBE_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dead_tube_coral_wall_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> DEAD_TUBE_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dead_tube_coral_waterlogged");

    public static final Supplier<BooleanStateProperty> DETECTOR_RAIL_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "detector_rail_powered");

    public static final Supplier<BooleanStateProperty> DIORITE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "diorite_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> DIORITE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "diorite_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> DIORITE_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "diorite_wall_east");

    public static final Supplier<BooleanStateProperty> DIORITE_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "diorite_wall_north");

    public static final Supplier<BooleanStateProperty> DIORITE_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "diorite_wall_south");

    public static final Supplier<BooleanStateProperty> DIORITE_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "diorite_wall_up");

    public static final Supplier<BooleanStateProperty> DIORITE_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "diorite_wall_waterlogged");

    public static final Supplier<BooleanStateProperty> DIORITE_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "diorite_wall_west");

    public static final Supplier<BooleanStateProperty> DISPENSER_TRIGGERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dispenser_triggered");

    public static final Supplier<BooleanStateProperty> DROPPER_TRIGGERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "dropper_triggered");

    public static final Supplier<BooleanStateProperty> ENDER_CHEST_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ender_chest_waterlogged");

    public static final Supplier<BooleanStateProperty> END_PORTAL_FRAME_EYE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "end_portal_frame_eye");

    public static final Supplier<BooleanStateProperty> END_STONE_BRICK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "end_stone_brick_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> END_STONE_BRICK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "end_stone_brick_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> END_STONE_BRICK_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "end_stone_brick_wall_east");

    public static final Supplier<BooleanStateProperty> END_STONE_BRICK_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "end_stone_brick_wall_north");

    public static final Supplier<BooleanStateProperty> END_STONE_BRICK_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "end_stone_brick_wall_south");

    public static final Supplier<BooleanStateProperty> END_STONE_BRICK_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "end_stone_brick_wall_up");

    public static final Supplier<BooleanStateProperty> END_STONE_BRICK_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "end_stone_brick_wall_waterlogged");

    public static final Supplier<BooleanStateProperty> END_STONE_BRICK_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "end_stone_brick_wall_west");

    public static final Supplier<BooleanStateProperty> FIRE_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "fire_coral_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> FIRE_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "fire_coral_wall_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> FIRE_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "fire_coral_waterlogged");

    public static final Supplier<BooleanStateProperty> FIRE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "fire_east");

    public static final Supplier<BooleanStateProperty> FIRE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "fire_north");

    public static final Supplier<BooleanStateProperty> FIRE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "fire_south");

    public static final Supplier<BooleanStateProperty> FIRE_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "fire_up");

    public static final Supplier<BooleanStateProperty> FIRE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "fire_west");

    public static final Supplier<BooleanStateProperty> FURNACE_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "furnace_lit");

    public static final Supplier<BooleanStateProperty> GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "glass_pane_east");

    public static final Supplier<BooleanStateProperty> GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "glass_pane_north");

    public static final Supplier<BooleanStateProperty> GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "glass_pane_south");

    public static final Supplier<BooleanStateProperty> GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "glass_pane_west");

    public static final Supplier<BooleanStateProperty> GRANITE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "granite_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> GRANITE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "granite_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> GRANITE_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "granite_wall_east");

    public static final Supplier<BooleanStateProperty> GRANITE_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "granite_wall_north");

    public static final Supplier<BooleanStateProperty> GRANITE_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "granite_wall_south");

    public static final Supplier<BooleanStateProperty> GRANITE_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "granite_wall_up");

    public static final Supplier<BooleanStateProperty> GRANITE_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "granite_wall_waterlogged");

    public static final Supplier<BooleanStateProperty> GRANITE_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "granite_wall_west");

    public static final Supplier<BooleanStateProperty> GRASS_BLOCK_SNOWY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "grass_block_snowy");

    public static final Supplier<BooleanStateProperty> GRAY_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "gray_bed_occupied");

    public static final Supplier<BooleanStateProperty> GRAY_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "gray_stained_glass_pane_east");

    public static final Supplier<BooleanStateProperty> GRAY_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "gray_stained_glass_pane_north");

    public static final Supplier<BooleanStateProperty> GRAY_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "gray_stained_glass_pane_south");

    public static final Supplier<BooleanStateProperty> GRAY_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "gray_stained_glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> GRAY_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "gray_stained_glass_pane_west");

    public static final Supplier<BooleanStateProperty> GREEN_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "green_bed_occupied");

    public static final Supplier<BooleanStateProperty> GREEN_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "green_stained_glass_pane_east");

    public static final Supplier<BooleanStateProperty> GREEN_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "green_stained_glass_pane_north");

    public static final Supplier<BooleanStateProperty> GREEN_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "green_stained_glass_pane_south");

    public static final Supplier<BooleanStateProperty> GREEN_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "green_stained_glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> GREEN_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "green_stained_glass_pane_west");

    public static final Supplier<BooleanStateProperty> HOPPER_ENABLED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "hopper_enabled");

    public static final Supplier<BooleanStateProperty> HORN_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "horn_coral_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> HORN_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "horn_coral_wall_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> HORN_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "horn_coral_waterlogged");

    public static final Supplier<BooleanStateProperty> IRON_BARS_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "iron_bars_east");

    public static final Supplier<BooleanStateProperty> IRON_BARS_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "iron_bars_north");

    public static final Supplier<BooleanStateProperty> IRON_BARS_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "iron_bars_south");

    public static final Supplier<BooleanStateProperty> IRON_BARS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "iron_bars_waterlogged");

    public static final Supplier<BooleanStateProperty> IRON_BARS_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "iron_bars_west");

    public static final Supplier<BooleanStateProperty> IRON_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "iron_door_open");

    public static final Supplier<BooleanStateProperty> IRON_DOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "iron_door_powered");

    public static final Supplier<BooleanStateProperty> IRON_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "iron_trapdoor_open");

    public static final Supplier<BooleanStateProperty> IRON_TRAPDOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "iron_trapdoor_powered");

    public static final Supplier<BooleanStateProperty> IRON_TRAPDOOR_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "iron_trapdoor_waterlogged");

    public static final Supplier<BooleanStateProperty> JUKEBOX_HAS_RECORD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jukebox_has_record");

    public static final Supplier<BooleanStateProperty> JUNGLE_BUTTON_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_button_powered");

    public static final Supplier<BooleanStateProperty> JUNGLE_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_door_open");

    public static final Supplier<BooleanStateProperty> JUNGLE_DOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_door_powered");

    public static final Supplier<BooleanStateProperty> JUNGLE_FENCE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_fence_east");

    public static final Supplier<BooleanStateProperty> JUNGLE_FENCE_GATE_IN_WALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_fence_gate_in_wall");

    public static final Supplier<BooleanStateProperty> JUNGLE_FENCE_GATE_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_fence_gate_open");

    public static final Supplier<BooleanStateProperty> JUNGLE_FENCE_GATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_fence_gate_powered");

    public static final Supplier<BooleanStateProperty> JUNGLE_FENCE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_fence_north");

    public static final Supplier<BooleanStateProperty> JUNGLE_FENCE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_fence_south");

    public static final Supplier<BooleanStateProperty> JUNGLE_FENCE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_fence_waterlogged");

    public static final Supplier<BooleanStateProperty> JUNGLE_FENCE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_fence_west");

    public static final Supplier<BooleanStateProperty> JUNGLE_LEAVES_PERSISTENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_leaves_persistent");

    public static final Supplier<BooleanStateProperty> JUNGLE_PRESSURE_PLATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_pressure_plate_powered");

    public static final Supplier<BooleanStateProperty> JUNGLE_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_sign_waterlogged");

    public static final Supplier<BooleanStateProperty> JUNGLE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> JUNGLE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> JUNGLE_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_trapdoor_open");

    public static final Supplier<BooleanStateProperty> JUNGLE_TRAPDOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_trapdoor_powered");

    public static final Supplier<BooleanStateProperty> JUNGLE_TRAPDOOR_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_trapdoor_waterlogged");

    public static final Supplier<BooleanStateProperty> JUNGLE_WALL_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "jungle_wall_sign_waterlogged");

    public static final Supplier<BooleanStateProperty> LADDER_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ladder_waterlogged");

    public static final Supplier<BooleanStateProperty> LANTERN_HANGING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "lantern_hanging");

    public static final Supplier<BooleanStateProperty> LECTERN_HAS_BOOK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "lectern_has_book");

    public static final Supplier<BooleanStateProperty> LECTERN_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "lectern_powered");

    public static final Supplier<BooleanStateProperty> LEVER_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "lever_powered");

    public static final Supplier<BooleanStateProperty> LIGHT_BLUE_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "light_blue_bed_occupied");

    public static final Supplier<BooleanStateProperty> LIGHT_BLUE_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "light_blue_stained_glass_pane_east");

    public static final Supplier<BooleanStateProperty> LIGHT_BLUE_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "light_blue_stained_glass_pane_north");

    public static final Supplier<BooleanStateProperty> LIGHT_BLUE_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "light_blue_stained_glass_pane_south");

    public static final Supplier<BooleanStateProperty> LIGHT_BLUE_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "light_blue_stained_glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> LIGHT_BLUE_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "light_blue_stained_glass_pane_west");

    public static final Supplier<BooleanStateProperty> LIGHT_GRAY_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "light_gray_bed_occupied");

    public static final Supplier<BooleanStateProperty> LIGHT_GRAY_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "light_gray_stained_glass_pane_east");

    public static final Supplier<BooleanStateProperty> LIGHT_GRAY_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "light_gray_stained_glass_pane_north");

    public static final Supplier<BooleanStateProperty> LIGHT_GRAY_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "light_gray_stained_glass_pane_south");

    public static final Supplier<BooleanStateProperty> LIGHT_GRAY_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "light_gray_stained_glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> LIGHT_GRAY_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "light_gray_stained_glass_pane_west");

    public static final Supplier<BooleanStateProperty> LIME_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "lime_bed_occupied");

    public static final Supplier<BooleanStateProperty> LIME_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "lime_stained_glass_pane_east");

    public static final Supplier<BooleanStateProperty> LIME_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "lime_stained_glass_pane_north");

    public static final Supplier<BooleanStateProperty> LIME_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "lime_stained_glass_pane_south");

    public static final Supplier<BooleanStateProperty> LIME_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "lime_stained_glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> LIME_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "lime_stained_glass_pane_west");

    public static final Supplier<BooleanStateProperty> MAGENTA_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "magenta_bed_occupied");

    public static final Supplier<BooleanStateProperty> MAGENTA_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "magenta_stained_glass_pane_east");

    public static final Supplier<BooleanStateProperty> MAGENTA_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "magenta_stained_glass_pane_north");

    public static final Supplier<BooleanStateProperty> MAGENTA_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "magenta_stained_glass_pane_south");

    public static final Supplier<BooleanStateProperty> MAGENTA_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "magenta_stained_glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> MAGENTA_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "magenta_stained_glass_pane_west");

    public static final Supplier<BooleanStateProperty> MOSSY_COBBLESTONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mossy_cobblestone_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> MOSSY_COBBLESTONE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mossy_cobblestone_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mossy_cobblestone_wall_east");

    public static final Supplier<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mossy_cobblestone_wall_north");

    public static final Supplier<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mossy_cobblestone_wall_south");

    public static final Supplier<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mossy_cobblestone_wall_up");

    public static final Supplier<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mossy_cobblestone_wall_waterlogged");

    public static final Supplier<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mossy_cobblestone_wall_west");

    public static final Supplier<BooleanStateProperty> MOSSY_STONE_BRICK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mossy_stone_brick_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> MOSSY_STONE_BRICK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mossy_stone_brick_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mossy_stone_brick_wall_east");

    public static final Supplier<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mossy_stone_brick_wall_north");

    public static final Supplier<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mossy_stone_brick_wall_south");

    public static final Supplier<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mossy_stone_brick_wall_up");

    public static final Supplier<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mossy_stone_brick_wall_waterlogged");

    public static final Supplier<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mossy_stone_brick_wall_west");

    public static final Supplier<BooleanStateProperty> MUSHROOM_STEM_DOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mushroom_stem_down");

    public static final Supplier<BooleanStateProperty> MUSHROOM_STEM_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mushroom_stem_east");

    public static final Supplier<BooleanStateProperty> MUSHROOM_STEM_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mushroom_stem_north");

    public static final Supplier<BooleanStateProperty> MUSHROOM_STEM_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mushroom_stem_south");

    public static final Supplier<BooleanStateProperty> MUSHROOM_STEM_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mushroom_stem_up");

    public static final Supplier<BooleanStateProperty> MUSHROOM_STEM_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mushroom_stem_west");

    public static final Supplier<BooleanStateProperty> MYCELIUM_SNOWY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "mycelium_snowy");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_FENCE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "nether_brick_fence_east");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_FENCE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "nether_brick_fence_north");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_FENCE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "nether_brick_fence_south");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_FENCE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "nether_brick_fence_waterlogged");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_FENCE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "nether_brick_fence_west");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "nether_brick_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "nether_brick_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "nether_brick_wall_east");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "nether_brick_wall_north");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "nether_brick_wall_south");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "nether_brick_wall_up");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "nether_brick_wall_waterlogged");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "nether_brick_wall_west");

    public static final Supplier<BooleanStateProperty> NOTE_BLOCK_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "note_block_powered");

    public static final Supplier<BooleanStateProperty> OAK_BUTTON_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_button_powered");

    public static final Supplier<BooleanStateProperty> OAK_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_door_open");

    public static final Supplier<BooleanStateProperty> OAK_DOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_door_powered");

    public static final Supplier<BooleanStateProperty> OAK_FENCE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_fence_east");

    public static final Supplier<BooleanStateProperty> OAK_FENCE_GATE_IN_WALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_fence_gate_in_wall");

    public static final Supplier<BooleanStateProperty> OAK_FENCE_GATE_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_fence_gate_open");

    public static final Supplier<BooleanStateProperty> OAK_FENCE_GATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_fence_gate_powered");

    public static final Supplier<BooleanStateProperty> OAK_FENCE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_fence_north");

    public static final Supplier<BooleanStateProperty> OAK_FENCE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_fence_south");

    public static final Supplier<BooleanStateProperty> OAK_FENCE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_fence_waterlogged");

    public static final Supplier<BooleanStateProperty> OAK_FENCE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_fence_west");

    public static final Supplier<BooleanStateProperty> OAK_LEAVES_PERSISTENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_leaves_persistent");

    public static final Supplier<BooleanStateProperty> OAK_PRESSURE_PLATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_pressure_plate_powered");

    public static final Supplier<BooleanStateProperty> OAK_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_sign_waterlogged");

    public static final Supplier<BooleanStateProperty> OAK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> OAK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> OAK_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_trapdoor_open");

    public static final Supplier<BooleanStateProperty> OAK_TRAPDOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_trapdoor_powered");

    public static final Supplier<BooleanStateProperty> OAK_TRAPDOOR_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_trapdoor_waterlogged");

    public static final Supplier<BooleanStateProperty> OAK_WALL_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "oak_wall_sign_waterlogged");

    public static final Supplier<BooleanStateProperty> OBSERVER_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "observer_powered");

    public static final Supplier<BooleanStateProperty> ORANGE_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "orange_bed_occupied");

    public static final Supplier<BooleanStateProperty> ORANGE_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "orange_stained_glass_pane_east");

    public static final Supplier<BooleanStateProperty> ORANGE_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "orange_stained_glass_pane_north");

    public static final Supplier<BooleanStateProperty> ORANGE_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "orange_stained_glass_pane_south");

    public static final Supplier<BooleanStateProperty> ORANGE_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "orange_stained_glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> ORANGE_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "orange_stained_glass_pane_west");

    public static final Supplier<BooleanStateProperty> PETRIFIED_OAK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "petrified_oak_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> PINK_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "pink_bed_occupied");

    public static final Supplier<BooleanStateProperty> PINK_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "pink_stained_glass_pane_east");

    public static final Supplier<BooleanStateProperty> PINK_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "pink_stained_glass_pane_north");

    public static final Supplier<BooleanStateProperty> PINK_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "pink_stained_glass_pane_south");

    public static final Supplier<BooleanStateProperty> PINK_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "pink_stained_glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> PINK_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "pink_stained_glass_pane_west");

    public static final Supplier<BooleanStateProperty> PISTON_EXTENDED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "piston_extended");

    public static final Supplier<BooleanStateProperty> PISTON_HEAD_SHORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "piston_head_short");

    public static final Supplier<BooleanStateProperty> PODZOL_SNOWY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "podzol_snowy");

    public static final Supplier<BooleanStateProperty> POLISHED_ANDESITE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "polished_andesite_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> POLISHED_ANDESITE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "polished_andesite_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> POLISHED_DIORITE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "polished_diorite_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> POLISHED_DIORITE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "polished_diorite_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> POLISHED_GRANITE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "polished_granite_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> POLISHED_GRANITE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "polished_granite_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> POWERED_RAIL_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "powered_rail_powered");

    public static final Supplier<BooleanStateProperty> PRISMARINE_BRICK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "prismarine_brick_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> PRISMARINE_BRICK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "prismarine_brick_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> PRISMARINE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "prismarine_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> PRISMARINE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "prismarine_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> PRISMARINE_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "prismarine_wall_east");

    public static final Supplier<BooleanStateProperty> PRISMARINE_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "prismarine_wall_north");

    public static final Supplier<BooleanStateProperty> PRISMARINE_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "prismarine_wall_south");

    public static final Supplier<BooleanStateProperty> PRISMARINE_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "prismarine_wall_up");

    public static final Supplier<BooleanStateProperty> PRISMARINE_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "prismarine_wall_waterlogged");

    public static final Supplier<BooleanStateProperty> PRISMARINE_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "prismarine_wall_west");

    public static final Supplier<BooleanStateProperty> PURPLE_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "purple_bed_occupied");

    public static final Supplier<BooleanStateProperty> PURPLE_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "purple_stained_glass_pane_east");

    public static final Supplier<BooleanStateProperty> PURPLE_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "purple_stained_glass_pane_north");

    public static final Supplier<BooleanStateProperty> PURPLE_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "purple_stained_glass_pane_south");

    public static final Supplier<BooleanStateProperty> PURPLE_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "purple_stained_glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> PURPLE_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "purple_stained_glass_pane_west");

    public static final Supplier<BooleanStateProperty> PURPUR_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "purpur_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> PURPUR_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "purpur_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> QUARTZ_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "quartz_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> QUARTZ_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "quartz_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> REDSTONE_LAMP_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "redstone_lamp_lit");

    public static final Supplier<BooleanStateProperty> REDSTONE_ORE_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "redstone_ore_lit");

    public static final Supplier<BooleanStateProperty> REDSTONE_TORCH_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "redstone_torch_lit");

    public static final Supplier<BooleanStateProperty> REDSTONE_WALL_TORCH_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "redstone_wall_torch_lit");

    public static final Supplier<BooleanStateProperty> RED_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_bed_occupied");

    public static final Supplier<BooleanStateProperty> RED_MUSHROOM_BLOCK_DOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_mushroom_block_down");

    public static final Supplier<BooleanStateProperty> RED_MUSHROOM_BLOCK_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_mushroom_block_east");

    public static final Supplier<BooleanStateProperty> RED_MUSHROOM_BLOCK_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_mushroom_block_north");

    public static final Supplier<BooleanStateProperty> RED_MUSHROOM_BLOCK_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_mushroom_block_south");

    public static final Supplier<BooleanStateProperty> RED_MUSHROOM_BLOCK_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_mushroom_block_up");

    public static final Supplier<BooleanStateProperty> RED_MUSHROOM_BLOCK_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_mushroom_block_west");

    public static final Supplier<BooleanStateProperty> RED_NETHER_BRICK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_nether_brick_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> RED_NETHER_BRICK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_nether_brick_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> RED_NETHER_BRICK_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_nether_brick_wall_east");

    public static final Supplier<BooleanStateProperty> RED_NETHER_BRICK_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_nether_brick_wall_north");

    public static final Supplier<BooleanStateProperty> RED_NETHER_BRICK_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_nether_brick_wall_south");

    public static final Supplier<BooleanStateProperty> RED_NETHER_BRICK_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_nether_brick_wall_up");

    public static final Supplier<BooleanStateProperty> RED_NETHER_BRICK_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_nether_brick_wall_waterlogged");

    public static final Supplier<BooleanStateProperty> RED_NETHER_BRICK_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_nether_brick_wall_west");

    public static final Supplier<BooleanStateProperty> RED_SANDSTONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_sandstone_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> RED_SANDSTONE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_sandstone_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> RED_SANDSTONE_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_sandstone_wall_east");

    public static final Supplier<BooleanStateProperty> RED_SANDSTONE_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_sandstone_wall_north");

    public static final Supplier<BooleanStateProperty> RED_SANDSTONE_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_sandstone_wall_south");

    public static final Supplier<BooleanStateProperty> RED_SANDSTONE_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_sandstone_wall_up");

    public static final Supplier<BooleanStateProperty> RED_SANDSTONE_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_sandstone_wall_waterlogged");

    public static final Supplier<BooleanStateProperty> RED_SANDSTONE_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_sandstone_wall_west");

    public static final Supplier<BooleanStateProperty> RED_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_stained_glass_pane_east");

    public static final Supplier<BooleanStateProperty> RED_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_stained_glass_pane_north");

    public static final Supplier<BooleanStateProperty> RED_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_stained_glass_pane_south");

    public static final Supplier<BooleanStateProperty> RED_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_stained_glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> RED_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "red_stained_glass_pane_west");

    public static final Supplier<BooleanStateProperty> REPEATER_LOCKED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "repeater_locked");

    public static final Supplier<BooleanStateProperty> REPEATER_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "repeater_powered");

    public static final Supplier<BooleanStateProperty> REPEATING_COMMAND_BLOCK_CONDITIONAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "repeating_command_block_conditional");

    public static final Supplier<BooleanStateProperty> SANDSTONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "sandstone_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> SANDSTONE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "sandstone_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> SANDSTONE_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "sandstone_wall_east");

    public static final Supplier<BooleanStateProperty> SANDSTONE_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "sandstone_wall_north");

    public static final Supplier<BooleanStateProperty> SANDSTONE_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "sandstone_wall_south");

    public static final Supplier<BooleanStateProperty> SANDSTONE_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "sandstone_wall_up");

    public static final Supplier<BooleanStateProperty> SANDSTONE_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "sandstone_wall_waterlogged");

    public static final Supplier<BooleanStateProperty> SANDSTONE_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "sandstone_wall_west");

    public static final Supplier<BooleanStateProperty> SCAFFOLDING_BOTTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "scaffolding_bottom");

    public static final Supplier<BooleanStateProperty> SCAFFOLDING_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "scaffolding_waterlogged");

    public static final Supplier<BooleanStateProperty> SEA_PICKLE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "sea_pickle_waterlogged");

    public static final Supplier<BooleanStateProperty> SMOKER_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "smoker_lit");

    public static final Supplier<BooleanStateProperty> SMOOTH_QUARTZ_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "smooth_quartz_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> SMOOTH_QUARTZ_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "smooth_quartz_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> SMOOTH_RED_SANDSTONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "smooth_red_sandstone_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> SMOOTH_RED_SANDSTONE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "smooth_red_sandstone_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> SMOOTH_SANDSTONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "smooth_sandstone_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> SMOOTH_SANDSTONE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "smooth_sandstone_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> SMOOTH_STONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "smooth_stone_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> SPRUCE_BUTTON_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_button_powered");

    public static final Supplier<BooleanStateProperty> SPRUCE_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_door_open");

    public static final Supplier<BooleanStateProperty> SPRUCE_DOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_door_powered");

    public static final Supplier<BooleanStateProperty> SPRUCE_FENCE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_fence_east");

    public static final Supplier<BooleanStateProperty> SPRUCE_FENCE_GATE_IN_WALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_fence_gate_in_wall");

    public static final Supplier<BooleanStateProperty> SPRUCE_FENCE_GATE_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_fence_gate_open");

    public static final Supplier<BooleanStateProperty> SPRUCE_FENCE_GATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_fence_gate_powered");

    public static final Supplier<BooleanStateProperty> SPRUCE_FENCE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_fence_north");

    public static final Supplier<BooleanStateProperty> SPRUCE_FENCE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_fence_south");

    public static final Supplier<BooleanStateProperty> SPRUCE_FENCE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_fence_waterlogged");

    public static final Supplier<BooleanStateProperty> SPRUCE_FENCE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_fence_west");

    public static final Supplier<BooleanStateProperty> SPRUCE_LEAVES_PERSISTENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_leaves_persistent");

    public static final Supplier<BooleanStateProperty> SPRUCE_PRESSURE_PLATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_pressure_plate_powered");

    public static final Supplier<BooleanStateProperty> SPRUCE_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_sign_waterlogged");

    public static final Supplier<BooleanStateProperty> SPRUCE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> SPRUCE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> SPRUCE_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_trapdoor_open");

    public static final Supplier<BooleanStateProperty> SPRUCE_TRAPDOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_trapdoor_powered");

    public static final Supplier<BooleanStateProperty> SPRUCE_TRAPDOOR_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_trapdoor_waterlogged");

    public static final Supplier<BooleanStateProperty> SPRUCE_WALL_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "spruce_wall_sign_waterlogged");

    public static final Supplier<BooleanStateProperty> STICKY_PISTON_EXTENDED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "sticky_piston_extended");

    public static final Supplier<BooleanStateProperty> STONE_BRICK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "stone_brick_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> STONE_BRICK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "stone_brick_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> STONE_BRICK_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "stone_brick_wall_east");

    public static final Supplier<BooleanStateProperty> STONE_BRICK_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "stone_brick_wall_north");

    public static final Supplier<BooleanStateProperty> STONE_BRICK_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "stone_brick_wall_south");

    public static final Supplier<BooleanStateProperty> STONE_BRICK_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "stone_brick_wall_up");

    public static final Supplier<BooleanStateProperty> STONE_BRICK_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "stone_brick_wall_waterlogged");

    public static final Supplier<BooleanStateProperty> STONE_BRICK_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "stone_brick_wall_west");

    public static final Supplier<BooleanStateProperty> STONE_BUTTON_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "stone_button_powered");

    public static final Supplier<BooleanStateProperty> STONE_PRESSURE_PLATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "stone_pressure_plate_powered");

    public static final Supplier<BooleanStateProperty> STONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "stone_slab_waterlogged");

    public static final Supplier<BooleanStateProperty> STONE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "stone_stairs_waterlogged");

    public static final Supplier<BooleanStateProperty> TNT_UNSTABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "tnt_unstable");

    public static final Supplier<BooleanStateProperty> TRAPPED_CHEST_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "trapped_chest_waterlogged");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_ATTACHED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "tripwire_attached");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_DISARMED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "tripwire_disarmed");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "tripwire_east");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_HOOK_ATTACHED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "tripwire_hook_attached");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_HOOK_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "tripwire_hook_powered");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "tripwire_north");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "tripwire_powered");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "tripwire_south");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "tripwire_west");

    public static final Supplier<BooleanStateProperty> TUBE_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "tube_coral_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> TUBE_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "tube_coral_wall_fan_waterlogged");

    public static final Supplier<BooleanStateProperty> TUBE_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "tube_coral_waterlogged");

    public static final Supplier<BooleanStateProperty> VINE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "vine_east");

    public static final Supplier<BooleanStateProperty> VINE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "vine_north");

    public static final Supplier<BooleanStateProperty> VINE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "vine_south");

    public static final Supplier<BooleanStateProperty> VINE_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "vine_up");

    public static final Supplier<BooleanStateProperty> VINE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "vine_west");

    public static final Supplier<BooleanStateProperty> WHITE_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "white_bed_occupied");

    public static final Supplier<BooleanStateProperty> WHITE_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "white_stained_glass_pane_east");

    public static final Supplier<BooleanStateProperty> WHITE_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "white_stained_glass_pane_north");

    public static final Supplier<BooleanStateProperty> WHITE_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "white_stained_glass_pane_south");

    public static final Supplier<BooleanStateProperty> WHITE_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "white_stained_glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> WHITE_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "white_stained_glass_pane_west");

    public static final Supplier<BooleanStateProperty> YELLOW_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "yellow_bed_occupied");

    public static final Supplier<BooleanStateProperty> YELLOW_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "yellow_stained_glass_pane_east");

    public static final Supplier<BooleanStateProperty> YELLOW_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "yellow_stained_glass_pane_north");

    public static final Supplier<BooleanStateProperty> YELLOW_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "yellow_stained_glass_pane_south");

    public static final Supplier<BooleanStateProperty> YELLOW_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "yellow_stained_glass_pane_waterlogged");

    public static final Supplier<BooleanStateProperty> YELLOW_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "yellow_stained_glass_pane_west");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private BooleanStateProperties() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
