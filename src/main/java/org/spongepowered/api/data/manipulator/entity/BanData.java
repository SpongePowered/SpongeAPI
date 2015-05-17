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
package org.spongepowered.api.data.manipulator.entity;

import org.spongepowered.api.data.manipulator.ListData;
import org.spongepowered.api.entity.player.User;
import org.spongepowered.api.util.ban.Ban;

import java.util.Collection;

/**
 * Represents a list of known {@link Ban}s usually applicable to
 * {@link User}s.
 */
public interface BanData extends ListData<Ban.User, BanData> {

    /**
     * Adds the given ban to the owner on top of any other bans.
     *
     * @param ban The ban to put on the user
     * @return This instance, for chaining
     */
    BanData ban(Ban.User ban);

    /**
     * Gets the bans registered for this user.
     *
     * @return Bans on this user
     */
    Collection<Ban.User> getBans();

}
