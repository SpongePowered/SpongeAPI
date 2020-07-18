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
package org.spongepowered.api.block.entity.carrier.chest;

import org.spongepowered.api.block.entity.carrier.NameableCarrierBlockEntity;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.type.ChestAttachmentType;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.item.inventory.Inventory;

import java.util.Optional;

/**
 * Represents a Chest.
 */
public interface Chest extends NameableCarrierBlockEntity {

    /**
     * Returns the inventory representing the combination of this chest
     * and its neighbor (which form a double chest), if available.
     *
     * <p>If this chest is not part of a double chest, then this method
     * will return {@link Optional#empty()}.</p>
     *
     * @return The combined inventory, if available
     */
    Optional<Inventory> getDoubleChestInventory();

    /**
     * Returns the connected {@link Chest}, if available.
     *
     * <p>If this chest is not part of a double chest, then this method
     * will return {@link Optional#empty()}.</p>
     *
     * @return The connected {@link Chest}, if available
     */
    Optional<Chest> getConnectedChest();

    /**
     * {@link Keys#CHEST_ATTACHMENT_TYPE}
     * @return The attachment type of this chest.
     */
    default Value.Mutable<ChestAttachmentType> attachmentType() {
        return this.requireValue(Keys.CHEST_ATTACHMENT_TYPE).asMutable();
    }

}
