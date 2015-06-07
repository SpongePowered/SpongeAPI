package org.spongepowered.api.util.provider;

import com.google.common.base.Optional;
import org.spongepowered.api.text.translation.Translation;

public interface TranslationProvider extends Provider {
    /**
     * Gets the {@link Translation} with the provided ID.
     *
     * @param id The ID of the translation
     * @return The {@link Translation} with the given ID or Optional.absent() if not found
     */
    Optional<Translation> getTranslationById(String id);
}
