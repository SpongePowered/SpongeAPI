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
import org.spongepowered.api.text.Message;

public class HoverAction<R> extends TextAction<R> {

    HoverAction(String id, R result) {
        super(id, result);
    }

    public static class ShowText extends HoverAction<Message<?>> {

        ShowText(Message<?> result) {
            super("show_text", result);
        }
    }

    public static class ShowItem extends HoverAction<ItemStack> {

        ShowItem(ItemStack result) {
            super("show_item", result);
        }

    }

    // TODO replace with achievement
    public static class ShowAchievement extends HoverAction<Object> {

        ShowAchievement(Object result) {
            super("show_achievement", result);
        }

    }

    public static class ShowEntity extends HoverAction<Entity> {

        ShowEntity(Entity result) {
            super("show_entity", result);
        }


        // TODO keep this just for reference, but should use entity?
        /*
        interface ShowActionEntity {

            String getName();

            String getType();

            UUID getID();

        }*/

    }

}
