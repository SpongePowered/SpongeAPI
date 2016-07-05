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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.Tristate;

import java.util.Collection;

/**
 * Each {@link DialogueArchetype} is made up of a dynamic tree of {@link Question}s,
 * meaning that each {@link Question} chooses the next one. A {@link Question}
 * is responded to by a {@link Speaker} with an {@link Answer}.
 */
public interface Question extends TextRepresentable {

    /**
     * Creates a {@link Builder} to return a {@link Question}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the {@link Text} that this question shows when asked.
     *
     * @return The text object
     */
    Text getText();

    @Override
    default Text toText() {
        return getText();
    }

    /**
     * Gets the {@link AnswerProcessor} to use when processing {@link Answer}s.
     *
     * @return The processor
     */
    AnswerProcessor getProcessor();

    /**
     * Gets the {@link AdditionalAnswerProcessor}s to use when processing
     * {@link Answer}s.
     *
     * <p>The returned {@link Collection} is immutable.</p>
     *
     * @return The processor
     */
    Collection<AdditionalAnswerProcessor> getAdditionalProcessors();

    /**
     * Gets whether or not this question suppresses output.
     *
     * @return Whether or not messages are suppressed.
     */
    Tristate suppressesOutput();

    interface Builder extends ResettableBuilder<Question, Builder> {

        /**
         * Sets the {@link Text} to show the {@link Speaker} when this
         * {@link Question} is shown.
         *
         * @param text The text to show
         * @return This builder, for chaining
         */
        Builder text(Text text);

        /**
         * Sets the {@link AnswerProcessor} to use when processing {@link
         * Answer}s.
         *
         * @param processor The processor to use
         * @return This builder, for chaining
         */
        Builder processor(AnswerProcessor processor);

        /**
         * Adds extra processors to use when processing {@link Answer}s. They
         * cannot determine the next {@link Question}.
         *
         * @param processors The processors to use
         * @return This builder, for chaining
         */
        default Builder additionalProcessors(Iterable<? extends AdditionalAnswerProcessor> processors) {
            checkNotNull(processors, "processors").forEach(this::additionalProcessor);
            return this;
        }

        /**
         * Adds an extra processor to use when processing {@link Answer}s. They
         * cannot determine the next {@link Question}. This is repeatable.
         *
         * @param processor The processor to add
         * @return This builder, for chaining
         */
        Builder additionalProcessor(AdditionalAnswerProcessor processor);

        /**
         * Sets whether or not any output by the {@link Speaker} should be
         * suppressed (as opposed to allowing it to go to, for example, main
         * chat). If {@link Tristate#UNDEFINED}, the {@link DialogueArchetype}'s
         * setting is used instead.
         *
         * @param suppress Whether output should be suppressed
         * @return This builder, for chaining
         */
        Builder suppressesOutput(Tristate suppress);

        /**
         * Builds an instance of a {@link Question}.
         *
         * @return The completed question
         * @throws IllegalStateException If the question is not complete
         */
        Question build();

    }

}
