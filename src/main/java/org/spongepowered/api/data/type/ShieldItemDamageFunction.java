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
package org.spongepowered.api.data.type;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.ResettableBuilder;

/**
 * Defines the amount of {@link org.spongepowered.api.data.Keys#ITEM_DURABILITY} damage a shield-like
 * {@link org.spongepowered.api.item.inventory.ItemStack} takes, when blocking an attack.
 */
public interface ShieldItemDamageFunction<T> {

    static ShieldItemDamageFunction<MultiplyAdd> of(MultiplyAdd config) {
        return Sponge.game().factoryProvider().provide(Factory.class).create(config);
    }

    T configuration();

    double resolve(double damage);

    interface Factory {

        ShieldItemDamageFunction<MultiplyAdd> create(MultiplyAdd config);

    }

    /**
     * The final amount of damage will be {@code constantDamage + fractionalDamage * attackDamage}
     */
    interface MultiplyAdd {

        static Builder builder() {
            return Sponge.game().builderProvider().provide(Builder.class);
        }

        /**
         * Returns the minimum amount of damage blocked attack must have had, for the item to take damage at all.
         *
         * @return minimum attack damage required for any durability loss
         */
        double minAttackDamage();

        /**
         * Returns the constant amount of damage taken.
         *
         * @return a constant amount of damage to take
         */
        double constantDamage();

        /**
         * Returns fractional amount of damage to take, where a factor of 1 means that the amount of durability lost is equal to attack damage,
         * and a factor of 0 that no durability is lost.
         *
         * @return fractional amount of damage to take
         */
        double fractionalDamage();

        interface Builder extends ResettableBuilder<MultiplyAdd, Builder> {

            /**
             * Sets the minimum amount of damage blocked attack must have had, for the item to take damage at all.
             *
             * @param minDamage minimum attack damage required for any durability loss
             * @return This builder, for chaining
             */
            Builder minAttackDamage(double minDamage);

            /**
             * Sets the constant amount of damage taken.
             *
             * @param constantDamage a constant amount of damage to take
             * @return This builder, for chaining
             */
            Builder constantDamage(double constantDamage);

            /**
             * Sets fractional amount of damage to take, where a factor of 1 means that the amount of durability lost is equal to attack damage,
             * and a factor of 0 that no durability is lost.
             *
             * @param fractionalDamage fractional amount of damage to take
             * @return This builder, for chaining
             */
            Builder fractionalDamage(double fractionalDamage);

            MultiplyAdd build();

        }

    }

}
