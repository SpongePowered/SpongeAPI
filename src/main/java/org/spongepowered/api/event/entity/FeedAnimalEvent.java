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

import org.spongepowered.api.entity.living.animal.Animal;
import org.spongepowered.api.entity.living.animal.Wolf;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;

/**
 * Fired when a {@link Player} feeds an {@link Animal}.
 */
@GenerateFactoryMethod
public interface FeedAnimalEvent extends InteractEntityEvent {

    /**
     * Gets a snapshot of the {@link ItemStack} fed to the {@link Animal} before it is used.
     *
     * @return A snapshot of the item fed.
     */
    ItemStackSnapshot getItem();

    /**
     * Fired when an adult {@link Animal} is fed with a breeding item leading to it being set in love.
     * This can be the case from attempting to breed animals, and from ocelots being fed fish.
     */
    interface Love extends FeedAnimalEvent {}

    /**
     * Fired when a passive, tameable {@link Animal} is fed, leading to there being a chance of it being tamed.
     */
    interface Taming extends FeedAnimalEvent {}

    /**
     * Fired when an {@link Animal} is fed with food which heals it.
     */
    interface Healing extends FeedAnimalEvent {}

    /**
     * Fired when a child {@link Animal} is fed with a breeding item leading to it aging.
     */
    interface Aging extends FeedAnimalEvent {}

}
