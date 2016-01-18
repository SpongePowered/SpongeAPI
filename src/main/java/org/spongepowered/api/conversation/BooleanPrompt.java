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

import static org.apache.commons.lang3.ArrayUtils.*;
import static org.apache.commons.lang3.BooleanUtils.*;

/**
 * BooleanPrompt is the base class for any prompt that requires a boolean
 * response from the user.
 */
public abstract class BooleanPrompt extends ValidatingPrompt{

    public BooleanPrompt() {
        super();
    }

    @Override
    protected boolean isInputValid(ConversationContext context, String input) {
        String[] accepted = {"true", "false", "on", "off", "yes", "no" /* Sponge: */, "y", "n", "1", "0", "right", "wrong", "correct", "incorrect", "valid", "invalid"}; // Spigot
        return contains(accepted, input.toLowerCase());
    }

    @Override
    protected Prompt acceptValidatedInput(ConversationContext context, String input) {
        if (input.equalsIgnoreCase("y") || input.equals("1") || input.equalsIgnoreCase("right") || input.equalsIgnoreCase("correct") || input.equalsIgnoreCase("valid")) input = "true"; // Spigot
        return acceptValidatedInput(context, toBoolean(input));
    }

    /**
     * Override this method to perform some action with the user's boolean
     * response.
     *
     * @param context Context information about the conversation.
     * @param input The user's boolean response.
     * @return The next {@link Prompt} in the prompt graph.
     */
    protected abstract Prompt acceptValidatedInput(ConversationContext context, boolean input);
}
