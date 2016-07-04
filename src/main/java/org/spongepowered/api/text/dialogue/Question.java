package org.spongepowered.api.text.dialogue;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.util.ResettableBuilder;

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
         * Sets whether or not all messages should be suppressed.
         *
         * @param suppress Whether or not all messages should be suppressed
         * @return This builder, for chaining
         */
        Builder suppressAllMessages(boolean suppress);

        /**
         * Sets specific {@link MessageChannel}s to not suppress. This is
         * ignored if {@link #suppressAllMessages(boolean)} is set to false.
         *
         * @param channels The channels to allow
         * @return This builder, for chaining
         */
        Builder allowedChannels(Iterable<MessageChannel> channels);

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
    AnswerProcessor getProcessor();

    /**
     * Gets all {@link MessageChannel}s that are allowed through suppression.
     *
     * @return The channels
     */
    Collection<MessageChannel> getAllowedChannels();

    /**
     * Gets whether or not this question suppresses messages.
     *
     * @return Whether or not this question suppresses messages.
     */
    boolean suppressesMessages();
}
