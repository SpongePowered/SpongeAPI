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
package org.spongepowered.api.data.manipulator;

import org.spongepowered.api.GameState;
import org.spongepowered.api.data.DataHolder;

import java.util.Optional;

/**
 * A registry of {@link DataManipulator}s and their respective
 * {@link DataManipulatorBuilder}s. Registration should occur prior to
 * {@link GameState#SERVER_ABOUT_TO_START}.
 */
public interface DataManipulatorRegistry {

    /**
     * Registers the given {@link DataManipulator} class with it's associated
     * {@link DataManipulatorBuilder}. The builder can be used to create new
     * instances of the given {@link DataManipulator} for data retrieval,
     * data representation, and mass application of a {@link DataManipulator}
     * to multiple {@link DataHolder}s.
     *
     * @param manipulatorClass The class of the data manipulator
     * @param immutableManipulatorClass The class of the immutable datamanipulator
     * @param builder The builder instance of the data manipulator
     * @param <T> The type of data manipulator
     * @param <I> The type of immutable datamanipulator
     */
    <T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>> void register(Class<? extends T> manipulatorClass,
                                                                                              Class<? extends I> immutableManipulatorClass,
                                                                                              DataManipulatorBuilder<T, I> builder);

    /**
     * Attempts to retrieve the builder for the given {@link DataManipulator}.
     *
     * <p>If the {@link DataManipulator} was not registered, multiple systems
     * could fail to retrieve specific data.</p>
     *
     * @param manipulatorClass The manipulator class
     * @param <T> The type of manipulator
     * @param <I> The type of immutable manipulator
     * @return The builder, if available
     */
    <T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>>
    Optional<DataManipulatorBuilder<T, I>> getBuilder(Class<T> manipulatorClass);

    /**
     * Attempts to retrieve the builder for the given
     * {@link ImmutableDataManipulator}.
     *
     * <p>If the {@link ImmutableDataManipulator} was not registered, multiple
     * systems could fail to retrieve specific data.</p>
     *
     * @param immutableManipulatorClass The immutable manipulator class
     * @param <T> The type of DataManipulator
     * @param <I> The type of ImmutableDataManipulator
     * @return The DataManipulatorBuilder, if available
     */
    <T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>>
    Optional<DataManipulatorBuilder<T, I>> getBuilderForImmutable(Class<I> immutableManipulatorClass);

}
