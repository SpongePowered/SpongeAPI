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
package org.spongepowered.api.block;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.block.trait.BlockTrait;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.property.PropertyHolder;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Collection;
import java.util.Optional;

/**
 * Describes a base type of block.
 *
 * <p>Blocks are further differentiated using a {@link BlockState}. Complex
 * data, such as inventory contents, are considered data, which is provided
 * via {@link DataHolder}.</p>
 */
@CatalogedBy(BlockTypes.class)
public interface BlockType extends CatalogType, Translatable, PropertyHolder {

    /**
     * Return the internal ID for the block.
     *
     * <p>The format of the internal ID may vary between implementations
     * but in Minecraft, it follows the format of {@code domain:type}, an
     * example being {@code minecraft:stone}.</p>
     *
     * @return The id
     */
    @Override
    String getName();

    /**
     * Return the default state for this block.
     *
     * @return The default state
     */
    BlockState getDefaultState();

    /**
     * Gets a {@link Collection} of all {@link BlockState}s for this
     * {@link BlockType}.
     *
     * @return An immutable collection of all block states for this block type
     */
    Collection<BlockState> getAllBlockStates();

    /**
     * Return the {@link ItemType} that represents this block.
     * @return The item type or {@link Optional#empty()} otherwise
     */
    Optional<ItemType> getItem();

    /**
     * Gets if this BlockType is set to receive random block ticks.
     *
     * <p>Random block ticks are most commonly used for growth of plants.</p>
     *
     * @return If the BlockType ticks randomly.
     */
    boolean getTickRandomly();

    /**
     * Sets if the BlockType should receive random block ticks.
     *
     * <p>Random block ticks are most commonly used for growth of plants.</p>
     *
     * @param tickRandomly If the BlockType should tick randomly.
     */
    void setTickRandomly(boolean tickRandomly);

    /**
     * Gets an immutable {@link Collection} of all applicable
     * {@link BlockTrait}s for this {@link BlockType}.
     *
     * @return An immutable collection of all applicable block traits
     */
    Collection<BlockTrait<?>> getTraits();

    /**
     * Attempts to retrieve the {@link BlockTrait} instance associated with
     * this {@link BlockState}s {@link BlockType} by string id. If there is no
     * {@link BlockTrait} available, {@link Optional#empty()} is returned.
     *
     * @param blockTrait The block trait id
     * @return The block trait, if available
     */
    Optional<BlockTrait<?>> getTrait(String blockTrait);

    /**
     * Gets the {@link BlockSoundGroup} for this block.
     *
     * @return This block's sound group.
     */
    BlockSoundGroup getSoundGroup();
}
