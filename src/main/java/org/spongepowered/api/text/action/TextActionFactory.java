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

import java.net.URL;

/**
 * Represents the required implementation for the static methods in
 * {@link TextActions}.
 */
interface TextActionFactory {

    /**
     * Creates a new {@link ClickAction.OpenUrl} instance that will ask the
     * player to open an URL when it is clicked.
     *
     * @param url The url to open
     * @return The created click action instance
     */
    ClickAction.OpenUrl createOpenUrl(URL url);

    /**
     * Creates a new {@link ClickAction.RunCommand} instance that will run a
     * command on the client when it is clicked.
     *
     * @param command The command to execute
     * @return The created click action instance
     */
    ClickAction.RunCommand createRunCommand(String command);

    /**
     * Creates a new {@link ClickAction.ChangePage} instance that will change
     * the page in a book when it is clicked.
     *
     * @param page The book page to switch to
     * @return The created click action instance
     */
    ClickAction.ChangePage createChangePage(int page);

    /**
     * Creates a new {@link ClickAction.SuggestCommand} instance that will
     * suggest the player a command when it is clicked.
     *
     * @param command The command to suggest
     * @return The created click action instance
     */
    ClickAction.SuggestCommand createSuggestCommand(String command);

    /**
     * Creates a new
     * {@link org.spongepowered.api.text.action.HoverAction.ShowText} instance
     * that will show text when it is hovered.
     *
     * @param text The message to show
     * @return The created hover action instance
     */
    HoverAction.ShowText createShowText(Text text);

    /**
     * Creates a new {@link HoverAction.ShowItem} instance that will show
     * information about an item when it is hovered.
     *
     * @param item The item to display
     * @return The created hover action instance
     */
    HoverAction.ShowItem createShowItem(ItemStack item);

    /**
     * Creates a new {@link HoverAction.ShowItem} instance that will show
     * information about an achievement when it is hovered.
     *
     * @param achievement The achievement to display
     * @return The created hover action instance
     */
    HoverAction.ShowAchievement createShowAchievement(Object achievement);

    /**
     * Creates a new {@link HoverAction} that will show information about an
     * entity when it is hovered.
     *
     * @param entity The entity to display
     * @return The created hover action instance
     */
    HoverAction.ShowEntity createShowEntity(Entity entity);

    /**
     * Creates a new {@link ShiftClickAction} instance that will insert text at
     * the current cursor position in the chat when it is shift-clicked.
     *
     * @param text The text to insert
     * @return The created shift-click action instance
     */
    ShiftClickAction.InsertText createInsertText(String text);

}
