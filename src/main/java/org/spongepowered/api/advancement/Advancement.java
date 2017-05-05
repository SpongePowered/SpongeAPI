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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.advancement.criteria.AdvancementCriterion;

import java.util.List;
import java.util.Optional;

/**
 * An advancement.
 */
public interface Advancement extends AdvancementStyle {

    /**
     * Creates a new {@link Builder} to create {@link Advancement}s.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link AdvancementType}.
     *
     * @return The advancement type
     */
    AdvancementType getType();

    /**
     * Gets all the children {@link Advancement}s.
     *
     * @return The children advancements
     */
    List<Advancement> getChildren();

    /**
     * Gets all the {@link AdvancementCriterion} that should be achieved
     * before this advancement is unlocked. {@link AdvancementCriterion#EMPTY}
     * will be returned if no criterion was assigned.
     * <p>
     * This {@link AdvancementCriterion} can be a AND or OR operation that
     * contains multiple possible {@link AdvancementCriterion}s.
     *
     * @return The criterion
     */
    AdvancementCriterion getCriterion();

    /**
     * Gets the parent {@link Advancement} if present.
     *
     * @return The parent advancement, if present
     */
    Optional<Advancement> getParent();

    /**
     * Gets whether a toast should be shown. This is the notification
     * that will be displayed in the top right corner.
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
     * <p>
     * Hidden advancements will only appear in the tree once they
     * are unlocked. The lines that connect them to other advancements
     * are still present.
     *
     * @return Is hidden
     */
    boolean isHidden();

    /**
     * A builder to create {@link Advancement}s.
     */
    interface Builder extends AdvancementStyle.Builder<Advancement, Builder> {

        /**
         * Sets the parent {@link Advancement}.
         *
         * @param parent The parent advancement
         * @return This builder, for chaining
         */
        Builder parent(Advancement parent);

        /**
         * Sets the {@link AdvancementType}.
         *
         * @param frameType The frame type
         * @return This builder, for chaining
         */
        Builder type(AdvancementType frameType);

        /**
         * Sets the {@link AdvancementType} that should be
         * used for the frame around the icon.
         * <p>
         * Defaults to the {@link AdvancementType} provided
         * by {@link #type(AdvancementType)}.
         *
         * @param frameType The frame type
         * @return This builder, for chaining
         */
        @Override
        Builder frameType(AdvancementType frameType);

        /**
         * Sets the {@link AdvancementCriterion} that should be used
         * for the advancement. Defaults to {@link AdvancementCriterion#EMPTY}.
         *
         * @param criterion The criterion
         * @return This builder, for chaining
         */
        Builder criterion(AdvancementCriterion criterion);

        /**
         * Sets whether a toast should be shown. This is the notification
         * that will be displayed in the top right corner.
         * <p>
         * Defaults to {@code true}.
         *
         * @param showToast Whether a toast should be shown
         * @return This builder, for chaining
         */
        Builder showToast(boolean showToast);

        /**
         * Sets whether a notification should be shown in the global chat.
         * <p>
         * Defaults to {@code true}.
         *
         * @param announceToChat Whether a notification should be shown in the chat
         * @return This builder, for chaining
         */
        Builder announceToChat(boolean announceToChat);

        /**
         * Sets whether the {@link Advancement} should be hidden.
         * <p>
         * Hidden advancements will only appear in the tree once they
         * are unlocked. The lines that connect them to other advancements
         * are still present.
         *
         * @param hidden Is hidden
         * @return This builder, for chaining
         */
        Builder hidden(boolean hidden);

        /**
         * Builds the {@link Advancement} with the specified
         * plugin id and id.
         *
         * @param pluginId The plugin id
         * @param id The id
         * @return The advancement
         */
        Advancement build(String pluginId, String id);
    }
}
