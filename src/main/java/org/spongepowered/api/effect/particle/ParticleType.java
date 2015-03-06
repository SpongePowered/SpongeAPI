/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.awt.Color;

/**
 * Represents a particle that can be sent on a Minecraft client.
 */
@CatalogedBy(ParticleTypes.class)
public interface ParticleType {

    /**
     * Gets the particle name.
     *
     * @return The particle's name
     */
    String getName();

    /**
     * Gets whether the particle able is to have a motion vector.
     *
     * @return Has motion
     */
    boolean hasMotion();

    /**
     * Represents a particle that can be colored.
     */
    interface Colorable extends ParticleType {

        /**
         * Gets the default color of this particle.
         *
         * @return The default color
         */
        Color getDefaultColor();

    }

    /**
     * Represents a particle that can be resized.
     */
    interface Resizable extends ParticleType {

        /**
         * Gets the default size of this particle.
         *
         * @return The default size
         */
        float getDefaultSize();

    }

    /**
     * Represents a particle that uses a note value.
     * Scales between 0 and 24, similar to the note block values.
     */
    interface Note extends ParticleType {

        /**
         * Gets the default note value of this particle.
         *
         * <p>The value scales between 0 and 24.</p>
         *
         * @return The default note
         */
        float getDefaultNote();

    }

    /**
     * Represents a particle that utilizes a item stack to be
     * able to render on the client.
     */
    interface Material extends ParticleType {

        /**
         * Gets the default item type of this particle.
         *
         * @return The item type
         */
        ItemStack getDefaultItem();

    }

}
