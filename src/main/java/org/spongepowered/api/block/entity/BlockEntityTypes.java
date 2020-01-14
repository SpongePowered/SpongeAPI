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

    public static final Supplier<BlockEntityType> BANNER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "BANNER");

    public static final Supplier<BlockEntityType> BARREL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "BARREL");

    public static final Supplier<BlockEntityType> BEACON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "BEACON");

    public static final Supplier<BlockEntityType> BED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "BED");

    public static final Supplier<BlockEntityType> BELL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "BELL");

    public static final Supplier<BlockEntityType> BLAST_FURNACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "BLAST_FURNACE");

    public static final Supplier<BlockEntityType> BREWING_STAND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "BREWING_STAND");

    public static final Supplier<BlockEntityType> CAMPFIRE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "CAMPFIRE");

    public static final Supplier<BlockEntityType> CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "CHEST");

    public static final Supplier<BlockEntityType> COMMAND_BLOCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "COMMAND_BLOCK");

    public static final Supplier<BlockEntityType> COMPARATOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "COMPARATOR");

    public static final Supplier<BlockEntityType> CONDUIT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "CONDUIT");

    public static final Supplier<BlockEntityType> DAYLIGHT_DETECTOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "DAYLIGHT_DETECTOR");

    public static final Supplier<BlockEntityType> DISPENSER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "DISPENSER");

    public static final Supplier<BlockEntityType> DROPPER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "DROPPER");

    public static final Supplier<BlockEntityType> ENCHANTMENT_TABLE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "ENCHANTMENT_TABLE");

    public static final Supplier<BlockEntityType> ENDER_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "ENDER_CHEST");

    public static final Supplier<BlockEntityType> END_GATEWAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "END_GATEWAY");

    public static final Supplier<BlockEntityType> END_PORTAL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "END_PORTAL");

    public static final Supplier<BlockEntityType> FURNACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "FURNACE");

    public static final Supplier<BlockEntityType> HOPPER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "HOPPER");

    public static final Supplier<BlockEntityType> JIGSAW = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "JIGSAW");

    public static final Supplier<BlockEntityType> JUKEBOX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "JUKEBOX");

    public static final Supplier<BlockEntityType> LECTERN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "LECTERN");

    public static final Supplier<BlockEntityType> MOB_SPAWNER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "MOB_SPAWNER");

    public static final Supplier<BlockEntityType> PISTON = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "PISTON");

    public static final Supplier<BlockEntityType> SHULKER_BOX = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "SHULKER_BOX");

    public static final Supplier<BlockEntityType> SIGN = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "SIGN");

    public static final Supplier<BlockEntityType> SKULL = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "SKULL");

    public static final Supplier<BlockEntityType> SMOKER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "SMOKER");

    public static final Supplier<BlockEntityType> STRUCTURE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "STRUCTURE");

    public static final Supplier<BlockEntityType> TRAPPED_CHEST = Sponge.getRegistry().getCatalogRegistry().provideSupplier(BlockEntityType.class, "TRAPPED_CHEST");

    // SORTFIELDS:OFF

    private BlockEntityTypes() {}
}
