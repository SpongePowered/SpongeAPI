/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.service.bans;

import org.spongepowered.api.entity.player.User;
import org.spongepowered.api.util.bans.Ban;
import org.spongepowered.api.util.bans.BanProvider;

import java.util.Collection;

/**
 * Represents something that holds bans from multiple {@link BanProvider}s.
 *
 * <p>The methods inherited from {@link BanProvider} are proxies to the providers stored
 * in this {@link BanService}. Bans are additive, meaning that providers cannot 'revoke'
 * bans that other providers have without calling other methods.</p>
 *
 * <p>There is at least one ban provider at all times, the vanilla ban provider.</p>
 */
public interface BanService extends BanProvider {

    /**
     * Gets all {@link BanProvider}s that this service uses.
     *
     * @return The {@link BanProvider}s
     */
    Collection<BanProvider> getProviders();

    /**
     * Adds a BanProvider to track in this service.
     *
     * @param provider The {@link BanProvider}
     */
    void addProvider(BanProvider provider);

    /**
     * Removes a BanProvider from tracking in this service.
     *
     * @param provider The {@link BanProvider}
     * @throws IllegalArgumentException if the vanilla ban provider
     *         is attempted to be removed
     */
    void removeProvider(BanProvider provider) throws IllegalArgumentException;

    /**
     * Bans the user using the vanilla banning system, with default settings.
     */
    void ban(User user, Ban ban);

}
