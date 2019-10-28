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

import com.google.common.collect.ImmutableList;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.scoreboard.Score;
import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.ShiftClickAction;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextFormat;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.selector.Selector;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.Nameable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Represents an immutable tree-structure of formatted (text) components. Each
 * instance consists of content and a list of children texts appended after the
 * content of this text. The content of the text is available through one of the
 * subclasses.
 *
 * <p>Text is primarily used for sending formatted chat messages to players, but
 * also in other places like books or signs.</p>
 *
 * <p>Text instances can be created through the available {@link #empty()} methods
 * or using one of the {@link Builder}s available through one of the
 * {@link #builder()} methods.</p>
 *
 * @see Text#builder()
 * @see Builder
 * @see LiteralText
 * @see TranslatableText
 * @see SelectorText
 * @see ScoreText
 */
public interface Text extends Comparable<Text>, DataSerializable, TextRepresentable {

    /**
     * Returns an empty, unformatted {@link Text} instance.
     *
     * @return An empty text
     */
    static Text empty() {
        return LiteralText.builder().build();
    }

    /**
     * Returns an empty, unformatted {@link Text} instance.
     *
     * @return An empty text
     */
    static Text newLine() {
        return LiteralText.builder().newLine().build();
    }

    /**
     * Creates a {@link Text} with the specified plain text. The created text
     * won't have any formatting or events configured.
     *
     * @param content The content of the text
     * @return The created text
     * @see LiteralText
     */
    static LiteralText of(String content) {
        return LiteralText.of(content);
    }

    /**
     * Creates a {@link Text} with the specified char as plain text. The created
     * text won't have any formatting or events configured.
     *
     * @param content The content of the text as char
     * @return The created text
     * @see LiteralText
     */
    static LiteralText of(char content) {
        return LiteralText.of(content);
    }

    /**
     * Creates a new unformatted {@link TranslatableText} with the given
     * {@link Translation}.
     *
     * @param translation The translation for the text
     * @return The created text
     * @see TranslatableText
     */
    static TranslatableText of(Translation translation) {
        return builder(translation).build();
    }

    /**
     * Creates a new unformatted {@link TranslatableText} with the given
     * {@link Translation}.
     *
     * @param nameable The translatable nameable for the text
     * @return The created text
     * @see TranslatableText
     */
    static TranslatableText of(Nameable.Translatable nameable) {
        return builder(nameable).build();
    }

    /**
     * Creates a new {@link Text} from the given {@link Nameable}.
     *
     * @param nameable The nameable for the text
     * @return The created text
     */
    static Text of(Nameable nameable) {
        checkNotNull(nameable, "nameable");
        if (nameable instanceof Nameable.Translatable) {
            return of(((Nameable.Translatable) nameable).getNameTranslation());
        }
        return of(nameable.getName());
    }

    /**
     * Creates a new unformatted {@link SelectorText} with the given selector.
     *
     * @param selector The selector for the text
     * @return The created text
     * @see SelectorText
     */
    static SelectorText of(Selector selector) {
        return SelectorText.of(selector);
    }

    /**
     * Creates a new unformatted {@link ScoreText} with the given score.
     *
     * @param score The score for the text
     * @return The created text
     * @see ScoreText
     */
    static ScoreText of(Score score) {
        return ScoreText.of(score);
    }

    /**
     * Builds a {@link Text} from a given array of objects.
     *
     * <p>For instance, you can use this like
     * <code>Text.of(TextColors.DARK_AQUA, "Hi", TextColors.AQUA, "Bye")</code>
     * </p>
     *
     * <p>This will create the correct {@link Text} instance if the input object
     * is the input for one of the {@link Text} types or convert the object to a
     * string otherwise.</p>
     *
     * <p>For instances of type {@link TextRepresentable} (e.g. {@link Text},
     * {@link Builder}, ...) the formatting of appended text has priority over
     * the current formatting in the method, e.g. the following results in a
     * green, then yellow and at the end green again {@link Text}:</p>
     *
     * <code>Text.of(TextColors.GREEN, "Hello ", Text.empty(TextColors.YELLOW,
     * "Spongie"), '!');</code>
     *
     * @param objects The object array
     * @return The built text object
     */
    static Text of(Object... objects) {
        return Sponge.getRegistry().requireFactory(Factory.class).of(objects);
    }

    /**
     * Creates a {@link Text.Builder} with empty text.
     *
     * @return A new text builder with empty text
     */
    static Builder builder() {
        return LiteralText.builder();
    }

    /**
     * Creates a new unformatted {@link LiteralText.Builder} with the specified
     * content.
     *
     * @param content The content of the text
     * @return The created text builder
     * @see LiteralText
     * @see LiteralText.Builder
     */
    static LiteralText.Builder builder(String content) {
        return LiteralText.builder(content);
    }

    /**
     * Creates a new unformatted {@link LiteralText.Builder} with the specified
     * content.
     *
     * @param content The content of the text as char
     * @return The created text builder
     * @see LiteralText
     * @see LiteralText.Builder
     */
    static LiteralText.Builder builder(char content) {
        return LiteralText.builder(content);
    }

    /**
     * Creates a new unformatted {@link SelectorText.Builder} with the given
     * selector.
     *
     * @param selector The selector for the builder
     * @return The created text builder
     * @see SelectorText
     * @see SelectorText.Builder
     */
    static SelectorText.Builder builder(Selector selector) {
        return SelectorText.builder(selector);
    }

    /**
     * Creates a new unformatted {@link ScoreText.Builder} with the given score.
     *
     * @param score The score for the text builder
     * @return The created text builder
     * @see ScoreText
     * @see ScoreText.Builder
     */
    static ScoreText.Builder builder(Score score) {
        return ScoreText.builder(score);
    }

    /**
     * Creates a new unformatted {@link TranslatableText} builder with the given
     * {@link Translation} and arguments.
     *
     * @param translation The translation for the text
     * @param args The arguments for the translation
     * @return The created text
     */
    static TranslatableText.Builder builder(Translation translation, Object... args) {
        return TranslatableText.builder(translation, args);
    }

    /**
     * Creates a new unformatted {@link TranslatableText} from the given
     * {@link org.spongepowered.api.util.Nameable.Translatable}.
     *
     * @param nameable The translatable nameable for the text
     * @param args The arguments for the translation
     * @return The created text
     */
    static TranslatableText.Builder builder(Nameable.Translatable nameable, Object... args) {
        return TranslatableText.builder(nameable, args);
    }

    /**
     * Joins a sequence of text objects together.
     *
     * @param texts The texts to join
     * @return A text object that joins the given text objects
     */
    static Text join(Text... texts) {
        return builder().append(texts).build();
    }

    /**
     * Joins a sequence of text objects together.
     *
     * @param texts The texts to join
     * @return A text object that joins the given text objects
     */
    static Text join(Iterable<? extends Text> texts) {
        return builder().append(texts).build();
    }

    /**
     * Joins a sequence of text objects together.
     *
     * @param texts The texts to join
     * @return A text object that joins the given text objects
     */
    static Text join(Iterator<? extends Text> texts) {
        return builder().append(texts).build();
    }

    /**
     * Joins a sequence of text objects together along with a separator.
     *
     * @param separator The separator
     * @param texts The texts to join
     * @return A text object that joins the given text objects
     */
    static Text joinWith(Text separator, Text... texts) {
        return Sponge.getRegistry().requireFactory(Factory.class).joinWith(separator, texts);
    }

    /**
     * Joins a sequence of text objects together along with a separator.
     *
     * @param separator The separator
     * @param texts The texts to join
     * @return A text object that joins the given text objects
     */
    static Text joinWith(Text separator, Iterable<? extends Text> texts) {
        return joinWith(separator, texts.iterator());
    }

    /**
     * Joins a sequence of text objects together along with a separator.
     *
     * @param separator The separator
     * @param texts An iterator for the texts to join
     * @return A text object that joins the given text objects
     */
    static Text joinWith(Text separator, Iterator<? extends Text> texts) {
        return Sponge.getRegistry().requireFactory(Factory.class).joinWith(separator, texts);
    }

    /**
     * Returns the format of this {@link Text}.
     *
     * @return The format of this text
     */
    TextFormat getFormat();

    /**
     * Returns the color of this {@link Text}.
     *
     * @return The color of this text
     */
    TextColor getColor();

    /**
     * Returns the style of this {@link Text}. This will return a compound
     * {@link TextStyle} if multiple different styles have been set.
     *
     * @return The style of this text
     */
    TextStyle getStyle();

    /**
     * Returns the immutable list of children appended after the content empty this
     * {@link Text}.
     *
     * @return The immutable list of children
     */
    ImmutableList<Text> getChildren();

    /**
     * Returns an immutable {@link Iterable} over this text and all of its
     * children. This is recursive, the children of the children will be also
     * included.
     *
     * @return An iterable over this text and the children texts
     */
    Iterable<Text> withChildren();

    /**
     * Returns the {@link ClickAction} executed on the client when this
     * {@link Text} gets clicked.
     *
     * @return The click action of this text, or {@link Optional#empty()} if not
     *         set
     */
    Optional<ClickAction<?>> getClickAction();

    /**
     * Returns the {@link HoverAction} executed on the client when this
     * {@link Text} gets hovered.
     *
     * @return The hover action of this text, or {@link Optional#empty()} if not
     *         set
     */
    Optional<HoverAction<?>> getHoverAction();

    /**
     * Returns the {@link ShiftClickAction} executed on the client when this
     * {@link Text} gets shift-clicked.
     *
     * @return The shift-click action of this text, or {@link Optional#empty()}
     *         if not set
     */
    Optional<ShiftClickAction<?>> getShiftClickAction();

    /**
     * Returns whether this {@link Text} is empty.
     *
     * @return {@code true} if this text is empty
     */
    boolean isEmpty();

    /**
     * Returns a new {@link Builder} with the content, formatting and actions of
     * this text. This can be used to edit an otherwise immutable {@link Text}
     * instance.
     *
     * @return A new message builder with the content of this text
     */
    Builder toBuilder();

    /**
     * Returns a plain text representation of this {@link Text} without any
     * formatting.
     *
     * @return This text converted to plain text
     */
    String toPlain();

    /**
     * Returns a plain text representation of this {@link Text} without any
     * children.
     *
     * @return This text (without children) converted to plain text
     */
    String toPlainSingle();

    /**
     * Concatenates the specified {@link Text} to this Text and returns the
     * result.
     *
     * @param other To concatenate
     * @return Concatenated text
     */
    Text concat(Text other);

    /**
     * Removes all empty texts from the beginning and end of this
     * text.
     *
     * @return Text result
     */
    Text trim();

    /**
     * Replaces a pattern in this text with a {@link Text}, preserving
     * formatting where possible.
     *
     * <p>If {@code lossy} is true, this will replace the pattern if this finds
     * it spanning multiple child {@link Text}s, resulting in a potential loss
     * of formatting; if false, it will only replace the pattern where it is
     * contained within one child {@link Text}, to preserve all formatting.</p>
     *
     * <p>This method produces a copy with the specified replacements. The
     * original is not modified.</p>
     *
     * @param oldValue The pattern to replace
     * @param newValue The value to replace with
     * @param lossy Whether lossy mode is enabled
     * @return The resulting (copied) text
     */
    Text replace(Pattern oldValue, Text newValue, boolean lossy);

    /**
     * Replaces a pattern in this text with a {@link Text}, preserving all
     * formatting.
     *
     * <p>This method produces a copy with the specified replacements. The
     * original is not modified.</p>
     *
     * @param oldValue The pattern to replace
     * @param newValue The value to replace with
     * @return The resulting (copied) text
     */
    Text replace(Pattern oldValue, Text newValue);

    /**
     * Replaces a string within this text with a {@link Text}, preserving
     * formatting where possible.
     *
     * <p>If {@code lossy} is true, this will replace the pattern if this finds
     * it spanning multiple child {@link Text}s, resulting in a potential loss
     * of formatting; if false, it will only replace the pattern where it is
     * contained within one child {@link Text}, to preserve all formatting.</p>
     *
     * <p>This method produces a copy with the specified replacements. The
     * original is not modified.</p>
     *
     * @param oldValue The string to replace
     * @param newValue The value to replace with
     * @param lossy Whether lossy mode is enabled
     * @return The resulting (copied) text
     */
    Text replace(String oldValue, Text newValue, boolean lossy);

    /**
     * Replaces a string within this text with a {@link Text}, preserving all
     * formatting.
     *
     * <p>This method produces a copy with the specified replacements. The
     * original is not modified.</p>
     *
     * @param oldValue The string to replace
     * @param newValue The value to replace with
     * @return The resulting (copied) text
     */
    Text replace(String oldValue, Text newValue);

    @Override
    default Text toText() {
        return this;
    }

    /**
     * Represents a builder class to create immutable {@link Text} instances.
     *
     * @see Text
     */
    interface Builder extends CopyableBuilder<Text, Builder>, TextRepresentable {

        /**
         * Returns the current format of the {@link Text} in this builder.
         *
         * @return The current format
         * @see Text#getFormat()
         */
        TextFormat getFormat();

        /**
         * Sets the {@link TextFormat} of this text.
         *
         * @param format The new text format for this text
         * @return The text builder
         * @see Text#getFormat()
         */
        Builder format(TextFormat format);

        /**
         * Returns the current color of the {@link Text} in this builder.
         *
         * @return The current color
         * @see Text#getColor()
         */
        TextColor getColor();

        /**
         * Sets the {@link TextColor} of this text.
         *
         * @param color The new text color for this text
         * @return This text builder
         * @see Text#getColor()
         */
        Builder color(TextColor color);

        /**
         * Returns the current style of the {@link Text} in this builder.
         *
         * @return The current style
         * @see Text#getStyle()
         */
        TextStyle getStyle();

        /**
         * Sets the text styles of this text. This will construct a composite
         * {@link TextStyle} of the current style and the specified styles first
         * and set it to the text.
         *
         * @param styles The text styles to apply
         * @return This text builder
         * @see Text#getStyle()
         */
        // TODO: Make sure this is the correct behaviour
        Builder style(TextStyle... styles) ;

        /**
         * Returns the current {@link ClickAction} of this builder.
         *
         * @return The current click action or {@link Optional#empty()} if none
         * @see Text#getClickAction()
         */
        Optional<ClickAction<?>> getClickAction();

        /**
         * Sets the {@link ClickAction} that will be executed if the text is
         * clicked in the chat.
         *
         * @param clickAction The new click action for the text
         * @return This text builder
         * @see Text#getClickAction()
         */
        Builder onClick(@Nullable ClickAction<?> clickAction);

        /**
         * Returns the current {@link HoverAction} of this builder.
         *
         * @return The current hover action or {@link Optional#empty()} if none
         * @see Text#getHoverAction()
         */
        Optional<HoverAction<?>> getHoverAction();

        /**
         * Sets the {@link HoverAction} that will be executed if the text is
         * hovered in the chat.
         *
         * @param hoverAction The new hover action for the text
         * @return This text builder
         * @see Text#getHoverAction()
         */
        Builder onHover(@Nullable HoverAction<?> hoverAction);

        /**
         * Returns the current {@link ShiftClickAction} of this builder.
         *
         * @return The current shift click action or {@link Optional#empty()} if
         *         none
         * @see Text#getShiftClickAction()
         */
        Optional<ShiftClickAction<?>> getShiftClickAction();

        /**
         * Sets the {@link ShiftClickAction} that will be executed if the text
         * is shift-clicked in the chat.
         *
         * @param shiftClickAction The new shift click action for the text
         * @return This text builder
         * @see Text#getShiftClickAction()
         */
        Builder onShiftClick(@Nullable ShiftClickAction<?> shiftClickAction);

        /**
         * Returns a view of the current children of this builder.
         *
         * <p>The returned list is unmodifiable, but not immutable. It will
         * change if new children get added through this builder.</p>
         *
         * @return An unmodifiable list of the current children
         * @see Text#getChildren()
         */
        List<Text> getChildren();

        /**
         * Appends the specified {@link Text} to the end of this text.
         *
         * @param children The texts to append
         * @return This text builder
         * @see Text#getChildren()
         */
        Builder append(Text... children);

        /**
         * Appends the specified {@link Text} to the end of this text.
         *
         * @param children The texts to append
         * @return This text builder
         * @see Text#getChildren()
         */
        Builder append(Collection<? extends Text> children);

        /**
         * Appends the specified {@link Text} to the end of this text.
         *
         * @param children The texts to append
         * @return This text builder
         * @see Text#getChildren()
         */
        Builder append(Iterable<? extends Text> children);

        /**
         * Appends the specified {@link Text} to the end of this text.
         *
         * @param children The texts to append
         * @return This text builder
         * @see Text#getChildren()
         */
        Builder append(Iterator<? extends Text> children);

        /**
         * Inserts the specified {@link Text} at the given position of this
         * builder.
         *
         * @param pos The position to insert the texts to
         * @param children The texts to insert
         * @return This text builder
         * @throws IndexOutOfBoundsException If the position is out of bounds
         * @see Text#getChildren()
         */
        Builder insert(int pos, Text... children);

        /**
         * Inserts the specified {@link Text} at the given position of this
         * builder.
         *
         * @param pos The position to insert the texts to
         * @param children The texts to insert
         * @return This text builder
         * @throws IndexOutOfBoundsException If the position is out of range
         * @see Text#getChildren()
         */
        Builder insert(int pos, Collection<? extends Text> children);

        /**
         * Inserts the specified {@link Text} at the given position of this
         * builder.
         *
         * @param pos The position to insert the texts to
         * @param children The texts to insert
         * @return This text builder
         * @throws IndexOutOfBoundsException If the position is out of range
         * @see Text#getChildren()
         */
        Builder insert(int pos, Iterable<? extends Text> children);

        /**
         * Inserts the specified {@link Text} at the given position of this
         * builder.
         *
         * @param pos The position to insert the texts to
         * @param children The texts to insert
         * @return This text builder
         * @throws IndexOutOfBoundsException If the position is out of range
         * @see Text#getChildren()
         */
        Builder insert(int pos, Iterator<? extends Text> children);

        /**
         * Removes the last child in this builder.
         *
         * @return This text builder
         * @see #remove(int)
         */
        Builder removeLastChild();

        /**
         * Removes the child at the given index.
         *
         * @param index The index of the child
         * @return This text builder
         * @throws IndexOutOfBoundsException if the given index is out of bounds
         */
        Builder remove(int index);

        /**
         * Removes the specified {@link Text} from this builder.
         *
         * @param children The texts to remove
         * @return This text builder
         * @see Text#getChildren()
         */
        Builder remove(Text... children);

        /**
         * Removes the specified {@link Text} from this builder.
         *
         * @param children The texts to remove
         * @return This text builder
         * @see Text#getChildren()
         */
        Builder remove(Collection<? extends Text> children);

        /**
         * Removes the specified {@link Text} from this builder.
         *
         * @param children The texts to remove
         * @return This text builder
         * @see Text#getChildren()
         */
        Builder remove(Iterable<? extends Text> children);

        /**
         * Removes the specified {@link Text} from this builder.
         *
         * @param children The texts to remove
         * @return This text builder
         * @see Text#getChildren()
         */
        Builder remove(Iterator<? extends Text> children);

        /**
         * Removes all children from this builder.
         *
         * @return This text builder
         * @see Text#getChildren()
         */
        Builder removeAll();

        /**
         * Removes all empty texts from the beginning and end of this
         * builder.
         *
         * @return This builder
         */
        Builder trim();

        /**
         * Builds an immutable instance of the current state of this text
         * builder.
         *
         * @return An immutable {@link Text} with the current properties of this
         *         builder
         */
        Text build();
    }

    interface Factory {
        Text of(Object... objects);

        Text joinWith(Text separator, Text... texts);

        Text joinWith(Text separator, Iterator<? extends Text> texts);
    }
}
