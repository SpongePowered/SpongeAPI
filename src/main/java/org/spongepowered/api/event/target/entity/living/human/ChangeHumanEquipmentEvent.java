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
package org.spongepowered.api.event.target.entity.living.human;

import com.google.common.base.Optional;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.source.entity.living.human.HumanEvent;
import org.spongepowered.api.event.target.entity.living.ChangeLivingEquipmentEvent;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackTransaction;
import org.spongepowered.api.item.inventory.Slot;

/**
 * Called when an entity changes an equipped item. This can occur whenever
 * a {@link Slot} belonging to an {@link Inventory} of an {@link Entity}
 * is filled with an {@link ItemStack}, emptied of an {@link ItemStack},
 * or swapped with an {@link ItemStack}. The requirement of course is
 * that if the {@link #getOriginalItem()} is {@link Optional#absent()}, then
 * the {@link #getNewItemStack()} must be present, and vice versa. In the event
 * that a change to the suggested {@link ItemStack}, the use of the
 * {@link ItemStackTransaction} is recommended.
 */
public interface ChangeHumanEquipmentEvent extends HumanEvent, ChangeLivingEquipmentEvent {

}
