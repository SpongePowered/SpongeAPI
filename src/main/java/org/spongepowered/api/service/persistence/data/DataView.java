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
package org.spongepowered.api.service.persistence.data;

import com.google.common.base.Optional;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Represents an object of data represented by a map.
 * <p>DataViews always exist within a {@link DataContainer} and can be used
 * for serialization.</p>
 */
public interface DataView {

    /**
     * Gets the parent container of this DataView.
     * <p>Every DataView will always have a {@link DataContainer}.</p>
     * <p>For any {@link DataContainer}, this will return itself.</p>
     *
     * @return The parent container
     */
    DataContainer getContainer();

    /**
     * Gets the current path of this {@link DataView} from its root
     * {@link DataContainer}.
     * <p>For any {@link DataContainer} itself, this will return an
     * empty string as it is the root of the path.</p>
     * <p>The full path will always include this {@link DataView}s name
     * at the end of the path, separated by the
     * {@link DataOptions#getPathSeparator()}.</p>
     *
     * @return The path of this view originating from the root
     */
    String getCurrentPath();

    /**
     * Gets the name of this individual {@link DataView} in the path.
     * <p>This will always be the final substring of the full path
     * from {@link #getCurrentPath()}.</p>
     *
     * @return The name of this DataView
     */
    String getName();

    /**
     * Gets the parent {@link DataView} of this view. The parent directly
     * contains this view according to the {@link #getCurrentPath()}.
     * <p>For any {@link DataContainer}, this will return an absent parent.</p>
     *
     * @return The parent data view containing this view
     */
    Optional<DataView> getParent();

    /**
     * Gets a set containing all keys in this {@link DataView}.
     * <p>If deep is set to true, then this will contain all the keys
     * within any child {@link DataView}s (and their children, etc).
     * These will be in a valid path notation for you to use.</p>
     * <p>If deep is set to false, then this will contain only the keys
     * of any direct children, and not their own children.</p>
     *
     * @param deep Whether or not to get all children keys
     * @return A set of current keys in this container
     */
    Set<String> getKeys(boolean deep);

    /**
     * Gets a Map containing all keys and their values for this {@link DataView}.
     * <p>If deep is set to true, then this will contain all the keys and
     * values within any child {@link DataView}s (and their children,
     * etc). These keys will be in a valid path notation for you to use.</p>
     * <p>If deep is set to false, then this will contain only the keys and
     * values of any direct children, and not their own children.</p>
     *
     * @param deep Whether or not to get a deep list of all children or not
     * @return Map of keys and values of this container
     */
    Map<String, Object> getValues(boolean deep);

    /**
     * Returns whether this {@link DataView} contains the given path.
     * <p>Paths should respect the owning {@link DataContainer}s
     * {@link DataOptions#getPathSeparator()} such that the path will be
     * parsed correctly.</p>
     *
     * @param path The path relative to this data view
     * @return True if the path exists
     */
    boolean contains(String path);

    /**
     * Gets an object from the desired path. If the path is not defined,
     * an absent Optional is returned.
     *
     * @param path The path to the Object
     * @return The Object, if available
     */
    Optional<Object> get(String path);

    /**
     * Sets the given Object value according to the given path relative to
     * this {@link DataView}'s path.
     *
     * @param path The path of the object to set
     * @param value The value of the data
     */
    void set(String path, Object value);

    /**
     * Removes the data associated to the given path relative to this
     * {@link DataView}'s path.
     * <p>Path can not be emtpy, to remove this {@link DataView}, call
     * the associated parent to remove this views name.</p>
     *
     * @param path The path of data to remove
     */
    void remove(String path);

    /**
     * Creates a new {@link DataView} at the desired path.
     * <p>If any data existed at the given path, that data will be
     * overwritten with the newly constructed {@link DataView}.</p>
     *
     * @param path The path of the new view
     * @return The newly created view
     */
    DataView createView(String path);

    /**
     * Creates a new {@link DataView} with the given data at the desired
     * path.
     * <p>If any data existed at the given path, that data will be overwritten
     * with the newly constructed {@link DataView}.</p>
     *
     * @param path The path of the new view
     * @param map The data to store in the new view
     * @return The new view
     */
    DataView createView(String path, Map<?, ?> map);

    /**
     * Gets the {@link DataView} by path, if available.
     * <p>If a {@link DataView} does not exist, or the data residing at
     * the path is not an instance of a {@link DataView}, an absent is
     * returned.</p>
     *
     * @param path The path of the value to get
     * @return The data view, if available
     */
    Optional<DataView> getView(String path);

    /**
     * Gets the {@link Boolean} by path, if available.
     * <p>If a {@link Boolean} does not exist, or the data residing at
     * the path is not an instance of a {@link Boolean}, an absent is
     * returned.</p>
     *
     * @param path The path of the value to get
     * @return The boolean, if available
     */
    Optional<Boolean> getBoolean(String path);

    /**
     * Gets the {@link Integer} by path, if available.
     * <p>If a {@link Integer} does not exist, or the data residing at
     * the path is not an instance of a {@link Integer}, an absent is
     * returned.</p>
     *
     * @param path The path of the value to get
     * @return The integer, if available
     */
    Optional<Integer> getInt(String path);

    /**
     * Gets the {@link Long} by path, if available.
     * <p>If a {@link Long} does not exist, or the data residing at
     * the path is not an instance of a {@link Long}, an absent is
     * returned.</p>
     *
     * @param path The path of the value to get
     * @return The long, if available
     */
    Optional<Long> getLong(String path);

    /**
     * Gets the {@link Double} by path, if available.
     * <p>If a {@link Double} does not exist, or the data residing at
     * the path is not an instance of a {@link Double}, an absent is
     * returned.</p>
     *
     * @param path The path of the value to get
     * @return The double, if available
     */
    Optional<Double> getDouble(String path);

    /**
     * Gets the {@link String} by path, if available.
     * <p>If a {@link String} does not exist, or the data residing at
     * the path is not an instance of a {@link String}, an absent is
     * returned.</p>
     *
     * @param path The path of the value to get
     * @return The string, if available
     */
    Optional<String> getString(String path);

    /**
     * Gets the {@link List} of something by path, if available.
     * <p>If a {@link List} of something does not exist, or the data
     * residing at the path is not an instance of a {@link List} of something,
     * an absent is returned.</p>
     *
     * @param path The path of the value to get
     * @return The list, if available
     */
    Optional<List<?>> getList(String path);

    /**
     * Gets the {@link List} of {@link String} by path, if available.
     * <p>If a {@link List} of {@link String} does not exist, or the data
     * residing at the path is not an instance of a {@link List} of
     * {@link String}, an absent is returned.</p>
     *
     * @param path The path of the value to get
     * @return The list of strings, if available
     */
    Optional<List<String>> getStringList(String path);

    /**
     * Gets the {@link List} of {@link Character} by path, if available.
     * <p>If a {@link List} of {@link Character} does not exist, or the data
     * residing at the path is not an instance of a {@link List} of
     * {@link Character}, an absent is returned.</p>
     *
     * @param path The path of the value to get
     * @return The list of characters, if available
     */
    Optional<List<Character>> getCharacterList(String path);

    /**
     * Gets the {@link List} of {@link Boolean} by path, if available.
     * <p>If a {@link List} of {@link Boolean} does not exist, or the data
     * residing at the path is not an instance of a {@link List} of
     * {@link Boolean}, an absent is returned.</p>
     *
     * @param path The path of the value to get
     * @return The list of booleans, if available
     */
    Optional<List<Boolean>> getBooleanList(String path);

    /**
     * Gets the {@link List} of {@link Byte} by path, if available.
     * <p>If a {@link List} of {@link Byte} does not exist, or the data
     * residing at the path is not an instance of a {@link List} of
     * {@link Byte}, an absent is returned.</p>
     *
     * @param path The path of the value to get
     * @return The list of bytes, if available
     */
    Optional<List<Byte>> getByteList(String path);

    /**
     * Gets the {@link List} of {@link Short} by path, if available.
     * <p>If a {@link List} of {@link Short} does not exist, or the data
     * residing at the path is not an instance of a {@link List} of
     * {@link Short}, an absent is returned.</p>
     *
     * @param path The path of the value to get
     * @return The list of shorts, if available
     */
    Optional<List<Short>> getShortList(String path);

    /**
     * Gets the {@link List} of {@link Integer} by path, if available.
     * <p>If a {@link List} of {@link Integer} does not exist, or the data
     * residing at the path is not an instance of a {@link List} of
     * {@link Integer}, an absent is returned.</p>
     *
     * @param path The path of the value to get
     * @return The list of integers, if available
     */
    Optional<List<Integer>> getIntegerList(String path);

    /**
     * Gets the {@link List} of {@link Long} by path, if available.
     * <p>If a {@link List} of {@link Long} does not exist, or the data
     * residing at the path is not an instance of a {@link List} of
     * {@link Long}, an absent is returned.</p>
     *
     * @param path The path of the value to get
     * @return The list of longs, if available
     */
    Optional<List<Long>> getLongList(String path);

    /**
     * Gets the {@link List} of {@link Float} by path, if available.
     * <p>If a {@link List} of {@link Float} does not exist, or the data
     * residing at the path is not an instance of a {@link List} of
     * {@link Float}, an absent is returned.</p>
     *
     * @param path The path of the value to get
     * @return The list of floats, if available
     */
    Optional<List<Float>> getFloatList(String path);

    /**
     * Gets the {@link List} of {@link Double} by path, if available.
     * <p>If a {@link List} of {@link Double} does not exist, or the data
     * residing at the path is not an instance of a {@link List} of
     * {@link Double}, an absent is returned.</p>
     *
     * @param path The path of the value to get
     * @return The list of doubles, if available
     */
    Optional<List<Double>> getDoubleList(String path);

    /**
     * Gets the {@link List} of {@link Map} by path, if available.
     * <p>If a {@link List} of {@link Map} does not exist, or the data
     * residing at the path is not an instance of a {@link List} of
     * {@link Map}, an absent is returned.</p>
     *
     * @param path The path of the value to get
     * @return The list of maps, if available
     */
    Optional<List<Map<?, ?>>> getMapList(String path);

    /**
     * Gets a {@link Map} of this {@link DataView} and all of it's children.
     * <p>This can be used as a serialization object as it is a copy.</p>
     *
     * @return A copy of the data represented by this view
     */
    Map<String, Object> toMap();
}
