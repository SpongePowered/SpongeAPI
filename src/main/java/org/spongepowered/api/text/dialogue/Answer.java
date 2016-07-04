package org.spongepowered.api.text.dialogue;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.TextRepresentable;

/**
 * A response to a {@link Question}. Mainly a container.
 */
public interface Answer extends TextRepresentable {

    @Override
    default Text toText() {
        return Text.of(getAnswer());
    }

    /**
     * Gets the response that was sent.
     * @return The response
     */
    String getAnswer();

    /**
     * Gets who sent the response.
     * @return The speaker
     */
    Speaker getSpeaker();
}
