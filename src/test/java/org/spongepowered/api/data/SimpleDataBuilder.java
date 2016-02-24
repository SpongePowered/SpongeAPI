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

import org.spongepowered.api.data.persistence.DataBuilder;
import org.spongepowered.api.data.persistence.InvalidDataException;

import java.util.List;
import java.util.Optional;

class SimpleDataBuilder implements DataBuilder<SimpleData> {

    @Override
    public Optional<SimpleData> build(final DataView container) {

        Optional<Integer> testInt = container.getInt(DataQuery.of("myInt"));
        if (!testInt.isPresent()) {
            throw new InvalidDataException("Missing important data: {myInt}");
        }
        Optional<Double> testDouble = container.getDouble(DataQuery.of("myDouble"));
        if (!testDouble.isPresent()) {
            throw new InvalidDataException("Missing important data: {myDouble}");
        }
        Optional<String> testString = container.getString(DataQuery.of("myString"));
        if (!testString.isPresent()) {
            throw new InvalidDataException("Missing important data: {myString}");
        }
        Optional<List<String>> testList = container.getStringList(DataQuery.of("myStringList"));
        if (!testList.isPresent()) {
            throw new InvalidDataException("Missing important data: {myStringList}");
        }

        return Optional.of(new SimpleData(testInt.get(),
                                                      testDouble.get(),
                                                      testString.get(),
                                                      testList.get()));
    }

    @Override
    public DataBuilder<SimpleData> reset() {
        return this;
    }
}
