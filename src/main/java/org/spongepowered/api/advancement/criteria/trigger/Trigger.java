/*
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.advancement.criteria.trigger;

import com.google.gson.Gson;
import io.leangen.geantyref.TypeToken;
import org.spongepowered.api.config.ConfigManager;
import org.spongepowered.configurate.ConfigurationOptions;
import org.spongepowered.configurate.serialize.TypeSerializer;
import org.spongepowered.configurate.serialize.TypeSerializerCollection;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.advancement.criteria.AdvancementCriterion;
import org.spongepowered.api.data.persistence.DataSerializable;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.advancement.CriterionEvent;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.scoreboard.criteria.Criterion;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.lang.reflect.Type;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * Represents a source that can trigger a {@link AdvancementCriterion}.
 *
 * @param <C> The configuration type
 */
@SuppressWarnings("unchecked")
@CatalogedBy(Triggers.class)
public interface Trigger<C extends FilteredTriggerConfiguration> extends CatalogType {

    /**
     * Creates a new {@link Builder} which can be used to create
     * a {@link Trigger}.
     *
     * @return The builder
     */
    static Builder<?> builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the type of the used {@link FilteredTriggerConfiguration}.
     *
     * <p>This type represents the {@code C} type parameter of this instance.</p>
     *
     * @return The configuration type
     */
    Type getConfigurationType();

    /**
     * Triggers the {@link Trigger} for all the online
     * {@link ServerPlayer players}.
     */
    void trigger();

    /**
     * Triggers the {@link Trigger} for the specified
     * {@link ServerPlayer players}.
     *
     * @param players The players to trigger for
     */
    void trigger(Iterable<ServerPlayer> players);

    /**
     * Triggers the {@link Trigger} for the
     * specified {@link ServerPlayer player}.
     *
     * @param player The player to trigger for
     */
    void trigger(ServerPlayer player);

    /**
     * A builder to create {@link Trigger}s.
     *
     * @param <C> The configuration type
     */
    interface Builder<C extends FilteredTriggerConfiguration> extends CopyableBuilder<Trigger<C>, Builder<C>> {

        /**
         * Sets the class for the {@link FilteredTriggerConfiguration} as
         * a {@link DataSerializable}. The configuration will be constructed
         * using the {@link DataBuilder} that is registered for
         * the {@link DataSerializable}.
         *
         * @param dataConfigClass The configuration class
         * @param <T> The configuration type
         * @return This builder, for chaining
         */
        <T extends FilteredTriggerConfiguration & DataSerializable> Builder<T> dataSerializableConfig(Class<T> dataConfigClass);

        /**
         * Sets the class for the {@link FilteredTriggerConfiguration} as
         * a config serializable. This configuration will be constructed
         * using Configurate (with {@link TypeSerializer}s).
         *
         * <p>By default, the configuration will be loaded with
         * Sponge-default options, with serializers as defined in
         * {@link ConfigManager#getSerializers()}.</p>
         *
         * @param configClass The configuration class
         * @param <T> The configuration type
         * @return This builder, for chaining
         */
        <T extends FilteredTriggerConfiguration> Builder<T> typeSerializableConfig(TypeToken<T> configClass);

        /**
         * Sets the class for the {@link FilteredTriggerConfiguration} as
         * a config serializable. This configuration will be constructed using
         * Configurate (with {@link TypeSerializer}s) with a
         * specific {@link TypeSerializerCollection} instead of the global one.
         *
         * @param configClass The configuration class
         * @param options The configuration options that control loading of data
         * @param <T> The configuration type
         * @return This builder, for chaining
         */
        <T extends FilteredTriggerConfiguration> Builder<T> typeSerializableConfig(TypeToken<T> configClass, ConfigurationOptions options);

        /**
         * Sets the class for the {@link FilteredTriggerConfiguration} as
         * a config serializable. This configuration will be constructed using
         * Configurate with specific options.
         *
         * <p>The configuration will be loaded with the returned
         * derivation of Sponge-default options, with serializers as defined in
         * {@link ConfigManager#getSerializers()}.</p>
         *
         * @param configClass The configuration class
         * @param options A callback that will receive options to modify
         * @param <T> The configuration type
         * @return This builder, for chaining
         */
        <T extends FilteredTriggerConfiguration> Builder<T> typeSerializableConfig(TypeToken<T> configClass,
                UnaryOperator<ConfigurationOptions> options);

        /**
         * Sets the class for the {@link FilteredTriggerConfiguration} as
         * a config serializable. This configuration will be constructed
         * using Configurate (with {@link TypeSerializer}s).
         *
         * <p>By default, the configuration will be loaded with
         * Sponge-default options, with serializers as defined in
         * {@link ConfigManager#getSerializers()}.</p>
         *
         * @param configClass The configuration class
         * @param <T> The configuration type
         * @return This builder, for chaining
         */
        <T extends FilteredTriggerConfiguration> Builder<T> typeSerializableConfig(Class<T> configClass);

        /**
         * Sets the class for the {@link FilteredTriggerConfiguration} as
         * a config serializable. This configuration will be constructed using
         * Configurate (with {@link TypeSerializer}s) with a
         * specific {@link TypeSerializerCollection} instead of the global one.
         *
         * @param configClass The configuration class
         * @param options The configuration options that control loading of data
         * @param <T> The configuration type
         * @return This builder, for chaining
         */
        <T extends FilteredTriggerConfiguration> Builder<T> typeSerializableConfig(Class<T> configClass, ConfigurationOptions options);

        /**
         * Sets the class for the {@link FilteredTriggerConfiguration} as
         * a config serializable. This configuration will be constructed using
         * Configurate with customized options based off of the Sponge-default
         * options.
         *
         * <p>The configuration will be loaded with the returned
         * derivation of Sponge-default options, with serializers as defined in
         * {@link ConfigManager#getSerializers()}.</p>
         *
         * @param configClass The configuration class
         * @param options A callback that will receive options to modify
         * @param <T> The configuration type
         * @return This builder, for chaining
         */
        <T extends FilteredTriggerConfiguration> Builder<T> typeSerializableConfig(Class<T> configClass, UnaryOperator<ConfigurationOptions> options);

        /**
         * Sets the class for the {@link FilteredTriggerConfiguration} as
         * a json serializable. This configuration will be constructed using
         * the provided {@link Gson} instance.
         *
         * @param configClass The configuration class
         * @param gson The gson instance to use
         * @param <T> The configuration type
         * @return This builder, for chaining
         */
        <T extends FilteredTriggerConfiguration> Builder<T> jsonSerializableConfig(Class<T> configClass, Gson gson);

        /**
         * Sets the class for the {@link FilteredTriggerConfiguration} as
         * a json serializable. This configuration will be constructed using
         * the default {@link Gson} instance.
         *
         * @param configClass The configuration class
         * @param <T> The configuration type
         * @return This builder, for chaining
         */
        <T extends FilteredTriggerConfiguration> Builder<T> jsonSerializableConfig(Class<T> configClass);

        /**
         * Sets the class for the {@link FilteredTriggerConfiguration} to use
         * {@link FilteredTriggerConfiguration.Empty}.
         *
         * @return This builder, for chaining
         */
        Builder<FilteredTriggerConfiguration.Empty> emptyConfig();

        /**
         * Adds the {@link Consumer} to handle the triggers. If no handler is
         * provided then will the result of the trigger always be {@code true},
         * which results in triggering the {@link Criterion}.
         *
         * <p>The {@link Cause} of the event should be used to determine
         * whether the configuration matches the requirements to trigger
         * the criterion.</p>
         *
         * @param eventListener The event listener
         * @return This builder, for chaining
         */
        Builder<C> listener(Consumer<CriterionEvent.Trigger<C>> eventListener);

        /**
         * Sets the identifier of the {@link Trigger}
         * (without the namespace).
         *
         * @param id The identifier
         * @return This builder, for chaining
         */
        Builder<C> id(String id);

        /**
         * Sets the name of the {@link Trigger}. Defaults
         * to the identifier ({@link #id(String)}).
         *
         * @param name The name
         * @return This builder, for chaining
         */
        Builder<C> name(String name);

        /**
         * Builds a {@link Trigger}.
         *
         * @return The trigger type
         */
        Trigger<C> build();
    }
}
