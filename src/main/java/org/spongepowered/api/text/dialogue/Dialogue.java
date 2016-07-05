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

import org.spongepowered.api.data.DataContainer;

import java.util.Optional;

/**
 * An instance of a dialogue that is in progress.
 * While {@link DialogueArchetype} is a structure, this is an actual instance
 * of the back-and-forth that it structures.
 */
public interface Dialogue {

    /**
     * Gets the {@link DialogueArchetype} object that this is an instance of.
     *
     * @return The archetype
     */
    DialogueArchetype getArchetype();

    /**
     * Gets the current dialogue-persistent data object.
     *
     * @return The data
     */
    DataContainer getData();

    /**
     * Adds a new {@link Speaker} to this instance. The speaker will
     * subsequently receive all {@link Question}s.
     *
     * @param speaker The speaker to add
     */
    void addSpeaker(Speaker speaker);

    /**
     * Gets a {@link Speaker}'s current question in this dialogue.
     *
     * @param speaker The speaker
     * @return The question if the speaker is in this dialogue, otherwise
     * {@link Optional#empty()}
     */
    Optional<Question> getCurrentQuestionFor(Speaker speaker);

}
