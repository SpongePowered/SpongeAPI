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
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.ShiftClickAction;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextFormat;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.translation.Translation;

import java.util.Collection;
import java.util.Iterator;

import javax.annotation.Nullable;

/**
 * Represents a {@link Text} containing a {@link Translation} identifier that
 * gets translated into the current locale on the client.
 *
 * @see Builder
 */
public final class TranslatableText extends Text {

    final Translation translation;
    final ImmutableList<Object> arguments;

    TranslatableText(Translation translation, ImmutableList<Object> arguments) {
        this.translation = checkNotNull(translation, "translation");
        this.arguments = checkNotNull(arguments, "arguments");
    }

    /**
     * Constructs a new immutable {@link TranslatableText} for the given
     * translation with the specified formatting and text actions applied.
     *
     * @param format The format of the text
     * @param children The immutable list of children of the text
     * @param clickAction The click action of the text, or {@code null} for none
     * @param hoverAction The hover action of the text, or {@code null} for none
     * @param shiftClickAction The shift click action of the text, or
     *        {@code null} for none
     * @param translation The translation of the text
     * @param arguments The arguments for the translation
     */
    TranslatableText(TextFormat format, ImmutableList<Text> children, @Nullable ClickAction<?> clickAction,
            @Nullable HoverAction<?> hoverAction, @Nullable ShiftClickAction<?> shiftClickAction, Translation translation,
            ImmutableList<Object> arguments) {
        super(format, children, clickAction, hoverAction, shiftClickAction);
        this.translation = checkNotNull(translation, "translation");
        this.arguments = checkNotNull(arguments, "arguments");
    }

    /**
     * Returns the translation of this {@link Text}.
     *
     * @return The translation of this text
     */
    public Translation getTranslation() {
        return this.translation;
    }

    /**
     * Returns the list of {@link Translation} arguments used to format this
     * {@link Text}.
     *
     * @return The list of translation arguments
     */
    public ImmutableList<Object> getArguments() {
        return this.arguments;
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
        if (!(o instanceof TranslatableText) || !super.equals(o)) {
            return false;
        }

        TranslatableText that = (TranslatableText) o;
        return this.translation.equals(that.translation)
                && this.arguments.equals(that.arguments);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), this.translation, this.arguments);
    }

    @Override
    MoreObjects.ToStringHelper toStringHelper() {
        return super.toStringHelper()
                .addValue(this.translation)
                .add("arguments", this.arguments);
    }

    /**
     * Represents a {@link Text.Builder} creating immutable
     * {@link TranslatableText} instances.
     *
     * @see TranslatableText
     */
    public static class Builder extends Text.Builder {

        private Translation translation;
        private ImmutableList<Object> arguments;

        /**
         * Constructs a new unformatted {@link Builder} with the given
         * {@link Translation} and arguments.
         *
         * @param translation The translation for the builder
         * @param args The arguments for the translation
         */
        Builder(Translation translation, Object... args) {
            translation(translation, args);
        }

        /**
         * Constructs a new unformatted {@link Builder} from the given
         * {@link org.spongepowered.api.text.translation.Translatable} .
         *
         * @param translatable The translatable for the builder
         * @param args The arguments for the translation
         */
        Builder(org.spongepowered.api.text.translation.Translatable translatable, Object... args) {
            translation(translatable, args);
        }

        /**
         * Constructs a new {@link Builder} with the formatting and actions of
         * the specified {@link Text} and the given {@link Translation} and
         * arguments.
         *
         * @param text The text to apply the properties from
         * @param translation The translation for the builder
         * @param args The arguments for the translation
         */
        Builder(Text text, Translation translation, Object... args) {
            super(text);
            translation(translation, args);
        }

        /**
         * Constructs a new {@link Builder} with the formatting and actions of
         * the specified {@link Text} and the given
         * {@link org.spongepowered.api.text.translation.Translatable}.
         *
         * @param text The text to apply the properties from
         * @param translatable The translatable for the builder
         * @param args The arguments for the translation
         */
        Builder(Text text, org.spongepowered.api.text.translation.Translatable translatable, Object... args) {
            super(text);
            translation(translatable, args);
        }

        /**
         * Constructs a new {@link Builder} with the formatting, actions and
         * translation of the specified {@link TranslatableText}.
         *
         * @param text The text to apply the properties from
         */
        Builder(TranslatableText text) {
            super(text);
            this.translation = text.translation;
            this.arguments = text.arguments;
        }

        /**
         * Returns the current translation of this builder.
         *
         * @return The current content
         * @see TranslatableText#getTranslation()
         */
        public final Translation getTranslation() {
            return this.translation;
        }

        /**
         * Returns the current translation arguments of this builder.
         *
         * @return The current translation arguments
         * @see TranslatableText#getArguments()
         */
        public final ImmutableList<Object> getArguments() {
            return this.arguments;
        }

        /**
         * Sets the translation of the text.
         *
         * @param translation The translation to use for this builder
         * @param args The arguments for the translation
         * @return This text builder
         */
        public Builder translation(Translation translation, Object... args) {
            this.translation = checkNotNull(translation, "translation");
            this.arguments = ImmutableList.copyOf(checkNotNull(args, "args"));
            return this;
        }

        /**
         * Sets the translation of the text.
         *
         * @param translatable The translatable object to use for this builder
         * @param args The arguments for the translation
         * @return This text builder
         */
        public Builder translation(org.spongepowered.api.text.translation.Translatable translatable, Object... args) {
            return translation(checkNotNull(translatable, "translatable").getTranslation(), args);
        }

        @Override
        public TranslatableText build() {
            return new TranslatableText(
                    this.format,
                    ImmutableList.copyOf(this.children),
                    this.clickAction,
                    this.hoverAction,
                    this.shiftClickAction,
                    this.translation,
                    this.arguments);
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
            return Objects.equal(this.translation, that.translation)
                    && Objects.equal(this.arguments, that.arguments);

        }

        @Override
        public int hashCode() {
            return Objects.hashCode(super.hashCode(), this.translation, this.arguments);
        }

        @Override
        MoreObjects.ToStringHelper toStringHelper() {
            return super.toStringHelper()
                    .addValue(this.translation)
                    .add("arguments", this.arguments);
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
