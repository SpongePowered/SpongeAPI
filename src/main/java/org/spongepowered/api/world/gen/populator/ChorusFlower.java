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
package org.spongepowered.api.world.gen.populator;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.world.gen.Populator;

/**
 * Represents a populator which will chorus flowers as in the end.
 */
public interface ChorusFlower extends Populator {

    /**
     * Creates a new {@link Builder} to build a {@link ChorusFlower} populator.
     *
     * @return The new builder
     */
    static Builder builder() {
        return Sponge.getRegistry().createBuilder(Builder.class);
    }

    /**
     * Gets the radius around the center (0, 0) of the world that this populator
     * will not apply to.
     * 
     * <p> This is used to prevent the islands from generating around the ender
     * dragon fight area. </p>
     * 
     * @return The radius
     */
    int getExclusionRadius();

    /**
     * Sets the radius around the center (0, 0) of the world that this populator
     * will not apply to.
     * 
     * <p> This must be a positive value or zero. </p>
     * 
     * @param radius The exclusion radius
     */
    void setExclusionRadius(int radius);

    /**
     * A builder for constructing {@link ChorusFlower} populators.
     */
    interface Builder extends ResettableBuilder<ChorusFlower, Builder> {

        /**
         * Sets the radius around the center (0, 0) of the world that this
         * populator will not apply to.
         * 
         * <p> This must be a positive value or zero. </p>
         * 
         * @param radius The exclusion radius
         * @return This builder, for chaining
         */
        Builder exclusionRadius(int radius);

        /**
         * Builds a new instance of a {@link ChorusFlower} populator with the
         * settings set within the builder.
         * 
         * @return A new instance of the populator
         * @throws IllegalStateException If there are any settings left unset
         *         which do not have default values
         */
        ChorusFlower build() throws IllegalStateException;

    }

}
