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
package org.spongepowered.api.scoreboard;


/**
 * Provides access to the main scoreboard for a world, and allows the creation of
 * new scoreboards.
 */
public interface ScoreboardManager {

    /**
     * Gets the primary {@link Scoreboard} used by a world.
     *
     * <p>This {@link Scoreboard} is saved by the server, is affected by the /scoreboard
     * command, and is set by default for {@link org.spongepowered.api.entity.player.Player}s in
     * the assoicated world.</p>
     *
     * @return The default {@link Scoreboard} for a world
     */
    Scoreboard getMainScoreboard();

    /**
     * Gets a new {@link Scoreboard}.
     *
     * @return The registered {@link Scoreboard}
     */
    Scoreboard createScoreboard();

}
