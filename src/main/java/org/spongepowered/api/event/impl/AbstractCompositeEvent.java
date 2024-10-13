package org.spongepowered.api.event.impl;

import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.CompositeEvent;
import org.spongepowered.api.event.Event;
import org.spongepowered.eventgen.annotations.UseField;

import java.util.Collections;
import java.util.List;

public abstract class AbstractCompositeEvent<E extends Event> extends AbstractEvent implements CompositeEvent<E> {

    @UseField
    protected E baseEvent;

    @UseField(overrideToString = true)
    protected List<Event> children;

    @UseField
    protected boolean cancelled;

    public final void postInit() {
        this.children = Collections.unmodifiableList(this.children);
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
        this.children().forEach(event -> {
            if (event instanceof Cancellable cancellable) {
                cancellable.setCancelled(cancel);
            }
        });
    }
}
