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
package org.spongepowered.api.entity.living.animal;

import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.living.Ageable;
import org.spongepowered.api.entity.living.animal.cow.Cow;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.util.Ticks;

import java.util.Optional;
import java.util.UUID;

/**
 * Represents an animal, such as a {@link Cow}.
 */
public interface Animal extends Ageable {

    /**
     * {@link Keys#BREEDER}
     *
     * @return The current breeder of the animal
     */
    default Optional<Value.Mutable<UUID>> breeder() {
        return this.getValue(Keys.BREEDER).map(Value::asMutable);
    }

    /**
     * Determines if the {@link ItemStack} is considered to be food by this animal.
     *
     * @param stack The stack
     * @return True if food, false if not
     */
    boolean isFood(ItemStack stack);

    /**
     * Determines if this animal can be bred with the provided animal. In vanilla, two animals can only be breed if they
     * are the same {@link EntityType} and are {@link Keys#IS_ADULT adults}.
     *
     * @param other The animal
     * @return True if can breed with, false if not
     */
    boolean canBreedWith(Animal other);

    /**
     * Instructs this animal to breed with the provided animal.
     *
     * @param animal The animal to breed with
     */
    void breedWith(Animal animal);
}
