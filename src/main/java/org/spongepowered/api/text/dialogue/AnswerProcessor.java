package org.spongepowered.api.text.dialogue;

/**
 * A functional interface which processes {@link Answer}s.
 */
@FunctionalInterface
public interface AnswerProcessor {
    /**
     * Processes an {@link Answer} and returns the next {@link Question} in the {@link Dialogue}.
     *
     * @param speaker The {@link Speaker} who provided the answer
     * @param answer The answer to the {@link Question}
     * @return The next {@link Question} in the {@link Dialogue}
     */
    Question process(Speaker speaker, Answer answer);
}
