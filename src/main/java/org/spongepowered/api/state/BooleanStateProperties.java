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

    public static final Supplier<BooleanStateProperty> ACACIA_BUTTON_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_BUTTON_POWERED");

    public static final Supplier<BooleanStateProperty> ACACIA_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_DOOR_OPEN");

    public static final Supplier<BooleanStateProperty> ACACIA_DOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_DOOR_POWERED");

    public static final Supplier<BooleanStateProperty> ACACIA_FENCE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_FENCE_EAST");

    public static final Supplier<BooleanStateProperty> ACACIA_FENCE_GATE_IN_WALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_FENCE_GATE_IN_WALL");

    public static final Supplier<BooleanStateProperty> ACACIA_FENCE_GATE_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_FENCE_GATE_OPEN");

    public static final Supplier<BooleanStateProperty> ACACIA_FENCE_GATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_FENCE_GATE_POWERED");

    public static final Supplier<BooleanStateProperty> ACACIA_FENCE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_FENCE_NORTH");

    public static final Supplier<BooleanStateProperty> ACACIA_FENCE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_FENCE_SOUTH");

    public static final Supplier<BooleanStateProperty> ACACIA_FENCE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_FENCE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> ACACIA_FENCE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_FENCE_WEST");

    public static final Supplier<BooleanStateProperty> ACACIA_LEAVES_PERSISTENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_LEAVES_PERSISTENT");

    public static final Supplier<BooleanStateProperty> ACACIA_PRESSURE_PLATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_PRESSURE_PLATE_POWERED");

    public static final Supplier<BooleanStateProperty> ACACIA_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_SIGN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> ACACIA_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> ACACIA_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> ACACIA_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_TRAPDOOR_OPEN");

    public static final Supplier<BooleanStateProperty> ACACIA_TRAPDOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_TRAPDOOR_POWERED");

    public static final Supplier<BooleanStateProperty> ACACIA_TRAPDOOR_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_TRAPDOOR_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> ACACIA_WALL_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACACIA_WALL_SIGN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> ACTIVATOR_RAIL_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ACTIVATOR_RAIL_POWERED");

    public static final Supplier<BooleanStateProperty> ANDESITE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ANDESITE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> ANDESITE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ANDESITE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> ANDESITE_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ANDESITE_WALL_EAST");

    public static final Supplier<BooleanStateProperty> ANDESITE_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ANDESITE_WALL_NORTH");

    public static final Supplier<BooleanStateProperty> ANDESITE_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ANDESITE_WALL_SOUTH");

    public static final Supplier<BooleanStateProperty> ANDESITE_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ANDESITE_WALL_UP");

    public static final Supplier<BooleanStateProperty> ANDESITE_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ANDESITE_WALL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> ANDESITE_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ANDESITE_WALL_WEST");

    public static final Supplier<BooleanStateProperty> BARREL_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BARREL_OPEN");

    public static final Supplier<BooleanStateProperty> BIRCH_BUTTON_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_BUTTON_POWERED");

    public static final Supplier<BooleanStateProperty> BIRCH_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_DOOR_OPEN");

    public static final Supplier<BooleanStateProperty> BIRCH_DOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_DOOR_POWERED");

    public static final Supplier<BooleanStateProperty> BIRCH_FENCE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_FENCE_EAST");

    public static final Supplier<BooleanStateProperty> BIRCH_FENCE_GATE_IN_WALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_FENCE_GATE_IN_WALL");

    public static final Supplier<BooleanStateProperty> BIRCH_FENCE_GATE_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_FENCE_GATE_OPEN");

    public static final Supplier<BooleanStateProperty> BIRCH_FENCE_GATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_FENCE_GATE_POWERED");

    public static final Supplier<BooleanStateProperty> BIRCH_FENCE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_FENCE_NORTH");

    public static final Supplier<BooleanStateProperty> BIRCH_FENCE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_FENCE_SOUTH");

    public static final Supplier<BooleanStateProperty> BIRCH_FENCE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_FENCE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BIRCH_FENCE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_FENCE_WEST");

    public static final Supplier<BooleanStateProperty> BIRCH_LEAVES_PERSISTENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_LEAVES_PERSISTENT");

    public static final Supplier<BooleanStateProperty> BIRCH_PRESSURE_PLATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_PRESSURE_PLATE_POWERED");

    public static final Supplier<BooleanStateProperty> BIRCH_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_SIGN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BIRCH_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BIRCH_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BIRCH_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_TRAPDOOR_OPEN");

    public static final Supplier<BooleanStateProperty> BIRCH_TRAPDOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_TRAPDOOR_POWERED");

    public static final Supplier<BooleanStateProperty> BIRCH_TRAPDOOR_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_TRAPDOOR_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BIRCH_WALL_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BIRCH_WALL_SIGN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BLACK_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BLACK_BED_OCCUPIED");

    public static final Supplier<BooleanStateProperty> BLACK_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BLACK_STAINED_GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> BLACK_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BLACK_STAINED_GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> BLACK_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BLACK_STAINED_GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> BLACK_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BLACK_STAINED_GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BLACK_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BLACK_STAINED_GLASS_PANE_WEST");

    public static final Supplier<BooleanStateProperty> BLAST_FURNACE_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BLAST_FURNACE_LIT");

    public static final Supplier<BooleanStateProperty> BLUE_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BLUE_BED_OCCUPIED");

    public static final Supplier<BooleanStateProperty> BLUE_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BLUE_STAINED_GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> BLUE_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BLUE_STAINED_GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> BLUE_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BLUE_STAINED_GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> BLUE_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BLUE_STAINED_GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BLUE_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BLUE_STAINED_GLASS_PANE_WEST");

    public static final Supplier<BooleanStateProperty> BRAIN_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BRAIN_CORAL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BRAIN_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BRAIN_CORAL_WALL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BRAIN_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BRAIN_CORAL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BREWING_STAND_HAS_BOTTLE_0 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BREWING_STAND_HAS_BOTTLE_0");

    public static final Supplier<BooleanStateProperty> BREWING_STAND_HAS_BOTTLE_1 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BREWING_STAND_HAS_BOTTLE_1");

    public static final Supplier<BooleanStateProperty> BREWING_STAND_HAS_BOTTLE_2 = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BREWING_STAND_HAS_BOTTLE_2");

    public static final Supplier<BooleanStateProperty> BRICK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BRICK_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BRICK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BRICK_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BRICK_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BRICK_WALL_EAST");

    public static final Supplier<BooleanStateProperty> BRICK_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BRICK_WALL_NORTH");

    public static final Supplier<BooleanStateProperty> BRICK_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BRICK_WALL_SOUTH");

    public static final Supplier<BooleanStateProperty> BRICK_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BRICK_WALL_UP");

    public static final Supplier<BooleanStateProperty> BRICK_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BRICK_WALL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BRICK_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BRICK_WALL_WEST");

    public static final Supplier<BooleanStateProperty> BROWN_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BROWN_BED_OCCUPIED");

    public static final Supplier<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_DOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BROWN_MUSHROOM_BLOCK_DOWN");

    public static final Supplier<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BROWN_MUSHROOM_BLOCK_EAST");

    public static final Supplier<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BROWN_MUSHROOM_BLOCK_NORTH");

    public static final Supplier<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BROWN_MUSHROOM_BLOCK_SOUTH");

    public static final Supplier<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BROWN_MUSHROOM_BLOCK_UP");

    public static final Supplier<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BROWN_MUSHROOM_BLOCK_WEST");

    public static final Supplier<BooleanStateProperty> BROWN_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BROWN_STAINED_GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> BROWN_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BROWN_STAINED_GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> BROWN_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BROWN_STAINED_GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> BROWN_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BROWN_STAINED_GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BROWN_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BROWN_STAINED_GLASS_PANE_WEST");

    public static final Supplier<BooleanStateProperty> BUBBLE_COLUMN_DRAG = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BUBBLE_COLUMN_DRAG");

    public static final Supplier<BooleanStateProperty> BUBBLE_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BUBBLE_CORAL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BUBBLE_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BUBBLE_CORAL_WALL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> BUBBLE_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "BUBBLE_CORAL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> CAMPFIRE_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CAMPFIRE_LIT");

    public static final Supplier<BooleanStateProperty> CAMPFIRE_SIGNAL_FIRE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CAMPFIRE_SIGNAL_FIRE");

    public static final Supplier<BooleanStateProperty> CAMPFIRE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CAMPFIRE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> CHAIN_COMMAND_BLOCK_CONDITIONAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CHAIN_COMMAND_BLOCK_CONDITIONAL");

    public static final Supplier<BooleanStateProperty> CHEST_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CHEST_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> CHORUS_PLANT_DOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CHORUS_PLANT_DOWN");

    public static final Supplier<BooleanStateProperty> CHORUS_PLANT_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CHORUS_PLANT_EAST");

    public static final Supplier<BooleanStateProperty> CHORUS_PLANT_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CHORUS_PLANT_NORTH");

    public static final Supplier<BooleanStateProperty> CHORUS_PLANT_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CHORUS_PLANT_SOUTH");

    public static final Supplier<BooleanStateProperty> CHORUS_PLANT_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CHORUS_PLANT_UP");

    public static final Supplier<BooleanStateProperty> CHORUS_PLANT_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CHORUS_PLANT_WEST");

    public static final Supplier<BooleanStateProperty> COBBLESTONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "COBBLESTONE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> COBBLESTONE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "COBBLESTONE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> COBBLESTONE_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "COBBLESTONE_WALL_EAST");

    public static final Supplier<BooleanStateProperty> COBBLESTONE_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "COBBLESTONE_WALL_NORTH");

    public static final Supplier<BooleanStateProperty> COBBLESTONE_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "COBBLESTONE_WALL_SOUTH");

    public static final Supplier<BooleanStateProperty> COBBLESTONE_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "COBBLESTONE_WALL_UP");

    public static final Supplier<BooleanStateProperty> COBBLESTONE_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "COBBLESTONE_WALL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> COBBLESTONE_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "COBBLESTONE_WALL_WEST");

    public static final Supplier<BooleanStateProperty> COMMAND_BLOCK_CONDITIONAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "COMMAND_BLOCK_CONDITIONAL");

    public static final Supplier<BooleanStateProperty> COMPARATOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "COMPARATOR_POWERED");

    public static final Supplier<BooleanStateProperty> CONDUIT_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CONDUIT_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> CUT_RED_SANDSTONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CUT_RED_SANDSTONE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> CUT_SANDSTONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CUT_SANDSTONE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> CYAN_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CYAN_BED_OCCUPIED");

    public static final Supplier<BooleanStateProperty> CYAN_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CYAN_STAINED_GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> CYAN_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CYAN_STAINED_GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> CYAN_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CYAN_STAINED_GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> CYAN_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CYAN_STAINED_GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> CYAN_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "CYAN_STAINED_GLASS_PANE_WEST");

    public static final Supplier<BooleanStateProperty> DARK_OAK_BUTTON_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_BUTTON_POWERED");

    public static final Supplier<BooleanStateProperty> DARK_OAK_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_DOOR_OPEN");

    public static final Supplier<BooleanStateProperty> DARK_OAK_DOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_DOOR_POWERED");

    public static final Supplier<BooleanStateProperty> DARK_OAK_FENCE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_FENCE_EAST");

    public static final Supplier<BooleanStateProperty> DARK_OAK_FENCE_GATE_IN_WALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_FENCE_GATE_IN_WALL");

    public static final Supplier<BooleanStateProperty> DARK_OAK_FENCE_GATE_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_FENCE_GATE_OPEN");

    public static final Supplier<BooleanStateProperty> DARK_OAK_FENCE_GATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_FENCE_GATE_POWERED");

    public static final Supplier<BooleanStateProperty> DARK_OAK_FENCE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_FENCE_NORTH");

    public static final Supplier<BooleanStateProperty> DARK_OAK_FENCE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_FENCE_SOUTH");

    public static final Supplier<BooleanStateProperty> DARK_OAK_FENCE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_FENCE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DARK_OAK_FENCE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_FENCE_WEST");

    public static final Supplier<BooleanStateProperty> DARK_OAK_LEAVES_PERSISTENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_LEAVES_PERSISTENT");

    public static final Supplier<BooleanStateProperty> DARK_OAK_PRESSURE_PLATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_PRESSURE_PLATE_POWERED");

    public static final Supplier<BooleanStateProperty> DARK_OAK_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_SIGN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DARK_OAK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DARK_OAK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DARK_OAK_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_TRAPDOOR_OPEN");

    public static final Supplier<BooleanStateProperty> DARK_OAK_TRAPDOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_TRAPDOOR_POWERED");

    public static final Supplier<BooleanStateProperty> DARK_OAK_TRAPDOOR_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_TRAPDOOR_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DARK_OAK_WALL_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_OAK_WALL_SIGN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DARK_PRISMARINE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_PRISMARINE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DARK_PRISMARINE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DARK_PRISMARINE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DAYLIGHT_DETECTOR_INVERTED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DAYLIGHT_DETECTOR_INVERTED");

    public static final Supplier<BooleanStateProperty> DEAD_BRAIN_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DEAD_BRAIN_CORAL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DEAD_BRAIN_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DEAD_BRAIN_CORAL_WALL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DEAD_BRAIN_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DEAD_BRAIN_CORAL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DEAD_BUBBLE_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DEAD_BUBBLE_CORAL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DEAD_BUBBLE_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DEAD_BUBBLE_CORAL_WALL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DEAD_BUBBLE_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DEAD_BUBBLE_CORAL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DEAD_FIRE_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DEAD_FIRE_CORAL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DEAD_FIRE_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DEAD_FIRE_CORAL_WALL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DEAD_FIRE_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DEAD_FIRE_CORAL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DEAD_HORN_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DEAD_HORN_CORAL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DEAD_HORN_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DEAD_HORN_CORAL_WALL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DEAD_HORN_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DEAD_HORN_CORAL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DEAD_TUBE_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DEAD_TUBE_CORAL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DEAD_TUBE_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DEAD_TUBE_CORAL_WALL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DEAD_TUBE_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DEAD_TUBE_CORAL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DETECTOR_RAIL_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DETECTOR_RAIL_POWERED");

    public static final Supplier<BooleanStateProperty> DIORITE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DIORITE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DIORITE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DIORITE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DIORITE_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DIORITE_WALL_EAST");

    public static final Supplier<BooleanStateProperty> DIORITE_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DIORITE_WALL_NORTH");

    public static final Supplier<BooleanStateProperty> DIORITE_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DIORITE_WALL_SOUTH");

    public static final Supplier<BooleanStateProperty> DIORITE_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DIORITE_WALL_UP");

    public static final Supplier<BooleanStateProperty> DIORITE_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DIORITE_WALL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> DIORITE_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DIORITE_WALL_WEST");

    public static final Supplier<BooleanStateProperty> DISPENSER_TRIGGERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DISPENSER_TRIGGERED");

    public static final Supplier<BooleanStateProperty> DROPPER_TRIGGERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "DROPPER_TRIGGERED");

    public static final Supplier<BooleanStateProperty> ENDER_CHEST_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ENDER_CHEST_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> END_PORTAL_FRAME_EYE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "END_PORTAL_FRAME_EYE");

    public static final Supplier<BooleanStateProperty> END_STONE_BRICK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "END_STONE_BRICK_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> END_STONE_BRICK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "END_STONE_BRICK_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> END_STONE_BRICK_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "END_STONE_BRICK_WALL_EAST");

    public static final Supplier<BooleanStateProperty> END_STONE_BRICK_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "END_STONE_BRICK_WALL_NORTH");

    public static final Supplier<BooleanStateProperty> END_STONE_BRICK_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "END_STONE_BRICK_WALL_SOUTH");

    public static final Supplier<BooleanStateProperty> END_STONE_BRICK_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "END_STONE_BRICK_WALL_UP");

    public static final Supplier<BooleanStateProperty> END_STONE_BRICK_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "END_STONE_BRICK_WALL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> END_STONE_BRICK_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "END_STONE_BRICK_WALL_WEST");

    public static final Supplier<BooleanStateProperty> FIRE_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "FIRE_CORAL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> FIRE_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "FIRE_CORAL_WALL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> FIRE_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "FIRE_CORAL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> FIRE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "FIRE_EAST");

    public static final Supplier<BooleanStateProperty> FIRE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "FIRE_NORTH");

    public static final Supplier<BooleanStateProperty> FIRE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "FIRE_SOUTH");

    public static final Supplier<BooleanStateProperty> FIRE_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "FIRE_UP");

    public static final Supplier<BooleanStateProperty> FIRE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "FIRE_WEST");

    public static final Supplier<BooleanStateProperty> FURNACE_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "FURNACE_LIT");

    public static final Supplier<BooleanStateProperty> GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GLASS_PANE_WEST");

    public static final Supplier<BooleanStateProperty> GRANITE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GRANITE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> GRANITE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GRANITE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> GRANITE_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GRANITE_WALL_EAST");

    public static final Supplier<BooleanStateProperty> GRANITE_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GRANITE_WALL_NORTH");

    public static final Supplier<BooleanStateProperty> GRANITE_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GRANITE_WALL_SOUTH");

    public static final Supplier<BooleanStateProperty> GRANITE_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GRANITE_WALL_UP");

    public static final Supplier<BooleanStateProperty> GRANITE_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GRANITE_WALL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> GRANITE_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GRANITE_WALL_WEST");

    public static final Supplier<BooleanStateProperty> GRASS_BLOCK_SNOWY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GRASS_BLOCK_SNOWY");

    public static final Supplier<BooleanStateProperty> GRAY_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GRAY_BED_OCCUPIED");

    public static final Supplier<BooleanStateProperty> GRAY_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GRAY_STAINED_GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> GRAY_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GRAY_STAINED_GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> GRAY_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GRAY_STAINED_GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> GRAY_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GRAY_STAINED_GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> GRAY_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GRAY_STAINED_GLASS_PANE_WEST");

    public static final Supplier<BooleanStateProperty> GREEN_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GREEN_BED_OCCUPIED");

    public static final Supplier<BooleanStateProperty> GREEN_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GREEN_STAINED_GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> GREEN_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GREEN_STAINED_GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> GREEN_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GREEN_STAINED_GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> GREEN_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GREEN_STAINED_GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> GREEN_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "GREEN_STAINED_GLASS_PANE_WEST");

    public static final Supplier<BooleanStateProperty> HOPPER_ENABLED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "HOPPER_ENABLED");

    public static final Supplier<BooleanStateProperty> HORN_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "HORN_CORAL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> HORN_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "HORN_CORAL_WALL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> HORN_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "HORN_CORAL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> IRON_BARS_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "IRON_BARS_EAST");

    public static final Supplier<BooleanStateProperty> IRON_BARS_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "IRON_BARS_NORTH");

    public static final Supplier<BooleanStateProperty> IRON_BARS_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "IRON_BARS_SOUTH");

    public static final Supplier<BooleanStateProperty> IRON_BARS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "IRON_BARS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> IRON_BARS_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "IRON_BARS_WEST");

    public static final Supplier<BooleanStateProperty> IRON_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "IRON_DOOR_OPEN");

    public static final Supplier<BooleanStateProperty> IRON_DOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "IRON_DOOR_POWERED");

    public static final Supplier<BooleanStateProperty> IRON_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "IRON_TRAPDOOR_OPEN");

    public static final Supplier<BooleanStateProperty> IRON_TRAPDOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "IRON_TRAPDOOR_POWERED");

    public static final Supplier<BooleanStateProperty> IRON_TRAPDOOR_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "IRON_TRAPDOOR_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> JUKEBOX_HAS_RECORD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUKEBOX_HAS_RECORD");

    public static final Supplier<BooleanStateProperty> JUNGLE_BUTTON_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_BUTTON_POWERED");

    public static final Supplier<BooleanStateProperty> JUNGLE_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_DOOR_OPEN");

    public static final Supplier<BooleanStateProperty> JUNGLE_DOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_DOOR_POWERED");

    public static final Supplier<BooleanStateProperty> JUNGLE_FENCE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_FENCE_EAST");

    public static final Supplier<BooleanStateProperty> JUNGLE_FENCE_GATE_IN_WALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_FENCE_GATE_IN_WALL");

    public static final Supplier<BooleanStateProperty> JUNGLE_FENCE_GATE_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_FENCE_GATE_OPEN");

    public static final Supplier<BooleanStateProperty> JUNGLE_FENCE_GATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_FENCE_GATE_POWERED");

    public static final Supplier<BooleanStateProperty> JUNGLE_FENCE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_FENCE_NORTH");

    public static final Supplier<BooleanStateProperty> JUNGLE_FENCE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_FENCE_SOUTH");

    public static final Supplier<BooleanStateProperty> JUNGLE_FENCE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_FENCE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> JUNGLE_FENCE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_FENCE_WEST");

    public static final Supplier<BooleanStateProperty> JUNGLE_LEAVES_PERSISTENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_LEAVES_PERSISTENT");

    public static final Supplier<BooleanStateProperty> JUNGLE_PRESSURE_PLATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_PRESSURE_PLATE_POWERED");

    public static final Supplier<BooleanStateProperty> JUNGLE_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_SIGN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> JUNGLE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> JUNGLE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> JUNGLE_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_TRAPDOOR_OPEN");

    public static final Supplier<BooleanStateProperty> JUNGLE_TRAPDOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_TRAPDOOR_POWERED");

    public static final Supplier<BooleanStateProperty> JUNGLE_TRAPDOOR_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_TRAPDOOR_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> JUNGLE_WALL_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "JUNGLE_WALL_SIGN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> LADDER_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LADDER_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> LANTERN_HANGING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LANTERN_HANGING");

    public static final Supplier<BooleanStateProperty> LECTERN_HAS_BOOK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LECTERN_HAS_BOOK");

    public static final Supplier<BooleanStateProperty> LECTERN_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LECTERN_POWERED");

    public static final Supplier<BooleanStateProperty> LEVER_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LEVER_POWERED");

    public static final Supplier<BooleanStateProperty> LIGHT_BLUE_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIGHT_BLUE_BED_OCCUPIED");

    public static final Supplier<BooleanStateProperty> LIGHT_BLUE_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIGHT_BLUE_STAINED_GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> LIGHT_BLUE_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIGHT_BLUE_STAINED_GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> LIGHT_BLUE_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIGHT_BLUE_STAINED_GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> LIGHT_BLUE_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIGHT_BLUE_STAINED_GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> LIGHT_BLUE_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIGHT_BLUE_STAINED_GLASS_PANE_WEST");

    public static final Supplier<BooleanStateProperty> LIGHT_GRAY_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIGHT_GRAY_BED_OCCUPIED");

    public static final Supplier<BooleanStateProperty> LIGHT_GRAY_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIGHT_GRAY_STAINED_GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> LIGHT_GRAY_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIGHT_GRAY_STAINED_GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> LIGHT_GRAY_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIGHT_GRAY_STAINED_GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> LIGHT_GRAY_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIGHT_GRAY_STAINED_GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> LIGHT_GRAY_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIGHT_GRAY_STAINED_GLASS_PANE_WEST");

    public static final Supplier<BooleanStateProperty> LIME_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIME_BED_OCCUPIED");

    public static final Supplier<BooleanStateProperty> LIME_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIME_STAINED_GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> LIME_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIME_STAINED_GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> LIME_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIME_STAINED_GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> LIME_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIME_STAINED_GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> LIME_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "LIME_STAINED_GLASS_PANE_WEST");

    public static final Supplier<BooleanStateProperty> MAGENTA_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MAGENTA_BED_OCCUPIED");

    public static final Supplier<BooleanStateProperty> MAGENTA_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MAGENTA_STAINED_GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> MAGENTA_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MAGENTA_STAINED_GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> MAGENTA_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MAGENTA_STAINED_GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> MAGENTA_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MAGENTA_STAINED_GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> MAGENTA_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MAGENTA_STAINED_GLASS_PANE_WEST");

    public static final Supplier<BooleanStateProperty> MOSSY_COBBLESTONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MOSSY_COBBLESTONE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> MOSSY_COBBLESTONE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MOSSY_COBBLESTONE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MOSSY_COBBLESTONE_WALL_EAST");

    public static final Supplier<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MOSSY_COBBLESTONE_WALL_NORTH");

    public static final Supplier<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MOSSY_COBBLESTONE_WALL_SOUTH");

    public static final Supplier<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MOSSY_COBBLESTONE_WALL_UP");

    public static final Supplier<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MOSSY_COBBLESTONE_WALL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MOSSY_COBBLESTONE_WALL_WEST");

    public static final Supplier<BooleanStateProperty> MOSSY_STONE_BRICK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MOSSY_STONE_BRICK_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> MOSSY_STONE_BRICK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MOSSY_STONE_BRICK_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MOSSY_STONE_BRICK_WALL_EAST");

    public static final Supplier<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MOSSY_STONE_BRICK_WALL_NORTH");

    public static final Supplier<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MOSSY_STONE_BRICK_WALL_SOUTH");

    public static final Supplier<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MOSSY_STONE_BRICK_WALL_UP");

    public static final Supplier<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MOSSY_STONE_BRICK_WALL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MOSSY_STONE_BRICK_WALL_WEST");

    public static final Supplier<BooleanStateProperty> MUSHROOM_STEM_DOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MUSHROOM_STEM_DOWN");

    public static final Supplier<BooleanStateProperty> MUSHROOM_STEM_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MUSHROOM_STEM_EAST");

    public static final Supplier<BooleanStateProperty> MUSHROOM_STEM_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MUSHROOM_STEM_NORTH");

    public static final Supplier<BooleanStateProperty> MUSHROOM_STEM_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MUSHROOM_STEM_SOUTH");

    public static final Supplier<BooleanStateProperty> MUSHROOM_STEM_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MUSHROOM_STEM_UP");

    public static final Supplier<BooleanStateProperty> MUSHROOM_STEM_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MUSHROOM_STEM_WEST");

    public static final Supplier<BooleanStateProperty> MYCELIUM_SNOWY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "MYCELIUM_SNOWY");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_FENCE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "NETHER_BRICK_FENCE_EAST");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_FENCE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "NETHER_BRICK_FENCE_NORTH");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_FENCE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "NETHER_BRICK_FENCE_SOUTH");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_FENCE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "NETHER_BRICK_FENCE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_FENCE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "NETHER_BRICK_FENCE_WEST");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "NETHER_BRICK_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "NETHER_BRICK_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "NETHER_BRICK_WALL_EAST");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "NETHER_BRICK_WALL_NORTH");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "NETHER_BRICK_WALL_SOUTH");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "NETHER_BRICK_WALL_UP");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "NETHER_BRICK_WALL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> NETHER_BRICK_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "NETHER_BRICK_WALL_WEST");

    public static final Supplier<BooleanStateProperty> NOTE_BLOCK_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "NOTE_BLOCK_POWERED");

    public static final Supplier<BooleanStateProperty> OAK_BUTTON_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_BUTTON_POWERED");

    public static final Supplier<BooleanStateProperty> OAK_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_DOOR_OPEN");

    public static final Supplier<BooleanStateProperty> OAK_DOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_DOOR_POWERED");

    public static final Supplier<BooleanStateProperty> OAK_FENCE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_FENCE_EAST");

    public static final Supplier<BooleanStateProperty> OAK_FENCE_GATE_IN_WALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_FENCE_GATE_IN_WALL");

    public static final Supplier<BooleanStateProperty> OAK_FENCE_GATE_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_FENCE_GATE_OPEN");

    public static final Supplier<BooleanStateProperty> OAK_FENCE_GATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_FENCE_GATE_POWERED");

    public static final Supplier<BooleanStateProperty> OAK_FENCE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_FENCE_NORTH");

    public static final Supplier<BooleanStateProperty> OAK_FENCE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_FENCE_SOUTH");

    public static final Supplier<BooleanStateProperty> OAK_FENCE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_FENCE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> OAK_FENCE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_FENCE_WEST");

    public static final Supplier<BooleanStateProperty> OAK_LEAVES_PERSISTENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_LEAVES_PERSISTENT");

    public static final Supplier<BooleanStateProperty> OAK_PRESSURE_PLATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_PRESSURE_PLATE_POWERED");

    public static final Supplier<BooleanStateProperty> OAK_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_SIGN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> OAK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> OAK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> OAK_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_TRAPDOOR_OPEN");

    public static final Supplier<BooleanStateProperty> OAK_TRAPDOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_TRAPDOOR_POWERED");

    public static final Supplier<BooleanStateProperty> OAK_TRAPDOOR_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_TRAPDOOR_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> OAK_WALL_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OAK_WALL_SIGN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> OBSERVER_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "OBSERVER_POWERED");

    public static final Supplier<BooleanStateProperty> ORANGE_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ORANGE_BED_OCCUPIED");

    public static final Supplier<BooleanStateProperty> ORANGE_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ORANGE_STAINED_GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> ORANGE_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ORANGE_STAINED_GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> ORANGE_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ORANGE_STAINED_GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> ORANGE_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ORANGE_STAINED_GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> ORANGE_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "ORANGE_STAINED_GLASS_PANE_WEST");

    public static final Supplier<BooleanStateProperty> PETRIFIED_OAK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PETRIFIED_OAK_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> PINK_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PINK_BED_OCCUPIED");

    public static final Supplier<BooleanStateProperty> PINK_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PINK_STAINED_GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> PINK_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PINK_STAINED_GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> PINK_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PINK_STAINED_GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> PINK_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PINK_STAINED_GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> PINK_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PINK_STAINED_GLASS_PANE_WEST");

    public static final Supplier<BooleanStateProperty> PISTON_EXTENDED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PISTON_EXTENDED");

    public static final Supplier<BooleanStateProperty> PISTON_HEAD_SHORT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PISTON_HEAD_SHORT");

    public static final Supplier<BooleanStateProperty> PODZOL_SNOWY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PODZOL_SNOWY");

    public static final Supplier<BooleanStateProperty> POLISHED_ANDESITE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "POLISHED_ANDESITE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> POLISHED_ANDESITE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "POLISHED_ANDESITE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> POLISHED_DIORITE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "POLISHED_DIORITE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> POLISHED_DIORITE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "POLISHED_DIORITE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> POLISHED_GRANITE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "POLISHED_GRANITE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> POLISHED_GRANITE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "POLISHED_GRANITE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> POWERED_RAIL_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "POWERED_RAIL_POWERED");

    public static final Supplier<BooleanStateProperty> PRISMARINE_BRICK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PRISMARINE_BRICK_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> PRISMARINE_BRICK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PRISMARINE_BRICK_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> PRISMARINE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PRISMARINE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> PRISMARINE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PRISMARINE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> PRISMARINE_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PRISMARINE_WALL_EAST");

    public static final Supplier<BooleanStateProperty> PRISMARINE_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PRISMARINE_WALL_NORTH");

    public static final Supplier<BooleanStateProperty> PRISMARINE_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PRISMARINE_WALL_SOUTH");

    public static final Supplier<BooleanStateProperty> PRISMARINE_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PRISMARINE_WALL_UP");

    public static final Supplier<BooleanStateProperty> PRISMARINE_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PRISMARINE_WALL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> PRISMARINE_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PRISMARINE_WALL_WEST");

    public static final Supplier<BooleanStateProperty> PURPLE_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PURPLE_BED_OCCUPIED");

    public static final Supplier<BooleanStateProperty> PURPLE_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PURPLE_STAINED_GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> PURPLE_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PURPLE_STAINED_GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> PURPLE_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PURPLE_STAINED_GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> PURPLE_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PURPLE_STAINED_GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> PURPLE_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PURPLE_STAINED_GLASS_PANE_WEST");

    public static final Supplier<BooleanStateProperty> PURPUR_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PURPUR_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> PURPUR_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "PURPUR_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> QUARTZ_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "QUARTZ_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> QUARTZ_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "QUARTZ_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> REDSTONE_LAMP_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "REDSTONE_LAMP_LIT");

    public static final Supplier<BooleanStateProperty> REDSTONE_ORE_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "REDSTONE_ORE_LIT");

    public static final Supplier<BooleanStateProperty> REDSTONE_TORCH_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "REDSTONE_TORCH_LIT");

    public static final Supplier<BooleanStateProperty> REDSTONE_WALL_TORCH_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "REDSTONE_WALL_TORCH_LIT");

    public static final Supplier<BooleanStateProperty> RED_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_BED_OCCUPIED");

    public static final Supplier<BooleanStateProperty> RED_MUSHROOM_BLOCK_DOWN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_MUSHROOM_BLOCK_DOWN");

    public static final Supplier<BooleanStateProperty> RED_MUSHROOM_BLOCK_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_MUSHROOM_BLOCK_EAST");

    public static final Supplier<BooleanStateProperty> RED_MUSHROOM_BLOCK_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_MUSHROOM_BLOCK_NORTH");

    public static final Supplier<BooleanStateProperty> RED_MUSHROOM_BLOCK_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_MUSHROOM_BLOCK_SOUTH");

    public static final Supplier<BooleanStateProperty> RED_MUSHROOM_BLOCK_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_MUSHROOM_BLOCK_UP");

    public static final Supplier<BooleanStateProperty> RED_MUSHROOM_BLOCK_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_MUSHROOM_BLOCK_WEST");

    public static final Supplier<BooleanStateProperty> RED_NETHER_BRICK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_NETHER_BRICK_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> RED_NETHER_BRICK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_NETHER_BRICK_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> RED_NETHER_BRICK_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_NETHER_BRICK_WALL_EAST");

    public static final Supplier<BooleanStateProperty> RED_NETHER_BRICK_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_NETHER_BRICK_WALL_NORTH");

    public static final Supplier<BooleanStateProperty> RED_NETHER_BRICK_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_NETHER_BRICK_WALL_SOUTH");

    public static final Supplier<BooleanStateProperty> RED_NETHER_BRICK_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_NETHER_BRICK_WALL_UP");

    public static final Supplier<BooleanStateProperty> RED_NETHER_BRICK_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_NETHER_BRICK_WALL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> RED_NETHER_BRICK_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_NETHER_BRICK_WALL_WEST");

    public static final Supplier<BooleanStateProperty> RED_SANDSTONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_SANDSTONE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> RED_SANDSTONE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_SANDSTONE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> RED_SANDSTONE_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_SANDSTONE_WALL_EAST");

    public static final Supplier<BooleanStateProperty> RED_SANDSTONE_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_SANDSTONE_WALL_NORTH");

    public static final Supplier<BooleanStateProperty> RED_SANDSTONE_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_SANDSTONE_WALL_SOUTH");

    public static final Supplier<BooleanStateProperty> RED_SANDSTONE_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_SANDSTONE_WALL_UP");

    public static final Supplier<BooleanStateProperty> RED_SANDSTONE_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_SANDSTONE_WALL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> RED_SANDSTONE_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_SANDSTONE_WALL_WEST");

    public static final Supplier<BooleanStateProperty> RED_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_STAINED_GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> RED_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_STAINED_GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> RED_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_STAINED_GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> RED_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_STAINED_GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> RED_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "RED_STAINED_GLASS_PANE_WEST");

    public static final Supplier<BooleanStateProperty> REPEATER_LOCKED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "REPEATER_LOCKED");

    public static final Supplier<BooleanStateProperty> REPEATER_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "REPEATER_POWERED");

    public static final Supplier<BooleanStateProperty> REPEATING_COMMAND_BLOCK_CONDITIONAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "REPEATING_COMMAND_BLOCK_CONDITIONAL");

    public static final Supplier<BooleanStateProperty> SANDSTONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SANDSTONE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SANDSTONE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SANDSTONE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SANDSTONE_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SANDSTONE_WALL_EAST");

    public static final Supplier<BooleanStateProperty> SANDSTONE_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SANDSTONE_WALL_NORTH");

    public static final Supplier<BooleanStateProperty> SANDSTONE_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SANDSTONE_WALL_SOUTH");

    public static final Supplier<BooleanStateProperty> SANDSTONE_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SANDSTONE_WALL_UP");

    public static final Supplier<BooleanStateProperty> SANDSTONE_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SANDSTONE_WALL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SANDSTONE_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SANDSTONE_WALL_WEST");

    public static final Supplier<BooleanStateProperty> SCAFFOLDING_BOTTOM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SCAFFOLDING_BOTTOM");

    public static final Supplier<BooleanStateProperty> SCAFFOLDING_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SCAFFOLDING_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SEA_PICKLE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SEA_PICKLE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SMOKER_LIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SMOKER_LIT");

    public static final Supplier<BooleanStateProperty> SMOOTH_QUARTZ_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SMOOTH_QUARTZ_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SMOOTH_QUARTZ_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SMOOTH_QUARTZ_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SMOOTH_RED_SANDSTONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SMOOTH_RED_SANDSTONE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SMOOTH_RED_SANDSTONE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SMOOTH_RED_SANDSTONE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SMOOTH_SANDSTONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SMOOTH_SANDSTONE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SMOOTH_SANDSTONE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SMOOTH_SANDSTONE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SMOOTH_STONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SMOOTH_STONE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SPRUCE_BUTTON_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_BUTTON_POWERED");

    public static final Supplier<BooleanStateProperty> SPRUCE_DOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_DOOR_OPEN");

    public static final Supplier<BooleanStateProperty> SPRUCE_DOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_DOOR_POWERED");

    public static final Supplier<BooleanStateProperty> SPRUCE_FENCE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_FENCE_EAST");

    public static final Supplier<BooleanStateProperty> SPRUCE_FENCE_GATE_IN_WALL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_FENCE_GATE_IN_WALL");

    public static final Supplier<BooleanStateProperty> SPRUCE_FENCE_GATE_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_FENCE_GATE_OPEN");

    public static final Supplier<BooleanStateProperty> SPRUCE_FENCE_GATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_FENCE_GATE_POWERED");

    public static final Supplier<BooleanStateProperty> SPRUCE_FENCE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_FENCE_NORTH");

    public static final Supplier<BooleanStateProperty> SPRUCE_FENCE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_FENCE_SOUTH");

    public static final Supplier<BooleanStateProperty> SPRUCE_FENCE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_FENCE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SPRUCE_FENCE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_FENCE_WEST");

    public static final Supplier<BooleanStateProperty> SPRUCE_LEAVES_PERSISTENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_LEAVES_PERSISTENT");

    public static final Supplier<BooleanStateProperty> SPRUCE_PRESSURE_PLATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_PRESSURE_PLATE_POWERED");

    public static final Supplier<BooleanStateProperty> SPRUCE_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_SIGN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SPRUCE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SPRUCE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SPRUCE_TRAPDOOR_OPEN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_TRAPDOOR_OPEN");

    public static final Supplier<BooleanStateProperty> SPRUCE_TRAPDOOR_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_TRAPDOOR_POWERED");

    public static final Supplier<BooleanStateProperty> SPRUCE_TRAPDOOR_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_TRAPDOOR_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> SPRUCE_WALL_SIGN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "SPRUCE_WALL_SIGN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> STICKY_PISTON_EXTENDED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "STICKY_PISTON_EXTENDED");

    public static final Supplier<BooleanStateProperty> STONE_BRICK_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "STONE_BRICK_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> STONE_BRICK_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "STONE_BRICK_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> STONE_BRICK_WALL_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "STONE_BRICK_WALL_EAST");

    public static final Supplier<BooleanStateProperty> STONE_BRICK_WALL_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "STONE_BRICK_WALL_NORTH");

    public static final Supplier<BooleanStateProperty> STONE_BRICK_WALL_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "STONE_BRICK_WALL_SOUTH");

    public static final Supplier<BooleanStateProperty> STONE_BRICK_WALL_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "STONE_BRICK_WALL_UP");

    public static final Supplier<BooleanStateProperty> STONE_BRICK_WALL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "STONE_BRICK_WALL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> STONE_BRICK_WALL_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "STONE_BRICK_WALL_WEST");

    public static final Supplier<BooleanStateProperty> STONE_BUTTON_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "STONE_BUTTON_POWERED");

    public static final Supplier<BooleanStateProperty> STONE_PRESSURE_PLATE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "STONE_PRESSURE_PLATE_POWERED");

    public static final Supplier<BooleanStateProperty> STONE_SLAB_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "STONE_SLAB_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> STONE_STAIRS_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "STONE_STAIRS_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> TNT_UNSTABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "TNT_UNSTABLE");

    public static final Supplier<BooleanStateProperty> TRAPPED_CHEST_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "TRAPPED_CHEST_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_ATTACHED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "TRIPWIRE_ATTACHED");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_DISARMED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "TRIPWIRE_DISARMED");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "TRIPWIRE_EAST");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_HOOK_ATTACHED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "TRIPWIRE_HOOK_ATTACHED");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_HOOK_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "TRIPWIRE_HOOK_POWERED");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "TRIPWIRE_NORTH");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_POWERED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "TRIPWIRE_POWERED");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "TRIPWIRE_SOUTH");

    public static final Supplier<BooleanStateProperty> TRIPWIRE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "TRIPWIRE_WEST");

    public static final Supplier<BooleanStateProperty> TUBE_CORAL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "TUBE_CORAL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> TUBE_CORAL_WALL_FAN_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "TUBE_CORAL_WALL_FAN_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> TUBE_CORAL_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "TUBE_CORAL_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> VINE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "VINE_EAST");

    public static final Supplier<BooleanStateProperty> VINE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "VINE_NORTH");

    public static final Supplier<BooleanStateProperty> VINE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "VINE_SOUTH");

    public static final Supplier<BooleanStateProperty> VINE_UP = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "VINE_UP");

    public static final Supplier<BooleanStateProperty> VINE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "VINE_WEST");

    public static final Supplier<BooleanStateProperty> WHITE_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "WHITE_BED_OCCUPIED");

    public static final Supplier<BooleanStateProperty> WHITE_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "WHITE_STAINED_GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> WHITE_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "WHITE_STAINED_GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> WHITE_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "WHITE_STAINED_GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> WHITE_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "WHITE_STAINED_GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> WHITE_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "WHITE_STAINED_GLASS_PANE_WEST");

    public static final Supplier<BooleanStateProperty> YELLOW_BED_OCCUPIED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "YELLOW_BED_OCCUPIED");

    public static final Supplier<BooleanStateProperty> YELLOW_STAINED_GLASS_PANE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "YELLOW_STAINED_GLASS_PANE_EAST");

    public static final Supplier<BooleanStateProperty> YELLOW_STAINED_GLASS_PANE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "YELLOW_STAINED_GLASS_PANE_NORTH");

    public static final Supplier<BooleanStateProperty> YELLOW_STAINED_GLASS_PANE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "YELLOW_STAINED_GLASS_PANE_SOUTH");

    public static final Supplier<BooleanStateProperty> YELLOW_STAINED_GLASS_PANE_WATERLOGGED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "YELLOW_STAINED_GLASS_PANE_WATERLOGGED");

    public static final Supplier<BooleanStateProperty> YELLOW_STAINED_GLASS_PANE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BooleanStateProperty.class, "YELLOW_STAINED_GLASS_PANE_WEST");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private BooleanStateProperties() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
