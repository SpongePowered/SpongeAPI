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

import org.spongepowered.api.text.Text;

/**
 * A Prompt is the main constituent of a {@link Conversation}. Each prompt
 * displays text to the user and optionally waits for a user's response.
 * Prompts are chained together into a directed graph that represents the
 * conversation flow. To halt a conversation, END_OF_CONVERSATION is returned
 * in liu of another Prompt object.
 */
public interface Prompt extends Cloneable {

    /**
     * A convenience constant for indicating the end of a conversation.
     */
    Prompt END_OF_CONVERSATION = null;

    /**
     * Gets the text to display to the user when this prompt is first
     * presented.
     *
     * @param context Context information about the conversation.
     * @return The text to display.
     */
    Text getPromptText(ConversationContext context);

    /**
     * Checks to see if this prompt implementation should wait for user input
     * or immediately display the next prompt.
     *
     * @param context Context information about the conversation.
     * @return If true, the {@link Conversation} will wait for input before
     *     continuing.
     */
    boolean blocksForInput(ConversationContext context);

    /**
     * Accepts and processes input from the user. Using the input, the next
     * Prompt in the prompt graph is returned.
     *
     * @param context Context information about the conversation.
     * @param input The input text from the user.
     * @return The next Prompt in the prompt graph.
     */
    Prompt acceptInput(ConversationContext context, String input);
}
