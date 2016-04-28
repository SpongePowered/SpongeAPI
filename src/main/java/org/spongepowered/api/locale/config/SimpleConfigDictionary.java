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
package org.spongepowered.api.locale.config;

import ninja.leaping.configurate.ConfigurationNode;

import java.io.IOException;
import java.util.Locale;

import javax.annotation.Nullable;

/**
 * Represents a simple implementation of {@link ConfigDictionary} with a single source.
 */
public class SimpleConfigDictionary extends AbstractConfigDictionary {

    @Nullable protected ConfigurationNode root;

    public SimpleConfigDictionary(Object subject, Locale defaultLocale) {
        super(subject, defaultLocale);
    }

    @Override
    public ConfigurationNode load(Locale locale) throws IOException {
        this.root = super.load(locale);
        return this.root;
    }

    @Override
    public ConfigurationNode getNode(Locale locale) {
        if (this.root == null) {
            throw new IllegalStateException("Tried to read SimpleConfigDictionary before it was loaded.");
        }

        return this.root.getNode(locale.toString());
    }

}
