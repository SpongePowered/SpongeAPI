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
package org.spongepowered.api.util;

import org.spongepowered.api.text.translation.Translation;
import org.spongepowered.api.text.translation.locale.Locales;

/**
 * An identifiable object that uses a {@link String} as an identifier.
 */
public interface Nameable {

    /**
     * The name that represents this object.
     *
     * @return The name.
     */
    String getName();

    /**
     * An object which has a name that is translatable.
     */
    interface Translatable extends Nameable {

        /**
         * Gets the human-readable name of this object.
         *
         * @return The name of this object
         */
        Translation getNameTranslation();

        /**
         * Gets the name in the {@link Locales#DEFAULT} locale of the
         * {@link Translation}.
         *
         * @return The default translation of the name.
         */
        @Override
        default String getName() {
            return getNameTranslation().get();
        }

    }

}
