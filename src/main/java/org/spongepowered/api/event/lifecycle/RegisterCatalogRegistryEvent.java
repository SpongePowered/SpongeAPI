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
package org.spongepowered.api.event.lifecycle;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.registry.DuplicateRegistrationException;

import java.util.Set;
import java.util.function.Supplier;

public interface RegisterCatalogRegistryEvent extends LifecycleEvent {

    /**
     * Registers a new {@link CatalogType} registry.
     *
     * @param catalogClass The catalog type
     * @param key The key for the registry
     * @param <T> The type
     * @throws DuplicateRegistrationException If the type is already registered
     */
    <T extends CatalogType> void register(Class<T> catalogClass, ResourceKey key) throws DuplicateRegistrationException;

    /**
     * Registers a new {@link CatalogType} registry.
     *
     * @param catalogClass The catalog type
     * @param key The key for the registry
     * @param defaultsSupplier The default added types, added for convenience
     * @param <T> The type
     * @throws DuplicateRegistrationException If the type is already registered
     */
    <T extends CatalogType> void register(Class<T> catalogClass, ResourceKey key, @Nullable Supplier<Set<T>> defaultsSupplier) throws DuplicateRegistrationException;
}
