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

import org.spongepowered.api.block.BlockTypes;

/**
 * A flag of sorts that determines whether a block change will perform various
 * interactions, such as notifying neighboring blocks, performing block physics
 * on placement, etc.
 */
public interface BlockChangeFlag {

    /**
     * Gets whether this flag defines that a block change should
     * notify neighboring blocks.
     *
     * @return True if this is set to notify neighboring blocks
     */
    boolean updateNeighbors();

    /**
     * Gets whether this flag defines that a block change should
     * update clients to perform a rendering update
     *
     * @return True if this is set to update clients
     */
    boolean notifyClients();

    /**
     * Gets whether this flag defines that a block change should
     * perform block physics checks or not. If not, no checks
     * are performed.
     *
     * @return True if this is set to perform block physics on placement
     */
    boolean performBlockPhysics();

    /**
     * Gets whether this flag will update observer blocks, different
     * from notifying neighbors in that neighbor notifications
     * can cause further block notification loops (like redstone),
     * whereas this focuses on {@link BlockTypes#OBSERVER} blocks
     * being told of updates.
     *
     * @return True if this is set to update observers.
     */
    boolean updateNeighboringShapes();

    /**
     * Gets whether this flag will queue lighting updates, different
     * blocks may affect lighting in locations, which can potentially
     * cause other blocks to perform side effects due to the light
     * changes (like mushrooms). It is not recommended to rely on this
     * particular flag for any changes that can cause client-side
     * lighting inconsistencies.
     *
     * @return True if this flag will update lighting
     */
    boolean updateLighting();

    /**
     * Gets whether this flag will notify pathfinders and navigators
     * for AI on entities and potentially other entities of a block
     * change. It may be helpful for mass block placement to bypass
     * a notification of pathfinders within an area.
     *
     * @return True if this flag will update pathing
     */
    boolean notifyPathfinding();

    /**
     * Gets whether this flag will allow blocks being destroyed as
     * a result of {@link #updateNeighboringShapes()} if the affected
     * blocks could be considered "destroyed" and drop items.
     *
     * @return True if this flag will allow neighboring blocks to perform drops
     */
    boolean neighborDropsAllowed();

    /**
     * Gets whether this flag is considering that blocks are being moved
     * in the world, much like how pistons will move blocks. This has some
     * effect on {@link org.spongepowered.api.block.entity.BlockEntity} creation
     * reaction or drop delays. The behaviors are dependent on the block in
     * particular.
     *
     * @return True if the flag is considering blocks are moving
     */
    boolean movingBlocks();

    /**
     * Gets whether this block change is going to request the client to re-render
     * the block on chnge for the next client tick. This has particular usage
     * when performing complicated block changes with extra steps, such as
     * pistons performing a move.
     *
     * @return True if the blockchagne is requesting the client to re-render
     * the change on the next tick
     */
    boolean forceClientRerender();

    /**
     * Gets whether the block change is requested to have no render update on
     * the client. This is generally used only when {@link #notifyClients()}
     * is {@code true} as well as {@link #forceClientRerender()} is
     * {@code false}.
     *
     * @return True if the client is not to render te block change, usually
     * accompanied later by a manual update after some ticks
     */
    boolean ignoreRender();

    /**
     * Gets the equivalent {@link BlockChangeFlag} of this flag with all
     * other flags while having the desired {@code updateNeighbors}
     * as defined by the parameter.
     *
     * @param updateNeighbors Whether to update neighboring blocks
     * @return The relative flag with the desired update neighbors
     */
    BlockChangeFlag withUpdateNeighbors(boolean updateNeighbors);

    /**
     * Gets the equivalent {@link BlockChangeFlag} of this flag
     * with all other flags while having the desired {@code updateClients}
     * as defined by the parameter.
     *
     * @param updateClients Whether to update clients
     * @return The relative flag with the desired update clients
     */
    BlockChangeFlag withNotifyClients(boolean updateClients);

    /**
     * Gets the equivalent {@link BlockChangeFlag} of this flag
     * with all other flags while having the desired {@code performBlockPhysics}
     * as defined by the parameter.
     *
     * @param performBlockPhysics Whether to perform block physics
     * @return The relative flag with the desired block physics
     */
    BlockChangeFlag withPhysics(boolean performBlockPhysics);

    /**
     * Gets the equivalent {@link BlockChangeFlag} of this flag with all
     * other flags while having the desired {@code updateNeighboringShapes}
     * as defined by the parameter.
     *
     * @param notifyObservers Whether to update observer blocks
     * @return The relative flag with the desired notify observers
     */
    BlockChangeFlag withNotifyObservers(boolean notifyObservers);

    BlockChangeFlag withLightingUpdates(boolean lighting);

    BlockChangeFlag withPathfindingUpdates(boolean pathfindingUpdates);

    BlockChangeFlag withNeighborDropsAllowed(boolean dropsAllowed);

    BlockChangeFlag withBlocksMoving(boolean moving);

    BlockChangeFlag withIgnoreRender(boolean ignoreRender);

    BlockChangeFlag withForcedReRender(boolean forcedReRender);

    /**
     * Gets the inverted {@link BlockChangeFlag} of this flag.
     * Normally, this may cancel out certain interactions, such
     * as physics, neighbor notifications, or even observer
     * notifications. In certain circumstances, some flags may
     * even require clients to rejoin the world or restart their
     * connections to the server.
     *
     * @return The inverted flag
     */
    BlockChangeFlag inverse();

    /**
     * Gets the equivalent {@link BlockChangeFlag} of this flag
     * with the {@code true}s set for this flag and the provided
     * {@code flag}, such that only if both flags have the same
     * {@code true} flags set will persist.
     *
     * <p>For example, if this flag has {@link #updateNeighboringShapes()}
     * and the incoming flag has {@link #updateNeighboringShapes()} returning
     * {@code true}, the resulting flag will have
     * {@link #updateNeighboringShapes()} return {@code true} as well. The
     * inverse is also true. If either has differing flags for any
     * of the above methods, the resulting flag will have a
     * {@code false} value.</p>
     *
     * @param flag The incoming flag to and with this flag
     * @return The resulting flag with matched values
     */
    BlockChangeFlag andFlag(BlockChangeFlag flag);

    /**
     * Gets the equivalent {@link BlockChangeFlag} of this flag
     * with the {@code true}s set for this flag and the provided
     * {@code flag}, such that only if both flags have the same
     * {@code true} flags set will persist.
     *
     * <p>For example, if this flag has {@link #updateNeighboringShapes()}
     * and the incoming flag has {@link #updateNeighboringShapes()} returning
     * {@code true}, the resulting flag will have
     * {@link #updateNeighboringShapes()} return {@code true} as well. The
     * inverse is also true. If either has differing flags for any
     * of the above methods, the resulting flag will have a
     * {@code false} value.</p>
     *
     * @param flag The incoming flag to and with this flag
     * @return The resulting flag with matched values
     */
    BlockChangeFlag andNotFlag(BlockChangeFlag flag);

    interface Factory {

        /**
         * Provides a {@link BlockChangeFlag} where all flags are {@code false}.
         *
         * <ul>
         *   <li>{@link BlockChangeFlag#updateNeighbors()} is {@code false}</li>
         *   <li>{@link BlockChangeFlag#notifyClients()} is {@code false}</li>
         *   <li>{@link BlockChangeFlag#updateNeighboringShapes()} is {@code false}</li>
         *   <li>{@link BlockChangeFlag#updateLighting()} is {@code false}</li>
         *   <li>{@link BlockChangeFlag#performBlockPhysics()} is {@code false}</li>
         *   <li>{@link BlockChangeFlag#notifyPathfinding()} is {@code false}</li>
         * </ul>
         *
         * @return The all false change flag
         */
        BlockChangeFlag none();

    }

}
