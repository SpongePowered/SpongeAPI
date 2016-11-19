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
package org.spongepowered.api.plugin;

import org.spongepowered.plugin.meta.PluginMetadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

/**
 * An annotation used to describe and mark a Sponge plugin.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Plugin {

    /**
     * The pattern plugin IDs must match. Plugin IDs must be lower case, and
     * start with an alphabetic character. It may only contain alphanumeric
     * characters, dashes or underscores. It cannot be longer than
     * 64 characters.
     */
    Pattern ID_PATTERN = PluginMetadata.ID_PATTERN;

    /**
     * An ID for the plugin to be used internally. The ID should be unique as to
     * not conflict with other plugins.
     *
     * <p>The plugin ID must match the {@link #ID_PATTERN}.</p>
     *
     * @return The plugin identifier
     * @see <a href="https://goo.gl/MRRYSJ">Java package naming conventions</a>
     */
    String id();

    /**
     * The human readable name of the plugin as to be used in descriptions and
     * similar things.
     *
     * @return The plugin name, or an empty string if unknown
     */
    String name() default "";

    /**
     * The version of the plugin.
     *
     * @return The plugin version, or an empty string if unknown
     */
    String version() default "";

    /**
     * The dependencies required to load <strong>before</strong> this plugin.
     *
     * @return The plugin dependencies
     */
    Dependency[] dependencies() default {};

    /**
     * The description of the plugin, explaining what it can be used for.
     *
     * @return The plugin description, or an empty string if unknown
     */
    String description() default "";

    /**
     * The URL or website of the plugin.
     *
     * @return The plugin url, or an empty string if unknown
     */
    String url() default "";

    /**
     * The authors of the plugin.
     *
     * @return The plugin authors, or empty if unknown
     */
    String[] authors() default {};

}
