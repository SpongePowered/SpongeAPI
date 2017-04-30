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
package org.spongepowered.api.event.cause.conversation;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.ResettableBuilder;

import javax.annotation.Nonnull;

/**
 * The cause behind a conversation ending.
 */
public interface ConversationEndCause {

    /**
     * Creates a new {@link Builder} for building {@link ConversationEndCause}s.
     *
     * @return A new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets how the conversation ended.
     *
     * @return The type of conversation end
     */
    ConversationEndType getConversationEndType();

    interface ConversationEndCauseBuilder<T extends ConversationEndCause, B extends ConversationEndCause.ConversationEndCauseBuilder<T, B>>
        extends ResettableBuilder<T, B> {

        /**
         * Sets the {@link ConversationEndCause} for this builder. This is
         * required for building a {@link ConversationEndCause}.
         *
         * @param endType The end type
         * @return This builder, for chaining
         */
        B type(ConversationEndType endType);

        /**
         * Builds a new {@code T extends} {@link ConversationEndCause}.
         *
         * @return A new conversation end cause
         */
        T build();

    }

    interface Builder extends ConversationEndCause.ConversationEndCauseBuilder<ConversationEndCause, ConversationEndCause.Builder> {

    }

}