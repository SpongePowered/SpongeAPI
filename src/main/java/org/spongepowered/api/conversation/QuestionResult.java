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

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * What to return from your answer handler on a question, to allow moving on to
 * a next question, the same question, or to end the conversation.
 */
public class QuestionResult {

    /**
     * Gets a question result which will end the question.
     *
     * @return A question result which ends the question
     */
    public static QuestionResult end() {
        return new QuestionResult(QuestionResultType.END);
    }

    /**
     * Gets a question result which will repeat the current question.
     *
     * @return A question result which will repeat the current question
     */
    public static QuestionResult repeat() {
        return new QuestionResult(QuestionResultType.REPEAT);
    }

    /**
     * Gets the question result which will move the conversation to the
     * next question.
     *
     * @param nextQuestion The desired question to move on to
     * @return A question result which will move on to the next question
     */
    public static QuestionResult nextQuestion(Question nextQuestion) {
        return new QuestionResult(QuestionResultType.NEXT, nextQuestion);
    }

    @Nullable private final Question nextQuestion;
    private final QuestionResultType type;

    /**
     * Creates a new question result with the specified type.
     *
     * <p>Should not pass {@link QuestionResultType#NEXT} with this constructor,
     * but rather {@link QuestionResult#QuestionResult(QuestionResultType, Question)}</p>
     *
     * @param type The type of question result
     */
    private QuestionResult(QuestionResultType type) {
        this.nextQuestion = null;
        this.type = type;
    }

    /**
     * Creates a new question result with the specified type.
     *
     * <p>Should generally only be used when the result type is
     * {@link QuestionResultType#NEXT}</p>
     *
     * @param type The type of question result
     * @param nextQuestion The next question
     */
    private QuestionResult(QuestionResultType type, Question nextQuestion) {
        this.nextQuestion = nextQuestion;
        this.type = type;
    }

    /**
     * Gets the next question, if it is present.
     *
     * <p>Generally should only be present if the type is NEXT.</p>
     *
     * @return The next question, if available.
     */
    public Optional<Question> getNextQuestion() {
        return Optional.ofNullable(this.nextQuestion);
    }

    /**
     * Gets the question result type.
     *
     * @return The type
     */
    public QuestionResultType getType() {
        return this.type;
    }

    /**
     * The different kinds of question result types there are which
     * conversations can handle.
     */
    public enum QuestionResultType {
        NEXT, REPEAT, END
    }

}
