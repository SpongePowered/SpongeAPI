package org.spongepowered.api.data.manipulator.generator.testing;

import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.generator.KeyValue;
import org.spongepowered.api.data.meta.ItemEnchantment;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.List;

public interface DummyManipulator extends DataManipulator<DummyManipulator, ImmutableDummyManipulator> {

    @KeyValue("myInt")
    Value<Integer> myInt();

    @KeyValue("myEnchantment")
    ListValue<ItemEnchantment> enchantment();

    @KeyValue("myInt")
    int myIntValue();

    @KeyValue("myInt")
    void setMyInt(int value);

    @KeyValue("myEnchantment")
    List<ItemEnchantment> getEnchantment();

    @KeyValue("myEnchantment")
    void setEnchantment(List<ItemEnchantment> enchantment);

}
