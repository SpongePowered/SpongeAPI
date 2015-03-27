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
package org.spongepowered.api.data.manipulators;

import org.spongepowered.api.data.DataManipulator;

import java.util.Date;

public interface JoinData extends DataManipulator<JoinData> {

    /**
     * Checks if this player has joined the server before.
     *
     * @return True If player has joined before
     */
    boolean hasJoinedBefore();

    /**
     * Gets the first time a player joined the server.
     *
     * <p>
     *     This time is based off epoch timestamps.
     * </p>
     *
     * @return The players first join time.
     */
    Date getFirstPlayed();

    /**
     * Gets the last time a player was on the server.
     *
     * <p>
     *     This time is based off epoch timestamps.
     * </p>
     *
     * @return The last time a player was online.
     */
    Date getLastPlayed();


}
