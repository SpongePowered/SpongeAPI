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

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all {@link BlockEntityType}s in vanilla Minecraft.
 */
public final class BlockEntityTypes {
    private BlockEntityTypes() {}

    // SORTFIELDS:ON

    public static final BlockEntityType BANNER = DummyObjectProvider.createFor(BlockEntityType.class, "BANNER");

    public static final BlockEntityType BEACON = DummyObjectProvider.createFor(BlockEntityType.class, "BEACON");

    public static final BlockEntityType BREWING_STAND = DummyObjectProvider.createFor(BlockEntityType.class, "BREWING_STAND");

    public static final BlockEntityType CHEST = DummyObjectProvider.createFor(BlockEntityType.class, "CHEST");

    public static final BlockEntityType COMMAND_BLOCK = DummyObjectProvider.createFor(BlockEntityType.class, "COMMAND_BLOCK");

    public static final BlockEntityType COMPARATOR = DummyObjectProvider.createFor(BlockEntityType.class, "COMPARATOR");

    public static final BlockEntityType DAYLIGHT_DETECTOR = DummyObjectProvider.createFor(BlockEntityType.class, "DAYLIGHT_DETECTOR");

    public static final BlockEntityType DISPENSER = DummyObjectProvider.createFor(BlockEntityType.class, "DISPENSER");

    public static final BlockEntityType DROPPER = DummyObjectProvider.createFor(BlockEntityType.class, "DROPPER");

    public static final BlockEntityType ENCHANTMENT_TABLE = DummyObjectProvider.createFor(BlockEntityType.class, "ENCHANTMENT_TABLE");

    public static final BlockEntityType ENDER_CHEST = DummyObjectProvider.createFor(BlockEntityType.class, "ENDER_CHEST");

    public static final BlockEntityType END_GATEWAY = DummyObjectProvider.createFor(BlockEntityType.class, "END_GATEWAY");

    public static final BlockEntityType END_PORTAL = DummyObjectProvider.createFor(BlockEntityType.class, "END_PORTAL");

    public static final BlockEntityType FURNACE = DummyObjectProvider.createFor(BlockEntityType.class, "FURNACE");

    public static final BlockEntityType HOPPER = DummyObjectProvider.createFor(BlockEntityType.class, "HOPPER");

    public static final BlockEntityType JUKEBOX = DummyObjectProvider.createFor(BlockEntityType.class, "JUKEBOX");

    public static final BlockEntityType MOB_SPAWNER = DummyObjectProvider.createFor(BlockEntityType.class, "MOB_SPAWNER");

    public static final BlockEntityType PISTON = DummyObjectProvider.createFor(BlockEntityType.class, "PISTON");

    public static final BlockEntityType PLAYER_HEAD = DummyObjectProvider.createFor(BlockEntityType.class, "PLAYER_HEAD");

    public static final BlockEntityType SHULKER_BOX = DummyObjectProvider.createFor(BlockEntityType.class, "SHULKER_BOX");

    public static final BlockEntityType SIGN = DummyObjectProvider.createFor(BlockEntityType.class, "SIGN");

    public static final BlockEntityType STRUCTURE = DummyObjectProvider.createFor(BlockEntityType.class, "STRUCTURE");

    public static final BlockEntityType TRAPPED_CHEST = DummyObjectProvider.createFor(BlockEntityType.class, "TRAPPED_CHEST");

    // SORTFIELDS:OFF

}
