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
package org.spongepowered.api.world;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockTypes;

/**
 * An enumeration of the possible {@link BlockChangeFlag}s.
 *
 * <p>{@link BlockChangeFlag}s can be combined using the
 * {@link BlockChangeFlag#andFlag(BlockChangeFlag)} and
 * {@link BlockChangeFlag#andNotFlag(BlockChangeFlag)} operators.</p>
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public final class BlockChangeFlags {

    // SORTFIELDS:ON

    /**
     * All the available flags are applied through the OR operator.
     */
    public static final BlockChangeFlag ALL = Sponge.game().factoryProvider().provide(BlockChangeFlag.Factory.class).none().inverse();

    /**
     * The default flags for a placement event, such as a player placing a block,
     * another entity placing a block, etc.
     *
     * <p>Note: While players are normally placing blocks with this flag, there's
     * other circumstances of placing a block "as" a {@link org.spongepowered.api.entity.living.player.Player}
     * that are covered outside the purview of this default placement flag.</p>
     */
    public static final BlockChangeFlag DEFAULT_PLACEMENT = Sponge.game().factoryProvider().provide(BlockChangeFlag.Factory.class).none()
            .withNotifyClients(true)
            .withUpdateNeighbors(true)
            .withPhysics(true)
            .withNotifyObservers(true)
            .withNeighborDropsAllowed(true)
            .withLightingUpdates(true)
            .withPathfindingUpdates(true);

    /**
     * No flags are set, triggers nothing, the following flags are as such:
     * <ul>
     *     <li>{@link BlockChangeFlag#notifyClients()} is {@code false}</li>
     *     <li>{@link BlockChangeFlag#updateNeighbors()} ()} is {@code false}</li>
     *     <li>{@link BlockChangeFlag#forceClientRerender()} is {@code false}</li>
     *     <li>{@link BlockChangeFlag#ignoreRender()} is {@code false}</li>
     *     <li>{@link BlockChangeFlag#movingBlocks()} is {@code false}</li>
     *     <li>{@link BlockChangeFlag#updateLighting()} is {@code false}</li>
     *     <li>{@link BlockChangeFlag#updateNeighboringShapes()} is {@code false}</li>
     *     <li>{@link BlockChangeFlag#performBlockPhysics()} is {@code false}</li>
     *     <li>{@link BlockChangeFlag#notifyPathfinding()} is {@code false}</li>
     * </ul>
     */
    public static final BlockChangeFlag NONE = Sponge.game().factoryProvider().provide(BlockChangeFlag.Factory.class).none();

    /**
     * Sends block changes to clients but does not trigger block updates or
     * other neighboring notification updates. It does enable lighting updates,
     * usually much more preferred to having a "minimal"
     */
    public static final BlockChangeFlag NOTIFY_CLIENTS = Sponge.game().factoryProvider().provide(BlockChangeFlag.Factory.class).none()
        .withLightingUpdates(true)
        .withNotifyClients(true);

    // SORTFIELDS:OFF

    private BlockChangeFlags() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
