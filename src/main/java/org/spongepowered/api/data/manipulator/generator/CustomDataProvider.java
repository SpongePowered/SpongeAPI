package org.spongepowered.api.data.manipulator.generator;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataRegistration;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.function.Predicate;

public class CustomDataProvider {

    public static RawBuilder builder() {
        return Sponge.getRegistry().createBuilder(RawBuilder.class);
    }

    public static <T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>> TypeBuilder<T, I> builder(Class<T> manipulatorClass, Class<I> immutableClass) {
        return Sponge.getDataManager().createCustomBuilder(manipulatorClass, immutableClass);
    }

    public interface BaseBuilder<B extends BaseBuilder<B>> extends ResettableBuilder<DataRegistration<?, ?>, B> {

        /**
         * Builds the {@link DataRegistration} with the specified
         * plugin instance and manipulator id.
         *
         * @param pluginInstance The plugin instance
         * @param id The manipulator id
         * @return The constructed data registration
         */
        DataRegistration<?, ?> build(Object pluginInstance, String id);
    }

    public interface RawBuilder extends BaseBuilder<RawBuilder> {

        /**
         * Registers a {@link Key} with the specified default value.
         *
         * @param key The key
         * @param defaultValue The default value
         * @param <T> The type of the value
         * @return This builder, for chaining
         */
        <T> RawBuilder value(Key<? extends BaseValue<T>> key, T defaultValue);

        /**
         * Registers a {@link Key} with a bounded value and specified default value.
         *
         * @param key The key
         * @param defaultValue The default value
         * @param <T> The type of the value
         * @return This builder, for chaining
         */
        <T extends Comparable<T>> RawBuilder boundedValue(Key<? extends BaseValue<T>> key, T defaultValue, T minimum, T maximum);

        /**
         * Defines a {@link Predicate} that checks whether the supplied
         * {@link DataManipulator} type is supported by the {@link DataHolder}.
         *
         * @param predicate The predicate
         * @return This builder, for chaining
         */
        RawBuilder predicate(Predicate<? extends DataHolder> predicate);
    }

    public interface TypeBuilder<T extends DataManipulator<T, I>, I extends ImmutableDataManipulator<I, T>> {

        <E> TypeBuilder<T, I> key(Key<? extends BaseValue<E>> key, String id, E defaultValue) throws IllegalArgumentException;

        <E> TypeBuilder<T, I> boundedKey(Key<? extends BoundedValue<E>> key, String id, E defaultValue, E lowerBound, E upperBound) throws IllegalArgumentException;

        TypeBuilder<T, I> predicate(Predicate<? extends DataHolder> predicate) throws IllegalArgumentException;

        TypeBuilder<T, I> version(int contentVersion);

        DataRegistration<T, I> build(Object pluginInstance, String id) throws IllegalArgumentException, IllegalStateException;
    }

}
