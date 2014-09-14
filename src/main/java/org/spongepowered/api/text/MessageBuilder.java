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

import org.spongepowered.api.util.Builder;

/**
 * Builder for easily creating messages.
 */
public interface MessageBuilder extends Builder<MessageBuilder, TextMessage> {

    /**
     * Appends a message to the end of this builder.
     * 
     * @param text
     * @param formats
     * @return This instance
     */
    MessageBuilder appendString(String text, TextFormatting... formats);

    /**
     * Appends a message with an event to the end of this builder. Can be either
     * click or hover.
     * 
     * @param display
     * @param action
     * @param value
     * @param formats
     * @return This instance.
     */
    MessageBuilder appendAction(String display, TextAction action, String value,
            TextFormatting... formats);
    
    /**
     * Appends a message with a link to the end of this builder.<br/>
     * <p>
     * Same thing as calling
     * {@code appendEvent(display, TextAction.OPEN_LINK, url.toString(), formats);}
     * </p>
     * <p>
     * file:// protocols are not allowed.
     * </p>
     * 
     * @param display Text to display
     * @param url The URL of the link. File:// protocols are not allowed.
     * @param formats The formatting codes to use.
     * @return This instance.
     */
    MessageBuilder appendLink(String display, URL url,
            TextFormatting... formats);

}
