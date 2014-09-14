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

package org.spongepowered.api.block;

import javax.annotation.Nullable;
import java.util.Set;

/**
 * Describes a voxel. Child classes define specific functionality.
 *
 * The concept of block states were introduced in Minecraft 1.8 to replace
 * metadata. Block states are described with a series of name-value pairs. For
 * this API names are referred to as attributes and values as
 * {@link BlockState}. For every block with the same ID got from
 * {@link #getID()} the set of attributes are the same.
 */
public interface Block {

    /**
     * Gets the id of this block.
     *
     * <p>Ex. Minecraft registers stone as "minecraft:stone"</p>
     *
     * @return The id
     */
    String getID();

    /**
     * Gets the {@link org.spongepowered.api.block.BlockState} of the block.
     * <p/>
     * Ex. "minecraft:stone" block. has a variant block state which determine
     * if it is smooth, granite, smooth_granite, diorite, smooth_diorite,
     * andesite or smooth_andesite.
     * <p/>
     * If there isn't a attribute for this block with the name {@code attribute}
     * then null is returned.
     *
     * @param attribute Name of the attribute being sort
     * @return Block state
     */
    @Nullable
    BlockState getBlockState(String attribute);

    /**
     * Gets all attributes for this block. If {@link Block}'s have the same ID,
     * which is obtained by {@link #getID()} then the set of attributes will be
     * equal.
     * <p/>
     * Suppose {@code a} and {@code b} are instances of {@link Block}
     * if {@code a.getID().equals(b.getID())} then
     * {@code a.getBlockStateAttributes().equals(b.getBlockStateAttributes())}.
     * <p/>
     *
     * @return Set of block state attributes
     */
    Set<String> getBlockStateAtributes();

    /**
     * Create a new block with the same ID and block state
     * apart from the attribute {@code attribute} which is set to {@code value}.
     * <p/>
     * If there is not a attribute {@code attribute} then null is returned.
     *
     * @throws BlockStateTypeException if the attributes type isn't int or is
     *     out of range
     * @param attribute The block state attribute to be changed
     * @param value     The value to be changed to
     * @return A new instance of {@link Block} with value of the block state
     *     attribute is {@code value}
     */
    @Nullable
    Block setBlockState(String attribute,int value);

    /**
     * Create a new block with the same ID and block state
     * apart from the attribute {@code attribute} which is set to {@code value}.
     * <p/>
     * If there is not a attribute {@code attribute} then null is returned.
     *
     * @throws BlockStateTypeException if the attributes type isn't boolean
     * @param attribute The block state attribute to be changed
     * @param value     The value to be changed to
     * @return A new instance of {@link Block} with value of the block state
     *     attribute is {@code value}
     */
    @Nullable
    Block setBlockState(String attribute,boolean value);

    /**
     * Create a new block with the same ID and block state
     * apart from the attribute {@code attribute} which is set to {@code value}.
     * <p/>
     * If there is not a attribute {@code attribute} then null is returned.
     *
     * @throws BlockStateTypeException If the attributes type isn't of the type
     *     of {@code value}
     * @param attribute The block state attribute to be changed
     * @param value     The value to be changed to
     * @return A new instance of {@link Block} with value of the block state
     * attribute is {@code value}
     */
    @Nullable
    Block setBlockState(String attribute,Object value);
}
