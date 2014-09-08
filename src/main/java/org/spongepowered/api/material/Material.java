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
package org.spongepowered.api.material;

/**
 * Handler for all materials.
 */
public interface Material {
    /**
     * Gets internal name for material, which is something like minecraft:stone. Or
     * modName:modItem
     * @return internal name of this Material
     */
    public String getName();
    
    /**
     * Gets max durability of items made of this material. If it's block or won't have
     * durability, 0 will returned.
     * @return max durability of item
     */
    public int getMaxDurability();
    
    /**
     * Checks is material a block or item.
     * @return true if this material is a block, false otherwise
     */
    public boolean isBlock();
    
    /**
     * If material is block, checks will it get affected by gravity.
     * @return true if block is affected by gravity, false otherwise
     */
    public boolean hasGravity();
    
    /**
     * Checks can the block catch fire (usually yes)
     * @return true if block can catch fire, false otherwise
     */
    public boolean isFlammable();
    
    /**
     * Checks can the block burned away by fire. Note that netherrack is flammable, but
     * it cannot burned away.
     * @return true if the block can burned away, false otherwise
     */
    public boolean isBurnable();
    
    /**
     * Checks is the block solid (can't passed throught by players)
     * @return true if block is solid
     */
    public boolean isSolid();
    
    /**
     * Checks is block liquid.
     * @return true, if block is liquid
     */
    public boolean isLiquid();
    
    /**
     * Checks is the block transparent (not blocking any vision)
     * @return true if block is transparent, false otherwise
     */
    public boolean isTransparent();
}
