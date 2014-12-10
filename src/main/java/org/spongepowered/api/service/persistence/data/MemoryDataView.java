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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Optional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Default implementation of a {@link DataView} being used in memory.
 */
public class MemoryDataView implements DataView {

    protected final Map<String, Object> map = new LinkedHashMap<String, Object>();
    private final DataContainer container;
    private final DataView parent;
    private final String path;
    private final String fullpath;

    protected MemoryDataView() {
        if (!(this instanceof DataContainer)) {
            throw new IllegalStateException("Cannot construct a root MemoryDataView without a container!");
        }
        this.path = "";
        this.fullpath = "";
        this.parent = null;
        this.container = (DataContainer) this;
    }

    protected MemoryDataView(DataView parent, String path) {
        checkArgument(!path.isEmpty(), "Path cannot be empty.");

        this.path = path;
        this.parent = parent;
        this.container = parent.getContainer();

        this.fullpath = createPath(parent, path);
    }

    public static String createPath(final DataView section, final String key) {
        return createPath(section, key, section.getContainer());
    }

    public static String createPath(final DataView section, final String key, final DataView relativeTo) {
        DataContainer root = section.getContainer();
        char separator = root.getOptions().getPathSeparator();

        StringBuilder builder = new StringBuilder();
        for (DataView parent = section; parent.getParent().isPresent() && (parent != relativeTo); parent = parent.getParent().get()) {
            if (builder.length() > 0) {
                builder.insert(0, separator);
            }
            builder.insert(0, parent.getName());
        }

        if (!key.isEmpty()) {
            if (builder.length() > 0) {
                builder.append(separator);
            }

            builder.append(key);
        }

        return builder.toString();
    }

    @Override
    public void remove(String path) {
        // TODO implement
    }

    @Override
    public DataContainer getContainer() {
        return this.container;
    }

    @Override
    public String getCurrentPath() {
        return this.fullpath;
    }

    @Override
    public String getName() {
        return path;
    }

    @Override
    public Optional<DataView> getParent() {
        return Optional.fromNullable(parent);
    }

    @Override
    public Set<String> getKeys(boolean deep) {
        return null; // TODO implement
    }

    @Override
    public Map<String, Object> getValues(boolean deep) {
        return null; // TODO implement
    }

    @Override
    public boolean contains(String path) {
        return false; // TODO implement
    }

    @Override
    public Optional<Object> get(String path) {
        return null; // TODO implement
    }

    @Override
    public void set(String path, Object value) {
        // TODO implement
    }

    @Override
    public DataView createView(String path) {
        return null; // TODO implement
    }

    @Override
    public DataView createView(String path, Map<?, ?> map) {
        return null; // TODO implement
    }

    @Override
    public Optional<DataView> getView(String path) {
        return null; // TODO implement
    }

    @Override
    public Optional<Boolean> getBoolean(String path) {
        return null; // TODO implement
    }

    @Override
    public Optional<Integer> getInt(String path) {
        return null; // TODO implement
    }

    @Override
    public Optional<Long> getLong(String path) {
        return null; // TODO implement
    }

    @Override
    public Optional<Double> getDouble(String path) {
        return null; // TODO implement
    }

    @Override
    public Optional<String> getString(String path) {
        return null; // TODO implement
    }

    @Override
    public Optional<List<?>> getList(String path) {
        return null; // TODO implement
    }

    @Override
    public Optional<List<String>> getStringList(String path) {
        return null; // TODO implement
    }

    @Override
    public Optional<List<Character>> getCharacterList(String path) {
        return null; // TODO implement
    }

    @Override
    public Optional<List<Boolean>> getBooleanList(String path) {
        return null; // TODO implement
    }

    @Override
    public Optional<List<Byte>> getByteList(String path) {
        return null; // TODO implement
    }

    @Override
    public Optional<List<Short>> getShortList(String path) {
        return null; // TODO implement
    }

    @Override
    public Optional<List<Integer>> getIntegerList(String path) {
        return null; // TODO implement
    }

    @Override
    public Optional<List<Long>> getLongList(String path) {
        return null; // TODO implement
    }

    @Override
    public Optional<List<Float>> getFloatList(String path) {
        return null; // TODO implement
    }

    @Override
    public Optional<List<Double>> getDoubleList(String path) {
        return null; // TODO implement
    }

    @Override
    public Optional<List<Map<?, ?>>> getMapList(String path) {
        return null; // TODO implement
    }

    @Override
    public Map<String, Object> toMap() {
        return null; // TODO implement
    }
}
