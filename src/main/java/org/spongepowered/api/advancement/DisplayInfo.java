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

import net.kyori.adventure.text.Component;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.function.Supplier;

public interface DisplayInfo {

    /**
     * Creates a new {@link Builder} to create {@link DisplayInfo}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the {@link AdvancementType}.
     *
     * @return The advancement type
     */
    AdvancementType getType();

    /**
     * Gets the description.
     *
     * @return The description
     */
    Component getDescription();

    /**
     * Gets the icon.
     *
     * @return The icon
     */
    ItemStackSnapshot getIcon();

    /**
     * Gets the title.
     *
     * @return The title
     */
    Component getTitle();

    /**
     * Gets whether a toast should be shown.
     *
     * <p>The toast is the notification that will be displayed
     * in the top right corner.</p>
     *
     * @return Show toast
     */
    boolean doesShowToast();

    /**
     * Gets whether a notification should be shown in the global chat.
     *
     * @return Announce to chat
     */
    boolean doesAnnounceToChat();

    /**
     * Gets whether this advancement is hidden.
     *
     * <p>Hidden advancements will only appear in the tree once they
     * are unlocked. The lines that connect them to other advancements
     * are still present.</p>
     *
     * @return Is hidden
     */
    boolean isHidden();

    /**
     * A builder to create {@link DisplayInfo}s.
     */
    interface Builder extends CopyableBuilder<DisplayInfo, Builder> {

        /**
         * Sets the {@link AdvancementType}. Defaults
         * to {@link AdvancementTypes#TASK}.
         *
         * @param advancementType The advancement type
         * @return This builder, for chaining
         */
        default Builder type(Supplier<? extends AdvancementType> advancementType) {
            return this.type(advancementType.get());
        }

        /**
         * Sets the {@link AdvancementType}. Defaults
         * to {@link AdvancementTypes#TASK}.
         *
         * @param advancementType The advancement type
         * @return This builder, for chaining
         */
        Builder type(AdvancementType advancementType);

        /**
         * Sets the description. Defaults to {@link Component#empty()}.
         *
         * @param description The description
         * @return This builder, for chaining
         */
        Builder description(Component description);

        /**
         * Sets the title.
         *
         * @param title The title
         * @return This builder, for chaining
         */
        Builder title(Component title);

        /**
         * Sets the icon of the advancement with the
         * specified {@link ItemType}.
         *
         * @param itemType The item type
         * @return This builder, for chaining
         */
        default Builder icon(Supplier<? extends ItemType> itemType) {
            return icon(itemType.get());
        }

        /**
         * Sets the icon of the advancement with the
         * specified {@link ItemType}.
         *
         * @param itemType The item type
         * @return This builder, for chaining
         */
        default Builder icon(ItemType itemType) {
            return this.icon(ItemStack.of(itemType, 1));
        }

        /**
         * Sets the icon of the advancement with the
         * specified {@link ItemStack}.
         *
         * @param itemStack The item stack
         * @return This builder, for chaining
         */
        default Builder icon(ItemStack itemStack) {
            return this.icon(itemStack.createSnapshot());
        }

        /**
         * Sets the icon of the advancement with the
         * specified {@link ItemStackSnapshot}.
         *
         * @param itemStackSnapshot The item stack snapshot
         * @return This builder, for chaining
         */
        Builder icon(ItemStackSnapshot itemStackSnapshot);

        /**
         * Sets whether a toast should be shown. This is the notification
         * that will be displayed in the top right corner.
         *
         * <p>Defaults to {@code true}.</p>
         *
         * @param showToast Whether a toast should be shown
         * @return This builder, for chaining
         */
        Builder showToast(boolean showToast);

        /**
         * Sets whether a notification should be shown in the global chat.
         *
         * <p>Defaults to {@code true}.</p>
         *
         * @param announceToChat Whether a notification should be shown in
         *     the chat
         * @return This builder, for chaining
         */
        Builder announceToChat(boolean announceToChat);

        /**
         * Sets whether the {@link Advancement} should be hidden.
         *
         * <p>Hidden advancements will only appear in the tree once they
         * are unlocked. The lines that connect them to other advancements
         * are still present.</p>
         *
         * @param hidden Is hidden
         * @return This builder, for chaining
         */
        Builder hidden(boolean hidden);

        /**
         * Builds the {@link DisplayInfo}.
         *
         * @return The display info
         */
        DisplayInfo build();

    }

}
