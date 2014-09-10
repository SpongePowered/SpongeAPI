/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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
package org.spongepowered.api.item;

/**
 * an abstract class for defining names of items, for identification purposes
 *
 */
public abstract class ItemID {
    // the name of the "mod" from which this item comes, ie: "minecraft"
    private final String implName;

    // the name of the item inside the "mod", ie: "golden_carrot"
    private final String itemName;

    /**
     * @param impl
     *            the name of the mod
     * @param item
     *            the name of the item
     */
    public ItemID(String impl, String item) {
        implName = impl;
        itemName = item;
    }

    /**
     * @return the implName
     */
    public String getImplName() {
        return implName;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    @Override
    public final String toString() {
        return implName + ":" + itemName;
    }

    @Override
    public final int hashCode() {
        return implName.hashCode() ^ itemName.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ItemID) {
            ItemID o = (ItemID) other;
            return o.getImplName().equals(getImplName())
                && o.getItemName().equals(getItemName());
        }
        return false;
    }
}
