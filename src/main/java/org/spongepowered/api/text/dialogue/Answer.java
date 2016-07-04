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
package org.spongepowered.api.text.dialogue;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;

/**
 * A response to a {@link Question}. Mainly a container.
 */
public interface Answer extends TextRepresentable {

    @Override
    default Text toText() {
        return getAnswer();
    }

    /**
     * Gets the response that was sent.
     *
     * @return The response
     */
    Text getAnswer();

    /**
     * Gets who sent the response.
     *
     * @return The speaker
     */
    Speaker getSpeaker();

    /**
     * Gets the {@link Question} that this is an answer to.
     *
     * @return The question
     */
    Question getQuestion();

    /**
     * Gets the dialogue that this is part of
     *
     * @return The dialogue
     */
    Dialogue getDialogue();

}
