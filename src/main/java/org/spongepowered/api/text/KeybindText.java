/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.ShiftClickAction;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextFormat;
import org.spongepowered.api.text.format.TextStyle;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

import javax.annotation.Nullable;

/**
 * Represents a {@link Text} containing a keybind.
 *
 * @see Builder
 */
public final class KeybindText extends Text {

    final String keybind;

    /**
     * Creates a builder.
     *
     * @return A builder
     */
    public static Builder builder() {
        return new Builder();
    }

    KeybindText(String keybind) {
        this.keybind = checkNotNull(keybind, "keybind");
    }

    /**
     * Constructs a new immutable {@link KeybindText} for the keybind
     * with the specified formatting and text actions applied.
     *
     * @param format The format of the text
     * @param children The immutable list of children of the text
     * @param clickAction The click action of the text, or {@code null} for none
     * @param hoverAction The hover action of the text, or {@code null} for none
     * @param shiftClickAction The shift click action of the text, or
     *        {@code null} for none
     * @param keybind The keybind
     */
    KeybindText(TextFormat format, ImmutableList<Text> children, @Nullable ClickAction<?> clickAction,
            @Nullable HoverAction<?> hoverAction, @Nullable ShiftClickAction<?> shiftClickAction, String keybind) {
        super(format, children, clickAction, hoverAction, shiftClickAction);
        this.keybind = checkNotNull(keybind, "keybind");
    }

    /**
     * Gets the keybind.
     *
     * @return The keybind
     */
    public String getKeybind() {
        return this.keybind;
    }

    @Override
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KeybindText) || !super.equals(o)) {
            return false;
        }

        KeybindText that = (KeybindText) o;
        return this.keybind.equals(that.keybind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.keybind);
    }

    @Override
    MoreObjects.ToStringHelper toStringHelper() {
        return super.toStringHelper()
                .add("keybind", this.keybind);
    }

    /**
     * Represents a {@link Text.Builder} creating immutable {@link KeybindText}
     * instances.
     *
     * @see KeybindText
     */
    public static class Builder extends Text.Builder {

        private String keybind;

        /**
         * Constructs a new empty {@link Builder}.
         */
        Builder() {
            this("");
        }

        /**
         * Constructs a new unformatted {@link Builder} with the given keybind.
         *
         * @param keybind The keybind
         */
        Builder(String keybind) {
            this.keybind(keybind);
        }

        /**
         * Constructs a new {@link Builder} with the formatting and actions of
         * the specified {@link Text} and the given keybind.
         *
         * @param text The text to apply the properties from
         * @param keybind The keybind
         */
        Builder(Text text, String keybind) {
            super(text);
            this.keybind(keybind);
        }

        /**
         * Constructs a new {@link Builder} with the formatting, actions and
         * keybind of the specified {@link KeybindText}.
         *
         * @param text The text to apply the properties from
         */
        Builder(KeybindText text) {
            super(text);
            this.keybind = text.keybind;
        }

        /**
         * Returns the current keybind of this builder.
         *
         * @return The current keybind
         * @see KeybindText#getKeybind()
         */
        public final String getKeybind() {
            return this.keybind;
        }

        /**
         * Sets the keybind.
         *
         * @param keybind The keybind
         * @return This text builder
         * @see KeybindText#getKeybind()
         */
        public Builder keybind(String keybind) {
            this.keybind = checkNotNull(keybind, "keybind");
            return this;
        }

        @Override
        public KeybindText build() {
            return new KeybindText(
                    this.format,
                    ImmutableList.copyOf(this.children),
                    this.clickAction,
                    this.hoverAction,
                    this.shiftClickAction,
                    this.keybind);
        }

        @Override
        public boolean equals(@Nullable Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Builder) || !super.equals(o)) {
                return false;
            }

            Builder that = (Builder) o;
            return Objects.equals(this.keybind, that.keybind);

        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), this.keybind);
        }

        @Override
        MoreObjects.ToStringHelper toStringHelper() {
            return super.toStringHelper()
                    .addValue(this.keybind);
        }

        @Override
        public Builder format(TextFormat format) {
            return (Builder) super.format(format);
        }

        @Override
        public Builder color(TextColor color) {
            return (Builder) super.color(color);
        }

        @Override
        public Builder style(TextStyle... styles) {
            return (Builder) super.style(styles);
        }

        @Override
        public Builder onClick(@Nullable ClickAction<?> clickAction) {
            return (Builder) super.onClick(clickAction);
        }

        @Override
        public Builder onHover(@Nullable HoverAction<?> hoverAction) {
            return (Builder) super.onHover(hoverAction);
        }

        @Override
        public Builder onShiftClick(@Nullable ShiftClickAction<?> shiftClickAction) {
            return (Builder) super.onShiftClick(shiftClickAction);
        }

        @Override
        public Builder append(Text... children) {
            return (Builder) super.append(children);
        }

        @Override
        public Builder append(Collection<? extends Text> children) {
            return (Builder) super.append(children);
        }

        @Override
        public Builder append(Iterable<? extends Text> children) {
            return (Builder) super.append(children);
        }

        @Override
        public Builder append(Iterator<? extends Text> children) {
            return (Builder) super.append(children);
        }

        @Override
        public Builder insert(int pos, Text... children) {
            return (Builder) super.insert(pos, children);
        }

        @Override
        public Builder insert(int pos, Collection<? extends Text> children) {
            return (Builder) super.insert(pos, children);
        }

        @Override
        public Builder insert(int pos, Iterable<? extends Text> children) {
            return (Builder) super.insert(pos, children);
        }

        @Override
        public Builder insert(int pos, Iterator<? extends Text> children) {
            return (Builder) super.insert(pos, children);
        }

        @Override
        public Builder remove(Text... children) {
            return (Builder) super.remove(children);
        }

        @Override
        public Builder remove(Collection<? extends Text> children) {
            return (Builder) super.remove(children);
        }

        @Override
        public Builder remove(Iterable<? extends Text> children) {
            return (Builder) super.remove(children);
        }

        @Override
        public Builder remove(Iterator<? extends Text> children) {
            return (Builder) super.remove(children);
        }

        @Override
        public Builder removeAll() {
            return (Builder) super.removeAll();
        }
    }
}
