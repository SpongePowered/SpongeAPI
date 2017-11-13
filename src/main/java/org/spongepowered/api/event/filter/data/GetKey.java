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
package org.spongepowered.api.event.filter.data;

import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.DataTransactionResult;
import org.spongepowered.api.data.key.Key;
import org.spongepowered.api.data.value.mutable.Value;
import org.spongepowered.api.event.data.ChangeDataHolderEvent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Sets the annotated parameter to either the underlying value or the {@link Value} wrapper
 * for the specified {@link Key}, depending on the type of the parameter.
 *
 * This annotation can be used in two scenarios:
 *   * The (non-annotated) event is a {@link ChangeDataHolderEvent.ValueChange}. In this case, the value will be retrieved
 *     by searching through the specified {@link DataTransactionResult.DataCategory}s, sequentially, until it is found.
 *
 *   * The {@link #tag()} matches the tag of another annotated parameter, which implements {@link DataHolder}.
 *     In this case, the value will be retrieved directly from the parameter. If multiple non-Getkey annotated
 *     parameters are present, {@link #tag()} will need to be manually set to prevent duplicate tags. Otherwise,
 *     it can be left at the default of "".
 *
 *    For the purposes of the second case, the {@link ChangeDataHolderEvent.ValueChange} event can be considered
 *    to always have a tag. This means that if you use {@link GetKey} in an event listener for {@link ChangeDataHolderEvent.ValueChange},
 *    ond use any other annotated parameters, you will need to explictly set {@link #tag()}
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface GetKey {

    /**
     * The id of the {@link Key} to use. This <b>must</b> be registered when the corresponding event listener
     * for this annotation is registered.
     * @return
     */
    String value();

    /**
     * The tag to use for disambiguating between multiple annotated parameters
     * @return
     */
    String tag() default "";

    /**
     * The {@link DataTransactionResult.DataCategory}s to search through when this annotation is used
     * with {@link ChangeDataHolderEvent.ValueChange}
     * @return
     */
    DataTransactionResult.DataCategory [] from() default {DataTransactionResult.DataCategory.SUCCESSFUL};
}
