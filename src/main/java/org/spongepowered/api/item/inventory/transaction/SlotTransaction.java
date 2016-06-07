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
package org.spongepowered.api.item.inventory.transaction;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.data.Transaction;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.item.inventory.Slot;

public final class SlotTransaction extends Transaction<ItemStackSnapshot> {
    
    private final Slot slot;

    public SlotTransaction(Slot slot, ItemStackSnapshot original, ItemStackSnapshot defaultReplacement) {
        super(original, defaultReplacement);
        this.slot = checkNotNull(slot, "Slot cannot be null!");
    }

    public final void setCustom(ItemStack stack) {
        setCustom(checkNotNull(stack, "ItemStack was null").createSnapshot());
    }

    public final Slot getSlot() {
        return this.slot;
    }

    @Override public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("slot", this.slot)
                .add("original", getOriginal())
                .add("default", getDefault())
                .add("custom", getCustom())
                .add("valid", isValid())
                .toString();
    }
    
}
