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
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializer;
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializerCollection;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.advancement.criteria.AdvancementCriterion;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.advancement.CriterionEvent;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.scoreboard.critieria.Criterion;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.function.Consumer;

/**
 * Represents a source that can trigger a {@link AdvancementCriterion}.
 *
 * @param <C> The configuration type
 */
@SuppressWarnings("unchecked")
@CatalogedBy(Triggers.class)
public interface Trigger<C extends FilteredTriggerConfiguration> extends CatalogType {

    /**
     * Creates a new {@link Builder}.
     *
     * @return The builder
     */
    static Builder<?> builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the type of the used {@link FilteredTriggerConfiguration}.
     *
     * @return The configuration type
     */
    Class<C> getConfigurationType();

    /**
     * Triggers the {@link Trigger} for all
     * the online {@link Player}s.
     */
    void trigger();

    /**
     * Triggers the {@link Trigger} for the
     * specified {@link Player}s.
     */
    void trigger(Iterable<Player> players);

    /**
     * Triggers the {@link Trigger} for the
     * specified {@link Player}.
     */
    void trigger(Player player);

    /**
     * A builder to create {@link Trigger}s.
     *
     * @param <C> The configuration type
     */
    interface Builder<C extends FilteredTriggerConfiguration> extends ResettableBuilder<Trigger<C>, Builder<C>> {

        /**
         * Sets the class for the {@link FilteredTriggerConfiguration} as a {@link DataSerializable}. The
         * configuration will be constructed using the {@link DataBuilder} that is registered
         * for the {@link DataSerializable}.
         *
         * @param dataConfigClass The configuration class
         * @param <T> The configuration type
         * @return This builder, for chaining
         */
        <T extends FilteredTriggerConfiguration & DataSerializable> Builder<T> dataSerializableConfig(Class<T> dataConfigClass);

        /**
         * Sets the class for the {@link FilteredTriggerConfiguration} as a config serializable. This
         * configuration will be constructed using configurate (with {@link TypeSerializer}s).
         *
         * @param configClass The configuration class
         * @param <T> The configuration type
         * @return This builder, for chaining
         */
        <T extends FilteredTriggerConfiguration> Builder<T> typeSerializableConfig(Class<T> configClass);

        /**
         * Sets the class for the {@link FilteredTriggerConfiguration} as a config serializable. This
         * configuration will be constructed using configurate (with {@link TypeSerializer}s)
         * with a specific {@link TypeSerializerCollection} instead of the global one.
         *
         * @param configClass The configuration class
         * @param typeSerializerCollection The type serializer collection
         * @param <T> The configuration type
         * @return This builder, for chaining
         */
        <T extends FilteredTriggerConfiguration> Builder<T> typeSerializableConfig(Class<T> configClass,
                TypeSerializerCollection typeSerializerCollection);

        /**
         * Sets the class for the {@link FilteredTriggerConfiguration} as a json serializable. This
         * configuration will be constructed using the provided {@link Gson} instance.
         *
         * @param configClass The configuration class
         * @param gson The gson
         * @param <T> The configuration type
         * @return This builder, for chaining
         */
        <T extends FilteredTriggerConfiguration> Builder<T> jsonSerializableConfig(Class<T> configClass, Gson gson);

        /**
         * Sets the class for the {@link FilteredTriggerConfiguration} as a json serializable. This
         * configuration will be constructed using the default {@link Gson} instance.
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
         * <p>The {@link Cause} of the event should be used to determine
         * whether the configuration matches the requirements to trigger
         * the criterion.
         *
         * @param eventListener The event listener
         * @return This builder, for chaining
         */
        Builder<C> listener(Consumer<CriterionEvent.Trigger<C>> eventListener);

        /**
         * Builds a {@link Trigger} with the given identifier (without the namespace).
         *
         * @param id The identifier
         * @return The trigger type
         */
        Trigger<C> build(String id);
    }
}
