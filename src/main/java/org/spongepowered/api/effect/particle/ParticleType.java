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
package org.spongepowered.api.effect.particle;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Map;
import java.util.Optional;

/**
 * Represents a particle that can be sent on a Minecraft client.
 */
@CatalogedBy(ParticleTypes.class)
public interface ParticleType extends CatalogType {

    /**
     * Gets the default value for the specified {@link ParticleOption}, it may
     * return {@link Optional#empty()} if the particle option isn't supported
     * by this particle type.
     *
     * @param option The particle option
     * @param <V> The value type
     * @return The option value if present, otherwise {@link Optional#empty()}
     */
    <V> Optional<V> getDefaultOption(ParticleOption<V> option);

    /**
     * Gets a immutable {@link Map} with all the available
     * {@link ParticleOption}s and their values. When a option isn't
     * available inside this {@link Map} it's most likely not supported
     * by this particle type.
     *
     * @return The default options
     */
    Map<ParticleOption<?>, Object> getDefaultOptions();

}
