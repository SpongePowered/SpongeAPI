package org.spongepowered.api.data.generator;

import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.immutable.ImmutableListData;
import org.spongepowered.api.data.manipulator.mutable.ListData;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * This {@link DataGenerator.FinalStep} supports only one {@link Key} with a {@link BaseValue}
 * of the type {@link ListValue}. The generated classes will
 * always extend {@link ListData} and {@link ImmutableListData}.
 *
 * @param <E> The element type of the list
 * @param <M> The mutable manipulator type
 * @param <I> The immutable manipulator type
 */
public interface ListDataGenerator<E, M extends ListData<E, M, I>, I extends ImmutableListData<E, I, M>>
        extends DataGenerator.FinalStep<M, I, ListDataGenerator<E, M, I>> {

    /**
     * Generates a {@link ListDataGenerator}. Only one key will be registered in
     * this {@link FinalStep} and it's {@link Value} type must be a
     * {@link ListValue}. The output extend the classes
     * {@link ListData} and a {@link ImmutableListData}.
     *
     * @param key Tke key
     * @param <E> The element type
     * @return The list data builder
     */
    static <E> ListDataGenerator<E, ? extends ListData<E, ?, ?>, ? extends ImmutableListData<E, ?, ?>> builder(
            Key<? extends ListValue<E>> key) {
        return DataGenerator.builder().list(key);
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
    <NM extends ListData<E, NM, NI>, NI extends ImmutableListData<E, NI, NM>> ListDataGenerator<E, NM, NI> interfaces(
            Class<NM> mutableClass, Class<NI> immutableClass);

    /**
     * Sets the default {@link List} value. Defaults to
     * {@link ArrayList#ArrayList()}.
     *
     * @param defaultList The default list
     * @return This builder, for chaining
     */
    ListDataGenerator<E, M, I> defaultValue(List<E> defaultList);
}
