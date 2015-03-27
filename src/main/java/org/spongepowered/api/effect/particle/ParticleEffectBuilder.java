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
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;

import java.awt.Color;

/**
 * Represents a builder to create a {@link ParticleEffect}.
 */
public interface ParticleEffectBuilder {

    /**
     * Sets the motion vector of the particle effect.
     *
     * <p>The default motion vector is {@link Vector3d#ZERO}.</p>
     *
     * @param motion The motion vector
     * @return This builder
     */
    ParticleEffectBuilder motion(Vector3d motion);

    /**
     * Sets the offset vector of the particle effect.
     *
     * <p>The default offset vector is {@link Vector3d#ZERO}.</p>
     *
     * @param offset The offset vector
     * @return This builder
     */
    ParticleEffectBuilder offset(Vector3d offset);

    /**
     * Sets the amount of particles of the particle effect.
     *
     * <p>The default count is 1.</p>
     *
     * @param count The count particles
     * @return This builder
     * @throws IllegalArgumentException If the count is less than one
     */
    ParticleEffectBuilder count(int count) throws IllegalArgumentException;

    /**
     * Builds an instance of a ParticleEffect.
     *
     * @return A new instance of a ParticleEffect
     */
    ParticleEffect build();

    /**
     * Represents a particle builder to create a {@link ParticleEffect.Colorable}.
     */
    interface Colorable extends ParticleEffectBuilder {

        /**
         * Sets the color of the particle effect.
         *
         * <p>The default color is retrieved from the colorable particle type,
         * by using {@link ParticleType.Colorable#getDefaultColor()}.</p>
         *
         * @param color The color
         * @return This builder
         */
        Colorable color(Color color);

        @Override
        Colorable motion(Vector3d motion);

        @Override
        Colorable offset(Vector3d offset);

        @Override
        Colorable count(int count);

        @Override
        ParticleEffect.Colorable build();

    }

    /**
     * Represents a particle builder to create a {@link ParticleEffect.Resizable}.
     */
    interface Resizable extends ParticleEffectBuilder {

        /**
         * Sets the size of the particle effect.
         *
         * <p>The default size is retrieved from the resizable particle type,
         * by using {@link ParticleType.Resizable#getDefaultSize()}.</p>
         *
         * @param size The size
         * @return This builder
         */
        Resizable size(float size);

        @Override
        Resizable motion(Vector3d motion);

        @Override
        Resizable offset(Vector3d offset);

        @Override
        Resizable count(int count);

        @Override
        ParticleEffect.Resizable build();

    }

    /**
     * Represents a particle builder to create a {@link ParticleEffect.Note}.
     */
    interface Note extends ParticleEffectBuilder {

        /**
         * Sets the note value of the particle effect.
         *
         * <p>The value scales between 0 and 24.</p>
         * <p>The default note value is retrieved from the note particle type,
         * by using {@link ParticleType.Note#getDefaultNote()}.</p>
         *
         * @param note The note
         * @return This builder
         */
        Note note(float note);

        @Override
        Note motion(Vector3d motion);

        @Override
        Note offset(Vector3d offset);

        @Override
        Note count(int count);

        @Override
        ParticleEffect.Note build();

    }

    /**
     * Represents a particle builder to create a {@link ParticleEffect.Material}.
     */
    interface Material extends ParticleEffectBuilder {

        /**
         * Sets the item stack of the particle effect.
         *
         * <p>The default item stack is retrieved from the note particle type,
         * by using {@link ParticleType.Material#getDefaultItem()}.</p>
         *
         * @param item The item stack
         * @return This builder
         */
        Material item(ItemStack item);

        /**
         * Sets the item type of the particle effect.
         *
         * @param item The item type
         * @return This builder
         */
        Material itemType(ItemType item);

        @Override
        Material motion(Vector3d motion);

        @Override
        Material offset(Vector3d offset);

        @Override
        Material count(int count);

        @Override
        ParticleEffect.Material build();

    }

}
