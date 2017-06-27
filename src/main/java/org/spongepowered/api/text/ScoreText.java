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
import org.spongepowered.api.scoreboard.Score;
import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.action.ShiftClickAction;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextFormat;
import org.spongepowered.api.text.format.TextStyle;

import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

import javax.annotation.Nullable;

/**
 * Represents a {@link Text} displaying the current score of a player.
 *
 * @see Score
 * @see Builder
 */
public final class ScoreText extends Text {

    final Score score;
    final Optional<String> override;

    ScoreText(Score score) {
        this.score = checkNotNull(score, "score");
        this.override = Optional.empty();
    }

    /**
     * Constructs a new immutable {@link ScoreText} for the given score with the
     * specified formatting and text actions applied.
     *
     * @param format The format of the text
     * @param children The immutable list of children of the text
     * @param clickAction The click action of the text, or {@code null} for none
     * @param hoverAction The hover action of the text, or {@code null} for none
     * @param shiftClickAction The shift click action of the text, or
     *        {@code null} for none
     * @param score The score of the text
     * @param override The text to override the score with, or {@code null} for
     *        none
     */
    ScoreText(TextFormat format, ImmutableList<Text> children, @Nullable ClickAction<?> clickAction,
            @Nullable HoverAction<?> hoverAction, @Nullable ShiftClickAction<?> shiftClickAction,
            Score score, @Nullable String override) {
        super(format, children, clickAction, hoverAction, shiftClickAction);
        this.score = checkNotNull(score, "score");
        this.override = Optional.ofNullable(override);
    }

    /**
     * Returns the score displayed by this {@link Text}.
     *
     * @return The score in this text
     */
    public Score getScore() {
        return this.score;
    }

    /**
     * Returns a value that is displayed instead of the real score.
     *
     * @return The value displayed instead of the real score, or
     *         {@link Optional#empty()} if the real score will be displayed
     *         instead
     */
    public Optional<String> getOverride() {
        return this.override;
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
        if (!(o instanceof ScoreText) || !super.equals(o)) {
            return false;
        }

        ScoreText that = (ScoreText) o;
        return this.score.equals(that.score) && this.override.equals(that.override);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), this.score, this.override);
    }

    @Override
    MoreObjects.ToStringHelper toStringHelper() {
        return super.toStringHelper()
                .addValue(this.score)
                .add("override", this.override.orElse(null));
    }

    /**
     * Represents a {@link Text.Builder} creating immutable {@link ScoreText}
     * instances.
     *
     * @see ScoreText
     */
    public static class Builder extends Text.Builder {

        private Score score;
        @Nullable private String override;

        /**
         * Constructs a new unformatted {@link Builder} with the given score.
         *
         * @param score The score for the text builder
         */
        Builder(Score score) {
            score(score);
        }

        /**
         * Constructs a new {@link Builder} with the formatting and actions of
         * the specified {@link Text} and the given score.
         *
         * @param text The text to apply the properties from
         * @param score The score for the text builder
         */
        Builder(Text text, Score score) {
            super(text);
            score(score);
        }

        /**
         * Constructs a new {@link Builder} with the formatting, actions and
         * score of the specified {@link ScoreText}.
         *
         * @param text The text to apply the properties from
         */
        Builder(ScoreText text) {
            super(text);
            this.score = text.score;
            this.override = text.override.orElse(null);
        }

        /**
         * Returns the current score of this builder.
         *
         * @return The current score
         * @see ScoreText#getScore()
         */
        public final Score getScore() {
            return this.score;
        }

        /**
         * Sets the score of the text.
         *
         * @param score The score for this builder to use
         * @return This text builder
         * @see ScoreText#getScore()
         */
        public Builder score(Score score) {
            this.score = checkNotNull(score, "score");
            return this;
        }

        /**
         * Returns the current override of this builder.
         *
         * @return The current override, or {@link Optional#empty()} if none
         * @see ScoreText#getOverride()
         */
        public final Optional<String> getOverride() {
            return Optional.ofNullable(this.override);
        }

        /**
         * Overrides the real score and displays a custom text instead.
         *
         * @param override The text to override the score with or {@code null}
         *        to reset
         * @return This text builder
         * @see ScoreText#getOverride()
         */
        public Builder override(@Nullable String override) {
            this.override = override;
            return this;
        }

        @Override
        public ScoreText build() {
            return new ScoreText(
                    this.format,
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
            if (!(o instanceof Builder) || !super.equals(o)) {
                return false;
            }

            Builder that = (Builder) o;
            return Objects.equal(this.score, that.score)
                    && Objects.equal(this.override, that.override);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(super.hashCode(), this.score, this.override);
        }

        @Override
        MoreObjects.ToStringHelper toStringHelper() {
            return super.toStringHelper()
                    .addValue(this.score)
                    .add("override", this.override);
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
