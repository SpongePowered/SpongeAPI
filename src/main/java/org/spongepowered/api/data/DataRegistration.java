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
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.persistence.InvalidDataException;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.ResettableBuilder;

public interface DataRegistration<T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>> extends CatalogType {

    /**
     * Creates a new {@link Builder} to build a {@link DataRegistration}.
     * Through the use of generics, this can be duck-typed to the generics of
     * the desired {@link DataManipulator} type to be registered.
     * @param <T>
     * @param <I>
     * @return
     */
    @SuppressWarnings("unchecked")
    static <T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>> Builder<T, I> builder() {
        return (Builder<T, I>) Sponge.getRegistry().createBuilder(Builder.class);
    }

    Class<T> getManipulatorClass();

    Class<I> getImmutableManipulatorClass();

    DataManipulatorBuilder<T, I> getDataManipulatorBuilder();

    PluginContainer getPluginContainer();

    @Override
    String getId();

    @Override
    String getName();

    interface Builder<T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>>
        extends ResettableBuilder<DataRegistration<T, I>, Builder<T, I>> {

        Builder<T, I> setDataClass(Class<T> manipulatorClass);

        Builder<T, I> setImmutableDataClass(Class<I> immutableDataClass);

        /**
         * Sets the id for the manipulator. The id should be formatted
         * according to the normal {@link CatalogType} standard:
         * <code>&#123;plugin-id&#124;&#58;&#123;manipulator-id&#124;</code>
         *
         * <p>The importance of the id is that the id is what will be used for
         * serialization and deserialization of custom plugin provided data,
         * such that if the string changes, or a plugin is no longer available
         * to register the data, the custom data being deserialized will not be
         * available through the system, and may be lost.</p>
         *
         * @param id The id for the manipulator
         * @return This builder, for chaining
         */
        Builder<T, I> setManipulatorId(String id);

        /**
         * Since {@link DataRegistration} objects should be considered
         * singletons in that the data registered upon creation is already
         * preformed, creating a new {@link DataRegistration} will always
         * fail.
         *
         * @param value The built object
         * @return This builder, but will fail
         * @throws UnsupportedOperationException Always will throw an exception
         *     since there can not be multiple registration objects for the same
         *     data
         */
        @Override
        @Deprecated
        Builder<T, I> from(DataRegistration<T, I> value) throws UnsupportedOperationException;

        @Override
        Builder<T, I> reset();

        /**
         * Registers all of the objects for the provided {@link DataRegistration}
         * object, including the registration's
         * {@link DataRegistration#getManipulatorClass()} for the
         * {@link DataManipulator} and
         * {@link DataRegistration#getImmutableManipulatorClass()}
         * and {@link DataRegistration#getDataManipulatorBuilder()} object. More
         * importantly, this also allows the proper identification of the
         * {@link DataManipulator} itself by the provided
         * {@link DataRegistration#getId()},
         * which, much like {@link CatalogType#getId()} is formatted with
         * <code>&#123;plugin-id&#124;&#58;&#123;manipulator-id&#124;</code>.
         *
         * <p>The difference to constructing the {@link DataRegistration} object
         * and {@link DataManager#register(Class, Class, DataManipulatorBuilder)}
         * is that when the {@link DataRegistration} object is built, all of the
         * classes and the provided builder will already have been registered.</p>
         *
         * <p>It is expected that as the required </p>
         *
         *
         *
         * @return The data registration object
         * @throws IllegalStateException
         * @throws IllegalArgumentException
         * @throws DataAlreadyRegisteredException
         */
        DataRegistration<T, I> buildAndRegister(PluginContainer container) throws IllegalStateException, IllegalArgumentException,
                                                                                  DataAlreadyRegisteredException;

    }

}
