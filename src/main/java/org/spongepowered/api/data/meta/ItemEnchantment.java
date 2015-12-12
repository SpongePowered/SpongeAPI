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
package org.spongepowered.api.data.meta;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.MemoryDataContainer;
import org.spongepowered.api.data.Queries;
import org.spongepowered.api.item.Enchantment;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Represents an {@link Enchantment} for an {@link ItemStack} such that the pair
 * is created for an item. The contract of item enchantments is that the
 * {@link Enchantment}'s {@link #getLevel()} can never be lower than 0.
 */
public final class ItemEnchantment implements DataSerializable {

    private final Enchantment enchantment;
    private final int level;

    /**
     * Creates a new {@link ItemEnchantment} with the provided
     * {@link Enchantment} and level.
     *
     * @param enchantment The enchantment
     * @param level The level to pass in
     */
    public ItemEnchantment(Enchantment enchantment, int level) {
        this.enchantment = checkNotNull(enchantment);
        checkArgument(level >= 0);
        this.level = level;
    }

    /**
     * Gets the {@link Enchantment} for this {@link ItemEnchantment}.
     *
     * @return The enchantment
     */
    public Enchantment getEnchantment() {
        return this.enchantment;
    }

    /**
     * Gets the level for this {@link ItemEnchantment}.
     *
     * @return The level of the enchantment
     */
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getContentVersion() {
        return 1;
    }

    @Override
    public DataContainer toContainer() {
        return new MemoryDataContainer()
                .set(Queries.CONTENT_VERSION, getContentVersion())
                .set(Queries.ENCHANTMENT_ID, this.enchantment.getId())
                .set(Queries.LEVEL, this.level);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.enchantment, this.level);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ItemEnchantment other = (ItemEnchantment) obj;
        return Objects.equal(this.enchantment, other.enchantment)
                && Objects.equal(this.level, other.level);
    }
}
