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
package org.spongepowered.api.world.server;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.Ticks;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Comparator;

/**
 * Represents a type of {@link Ticket chunk loading ticket} that can be obtained
 * to ensure chunks remain loaded in a {@link ServerWorld}.
 *
 * @param <T> The type of value that is associated with a {@link Ticket} of this
 *      type.
 */
@SuppressWarnings("unchecked")
public interface TicketType<T>  {

    static <T> Builder<T> builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * The name of this type.
     *
     * @return The name
     */
    String name();

    /**
     * Gets the lifetime of any {@link Ticket tickets} of this type.
     *
     * @return The number of {@link Ticks} any {@link Ticket tickets} of this
     *         type will be valid for.
     */
    Ticks lifetime();

    interface Builder<T> extends ResettableBuilder<T, Builder<T>> {

        /**
         * Sets the name of the {@link TicketType type}.
         *
         * @param name The name
         * @return The builder, for chaining
         */
        Builder<T> name(@NonNull String name);

        /**
         * Sets the {@link Comparator comparator} used by requested {@link Ticket tickets}
         * of this type used to determine the appropriate ticket to be used during collisions.
         * <p>
         * If this call is omitted, it is up to the implementation on how the comparison is handled.
         * In the official implementation, the resulting comparison value is '0'.
         *
         * @param comparator The comparator
         * @return The builder, for chaining
         */
        Builder<T> comparator(@Nullable Comparator<T> comparator);

        /**
         * Sets the lifetime of the {@link TicketType type}.
         *
         * @param lifetime The lifetime
         * @return The builder, for chaining
         */
        Builder<T> lifetime(Ticks lifetime);

        /**
         * Builds a new {@link TicketType type}.
         *
         * @return The type
         */
        TicketType<T> build();
    }
}
