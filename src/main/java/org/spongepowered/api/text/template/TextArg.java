package org.spongepowered.api.text.template;

import com.google.common.base.Optional;
import org.spongepowered.api.text.Text;

public interface TextArg<T> {

    Optional<? extends Text> create(T value);

}
