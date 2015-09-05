package org.spongepowered.api.text.template;

import org.spongepowered.api.text.Text;

public interface TextArg<T> {

   Text create(T value);

}
