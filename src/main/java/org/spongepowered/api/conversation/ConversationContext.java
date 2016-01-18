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

import org.spongepowered.api.Game;

import java.util.Map;

/**
 * A ConversationContext provides continuity between nodes in the prompt graph
 * by giving the developer access to the subject of the conversation and a
 * generic map for storing values that are shared between all {@link Prompt}
 * invocations.
 */
public class ConversationContext {

    private Conversable forWhom;
    private Map<Object, Object> sessionData;
    private Game game;

    /**
     * @param game The owning plugin.
     * @param forWhom The subject of the conversation.
     * @param initialSessionData Any initial values to put in the sessionData
     *     map.
     */
    public ConversationContext(Game game, Conversable forWhom, Map<Object, Object> initialSessionData) {
        this.game = game;
        this.forWhom = forWhom;
        this.sessionData = initialSessionData;
    }

    /**
     * Gets the plugin that owns this conversation.
     *
     * @return The owning game.
     */
    public Game getGame() {
        return game;
    }

    /**
     * Gets the subject of the conversation.
     *
     * @return The subject of the conversation.
     */
    public Conversable getForWhom() {
        return forWhom;
    }

    /**
     * Gets the entire sessionData map.
     * @return The full sessionData map.
     */
    public Map<Object, Object> getAllSessionData() {
        return sessionData;
    }

    /**
     * Gets session data shared between all {@link Prompt} invocations. Use
     * this as a way to pass data through each Prompt as the conversation
     * develops.
     *
     * @param key The session data key.
     * @return The requested session data.
     */
    public Object getSessionData(Object key) {
        return sessionData.get(key);
    }

    /**
     * Sets session data shared between all {@link Prompt} invocations. Use
     * this as a way to pass data through each prompt as the conversation
     * develops.
     *
     * @param key The session data key.
     * @param value The session data value.
     */
    public void setSessionData(Object key, Object value) {
        sessionData.put(key, value);
    }


}
