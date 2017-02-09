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
package org.spongepowered.api;

import com.google.common.collect.SetMultimap;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.Set;

/**
 * A GameDictionary is a store of {@link org.spongepowered.api.GameDictionary.Entry}s.
 *
 * <p>Note that the GameDictionary's keys are different from Minecraft item ids.
 * Minecraft item IDs are namespaces, e.g. minecraft:carrot while ItemDictionary
 * keys are not, by design(e.g. carrot). This is mainly to keep supporting the
 * existing Forge 'ore dictionary'.</p>
 */
public interface GameDictionary {

    /**
     * Registers an {@link org.spongepowered.api.GameDictionary.Entry}
     * in the dictionary with a String key. The stack size is ignored.
     *
     * @param key The key of the item as a String
     * @param entry The item to register
     */
    void register(String key, Entry entry);

    /**
     * Retrieves the entries registered for the given key. The stack sizes are
     * set to 1.
     *
     * @param key The key of the entries as a String
     * @return The entries registered for the given key
     */
    Set<Entry> get(String key);

    /**
     * Retrieves all entries registered in this game dictionary, mapped by their
     * key.
     *
     * @return A map of all entries registered
     */
    SetMultimap<String, Entry> getAll();

    interface Entry {

        /**
         * Returns the type of item contained by this entry.
         *
         * @return The item type
         */
        ItemType getType();

        /**
         * Tests whether the provided item stack matches this entry's
         * specifications.
         *
         * @param stack The item stack to test
         * @return {@code true} if the stack matches this entry
         */
        boolean matches(ItemStack stack);

        /**
         * Returns whether this entry checks against the item type and extra
         * data associated with the stack. If this returns {@code true}, any
         * {@link ItemStack} whose {@link ItemType} and manipulators match
         * those of the {@linkplain #getTemplate() template} will {@linkplain
         * #matches(ItemStack) match} this entry; however, not all manipulators
         * present in the template are required to match those in the item
         * stack to cause them to match. If this returns {@code false}, any
         * item stack whose {@link ItemType} matches that of the entry will
         * match this entry.
         *
         * @return {@code true} if the entry checks extra data on the stack
         */
        boolean isSpecific();

        /**
         * Returns an item stack snapshot for plugins to inspect this entry.
         * The returned snapshot will {@linkplain #matches(ItemStack) match}
         * this entry. The size of the snapshot will always be 1.
         *
         * @return A snapshot that matches this entry
         */
        ItemStackSnapshot getTemplate();
    }

}
