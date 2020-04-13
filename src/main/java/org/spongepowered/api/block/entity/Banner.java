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
package org.spongepowered.api.block.entity;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.meta.BannerPatternLayer;
import org.spongepowered.api.data.type.DyeColor;
import org.spongepowered.api.data.value.ListValue;
import org.spongepowered.api.data.value.Value;

/**
 * Represents a Banner {@link BlockEntity}.
 */
public interface Banner extends NameableBlockEntity {

    /**
     * Gets the {@link org.spongepowered.api.data.value.Value.Mutable} for the base {@link DyeColor}.
     *
     * @return The value for the base color
     */
    default Value.Mutable<DyeColor> baseColor() {
        return this.requireValue(Keys.DYE_COLOR).asMutable();
    }

    /**
     * Gets the {@link org.spongepowered.api.data.value.ListValue.Mutable} of all patterns for the
     * {@link Banner}.
     *
     * @return The pattern list
     */
    default ListValue.Mutable<BannerPatternLayer> patternLayers() {
        return this.requireValue(Keys.BANNER_PATTERN_LAYERS).asMutable();
    }
}
