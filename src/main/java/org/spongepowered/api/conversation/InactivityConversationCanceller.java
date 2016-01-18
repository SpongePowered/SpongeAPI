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
import org.spongepowered.api.Sponge;

public class InactivityConversationCanceller implements ConversationCanceller {
    protected Game game = Sponge.getGame();
    protected int timeoutSeconds;
    protected Conversation conversation;
    private int taskId = -1;

    /**
     * Creates an InactivityConversationCanceller.
     *
     * @param game The owning game.
     * @param timeoutSeconds The number of seconds of inactivity to wait.
     */
    public InactivityConversationCanceller(Game game, int timeoutSeconds) {
        this.game = game;
        this.timeoutSeconds = timeoutSeconds;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
        //startTimer();
    }

    public boolean cancelBasedOnInput(ConversationContext context, String input) {
        // Reset the inactivity timer
        //stopTimer();
        //startTimer();
        return false;
    }

    public ConversationCanceller clone() {
        return new InactivityConversationCanceller(game, timeoutSeconds);
    }

    /**
     * Starts an inactivity timer.
     */
    /*private void startTimer() {
        //TODO: Update to use sponge scheduler
        /*taskId = game.getScheduler().createTaskBuilder().execute(new Runnable() {
        })

                .scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                if (conversation.getState() == Conversation.ConversationState.UNSTARTED) {
                    startTimer();
                } else if (conversation.getState() ==  Conversation.ConversationState.STARTED) {
                    cancelling(conversation);
                    conversation.abandon(new ConversationAbandonedEvent(conversation, InactivityConversationCanceller.this));
                }
            }
        }, timeoutSeconds * 20);

    }

    /**
     * Stops the active inactivity timer.

    private void stopTimer() {
        if (taskId != -1) {
            plugin.getServer().getScheduler().cancelTask(taskId);
            taskId = -1;
        }
    }*/

    /**
     * Subclasses of InactivityConversationCanceller can override this method
     * to take additional actions when the inactivity timer abandons the
     * conversation.
     *
     * @param conversation The conversation being abandoned.
     */
    protected void cancelling(Conversation conversation) {

    }
}
