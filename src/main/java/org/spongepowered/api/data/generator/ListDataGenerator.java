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
package org.spongepowered.api.data.generator;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.immutable.ImmutableListData;
import org.spongepowered.api.data.manipulator.mutable.ListData;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.value.mutable.ListValue;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.ArrayList;
import java.util.List;

/**
 * This {@link DataGenerator} supports only one {@link Key} with a {@link BaseValue}
 * of the type {@link ListValue}. The generated classes will
 * always extend {@link ListData} and {@link ImmutableListData}.
 *
 * @param <E> The element type of the list
 * @param <M> The mutable manipulator type
 * @param <I> The immutable manipulator type
 */
@SuppressWarnings("unchecked")
public interface ListDataGenerator<E, M extends ListData<E, M, I>, I extends ImmutableListData<E, I, M>>
        extends DataGenerator<M, I, ListDataGenerator<E, M, I>, ListDataGenerator<?,?,?>> {

    /**
     * Generates a {@link ListDataGenerator}. Only one key will be
     * registered in this generator and it's {@link Value} type must
     * be a {@link ListValue}. The output extend the classes
     * {@link ListData} and a {@link ImmutableListData}.
     *
     * @param <E> The element type
     * @return The list data builder
     */
    static <E> ListDataGenerator<E, ? extends ListData<E, ?, ?>, ? extends ImmutableListData<E, ?, ?>> builder() {
        return Sponge.getRegistry().createBuilder(ListDataGenerator.class);
    }

    /**
     * Sets the {@link Key}.
     *
     * @param key Tke key
     * @param <NE> The element type
     * @return The builder, for chaining
     */
    <NE> ListDataGenerator<NE, ? extends ListData<NE, ?, ?>, ? extends ImmutableListData<NE, ?, ?>> key(
            Key<? extends ListValue<NE>> key);

    /**
     * Sets the interfaces that the generated {@link DataManipulator} and
     * {@link ImmutableDataManipulator} classes should be implement.
     *
     * @param mutableClass The mutable interface
     * @param immutableClass The immutable interface
     * @param <NM> The type of the mutable interface
     * @param <NI> The type of the immutable interface
     * @return This builder, for chaining
     */
    <NM extends ListData<E, NM, NI>, NI extends ImmutableListData<E, NI, NM>> ListDataGenerator<E, NM, NI> interfaces(
            Class<NM> mutableClass, Class<NI> immutableClass);

    /**
     * Sets the default {@link List} value. Defaults to
     * {@link ArrayList#ArrayList()}.
     *
     * @param defaultList The default list
     * @return This builder, for chaining
     */
    ListDataGenerator<E, M, I> defaultValue(List<E> defaultList);
}
