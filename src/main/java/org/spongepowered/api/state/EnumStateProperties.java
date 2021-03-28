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
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * Represents all possible {@link EnumStateProperty}s that are known to exist in
 * vanilla minecraft.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class EnumStateProperties {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ACACIA_BUTTON_FACE = EnumStateProperties.key(ResourceKey.sponge("acacia_button_face"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ACACIA_BUTTON_FACING = EnumStateProperties.key(ResourceKey.sponge("acacia_button_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ACACIA_DOOR_FACING = EnumStateProperties.key(ResourceKey.sponge("acacia_door_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ACACIA_DOOR_HALF = EnumStateProperties.key(ResourceKey.sponge("acacia_door_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ACACIA_DOOR_HINGE = EnumStateProperties.key(ResourceKey.sponge("acacia_door_hinge"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ACACIA_FENCE_GATE_FACING = EnumStateProperties.key(ResourceKey.sponge("acacia_fence_gate_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ACACIA_LOG_AXIS = EnumStateProperties.key(ResourceKey.sponge("acacia_log_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ACACIA_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("acacia_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ACACIA_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("acacia_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ACACIA_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("acacia_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ACACIA_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("acacia_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ACACIA_TRAPDOOR_FACING = EnumStateProperties.key(ResourceKey.sponge("acacia_trapdoor_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ACACIA_TRAPDOOR_HALF = EnumStateProperties.key(ResourceKey.sponge("acacia_trapdoor_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ACACIA_WALL_SIGN_FACING = EnumStateProperties.key(ResourceKey.sponge("acacia_wall_sign_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ACACIA_WOOD_AXIS = EnumStateProperties.key(ResourceKey.sponge("acacia_wood_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ACTIVATOR_RAIL_SHAPE = EnumStateProperties.key(ResourceKey.sponge("activator_rail_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ANDESITE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("andesite_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ANDESITE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("andesite_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ANDESITE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("andesite_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ANDESITE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("andesite_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ANVIL_FACING = EnumStateProperties.key(ResourceKey.sponge("anvil_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ATTACHED_MELON_STEM_FACING = EnumStateProperties.key(ResourceKey.sponge("attached_melon_stem_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ATTACHED_PUMPKIN_STEM_FACING = EnumStateProperties.key(ResourceKey.sponge("attached_pumpkin_stem_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BAMBOO_LEAVES = EnumStateProperties.key(ResourceKey.sponge("bamboo_leaves"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BARREL_FACING = EnumStateProperties.key(ResourceKey.sponge("barrel_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BELL_ATTACHMENT = EnumStateProperties.key(ResourceKey.sponge("bell_attachment"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BELL_FACING = EnumStateProperties.key(ResourceKey.sponge("bell_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BIRCH_BUTTON_FACE = EnumStateProperties.key(ResourceKey.sponge("birch_button_face"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BIRCH_BUTTON_FACING = EnumStateProperties.key(ResourceKey.sponge("birch_button_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BIRCH_DOOR_FACING = EnumStateProperties.key(ResourceKey.sponge("birch_door_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BIRCH_DOOR_HALF = EnumStateProperties.key(ResourceKey.sponge("birch_door_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BIRCH_DOOR_HINGE = EnumStateProperties.key(ResourceKey.sponge("birch_door_hinge"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BIRCH_FENCE_GATE_FACING = EnumStateProperties.key(ResourceKey.sponge("birch_fence_gate_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BIRCH_LOG_AXIS = EnumStateProperties.key(ResourceKey.sponge("birch_log_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BIRCH_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("birch_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BIRCH_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("birch_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BIRCH_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("birch_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BIRCH_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("birch_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BIRCH_TRAPDOOR_FACING = EnumStateProperties.key(ResourceKey.sponge("birch_trapdoor_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BIRCH_TRAPDOOR_HALF = EnumStateProperties.key(ResourceKey.sponge("birch_trapdoor_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BIRCH_WALL_SIGN_FACING = EnumStateProperties.key(ResourceKey.sponge("birch_wall_sign_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BIRCH_WOOD_AXIS = EnumStateProperties.key(ResourceKey.sponge("birch_wood_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BLACK_BED_FACING = EnumStateProperties.key(ResourceKey.sponge("black_bed_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BLACK_BED_PART = EnumStateProperties.key(ResourceKey.sponge("black_bed_part"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BLACK_GLAZED_TERRACOTTA_FACING = EnumStateProperties.key(ResourceKey.sponge("black_glazed_terracotta_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BLACK_SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("black_shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BLACK_WALL_BANNER_FACING = EnumStateProperties.key(ResourceKey.sponge("black_wall_banner_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BLAST_FURNACE_FACING = EnumStateProperties.key(ResourceKey.sponge("blast_furnace_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BLUE_BED_FACING = EnumStateProperties.key(ResourceKey.sponge("blue_bed_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BLUE_BED_PART = EnumStateProperties.key(ResourceKey.sponge("blue_bed_part"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BLUE_GLAZED_TERRACOTTA_FACING = EnumStateProperties.key(ResourceKey.sponge("blue_glazed_terracotta_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BLUE_SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("blue_shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BLUE_WALL_BANNER_FACING = EnumStateProperties.key(ResourceKey.sponge("blue_wall_banner_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BONE_BLOCK_AXIS = EnumStateProperties.key(ResourceKey.sponge("bone_block_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BRAIN_CORAL_WALL_FAN_FACING = EnumStateProperties.key(ResourceKey.sponge("brain_coral_wall_fan_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BRICK_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("brick_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BRICK_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("brick_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BRICK_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("brick_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BRICK_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("brick_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BROWN_BED_FACING = EnumStateProperties.key(ResourceKey.sponge("brown_bed_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BROWN_BED_PART = EnumStateProperties.key(ResourceKey.sponge("brown_bed_part"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BROWN_GLAZED_TERRACOTTA_FACING = EnumStateProperties.key(ResourceKey.sponge("brown_glazed_terracotta_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BROWN_SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("brown_shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BROWN_WALL_BANNER_FACING = EnumStateProperties.key(ResourceKey.sponge("brown_wall_banner_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> BUBBLE_CORAL_WALL_FAN_FACING = EnumStateProperties.key(ResourceKey.sponge("bubble_coral_wall_fan_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> CAMPFIRE_FACING = EnumStateProperties.key(ResourceKey.sponge("campfire_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> CARVED_PUMPKIN_FACING = EnumStateProperties.key(ResourceKey.sponge("carved_pumpkin_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> CHAIN_COMMAND_BLOCK_FACING = EnumStateProperties.key(ResourceKey.sponge("chain_command_block_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> CHEST_FACING = EnumStateProperties.key(ResourceKey.sponge("chest_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> CHEST_TYPE = EnumStateProperties.key(ResourceKey.sponge("chest_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> CHIPPED_ANVIL_FACING = EnumStateProperties.key(ResourceKey.sponge("chipped_anvil_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> COBBLESTONE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("cobblestone_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> COBBLESTONE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("cobblestone_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> COBBLESTONE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("cobblestone_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> COBBLESTONE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("cobblestone_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> COCOA_FACING = EnumStateProperties.key(ResourceKey.sponge("cocoa_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> COMMAND_BLOCK_FACING = EnumStateProperties.key(ResourceKey.sponge("command_block_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> COMPARATOR_FACING = EnumStateProperties.key(ResourceKey.sponge("comparator_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> COMPARATOR_MODE = EnumStateProperties.key(ResourceKey.sponge("comparator_mode"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> CREEPER_WALL_HEAD_FACING = EnumStateProperties.key(ResourceKey.sponge("creeper_wall_head_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> CUT_RED_SANDSTONE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("cut_red_sandstone_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> CUT_SANDSTONE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("cut_sandstone_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> CYAN_BED_FACING = EnumStateProperties.key(ResourceKey.sponge("cyan_bed_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> CYAN_BED_PART = EnumStateProperties.key(ResourceKey.sponge("cyan_bed_part"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> CYAN_GLAZED_TERRACOTTA_FACING = EnumStateProperties.key(ResourceKey.sponge("cyan_glazed_terracotta_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> CYAN_SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("cyan_shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> CYAN_WALL_BANNER_FACING = EnumStateProperties.key(ResourceKey.sponge("cyan_wall_banner_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DAMAGED_ANVIL_FACING = EnumStateProperties.key(ResourceKey.sponge("damaged_anvil_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_OAK_BUTTON_FACE = EnumStateProperties.key(ResourceKey.sponge("dark_oak_button_face"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_OAK_BUTTON_FACING = EnumStateProperties.key(ResourceKey.sponge("dark_oak_button_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_OAK_DOOR_FACING = EnumStateProperties.key(ResourceKey.sponge("dark_oak_door_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_OAK_DOOR_HALF = EnumStateProperties.key(ResourceKey.sponge("dark_oak_door_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_OAK_DOOR_HINGE = EnumStateProperties.key(ResourceKey.sponge("dark_oak_door_hinge"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_OAK_FENCE_GATE_FACING = EnumStateProperties.key(ResourceKey.sponge("dark_oak_fence_gate_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_OAK_LOG_AXIS = EnumStateProperties.key(ResourceKey.sponge("dark_oak_log_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_OAK_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("dark_oak_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_OAK_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("dark_oak_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_OAK_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("dark_oak_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_OAK_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("dark_oak_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_OAK_TRAPDOOR_FACING = EnumStateProperties.key(ResourceKey.sponge("dark_oak_trapdoor_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_OAK_TRAPDOOR_HALF = EnumStateProperties.key(ResourceKey.sponge("dark_oak_trapdoor_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_OAK_WALL_SIGN_FACING = EnumStateProperties.key(ResourceKey.sponge("dark_oak_wall_sign_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_OAK_WOOD_AXIS = EnumStateProperties.key(ResourceKey.sponge("dark_oak_wood_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_PRISMARINE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("dark_prismarine_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_PRISMARINE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("dark_prismarine_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_PRISMARINE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("dark_prismarine_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DARK_PRISMARINE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("dark_prismarine_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DEAD_BRAIN_CORAL_WALL_FAN_FACING = EnumStateProperties.key(ResourceKey.sponge("dead_brain_coral_wall_fan_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DEAD_BUBBLE_CORAL_WALL_FAN_FACING = EnumStateProperties.key(ResourceKey.sponge("dead_bubble_coral_wall_fan_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DEAD_FIRE_CORAL_WALL_FAN_FACING = EnumStateProperties.key(ResourceKey.sponge("dead_fire_coral_wall_fan_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DEAD_HORN_CORAL_WALL_FAN_FACING = EnumStateProperties.key(ResourceKey.sponge("dead_horn_coral_wall_fan_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DEAD_TUBE_CORAL_WALL_FAN_FACING = EnumStateProperties.key(ResourceKey.sponge("dead_tube_coral_wall_fan_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DETECTOR_RAIL_SHAPE = EnumStateProperties.key(ResourceKey.sponge("detector_rail_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DIORITE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("diorite_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DIORITE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("diorite_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DIORITE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("diorite_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DIORITE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("diorite_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DISPENSER_FACING = EnumStateProperties.key(ResourceKey.sponge("dispenser_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DRAGON_WALL_HEAD_FACING = EnumStateProperties.key(ResourceKey.sponge("dragon_wall_head_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> DROPPER_FACING = EnumStateProperties.key(ResourceKey.sponge("dropper_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ENDER_CHEST_FACING = EnumStateProperties.key(ResourceKey.sponge("ender_chest_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> END_PORTAL_FRAME_FACING = EnumStateProperties.key(ResourceKey.sponge("end_portal_frame_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> END_ROD_FACING = EnumStateProperties.key(ResourceKey.sponge("end_rod_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> END_STONE_BRICK_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("end_stone_brick_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> END_STONE_BRICK_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("end_stone_brick_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> END_STONE_BRICK_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("end_stone_brick_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> END_STONE_BRICK_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("end_stone_brick_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> FIRE_CORAL_WALL_FAN_FACING = EnumStateProperties.key(ResourceKey.sponge("fire_coral_wall_fan_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> FURNACE_FACING = EnumStateProperties.key(ResourceKey.sponge("furnace_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> GRANITE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("granite_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> GRANITE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("granite_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> GRANITE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("granite_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> GRANITE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("granite_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> GRAY_BED_FACING = EnumStateProperties.key(ResourceKey.sponge("gray_bed_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> GRAY_BED_PART = EnumStateProperties.key(ResourceKey.sponge("gray_bed_part"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> GRAY_GLAZED_TERRACOTTA_FACING = EnumStateProperties.key(ResourceKey.sponge("gray_glazed_terracotta_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> GRAY_SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("gray_shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> GRAY_WALL_BANNER_FACING = EnumStateProperties.key(ResourceKey.sponge("gray_wall_banner_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> GREEN_BED_FACING = EnumStateProperties.key(ResourceKey.sponge("green_bed_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> GREEN_BED_PART = EnumStateProperties.key(ResourceKey.sponge("green_bed_part"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> GREEN_GLAZED_TERRACOTTA_FACING = EnumStateProperties.key(ResourceKey.sponge("green_glazed_terracotta_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> GREEN_SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("green_shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> GREEN_WALL_BANNER_FACING = EnumStateProperties.key(ResourceKey.sponge("green_wall_banner_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> GRINDSTONE_FACE = EnumStateProperties.key(ResourceKey.sponge("grindstone_face"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> GRINDSTONE_FACING = EnumStateProperties.key(ResourceKey.sponge("grindstone_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> HAY_BLOCK_AXIS = EnumStateProperties.key(ResourceKey.sponge("hay_block_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> HOPPER_FACING = EnumStateProperties.key(ResourceKey.sponge("hopper_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> HORN_CORAL_WALL_FAN_FACING = EnumStateProperties.key(ResourceKey.sponge("horn_coral_wall_fan_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> IRON_DOOR_FACING = EnumStateProperties.key(ResourceKey.sponge("iron_door_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> IRON_DOOR_HALF = EnumStateProperties.key(ResourceKey.sponge("iron_door_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> IRON_DOOR_HINGE = EnumStateProperties.key(ResourceKey.sponge("iron_door_hinge"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> IRON_TRAPDOOR_FACING = EnumStateProperties.key(ResourceKey.sponge("iron_trapdoor_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> IRON_TRAPDOOR_HALF = EnumStateProperties.key(ResourceKey.sponge("iron_trapdoor_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JACK_O_LANTERN_FACING = EnumStateProperties.key(ResourceKey.sponge("jack_o_lantern_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JIGSAW_FACING = EnumStateProperties.key(ResourceKey.sponge("jigsaw_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JUNGLE_BUTTON_FACE = EnumStateProperties.key(ResourceKey.sponge("jungle_button_face"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JUNGLE_BUTTON_FACING = EnumStateProperties.key(ResourceKey.sponge("jungle_button_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JUNGLE_DOOR_FACING = EnumStateProperties.key(ResourceKey.sponge("jungle_door_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JUNGLE_DOOR_HALF = EnumStateProperties.key(ResourceKey.sponge("jungle_door_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JUNGLE_DOOR_HINGE = EnumStateProperties.key(ResourceKey.sponge("jungle_door_hinge"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JUNGLE_FENCE_GATE_FACING = EnumStateProperties.key(ResourceKey.sponge("jungle_fence_gate_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JUNGLE_LOG_AXIS = EnumStateProperties.key(ResourceKey.sponge("jungle_log_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JUNGLE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("jungle_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JUNGLE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("jungle_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JUNGLE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("jungle_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JUNGLE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("jungle_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JUNGLE_TRAPDOOR_FACING = EnumStateProperties.key(ResourceKey.sponge("jungle_trapdoor_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JUNGLE_TRAPDOOR_HALF = EnumStateProperties.key(ResourceKey.sponge("jungle_trapdoor_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JUNGLE_WALL_SIGN_FACING = EnumStateProperties.key(ResourceKey.sponge("jungle_wall_sign_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> JUNGLE_WOOD_AXIS = EnumStateProperties.key(ResourceKey.sponge("jungle_wood_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LADDER_FACING = EnumStateProperties.key(ResourceKey.sponge("ladder_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LARGE_FERN_HALF = EnumStateProperties.key(ResourceKey.sponge("large_fern_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LECTERN_FACING = EnumStateProperties.key(ResourceKey.sponge("lectern_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LEVER_FACE = EnumStateProperties.key(ResourceKey.sponge("lever_face"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LEVER_FACING = EnumStateProperties.key(ResourceKey.sponge("lever_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LIGHT_BLUE_BED_FACING = EnumStateProperties.key(ResourceKey.sponge("light_blue_bed_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LIGHT_BLUE_BED_PART = EnumStateProperties.key(ResourceKey.sponge("light_blue_bed_part"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LIGHT_BLUE_GLAZED_TERRACOTTA_FACING = EnumStateProperties.key(ResourceKey.sponge("light_blue_glazed_terracotta_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LIGHT_BLUE_SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("light_blue_shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LIGHT_BLUE_WALL_BANNER_FACING = EnumStateProperties.key(ResourceKey.sponge("light_blue_wall_banner_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LIGHT_GRAY_BED_FACING = EnumStateProperties.key(ResourceKey.sponge("light_gray_bed_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LIGHT_GRAY_BED_PART = EnumStateProperties.key(ResourceKey.sponge("light_gray_bed_part"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LIGHT_GRAY_GLAZED_TERRACOTTA_FACING = EnumStateProperties.key(ResourceKey.sponge("light_gray_glazed_terracotta_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LIGHT_GRAY_SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("light_gray_shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LIGHT_GRAY_WALL_BANNER_FACING = EnumStateProperties.key(ResourceKey.sponge("light_gray_wall_banner_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LILAC_HALF = EnumStateProperties.key(ResourceKey.sponge("lilac_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LIME_BED_FACING = EnumStateProperties.key(ResourceKey.sponge("lime_bed_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LIME_BED_PART = EnumStateProperties.key(ResourceKey.sponge("lime_bed_part"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LIME_GLAZED_TERRACOTTA_FACING = EnumStateProperties.key(ResourceKey.sponge("lime_glazed_terracotta_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LIME_SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("lime_shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LIME_WALL_BANNER_FACING = EnumStateProperties.key(ResourceKey.sponge("lime_wall_banner_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> LOOM_FACING = EnumStateProperties.key(ResourceKey.sponge("loom_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> MAGENTA_BED_FACING = EnumStateProperties.key(ResourceKey.sponge("magenta_bed_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> MAGENTA_BED_PART = EnumStateProperties.key(ResourceKey.sponge("magenta_bed_part"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> MAGENTA_GLAZED_TERRACOTTA_FACING = EnumStateProperties.key(ResourceKey.sponge("magenta_glazed_terracotta_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> MAGENTA_SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("magenta_shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> MAGENTA_WALL_BANNER_FACING = EnumStateProperties.key(ResourceKey.sponge("magenta_wall_banner_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> MOSSY_COBBLESTONE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("mossy_cobblestone_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> MOSSY_COBBLESTONE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("mossy_cobblestone_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> MOSSY_COBBLESTONE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("mossy_cobblestone_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> MOSSY_COBBLESTONE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("mossy_cobblestone_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> MOSSY_STONE_BRICK_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("mossy_stone_brick_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> MOSSY_STONE_BRICK_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("mossy_stone_brick_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> MOSSY_STONE_BRICK_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("mossy_stone_brick_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> MOSSY_STONE_BRICK_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("mossy_stone_brick_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> MOVING_PISTON_FACING = EnumStateProperties.key(ResourceKey.sponge("moving_piston_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> MOVING_PISTON_TYPE = EnumStateProperties.key(ResourceKey.sponge("moving_piston_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> NETHER_BRICK_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("nether_brick_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> NETHER_BRICK_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("nether_brick_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> NETHER_BRICK_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("nether_brick_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> NETHER_BRICK_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("nether_brick_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> NETHER_PORTAL_AXIS = EnumStateProperties.key(ResourceKey.sponge("nether_portal_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> NOTE_BLOCK_INSTRUMENT = EnumStateProperties.key(ResourceKey.sponge("note_block_instrument"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> OAK_BUTTON_FACE = EnumStateProperties.key(ResourceKey.sponge("oak_button_face"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> OAK_BUTTON_FACING = EnumStateProperties.key(ResourceKey.sponge("oak_button_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> OAK_DOOR_FACING = EnumStateProperties.key(ResourceKey.sponge("oak_door_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> OAK_DOOR_HALF = EnumStateProperties.key(ResourceKey.sponge("oak_door_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> OAK_DOOR_HINGE = EnumStateProperties.key(ResourceKey.sponge("oak_door_hinge"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> OAK_FENCE_GATE_FACING = EnumStateProperties.key(ResourceKey.sponge("oak_fence_gate_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> OAK_LOG_AXIS = EnumStateProperties.key(ResourceKey.sponge("oak_log_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> OAK_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("oak_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> OAK_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("oak_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> OAK_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("oak_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> OAK_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("oak_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> OAK_TRAPDOOR_FACING = EnumStateProperties.key(ResourceKey.sponge("oak_trapdoor_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> OAK_TRAPDOOR_HALF = EnumStateProperties.key(ResourceKey.sponge("oak_trapdoor_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> OAK_WALL_SIGN_FACING = EnumStateProperties.key(ResourceKey.sponge("oak_wall_sign_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> OAK_WOOD_AXIS = EnumStateProperties.key(ResourceKey.sponge("oak_wood_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> OBSERVER_FACING = EnumStateProperties.key(ResourceKey.sponge("observer_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ORANGE_BED_FACING = EnumStateProperties.key(ResourceKey.sponge("orange_bed_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ORANGE_BED_PART = EnumStateProperties.key(ResourceKey.sponge("orange_bed_part"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ORANGE_GLAZED_TERRACOTTA_FACING = EnumStateProperties.key(ResourceKey.sponge("orange_glazed_terracotta_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ORANGE_SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("orange_shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ORANGE_WALL_BANNER_FACING = EnumStateProperties.key(ResourceKey.sponge("orange_wall_banner_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PEONY_HALF = EnumStateProperties.key(ResourceKey.sponge("peony_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PETRIFIED_OAK_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("petrified_oak_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PINK_BED_FACING = EnumStateProperties.key(ResourceKey.sponge("pink_bed_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PINK_BED_PART = EnumStateProperties.key(ResourceKey.sponge("pink_bed_part"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PINK_GLAZED_TERRACOTTA_FACING = EnumStateProperties.key(ResourceKey.sponge("pink_glazed_terracotta_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PINK_SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("pink_shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PINK_WALL_BANNER_FACING = EnumStateProperties.key(ResourceKey.sponge("pink_wall_banner_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PISTON_FACING = EnumStateProperties.key(ResourceKey.sponge("piston_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PISTON_HEAD_FACING = EnumStateProperties.key(ResourceKey.sponge("piston_head_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PISTON_HEAD_TYPE = EnumStateProperties.key(ResourceKey.sponge("piston_head_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PLAYER_WALL_HEAD_FACING = EnumStateProperties.key(ResourceKey.sponge("player_wall_head_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> POLISHED_ANDESITE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("polished_andesite_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> POLISHED_ANDESITE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("polished_andesite_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> POLISHED_ANDESITE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("polished_andesite_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> POLISHED_ANDESITE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("polished_andesite_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> POLISHED_DIORITE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("polished_diorite_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> POLISHED_DIORITE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("polished_diorite_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> POLISHED_DIORITE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("polished_diorite_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> POLISHED_DIORITE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("polished_diorite_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> POLISHED_GRANITE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("polished_granite_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> POLISHED_GRANITE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("polished_granite_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> POLISHED_GRANITE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("polished_granite_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> POLISHED_GRANITE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("polished_granite_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> POWERED_RAIL_SHAPE = EnumStateProperties.key(ResourceKey.sponge("powered_rail_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PRISMARINE_BRICK_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("prismarine_brick_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PRISMARINE_BRICK_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("prismarine_brick_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PRISMARINE_BRICK_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("prismarine_brick_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PRISMARINE_BRICK_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("prismarine_brick_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PRISMARINE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("prismarine_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PRISMARINE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("prismarine_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PRISMARINE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("prismarine_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PRISMARINE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("prismarine_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PURPLE_BED_FACING = EnumStateProperties.key(ResourceKey.sponge("purple_bed_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PURPLE_BED_PART = EnumStateProperties.key(ResourceKey.sponge("purple_bed_part"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PURPLE_GLAZED_TERRACOTTA_FACING = EnumStateProperties.key(ResourceKey.sponge("purple_glazed_terracotta_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PURPLE_SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("purple_shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PURPLE_WALL_BANNER_FACING = EnumStateProperties.key(ResourceKey.sponge("purple_wall_banner_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PURPUR_PILLAR_AXIS = EnumStateProperties.key(ResourceKey.sponge("purpur_pillar_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PURPUR_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("purpur_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PURPUR_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("purpur_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PURPUR_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("purpur_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> PURPUR_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("purpur_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> QUARTZ_PILLAR_AXIS = EnumStateProperties.key(ResourceKey.sponge("quartz_pillar_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> QUARTZ_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("quartz_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> QUARTZ_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("quartz_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> QUARTZ_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("quartz_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> QUARTZ_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("quartz_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> RAIL_SHAPE = EnumStateProperties.key(ResourceKey.sponge("rail_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> REDSTONE_WALL_TORCH_FACING = EnumStateProperties.key(ResourceKey.sponge("redstone_wall_torch_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> REDSTONE_WIRE_EAST = EnumStateProperties.key(ResourceKey.sponge("redstone_wire_east"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> REDSTONE_WIRE_NORTH = EnumStateProperties.key(ResourceKey.sponge("redstone_wire_north"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> REDSTONE_WIRE_SOUTH = EnumStateProperties.key(ResourceKey.sponge("redstone_wire_south"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> REDSTONE_WIRE_WEST = EnumStateProperties.key(ResourceKey.sponge("redstone_wire_west"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> RED_BED_FACING = EnumStateProperties.key(ResourceKey.sponge("red_bed_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> RED_BED_PART = EnumStateProperties.key(ResourceKey.sponge("red_bed_part"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> RED_GLAZED_TERRACOTTA_FACING = EnumStateProperties.key(ResourceKey.sponge("red_glazed_terracotta_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> RED_NETHER_BRICK_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("red_nether_brick_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> RED_NETHER_BRICK_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("red_nether_brick_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> RED_NETHER_BRICK_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("red_nether_brick_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> RED_NETHER_BRICK_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("red_nether_brick_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> RED_SANDSTONE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("red_sandstone_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> RED_SANDSTONE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("red_sandstone_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> RED_SANDSTONE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("red_sandstone_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> RED_SANDSTONE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("red_sandstone_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> RED_SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("red_shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> RED_WALL_BANNER_FACING = EnumStateProperties.key(ResourceKey.sponge("red_wall_banner_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> REPEATER_FACING = EnumStateProperties.key(ResourceKey.sponge("repeater_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> REPEATING_COMMAND_BLOCK_FACING = EnumStateProperties.key(ResourceKey.sponge("repeating_command_block_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ROSE_BUSH_HALF = EnumStateProperties.key(ResourceKey.sponge("rose_bush_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SANDSTONE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("sandstone_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SANDSTONE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("sandstone_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SANDSTONE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("sandstone_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SANDSTONE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("sandstone_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SKELETON_WALL_SKULL_FACING = EnumStateProperties.key(ResourceKey.sponge("skeleton_wall_skull_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SMOKER_FACING = EnumStateProperties.key(ResourceKey.sponge("smoker_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SMOOTH_QUARTZ_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("smooth_quartz_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SMOOTH_QUARTZ_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("smooth_quartz_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SMOOTH_QUARTZ_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("smooth_quartz_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SMOOTH_QUARTZ_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("smooth_quartz_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SMOOTH_RED_SANDSTONE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("smooth_red_sandstone_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SMOOTH_RED_SANDSTONE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("smooth_red_sandstone_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SMOOTH_RED_SANDSTONE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("smooth_red_sandstone_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SMOOTH_RED_SANDSTONE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("smooth_red_sandstone_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SMOOTH_SANDSTONE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("smooth_sandstone_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SMOOTH_SANDSTONE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("smooth_sandstone_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SMOOTH_SANDSTONE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("smooth_sandstone_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SMOOTH_SANDSTONE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("smooth_sandstone_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SMOOTH_STONE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("smooth_stone_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SPRUCE_BUTTON_FACE = EnumStateProperties.key(ResourceKey.sponge("spruce_button_face"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SPRUCE_BUTTON_FACING = EnumStateProperties.key(ResourceKey.sponge("spruce_button_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SPRUCE_DOOR_FACING = EnumStateProperties.key(ResourceKey.sponge("spruce_door_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SPRUCE_DOOR_HALF = EnumStateProperties.key(ResourceKey.sponge("spruce_door_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SPRUCE_DOOR_HINGE = EnumStateProperties.key(ResourceKey.sponge("spruce_door_hinge"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SPRUCE_FENCE_GATE_FACING = EnumStateProperties.key(ResourceKey.sponge("spruce_fence_gate_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SPRUCE_LOG_AXIS = EnumStateProperties.key(ResourceKey.sponge("spruce_log_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SPRUCE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("spruce_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SPRUCE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("spruce_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SPRUCE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("spruce_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SPRUCE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("spruce_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SPRUCE_TRAPDOOR_FACING = EnumStateProperties.key(ResourceKey.sponge("spruce_trapdoor_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SPRUCE_TRAPDOOR_HALF = EnumStateProperties.key(ResourceKey.sponge("spruce_trapdoor_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SPRUCE_WALL_SIGN_FACING = EnumStateProperties.key(ResourceKey.sponge("spruce_wall_sign_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SPRUCE_WOOD_AXIS = EnumStateProperties.key(ResourceKey.sponge("spruce_wood_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STICKY_PISTON_FACING = EnumStateProperties.key(ResourceKey.sponge("sticky_piston_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STONECUTTER_FACING = EnumStateProperties.key(ResourceKey.sponge("stonecutter_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STONE_BRICK_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("stone_brick_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STONE_BRICK_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("stone_brick_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STONE_BRICK_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("stone_brick_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STONE_BRICK_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("stone_brick_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STONE_BUTTON_FACE = EnumStateProperties.key(ResourceKey.sponge("stone_button_face"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STONE_BUTTON_FACING = EnumStateProperties.key(ResourceKey.sponge("stone_button_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STONE_SLAB_TYPE = EnumStateProperties.key(ResourceKey.sponge("stone_slab_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STONE_STAIRS_FACING = EnumStateProperties.key(ResourceKey.sponge("stone_stairs_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STONE_STAIRS_HALF = EnumStateProperties.key(ResourceKey.sponge("stone_stairs_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STONE_STAIRS_SHAPE = EnumStateProperties.key(ResourceKey.sponge("stone_stairs_shape"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STRIPPED_ACACIA_LOG_AXIS = EnumStateProperties.key(ResourceKey.sponge("stripped_acacia_log_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STRIPPED_ACACIA_WOOD_AXIS = EnumStateProperties.key(ResourceKey.sponge("stripped_acacia_wood_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STRIPPED_BIRCH_LOG_AXIS = EnumStateProperties.key(ResourceKey.sponge("stripped_birch_log_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STRIPPED_BIRCH_WOOD_AXIS = EnumStateProperties.key(ResourceKey.sponge("stripped_birch_wood_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STRIPPED_DARK_OAK_LOG_AXIS = EnumStateProperties.key(ResourceKey.sponge("stripped_dark_oak_log_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STRIPPED_DARK_OAK_WOOD_AXIS = EnumStateProperties.key(ResourceKey.sponge("stripped_dark_oak_wood_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STRIPPED_JUNGLE_LOG_AXIS = EnumStateProperties.key(ResourceKey.sponge("stripped_jungle_log_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STRIPPED_JUNGLE_WOOD_AXIS = EnumStateProperties.key(ResourceKey.sponge("stripped_jungle_wood_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STRIPPED_OAK_LOG_AXIS = EnumStateProperties.key(ResourceKey.sponge("stripped_oak_log_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STRIPPED_OAK_WOOD_AXIS = EnumStateProperties.key(ResourceKey.sponge("stripped_oak_wood_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STRIPPED_SPRUCE_LOG_AXIS = EnumStateProperties.key(ResourceKey.sponge("stripped_spruce_log_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STRIPPED_SPRUCE_WOOD_AXIS = EnumStateProperties.key(ResourceKey.sponge("stripped_spruce_wood_axis"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> STRUCTURE_BLOCK_MODE = EnumStateProperties.key(ResourceKey.sponge("structure_block_mode"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> SUNFLOWER_HALF = EnumStateProperties.key(ResourceKey.sponge("sunflower_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> TALL_GRASS_HALF = EnumStateProperties.key(ResourceKey.sponge("tall_grass_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> TALL_SEAGRASS_HALF = EnumStateProperties.key(ResourceKey.sponge("tall_seagrass_half"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> TRAPPED_CHEST_FACING = EnumStateProperties.key(ResourceKey.sponge("trapped_chest_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> TRAPPED_CHEST_TYPE = EnumStateProperties.key(ResourceKey.sponge("trapped_chest_type"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> TRIPWIRE_HOOK_FACING = EnumStateProperties.key(ResourceKey.sponge("tripwire_hook_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> TUBE_CORAL_WALL_FAN_FACING = EnumStateProperties.key(ResourceKey.sponge("tube_coral_wall_fan_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> WALL_TORCH_FACING = EnumStateProperties.key(ResourceKey.sponge("wall_torch_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> WHITE_BED_FACING = EnumStateProperties.key(ResourceKey.sponge("white_bed_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> WHITE_BED_PART = EnumStateProperties.key(ResourceKey.sponge("white_bed_part"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> WHITE_GLAZED_TERRACOTTA_FACING = EnumStateProperties.key(ResourceKey.sponge("white_glazed_terracotta_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> WHITE_SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("white_shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> WHITE_WALL_BANNER_FACING = EnumStateProperties.key(ResourceKey.sponge("white_wall_banner_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> WITHER_SKELETON_WALL_SKULL_FACING = EnumStateProperties.key(ResourceKey.sponge("wither_skeleton_wall_skull_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> YELLOW_BED_FACING = EnumStateProperties.key(ResourceKey.sponge("yellow_bed_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> YELLOW_BED_PART = EnumStateProperties.key(ResourceKey.sponge("yellow_bed_part"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> YELLOW_GLAZED_TERRACOTTA_FACING = EnumStateProperties.key(ResourceKey.sponge("yellow_glazed_terracotta_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> YELLOW_SHULKER_BOX_FACING = EnumStateProperties.key(ResourceKey.sponge("yellow_shulker_box_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> YELLOW_WALL_BANNER_FACING = EnumStateProperties.key(ResourceKey.sponge("yellow_wall_banner_facing"));

    public static final DefaultedRegistryReference<EnumStateProperty<?>> ZOMBIE_WALL_HEAD_FACING = EnumStateProperties.key(ResourceKey.sponge("zombie_wall_head_facing"));

    // SORTFIELDS:OFF

    // @formatter:on

    private EnumStateProperties() {
    }

    private static DefaultedRegistryReference<EnumStateProperty<?>> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.ENUM_STATE_PROPERTY, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
