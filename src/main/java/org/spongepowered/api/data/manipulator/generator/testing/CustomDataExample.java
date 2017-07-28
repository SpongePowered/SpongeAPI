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
package org.spongepowered.api.data.manipulator.generator.testing;

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.DataRegistration;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.key.KeyFactory;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.generator.CustomData;
import org.spongepowered.api.data.manipulator.generator.KeyValue;
import org.spongepowered.api.data.manipulator.mutable.ListData;
import org.spongepowered.api.data.manipulator.mutable.MappedData;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.TypeTokens;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomDataExample {

    /*
    // For obvious reasons, we want to be able to use the key for various things. so we generate it!
    public static final Key<Value<String>> MY_STRING = KeyFactory.makeSingleKey(TypeTokens.STRING_TOKEN, TypeTokens.STRING_VALUE_TOKEN, DataQuery.of
            ("MyString"), "com.gabizou.my_string", "MyStringKey");

    public static final TypeToken<List<ItemStack>> LIST_ITEM_STACK_TOKEN = new TypeToken<List<ItemStack>>() {
    };
    public static final TypeToken<ListValue<ItemStack>> LIST_ITEM_STACK_VALUE_TOKEN = new TypeToken<ListValue<ItemStack>>() {
    };

    public static final Key<ListValue<ItemStack>> MY_STACKS = KeyFactory.makeListKey(LIST_ITEM_STACK_TOKEN, LIST_ITEM_STACK_VALUE_TOKEN, DataQuery.of("MyItemStacks"), "com.gabizou.my_stacks", "MyStacks");

    // We get to use the CustomDataProvider, however, since there are no hard interfaces provided,
    // we can't use any form of generics. Fortunately for us, we don't really care about generics,
    // except for using our Key. With that, we still need to provide some information about the
    // default values of that key.
    // So, in essence, we still get our DataRegistration object back, which can be private.
    // The nice thing about this is that the registration, once validated and classes generated,
    // the classes and builder instance are also validated and registered with the DataManager.
    // No further registration is required
    private static final DataRegistration<?, ?> MY_STRING_REGISTRATION = CustomDataProvider.builder()
            //.intValue(MY_STRING, 54) // Will not compile due to method requirements :D
            .value(MY_STRING, "DefaultString")
            .value(MY_STACKS, ImmutableList.of())
            .build(null, "CustomStringData"); // Not actually supposed to be null, but it can be for the sake of demonstration

    // We now have our generated "super class" which can be used in any methods accepting manipulator classes
    public static final Class<? extends DataManipulator<?, ?>> MY_STRING_MANIPULATOR = MY_STRING_REGISTRATION.getSuperManipulator();
    // We also have our immutable registration
    public static final Class<? extends ImmutableDataManipulator<?, ?>> MY_STRING_IMMUTABLE_MANIPULATOR = MY_STRING_REGISTRATION.getSuperImmutable();
    // And of course, our data builder class
    public static final Class<? extends DataManipulatorBuilder<?, ?>> MY_STRING_BUILDER_CLASS = MY_STRING_REGISTRATION.getBuilderClass();
    // Oh! And I almost forgot, we can have our own static instance of our manipulator builder since that is generated for us as well!
    public static final DataManipulatorBuilder<?, ?> MY_STRING_BUILDER = MY_STRING_REGISTRATION.getBuilder();

    // After all this is set and done, the DataRegistration is also able to produce new instances
    // without having to use the DataManager, since it already has the instance prepared.
    */


    public static final Key<ListValue<ItemStack>> MY_STACKS_KEY = KeyFactory.makeListKey(
            TypeToken.of(ItemStack.class), DataQuery.of("MyStacks"), "test_data:my_stacks", "MyStacks");

    public static final Key<MapValue<Integer, String>> MY_MAP_KEY = KeyFactory.makeMapKeyWithKeyAndValue(
            TypeTokens.INTEGER_TOKEN, TypeTokens.STRING_TOKEN, DataQuery.of("MyMap"), "test_data:my_map", "MyMap");

    private static final DataRegistration<? extends ListData<ItemStack, ?, ?>, ?> MY_STACKS_DATA = CustomData.builder()
            .list(MY_STACKS_KEY)
            .defaultValue(new ArrayList<>())
            .build(null, "my_stacks_data");

    private static final DataRegistration<? extends MappedData<Integer, String, ?, ?>, ?> MY_MAP_DATA = CustomData.builder()
            .map(MY_MAP_KEY)
            .defaultValue(new HashMap<>())
            .build(null, "my_map_data");

    private static final DataRegistration<MyDataCollection, MyImmutableDataCollection> MULTIPLE_KEYS_DATA = CustomData.builder()
            .keys()
            .key(MY_STACKS_KEY, new ArrayList<>())
            .key(MY_MAP_KEY, new HashMap<>())
            .interfaces(MyDataCollection.class, MyImmutableDataCollection.class)
            .build(null, "my_data_collection");

    interface MyDataCollection extends DataManipulator<MyDataCollection, MyImmutableDataCollection> {

        @KeyValue("my_stacks")
        ListValue<ItemStack> myStacks();

        @KeyValue("my_stacks")
        List<ItemStack> getMyStacks();

        @KeyValue("my_stacks")
        void setMyStacks(List<ItemStack> value);
    }

    interface MyImmutableDataCollection extends ImmutableDataManipulator<MyImmutableDataCollection, MyDataCollection> {

    }
}
