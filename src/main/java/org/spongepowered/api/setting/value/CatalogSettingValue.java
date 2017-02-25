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
package org.spongepowered.api.setting.value;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.CatalogType;

import java.util.Optional;

import javax.annotation.Nullable;

/**
 * A {@link CatalogType} setting value.
 */
public class CatalogSettingValue<T extends CatalogType> implements SettingValue<T> {

    private final Class<T> catalogClass;
    @Nullable private T value;

    public CatalogSettingValue(Class<T> catalogClass, @Nullable T value) {
        this.catalogClass = checkNotNull(catalogClass, "catalog class");
        this.value = value;
    }

    @Override
    public Optional<T> get() {
        return Optional.ofNullable(this.value);
    }

    @Override
    public void set(@Nullable T value) {
        this.value = value;
    }

    @Override
    public String serialize() {
        return this.value == null ? "" : this.value.getId();
    }

}
