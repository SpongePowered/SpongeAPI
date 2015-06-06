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
import org.spongepowered.api.GameState;

/**
 * A registry of {@link Component}s and their respective
 * {@link ComponentBuilder}s. Registration should occur prior to
 * {@link GameState#SERVER_ABOUT_TO_START}.
 */
public interface ComponentRegistry {

    /**
     * Registers the given {@link Component} class with it's associated
     * {@link ComponentBuilder}. The builder can be used to create new
     * instances of the given {@link Component} for data retrieval,
     * data representation, and mass application of a {@link Component}
     * to multiple {@link DataHolder}s.
     *
     * @param componentClass The class of the data component
     * @param builder The builder instance of the data component
     * @param <T> The type of data component
     */
    <T extends Component<T>> void register(Class<T> componentClass, ComponentBuilder<T> builder);

    /**
     * Attempts to retrieve the builder for the given {@link Component}.
     *
     * <p>If the {@link Component} was not registered, multiple systems
     * could fail to retrieve specific data.</p>
     *
     * @param componentClass The component class
     * @param <T> The type of component
     * @return The builder, if available
     */
    <T extends Component<T>> Optional<ComponentBuilder<T>> getBuilder(Class<T> componentClass);

}
