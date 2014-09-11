package org.spongepowered.api.component.system;

import org.spongepowered.api.component.Component;
import org.spongepowered.api.component.ComponentHolder;

import javax.annotation.Nullable;

/**
 * Represents a relationship system of {@link org.spongepowered.api.component.ComponentHolder}s and their {@link org.spongepowered.api.component.Component}s.
 */
public interface ComponentSystem {
    /**
     * Registers a {@link org.spongepowered.api.component.ComponentHolder} and {@link org.spongepowered.api.component.Component} relationship in the system
     *
     * @param holder The holder
     * @param component The component
     * @return The component, for chaining
     */
    public <T extends Component> T register(ComponentHolder<? super T> holder, T component);

    /**
     * Gets a {@link org.spongepowered.api.component.Component} for the {@link org.spongepowered.api.component.ComponentHolder} in the system.
     *
     * @param holder The holder
     * @param clazz The component class
     * @return The component
     */
    @Nullable
    <T extends Component> T get(ComponentHolder<? super T> holder, Class<T> clazz);

    /**
     * Removes a {@link org.spongepowered.api.component.ComponentHolder} and {@link org.spongepowered.api.component.Component}'s relationship from the system.
     *
     * @param holder The holder
     * @param clazz The component's class
     * @return The component that was removed
     */
    public <T extends Component> T remove(ComponentHolder<? super T> holder, Class<T> clazz);
}
