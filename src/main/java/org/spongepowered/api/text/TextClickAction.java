/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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

import java.util.regex.Pattern;

import javax.annotation.Nonnull;

/**
 * Represents an action that will be executed by the Minecraft Client as soon as
 * the player clicks on the {@link MessagePart} this Click is attached to.
 */
public final class TextClickAction {

    /**
     * Regex matching allowed URLs as accepted by the Minecraft Client as of
     * Minecraft v1.7.10
     */
    private static final Pattern HTTP_REGEX = Pattern.compile("^https?://.*", Pattern.CASE_INSENSITIVE);

    /**
     * Builds a new Click of type {@link Type#OPEN_URL}.
     *
     * @param url An URL matching {@link #HTTP_REGEX}
     * @return A new Click of type OPEN_URL
     */
    @Nonnull
    public static TextClickAction ofOpenUrl(@Nonnull final String url) {
        if (!HTTP_REGEX.matcher(url).matches()) {
            throw new IllegalArgumentException("Provided url is invalid: " + url);
        }
        return forType(Type.OPEN_URL, url);
    }

    /**
     * Builds a new Click of type {@link Type#SEND_TEXT}.
     *
     * @param text The text to be send
     * @return A new Click of type SEND_TEXT
     */
    @Nonnull
    public static TextClickAction ofSendText(@Nonnull final String text) {
        return forType(Type.SEND_TEXT, text);
    }

    /**
     * Builds a new Click of type {@link Type#SET_TEXT}.
     *
     * @param text The text to be set
     * @return A new Click of type SET_TEXT
     */
    @Nonnull
    public static TextClickAction ofSetText(@Nonnull final String text) {
        return forType(Type.SET_TEXT, text);
    }

    /**
     * Builds a new Click of the provided Type with the provided text.
     *
     * @param type The Type
     * @param action The text
     * @return A new Click of the provided Type
     */
    @Nonnull
    private static TextClickAction forType(@Nonnull final Type type, @Nonnull final String action) {
        return new TextClickAction(type, action);
    }

    /**
     * An enum listing all possible action on Click.
     */
    public enum Type {
        /**
         * Based on Client configuration, will either open the URL or open the
         * "what to do with that URL?" prompt.
         */
        OPEN_URL,

        /**
         * Will make the user send the provided text to the chat. Supports
         * commands (text starting with '/').
         */
        SEND_TEXT,

        /**
         * Will fill the user chat input with the provided text.
         */
        SET_TEXT,
        ;
    }

    @Nonnull private final Type type;
    @Nonnull private final String text;

    /**
     * Builds a new Click of the provided Type with the provided text.
     *
     * @param type The Type
     * @param text The text
     */
    private TextClickAction(@Nonnull final Type type, @Nonnull final String text) {
        this.type = type;
        this.text = text;
    }

    /**
     * Gets the Type of this Click.
     *
     * @return The Type of this Click
     */
    public Type getType() {
        return this.type;
    }

    /**
     * Gets the text of this Click.
     *
     * @return The text of this Click
     */
    public String getText() {
        return this.text;
    }

    @Override
    public String toString() {
        return "Click [type=" + type.name() + ", text=" + text + "]";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final TextClickAction click = (TextClickAction) o;

        if (!text.equals(click.text)) {
            return false;
        }
        if (type != click.type) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + text.hashCode();
        return result;
    }

}
