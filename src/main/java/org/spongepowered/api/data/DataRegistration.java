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
import org.spongepowered.api.event.CauseStackManager;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.util.CatalogBuilder;

public interface DataRegistration<T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>> extends CatalogType {

    /**
     * Creates a new {@link Builder} to build a {@link DataRegistration}.
     * Through the use of generics, this can be duck-typed to the generics of
     * the desired {@link DataManipulator} type to be registered.
     *
     * @return The new builder instance
     */
    @SuppressWarnings("unchecked")
    static Builder<?, ?> builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link DataManipulator} class for this registration.
     *
     * @return The manipulator class registered
     */
    Class<T> getManipulatorClass();

    /**
     * Gets the implementing class of the {@link DataManipulator} for this
     * registration.
     *
     * @return The manipulator class registered
     */
    Class<? extends T> getImplementationClass();

    /**
     * Gets the {@link ImmutableDataManipulator} class for this registration.
     *
     * @return The immutable class registered
     */
    Class<I> getImmutableManipulatorClass();

    /**
     * Gets the implementing class of the {@link ImmutableDataManipulator} for
     * this registration.
     *
     * @return The immutable manipulator class registered
     */
    Class<? extends I> getImmutableImplementationClass();

    /**
     * Gets the {@link DataManipulatorBuilder} registered for this registration.
     *
     * @return The manipulator builder
     */
    DataManipulatorBuilder<T, I> getDataManipulatorBuilder();

    /**
     * Gets the owning {@link PluginContainer}.
     *
     * @return The owning plugin container for this registration
     */
    PluginContainer getPluginContainer();

    interface Builder<T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>>
            extends CatalogBuilder<DataRegistration<T, I>, Builder<T, I>> {

        /**
         * Sets the {@link DataManipulator} class to be used. For the sake of
         * generics, this method must be called prior to
         * {@link #immutableClass(Class)} to properly infer generic usage
         * by the compiler and at runtime.
         *
         * @param manipulatorClass The manipulator class
         * @param <D> The type of data manipulator
         * @param <M> The type of immutable data manipulator
         * @return This builder, properly generified, for chaining
         */
        <D extends DataManipulator<D, M>, M extends ImmutableDataManipulator<M, D>> Builder<D, M> dataClass(Class<D> manipulatorClass);

        /**
         * Sets the immutable class. <strong>THIS MUST BE CALLED AFTER
         * {@link #dataClass(Class)}!</strong>
         *
         * @param immutableDataClass The immutable data class
         * @return This builder, for chaining
         * @throws IllegalStateException If the data manipulator class has not
         *     been set already
         */
        Builder<T, I> immutableClass(Class<I> immutableDataClass) throws IllegalStateException;

        /**
         * Optionally sets a separate implementation class for the
         * {@link DataManipulator}. <strong>THIS MUST BE CALLED AFTER
         * {@link #dataClass(Class)}!</strong>
         *
         * @param dataImplementationClass The data manipulator implementation
         * @return This builder, for chaining
         * @throws IllegalStateException If the data manipulator class has not
         *     been set already
         */
        Builder<T, I> dataImplementation(Class<? extends T> dataImplementationClass) throws IllegalStateException;

        /**
         * Optionally sets a separate implementation class for the
         * {@link ImmutableDataManipulator}. <strong>THIS MUST BE CALLED AFTER
         * {@link #dataClass(Class)}!</strong>
         *
         * @param immutableImplementationClass The immutable data manipulator
         *     implementation
         * @return This builder, for chaining
         * @throws IllegalStateException If the immutable data manipulator
         *     class has not been set already
         */
        Builder<T, I> immutableImplementation(Class<? extends I> immutableImplementationClass) throws IllegalStateException;

        /**
         * Sets the {@link DataManipulatorBuilder} to be used to generate new
         * {@link DataManipulator DataManipulators} and
         * {@link ImmutableDataManipulator ImmutableDataManipulators}.
         *
         * @param builder The builder
         * @return This builder, for chaining
         */
        Builder<T, I> builder(DataManipulatorBuilder<T, I> builder);

        @Override
        Builder<T, I> reset();

        /**
         * {@inheritDoc}
         *
         * All of the objects for the provided {@link DataRegistration}
         * object, including the registration's
         * {@link DataRegistration#getManipulatorClass()} for the
         * {@link DataManipulator} and
         * {@link DataRegistration#getImmutableManipulatorClass()}
         * and {@link DataRegistration#getDataManipulatorBuilder()}
         * object will also be registered.
         *
         * @return The data registration object
         * @throws IllegalStateException If registrations can no longer take place
         * @throws IllegalArgumentException Various reasons
         * @throws DataAlreadyRegisteredException If the classes and or builder
         *                                        has already been registered
         */
        @Override
        DataRegistration<T, I> build();
    }
}
