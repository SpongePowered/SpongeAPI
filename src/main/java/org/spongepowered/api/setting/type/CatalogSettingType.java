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

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.setting.value.CatalogSettingValue;

import java.util.Optional;

import javax.annotation.Nullable;

public class CatalogSettingType<T extends CatalogType> implements SettingType<T, CatalogSettingValue<T>> {

    private final Class<T> catalogClass;

    /**
     * Creates a new {@link Enum} setting type.
     *
     * @param catalogClass The enum class
     * @param <T> The enum type
     * @return The setting type
     */
    public static <T extends CatalogType> CatalogSettingType<T> of(Class<T> catalogClass) {
        return new CatalogSettingType<>(catalogClass);
    }

    protected CatalogSettingType(Class<T> catalogClass) {
        this.catalogClass = checkNotNull(catalogClass, "catalog class");
    }

    @Override
    public String serialize(CatalogSettingValue<T> object) {
        return object.serialize();
    }

    @Override
    public Optional<CatalogSettingValue<T>> deserialize(String string) {
        checkNotNull(string, "string");

        return Sponge.getRegistry().getType(this.catalogClass, string).map(this::createValue);
    }

    @Override
    public CatalogSettingValue<T> createValue(@Nullable T value) {
        return new CatalogSettingValue<>(this.catalogClass, value);
    }

}
