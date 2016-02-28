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

import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataManager;
import org.spongepowered.api.data.persistence.DataBuilder;

import java.util.Optional;

/**
 * A builder of {@link DataManipulator}s. This builder can build
 * a specific {@link DataManipulator} that can be used to pre-construct
 * customized data prior to applying to a {@link DataHolder}.
 *
 * <p>{@link DataManipulatorBuilder}s must be registered with the
 * {@link DataManager} before they can be used by the game
 * and plugins. Failure to do so may prevent the {@link DataManipulator} from
 * being used.</p>
 *
 * @param <T> The type of {@link DataManipulator}
 */
public interface DataManipulatorBuilder<T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>> extends DataBuilder<T> {

    /**
     * Creates a new specific {@link DataManipulator} for consumption.
     *
     * @return The newly created data manipulator
     */
    T create();

    /**
     * Attempts to read data from the given {@link DataHolder} and constructs
     * a new copy of the {@link DataManipulator} as an instance of
     * <code>T</code>.
     *
     * <p>If the {@link DataHolder} does not contain the necessary information
     * to pre-populate the {@link DataManipulator}, a fresh new
     * {@link DataManipulator} is returned. If the {@link DataManipulator} is
     * incompatible with the {@link DataHolder}, {@link Optional#empty()} is
     * returned.</p>
     *
     * @param dataHolder The {@link DataHolder} to extract data
     * @return A new instance of this {@link DataManipulator} with relevant data
     *     filled from the given {@link DataHolder}, if available
     */
    Optional<T> createFrom(DataHolder dataHolder);

}
