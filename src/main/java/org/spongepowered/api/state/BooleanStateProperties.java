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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * Represents all possible {@link BooleanStateProperty}s that are known to exist in
 * vanilla minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class BooleanStateProperties {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_BUTTON_POWERED = BooleanStateProperties.key(ResourceKey.sponge("acacia_button_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_DOOR_OPEN = BooleanStateProperties.key(ResourceKey.sponge("acacia_door_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_DOOR_POWERED = BooleanStateProperties.key(ResourceKey.sponge("acacia_door_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_FENCE_EAST = BooleanStateProperties.key(ResourceKey.sponge("acacia_fence_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_FENCE_GATE_IN_WALL = BooleanStateProperties.key(ResourceKey.sponge("acacia_fence_gate_in_wall"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_FENCE_GATE_OPEN = BooleanStateProperties.key(ResourceKey.sponge("acacia_fence_gate_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_FENCE_GATE_POWERED = BooleanStateProperties.key(ResourceKey.sponge("acacia_fence_gate_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_FENCE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("acacia_fence_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_FENCE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("acacia_fence_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_FENCE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("acacia_fence_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_FENCE_WEST = BooleanStateProperties.key(ResourceKey.sponge("acacia_fence_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_LEAVES_PERSISTENT = BooleanStateProperties.key(ResourceKey.sponge("acacia_leaves_persistent"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_PRESSURE_PLATE_POWERED = BooleanStateProperties.key(ResourceKey.sponge("acacia_pressure_plate_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_SIGN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("acacia_sign_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("acacia_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("acacia_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_TRAPDOOR_OPEN = BooleanStateProperties.key(ResourceKey.sponge("acacia_trapdoor_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_TRAPDOOR_POWERED = BooleanStateProperties.key(ResourceKey.sponge("acacia_trapdoor_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_TRAPDOOR_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("acacia_trapdoor_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACACIA_WALL_SIGN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("acacia_wall_sign_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ACTIVATOR_RAIL_POWERED = BooleanStateProperties.key(ResourceKey.sponge("activator_rail_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ANDESITE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("andesite_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ANDESITE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("andesite_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ANDESITE_WALL_EAST = BooleanStateProperties.key(ResourceKey.sponge("andesite_wall_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ANDESITE_WALL_NORTH = BooleanStateProperties.key(ResourceKey.sponge("andesite_wall_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ANDESITE_WALL_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("andesite_wall_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ANDESITE_WALL_UP = BooleanStateProperties.key(ResourceKey.sponge("andesite_wall_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ANDESITE_WALL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("andesite_wall_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ANDESITE_WALL_WEST = BooleanStateProperties.key(ResourceKey.sponge("andesite_wall_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BARREL_OPEN = BooleanStateProperties.key(ResourceKey.sponge("barrel_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_BUTTON_POWERED = BooleanStateProperties.key(ResourceKey.sponge("birch_button_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_DOOR_OPEN = BooleanStateProperties.key(ResourceKey.sponge("birch_door_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_DOOR_POWERED = BooleanStateProperties.key(ResourceKey.sponge("birch_door_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_FENCE_EAST = BooleanStateProperties.key(ResourceKey.sponge("birch_fence_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_FENCE_GATE_IN_WALL = BooleanStateProperties.key(ResourceKey.sponge("birch_fence_gate_in_wall"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_FENCE_GATE_OPEN = BooleanStateProperties.key(ResourceKey.sponge("birch_fence_gate_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_FENCE_GATE_POWERED = BooleanStateProperties.key(ResourceKey.sponge("birch_fence_gate_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_FENCE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("birch_fence_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_FENCE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("birch_fence_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_FENCE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("birch_fence_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_FENCE_WEST = BooleanStateProperties.key(ResourceKey.sponge("birch_fence_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_LEAVES_PERSISTENT = BooleanStateProperties.key(ResourceKey.sponge("birch_leaves_persistent"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_PRESSURE_PLATE_POWERED = BooleanStateProperties.key(ResourceKey.sponge("birch_pressure_plate_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_SIGN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("birch_sign_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("birch_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("birch_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_TRAPDOOR_OPEN = BooleanStateProperties.key(ResourceKey.sponge("birch_trapdoor_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_TRAPDOOR_POWERED = BooleanStateProperties.key(ResourceKey.sponge("birch_trapdoor_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_TRAPDOOR_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("birch_trapdoor_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BIRCH_WALL_SIGN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("birch_wall_sign_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BLACK_BED_OCCUPIED = BooleanStateProperties.key(ResourceKey.sponge("black_bed_occupied"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BLACK_STAINED_GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("black_stained_glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BLACK_STAINED_GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("black_stained_glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BLACK_STAINED_GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("black_stained_glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BLACK_STAINED_GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("black_stained_glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BLACK_STAINED_GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("black_stained_glass_pane_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BLAST_FURNACE_LIT = BooleanStateProperties.key(ResourceKey.sponge("blast_furnace_lit"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BLUE_BED_OCCUPIED = BooleanStateProperties.key(ResourceKey.sponge("blue_bed_occupied"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BLUE_STAINED_GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("blue_stained_glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BLUE_STAINED_GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("blue_stained_glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BLUE_STAINED_GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("blue_stained_glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BLUE_STAINED_GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("blue_stained_glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BLUE_STAINED_GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("blue_stained_glass_pane_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BRAIN_CORAL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("brain_coral_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BRAIN_CORAL_WALL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("brain_coral_wall_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BRAIN_CORAL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("brain_coral_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BREWING_STAND_HAS_BOTTLE_0 = BooleanStateProperties.key(ResourceKey.sponge("BREWING_STAND_HAS_BOTTLE_0"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BREWING_STAND_HAS_BOTTLE_1 = BooleanStateProperties.key(ResourceKey.sponge("BREWING_STAND_HAS_BOTTLE_1"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BREWING_STAND_HAS_BOTTLE_2 = BooleanStateProperties.key(ResourceKey.sponge("BREWING_STAND_HAS_BOTTLE_2"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BRICK_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("brick_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BRICK_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("brick_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BRICK_WALL_EAST = BooleanStateProperties.key(ResourceKey.sponge("brick_wall_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BRICK_WALL_NORTH = BooleanStateProperties.key(ResourceKey.sponge("brick_wall_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BRICK_WALL_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("brick_wall_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BRICK_WALL_UP = BooleanStateProperties.key(ResourceKey.sponge("brick_wall_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BRICK_WALL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("brick_wall_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BRICK_WALL_WEST = BooleanStateProperties.key(ResourceKey.sponge("brick_wall_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BROWN_BED_OCCUPIED = BooleanStateProperties.key(ResourceKey.sponge("brown_bed_occupied"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_DOWN = BooleanStateProperties.key(ResourceKey.sponge("brown_mushroom_block_down"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_EAST = BooleanStateProperties.key(ResourceKey.sponge("brown_mushroom_block_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_NORTH = BooleanStateProperties.key(ResourceKey.sponge("brown_mushroom_block_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("brown_mushroom_block_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_UP = BooleanStateProperties.key(ResourceKey.sponge("brown_mushroom_block_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BROWN_MUSHROOM_BLOCK_WEST = BooleanStateProperties.key(ResourceKey.sponge("brown_mushroom_block_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BROWN_STAINED_GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("brown_stained_glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BROWN_STAINED_GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("brown_stained_glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BROWN_STAINED_GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("brown_stained_glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BROWN_STAINED_GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("brown_stained_glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BROWN_STAINED_GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("brown_stained_glass_pane_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BUBBLE_COLUMN_DRAG = BooleanStateProperties.key(ResourceKey.sponge("bubble_column_drag"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BUBBLE_CORAL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("bubble_coral_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BUBBLE_CORAL_WALL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("bubble_coral_wall_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> BUBBLE_CORAL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("bubble_coral_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CAMPFIRE_LIT = BooleanStateProperties.key(ResourceKey.sponge("campfire_lit"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CAMPFIRE_SIGNAL_FIRE = BooleanStateProperties.key(ResourceKey.sponge("campfire_signal_fire"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CAMPFIRE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("campfire_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CHAIN_COMMAND_BLOCK_CONDITIONAL = BooleanStateProperties.key(ResourceKey.sponge("chain_command_block_conditional"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CHEST_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("chest_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CHORUS_PLANT_DOWN = BooleanStateProperties.key(ResourceKey.sponge("chorus_plant_down"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CHORUS_PLANT_EAST = BooleanStateProperties.key(ResourceKey.sponge("chorus_plant_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CHORUS_PLANT_NORTH = BooleanStateProperties.key(ResourceKey.sponge("chorus_plant_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CHORUS_PLANT_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("chorus_plant_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CHORUS_PLANT_UP = BooleanStateProperties.key(ResourceKey.sponge("chorus_plant_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CHORUS_PLANT_WEST = BooleanStateProperties.key(ResourceKey.sponge("chorus_plant_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> COBBLESTONE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("cobblestone_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> COBBLESTONE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("cobblestone_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> COBBLESTONE_WALL_EAST = BooleanStateProperties.key(ResourceKey.sponge("cobblestone_wall_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> COBBLESTONE_WALL_NORTH = BooleanStateProperties.key(ResourceKey.sponge("cobblestone_wall_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> COBBLESTONE_WALL_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("cobblestone_wall_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> COBBLESTONE_WALL_UP = BooleanStateProperties.key(ResourceKey.sponge("cobblestone_wall_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> COBBLESTONE_WALL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("cobblestone_wall_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> COBBLESTONE_WALL_WEST = BooleanStateProperties.key(ResourceKey.sponge("cobblestone_wall_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> COMMAND_BLOCK_CONDITIONAL = BooleanStateProperties.key(ResourceKey.sponge("command_block_conditional"));

    public static final DefaultedRegistryReference<BooleanStateProperty> COMPARATOR_POWERED = BooleanStateProperties.key(ResourceKey.sponge("comparator_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CONDUIT_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("conduit_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CUT_RED_SANDSTONE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("cut_red_sandstone_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CUT_SANDSTONE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("cut_sandstone_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CYAN_BED_OCCUPIED = BooleanStateProperties.key(ResourceKey.sponge("cyan_bed_occupied"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CYAN_STAINED_GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("cyan_stained_glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CYAN_STAINED_GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("cyan_stained_glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CYAN_STAINED_GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("cyan_stained_glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CYAN_STAINED_GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("cyan_stained_glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> CYAN_STAINED_GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("cyan_stained_glass_pane_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_BUTTON_POWERED = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_button_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_DOOR_OPEN = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_door_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_DOOR_POWERED = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_door_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_FENCE_EAST = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_fence_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_FENCE_GATE_IN_WALL = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_fence_gate_in_wall"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_FENCE_GATE_OPEN = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_fence_gate_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_FENCE_GATE_POWERED = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_fence_gate_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_FENCE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_fence_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_FENCE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_fence_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_FENCE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_fence_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_FENCE_WEST = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_fence_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_LEAVES_PERSISTENT = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_leaves_persistent"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_PRESSURE_PLATE_POWERED = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_pressure_plate_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_SIGN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_sign_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_TRAPDOOR_OPEN = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_trapdoor_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_TRAPDOOR_POWERED = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_trapdoor_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_TRAPDOOR_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_trapdoor_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_OAK_WALL_SIGN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dark_oak_wall_sign_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_PRISMARINE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dark_prismarine_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DARK_PRISMARINE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dark_prismarine_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DAYLIGHT_DETECTOR_INVERTED = BooleanStateProperties.key(ResourceKey.sponge("daylight_detector_inverted"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DEAD_BRAIN_CORAL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dead_brain_coral_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DEAD_BRAIN_CORAL_WALL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dead_brain_coral_wall_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DEAD_BRAIN_CORAL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dead_brain_coral_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DEAD_BUBBLE_CORAL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dead_bubble_coral_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DEAD_BUBBLE_CORAL_WALL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dead_bubble_coral_wall_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DEAD_BUBBLE_CORAL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dead_bubble_coral_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DEAD_FIRE_CORAL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dead_fire_coral_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DEAD_FIRE_CORAL_WALL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dead_fire_coral_wall_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DEAD_FIRE_CORAL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dead_fire_coral_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DEAD_HORN_CORAL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dead_horn_coral_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DEAD_HORN_CORAL_WALL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dead_horn_coral_wall_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DEAD_HORN_CORAL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dead_horn_coral_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DEAD_TUBE_CORAL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dead_tube_coral_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DEAD_TUBE_CORAL_WALL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dead_tube_coral_wall_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DEAD_TUBE_CORAL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("dead_tube_coral_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DETECTOR_RAIL_POWERED = BooleanStateProperties.key(ResourceKey.sponge("detector_rail_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DIORITE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("diorite_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DIORITE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("diorite_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DIORITE_WALL_EAST = BooleanStateProperties.key(ResourceKey.sponge("diorite_wall_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DIORITE_WALL_NORTH = BooleanStateProperties.key(ResourceKey.sponge("diorite_wall_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DIORITE_WALL_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("diorite_wall_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DIORITE_WALL_UP = BooleanStateProperties.key(ResourceKey.sponge("diorite_wall_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DIORITE_WALL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("diorite_wall_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DIORITE_WALL_WEST = BooleanStateProperties.key(ResourceKey.sponge("diorite_wall_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DISPENSER_TRIGGERED = BooleanStateProperties.key(ResourceKey.sponge("dispenser_triggered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> DROPPER_TRIGGERED = BooleanStateProperties.key(ResourceKey.sponge("dropper_triggered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ENDER_CHEST_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("ender_chest_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> END_PORTAL_FRAME_EYE = BooleanStateProperties.key(ResourceKey.sponge("end_portal_frame_eye"));

    public static final DefaultedRegistryReference<BooleanStateProperty> END_STONE_BRICK_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("end_stone_brick_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> END_STONE_BRICK_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("end_stone_brick_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> END_STONE_BRICK_WALL_EAST = BooleanStateProperties.key(ResourceKey.sponge("end_stone_brick_wall_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> END_STONE_BRICK_WALL_NORTH = BooleanStateProperties.key(ResourceKey.sponge("end_stone_brick_wall_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> END_STONE_BRICK_WALL_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("end_stone_brick_wall_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> END_STONE_BRICK_WALL_UP = BooleanStateProperties.key(ResourceKey.sponge("end_stone_brick_wall_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> END_STONE_BRICK_WALL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("end_stone_brick_wall_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> END_STONE_BRICK_WALL_WEST = BooleanStateProperties.key(ResourceKey.sponge("end_stone_brick_wall_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> FIRE_CORAL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("fire_coral_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> FIRE_CORAL_WALL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("fire_coral_wall_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> FIRE_CORAL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("fire_coral_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> FIRE_EAST = BooleanStateProperties.key(ResourceKey.sponge("fire_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> FIRE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("fire_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> FIRE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("fire_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> FIRE_UP = BooleanStateProperties.key(ResourceKey.sponge("fire_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> FIRE_WEST = BooleanStateProperties.key(ResourceKey.sponge("fire_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> FURNACE_LIT = BooleanStateProperties.key(ResourceKey.sponge("furnace_lit"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("glass_pane_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GRANITE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("granite_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GRANITE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("granite_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GRANITE_WALL_EAST = BooleanStateProperties.key(ResourceKey.sponge("granite_wall_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GRANITE_WALL_NORTH = BooleanStateProperties.key(ResourceKey.sponge("granite_wall_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GRANITE_WALL_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("granite_wall_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GRANITE_WALL_UP = BooleanStateProperties.key(ResourceKey.sponge("granite_wall_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GRANITE_WALL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("granite_wall_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GRANITE_WALL_WEST = BooleanStateProperties.key(ResourceKey.sponge("granite_wall_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GRASS_BLOCK_SNOWY = BooleanStateProperties.key(ResourceKey.sponge("grass_block_snowy"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GRAY_BED_OCCUPIED = BooleanStateProperties.key(ResourceKey.sponge("gray_bed_occupied"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GRAY_STAINED_GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("gray_stained_glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GRAY_STAINED_GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("gray_stained_glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GRAY_STAINED_GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("gray_stained_glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GRAY_STAINED_GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("gray_stained_glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GRAY_STAINED_GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("gray_stained_glass_pane_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GREEN_BED_OCCUPIED = BooleanStateProperties.key(ResourceKey.sponge("green_bed_occupied"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GREEN_STAINED_GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("green_stained_glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GREEN_STAINED_GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("green_stained_glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GREEN_STAINED_GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("green_stained_glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GREEN_STAINED_GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("green_stained_glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> GREEN_STAINED_GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("green_stained_glass_pane_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> HOPPER_ENABLED = BooleanStateProperties.key(ResourceKey.sponge("hopper_enabled"));

    public static final DefaultedRegistryReference<BooleanStateProperty> HORN_CORAL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("horn_coral_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> HORN_CORAL_WALL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("horn_coral_wall_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> HORN_CORAL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("horn_coral_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> IRON_BARS_EAST = BooleanStateProperties.key(ResourceKey.sponge("iron_bars_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> IRON_BARS_NORTH = BooleanStateProperties.key(ResourceKey.sponge("iron_bars_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> IRON_BARS_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("iron_bars_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> IRON_BARS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("iron_bars_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> IRON_BARS_WEST = BooleanStateProperties.key(ResourceKey.sponge("iron_bars_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> IRON_DOOR_OPEN = BooleanStateProperties.key(ResourceKey.sponge("iron_door_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> IRON_DOOR_POWERED = BooleanStateProperties.key(ResourceKey.sponge("iron_door_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> IRON_TRAPDOOR_OPEN = BooleanStateProperties.key(ResourceKey.sponge("iron_trapdoor_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> IRON_TRAPDOOR_POWERED = BooleanStateProperties.key(ResourceKey.sponge("iron_trapdoor_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> IRON_TRAPDOOR_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("iron_trapdoor_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUKEBOX_HAS_RECORD = BooleanStateProperties.key(ResourceKey.sponge("jukebox_has_record"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_BUTTON_POWERED = BooleanStateProperties.key(ResourceKey.sponge("jungle_button_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_DOOR_OPEN = BooleanStateProperties.key(ResourceKey.sponge("jungle_door_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_DOOR_POWERED = BooleanStateProperties.key(ResourceKey.sponge("jungle_door_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_FENCE_EAST = BooleanStateProperties.key(ResourceKey.sponge("jungle_fence_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_FENCE_GATE_IN_WALL = BooleanStateProperties.key(ResourceKey.sponge("jungle_fence_gate_in_wall"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_FENCE_GATE_OPEN = BooleanStateProperties.key(ResourceKey.sponge("jungle_fence_gate_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_FENCE_GATE_POWERED = BooleanStateProperties.key(ResourceKey.sponge("jungle_fence_gate_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_FENCE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("jungle_fence_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_FENCE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("jungle_fence_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_FENCE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("jungle_fence_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_FENCE_WEST = BooleanStateProperties.key(ResourceKey.sponge("jungle_fence_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_LEAVES_PERSISTENT = BooleanStateProperties.key(ResourceKey.sponge("jungle_leaves_persistent"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_PRESSURE_PLATE_POWERED = BooleanStateProperties.key(ResourceKey.sponge("jungle_pressure_plate_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_SIGN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("jungle_sign_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("jungle_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("jungle_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_TRAPDOOR_OPEN = BooleanStateProperties.key(ResourceKey.sponge("jungle_trapdoor_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_TRAPDOOR_POWERED = BooleanStateProperties.key(ResourceKey.sponge("jungle_trapdoor_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_TRAPDOOR_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("jungle_trapdoor_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> JUNGLE_WALL_SIGN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("jungle_wall_sign_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LADDER_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("ladder_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LANTERN_HANGING = BooleanStateProperties.key(ResourceKey.sponge("lantern_hanging"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LECTERN_HAS_BOOK = BooleanStateProperties.key(ResourceKey.sponge("lectern_has_book"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LECTERN_POWERED = BooleanStateProperties.key(ResourceKey.sponge("lectern_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LEVER_POWERED = BooleanStateProperties.key(ResourceKey.sponge("lever_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIGHT_BLUE_BED_OCCUPIED = BooleanStateProperties.key(ResourceKey.sponge("light_blue_bed_occupied"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIGHT_BLUE_STAINED_GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("light_blue_stained_glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIGHT_BLUE_STAINED_GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("light_blue_stained_glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIGHT_BLUE_STAINED_GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("light_blue_stained_glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIGHT_BLUE_STAINED_GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("light_blue_stained_glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIGHT_BLUE_STAINED_GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("light_blue_stained_glass_pane_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIGHT_GRAY_BED_OCCUPIED = BooleanStateProperties.key(ResourceKey.sponge("light_gray_bed_occupied"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIGHT_GRAY_STAINED_GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("light_gray_stained_glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIGHT_GRAY_STAINED_GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("light_gray_stained_glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIGHT_GRAY_STAINED_GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("light_gray_stained_glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIGHT_GRAY_STAINED_GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("light_gray_stained_glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIGHT_GRAY_STAINED_GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("light_gray_stained_glass_pane_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIME_BED_OCCUPIED = BooleanStateProperties.key(ResourceKey.sponge("lime_bed_occupied"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIME_STAINED_GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("lime_stained_glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIME_STAINED_GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("lime_stained_glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIME_STAINED_GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("lime_stained_glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIME_STAINED_GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("lime_stained_glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> LIME_STAINED_GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("lime_stained_glass_pane_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MAGENTA_BED_OCCUPIED = BooleanStateProperties.key(ResourceKey.sponge("magenta_bed_occupied"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MAGENTA_STAINED_GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("magenta_stained_glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MAGENTA_STAINED_GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("magenta_stained_glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MAGENTA_STAINED_GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("magenta_stained_glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MAGENTA_STAINED_GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("magenta_stained_glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MAGENTA_STAINED_GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("magenta_stained_glass_pane_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MOSSY_COBBLESTONE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("mossy_cobblestone_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MOSSY_COBBLESTONE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("mossy_cobblestone_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_EAST = BooleanStateProperties.key(ResourceKey.sponge("mossy_cobblestone_wall_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_NORTH = BooleanStateProperties.key(ResourceKey.sponge("mossy_cobblestone_wall_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("mossy_cobblestone_wall_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_UP = BooleanStateProperties.key(ResourceKey.sponge("mossy_cobblestone_wall_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("mossy_cobblestone_wall_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MOSSY_COBBLESTONE_WALL_WEST = BooleanStateProperties.key(ResourceKey.sponge("mossy_cobblestone_wall_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MOSSY_STONE_BRICK_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("mossy_stone_brick_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MOSSY_STONE_BRICK_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("mossy_stone_brick_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_EAST = BooleanStateProperties.key(ResourceKey.sponge("mossy_stone_brick_wall_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_NORTH = BooleanStateProperties.key(ResourceKey.sponge("mossy_stone_brick_wall_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("mossy_stone_brick_wall_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_UP = BooleanStateProperties.key(ResourceKey.sponge("mossy_stone_brick_wall_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("mossy_stone_brick_wall_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MOSSY_STONE_BRICK_WALL_WEST = BooleanStateProperties.key(ResourceKey.sponge("mossy_stone_brick_wall_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MUSHROOM_STEM_DOWN = BooleanStateProperties.key(ResourceKey.sponge("mushroom_stem_down"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MUSHROOM_STEM_EAST = BooleanStateProperties.key(ResourceKey.sponge("mushroom_stem_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MUSHROOM_STEM_NORTH = BooleanStateProperties.key(ResourceKey.sponge("mushroom_stem_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MUSHROOM_STEM_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("mushroom_stem_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MUSHROOM_STEM_UP = BooleanStateProperties.key(ResourceKey.sponge("mushroom_stem_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MUSHROOM_STEM_WEST = BooleanStateProperties.key(ResourceKey.sponge("mushroom_stem_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> MYCELIUM_SNOWY = BooleanStateProperties.key(ResourceKey.sponge("mycelium_snowy"));

    public static final DefaultedRegistryReference<BooleanStateProperty> NETHER_BRICK_FENCE_EAST = BooleanStateProperties.key(ResourceKey.sponge("nether_brick_fence_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> NETHER_BRICK_FENCE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("nether_brick_fence_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> NETHER_BRICK_FENCE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("nether_brick_fence_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> NETHER_BRICK_FENCE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("nether_brick_fence_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> NETHER_BRICK_FENCE_WEST = BooleanStateProperties.key(ResourceKey.sponge("nether_brick_fence_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> NETHER_BRICK_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("nether_brick_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> NETHER_BRICK_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("nether_brick_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> NETHER_BRICK_WALL_EAST = BooleanStateProperties.key(ResourceKey.sponge("nether_brick_wall_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> NETHER_BRICK_WALL_NORTH = BooleanStateProperties.key(ResourceKey.sponge("nether_brick_wall_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> NETHER_BRICK_WALL_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("nether_brick_wall_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> NETHER_BRICK_WALL_UP = BooleanStateProperties.key(ResourceKey.sponge("nether_brick_wall_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> NETHER_BRICK_WALL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("nether_brick_wall_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> NETHER_BRICK_WALL_WEST = BooleanStateProperties.key(ResourceKey.sponge("nether_brick_wall_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> NOTE_BLOCK_POWERED = BooleanStateProperties.key(ResourceKey.sponge("note_block_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_BUTTON_POWERED = BooleanStateProperties.key(ResourceKey.sponge("oak_button_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_DOOR_OPEN = BooleanStateProperties.key(ResourceKey.sponge("oak_door_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_DOOR_POWERED = BooleanStateProperties.key(ResourceKey.sponge("oak_door_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_FENCE_EAST = BooleanStateProperties.key(ResourceKey.sponge("oak_fence_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_FENCE_GATE_IN_WALL = BooleanStateProperties.key(ResourceKey.sponge("oak_fence_gate_in_wall"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_FENCE_GATE_OPEN = BooleanStateProperties.key(ResourceKey.sponge("oak_fence_gate_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_FENCE_GATE_POWERED = BooleanStateProperties.key(ResourceKey.sponge("oak_fence_gate_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_FENCE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("oak_fence_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_FENCE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("oak_fence_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_FENCE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("oak_fence_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_FENCE_WEST = BooleanStateProperties.key(ResourceKey.sponge("oak_fence_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_LEAVES_PERSISTENT = BooleanStateProperties.key(ResourceKey.sponge("oak_leaves_persistent"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_PRESSURE_PLATE_POWERED = BooleanStateProperties.key(ResourceKey.sponge("oak_pressure_plate_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_SIGN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("oak_sign_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("oak_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("oak_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_TRAPDOOR_OPEN = BooleanStateProperties.key(ResourceKey.sponge("oak_trapdoor_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_TRAPDOOR_POWERED = BooleanStateProperties.key(ResourceKey.sponge("oak_trapdoor_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_TRAPDOOR_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("oak_trapdoor_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OAK_WALL_SIGN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("oak_wall_sign_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> OBSERVER_POWERED = BooleanStateProperties.key(ResourceKey.sponge("observer_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ORANGE_BED_OCCUPIED = BooleanStateProperties.key(ResourceKey.sponge("orange_bed_occupied"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ORANGE_STAINED_GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("orange_stained_glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ORANGE_STAINED_GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("orange_stained_glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ORANGE_STAINED_GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("orange_stained_glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ORANGE_STAINED_GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("orange_stained_glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> ORANGE_STAINED_GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("orange_stained_glass_pane_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PETRIFIED_OAK_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("petrified_oak_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PINK_BED_OCCUPIED = BooleanStateProperties.key(ResourceKey.sponge("pink_bed_occupied"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PINK_STAINED_GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("pink_stained_glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PINK_STAINED_GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("pink_stained_glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PINK_STAINED_GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("pink_stained_glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PINK_STAINED_GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("pink_stained_glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PINK_STAINED_GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("pink_stained_glass_pane_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PISTON_EXTENDED = BooleanStateProperties.key(ResourceKey.sponge("piston_extended"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PISTON_HEAD_SHORT = BooleanStateProperties.key(ResourceKey.sponge("piston_head_short"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PODZOL_SNOWY = BooleanStateProperties.key(ResourceKey.sponge("podzol_snowy"));

    public static final DefaultedRegistryReference<BooleanStateProperty> POLISHED_ANDESITE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("polished_andesite_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> POLISHED_ANDESITE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("polished_andesite_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> POLISHED_DIORITE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("polished_diorite_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> POLISHED_DIORITE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("polished_diorite_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> POLISHED_GRANITE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("polished_granite_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> POLISHED_GRANITE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("polished_granite_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> POWERED_RAIL_POWERED = BooleanStateProperties.key(ResourceKey.sponge("powered_rail_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PRISMARINE_BRICK_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("prismarine_brick_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PRISMARINE_BRICK_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("prismarine_brick_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PRISMARINE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("prismarine_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PRISMARINE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("prismarine_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PRISMARINE_WALL_EAST = BooleanStateProperties.key(ResourceKey.sponge("prismarine_wall_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PRISMARINE_WALL_NORTH = BooleanStateProperties.key(ResourceKey.sponge("prismarine_wall_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PRISMARINE_WALL_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("prismarine_wall_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PRISMARINE_WALL_UP = BooleanStateProperties.key(ResourceKey.sponge("prismarine_wall_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PRISMARINE_WALL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("prismarine_wall_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PRISMARINE_WALL_WEST = BooleanStateProperties.key(ResourceKey.sponge("prismarine_wall_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PURPLE_BED_OCCUPIED = BooleanStateProperties.key(ResourceKey.sponge("purple_bed_occupied"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PURPLE_STAINED_GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("purple_stained_glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PURPLE_STAINED_GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("purple_stained_glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PURPLE_STAINED_GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("purple_stained_glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PURPLE_STAINED_GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("purple_stained_glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PURPLE_STAINED_GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("purple_stained_glass_pane_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PURPUR_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("purpur_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> PURPUR_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("purpur_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> QUARTZ_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("quartz_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> QUARTZ_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("quartz_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> REDSTONE_LAMP_LIT = BooleanStateProperties.key(ResourceKey.sponge("redstone_lamp_lit"));

    public static final DefaultedRegistryReference<BooleanStateProperty> REDSTONE_ORE_LIT = BooleanStateProperties.key(ResourceKey.sponge("redstone_ore_lit"));

    public static final DefaultedRegistryReference<BooleanStateProperty> REDSTONE_TORCH_LIT = BooleanStateProperties.key(ResourceKey.sponge("redstone_torch_lit"));

    public static final DefaultedRegistryReference<BooleanStateProperty> REDSTONE_WALL_TORCH_LIT = BooleanStateProperties.key(ResourceKey.sponge("redstone_wall_torch_lit"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_BED_OCCUPIED = BooleanStateProperties.key(ResourceKey.sponge("red_bed_occupied"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_MUSHROOM_BLOCK_DOWN = BooleanStateProperties.key(ResourceKey.sponge("red_mushroom_block_down"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_MUSHROOM_BLOCK_EAST = BooleanStateProperties.key(ResourceKey.sponge("red_mushroom_block_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_MUSHROOM_BLOCK_NORTH = BooleanStateProperties.key(ResourceKey.sponge("red_mushroom_block_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_MUSHROOM_BLOCK_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("red_mushroom_block_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_MUSHROOM_BLOCK_UP = BooleanStateProperties.key(ResourceKey.sponge("red_mushroom_block_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_MUSHROOM_BLOCK_WEST = BooleanStateProperties.key(ResourceKey.sponge("red_mushroom_block_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_NETHER_BRICK_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("red_nether_brick_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_NETHER_BRICK_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("red_nether_brick_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_NETHER_BRICK_WALL_EAST = BooleanStateProperties.key(ResourceKey.sponge("red_nether_brick_wall_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_NETHER_BRICK_WALL_NORTH = BooleanStateProperties.key(ResourceKey.sponge("red_nether_brick_wall_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_NETHER_BRICK_WALL_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("red_nether_brick_wall_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_NETHER_BRICK_WALL_UP = BooleanStateProperties.key(ResourceKey.sponge("red_nether_brick_wall_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_NETHER_BRICK_WALL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("red_nether_brick_wall_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_NETHER_BRICK_WALL_WEST = BooleanStateProperties.key(ResourceKey.sponge("red_nether_brick_wall_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_SANDSTONE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("red_sandstone_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_SANDSTONE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("red_sandstone_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_SANDSTONE_WALL_EAST = BooleanStateProperties.key(ResourceKey.sponge("red_sandstone_wall_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_SANDSTONE_WALL_NORTH = BooleanStateProperties.key(ResourceKey.sponge("red_sandstone_wall_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_SANDSTONE_WALL_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("red_sandstone_wall_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_SANDSTONE_WALL_UP = BooleanStateProperties.key(ResourceKey.sponge("red_sandstone_wall_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_SANDSTONE_WALL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("red_sandstone_wall_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_SANDSTONE_WALL_WEST = BooleanStateProperties.key(ResourceKey.sponge("red_sandstone_wall_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_STAINED_GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("red_stained_glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_STAINED_GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("red_stained_glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_STAINED_GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("red_stained_glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_STAINED_GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("red_stained_glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> RED_STAINED_GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("red_stained_glass_pane_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> REPEATER_LOCKED = BooleanStateProperties.key(ResourceKey.sponge("repeater_locked"));

    public static final DefaultedRegistryReference<BooleanStateProperty> REPEATER_POWERED = BooleanStateProperties.key(ResourceKey.sponge("repeater_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> REPEATING_COMMAND_BLOCK_CONDITIONAL = BooleanStateProperties.key(ResourceKey.sponge("repeating_command_block_conditional"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SANDSTONE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("sandstone_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SANDSTONE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("sandstone_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SANDSTONE_WALL_EAST = BooleanStateProperties.key(ResourceKey.sponge("sandstone_wall_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SANDSTONE_WALL_NORTH = BooleanStateProperties.key(ResourceKey.sponge("sandstone_wall_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SANDSTONE_WALL_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("sandstone_wall_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SANDSTONE_WALL_UP = BooleanStateProperties.key(ResourceKey.sponge("sandstone_wall_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SANDSTONE_WALL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("sandstone_wall_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SANDSTONE_WALL_WEST = BooleanStateProperties.key(ResourceKey.sponge("sandstone_wall_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SCAFFOLDING_BOTTOM = BooleanStateProperties.key(ResourceKey.sponge("scaffolding_bottom"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SCAFFOLDING_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("scaffolding_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SEA_PICKLE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("sea_pickle_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SMOKER_LIT = BooleanStateProperties.key(ResourceKey.sponge("smoker_lit"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SMOOTH_QUARTZ_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("smooth_quartz_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SMOOTH_QUARTZ_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("smooth_quartz_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SMOOTH_RED_SANDSTONE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("smooth_red_sandstone_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SMOOTH_RED_SANDSTONE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("smooth_red_sandstone_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SMOOTH_SANDSTONE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("smooth_sandstone_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SMOOTH_SANDSTONE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("smooth_sandstone_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SMOOTH_STONE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("smooth_stone_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_BUTTON_POWERED = BooleanStateProperties.key(ResourceKey.sponge("spruce_button_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_DOOR_OPEN = BooleanStateProperties.key(ResourceKey.sponge("spruce_door_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_DOOR_POWERED = BooleanStateProperties.key(ResourceKey.sponge("spruce_door_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_FENCE_EAST = BooleanStateProperties.key(ResourceKey.sponge("spruce_fence_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_FENCE_GATE_IN_WALL = BooleanStateProperties.key(ResourceKey.sponge("spruce_fence_gate_in_wall"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_FENCE_GATE_OPEN = BooleanStateProperties.key(ResourceKey.sponge("spruce_fence_gate_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_FENCE_GATE_POWERED = BooleanStateProperties.key(ResourceKey.sponge("spruce_fence_gate_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_FENCE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("spruce_fence_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_FENCE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("spruce_fence_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_FENCE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("spruce_fence_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_FENCE_WEST = BooleanStateProperties.key(ResourceKey.sponge("spruce_fence_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_LEAVES_PERSISTENT = BooleanStateProperties.key(ResourceKey.sponge("spruce_leaves_persistent"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_PRESSURE_PLATE_POWERED = BooleanStateProperties.key(ResourceKey.sponge("spruce_pressure_plate_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_SIGN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("spruce_sign_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("spruce_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("spruce_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_TRAPDOOR_OPEN = BooleanStateProperties.key(ResourceKey.sponge("spruce_trapdoor_open"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_TRAPDOOR_POWERED = BooleanStateProperties.key(ResourceKey.sponge("spruce_trapdoor_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_TRAPDOOR_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("spruce_trapdoor_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> SPRUCE_WALL_SIGN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("spruce_wall_sign_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> STICKY_PISTON_EXTENDED = BooleanStateProperties.key(ResourceKey.sponge("sticky_piston_extended"));

    public static final DefaultedRegistryReference<BooleanStateProperty> STONE_BRICK_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("stone_brick_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> STONE_BRICK_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("stone_brick_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> STONE_BRICK_WALL_EAST = BooleanStateProperties.key(ResourceKey.sponge("stone_brick_wall_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> STONE_BRICK_WALL_NORTH = BooleanStateProperties.key(ResourceKey.sponge("stone_brick_wall_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> STONE_BRICK_WALL_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("stone_brick_wall_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> STONE_BRICK_WALL_UP = BooleanStateProperties.key(ResourceKey.sponge("stone_brick_wall_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> STONE_BRICK_WALL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("stone_brick_wall_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> STONE_BRICK_WALL_WEST = BooleanStateProperties.key(ResourceKey.sponge("stone_brick_wall_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> STONE_BUTTON_POWERED = BooleanStateProperties.key(ResourceKey.sponge("stone_button_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> STONE_PRESSURE_PLATE_POWERED = BooleanStateProperties.key(ResourceKey.sponge("stone_pressure_plate_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> STONE_SLAB_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("stone_slab_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> STONE_STAIRS_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("stone_stairs_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> TNT_UNSTABLE = BooleanStateProperties.key(ResourceKey.sponge("tnt_unstable"));

    public static final DefaultedRegistryReference<BooleanStateProperty> TRAPPED_CHEST_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("trapped_chest_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> TRIPWIRE_ATTACHED = BooleanStateProperties.key(ResourceKey.sponge("tripwire_attached"));

    public static final DefaultedRegistryReference<BooleanStateProperty> TRIPWIRE_DISARMED = BooleanStateProperties.key(ResourceKey.sponge("tripwire_disarmed"));

    public static final DefaultedRegistryReference<BooleanStateProperty> TRIPWIRE_EAST = BooleanStateProperties.key(ResourceKey.sponge("tripwire_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> TRIPWIRE_HOOK_ATTACHED = BooleanStateProperties.key(ResourceKey.sponge("tripwire_hook_attached"));

    public static final DefaultedRegistryReference<BooleanStateProperty> TRIPWIRE_HOOK_POWERED = BooleanStateProperties.key(ResourceKey.sponge("tripwire_hook_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> TRIPWIRE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("tripwire_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> TRIPWIRE_POWERED = BooleanStateProperties.key(ResourceKey.sponge("tripwire_powered"));

    public static final DefaultedRegistryReference<BooleanStateProperty> TRIPWIRE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("tripwire_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> TRIPWIRE_WEST = BooleanStateProperties.key(ResourceKey.sponge("tripwire_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> TUBE_CORAL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("tube_coral_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> TUBE_CORAL_WALL_FAN_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("tube_coral_wall_fan_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> TUBE_CORAL_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("tube_coral_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> VINE_EAST = BooleanStateProperties.key(ResourceKey.sponge("vine_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> VINE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("vine_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> VINE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("vine_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> VINE_UP = BooleanStateProperties.key(ResourceKey.sponge("vine_up"));

    public static final DefaultedRegistryReference<BooleanStateProperty> VINE_WEST = BooleanStateProperties.key(ResourceKey.sponge("vine_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> WHITE_BED_OCCUPIED = BooleanStateProperties.key(ResourceKey.sponge("white_bed_occupied"));

    public static final DefaultedRegistryReference<BooleanStateProperty> WHITE_STAINED_GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("white_stained_glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> WHITE_STAINED_GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("white_stained_glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> WHITE_STAINED_GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("white_stained_glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> WHITE_STAINED_GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("white_stained_glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> WHITE_STAINED_GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("white_stained_glass_pane_west"));

    public static final DefaultedRegistryReference<BooleanStateProperty> YELLOW_BED_OCCUPIED = BooleanStateProperties.key(ResourceKey.sponge("yellow_bed_occupied"));

    public static final DefaultedRegistryReference<BooleanStateProperty> YELLOW_STAINED_GLASS_PANE_EAST = BooleanStateProperties.key(ResourceKey.sponge("yellow_stained_glass_pane_east"));

    public static final DefaultedRegistryReference<BooleanStateProperty> YELLOW_STAINED_GLASS_PANE_NORTH = BooleanStateProperties.key(ResourceKey.sponge("yellow_stained_glass_pane_north"));

    public static final DefaultedRegistryReference<BooleanStateProperty> YELLOW_STAINED_GLASS_PANE_SOUTH = BooleanStateProperties.key(ResourceKey.sponge("yellow_stained_glass_pane_south"));

    public static final DefaultedRegistryReference<BooleanStateProperty> YELLOW_STAINED_GLASS_PANE_WATERLOGGED = BooleanStateProperties.key(ResourceKey.sponge("yellow_stained_glass_pane_waterlogged"));

    public static final DefaultedRegistryReference<BooleanStateProperty> YELLOW_STAINED_GLASS_PANE_WEST = BooleanStateProperties.key(ResourceKey.sponge("yellow_stained_glass_pane_west"));

    // SORTFIELDS:OFF

    // @formatter:on

    private BooleanStateProperties() {
    }

    private static DefaultedRegistryReference<BooleanStateProperty> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.BOOLEAN_STATE_PROPERTY, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
