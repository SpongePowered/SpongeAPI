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
package org.spongepowered.api.service.context;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.event.EventContext;

import java.util.Optional;

/**
 * A common interface for objects that have an identifier and can have a set of
 * active {@link Context}s determined.
 *
 * <p>Used primarily by {@link ContextService}s.</p>
 */
public interface Contextual {

    /**
     * Returns the identifier associated with this Contextual.
     *
     * <p>The identifier of each distinct Contextual within a collection of
     * contextuals should be unique.</p>
     *
     * <p>Not guaranteed to be human-readable. Use
     * {@link #friendlyIdentifier()} for a more readable alternative.</p>
     *
     * @return The identifier for this subject
     */
    String identifier();

    /**
     * Returns the friendly identifier associated with this Contextual.
     *
     * <p>Unlike {@link #identifier()}, this value is not guaranteed to be
     * unique.</p>
     *
     * <p>If the friendly identifier is equal to the normal identifier,
     * this method should return {@link Optional#empty()}.</p>
     *
     * <p>Contextuals which represent a {@link ServerPlayer} or a {@link User}
     * should return the username here, if available.</p>
     *
     * @return The friendly identifier for this contextual
     */
    default Optional<String> friendlyIdentifier() {
        return Optional.empty();
    }

    /**
     * Get the cause describing the current state of this subject.
     *
     * <p>This is often not based on current game state, but rather the last
     * known state of this subject. If a subject refers to a game object that is
     * not active in the world, the cause may be a global cause.</p>
     *
     * @return the active cause
     */
    default Cause contextCause() {
        return Cause.of(EventContext.empty(), Sponge.game().server());
    }

}
