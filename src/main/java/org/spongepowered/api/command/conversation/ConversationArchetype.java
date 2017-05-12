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

import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Collection;
import java.util.Optional;

import javax.annotation.Nullable;

/**
 * A reusable collection of information which is used to
 * create a {@link Conversation}.
 */
public interface ConversationArchetype {

    /**
     * Creates a new {@link ConversationArchetype.Builder} to build a {@link ConversationArchetype}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the id for the archetype.
     *
     * @return The id
     */
    String getId();

    /**
     * Gets the message which will be sent to the conversants when the
     * conversation starts, if it is set.
     *
     * @return The starting message, if available
     */
    Optional<Text> getStartingMessage();

    /**
     * Gets the string that if the conversant enters will cause them to leave
     * the conversation.
     *
     * @return The string which allows the conversant to leave the conversation
     */
    String getExitString();

    /**
     * Gets the question the conversation will start with.
     *
     * @return The first question
     */
    Question getFirstQuestion();

    /**
     * Gets if the conversation will catch the {@link Conversant}'s output.
     *
     * @return Whether or not the conversation will catch the {@link Conversant}'s output
     */
    boolean catchesOutput();

    /**
     * Gets if {@link Conversant}s can use commands.
     *
     * @return Whether or not {@link Conversant}s can use commands
     */
    boolean allowsCommands();

    /**
     * Gets the default handler for all {@link Conversant}s within the conversation.
     *
     * @return The default handler for all {@link Conversant}s within the conversation
     */
    ExternalChatHandler getDefaultChatHandler();

    /**
     * Gets the handlers that handles the end of the {@link Conversation}.
     *
     * @return All ending handlers
     */
    ImmutableSet<EndingHandler> getEndingHandlers();

    /**
     * Gets the banner that will be sent before each question prompt
     * if title is set.
     *
     * <p>This is a combination of the padding and title set.</p>
     *
     * @return The question banner, if available
     */
    Optional<Text> getBanner();

    /**
     * Gets the header that occurs before each question, or after
     * the banner if the the banner is set.
     *
     * <p>This is completely optional and is often not set.</p>
     *
     * @return The question header, if set
     */
    Optional<Text> getHeader();

    /**
     * Gets the title used to create the header, if set.
     *
     * @return The title of the conversation, if available
     */
    Optional<Text> getTitle();

    /**
     * Gets the padding used to create the header, if set.
     *
     * @return The padding of the conversation, if available
     */
    Optional<Text> getPadding();

    /**
     * Gets the message sent to {@link Conversant}s when they
     * try to use a command in a conversation and that is disabled.
     *
     * @return The no command usage message
     */
    Text getNoCommandUsageMessage();

    /**
     * Starts the conversation for the specified conversants.
     *
     * <p>Generally only one conversant is set, as each question is completed
     * after just one responds, but multiple are allowed to support the use case
     * of multiple participants. If you want them to be in their own
     * conversation, use the archetype to simply start another one.</p>
     *
     * @param plugin The plugin starting the conversation
     * @param conversants The conversants to start the conversation for
     * @return The conversation that was started, if created successfully
     * @throws IllegalArgumentException If the object passed in is not
     *     a plugin instance
     */
    Optional<Conversation> start(Object plugin, Conversant... conversants);

    /**
     * Gets a builder based off of this archetype's values.
     *
     * @return The builder
     */
    Builder toBuilder();

    /**
     * Used to create an {@link ConversationArchetype}.
     */
    interface Builder extends ResettableBuilder<ConversationArchetype, Builder> {

        /**
         * Sets the id of the archetype. This is mandatory.
         *
         * @param id The desired id
         * @return The modified builder
         */
        Builder id(String id);

        /**
         * Sets the exit string. If you do not set this, it defaults to "exit".
         *
         * @param exit The desired exit string
         * @return The modified builder
         */
        Builder exitString(String exit);

        /**
         * Sets the message sent to conversants on conversation start.
         *
         * <p>This is not needed at all.</p>
         *
         * <p>This is sent before banner and header if those
         * are set and only once.</p>
         *
         * @param startingMessage The desired starting message
         * @return The modified builder
         */
        Builder startingMessage(@Nullable Text startingMessage);

        /**
         * Sets the padding of the header sent before each question. Defaults to
         * '=' if you do not set one and you set a title.
         *
         * <p>This does not need to be set.</p>
         *
         * @param padding The desired padding text
         * @return The modified builder
         */
        Builder padding(@Nullable Text padding);

        /**
         * Sets the title of the header sent before each question. If not set,
         * no header will be sent before each question.
         *
         * <p>This does not need to be set if you don't want a
         * banner before each question.</p>
         *
         * @param title The desired title for the conversation
         * @return The modified builder
         */
        Builder title(@Nullable Text title);

        /**
         * Sets the header that occurs before each question, or
         * after the banner if the the title is set.
         *
         * <p>This does not need to be set if you don't want a
         * header before each question.</p>
         *
         * @param header The desired header for the conversation
         * @return The modified builder
         */
        Builder header(@Nullable Text header);

        /**
         * Sets the first question of the conversation. This is required to set
         * so the conversation knows where to start.
         *
         * @param question The desired first question
         * @return The modified builder
         */
        Builder firstQuestion(Question question);

        /**
         * Adds an ending handler to the conversation.
         *
         * <p>You should at least add one handler.</p>
         *
         * @param endingHandler The ending handler to add
         * @return The modified builder
         */
        Builder endingHandler(EndingHandler endingHandler);

        /**
         * Adds all specified ending handlers to the conversation.
         *
         * @param endingHandlers The ending handlers to add
         * @return The modified builder
         */
        Builder endingHandlers(EndingHandler... endingHandlers);

        /**
         * Adds an entire collection of ending handlers to the conversation.
         *
         * @param endingHandlers The ending handlers to add
         * @return The modified builder
         */
        Builder endingHandlers(Collection<EndingHandler> endingHandlers);

        /**
         * Resets the list of ending handlers. Make sure to have at least
         * one set though.
         *
         * @return The modified builder.
         */
        Builder clearEndingHandlers();

        /**
         * Sets the default chat handler for {@link Conversant}s being added.
         *
         * <p>In the default Sponge implementation, this defaults to a
         * handler which simply deletes all incoming messages.</p>
         *
         * @param externalChatHandler The desired default external chat handler
         * @return The modified builder
         */
        Builder defaultChatHandler(ExternalChatHandler externalChatHandler);

        /**
         * Sets whether or not the conversation should prevent {@link Conversant}'s
         * messages going to their normal chat channels, "catching" them.
         *
         * @param catches Whether or not to catch the messages
         * @return The modified builder
         */
        Builder catchesOutput(boolean catches);

        /**
         * Sets whether or not the conversation should prevent
         * {@link Conversant}s from using commands.
         *
         * @param allow Whether or not to allow commands
         * @return The modified builder
         */
        Builder allowCommands(boolean allow);

        /**
         * Sets the message sent to {@link Conversant}s when they
         * try to use a command in a conversation and that is disabled.
         *
         * @param message The message to send
         * @return The modified builder
         */
        Builder noCommandUsageMessage(Text message);

        /**
         * Takes all of the values from the builder to create a
         * {@link ConversationArchetype}.
         *
         * @return The created conversation archetype
         */
        ConversationArchetype build();

    }

}
