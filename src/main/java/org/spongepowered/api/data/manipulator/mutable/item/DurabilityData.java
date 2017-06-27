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
package org.spongepowered.api.data.manipulator.mutable.item;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.item.ImmutableDurabilityData;
import org.spongepowered.api.data.property.item.UseLimitProperty;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * An {@link DataManipulator} handling the "durability" of an {@link ItemStack}
 * that will "break" after a certain amount of "uses".
 *
 * <p>Usually, items with durability will break and disappear when their
 * durability reaches the maximum. Examples of this include pickaxes,
 * axes, swords, and shovels. It is recommended to retrieve the maximum
 * durability limit from the {@link UseLimitProperty}.</p>
 */
public interface DurabilityData extends DataManipulator<DurabilityData, ImmutableDurabilityData> {

    /**
     * Gets the {@link MutableBoundedValue} for the "durability" remaining.
     * The durability is a number signifying how many "uses' remain on the
     * item. When the durability reaches 0, usually, the item breaks.
     *
     * @return The immutable bounded value of durability remaining
     * @see Keys#ITEM_DURABILITY
     */
    MutableBoundedValue<Integer> durability();

    /**
     * Gets the {@link Value} for the "unbreakable" state of the
     * {@link ItemStack}. While the {@link ItemStack} is "unbreakable",
     * the durability can not change.
     *
     * @return The immutable value for the "unbreakable" state
     * @see Keys#UNBREAKABLE
     */
    Value<Boolean> unbreakable();

}
