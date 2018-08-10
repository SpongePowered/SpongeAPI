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

import org.spongepowered.api.Sponge;
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
public interface ScoreText extends Text {

    /**
     * Creates a {@link Builder}.
     *
     * @return A new text builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Returns the score displayed by this {@link Text}.
     *
     * @return The score in this text
     */
    Score getScore();

    /**
     * Returns a value that is displayed instead of the real score.
     *
     * @return The value displayed instead of the real score, or
     *         {@link Optional#empty()} if the real score will be displayed
     *         instead
     */
    Optional<String> getOverride();

    @Override
    Builder toBuilder();

    /**
     * Represents a {@link Text.Builder} creating immutable {@link ScoreText}
     * instances.
     *
     * @see ScoreText
     */
    interface Builder extends Text.Builder {

        /**
         * Returns the current score of this builder.
         *
         * @return The current score
         * @see ScoreText#getScore()
         */
        Score getScore();

        /**
         * Sets the score of the text.
         *
         * @param score The score for this builder to use
         * @return This text builder
         * @see ScoreText#getScore()
         */
        Builder score(Score score);

        /**
         * Returns the current override of this builder.
         *
         * @return The current override, or {@link Optional#empty()} if none
         * @see ScoreText#getOverride()
         */
        Optional<String> getOverride();

        /**
         * Overrides the real score and displays a custom text instead.
         *
         * @param override The text to override the score with or {@code null}
         *        to reset
         * @return This text builder
         * @see ScoreText#getOverride()
         */
        Builder override(@Nullable String override);

        @Override
        Builder format(TextFormat format);

        @Override
        Builder color(TextColor color);

        @Override
        Builder style(TextStyle... styles);

        @Override
        Builder onClick(@Nullable ClickAction<?> clickAction);

        @Override
        Builder onHover(@Nullable HoverAction<?> hoverAction);

        @Override
        Builder onShiftClick(@Nullable ShiftClickAction<?> shiftClickAction);

        @Override
        Builder append(Text... children);

        @Override
        Builder append(Collection<? extends Text> children);

        @Override
        Builder append(Iterable<? extends Text> children);

        @Override
        Builder append(Iterator<? extends Text> children);

        @Override
        Builder insert(int pos, Text... children);

        @Override
        Builder insert(int pos, Collection<? extends Text> children);

        @Override
        Builder insert(int pos, Iterable<? extends Text> children);

        @Override
        Builder insert(int pos, Iterator<? extends Text> children);

        @Override
        Builder remove(Text... children);

        @Override
        Builder remove(Collection<? extends Text> children);

        @Override
        Builder remove(Iterable<? extends Text> children);

        @Override
        Builder remove(Iterator<? extends Text> children);

        @Override
        Builder removeAll();

        @Override
        ScoreText build();

        @Override
        Builder from(Text value);
    }
}
