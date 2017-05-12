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

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.command.args.parsing.InputTokenizer;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * A {@link Conversation} contains one of these which point to each other,
 * allowing for handling, and identification.
 */
public interface Question {

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
     * Gets the prompt for handler for this question.
     *
     * <p>This is specified through a functional interface
     * to generate a prompt with contextual information.</p>
     *
     * @return The prompt handler for this question
     */
    PromptHandler getPromptHandler();

    /**
     * Gets the arguments set for this question. This is set on creation to
     * to allow parsing of answer.
     *
     * @return The set arguments of the question
     */
    CommandElement getArguments();

    /**
     * Gets the active input tokenizer used for this question.
     *
     * @return This question's input tokenizer
     */
    InputTokenizer getInputTokenizer();

    /**
     * Gets a builder based on the values present in the question.
     *
     * @return The new builder
     */
    Builder toBuilder();

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
         * Allows you to specify a contextually based prompt,
         * from the {@link Conversation} and the {@link DataContainer} context.
         *
         * <p>Can simply return a constant {@link Text} if you wish.</p>
         *
         * @param promptHandler The handler for the prompt
         * @return The modified builder
         */
        Builder prompt(PromptHandler promptHandler);

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
         * @param element The desired command element
         * @return The modified builder
         */
        Builder argument(CommandElement element);

        /**
         * Sets the arguments for the question as a sequence.
         *
         * <p>If these are not set, it will generally default
         * to a command element of a string with the key "answer".</p>
         *
         * @param elements A variable amount of command elements
         * @return The modified builder
         */
        Builder arguments(CommandElement... elements);

        /**
         * Sets the input tokenizer to be used to convert input from a string
         * into a list of argument tokens.
         *
         * @see InputTokenizer Fo common input parser implementations
         * @param inputTokenizer The input tokenizer to parse with
         * @return The modified builder
         */
        Builder inputTokenizer(InputTokenizer inputTokenizer);

        /**
         * Creates the question from the values added to the builder.
         *
         * @return The created question
         */
        Question build();

    }

}
