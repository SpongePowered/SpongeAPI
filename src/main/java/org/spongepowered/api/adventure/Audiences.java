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
import org.spongepowered.api.Sponge;

import java.util.Objects;

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
        return Sponge.getGame().getServer();
    }

    /**
     * Gets an {@link Audience} that targets all online players.
     *
     * @return An audience
     */
    public static Audience onlinePlayers() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).onlinePlayers();
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
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).withPermission(permission);
    }

    /**
     * Gets an {@link Audience} that targets the system, such as a server console.
     *
     * @return An audience
     */
    public static Audience system() {
        return Sponge.getGame().getSystemSubject();
    }

    private static Factory factory() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class);
    }

    public interface Factory {

        Audience onlinePlayers();

        Audience withPermission(String permission);
    }
}
