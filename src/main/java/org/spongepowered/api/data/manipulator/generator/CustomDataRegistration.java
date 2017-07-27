package org.spongepowered.api.data.manipulator.generator;

import org.spongepowered.api.data.DataRegistration;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;

public interface CustomDataRegistration<T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>> extends DataRegistration<T, I> {

    /**
     * Gets the generated {@link DataManipulator} class for this registration
     * that implements the {@link #getManipulatorClass()}.
     *
     * @return The generated manipulator class
     */
    Class<T> getGeneratedManipulatorClass();

    /**
     * Gets the generated {@link ImmutableDataManipulator} class for this registration
     * that implements the {@link #getImmutableManipulatorClass()}.
     *
     * @return The generated immutable class
     */
    Class<I> getGeneratedImmutableManipulatorClass();

}
