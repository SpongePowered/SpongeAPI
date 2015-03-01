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
import com.google.common.collect.Lists;
import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.ShiftClickAction;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.text.translation.Translation;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

/**
 * Represents a builder class to create immutable {@link Text} instances.
 *
 * @see Text
 */
public abstract class TextBuilder {

    protected TextColor color = TextColors.NONE;
    protected TextStyle style = TextStyles.NONE;
    protected List<Text> children = Lists.newArrayList();
    @Nullable protected ClickAction<?> clickAction;
    @Nullable protected HoverAction<?> hoverAction;
    @Nullable protected ShiftClickAction<?> shiftClickAction;

    /**
     * Constructs a new empty {@link TextBuilder}.
     */
    protected TextBuilder() {
    }

    /**
     * Constructs a new {@link TextBuilder} with the properties of the given
     * {@link Text} as initial values.
     *
     * @param text The text to copy the values from
     */
    public TextBuilder(Text text) {
        checkNotNull(text, "text");
        this.color = text.color;
        this.style = text.style;
        this.children = Lists.newArrayList(text.children);
        this.clickAction = text.clickAction.orNull();
        this.hoverAction = text.hoverAction.orNull();
        this.shiftClickAction = text.shiftClickAction.orNull();
    }

    /**
     * Returns the current color of the {@link Text} in this builder.
     *
     * @return The current color
     * @see Text#getColor()
     */
    public final TextColor getColor() {
        return this.color;
    }

    /**
     * Sets the {@link TextColor} of this text.
     *
     * @param color The new text color for this text
     * @return This text builder
     * @see Text#getColor()
     */
    public TextBuilder color(TextColor color) {
        this.color = checkNotNull(color, "color");
        return this;
    }

    /**
     * Returns the current style of the {@link Text} in this builder.
     *
     * @return The current style
     * @see Text#getStyle()
     */
    public final TextStyle getStyle() {
        return this.style;
    }

    /**
     * Sets the text styles of this text. This will construct a composite
     * {@link TextStyle} of the current style and the specified styles first and
     * set it to the text.
     *
     * @param styles The text styles to apply
     * @return This text builder
     * @see Text#getStyle()
     */
    // TODO: Make sure this is the correct behaviour
    public TextBuilder style(TextStyle... styles) {
        this.style = this.style.and(styles);
        return this;
    }

    /**
     * Returns the current {@link ClickAction} of this builder.
     *
     * @return The current click action or {@link Optional#absent()} if none
     * @see Text#getClickAction()
     */
    public final Optional<ClickAction<?>> getClickAction() {
        return Optional.<ClickAction<?>>fromNullable(this.clickAction);
    }

    /**
     * Sets the {@link ClickAction} that will be executed if the text is clicked
     * in the chat.
     *
     * @param clickAction The new click action for the text
     * @return This text builder
     * @see Text#getClickAction()
     */
    public TextBuilder onClick(@Nullable ClickAction<?> clickAction) {
        this.clickAction = clickAction;
        return this;
    }

    /**
     * Returns the current {@link HoverAction} of this builder.
     *
     * @return The current hover action or {@link Optional#absent()} if none
     * @see Text#getHoverAction()
     */
    public final Optional<HoverAction<?>> getHoverAction() {
        return Optional.<HoverAction<?>>fromNullable(this.hoverAction);
    }

    /**
     * Sets the {@link HoverAction} that will be executed if the text is hovered
     * in the chat.
     *
     * @param hoverAction The new hover action for the text
     * @return This text builder
     * @see Text#getHoverAction()
     */
    public TextBuilder onHover(@Nullable HoverAction<?> hoverAction) {
        this.hoverAction = hoverAction;
        return this;
    }

    /**
     * Returns the current {@link ShiftClickAction} of this builder.
     *
     * @return The current shift click action or {@link Optional#absent()} if
     *         none
     * @see Text#getShiftClickAction()
     */
    public final Optional<ShiftClickAction<?>> getShiftClickAction() {
        return Optional.<ShiftClickAction<?>>fromNullable(this.shiftClickAction);
    }

    /**
     * Sets the {@link ShiftClickAction} that will be executed if the text is
     * shift-clicked in the chat.
     *
     * @param shiftClickAction The new shift click action for the text
     * @return This text builder
     * @see Text#getShiftClickAction()
     */
    public TextBuilder onShiftClick(@Nullable ShiftClickAction<?> shiftClickAction) {
        this.shiftClickAction = shiftClickAction;
        return this;
    }

    /**
     * Returns a view of the current children of this builder.
     *
     * <p>The returned list is unmodifiable, but not immutable. It will change
     * if new children get added through this builder.</p>
     *
     * @return An unmodifiable list of the current children
     * @see Text#getChildren()
     */
    public final List<Text> getChildren() {
        return Collections.unmodifiableList(this.children);
    }

    /**
     * Appends the specified {@link Text} to the end of this text.
     *
     * @param children The texts to append
     * @return This text builder
     * @see Text#getChildren()
     */
    public TextBuilder append(Text... children) {
        for (Text child : checkNotNull(children, "children")) {
            checkNotNull(child, "child");
            this.children.add(child);
        }
        return this;
    }

    /**
     * Appends the specified {@link Text} to the end of this text.
     *
     * @param children The texts to append
     * @return This text builder
     * @see Text#getChildren()
     */
    public TextBuilder append(Iterable<? extends Text> children) {
        for (Text child : checkNotNull(children, "children")) {
            this.children.add(checkNotNull(child, "child"));
        }
        return this;
    }

    /**
     * Inserts the specified {@link Text} at the given position of this builder.
     *
     * @param pos The position to insert the texts to
     * @param children The texts to insert
     * @return This text builder
     * @throws IndexOutOfBoundsException If the position is out of bounds
     * @see Text#getChildren()
     */
    public TextBuilder insert(int pos, Text... children) {
        for (Text child : checkNotNull(children, "children")) {
            this.children.add(pos++, checkNotNull(child, "child"));
        }
        return this;
    }

    /**
     * Inserts the specified {@link Text} at the given position of this builder.
     *
     * @param pos The position to insert the texts to
     * @param children The texts to insert
     * @return This text builder
     * @throws IndexOutOfBoundsException If the position is out of range
     * @see Text#getChildren()
     */
    public TextBuilder insert(int pos, Iterable<? extends Text> children) {
        for (Text child : checkNotNull(children, "children")) {
            this.children.add(pos++, checkNotNull(child, "child"));
        }
        return this;
    }

    /**
     * Removes the specified {@link Text} from this builder.
     *
     * @param children The texts to remove
     * @return This text builder
     * @see Text#getChildren()
     */
    public TextBuilder remove(Text... children) {
        for (Text child : checkNotNull(children, "children")) {
            this.children.remove(checkNotNull(child));
        }
        return this;
    }

    /**
     * Removes the specified {@link Text} from this builder.
     *
     * @param children The texts to remove
     * @return This text builder
     * @see Text#getChildren()
     */
    public TextBuilder remove(Iterable<? extends Text> children) {
        for (Text child : checkNotNull(children, "children")) {
            this.children.remove(checkNotNull(child));
        }
        return this;
    }

    /**
     * Removes all children from this builder.
     *
     * @return This text builder
     * @see Text#getChildren()
     */
    public TextBuilder removeAll() {
        this.children.clear();
        return this;
    }

    /**
     * Builds an immutable instance of the current state of this text builder.
     *
     * @return An immutable {@link Text} with the current properties of this
     *         builder
     */
    public abstract Text build();

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TextBuilder)) {
            return false;
        }

        TextBuilder that = (TextBuilder) o;
        return Objects.equal(this.color, that.color)
                && Objects.equal(this.style, that.style)
                && Objects.equal(this.clickAction, that.clickAction)
                && Objects.equal(this.hoverAction, that.hoverAction)
                && Objects.equal(this.shiftClickAction, that.shiftClickAction)
                && Objects.equal(this.children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.color, this.style, this.clickAction, this.hoverAction, this.shiftClickAction, this.children);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(TextBuilder.class)
                .add("color", this.color)
                .add("style", this.style)
                .add("children", this.children)
                .add("clickAction", this.clickAction)
                .add("hoverAction", this.hoverAction)
                .add("shiftClickAction", this.shiftClickAction)
                .toString();
    }

    /**
     * Represents a {@link TextBuilder} creating immutable {@link Text.Literal}
     * instances.
     *
     * @see Text.Literal
     */
    public static class Literal extends TextBuilder {

        protected String content;

        /**
         * Constructs a new empty {@link Literal}.
         */
        public Literal() {
            this("");
        }

        /**
         * Constructs a new unformatted {@link Literal} with the given content.
         *
         * @param content The content for the text builder
         */
        public Literal(String content) {
            content(content);
        }

        /**
         * Constructs a new {@link Literal} with the formatting and actions of
         * the specified {@link Text} and the given content.
         *
         * @param text The text to apply the properties from
         * @param content The content for the text builder
         */
        public Literal(Text text, String content) {
            super(text);
            content(content);
        }

        /**
         * Constructs a new {@link Literal} with the formatting, actions and
         * content of the specified {@link Text.Literal}.
         *
         * @param text The text to apply the properties from
         */
        public Literal(Text.Literal text) {
            super(text);
            this.content = text.content;
        }

        /**
         * Returns the current content of this builder.
         *
         * @return The current content
         * @see Text.Literal#getContent()
         */
        public final String getContent() {
            return this.content;
        }

        /**
         * Sets the plain text content of this text.
         *
         * @param content The content of this text
         * @return This text builder
         * @see Text.Literal#getContent()
         */
        public Literal content(String content) {
            this.content = checkNotNull(content, "content");
            return this;
        }

        @Override
        public Text.Literal build() {
            // Special case for empty builder
            if (this.content.isEmpty() && this.color == TextColors.NONE && this.style.isEmpty() && this.children.isEmpty()
                    && this.clickAction == null && this.hoverAction == null && this.shiftClickAction == null) {
                return Texts.EMPTY;
            }

            return new Text.Literal(
                    this.color,
                    this.style,
                    ImmutableList.copyOf(this.children),
                    this.clickAction,
                    this.hoverAction,
                    this.shiftClickAction,
                    this.content);
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
            return Objects.equal(this.content, that.content);

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

        @Override
        public Literal color(TextColor color) {
            return (Literal) super.color(color);
        }

        @Override
        public Literal style(TextStyle... styles) {
            return (Literal) super.style(styles);
        }

        @Override
        public Literal onClick(@Nullable ClickAction<?> clickAction) {
            return (Literal) super.onClick(clickAction);
        }

        @Override
        public Literal onHover(@Nullable HoverAction<?> hoverAction) {
            return (Literal) super.onHover(hoverAction);
        }

        @Override
        public Literal onShiftClick(@Nullable ShiftClickAction<?> shiftClickAction) {
            return (Literal) super.onShiftClick(shiftClickAction);
        }

        @Override
        public Literal append(Text... children) {
            return (Literal) super.append(children);
        }

        @Override
        public Literal append(Iterable<? extends Text> children) {
            return (Literal) super.append(children);
        }

        @Override
        public Literal insert(int pos, Text... children) {
            return (Literal) super.insert(pos, children);
        }

        @Override
        public Literal insert(int pos, Iterable<? extends Text> children) {
            return (Literal) super.insert(pos, children);
        }

        @Override
        public Literal remove(Text... children) {
            return (Literal) super.remove(children);
        }

        @Override
        public Literal remove(Iterable<? extends Text> children) {
            return (Literal) super.remove(children);
        }

        @Override
        public Literal removeAll() {
            return (Literal) super.removeAll();
        }

    }

    /**
     * Represents a {@link TextBuilder} creating immutable
     * {@link Text.Translatable} instances.
     *
     * @see Text.Translatable
     */
    public static class Translatable extends TextBuilder {

        protected Translation translation;
        protected ImmutableList<Object> arguments;

        /**
         * Constructs a new unformatted {@link Translatable} with the given
         * {@link Translation} and arguments.
         *
         * @param translation The translation for the builder
         * @param args The arguments for the translation
         */
        public Translatable(Translation translation, Object... args) {
            translation(translation, args);
        }

        /**
         * Constructs a new unformatted {@link TextBuilder.Translatable} from
         * the given {@link org.spongepowered.api.text.translation.Translatable}
         * .
         *
         * @param translatable The translatable for the builder
         * @param args The arguments for the translation
         */
        public Translatable(org.spongepowered.api.text.translation.Translatable translatable, Object... args) {
            translation(translatable, args);
        }

        /**
         * Constructs a new {@link Translatable} with the formatting and actions
         * of the specified {@link Text} and the given {@link Translation} and
         * arguments.
         *
         * @param text The text to apply the properties from
         * @param translation The translation for the builder
         * @param args The arguments for the translation
         */
        public Translatable(Text text, Translation translation, Object... args) {
            super(text);
            translation(translation, args);
        }

        /**
         * Constructs a new {@link Translatable} with the formatting and actions
         * of the specified {@link Text} and the given
         * {@link org.spongepowered.api.text.translation.Translatable}.
         *
         * @param text The text to apply the properties from
         * @param translatable The translatable for the builder
         * @param args The arguments for the translation
         */
        public Translatable(Text text, org.spongepowered.api.text.translation.Translatable translatable, Object... args) {
            super(text);
            translation(translatable, args);
        }

        /**
         * Constructs a new {@link Translatable} with the formatting, actions
         * and translation of the specified {@link Text.Translatable}.
         *
         * @param text The text to apply the properties from
         */
        public Translatable(Text.Translatable text) {
            super(text);
            this.translation = text.translation;
            this.arguments = text.arguments;
        }

        /**
         * Returns the current translation of this builder.
         *
         * @return The current content
         * @see Text.Translatable#getTranslation()
         */
        public final Translation getTranslation() {
            return this.translation;
        }

        /**
         * Returns the current translation arguments of this builder.
         *
         * @return The current translation arguments
         * @see Text.Translatable#getArguments()
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
        public Translatable translation(Translation translation, Object... args) {
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
        public Translatable translation(org.spongepowered.api.text.translation.Translatable translatable, Object... args) {
            return translation(checkNotNull(translatable, "translatable").getTranslation(), args);
        }

        @Override
        public Text.Translatable build() {
            return new Text.Translatable(
                    this.color,
                    this.style,
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
            if (!(o instanceof Translatable) || !super.equals(o)) {
                return false;
            }

            Translatable that = (Translatable) o;
            return Objects.equal(this.translation, that.translation)
                    && Objects.equal(this.arguments, that.arguments);

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

        @Override
        public Translatable color(TextColor color) {
            return (Translatable) super.color(color);
        }

        @Override
        public Translatable style(TextStyle... styles) {
            return (Translatable) super.style(styles);
        }

        @Override
        public Translatable onClick(@Nullable ClickAction<?> clickAction) {
            return (Translatable) super.onClick(clickAction);
        }

        @Override
        public Translatable onHover(@Nullable HoverAction<?> hoverAction) {
            return (Translatable) super.onHover(hoverAction);
        }

        @Override
        public Translatable onShiftClick(@Nullable ShiftClickAction<?> shiftClickAction) {
            return (Translatable) super.onShiftClick(shiftClickAction);
        }

        @Override
        public Translatable append(Text... children) {
            return (Translatable) super.append(children);
        }

        @Override
        public Translatable append(Iterable<? extends Text> children) {
            return (Translatable) super.append(children);
        }

        @Override
        public Translatable insert(int pos, Text... children) {
            return (Translatable) super.insert(pos, children);
        }

        @Override
        public Translatable insert(int pos, Iterable<? extends Text> children) {
            return (Translatable) super.insert(pos, children);
        }

        @Override
        public Translatable remove(Text... children) {
            return (Translatable) super.remove(children);
        }

        @Override
        public Translatable remove(Iterable<? extends Text> children) {
            return (Translatable) super.remove(children);
        }

        @Override
        public Translatable removeAll() {
            return (Translatable) super.removeAll();
        }

    }

    /**
     * Represents a {@link TextBuilder} creating immutable {@link Text.Selector}
     * instances.
     *
     * @see Text.Selector
     */
    public static class Selector extends TextBuilder {

        protected org.spongepowered.api.text.selector.Selector selector;

        /**
         * Constructs a new unformatted {@link Selector} with the given
         * selector.
         *
         * @param selector The selector for the builder
         */
        public Selector(org.spongepowered.api.text.selector.Selector selector) {
            selector(selector);
        }

        /**
         * Constructs a new {@link Selector} with the formatting and actions of
         * the specified {@link Text} and the given selector.
         *
         * @param text The text to apply the properties from
         * @param selector The selector for the builder
         */
        public Selector(Text text, org.spongepowered.api.text.selector.Selector selector) {
            super(text);
            selector(selector);
        }

        /**
         * Constructs a new {@link Selector} with the formatting, actions and
         * selector of the specified {@link Text.Selector}.
         *
         * @param text The text to apply the properties from
         */
        public Selector(Text.Selector text) {
            super(text);
            this.selector = text.selector;
        }

        /**
         * Returns the current selector of this builder.
         *
         * @return The current selector
         * @see Text.Selector#getSelector()
         */
        public final org.spongepowered.api.text.selector.Selector getSelector() {
            return this.selector;
        }

        /**
         * Sets the selector of the text.
         *
         * @param selector The selector for this builder to use
         * @return This text builder
         * @see Text.Selector#getSelector()
         */
        public Selector selector(org.spongepowered.api.text.selector.Selector selector) {
            this.selector = checkNotNull(selector, "selector");
            return this;
        }

        @Override
        public Text.Selector build() {
            return new Text.Selector(
                    this.color,
                    this.style,
                    ImmutableList.copyOf(this.children),
                    this.clickAction,
                    this.hoverAction,
                    this.shiftClickAction,
                    this.selector);
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
            return Objects.equal(this.selector, that.selector);

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

        @Override
        public Selector color(TextColor color) {
            return (Selector) super.color(color);
        }

        @Override
        public Selector style(TextStyle... styles) {
            return (Selector) super.style(styles);
        }

        @Override
        public Selector onClick(@Nullable ClickAction<?> clickAction) {
            return (Selector) super.onClick(clickAction);
        }

        @Override
        public Selector onHover(@Nullable HoverAction<?> hoverAction) {
            return (Selector) super.onHover(hoverAction);
        }

        @Override
        public Selector onShiftClick(@Nullable ShiftClickAction<?> shiftClickAction) {
            return (Selector) super.onShiftClick(shiftClickAction);
        }

        @Override
        public Selector append(Text... children) {
            return (Selector) super.append(children);
        }

        @Override
        public Selector append(Iterable<? extends Text> children) {
            return (Selector) super.append(children);
        }

        @Override
        public Selector insert(int pos, Text... children) {
            return (Selector) super.insert(pos, children);
        }

        @Override
        public Selector insert(int pos, Iterable<? extends Text> children) {
            return (Selector) super.insert(pos, children);
        }

        @Override
        public Selector remove(Text... children) {
            return (Selector) super.remove(children);
        }

        @Override
        public Selector remove(Iterable<? extends Text> children) {
            return (Selector) super.remove(children);
        }

        @Override
        public Selector removeAll() {
            return (Selector) super.removeAll();
        }

    }

    /**
     * Represents a {@link TextBuilder} creating immutable {@link Text.Score}
     * instances.
     *
     * @see Text.Score
     */
    public static class Score extends TextBuilder {

        // TODO: Update with Statistic API
        protected Object score;
        @Nullable protected String override;

        /**
         * Constructs a new unformatted {@link Score} with the given score.
         *
         * @param score The score for the text builder
         */
        public Score(Object score) {
            score(score);
        }

        /**
         * Constructs a new {@link Score} with the formatting and actions of the
         * specified {@link Text} and the given score.
         *
         * @param text The text to apply the properties from
         * @param score The score for the text builder
         */
        public Score(Text text, Object score) {
            super(text);
            score(score);
        }

        /**
         * Constructs a new {@link Score} with the formatting, actions and score
         * of the specified {@link Text.Score}.
         *
         * @param text The text to apply the properties from
         */
        public Score(Text.Score text) {
            super(text);
            this.score = text.score;
            this.override = text.override.orNull();
        }

        /**
         * Returns the current score of this builder.
         *
         * @return The current score
         * @see Text.Score#getScore()
         */
        public final Object getScore() {
            return this.score;
        }

        /**
         * Sets the score of the text.
         *
         * @param score The score for this builder to use
         * @return This text builder
         * @see Text.Score#getScore()
         */
        public Score score(Object score) {
            this.score = checkNotNull(score, "score");
            return this;
        }

        /**
         * Returns the current override of this builder.
         *
         * @return The current override, or {@link Optional#absent()} if none
         * @see Text.Score#getOverride()
         */
        public final Optional<String> getOverride() {
            return Optional.fromNullable(this.override);
        }

        /**
         * Overrides the real score and displays a custom text instead.
         *
         * @param override The text to override the score with or {@code null}
         *        to reset
         * @return This text builder
         * @see Text.Score#getOverride()
         */
        public Score override(@Nullable String override) {
            this.override = override;
            return this;
        }

        @Override
        public Text.Score build() {
            return new Text.Score(
                    this.color,
                    this.style,
                    ImmutableList.copyOf(this.children),
                    this.clickAction,
                    this.hoverAction,
                    this.shiftClickAction,
                    this.score,
                    this.override);
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
            return Objects.equal(this.score, that.score)
                    && Objects.equal(this.override, that.override);
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

        @Override
        public Score color(TextColor color) {
            return (Score) super.color(color);
        }

        @Override
        public Score style(TextStyle... styles) {
            return (Score) super.style(styles);
        }

        @Override
        public Score onClick(@Nullable ClickAction<?> clickAction) {
            return (Score) super.onClick(clickAction);
        }

        @Override
        public Score onHover(@Nullable HoverAction<?> hoverAction) {
            return (Score) super.onHover(hoverAction);
        }

        @Override
        public Score onShiftClick(@Nullable ShiftClickAction<?> shiftClickAction) {
            return (Score) super.onShiftClick(shiftClickAction);
        }

        @Override
        public Score append(Text... children) {
            return (Score) super.append(children);
        }

        @Override
        public Score append(Iterable<? extends Text> children) {
            return (Score) super.append(children);
        }

        @Override
        public Score insert(int pos, Text... children) {
            return (Score) super.insert(pos, children);
        }

        @Override
        public Score insert(int pos, Iterable<? extends Text> children) {
            return (Score) super.insert(pos, children);
        }

        @Override
        public Score remove(Text... children) {
            return (Score) super.remove(children);
        }

        @Override
        public Score remove(Iterable<? extends Text> children) {
            return (Score) super.remove(children);
        }

        @Override
        public Score removeAll() {
            return (Score) super.removeAll();
        }

    }

}
