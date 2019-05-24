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
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.state.StateContainer;
import org.spongepowered.api.state.StateProperty;
import org.spongepowered.api.data.property.PropertyHolder;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Optional;

/**
 * Describes a base type of block.
 *
 * <p>Blocks are further differentiated using a {@link BlockState}. Complex
 * data, such as inventory contents, are considered data, which is provided
 * via {@link BlockEntity}.</p>
 */
@CatalogedBy(BlockTypes.class)
public interface BlockType extends CatalogType, StateContainer<BlockState>, Translatable, PropertyHolder {

    /**
     * Return the {@link ItemType} that represents this block.
     * @return The item type or {@link Optional#empty()} otherwise
     */
    Optional<ItemType> getItem();

    /**
     * Gets if this BlockType is set to receive random block ticks.
     *
     * <p>Random block updates are most commonly used for growth of plants.</p>
     *
     * @return If the BlockType updates randomly
     */
    boolean doesUpdateRandomly();

    /**
     * Sets if the BlockType should receive random block updates.
     *
     * <p>Random block updates are most commonly used for growth of plants.</p>
     *
     * @param updateRandomly If the BlockType should update randomly
     */
    void setUpdateRandomly(boolean updateRandomly);

    /**
     * Gets the {@link BlockSoundGroup} for this block.
     *
     * @return This block's sound group.
     */
    BlockSoundGroup getSoundGroup();

    /**
     * Attempts to retrieve the {@link StateProperty} instance associated with
     * this {@link BlockState}s {@link BlockType} by string id. If there is no
     * {@link StateProperty} available, {@link Optional#empty()} is returned.
     *
     * @param property The property id
     * @return The property, if available
     */
    Optional<StateProperty<?>> getProperty(String property);
}
