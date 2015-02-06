/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.text.action;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;

/**
 * Represents a {@link TextAction} that responds to hovers.
 *
 * @param <R> The type of the result of the action
 */
public abstract class HoverAction<R> extends TextAction<R> {

    /**
     * Constructs a new {@link HoverAction} with the given result.
     *
     * @param result The result of the hover action
     */
    protected HoverAction(R result) {
        super(result);
    }

    /**
     * Shows some text.
     */
    public static final class ShowText extends HoverAction<Text> {

        /**
         * Constructs a new {@link ShowText} instance that will show text when
         * it is hovered.
         *
         * @param text The message to show
         */
        public ShowText(Text text) {
            super(text);
        }
    }

    /**
     * Shows information about an item.
     */
    public static final class ShowItem extends HoverAction<ItemStack> {

        /**
         * Constructs a new {@link ShowItem} instance that will show information
         * about an item when it is hovered.
         *
         * @param item The item to display
         */
        public ShowItem(ItemStack item) {
            super(item);
        }

    }

    /**
     * Shows information about an achievement.
     */
    // TODO: Replace with achievement
    public static final class ShowAchievement extends HoverAction<Object> {

        /**
         * Constructs a new {@link ShowAchievement} instance that will show
         * information about an achievement when it is hovered.
         *
         * @param achievement The achievement to display
         */
        public ShowAchievement(Object achievement) {
            super(achievement);
        }

    }

    /**
     * Shows information about an entity.
     */
    public static final class ShowEntity extends HoverAction<Entity> {

        /**
         * Constructs a new {@link ShowEntity} that will show information about
         * an entity when it is hovered.
         *
         * @param entity The entity to display
         */
        public ShowEntity(Entity entity) {
            super(entity);
        }

    }

}
