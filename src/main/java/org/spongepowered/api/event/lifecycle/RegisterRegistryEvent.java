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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.event.GenericEvent;
import org.spongepowered.api.registry.DuplicateRegistrationException;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.ScopedRegistryHolder;

import java.util.Map;
import java.util.function.Supplier;

public interface RegisterRegistryEvent<T extends ScopedRegistryHolder> extends GenericEvent<T>, LifecycleEvent {

    T getHolder();

    /**
     * Registers a new {@link Registry}.
     *
     * @param key The key for the registry
     * @param isDynamic If this registry will support additional registrations after the lifecycle
     * @throws DuplicateRegistrationException If the type is already registered
     */
    <R> Registry<R> register(RegistryKey<R> key, boolean isDynamic) throws DuplicateRegistrationException;

    /**
     * Registers a new {@link Registry}.
     *
     * @param key The key for the registry
     * @param isDynamic If this registry will support additional registrations after the lifecycle
     * @param defaultValues The values to populate the registry with
     * @throws DuplicateRegistrationException If the type is already registered
     */
    <R> Registry<R> register(RegistryKey<R> key, boolean isDynamic, Supplier<Map<ResourceKey, R>> defaultValues) throws DuplicateRegistrationException;
}
