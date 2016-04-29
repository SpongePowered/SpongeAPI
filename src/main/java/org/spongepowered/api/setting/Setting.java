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
package org.spongepowered.api.setting;

import org.spongepowered.api.setting.type.SettingType;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageReceiver;

import java.util.Optional;
import java.util.regex.Pattern;

/**
 * A setting.
 *
 * @param <T> The value type of this setting
 */
public interface Setting<T> {

    /**
     * A pattern to validate setting ids.
     */
    Pattern ID_PATTERN = Pattern.compile("[a-z][a-z0-9_]*");

    /**
     * Gets the identifier for this setting.
     *
     * <p>Ids should be unique as to not conflict with other settings.</p>
     *
     * <p>The id must be lowercase, start with an alphabetic character, and
     * contain only alphanumeric characters.</p>
     *
     * @return The identifier
     * @see #ID_PATTERN
     */
    String getId();

    /**
     * Gets the friendly name for this setting.
     *
     * @param receiver The receiver of the name
     * @return The friendly name
     */
    Text getName(MessageReceiver receiver);

    /**
     * Gets the setting type.
     *
     * @return The setting type
     */
    SettingType<T> getType();

    /**
     * Gets the default value associated with this setting.
     *
     * @return The default value, if present, {@link Optional#empty()} otherwise
     */
    Optional<T> getDefaultValue();

}
