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
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * Represents a structure for a back-and-forth communication between one or
 * more {@link Speaker}s and one or more plugiins.
 */
public interface DialogueArchetype {

    /**
     * Creates a new {@link Builder} to build a new {@link DialogueArchetype}.
     *
     * @return The newly created builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Creates a new {@link Dialogue} for the specified {@link Speaker}(s).
     *
     * @param speakers The speakers to send the initial {@link Question} to
     * @return The newly created {@link Dialogue}
     * @throws IllegalArgumentException If {@code speakers} is empty
     */
    Dialogue start(Speaker... speakers);

    /**
     * Creates a new {@link Dialogue} for the specified {@link Speaker}(s).
     *
     * @param speakers The speakers to send the initial {@link Question} to
     * @return The newly created {@link Dialogue}
     * @throws IllegalArgumentException If {@code speakers} is empty
     */
    Dialogue start(Iterable<? extends Speaker> speakers);

    /**
     * Gets the first question that is shown to the {@link Speaker} when the
     * {@link Dialogue} is instantiated.
     *
     * @return The initial question
     */
    Question getInitialQuestion();

    /**
     * Gets the initial data that the generated {@link Dialogue} will be
     * populated with. This is a copy of the data.
     *
     * @return The data
     */
    DataContainer getInitialData();

    /**
     * Gets whether or not output is suppressed by default.
     *
     * @return Whether output is suppressed
     * @see Builder#suppressesOutput(boolean)
     */
    boolean suppressesOutput();

    /**
     * Gets the handler for chat messages that occur during {@link Dialogue}s.
     *
     * @return The handler
     */
    DialogueChatHandler getChatHandler();

    interface Builder extends ResettableBuilder<DialogueArchetype, Builder> {

        /**
         * Sets the first {@link Question} to use when initializing the exchange.
         *
         * @param question The question to use
         * @return This builder, for chaining
         */
        Builder initialQuestion(Question question);

        /**
         * Adds data to populate the initial persistent {@link DataContainer}
         *
         * @param query The path to the data
         * @param input The object to insert
         * @return This builder, for chaining
         */
        Builder initialData(DataQuery query, Object input);

        /**
         * Adds data to populate the initial persistent {@link DataView}.
         *
         * @param view The view to merge with the current one
         * @return This builder, for chaining
         */
        default Builder initialData(DataView view) {
            checkNotNull(view, "view").getValues(true).forEach(this::initialData);
            return this;
        }

        /**
         * Sets whether or not output by the {@link Speaker} should be
         * suppressed by default (as opposed to allowing it to go to, for
         * example, main chat). This can be overridden by {@link Question}s.
         *
         * @param suppress Whether or not to suppress output
         * @return This builder, for chaining
         */
        Builder suppressesOutput(boolean suppress);

        /**
         * Sets the {@link DialogueChatHandler} to use when a chat message is
         * sent to a {@link Speaker}.
         *
         * @param handler The handler to use
         * @return This builder, for chaining
         */
        Builder chatHandler(DialogueChatHandler handler);

        /**
         * Builds the new DialogueArchetype instance.
         *
         * @return The new DialogueArchetype
         * @throws IllegalStateException If the archetype is incomplete
         */
        DialogueArchetype build();

    }
}
