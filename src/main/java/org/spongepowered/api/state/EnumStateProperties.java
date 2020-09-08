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
 * Represents all possible {@link EnumStateProperty}s that are known to exist in
 * vanilla minecraft.
 */
public final class EnumStateProperties {

    // SORTFIELDS:ON

    public static final Supplier<EnumStateProperty<?>> ACACIA_BUTTON_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "acacia_button_face");

    public static final Supplier<EnumStateProperty<?>> ACACIA_BUTTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "acacia_button_facing");

    public static final Supplier<EnumStateProperty<?>> ACACIA_DOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "acacia_door_facing");

    public static final Supplier<EnumStateProperty<?>> ACACIA_DOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "acacia_door_half");

    public static final Supplier<EnumStateProperty<?>> ACACIA_DOOR_HINGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "acacia_door_hinge");

    public static final Supplier<EnumStateProperty<?>> ACACIA_FENCE_GATE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "acacia_fence_gate_facing");

    public static final Supplier<EnumStateProperty<?>> ACACIA_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "acacia_log_axis");

    public static final Supplier<EnumStateProperty<?>> ACACIA_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "acacia_slab_type");

    public static final Supplier<EnumStateProperty<?>> ACACIA_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "acacia_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> ACACIA_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "acacia_stairs_half");

    public static final Supplier<EnumStateProperty<?>> ACACIA_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "acacia_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> ACACIA_TRAPDOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "acacia_trapdoor_facing");

    public static final Supplier<EnumStateProperty<?>> ACACIA_TRAPDOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "acacia_trapdoor_half");

    public static final Supplier<EnumStateProperty<?>> ACACIA_WALL_SIGN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "acacia_wall_sign_facing");

    public static final Supplier<EnumStateProperty<?>> ACACIA_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "acacia_wood_axis");

    public static final Supplier<EnumStateProperty<?>> ACTIVATOR_RAIL_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "activator_rail_shape");

    public static final Supplier<EnumStateProperty<?>> ANDESITE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "andesite_slab_type");

    public static final Supplier<EnumStateProperty<?>> ANDESITE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "andesite_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> ANDESITE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "andesite_stairs_half");

    public static final Supplier<EnumStateProperty<?>> ANDESITE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "andesite_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> ANVIL_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "anvil_facing");

    public static final Supplier<EnumStateProperty<?>> ATTACHED_MELON_STEM_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "attached_melon_stem_facing");

    public static final Supplier<EnumStateProperty<?>> ATTACHED_PUMPKIN_STEM_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "attached_pumpkin_stem_facing");

    public static final Supplier<EnumStateProperty<?>> BAMBOO_LEAVES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "bamboo_leaves");

    public static final Supplier<EnumStateProperty<?>> BARREL_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "barrel_facing");

    public static final Supplier<EnumStateProperty<?>> BELL_ATTACHMENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "bell_attachment");

    public static final Supplier<EnumStateProperty<?>> BELL_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "bell_facing");

    public static final Supplier<EnumStateProperty<?>> BIRCH_BUTTON_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "birch_button_face");

    public static final Supplier<EnumStateProperty<?>> BIRCH_BUTTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "birch_button_facing");

    public static final Supplier<EnumStateProperty<?>> BIRCH_DOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "birch_door_facing");

    public static final Supplier<EnumStateProperty<?>> BIRCH_DOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "birch_door_half");

    public static final Supplier<EnumStateProperty<?>> BIRCH_DOOR_HINGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "birch_door_hinge");

    public static final Supplier<EnumStateProperty<?>> BIRCH_FENCE_GATE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "birch_fence_gate_facing");

    public static final Supplier<EnumStateProperty<?>> BIRCH_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "birch_log_axis");

    public static final Supplier<EnumStateProperty<?>> BIRCH_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "birch_slab_type");

    public static final Supplier<EnumStateProperty<?>> BIRCH_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "birch_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> BIRCH_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "birch_stairs_half");

    public static final Supplier<EnumStateProperty<?>> BIRCH_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "birch_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> BIRCH_TRAPDOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "birch_trapdoor_facing");

    public static final Supplier<EnumStateProperty<?>> BIRCH_TRAPDOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "birch_trapdoor_half");

    public static final Supplier<EnumStateProperty<?>> BIRCH_WALL_SIGN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "birch_wall_sign_facing");

    public static final Supplier<EnumStateProperty<?>> BIRCH_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "birch_wood_axis");

    public static final Supplier<EnumStateProperty<?>> BLACK_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "black_bed_facing");

    public static final Supplier<EnumStateProperty<?>> BLACK_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "black_bed_part");

    public static final Supplier<EnumStateProperty<?>> BLACK_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "black_glazed_terracotta_facing");

    public static final Supplier<EnumStateProperty<?>> BLACK_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "black_shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> BLACK_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "black_wall_banner_facing");

    public static final Supplier<EnumStateProperty<?>> BLAST_FURNACE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "blast_furnace_facing");

    public static final Supplier<EnumStateProperty<?>> BLUE_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "blue_bed_facing");

    public static final Supplier<EnumStateProperty<?>> BLUE_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "blue_bed_part");

    public static final Supplier<EnumStateProperty<?>> BLUE_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "blue_glazed_terracotta_facing");

    public static final Supplier<EnumStateProperty<?>> BLUE_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "blue_shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> BLUE_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "blue_wall_banner_facing");

    public static final Supplier<EnumStateProperty<?>> BONE_BLOCK_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "bone_block_axis");

    public static final Supplier<EnumStateProperty<?>> BRAIN_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "brain_coral_wall_fan_facing");

    public static final Supplier<EnumStateProperty<?>> BRICK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "brick_slab_type");

    public static final Supplier<EnumStateProperty<?>> BRICK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "brick_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> BRICK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "brick_stairs_half");

    public static final Supplier<EnumStateProperty<?>> BRICK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "brick_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> BROWN_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "brown_bed_facing");

    public static final Supplier<EnumStateProperty<?>> BROWN_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "brown_bed_part");

    public static final Supplier<EnumStateProperty<?>> BROWN_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "brown_glazed_terracotta_facing");

    public static final Supplier<EnumStateProperty<?>> BROWN_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "brown_shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> BROWN_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "brown_wall_banner_facing");

    public static final Supplier<EnumStateProperty<?>> BUBBLE_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "bubble_coral_wall_fan_facing");

    public static final Supplier<EnumStateProperty<?>> CAMPFIRE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "campfire_facing");

    public static final Supplier<EnumStateProperty<?>> CARVED_PUMPKIN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "carved_pumpkin_facing");

    public static final Supplier<EnumStateProperty<?>> CHAIN_COMMAND_BLOCK_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "chain_command_block_facing");

    public static final Supplier<EnumStateProperty<?>> CHEST_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "chest_facing");

    public static final Supplier<EnumStateProperty<?>> CHEST_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "chest_type");

    public static final Supplier<EnumStateProperty<?>> CHIPPED_ANVIL_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "chipped_anvil_facing");

    public static final Supplier<EnumStateProperty<?>> COBBLESTONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "cobblestone_slab_type");

    public static final Supplier<EnumStateProperty<?>> COBBLESTONE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "cobblestone_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> COBBLESTONE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "cobblestone_stairs_half");

    public static final Supplier<EnumStateProperty<?>> COBBLESTONE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "cobblestone_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> COCOA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "cocoa_facing");

    public static final Supplier<EnumStateProperty<?>> COMMAND_BLOCK_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "command_block_facing");

    public static final Supplier<EnumStateProperty<?>> COMPARATOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "comparator_facing");

    public static final Supplier<EnumStateProperty<?>> COMPARATOR_MODE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "comparator_mode");

    public static final Supplier<EnumStateProperty<?>> CREEPER_WALL_HEAD_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "creeper_wall_head_facing");

    public static final Supplier<EnumStateProperty<?>> CUT_RED_SANDSTONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "cut_red_sandstone_slab_type");

    public static final Supplier<EnumStateProperty<?>> CUT_SANDSTONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "cut_sandstone_slab_type");

    public static final Supplier<EnumStateProperty<?>> CYAN_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "cyan_bed_facing");

    public static final Supplier<EnumStateProperty<?>> CYAN_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "cyan_bed_part");

    public static final Supplier<EnumStateProperty<?>> CYAN_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "cyan_glazed_terracotta_facing");

    public static final Supplier<EnumStateProperty<?>> CYAN_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "cyan_shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> CYAN_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "cyan_wall_banner_facing");

    public static final Supplier<EnumStateProperty<?>> DAMAGED_ANVIL_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "damaged_anvil_facing");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_BUTTON_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_oak_button_face");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_BUTTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_oak_button_facing");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_DOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_oak_door_facing");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_DOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_oak_door_half");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_DOOR_HINGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_oak_door_hinge");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_FENCE_GATE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_oak_fence_gate_facing");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_oak_log_axis");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_oak_slab_type");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_oak_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_oak_stairs_half");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_oak_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_TRAPDOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_oak_trapdoor_facing");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_TRAPDOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_oak_trapdoor_half");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_WALL_SIGN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_oak_wall_sign_facing");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_oak_wood_axis");

    public static final Supplier<EnumStateProperty<?>> DARK_PRISMARINE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_prismarine_slab_type");

    public static final Supplier<EnumStateProperty<?>> DARK_PRISMARINE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_prismarine_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> DARK_PRISMARINE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_prismarine_stairs_half");

    public static final Supplier<EnumStateProperty<?>> DARK_PRISMARINE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dark_prismarine_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> DEAD_BRAIN_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dead_brain_coral_wall_fan_facing");

    public static final Supplier<EnumStateProperty<?>> DEAD_BUBBLE_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dead_bubble_coral_wall_fan_facing");

    public static final Supplier<EnumStateProperty<?>> DEAD_FIRE_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dead_fire_coral_wall_fan_facing");

    public static final Supplier<EnumStateProperty<?>> DEAD_HORN_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dead_horn_coral_wall_fan_facing");

    public static final Supplier<EnumStateProperty<?>> DEAD_TUBE_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dead_tube_coral_wall_fan_facing");

    public static final Supplier<EnumStateProperty<?>> DETECTOR_RAIL_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "detector_rail_shape");

    public static final Supplier<EnumStateProperty<?>> DIORITE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "diorite_slab_type");

    public static final Supplier<EnumStateProperty<?>> DIORITE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "diorite_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> DIORITE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "diorite_stairs_half");

    public static final Supplier<EnumStateProperty<?>> DIORITE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "diorite_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> DISPENSER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dispenser_facing");

    public static final Supplier<EnumStateProperty<?>> DRAGON_WALL_HEAD_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dragon_wall_head_facing");

    public static final Supplier<EnumStateProperty<?>> DROPPER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "dropper_facing");

    public static final Supplier<EnumStateProperty<?>> ENDER_CHEST_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ender_chest_facing");

    public static final Supplier<EnumStateProperty<?>> END_PORTAL_FRAME_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "end_portal_frame_facing");

    public static final Supplier<EnumStateProperty<?>> END_ROD_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "end_rod_facing");

    public static final Supplier<EnumStateProperty<?>> END_STONE_BRICK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "end_stone_brick_slab_type");

    public static final Supplier<EnumStateProperty<?>> END_STONE_BRICK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "end_stone_brick_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> END_STONE_BRICK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "end_stone_brick_stairs_half");

    public static final Supplier<EnumStateProperty<?>> END_STONE_BRICK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "end_stone_brick_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> FIRE_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "fire_coral_wall_fan_facing");

    public static final Supplier<EnumStateProperty<?>> FURNACE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "furnace_facing");

    public static final Supplier<EnumStateProperty<?>> GRANITE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "granite_slab_type");

    public static final Supplier<EnumStateProperty<?>> GRANITE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "granite_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> GRANITE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "granite_stairs_half");

    public static final Supplier<EnumStateProperty<?>> GRANITE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "granite_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> GRAY_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "gray_bed_facing");

    public static final Supplier<EnumStateProperty<?>> GRAY_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "gray_bed_part");

    public static final Supplier<EnumStateProperty<?>> GRAY_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "gray_glazed_terracotta_facing");

    public static final Supplier<EnumStateProperty<?>> GRAY_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "gray_shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> GRAY_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "gray_wall_banner_facing");

    public static final Supplier<EnumStateProperty<?>> GREEN_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "green_bed_facing");

    public static final Supplier<EnumStateProperty<?>> GREEN_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "green_bed_part");

    public static final Supplier<EnumStateProperty<?>> GREEN_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "green_glazed_terracotta_facing");

    public static final Supplier<EnumStateProperty<?>> GREEN_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "green_shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> GREEN_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "green_wall_banner_facing");

    public static final Supplier<EnumStateProperty<?>> GRINDSTONE_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "grindstone_face");

    public static final Supplier<EnumStateProperty<?>> GRINDSTONE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "grindstone_facing");

    public static final Supplier<EnumStateProperty<?>> HAY_BLOCK_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "hay_block_axis");

    public static final Supplier<EnumStateProperty<?>> HOPPER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "hopper_facing");

    public static final Supplier<EnumStateProperty<?>> HORN_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "horn_coral_wall_fan_facing");

    public static final Supplier<EnumStateProperty<?>> IRON_DOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "iron_door_facing");

    public static final Supplier<EnumStateProperty<?>> IRON_DOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "iron_door_half");

    public static final Supplier<EnumStateProperty<?>> IRON_DOOR_HINGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "iron_door_hinge");

    public static final Supplier<EnumStateProperty<?>> IRON_TRAPDOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "iron_trapdoor_facing");

    public static final Supplier<EnumStateProperty<?>> IRON_TRAPDOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "iron_trapdoor_half");

    public static final Supplier<EnumStateProperty<?>> JACK_O_LANTERN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jack_o_lantern_facing");

    public static final Supplier<EnumStateProperty<?>> JIGSAW_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jigsaw_facing");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_BUTTON_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jungle_button_face");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_BUTTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jungle_button_facing");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_DOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jungle_door_facing");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_DOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jungle_door_half");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_DOOR_HINGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jungle_door_hinge");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_FENCE_GATE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jungle_fence_gate_facing");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jungle_log_axis");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jungle_slab_type");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jungle_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jungle_stairs_half");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jungle_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_TRAPDOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jungle_trapdoor_facing");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_TRAPDOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jungle_trapdoor_half");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_WALL_SIGN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jungle_wall_sign_facing");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "jungle_wood_axis");

    public static final Supplier<EnumStateProperty<?>> LADDER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ladder_facing");

    public static final Supplier<EnumStateProperty<?>> LARGE_FERN_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "large_fern_half");

    public static final Supplier<EnumStateProperty<?>> LECTERN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "lectern_facing");

    public static final Supplier<EnumStateProperty<?>> LEVER_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "lever_face");

    public static final Supplier<EnumStateProperty<?>> LEVER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "lever_facing");

    public static final Supplier<EnumStateProperty<?>> LIGHT_BLUE_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "light_blue_bed_facing");

    public static final Supplier<EnumStateProperty<?>> LIGHT_BLUE_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "light_blue_bed_part");

    public static final Supplier<EnumStateProperty<?>> LIGHT_BLUE_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "light_blue_glazed_terracotta_facing");

    public static final Supplier<EnumStateProperty<?>> LIGHT_BLUE_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "light_blue_shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> LIGHT_BLUE_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "light_blue_wall_banner_facing");

    public static final Supplier<EnumStateProperty<?>> LIGHT_GRAY_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "light_gray_bed_facing");

    public static final Supplier<EnumStateProperty<?>> LIGHT_GRAY_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "light_gray_bed_part");

    public static final Supplier<EnumStateProperty<?>> LIGHT_GRAY_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "light_gray_glazed_terracotta_facing");

    public static final Supplier<EnumStateProperty<?>> LIGHT_GRAY_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "light_gray_shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> LIGHT_GRAY_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "light_gray_wall_banner_facing");

    public static final Supplier<EnumStateProperty<?>> LILAC_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "lilac_half");

    public static final Supplier<EnumStateProperty<?>> LIME_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "lime_bed_facing");

    public static final Supplier<EnumStateProperty<?>> LIME_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "lime_bed_part");

    public static final Supplier<EnumStateProperty<?>> LIME_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "lime_glazed_terracotta_facing");

    public static final Supplier<EnumStateProperty<?>> LIME_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "lime_shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> LIME_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "lime_wall_banner_facing");

    public static final Supplier<EnumStateProperty<?>> LOOM_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "loom_facing");

    public static final Supplier<EnumStateProperty<?>> MAGENTA_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "magenta_bed_facing");

    public static final Supplier<EnumStateProperty<?>> MAGENTA_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "magenta_bed_part");

    public static final Supplier<EnumStateProperty<?>> MAGENTA_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "magenta_glazed_terracotta_facing");

    public static final Supplier<EnumStateProperty<?>> MAGENTA_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "magenta_shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> MAGENTA_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "magenta_wall_banner_facing");

    public static final Supplier<EnumStateProperty<?>> MOSSY_COBBLESTONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "mossy_cobblestone_slab_type");

    public static final Supplier<EnumStateProperty<?>> MOSSY_COBBLESTONE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "mossy_cobblestone_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> MOSSY_COBBLESTONE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "mossy_cobblestone_stairs_half");

    public static final Supplier<EnumStateProperty<?>> MOSSY_COBBLESTONE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "mossy_cobblestone_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> MOSSY_STONE_BRICK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "mossy_stone_brick_slab_type");

    public static final Supplier<EnumStateProperty<?>> MOSSY_STONE_BRICK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "mossy_stone_brick_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> MOSSY_STONE_BRICK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "mossy_stone_brick_stairs_half");

    public static final Supplier<EnumStateProperty<?>> MOSSY_STONE_BRICK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "mossy_stone_brick_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> MOVING_PISTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "moving_piston_facing");

    public static final Supplier<EnumStateProperty<?>> MOVING_PISTON_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "moving_piston_type");

    public static final Supplier<EnumStateProperty<?>> NETHER_BRICK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "nether_brick_slab_type");

    public static final Supplier<EnumStateProperty<?>> NETHER_BRICK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "nether_brick_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> NETHER_BRICK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "nether_brick_stairs_half");

    public static final Supplier<EnumStateProperty<?>> NETHER_BRICK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "nether_brick_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> NETHER_PORTAL_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "nether_portal_axis");

    public static final Supplier<EnumStateProperty<?>> NOTE_BLOCK_INSTRUMENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "note_block_instrument");

    public static final Supplier<EnumStateProperty<?>> OAK_BUTTON_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "oak_button_face");

    public static final Supplier<EnumStateProperty<?>> OAK_BUTTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "oak_button_facing");

    public static final Supplier<EnumStateProperty<?>> OAK_DOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "oak_door_facing");

    public static final Supplier<EnumStateProperty<?>> OAK_DOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "oak_door_half");

    public static final Supplier<EnumStateProperty<?>> OAK_DOOR_HINGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "oak_door_hinge");

    public static final Supplier<EnumStateProperty<?>> OAK_FENCE_GATE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "oak_fence_gate_facing");

    public static final Supplier<EnumStateProperty<?>> OAK_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "oak_log_axis");

    public static final Supplier<EnumStateProperty<?>> OAK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "oak_slab_type");

    public static final Supplier<EnumStateProperty<?>> OAK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "oak_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> OAK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "oak_stairs_half");

    public static final Supplier<EnumStateProperty<?>> OAK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "oak_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> OAK_TRAPDOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "oak_trapdoor_facing");

    public static final Supplier<EnumStateProperty<?>> OAK_TRAPDOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "oak_trapdoor_half");

    public static final Supplier<EnumStateProperty<?>> OAK_WALL_SIGN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "oak_wall_sign_facing");

    public static final Supplier<EnumStateProperty<?>> OAK_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "oak_wood_axis");

    public static final Supplier<EnumStateProperty<?>> OBSERVER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "observer_facing");

    public static final Supplier<EnumStateProperty<?>> ORANGE_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "orange_bed_facing");

    public static final Supplier<EnumStateProperty<?>> ORANGE_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "orange_bed_part");

    public static final Supplier<EnumStateProperty<?>> ORANGE_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "orange_glazed_terracotta_facing");

    public static final Supplier<EnumStateProperty<?>> ORANGE_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "orange_shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> ORANGE_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "orange_wall_banner_facing");

    public static final Supplier<EnumStateProperty<?>> PEONY_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "peony_half");

    public static final Supplier<EnumStateProperty<?>> PETRIFIED_OAK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "petrified_oak_slab_type");

    public static final Supplier<EnumStateProperty<?>> PINK_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "pink_bed_facing");

    public static final Supplier<EnumStateProperty<?>> PINK_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "pink_bed_part");

    public static final Supplier<EnumStateProperty<?>> PINK_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "pink_glazed_terracotta_facing");

    public static final Supplier<EnumStateProperty<?>> PINK_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "pink_shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> PINK_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "pink_wall_banner_facing");

    public static final Supplier<EnumStateProperty<?>> PISTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "piston_facing");

    public static final Supplier<EnumStateProperty<?>> PISTON_HEAD_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "piston_head_facing");

    public static final Supplier<EnumStateProperty<?>> PISTON_HEAD_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "piston_head_type");

    public static final Supplier<EnumStateProperty<?>> PLAYER_WALL_HEAD_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "player_wall_head_facing");

    public static final Supplier<EnumStateProperty<?>> POLISHED_ANDESITE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "polished_andesite_slab_type");

    public static final Supplier<EnumStateProperty<?>> POLISHED_ANDESITE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "polished_andesite_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> POLISHED_ANDESITE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "polished_andesite_stairs_half");

    public static final Supplier<EnumStateProperty<?>> POLISHED_ANDESITE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "polished_andesite_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> POLISHED_DIORITE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "polished_diorite_slab_type");

    public static final Supplier<EnumStateProperty<?>> POLISHED_DIORITE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "polished_diorite_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> POLISHED_DIORITE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "polished_diorite_stairs_half");

    public static final Supplier<EnumStateProperty<?>> POLISHED_DIORITE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "polished_diorite_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> POLISHED_GRANITE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "polished_granite_slab_type");

    public static final Supplier<EnumStateProperty<?>> POLISHED_GRANITE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "polished_granite_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> POLISHED_GRANITE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "polished_granite_stairs_half");

    public static final Supplier<EnumStateProperty<?>> POLISHED_GRANITE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "polished_granite_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> POWERED_RAIL_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "powered_rail_shape");

    public static final Supplier<EnumStateProperty<?>> PRISMARINE_BRICK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "prismarine_brick_slab_type");

    public static final Supplier<EnumStateProperty<?>> PRISMARINE_BRICK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "prismarine_brick_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> PRISMARINE_BRICK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "prismarine_brick_stairs_half");

    public static final Supplier<EnumStateProperty<?>> PRISMARINE_BRICK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "prismarine_brick_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> PRISMARINE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "prismarine_slab_type");

    public static final Supplier<EnumStateProperty<?>> PRISMARINE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "prismarine_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> PRISMARINE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "prismarine_stairs_half");

    public static final Supplier<EnumStateProperty<?>> PRISMARINE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "prismarine_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> PURPLE_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "purple_bed_facing");

    public static final Supplier<EnumStateProperty<?>> PURPLE_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "purple_bed_part");

    public static final Supplier<EnumStateProperty<?>> PURPLE_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "purple_glazed_terracotta_facing");

    public static final Supplier<EnumStateProperty<?>> PURPLE_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "purple_shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> PURPLE_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "purple_wall_banner_facing");

    public static final Supplier<EnumStateProperty<?>> PURPUR_PILLAR_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "purpur_pillar_axis");

    public static final Supplier<EnumStateProperty<?>> PURPUR_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "purpur_slab_type");

    public static final Supplier<EnumStateProperty<?>> PURPUR_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "purpur_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> PURPUR_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "purpur_stairs_half");

    public static final Supplier<EnumStateProperty<?>> PURPUR_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "purpur_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> QUARTZ_PILLAR_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "quartz_pillar_axis");

    public static final Supplier<EnumStateProperty<?>> QUARTZ_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "quartz_slab_type");

    public static final Supplier<EnumStateProperty<?>> QUARTZ_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "quartz_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> QUARTZ_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "quartz_stairs_half");

    public static final Supplier<EnumStateProperty<?>> QUARTZ_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "quartz_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> RAIL_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "rail_shape");

    public static final Supplier<EnumStateProperty<?>> REDSTONE_WALL_TORCH_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "redstone_wall_torch_facing");

    public static final Supplier<EnumStateProperty<?>> REDSTONE_WIRE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "redstone_wire_east");

    public static final Supplier<EnumStateProperty<?>> REDSTONE_WIRE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "redstone_wire_north");

    public static final Supplier<EnumStateProperty<?>> REDSTONE_WIRE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "redstone_wire_south");

    public static final Supplier<EnumStateProperty<?>> REDSTONE_WIRE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "redstone_wire_west");

    public static final Supplier<EnumStateProperty<?>> RED_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "red_bed_facing");

    public static final Supplier<EnumStateProperty<?>> RED_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "red_bed_part");

    public static final Supplier<EnumStateProperty<?>> RED_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "red_glazed_terracotta_facing");

    public static final Supplier<EnumStateProperty<?>> RED_NETHER_BRICK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "red_nether_brick_slab_type");

    public static final Supplier<EnumStateProperty<?>> RED_NETHER_BRICK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "red_nether_brick_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> RED_NETHER_BRICK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "red_nether_brick_stairs_half");

    public static final Supplier<EnumStateProperty<?>> RED_NETHER_BRICK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "red_nether_brick_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> RED_SANDSTONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "red_sandstone_slab_type");

    public static final Supplier<EnumStateProperty<?>> RED_SANDSTONE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "red_sandstone_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> RED_SANDSTONE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "red_sandstone_stairs_half");

    public static final Supplier<EnumStateProperty<?>> RED_SANDSTONE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "red_sandstone_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> RED_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "red_shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> RED_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "red_wall_banner_facing");

    public static final Supplier<EnumStateProperty<?>> REPEATER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "repeater_facing");

    public static final Supplier<EnumStateProperty<?>> REPEATING_COMMAND_BLOCK_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "repeating_command_block_facing");

    public static final Supplier<EnumStateProperty<?>> ROSE_BUSH_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "rose_bush_half");

    public static final Supplier<EnumStateProperty<?>> SANDSTONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "sandstone_slab_type");

    public static final Supplier<EnumStateProperty<?>> SANDSTONE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "sandstone_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> SANDSTONE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "sandstone_stairs_half");

    public static final Supplier<EnumStateProperty<?>> SANDSTONE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "sandstone_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> SKELETON_WALL_SKULL_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "skeleton_wall_skull_facing");

    public static final Supplier<EnumStateProperty<?>> SMOKER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "smoker_facing");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_QUARTZ_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "smooth_quartz_slab_type");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_QUARTZ_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "smooth_quartz_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_QUARTZ_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "smooth_quartz_stairs_half");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_QUARTZ_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "smooth_quartz_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_RED_SANDSTONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "smooth_red_sandstone_slab_type");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_RED_SANDSTONE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "smooth_red_sandstone_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_RED_SANDSTONE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "smooth_red_sandstone_stairs_half");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_RED_SANDSTONE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "smooth_red_sandstone_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_SANDSTONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "smooth_sandstone_slab_type");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_SANDSTONE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "smooth_sandstone_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_SANDSTONE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "smooth_sandstone_stairs_half");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_SANDSTONE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "smooth_sandstone_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_STONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "smooth_stone_slab_type");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_BUTTON_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "spruce_button_face");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_BUTTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "spruce_button_facing");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_DOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "spruce_door_facing");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_DOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "spruce_door_half");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_DOOR_HINGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "spruce_door_hinge");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_FENCE_GATE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "spruce_fence_gate_facing");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "spruce_log_axis");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "spruce_slab_type");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "spruce_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "spruce_stairs_half");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "spruce_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_TRAPDOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "spruce_trapdoor_facing");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_TRAPDOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "spruce_trapdoor_half");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_WALL_SIGN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "spruce_wall_sign_facing");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "spruce_wood_axis");

    public static final Supplier<EnumStateProperty<?>> STICKY_PISTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "sticky_piston_facing");

    public static final Supplier<EnumStateProperty<?>> STONECUTTER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stonecutter_facing");

    public static final Supplier<EnumStateProperty<?>> STONE_BRICK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stone_brick_slab_type");

    public static final Supplier<EnumStateProperty<?>> STONE_BRICK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stone_brick_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> STONE_BRICK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stone_brick_stairs_half");

    public static final Supplier<EnumStateProperty<?>> STONE_BRICK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stone_brick_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> STONE_BUTTON_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stone_button_face");

    public static final Supplier<EnumStateProperty<?>> STONE_BUTTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stone_button_facing");

    public static final Supplier<EnumStateProperty<?>> STONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stone_slab_type");

    public static final Supplier<EnumStateProperty<?>> STONE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stone_stairs_facing");

    public static final Supplier<EnumStateProperty<?>> STONE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stone_stairs_half");

    public static final Supplier<EnumStateProperty<?>> STONE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stone_stairs_shape");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_ACACIA_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stripped_acacia_log_axis");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_ACACIA_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stripped_acacia_wood_axis");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_BIRCH_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stripped_birch_log_axis");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_BIRCH_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stripped_birch_wood_axis");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_DARK_OAK_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stripped_dark_oak_log_axis");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_DARK_OAK_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stripped_dark_oak_wood_axis");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_JUNGLE_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stripped_jungle_log_axis");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_JUNGLE_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stripped_jungle_wood_axis");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_OAK_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stripped_oak_log_axis");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_OAK_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stripped_oak_wood_axis");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_SPRUCE_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stripped_spruce_log_axis");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_SPRUCE_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "stripped_spruce_wood_axis");

    public static final Supplier<EnumStateProperty<?>> STRUCTURE_BLOCK_MODE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "structure_block_mode");

    public static final Supplier<EnumStateProperty<?>> SUNFLOWER_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "sunflower_half");

    public static final Supplier<EnumStateProperty<?>> TALL_GRASS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "tall_grass_half");

    public static final Supplier<EnumStateProperty<?>> TALL_SEAGRASS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "tall_seagrass_half");

    public static final Supplier<EnumStateProperty<?>> TRAPPED_CHEST_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "trapped_chest_facing");

    public static final Supplier<EnumStateProperty<?>> TRAPPED_CHEST_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "trapped_chest_type");

    public static final Supplier<EnumStateProperty<?>> TRIPWIRE_HOOK_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "tripwire_hook_facing");

    public static final Supplier<EnumStateProperty<?>> TUBE_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "tube_coral_wall_fan_facing");

    public static final Supplier<EnumStateProperty<?>> WALL_TORCH_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "wall_torch_facing");

    public static final Supplier<EnumStateProperty<?>> WHITE_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "white_bed_facing");

    public static final Supplier<EnumStateProperty<?>> WHITE_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "white_bed_part");

    public static final Supplier<EnumStateProperty<?>> WHITE_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "white_glazed_terracotta_facing");

    public static final Supplier<EnumStateProperty<?>> WHITE_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "white_shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> WHITE_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "white_wall_banner_facing");

    public static final Supplier<EnumStateProperty<?>> WITHER_SKELETON_WALL_SKULL_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "wither_skeleton_wall_skull_facing");

    public static final Supplier<EnumStateProperty<?>> YELLOW_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "yellow_bed_facing");

    public static final Supplier<EnumStateProperty<?>> YELLOW_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "yellow_bed_part");

    public static final Supplier<EnumStateProperty<?>> YELLOW_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "yellow_glazed_terracotta_facing");

    public static final Supplier<EnumStateProperty<?>> YELLOW_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "yellow_shulker_box_facing");

    public static final Supplier<EnumStateProperty<?>> YELLOW_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "yellow_wall_banner_facing");

    public static final Supplier<EnumStateProperty<?>> ZOMBIE_WALL_HEAD_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "zombie_wall_head_facing");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private EnumStateProperties() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
