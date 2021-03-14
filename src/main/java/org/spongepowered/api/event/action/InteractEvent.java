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
package org.spongepowered.api.event.action;

import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.data.type.HandType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.event.EventContextKeys;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.Optional;

/**
 * Base event for all interactions.
 */
public interface InteractEvent extends Event {
    /**
     * Gets the fake {@link Player} who performed interaction.
     *
     * @return Fake player performing interaction
     */
    default Optional<Player> fakePlayer() {
        return this.getContext().get(EventContextKeys.FAKE_PLAYER);
    }
    
    /**
     * Gets {@link User} who performed interaction.
     *
     * @return User performing interaction
     */
    default Optional<User> user() {
        return this.getContext().get(EventContextKeys.CREATOR);
    }
    
    default Optional<ItemStackSnapshot> usedItem() {
        return this.getContext().get(EventContextKeys.USED_ITEM);
    }
    
    /**
     * Gets the {@link HandType} used to interact.
     *
     * @return The hand used to interact
     */
    default HandType handType() {
        return this.getContext()
                .get(EventContextKeys.USED_HAND)
                .orElseThrow(() -> new IllegalStateException("used hand in interact event is not present"));
    }
    
    /**
     * Gets the {@link BlockSnapshot} player interacts with.
     *
     * @return The BlockSnapshot with which the interaction was performed
     */
    default Optional<BlockSnapshot> hitBlock() {
        return this.getContext().get(EventContextKeys.BLOCK_HIT);
    }
    
    /**
     * Gets the {@link Entity} player interacts with.
     *
     * @return The Entity with which the interaction was performed
     */
    default Optional<Entity> hitEntity() {
        return this.getContext().get(EventContextKeys.ENTITY_HIT);
    }
}
