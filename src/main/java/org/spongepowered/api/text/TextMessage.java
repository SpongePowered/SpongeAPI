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

import java.net.URL;
import java.util.List;

/**
 * Basic messages to send to the player.
 */
public interface TextMessage extends Iterable<TextMessage>, Cloneable {

    /**
     * Gets the text of this chat message.
     * 
     * @return Unformatted Text
     */
    String getPlainText();
    
    /**
     * Gets the text value of this message and all children recursively.
     * 
     * @return
     */
    String getUnformattedText();

    /**
     * Gets the formatted text for this message and all children recursively.
     * 
     * @return Formatted text
     */
    String getFormattedText();

    /**
     * Appends the given text to the end of this message
     * 
     * @param text Text to append
     * @return Itself
     */
    TextMessage append(String text);

    /**
     * Appends a url to the end of this message.
     * 
     * @param text The display text of the url
     * @param url The target
     * @return Itself
     */
    TextMessage append(String text, URL url);
    
    /**
     * Appends a url with a style to the end of this message.
     * 
     * @param text
     * @param url
     * @param style
     * @return
     */
    TextMessage append(String text, URL url, TextStyle style);

    /**
     * Appends a general client event to the end of this message.
     * 
     * @param text The display text of the event.
     * @param event The event
     * @return Itself
     */
    TextMessage append(String text, TextClientEvent event);

    /**
     * Appends a message to the end of this one.
     * 
     * @param message The message to append
     * @return Itself
     */
    TextMessage append(TextMessage message);

    /**
     * Gets all the children of this part of the message.
     * 
     * @return Array of children
     */
    List<TextMessage> getChildren();

    /**
     * Gets the style this component is using.
     * 
     * @return The style
     */
    TextStyle getStyle();

    /**
     * Sets the style to be used by this message.
     * 
     * @param style The style
     * @return Itself
     */
    TextMessage setStyle(TextStyle style);

    /**
     * Creates a deep copy of this message, taking into account all the parent
     * styles.
     * 
     * @return A new deep copy
     */
    TextMessage createDeepCopy();

    /**
     * Creates a shallow copy of this message, ignoring all parent styles.
     * 
     * @return A new shallow copy.
     */
    TextMessage createShallowCopy();

    /**
     * Gets the raw json of this message.
     * 
     * @return raw json
     */
    String getRaw();

}
