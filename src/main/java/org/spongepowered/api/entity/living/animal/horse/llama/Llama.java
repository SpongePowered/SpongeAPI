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
package org.spongepowered.api.entity.living.animal.horse.llama;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.type.LlamaType;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.living.animal.horse.PackHorse;
import org.spongepowered.api.entity.living.animal.horse.TameableHorse;

/**
 * Represents a Llama. Llamas are unique in that
 * they can be ridden by players, but not controlled by players. Likewise, they
 * have colors and styles and can have storage "strength".
 */
public interface Llama extends LlamaLike, TameableHorse, PackHorse {

    /**
     * {@link Keys#LLAMA_TYPE}
     *
     * @return The llama type
     * @see org.spongepowered.api.data.type.LlamaTypes
     */
    default Value.Mutable<LlamaType> llamaType() {
        return this.requireValue(Keys.LLAMA_TYPE).asMutable();
    }

    /**
     * {@link Keys#STRENGTH}
     *
     * @return The strength of this llama, determines how big of an inventory they can carry
     */
    default Value.Mutable<Integer> strength() {
        return this.requireValue(Keys.STRENGTH).asMutable();
    }
}
