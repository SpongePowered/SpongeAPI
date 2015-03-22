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
package org.spongepowered.api.item.data;

/**
 * Represents an item that has limited number of uses.
 *
 * <p>Usually, items with durability will break and disappear when their
 * durability reaches the maximum. Examples of this include pickaxes,
 * axes, swords, and shovels. It is recommended to retrieve the maximum
 * durability limit from the
 * {@link org.spongepowered.api.item.properties.UseLimitProperty}.</p>
 */
public interface DurabilityData extends ItemData<DurabilityData> {

    /**
     * Gets the durability of the item.
     *
     * <p>The durability is a number signifying how many "uses' remain on
     * the item. When the durability reaches 0, usually, the item breaks.</p>
     *
     * @return The durability
     */
    int getDurability();

    /**
     * Sets the durability of the item.
     *
     * <p>The durability is a number signifying how many "uses' remain on
     * the item. When the durability reaches their maximum, usually, the item
     * breaks.</p>
     *
     * @param durability The durability
     */
    void setDurability(int durability);

    /**
     * Sets whether this durable item is breakable or not.
     *
     * <p>When an item is unbreakable, it can not be damaged, and
     * does not reduce in durability.</p>
     *
     * @return Whether the item is breakable or not
     */
    boolean isBreakable();

    /**
     * Sets whether this durable item is breakable or not.
     *
     * <p>When an item is unbreakable, it can not be damaged, and
     * does not reduce in durability.</p>
     *
     * @param breakable Whether the item is breakable or not
     */
    void setBreakable(boolean breakable);
}
