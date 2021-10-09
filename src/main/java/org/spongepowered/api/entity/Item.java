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
package org.spongepowered.api.entity;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.Ticks;

/**
 * Represents an Item.
 */
public interface Item extends Entity {

    /**
     * {@link Keys#ITEM_STACK_SNAPSHOT}
     *
     * @return The item being represented by this entity
     */
    default Value.Mutable<ItemStackSnapshot> item() {
        return this.requireValue(Keys.ITEM_STACK_SNAPSHOT).asMutable();
    }

    /**
     * {@link Keys#DESPAWN_DELAY}
     *
     * @return The despawn delay (in ticks) of the item
     */
    default Value.Mutable<Ticks> despawnDelay() {
        return this.requireValue(Keys.DESPAWN_DELAY).asMutable();
    }

    /**
     * {@link Keys#INFINITE_DESPAWN_DELAY}
     *
     * @return Whether the item will not despawn for an infinite time
     */
    default Value.Mutable<Boolean> infiniteDespawnDelay() {
        return this.requireValue(Keys.INFINITE_DESPAWN_DELAY).asMutable();
    }

    /**
     * {@link Keys#INFINITE_PICKUP_DELAY}
     *
     * @return Whether the item has an infinite pickup delay
     */
    default Value.Mutable<Boolean> infinitePickupDelay() {
        return this.requireValue(Keys.INFINITE_PICKUP_DELAY).asMutable();
    }

    /**
     * {@link Keys#PICKUP_DELAY}
     *
     * @return The pickup delay (in ticks) of the item
     */
    default Value.Mutable<Ticks> pickupDelay() {
        return this.requireValue(Keys.PICKUP_DELAY).asMutable();
    }
}
