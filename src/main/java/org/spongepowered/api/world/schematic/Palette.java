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

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

/**
 * Represents a mapping for types to a local identifier. Can be used for
 * mapping {@link CatalogType}s to {@code int} id's for storage purposes,
 * or for converting stored information to a representable format back into
 * {@link CatalogType}s.
 *
 * @param <T> The type this palette will maintain
 */
@CatalogedBy(PaletteTypes.class)
public interface Palette<T> {

    /**
     * Gets the type of this palette.
     *
     * @return The palette type
     */
    PaletteType<T> getType();

    /**
     * Gets the highest identifier in this palette.
     *
     * @return The highest id
     */
    int getHighestId();

    /**
     * Gets the {@code type} represented by the given identifier from the mapping.
     *
     * @param id The identifier
     * @return The type, if found
     */
    Optional<T> get(int id);

    /**
     * Gets the identifier for the given {@code type T} if it exists within the
     * mapping.
     *
     * @param type The type
     * @return The identifier, if found
     */
    OptionalInt get(T type);


    /**
     * Gets all {@code type T}s contained in this palette.
     *
     * @return All contained types
     */
    Stream<T> stream();

    Mutable<T> asMutable();

    Immutable<T> asImmutable();

    interface Mutable<M> extends Palette<M> {

        /**
         * Gets the identifier for the given {@code type T} from the mapping. If the
         * {@code type T} is not yet registered in the mapping then it is registered and
         * given the next available identifier.
         *
         * @param type The type
         * @return The identifier
         */
        int getOrAssign(M type);

        /**
         * Removes the given {@code type T} from the mapping.
         *
         * <p>Note that if this palette is considered a global palette, removal is not supported.</p>
         *
         * @param type The type to remove
         * @return If the type existed in the mapping
         */
        boolean remove(M type);

        @Override
        default Mutable<M> asMutable() {
            return this;
        }
    }

    interface Immutable<I> extends Palette<I> {

        @Override
        default Immutable<I> asImmutable() {
            return this;
        }
    }

}
