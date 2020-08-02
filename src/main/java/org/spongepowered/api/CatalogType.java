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
package org.spongepowered.api;

import net.kyori.adventure.key.Keyed;
import org.spongepowered.api.registry.GameRegistry;

/**
 * Represents a type of a dummy that can be used to identify types without
 * using an {@link Enum}.
 *
 * <p>All implementing classes, including those not listed in the dummy
 * specified by the {@link org.spongepowered.api.util.annotation.CatalogedBy
 * CatalogedBy} annotation, must meet the requirement that if any of
 * <code>`a.equals(b)`</code>, <code>`a == b`</code>, or
 * <code>`a.getKey().equals(b.getKey())`</code> are true then all must
 * be true.</p>
 */
public interface CatalogType extends Keyed {

    /**
     * Gets the catalog key for this catalog type. Useful for storing a searchable
     * id reference within the {@link GameRegistry}. Since the {@link GameRegistry}
     * can effectively search for the {@link ResourceKey#getNamespace()}, a fail
     * fast scenario can be achieved if the namespace provider (usually a plugin or
     * mod) is unavailable.
     *
     * @return The catalog key
     */
    ResourceKey getKey();

    @Override
    default ResourceKey key() {
        return this.getKey();
    }
}
