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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.ShiftClickAction;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.text.translation.Translation;

import java.util.Iterator;

import javax.annotation.Nullable;

/**
 * Represents an immutable instance of formatted text that can be displayed on
 * the client. Each instance consists of content and a list of children texts
 * appended after the content of this text. The content of the text is available
 * through one of the subclasses.
 *
 * <p>Text is primarily used for sending formatted chat messages to players, but
 * also in other places like books or signs.</p>
 *
 * <p>Text instances can be either directly created through the available
 * constructor or using the {@link TextBuilder} available through one of the
 * {@link Texts#builder()} methods, which is the recommended way.</p>
 *
 * @see Texts#builder()
 * @see TextBuilder
 * @see Literal
 * @see Translatable
 * @see Selector
 * @see Score
 */
public abstract class Text {

    protected final TextColor color;
    protected final TextStyle style;
    protected final ImmutableList<Text> children;
    protected final Optional<ClickAction<?>> clickAction;
    protected final Optional<HoverAction<?>> hoverAction;
    protected final Optional<ShiftClickAction<?>> shiftClickAction;

    /**
     * An {@link Iterable} providing an {@link Iterator} over this {@link Text}
     * as well as all children text and their children.
     */
    protected final Iterable<Text> childrenIterable = new Iterable<Text>() {

        @Override
        public Iterator<Text> iterator() {
            return Text.this.children.isEmpty() ? Iterators.singletonIterator(Text.this) : new TextIterator(Text.this);
        }

    };

    Text() {
        this(TextColors.NONE, TextStyles.NONE, ImmutableList.<Text>of(), null, null, null);
    }

    /**
     * Constructs a new immutable {@link Text} with the specified formatting and
     * text actions applied.
     *
     * @param color The color of the text
     * @param style The style of the text
     * @param children The immutable list of children of the text
     * @param clickAction The click action of the text, or {@code null} for none
     * @param hoverAction The hover action of the text, or {@code null} for none
     * @param shiftClickAction The shift click action of the text, or
     *        {@code null} for none
     */
    protected Text(TextColor color, TextStyle style, ImmutableList<Text> children, @Nullable ClickAction<?> clickAction,
            @Nullable HoverAction<?> hoverAction, @Nullable ShiftClickAction<?> shiftClickAction) {
        this.color = checkNotNull(color, "color");
        this.style = checkNotNull(style, "style");
        this.children = checkNotNull(children, "children");
        this.clickAction = Optional.<ClickAction<?>>fromNullable(clickAction);
        this.hoverAction = Optional.<HoverAction<?>>fromNullable(hoverAction);
        this.shiftClickAction = Optional.<ShiftClickAction<?>>fromNullable(shiftClickAction);
    }

    /**
     * Returns the color of this {@link Text}.
     *
     * @return The color of this text
     */
    public final TextColor getColor() {
        return this.color;
    }

    /**
     * Returns the style of this {@link Text}. This will return a compound
     * {@link TextStyle} if multiple different styles have been set.
     *
     * @return The style of this text
     */
    public final TextStyle getStyle() {
        return this.style;
    }

    /**
     * Returns the immutable list of children appended after the content of this
     * {@link Text}.
     *
     * @return The immutable list of children
     */
    public final ImmutableList<Text> getChildren() {
        return this.children;
    }

    /**
     * Returns an immutable {@link Iterable} over this text and all of its
     * children. This is recursive, the children of the children will be also
     * included.
     *
     * @return An iterable over this text and the children texts
     */
    public final Iterable<Text> withChildren() {
        return this.childrenIterable;
    }

    /**
     * Returns the {@link ClickAction} executed on the client when this
     * {@link Text} gets clicked.
     *
     * @return The click action of this text, or {@link Optional#absent()} if
     *         not set
     */
    public final Optional<ClickAction<?>> getClickAction() {
        return this.clickAction;
    }

    /**
     * Returns the {@link HoverAction} executed on the client when this
     * {@link Text} gets hovered.
     *
     * @return The hover action of this text, or {@link Optional#absent()} if
     *         not set
     */
    public final Optional<HoverAction<?>> getHoverAction() {
        return this.hoverAction;
    }

    /**
     * Returns the {@link ShiftClickAction} executed on the client when this
     * {@link Text} gets shift-clicked.
     *
     * @return The shift-click action of this text, or {@link Optional#absent()}
     *         if not set
     */
    public final Optional<ShiftClickAction<?>> getShiftClickAction() {
        return this.shiftClickAction;
    }

    /**
     * Returns a new {@link TextBuilder} with the content, formatting and
     * actions of this text. This can be used to edit an otherwise immutable
     * {@link Text} instance.
     *
     * @return A new message builder with the content of this text
     */
    public abstract TextBuilder builder();

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Text)) {
            return false;
        }

        Text that = (Text) o;
        return this.color.equals(that.color)
                && this.style.equals(that.style)
                && this.children.equals(that.children)
                && this.clickAction.equals(that.clickAction)
                && this.hoverAction.equals(that.hoverAction)
                && this.shiftClickAction.equals(that.shiftClickAction);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.color, this.style, this.children, this.clickAction, this.hoverAction, this.shiftClickAction);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(Text.class)
                .add("color", this.color)
                .add("style", this.style)
                .add("children", this.children)
                .add("clickAction", this.clickAction)
                .add("hoverAction", this.hoverAction)
                .add("shiftClickAction", this.shiftClickAction)
                .toString();
    }

    /**
     * Represents a {@link Text} containing a plain text {@link String}.
     *
     * @see TextBuilder.Literal
     */
    public static class Literal extends Text {

        protected final String content;

        Literal() {
            this("");
        }

        Literal(String content) {
            this.content = checkNotNull(content, "content");
        }

        /**
         * Constructs a new immutable {@link Literal} for the given plain text
         * content with the specified formatting and text actions applied.
         *
         * @param color The color of the text
         * @param style The style of the text
         * @param children The immutable list of children of the text
         * @param clickAction The click action of the text, or {@code null} for
         *        none
         * @param hoverAction The hover action of the text, or {@code null} for
         *        none
         * @param shiftClickAction The shift click action of the text, or
         *        {@code null} for none
         * @param content The plain text content of the text
         */
        public Literal(TextColor color, TextStyle style, ImmutableList<Text> children, @Nullable ClickAction<?> clickAction,
                @Nullable HoverAction<?> hoverAction, @Nullable ShiftClickAction<?> shiftClickAction, String content) {
            super(color, style, children, clickAction, hoverAction, shiftClickAction);
            this.content = checkNotNull(content, "content");
        }

        /**
         * Returns the plain text content of this {@link Text}.
         *
         * @return The content of this text
         */
        public final String getContent() {
            return this.content;
        }

        @Override
        public TextBuilder.Literal builder() {
            return new TextBuilder.Literal(this);
        }

        @Override
        public boolean equals(@Nullable Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Literal) || !super.equals(o)) {
                return false;
            }

            Literal that = (Literal) o;
            return this.content.equals(that.content);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(super.hashCode(), this.content);
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .addValue(super.toString())
                    .add("content", this.content)
                    .toString();
        }

    }

    /**
     * Represents a {@link Text} containing a {@link Translation} identifier
     * that gets translated into the current locale on the client.
     *
     * @see TextBuilder.Translatable
     */
    public static class Translatable extends Text {

        protected final Translation translation;
        protected final ImmutableList<Object> arguments;

        Translatable(Translation translation, ImmutableList<Object> arguments) {
            this.translation = checkNotNull(translation, "translation");
            this.arguments = checkNotNull(arguments, "arguments");
        }

        /**
         * Constructs a new immutable {@link Translatable} for the given
         * translation with the specified formatting and text actions applied.
         *
         * @param color The color of the text
         * @param style The style of the text
         * @param children The immutable list of children of the text
         * @param clickAction The click action of the text, or {@code null} for
         *        none
         * @param hoverAction The hover action of the text, or {@code null} for
         *        none
         * @param shiftClickAction The shift click action of the text, or
         *        {@code null} for none
         * @param translation The translation of the text
         * @param arguments The arguments for the translation
         */
        public Translatable(TextColor color, TextStyle style, ImmutableList<Text> children, @Nullable ClickAction<?> clickAction,
                @Nullable HoverAction<?> hoverAction, @Nullable ShiftClickAction<?> shiftClickAction, Translation translation,
                ImmutableList<Object> arguments) {
            super(color, style, children, clickAction, hoverAction, shiftClickAction);
            this.translation = checkNotNull(translation, "translation");
            this.arguments = checkNotNull(arguments, "arguments");
        }

        /**
         * Returns the translation of this {@link Text}.
         *
         * @return The translation of this text
         */
        public final Translation getTranslation() {
            return this.translation;
        }

        /**
         * Returns the list of {@link Translation} arguments used to format this
         * {@link Text}.
         *
         * @return The list of translation arguments
         */
        public final ImmutableList<Object> getArguments() {
            return this.arguments;
        }

        @Override
        public TextBuilder.Translatable builder() {
            return new TextBuilder.Translatable(this);
        }

        @Override
        public boolean equals(@Nullable Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Translatable) || !super.equals(o)) {
                return false;
            }

            Translatable that = (Translatable) o;
            return this.translation.equals(that.translation)
                    && this.arguments.equals(that.arguments);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(super.hashCode(), this.translation, this.arguments);
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .addValue(super.toString())
                    .add("translation", this.translation)
                    .add("arguments", this.arguments)
                    .toString();
        }

    }

    /**
     * Represents a {@link Text} containing a selector that will be replaced by
     * the names of the matching entities on the client.
     *
     * @see org.spongepowered.api.text.selector.Selector
     * @see TextBuilder.Score
     */
    public static class Selector extends Text {

        protected final org.spongepowered.api.text.selector.Selector selector;

        Selector(org.spongepowered.api.text.selector.Selector selector) {
            this.selector = checkNotNull(selector, "selector");
        }

        /**
         * Constructs a new immutable {@link Selector} for the given selector
         * with the specified formatting and text actions applied.
         *
         * @param color The color of the text
         * @param style The style of the text
         * @param children The immutable list of children of the text
         * @param clickAction The click action of the text, or {@code null} for
         *        none
         * @param hoverAction The hover action of the text, or {@code null} for
         *        none
         * @param shiftClickAction The shift click action of the text, or
         *        {@code null} for none
         * @param selector The selector of the text
         */
        public Selector(TextColor color, TextStyle style, ImmutableList<Text> children, @Nullable ClickAction<?> clickAction,
                @Nullable HoverAction<?> hoverAction, @Nullable ShiftClickAction<?> shiftClickAction,
                org.spongepowered.api.text.selector.Selector selector) {
            super(color, style, children, clickAction, hoverAction, shiftClickAction);
            this.selector = checkNotNull(selector, "selector");
        }

        /**
         * Returns the selector used in this {@link Text}.
         *
         * @return The selector of this text
         */
        public final org.spongepowered.api.text.selector.Selector getSelector() {
            return this.selector;
        }

        @Override
        public TextBuilder.Selector builder() {
            return new TextBuilder.Selector(this);
        }

        @Override
        public boolean equals(@Nullable Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Selector) || !super.equals(o)) {
                return false;
            }

            Selector that = (Selector) o;
            return this.selector.equals(that.selector);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(super.hashCode(), this.selector);
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .addValue(super.toString())
                    .add("selector", this.selector)
                    .toString();
        }

    }

    /**
     * Represents a {@link Text} displaying the current score of a player.
     *
     * @see TextBuilder.Score
     */
    public static class Score extends Text {

        // TODO: Update with Statistic API
        protected final Object score;
        protected final Optional<String> override;

        Score(Object score) {
            this.score = checkNotNull(score, "score");
            this.override = Optional.absent();
        }

        /**
         * Constructs a new immutable {@link Score} for the given score with the
         * specified formatting and text actions applied.
         *
         * @param color The color of the text
         * @param style The style of the text
         * @param children The immutable list of children of the text
         * @param clickAction The click action of the text, or {@code null} for
         *        none
         * @param hoverAction The hover action of the text, or {@code null} for
         *        none
         * @param shiftClickAction The shift click action of the text, or
         *        {@code null} for none
         * @param score The score of the text
         * @param override The text to override the score with, or {@code null}
         *        for none
         */
        public Score(TextColor color, TextStyle style, ImmutableList<Text> children, @Nullable ClickAction<?> clickAction,
                @Nullable HoverAction<?> hoverAction, @Nullable ShiftClickAction<?> shiftClickAction, Object score, @Nullable String override) {
            super(color, style, children, clickAction, hoverAction, shiftClickAction);
            this.score = checkNotNull(score, "score");
            this.override = Optional.fromNullable(override);
        }

        /**
         * Returns the score displayed by this {@link Text}.
         *
         * @return The score in this text
         */
        public final Object getScore() {
            return this.score;
        }

        /**
         * Returns a value that is displayed instead of the real score.
         *
         * @return The value displayed instead of the real score, or
         *         {@link Optional#absent()} if the real score will be displayed
         *         instead
         */
        public final Optional<String> getOverride() {
            return this.override;
        }

        @Override
        public TextBuilder.Score builder() {
            return new TextBuilder.Score(this);
        }

        @Override
        public boolean equals(@Nullable Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Score) || !super.equals(o)) {
                return false;
            }

            Score that = (Score) o;
            return this.override.equals(that.override) && this.score.equals(that.score);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(super.hashCode(), this.score, this.override);
        }

        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .addValue(super.toString())
                    .add("score", this.score)
                    .add("override", this.override)
                    .toString();
        }

    }

}
