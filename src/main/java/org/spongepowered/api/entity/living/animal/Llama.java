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
package org.spongepowered.api.entity.living.animal;

import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.LlamaType;
import org.spongepowered.api.data.value.BoundedValue;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.projectile.ProjectileLauncher;

/**
 * Represents a Llama in the base game. Llamas are unique in that
 * they can be ridden by players, but not controlled by players. Likewise, they
 * have colors and styles and can have storage "strength".
 */
public interface Llama extends Horse, ProjectileLauncher {

    /**
     * Gets the {@link org.spongepowered.api.data.value.Value.Mutable}} for the {@link LlamaType} of this
     * {@link Llama}.
     *
     * @return The llama type
     */
    default Value.Mutable<LlamaType> type() {
        return this.getValue(Keys.LLAMA_TYPE).get().asMutable();
    }

    /**
     * Gets the {@link org.spongepowered.api.data.value.Value.Mutable}} for the {@link Keys#LLAMA_STRENGTH llama strength}
     * when attacking.
     *
     * @return The strength value of the llama
     */
    default BoundedValue.Mutable<Integer> strength() {
        return this.getValue(Keys.LLAMA_STRENGTH).get().asMutable();
    }
}
