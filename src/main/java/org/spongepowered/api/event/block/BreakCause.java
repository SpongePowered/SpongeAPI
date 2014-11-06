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
package org.spongepowered.api.event.block;

import org.spongepowered.api.event.cause.Cause;

/**
 * Block break cause.
 */
public interface BreakCause extends Cause {
    
    /**
     * Gets name of this block break cause.
     * @return
     */
    String getName();
    
    /**
     * Checks is the block break cause Unknown, which means that it is probably
     * created by mods.
     * @return true if the break cause is unknown, false otherwise
     */
    boolean isUnknown();
    
    /**
     * Explosion broke the block.
     */
    interface Explosion extends BreakCause {
        //TODO: Support explosions
    }
    
    /**
     * Entity, usually player, enderman or sheep (eating grass...) broke the block.
     * Creepers are handled using Explosion cause.
     */
    interface Entity extends BreakCause {
        /**
         * Gets entity who tried to broke the block.
         * @return Entity breaking block
         */
        Entity getEntity();
    }
    
    /**
     * Block was broken by another block, usually happens when sponge and water
     * touches.
     */
    interface Block extends BreakCause {
        /**
         * Gets block which tried to broke other block.
         */
        Block getBreaker();
    }
    
    /**
     * Fluid was destroyed because fluid source block was removed.
     */
    interface SourceRemoved extends BreakCause {
        //TODO: Way to get this... Must consider.
    }
    
    /**
     * Block was destroyed by natural decay. This usually happens only 
     * to leaves when they are not touching wood blocks.
     */
    interface Decay extends BreakCause {
        
    }
    
    /**
     * Something tried to broke the block. Mods may create this kind of causes,
     * if they don't support Sponge.
     */
    interface Unknown extends BreakCause {
        //TODO: Even way to get this may be needed
    }
}
