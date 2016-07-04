package org.spongepowered.api.text.dialogue;

import org.spongepowered.api.text.channel.MessageReceiver;

import java.util.Optional;

public interface Speaker extends MessageReceiver {

    /**
     * Gets whether this speaker is currently in a {@link Dialogue.Instance}.
     * This is equivalent to calling {@link #getCurrentDialogue()
     * getCurrentDialogue().isPresent()}, minus the {@link Optional} boxing.
     *
     * @return Whether or not the speaker is in a dialogue
     */
    boolean isSpeaking();

    /**
     * Gets the current {@link Dialogue.Instance} that this speaker is in.
     *
     * @return The instance if the speaker is in one, otherwise
     * {@link Optional#empty}
     */
    Optional<Dialogue.Instance> getCurrentDialogue();

    /**
     * Adds this speaker to the provided {@link Dialogue.Instance}.
     *
     * @param instance The dialogue to add the speaker to
     * @throws IllegalStateException If the speaker is already in a
     * {@link Dialogue.Instance}
     * @see Dialogue.Instance#addSpeaker(Speaker)
     */
    default void addToDialogue(Dialogue.Instance instance) {
        instance.addSpeaker(this);
    }

    /**
     * Gets the {@link Question} that the speaker is currently in.
     *
     * @return The question if the speaker is in a dialogue, otherwise
     * {@link Optional#empty()}
     */
    default Optional<Question> getCurrentQuestion() {
        return this.getCurrentDialogue().flatMap(inst -> inst.getCurrentQuestionFor(this));
    }
}
