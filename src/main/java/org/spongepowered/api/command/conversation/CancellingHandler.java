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

/**
 * A functional interface which checks command and text input to see
 * if the {@link Conversant} should quit the {@link Conversation}.
 *
 * <p>All implementations should return true to cancel to have the
 * {@link Conversant} quit the {@link Conversation}.</p>
 */
@FunctionalInterface
public interface CancellingHandler {

    /**
     * Processes input from commands and chat to see if the {@link Conversant}
     * should quit the {@link Conversation}.
     *
     * <p>The input is not lower-cased when this is called.</p>
     *
     * @param conversation The conversation the user is in
     * @param conversant The conversant involved
     * @param input The conversant's raw input
     * @param wasCommand If the input came as a command
     * @return True if the conversant should quit the conversation
     */
    boolean process(Conversation conversation, Conversant conversant, String input, boolean wasCommand);

}
