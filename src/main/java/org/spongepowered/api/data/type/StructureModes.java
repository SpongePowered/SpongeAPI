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
package org.spongepowered.api.data.type;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * An enumeration of vanilla {@link StructureMode}s.
 */
public final class StructureModes {

    // SORTFIELDS:ON

    /**
     * Corner mode allows for an easier and automatic size calculation while
     * saving or loading structures.
     */
    public static final Supplier<StructureMode> CORNER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(StructureMode.class, "corner");

    /**
     * Data mode can only be used during natural generation.
     *
     * <p>They mark the location to run a function specified by its metadata
     * input, which can only be used for relevant structures.</p>
     *
     * <p>The structure block is removed afterwards.</p>
     *
     * <p>This mode is the default mode when a structure block is first
     * placed.</p>
     */
    public static final Supplier<StructureMode> DATA = Sponge.getRegistry().getCatalogRegistry().provideSupplier(StructureMode.class, "data");

    /**
     * Load mode allows a player to load and rotate saved structure files.
     */
    public static final Supplier<StructureMode> LOAD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(StructureMode.class, "load");

    /**
     * Save mode allows a player to highlight a structure in the world and
     * save it to a file.
     */
    public static final Supplier<StructureMode> SAVE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(StructureMode.class, "save");

    // SORTFIELDS:OFF

    private StructureModes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
