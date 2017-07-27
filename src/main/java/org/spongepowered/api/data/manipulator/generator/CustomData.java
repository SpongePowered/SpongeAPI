package org.spongepowered.api.data.manipulator.generator;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataRegistration;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.immutable.ImmutableListData;
import org.spongepowered.api.data.manipulator.immutable.ImmutableMappedData;
import org.spongepowered.api.data.manipulator.immutable.ImmutableVariantData;
import org.spongepowered.api.data.manipulator.mutable.ListData;
import org.spongepowered.api.data.manipulator.mutable.MappedData;
import org.spongepowered.api.data.manipulator.mutable.VariantData;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@SuppressWarnings("unchecked")
public interface CustomData {

    /**
     * Constructs a new {@link BaseBuilder}.
     *
     * @return The builder
     */
    static BaseBuilder builder() {
        return Sponge.getRegistry().createBuilder(CustomData.BaseBuilder.class);
    }

    /**
     * The {@link BaseBuilder}, this builder will generate a {@link DataBuilder}
     * based on the type of {@link DataManipulator} and {@link ImmutableDataManipulator}
     * as output.
     */
    interface BaseBuilder extends ResettableBuilder<CustomDataRegistration<?, ?>, BaseBuilder> {

        /**
         * Generates a {@link KeyValuesBuilder}. This is the  only {@link DataBuilder}
         * that supports multiple {@link Key}s.
         *
         * @return The key values builder
         */
        KeyValuesBuilder<?, ?> keyValues();

        /**
         * Generates a {@link VariantBuilder}. Only one key will be registered in
         * this {@link DataBuilder}. The output extend the classes
         * {@link VariantData} and a {@link ImmutableVariantData}.
         *
         * @param key Tke key
         * @param <V> The value type
         * @return The variant builder
         */
        <V> CustomData.VariantBuilder<V, ? extends VariantData<V, ?, ?>, ? extends ImmutableVariantData<V, ?, ?>> variant(
                Key<? extends Value<V>> key);

        /**
         * Generates a {@link ListBuilder}. Only one key will be registered in
         * this {@link DataBuilder} and it's {@link Value} type must be a
         * {@link ListValue}. The output extend the classes
         * {@link ListData} and a {@link ImmutableListData}.
         *
         * @param key Tke key
         * @param <E> The element type
         * @return The list builder
         */
        <E> CustomData.ListBuilder<E, ? extends ListData<E, ?, ?>, ? extends ImmutableListData<E, ?, ?>> list(
                Key<? extends ListValue<E>> key);

        /**
         * Generates a {@link MapBuilder}. Only one key will be registered in
         * this {@link DataBuilder} and it's {@link Value} type must be a
         * {@link MapValue}. The output extend the classes
         * {@link MappedData} and a {@link ImmutableMappedData}.
         *
         * @param key Tke key
         * @param <K> The map key type
         * @param <V> The map value type
         * @return The map builder
         */
        <K, V> CustomData.MapBuilder<K, V, ? extends MappedData<K, V, ?, ?>, ? extends ImmutableMappedData<K, V, ?, ?>> map(
                Key<? extends MapValue<K, V>> key);
    }

    interface DataBuilder<M extends DataManipulator<M, I>, I extends ImmutableDataManipulator<I, M>, B> {

        /**
         * Sets the content version of the constructed
         * {@link DataManipulator}s. Defaults to {@code 1}.
         *
         * @param contentVersion The content version
         * @return This builder, for chaining
         */
        B version(int contentVersion);

        /**
         * Defines a {@link Predicate} that checks whether the supplied
         * {@link DataManipulator} type is supported by the {@link DataHolder}.
         *
         * @param predicate The predicate
         * @return This builder, for chaining
         */
        B predicate(Predicate<? extends DataHolder> predicate);

        /**
         * Builds the {@link DataRegistration} with the specified
         * plugin instance and manipulator id.
         *
         * @param pluginInstance The plugin instance
         * @param id The manipulator id
         * @return The constructed data registration
         */
        CustomDataRegistration<M, I> build(Object pluginInstance, String id);
    }

    /**
     * A expansion of the {@link CustomData} that supports
     * multiple {@link Key}s and values.
     *
     * @param <M> The mutable manipulator type
     * @param <I> The immutable manipulator type
     */
    interface KeyValuesBuilder<M extends DataManipulator<M, I>, I extends ImmutableDataManipulator<I, M>>
            extends DataBuilder<M, I, KeyValuesBuilder<M, I>> {

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
        <NM extends DataManipulator<NM, NI>, NI extends ImmutableDataManipulator<NI, NM>> KeyValuesBuilder<M, I> interfaces(
                Class<NM> mutableClass, Class<NI> immutableClass);

        /**
         * Registers a {@link Key} with the specified default value.
         *
         * @param key The key
         * @param defaultValue The default value
         * @param <T> The type of the value
         * @return This builder, for chaining
         */
        <T> KeyValuesBuilder<M, I> value(Key<? extends BaseValue<T>> key, T defaultValue);

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
        <T extends Comparable<T>> KeyValuesBuilder<M, I> boundedValue(Key<? extends BaseValue<T>> key, T defaultValue, T minimum, T maximum);
    }

    interface VariantBuilder<V, M extends VariantData<V, M, I>, I extends ImmutableVariantData<V, I, M>>
            extends DataBuilder<M, I, VariantBuilder<V, M, I>> {

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
        <NM extends VariantData<V, NM, NI>, NI extends ImmutableVariantData<V, NI, NM>> VariantBuilder<V, NM, NI> interfaces(
                Class<NM> mutableClass, Class<NI> immutableClass);

        VariantBuilder<V, M, I> defaultValue(V defaultVariant);
    }

    interface ListBuilder<E, M extends ListData<E, M, I>, I extends ImmutableListData<E, I, M>>
            extends DataBuilder<M, I, ListBuilder<E, M, I>> {

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
        <NM extends ListData<E, NM, NI>, NI extends ImmutableListData<E, NI, NM>> ListBuilder<E, NM, NI> interfaces(
                Class<NM> mutableClass, Class<NI> immutableClass);

        ListBuilder<E, M, I> defaultValue(List<E> defaultList);
    }

    interface MapBuilder<K, V, M extends MappedData<K, V, M, I>, I extends ImmutableMappedData<K, V, I, M>>
            extends DataBuilder<M, I, MapBuilder<K, V, M, I>> {

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
        <NM extends MappedData<K, V, NM, NI>, NI extends ImmutableMappedData<K, V, NI, NM>> MapBuilder<K, V, NM, NI> interfaces(
                Class<NM> mutableClass, Class<NI> immutableClass);

        /**
         * Sets the default {@link Map} value.
         *
         * @param defaultMap The default map value
         * @return This builder, for chaining
         */
        MapBuilder<K, V, M, I> defaultValue(Map<K, V> defaultMap);
    }
}
