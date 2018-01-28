package org.spongepowered.api.data.generator;

import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.BoundedValue;

import java.util.Comparator;

/**
 * This {@link DataGenerator.FinalStep} supports multiple {@link Key}s and it's values.
 *
 * @param <M> The mutable manipulator type
 * @param <I> The immutable manipulator type
 */
public interface GenericDataGenerator<M extends DataManipulator<M, I>, I extends ImmutableDataManipulator<I, M>>
        extends DataGenerator.FinalStep<M, I, GenericDataGenerator<M, I>> {

    /**
     * Constructs a new {@link GenericDataGenerator}. This is the only {@link FinalStep}
     * that supports multiple {@link Key}s.
     *
     * @return The key values data builder
     */
    static GenericDataGenerator builder() {
        return DataGenerator.builder().generic();
    }

    /**
     * Sets the interfaces that the generated {@link DataManipulator} and
     * {@link ImmutableDataManipulator} classes should be implement.
     *
     * @param mutableClass The mutable interface
     * @param immutableClass The immutable interface
     * @param <NM> The type of the mutable interface
     * @param <NI> The type of the immutable interface
     * @return This builder, for chaining
     */
    <NM extends DataManipulator<NM, NI>, NI extends ImmutableDataManipulator<NI, NM>> GenericDataGenerator<NM, NI> interfaces(
            Class<NM> mutableClass, Class<NI> immutableClass);

    /**
     * Registers a {@link Key} with the specified default value.
     *
     * @param key The key
     * @param defaultValue The default value
     * @param <T> The type of the value
     * @return This builder, for chaining
     */
    <T> GenericDataGenerator<M, I> key(Key<? extends BaseValue<T>> key, T defaultValue);

    /**
     * Registers a {@link Key} with a bounded value and specified default value.
     *
     * @param key The key
     * @param defaultValue The default value
     * @param minimum The minimum value
     * @param maximum The maximum value
     * @param <T> The type of the value
     * @return This builder, for chaining
     */
    <T extends Comparable<T>> GenericDataGenerator<M, I> boundedKey(Key<? extends BoundedValue<T>> key, T defaultValue, T minimum, T maximum);

    /**
     * Registers a {@link Key} with a bounded value and specified
     * default value. The {@link Comparator} will be used to check whether
     * the value is between it's bounds.
     *
     * @param key The key
     * @param defaultValue The default value
     * @param minimum The minimum value
     * @param maximum The maximum value
     * @param comparator The comparator
     * @param <T> The type of the value
     * @return This builder, for chaining
     */
    <T> GenericDataGenerator<M, I> boundedKey(Key<? extends BoundedValue<T>> key, T defaultValue, T minimum, T maximum, Comparator<T> comparator);
}
