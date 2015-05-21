package org.spongepowered.api.util.command;

/**
 * Useful building blocks for message sinks.
 */
public class MessageSinks {
    private static final MessageSinkFactory factory = null;


    /**
     * A message sink that targets all subjects with the given permission.
     *
     * @param permission The permission to target
     * @return The sink
     */
    public static MessageSink toPermission(String permission) {
        return factory.toPermission(permission);
    }

    /**
     * A message sink that targets all subjects currently active.
     *
     * @return The sink
     */
    public static MessageSink toAll() {
        return factory.toAll();
    }

    /**
     * A message sink that targets all subjects contained within the given targets.
     *
     * @param sinks The sinks to combine
     * @return The sink
     */
    public static MessageSink combined(MessageSink... sinks) {
        return factory.combined(sinks);
    }

}
