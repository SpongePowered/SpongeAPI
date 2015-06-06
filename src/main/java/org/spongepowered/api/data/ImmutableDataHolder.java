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
package org.spongepowered.api.data;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableCollection;
import org.spongepowered.api.data.token.BaseToken;
import org.spongepowered.api.data.token.GetterToken;
import org.spongepowered.api.data.token.SetterToken;
import org.spongepowered.api.data.token.Token;

import javax.annotation.Nullable;

/**
 * Represents an immutable variant of the {@link DataHolder} where once built,
 * the {@link ImmutableDataHolder} can not be modified.
 *
 * @see DataHolder
 * @param <T> The sub type of immutable data holder
 */
public interface ImmutableDataHolder<T extends ImmutableDataHolder<T>> extends DataSerializable {

    /**
     * Get a copy of all properties defined on this
     * {@link ImmutableDataHolder}, with their current values.
     *
     * @return A collection of all known components
     */
    ImmutableCollection<Component<?>> getComponents();

    /**
     * Gets an instance of the given data class for this
     * {@link ImmutableDataHolder}.
     *
     * <p>If there is no pre-existing data that can be represented by the given
     * {@link Component} class, {@link Optional#absent()} is returned.
     * </p>
     *
     * @param componentClass The data class
     * @param <M> The type of data
     * @return An instance of the component, if not available
     */
    <M extends Component<M>> Optional<M> getComponent(Class<M> componentClass);

    /**
     * Gets an altered copy of this {@link ImmutableDataHolder} with the given
     * {@link Component} modified data. If the data is not compatible for
     * any reason, {@link Optional#absent()} is returned.
     *
     * <p>This does not alter the current {@link ImmutableDataHolder}.</p>
     *
     * @param component The new component containing data
     * @param <M> The type of data component
     * @return A new immutable data holder with the given component
     */
    <M extends Component<M>> Optional<T> withData(M component);

    /**
     * Gets an altered copy of this {@link ImmutableDataHolder} without the
     * given {@link Component}. If the data represented by the
     * component can not exist without a "default state" of the
     * {@link Component}, the {@link Component} is reset to the
     * "default" state.
     *
     * @param component The component class to remove
     * @param <M> The component type
     * @return A new immutable data holder without the given component
     */
    <M extends Component<M>> Optional<T> withoutData(Class<M> component);

    /**
     * Checks if the given {@link BaseToken} is compatible with this
     * {@link DataHolder}.
     *
     * @param baseToken The token to check
     * @return True if the token is compatible with this data holder
     */
    boolean isCompatible(BaseToken<?> baseToken);

    /**
     * Gets the value keyed by the given {@link GetterToken}. If the value
     * is supported but not currently set, {@link Optional#absent()} is
     * returned. If the {@link GetterToken} is not compatible with this
     * {@link DataHolder}, {@link Optional#absent()} is returned.
     *
     * @param getterToken The getter token
     * @param <V> The type of value to return
     * @return The value, if available
     */
    <V> Optional<V> get(GetterToken<V> getterToken);

    /**
     * Gets the value for the given {@link GetterToken}. If the value is not
     * set, but supported by this {@link DataHolder}, then the given default
     * is returned.
     *
     * <p>The value is NOT modified in any way.</p>
     *
     * @param getterToken The getter token
     * @param defaultValue The default value if not set
     * @param <V> The type of value
     * @return The value, if not default
     */
    <V> V getOrDefault(GetterToken<V> getterToken, V defaultValue);

    /**
     * Attempts to get the value for the {@link GetterToken}, if the value is
     * not set, {@code null} is returned. This performs no checks whether the
     * value to be fetched keyed by the {@link GetterToken} is compatible with
     * this {@link DataHolder}, so it should be considered that
     * {@link #isCompatible(BaseToken)} is checked prior to expecting a value
     * to be returned.
     *
     * @param getterToken The getter token
     * @param <V> The type of value to be returned
     * @return The value, or null
     */
    @Nullable
    <V> V getOrNull(GetterToken<V> getterToken);

    /**
     * Sets the given value type {@link V} determined by the
     * {@link SetterToken} as a new {@link ImmutableDataHolder} instance.
     *
     * @param setterToken The setter token to set the underlying value of
     * @param value The value to set
     * @param <V> The type of value
     * @return A new instance of this immutable data holder
     */
    <V> T set(SetterToken<V> setterToken, V value);

    /**
     * Atteps to apply a transformation of the value keyed to the given
     * {@link Token} such that the given {@link Function} is applied onto the
     * supplied value.
     *`
     * <p>Note that the {@link Function} is only applied when the
     * {@link DataHolder} supports the {@link Token}. If the value is currently
     * absent or null, the {@link Function} will still be called, but the input
     * will remain null. The output of the {@link Function} should never return
     * null.</p>
     *
     * @param token The token for the value of data
     * @param transformerFunction The transformer function to apply to the value
     * @param <V> The type of value being transformed
     * @return A new instance of this immutable data holder
     */
    <V> T transform(Token<V> token, Function<V, V> transformerFunction);

}
