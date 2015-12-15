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
package org.spongepowered.api.item.inventory;

import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.transaction.InventoryTransactionResult;
import org.spongepowered.api.text.translation.FixedTranslation;
import org.spongepowered.api.text.translation.Translation;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Optional;

/**
 * An EmptyInventory is an {@link Inventory} with exactly zero slots, no children and
 * a guarantee that all queries will only every return an EmptyInventory.
 */
public class EmptyInventory implements Inventory {
    private static FixedTranslation TRANSLATION_EMPTY = new FixedTranslation("empty");

    @Override
    public ItemStack poll() {
        return ItemStackSnapshot.NONE.createStack();
    }

    @Override
    public ItemStack poll(int limit) {
        return ItemStackSnapshot.NONE.createStack();
    }

    @Override
    public ItemStack peek() {
        return ItemStackSnapshot.NONE.createStack();
    }

    @Override
    public ItemStack peek(int limit) {
        return ItemStackSnapshot.NONE.createStack();
    }

    @Override
    public InventoryTransactionResult offer(ItemStack stack) {
        return InventoryTransactionResult.failNoTransactions();
    }

    @Override
    public InventoryTransactionResult set(ItemStack stack) {
        return InventoryTransactionResult.failNoTransactions();
    }

    @Override
    public void clear() {
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int capacity() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean contains(ItemStack stack) {
        return false;
    }

    @Override
    public boolean contains(ItemType type) {
        return false;
    }

    @Override
    public int getMaxStackSize() {
        return 0;
    }

    @Override
    public void setMaxStackSize(int size) {

    }

    @Override
    public <T extends InventoryProperty<?, ?>> Collection<T> getProperties(Inventory child, Class<T> property) {
        return Collections.emptyList();
    }

    @Override
    public <T extends InventoryProperty<?, ?>> Collection<T> getProperties(Class<T> property) {
        return Collections.emptyList();
    }

    @Override
    public <T extends InventoryProperty<?, ?>> Optional<T> getProperty(Inventory child, Class<T> property, Object key) {
        return Optional.empty();
    }

    @Override
    public <T extends InventoryProperty<?, ?>> Optional<T> getProperty(Class<T> property, Object key) {
        return Optional.empty();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Inventory> T query(Class<?>... types) {
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Inventory> T query(ItemType... types) {
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Inventory> T query(ItemStack... types) {
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Inventory> T query(InventoryProperty<?, ?>... props) {
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Inventory> T query(Translation... names) {
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Inventory> T query(String... names) {
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Inventory> T query(Object... args) {
        return (T) this;
    }

    @Override
    public Iterator<Inventory> iterator() {
        return Collections.emptyIterator();
    }

    @Override
    public Translation getName() {
        return TRANSLATION_EMPTY;
    }
}
