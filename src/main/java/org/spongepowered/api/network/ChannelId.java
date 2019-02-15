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
package org.spongepowered.api.network;

import com.google.inject.BindingAnnotation;
import org.spongepowered.api.CatalogKey;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation used for naming {@link ChannelBinding} injections.
 *
 * <p>Due to the limitations of Java annotations,
 * the 'namespace' and 'value' components of the {@link CatalogKey}
 * must be specified separately, instead of using a {@link CatalogKey} directly.</p>
 *
 * <p><pre>{@code @ChannelId(namespace="myplugin", value="SomeChannel") @Inject
 * ChannelBinding.RawDataChannel channel;}</pre></p>
 */
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface ChannelId {

    /**
     * Gets the channel namespace.
     *
     * <p>This corresponds to {@link CatalogKey#getNamespace()}</p>
     *
     * @return The channel namespace
     */
    String namespace();

    /**
     * Get the channel name.
     *
     * <p>This corresponds to {@link CatalogKey#getValue()}</p>
     * @return
     */
    String value();
}
