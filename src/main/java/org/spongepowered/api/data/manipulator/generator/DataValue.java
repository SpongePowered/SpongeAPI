package org.spongepowered.api.data.manipulator.generator;

public @interface DataValue {

    Class<?> type();

    String query();

}
