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

    public static final Supplier<EnumStateProperty<?>> ACACIA_BUTTON_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ACACIA_BUTTON_FACE");

    public static final Supplier<EnumStateProperty<?>> ACACIA_BUTTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ACACIA_BUTTON_FACING");

    public static final Supplier<EnumStateProperty<?>> ACACIA_DOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ACACIA_DOOR_FACING");

    public static final Supplier<EnumStateProperty<?>> ACACIA_DOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ACACIA_DOOR_HALF");

    public static final Supplier<EnumStateProperty<?>> ACACIA_DOOR_HINGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ACACIA_DOOR_HINGE");

    public static final Supplier<EnumStateProperty<?>> ACACIA_FENCE_GATE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ACACIA_FENCE_GATE_FACING");

    public static final Supplier<EnumStateProperty<?>> ACACIA_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ACACIA_LOG_AXIS");

    public static final Supplier<EnumStateProperty<?>> ACACIA_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ACACIA_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> ACACIA_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ACACIA_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> ACACIA_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ACACIA_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> ACACIA_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ACACIA_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> ACACIA_TRAPDOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ACACIA_TRAPDOOR_FACING");

    public static final Supplier<EnumStateProperty<?>> ACACIA_TRAPDOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ACACIA_TRAPDOOR_HALF");

    public static final Supplier<EnumStateProperty<?>> ACACIA_WALL_SIGN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ACACIA_WALL_SIGN_FACING");

    public static final Supplier<EnumStateProperty<?>> ACACIA_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ACACIA_WOOD_AXIS");

    public static final Supplier<EnumStateProperty<?>> ACTIVATOR_RAIL_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ACTIVATOR_RAIL_SHAPE");

    public static final Supplier<EnumStateProperty<?>> ANDESITE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ANDESITE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> ANDESITE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ANDESITE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> ANDESITE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ANDESITE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> ANDESITE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ANDESITE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> ANVIL_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ANVIL_FACING");

    public static final Supplier<EnumStateProperty<?>> ATTACHED_MELON_STEM_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ATTACHED_MELON_STEM_FACING");

    public static final Supplier<EnumStateProperty<?>> ATTACHED_PUMPKIN_STEM_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ATTACHED_PUMPKIN_STEM_FACING");

    public static final Supplier<EnumStateProperty<?>> BAMBOO_LEAVES = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BAMBOO_LEAVES");

    public static final Supplier<EnumStateProperty<?>> BARREL_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BARREL_FACING");

    public static final Supplier<EnumStateProperty<?>> BELL_ATTACHMENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BELL_ATTACHMENT");

    public static final Supplier<EnumStateProperty<?>> BELL_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BELL_FACING");

    public static final Supplier<EnumStateProperty<?>> BIRCH_BUTTON_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BIRCH_BUTTON_FACE");

    public static final Supplier<EnumStateProperty<?>> BIRCH_BUTTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BIRCH_BUTTON_FACING");

    public static final Supplier<EnumStateProperty<?>> BIRCH_DOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BIRCH_DOOR_FACING");

    public static final Supplier<EnumStateProperty<?>> BIRCH_DOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BIRCH_DOOR_HALF");

    public static final Supplier<EnumStateProperty<?>> BIRCH_DOOR_HINGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BIRCH_DOOR_HINGE");

    public static final Supplier<EnumStateProperty<?>> BIRCH_FENCE_GATE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BIRCH_FENCE_GATE_FACING");

    public static final Supplier<EnumStateProperty<?>> BIRCH_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BIRCH_LOG_AXIS");

    public static final Supplier<EnumStateProperty<?>> BIRCH_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BIRCH_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> BIRCH_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BIRCH_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> BIRCH_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BIRCH_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> BIRCH_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BIRCH_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> BIRCH_TRAPDOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BIRCH_TRAPDOOR_FACING");

    public static final Supplier<EnumStateProperty<?>> BIRCH_TRAPDOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BIRCH_TRAPDOOR_HALF");

    public static final Supplier<EnumStateProperty<?>> BIRCH_WALL_SIGN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BIRCH_WALL_SIGN_FACING");

    public static final Supplier<EnumStateProperty<?>> BIRCH_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BIRCH_WOOD_AXIS");

    public static final Supplier<EnumStateProperty<?>> BLACK_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BLACK_BED_FACING");

    public static final Supplier<EnumStateProperty<?>> BLACK_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BLACK_BED_PART");

    public static final Supplier<EnumStateProperty<?>> BLACK_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BLACK_GLAZED_TERRACOTTA_FACING");

    public static final Supplier<EnumStateProperty<?>> BLACK_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BLACK_SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> BLACK_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BLACK_WALL_BANNER_FACING");

    public static final Supplier<EnumStateProperty<?>> BLAST_FURNACE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BLAST_FURNACE_FACING");

    public static final Supplier<EnumStateProperty<?>> BLUE_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BLUE_BED_FACING");

    public static final Supplier<EnumStateProperty<?>> BLUE_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BLUE_BED_PART");

    public static final Supplier<EnumStateProperty<?>> BLUE_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BLUE_GLAZED_TERRACOTTA_FACING");

    public static final Supplier<EnumStateProperty<?>> BLUE_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BLUE_SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> BLUE_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BLUE_WALL_BANNER_FACING");

    public static final Supplier<EnumStateProperty<?>> BONE_BLOCK_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BONE_BLOCK_AXIS");

    public static final Supplier<EnumStateProperty<?>> BRAIN_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BRAIN_CORAL_WALL_FAN_FACING");

    public static final Supplier<EnumStateProperty<?>> BRICK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BRICK_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> BRICK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BRICK_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> BRICK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BRICK_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> BRICK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BRICK_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> BROWN_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BROWN_BED_FACING");

    public static final Supplier<EnumStateProperty<?>> BROWN_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BROWN_BED_PART");

    public static final Supplier<EnumStateProperty<?>> BROWN_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BROWN_GLAZED_TERRACOTTA_FACING");

    public static final Supplier<EnumStateProperty<?>> BROWN_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BROWN_SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> BROWN_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BROWN_WALL_BANNER_FACING");

    public static final Supplier<EnumStateProperty<?>> BUBBLE_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "BUBBLE_CORAL_WALL_FAN_FACING");

    public static final Supplier<EnumStateProperty<?>> CAMPFIRE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "CAMPFIRE_FACING");

    public static final Supplier<EnumStateProperty<?>> CARVED_PUMPKIN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "CARVED_PUMPKIN_FACING");

    public static final Supplier<EnumStateProperty<?>> CHAIN_COMMAND_BLOCK_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "CHAIN_COMMAND_BLOCK_FACING");

    public static final Supplier<EnumStateProperty<?>> CHEST_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "CHEST_FACING");

    public static final Supplier<EnumStateProperty<?>> CHEST_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "CHEST_TYPE");

    public static final Supplier<EnumStateProperty<?>> CHIPPED_ANVIL_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "CHIPPED_ANVIL_FACING");

    public static final Supplier<EnumStateProperty<?>> COBBLESTONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "COBBLESTONE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> COBBLESTONE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "COBBLESTONE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> COBBLESTONE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "COBBLESTONE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> COBBLESTONE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "COBBLESTONE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> COCOA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "COCOA_FACING");

    public static final Supplier<EnumStateProperty<?>> COMMAND_BLOCK_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "COMMAND_BLOCK_FACING");

    public static final Supplier<EnumStateProperty<?>> COMPARATOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "COMPARATOR_FACING");

    public static final Supplier<EnumStateProperty<?>> COMPARATOR_MODE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "COMPARATOR_MODE");

    public static final Supplier<EnumStateProperty<?>> CREEPER_WALL_HEAD_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "CREEPER_WALL_HEAD_FACING");

    public static final Supplier<EnumStateProperty<?>> CUT_RED_SANDSTONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "CUT_RED_SANDSTONE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> CUT_SANDSTONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "CUT_SANDSTONE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> CYAN_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "CYAN_BED_FACING");

    public static final Supplier<EnumStateProperty<?>> CYAN_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "CYAN_BED_PART");

    public static final Supplier<EnumStateProperty<?>> CYAN_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "CYAN_GLAZED_TERRACOTTA_FACING");

    public static final Supplier<EnumStateProperty<?>> CYAN_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "CYAN_SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> CYAN_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "CYAN_WALL_BANNER_FACING");

    public static final Supplier<EnumStateProperty<?>> DAMAGED_ANVIL_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DAMAGED_ANVIL_FACING");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_BUTTON_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_OAK_BUTTON_FACE");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_BUTTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_OAK_BUTTON_FACING");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_DOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_OAK_DOOR_FACING");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_DOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_OAK_DOOR_HALF");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_DOOR_HINGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_OAK_DOOR_HINGE");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_FENCE_GATE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_OAK_FENCE_GATE_FACING");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_OAK_LOG_AXIS");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_OAK_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_OAK_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_OAK_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_OAK_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_TRAPDOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_OAK_TRAPDOOR_FACING");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_TRAPDOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_OAK_TRAPDOOR_HALF");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_WALL_SIGN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_OAK_WALL_SIGN_FACING");

    public static final Supplier<EnumStateProperty<?>> DARK_OAK_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_OAK_WOOD_AXIS");

    public static final Supplier<EnumStateProperty<?>> DARK_PRISMARINE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_PRISMARINE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> DARK_PRISMARINE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_PRISMARINE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> DARK_PRISMARINE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_PRISMARINE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> DARK_PRISMARINE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DARK_PRISMARINE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> DEAD_BRAIN_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DEAD_BRAIN_CORAL_WALL_FAN_FACING");

    public static final Supplier<EnumStateProperty<?>> DEAD_BUBBLE_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DEAD_BUBBLE_CORAL_WALL_FAN_FACING");

    public static final Supplier<EnumStateProperty<?>> DEAD_FIRE_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DEAD_FIRE_CORAL_WALL_FAN_FACING");

    public static final Supplier<EnumStateProperty<?>> DEAD_HORN_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DEAD_HORN_CORAL_WALL_FAN_FACING");

    public static final Supplier<EnumStateProperty<?>> DEAD_TUBE_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DEAD_TUBE_CORAL_WALL_FAN_FACING");

    public static final Supplier<EnumStateProperty<?>> DETECTOR_RAIL_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DETECTOR_RAIL_SHAPE");

    public static final Supplier<EnumStateProperty<?>> DIORITE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DIORITE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> DIORITE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DIORITE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> DIORITE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DIORITE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> DIORITE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DIORITE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> DISPENSER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DISPENSER_FACING");

    public static final Supplier<EnumStateProperty<?>> DRAGON_WALL_HEAD_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DRAGON_WALL_HEAD_FACING");

    public static final Supplier<EnumStateProperty<?>> DROPPER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "DROPPER_FACING");

    public static final Supplier<EnumStateProperty<?>> ENDER_CHEST_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ENDER_CHEST_FACING");

    public static final Supplier<EnumStateProperty<?>> END_PORTAL_FRAME_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "END_PORTAL_FRAME_FACING");

    public static final Supplier<EnumStateProperty<?>> END_ROD_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "END_ROD_FACING");

    public static final Supplier<EnumStateProperty<?>> END_STONE_BRICK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "END_STONE_BRICK_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> END_STONE_BRICK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "END_STONE_BRICK_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> END_STONE_BRICK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "END_STONE_BRICK_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> END_STONE_BRICK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "END_STONE_BRICK_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> FIRE_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "FIRE_CORAL_WALL_FAN_FACING");

    public static final Supplier<EnumStateProperty<?>> FURNACE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "FURNACE_FACING");

    public static final Supplier<EnumStateProperty<?>> GRANITE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "GRANITE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> GRANITE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "GRANITE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> GRANITE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "GRANITE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> GRANITE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "GRANITE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> GRAY_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "GRAY_BED_FACING");

    public static final Supplier<EnumStateProperty<?>> GRAY_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "GRAY_BED_PART");

    public static final Supplier<EnumStateProperty<?>> GRAY_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "GRAY_GLAZED_TERRACOTTA_FACING");

    public static final Supplier<EnumStateProperty<?>> GRAY_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "GRAY_SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> GRAY_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "GRAY_WALL_BANNER_FACING");

    public static final Supplier<EnumStateProperty<?>> GREEN_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "GREEN_BED_FACING");

    public static final Supplier<EnumStateProperty<?>> GREEN_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "GREEN_BED_PART");

    public static final Supplier<EnumStateProperty<?>> GREEN_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "GREEN_GLAZED_TERRACOTTA_FACING");

    public static final Supplier<EnumStateProperty<?>> GREEN_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "GREEN_SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> GREEN_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "GREEN_WALL_BANNER_FACING");

    public static final Supplier<EnumStateProperty<?>> GRINDSTONE_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "GRINDSTONE_FACE");

    public static final Supplier<EnumStateProperty<?>> GRINDSTONE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "GRINDSTONE_FACING");

    public static final Supplier<EnumStateProperty<?>> HAY_BLOCK_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "HAY_BLOCK_AXIS");

    public static final Supplier<EnumStateProperty<?>> HOPPER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "HOPPER_FACING");

    public static final Supplier<EnumStateProperty<?>> HORN_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "HORN_CORAL_WALL_FAN_FACING");

    public static final Supplier<EnumStateProperty<?>> IRON_DOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "IRON_DOOR_FACING");

    public static final Supplier<EnumStateProperty<?>> IRON_DOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "IRON_DOOR_HALF");

    public static final Supplier<EnumStateProperty<?>> IRON_DOOR_HINGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "IRON_DOOR_HINGE");

    public static final Supplier<EnumStateProperty<?>> IRON_TRAPDOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "IRON_TRAPDOOR_FACING");

    public static final Supplier<EnumStateProperty<?>> IRON_TRAPDOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "IRON_TRAPDOOR_HALF");

    public static final Supplier<EnumStateProperty<?>> JACK_O_LANTERN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JACK_O_LANTERN_FACING");

    public static final Supplier<EnumStateProperty<?>> JIGSAW_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JIGSAW_FACING");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_BUTTON_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JUNGLE_BUTTON_FACE");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_BUTTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JUNGLE_BUTTON_FACING");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_DOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JUNGLE_DOOR_FACING");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_DOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JUNGLE_DOOR_HALF");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_DOOR_HINGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JUNGLE_DOOR_HINGE");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_FENCE_GATE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JUNGLE_FENCE_GATE_FACING");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JUNGLE_LOG_AXIS");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JUNGLE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JUNGLE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JUNGLE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JUNGLE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_TRAPDOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JUNGLE_TRAPDOOR_FACING");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_TRAPDOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JUNGLE_TRAPDOOR_HALF");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_WALL_SIGN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JUNGLE_WALL_SIGN_FACING");

    public static final Supplier<EnumStateProperty<?>> JUNGLE_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "JUNGLE_WOOD_AXIS");

    public static final Supplier<EnumStateProperty<?>> LADDER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LADDER_FACING");

    public static final Supplier<EnumStateProperty<?>> LARGE_FERN_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LARGE_FERN_HALF");

    public static final Supplier<EnumStateProperty<?>> LECTERN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LECTERN_FACING");

    public static final Supplier<EnumStateProperty<?>> LEVER_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LEVER_FACE");

    public static final Supplier<EnumStateProperty<?>> LEVER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LEVER_FACING");

    public static final Supplier<EnumStateProperty<?>> LIGHT_BLUE_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LIGHT_BLUE_BED_FACING");

    public static final Supplier<EnumStateProperty<?>> LIGHT_BLUE_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LIGHT_BLUE_BED_PART");

    public static final Supplier<EnumStateProperty<?>> LIGHT_BLUE_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LIGHT_BLUE_GLAZED_TERRACOTTA_FACING");

    public static final Supplier<EnumStateProperty<?>> LIGHT_BLUE_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LIGHT_BLUE_SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> LIGHT_BLUE_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LIGHT_BLUE_WALL_BANNER_FACING");

    public static final Supplier<EnumStateProperty<?>> LIGHT_GRAY_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LIGHT_GRAY_BED_FACING");

    public static final Supplier<EnumStateProperty<?>> LIGHT_GRAY_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LIGHT_GRAY_BED_PART");

    public static final Supplier<EnumStateProperty<?>> LIGHT_GRAY_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LIGHT_GRAY_GLAZED_TERRACOTTA_FACING");

    public static final Supplier<EnumStateProperty<?>> LIGHT_GRAY_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LIGHT_GRAY_SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> LIGHT_GRAY_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LIGHT_GRAY_WALL_BANNER_FACING");

    public static final Supplier<EnumStateProperty<?>> LILAC_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LILAC_HALF");

    public static final Supplier<EnumStateProperty<?>> LIME_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LIME_BED_FACING");

    public static final Supplier<EnumStateProperty<?>> LIME_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LIME_BED_PART");

    public static final Supplier<EnumStateProperty<?>> LIME_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LIME_GLAZED_TERRACOTTA_FACING");

    public static final Supplier<EnumStateProperty<?>> LIME_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LIME_SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> LIME_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LIME_WALL_BANNER_FACING");

    public static final Supplier<EnumStateProperty<?>> LOOM_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "LOOM_FACING");

    public static final Supplier<EnumStateProperty<?>> MAGENTA_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "MAGENTA_BED_FACING");

    public static final Supplier<EnumStateProperty<?>> MAGENTA_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "MAGENTA_BED_PART");

    public static final Supplier<EnumStateProperty<?>> MAGENTA_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "MAGENTA_GLAZED_TERRACOTTA_FACING");

    public static final Supplier<EnumStateProperty<?>> MAGENTA_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "MAGENTA_SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> MAGENTA_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "MAGENTA_WALL_BANNER_FACING");

    public static final Supplier<EnumStateProperty<?>> MOSSY_COBBLESTONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "MOSSY_COBBLESTONE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> MOSSY_COBBLESTONE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "MOSSY_COBBLESTONE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> MOSSY_COBBLESTONE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "MOSSY_COBBLESTONE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> MOSSY_COBBLESTONE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "MOSSY_COBBLESTONE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> MOSSY_STONE_BRICK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "MOSSY_STONE_BRICK_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> MOSSY_STONE_BRICK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "MOSSY_STONE_BRICK_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> MOSSY_STONE_BRICK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "MOSSY_STONE_BRICK_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> MOSSY_STONE_BRICK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "MOSSY_STONE_BRICK_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> MOVING_PISTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "MOVING_PISTON_FACING");

    public static final Supplier<EnumStateProperty<?>> MOVING_PISTON_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "MOVING_PISTON_TYPE");

    public static final Supplier<EnumStateProperty<?>> NETHER_BRICK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "NETHER_BRICK_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> NETHER_BRICK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "NETHER_BRICK_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> NETHER_BRICK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "NETHER_BRICK_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> NETHER_BRICK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "NETHER_BRICK_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> NETHER_PORTAL_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "NETHER_PORTAL_AXIS");

    public static final Supplier<EnumStateProperty<?>> NOTE_BLOCK_INSTRUMENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "NOTE_BLOCK_INSTRUMENT");

    public static final Supplier<EnumStateProperty<?>> OAK_BUTTON_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "OAK_BUTTON_FACE");

    public static final Supplier<EnumStateProperty<?>> OAK_BUTTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "OAK_BUTTON_FACING");

    public static final Supplier<EnumStateProperty<?>> OAK_DOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "OAK_DOOR_FACING");

    public static final Supplier<EnumStateProperty<?>> OAK_DOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "OAK_DOOR_HALF");

    public static final Supplier<EnumStateProperty<?>> OAK_DOOR_HINGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "OAK_DOOR_HINGE");

    public static final Supplier<EnumStateProperty<?>> OAK_FENCE_GATE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "OAK_FENCE_GATE_FACING");

    public static final Supplier<EnumStateProperty<?>> OAK_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "OAK_LOG_AXIS");

    public static final Supplier<EnumStateProperty<?>> OAK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "OAK_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> OAK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "OAK_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> OAK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "OAK_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> OAK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "OAK_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> OAK_TRAPDOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "OAK_TRAPDOOR_FACING");

    public static final Supplier<EnumStateProperty<?>> OAK_TRAPDOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "OAK_TRAPDOOR_HALF");

    public static final Supplier<EnumStateProperty<?>> OAK_WALL_SIGN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "OAK_WALL_SIGN_FACING");

    public static final Supplier<EnumStateProperty<?>> OAK_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "OAK_WOOD_AXIS");

    public static final Supplier<EnumStateProperty<?>> OBSERVER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "OBSERVER_FACING");

    public static final Supplier<EnumStateProperty<?>> ORANGE_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ORANGE_BED_FACING");

    public static final Supplier<EnumStateProperty<?>> ORANGE_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ORANGE_BED_PART");

    public static final Supplier<EnumStateProperty<?>> ORANGE_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ORANGE_GLAZED_TERRACOTTA_FACING");

    public static final Supplier<EnumStateProperty<?>> ORANGE_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ORANGE_SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> ORANGE_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ORANGE_WALL_BANNER_FACING");

    public static final Supplier<EnumStateProperty<?>> PEONY_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PEONY_HALF");

    public static final Supplier<EnumStateProperty<?>> PETRIFIED_OAK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PETRIFIED_OAK_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> PINK_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PINK_BED_FACING");

    public static final Supplier<EnumStateProperty<?>> PINK_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PINK_BED_PART");

    public static final Supplier<EnumStateProperty<?>> PINK_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PINK_GLAZED_TERRACOTTA_FACING");

    public static final Supplier<EnumStateProperty<?>> PINK_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PINK_SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> PINK_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PINK_WALL_BANNER_FACING");

    public static final Supplier<EnumStateProperty<?>> PISTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PISTON_FACING");

    public static final Supplier<EnumStateProperty<?>> PISTON_HEAD_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PISTON_HEAD_FACING");

    public static final Supplier<EnumStateProperty<?>> PISTON_HEAD_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PISTON_HEAD_TYPE");

    public static final Supplier<EnumStateProperty<?>> PLAYER_WALL_HEAD_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PLAYER_WALL_HEAD_FACING");

    public static final Supplier<EnumStateProperty<?>> POLISHED_ANDESITE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "POLISHED_ANDESITE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> POLISHED_ANDESITE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "POLISHED_ANDESITE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> POLISHED_ANDESITE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "POLISHED_ANDESITE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> POLISHED_ANDESITE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "POLISHED_ANDESITE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> POLISHED_DIORITE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "POLISHED_DIORITE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> POLISHED_DIORITE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "POLISHED_DIORITE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> POLISHED_DIORITE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "POLISHED_DIORITE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> POLISHED_DIORITE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "POLISHED_DIORITE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> POLISHED_GRANITE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "POLISHED_GRANITE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> POLISHED_GRANITE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "POLISHED_GRANITE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> POLISHED_GRANITE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "POLISHED_GRANITE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> POLISHED_GRANITE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "POLISHED_GRANITE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> POWERED_RAIL_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "POWERED_RAIL_SHAPE");

    public static final Supplier<EnumStateProperty<?>> PRISMARINE_BRICK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PRISMARINE_BRICK_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> PRISMARINE_BRICK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PRISMARINE_BRICK_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> PRISMARINE_BRICK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PRISMARINE_BRICK_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> PRISMARINE_BRICK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PRISMARINE_BRICK_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> PRISMARINE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PRISMARINE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> PRISMARINE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PRISMARINE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> PRISMARINE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PRISMARINE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> PRISMARINE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PRISMARINE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> PURPLE_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PURPLE_BED_FACING");

    public static final Supplier<EnumStateProperty<?>> PURPLE_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PURPLE_BED_PART");

    public static final Supplier<EnumStateProperty<?>> PURPLE_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PURPLE_GLAZED_TERRACOTTA_FACING");

    public static final Supplier<EnumStateProperty<?>> PURPLE_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PURPLE_SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> PURPLE_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PURPLE_WALL_BANNER_FACING");

    public static final Supplier<EnumStateProperty<?>> PURPUR_PILLAR_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PURPUR_PILLAR_AXIS");

    public static final Supplier<EnumStateProperty<?>> PURPUR_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PURPUR_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> PURPUR_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PURPUR_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> PURPUR_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PURPUR_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> PURPUR_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "PURPUR_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> QUARTZ_PILLAR_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "QUARTZ_PILLAR_AXIS");

    public static final Supplier<EnumStateProperty<?>> QUARTZ_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "QUARTZ_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> QUARTZ_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "QUARTZ_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> QUARTZ_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "QUARTZ_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> QUARTZ_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "QUARTZ_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> RAIL_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "RAIL_SHAPE");

    public static final Supplier<EnumStateProperty<?>> REDSTONE_WALL_TORCH_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "REDSTONE_WALL_TORCH_FACING");

    public static final Supplier<EnumStateProperty<?>> REDSTONE_WIRE_EAST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "REDSTONE_WIRE_EAST");

    public static final Supplier<EnumStateProperty<?>> REDSTONE_WIRE_NORTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "REDSTONE_WIRE_NORTH");

    public static final Supplier<EnumStateProperty<?>> REDSTONE_WIRE_SOUTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "REDSTONE_WIRE_SOUTH");

    public static final Supplier<EnumStateProperty<?>> REDSTONE_WIRE_WEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "REDSTONE_WIRE_WEST");

    public static final Supplier<EnumStateProperty<?>> RED_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "RED_BED_FACING");

    public static final Supplier<EnumStateProperty<?>> RED_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "RED_BED_PART");

    public static final Supplier<EnumStateProperty<?>> RED_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "RED_GLAZED_TERRACOTTA_FACING");

    public static final Supplier<EnumStateProperty<?>> RED_NETHER_BRICK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "RED_NETHER_BRICK_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> RED_NETHER_BRICK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "RED_NETHER_BRICK_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> RED_NETHER_BRICK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "RED_NETHER_BRICK_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> RED_NETHER_BRICK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "RED_NETHER_BRICK_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> RED_SANDSTONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "RED_SANDSTONE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> RED_SANDSTONE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "RED_SANDSTONE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> RED_SANDSTONE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "RED_SANDSTONE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> RED_SANDSTONE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "RED_SANDSTONE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> RED_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "RED_SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> RED_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "RED_WALL_BANNER_FACING");

    public static final Supplier<EnumStateProperty<?>> REPEATER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "REPEATER_FACING");

    public static final Supplier<EnumStateProperty<?>> REPEATING_COMMAND_BLOCK_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "REPEATING_COMMAND_BLOCK_FACING");

    public static final Supplier<EnumStateProperty<?>> ROSE_BUSH_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ROSE_BUSH_HALF");

    public static final Supplier<EnumStateProperty<?>> SANDSTONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SANDSTONE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> SANDSTONE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SANDSTONE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> SANDSTONE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SANDSTONE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> SANDSTONE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SANDSTONE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> SKELETON_WALL_SKULL_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SKELETON_WALL_SKULL_FACING");

    public static final Supplier<EnumStateProperty<?>> SMOKER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SMOKER_FACING");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_QUARTZ_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SMOOTH_QUARTZ_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_QUARTZ_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SMOOTH_QUARTZ_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_QUARTZ_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SMOOTH_QUARTZ_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_QUARTZ_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SMOOTH_QUARTZ_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_RED_SANDSTONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SMOOTH_RED_SANDSTONE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_RED_SANDSTONE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SMOOTH_RED_SANDSTONE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_RED_SANDSTONE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SMOOTH_RED_SANDSTONE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_RED_SANDSTONE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SMOOTH_RED_SANDSTONE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_SANDSTONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SMOOTH_SANDSTONE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_SANDSTONE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SMOOTH_SANDSTONE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_SANDSTONE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SMOOTH_SANDSTONE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_SANDSTONE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SMOOTH_SANDSTONE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> SMOOTH_STONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SMOOTH_STONE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_BUTTON_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SPRUCE_BUTTON_FACE");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_BUTTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SPRUCE_BUTTON_FACING");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_DOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SPRUCE_DOOR_FACING");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_DOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SPRUCE_DOOR_HALF");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_DOOR_HINGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SPRUCE_DOOR_HINGE");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_FENCE_GATE_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SPRUCE_FENCE_GATE_FACING");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SPRUCE_LOG_AXIS");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SPRUCE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SPRUCE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SPRUCE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SPRUCE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_TRAPDOOR_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SPRUCE_TRAPDOOR_FACING");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_TRAPDOOR_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SPRUCE_TRAPDOOR_HALF");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_WALL_SIGN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SPRUCE_WALL_SIGN_FACING");

    public static final Supplier<EnumStateProperty<?>> SPRUCE_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SPRUCE_WOOD_AXIS");

    public static final Supplier<EnumStateProperty<?>> STICKY_PISTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STICKY_PISTON_FACING");

    public static final Supplier<EnumStateProperty<?>> STONECUTTER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STONECUTTER_FACING");

    public static final Supplier<EnumStateProperty<?>> STONE_BRICK_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STONE_BRICK_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> STONE_BRICK_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STONE_BRICK_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> STONE_BRICK_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STONE_BRICK_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> STONE_BRICK_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STONE_BRICK_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> STONE_BUTTON_FACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STONE_BUTTON_FACE");

    public static final Supplier<EnumStateProperty<?>> STONE_BUTTON_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STONE_BUTTON_FACING");

    public static final Supplier<EnumStateProperty<?>> STONE_SLAB_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STONE_SLAB_TYPE");

    public static final Supplier<EnumStateProperty<?>> STONE_STAIRS_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STONE_STAIRS_FACING");

    public static final Supplier<EnumStateProperty<?>> STONE_STAIRS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STONE_STAIRS_HALF");

    public static final Supplier<EnumStateProperty<?>> STONE_STAIRS_SHAPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STONE_STAIRS_SHAPE");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_ACACIA_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STRIPPED_ACACIA_LOG_AXIS");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_ACACIA_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STRIPPED_ACACIA_WOOD_AXIS");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_BIRCH_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STRIPPED_BIRCH_LOG_AXIS");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_BIRCH_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STRIPPED_BIRCH_WOOD_AXIS");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_DARK_OAK_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STRIPPED_DARK_OAK_LOG_AXIS");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_DARK_OAK_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STRIPPED_DARK_OAK_WOOD_AXIS");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_JUNGLE_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STRIPPED_JUNGLE_LOG_AXIS");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_JUNGLE_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STRIPPED_JUNGLE_WOOD_AXIS");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_OAK_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STRIPPED_OAK_LOG_AXIS");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_OAK_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STRIPPED_OAK_WOOD_AXIS");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_SPRUCE_LOG_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STRIPPED_SPRUCE_LOG_AXIS");

    public static final Supplier<EnumStateProperty<?>> STRIPPED_SPRUCE_WOOD_AXIS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STRIPPED_SPRUCE_WOOD_AXIS");

    public static final Supplier<EnumStateProperty<?>> STRUCTURE_BLOCK_MODE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "STRUCTURE_BLOCK_MODE");

    public static final Supplier<EnumStateProperty<?>> SUNFLOWER_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "SUNFLOWER_HALF");

    public static final Supplier<EnumStateProperty<?>> TALL_GRASS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "TALL_GRASS_HALF");

    public static final Supplier<EnumStateProperty<?>> TALL_SEAGRASS_HALF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "TALL_SEAGRASS_HALF");

    public static final Supplier<EnumStateProperty<?>> TRAPPED_CHEST_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "TRAPPED_CHEST_FACING");

    public static final Supplier<EnumStateProperty<?>> TRAPPED_CHEST_TYPE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "TRAPPED_CHEST_TYPE");

    public static final Supplier<EnumStateProperty<?>> TRIPWIRE_HOOK_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "TRIPWIRE_HOOK_FACING");

    public static final Supplier<EnumStateProperty<?>> TUBE_CORAL_WALL_FAN_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "TUBE_CORAL_WALL_FAN_FACING");

    public static final Supplier<EnumStateProperty<?>> WALL_TORCH_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "WALL_TORCH_FACING");

    public static final Supplier<EnumStateProperty<?>> WHITE_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "WHITE_BED_FACING");

    public static final Supplier<EnumStateProperty<?>> WHITE_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "WHITE_BED_PART");

    public static final Supplier<EnumStateProperty<?>> WHITE_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "WHITE_GLAZED_TERRACOTTA_FACING");

    public static final Supplier<EnumStateProperty<?>> WHITE_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "WHITE_SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> WHITE_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "WHITE_WALL_BANNER_FACING");

    public static final Supplier<EnumStateProperty<?>> WITHER_SKELETON_WALL_SKULL_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "WITHER_SKELETON_WALL_SKULL_FACING");

    public static final Supplier<EnumStateProperty<?>> YELLOW_BED_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "YELLOW_BED_FACING");

    public static final Supplier<EnumStateProperty<?>> YELLOW_BED_PART = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "YELLOW_BED_PART");

    public static final Supplier<EnumStateProperty<?>> YELLOW_GLAZED_TERRACOTTA_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "YELLOW_GLAZED_TERRACOTTA_FACING");

    public static final Supplier<EnumStateProperty<?>> YELLOW_SHULKER_BOX_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "YELLOW_SHULKER_BOX_FACING");

    public static final Supplier<EnumStateProperty<?>> YELLOW_WALL_BANNER_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "YELLOW_WALL_BANNER_FACING");

    public static final Supplier<EnumStateProperty<?>> ZOMBIE_WALL_HEAD_FACING = Sponge.getRegistry().getCatalogRegistry().provideSupplier(EnumStateProperty.class, "ZOMBIE_WALL_HEAD_FACING");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private EnumStateProperties() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
