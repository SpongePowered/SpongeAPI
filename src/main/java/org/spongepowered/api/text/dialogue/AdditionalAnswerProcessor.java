package org.spongepowered.api.text.dialogue;

import org.spongepowered.api.data.DataContainer;

/**
 * A functional interface that processes answers without deciding the next
 * {@link Question}.
 */
@FunctionalInterface
public interface AdditionalAnswerProcessor {

    /**
     * Processes an {@link Question}.
     *
     * @param dialogue The current dialogue.
     * @param data The current dialogue-persistent data
     * @param question The question being answered
     * @param answer The answer to the question
     */
    void process(Dialogue dialogue, DataContainer data, Question question, Answer answer);
}
