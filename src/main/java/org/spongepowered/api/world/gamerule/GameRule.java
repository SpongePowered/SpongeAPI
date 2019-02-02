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
package org.spongepowered.api.world.gamerule;

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.CatalogKey;
import org.spongepowered.api.CatalogType;
import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.util.CatalogBuilder;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * Represents a game rule.
 *
 * @param <V> The type of the value
 */
@CatalogedBy(GameRules.class)
public interface GameRule<V> extends CatalogType {

    /**
     * Gets the value {@link TypeToken type}.
     *
     * @return The value type
     */
    TypeToken<V> getValueType();

    /**
     * Gets the default value.
     *
     * @return The default value
     */
    V getDefaultValue();

    // TODO: Command argument parser

    interface Builder<V> extends CatalogBuilder<GameRule<V>, Builder<V>> {

        // TODO: Command argument parser

        /**
         * Sets the name of the {@link CatalogType}. Defaults to the
         * {@link CatalogKey#getValue() catalog key value}.
         *
         * <p>This name will be used when setting game rules through
         * a command. If duplicate names are found between namespaces,
         * the plain {@link #key(CatalogKey)} will need to be used
         * instead.</p>
         *
         * @param name The name
         * @return This builder for chaining
         */
        @Override
        Builder<V> name(String name);

        /**
         * Sets the name of the {@link CatalogType} as a {@link Translation}. Defaults
         * to the {@link CatalogKey#getValue() catalog key value}.
         *
         * <p>This name will be used when setting game rules through
         * a command. If duplicate names are found between namespaces,
         * the plain {@link #key(CatalogKey)} will need to be used
         * instead.</p>
         *
         * @param translation The name translation
         * @return This builder for chaining
         */
        @Override
        Builder<V> name(Translation translation);

        /**
         * Sets the value type.
         *
         * @param valueType The value type
         * @param <NV> The value type
         * @return This builder, for chaining
         */
        default <NV> Builder<NV> valueType(Class<NV> valueType) {
            return valueType(TypeToken.of(valueType));
        }

        /**
         * Sets the value {@link TypeToken type}.
         *
         * @param valueType The value type
         * @param <NV> The value type
         * @return This builder, for chaining
         */
        <NV> Builder<NV> valueType(TypeToken<NV> valueType);

        /**
         * Sets the default value.
         *
         * <p>Must be called after {@link #valueType(TypeToken)}.</p>
         *
         * @param defaultValue The default value
         * @return This builder, for chaining
         */
        Builder<V> defaultValue(V defaultValue);

        /**
         * Builds the {@link GameRule}.
         *
         * @return The built game rule
         * @throws IllegalStateException If not all required options were specified; {@link #key(CatalogKey)},
         *                               {@link #valueType(TypeToken)}, {@link #defaultValue(Object)}.
         */
        @Override
        GameRule<V> build() throws IllegalStateException;

        /**
         * @deprecated It's not allowed to duplicate game rules.
         */
        @Deprecated
        @Override
        default Builder<V> from(GameRule<V> value) {
            throw new UnsupportedOperationException("Duplicating game rules isn't allowed.");
        }
    }
}
