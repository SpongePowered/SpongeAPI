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

import io.leangen.geantyref.TypeToken;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataQuery;
import org.spongepowered.api.data.persistence.DataStore;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.plugin.PluginContainer;

import java.util.Collection;
import java.util.Optional;

/**
 * An optional registration of {@link Key keys} to associate a semi-persistent
 * state of their associated {@link Value values} that can be stored, retrieved,
 * persisted, and/or associated with {@link DataHolder DataHolders}. A
 * registration identifies the given {@link #getKeys() Keys} are provided by an
 * implementation for specific {@link DataHolder DataHolders} that may support
 * and not support those {@link Key keys}. All API provided {@link Key keys}
 * exposed through the {@link Keys} class will have an associated registration
 * by the implementation of the API, whether they are usable through
 * {@link DataProvider DataProviders} or {@link DataStore DataStores}.
 *
 * <p>If dynamic or persistent retention of the {@link Value Values} by
 * {@link Key keys} is not desired, a registration is optional. This would mean
 * that any submitted {@link Value}s of a {@link Key} without an associated
 * {@link DataRegistration} will be only stored on a
 * {@link org.spongepowered.api.data.DataHolder.Mutable mutable DataHolder} for
 * the duration that that holder exists. The value would not persist between
 * reloads, restarts, etc.</p>
 */
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
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the {@link DataProvider} for the given {@link Key} to potentially
     * get or offer {@link Value}s from any {@link ValueContainer} provided
     * that the container is supported by the {@code DataProvider}. If the
     * {@code key} is not actually registered with this {@link DataRegistration},
     * an {@link UnregisteredKeyException} is thrown. If there is no
     * {@code DataProvider} registered for the particular {@code Key},
     * {@link Optional#empty()} is returned.
     *
     * @param <V> The value type
     * @param <E> The element type
     * @param key The requested key
     * @return The provider, if there is one for the key
     * @throws UnregisteredKeyException If the key is not registered in this
     *     registration
     */
    <V extends Value<E>, E> Collection<DataProvider<V, E>> getProvidersFor(Key<V> key) throws UnregisteredKeyException;

    /**
     * Gets the appropriate {@link DataStore} for the context of the
     * {@link TypeToken} that is being serialized/deserialized. It is always
     * possible that there may be a {@link DataStore} that does not support
     * the provided {@link TypeToken}, while a {@link DataProvider} may be
     * provided for a particular {@link Key}.
     *
     * @param token The type token of the desired ValueContainer
     * @return The relevant DataStore for the desired type token of the target
     *     type.
     */
    Optional<DataStore> getDataStore(TypeToken<? extends DataHolder> token);

    /**
     * Gets the appropriate {@link DataStore} for the context of the
     * {@link TypeToken} that is being serialized/deserialized. It is always
     * possible that there may be a {@link DataStore} that does not support
     * the provided {@link Class}, while a {@link DataProvider} may be
     * provided for a particular {@link Key}.
     *
     * @param token The class of the desired ValueContainer. Cannot be a raw type
     * @return The relevant DataStore for the desired type token of the target
     *     type.
     */
    Optional<DataStore> getDataStore(Class<? extends DataHolder> token);

    /**
     * Gets the registered {@link Key Keys} this controls. Note that each
     * {@link Key} can only be registered/owned by a single
     * {@link PluginContainer}. It is possible for there to be only a single
     * key registered, or multiple, depending on the basis of what potentially
     * grouped values are controlled by a single {@link DataStore} or multiple
     * {@link DataProvider}s, based on the supported {@link DataHolder}s.
     *
     * @return The keys registered
     */
    Iterable<Key<?>> getKeys();

    /**
     * Gets the owning {@link PluginContainer}.
     *
     * @return The owning plugin container for this registration
     */
    PluginContainer getPluginContainer();

    /**
     * Creates a DataRegistration for a single key with a DataStore for given data-holders.
     *
     *
     * @param key the data key
     * @param dataHolders the data-holders
     * @param <T> the keys value type
     *
     * @return The built data registration
     */
    @SafeVarargs
    static <T> DataRegistration of(Key<Value<T>> key, Class<? extends DataHolder> dataHolder, Class<? extends DataHolder>... dataHolders) {
        final DataStore dataStore = DataStore.of(key, DataQuery.of(key.getKey().getNamespace(), key.getKey().getValue()), dataHolder, dataHolders);
        return DataRegistration.builder().dataKey(key).store(dataStore).key(key.getKey()).build();
    }

    /**
     * A standard builder for constructing new {@link DataRegistration}s. It's
     * always advised to create a new builder with
     * {@link DataRegistration#builder()} and calling {@link #reset()} when
     * re-using said builder.
     */
    interface Builder extends CatalogBuilder<DataRegistration, Builder> {

        /**
         * Gives the builder a {@link DataStore} that will enable supporting
         * serializing and de-serializing {@link Value}s given a context of a
         * specific {@link DataHolder} by {@link TypeToken}. It is recommended
         * that if the {@link Key}s are meant to be all grouped/controlled
         * together, a single {@link DataStore} is to serialize/de-serialize any
         * and all {@link Value Values} for those {@link Key Keys}.
         *
         * @param store The data store providing the serialization process
         * @return This builder, for chaining
         * @throws DuplicateDataStoreException If the DataStore is already
         *     registered for the type token it uses
         */
        Builder store(DataStore store) throws DuplicateDataStoreException;

        /**
         * Gives the builder a {@link DataProvider} of which is registered for a
         * particular {@link Key}. If a {@link DataProvider} already exists for
         * the {@link Key}, a {@link DuplicateProviderException} can be thrown.
         *
         * <p>Note that by supplying a {@link DataProvider}, the {@link Value
         * Values} with the provider's {@link Key} will <strong>NOT</strong> be
         * passed to any potentially registered {@link DataStore DataStores} for
         * serialization. A {@link Key} that has a {@link DataProvider} will
         * always pass through that {@link DataProvider}, and never a
         * {@link DataStore}.</p>
         *
         * @param provider The provider
         * @return This builder, for chaining
         * @throws DuplicateProviderException If there is already a DataProvider
         *     for the key
         */
        Builder provider(DataProvider<?, ?> provider) throws DuplicateProviderException;

        /**
         * Gives the {@link Key} to this builder signifying the key is to be
         * registered either with an applicable {@link DataProvider} or an
         * associated {@link DataStore} that will provide serialization/deserialization
         * behaviors. A {@link Key} alone in the registration will allow for the
         * understanding that the {@link Key Key's} {@link Value} will be
         * constructed/provided for for various {@link DataHolder}s either
         * through a {@link DataProvider} dynamically, or by a serialization
         * strategy by {@link DataStore a contextualized DataStore}.
         *
         * @param key The key to register
         * @return This builder, for chaining
         */
        Builder dataKey(Key<?> key);

        /**
         * Gives the {@link Key} to this builder signifying the key is to be
         * registered either with an applicable {@link DataProvider} or an
         * associated {@link DataStore} that will provide serialization/deserialization
         * behaviors. A {@link Key} alone in the registration will allow for the
         * understanding that the {@link Key Key's} {@link Value} will be
         * constructed/provided for for various {@link DataHolder}s either
         * through a {@link DataProvider} dynamically, or by a serialization
         * strategy by {@link DataStore a contextualized DataStore}.
         *
         * @param key The key to register
         * @param others The additional keys
         * @return This builder, for chaining
         */
        Builder dataKey(Key<?> key, Key<?>... others);

        /**
         * Gives the {@link Key} to this builder signifying the key is to be
         * registered either with an applicable {@link DataProvider} or an
         * associated {@link DataStore} that will provide serialization/deserialization
         * behaviors. A {@link Key} alone in the registration will allow for the
         * understanding that the {@link Key Key's} {@link Value} will be
         * constructed/provided for for various {@link DataHolder}s either
         * through a {@link DataProvider} dynamically, or by a serialization
         * strategy by {@link DataStore a contextualized DataStore}.
         *
         * @param keys The key to register
         * @return This builder, for chaining
         */
        Builder dataKey(Iterable<Key<?>> keys);

        @Override
        Builder reset();

        /**
         * {@inheritDoc}
         *
         * @return The data registration object
         * @throws IllegalStateException If registrations can no longer take place
         * @throws IllegalStateException If there are no {@link Key}s registered
         *     in this registration
         * @throws IllegalStateException If there are no {@link DataProvider}s
         *     or {@link DataStore}s, resulting in the keys being dynamic
         * @throws DataAlreadyRegisteredException If a key has already been claimed by another registration
         */
        @Override
        DataRegistration build();
    }
}
