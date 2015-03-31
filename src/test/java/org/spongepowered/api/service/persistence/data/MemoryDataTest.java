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
import static org.spongepowered.api.service.persistence.data.DataQuery.of;

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
        DataQuery tempQuery = of("foo", "bar", "baz");
        container.createView(tempQuery);
        assertTrue(container.getView(tempQuery).isPresent());
    }

    @Test
    public void testSetData() {
        DataContainer container = new MemoryDataContainer();
        DataQuery testQuery = of('.', "foo.bar");
        container.set(testQuery, 1);
        Optional<Integer> optional = container.getInt(testQuery);
        assertTrue(optional.isPresent());
    }

    @Test
    public void testIncorrectType() {
        DataContainer container = new MemoryDataContainer();
        DataQuery testQuery = of("foo", "bar");
        container.set(testQuery, "foo");
        Optional<Integer> optional = container.getInt(testQuery);
        assertTrue(!optional.isPresent());
    }

    @Test
    public void testNumbers() {
        DataContainer container = new MemoryDataContainer();
        DataQuery testQuery = of("foo", "bar");
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
        DataQuery testQuery = of("foo", "bar");
        container.set(testQuery, false);
        Optional<Boolean> booleanOptional = container.getBoolean(testQuery);
        assertTrue(booleanOptional.isPresent());
        assertTrue(!booleanOptional.get());
    }

    @Test
    public void testString() {
        DataContainer container = new MemoryDataContainer();
        DataQuery testQuery = of("foo", "bar");
        container.set(testQuery, "foo");
        Optional<String> stringOptional = container.getString(testQuery);
        assertTrue(stringOptional.isPresent());
        assertTrue(stringOptional.get().equals("foo"));
    }

    @Test
    public void testAbsents() {
        DataContainer container = new MemoryDataContainer();
        DataQuery testQuery = of("foo", "bar", "baz");
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
        DataQuery testQuery = of("foo", "bar", "baz");
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
        DataQuery query = of("foo");
        List<DataView> list = Lists.newArrayList();
        for (int i = 0; i < 1; i++) {
            DataContainer internal = new MemoryDataContainer();
            internal.set(of("foo", "bar"), "foo.bar" + i);
            int[] ints = new int[] {0, 1, 2, 3, i};
            internal.set(of("ints"), ints);
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
        DataQuery query = of("");
        container.set(query, "foo");
        assertTrue(container.get(query).isPresent());
        assertTrue(container.get(query).get().equals("foo"));
    }

    @Test
    public void testContainsEmpty() {
        DataContainer container = new MemoryDataContainer();
        DataQuery query = of("");
        assertTrue(!container.contains(query));
        container.set(query, "foo");
        assertTrue(container.contains(query));
        query = of('.', "foo.bar");
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

        Optional<SimpleData> fromContainer = container.getSerializable(of(), SimpleData.class, service);
        assertTrue(fromContainer.isPresent());
        assertTrue(Objects.equal(fromContainer.get(), temp));
        assertTrue(container.contains(of("myStringList")));
        assertTrue(container.getStringList(of("myStringList")).get().equals(myList));

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
        container.set(of("foo", "bar"), list);
        assertTrue(container.contains(of("foo", "bar")));
        Optional<List<SimpleData>> fromContainer = container.getSerializableList(of("foo", "bar"), SimpleData.class, service);
        assertTrue(fromContainer.isPresent());
        List<SimpleData> memoryList = fromContainer.get();
        assertTrue(Objects.equal(memoryList, list));

    }

    @Test
    public void testGetKeys() {
        Set<DataQuery> queries = Sets.newHashSet();

        queries.add(of("foo"));
        queries.add(of("foo", "bar"));
        queries.add(of("foo", "bar", "baz"));
        queries.add(of("bar"));
        DataView view = new MemoryDataContainer();
        view.set(of("foo"), "foo");
        view.set(of("foo", "bar"), "foobar");
        view.set(of("foo", "bar", "baz"), "foobarbaz");
        view.set(of("bar"), 1);

        Set<DataQuery> testQueries = Sets.newHashSet();
        testQueries.add(of("foo"));
        testQueries.add(of("bar"));
        Set<DataQuery> shallowKeys = view.getKeys(false);
        assertTrue(shallowKeys.equals(testQueries));
        Set<DataQuery> deepKeys = view.getKeys(true);
        assertTrue(deepKeys.containsAll(queries));
    }

    @Test
    public void testGetMaps() {
        DataView view = new MemoryDataContainer();
        view.set(of("foo", "bar", "foo"), "foo");
        view.set(of("foo", "bar", "bar"), "foobar");
        view.set(of("foo", "bar", "baz"), "foobarbaz");
        view.set(of("bar"), 1);

        Map<DataQuery, Object> shallowMap = Maps.newLinkedHashMap();
        shallowMap.put(of("bar"), 1);
        final Map<DataQuery, Object> internalView = Maps.newLinkedHashMap();
        internalView.put(of("foo"), "foo");
        internalView.put(of("bar"), "foobar");
        internalView.put(of("baz"), "foobarbaz");
        Map<DataQuery, Object> intermediateMap = Maps.newLinkedHashMap();
        intermediateMap.put(of("bar"), internalView);
        shallowMap.put(of("foo"), intermediateMap);

        Map<DataQuery, Object> shallowValues = view.getValues(false);
        assertTrue(shallowValues.entrySet().equals(shallowMap.entrySet()));

        // Since we also support getting deep values, this has the uncommon side effect
        // of actually having every possible DataQuery created for every possible value
        // from the top level root node.
        final Map<DataQuery, Object> deepMap = Maps.newLinkedHashMap();
        deepMap.put(of("bar"), 1);
        deepMap.put(of("foo", "bar", "foo"), "foo");
        deepMap.put(of("foo", "bar", "bar"), "foobar");
        deepMap.put(of("foo", "bar", "baz"), "foobarbaz");
        deepMap.put(of("foo"), intermediateMap);
        intermediateMap.put(of("bar", "foo"), "foo");
        intermediateMap.put(of("bar", "bar"), "foobar");
        intermediateMap.put(of("bar", "baz"), "foobarbaz");
        deepMap.put(of("foo", "bar"), internalView);

        Map<DataQuery, Object> deepValues = view.getValues(true);
        assertTrue(deepValues.keySet().equals(deepMap.keySet()));
        assertTrue(deepValues.entrySet().equals(deepMap.entrySet()));
    }

    @Test
    public void testMaps() {
        Map<String, Object> myMap = Maps.newHashMap();
        myMap.put("foo", "bar");
        myMap.put("myNumber", 1);
        List<String> stringList = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            stringList.add("Foo" + i);
        }
        myMap.put("myList", stringList);
        DataView view = new MemoryDataContainer();
        view.set(of("Foo"), myMap);

        Map<?, ?> retrievedMap = (Map<?, ?>) view.getMap(of("Foo")).get();
        assertTrue(myMap.keySet().equals(retrievedMap.keySet()));
        assertTrue(myMap.entrySet().equals(retrievedMap.entrySet()));
    }

}
