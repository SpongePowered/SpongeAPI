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
package org.spongepowered.api.item.inventory.property;

import org.spongepowered.api.block.BlockTypes;
import org.spongepowered.api.data.Property;
import org.spongepowered.api.entity.EntityTypes;
import org.spongepowered.api.item.inventory.Carrier;
import org.spongepowered.api.item.inventory.Container;
import org.spongepowered.api.item.inventory.ItemStack;

/**
 * Once the {@link Container} with this Property is closed all contained {@link ItemStack}s
 * are returned to the specified Carrier or if {@code null} dropped on the ground.
 *
 * Default Property of {@link BlockTypes#CRAFTING_TABLE}, {@link BlockTypes#ANVIL},
 * {@link BlockTypes#ENCHANTING_TABLE}, {@link EntityTypes#VILLAGER}, the players crafting grid.
 */
// TODO-feature/custominventory remove? was supposed to be what workbenches etc. do in vanilla
public class ReturningItemProperty extends AbstractInventoryProperty<String, Carrier>{

    public ReturningItemProperty(Carrier carrier) {
        super(carrier);
    }

    @Override
    public int compareTo(Property<?, ?> other) {
        if (other == null) {
            return 1;
        }

        return 0; // TODO how to compare carriers?
    }
}
