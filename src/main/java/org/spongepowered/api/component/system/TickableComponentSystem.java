package org.spongepowered.api.component.system;

/**
 * Represents a system where {@link org.spongepowered.api.component.Component}s are processed each implementation's tick.
 */
public interface TickableComponentSystem extends ComponentSystem {
    /**
     * Called by the implementation to "process" the system
     * @param dt Time since last tick
     */
    void tick(float dt);
}
