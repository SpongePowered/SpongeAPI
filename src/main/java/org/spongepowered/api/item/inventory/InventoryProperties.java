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
package org.spongepowered.api.item.inventory;

import org.spongepowered.api.data.property.Property;
import org.spongepowered.api.data.property.PropertyHolder;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;
import org.spongepowered.math.vector.Vector2i;

import java.util.UUID;

/**
 * Properties specific to {@link Inventory} objects that are not
 * supported on other types of {@link PropertyHolder}s.
 */
@SuppressWarnings("unchecked")
public final class InventoryProperties {

    // SORTFIELDS:ON

    /**
     * Represents the plugin that created this inventory.
     */
    public static final Property<PluginContainer> PLUGIN = DummyObjectProvider.createFor(Property.class, "PLUGIN");

    /**
     * Represents the maximum stack size of slots in an inventory.
     */
    public static final Property<Integer> MAX_STACK_SIZE = DummyObjectProvider.createFor(Property.class, "MAX_STACK_SIZE");

    /**
     * Represents the {@link EquipmentType} that the target inventory supports.
     */
    public static final Property<EquipmentType> EQUIPMENT_TYPE = DummyObjectProvider.createFor(Property.class, "EQUIPMENT_TYPE");

    /**
     * Represents the index of a slot.
     */
    public static final Property<Integer> SLOT_INDEX = DummyObjectProvider.createFor(Property.class, "SLOT_INDEX");

    /**
     * A property which represents the position of a slot within a grid. Bear in mind
     * that this property should be retrieved from the relevant parent, since a
     * slot may have multiple parent inventories.
     */
    public static final Property<Vector2i> SLOT_POSITION = DummyObjectProvider.createFor(Property.class, "SLOT_POSITION");

    /**
     * A property which represents a "side" for a particular slot, for use in querying "sided inventories".
     */
    public static final Property<Direction> SLOT_SIDE = DummyObjectProvider.createFor(Property.class, "SLOT_SIDE");

    /**
     * Represents the {@link UUID} of a inventory.
     */
    public static final Property<UUID> UNIQUE_ID = DummyObjectProvider.createFor(Property.class, "UNIQUE_ID");

    /**
     * Represents the title of a inventory, is viewable by players looking at the inventory. Not all inventories have a title.
     */
    public static final Property<Text> TITLE = DummyObjectProvider.createFor(Property.class, "TITLE");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private InventoryProperties() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
