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
package org.spongepowered.api.event.cause.block;

import org.spongepowered.api.block.Block;

/**
 * Block place cause.
 */
public interface PlaceCause extends BlockCause {
    
    /**
     * Entity (usually player) placed the block. Enderdragon's death doesn't
     * count, as it technically does not create the return portal.
     */
    interface Entity extends PlaceCause {
        /**
         * Gets entity which placed this block.
         * @return Entity which placed this block
         */
        Entity getEntity();
    }
    
    /**
     * Plant was grown and created new block(s). Trees are also considered as
     * plants.
     */
    interface PlantGrow extends PlaceCause {
        /**
         * Gets sapling which grew the new plant.
         * @return Sapling of plant
         */
        Block getSapling();
    }
    
    /**
     * Block was spawned as part of some structure. World gen structures won't
     * count, only structures, which spawn when something happens is loaded
     * chunks count. In vanilla, the only example is enderdragon's death.
     */
    interface Spawn extends PlaceCause {
        //TODO: When chunk events are implemented, add spawn causes.
    }
}
