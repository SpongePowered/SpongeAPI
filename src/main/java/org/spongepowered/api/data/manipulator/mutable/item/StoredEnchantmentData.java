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
package org.spongepowered.api.data.manipulator.mutable.item;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.immutable.item.ImmutableStoredEnchantmentData;
import org.spongepowered.api.data.manipulator.mutable.ListData;
import org.spongepowered.api.data.meta.ItemEnchantment;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * A {@link DataManipulator} handling "stored" {@link ItemEnchantment}s.
 * Usually, stored {@link ItemEnchantment}s can be "transferred" to other
 * {@link ItemStack}s. Examples include {@link ItemTypes#ENCHANTED_BOOK}s
 * storing enchantments to apply to weapons.
 */
public interface StoredEnchantmentData extends ListData<ItemEnchantment, StoredEnchantmentData, ImmutableStoredEnchantmentData> {

    /**
     * Gets the {@link ListValue} of {@link ItemEnchantment}s stored such
     * that it can be applied to an {@link ItemStack}.
     *
     * @return The list value of item enchantments
     * @see Keys#STORED_ENCHANTMENTS
     */
    default ListValue<ItemEnchantment> enchantments() {
        return getListValue();
    }

}
