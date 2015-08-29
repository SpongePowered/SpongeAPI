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
package org.spongepowered.api.event.inventory;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.EntitySnapshot;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;
import org.spongepowered.api.event.cause.CauseTracked;
import org.spongepowered.api.event.block.BlockEvent;
import org.spongepowered.api.event.entity.EntityEvent;
import org.spongepowered.api.event.entity.living.LivingEvent;
import org.spongepowered.api.event.entity.living.human.HumanEvent;
import org.spongepowered.api.event.entity.living.player.PlayerEvent;
import org.spongepowered.api.event.entity.AffectEntityEvent;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.ItemStackTransaction;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import java.util.List;

/**
 * Handles when any {@link ItemStack}(s) is/are about to be "dropped" onto
 * the ground. This will happen before they are physically dropped, in which
 * case before an {@link Item} entity is actually constructed, let alone
 * spawned.
 */
public interface DropItemStackEvent extends GameEvent, CauseTracked, Cancellable {

    interface Pre extends DropItemStackEvent {

        /**
         * Gets the list of {@link ItemStackSnapshot}s to be dropped.
         *
         * @return The list of itemstack transactions
         */
        ImmutableList<ItemStackSnapshot> getDefaultDroppedItems();

        /**
         * Gets the list of {@link ItemStackTransaction}s of the {@link ItemStack}s
         * that will be dropped, if {@link ItemStackTransaction#isValid()} returns
         * <code>true</code>. If the transaction returns <code>false</code>, the
         * {@link ItemStackTransaction#getFinalSnapshot()} will not be dropped as
         * an {@link Item} after this event.
         *
         * @return The customized list of item stacks to drop
         */
        ImmutableList<ItemStackTransaction> getDroppedItems();

        /**
         * Adds the provided {@link ItemStackSnapshot} to the list of dropped
         * {@link ItemStackTransaction}s in {@link #getDroppedItems()}.
         *
         * @param itemStackSnapshot The item stack snapshot to add
         */
        void addItem(ItemStackSnapshot itemStackSnapshot);

        /**
         * Applies a {@link Predicate} on the {@link ItemStackSnapshot}s such that
         * any {@link ItemStackSnapshot} that when {@link Predicate#apply(Object)}
         * returns <code>false</code>, the owning {@link ItemStackTransaction} is
         * marked as "invalid".
         *
         * @param predicate The predicate to apply to the list
         */
        void filter(Predicate<ItemStackSnapshot> predicate);

        interface SourceBlock extends Pre, DropItemStackEvent.SourceBlock { }

        interface SourceEntity extends Pre, DropItemStackEvent.SourceEntity { }

        interface SourceLiving extends SourceEntity, DropItemStackEvent.SourceLiving { }

        interface SourceHuman extends SourceLiving, DropItemStackEvent.SourceHuman { }

        interface SourcePlayer extends SourceHuman, DropItemStackEvent.SourcePlayer { }

    }

    interface Post extends DropItemStackEvent, AffectEntityEvent {

        @Override
        ImmutableList<EntitySnapshot> getEntitySnapshots();

        @Override
        List<Item> getEntities();

        @Override
        List<Item> filterEntityLocations(Predicate<Location<World>> predicate);

        @Override
        List<Item> filterEntities(Predicate<? extends Entity> predicate);

        interface SourceBlock extends Post, DropItemStackEvent.SourceBlock { }

        interface SourceEntity extends Post, DropItemStackEvent.SourceEntity { }

        interface SourceLiving extends SourceEntity, DropItemStackEvent.SourceLiving { }

        interface SourceHuman extends SourceLiving, DropItemStackEvent.SourceHuman { }

        interface SourcePlayer extends SourceHuman, DropItemStackEvent.SourcePlayer { }
    }

    interface SourceBlock extends DropItemStackEvent, BlockEvent { }

    interface SourceEntity extends DropItemStackEvent, EntityEvent { }

    interface SourceLiving extends SourceEntity, LivingEvent { }

    interface SourceHuman extends SourceLiving, HumanEvent { }

    interface SourcePlayer extends SourceHuman, PlayerEvent { }

}
