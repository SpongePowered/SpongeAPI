package org.spongepowered.api.text.dialogue;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * Represents a back-and-forth communication
 */
public interface Dialogue {
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }
    interface Builder extends ResettableBuilder<Dialogue, Builder> {
        Builder firstQuestion(Question question);
        Dialogue build();
    }
}
