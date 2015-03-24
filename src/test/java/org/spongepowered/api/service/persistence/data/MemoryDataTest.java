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

import static org.junit.Assert.assertTrue;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;
import org.mockito.Mockito;
import org.spongepowered.api.service.persistence.DataSerializableBuilder;
import org.spongepowered.api.service.persistence.SerializationService;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MemoryDataTest {

    @Test
    public void testCreateDataView() {
        new MemoryDataContainer();
    }

    @Test
    public void testCreateView() {
        DataContainer container = new MemoryDataContainer();
        DataQuery tempQuery = new DataQuery("foo", "bar", "baz");
        container.createView(tempQuery);
        assertTrue(container.getView(tempQuery).isPresent());
    }

    @Test
    public void testSetData() {
        DataContainer container = new MemoryDataContainer();
        DataQuery testQuery = new DataQuery('.', "foo.bar");
        container.set(testQuery, 1);
        Optional<Integer> optional = container.getInt(testQuery);
        assertTrue(optional.isPresent());
    }

    @Test
    public void testIncorrectType() {
        DataContainer container = new MemoryDataContainer();
        DataQuery testQuery = new DataQuery("foo", "bar");
        container.set(testQuery, "foo");
        Optional<Integer> optional = container.getInt(testQuery);
        assertTrue(!optional.isPresent());
    }

    @Test
    public void testNumbers() {
        DataContainer container = new MemoryDataContainer();
        DataQuery testQuery = new DataQuery("foo", "bar");
        container.set(testQuery, 1.0D);
        Optional<Integer> integerOptional = container.getInt(testQuery);
        assertTrue(integerOptional.isPresent());
        assertTrue(integerOptional.get() == 1);
        Optional<Long> longOptional = container.getLong(testQuery);
        assertTrue(longOptional.isPresent());
        assertTrue(longOptional.get() == 1L);
        Optional<Double> doubleOptional = container.getDouble(testQuery);
        assertTrue(doubleOptional.isPresent());
        assertTrue(doubleOptional.get() == 1.0D);
    }

    @Test
    public void testBoolean() {
        DataContainer container = new MemoryDataContainer();
        DataQuery testQuery = new DataQuery("foo", "bar");
        container.set(testQuery, false);
        Optional<Boolean> booleanOptional = container.getBoolean(testQuery);
        assertTrue(booleanOptional.isPresent());
        assertTrue(!booleanOptional.get());
    }

    @Test
    public void testString() {
        DataContainer container = new MemoryDataContainer();
        DataQuery testQuery = new DataQuery("foo", "bar");
        container.set(testQuery, "foo");
        Optional<String> stringOptional = container.getString(testQuery);
        assertTrue(stringOptional.isPresent());
        assertTrue(stringOptional.get().equals("foo"));
    }

    @Test
    public void testAbsents() {
        DataContainer container = new MemoryDataContainer();
        DataQuery testQuery = new DataQuery("foo", "bar", "baz");
        assertTrue(!container.get(testQuery).isPresent());
        assertTrue(!container.getBoolean(testQuery).isPresent());
        assertTrue(!container.getBooleanList(testQuery).isPresent());
        assertTrue(!container.getByteList(testQuery).isPresent());
        assertTrue(!container.getCharacterList(testQuery).isPresent());
        assertTrue(!container.getDouble(testQuery).isPresent());
        assertTrue(!container.getDoubleList(testQuery).isPresent());
        assertTrue(!container.getFloatList(testQuery).isPresent());
        assertTrue(!container.getInt(testQuery).isPresent());
        assertTrue(!container.getIntegerList(testQuery).isPresent());
        assertTrue(!container.getList(testQuery).isPresent());
        assertTrue(!container.getLong(testQuery).isPresent());
        assertTrue(!container.getLongList(testQuery).isPresent());
        assertTrue(!container.getMapList(testQuery).isPresent());
        assertTrue(!container.getShortList(testQuery).isPresent());
        assertTrue(!container.getString(testQuery).isPresent());
        assertTrue(!container.getStringList(testQuery).isPresent());
        assertTrue(!container.getView(testQuery).isPresent());
    }

    @Test
    public void testNumberedLists() {
        DataContainer container = new MemoryDataContainer();
        DataQuery testQuery = new DataQuery("foo", "bar", "baz");
        List<Integer> intList = ImmutableList.of(1, 2, 3, 4);
        container.set(testQuery, intList);
        assertTrue(container.getIntegerList(testQuery).isPresent());
        assertTrue(container.getIntegerList(testQuery).get().equals(intList));

        List<Double> doubleList = ImmutableList.of(1.0D, 2.0D, 3.0D, 4.0D);
        container.set(testQuery, doubleList);
        assertTrue(container.getDoubleList(testQuery).isPresent());
        assertTrue(container.getDoubleList(testQuery).get().equals(doubleList));

        List<Short> shortList = ImmutableList.of((short) 1, (short) 2, (short) 3, (short) 4);
        container.set(testQuery, shortList);
        assertTrue(container.getShortList(testQuery).isPresent());
        assertTrue(container.getShortList(testQuery).get().equals(shortList));

        List<Byte> byteList = ImmutableList.of((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        container.set(testQuery, byteList);
        assertTrue(container.getByteList(testQuery).isPresent());
        assertTrue(container.getByteList(testQuery).get().equals(byteList));

    }

    @Test
    public void testLists() {
        DataContainer container = new MemoryDataContainer();
        DataQuery query = new DataQuery("foo");
        List<DataView> list = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            DataContainer internal = new MemoryDataContainer();
            internal.set(new DataQuery("foo", "bar"), "foo.bar" + i);
            int[] ints = new int[] {0, 1, 2, 3, i};
            internal.set(new DataQuery("ints"), ints);
            list.add(internal);
        }
        container.set(query, list);
        assertTrue(container.contains(query));
        List<DataView> queriedList = container.getViewList(query).get();
        assertTrue(queriedList.equals(list));
    }

    @Test
    public void testEmptyQuery() {
        DataContainer container = new MemoryDataContainer();
        DataQuery query = new DataQuery("");
        container.set(query, "foo");
        assertTrue(container.get(query).isPresent());
        assertTrue(container.get(query).get().equals("foo"));
    }

    @Test
    public void testContainsEmpty() {
        DataContainer container = new MemoryDataContainer();
        DataQuery query = new DataQuery("");
        assertTrue(!container.contains(query));
        container.set(query, "foo");
        assertTrue(container.contains(query));
        query = new DataQuery('.', "foo.bar");
        assertTrue(!container.contains(query));
        container.set(query, "baz");
        assertTrue(container.contains(query));
    }

    @Test
    public void testGetName() {
        DataContainer container = new MemoryDataContainer();
        assertTrue(container.getName() !=  null);
    }

    @Test
    public void testGetSerializable() {
        // Need to mock the service Sadly, this takes the most amount of time
        SerializationService service = Mockito.mock(SerializationService.class);
        DataSerializableBuilder<SimpleData> builder = new SimpleDataBuilder();
        Mockito.stub(service.getBuilder(SimpleData.class)).toReturn(Optional.of(builder));

        List<String> myList = ImmutableList.of("foo", "bar", "baz");

        SimpleData temp = new SimpleData(1, 2.0, "foo", myList);
        DataContainer container = temp.toContainer();

        Optional<SimpleData> fromContainer = container.getSerializable(new DataQuery(), SimpleData.class, service);
        assertTrue(fromContainer.isPresent());
        assertTrue(Objects.equal(fromContainer.get(), temp));
        assertTrue(container.contains(new DataQuery("myStringList")));
        assertTrue(container.getStringList(new DataQuery("myStringList")).get().equals(myList));

    }

    @Test
    public void testGetSerializableList() {
        SerializationService service = Mockito.mock(SerializationService.class);
        DataSerializableBuilder<SimpleData> builder = new SimpleDataBuilder();
        Mockito.stub(service.getBuilder(SimpleData.class)).toReturn(Optional.of(builder));

        List<SimpleData> list = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            String number = Integer.toString(i);
            list.add(new SimpleData(i, 0.1 * i, "i", Lists.asList(number, new String[] {" foo", "bar"})));
        }
        DataContainer container = new MemoryDataContainer();
        container.set(new DataQuery("foo", "bar"), list);
        assertTrue(container.contains(new DataQuery("foo", "bar")));
        Optional<List<SimpleData>> fromContainer = container.getSerializableList(new DataQuery("foo", "bar"), SimpleData.class, service);
        assertTrue(fromContainer.isPresent());
        List<SimpleData> memoryList = fromContainer.get();
        assertTrue(Objects.equal(memoryList, list));

    }

    @Test
    public void testGetKeys() {
        Set<DataQuery> queries = Sets.newHashSet();

        queries.add(new DataQuery("foo"));
        queries.add(new DataQuery("foo", "bar"));
        queries.add(new DataQuery("foo", "bar", "baz"));
        queries.add(new DataQuery("bar"));
        DataView view = new MemoryDataContainer();
        view.set(new DataQuery("foo"), "foo");
        view.set(new DataQuery("foo", "bar"), "foobar");
        view.set(new DataQuery("foo", "bar", "baz"), "foobarbaz");
        view.set(new DataQuery("bar"), 1);

        Set<DataQuery> testQueries = Sets.newHashSet();
        testQueries.add(new DataQuery("foo"));
        testQueries.add(new DataQuery("bar"));
        Set<DataQuery> shallowKeys = view.getKeys(false);
        assertTrue(shallowKeys.equals(testQueries));
        Set<DataQuery> deepKeys = view.getKeys(true);
        assertTrue(deepKeys.containsAll(queries));
    }

    @Test
    public void testGetMaps() {
        List<DataQuery> queries = Lists.newArrayList();

        queries.add(new DataQuery("foo"));
        queries.add(new DataQuery("foo", "bar"));
        queries.add(new DataQuery("foo", "bar", "baz"));
        queries.add(new DataQuery("bar"));
        DataView view = new MemoryDataContainer();
        view.set(new DataQuery("foo"), "foo");
        view.set(new DataQuery("foo", "bar"), "foobar");
        view.set(new DataQuery("foo", "bar", "baz"), "foobarbaz");
        view.set(new DataQuery("bar"), 1);

        Map<DataQuery, Object> shallowMap = Maps.newHashMap();
        shallowMap.put(new DataQuery("foo"), "foo");
        shallowMap.put(new DataQuery("bar"), 1);

        Map<DataQuery, Object> deepMap = Maps.newHashMap();
        deepMap.put(new DataQuery("foo"), "foo");
        deepMap.put(new DataQuery("foo", "bar"), "foobar");
        deepMap.put(new DataQuery("foo", "bar", "baz"), "foobarbaz");
        deepMap.put(new DataQuery("bar"), 1);

        List<DataQuery> testQueries = Lists.newArrayList();
        testQueries.add(new DataQuery("foo"));
        testQueries.add(new DataQuery("bar"));
        Map<DataQuery, Object> shallowValues = view.getValues(false);
        assertTrue(shallowValues.keySet().equals(shallowMap.keySet()));
        Map<DataQuery, Object> deepValues = view.getValues(true);
        assertTrue(deepValues.keySet().equals(deepMap.keySet()));
    }

}
