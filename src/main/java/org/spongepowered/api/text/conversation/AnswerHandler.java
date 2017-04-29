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
package org.spongepowered.api.text.conversation;

import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.text.Text;

/**
 * A functional interface, which a {@link Question} utilizes to handle responses.
 */
@FunctionalInterface
public interface AnswerHandler {

    /**
     * Handles a {@link Conversant}'s answer to a {@link Question}.
     *
     * <p>This is where you should collect all information from individual
     * {@link Question}s or prompts, to the{@link DataContainer}
     * accessible through {@link Conversation#getContext()} with
     * {@link DataQuery} or store it yourself.</p>
     *
     * <p>A {@link QuestionResult} needs to be returned so the conversation
     * knows how to continue on. The three possible types can be accessed
     * by static methods on the class. You can tell the conversation to either
     * end, go to the next question, or repeat the same question.</p>
     *
     * <p><strong>Note:</strong> You must use
     * {@link Conversant#sendThroughMessage(Text)} to send conversants a message
     * if the conversation is set to catch messages.</p>
     *
     * @param conversation The conversation involved in this answer
     * @param conversant The conversant answering the question
     * @param question The question being answered
     * @param args The context of this specific question
     * @return Whether to end the conversation, repeat the question, or go to
     *     another question
     */
    QuestionResult handle(Conversation conversation, Conversant conversant, Question question, ResponseContext args);

}
