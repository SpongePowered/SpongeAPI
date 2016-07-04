package org.spongepowered.api.text.dialogue;

import org.spongepowered.api.data.DataContainer;

/**
 * A functional interface which processes {@link Answer}s.
 */
@FunctionalInterface
public interface AnswerProcessor {

    /**
     * Processes an {@link Answer} and returns the next {@link Question} in the {@link Dialogue}.
     *
     * @param dialogue The current dialogue
     * @param data The current dialogue-persistent data
     * @param question The question being answered
     * @param answer The answer to the question
     * @return The next {@link Question} in the {@link Dialogue}
     */
    Question process(Dialogue dialogue, DataContainer data, Question question, Answer answer);
}
