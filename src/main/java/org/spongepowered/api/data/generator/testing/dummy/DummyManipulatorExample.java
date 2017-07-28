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
package org.spongepowered.api.data.generator.testing.dummy;

import static org.spongepowered.api.data.key.KeyFactory.makeListKey;
import static org.spongepowered.api.data.key.KeyFactory.makeMutableBoundedValueKey;

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.DataRegistration;
import org.spongepowered.api.data.generator.DataGenerator;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.meta.ItemEnchantment;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.util.TypeTokens;

import java.util.ArrayList;

public class DummyManipulatorExample {

    public static final Key<MutableBoundedValue<Integer>> MY_INT_KEY = makeMutableBoundedValueKey(
            TypeTokens.INTEGER_TOKEN, DataQuery.of("MyInteger"), "my_data_plugin:my_int", "My Integer");

    public static final Key<ListValue<ItemEnchantment>> MY_ITEM_ENCHANTMENTS_KEY = makeListKey(
            TypeToken.of(ItemEnchantment.class), DataQuery.of("MyItemEnchantments"), "my_data_plugin:my_item_enchantments", "My Item Enchantments");

    public static final DataRegistration<DummyManipulator, ImmutableDummyManipulator> MY_REGISTRATION =
            DataGenerator.builder().keys()
                    // Register my bounded int key
                    .boundedKey(MY_INT_KEY, 10, 0, 10)
                    // Register my enchantments key
                    .key(MY_ITEM_ENCHANTMENTS_KEY, new ArrayList<>())
                    // Only target agent
                    .predicate(dataHolder -> dataHolder instanceof Agent)
                    // Apply interfaces
                    .interfaces(DummyManipulator.class, ImmutableDummyManipulator.class)
                    .version(1)
                    .buildAndRegister("my_data_plugin", "dummy_manipulator"); // Not supposed to be null
}
