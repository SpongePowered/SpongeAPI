/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.plugin;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * An annotation used to describe and mark a Sponge plugin
 */
@Target(TYPE)
@Retention(RUNTIME)
public @interface Plugin {

    /**
     * An ID for the plugin to be used internally. The ID should be unique as to
     * not conflict with other plugins.
     *
     * @return A unique identifier
     */
    String id();

    /**
     * The human readable name of the plugin as to be used in descriptions and
     * similar things.
     *
     * @return The human readable name of the plugin
     */
    String name();

    /**
     * The version of the plugin.
     *
     * @return The version of the plugin
     */
    String version() default "unknown";

    /**
     * A simple dependency string for this mod separated by a ";"
     * example:
     * <pre>"required-after:Sponge@[1.2.3.2222,);required-after:myLibraryPlugin;after:towny;before:worldguard"</pre>
     * supported options:
     * <dl>
     *   <dt>after</dt>
     *   <dd>when present this plugin will run after plugin x</dd>
     *   <dt>required-after</dt>
     *   <dd>plugin x must be present, load after plugin x</dd>
     *   <dt>before</dt>
     *   <dd>when present run before plugin x</dd>
     *   <dt>required-before</dt>
     *   <dd>plugin x must be present, load before plugin x</dd>
     * </dl>
     * supports maven version ranges after @ in any field
     *
     * @return A specially formatted list of dependencies
     */
    String dependencies() default "";


}
