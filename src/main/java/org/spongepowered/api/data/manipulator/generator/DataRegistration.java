package org.spongepowered.api.data.manipulator.generator;

import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;

public interface DataRegistration<T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>> {

    Class<T> getSuperManipulator();

    Class<? extends T> getGeneratedImplClass();

    Class<I> getSuperImmutable();

    Class<? extends I> getGeneratedImmutable();

    Class<? extends DataManipulatorBuilder<T, I>> getBuilderClass();

    Object getPluginInstance();

    T makeDefaultMutable();

    I makeDefaultImmutable();

    DataManipulatorBuilder<T, I> getBuilder();
}
