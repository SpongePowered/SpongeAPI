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
package org.spongepowered.api.util.orientation;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Optional;

/**
 * Represents an orientation in relative for an ItemFrame as an example.
 */
@CatalogedBy(Orientations.class)
public interface Orientation extends CatalogType {

    /**
     * Gets the {@link Orientation} with the provided degrees.
     *
     * @param degrees The degrees of the rotation
     * @return The {@link Orientation} with the given degrees or
     *      <tt>Optional.empty()</tt> if not found
     */
    static Optional<Orientation> fromDegrees(int degrees) {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).fromDegrees(degrees);
    }

    /**
     * The angle in degrees.
     *
     * @return The angle in degrees
     */
    //TODO we should have an Angle class in the future
    int getAngle();

    interface Factory {

        Optional<Orientation> fromDegrees(int degrees);
    }
}
