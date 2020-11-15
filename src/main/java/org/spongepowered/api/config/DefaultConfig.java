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
package org.spongepowered.api.config;

import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import org.spongepowered.configurate.loader.ConfigurationLoader;

import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.file.Path;

/**
 * Provides an convenient injection for {@link ConfigRoot#getConfig()} or
 * {@link ConfigRoot#getConfigPath()}.
 *
 * <p>Use this annotation on a {@link File} or {@link Path} if you want the
 * pathname to the default configuration. Or instead, use this annotation on a
 * {@link ConfigurationLoader} to get an instance of that. Remember that
 * {@link Inject} is also necessary.</p>
 *
 * @see ConfigManager For getting configuration without injection
 */
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
public @interface DefaultConfig {

    /**
     * Whether the the shared root for configuration should be used.
     *
     * @return True to use a shared root configuration
     * @see ConfigRoot#getConfigPath() For information on what the
     *     shared root is
     */
    boolean sharedRoot();

}
