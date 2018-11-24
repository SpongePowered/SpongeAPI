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
package org.spongepowered.api.item.inventory;

import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.event.item.inventory.UpdateAnvilEvent;

/**
 * The level and material costs for an anvil usage.
 */
public interface AnvilCost extends DataSerializable {

    /**
     * Returns the level cost.
     *
     * @return The level cost
     */
    int getLevelCost();

    /**
     * Returns the material cost.
     *
     * @return The material cost
     */
    int getMaterialCost();

    /**
     * Returns a modified copy of the Costs
     *
     * @param levelCost The new level cost
     * @return A modified copy of the Costs
     */
    AnvilCost withLevelCost(int levelCost);

    /**
     * Returns a modified copy of the Costs
     *
     * @param materialCost The new material cost
     * @return A modified copy of the Costs
     */
    AnvilCost withMaterialCost(int materialCost);
}
