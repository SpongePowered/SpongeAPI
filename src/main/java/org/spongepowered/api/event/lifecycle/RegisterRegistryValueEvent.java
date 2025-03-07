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

import org.spongepowered.api.Engine;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.event.GenericEvent;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryHolder;
import org.spongepowered.api.registry.RegistryRegistrationSet;
import org.spongepowered.api.registry.RegistryType;
import org.spongepowered.eventgen.annotations.NoFactoryMethod;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Lifecycle event for registering entries to a {@link Registry}.
 *
 * <p>This event may be called multiple times for the same layer
 * as the registry is being appended and as dependencies become
 * available. Plugins should only execute code inside the consumers.</p>
 *
 * <p><strong>Note:</strong> Layers might be reloadable! When a registry
 * is being reloaded, this event is fired again for the relevant registries.
 * The implementation does not keep a reference to the Consumer observed
 * in the last stage and expects plugins to fill a new set of entries.</p>
 *
 * <p>Additionally, plugins may request to take a dependency on another
 * registry in order to access registered entries early to enrich its
 * own content. This can prove to be useful when both registries are in
 * the same layer and would have no access to each other otherwise.</p>
 *
 * <p>The available registries and their content are not guaranteed to
 * be accessible unless they have been added as a dependency. Plugins
 * might observe registries they have not marked as a dependency due
 * to the platform having natural dependency on them or due to the
 * registries dependency graph.</p>
 */
@NoFactoryMethod
public interface RegisterRegistryValueEvent extends LifecycleEvent {

    /**
     * <p>Register new entries against a specific {@link Registry}.</p>
     *
     * <p>The consumer will be called if it matches the current set of
     * registries being created.</p>
     *
     * @param registryType The registry type to append.
     * @param consumer The consumer to be called if found.
     */
    default <T> void registry(RegistryType<T> registryType, Consumer<RegistryStep<T>> consumer) {
        this.registry(registryType, (h, r) -> consumer.accept(r));
    }

    /**
     * <p>Register new entries against a specific {@link Registry}.</p>
     *
     * <p>The consumer will be called if it matches the current set of
     * registries being created.</p>
     *
     * @param registryType The registry type to append.
     * @param consumer The consumer to be called if found.
     */
    <T> void registry(RegistryType<T> registryType, BiConsumer<RegistryHolder, RegistryStep<T>> consumer);

    /**
     * <p>Register new entries against a specific {@link Registry}.</p>
     *
     * <p>The consumer will be called if it matches the current set of
     * registries being created.</p>
     *
     * @param registryType The registry type to append.
     * @param consumer The consumer to be called if found.
     * @param dependencies The list of registries to create before
     *                     invoking the consumer.
     */
    <T> void registry(RegistryType<T> registryType, BiConsumer<RegistryHolder, RegistryStep<T>> consumer, final RegistryType<?>... dependencies);

    /**
     * <p>Register new entries against a specific {@link Registry}.</p>
     *
     * <p>The {@link RegistryRegistrationSet registration set} will be
     * appended if it matches the current set of registries being created.</p>
     *
     * @param registrationSet The registration set.
     */
    default <T> void register(RegistryRegistrationSet<T> registrationSet) {
        this.registry(registrationSet.registryType(), (h, r) -> registrationSet.values().forEach((k, v) -> r.register(k, v.apply(h))));
    }

    /**
     * <p>Register new entries against a specific {@link Registry}.</p>
     *
     * <p>The {@link RegistryRegistrationSet registration set} will be
     * appended if it matches the current set of registries being created.</p>
     *
     * @param registrationSet The registration set.
     * @param dependencies The list of registries to create before
     *                     appending the registration set.
     */
    default <T> void register(RegistryRegistrationSet<T> registrationSet, final RegistryType<?>... dependencies) {
        this.registry(registrationSet.registryType(), (h, r) -> registrationSet.values().forEach((k, v) -> r.register(k, v.apply(h))), dependencies);
    }

    interface RegistryStep<T> {

        RegistryStep<T> register(ResourceKey key, T value);
    }

    interface GameScoped extends RegisterRegistryValueEvent {
    }

    interface EngineScoped<E extends Engine> extends RegisterRegistryValueEvent, GenericEvent<E> {
    }

    interface WorldScoped extends RegisterRegistryValueEvent {

        ResourceKey worldKey();
    }
}
