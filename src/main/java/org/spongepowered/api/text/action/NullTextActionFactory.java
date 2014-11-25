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
import org.spongepowered.api.text.message.Message;

import java.net.URL;

/**
 * Dummy implementation of {@link TextActionFactory} - returns null for all
 * methods.
 */
class NullTextActionFactory implements TextActionFactory {

    @Override
    public ClickAction.OpenUrl createOpenUrl(URL url) {
        return null;
    }

    @Override
    public ClickAction.RunCommand createRunCommand(String command) {
        return null;
    }

    @Override
    public ClickAction.ChangePage createChangePage(int page) {
        return null;
    }

    @Override
    public ClickAction.SuggestCommand createSuggestCommand(String command) {
        return null;
    }

    @Override
    public HoverAction.ShowText createShowText(Message<?> text) {
        return null;
    }

    @Override
    public HoverAction.ShowItem createShowItem(ItemStack item) {
        return null;
    }

    @Override
    public HoverAction.ShowAchievement createShowAchievement(Object achievement) {
        return null;
    }

    @Override
    public HoverAction.ShowEntity createShowEntity(Entity entity) {
        return null;
    }

    @Override
    public ShiftClickAction.InsertText createInsertText(String text) {
        return null;
    }

}
