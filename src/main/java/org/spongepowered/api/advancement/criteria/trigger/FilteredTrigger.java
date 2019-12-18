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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.CopyableBuilder;

/**
 * Represents something that will filter the context
 * of the {@link Trigger} to determine whether a criterion
 * will be granted.
 */
@SuppressWarnings("unchecked")
public interface FilteredTrigger<C extends FilteredTriggerConfiguration> {

    /**
     * Creates a new {@link Trigger.Builder}.
     *
     * @return The builder
     */
    static Builder<?> builder() {
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the {@link Trigger}.
     *
     * @return The type
     */
    Trigger<C> getType();

    /**
     * Gets the {@link FilteredTriggerConfiguration} of this trigger.
     *
     * @return The trigger configuration
     */
    C getConfiguration();

    /**
     * A builder to create {@link FilteredTrigger}s.
     *
     * @param <C> The trigger type
     */
    interface Builder<C extends FilteredTriggerConfiguration> extends CopyableBuilder<FilteredTrigger<C>, Builder<C>> {

        /**
         * Sets the {@link Trigger}.
         *
         * @param type The trigger type
         * @param <T> The configuration type
         * @return This builder, for chaining
         */
        <T extends FilteredTriggerConfiguration> Builder<T> type(Trigger<T> type);

        /**
         * Sets the {@link FilteredTriggerConfiguration}.
         *
         * @param config The configuration
         * @return This builder, for chaining
         */
        Builder<C> config(C config);

        /**
         * Builds the {@link FilteredTrigger}.
         *
         * @return The trigger
         */
        FilteredTrigger<C> build();

    }

}
