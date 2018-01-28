package org.spongepowered.api.data.generator;

import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.immutable.ImmutableMappedData;
import org.spongepowered.api.data.manipulator.mutable.MappedData;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * This {@link DataGenerator.FinalStep} supports only one {@link Key} with a {@link BaseValue}
 * of the type {@link MapValue}. The generated classes will
 * always extend {@link MappedData} and {@link ImmutableMappedData}.
 *
 * @param <K> The key type of the map
 * @param <V> The value type of the map
 * @param <M> The mutable manipulator type
 * @param <I> The immutable manipulator type
 */
public interface MappedDataGenerator<K, V, M extends MappedData<K, V, M, I>, I extends ImmutableMappedData<K, V, I, M>>
        extends DataGenerator.FinalStep<M, I, MappedDataGenerator<K, V, M, I>> {

    /**
     * Generates a {@link MappedDataGenerator}. Only one key will be registered in
     * this {@link FinalStep} and it's {@link Value} type must be a
     * {@link MapValue}. The output extend the classes
     * {@link MappedData} and a {@link ImmutableMappedData}.
     *
     * @param key Tke key
     * @param <K> The map key type
     * @param <V> The map value type
     * @return The map data builder
     */
    static <K, V> MappedDataGenerator<K, V, ? extends MappedData<K, V, ?, ?>, ? extends ImmutableMappedData<K, V, ?, ?>> builder(
            Key<? extends MapValue<K, V>> key) {
        return DataGenerator.builder().mapped(key);
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
    <NM extends MappedData<K, V, NM, NI>, NI extends ImmutableMappedData<K, V, NI, NM>> MappedDataGenerator<K, V, NM, NI> interfaces(
            Class<NM> mutableClass, Class<NI> immutableClass);

    /**
     * Sets the default {@link Map} value. Defaults to
     * {@link HashMap#HashMap()}.
     *
     * @param defaultMap The default map value
     * @return This builder, for chaining
     */
    MappedDataGenerator<K, V, M, I> defaultValue(Map<K, V> defaultMap);
}
