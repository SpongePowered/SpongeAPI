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

import java.util.Map.Entry;
import java.util.Set;

/**
 * Used to define the style of a message. Things like color, bold, and client
 * events.
 */
public interface TextStyle {

    /**
     * The color from {@link TextFormatting}.
     * 
     * @return The color
     */
    TextFormatting getColor();

    /**
     * Sets the color of this style.
     * 
     * @param color Only colors.
     * @return Itself
     */
    TextStyle setColor(TextFormatting color);

    /**
     * Gets if the text is bolded.
     * 
     * @return True if bold, false if not
     */
    boolean isBold();

    /**
     * Sets the text to be bolded.
     * 
     * @param bold Value to set
     * @return Itself
     */
    TextStyle setBold(boolean bold);

    /**
     * Gets if the text is italicized.
     * 
     * @return True if italic, false if not
     */
    boolean isItalic();

    /**
     * Sets the text to be italicized.
     * 
     * @param italic Value to set
     * @return Itself
     */
    TextStyle setItalic(boolean italic);

    /**
     * Gets if the text is underlined.
     * 
     * @return True if underlined, false if not
     */
    boolean isUnderlined();

    /**
     * Sets the text to be underlined.
     * 
     * @param underlined Value to set
     * @return Itself
     */
    TextStyle setUnderlined(boolean underlined);

    /**
     * Gets if the text is strikethrough.
     * 
     * @return True if strikethough, false if not
     */
    boolean isStrikethrough();

    /**
     * Sets the text to be strikethrough.
     * 
     * @param strikethrough Value to set
     * @return Itself
     */
    TextStyle setStrikethrough(boolean strikethrough);

    /**
     * Gets if the text is obfuscated, AKA magic.
     * 
     * @return True if obfuscated, false if not
     */
    boolean isObfuscated();

    /**
     * Sets the text to be obfuscated, AKA magic.
     * 
     * @param obfuscated Value to set
     * @return Itself
     */
    TextStyle setObfuscated(boolean obfuscated);

    /**
     * Gets the click event for this style.
     * 
     * @return The client click event.
     */
    TextClientEvent getClickEvent();

    /**
     * Sets the click event for this style.
     * 
     * @param clickEvent The client click event.
     * @return Itself
     */
    TextStyle setClickEvent(TextClientEvent clickEvent);

    /**
     * Gets the hover event used for this style.
     * 
     * @return The client hover event
     */
    TextClientEvent getHoverEvent();

    /**
     * Sets the hover event for this style.
     * 
     * @param hoverEvent The client hover event
     * @return Itself
     */
    TextStyle setHoverEvent(TextClientEvent hoverEvent);

    /**
     * Gets the text to be inserted in chat when shift clicked.
     * 
     * @return The text to be inserted
     */
    String getInsertion();

    /**
     * Sets the text to be inserted in chat when shift clicked.
     * 
     * @return This Message
     */
    TextMessage setInsertion();

    /**
     * Gets the formatted string used by the font renderer.
     * 
     * @return Formatted string
     */
    String getFormatCodes();

    /**
     * Gets a custom, non-vanilla style entry
     * 
     * @param key The custom key
     * @return Style entry value
     */
    Object getExtra(String key);

    /**
     * Sets a custom, non-vanilla style entry.
     * 
     * @param key The custom key
     * @param value The custom value
     * @return Itself
     */
    TextStyle setExtra(String key, Object value);

    /**
     * Gets the set of custom style entries in this style.
     * 
     * @return Set of style entries
     */
    Set<Entry<String, Object>> getExtraSet();

    /**
     * Returns true if this style has no entries set
     * 
     * @return True if style is empty
     */
    boolean isEmpty();

    /**
     * Gets the parent for this style
     * 
     * @return The parent
     */
    TextStyle getParent();

    /**
     * Sets the parent of this style. If any value in this style is null, the
     * parent's will be used instead.
     * 
     * @param parent The parent style
     * @return Itself
     */
    TextStyle setParent(TextStyle parent);

    /**
     * Creates a new ChatStyle based on this one, ignoring parents.
     * 
     * @return A shallow copy
     */
    TextStyle createShallowCopy();

    /**
     * Creates a new ChatStyle based on this one, inheriting from all parents.
     * 
     * @return A deep copy
     */
    TextStyle createDeepCopy();
}
