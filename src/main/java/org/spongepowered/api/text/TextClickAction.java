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

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
     * Builds a new TextClickAction of type {@link Type#OPEN_URL}.
     *
     * @param url An URL matching {@link #HTTP_REGEX}
     * @return A new TextClickAction of type OPEN_URL
     */
    @Nonnull
    public static TextClickAction ofOpenUrl(@Nonnull final String url) {
        if (!HTTP_REGEX.matcher(url).matches()) {
            throw new IllegalArgumentException("Provided url is invalid: " + url);
        }
        return new TextClickAction(Type.OPEN_URL, url);
    }

    /**
     * Builds a new TextClickAction of type {@link Type#SEND_TEXT}.
     *
     * @param text The text to be send
     * @return A new TextClickAction of type SEND_TEXT
     */
    @Nonnull
    public static TextClickAction ofSendText(@Nonnull final String text) {
        return new TextClickAction(Type.SEND_TEXT, text);
    }

    /**
     * Builds a new TextClickAction of type {@link Type#SET_TEXT}.
     *
     * @param text The text to be set
     * @return A new TextClickAction of type SET_TEXT
     */
    @Nonnull
    public static TextClickAction ofSetText(@Nonnull final String text) {
        return new TextClickAction(Type.SET_TEXT, text);
    }

    /**
     * Builds a new TextClickAction of generic type.
     *
     * @param type The click type
     * @param object The data object
     * @return A new TextClickAction
     * @throws IllegalArgumentException if type does not
     *             {@link Type#accept(Object)} the object for any reason.
     */
    @Nonnull
    public static TextClickAction forType(@Nonnull final Type type, @Nonnull final Object object) {
        if (type.accept(object)) {
            return new TextClickAction(type, object);
        } else {
            throw new IllegalArgumentException(type + " does not support " + object + " (" + object.getClass().getName() + ")");
        }
    }

    /**
     * An enum like class listing all possible actions on Click.
     */
    public abstract static class Type {

        private static final Map<String, Type> BY_NAME = new LinkedHashMap<String, Type>();

        /**
         * Based on Client configuration, will either open the URL or open the
         * "What to do with that URL?" prompt.
         * <p>
         * <b>data</b> (String): The URL that should be opened.
         * </p>
         */
        @Nonnull public static final Type OPEN_URL = new Type("OPEN_URL") {

            @Override
            protected boolean accept(final Object object) {
                return object instanceof String && HTTP_REGEX.matcher((String) object).matches();
            };
        };

        /**
         * Will make the user send the provided text to the chat. Supports
         * commands (texts starting with '/').
         * <p>
         * <b>data</b> (String): The command to send.
         * </p>
         */
        @Nonnull public static final Type SEND_TEXT = new Type("SEND_TEXT") {

            @Override
            protected boolean accept(final Object object) {
                return object instanceof String;
            };
        };

        /**
         * Will fill the user chat input with the provided text.
         * <p>
         * <b>data</b> (String): The chat to put in the chat input.
         * </p>
         */
        @Nonnull public static final Type SET_TEXT = new Type("SET_TEXT") {

            @Override
            protected boolean accept(final Object object) {
                return object instanceof String;
            };
        };

        /**
         * Will open the specified page in a book. (Books only)
         * <p>
         * <b>data</b> (Integer): A page in the currently opened book.
         * </p>
         */
        @Nonnull public static final Type CHANGE_PAGE = new Type("CHANGE_PAGE") {

            @Override
            protected boolean accept(final Object object) {
                return object instanceof Integer;
            };
        };

        /**
         * Will open the twitch user info. (Client only)
         * <p>
         * <b>data</b> (String): Twitch user name.
         * </p>
         */
        @Nonnull public static final Type TWITCH_USER_INFO = new Type("TWITCH_USER_INFO") {

            @Override
            protected boolean accept(final Object object) {
                return object instanceof String;
            };
        };

        /**
         * Will open the specified file. (Client only)
         * <p>
         * <b>data</b> (String): Path targeting to a local file.
         * </p>
         */
        @Nonnull public static final Type OPEN_FILE = new Type("OPEN_FILE") {

            @Override
            protected boolean accept(final Object object) {
                return object instanceof String;
            };
        };

        @Nonnull private final String name;

        /**
         * Creates a new Type with a given name.
         *
         * @param name The name for this TextActionClickType. The name is case
         *        insensitive and must be unique!
         * @throws IllegalArgumentException If the given name does already exist
         */
        @SuppressWarnings("null")
        public Type(@Nonnull final String name) {
            super();
            this.name = name.toUpperCase();
            if (!BY_NAME.containsKey(this.name)) {
                BY_NAME.put(this.name, this);
            } else {
                throw new IllegalArgumentException("TextActionClickType with name " + this.name + " does already exist!");
            }
        }

        @Nonnull
        public final String getName() {
            return name;
        }

        protected abstract boolean accept(@Nonnull Object object);

        protected boolean equalsData(@Nonnull final Object o1, @Nonnull final Object o2) {
            return o1.equals(o2);
        }

        protected String dataToString(@Nonnull final Object object) {
            return object.toString();
        }

        @Override
        public final String toString() {
            return "TextClickActionType[" + name + "]";
        }

        @Override
        public final boolean equals(final Object obj) {
            return this == obj;
        }

        @Override
        public final int hashCode() {
            return super.hashCode();
        }

        /**
         * Gets the Type for the given type name.
         *
         * @param name The name to check
         * @return The Type for the given (case insesitive) name or null, if the
         *         given name does not specify a type.
         */
        @Nullable
        public static Type getByName(@Nonnull final String name) {
            return BY_NAME.get(name.toUpperCase());
        }

        /**
         * Gets all registered TextClickActions.
         *
         * @return A {@link Set} all registered TextClickActions .
         */
        @Nonnull
        public static Set<Type> getAll() {
            return new LinkedHashSet<Type>(BY_NAME.values());
        }

    }

    @Nonnull private final Type type;
    @Nonnull private final Object object;

    /**
     * Builds a new Click of the provided Type with the provided text.
     *
     * @param type The Type
     * @param text The text
     */
    private TextClickAction(@Nonnull final Type type, @Nonnull final Object object) {
        this.type = type;
        this.object = object;
    }

    /**
     * Gets the Type of this Click.
     *
     * @return The Type of this Click
     */
    @Nonnull
    public Type getType() {
        return this.type;
    }

    /**
     * Gets the text attached to this click action. Returns null if the attached
     * object isn't an {@link String}.
     *
     * @return An text if the attached object is an {@link String}, null
     *         otherwise
     */
    @Nullable
    public String getText() {
        return this.object instanceof String ? (String) object : null;
    }

    /**
     * Gets the {@link Object} attached to this click action.
     *
     * @return The {@link Object} the attached to this click action
     */
    @Nonnull
    public Object getObject() {
        return object;
    }

    @Override
    @Nonnull
    public String toString() {
        return "TextClickAction [type=" + type.name + ", object=" + type.dataToString(object) + "]";
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

        if (type != click.type) {
            return false;
        }

        return type.equalsData(object, click.object);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + object.hashCode();
        return result;
    }

}
