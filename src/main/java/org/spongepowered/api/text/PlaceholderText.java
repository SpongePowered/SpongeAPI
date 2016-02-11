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

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.ShiftClickAction;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextFormat;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.transformer.Transformer;
import org.spongepowered.api.text.transformer.Transformers;
import org.spongepowered.api.text.transformer.ValueForKeyTransformer;

import java.util.Optional;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * Represents a placeholder {@link Text} that can be replaced with another Text
 * by {@link Text#format(Text, Function)}.
 *
 * @see PlaceholderText.Builder
 */
public class PlaceholderText extends Text {

    protected final Transformer<?> transformer;
    private final Optional<Text> fallback;

    PlaceholderText(String key) {
        this(key, null);
    }

    PlaceholderText(String key, @Nullable Text fallback) {
        this(Transformers.key(key), fallback);
    }

    PlaceholderText(Transformer<?> transformer) {
        this(transformer, null);
    }

    PlaceholderText(Transformer<?> transformer, @Nullable Text fallback) {
        this.transformer = checkNotNull(transformer, "transformer");
        this.fallback = Optional.ofNullable(fallback);
    }

    /**
     * Constructs a new immutable {@link Builder} for the given plain text
     * content with the specified formatting and text actions applied.
     *
     * @param format The format of the text
     * @param children The immutable list of children of the text
     * @param clickAction The click action of the text, or {@code null} for none
     * @param hoverAction The hover action of the text, or {@code null} for none
     * @param shiftClickAction The shift click action of the text, or
     *        {@code null} for none
     * @param transformer The transformer of the placeholder
     * @param fallback The fallback text if this does not get replaced
     */
    PlaceholderText(TextFormat format, ImmutableList<Text> children, @Nullable ClickAction<?> clickAction,
            @Nullable HoverAction<?> hoverAction, @Nullable ShiftClickAction<?> shiftClickAction,
            Transformer<?> transformer, Text fallback) {
        super(format, children, clickAction, hoverAction, shiftClickAction);
        this.transformer = checkNotNull(transformer, "transformer");
        this.fallback = Optional.ofNullable(fallback);
    }

    /**
     * This method calculates / generates the replacement for this placeholder
     * in {@link Text#format(Text, Function)}. It uses the contained
     * {@link Transformer} to do the necessary transformations. If this method
     * returns {@link Optional#empty()} then this placeholder should not be
     * replaced. This is usually the case if not enough context information is
     * available.
     *
     * @param context The context data function passed by
     *        {@link Text#format(Text, Function)} that should be used to
     *        calculate/generate a replacement
     * @return The replacement for this placeholder
     *
     * @see Transformer#transform(Function)
     */
    public final Optional<?> calculateReplacement(Function<String, ?> context) {
        return checkNotNull(this.transformer.transform(checkNotNull(context, "context")), "transformer result");
    }

    /**
     * Gets the {@link Transformer} that is used to resolve the placeholder's
     * replacement during the {@link Text#format(Text, Function)} call.
     *
     * @return The transformer that is used to resolve the placeholder's
     *         replacement
     */
    public Transformer<?> getTransformer() {
        return this.transformer;
    }

    /**
     * Gets the fallback text that will be used in place if this placeholder has
     * no value.
     *
     * @return The fallback text
     */
    public Optional<Text> getFallback() {
        return this.fallback;
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
        if (!(o instanceof Builder) || !super.equals(o)) {
            return false;
        }

        PlaceholderText that = (PlaceholderText) o;
        return Objects.equal(this.transformer, that.transformer) && Objects.equal(this.fallback, that.fallback);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), this.transformer);
    }

    @Override
    protected ToStringHelper toStringHelper() {
        return super.toStringHelper()
                .add("transformer", this.transformer)
                .add("fallback", this.fallback.orElse(null))
                .addValue(super.toString());
    }

    /**
     * Represents a {@link Text.Builder} creating immutable {@link PlaceholderText}
     * instances.
     *
     * @see PlaceholderText
     */
    public static class Builder extends Text.Builder {

        private Transformer<?> transformer;
        private Text fallback;

        /**
         * Constructs a new unformatted {@link Builder} with the given content.
         *
         * @param key The none empty replacement key for the placeholder builder
         */
        Builder(String key) {
            key(key);
        }

        /**
         * Constructs a new {@link Builder} with the formatting and actions of
         * the specified {@link Text} and the given content.
         *
         * @param text The text to apply the properties from
         * @param key The none empty replacement key for the placeholder builder
         */
        Builder(Text text, String key) {
            super(text);
            key(key);
        }

        /**
         * Constructs a new unformatted {@link Builder} with the given content.
         *
         * @param transformer The transformer for the placeholder builder
         */
        Builder(Transformer<?> transformer) {
            transformer(transformer);
        }

        /**
         * Constructs a new {@link Builder} with the formatting and actions of
         * the specified {@link Text} and the given content.
         *
         * @param text The text to apply the properties from
         * @param transformer The transformer for the placeholder builder
         */
        Builder(Text text, Transformer<?> transformer) {
            super(text);
            transformer(transformer);
        }

        /**
         * Constructs a new {@link Builder} with the formatting, actions and
         * content of the specified {@link Text.Builder}.
         *
         * @param text The text to apply the properties from
         */
        Builder(PlaceholderText text) {
            super(text);
            this.transformer = text.transformer;
            if (text.getFallback().isPresent()) {
                this.fallback = text.getFallback().get();
            }
        }

        /**
         * Returns the current transformer of this builder.
         *
         * @return The current transformer
         *
         * @see PlaceholderText#getTransformer()
         */
        public final Transformer<?> getTransformer() {
            return this.transformer;
        }

        /**
         * Sets the key that is used in {@link Text#format(Text, Function)} to
         * resolve the replacement for this placeholder.
         *
         * @param key The key used to resolve the replacement
         * @return This text builder
         * @see ValueForKeyTransformer
         */
        public Builder key(String key) {
            transformer(Transformers.key(key));
            return this;
        }

        /**
         * Sets the {@link Transformer} that is used in
         * {@link Text#format(Text, Function)} to resolve the replacement for
         * this placeholder.
         *
         * @param transformer The transformer used to resolve the replacement
         * @return This text builder
         */
        public Builder transformer(Transformer<?> transformer) {
            this.transformer = checkNotNull(transformer, "transformer");
            return this;
        }

        /**
         * Sets the fallback text that will be used if no replacements is
         * present for this placeholder
         *
         * @param fallback The content of this text
         * @return This text builder
         * @see PlaceholderText#getFallback()
         */
        public Builder fallback(Text fallback) {
            this.fallback = fallback;
            return this;
        }

        @Override
        public PlaceholderText build() {
            return new PlaceholderText(
                    this.format,
                    ImmutableList.copyOf(this.children),
                    this.clickAction,
                    this.hoverAction,
                    this.shiftClickAction,
                    this.transformer,
                    this.fallback);
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
            return Objects.equal(this.transformer, that.transformer) && Objects.equal(this.fallback, that.fallback);

        }

        @Override
        public int hashCode() {
            return Objects.hashCode(super.hashCode(), this.fallback);
        }

        @Override
        protected ToStringHelper toStringHelper() {
            return super.toStringHelper()
                    .add("transformer", this.transformer)
                    .add("fallback", this.fallback);
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
        public Builder append(Iterable<? extends Text> children) {
            return (Builder) super.append(children);
        }

        @Override
        public Builder insert(int pos, Text... children) {
            return (Builder) super.insert(pos, children);
        }

        @Override
        public Builder insert(int pos, Iterable<? extends Text> children) {
            return (Builder) super.insert(pos, children);
        }

        @Override
        public Builder remove(Text... children) {
            return (Builder) super.remove(children);
        }

        @Override
        public Builder remove(Iterable<? extends Text> children) {
            return (Builder) super.remove(children);
        }

        @Override
        public Builder removeAll() {
            return (Builder) super.removeAll();
        }

    }

}
