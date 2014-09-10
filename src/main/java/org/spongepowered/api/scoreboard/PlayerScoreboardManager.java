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
 * This class provides a layering system for objectives and scoreboards.
 *
 * <p>Every scoreboard and every objective is a layer.
 * Every layer can be opaque or not.</p>
 *
 * <p>When you add an opaque layer,
 * every layer's objectives below that one will be hidden.</p>
 *
 * <p>When you add an non-opaque layer, only
 * the lower layer's objectives on the same position will be overwritten.</p>
 */
public interface PlayerScoreboardManager {

    /**
     * Adds the specified scoreboard as a layer on top of the stack.
     *
     * @param opaque Whether the added layer is opaque or not
     * @param scoreboard The scoreboard to display.
     */
    void addScoreboardLayer(Scoreboard scoreboard, boolean opaque);

    /**
     * Gets whether the specified scoreboard is in the layer list.
     *
     * @param scoreboard The scoreboard to scan for.
     */
    void hasScoreboardLayer(Scoreboard scoreboard);

    /**
     * Removes the specified scoreboard from the layer list.
     *
     * @param scoreboard The scoreboard to remove.
     */
    void removeScoreboardLayer(Scoreboard scoreboard);

    /**
     * Adds the specified objective as a layer on top of the stack.
     *
     * @param opaque Whether the added layer is opaque or not
     * @param objective The objective to display.
     */
    void addObjectiveLayer(Objective objective, boolean opaque);

    /**
     * Gets whether the specified objective is in the layer list.
     *
     * @param objective The objective to scan for.
     */
    void hasObjectiveLayer(Objective objective);

    /**
     * Removes the specified objective from the layer list.
     *
     * @param objective The objective to remove.
     */
    void removeObjectiveLayer(Objective objective);

    /**
     * Gets the count of all currently added layers.
     *
     * @return the current layer count
     */
    int getLayerCount();

    /**
     * <p>Moves the specified scoreboard layer to a specific position,
     * i.e. to the top or the bottom.</p>
     *
     * @param scoreboard The scoreboard whose layer to move.
     * @param target The target position, where 0 is the bottom
     */
    void moveScoreboardLayer(Scoreboard scoreboard, int target);

    /**
     * <p>Moves the specified objective layer to a specific position,
     * i.e. to the top or the bottom.</p>
     *
     * @param objective The objective whose layer to move.
     * @param target The target position, where 0 is the bottom
     */
    void moveObjectiveLayer(Objective objective, int target);

    /**
     * Removes all layers from this player.
     */
    void clear();
}
