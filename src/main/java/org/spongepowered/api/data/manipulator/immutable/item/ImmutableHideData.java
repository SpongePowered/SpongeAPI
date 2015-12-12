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
package org.spongepowered.api.data.manipulator.immutable.item;

import org.spongepowered.api.data.manipulator.ImmutableDataManipulator;
import org.spongepowered.api.data.manipulator.mutable.item.HideData;
import org.spongepowered.api.data.value.immutable.ImmutableValue;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * An {@link ImmutableDataManipulator} handling the hidden state of various pieces of information
 * attached to an {@link ItemStack}.
 */
public interface ImmutableHideData extends ImmutableDataManipulator<ImmutableHideData, HideData> {

    /**
     * Gets the {@link ImmutableValue} for the "enchantments hidden" state of an itemstack.
     *
     * @return The immutable value for the enchantments hidden state
     */
    ImmutableValue<Boolean> hideEnchantments();

    /**
     * Gets the {@link ImmutableValue} for the "attributes hidden" state of an itemstack.
     *
     * @return The immutable value for the attributes hidden state
     */
    ImmutableValue<Boolean> hideAttributes();

    /**
     * Gets the {@link ImmutableValue} for the "unbreakable hidden" state of an itemstack.
     *
     * @return The immutable value for the unbreakable hidden state
     */
    ImmutableValue<Boolean> hideUnbreakable();

    /**
     * Gets the {@link ImmutableValue} for the "can destroy hidden" state of an itemstack.
     *
     * @return The immutable value for the can destroy hidden state
     */
    ImmutableValue<Boolean> hideCanDestroy();

    /**
     * Gets the {@link ImmutableValue} for the "can destroy hidden" state of an itemstack.
     *
     * @return The immutable value for the can place hidden state
     */
    ImmutableValue<Boolean> hideCanPlace();

    /**
     * Gets the {@link ImmutableValue} for the "miscellaneous hidden" state of an itemstack.
     *
     * @return The immutable value for the miscellaneous hidden state
     */
    ImmutableValue<Boolean> hideMiscellaneous();

}
