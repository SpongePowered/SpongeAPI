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

import java.awt.Color;

import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.ItemStack;

import com.flowpowered.math.vector.Vector3f;

public interface ParticleEffectBuilder {

    /**
     * Sets the motion vector of the particle effect.
     * 
     * @param motion The motion vector
     * @return This builder
     */
    ParticleEffectBuilder motion(Vector3f motion);

    /**
     * Sets the offset vector of the particle effect.
     * 
     * @param offset The offset vector
     * @return This builder
     */
    ParticleEffectBuilder offset(Vector3f offset);

    /**
     * Sets the amount of particles of the particle effect.
     * 
     * @param count The count particles
     * @return This builder
     */
    ParticleEffectBuilder count(int count);

    /**
     * Builds an instance of a ParticleEffect.
     *
     * @return A new instance of a ParticleEffect
     */
    ParticleEffect build();

    /**
     * Represents a particle that can be colored.
     */
    interface Colorable extends ParticleEffectBuilder {

        /**
         * Sets the color of the particle effect.
         * 
         * @param color The color
         * @return This builder
         */
        Colorable color(Color color);

        @Override
        Colorable motion(Vector3f motion);

        @Override
        Colorable offset(Vector3f offset);

        @Override
        Colorable count(int count);

        @Override
        ParticleEffect.Colorable build() throws IllegalStateException;

    }

    /**
     * Represents a particle effect that can be resized.
     */
    interface Resizable extends ParticleEffectBuilder {

        /**
         * Sets the size of the particle effect.
         * 
         * @param size The size
         * @return This builder
         */
        Resizable size(float size);

        @Override
        Resizable motion(Vector3f motion);

        @Override
        Resizable offset(Vector3f offset);

        @Override
        Resizable count(int count);

        @Override
        ParticleEffect.Resizable build() throws IllegalStateException;

    }

    /**
     * Represents a particle effect that uses a note value.
     */
    interface Note extends ParticleEffectBuilder {

        /**
         * Sets the note value of the particle effect.
         * 
         * <p>The value scales between 0 and 24</p>
         * 
         * @param note The note
         * @return This builder
         */
        Note note(float note);

        @Override
        Note motion(Vector3f motion);

        @Override
        Note offset(Vector3f offset);

        @Override
        Note count(int count);

        @Override
        ParticleEffect.Note build() throws IllegalStateException;

    }

    /**
     * Represents a particle effect that utilizes a item stack to be
     * able to render on the client.
     */
    interface Material extends ParticleEffectBuilder {

        /**
         * Sets the item stack of the particle effect.
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
        Material motion(Vector3f motion);

        @Override
        Material offset(Vector3f offset);

        @Override
        Material count(int count);

        @Override
        ParticleEffect.Material build() throws IllegalStateException;

    }

}
