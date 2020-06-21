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

import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.data.persistence.DataContentUpdater;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.persistence.DataTranslator;
import org.spongepowered.api.data.persistence.DataView;
import org.spongepowered.plugin.PluginContainer;

import java.util.Collection;
import java.util.Optional;

/**
 * A manager of the overall Data API. This handles the registration of
 * {@link DataSerializable}s and their {@link DataBuilder}s,
 * {@link DataRegistration}s, etc.
 *
 * <p>Note that this manager powers not just serialization and deserialization,
 * but also powers a majority of the Data API.</p>
 */
public interface DataManager {

    /**
     * Registers a {@link DataBuilder} that will dynamically build
     * the given {@link DataSerializable} from a {@link DataContainer}.
     *
     * <p>Builders may not always exist for a given {@link DataSerializable},
     * nor is it guaranteed that a provided builder will function with all
     * {@link DataContainer}s.
     * </p>
     *
     * @param clazz The class of the {@link DataSerializable}
     * @param builder The builder that can build the data serializable
     * @param <T> The type of data serializable
     */
    <T extends DataSerializable> void registerBuilder(Class<T> clazz, DataBuilder<T> builder);

    /**
     * Registers a {@link DataContentUpdater} for the desired
     * {@link DataSerializable} such that any versioned data may be updated to
     * newer versions for the most up to date {@link DataBuilder}.
     *
     * @param clazz The data serializable class
     * @param updater The updater
     * @param <T> The type of DataSerializable
     */
    <T extends DataSerializable> void registerContentUpdater(Class<T> clazz, DataContentUpdater updater);

    /**
     * Gets a wrapped fake {@link DataContentUpdater} that may wrap several
     * {@link DataContentUpdater}s to translate versioned data from the desired
     * {@code fromVersion} to the {@code toVersion}. If the version jump is too
     * great or a {@link DataContentUpdater} has not been registered to cover
     * the complete jump, {@link Optional#empty()} may be returned.
     *
     * @param clazz The data serializable class
     * @param fromVersion The version converting from
     * @param toVersion The version converting to
     * @param <T> The type of data serializable
     * @return The content updater, if available
     */
    <T extends DataSerializable> Optional<DataContentUpdater> getWrappedContentUpdater(Class<T> clazz, int fromVersion, int toVersion);

    /**
     * Attempts to retrieve the {@link DataBuilder} for the desired
     * {@link DataSerializable} class.
     *
     * <p>Builders may not always exist for a given {@link DataSerializable},
     * nor is it guaranteed that a provided builder will function with all
     * {@link DataContainer}s.</p>
     *
     * @param clazz The class of the data serializable
     * @param <T> The type of data serializable
     * @return The builder, if available
     */
    <T extends DataSerializable> Optional<DataBuilder<T>> getBuilder(Class<T> clazz);

    /**
     * Attempts to translate an instance of the {@link DataSerializable} from
     * the provided {@link DataView}. If there is no {@link DataBuilder}
     * registered for the provided {@link DataSerializable}, then
     * {@link Optional#empty()} may be returned.
     *
     * @param clazz The class of the data serializable
     * @param dataView The data view containing raw data
     * @param <T> The type of data serializable
     * @return The data serializable, if available
     */
    <T extends DataSerializable> Optional<T> deserialize(Class<T> clazz, DataView dataView);

    /**
     * Registers the given {@link org.spongepowered.api.data.DataHolder.Immutable} class with it's
     * associated {@link org.spongepowered.api.data.DataHolderBuilder.Immutable}. The builder can be used to
     * create new instances of the given {@link org.spongepowered.api.data.DataHolder.Immutable} for data
     * retrieval, data representation, etc.
     *
     * @param holderClass The class of the immutable data holder
     * @param builder The builder instance of the immutable data holder
     * @param <T> The type of immutable data holder
     * @param <B> The type of immutable data builder
     */
    <T extends DataHolder.Immutable<T>, B extends DataHolderBuilder.Immutable<T, B>> void register(Class<T> holderClass, B builder);

    /**
     * Registers a legacy {@code id} that is used by a previous version of
     * {@link DataRegistration} from a plugin such that the custom data can
     * be retained, while not being lost.
     *
     * @param legacyId The legacy id
     * @param registration The registration object successfully created
     */
    void registerLegacyManipulatorIds(String legacyId, DataRegistration registration);

    /**
     * Attempts to retrieve the builder for the given
     * {@link org.spongepowered.api.data.DataHolder.Immutable}.
     *
     * <p>If the {@link org.spongepowered.api.data.DataHolder.Immutable} was not registered, multiple
     * systems could fail to retrieve specific data.</p>
     *
     * @param holderClass The immutable data holder class
     * @param <T> The type of immutable data holder
     * @param <B> The type of immutable data builder
     * @return The builder, if available
     */
    <T extends DataHolder.Immutable<T>, B extends DataHolderBuilder.Immutable<T, B>> Optional<B> getImmutableBuilder(Class<T> holderClass);

    /**
     * Gets the desired {@link DataTranslator} for the provided class.
     *
     * @param objectClass The class of the object
     * @param <T> The type of object
     * @return The data translator, if available
     */
    <T> Optional<DataTranslator<T>> getTranslator(Class<T> objectClass);

    /**
     * Gets all {@link Class}es of all {@link DataRegistration}s registered for
     * the provided {@link PluginContainer}. The provided {@link Collection} is
     * considered immutable and can not be modified.
     *
     * @param container The plugin container for registered classes
     * @return The collection of all registered data manipulator classes
     */
    Collection<DataRegistration> getAllRegistrationsFor(PluginContainer container);

    /**
     * Creates a new {@link DataContainer} with a default
     * {@link org.spongepowered.api.data.persistence.DataView.SafetyMode} of
     * {@link org.spongepowered.api.data.persistence.DataView.SafetyMode#ALL_DATA_CLONED}.
     *
     * @return A new data container
     */
    DataContainer createContainer();

    /**
     * Creates a new {@link DataContainer} with the provided
     * {@link org.spongepowered.api.data.persistence.DataView.SafetyMode}.
     *
     * @param safety The safety mode to use
     * @see org.spongepowered.api.data.persistence.DataView.SafetyMode
     * @return A new data container with the provided safety mode
     */
    DataContainer createContainer(DataView.SafetyMode safety);

}
