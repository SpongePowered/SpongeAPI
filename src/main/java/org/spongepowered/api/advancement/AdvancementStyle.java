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
package org.spongepowered.api.advancement;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * Some that has a style within a advancement tree. Either an
 * {@link AdvancementTree} or an {@link Advancement}.
 */
public interface AdvancementStyle extends CatalogType, TextRepresentable {

    /**
     * Gets the description.
     *
     * @return The description
     */
    Text getDescription();

    /**
     * Gets the icon.
     *
     * @return The icon
     */
    ItemStackSnapshot getIcon();

    /**
     * Gets the {@link AdvancementType} that should be
     * used for the frame around the icon.
     *
     * @return The frame type
     */
    AdvancementType getFrameType();

    /**
     * Gets the title.
     *
     * @return The title
     */
    Text getTitle();

    /**
     * The base interface to create {@link AdvancementStyle} objects.
     */
    interface Builder<T extends AdvancementStyle, B extends Builder<T, B>> extends ResettableBuilder<T, B> {

        /**
         * Sets the description. Defaults to {@link Text#EMPTY}.
         *
         * @param description The description
         * @return This builder, for chaining
         */
        B description(Text description);

        /**
         * Sets the title.
         *
         * @param title The title
         * @return This builder, for chaining
         */
        B title(Text title);

        /**
         * Sets the {@link AdvancementType} that should be
         * used for the frame around the icon.
         * <p>
         * Defaults to {@link AdvancementTypes#TASK}.
         *
         * @param frameType The frame type
         * @return This builder, for chaining
         */
        B frameType(AdvancementType frameType);

        /**
         * Sets the icon of the advancement with the
         * specified {@link ItemType}.
         *
         * @param itemType The item type
         * @return This builder, for chaining
         */
        default B icon(ItemType itemType) {
            return icon(ItemStack.of(itemType, 1));
        }

        /**
         * Sets the icon of the advancement with the
         * specified {@link ItemStack}.
         *
         * @param itemStack The item stack
         * @return This builder, for chaining
         */
        default B icon(ItemStack itemStack) {
            return icon(itemStack.createSnapshot());
        }

        /**
         * Sets the icon of the advancement with the
         * specified {@link ItemStackSnapshot}.
         *
         * @param itemStackSnapshot The item stack snapshot
         * @return This builder, for chaining
         */
        B icon(ItemStackSnapshot itemStackSnapshot);

        /**
         * Sets the icon of the advancement with the
         * specified {@link BlockType}.
         *
         * @param blockType The block type
         * @return This builder, for chaining
         */
        default B icon(BlockType blockType) {
            return icon(blockType.getDefaultState());
        }

        /**
         * Sets the icon of the advancement with the
         * specified {@link BlockState}.
         *
         * @param blockState The block state
         * @return This builder, for chaining
         */
        B icon(BlockState blockState);
    }
}
