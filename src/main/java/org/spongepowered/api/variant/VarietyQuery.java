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
package org.spongepowered.api.variant;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Collection;

/**
 * A variety query will be used to match a set of specific
 * {@link Variety varieties} and {@link Property properties} on
 * a {@link VarietyQueryable}.
 */
public interface VarietyQuery {

    /**
     * Creates a {@link Builder} to create {@link VarietyQuery variety queries}.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Creates a {@link VarietyQuery} from the provided {@link Variety}.
     *
     * @param variety The variety
     * @return The variety query
     */
    static VarietyQuery of(Variety variety) {
        return builder().variety(variety).build();
    }

    /**
     * Creates a {@link VarietyQuery} from the provided {@link Variety}
     * and the specific {@link MatchOperator}.
     *
     * @param variety The variety
     * @return The variety query
     */
    static VarietyQuery of(Variety variety, MatchOperator operator) {
        return builder().variety(variety, operator).build();
    }

    /**
     * Creates a {@link VarietyQuery} from the provided
     * {@link Property properties}.
     *
     * @param properties The properties
     * @return The variety query
     */
    static VarietyQuery of(Property<?,?>... properties) {
        return builder().properties(properties).build();
    }

    /**
     * Gets the {@link VarietyQueryEntry} that will be matched.
     *
     * @return The variety entries
     */
    Collection<VarietyQueryEntry> getVarietyEntries();

    /**
     * Gets the {@link Property properties} that
     * will be matched.
     *
     * @return The properties
     */
    Collection<Property<?,?>> getProperties();

    /**
     * A builder to create {@link VarietyQuery variety queries}.
     */
    interface Builder extends ResettableBuilder<VarietyQuery, Builder> {

        /**
         * Adds the {@link Variety varieties}.
         *
         * @param varieties The varieties
         * @return This builder, for chaining
         */
        default Builder varieties(Variety... varieties) {
            for (Variety variety : varieties) {
                variety(variety);
            }
            return this;
        }

        /**
         * Adds the {@link Variety varieties}.
         *
         * @param varieties The varieties
         * @return This builder, for chaining
         */
        default Builder varieties(Iterable<Variety> varieties) {
            for (Variety variety : varieties) {
                variety(variety);
            }
            return this;
        }

        /**
         * Adds the {@link Variety}.
         *
         * @param variety The variety
         * @return This builder, for chaining
         */
        default Builder variety(Variety variety) {
            return variety(variety, MatchOperator.EQUAL);
        }

        /**
         * Adds the {@link Variety} with a specific
         * {@link MatchOperator}.
         *
         * @param variety The variety
         * @param operator The operator
         * @return This builder, for chaining
         */
        Builder variety(Variety variety, MatchOperator operator);

        /**
         * Adds the {@link Property} that should
         * be matched.
         *
         * @param property The property
         * @return This builder, for chaining
         */
        Builder property(Property<?,?> property);

        /**
         * Adds the {@link Property properties} that should
         * be matched.
         *
         * @param properties The properties
         * @return This builder, for chaining
         */
        Builder properties(Property<?,?>... properties);

        /**
         * Adds the {@link Property properties} that should
         * be matched.
         *
         * @param properties The properties
         * @return This builder, for chaining
         */
        Builder properties(Iterable<Property<?,?>> properties);

        /**
         * Builds the {@link VarietyQuery}.
         *
         * @return The variety query
         */
        VarietyQuery build();
    }
}
