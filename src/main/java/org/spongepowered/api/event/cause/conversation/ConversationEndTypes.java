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

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * Provided conversation end types that you should attempt to stick to.
 */
public final class ConversationEndTypes {

    /**
     * Should be used if there was a problem with the conversation, such as a
     * missing question.
     */
    public static final ConversationEndType ERROR = DummyObjectProvider.createFor(ConversationEndType.class, "ERROR");

    /**
     * Shows that the conversation has naturally been finished by reaching the
     * last question.
     */
    public static final ConversationEndType FINISHED = DummyObjectProvider.createFor(ConversationEndType.class, "FINISHED");

    /**
     * Should be used if another plugin is forcing the plugin to be closed.
     */
    public static final ConversationEndType FORCED = DummyObjectProvider.createFor(ConversationEndType.class, "FORCED");

    /**
     * Shows that the user has used the exit keyword to leave the conversation.
     */
    public static final ConversationEndType QUIT = DummyObjectProvider.createFor(ConversationEndType.class, "QUIT");

    /**
     * Used to convey that the conversation has timed out due to there being no
     * conversants left in a conversation.
     */
    public static final ConversationEndType TIMED_OUT = DummyObjectProvider.createFor(ConversationEndType.class, "TIMED_OUT");

    private ConversationEndTypes() {}

}
