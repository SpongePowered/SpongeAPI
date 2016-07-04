package org.spongepowered.api.text.dialogue;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.Tristate;

import java.util.Collection;

/**
 * Each {@link Dialogue} is made up of a dynamic tree of {@link Question}s,
 * meaning that each {@link Question} chooses the next one. A {@link Question}
 * is responded to by a {@link Speaker} with an {@link Answer}.
 */
public interface Question extends TextRepresentable {
    /**
     * Creates a {@link Builder} to return an {@link Question}.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }
    interface Builder extends ResettableBuilder<Question, Builder> {

        /**
         * Sets the {@link Text} to show the {@link Speaker} when this
         * {@link Question} is shown.
         *
         * @param text The text to show
         * @return This builder, for chaining
         */
        Builder setText(Text text);

        /**
         * Sets the {@link AnswerProcessor} to use when processing {@link Answer}s.
         *
         * @param processor The processor to use
         * @return This builder, for chaining
         */
        Builder setProcessor(AnswerProcessor processor);

        /**
         * Adds extra processors to use when processing {@link Answer}s. They
         * cannot determine the next {@link Question}.
         *
         * @param processors The processors to use.
         * @return This builder, for chaining
         */
        Builder setAdditionalProcessors(Iterable<AdditionalAnswerProcessor> processors);

        /**
         * Adds an extra processor to use when processing {@link Answer}s. They
         * cannot determine the next {@link Question}. This is repeatable.
         *
         * @param processor The processor to add
         * @return This builder, for chaining
         */
        Builder addAdditionalProcessor(AdditionalAnswerProcessor processor);

        /**
         * Sets whether or not all messages should be suppressed. If
         * {@link Tristate#UNDEFINED}, the {@link Dialogue}'s setting is used
         * instead.
         *
         * @param suppress Whether or not all messages should be suppressed
         * @return This builder, for chaining
         */
        Builder suppressAllMessages(Tristate suppress);

        /**
         * Sets specific {@link MessageChannel}s to not suppress. This is
         * ignored if {@link #suppressAllMessages(Tristate)} is set to false.
         *
         * @param channels The channels to allow
         * @return This builder, for chaining
         */
        Builder allowedChannels(Iterable<MessageChannel> channels);

        /**
         * Sets whether or not any output by the {@link Speaker} should be
         * suppressed (as opposed to allowing it to go to, for example, main
         * chat). If {@link Tristate#UNDEFINED}, the {@link Dialogue}'s setting
         * is used instead.
         *
         * @param suppress Whether output should be suppressed
         * @return This builder, for chaining
         */
        Builder suppressOutput(Tristate suppress);

        /**
         * Builds an instance of a {@link Question}.
         *
         * @return The completed question
         * @throws IllegalStateException If the question is not complete
         */
        Question build();
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
    AnswerProcessor getMainProcessor();

    /**
     * Gets the {@link AdditionalAnswerProcessor}s to use when processing
     * {@link Answer}s.
     *
     * @return The processor
     */
    Collection<AdditionalAnswerProcessor> getAdditionalProcessors();

    /**
     * Gets all {@link MessageChannel}s that are allowed through suppression.
     *
     * @return The channels
     */
    Collection<MessageChannel> getAllowedChannels();

    /**
     * Gets whether or not this question suppresses messages.
     *
     * @return Whether or not messages are suppressed.
     */
    Tristate suppressesMessages();

    /**
     * Gets whether or not this question suppresses output.
     *
     * @return Whether or not messages are suppressed.
     */
    Tristate suppressesOutput();
}
