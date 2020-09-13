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
package org.spongepowered.api.event.entity;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.message.MessageCancellable;
import org.spongepowered.api.event.message.MessageChannelEvent;
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;
import org.spongepowered.api.world.gamerule.GameRules;

/**
 * An event where the {@link Entity} is being either removed usually due to
 * the {@link Entity} being marked as "dead". Happens before
 * {@link HarvestEntityEvent}.
 */
@GenerateFactoryMethod
public interface DestructEntityEvent extends MessageChannelEvent, MessageCancellable {

    /**
     * Gets the {@link Entity}.
     *
     * @return The entity
     */
    Entity getEntity();

    /**
     * A derivative of {@link DestructEntityEvent} where the removal of the
     * {@link Living}, the {@link DestructEntityEvent#getEntity()},
     * is due to it losing its health.
     *
     * <p>Note that cancelling this event will have the implication that the
     * entity will have restored health and not enter a "death" state to
     * play a dying animation, drop items, and drop experience. It is highly
     * encouraged to keep the cancellation of this event at a mimium as in modded
     * environments, cancelling this event may have other implications that mods
     * may not consider and cause bugs.</p>
     */
    interface Death extends DestructEntityEvent, Cancellable {

        @Override
        Living getEntity();

        /**
         * Applies the {@link GameRules#KEEP_INVENTORY} gamerule to this
         * entity alone.
         *
         * <p>This only works for players</p>
         *
         * @param keepInventory Whether to keep the inventory on death
         */
        void setKeepInventory(boolean keepInventory);

        /**
         * Returns whether the inventory is kept after death.
         *
         * <p>By default this is the same as the
         * {@link GameRules#KEEP_INVENTORY} gamerule.</p>
         *
         * @return Whether the inventory is kept after death.
         */
        boolean getKeepInventory();

    }
}
