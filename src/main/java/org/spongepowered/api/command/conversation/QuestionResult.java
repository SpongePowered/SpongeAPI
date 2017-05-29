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
package org.spongepowered.api.command.conversation;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Optional;

/**
 * What to build and return from your answer handler on a question, to allow
 * moving on to a next question, the same question, or to end the conversation.
 */
public interface QuestionResult {

    /**
     * The various types of question result types.
     */
    enum QuestionResultType {

        /**
         * Ends the conversation naturally.
         */
        END,

        /**
         * Repeats the current question.
         */
        REPEAT,

        /**
         * Goes to the next question, that you must specify.
         */
        NEXT

    }

    /**
     * Creates a new {@link QuestionResult.Builder} to build a {@link QuestionResult}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the question result type.
     *
     * @return The type
     */
    QuestionResultType getType();

    /**
     * Gets the next question, if it is present.
     *
     * <p>Generally should only be present if the type is NEXT.</p>
     *
     * @return The next question, if available.
     */
    Optional<Question> getNextQuestion();

    /**
     * Gets a builder based off of this result's values.
     *
     * @return The builder
     */
    Builder toBuilder();

    /**
     * Used to create an {@link QuestionResult}.
     */
    interface Builder extends ResettableBuilder<QuestionResult, Builder> {

        /**
         * Sets the question result type.
         *
         * @param type The desired question result type
         * @return The modified builder
         */
        Builder type(QuestionResultType type);

        /**
         * Sets the next question.
         *
         * <p>Automatically sets the type to next.</p>
         *
         * @param question The desired next question
         * @return The modified builder
         */
        Builder nextQuestion(Question question);

        /**
         * Sets the question result type to go to the
         * next question.
         *
         * <p>You must set the next question to use
         * this type.</p>
         *
         * @return The modified builder
         */
        Builder next();

        /**
         * Sets the question result type to
         * end the conversation.
         *
         * @return The modified builder
         */
        Builder end();

        /**
         * Sets the question result type to
         * repeat the current question.
         *
         * @return The modified builder
         */
        Builder repeat();

        /**
         * Takes all of the values from the builder to create a
         * {@link QuestionResult}.
         *
         * @return The created question result
         */
        QuestionResult build();

    }

}
