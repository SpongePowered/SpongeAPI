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

import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.manipulator.DataManipulator;
import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.value.BaseValue;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation can be applied to a method in a {@link DataManipulator} or
 * {@link ImmutableDataManipulator} interface. It allows that getter and setters
 * can be generated for the {@link Key}s in the target manipulator.
 * <p>Getters have always zero arguments and support two return types. The first one
 * is the element <code>E</code> of a {@link Key} and the second one is
 * returning the {@link BaseValue}. The return type must always be a super type of
 * the {@link Key} value or element. Primitive values can be automatically unboxed,
 * this is an exception on the exact match.</p>
 * <p>For example:
 * <pre>
 * {@code
 * // The key
 * Key<Value<Integer>> MY_INT_KEY = KeyFactory.makeValueKey(TypeTokens.INTEGER_TOKEN, DataQuery.of("MyInt"), "my_plugin:my_int", "MyInt");
 *
 * class MyImmutableData extends ImmutableDataManipulator<MyImmutableData, MyData> { }
 * class MyData extends DataManipulator<MyData, MyImmutableData> {
 *   @KeyValue("my_int") int getMyInt();
 *   @KeyValue("my_int") Integer getMyInteger();
 *   @KeyValue("my_int") Value<Integer> myInt();
 * }
 * }
 * </pre>
 * </p>
 * <p>Setters have always one argument, this must always match the element
 * <code>E</code></p>. Primitive values can also be automatically boxed.
 * In a {@link ImmutableDataManipulator} is a return type required, this will return the newly
 * constructed immutable manipulator.
 * You can also return a manipulator in a{@link DataManipulator}, this will always return the
 * object itself and allows chaining operations. The return type isn't required in this case.
 * <p>For example:
 * <pre>
 * {@code
 * // The key
 * Key<Value<Integer>> MY_INT_KEY = KeyFactory.makeValueKey(TypeTokens.INTEGER_TOKEN, DataQuery.of("MyInt"), "my_plugin:my_int", "MyInt");
 *
 * class MyImmutableData extends ImmutableDataManipulator<MyImmutableData, MyData> {
 *   @KeyValue("my_int") MyImmutableData myInt(int value);
 *   @KeyValue("my_int") MyImmutableData myInteger(Integer value);
 * }
 * class MyData extends DataManipulator<MyData, MyImmutableData> {
 *   @KeyValue("my_int") void setMyInt(int value);
 *   @KeyValue("my_int") MyData myInt(int value);
 *   @KeyValue("my_int") void setMyInteger(Integer value);
 *   @KeyValue("my_int") MyData myInteger(Integer value);
 * }
 * }
 * </pre>
 * </p>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface KeyValue {

    /**
     * The id of the target {@link Key}. The id doesn't have to be
     * fully qualified with the plugin id, it will try to find the appropriate
     * {@link Key} in this case.
     *
     * @return The id of the target key
     */
    String value();

}
