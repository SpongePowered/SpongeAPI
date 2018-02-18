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
import java.util.Optional;

import javax.annotation.Nullable;

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
 * <blockquote><code>Key&lt;Value&lt;Integer&gt;&gt;&nbsp;MY_INT_KEY&nbsp;=&nbsp;Key.builder()
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;.type(TypeTokens.INTEGER_VALUE_TOKEN))
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;.query(DataQuery.of("MyInt"))
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;.id("my_int")
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;.name("MyInt")
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;.build();
 * <br/>// Don't forget to register it!
 * <br/>
 * <br/>class&nbsp;MyImmutableData&nbsp;extends&nbsp;ImmutableDataManipulator&lt;MyImmutableData,&nbsp;MyData&gt;&nbsp;{&nbsp;}
 * <br/>class&nbsp;MyData&nbsp;extends&nbsp;DataManipulator&lt;MyData,&nbsp;MyImmutableData&gt;&nbsp;{
 * <br/>&nbsp;&nbsp;@KeyValue("my_int")&nbsp;int&nbsp;getMyInt();
 * <br/>&nbsp;&nbsp;@KeyValue("my_int")&nbsp;Integer&nbsp;getMyInteger();
 * <br/>&nbsp;&nbsp;@KeyValue("my_int")&nbsp;Value&lt;Integer&gt;&nbsp;myInt();
 * <br/>}</code></blockquote>
 * </p>
 * <p>Setters have always one argument, this must always match the element
 * <code>E</code></p>. Primitive values can also be automatically boxed.
 * In a {@link ImmutableDataManipulator} is a return type required, this will return the newly
 * constructed immutable manipulator.
 * You can also return a manipulator in a{@link DataManipulator}, this will always return the
 * object itself and allows chaining operations. The return type isn't required in this case.
 * this is an exception on the exact match.</p>
 * <p>For example:
 * <blockquote><code>Key&lt;Value&lt;Integer&gt;&gt;&nbsp;MY_INT_KEY&nbsp;=&nbsp;Key.builder()
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;.type(TypeTokens.INTEGER_VALUE_TOKEN))
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;.query(DataQuery.of("MyInt"))
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;.id("my_int")
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;.name("MyInt")
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;.build();
 * <br/>// Don't forget to register it!
 * <br/>
 * <br/>class&nbsp;MyImmutableData&nbsp;extends&nbsp;ImmutableDataManipulator&lt;MyImmutableData,&nbsp;MyData&gt;&nbsp;{
 * <br/>&nbsp;&nbsp;@KeyValue("my_int")&nbsp;MyImmutableData&nbsp;myInt(int&nbsp;value);
 * <br/>&nbsp;&nbsp;@KeyValue("my_int")&nbsp;MyImmutableData&nbsp;myInteger(Integer&nbsp;value);
 * <br/>}
 * <br/>class&nbsp;MyData&nbsp;extends&nbsp;DataManipulator&lt;MyData,&nbsp;MyImmutableData&gt;&nbsp;{
 * <br/>&nbsp;&nbsp;@KeyValue("my_int")&nbsp;void&nbsp;setMyInt(int&nbsp;value);
 * <br/>&nbsp;&nbsp;@KeyValue("my_int")&nbsp;MyData&nbsp;myInt(int&nbsp;value);
 * <br/>&nbsp;&nbsp;@KeyValue("my_int")&nbsp;void&nbsp;setMyInteger(Integer&nbsp;value);
 * <br/>&nbsp;&nbsp;@KeyValue("my_int")&nbsp;MyData&nbsp;myInteger(Integer&nbsp;value);
 * <br/>}</code></blockquote>
 * </p>
 * <p>
 * In addition to the default setters and getters is there also extended support
 * for {@link Nullable} values when using {@link Optional}s. A setter with a {@link Nullable}
 * annotated parameter will automatically be put into a {@link Optional} (this
 * also works in combination with returning a manipulator). A getter
 * with a {@link Nullable} annotation will be automatically unboxed.
 * <p>For example:
 * <blockquote><code>Key&lt;Value&lt;Integer&gt;&gt;&nbsp;MY_INT_KEY&nbsp;=&nbsp;Key.builder()
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;.type(new&nbsp;TypeToken&lt;OptionalValue&lt;Integer&gt;&gt;()&nbsp;{})
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;.query(DataQuery.of("MyOptInt"))
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;.id("my_opt_int")
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;.name("MyOptInt")
 * <br/>&nbsp;&nbsp;&nbsp;&nbsp;.build();
 * <br/>// Don't forget to register it!
 * <br/>
 * <br/>class&nbsp;MyImmutableData&nbsp;extends&nbsp;ImmutableDataManipulator&lt;MyImmutableData,&nbsp;MyData&gt;&nbsp;{
 * <br/>&nbsp;&nbsp;@KeyValue("my_opt_int")&nbsp;MyImmutableData&nbsp;myOptInteger(Optional&lt;Integer&gt;&nbsp;value);
 * <br/>&nbsp;&nbsp;@KeyValue("my_opt_int")&nbsp;MyImmutableData&nbsp;myOptInteger(@Nullable&nbsp;Integer&nbsp;value);
 * <br/>}
 * <br/>class&nbsp;MyData&nbsp;extends&nbsp;DataManipulator&lt;MyData,&nbsp;MyImmutableData&gt;&nbsp;{
 * <br/>&nbsp;&nbsp;@KeyValue("my_opt_int")&nbsp;void&nbsp;setMyInteger(@Nullable&nbsp;Integer&nbsp;value);
 * <br/>&nbsp;&nbsp;@KeyValue("my_opt_int")&nbsp;MyData&nbsp;myInteger(Optional&lt;Integer&gt;&nbsp;value);
 * <br/>}</code></blockquote>
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
