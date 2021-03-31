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
package org.spongepowered.api.world.schematic;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryValue;
import org.spongepowered.api.registry.Registry;
import org.spongepowered.api.registry.RegistryHolder;
import org.spongepowered.api.registry.RegistryType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Optional;
import java.util.function.BiFunction;

@CatalogedBy(PaletteTypes.class)
public interface PaletteType<T, R> extends DefaultedRegistryValue {

    @SuppressWarnings("unchecked")
    static <E, ER> Builder<E, ER> builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    Palette<T, R> create(RegistryHolder holder, RegistryType<R> registryType);

    BiFunction<String, Registry<R>, Optional<T>> resolver();

    BiFunction<Registry<R>, T, String> stringifier();

    interface Builder<T, R> extends org.spongepowered.api.util.Builder<PaletteType<T, R>, Builder<T, R>> {

        Builder<T, R> resolver(BiFunction<String, Registry<R>, Optional<T>> resolver);

        Builder<T, R> stringifier(BiFunction<Registry<R>, T, String> stringifier);
    }
}
