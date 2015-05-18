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
import com.google.common.base.Predicate;
import org.spongepowered.api.data.token.BaseToken;
import org.spongepowered.api.data.token.GetterToken;
import org.spongepowered.api.data.token.SetterToken;
import org.spongepowered.api.data.token.Token;
import org.spongepowered.api.service.persistence.InvalidDataException;

import java.util.Collection;

import javax.annotation.Nullable;

/**
 * A data holder object allows the access of additional data on the object
 * that is not simply expressed by its basic type.
 *
 * <p>For example, a chest block, which is of the chest type, also has
 * inventory. This inventory is considered extra data, which can
 * be accessed via {@link #getData(Class)}, provided that an implementation
 * exposes that extra data.</p>
 */
public interface DataHolder extends DataSerializable {

    /**
     * Gets an instance of the given data class for this {@link DataHolder}.
     *
     * <p>If there is no pre-existing data that can be represented by the given
     * {@link Component} class, {@link Optional#absent()} is returned.
     * </p>
     *
     * @param dataClass The data class
     * @param <T> The type of data
     * @return An instance of the class, if not available
     */
    <T extends Component<T>> Optional<T> getData(Class<T> dataClass);

    /**
     * Gets or creates a new {@link Component} that can be accepted by
     * this {@link DataHolder}. In the event that there is no data that can
     * be represented by the given {@link Component}, a new
     * {@link Component} object is created with default values.
     *
     * <p>In the event the {@link Component} can not represent any data
     * pertaining to this {@link DataHolder}, {@link Optional#absent()} is
     * returned.</p>
     *
     * @param componentClass The data class
     * @param <T> The type of data
     * @return An instance of the class, if not available
     */
    <T extends Component<T>> Optional<T> getOrCreate(Class<T> componentClass);

    /**
     * Attempts to remove the given {@link Component} represented on this
     * {@link DataHolder} if possible.
     *
     * <p>Certain {@link Component}s can not be removed due to certain
     * dependencies relying on the particular data to function.</p>
     *
     * @param componentClass The data component class
     * @param <T> The type of data component
     * @return If the removal was successful
     */
    <T extends Component<T>> boolean remove(Class<T> componentClass);

    /**
     * Checks if the given {@link Component} class is able to represent
     * data within this {@link DataHolder}.
     *
     * @param componentClass The data class
     * @param <T> The type of data
     * @return True if this {@link DataHolder} can accept the
     *     {@link Component} object
     */
    <T extends Component<T>> boolean isCompatible(Class<T> componentClass);

    /**
     * Offers the given {@link Component} to this {@link DataHolder}.
     *
     * <p>In the event that the {@link Component} contains data that
     * would otherwise overlap existing data on this {@link DataHolder}, a
     * default {@link DataPriority#COMPONENT} is used.</p>
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected and replaced
     * data.</p>
     *
     * @param component The component data to offer
     * @param <T> The type of component data
     * @return The transaction result
     */
    <T extends Component<T>> DataTransactionResult offer(T component);

    /**
     * Offers the given {@link Component} to this {@link DataHolder}.
     *
     * <p>If any data is rejected or existing data is replaced, the
     * {@link DataTransactionResult} will retain the rejected and replaced
     * data.</p>
     *
     * @param component The component data to offer
     * @param <T> The type of component data
     * @param priority The data priority to use
     * @return The transaction result
     */
    <T extends Component<T>> DataTransactionResult offer(T component, DataPriority priority);

    /**
     * Gets an copied collection of all known {@link Component}s
     * belonging to this {@link DataHolder}. An individual
     * {@link Component} can be used for creating new data to replace on
     * this {@link DataHolder}.
     *
     * @return A collection of copied data components belonging to this
     *     data holder
     */
    Collection<Component<?>> getComponents();

    /**
     * Attempts to retrieve a specific {@link Property} type of this
     * {@link DataHolder}. If the property is not applicable,
     * {@link Optional#absent()} is returned.
     *
     * <p>{@link Property}s can define various immutable information about a
     * {@link DataHolder} that is dependent on the instance of the holder.
     * As {@link Property}s cannot be changed, the {@link DataHolder} can
     * not change the information about it's own properties either.</p>
     *
     * @param propertyClass The property class
     * @param <T> The type of property
     * @return The property, if available
     */
    <T extends Property<?, ?>> Optional<T> getProperty(Class<T> propertyClass);

    /**
     * Gets an immutable collection of all known {@link Property}s pertaining
     * to this {@link DataHolder}.
     *
     * <p>{@link Property}s can not be changed such that the property is
     * attached to the instance of the residing {@link DataHolder}.</p>
     *
     * @return An immutable collection of all known {@link Property}s
     */
    Collection<Property<?, ?>> getProperties();

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
     * {@link SetterToken}.
     *
     * @param setterToken The setter token to set the underlying value of
     * @param value The value to set
     * @param <V> The type of value
     * @return The data holder, for chaining
     */
    <V> DataHolder set(SetterToken<V> setterToken, V value);

    /**
     * Atteps to apply a transformation of the value keyed to the given
     * {@link Token} such that the given {@link Function} is applied onto the
     * supplied value.
     *
     * <p>Note that the {@link Function} is only applied when the
     * {@link DataHolder} supports the {@link Token}. If the value is currently
     * absent or null, the {@link Function} will still be called, but the input
     * will remain null. The output of the {@link Function} should never return
     * null.</p>
     *
     * @param token The token for the value of data
     * @param transformerFunction The transformer function to apply to the
     *     value
     * @param <V> The type of value being transformed
     * @return This data holder, for chaining
     */
    <V> DataHolder transform(Token<V> token, Function<V, V> transformerFunction);

    /**
     * Attempts to retrieve a {@link Predicate} for the given {@link Token}. If
     * the {@link Token} is not supported, {@link Optional#absent()} is
     * returned. The {@link Predicate} can be used to perform validation on a
     * value prior to {@link DataHolder#set(SetterToken, Object)}.
     *
     * @param token The token to get the predicate for
     * @param <V> The type of value
     * @return The predicate, if available
     */
    <V> Optional<Predicate<V>> predicateFor(Token<V> token);

    /**
     * Validates the container with known data required to set the raw data to
     * this {@link DataHolder}. If the container is incomplete or contains
     * invalid data, <code>false</code> is returned.
     *
     * <p>This validation should be checked prior to calling
     * {@link #setRawData(DataContainer)} to avoid exceptions.</p>
     *
     * @param container The raw data to validate
     * @return True if the data is valid
     */
    boolean validateRawData(DataContainer container);

    /**
     * Attempts to set all data of this {@link DataHolder} according to the
     * {@link DataContainer}'s held information. Using this to modify known
     * {@link Component} is unsupported and if the data is invalid, an
     * {@link InvalidDataException} is thrown.
     *
     * <p>This setter is used to provide setting custom data that is not
     * represented by the Data API, including forge mods and other
     * unknown data. Attempts at validating known {@link Component}s
     * contained in the data container are made with the assumption that all
     * necessary data exists.</p>
     *
     * @param container A container containing all raw data to set on this
     *     data holder
     * @throws InvalidDataException If the container is missing or has invalid
     *     data that this holder will refuse
     */
    void setRawData(DataContainer container) throws InvalidDataException;

}
