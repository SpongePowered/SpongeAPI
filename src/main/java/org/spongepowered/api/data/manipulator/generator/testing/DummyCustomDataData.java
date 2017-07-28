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

import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.DataRegistration;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.key.KeyFactory;
import org.spongepowered.api.data.manipulator.generator.CustomData;
import org.spongepowered.api.data.meta.ItemEnchantment;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.util.TypeTokens;

import java.util.ArrayList;

public class DummyCustomDataData {

    public static final Key<MutableBoundedValue<Integer>> MY_INT_KEY =
            KeyFactory
                    .makeSingleKey(TypeTokens.INTEGER_TOKEN,
                            TypeTokens.BOUNDED_INTEGER_VALUE_TOKEN,
                            DataQuery.of("MyInteger"),
                            "com.gabizou:my_integer",
                            "My Integer");

    public static final Key<ListValue<ItemEnchantment>> MY_ENCHANTMENT_KEY =
            KeyFactory
                    .makeListKey(TypeTokens.LIST_ITEM_ENCHANTMENT_TOKEN,
                            TypeTokens.LIST_ITEM_ENCHANTMENT_VALUE_TOKEN,
                            DataQuery.of("MyItemEnchantment"),
                            "com.gabizou:my_item_enchantment",
                            "My Item Enchantment");

    public static final DataRegistration<DummyManipulator, ImmutableDummyManipulator> MY_REGISTRATION =
            CustomData.builder().keyValues()
                    .boundedValue(MY_INT_KEY, 10, 0, 10)
                    .value(MY_ENCHANTMENT_KEY, new ArrayList<>())
                    .predicate(dataHolder -> dataHolder instanceof Agent)
                    .interfaces(DummyManipulator.class, ImmutableDummyManipulator.class)
                    .version(1)
                    .build(null, "MyCustomData"); // Not supposed to be null
}
