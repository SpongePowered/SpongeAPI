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
package org.spongepowered.api.data;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;

/**
 * Represents an immutable variant of the {@link DataHolder} where once built,
 * the {@link ImmutableDataHolder} can not be modified.
 *
 * @see DataHolder
 * @param <T> The sub type of immutable data holder
 */
public interface ImmutableDataHolder<T extends ImmutableDataHolder<T>> extends DataSerializable {

    /**
     * Get a copy of all properties defined on this
     * {@link ImmutableDataHolder}, with their current values.
     *
     * @return A collection of all known manipulators
     */
    ImmutableCollection<DataManipulator<?>> getManipulators();

    /**
     * Gets an instance of the given data class for this
     * {@link ImmutableDataHolder}.
     *
     * <p>If there is no pre-existing data that can be represented by the given
     * {@link DataManipulator} class, {@link Optional#absent()} is returned.
     * </p>
     *
     * @param manipulatorClass The data class
     * @param <M> The type of data
     * @return An instance of the class, if not available
     */
    <M extends DataManipulator<M>> Optional<M> getManipulator(Class<M> manipulatorClass);

    /**
     * Gets an altered copy of this {@link ImmutableDataHolder} with the given
     * {@link DataManipulator} modified data. If the data is not compatible for
     * any reason, {@link Optional#absent()} is returned.
     *
     * <p>This does not alter the current {@link ImmutableDataHolder}.</p>
     *
     * @param manipulator The new manipulator containing data
     * @param <M> The type of data manipulator
     * @return A new immutable data holder with the given manipulator
     */
    <M extends DataManipulator<M>> Optional<T> withData(M manipulator);

    /**
     * Gets an altered copy of this {@link ImmutableDataHolder} without the
     * given {@link DataManipulator}. If the data represented by the
     * manipulator can not exist without a "default state" of the
     * {@link DataManipulator}, the {@link DataManipulator} is reset to the
     * "default" state.
     *
     * @param manipulator The manipulator class to remove
     * @param <M> The manipulator type
     * @return A new immutable data holder without the given manipulator
     */
    <M extends DataManipulator<M>> Optional<T> withoutData(Class<M> manipulator);

}
