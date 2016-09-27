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
package org.spongepowered.api.event.filter.cause;

import org.spongepowered.api.event.cause.EventContext;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Sets the parameter to the object with the specified name. An additional check
 * is done to ensure that the named cause object is of the correct type. The
 * filter fails if this is not the case.
 *
 * @see EventContext#get(String)
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface ContextValue {

    /**
     * Gets the name to use with the {@link NamedCause}.
     *
     * @return The name to use
     */
    String value();

    /**
     * If specified the possible type for the returned object (normally
     * specified by the type of the annotated parameter) is restricted to only
     * the specified types.
     *
     * <p>For exampled annotating a parameter of type Monster would normally
     * accept all entities extending Monster, however with the includes
     * specified as Enderman and Zombie the possible Monsters returned would be
     * restricted to entities extending either Enderman and Zombie.</p>
     *
     * @return The included classes, if empty then the type is not restricted
     */
    Class<?>[] typeFilter() default {};

    /**
     * If true then the behavior of the typeFilter is reversed and the specified
     * types are excluded rather than included.
     *
     * @return If the type filter is reversed
     */
    boolean inverse() default false;

}
