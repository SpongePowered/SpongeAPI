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
package org.spongepowered.api.data.generator.testing;

import static org.spongepowered.api.data.key.KeyFactory.makeListKey;
import static org.spongepowered.api.data.key.KeyFactory.makeMapKeyWithKeyAndValue;
import static org.spongepowered.api.data.key.KeyFactory.makeValueKey;

import com.google.common.reflect.TypeToken;
import org.spongepowered.api.data.DataQuery;
import org.spongepowered.api.data.DataRegistration;
import org.spongepowered.api.data.generator.DataGenerator;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.immutable.ImmutableVariantData;
import org.spongepowered.api.data.manipulator.mutable.ListData;
import org.spongepowered.api.data.manipulator.mutable.MappedData;
import org.spongepowered.api.data.manipulator.mutable.VariantData;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.MapValue;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.util.TypeTokens;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleExamples {

    public static final Key<ListValue<String>> MY_LINES_KEY = makeListKey(
            TypeTokens.STRING_TOKEN, DataQuery.of("MyLines"), "my_data_plugin:my_lines", "My Lines");

    private static final DataRegistration<? extends ListData<String, ?, ?>, ?> MY_LINES_DATA = DataGenerator.builder()
            .list(MY_LINES_KEY)
            .defaultValue(new ArrayList<>())
            .buildAndRegister("my_data_plugin", "my_lines_data");

    public static final Key<MapValue<Integer, String>> MY_INT_TO_STRING_MAP_KEY = makeMapKeyWithKeyAndValue(
            TypeTokens.INTEGER_TOKEN, TypeTokens.STRING_TOKEN, DataQuery.of("MyIntToStringMap"), "my_data_plugin:my_int_to_string_map", "My Int To "
                    + "String Map");

    private static final DataRegistration<? extends MappedData<Integer, String, ?, ?>, ?> MY_INT_TO_STRING_MAP_DATA = DataGenerator.builder()
            .map(MY_INT_TO_STRING_MAP_KEY)
            .defaultValue(new HashMap<>())
            .buildAndRegister("my_data_plugin", "my_int_to_string_map_data");

    enum Fruit {
        APPLE,
        BANANA,
        CITRON,
        ;
    }

    public static final Key<Value<Fruit>> MY_FRUIT_KEY = makeValueKey(
            TypeToken.of(Fruit.class), DataQuery.of("MyFruit"), "my_data_plugin:my_fruit", "My Fruit");

    private static final DataRegistration<? extends VariantData<Fruit, ?, ?>, ?> MY_FRUIT_DATA = DataGenerator.builder()
            .variant(MY_FRUIT_KEY)
            .defaultValue(Fruit.APPLE)
            .buildAndRegister("my_data_plugin", "my_fruit_data");

    public static final Key<Value<Fruit>> MY_OTHER_FRUIT_KEY = makeValueKey(
            TypeToken.of(Fruit.class), DataQuery.of("MyOtherFruit"), "my_data_plugin:my_other_fruit", "My Other Fruit");

    public interface OtherFruitData extends VariantData<Fruit, OtherFruitData, OtherImmutableFruitData> {}

    public interface OtherImmutableFruitData extends ImmutableVariantData<Fruit, OtherImmutableFruitData, OtherFruitData> {}

    private static final DataRegistration<OtherFruitData, OtherImmutableFruitData> MY_OTHER_FRUIT_DATA = DataGenerator.builder()
            .variant(MY_OTHER_FRUIT_KEY)
            .interfaces(OtherFruitData.class, OtherImmutableFruitData.class)
            .defaultValue(Fruit.APPLE)
            .buildAndRegister("my_data_plugin", "my_other_fruit_data");
}
