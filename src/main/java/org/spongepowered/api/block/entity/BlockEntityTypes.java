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
package org.spongepowered.api.block.entity;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * An enumeration of all {@link BlockEntityType}s in vanilla Minecraft.
 */
public final class BlockEntityTypes {

    // SORTFIELDS:ON

    public static final Supplier<BlockEntityType> BANNER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "banner");

    public static final Supplier<BlockEntityType> BARREL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "barrel");

    public static final Supplier<BlockEntityType> BEACON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "beacon");

    public static final Supplier<BlockEntityType> BED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "bed");

    public static final Supplier<BlockEntityType> BEEHIVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "beehive");

    public static final Supplier<BlockEntityType> BELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "bell");

    public static final Supplier<BlockEntityType> BLAST_FURNACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "blast_furnace");

    public static final Supplier<BlockEntityType> BREWING_STAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "brewing_stand");

    public static final Supplier<BlockEntityType> CAMPFIRE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "campfire");

    public static final Supplier<BlockEntityType> CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "chest");

    public static final Supplier<BlockEntityType> COMMAND_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "command_block");

    public static final Supplier<BlockEntityType> COMPARATOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "comparator");

    public static final Supplier<BlockEntityType> CONDUIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "conduit");

    public static final Supplier<BlockEntityType> DAYLIGHT_DETECTOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "daylight_detector");

    public static final Supplier<BlockEntityType> DISPENSER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "dispenser");

    public static final Supplier<BlockEntityType> DROPPER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "dropper");

    public static final Supplier<BlockEntityType> ENCHANTMENT_TABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "enchantment_table");

    public static final Supplier<BlockEntityType> ENDER_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "ender_chest");

    public static final Supplier<BlockEntityType> END_GATEWAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "end_gateway");

    public static final Supplier<BlockEntityType> END_PORTAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "end_portal");

    public static final Supplier<BlockEntityType> FURNACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "furnace");

    public static final Supplier<BlockEntityType> HOPPER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "hopper");

    public static final Supplier<BlockEntityType> JIGSAW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "jigsaw");

    public static final Supplier<BlockEntityType> JUKEBOX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "jukebox");

    public static final Supplier<BlockEntityType> LECTERN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "lectern");

    public static final Supplier<BlockEntityType> MOB_SPAWNER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "mob_spawner");

    public static final Supplier<BlockEntityType> PISTON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "piston");

    public static final Supplier<BlockEntityType> SHULKER_BOX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "shulker_box");

    public static final Supplier<BlockEntityType> SIGN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "sign");

    public static final Supplier<BlockEntityType> SKULL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "skull");

    public static final Supplier<BlockEntityType> SMOKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "smoker");

    public static final Supplier<BlockEntityType> STRUCTURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "structure");

    public static final Supplier<BlockEntityType> TRAPPED_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "trapped_chest");

    // SORTFIELDS:OFF

    private BlockEntityTypes() {}
}
