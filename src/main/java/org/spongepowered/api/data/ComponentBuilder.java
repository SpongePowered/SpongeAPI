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
import org.spongepowered.api.service.persistence.DataBuilder;

/**
 * A builder of {@link Component}s. This builder can build
 * a specific {@link Component} that can be used to pre-construct
 * customized data prior to applying to a {@link DataHolder}.
 *
 * <p>{@link ComponentBuilder}s must be registered with the
 * {@link ComponentRegistry} before they can be used by the game
 * and plugins. Failure to do so may prevent the {@link Component} from
 * being used.</p>
 *
 * @param <T> The type of {@link Component}
 */
public interface ComponentBuilder<T extends Component<T>> extends DataBuilder<T> {

    /**
     * Creates a new specific {@link Component} for consumption. There
     * should be no reason for a {@link Component} to exist without
     * a reference to a {@link DataHolder} as {@link Component}s are
     * virtual "snapshots" of "data".
     *
     * @return The newly created data component
     */
    T create();

    /**
     * Attempts to read data from the given {@link DataHolder} and constructs
     * a new copy of the {@link Component} as an instance of
     * <code>T</code>.
     *
     * <p>If the {@link DataHolder} does not contain the necessary information
     * to pre-populate the {@link Component}, a fresh new
     * {@link Component} is returned. If the {@link Component} is
     * incompatible with the {@link DataHolder}, {@link Optional#absent()} is
     * returned.</p>
     *
     * @param dataHolder The {@link DataHolder} to extract data
     * @return A new instance of this {@link Component} with relevant data
     *     filled from the given {@link DataHolder}, if available
     */
    Optional<T> createFrom(DataHolder dataHolder);

}
