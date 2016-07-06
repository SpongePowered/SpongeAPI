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

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.command.CommandSource;

import java.util.Optional;

/**
 * Anything that can take part in the answering side of a {@link Dialogue}.
 */
public interface Speaker extends CommandSource {

    /**
     * Gets whether this speaker is currently in a {@link Dialogue}.
     * This is equivalent to calling {@link #getCurrentDialogue()
     * getCurrentDialogue().isPresent()}, but shorter.
     *
     * @return Whether or not the speaker is in a dialogue
     */
    default boolean isSpeaking() {
        return this.getCurrentDialogue().isPresent();
    }

    /**
     * Gets the current {@link Dialogue} that this speaker is in.
     *
     * @return The instance if the speaker is in one, otherwise
     * {@link Optional#empty}
     */
    Optional<Dialogue> getCurrentDialogue();

    /**
     * Adds this speaker to the provided {@link Dialogue}.
     *
     * @param dialogue The dialogue to add the speaker to
     * @throws IllegalStateException If the speaker is already in a
     * {@link Dialogue}
     * @see Dialogue#addSpeaker(Speaker)
     */
    default void addToDialogue(Dialogue dialogue) {
        checkNotNull(dialogue, "dialogue").addSpeaker(this);
    }

    /**
     * Gets the {@link Question} that the speaker is currently in.
     *
     * @return The question if the speaker is in a dialogue, otherwise
     * {@link Optional#empty()}
     */
    default Optional<Question> getCurrentQuestion() {
        return this.getCurrentDialogue().flatMap(dialogue -> dialogue.getCurrentQuestionFor(this));
    }


}
