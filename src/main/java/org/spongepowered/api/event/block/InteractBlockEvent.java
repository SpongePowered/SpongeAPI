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
package org.spongepowered.api.event.block;

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.action.InteractEvent;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.Direction;
import org.spongepowered.api.util.Tristate;
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.math.vector.Vector3d;

/**
 * Base event for all interactions involving a {@link BlockSnapshot} at a
 * {@link ServerLocation}.
 *
 * <p>Note: Any interaction that occurs within {@link BlockTypes#AIR} where the
 * {@link ServerLocation} is not known, will contain a {@link BlockSnapshot#empty()}.</p>
 */
public interface InteractBlockEvent extends InteractEvent {

    /**
     * Gets the {@link BlockSnapshot}.
     *
     * @return The block snapshot
     */
    BlockSnapshot block();

    /**
     * Gets the target "side" of the {@link BlockState} being interacted with
     * or {@link Direction#NONE} if not known.
     *
     * @return An optional containing the side being interacted with or
     *     {@link Direction#NONE}
     */
    Direction targetSide();

    /**
     * An event where the targeted block is being interacted with the client's
     * "primary" button.
     *
     * <p>This is usually left-click.</p>
     */
    interface Primary extends InteractBlockEvent {

        /**
         * Called when a player starts digging a block.
         *
         * <p>Canceling this will prevent starting to break a block in survival and breaking a block in creative</p>
         */
        interface Start extends Primary, Cancellable {

        }

        /**
         * Called when a player cancels digging a block.
         */
        interface Stop extends Primary {

        }

        /**
         * Called when a player finishes digging a block.
         *
         * <p>Canceling this will prevent breaking a block.</p>
         */
        interface Finish extends Primary, Cancellable {

        }
    }

    /**
     * An event where the targeted block is being interacted with the client's
     * "secondary" button.
     *
     * <p>This is usually right-click.</p>
     */
    @GenerateFactoryMethod
    interface Secondary extends InteractBlockEvent {

        Tristate originalUseItemResult();

        /**
         * Gets the original {@link #useBlockResult}.
         *
         * @return The original {@link #useBlockResult}
         */
        Tristate originalUseBlockResult();

        /**
         * Gets whether the {@link Player#itemInHand} should be used.
         *
         * <ul>
         * <li>FALSE: The {@link ItemStack} will never be used.</li>
         * <li>UNDEFINED: The {@link ItemStack} will be used if the block fails.
         * </li>
         * <li>TRUE: The {@link ItemStack} will always be used.</li>
         * </ul>
         *
         * <p>Note: These results may differ depending on implementation.</p>
         *
         * @return Whether the {@link Player#itemInHand} should be used
         */
        Tristate useItemResult();

        /**
         * Gets whether the interacted {@link BlockSnapshot} should be used.
         *
         * <ul>
         * <li>FALSE: {@link BlockSnapshot} will never be used.</li>
         * <li>UNDEFINED: {@link BlockSnapshot} will be used as normal.</li>
         * <li>TRUE: {@link BlockSnapshot} will always be used.</li>
         * </ul>
         *
         * <p>Note: These results may differ depending on implementation.</p>
         *
         * @return Whether the interacted {@link BlockSnapshot} should be used
         */
        Tristate useBlockResult();

        /**
         * Gets the point of interaction where the interaction occurred as a {@link Vector3d}.
         *
         * @return The interaction point
         */
        Vector3d interactionPoint();

        interface Pre extends Secondary, Cancellable {

            /**
             * Sets whether the {@link Player#itemInHand} should be used.
             *
             * <ul>
             * <li>FALSE: The {@link ItemStack} will never be used.</li>
             * <li>UNDEFINED: The {@link ItemStack} will be used if the block fails.
             * </li>
             * <li>TRUE: The {@link ItemStack} will always be used.</li>
             * </ul>
             *
             * <p>Note: These results may differ depending on implementation.</p>
             *
             * @param result Whether the {@link Player#itemInHand} should be used
             */
            void setUseItemResult(Tristate result);

            /**
             * Sets whether the interacted {@link BlockSnapshot} should be used.
             *
             * <ul>
             * <li>FALSE: {@link BlockSnapshot} will never be used.</li>
             * <li>UNDEFINED: {@link BlockSnapshot} will be used as normal.</li>
             * <li>TRUE: {@link BlockSnapshot} will always be used.</li>
             * </ul>
             *
             * <p>Note: These results may differ depending on implementation.</p>
             *
             * @param result Whether the interacted {@link BlockSnapshot} should be
             *     used
             */
            void setUseBlockResult(Tristate result);
        }

    }
}
