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

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import org.spongepowered.api.service.persistence.DataSerializable;

import java.util.Arrays;
import java.util.List;

class SimpleData implements DataSerializable {

    private final int testInt;
    private final double testDouble;
    private final String testString;
    private final String[] testList;

    SimpleData(int testInt, double testDouble, String testString, List<String> testList) {
        this.testInt = testInt;
        this.testDouble = testDouble;
        this.testString = testString;
        this.testList = testList.toArray(new String[testList.size()]);
    }

    public int getTestInt() {
        return this.testInt;
    }

    public double getTestDouble() {
        return this.testDouble;
    }

    public String getTestString() {
        return this.testString;
    }

    public List<String> getTestList() {
        return ImmutableList.copyOf(this.testList);
    }

    @Override
    public DataContainer toContainer() {
        DataContainer container = new MemoryDataContainer();
        container.set(new DataQuery("myInt"), this.testInt);
        container.set(new DataQuery("myDouble"), this.testDouble);
        container.set(new DataQuery("myString"), this.testString);
        container.set(new DataQuery("myStringList"), this.testList);
        return container;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.testInt, this.testDouble, this.testString, this.testList);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final SimpleData other = (SimpleData) obj;
        return Objects.equal(this.testInt, other.testInt)
                && Objects.equal(this.testDouble, other.testDouble)
                && Objects.equal(this.testString, other.testString)
                && Arrays.equals(this.testList, other.testList);
    }
}
