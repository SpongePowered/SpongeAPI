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

import java.util.Arrays;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Represents a tooltip that will appear on the Client screen as soon as he
 * hovers the {@link MessagePart} this Hover is attached to.
 */
public final class TextHover {

    /**
     * Builds a new Hover of type {@link Type#SHOW_ACHIEVEMENT}.
     *
     * @param achievement The Achievement
     * @return A new Hover of type SHOW_ACHIEVEMENT
     */
    @Nonnull
    public static TextHover of(@Nonnull final Achievement achievement) {
        return new TextHover(Type.SHOW_ACHIEVEMENT, achievement);
    }

    /**
     * Builds a new Hover of type {@link Type#SHOW_ITEM}.
     *
     * @param item The ItemStack
     * @return A new Hover of type SHOW_ITEM
     */
    @Nonnull
    public static TextHover of(@Nonnull final ItemStack item) {
        return new TextHover(Type.SHOW_ITEM, item);
    }

    /**
     * Builds a new Hover of type {@link Type#SHOW_TEXT}.
     *
     * @param lines The text
     * @return A new Hover of type SHOW_TEXT
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
     * An enum listing all possible types of Hover.
     */
    public enum Type {
        /**
         * Will show the player a tooltip containing the provided
         * {@link Achievement}'s name and description when he hovers the text.
         */
        SHOW_ACHIEVEMENT,

        /**
         * Will show the player the same tooltip that appeard when hovering the
         * provided {@link ItemStack} in an inventory.
         */
        SHOW_ITEM,

        /**
         * Will show the player a tooltip containing the provided lines. These
         * lines can contain {@link ChatFormatting} codes.
         */
        SHOW_TEXT,
        ;
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
    @Nullable
    public Achievement getAchievement() {
        return this.type == Type.SHOW_ACHIEVEMENT ? (Achievement) this.object : null;
    }

    /**
     * Gets a copy of the ItemStack attached to this Hover. Returns null if the
     * attached object isn't an ItemStack.
     *
     * @return An ItemStack if the attached object is an ItemStack, null
     *         otherwise
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

    @Override
    @Nonnull
    public String toString() {
        switch (type) {
            case SHOW_ACHIEVEMENT :
                return "Hover [type=SHOW_ACHIEVEMENT, object=" + ((Achievement) object).name() + "]";
            case SHOW_ITEM :
                return "Hover [type=SHOW_ITEM, object=" + object + "]";
            case SHOW_TEXT :
                return "Hover [type=SHOW_TEXT, object=" + Arrays.toString((String[]) object) + "]";
            default :
                throw new IllegalArgumentException("Should never be here!");
        }
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
        switch (type) {
            case SHOW_ACHIEVEMENT :
            case SHOW_ITEM :
                if (!object.equals(hover.object)) {
                    return false;
                }
                break;
            case SHOW_TEXT :
                if (!Arrays.equals((String[]) object, (String[]) hover.object)) {
                    return false;
                }
                break;
            default :
                throw new IllegalArgumentException("Should never be here!");
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + object.hashCode();
        return result;
    }
}
