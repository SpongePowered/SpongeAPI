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
package org.spongepowered.api.command.conversation;

import org.spongepowered.api.command.conversation.QuestionResult.QuestionResultType;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.conversation.ConversationEndType;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;

import java.util.Optional;
import java.util.Set;

import javax.annotation.Nullable;

/**
 * Represents a created conversation with one or more {@link Conversant}s.
 *
 * <p>These are checked every five minutes to see if there are no players.
 * If this is true, the conversation is ended with </p>
 */
public interface Conversation {

    /**
     * Gets who started the conversation, if present.
     *
     * @return The {@link PluginContainer} who started this conversation
     */
    PluginContainer getCreator();

    /**
     * Gets a data container where you can store all relevant information you
     * gather from each question's {@link AnswerHandler}.
     *
     * @return The overall context of this conversation
     */
    DataContainer getContext();

    /**
     * Gets the handler which handles input to see if it should end
     * the {@link Conversation}.
     *
     * @return The cancelling handler
     */
    default CancellingHandler getCancellingHandler() {
        return getArchetype().getCancellingHandler();
    }

    /**
     * An ease of use method to retrieve the banner for each question, which
     * is set if the title is specified and has padding added on.
     *
     * @return The conversation header, if available
     */
    default Optional<Text> getBanner() {
        return getArchetype().getBanner();
    }

    /**
     * An ease of use method to retrieve the header for each question, which
     * is not always set.
     *
     * <p>Occurs after the banner if that is set.</p>
     *
     * @return The conversation header, if available
     */
    default Optional<Text> getHeader() {
        return getArchetype().getHeader();
    }

    /**
     * Gets the archetype of this conversation. Contains initial information.
     *
     * @return The initial archetype of this conversation
     */
    ConversationArchetype getArchetype();

    /**
     * Gets every {@link Conversant} within this conversation.
     *
     * @return A set of all the {@link Conversant}s
     */
    Set<Conversant> getConversants();

    /**
     * Gets the question that is currently being accessed or processed.
     *
     * @return The current question
     */
    Optional<Question> getCurrentQuestion();

    /**
     * Sets the new question, sending them the header, as well as the prompt
     * of the question.
     *
     * @param question The question to set to
     */
    void setQuestion(@Nullable Question question);

    /**
     * Ends the conversation, calling all of the ending handlers, removing the
     * {@link Conversant}s, and calls the relevant events.
     *
     * <p>A question handler should not call this to end a {@link Conversation}
     * if it is finished normally, but rather return a
     * {@link QuestionResultType#END}.</p>
     *
     * @param endType The type of end this should be
     * @param cause The cause of this end
     * @return Whether or not the conversation truly ended
     */
    boolean end(ConversationEndType endType, Cause cause);

    /**
     * Adds the specified {@link Conversant} to the conversation,
     * with the generic delete all {@link ExternalChatHandler}.
     *
     * <p>This sends them the prompt of the current active question.</p>
     *
     * @param conversant The conversant to add to the conversation
     */
    default void addConversant(Conversant conversant) {
        addConversant(conversant, ExternalChatHandlers.deleteAll());
    }

    /**
     * Adds a {@link Conversant} to the conversation.
     *
     * <p>This sends them the prompt of the current active question.</p>
     *
     * @param conversant The conversant to add to the conversation
     * @param externalChatHandler The chat handler to give the conversant
     */
    void addConversant(Conversant conversant, ExternalChatHandler externalChatHandler);

    /**
     * Removes the specified {@link Conversant} from the conversation.
     *
     * <p>This is meant for unique use cases, as only one conversant can
     * answer each question. Once one answers, both will go to the next
     * question or step.</p>
     *
     * <p>If you remove all {@link Conversant}s remember to end the
     * conversation with {@link #end(ConversationEndType, Cause)}.</p>
     *
     * @param conversant The conversant to remove from the conversation
     */
    void removeConversant(Conversant conversant);

    /**
     * Removes every {@link Conversant} from the conversation.
     *
     * <p>This does not end the conversation, so keep in mind
     * you should use {@link #end(ConversationEndType, Cause)} or else this
     * conversation will just continue without any conversants.</p>
     */
    void removeAllConversants();

    /**
     * If the specified {@link Conversant} is in the conversation it changes
     * their {@link ExternalChatHandler} to the one you specify. If they are
     * not in the conversation, instead use {@link #addConversant(Conversant)}.
     *
     * @param conversant The conversant which you want to modify
     * @param externalChatHandler The external chat handler for the conversant
     */
    void setChatHandler(Conversant conversant, ExternalChatHandler externalChatHandler);

    /**
     * Gets the chat handler which handles incoming messages for a
     * {@link Conversant} if they are in this conversation.
     *
     * @param conversant The conversant to get the handler for
     * @return The handler of the specified {@link Conversant}, if present
     */
    Optional<ExternalChatHandler> getChatHandler(Conversant conversant);

    /**
     * Whether or not this conversation has ended.
     *
     * @return Whether or not this conversation has ended
     */
    boolean hasEnded();

    /**
     * Sets whether or not {@link Conversant} output should be caught.
     *
     * @param catches If {@link Conversant} output should be caught
     */
    void catchOutput(boolean catches);

    /**
     * Gets if {@link Conversant} output should be caught.
     *
     * @return Whether or not {@link Conversant} output should be caught
     */
    boolean catchesOutput();

    /**
     * Sets whether or not {@link Conversant}s can use commands.
     *
     * @param allow If {@link Conversant}s can use commands
     */
    void allowCommands(boolean allow);

    /**
     * Gets if {@link Conversant}s can use commands.
     *
     * @return Whether or not {@link Conversant}s can use commands
     */
    boolean allowsCommands();

    /**
     * Gets every ending handler added to the conversation. Generally there is
     * only one.
     *
     * @return All ending handlers for the conversation
     */
    Set<EndingHandler> getEndingHandlers();

    /**
     * Adds an ending handler which is processed when the conversation ends.
     *
     * @param endingHandler The ending handler to add
     */
    void addEndingHandler(EndingHandler endingHandler);

    /**
     * Removes the specified ending handler, so it is never processed.
     *
     * @param endingHandler The ending handler to removed
     * @return Whether or not the specified ending handler was removed
     */
    boolean removeEndingHandler(EndingHandler endingHandler);

    /**
     * A convenience method to get the id of the conversation archetype.
     *
     * @return The id of the conversation archetype
     */
    default String getId() {
        return getArchetype().getId();
    }
    
}
