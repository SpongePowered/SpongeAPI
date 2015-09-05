package org.spongepowered.api.text.template;

import org.spongepowered.api.text.Text;

public abstract class TextElement<T> {

    public abstract Text create(T value);

    public TextArg.Named<T> name(String name) {
        return new TextArg.Named<T>(name, this);
    }

    public TextArg.Pos<T> pos(int position) {
        return new TextArg.Pos<T>(position, this);
    }

}
