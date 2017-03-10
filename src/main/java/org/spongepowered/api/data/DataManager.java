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
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulatorBuilder;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.persistence.DataContentUpdater;
import org.spongepowered.api.data.persistence.DataTranslator;
import org.spongepowered.api.plugin.PluginContainer;

import java.util.Collection;
import java.util.Optional;

/**
 * A manager of the overall Data API. This handles the registration of
 * {@link DataSerializable}s and their {@link DataBuilder}s,
 * {@link DataManipulator}s and their respective {@link DataManipulatorBuilder}s,
 * {@link ImmutableDataManipulator}s and their respective
 * {@link ImmutableDataManipulatorBuilder}s, etc.
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
     * Registers the given {@link ImmutableDataHolder} class with it's
     * associated {@link ImmutableDataBuilder}. The builder can be used to
     * create new instances of the given {@link ImmutableDataHolder} for data
     * retrieval, data representation, etc.
     *
     * @param holderClass The class of the immutable data holder
     * @param builder The builder instance of the immutable data holder
     * @param <T> The type of immutable data holder
     * @param <B> The type of immutable data builder
     */
    <T extends ImmutableDataHolder<T>, B extends ImmutableDataBuilder<T, B>> void register(Class<T> holderClass, B builder);

    /**
     * Registers the given {@link DataManipulator} class with it's associated
     * {@link DataManipulatorBuilder}. The builder can be used to create new
     * instances of the given {@link DataManipulator} for data retrieval,
     * data representation, and mass application of a {@link DataManipulator}
     * to multiple {@link DataHolder}s.
     *
     * <p>Due to the addition of {@link DataRegistration}</p>
     *
     * @param manipulatorClass The class of the data manipulator
     * @param immutableManipulatorClass The class of the immutable
     *     datamanipulator
     * @param builder The builder instance of the data manipulator
     * @param <T> The type of data manipulator
     * @param <I> The type of immutable datamanipulator
     * @deprecated Use {@link DataRegistration#builder()} to simplify the
     *     registration process with the plugin developer provided id's
     */
    @Deprecated
    <T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>> void register(Class<? extends T> manipulatorClass,
            Class<? extends I> immutableManipulatorClass, DataManipulatorBuilder<T, I> builder);

    /**
     * Attempts to retrieve the builder for the given
     * {@link ImmutableDataHolder}.
     *
     * <p>If the {@link ImmutableDataHolder} was not registered, multiple
     * systems could fail to retrieve specific data.</p>
     *
     * @param holderClass The immutable data holder class
     * @param <T> The type of immutable data holder
     * @param <B> The type of immutable data builder
     * @return The builder, if available
     */
    <T extends ImmutableDataHolder<T>, B extends ImmutableDataBuilder<T, B>> Optional<B> getImmutableBuilder(Class<T> holderClass);

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
        Optional<DataManipulatorBuilder<T, I>> getManipulatorBuilder(Class<T> manipulatorClass);

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
        Optional<DataManipulatorBuilder<T, I>> getImmutableManipulatorBuilder(Class<I> immutableManipulatorClass);

    /**
     * Registers a {@link DataTranslator} for the desired class.
     *
     * @param objectClass The class of the object type being managed
     * @param translator The translator for the desired class object
     * @param <T> The type of object
     */
    <T> void registerTranslator(Class<T> objectClass, DataTranslator<T> translator);

    /**
     * Gets the desired {@link DataTranslator} for the provided class.
     *
     * @param objectclass The class of the object
     * @param <T> The type of object
     * @return The data translator, if available
     */
    <T> Optional<DataTranslator<T>> getTranslator(Class<T> objectclass);

    /**
     * Gets all {@link Class}es of all {@link DataManipulator}s registered for
     * the provided {@link PluginContainer}. The provided {@link Collection} is
     * considered immutable and can not be modified.
     *
     * @param container The plugin container for registered classes
     * @return The collection of all registered data manipulator classes
     */
    Collection<Class<? extends DataManipulator<?, ?>>> getAllRegistrationsFor(PluginContainer container);

}
