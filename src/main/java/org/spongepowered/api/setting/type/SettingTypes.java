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
package org.spongepowered.api.setting.type;

import org.spongepowered.api.CatalogType;

/**
 * An enumeration of sharable setting types.
 */
public final class SettingTypes {

    /**
     * A {@link Boolean} setting type.
     */
    public static final BooleanSettingType BOOLEAN = new BooleanSettingType();

    /**
     * A {@link Double} setting type.
     */
    public static final DoubleSettingType DOUBLE = new DoubleSettingType();

    /**
     * A {@link Float} setting type.
     */
    public static final FloatSettingType FLOAT = new FloatSettingType();

    /**
     * A {@link Integer} setting type.
     */
    public static final IntegerSettingType INTEGER = new IntegerSettingType();

    /**
     * A {@link Long} setting type.
     */
    public static final LongSettingType LONG = new LongSettingType();

    /**
     * Creates a new {@link Enum} setting type.
     *
     * @param enumClass The enum class
     * @param <T> The enum type
     * @return The setting type
     */
    public static <T extends Enum<T>> EnumSettingType<T> enumOf(Class<T> enumClass) {
        return EnumSettingType.of(enumClass);
    }

    /**
     * Creates a new {@link CatalogType} setting type.
     *
     * @param catalogClass The catalog class
     * @param <T> The catalog type
     * @return The setting type
     */
    public static <T extends CatalogType> CatalogSettingType<T> catalogOf(Class<T> catalogClass) {
        return CatalogSettingType.of(catalogClass);
    }

    private SettingTypes() {
    }

}
