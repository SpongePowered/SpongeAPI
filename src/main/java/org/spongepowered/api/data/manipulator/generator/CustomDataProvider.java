package org.spongepowered.api.data.manipulator.generator;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.SetValue;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class CustomDataProvider {

    public static RawBuilder builder() {
        return Sponge.getRegistry().createBuilder(RawBuilder.class);
    }

    public static <T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>> TypeBuilder<T, I> builder(Class<T> manipulatorClass, Class<I> immutableClass) {
        return Sponge.getDataManager().createCustomBuilder(manipulatorClass, immutableClass);
    }


    public interface RawBuilder extends ResettableBuilder<DataRegistration<?, ?>, RawBuilder> {

        RawBuilder stringValue(Key<? extends BaseValue<String>> key, String defaultValue);

        RawBuilder booleanValue(Key<? extends BaseValue<Boolean>> key, boolean defaultValue);

        RawBuilder intValue(Key<? extends BaseValue<Integer>> key, int defaultValue);

        RawBuilder boundedInt(Key<? extends BoundedValue<Integer>> key, int defaultValue, int minimum, int max);

        RawBuilder longValue(Key<? extends BaseValue<Long>> key, long defaultValue);

        RawBuilder boundedLong(Key<? extends BoundedValue<Long>> key, long defaultValue, long minimum, long maximum);

        RawBuilder floatValue(Key<? extends BaseValue<Float>> key, float defaultValue);

        RawBuilder boundedFloat(Key<? extends BoundedValue<Float>> key, float defaultValue, float minimum, float maximum);

        RawBuilder doubleValue(Key<? extends BaseValue<Double>> key, double defaultValue);

        RawBuilder boundedDouble(Key<? extends BoundedValue<Double>> key, double defaultValue, double minimum, double maximum);

        <T extends Comparable<T>> RawBuilder bounded(Key<? extends BoundedValue<T>> key, T defaultValue, T minimum, T maximum);

        <T extends DataSerializable> RawBuilder serializable(Key<? extends BaseValue<? extends T>> key, T serializable);

        <E> RawBuilder list(Key<? extends ListValue<E>> key, List<E> defaultValue, Class<E> objectClass) throws IllegalArgumentException;

        <E> RawBuilder set(Key<? extends SetValue<E>> key, Set<E> defaultValue, Class<E> objectClass) throws IllegalArgumentException;

        <T> RawBuilder object(Key<? extends BaseValue<T>> key, T object) throws IllegalArgumentException;

        <K, V> RawBuilder map(Key<? extends MapValue<K, V>> key, Map<K, V> defaultValue, Class<K> keyClass, Class<V> valueClass) throws IllegalArgumentException;

        /**
         * Defines a {@link Predicate} to use
         * @param predicate
         * @return
         */
        RawBuilder predicate(Predicate<? extends DataHolder> predicate);

        DataRegistration<?, ?> build(Object pluginInstance);

        RawBuilder id(String manipulatorId);
    }

    public interface TypeBuilder<T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>> {

        TypeBuilder<T, I> key(Key<?> key, String id);

        TypeBuilder<T, I> predicate(Predicate<? extends DataHolder> predicate);

        TypeBuilder<T, I> id(String s);

        DataRegistration<T, I> build(Object pluginInstance);
    }

}
