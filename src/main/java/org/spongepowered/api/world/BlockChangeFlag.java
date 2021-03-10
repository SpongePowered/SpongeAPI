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
         * Provides the defaulted flag.
         * <ul>
         *   <li>{@link BlockChangeFlag#updateNeighbors()} is {@code false}</li>
         *   <li>{@link BlockChangeFlag#notifyClients()} is {@code true}</li>
         *   <li>{@link BlockChangeFlag#updateNeighboringShapes()} is {@code true}</li>
         *   <li>{@link BlockChangeFlag#updateLighting()} is {@code true}</li>
         *   <li>{@link BlockChangeFlag#performBlockPhysics()} is {@code true}</li>
         *   <li>{@link BlockChangeFlag#notifyPathfinding()} is {@code true}</li>
         * </ul>
         * @return The defaulted flag
         */
        BlockChangeFlag empty();

        /**
         * Provides a {@link BlockChangeFlag} where all flags are {@code false}, except the
         * context of client notifications for visual updates.
         *
         * <ul>
         *   <li>{@link BlockChangeFlag#updateNeighbors()} is {@code false}</li>
         *   <li>{@link BlockChangeFlag#notifyClients()} is {@code true}</li>
         *   <li>{@link BlockChangeFlag#updateNeighboringShapes()} is {@code false}</li>
         *   <li>{@link BlockChangeFlag#updateLighting()} is {@code true}</li>
         *   <li>{@link BlockChangeFlag#performBlockPhysics()} is {@code false}</li>
         *   <li>{@link BlockChangeFlag#notifyPathfinding()} is {@code false}</li>
         * </ul>
         * @return The all false change flag
         */
        BlockChangeFlag none();

    }

}
