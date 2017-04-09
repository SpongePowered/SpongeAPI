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
package org.spongepowered.api.conversation;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * A {@link Conversation} contains one of these which point to each other,
 * allowing for handling, and identification.
 */
public interface Question extends TextRepresentable {

    /**
     * Creates a new {@link Question.Builder} to build a {@link Question}.
     *
     * @return The new builder
     */
    static Question.Builder builder() {
        return Sponge.getRegistry().createBuilder(Question.Builder.class);
    }

    /**
     * Gets the id of this question. Should be different from all
     * other questions within its {@link Conversation};
     *
     * @return The id
     */
    String getId();

    /**
     * Gets the handler which handles a {@link Conversant}'s answer
     * to this question.
     *
     * @return The answer handler for this question
     */
    AnswerHandler getHandler();

    /**
     * Gets the prompt for this question.
     *
     * @return The prompt
     */
    Text getPrompt();

    /**
     * Gets the arguments set for this question. This is set on creation to
     * to allow parsing of answer.
     *
     * @return The set arguments of the question
     */
    CommandElement getArguments();

    /**
     * Used to create a new {@link Question}.
     */
    interface Builder extends ResettableBuilder<Question, Builder> {

        /**
         * Sets the id of the question. Should be different from all
         * other questions within its {@link Conversation}.
         *
         * @param id The desired id
         * @return The modified builder
         */
        Builder id(String id);

        /**
         * Sets the prompt of the question. This is essentially the question
         * asked and needs to be set.
         *
         * @param prompt The desired prompt
         * @return The modified builder
         */
        Builder prompt(Text prompt);

        /**
         * Sets the answer handler for the question.
         *
         * @param answerHandler The desired answer handler
         * @return The modified builder
         */
        Builder handler(AnswerHandler answerHandler);

        /**
         * Sets the argument for the question.
         *
         * @param element The desired command elemtn
         * @return The modified builder
         */
        Builder argument(CommandElement element);

        /**
         * Sets the arguments for the question as a sequence.
         *
         * @param elements A variable amount of command elements
         * @return The modified builder
         */
        Builder arguments(CommandElement... elements);

        /**
         * Creates the question from the values added to the builder.
         *
         * @return The created question
         */
        Question build();

    }

}
