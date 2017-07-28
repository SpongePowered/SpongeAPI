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

import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.generator.KeyValue;
import org.spongepowered.api.data.meta.ItemEnchantment;
import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.List;

public interface DummyManipulator extends DataManipulator<DummyManipulator, ImmutableDummyManipulator> {

    // My int

    @KeyValue("my_int") MutableBoundedValue<Integer> myInt();
    @KeyValue("my_int") int getMyInt();
    @KeyValue("my_int") Integer getMyInteger();
    @KeyValue("my_int") void setMyInt(int value);
    @KeyValue("my_int") DummyManipulator myInt(int value);
    @KeyValue("my_int") void setMyInteger(Integer value);
    @KeyValue("my_int") DummyManipulator myInteger(Integer value);

    // My item enchantments

    @KeyValue("my_item_enchantments") ListValue<ItemEnchantment> enchantments();
    @KeyValue("my_item_enchantments") List<ItemEnchantment> getEnchantments();
    @KeyValue("my_item_enchantments") void setEnchantments(List<ItemEnchantment> enchantments);
    @KeyValue("my_item_enchantments") DummyManipulator enchantments(List<ItemEnchantment> enchantments);

}
