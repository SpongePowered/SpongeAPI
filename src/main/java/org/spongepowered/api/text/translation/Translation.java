package org.spongepowered.api.text.translation;

import com.google.common.base.Optional;

public interface Translation {
    Optional<String> getId();

    String get();
    String get(Object... args);
    // TODO: this would only work on the client
    // String get(Locale locale);
    // String get(Locale locale, Object... args);
}
