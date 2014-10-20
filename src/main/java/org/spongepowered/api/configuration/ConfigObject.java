/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.configuration;

import java.util.Map.Entry;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Class for adding, removing, and modifying config elements in an object.
 */
public interface ConfigObject extends ConfigElement<Object>,
Iterable<Entry<String, ConfigElement<? extends Object>>> {

    /**
     * Gets an element of an unknown type.
     * 
     * @param string The key
     * @return The element or null if it doesn't exist
     */
    @Nullable
    ConfigElement<?> getElement(@Nonnull String string);

    /**
     * Gets an element with the specified name and type.
     * 
     * @param key The key
     * @param type The type
     * @return The element value or null if it doesn't exist.
     */
    @Nullable
    <T> ConfigElement<T> getElement(@Nonnull String key, @Nonnull Class<T> type);

    /**
     * Gets an element with the specified name.  If it doesn't exist, it is set to defaultValue.
     * 
     * @param key The key
     * @param defaultValue The default value
     * @return The value or defaultValue if it doesn't exist.
     */
    <T> ConfigElement<T> getElement(@Nonnull String key, @Nullable T defaultValue);

    /**
     * Gets the element with the specified name and sets the comment.
     * If it doesn't exist, sets it to the defaultValue.
     * 
     * @param key The key
     * @param defaultValue The default value
     * @param comment The comment
     * @return The value or defaultValue if it doesn't exist.
     */
    <T> ConfigElement<T> getElement(@Nonnull String key, @Nullable T defaultValue, String comment);

    /**
     * Gets a {@link ConfigObject} with the given name. If doesn't exist, creates a new one.
     * 
     * @param key Object name
     * @return The config object or null if it doesn't exist
     */
    ConfigObject getObject(@Nonnull String key);

    /**
     * Gets a {@link ConfigObject} with the given name and comment. If it
     * doesn't exist, creates a new one.
     * 
     * @param key Object name
     * @param comment Comment
     * @return The config object
     */
    ConfigObject getObject(@Nonnull String key, String comment);

    /**
     * Gets a {@link ConfigArray} with the given name and type. If doesn't
     * exist, creates a new one.
     * 
     * @param key Array name
     * @param type Array content type
     * @return The config array
     */
    <T> ConfigArray<T> getArray(@Nonnull String key, @Nonnull Class<T> type);

    /**
     * Gets a {@link ConfigArray} with the given name, type, and comment. If it
     * doesn't exist, creates a new one.
     * 
     * @param key Array name
     * @param type Array content type
     * @param comment Comment
     * @return The config array
     */
    <T> ConfigArray<T> getArray(@Nonnull String key, @Nonnull Class<T> type, String comment);

    /**
     * Gets a {@link ConfigPrimitive} with the specified name.
     * 
     * @param key Primitive name
     * @param type The type of the primitive.
     * @return The primitive
     */
    <T> ConfigPrimitive<T> getPrimitive(@Nonnull String key, @Nonnull Class<T> type);

    /**
     * Gets a {@link ConfigPrimitive} with the specified name. If it doesn't
     * exist, uses the defaultValue.
     * 
     * @param key Primitive name
     * @param defaultValue Value to use if it doesn't exist.
     * @return The primitive
     */
    <T> ConfigPrimitive<T> getPrimitive(@Nonnull String key, @Nullable T defaultValue);

    /**
     * Gets a {@link ConfigPrimitive} with the specified name and sets the
     * comment. If it doesn't exist, uses the given default value.
     * 
     * @param key The key
     * @param defaultValue The default value
     * @param comment The comment
     * @return The primitive
     */
    <T> ConfigPrimitive<T> getPrimitive(@Nonnull String key, @Nullable T defaultValue, String comment);

    /**
     * Gets whether the element exists.
     * 
     * @param key The key
     * @return True if it has, false if not.
     */
    boolean hasElement(@Nonnull String key);

    /**
     * Gets the type stored in the element represented by the key.
     * 
     * @param key The key
     * @return The element type or null if it doesn't exist
     */
    @Nullable
    Class<?> getElementType(@Nonnull String key);

    /**
     * Deletes unused elements from this object. An element is considered
     * unused if it hasn't been accessed this session.
     */
    void cleanup();
}
