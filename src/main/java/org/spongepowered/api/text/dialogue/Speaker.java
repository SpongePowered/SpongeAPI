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

import org.spongepowered.api.text.channel.MessageReceiver;

import java.util.Optional;

public interface Speaker extends MessageReceiver {

    /**
     * Gets whether this speaker is currently in a {@link Dialogue.Instance}.
     * This is equivalent to calling {@link #getCurrentDialogue()
     * getCurrentDialogue().isPresent()}, minus the {@link Optional} boxing.
     *
     * @return Whether or not the speaker is in a dialogue
     */
    boolean isSpeaking();

    /**
     * Gets the current {@link Dialogue.Instance} that this speaker is in.
     *
     * @return The instance if the speaker is in one, otherwise
     * {@link Optional#empty}
     */
    Optional<Dialogue.Instance> getCurrentDialogue();

    /**
     * Adds this speaker to the provided {@link Dialogue.Instance}.
     *
     * @param instance The dialogue to add the speaker to
     * @throws IllegalStateException If the speaker is already in a
     * {@link Dialogue.Instance}
     * @see Dialogue.Instance#addSpeaker(Speaker)
     */
    default void addToDialogue(Dialogue.Instance instance) {
        instance.addSpeaker(this);
    }

    /**
     * Gets the {@link Question} that the speaker is currently in.
     *
     * @return The question if the speaker is in a dialogue, otherwise
     * {@link Optional#empty()}
     */
    default Optional<Question> getCurrentQuestion() {
        return this.getCurrentDialogue().flatMap(inst -> inst.getCurrentQuestionFor(this));
    }
}
