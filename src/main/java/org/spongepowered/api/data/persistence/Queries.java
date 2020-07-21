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
package org.spongepowered.api.data.persistence;

import static org.spongepowered.api.data.persistence.DataQuery.of;

public final class Queries {

    // Content version
    public static final DataQuery CONTENT_VERSION = of("ContentVersion");

    // Transaction
    public static final DataQuery TYPE_CLASS = of("TypeClass");
    public static final DataQuery ORIGINAL = of("Original");
    public static final DataQuery DEFAULT_REPLACEMENT = of("DefaultReplacement");
    public static final DataQuery CUSTOM_REPLACEMENT = of("CustomReplacement");
    public static final DataQuery VALID = of("IsValid");

    // WeightedSerializableObject
    public static final DataQuery WEIGHTED_SERIALIZABLE = of("DataSerializable");
    public static final DataQuery WEIGHTED_SERIALIZABLE_WEIGHT = of("Weight");

    // Item Enchantment
    public static final DataQuery ENCHANTMENT_ID = of("Enchantment");
    public static final DataQuery LEVEL = of("Level");

    // WeightedItem
    public static final DataQuery WEIGHTED_ITEM_QUANTITY = of("Quantity");

    // Location
    public static final DataQuery WORLD_KEY = of("WorldKey");
    public static final DataQuery POSITION_X = of("X");
    public static final DataQuery POSITION_Y = of("Y");
    public static final DataQuery POSITION_Z = of("Z");

    // Variable
    public static final DataQuery VARIABLE_CHANCE = of("Chance");
    public static final DataQuery VARIABLE_BASE = of("Base");
    public static final DataQuery VARIABLE_VARIANCE = of("Variance");
    public static final DataQuery VARIABLE_AMOUNT = of("Amount");

    // Color
    public static final DataQuery COLOR_RED = of("Red");
    public static final DataQuery COLOR_BLUE = of("Blue");
    public static final DataQuery COLOR_GREEN = of("Green");

    // Tracking
    public static final DataQuery CREATOR_ID = of("Creator");
    public static final DataQuery NOTIFIER_ID = of("Notifier");

    // Text
    public static final DataQuery JSON = of("JSON");
    public static final DataQuery TEXT_TITLE = of("TextTitle");
    public static final DataQuery TEXT_AUTHOR = of("TextAuthor");
    public static final DataQuery TEXT_PAGE_LIST = of("TextPageList");

    // RespawnLocation
    public static final DataQuery FORCED_SPAWN = of("ForcedSpawn");

    // UUID
    public static final DataQuery UUID_LEAST = of("UuidLeast");
    public static final DataQuery UUID_MOST = of("UuidMost");
    public static final DataQuery POSITION = of("Pos");

    // Suppress default constructor to ensure non-instantiability.
    private Queries() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
