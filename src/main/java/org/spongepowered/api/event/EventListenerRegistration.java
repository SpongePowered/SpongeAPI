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
package org.spongepowered.api.event;

import io.leangen.geantyref.TypeToken;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.plugin.PluginContainer;

import java.lang.reflect.Type;
import java.util.Objects;

/**
 * Represents the composition of a {@link EventListener listener} and the attributes that define it
 * to the system.
 *
 * @param <T> The event type
 */
public interface EventListenerRegistration<T extends Event> {

    static <T extends Event> EventListenerRegistration.Builder<T> builder(final TypeToken<T> eventType) {
        return Sponge.game().factoryProvider().provide(Factory.class).builder(Objects.requireNonNull(eventType, "eventType"));
    }

    static <T extends Event> EventListenerRegistration.Builder<T> builder(final Class<T> eventClass) {
        return Sponge.game().factoryProvider().provide(Factory.class).builder(TypeToken.get(eventClass));
    }

    Type eventType();

    PluginContainer plugin();

    Order order();

    boolean beforeModifications();

    EventListener<? super T> listener();

    interface Builder<T extends Event> extends ResettableBuilder<EventListenerRegistration<T>, Builder<T>> {

        Builder<T> plugin(PluginContainer plugin);

        Builder<T> order(Order order);

        Builder<T> beforeModifications(boolean beforeModifications);

        Builder<T> listener(EventListener<? super T> listener);

        EventListenerRegistration<T> build();
    }

    interface Factory {

        <T extends Event> Builder<T> builder(TypeToken<T> eventType);
    }
}
