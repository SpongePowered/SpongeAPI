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
import org.spongepowered.api.registry.RegistryHolder;
import org.spongepowered.api.registry.RegistryType;
import org.spongepowered.eventgen.annotations.NoFactoryMethod;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

@NoFactoryMethod
public interface RegisterRegistryValueEvent extends LifecycleEvent {

    default <T> void registry(RegistryType<T> registryType, Consumer<RegistryStep<T>> consumer) {
        this.registry(registryType, (h, r) -> consumer.accept(r));
    }

    <T> void registry(RegistryType<T> registryType, BiConsumer<RegistryHolder, RegistryStep<T>> consumer);

    <T> void registry(RegistryType<T> registryType, BiConsumer<RegistryHolder, RegistryStep<T>> consumer, final RegistryType<?>... dependencies);

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
