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

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

/**
 * Represents a particle effect that needs a item stack to be rendered on the client.
 */
public interface ItemParticle extends ParticleEffect {

    /**
     * Gets the item stack of the particle effect.
     *
     * @return The item stack
     */
    ItemStackSnapshot getItem();

    /**
     * Represents a particle builder to create a {@link ItemParticle}.
     */
    interface Builder extends ParticleEffect.Builder {

        /**
         * Sets the item type of the particle effect.
         *
         * @param item The item type
         * @return This builder
         */
        Builder item(ItemStackSnapshot item);

        @Override
        Builder type(ParticleType particleType);

        @Override
        Builder motion(Vector3d motion);

        @Override
        Builder offset(Vector3d offset);

        @Override
        Builder count(int count);

        @Override
        ItemParticle build();

        @Override
        Builder reset();

    }
}
