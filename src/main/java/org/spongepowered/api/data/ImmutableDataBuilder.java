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

import org.spongepowered.api.service.persistence.DataBuilder;

/**
 * A builder, much like a normal {@link DataBuilder} except that it builds
 * {@link ImmutableDataHolder}s. While the {@link ImmutableDataHolder} is like
 * a {@link DataHolder}, it is immutable.
 *
 * @param <H> The type of {@link ImmutableDataHolder}
 * @param <E> The extended {@link ImmutableDataBuilder}
 */
public interface ImmutableDataBuilder<H extends ImmutableDataHolder<H>, E extends ImmutableDataBuilder<H, E>> extends DataBuilder<H> {

    /**
     * Adds the given {@link Component} to the builder. The
     * {@link Component} is copied when the {@link ImmutableDataHolder}
     * is created.
     *
     * @param component The component to add
     * @param <M> The maipulator type
     * @return This builder, for chaining
     */
    <M extends Component<M>> E add(M component);

    /**
     * Copies all known {@link Component}s from the given
     * {@link ImmutableDataHolder}. This is a defensive copy as
     * {@link Component} is mutable.
     *
     * @param holder The {@link ImmutableDataHolder} to copy from
     * @return This builder for chaining
     */
    E from(H holder);

    /**
     * Resets this builder to a "default" state such that there is no
     * remaining {@link Component}s to set. This is to be the presumed
     * "default" state.
     *
     * @return This builder, for chaining
     */
    E reset();

    /**
     * Attempts to build a new {@link ImmutableDataHolder}.
     *
     * @return The new immutable data holder
     */
    H build();

}
