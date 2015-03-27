/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.block;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataManipulator;

/**
 * Represents a block using {@link BlockType} and a list of
 * {@link DataManipulator} instances.
 *
 * <p>States are considered immutable {@link DataHolder}s as the
 * contained {@link DataManipulator}s can not be changed.</p>
 */
public interface BlockState {

    /**
     * Get the base type of block.
     *
     * <p>The type does not include block data such as the contents of
     * inventories.</p>
     *
     * @return The type of block
     */
    BlockType getType();

    /**
     * Get all properties defined on this BlockState, with their current values.
     *
     * @return Map of all current properties
     */
    ImmutableCollection<DataManipulator<?>> getManipulators();

    /**
     * Gets all property names defined on this BlockState.
     *
     * @return Collection of property names
     */
    ImmutableCollection<String> getManipulatorIds();

    /**
     * Get a property from its name.
     *
     * @param name The name of the property
     * @return The property with the given name or Optional.absent() if not found
     */
    Optional<DataManipulator<?>> getManipulatorByName(String name);

    /**
     * Get the current value of a given property.
     *
     * @param name Property to get value of
     * @return Current value of the property or Optional.absent() if not found
     */
    Optional<? extends Comparable<?>> getManipulatorValue(String name);

    /**
     * Get an altered BlockState with the given property set to the given value.
     *
     * <p>This does not alter the current BlockState instance</p>
     *
     * @param property Property to change value of
     * @return A BlockState with the property's value modified
     */
    BlockState withData(DataManipulator<?> property);

    /**
     * Get an altered BlockState with the given property set to the next valid
     * value for that property, cycling to the lowest value after the highest
     * value.
     *
     * <p>This does not alter the current BlockState instance</p>
     *
     * @param property Property to change value of
     * @return A BlockState with the property's value modified
     */
    BlockState cycleProperty(DataManipulator<?> property);

}
