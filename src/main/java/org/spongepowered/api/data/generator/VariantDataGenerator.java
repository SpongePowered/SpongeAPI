package org.spongepowered.api.data.generator;

import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.immutable.ImmutableVariantData;
import org.spongepowered.api.data.manipulator.mutable.VariantData;
import org.spongepowered.api.data.value.mutable.Value;

/**
 * This {@link DataGenerator.FinalStep} supports only one {@link Key}. The generated classes
 * will always extend {@link VariantData} and {@link ImmutableVariantData}.
 *
 * @param <V> The variant type
 * @param <M> The mutable manipulator type
 * @param <I> The immutable manipulator type
 */
public interface VariantDataGenerator<V, M extends VariantData<V, M, I>, I extends ImmutableVariantData<V, I, M>>
        extends DataGenerator.FinalStep<M, I, VariantDataGenerator<V, M, I>> {

    /**
     * Generates a {@link VariantDataGenerator}. Only one key will be registered in
     * this {@link FinalStep}. The output extend the classes
     * {@link VariantData} and a {@link ImmutableVariantData}.
     *
     * @param key Tke key
     * @param <V> The value type
     * @return The variant data builder
     */
    static <V> VariantDataGenerator<V, ? extends VariantData<V, ?, ?>, ? extends ImmutableVariantData<V, ?, ?>> builder(
            Key<? extends Value<V>> key) {
        return DataGenerator.builder().variant(key);
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
    <NM extends VariantData<V, NM, NI>, NI extends ImmutableVariantData<V, NI, NM>> VariantDataGenerator<V, NM, NI> interfaces(
            Class<NM> mutableClass, Class<NI> immutableClass);

    /**
     * Sets the default variant type, is required to be set.
     *
     * @param defaultVariant The default variant type
     * @return This builder, for chaining
     */
    VariantDataGenerator<V, M, I> defaultValue(V defaultVariant);
}
