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

import org.spongepowered.api.text.channel.MessageChannel;

/**
 * Handler that deals with messages that are sent to a Speaker who is currently
 * in an active Dialogue.
 */
public interface DialogueChatHandler {

    /**
     * Processes the given chat details. This method is called after the last
     * chat event was processed but before the message is actually sent to the
     * client.
     *
     * <p>Implementations may queue the given messages to send it after the
     * dialogue is finished.</p>
     *
     * @param dialogue The dialogue that is currently open.
     * @param details The details of the chat that has been sent to a {@link
     *     Speaker} and has been intercepted.
     * @return Whether or not to proceed with sending the message.
     */
    boolean process(Dialogue dialogue, ChatDetails details);

    /**
     * Notifies this handler of the end of the dialogue.
     *
     * <p>This method can be used to send queued messages after the dialogue
     * has been concluded. Please ensure that they are sent to the correct
     * {@link MessageChannel}.</p>
     *
     * @param dialogue The dialogue that was concluded
     */
    void notifyEnd(Dialogue dialogue);

}
