package org.spongepowered.api.data.manipulator.generator.testing;

import com.google.common.collect.ImmutableList;
import com.google.common.reflect.TypeToken;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.key.KeyFactory;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.generator.CustomDataProvider;
import org.spongepowered.api.data.manipulator.generator.DataRegistration;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.CommonTokens;

import java.util.List;

public class SimpleStringCustomData {

    // For obvious reasons, we want to be able to use the key for various things. so we generate it!
    public static final Key<Value<String>> MY_STRING = KeyFactory.makeSingleKey(CommonTokens.STRING_TOKEN, CommonTokens.STRING_VALUE_TOKEN, DataQuery.of("MyString"), "com.gabizou.my_string", "MyStringKey");

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
            .id("CustomStringData")
            //.intValue(MY_STRING, 54) // Will not compile due to method requirements :D
            .stringValue(MY_STRING, "DefaultString")
            .list(MY_STACKS, ImmutableList.of(), ItemStack.class)
            .build(null); // Not actually supposed to be null, but it can be for the sake of demonstration

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


}
