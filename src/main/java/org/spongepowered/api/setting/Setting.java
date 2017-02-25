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

import org.spongepowered.api.Sponge;
import org.spongepowered.api.setting.type.SettingType;
import org.spongepowered.api.setting.value.SettingValue;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.channel.MessageReceiver;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Collection;
import java.util.Optional;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

/**
 * A setting.
 *
 * <p>Settings are immutable.</p>
 *
 * @param <T> The value type of this setting
 */
public interface Setting<T> {

    /**
     * A pattern to validate setting ids.
     */
    Pattern ID_PATTERN = Pattern.compile("[a-z][a-z0-9_]*");

    /**
     * Creates a new {@link Builder} to create {@link Setting}s.
     *
     * @return The new builder
     */
    @SuppressWarnings("unchecked")
    static <T, V extends SettingValue<T>> Builder<T, V> builder(SettingType<T, V> type) {
        return Sponge.getRegistry().createBuilder(Builder.class).type(type);
    }

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
     * Gets a collection of aliases for this setting.
     *
     * @return A collection of aliases
     */
    Collection<String> getAliases();

    /**
     * Gets the friendly name for this setting.
     *
     * @param receiver The receiver of the name
     * @return The friendly name
     */
    Text getName(@Nullable MessageReceiver receiver);

    /**
     * Gets the setting type.
     *
     * @return The setting type
     */
    SettingType<T, SettingValue<T>> getType();

    /**
     * Create a {@link SettingValue} for the provided value.
     *
     * @param value The value
     * @return The setting value
     * @see SettingType#createValue(Object)
     */
    default SettingValue<T> createValue(@Nullable T value) {
        return this.getType().createValue(value);
    }

    /**
     * Gets the default value associated with this setting.
     *
     * @return The default value, if present, {@link Optional#empty()} otherwise
     */
    Optional<T> getDefaultValue();

    /**
     * Represents a builder class to create immutable {@link Setting}s.
     *
     * @see Setting
     */
    interface Builder<T, V extends SettingValue<T>> extends ResettableBuilder<Setting<T>, Builder<T, V>> {

        /**
         * Sets the id for settings created by this builder.
         *
         * @param id The setting id
         * @return This builder
         * @throws IllegalArgumentException If the id does not match
         *     the {@link #ID_PATTERN pattern}
         */
        Builder<T, V> id(String id);

        /**
         * Sets the aliases for settings created by this builder.
         *
         * @param aliases The aliases
         * @return This builder
         * @throws IllegalArgumentException If any of the ids do not
         *     match the {@link #ID_PATTERN pattern}
         */
        Builder<T, V> aliases(String... aliases);

        /**
         * Sets the aliases for settings created by this builder.
         *
         * @param aliases The aliases
         * @return This builder
         */
        Builder<T, V> aliases(Collection<String> aliases);

        /**
         * Sets the type for settings created by this builder.
         *
         * @param type The setting type
         * @return This builder
         */
        Builder<T, V> type(SettingType<T, V> type);

        /**
         * Sets the name for settings created by this builder.
         *
         * @param name The setting name
         * @return This builder
         */
        Builder<T, V> name(Text name);

        /**
         * Sets the default value for settings created by this builder.
         *
         * @param defaultValue The default value
         * @return This builder
         */
        Builder<T, V> defaultValue(@Nullable T defaultValue);

        /**
         * Builds a setting based off the values of this builder.
         *
         * @return The setting
         * @throws IllegalStateException If the id has not been set
         * @throws IllegalStateException If the id does not match
         *     the {@link #ID_PATTERN pattern}
         * @throws IllegalStateException If the type has not been set
         * @throws IllegalStateException If the name has not been set
         */
        Setting<T> build();

    }

}
