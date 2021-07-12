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
package org.spongepowered.api.event.message;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.adventure.Audiences;
import org.spongepowered.api.util.annotation.eventgen.NoFactoryMethod;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * Describes events when a involving a {@link Component} message and {@link Audience}s.
 */
@NoFactoryMethod
public interface AudienceMessageEvent extends MessageEvent {

    /**
     * Gets the original audience that this message will be sent to.
     *
     * @return The original audience to send to
     */
    Audience originalAudience();

    /**
     * Gets the current audience that this message will be sent to.
     *
     * @return The message channel the message in this event will be sent to
     */
    Optional<Audience> audience();

    /**
     * Sets the audience for this message to go to.
     *
     * @param audience The audience to set
     */
    void setAudience(@Nullable Audience audience);

    /**
     * Filters the current audience with given predicate.
     *
     * @param predicate the predicate
     */
    default void filterAudience(final Predicate<Audience> predicate) {
        if (this.audience().isPresent()) {
            this.setAudience(Audiences.filtered(this.audience().get(), predicate).orElse(null));
        }
    }

}
