package org.spongepowered.api.data.manipulator.generator.testing;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.key.KeyFactory;
import org.spongepowered.api.data.manipulator.DataManipulatorBuilder;
import org.spongepowered.api.data.manipulator.generator.DataRegistration;
import org.spongepowered.api.data.meta.ItemEnchantment;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.util.CommonTokens;

public class DummyCustomDataData {

    public static final Key<MutableBoundedValue<Integer>> MY_INT_KEY =
            KeyFactory
                    .makeSingleKey(CommonTokens.INTEGER_TOKEN,
                            CommonTokens.BOUNDED_INTEGER_VALUE_TOKEN,
                            DataQuery.of("MyInteger"),
                            "com.gabizou:my_integer",
                            "My Integer");

    public static final Key<ListValue<ItemEnchantment>> MY_ENCHANTMENT_KEY =
            KeyFactory
                    .makeListKey(CommonTokens.LIST_ITEM_ENCHANTMENT_TOKEN,
                            CommonTokens.LIST_ITEM_ENCHANTMENT_VALUE_TOKEN,
                            DataQuery.of("MyItemEnchantment"),
                            "com.gabizou:my_item_enchantment",
                            "My Item Enchantment");

    public static final DataRegistration<DummyManipulator, ImmutableDummyManipulator> MY_REGISTRATION =
            Sponge.getDataManager()
                    .createCustomBuilder(DummyManipulator.class, ImmutableDummyManipulator.class)
                    .boundedKey(MY_INT_KEY, "myInt", 10, 0, 10)
                    .key(MY_ENCHANTMENT_KEY, "myEnchantment")
                    .predicate(dataHolder -> dataHolder instanceof Agent)
                    .version(1)
                    .build(null, "MyCustomData"); // Not supposed to be null

    public static final DataManipulatorBuilder<DummyManipulator, ImmutableDummyManipulator> MY_BUILDER =
            MY_REGISTRATION.getBuilder();

}
