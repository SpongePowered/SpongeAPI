package org.spongepowered.api.scheduler;

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

public final class TaskPriorities {

    //sortfields:ON
    public static final TaskPriority EXTREMELY_HIGH = DummyObjectProvider.createFor(TaskPriority.class, "EXTREMELY_HIGH");
    public static final TaskPriority VERY_HIGH = DummyObjectProvider.createFor(TaskPriority.class, "VERY_HIGH");
    public static final TaskPriority HIGH = DummyObjectProvider.createFor(TaskPriority.class, "HIGH");
    public static final TaskPriority NORMAL = DummyObjectProvider.createFor(TaskPriority.class, "NORMAL");
    public static final TaskPriority LOW = DummyObjectProvider.createFor(TaskPriority.class, "LOW");
    public static final TaskPriority VERY_LOW = DummyObjectProvider.createFor(TaskPriority.class, "VERY_LOW");
    public static final TaskPriority EXTREMELY_LOW = DummyObjectProvider.createFor(TaskPriority.class, "EXTREMELY_LOW");
    //sortfields:OFF

    private TaskPriorities() {
    }

}
