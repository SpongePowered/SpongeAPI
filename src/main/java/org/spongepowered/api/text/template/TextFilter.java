package org.spongepowered.api.text.template;

import com.google.common.collect.ImmutableList;

public abstract class TextFilter<P extends TextElement<?>, T extends TextElement<?>> {

    public abstract T filter(P prev, ImmutableList<String> args);

    public abstract ImmutableList<String> serializeArgs(T elem);

}
