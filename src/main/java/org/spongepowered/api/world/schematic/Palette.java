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

import org.spongepowered.api.block.BlockState;

import java.util.Collection;
import java.util.Optional;

/**
 * Represents a mapping for blockstates to a local identifier.
 */
public interface Palette {

    /**
     * Gets the type of this palette.
     * 
     * @return The palette type
     */
    PaletteType getType();

    /**
     * Gets the highest identifier in this palette.
     * 
     * @return The highest id
     */
    int getHighestId();

    /**
     * Gets the identifier for the given blockstate if it exists within the
     * mapping.
     * 
     * @param state The block state
     * @return The identifier, if found
     */
    Optional<Integer> get(BlockState state);

    /**
     * Gets the identifier for the given blockstate from the mapping. If the
     * blockstate is not yet registered in the mapping then it is registered and
     * given the next availale identifier.
     * 
     * @param state The blockstate
     * @return The identifier
     */
    int getOrAssign(BlockState state);

    /**
     * Gets the blockstate represented by the given identifier from the mapping.
     * 
     * @param id The identifier
     * @return The blockstate, if found
     */
    Optional<BlockState> get(int id);

    /**
     * Removes the given blockstate from the mapping.
     * 
     * @param state The blockstate to remove
     * @return If the blockstate existed in the mapping
     */
    boolean remove(BlockState state);

    /**
     * Gets all {@link BlockState}s contained in this palette.
     * 
     * @return All contained block states
     */
    Collection<BlockState> getEntries();

}
