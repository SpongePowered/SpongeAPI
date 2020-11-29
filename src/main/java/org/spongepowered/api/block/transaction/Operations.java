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
package org.spongepowered.api.block.transaction;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

public final class Operations {
    /**
     * An {@link Operation} that signifies a {@link org.spongepowered.api.block.BlockState block} is either:
     * <ul>
     *     <li>Replacing {@link org.spongepowered.api.block.BlockTypes#AIR an air} block</li>
     *     <li>A {@link org.spongepowered.api.block.BlockState} that is replaceable when moved, or an
     *     {@link org.spongepowered.api.item.inventory.ItemStack} can replace it</li>
     * </ul>
     */
    public static final Supplier<Operation> PLACE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Operation.class, "place");
    /**
     * An {@link Operation} that signifies a non {@link org.spongepowered.api.block.BlockTypes#AIR air block} being
     * broken and replaced with {@link org.spongepowered.api.block.BlockTypes#AIR an air block}.
     */
    public static final Supplier<Operation> BREAK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Operation.class, "break");
    /**
     * An {@link Operation} that signifies the block change is particularly discernible as though the
     * {@link org.spongepowered.api.block.BlockState} may be different but the
     * {@link org.spongepowered.api.block.BlockType} may be the same. Or a congruency of changes that
     * result to a "similar enough" change that the blocks share a very unique common trait.
     */
    public static final Supplier<Operation> MODIFY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Operation.class, "modify");
    /**
     * An {@link Operation} that is considered specially during a plant based block to change into
     * potentially more blocks, occasionally either a combination of {@link #PLACE} and {@link #MODIFY}
     * but likewise commonly shared as a "root" plant or some kind.
     */
    public static final Supplier<Operation> GROWTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Operation.class, "growth");

    public static final Supplier<Operation> DECAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Operation.class, "decay");
    public static final Supplier<Operation> LIQUID_SPREAD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Operation.class, "liquid_spread");
    public static final Supplier<Operation> LIQUID_DECAY = Sponge.getRegistry().getCatalogRegistry().provideSupplier(Operation.class, "liquid_decay");

    private Operations() {}
}
