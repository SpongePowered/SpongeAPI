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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.spongepowered.api.scoreboard.Score;
import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.ShiftClickAction;
import org.spongepowered.api.text.action.TextAction;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextFormat;
import org.spongepowered.api.text.format.TextProperty;
import org.spongepowered.api.text.format.TextStyle;
import org.spongepowered.api.text.format.TextStyles;
import org.spongepowered.api.text.selector.Selector;
import org.spongepowered.api.text.serializer.TextSerializers;
import org.spongepowered.api.text.transformer.Transformer;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.Functional;
import org.spongepowered.api.util.Functions;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.annotation.Nullable;

/**
 * Represents an immutable tree-structure of formatted (text) components. Each
 * instance consists of content and a list of children texts appended after the
 * content of this text. The content of the text is available through one of the
 * subclasses.
 *
 * <p>Text is primarily used for sending formatted chat messages to players, but
 * also in other places like books or signs.</p>
 *
 * <p>Text instances can be created through the available {@link #of()} methods
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
public abstract class Text implements TextRepresentable {

    /**
     * The empty, unformatted {@link Text} instance.
     */
    public static final Text EMPTY = LiteralText.EMPTY;

    public static final Text DEFAULT_SEPARATOR = new LiteralText(", ");

    /**
     * Format indicator for {@link Text#of(Object...)} to append the following
     * {@link TextRepresentable}s. This has no effect on none
     * {@link TextRepresentable} instances.
     */
    public static final TextProperty APPEND_TEXTS = new TextProperty() {
    };
    /**
     * Format indicator for {@link Text#of(Object...)} to apply the specified
     * format to the following {@link Text}s.This has no effect on none
     * {@link TextRepresentable} instances.
     */
    public static final TextProperty FORMAT_TEXTS = new TextProperty() {
    };
    /**
     * Format indicator for {@link Text#of(Object...)} to mark the format as
     * changed so it will be appended if not followed by a none
     * {@link TextProperty}.
     */
    public static final TextProperty MARK_CHANGED = new TextProperty() {
    };

    static final char NEW_LINE_CHAR = '\n';
    static final String NEW_LINE_STRING = "\n";

    /**
     * An unformatted {@link Text} that will start a new line (if supported).
     */
    public static final LiteralText NEW_LINE = new LiteralText(NEW_LINE_STRING);

    /**
     * A {@link Comparator} for texts that compares the plain text of two text
     * instances.
     */
    public static Comparator<Text> PLAIN_COMPARATOR = (text1, text2) -> text1.toPlain().compareTo(text2.toPlain());

    final TextFormat format;
    final ImmutableList<Text> children;
    final Optional<ClickAction<?>> clickAction;
    final Optional<HoverAction<?>> hoverAction;
    final Optional<ShiftClickAction<?>> shiftClickAction;

    /**
     * An {@link Iterable} providing an {@link Iterator} over this {@link Text}
     * as well as all children text and their children.
     */
    final Iterable<Text> childrenIterable;

    Text() {
        this.format = TextFormat.NONE; // TODO
        this.children = ImmutableList.of();
        this.clickAction = Optional.empty();
        this.hoverAction = Optional.empty();
        this.shiftClickAction = Optional.empty();
        this.childrenIterable = () -> Iterators.singletonIterator(this);
    }

    /**
     * Constructs a new immutable {@link Text} with the specified formatting and
     * text actions applied.
     *
     * @param format The format of the text
     * @param children The immutable list of children of the text
     * @param clickAction The click action of the text, or {@code null} for none
     * @param hoverAction The hover action of the text, or {@code null} for none
     * @param shiftClickAction The shift click action of the text, or
     *        {@code null} for none
     */
    Text(TextFormat format, ImmutableList<Text> children, @Nullable ClickAction<?> clickAction,
            @Nullable HoverAction<?> hoverAction, @Nullable ShiftClickAction<?> shiftClickAction) {
        this.format = checkNotNull(format, "format");
        this.children = checkNotNull(children, "children");
        this.clickAction = Optional.ofNullable(clickAction);
        this.hoverAction = Optional.ofNullable(hoverAction);
        this.shiftClickAction = Optional.ofNullable(shiftClickAction);
        this.childrenIterable = () -> new TextIterator(this);
    }

    /**
     * Returns the format of this {@link Text}.
     *
     * @return The format of this text
     */
    public final TextFormat getFormat() {
        return this.format;
    }

    /**
     * Returns the color of this {@link Text}.
     *
     * @return The color of this text
     */
    public final TextColor getColor() {
        return this.format.getColor();
    }

    /**
     * Returns the style of this {@link Text}. This will return a compound
     * {@link TextStyle} if multiple different styles have been set.
     *
     * @return The style of this text
     */
    public final TextStyle getStyle() {
        return this.format.getStyle();
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
     * @return The click action of this text, or {@link Optional#empty()} if not
     *         set
     */
    public final Optional<ClickAction<?>> getClickAction() {
        return this.clickAction;
    }

    /**
     * Returns the {@link HoverAction} executed on the client when this
     * {@link Text} gets hovered.
     *
     * @return The hover action of this text, or {@link Optional#empty()} if not
     *         set
     */
    public final Optional<HoverAction<?>> getHoverAction() {
        return this.hoverAction;
    }

    /**
     * Returns the {@link ShiftClickAction} executed on the client when this
     * {@link Text} gets shift-clicked.
     *
     * @return The shift-click action of this text, or {@link Optional#empty()}
     *         if not set
     */
    public final Optional<ShiftClickAction<?>> getShiftClickAction() {
        return this.shiftClickAction;
    }

    /**
     * Returns whether this {@link Text} is empty.
     *
     * @return {@code true} if this text is empty
     */
    public final boolean isEmpty() {
        return this == EMPTY;
    }

    /**
     * Returns a new {@link Builder} with the content, formatting and actions of
     * this text. This can be used to edit an otherwise immutable {@link Text}
     * instance.
     *
     * @return A new message builder with the content of this text
     */
    public abstract Builder toBuilder();

    /**
     * Returns a plain text representation of this {@link Text} without any
     * formatting.
     *
     * @return This text converted to plain text
     */
    public final String toPlain() {
        return TextSerializers.PLAIN.serialize(this);
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Text)) {
            return false;
        }

        Text that = (Text) o;
        return this.format.equals(that.format)
                && this.children.equals(that.children)
                && this.clickAction.equals(that.clickAction)
                && this.hoverAction.equals(that.hoverAction)
                && this.shiftClickAction.equals(that.shiftClickAction);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.format, this.children, this.clickAction, this.hoverAction, this.shiftClickAction);
    }

    Objects.ToStringHelper toStringHelper() {
        return Objects.toStringHelper(Text.class)
                .omitNullValues()
                .add("format", this.format.isEmpty() ? null : this.format)
                .add("children", this.children.isEmpty() ? null : this.children)
                .add("clickAction", this.clickAction.orElse(null))
                .add("hoverAction", this.hoverAction.orElse(null))
                .add("shiftClickAction", this.shiftClickAction.orElse(null));
    }

    @Override
    public final String toString() {
        return toStringHelper().toString();
    }

    @Override
    public final Text toText() {
        return this;
    }

    /**
     * Represents a builder class to create immutable {@link Text} instances.
     *
     * @see Text
     */
    public static abstract class Builder implements TextRepresentable {

        TextFormat format = TextFormat.NONE;
        List<Text> children = new ArrayList<>();
        @Nullable ClickAction<?> clickAction;
        @Nullable HoverAction<?> hoverAction;
        @Nullable ShiftClickAction<?> shiftClickAction;

        /**
         * Constructs a new empty {@link Builder}.
         */
        Builder() {
        }

        /**
         * Constructs a new {@link Builder} with the properties of the given
         * {@link Text} as initial values.
         *
         * @param text The text to copy the values from
         */
        Builder(Text text) {
            this.format = text.format;
            this.children = new ArrayList<>(text.children);
            this.clickAction = text.clickAction.orElse(null);
            this.hoverAction = text.hoverAction.orElse(null);
            this.shiftClickAction = text.shiftClickAction.orElse(null);
        }

        /**
         * Returns the current format of the {@link Text} in this builder.
         *
         * @return The current format
         * @see Text#getFormat()
         */
        public final TextFormat getFormat() {
            return this.format;
        }

        /**
         * Sets the {@link TextFormat} of this text.
         *
         * @param format The new text format for this text
         * @return The text builder
         * @see Text#getFormat()
         */
        public Builder format(TextFormat format) {
            this.format = checkNotNull(format, "format");
            return this;
        }

        /**
         * Returns the current color of the {@link Text} in this builder.
         *
         * @return The current color
         * @see Text#getColor()
         */
        public final TextColor getColor() {
            return this.format.getColor();
        }

        /**
         * Sets the {@link TextColor} of this text.
         *
         * @param color The new text color for this text
         * @return This text builder
         * @see Text#getColor()
         */
        public Builder color(TextColor color) {
            this.format = this.format.color(color);
            return this;
        }

        /**
         * Returns the current style of the {@link Text} in this builder.
         *
         * @return The current style
         * @see Text#getStyle()
         */
        public final TextStyle getStyle() {
            return this.format.getStyle();
        }

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
        public Builder style(TextStyle... styles) {
            this.format = this.format.style(this.format.getStyle().and(styles));
            return this;
        }

        /**
         * Returns the current {@link ClickAction} of this builder.
         *
         * @return The current click action or {@link Optional#empty()} if none
         * @see Text#getClickAction()
         */
        public final Optional<ClickAction<?>> getClickAction() {
            return Optional.ofNullable(this.clickAction);
        }

        /**
         * Sets the {@link ClickAction} that will be executed if the text is
         * clicked in the chat.
         *
         * @param clickAction The new click action for the text
         * @return This text builder
         * @see Text#getClickAction()
         */
        public Builder onClick(@Nullable ClickAction<?> clickAction) {
            this.clickAction = clickAction;
            return this;
        }

        /**
         * Returns the current {@link HoverAction} of this builder.
         *
         * @return The current hover action or {@link Optional#empty()} if none
         * @see Text#getHoverAction()
         */
        public final Optional<HoverAction<?>> getHoverAction() {
            return Optional.ofNullable(this.hoverAction);
        }

        /**
         * Sets the {@link HoverAction} that will be executed if the text is
         * hovered in the chat.
         *
         * @param hoverAction The new hover action for the text
         * @return This text builder
         * @see Text#getHoverAction()
         */
        public Builder onHover(@Nullable HoverAction<?> hoverAction) {
            this.hoverAction = hoverAction;
            return this;
        }

        /**
         * Returns the current {@link ShiftClickAction} of this builder.
         *
         * @return The current shift click action or {@link Optional#empty()} if
         *         none
         * @see Text#getShiftClickAction()
         */
        public final Optional<ShiftClickAction<?>> getShiftClickAction() {
            return Optional.ofNullable(this.shiftClickAction);
        }

        /**
         * Sets the {@link ShiftClickAction} that will be executed if the text
         * is shift-clicked in the chat.
         *
         * @param shiftClickAction The new shift click action for the text
         * @return This text builder
         * @see Text#getShiftClickAction()
         */
        public Builder onShiftClick(@Nullable ShiftClickAction<?> shiftClickAction) {
            this.shiftClickAction = shiftClickAction;
            return this;
        }

        /**
         * Returns a view of the current children of this builder.
         *
         * <p>The returned list is unmodifiable, but not immutable. It will
         * change if new children get added through this builder.</p>
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
        public Builder append(Text... children) {
            Collections.addAll(this.children, children);
            return this;
        }

        /**
         * Appends the specified {@link Text} to the end of this text.
         *
         * @param children The texts to append
         * @return This text builder
         * @see Text#getChildren()
         */
        public Builder append(Collection<? extends Text> children) {
            this.children.addAll(children);
            return this;
        }

        /**
         * Appends the specified {@link Text} to the end of this text.
         *
         * @param children The texts to append
         * @return This text builder
         * @see Text#getChildren()
         */
        public Builder append(Iterable<? extends Text> children) {
            for (Text child : children) {
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
        public Builder append(Iterator<? extends Text> children) {
            while (children.hasNext()) {
                this.children.add(children.next());
            }
            return this;
        }

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
        public Builder insert(int pos, Text... children) {
            this.children.addAll(pos, Arrays.asList(children));
            return this;
        }

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
        public Builder insert(int pos, Collection<? extends Text> children) {
            this.children.addAll(pos, children);
            return this;
        }

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
        public Builder insert(int pos, Iterable<? extends Text> children) {
            for (Text child : children) {
                this.children.add(pos++, child);
            }
            return this;
        }

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
        public Builder insert(int pos, Iterator<? extends Text> children) {
            while (children.hasNext()) {
                this.children.add(pos++, children.next());
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
        public Builder remove(Text... children) {
            this.children.removeAll(Arrays.asList(children));
            return this;
        }

        /**
         * Removes the specified {@link Text} from this builder.
         *
         * @param children The texts to remove
         * @return This text builder
         * @see Text#getChildren()
         */
        public Builder remove(Collection<? extends Text> children) {
            this.children.removeAll(children);
            return this;
        }

        /**
         * Removes the specified {@link Text} from this builder.
         *
         * @param children The texts to remove
         * @return This text builder
         * @see Text#getChildren()
         */
        public Builder remove(Iterable<? extends Text> children) {
            for (Text child : children) {
                this.children.remove(child);
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
        public Builder remove(Iterator<? extends Text> children) {
            while (children.hasNext()) {
                this.children.remove(children.next());
            }
            return this;
        }

        /**
         * Removes all children from this builder.
         *
         * @return This text builder
         * @see Text#getChildren()
         */
        public Builder removeAll() {
            this.children.clear();
            return this;
        }

        /**
         * Builds an immutable instance of the current state of this text
         * builder.
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
            if (!(o instanceof Builder)) {
                return false;
            }

            Builder that = (Builder) o;
            return Objects.equal(this.format, that.format)
                    && Objects.equal(this.clickAction, that.clickAction)
                    && Objects.equal(this.hoverAction, that.hoverAction)
                    && Objects.equal(this.shiftClickAction, that.shiftClickAction)
                    && Objects.equal(this.children, that.children);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.format, this.clickAction, this.hoverAction, this.shiftClickAction, this.children);
        }

        Objects.ToStringHelper toStringHelper() {
            return Objects.toStringHelper(Builder.class)
                    .omitNullValues()
                    .add("format", this.format.isEmpty() ? null : this.format)
                    .add("children", this.children.isEmpty() ? null : this.children)
                    .add("clickAction", this.clickAction)
                    .add("hoverAction", this.hoverAction)
                    .add("shiftClickAction", this.shiftClickAction);
        }

        @Override
        public final String toString() {
            return toStringHelper().toString();
        }

        @Override
        public final Text toText() {
            return build();
        }

    }

    /**
     * Returns an empty, unformatted {@link Text} instance.
     *
     * @return An empty text
     */
    public static Text of() {
        return EMPTY;
    }

    /**
     * Creates a {@link Text} with the specified plain text. The created text
     * won't have any formatting or events configured.
     *
     * @param content The content of the text
     * @return The created text
     * @see LiteralText
     */
    public static LiteralText of(String content) {
        if (checkNotNull(content, "content").isEmpty()) {
            return LiteralText.EMPTY;
        } else if (content.equals(NEW_LINE_STRING)) {
            return NEW_LINE;
        } else {
            return new LiteralText(content);
        }
    }

    /**
     * Creates a {@link Text} with the specified char as plain text. The created
     * text won't have any formatting or events configured.
     *
     * @param content The contant of the text as char
     * @return The created text
     * @see LiteralText
     */
    public static LiteralText of(char content) {
        if (content == NEW_LINE_CHAR) {
            return NEW_LINE;
        } else {
            return new LiteralText(String.valueOf(content));
        }
    }

    /**
     * Creates a new unformatted {@link TranslatableText} with the given
     * {@link Translation} and arguments.
     *
     * @param translation The translation for the text
     * @param args The arguments for the translation
     * @return The created text
     * @see TranslatableText
     */
    public static TranslatableText of(Translation translation, Object... args) {
        return new TranslatableText(translation, ImmutableList.copyOf(checkNotNull(args, "args")));
    }

    /**
     * Creates a new unformatted {@link TranslatableText} from the given
     * {@link Translatable}.
     *
     * @param translatable The translatable for the text
     * @param args The arguments for the translation
     * @return The created text
     * @see TranslatableText
     */
    public static TranslatableText of(Translatable translatable, Object... args) {
        return of(checkNotNull(translatable, "translatable").getTranslation(), args);
    }

    /**
     * Creates a new unformatted {@link SelectorText} with the given selector.
     *
     * @param selector The selector for the text
     * @return The created text
     * @see SelectorText
     */
    public static SelectorText of(Selector selector) {
        return new SelectorText(selector);
    }

    /**
     * Creates a new unformatted {@link ScoreText} with the given score.
     *
     * @param score The score for the text
     * @return The created text
     * @see ScoreText
     */
    public static ScoreText of(Score score) {
        return new ScoreText(score);
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
     * @param objects The object array
     * @return The built text object
     */
    public static Text of(Object... objects) {
        // Shortcut for lonely TextRepresentables
        if (objects.length == 1 && objects[0] instanceof TextRepresentable && !(objects[0] instanceof TextProperty)) {
            return ((TextRepresentable) objects[0]).toText();
        }

        final Text.Builder builder = builder();
        TextFormat format = TextFormat.NONE;
        HoverAction<?> hoverAction = null;
        ClickAction<?> clickAction = null;
        ShiftClickAction<?> shiftClickAction = null;
        boolean changedFormat = false;
        boolean appendTexts = false;

        for (Object obj : objects) {
            if (obj instanceof TextProperty) {
                changedFormat = true;
                // Format indicators
                if (obj == APPEND_TEXTS) {
                    appendTexts = true;
                } else if (obj == FORMAT_TEXTS) {
                    appendTexts = false;
                } else if (obj == MARK_CHANGED) {
                    // Do nothing, as changedFormat is already true here
                    // Text formatting + actions
                } else if (obj instanceof TextFormat) {
                    format = (TextFormat) obj;
                } else if (obj instanceof TextColor) {
                    format = format.color((TextColor) obj);
                } else if (obj instanceof TextStyle) {
                    format = format.style(obj.equals(TextStyles.RESET) ? TextStyles.NONE : format.getStyle().and((TextStyle) obj));
                } else if (obj instanceof TextAction) {
                    if (obj == TextActions.RESET_ACTIONS) {
                        hoverAction = null;
                        clickAction = null;
                        shiftClickAction = null;
                    } else if (obj instanceof HoverAction) {
                        hoverAction = (HoverAction<?>) obj;
                    } else if (obj instanceof ClickAction) {
                        clickAction = (ClickAction<?>) obj;
                    } else if (obj instanceof ShiftClickAction) {
                        shiftClickAction = (ShiftClickAction<?>) obj;
                    } else {
                        // Unsupported TextAction
                    }
                } else {
                    // Unsupported TextProperty
                }
            } else if (appendTexts && obj instanceof TextRepresentable) {
                builder.append(((TextRepresentable) obj).toText());
            } else {
                // Simple content
                changedFormat = false;
                final Text.Builder childBuilder;
                TextFormat childFormat = format;

                if (obj instanceof TextRepresentable) {
                    childBuilder = ((TextRepresentable) obj).toText().toBuilder();
                    // Merge instead of overwrite format
                    childFormat = childBuilder.getFormat().merge(format);
                } else if (obj instanceof String) {
                    childBuilder = builder((String) obj);
                } else if (obj instanceof Translation) {
                    childBuilder = builder((Translation) obj);
                } else if (obj instanceof Translatable) {
                    childBuilder = builder(((Translatable) obj).getTranslation());
                } else if (obj instanceof Selector) {
                    childBuilder = builder((Selector) obj);
                } else if (obj instanceof Score) {
                    childBuilder = builder((Score) obj);
                } else if (obj instanceof Iterable<?>) {
                    childBuilder = joinOf(DEFAULT_SEPARATOR, (Iterable<?>) obj).toBuilder();
                } else if (obj instanceof Object[]) {
                    childBuilder = joinOf(DEFAULT_SEPARATOR, (Object[]) obj).toBuilder();
                } else {
                    childBuilder = builder(String.valueOf(obj));
                }

                builder.append(applyAndBuild(childBuilder, childFormat, hoverAction, clickAction, shiftClickAction));
            }
        }

        if (changedFormat) {
            // Did the formatting change without being applied to something?
            // Then just append an empty text with that formatting
            builder.append(applyAndBuild(builder(), format, hoverAction, clickAction, shiftClickAction));
        }

        return simplifyAndBuild(builder);
    }

    private static Text applyAndBuild(Builder builder, TextFormat format, HoverAction<?> hoverAction,
            ClickAction<?> clickAction, ShiftClickAction<?> shiftClickAction) {
        if (hoverAction != null) {
            builder.onHover(hoverAction);
        }
        if (clickAction != null) {
            builder.onClick(clickAction);
        }
        if (shiftClickAction != null) {
            builder.onShiftClick(shiftClickAction);
        }
        return builder.format(format).build();
    }

    /**
     * Creates a {@link Text.Builder} with empty text.
     *
     * @return A new text builder with empty text
     */
    public static Text.Builder builder() {
        return new LiteralText.Builder();
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
    public static LiteralText.Builder builder(String content) {
        return new LiteralText.Builder(content);
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
    public static LiteralText.Builder builder(char content) {
        return builder(String.valueOf(content));
    }

    /**
     * Creates a new {@link LiteralText.Builder} with the formatting and actions
     * of the specified {@link Text} and the given content.
     *
     * @param text The text to apply the properties from
     * @param content The content for the text builder
     * @return The created text builder
     * @see LiteralText
     * @see LiteralText.Builder
     */
    public static LiteralText.Builder builder(Text text, String content) {
        return new LiteralText.Builder(text, content);
    }

    /**
     * Creates a new unformatted {@link TranslatableText.Builder} with the given
     * {@link Translation} and arguments.
     *
     * @param translation The translation for the builder
     * @param args The arguments for the translation
     * @return The created text builder
     * @see TranslatableText
     * @see TranslatableText.Builder
     */
    public static TranslatableText.Builder builder(Translation translation, Object... args) {
        return new TranslatableText.Builder(translation, args);
    }

    /**
     * Creates a new unformatted {@link TranslatableText.Builder} from the given
     * {@link Translatable}.
     *
     * @param translatable The translatable for the builder
     * @param args The arguments for the translation
     * @return The created text builder
     * @see TranslatableText
     * @see TranslatableText.Builder
     */
    public static TranslatableText.Builder builder(Translatable translatable, Object... args) {
        return new TranslatableText.Builder(translatable, args);
    }

    /**
     * Creates a new {@link TranslatableText.Builder} with the formatting and
     * actions of the specified {@link Text} and the given {@link Translation}
     * and arguments.
     *
     * @param text The text to apply the properties from
     * @param translation The translation for the builder
     * @param args The arguments for the translation
     * @return The created text builder
     * @see TranslatableText
     * @see TranslatableText.Builder
     */
    public static TranslatableText.Builder builder(Text text, Translation translation, Object... args) {
        return new TranslatableText.Builder(text, translation, args);
    }

    /**
     * Creates a new {@link TranslatableText.Builder} with the formatting and
     * actions of the specified {@link Text} and the given {@link Translatable}.
     *
     * @param text The text to apply the properties from
     * @param translatable The translatable for the builder
     * @param args The arguments for the translation
     * @return The created text builder
     * @see TranslatableText
     * @see TranslatableText.Builder
     */
    public static TranslatableText.Builder builder(Text text, Translatable translatable, Object... args) {
        return new TranslatableText.Builder(text, translatable, args);
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
    public static SelectorText.Builder builder(Selector selector) {
        return new SelectorText.Builder(selector);
    }

    /**
     * Creates a new {@link SelectorText.Builder} with the formatting and
     * actions of the specified {@link Text} and the given selector.
     *
     * @param text The text to apply the properties from
     * @param selector The selector for the builder
     * @return The created text builder
     * @see SelectorText
     * @see SelectorText.Builder
     */
    public static SelectorText.Builder builder(Text text, Selector selector) {
        return new SelectorText.Builder(text, selector);
    }

    /**
     * Creates a new unformatted {@link ScoreText.Builder} with the given score.
     *
     * @param score The score for the text builder
     * @return The created text builder
     * @see ScoreText
     * @see ScoreText.Builder
     */
    public static ScoreText.Builder builder(Score score) {
        return new ScoreText.Builder(score);
    }

    /**
     * Creates a new {@link ScoreText.Builder} with the formatting and actions
     * of the specified {@link Text} and the given score.
     *
     * @param text The text to apply the properties from
     * @param score The score for the text builder
     * @return The created text builder
     * @see ScoreText
     * @see ScoreText.Builder
     */
    public static ScoreText.Builder builder(Text text, Score score) {
        return new ScoreText.Builder(text, score);
    }

    /**
     * Creates a placeholder {@link Text} with the specified key. The created
     * message won't have any formatting or events configured.
     *
     * @param key The key of the placeholder
     * @return The created text
     * @see PlaceholderText
     */
    public static PlaceholderText placeholder(String key) {
        return new PlaceholderText(key);
    }

    /**
     * Creates a placeholder {@link Text} with the specified key and fallback.
     * The created message won't have any formatting or events configured.
     *
     * @param key The key of the placeholder
     * @param fallback The fallback of the text if it is not replaced
     * @return The created text
     * @see PlaceholderText
     */
    public static PlaceholderText placeholder(String key, @Nullable Text fallback) {
        return new PlaceholderText(key, fallback);
    }

    /**
     * Creates a placeholder {@link Text} with the specified {@link Transformer}
     * . The created message won't have any formatting or events configured.
     *
     * @param transformer The transformer of the placeholder
     * @return The created text
     * @see PlaceholderText
     */
    public static PlaceholderText placeholder(Transformer<?> transformer) {
        return new PlaceholderText(transformer);
    }

    /**
     * Creates a placeholder {@link Text} with the specified {@link Transformer}
     * and fallback. The created message won't have any formatting or events
     * configured.
     *
     * @param transformer The transformer of the placeholder
     * @param fallback The fallback of the text if it is not replaced
     * @return The created text
     * @see PlaceholderText
     */
    public static PlaceholderText placeholder(Transformer<?> transformer, @Nullable Text fallback) {
        return new PlaceholderText(transformer, fallback);
    }

    /**
     * Creates a new unformatted {@link PlaceholderText.Builder} with the
     * specified key.
     *
     * @param key The key of the placeholder
     * @return The created placeholder builder
     * @see PlaceholderText
     * @see PlaceholderText.Builder
     */
    public static PlaceholderText.Builder placeholderBuilder(String key) {
        return new PlaceholderText.Builder(key);
    }

    /**
     * Creates a new unformatted {@link PlaceholderText.Builder} with the
     * specified transformer.
     *
     * @param transformer The transformer of the placeholder
     * @return The created placeholder builder
     * @see PlaceholderText
     * @see PlaceholderText.Builder
     */
    public static PlaceholderText.Builder placeholderBuilder(Transformer<?> transformer) {
        return new PlaceholderText.Builder(transformer);
    }

    /**
     * If the given builder contains only a single child the child will be
     * returned otherwise the default {@link Builder#build()} will be called.
     * This method assumes, that there is no styling or data applied to the
     * given builder except for children.
     *
     * @param builder The builder to simplify or build
     * @return The simplified or build Text instance
     */
    private static Text simplifyAndBuild(Builder builder) {
        // Children size zero will automatically falls back to Text.EMPTY
        if (builder.children.size() == 1) {
            // Single content reduce Text depth
            return builder.children.get(0);
        } else {
            return builder.build();
        }
    }

    /**
     * Joins a sequence of text objects together.
     *
     * @param texts The texts to join
     * @return A text object that joins the given text objects
     */
    public static Text join(Text... texts) {
        return simplifyAndBuild(builder().append(texts));
    }

    /**
     * Joins a sequence of text objects together.
     *
     * @param texts The texts to join
     * @return A text object that joins the given text objects
     */
    public static Text join(Iterable<? extends Text> texts) {
        return simplifyAndBuild(builder().append(texts));
    }

    /**
     * Joins a sequence of text objects together.
     *
     * @param texts The texts to join
     * @return A text object that joins the given text objects
     */
    public static Text join(Iterator<? extends Text> texts) {
        return simplifyAndBuild(builder().append(texts));
    }

    /**
     * Joins a sequence of text objects together along with a separator.
     *
     * @param separator The separator
     * @param texts The texts to join
     * @return A text object that joins the given text objects
     */
    public static Text joinWith(Text separator, Stream<? extends Text> texts) {
        final Builder builder = builder();
        texts.forEachOrdered(Functional.joiner(builder::append, separator));
        return simplifyAndBuild(builder);
    }

    /**
     * Joins a sequence of text objects together along with a separator.
     *
     * @param separator The separator
     * @param texts The texts to join
     * @return A text object that joins the given text objects
     */
    public static Text joinWith(Text separator, Text... texts) {
        return joinWith(separator, Arrays.stream(texts));
    }

    /**
     * Joins a sequence of text objects together along with a separator.
     *
     * @param separator The separator
     * @param texts The texts to join
     * @return A text object that joins the given text objects
     */
    public static Text joinWith(Text separator, Iterable<? extends Text> texts) {
        return joinWith(separator, StreamSupport.stream(texts.spliterator(), false));
    }

    /**
     * Joins a sequence of text objects together along with a separator.
     *
     * @param separator The separator
     * @param texts An iterator for the texts to join
     * @return A text object that joins the given text objects
     */
    public static Text joinWith(Text separator, Iterator<? extends Text> texts) {
        @SuppressWarnings("unchecked")
        final Iterable<Text> iterable = () -> (Iterator<Text>) texts;
        return joinWith(separator, iterable);
    }

    /**
     * Builds a {@link Text} from a given array of content objects. This method
     * assumes, that all elements of the array are content and not formatting.
     *
     * <p>This will create the correct {@link Text} instance if the input object
     * is the input for one of the {@link Text} types or convert the object to a
     * string otherwise.</p>
     *
     * @param separator The separator to be inserted between elements
     * @param objects The array that contains the content
     * @return The built text object
     */
    public static Text joinOf(Text separator, Object... objects) {
        return joinWith(separator, Arrays.stream(objects).map(Text::of));
    }

    /**
     * Builds a {@link Text} from a given {@link Iterable}. This method assumes,
     * that all elements of the iterable are content and not formatting.
     *
     * <p>This will create the correct {@link Text} instance if the input object
     * is the input for one of the {@link Text} types or convert the object to a
     * string otherwise.</p>
     *
     * @param separator The separator to be inserted between elements
     * @param contents The iterable that contains the content
     * @return The built text object
     */
    public static Text joinOf(Text separator, Iterable<?> contents) {
        return joinWith(separator, StreamSupport.stream(contents.spliterator(), false).map(Text::of));
    }

    /**
     * Creates a new Text instance with all {@link PlaceholderText}s replaced.
     * All placeholders without a non-null replacement are ignored. All
     * replacements will be wrapped in a {@link Text} using
     * {@link Text#of(Object...)} the color and the style from the placeholder
     * are transfered to that method as well. Useful for lazy fetching
     * replacements.
     *
     * @param template The template text in which all {@link PlaceholderText}s
     *        should be replaced
     * @param context The context data used to calculate the replacements for
     *        the {@link PlaceholderText}s. It does not have to contain enough
     *        data to replace all placeholders
     * @return The text with all possible placeholders replaced
     */
    public static Text format(Text template, Function<String, ?> context) {
        checkNotNull(template, "template");
        checkNotNull(context, "context values");
        return formatNoChecks(template, context);
    }

    /**
     * Creates a new Text instance with all {@link PlaceholderText}s replaced.
     * All placeholders without a non-null replacement are ignored. All
     * replacements will be wrapped in a {@link Text} using
     * {@link Text#of(Object...)} the color and the style from the placeholder
     * are transfered to that method as well.
     *
     * @param template The template text in which all {@link PlaceholderText}s
     *        should be replaced
     * @param context The context data used to calculate the replacements for
     *        the {@link PlaceholderText}s. It does not have to contain enough
     *        data to replace all placeholders
     * @return The text with all possible placeholders replaced
     */
    public static Text format(Text template, Map<String, ?> context) {
        checkNotNull(template, "template");
        checkNotNull(context, "context values");
        if (context.isEmpty()) {
            return template;
        }
        return formatNoChecks(template, context::get);
    }

    /**
     * Creates a new Text instance with all {@link PlaceholderText}s replaced.
     * All placeholders with an {@link Optional#empty()} replacement are
     * ignored. All replacements will be wrapped in a {@link Text} using
     * {@link Text#of(Object...)} the {@link TextColor}, {@link TextStyle}s and
     * {@link TextAction}s from the placeholder are transfered to that method as
     * well.
     *
     * @param template The template text in which all {@link PlaceholderText}s
     *        should be replaced
     * @param context The context data used to calculate the replacements for
     *        the {@link PlaceholderText}s. It does not have to contain enough
     *        data to replace all placeholders
     * @return The text with all possible placeholders replaced
     */
    public static Text format(Text template, Object... context) {
        checkNotNull(template, "template");
        checkNotNull(context, "context values");
        if (context.length == 0) {
            return template;
        }
        final Map<String, Object> contextMap = Maps.newHashMapWithExpectedSize(context.length);
        int index = 0;
        for (Object replacement : context) {
            contextMap.put(Integer.toString(index++), replacement);
        }
        return formatNoChecks(template, contextMap::get);
    }

    private static Text formatNoChecks(Text template, Function<String, ?> context) {
        // Is this a placeholder that should be replaced?
        if (template instanceof PlaceholderText) {
            final Optional<?> replacement = ((PlaceholderText) template).calculateReplacement(context);
            // Only replace in case a replacement is present
            if (replacement.isPresent()) {
                // Copy color, style and text actions from placeholder
                final List<Object> formats = Lists.newArrayList();
                formats.add(FORMAT_TEXTS);
                formats.add(template.getFormat());
                final Optional<HoverAction<?>> hoverAction = template.getHoverAction();
                hoverAction.ifPresent(formats::add);
                final Optional<ClickAction<?>> clickAction = template.getClickAction();
                clickAction.ifPresent(formats::add);
                final Optional<ShiftClickAction<?>> shiftClickAction = template.getShiftClickAction();
                shiftClickAction.ifPresent(formats::add);
                formats.add(replacement.get());

                return Text.of(formats.toArray());
            }
        }
        // Also check child texts for placeholders
        Text.Builder builder = null;
        final List<Text> children = template.getChildren();
        for (int i = 0; i < children.size(); ++i) {
            final Text child = children.get(i);
            final Text formatted = formatNoChecks(child, context);
            if (builder == null) {
                if (formatted == child) {
                    continue;
                }
                builder = template.toBuilder();
                builder.remove(children.subList(i, children.size()));
            }
            builder.append(formatted);
        }
        return builder == null ? template : builder.build();
    }

    /**
     * Creates a new {@link FormatBuilder} that allows chained calls to
     * configure the format function.
     *
     * @return The newly created format builder that can be used to setup the
     *         formating
     * @see FormatBuilder
     */
    public static FormatBuilder formatBuilder() {
        return new FormatBuilder();
    }

    /**
     * Helper class that allows easier/chained calls to the format method
     * without extra steps
     */
    public static final class FormatBuilder implements Function<Text, Text>, ResettableBuilder<Function<String, Object>, FormatBuilder> {

        private static final Function<String, ?> NO_FALLBACK_FUNCTION = Functions.constantNull();

        private final Map<String, Object> values = Maps.newHashMap();
        private Function<String, Object> replacerFunction = input -> this.values.get(input);
        private Function<String, ?> fallbackFunction = NO_FALLBACK_FUNCTION;

        /**
         * Creates a new format builder that should format the given template.
         */
        FormatBuilder() {
        }

        /**
         * Set the given replacement for the given keys. Replacements set with
         * this method will always take precedence over values set by the other
         * methods. Values set using this method can be set/replaced after the
         * format execution. This way you can create lots of similar
         * {@link Text}s by just replacing a single or a few arguments.
         *
         * @param key The key used to set the value
         * @param replacement The replacement to use. Null will unset it
         * @return This instance for chaining
         */
        public FormatBuilder with(String key, @Nullable Object replacement) {
            checkNotNull(key, "key");
            this.values.put(key, replacement);
            return this;
        }

        /**
         * Appends the given replacement {@link Supplier} for the given key.
         * This method could be used for counters, indexes and stuff alike. If
         * the supplier returns null the next provider can try to resolve it.
         *
         * <p><b>Note:</b>The given {@link Supplier} is only used if no other
         * previous call provided a replacement for this key.</p>
         *
         * @param key The key used to set the supplier
         * @param supplier The supplier used to get the replacement
         * @return This instance for chaining
         * @see Functions#supplied(Supplier)
         * @see #with(Predicate, Function)
         */
        public FormatBuilder with(String key, Supplier<?> supplier) {
            checkNotNull(key, "key");
            checkNotNull(supplier, "supplier");
            return with(input -> key.equals(input), Functions.supplied(supplier));
        }

        /**
         * Appends the given replacement {@link Function} for the given key.
         * This method should be used if only some keys should be resolved the
         * given function. If the function returns null the next provider can
         * try to resolve it.
         *
         * <p><b>Note:</b>The given {@link Function} is only used if no other
         * previous call provided a replacement for this key.</p>
         *
         * @param filter The filter used to decide whether the given function
         *        should be used. It will be used if the
         *        {@link Predicate#test(Object) test} returns true
         * @param function The function used to calculate the replacement
         * @return This instance for chaining
         * @see Functions#conditional(Predicate, Function, Function)
         * @see #with(Function)
         */
        public FormatBuilder with(Predicate<? super String> filter, Function<? super String, ? extends Object> function) {
            checkNotNull(filter, "filter");
            checkNotNull(function, "function");
            return with(Functions.conditional(filter, function, Functions.constantNull()));
        }

        /**
         * Appends the given replacement {@link Function} for all keys. Can be
         * used for both fetching/calculating/returning specific replacements or
         * parsing the input key to return a generated replacement based on the
         * input specifications. If the function returns null the next provider
         * can try to resolve the key.
         *
         * <p><b>Note:</b>This given {@link Function} is only used if no other
         * previous call provided a replacement for the key.</p>
         *
         * @param function The function used to calculate the replacement
         * @return This instance for chaining
         * @see Functions#nonNullResultOrElse(Function, Function)
         */
        public FormatBuilder with(Function<? super String, ? extends Object> function) {
            checkNotNull(function, "function");
            this.replacerFunction = Functions.nonNullResultOrElse(this.replacerFunction, function);
            return this;
        }

        /**
         * Set the fallback strategy to use if the key could not be resolved.
         * The no fallback strategy will omit the placeholder to allow setting
         * it in a later run.
         *
         * @return This instance for chaining
         * @see #fallback(Function)
         */
        public FormatBuilder noFallback() {
            return fallback(NO_FALLBACK_FUNCTION);
        }

        /**
         * Set the fallback strategy to use if the key could not be resolved.
         * The constant fallback strategy will always return the given constant.
         * That way you could replace all unresolved {@link PlaceholderText}s
         * with the empty text.
         *
         * @return This instance for chaining
         * @see #fallback(Function)
         */
        public FormatBuilder fallback(Object fallback) {
            checkNotNull(fallback, "fallback");
            return fallback(Functions.constant(fallback));
        }

        /**
         * Set the fallback strategy to use if the key could not be resolved.
         * The supplier fallback strategy will get the replacement from the
         * given {@link Supplier}.
         *
         * @return This instance for chaining
         * @see #fallback(Function)
         */
        public FormatBuilder fallback(Supplier<?> supplier) {
            return fallback(Functions.supplied(supplier));
        }

        /**
         * Set the fallback strategy to use if the key could not be resolved.
         * The throwing fallback strategy will throw an
         * {@link IllegalStateException} if no replacement for the given key
         * could be found.
         *
         * @return This instance for chaining
         * @see #fallback(Function)
         */
        public FormatBuilder throwingfallback() {
            return fallback(Functions.exceptionFunction(IllegalStateException::new,
                    "Missing replacement for placeholder with key: "::concat));
        }

        /**
         * Set the fallback strategy to use if the key could not be resolved.
         * The supplier fallback strategy will get the replacement from the
         * given {@link Function}.
         *
         * @return This instance for chaining
         */
        public FormatBuilder fallback(Function<String, ?> function) {
            checkNotNull(function, "function");
            this.fallbackFunction = function;
            return this;
        }

        @Override
        public FormatBuilder from(Function<String, Object> function) {
            reset();
            return with(function);
        }

        @Override
        public FormatBuilder reset() {
            this.replacerFunction = input -> this.values.get(input);
            this.values.clear();
            noFallback();
            return this;
        }

        /**
         * Applies the specified replacements on the given {@link Text}
         * template. This step is repeatable.
         *
         * @param template The {@link Text} template to apply the specified
         *        formating on
         * @return The processed with all possible {@link PlaceholderText}s
         *         replaced
         * @see #format(Text, Function)
         */
        @Override
        public Text apply(Text template) {
            return formatNoChecks(template, Functions.nonNullResultOrElse(this.replacerFunction, this.fallbackFunction));
        }

    }

}
