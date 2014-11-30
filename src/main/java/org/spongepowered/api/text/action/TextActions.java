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
 * Utility methods to create instances of {@link TextAction}s.
 */
public final class TextActions {

    private static final TextActionFactory factory = null;

    private TextActions() {
    }

    /**
     * Creates a new {@link ClickAction} that will ask the player to open an URL
     * when it is clicked.
     *
     * @param url The URL to open
     * @return The created click action instance
     */
    public static ClickAction.OpenUrl openUrl(URL url) {
        return factory.createOpenUrl(url);
    }

    /**
     * Creates a new {@link ClickAction} that will type a command on the client
     * when it is clicked.
     *
     * @param command The command to execute
     * @return The created click action instance
     */
    public static ClickAction.RunCommand runCommand(String command) {
        return factory.createRunCommand(command);
    }

    /**
     * Creates a new {@link ClickAction} that will change the page in a book
     * when it is clicked.
     *
     * @param page The book page to switch to
     * @return The created click action instance
     */
    public static ClickAction.ChangePage changePage(int page) {
        return factory.createChangePage(page);
    }

    /**
     * Creates a new {@link ClickAction} that will suggest the player a command
     * when it is clicked.
     *
     * @param command The command to suggest
     * @return The created click action instance
     */
    public static ClickAction.SuggestCommand suggestCommand(String command) {
        return factory.createSuggestCommand(command);
    }

    /**
     * Creates a new {@link HoverAction} that will show a text on the client
     * when it is hovered.
     *
     * @param text The text to display
     * @return The created hover action instance
     */
    public static HoverAction.ShowText showText(Message<?> text) {
        return factory.createShowText(text);
    }

    /**
     * Creates a new {@link HoverAction} that will show information about an
     * item when it is hovered.
     *
     * @param item The item to display
     * @return The created hover action instance
     */
    public static HoverAction.ShowItem showItem(ItemStack item) {
        return factory.createShowItem(item);
    }

    /**
     * Creates a new {@link HoverAction} that will show information about an
     * achievement when it is hovered.
     *
     * @param achievement The achievement to display
     * @return The created hover action instance
     */
    public static HoverAction.ShowAchievement showAchievement(Object achievement) {
        return factory.createShowAchievement(achievement);
    }

    /**
     * Creates a new {@link HoverAction} that will show information about an
     * entity when it is hovered.
     *
     * @param entity The entity to display
     * @return The created hover action instance
     */
    public static HoverAction.ShowEntity showEntity(Entity entity) {
        return factory.createShowEntity(entity);
    }

    /**
     * Creates a new {@link ShiftClickAction} that will insert text at the
     * current cursor position in the chat when it is shift-clicked.
     *
     * @param text The text to insert
     * @return The created shift click action instance
     */
    public static ShiftClickAction.InsertText insertText(String text) {
        return factory.createInsertText(text);
    }

}
