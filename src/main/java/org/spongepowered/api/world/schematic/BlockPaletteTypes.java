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

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

/**
 * An enumeration of known {@link BlockPaletteType}s.
 * @deprecated Use {@link PaletteTypes}.
 */
@Deprecated
public class BlockPaletteTypes {

    /**
     * The global palette containing a mapping of all block states to ids.
     * @deprecated See {@link PaletteTypes#GLOBAL_BLOCKS}
     */
    @Deprecated
    public static final BlockPaletteType GLOBAL = DummyObjectProvider.createFor(BlockPaletteType.class, "GLOBAL");
    /**
     * A local palette containing only a subset of the global palette.
     * @deprecated See {@link PaletteTypes#LOCAL_BLOCKS}
     */
    @Deprecated
    public static final BlockPaletteType LOCAL = DummyObjectProvider.createFor(BlockPaletteType.class, "LOCAL");

    // Suppress default constructor to ensure non-instantiability.
    private BlockPaletteTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
