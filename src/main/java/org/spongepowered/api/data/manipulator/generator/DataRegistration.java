package org.spongepowered.api.data.manipulator.generator;

import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;

public interface DataRegistration<T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>> {


    public Class<T> getSuperManipulator();

    public Class<? extends T> getGeneratedImplClass();

    public Class<I> getSuperImmutable();

    public Class<? extends I> getGeneratedImmutable();

    public Class<? extends DataManipulatorBuilder<T, I>> getBuilderClass();

    public Object getPluginInstance();

    T makeDefaultMutable();

    I makeDefaultImmutable();

    DataManipulatorBuilder<T, I> getBuilder();
}
