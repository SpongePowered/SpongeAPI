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

import org.spongepowered.api.data.generator.KeyValue;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.meta.ItemEnchantment;
import org.spongepowered.api.data.value.immutable.ImmutableBoundedValue;
import org.spongepowered.api.data.value.immutable.ImmutableListValue;

import java.util.List;

public interface ImmutableDummyManipulator extends ImmutableDataManipulator<ImmutableDummyManipulator, DummyManipulator> {

    // My int

    @KeyValue("my_int") ImmutableBoundedValue<Integer> myInt();
    @KeyValue("my_int") int getMyInt();
    @KeyValue("my_int") Integer getMyInteger();
    @KeyValue("my_int") ImmutableDummyManipulator myInt(int value);
    @KeyValue("my_int") ImmutableDummyManipulator myInteger(Integer value);

    // My item enchantments

    @KeyValue("my_item_enchantments") ImmutableListValue<ItemEnchantment> enchantments();
    @KeyValue("my_item_enchantments") List<ItemEnchantment> getEnchantments();
    @KeyValue("my_item_enchantments") ImmutableDummyManipulator enchantments(List<ItemEnchantment> enchantments);

}
