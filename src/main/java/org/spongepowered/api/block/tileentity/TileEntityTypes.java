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
package org.spongepowered.api.block.tileentity;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of all {@link TileEntityType}s in vanilla Minecraft.
 */
public final class TileEntityTypes {
    private TileEntityTypes() {}

    // SORTFIELDS:ON

    public static final TileEntityType BANNER = DummyObjectProvider.createFor(TileEntityType.class, "BANNER");

    public static final TileEntityType BEACON = DummyObjectProvider.createFor(TileEntityType.class, "BEACON");

    public static final TileEntityType BREWING_STAND = DummyObjectProvider.createFor(TileEntityType.class, "BREWING_STAND");

    public static final TileEntityType CHEST = DummyObjectProvider.createFor(TileEntityType.class, "CHEST");

    public static final TileEntityType COMMAND_BLOCK = DummyObjectProvider.createFor(TileEntityType.class, "COMMAND_BLOCK");

    public static final TileEntityType COMPARATOR = DummyObjectProvider.createFor(TileEntityType.class, "COMPARATOR");

    public static final TileEntityType DAYLIGHT_DETECTOR = DummyObjectProvider.createFor(TileEntityType.class, "DAYLIGHT_DETECTOR");

    public static final TileEntityType DISPENSER = DummyObjectProvider.createFor(TileEntityType.class, "DISPENSER");

    public static final TileEntityType DROPPER = DummyObjectProvider.createFor(TileEntityType.class, "DROPPER");

    public static final TileEntityType ENCHANTMENT_TABLE = DummyObjectProvider.createFor(TileEntityType.class, "ENCHANTMENT_TABLE");

    public static final TileEntityType ENDER_CHEST = DummyObjectProvider.createFor(TileEntityType.class, "ENDER_CHEST");

    public static final TileEntityType END_GATEWAY = DummyObjectProvider.createFor(TileEntityType.class, "END_GATEWAY");

    public static final TileEntityType END_PORTAL = DummyObjectProvider.createFor(TileEntityType.class, "END_PORTAL");

    public static final TileEntityType FLOWER_POT = DummyObjectProvider.createFor(TileEntityType.class, "FLOWER_POT");

    public static final TileEntityType FURNACE = DummyObjectProvider.createFor(TileEntityType.class, "FURNACE");

    public static final TileEntityType HOPPER = DummyObjectProvider.createFor(TileEntityType.class, "HOPPER");

    public static final TileEntityType JUKEBOX = DummyObjectProvider.createFor(TileEntityType.class, "JUKEBOX");

    public static final TileEntityType MOB_SPAWNER = DummyObjectProvider.createFor(TileEntityType.class, "MOB_SPAWNER");

    public static final TileEntityType NOTE = DummyObjectProvider.createFor(TileEntityType.class, "NOTE");

    public static final TileEntityType PISTON = DummyObjectProvider.createFor(TileEntityType.class, "PISTON");

    public static final TileEntityType SHULKER_BOX = DummyObjectProvider.createFor(TileEntityType.class, "SHULKER_BOX");

    public static final TileEntityType SIGN = DummyObjectProvider.createFor(TileEntityType.class, "SIGN");

    public static final TileEntityType SKULL = DummyObjectProvider.createFor(TileEntityType.class, "SKULL");

    public static final TileEntityType STRUCTURE = DummyObjectProvider.createFor(TileEntityType.class, "STRUCTURE");

    // SORTFIELDS:OFF

}
