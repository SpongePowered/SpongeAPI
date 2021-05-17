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
package org.spongepowered.api.adventure;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.audience.ForwardingAudience;
import org.spongepowered.api.Sponge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * {@link Audience}s.
 */
public final class Audiences {
    /**
     * Gets an {@link Audience} that targets the entire server, including players
     * and system, when available.
     *
     * @return An audience
     */
    public static Audience server() {
        return Sponge.game().server();
    }

    /**
     * Gets an {@link Audience} that targets all online players.
     *
     * @return An audience
     */
    public static Audience onlinePlayers() {
        return Audiences.factory().onlinePlayers();
    }

    /**
     * Gets an {@link Audience} that targets all online players
     * with the specified permission.
     *
     * @param permission The permission
     * @return An audience
     */
    public static Audience withPermission(final String permission) {
        Objects.requireNonNull(permission);
        return Audiences.factory().withPermission(permission);
    }

    /**
     * Filters an audience with given predicate.
     * <p>For {@link net.kyori.adventure.audience.ForwardingAudience}s the predicate is tested on each {@link ForwardingAudience#audiences()}</p>
     *
     * @param predicate The predicate
     *
     * @return The filtered audience.
     */
    public static Optional<Audience> filtered(final Audience audience, final Predicate<Audience> predicate) {
        if (!(audience instanceof ForwardingAudience)) {
            if (predicate.test(audience)) {
                return Optional.of(audience);
            }
            return Optional.empty();
        }
        final List<Audience> list = new ArrayList<>();
        for (Audience subAudience : ((ForwardingAudience) audience).audiences()) {
            Audiences.filtered(subAudience, predicate).ifPresent(list::add);
        }
        if (list.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of((ForwardingAudience) () -> list);
    }

    /**
     * Gets an {@link Audience} that targets the system, such as a server console.
     *
     * @return An audience
     */
    public static Audience system() {
        return Sponge.game().systemSubject();
    }

    private static Factory factory() {
        return Sponge.game().factoryProvider().provide(Factory.class);
    }

    public interface Factory {

        Audience onlinePlayers();

        Audience withPermission(String permission);
    }
}
