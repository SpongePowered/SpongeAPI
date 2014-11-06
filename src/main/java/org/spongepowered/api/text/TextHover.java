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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Represents a tooltip that will appear on the Client screen as soon as he
 * hovers the {@link MessagePart} this Hover is attached to.
 */
public final class TextHover {

    /**
     * Builds a new TextHover of type {@link Type#SHOW_ACHIEVEMENT}.
     *
     * @param achievement The Achievement to show on hover.
     * @return A new TextHover of type SHOW_ACHIEVEMENT
     */
// TODO: Enable if Achievement class is added
//    @Nonnull
//    public static TextHover of(@Nonnull final Achievement achievement) {
//        return new TextHover(Type.SHOW_ACHIEVEMENT, achievement);
//    }

    /**
     * Builds a new TextHover of type {@link Type#SHOW_ENTITY}.
     *
     * @param entity The {@link Entity} to show on hover.
     * @return A new TextHover of type SHOW_ENTITY
     */
    @Nonnull
    public static TextHover of(@Nonnull final Entity entity) {
        return new TextHover(Type.SHOW_ENTITY, entity);
    }

    /**
     * Builds a new TextHover of type {@link Type#SHOW_ITEM}.
     *
     * @param item The {@link ItemStack} to show on hover.
     * @return A new TextHover of type SHOW_ITEM
     */
    @Nonnull
    public static TextHover of(@Nonnull final ItemStack item) {
        return new TextHover(Type.SHOW_ITEM, item);
    }

    /**
     * Builds a new TextHover of type {@link Type#SHOW_TEXT}.
     *
     * @param lines The text to show on hover.
     * @return A new TextHover of type SHOW_TEXT
     */
    @SuppressWarnings("null")
    @Nonnull
    public static TextHover of(@Nonnull final String... lines) {
        if (lines.length == 0) {
            throw new IllegalArgumentException("lines can't be empty");
        }
        for (final String line : lines) {
            if (line == null) {
                throw new IllegalArgumentException("lines can't contain null elements");
            }
        }
        // TODO Support \n in Strings here if wanted
        return new TextHover(Type.SHOW_TEXT, lines.clone());
    }
    /**
     * Builds a new TextHover of generic type.
     *
     * @param type The hover type
     * @param object The data object to show on hover.
     * @return A new TextHover
     * @throws IllegalArgumentException if type does not
     *        {@link Type#accept(Object)} the object for any reason.
     */
    @Nonnull
    public static TextHover forType(@Nonnull final Type type, @Nonnull final Object object) {
        if (type.accept(type)) {
            return new TextHover(type, object);
        } else {
            throw new IllegalArgumentException(type + " does not support " + object + " (" + object.getClass().getName() + ")");
        }
    }

    /**
     * An enum like class listing all possible types of Hover.
     */
    public static abstract class Type {

        /**
         * Will show the player a tooltip containing the provided
         * {@link Achievement}'s name and description when he hovers the text.
         */
// TODO: Enable if Achievement class is added
//        @Nonnull public final static Type SHOW_ACHIEVEMENT = new Type("SHOW_ACHIEVEMENT") {
//
//            @Override
//            protected boolean accept(@Nonnull final Object object) {
//                return object instanceof Achievement;
//            };
//        };

        /**
         * Will show the player the same tooltip that appeard when hovering the
         * provided {@link ItemStack} in an inventory.
         */
        @Nonnull public final static Type SHOW_ENTITY = new Type("SHOW_ENTITY") {

            @Override
            protected boolean accept(@Nonnull final Object object) {
                return object instanceof Entity;
            };
        };

        /**
         * Will show the player the same tooltip that appeard when hovering the
         * provided {@link ItemStack} in an inventory.
         */
        @Nonnull public final static Type SHOW_ITEM = new Type("SHOW_ITEM") {

            @Override
            protected boolean accept(@Nonnull final Object object) {
                return object instanceof ItemStack;
            };
        };

        /**
         * Will show the player a tooltip containing the provided lines. These
         * lines can contain {@link TextFormatting} codes.
         */
        @Nonnull public final static Type SHOW_TEXT = new Type("SHOW_TEXT") {

            @Override
            protected boolean accept(@Nonnull final Object object) {
                return object instanceof String[];
            };
        };

        private static final Map<String, Type> BY_NAME = new LinkedHashMap<String, Type>();

        @Nonnull private final String name;

        /**
         * Creates a new Type with a given name.
         * 
         * @param name The name for this TextHoverType. The name is case
         *       insensitive and must be unique!
         * @throws IllegalArgumentException If the given name does already exist
         */
        @SuppressWarnings("null")
        public Type(@Nonnull final String name) {
            super();
            this.name = name.toUpperCase();
            if (!BY_NAME.containsKey(this.name)) {
                BY_NAME.put(this.name, this);
            } else {
                throw new IllegalArgumentException("TextHoverType with name " + this.name + " does already exist!");
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
            return "TextHoverType[" + name + "]";
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
         * Gets all registered TextHovers.
         *
         * @return A {@link Set} all registered TextHovers .
         */
        @Nonnull
        public static Set<Type> getAll() {
            return new LinkedHashSet<Type>(BY_NAME.values());
        }
    }

    @Nonnull private final Type type;
    @Nonnull private final Object object;

    /**
     * Builds a Hover from the provided Type and object.
     *
     * @param type The Type
     * @param object The object
     */
    private TextHover(@Nonnull final Type type, @Nonnull final Object object) {
        this.type = type;
        this.object = object;
    }

    /**
     * Gets the Type of this Hover.
     *
     * @return The Type of this Hover
     */
    @Nonnull
    public Type getType() {
        return this.type;
    }

    /**
     * Gets the Achievement attached to this Hover. Returns null if the attached
     * object isn't an Achievement.
     *
     * @return An Achievement if the attached object is an Achievement, null
     *         otherwise
     */
// TODO: Enable if Achievement class is added
//    @Nullable
//    public Object getAchievement() {
//        return this.type == Type.SHOW_ACHIEVEMENT ? (Achievement) this.object : null;
//    }

    /**
     * Gets the {@link Entity} attached to this Hover. Returns null if the
     * attached object isn't an {@link Entity}.
     *
     * @return An {@link Entity} if the attached object is an {@link Entity},
     *         null otherwise
     */
    @Nullable
    public Entity getEntity() {
        return this.type == Type.SHOW_ENTITY ? (Entity) this.object : null;
    }

    /**
     * Gets the {@link ItemStack} attached to this Hover. Returns null if the
     * attached object isn't an {@link ItemStack}.
     *
     * @return An {@link ItemStack} if the attached object is an
     *         {@link ItemStack}, null otherwise
     */
    @Nullable
    public ItemStack getItem() {
        return this.type == Type.SHOW_ITEM ? (ItemStack) this.object : null;
    }

    /**
     * Gets a copy of the tooltip lines attached to this Hover. Returns null if
     * the attached object isn't a String array.
     *
     * @return The tooltip lines if the attached object is a String array, null
     *         otherwise
     */
    @Nullable
    public String[] getText() {
        return this.type == Type.SHOW_TEXT ? ((String[]) this.object).clone() : null;
    }

    /**
     * Gets the {@link Object} attached to this Hover.
     *
     * @return The {@link Object} the attached to this hover
     */
    @Nonnull
    public Object getObject() {
        return object;
    }

    @Override
    @Nonnull
    public String toString() {
        return "TextHover [type=" + type.name + ", object=" + type.dataToString(object) + "]";
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final TextHover hover = (TextHover) o;

        if (type != hover.type) {
            return false;
        }

        return type.equalsData(object, hover.object);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + object.hashCode();
        return result;
    }
}
