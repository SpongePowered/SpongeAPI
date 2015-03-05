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

package org.spongepowered.api.util.event.factory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import com.google.common.collect.Maps;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ClassGeneratorProviderTest {

    private static final double ERROR = 0.03;

    private ClassGeneratorProvider createProvider() {
        return new ClassGeneratorProvider("org.spongepowered.test");
    }

    @Test
    public void testCreate_Primitives() throws Exception {
        ClassGeneratorProvider provider = createProvider();
        EventFactory<PrimitiveContainer> factory = provider.create(PrimitiveContainer.class, Object.class);
        Map<String, Object> values = Maps.newHashMap();
        values.put("byte", (byte) 10);
        values.put("short", (short) 11);
        values.put("int", 12);
        values.put("long", 13L);
        values.put("float", (float) 14.5);
        values.put("double", 15.5);
        values.put("boolean", true);
        values.put("char", (char) 17);

        PrimitiveContainer result = factory.apply(values);

        assertThat(result.getByte(), is((byte) 10));
        assertThat(result.getShort(), is((short) 11));
        assertThat(result.getInt(), is(12));
        assertThat(result.getLong(), is(13L));
        assertThat((double) result.getFloat(), is(closeTo(14.5, ERROR)));
        assertThat(result.getDouble(), is(closeTo(15.5, ERROR)));
        assertThat(result.getBoolean(), is(true));
        assertThat(result.getChar(), is((char) 17));

        result.setByte((byte) 20);
        result.setShort((short) 21);
        result.setInt(22);
        result.setLong(23L);
        result.setFloat((float) 24.5);
        result.setDouble(25.5);
        result.setBoolean(false);
        result.setChar((char) 27);

        assertThat(result.getByte(), is((byte) 20));
        assertThat(result.getShort(), is((short) 21));
        assertThat(result.getInt(), is(22));
        assertThat(result.getLong(), is(23L));
        assertThat((double) result.getFloat(), is(closeTo(24.5, ERROR)));
        assertThat(result.getDouble(), is(closeTo(25.5, ERROR)));
        assertThat(result.getBoolean(), is(false));
        assertThat(result.getChar(), is((char) 27));
    }

    @Test
    public void testCreate_UnsetPrimitives() throws Exception {
        ClassGeneratorProvider provider = createProvider();
        EventFactory<PrimitiveContainer> factory = provider.create(PrimitiveContainer.class, Object.class);
        PrimitiveContainer result = factory.apply(Collections.<String, Object>emptyMap());

        assertThat(result.getByte(), is((byte) 0));
        assertThat(result.getShort(), is((short) 0));
        assertThat(result.getInt(), is(0));
        assertThat(result.getLong(), is(0L));
        assertThat((double) result.getFloat(), is(closeTo(0, ERROR)));
        assertThat(result.getDouble(), is(closeTo(0, ERROR)));
        assertThat(result.getBoolean(), is(false));
        assertThat(result.getChar(), is((char) 0));
    }

    @Test(expected = NullPointerException.class)
    public void testCreate_UnsetPrimitivesWithNonNull() throws Exception {
        ClassGeneratorProvider provider = createProvider();
        provider.setNullPolicy(NullPolicy.NON_NULL_BY_DEFAULT);
        EventFactory<PrimitiveContainer> factory = provider.create(PrimitiveContainer.class, Object.class);
        factory.apply(Collections.<String, Object>emptyMap());
    }

    @Test
    public void testCreate_BoxedPrimitives() throws Exception {
        ClassGeneratorProvider provider = createProvider();
        EventFactory<BoxedPrimitiveContainer> factory = provider.create(BoxedPrimitiveContainer.class, Object.class);
        Map<String, Object> values = Maps.newHashMap();
        values.put("byte", (byte) 10);
        values.put("short", (short) 11);
        values.put("int", 12);
        values.put("long", 13L);
        values.put("float", (float) 14.5);
        values.put("double", 15.5);
        values.put("boolean", true);
        values.put("char", (char) 17);

        BoxedPrimitiveContainer result = factory.apply(values);

        assertThat(result.getByte(), is((byte) 10));
        assertThat(result.getShort(), is((short) 11));
        assertThat(result.getInt(), is(12));
        assertThat(result.getLong(), is(13L));
        assertThat((double) result.getFloat(), is(closeTo(14.5, ERROR)));
        assertThat(result.getDouble(), is(closeTo(15.5, ERROR)));
        assertThat(result.getBoolean(), is(true));
        assertThat(result.getChar(), is((char) 17));

        result.setByte((byte) 20);
        result.setShort((short) 21);
        result.setInt(22);
        result.setLong(23L);
        result.setFloat((float) 24.5);
        result.setDouble(25.5);
        result.setBoolean(false);
        result.setChar((char) 27);

        assertThat(result.getByte(), is((byte) 20));
        assertThat(result.getShort(), is((short) 21));
        assertThat(result.getInt(), is(22));
        assertThat(result.getLong(), is(23L));
        assertThat((double) result.getFloat(), is(closeTo(24.5, ERROR)));
        assertThat(result.getDouble(), is(closeTo(25.5, ERROR)));
        assertThat(result.getBoolean(), is(false));
        assertThat(result.getChar(), is((char) 27));

        result.setByte(null);
        result.setShort(null);
        result.setInt(null);
        result.setLong(null);
        result.setFloat(null);
        result.setDouble(null);
        result.setBoolean(null);
        result.setChar(null);

        assertThat(result.getByte(), is(nullValue()));
        assertThat(result.getShort(), is(nullValue()));
        assertThat(result.getInt(), is(nullValue()));
        assertThat(result.getLong(), is(nullValue()));
        assertThat(result.getFloat(), is(nullValue()));
        assertThat(result.getDouble(), is(nullValue()));
        assertThat(result.getBoolean(), is(nullValue()));
        assertThat(result.getChar(), is(nullValue()));
    }

    @Test
    public void testCreate_Arrays() throws Exception {
        ClassGeneratorProvider provider = createProvider();
        EventFactory<ArrayContainer> factory = provider.create(ArrayContainer.class, Object.class);

        Object object = new Object();

        Map<String, Object> values = Maps.newHashMap();
        values.put("bytes", new byte[]{1});
        values.put("shorts", new short[]{2});
        values.put("ints", new int[]{3});
        values.put("longs", new long[]{4});
        values.put("floats", new float[0]);
        values.put("doubles", new double[0]);
        values.put("booleans", new boolean[]{true});
        values.put("chars", new char[]{'a'});
        values.put("objects", new Object[]{object});

        ArrayContainer result = factory.apply(values);

        assertThat(result.getBytes(), is(new byte[]{1}));
        assertThat(result.getShorts(), is(new short[]{2}));
        assertThat(result.getInts(), is(new int[]{3}));
        assertThat(result.getLongs(), is(new long[]{4}));
        assertThat(result.getFloats(), is(new float[0]));
        assertThat(result.getDoubles(), is(new double[0]));
        assertThat(result.getBooleans(), is(new boolean[]{true}));
        assertThat(result.getChars(), is(new char[]{'a'}));
        assertThat(result.getObjects(), is(new Object[]{object}));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_ExcessParameters() throws Exception {
        ClassGeneratorProvider provider = createProvider();
        EventFactory<ExcessParametersContainer> factory = provider.create(ExcessParametersContainer.class, Object.class);

        Map<String, Object> values = Maps.newHashMap();
        values.put("name", "Jon");
        values.put("age", 8);

        factory.apply(values);
    }

    @Test
    public void testCreate_Inheritance() throws Exception {
        ClassGeneratorProvider provider = createProvider();
        EventFactory<ChildContainer> factory = provider.create(ChildContainer.class, Object.class);

        Map<String, Object> values = Maps.newHashMap();
        values.put("name", "Eduardo");
        values.put("age", 25);
        values.put("heatCapacity", 20);
        values.put("height", 6);
        values.put("temperature", 99);

        ChildContainer result = factory.apply(values);

        assertThat(result.getName(), is(equalTo("Eduardo")));
        assertThat(result.getAge(), is(25));
        assertThat(result.getHeatCapacity(), is(20));
        assertThat(result.getHeight(), is(6));
        assertThat(result.getTemperature(), is(99));

        result.setName("Brandon");
        result.setAge(30);

        assertThat(result.getName(), is(equalTo("Brandon")));
        assertThat(result.getAge(), is(30));
        assertThat(result.getHeatCapacity(), is(20));
        assertThat(result.getHeight(), is(6));
        assertThat(result.getTemperature(), is(99));
    }

    @Test(expected = AbstractMethodError.class)
    public void testCreate_NonConformingAccessor() throws Exception {
        ClassGeneratorProvider provider = createProvider();
        EventFactory<NonConformingAccessorContainer> factory = provider.create(NonConformingAccessorContainer.class, Object.class);

        NonConformingAccessorContainer result = factory.apply(Collections.<String, Object>emptyMap());
        result.setName("Joey");
        assertThat(result.getName(0), is(Matchers.nullValue())); // Nonconforming method
    }

    @Test(expected = AbstractMethodError.class)
    public void testCreate_NonConformingMutator() throws Exception {
        ClassGeneratorProvider provider = createProvider();
        EventFactory<NonConformingMutatorContainer> factory = provider.create(NonConformingMutatorContainer.class, Object.class);

        NonConformingMutatorContainer result = factory.apply(Collections.<String, Object>emptyMap());
        assertThat(result.getName(), is(Matchers.nullValue()));
        result.setName("Joey"); // Nonconforming method
    }

    @Test(expected = AbstractMethodError.class)
    public void testCreate_IncorrectMutator() throws Exception {
        ClassGeneratorProvider provider = createProvider();
        EventFactory<IncorrectMutatorContainer> factory = provider.create(IncorrectMutatorContainer.class, Object.class);

        IncorrectMutatorContainer result = factory.apply(Collections.<String, Object>emptyMap());
        assertThat(result.getAddress(), is(Matchers.nullValue()));
        result.setAddress(new ArrayList<Object>()); // Nonconforming method
    }

    @Test
    public void testCreate_AbstractImpl() throws Exception {
        ClassGeneratorProvider provider = createProvider();
        EventFactory<AbstractImplContainer> factory = provider.create(AbstractImplContainer.class, AbstractImpl.class);

        Map<String, Object> values = Maps.newHashMap();
        values.put("age", 56);

        AbstractImplContainer result = factory.apply(values);

        assertThat(result.getName(), is(equalTo("Bobby")));
        assertThat(result.getAge(), is(56));
        assertThat(((AbstractImpl) result).isCool(), is(true));

        result.setName("Nathaniel");

        assertThat(result.getName(), is(equalTo("Nathaniel Iceman")));
        assertThat(result.getAge(), is(56));
        assertThat(((AbstractImpl) result).isCool(), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_AbstractImplAndExcessParams() throws Exception {
        Map<String, Object> values = Maps.newHashMap();
        values.put("name", "Vincent");
        values.put("age", 56);
        values.put("cool", false);

        ClassGeneratorProvider provider = createProvider();
        EventFactory<AbstractImplContainer> factory = provider.create(AbstractImplContainer.class, AbstractImpl.class);
        factory.apply(values);
    }

    public interface PrimitiveContainer {

        byte getByte();

        void setByte(byte v);

        short getShort();

        void setShort(short v);

        int getInt();

        void setInt(int v);

        long getLong();

        void setLong(long v);

        float getFloat();

        void setFloat(float v);

        double getDouble();

        void setDouble(double v);

        boolean getBoolean();

        void setBoolean(boolean v);

        char getChar();

        void setChar(char v);
    }

    public interface BoxedPrimitiveContainer {

        Byte getByte();

        void setByte(Byte v);

        Short getShort();

        void setShort(Short v);

        Integer getInt();

        void setInt(Integer v);

        Long getLong();

        void setLong(Long v);

        Float getFloat();

        void setFloat(Float v);

        Double getDouble();

        void setDouble(Double v);

        Boolean getBoolean();

        void setBoolean(Boolean v);

        Character getChar();

        void setChar(Character v);
    }

    public interface ArrayContainer {

        byte[] getBytes();

        void setBytes(byte[] v);

        short[] getShorts();

        void setShorts(short[] v);

        int[] getInts();

        void setInts(int[] v);

        long[] getLongs();

        void setLongs(long[] v);

        float[] getFloats();

        void setFloats(float[] v);

        double[] getDoubles();

        void setDoubles(double[] v);

        boolean[] getBooleans();

        void setBooleans(boolean[] v);

        char[] getChars();

        void setChars(char[] v);

        Object[] getObjects();

        void setObjects(Object[] v);
    }

    public interface ExcessParametersContainer {

        String getName();

        String setName(String name);
    }

    public interface Parent1AContainer {

        String getName();

        void setName(String name);
    }

    public interface Parent1BContainer {

        int getAge();

        int getHeatCapacity();
    }

    public interface Parent2AContainer extends Parent1AContainer {

        int getAge();

        int getHeight();
    }

    public interface Parent2BContainer extends Parent1AContainer {

        void setAge(int age);
    }

    public interface ChildContainer extends Parent2AContainer, Parent2BContainer, Parent1BContainer {

        int getTemperature();
    }

    public interface NonConformingAccessorContainer {

        String getName(int index);

        void setName(String name);
    }

    public interface NonConformingMutatorContainer {

        String getName();

        String setName(String name);
    }

    public interface IncorrectMutatorContainer {

        List<?> getAddress();

        void setAddress(ArrayList<?> address);
    }

    public interface AbstractImplContainer {

        String getName();

        void setName(String name);

        int getAge();

        void setAge(int age);
    }

    public static class AbstractImpl {

        private String name = "Bobby";

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name + " Iceman";
        }

        public boolean isCool() {
            return true;
        }
    }

}
