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
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;

import java.net.URL;
import java.util.UUID;

import javax.annotation.Nullable;

/**
 * Utility methods to create instances of {@link TextAction}s.
 */
public final class TextActions {

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
        return new ClickAction.OpenUrl(url);
    }

    /**
     * Creates a new {@link ClickAction} that will type a command on the client
     * when it is clicked.
     *
     * @param command The command to execute
     * @return The created click action instance
     */
    public static ClickAction.RunCommand runCommand(String command) {
        return new ClickAction.RunCommand(command);
    }

    /**
     * Creates a new {@link ClickAction} that will change the page in a book
     * when it is clicked.
     *
     * @param page The book page to switch to
     * @return The created click action instance
     */
    public static ClickAction.ChangePage changePage(int page) {
        return new ClickAction.ChangePage(page);
    }

    /**
     * Creates a new {@link ClickAction} that will suggest the player a command
     * when it is clicked.
     *
     * @param command The command to suggest
     * @return The created click action instance
     */
    public static ClickAction.SuggestCommand suggestCommand(String command) {
        return new ClickAction.SuggestCommand(command);
    }

    /**
     * Creates a new {@link HoverAction} that will show a text on the client
     * when it is hovered.
     *
     * @param text The text to display
     * @return The created hover action instance
     */
    public static HoverAction.ShowText showText(Text text) {
        return new HoverAction.ShowText(text);
    }

    /**
     * Creates a new {@link HoverAction} that will show information about an
     * item when it is hovered.
     *
     * @param item The item to display
     * @return The created hover action instance
     */
    public static HoverAction.ShowItem showItem(ItemStack item) {
        return new HoverAction.ShowItem(item);
    }

    /**
     * Creates a new {@link HoverAction} that will show information about an
     * achievement when it is hovered.
     *
     * @param achievement The achievement to display
     * @return The created hover action instance
     */
    public static HoverAction.ShowAchievement showAchievement(Object achievement) {
        return new HoverAction.ShowAchievement(achievement);
    }

    /**
     * Creates a new {@link HoverAction} that will show information about an
     * entity when it is hovered.
     *
     * @param entity The entity to display
     * @return The created hover action instance
     */
    public static HoverAction.ShowEntity showEntity(HoverAction.ShowEntity.Ref entity) {
        return new HoverAction.ShowEntity(entity);
    }

    /**
     * Creates a new {@link HoverAction} that will show information about an
     * entity when it is hovered.
     *
     * @param uuid The UUID of the entity
     * @param name The name of the entity
     * @param type The type of the entity
     * @return The created hover action instance
     */
    public static HoverAction.ShowEntity showEntity(UUID uuid, String name, @Nullable EntityType type) {
        return showEntity(new HoverAction.ShowEntity.Ref(uuid, name, type));
    }

    /**
     * Creates a new {@link HoverAction} that will show information about an
     * entity when it is hovered.
     *
     * @param uuid The UUID of the entity
     * @param name The name of the entity
     * @return The created hover action instance
     */
    public static HoverAction.ShowEntity showEntity(UUID uuid, String name) {
        return showEntity(new HoverAction.ShowEntity.Ref(uuid, name));
    }

    /**
     * Creates a new {@link HoverAction} that will show information about an
     * entity when it is hovered.
     *
     * @param entity The entity
     * @param name The name of the entity
     * @return The created hover action instance
     */
    public static HoverAction.ShowEntity showEntity(Entity entity, String name) {
        return showEntity(new HoverAction.ShowEntity.Ref(entity, name));
    }

    /**
     * Creates a new {@link ShiftClickAction} that will insert text at the
     * current cursor position in the chat when it is shift-clicked.
     *
     * @param text The text to insert
     * @return The created shift click action instance
     */
    public static ShiftClickAction.InsertText insertText(String text) {
        return new ShiftClickAction.InsertText(text);
    }

}
