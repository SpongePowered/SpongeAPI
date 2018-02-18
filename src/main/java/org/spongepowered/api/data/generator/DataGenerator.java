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
package org.spongepowered.api.data.generator;

import org.spongepowered.api.data.DataRegistration;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * A generator that allows a {@link DataRegistration} to be constructed with
 * generated {@link DataManipulator} and {@link ImmutableDataManipulator} classes.
 *
 * @param <M> The mutable data manipulator type
 * @param <I> The immutable data manipulator type
 * @param <G> The generic type that will be used when chaining
 *            methods, should always return the same signature.
 * @param <R> The generic type used when resetting the builder through {@link #reset()}.
 */
public interface DataGenerator<
        M extends DataManipulator<M, I>,
        I extends ImmutableDataManipulator<I, M>,
        G extends DataGenerator<M, I, G, R>,
        R extends DataGenerator<?, ?, ?, R>>
        extends ResettableBuilder<DataRegistration<?,?>, R> {

    /**
     * The nature of the builder doesn't allow values of data registration to be
     * reused. It is also unlikely that {@link Key}s names and manipulator types
     * will be reused in multiple {@link DataRegistration}s. Use {@link #reset()}
     * and resupply the builder instead.
     *
     * @param value The built object
     * @return This builder, for chaining
     * @deprecated It is not supported to construct the same {@link DataRegistration},
     *             use {@link #reset()} instead and start from scratch.
     */
    @Deprecated
    @Override
    R from(DataRegistration<?,?> value) throws UnsupportedOperationException;

    /**
     * Sets a more generalized name to refer to the registered
     * {@link DataManipulator} as a common name.
     *
     * <p>As an example: if I have a DummyTestData, a name could be "Dummy".</p>
     *
     * @param name The data name
     * @return This builder, for chaining
     */
    G name(String name);

    /**
     * Sets the content version of the constructed
     * {@link DataManipulator}s. Defaults to {@code 1}.
     *
     * @param contentVersion The content version
     * @return This builder, for chaining
     */
    G version(int contentVersion);

    /**
     * Sets the identifier of the {@link DataRegistration}
     * (without the namespace).
     *
     * @param id The identifier
     * @return This builder, for chaining
     */
    G id(String id);

    /**
     * Builds the {@link DataRegistration} with the specified manipulator
     * id and the {@link PluginContainer} in the current context.
     *
     * @return The constructed data registration
     */
    DataRegistration<M, I> build();
}
