package org.spongepowered.api.text.dialogue;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Optional;

/**
 * Represents a structure for a back-and-forth communication between one or
 * more {@link Speaker}s and one or more plugiins.
 */
public interface Dialogue {
    /**
     * Creates a new {@link Builder} to build a new {@link Dialogue}.
     *
     * @return The newly created builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Creates a new {@link Instance} for the specified {@link Speaker}(s).
     *
     * @param speakers The speakers to send the initial {@link Question} to
     * @return The newly created {@link Instance}
     * @throws IllegalArgumentException If {@code speakers} is empty
     */
    Instance start(Speaker... speakers);

    interface Builder extends ResettableBuilder<Dialogue, Builder> {

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
            view.getValues(true).forEach(this::initialData);
            return this;
        }

        /**
         * Sets whether or not to suppress all messages by default.
         * {@link Question}s can override this.
         *
         * @param suppress Whether or not to suppress messages
         * @return This builder, for chaining
         */
        Builder suppressAllMessages(boolean suppress);

        /**
         * Sets channels to allow messages from. This is ignored if
         * {@link #suppressAllMessages(boolean)}, or the {@link Question}
         * equivalent, is set to true.
         *
         * @param channels The channels to allow
         * @return This builder, for chaining
         */
        Builder allowedChannels(Iterable<MessageChannel> channels);

        /**
         * Sets whether or not output by the {@link Speaker} should be
         * suppressed by default (as opposed to allowing it to go to, for
         * example, main chat). This can be overridden by {@link Question}s.
         *
         * @param suppress Whether or not to suppress output
         * @return This builder, for chaining
         */
        Builder suppressOutput(boolean suppress);

        /**
         * Builds the new Dialogue instance.
         *
         * @return The new Dialogue
         */
        Dialogue build();
    }

    /**
     * An instance of a {@link Dialogue} that is in progress.
     * While {@link Dialogue} is a structure, this is an actual instance of the
     * back-and-forth that it structures.
     */
    interface Instance {

        /**
         * Gets the {@link Dialogue} object that this is an instance of.
         *
         * @return The dialogue object
         */
        Dialogue getDialogue();

        /**
         * Gets the current dialogue-persistent data object.
         *
         * @return The data
         */
        DataContainer getData();

        /**
         * Adds a new {@link Speaker} to this instance. The speaker will
         * subsequently receive all {@link Question}s.
         *
         * @param speaker The speaker to add
         */
        void addSpeaker(Speaker speaker);

        /**
         * Gets a {@link Speaker}'s current question in this dialogue.
         * 
         * @param speaker The speaker
         * @return The question if the speaker is in this dialogue, otherwise
         * {@link Optional#empty()}
         */
        Optional<Question> getCurrentQuestionFor(Speaker speaker);
    }

}
