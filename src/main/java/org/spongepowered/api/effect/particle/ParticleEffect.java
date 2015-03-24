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

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.item.inventory.ItemStack;

import java.awt.Color;

/**
 * Represents a particle effect that can be send to the Minecraft client.
 */
public interface ParticleEffect {

    /**
     * Gets the type of the particle effect.
     *
     * @return The particle type
     */
    ParticleType getType();

    /**
     * Gets the motion vector of the particle effect.
     *
     * @return The motion vector
     */
    Vector3d getMotion();

    /**
     * Gets the offset vector of the particle effect.
     *
     * @return The offset vector
     */
    Vector3d getOffset();

    /**
     * Gets the amount of particles that will be spawned.
     *
     * @return The count of particles
     */
    int getCount();

    /**
     * Represents a colored particle effect.
     */
    interface Colorable extends ParticleEffect {

        /**
         * Gets the color of the particle effect.
         *
         * @return The color
         */
        Color getColor();

    }

    /**
     * Represents a resized particle effect.
     */
    interface Resizable extends ParticleEffect {

        /**
         * Gets the size of the particle effect.
         *
         * @return The size
         */
        float getSize();

    }

    /**
     * Represents a particle effect that uses a note value.
     */
    interface Note extends ParticleEffect {

        /**
         * Gets the note value of the particle effect.
         *
         * <p>The value scales between 0 and 24.</p>
         *
         * @return The note value
         */
        float getNote();

    }

    /**
     * Represents a particle effect that needs a item stack to be rendered on the client.
     */
    interface Material extends ParticleEffect {

        /**
         * Gets the item stack of the particle effect.
         *
         * @return The item stack
         */
        ItemStack getItem();

    }

}
