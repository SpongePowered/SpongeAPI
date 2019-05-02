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

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.CatalogBuilder;

import java.util.function.Function;

public interface DataRegistration extends CatalogType {

    /**
     * Creates a new {@link Builder} to build a {@link DataRegistration}.
     * Through the use of generics, this can be duck-typed to the generics of
     * the desired {@link DataManipulator} type to be registered.
     *
     * @return The new builder instance
     */
    @SuppressWarnings("unchecked")
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    Function<Iterable<Value.Immutable<?>>, DataView> getSerializer();

    Function<DataView, Iterable<Value.Mutable<?>>> getDeserializer();

    Iterable<Key<?>> getKeys();

    /**
     * Gets the owning {@link PluginContainer}.
     *
     * @return The owning plugin container for this registration
     */
    PluginContainer getPluginContainer();

    interface Builder extends CatalogBuilder<DataRegistration, Builder> {

        Builder serializer(Function<Iterable<Value.Immutable<?>>, DataView> serializer);
        Builder deserializer(Function<DataView, Iterable<Value.Mutable<?>>> serializer);

        Builder key(Key<?> key);

        Builder key(Key<?> key, Key<?>... others);

        Builder key(Iterable<Key<?>> keys);

        @Override
        Builder reset();

        /**
         * {@inheritDoc}
         *
         * @return The data registration object
         * @throws IllegalStateException If registrations can no longer take place
         * @throws IllegalStateException If there are no {@link Key}s registered in this registration
         * @throws DataAlreadyRegisteredException If a key has already been claimed by another registration
         */
        @Override
        DataRegistration build();
    }
}
