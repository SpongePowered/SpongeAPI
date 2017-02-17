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
package org.spongepowered.api.util.event.factory;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.spongepowered.api.eventgencore.annotation.PropertySettings;
import org.spongepowered.api.eventgencore.classwrapper.reflection.ReflectionClassWrapper;
import org.spongepowered.api.eventgencore.classwrapper.reflection.ReflectionUtils;
import org.spongepowered.api.util.annotation.TransformResult;
import org.spongepowered.api.util.annotation.TransformWith;
import org.spongepowered.api.util.generator.event.factory.ClassGeneratorProvider;
import org.spongepowered.api.util.generator.event.factory.NullPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;


@RunWith(PowerMockRunner.class)
@PrepareForTest(ReflectionUtils.class)
public class ClassGeneratorProviderTest {

    private static final double ERROR = 0.03;

    private ClassGeneratorProvider provider;
    private FactoryInterface factory;

    @Before
    public void beforeTest() {
        this.provider = new ClassGeneratorProvider("org.spongepowered.test");
        this.provider.setNullPolicy(NullPolicy.NON_NULL_BY_DEFAULT);
        this.factory = null;
    }

    private FactoryInterface getFactory() {
        if (this.factory == null) {
            this.factory = this.provider.createFactoryInterfaceImpl(FactoryInterface.class);
        }
        return this.factory;
    }

    @Test
    public void testCreate_SimpleInterface() throws Exception {
        SimpleInterface simpleInterface = this.getFactory().createSimpleInterface("Foo");
        assertThat(simpleInterface.getName(), is(equalTo("Foo")));

        simpleInterface.setName("Me");
        assertThat(simpleInterface.getName(), is(equalTo("Me")));
    }

    @Test(expected = NullPointerException.class)
    public void testCreate_SimpleInterface_Null() throws Exception {
        SimpleInterface simpleInterface = this.getFactory().createSimpleInterface(null);
    }

    @Test
    public void testCreate_SimpleInterface_NullPolicy() throws Exception {
        this.provider.setNullPolicy(NullPolicy.NULL_BY_DEFAULT);
        SimpleInterface simpleInterface = this.getFactory().createSimpleInterface(null);
        assertThat(simpleInterface.getName(), is(nullValue()));

        simpleInterface.setName("Me");
        assertThat(simpleInterface.getName(), is(equalTo("Me")));
    }

    @Test
    public void testCreate_ModifierMethodInterface() throws Exception {
        ModifiedMethodInterface result = this.getFactory().createModifiedMethodInterface(new ModifierClass(), new ModifierClass());

        assertNotSame(result.getNewModifierClass(), result.getNewModifierClass());
        assertNotSame(result.getOtherModifierClass(), result.getOtherModifierClass());
    }

    @Test
    public void testCreate_Primitives() throws Exception {
        PrimitiveContainer result = this.getFactory().createPrimitiveContainer((byte) 10, (short) 11, 12, 13L, (float) 14.5, 15.5, true, (char) 17);

        assertThat(result.getByte_(), is((byte) 10));
        assertThat(result.getShort_(), is((short) 11));
        assertThat(result.getInt_(), is(12));
        assertThat(result.getLong_(), is(13L));
        assertThat((double) result.getFloat_(), is(closeTo(14.5, ERROR)));
        assertThat(result.getDouble_(), is(closeTo(15.5, ERROR)));
        assertThat(result.getBoolean_(), is(true));
        assertThat(result.getChar_(), is((char) 17));

        result.setByte_((byte) 20);
        result.setShort_((short) 21);
        result.setInt_(22);
        result.setLong_(23L);
        result.setFloat_((float) 24.5);
        result.setDouble_(25.5);
        result.setBoolean_(false);
        result.setChar_((char) 27);

        assertThat(result.getByte_(), is((byte) 20));
        assertThat(result.getShort_(), is((short) 21));
        assertThat(result.getInt_(), is(22));
        assertThat(result.getLong_(), is(23L));
        assertThat((double) result.getFloat_(), is(closeTo(24.5, ERROR)));
        assertThat(result.getDouble_(), is(closeTo(25.5, ERROR)));
        assertThat(result.getBoolean_(), is(false));
        assertThat(result.getChar_(), is((char) 27));
    }

    @Test
    public void testCreate_Arrays() throws Exception {
        Object object = new Object();

        ArrayContainer result = this.getFactory().createArrayContainer(new byte[]{1}, new short[]{2}, new int[]{3}, new long[]{4}, new float[0], new double[0], new boolean[]{true}, new char[]{'a'}, new Object[]{object});

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

    @Test
    public void testCreate_Inheritance() throws Exception {
        ChildContainer result = this.getFactory().createChildContainer("Eduardo", 25, 20, 6, 99);

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

    @Test(expected = NoSuchMethodError.class)
    public void testCreate_NonConformingAccessor() throws Exception {
        NonConformingAccessorContainer result = this.getFactory().createNonConformingAccessorContainer("Me");
    }

    @Test(expected = AbstractMethodError.class)
    public void testCreate_NonConformingMutator() throws Exception {
        NonConformingMutatorContainer result = this.getFactory().createNonConformingMutatorContainer("test");
        assertThat(result.getName(), is(equalTo("test")));
        result.setName("Joey"); // Nonconforming method
    }

    @Test(expected = AbstractMethodError.class)
    public void testCreate_IncorrectMutator() throws Exception {
        IncorrectMutatorContainer result = this.getFactory().createIncorrectMutatorContainer(Lists.newArrayList());
        assertThat(result.getAddress(), is(equalTo(Lists.newArrayList())));
        result.setAddress(new ArrayList<>()); // Nonconforming method
    }

    @Test
    public void testCreate_AbstractImpl() throws Exception {
        PowerMockito.spy(ReflectionUtils.class);
        PowerMockito.when(ReflectionUtils.getBaseClass(AbstractImplContainer.class)).thenReturn(new ReflectionClassWrapper(AbstractImpl.class));
        AbstractImplContainer result = this.getFactory().createAbstractImplContainer(56);

        assertThat(result.getName(), is(equalTo("Bobby")));
        assertThat(result.getAge(), is(56));
        assertThat(((AbstractImpl) result).isCool(), is(true));

        result.setName("Nathaniel");

        assertThat(result.getName(), is(equalTo("Nathaniel Iceman")));
        assertThat(result.getAge(), is(56));
        assertThat(((AbstractImpl) result).isCool(), is(true));
    }

    /*@Test(expected = IllegalArgumentException.class)
    public void testCreate_AbstractImplAndExcessParams() throws Exception {
        Map<String, Object> values = Maps.newHashMap();
        values.put("name", "Vincent");
        values.put("age", 56);
        values.put("cool", false);

        ClassGeneratorProvider provider = createProvider();
        EventFactory<AbstractImplContainer> factory = provider.create(AbstractImplContainer.class, AbstractImpl.class,
                SpongeEventFactoryUtils.plugins);
        factory.apply(values);
    }
*/
    @Test
    public void testCreate_OptionalGetter() {
        OptionalGetter getter = this.getFactory().createOptionalGetter(Optional.ofNullable("MyName"));

        assertThat(getter.getName().isPresent(), is(true));
        assertThat(getter.getName().get(), is(equalTo("MyName")));

        getter.setName(null);
        assertThat(getter.getName().isPresent(), is(false));

        getter.setName("Aaron");

        assertThat(getter.getName().isPresent(), is(true));
        assertThat(getter.getName().get(), is(equalTo("Aaron")));
    }

    @Test(expected = RuntimeException.class)
    public void testCreate_OverloadedSetter() {
        CovariantMethodOverrideInterface overriden = this.getFactory().createCovariantMethodOverrideInterface("");
        overriden.setObject(new Object());
    }

    @Test
    public void testCreate_UnrequiredPrimitives() {
        UnrequiredPrimtiveInterface generated = this.getFactory().createUnrequiredPrimitiveInterface(2.0);

        assertThat(generated.getBooleanValue(), is(false));
        assertThat(generated.getIntValue(), is(0));
        assertThat(generated.getDoubleValue(), is(closeTo(2.0, ERROR)));

        generated.setBooleanValue(true);
        generated.setIntValue(5);
        generated.setDoubleValue(20);

        assertThat(generated.getBooleanValue(), is(true));
        assertThat(generated.getIntValue(), is(5));
        assertThat(generated.getDoubleValue(), is(closeTo(20, ERROR)));

        generated.setBooleanValue(false);

        assertThat(generated.getBooleanValue(), is(false));
    }

    public interface OptionalGetter {

        Optional<String> getName();

        void setName(@Nullable String name);
    }

    public interface PrimitiveContainer {

        byte getByte_();

        void setByte_(byte v);

        short getShort_();

        void setShort_(short v);

        int getInt_();

        void setInt_(int v);

        long getLong_();

        void setLong_(long v);

        float getFloat_();

        void setFloat_(float v);

        double getDouble_();

        void setDouble_(double v);

        boolean getBoolean_();

        void setBoolean_(boolean v);

        char getChar_();

        void setChar_(char v);
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

        @PropertySettings(generateMethods = false, requiredParameter = false)
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

    public interface ModifiedMethodInterface {

        @TransformResult
        ModifierClass getNewModifierClass();

        @TransformResult("foo")
        ModifierClass getOtherModifierClass();

    }

    public class ModifierClass {

        @TransformWith
        public ModifierClass copy() {
            return new ModifierClass();
        }

        @TransformWith("foo")
        public ModifierClass copy2() {
            return new ModifierClass();
        }
    }

    public interface CovariantMethodInterface {

        Object getObject();

        void setObject(Object object);
    }

    public interface CovariantMethodOverrideInterface extends CovariantMethodInterface {

        @Override
        String getObject();

        void setObject(String object);
    }

    public interface UnrequiredPrimtiveInterface {

        @PropertySettings(requiredParameter = false)
        boolean getBooleanValue();

        void setBooleanValue(boolean value);

        @PropertySettings(requiredParameter = false)
        int getIntValue();

        void setIntValue(int value);

        double getDoubleValue();

        void setDoubleValue(double value);

    }

    public interface SimpleInterface {

        String getName();

        void setName(String name);
    }

    public interface FactoryInterface {

        UnrequiredPrimtiveInterface createUnrequiredPrimitiveInterface(double doubleValue);

        CovariantMethodOverrideInterface createCovariantMethodOverrideInterface(String object);

        OptionalGetter createOptionalGetter(Optional<String> name);

        AbstractImplContainer createAbstractImplContainer(int age);

        IncorrectMutatorContainer createIncorrectMutatorContainer(List<?> address);

        NonConformingMutatorContainer createNonConformingMutatorContainer(String name);

        NonConformingAccessorContainer createNonConformingAccessorContainer(String name);

        ChildContainer createChildContainer(String name, int age, int heatCapacity, int height, int temperature);

        ArrayContainer createArrayContainer(byte[] bytes, short[] shorts, int[] ints, long[] longs, float[] floats, double[] doubles, boolean[] booleans, char[] chars, Object[] objects);

        PrimitiveContainer createPrimitiveContainer(byte byte_, short short_, int int_, long long_, float float_, double double_, boolean boolean_, char char_);

        ModifiedMethodInterface createModifiedMethodInterface(ModifierClass newModifierClass, ModifierClass otherModifierClass);

        SimpleInterface createSimpleInterface(String name);
    }

}
