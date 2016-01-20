package org.spongepowered.api.text.channel;

import org.spongepowered.api.channel.Channel;
import org.spongepowered.api.effect.Viewer;
import org.spongepowered.api.text.title.Title;

import javax.annotation.Nullable;

public interface TitleChannel extends Channel<Title, Viewer> {

    @Override
    default void send(@Nullable Object sender, Title original) {
        for (Viewer viewer : this.getMembers()) {
            viewer.sendTitle(original);
        }
    }

}
