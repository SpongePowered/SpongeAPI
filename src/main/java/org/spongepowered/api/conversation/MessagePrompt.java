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

/**
 * MessagePrompt is the base class for any prompt that only displays a message
 * to the user and requires no input.
 */
public abstract class MessagePrompt implements Prompt{

    public MessagePrompt() {
        super();
    }

    /**
     * Message prompts never wait for user input before continuing.
     *
     * @param context Context information about the conversation.
     * @return Always false.
     */
    public boolean blocksForInput(ConversationContext context) {
        return false;
    }

    /**
     * Accepts and ignores any user input, returning the next prompt in the
     * prompt graph instead.
     *
     * @param context Context information about the conversation.
     * @param input Ignored.
     * @return The next prompt in the prompt graph.
     */
    public Prompt acceptInput(ConversationContext context, String input) {
        return getNextPrompt(context);
    }

    /**
     * Override this method to return the next prompt in the prompt graph.
     *
     * @param context Context information about the conversation.
     * @return The next prompt in the prompt graph.
     */
    protected abstract Prompt getNextPrompt(ConversationContext context);
}