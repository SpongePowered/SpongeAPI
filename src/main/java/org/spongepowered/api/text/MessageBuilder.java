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
package org.spongepowered.api.text;

import org.spongepowered.api.entity.Player;
import org.spongepowered.api.item.Item;
import org.spongepowered.api.util.Builder;

import java.net.URL;

import javax.annotation.Nullable;

/**
 * Builder for easily creating messages.
 */
public interface MessageBuilder extends Builder<MessageBuilder, TextMessage> {

    /**
     * Appends a message to this builder.
     * 
     * @param text Text to append
     * @param formats Text format
     * @return This instance
     */
    MessageBuilder appendString(String text, TextFormatting... formats);

    /**
     * Appends a message with an event to this builder. Can be either click or
     * hover.
     * 
     * @param display The display text
     * @param action The action
     * @param value The action value
     * @param formats The formatting
     * @return This instance.
     */
    MessageBuilder appendAction(String display, TextAction action, String value, TextFormatting... formats);

    /**
     * Appends a message with both a click and hover event to this builder.
     * 
     * @param display The display text
     * @param clickEvent The click event
     * @param clickValue The click event value
     * @param hoverEvent The hover event
     * @param hoverValue The hover event value
     * @param formats The formatting
     * @return This instance
     */
    MessageBuilder appendAction(String display, TextAction clickEvent, String clickValue, TextAction hoverEvent, String hoverValue,
            TextFormatting... formats);

    /**
     * Appends a message with a link to this builder. Same thing as
     * calling
     * {@code appendEvent(display, TextAction.OPEN_LINK, url.toString(), formats);}
     * <p>
     * file:// protocols are not allowed.
     * </p>
     * 
     * @param display The display text
     * @param url The URL of the link
     * @param formats The formatting
     * @return This instance
     */
    MessageBuilder appendLink(String display, URL url, TextFormatting... formats);

    /**
     * Appends a run_command click action to this builder. Same thing as calling
     * {@code appendEvent(display, TextAction.RUN_COMMAND, command, formats);}.
     * 
     * @param display The display text
     * @param command The command to run
     * @param formats THe formatting
     * @return This instance
     */
    MessageBuilder appendCommandRun(String display, String command, TextFormatting... formats);

    /**
     * Appends a suggest_command click action to this builder. Same thing as calling
     * {@code appendEvent(display, TextAction.SUGGEST_COMMAND, command, formats);}.
     * 
     * @param display The display text
     * @param command The command to suggest
     * @param formats THe formatting
     * @return This instance
     */
    MessageBuilder appendCommandSuggestion(String display, String command, TextFormatting... formats);

    /**
     * Appends a message with hover text to this builder. Same thing as calling
     * {@code appendAction(display, TextAction.SHOW_TEXT, hover, formats)}.
     * 
     * @param display The display text
     * @param hover The hover text
     * @param formats The formatting
     * @return This instance
     */
    MessageBuilder appendHoverText(String display, String hover, TextFormatting... formats);

    /**
     * Appends an achievement hover event to this builder. Same thing as calling
     * {@code appendAction(display, TextAction.SHOW_ACHIEVEMENT, achievement, formats);}.
     * 
     * TODO Add Achievement class
     * 
     * @param display The display text
     * @param achivement The achievement to display
     * @param formats The formatting
     * @return This instance
     */
    MessageBuilder appendAchivement(String display, String achivement, TextFormatting... formats);

    /**
     * Appends an item hover event to this builder. Same thing as calling
     * {@code appendAction(display, TextAction.SHOW_ITEM, item.getID(), formats);}.
     * 
     * @param display The display text
     * @param item The item to display
     * @param formats The formatting
     * @return This instance
     */
    MessageBuilder appendItem(String display, Item item, TextFormatting... formats);
    /**
     * Appends a translated message to this builder.
     * 
     * @param tranlation The translation string
     * @param params The translation parameters
     * @param formats The formatting
     * @return This instance
     */
    MessageBuilder appendTranslation(String tranlation, @Nullable String[] params, TextFormatting... formats);

    /**
     * Appends a player's score to this builder.
     * 
     * @param player The player
     * @param score The score identifier
     * @param formats The formatting
     * @return
     */
    MessageBuilder appendScore(Player player, String score, TextFormatting... formats);

    /**
     * Appends a selector message to this builder.
     * 
     * @param selector The selector text
     * @param formats The formatting
     * @return This instance
     */
    MessageBuilder appendSelector(String selector, TextFormatting... formats);

}
