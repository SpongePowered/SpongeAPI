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

public interface DataSection {

    Set<String> getKeys(boolean deep);

    Map<String, Object> getValues(boolean deep);

    boolean contains(String path);

    boolean isSet(String path);

    String getCurrentPath();

    String getName();

    Optional<DataSection> getRoot();

    Optional<DataSection> getParent();

    Optional<Object> get(String path);

    void set(String path, Object value);

    DataSection createSection(String path);

    DataSection createSection(String path, Map<?, ?> map);

    Optional<DataSection> getSection(String path);

    Optional<Boolean> getBoolean(String path);

    Optional<Integer> getInt(String path);

    Optional<Long> getLong(String path);

    Optional<Double> getDouble(String path);

    Optional<String> getString(String path);

    Optional<List<?>> getList(String path);

    Optional<List<String>> getStringList(String path);

    Optional<List<Character>> getCharacterList(String path);

    Optional<List<Boolean>> getBooleanList(String path);

    Optional<List<Byte>> getByteList(String path);

    Optional<List<Short>> getShortList(String path);

    Optional<List<Integer>> getIntegerList(String path);

    Optional<List<Long>> getLongList(String path);

    Optional<List<Float>> getFloatList(String path);

    Optional<List<Double>> getDoubleList(String path);

    Optional<List<Map<?, ?>>> getMapList(String path);

}
