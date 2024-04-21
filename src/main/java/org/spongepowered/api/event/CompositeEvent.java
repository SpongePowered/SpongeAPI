package org.spongepowered.api.event;

import org.spongepowered.api.util.annotation.eventgen.NoFactoryMethod;

import java.util.List;
import java.util.function.Consumer;

/**
 * A {@link CompositeEvent} is an {@link Event} that contains multiple
 * side effectual {@link Event Events}, which may have their own side effects
 * and may be {@link Cancellable}. In some cases, the interactions of this event
 * may be cancellable as a whole, but are not guaranteed to revert all side
 * effects on the {@link org.spongepowered.api.Game}. The {@link #children()} of
 * this event are ordered in a "best-effort" basis, and may not be guaranteed
 * to be in any particular order.
 * <p>Using {@link #setCancelled(boolean)} will perform a best effort cancellation
 * on each of the children events.
 */
@NoFactoryMethod
public interface CompositeEvent<E extends Event> extends Event, Cancellable {

    E baseEvent();

    List<Event> children();

    default <E extends Event> List<? extends E> event(Class<E> type) {
        return this.children().stream()
            .filter(type::isInstance)
            .map(type::cast)
            .toList();
    }

    default <E extends Event> void applyTo(Class<E> type, Consumer<? super E> consumer) {
        this.children().stream()
            .filter(type::isInstance)
            .map(type::cast)
            .forEach(consumer);
    }

    /**
     * {@inheritDoc}
     *
     * Cancels this event and all related events captured {@link #children()}.
     * Selectively, if individual events are wished to be cancelled,
     * the individual events should be cancelled instead.
     *
     * @param cancel The new cancelled state
     */
    @Override
    void setCancelled(boolean cancel);
}
