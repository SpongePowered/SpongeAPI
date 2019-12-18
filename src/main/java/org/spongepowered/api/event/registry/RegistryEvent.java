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
package org.spongepowered.api.event.registry;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.registry.DuplicateRegistrationException;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Set;
import java.util.function.Supplier;

public interface RegistryEvent {

    interface Builder {

        /**
         * Registers a new {@link ResettableBuilder builder}.
         *
         * @param builderClass The builder type
         * @param supplier The supplier of the builder instance
         * @param <T> The type
         * @throws DuplicateRegistrationException If the type is already registered
         */
        <T extends ResettableBuilder<?, ? super T>> void register(Class<T> builderClass, Supplier<? super T> supplier) throws DuplicateRegistrationException;
    }

    interface CatalogRegistry extends RegistryEvent {

        /**
         * Registers a new {@link CatalogType catalog type} registry.
         *
         * @param catalogClass The catalog type
         * @param <T> The type
         * @throws DuplicateRegistrationException If the type is already registered
         */
        <T extends CatalogType> void register(Class<T> catalogClass) throws DuplicateRegistrationException;

        /**
         * Registers a new {@link CatalogType catalog type} registry.
         *
         * @param catalogClass The catalog type
         * @param defaultsSupplier The default added types, added for convenience
         * @param <T> The type
         * @throws DuplicateRegistrationException If the type is already registered
         */
        <T extends CatalogType> void register(Class<T> catalogClass, Supplier<Set<T>> defaultsSupplier) throws DuplicateRegistrationException;
    }

    interface Catalog<T extends CatalogType> extends RegistryEvent {

        /**
         * Registers a new {@link CatalogType catalog type}.
         *
         * @param catalogType The catalog type
         * @throws DuplicateRegistrationException If the type is already registered
         */
        void register(T catalogType) throws DuplicateRegistrationException;
    }

    interface Factory {

        /**
         * Registers an object meant to be used to churn object references
         *
         * @param factoryClass The factory type
         * @param <T> The type
         * @throws DuplicateRegistrationException If the type is already registered
         */
        <T> void register(Class<T> factoryClass) throws DuplicateRegistrationException;
    }
}
