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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryValue;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.Ticks;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * Represents a type of {@link Ticket chunk loading ticket} that can be obtained
 * to ensure chunks remain loaded in a {@link ServerWorld}.
 */
@CatalogedBy(TicketTypes.class)
public interface TicketType extends DefaultedRegistryValue<TicketType> {

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * @return Whether tickets of this type are persisted when the world is shut down.
     */
    boolean persists();

    /**
     * @return Whether tickets of this type will load chunks.
     */
    boolean loadsChunks();

    /**
     * @return Whether tickets of this type will cause chunks to update their blocks and entities.
     */
    boolean simulatesChunks();

    /**
     * Gets whether tickets of this type keeps the world active.
     * The world may stop processing after being inactive for a certain amount of time.
     *
     * @return Whether tickets of this type keeps the world active.
     */
    boolean keepsWorldActive();

    /**
     * @return Whether tickets of this type count down their remaining ticks even their chunks are not loaded.
     */
    boolean canExpireIfUnloaded();

    /**
     * Gets the lifetime of any {@link Ticket tickets} of this type.
     *
     * @return The number of {@link Ticks} any {@link Ticket tickets} of this
     *         type will be valid for.
     */
    Ticks lifetime();

    interface Builder extends ResettableBuilder<TicketType, Builder> {

        /**
         * @param persists Whether tickets of this type are persisted when the world is shut down.
         * @return This builder, for chaining
         */
        Builder persists(boolean persists);

        /**
         * @param loadsChunks Whether tickets of this type will load chunks.
         * @return This builder, for chaining
         */
        Builder loadsChunks(boolean loadsChunks);

        /**
         * @param simulatesChunks Whether tickets of this type will cause chunks to update their blocks and entities.
         * @return This builder, for chaining
         */
        Builder simulatesChunks(boolean simulatesChunks);

        /**
         * Sets whether tickets of this type keeps the world active.
         * The world may stop processing after being inactive for a certain amount of time.
         *
         * @param keepsWorldActive Whether tickets of this type keeps the world active.
         * @return This builder, for chaining
         */
        Builder keepsWorldActive(boolean keepsWorldActive);

        /**
         * @param canExpireIfUnloaded Whether tickets of this type count down their remaining ticks even their chunks are not loaded.
         * @return This builder, for chaining
         */
        Builder canExpireIfUnloaded(boolean canExpireIfUnloaded);

        /**
         * Sets the lifetime of the {@link TicketType type}.
         *
         * @param lifetime The lifetime
         * @return The builder, for chaining
         */
        Builder lifetime(Ticks lifetime);

        /**
         * Builds a new {@link TicketType type}.
         *
         * @return The type
         */
        TicketType build();
    }
}
