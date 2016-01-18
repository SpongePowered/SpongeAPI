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

import org.apache.commons.lang3.math.NumberUtils;

/**
 * NumericPrompt is the base class for any prompt that requires a {@link
 * Number} response from the user.
 */
public abstract class NumericPrompt extends ValidatingPrompt{
    public NumericPrompt() {
        super();
    }

    @Override
    protected boolean isInputValid(ConversationContext context, String input) {
        return NumberUtils.isNumber(input) && isNumberValid(context, NumberUtils.createNumber(input));
    }

    /**
     * Override this method to do further validation on the numeric player
     * input after the input has been determined to actually be a number.
     *
     * @param context Context information about the conversation.
     * @param input The number the player provided.
     * @return The validity of the player's input.
     */
    protected boolean isNumberValid(ConversationContext context, Number input) {
        return true;
    }

    @Override
    protected Prompt acceptValidatedInput(ConversationContext context, String input) {
        try
        {
            return acceptValidatedInput(context, NumberUtils.createNumber(input));
        } catch (NumberFormatException e) {
            return acceptValidatedInput(context, NumberUtils.INTEGER_ZERO);
        }
    }

    /**
     * Override this method to perform some action with the user's integer
     * response.
     *
     * @param context Context information about the conversation.
     * @param input The user's response as a {@link Number}.
     * @return The next {@link Prompt} in the prompt graph.
     */
    protected abstract Prompt acceptValidatedInput(ConversationContext context, Number input);

    @Override
    protected String getFailedValidationText(ConversationContext context, String invalidInput) {
        if (NumberUtils.isNumber(invalidInput)) {
            return getFailedValidationText(context, NumberUtils.createNumber(invalidInput));
        } else {
            return getInputNotNumericText(context, invalidInput);
        }
    }

    /**
     * Optionally override this method to display an additional message if the
     * user enters an invalid number.
     *
     * @param context Context information about the conversation.
     * @param invalidInput The invalid input provided by the user.
     * @return A message explaining how to correct the input.
     */
    protected String getInputNotNumericText(ConversationContext context, String invalidInput) {
        return null;
    }

    /**
     * Optionally override this method to display an additional message if the
     * user enters an invalid numeric input.
     *
     * @param context Context information about the conversation.
     * @param invalidInput The invalid input provided by the user.
     * @return A message explaining how to correct the input.
     */
    protected String getFailedValidationText(ConversationContext context, Number invalidInput) {
        return null;
    }
}