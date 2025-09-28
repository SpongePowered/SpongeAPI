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
import org.spongepowered.api.event.cause.entity.damage.DamageType;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.tag.Tag;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.Set;

/**
 * Defines the amount of damage reduced when blocking with a shield-like {@link org.spongepowered.api.item.inventory.ItemStack}.
 * The final amount of blocked damage will be {@code constantReduction + fractionalReduction * damage}
 */
public interface ShieldDamageReduction {

    double resolve(DamageSource source, double damage, double angle);

    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    interface Builder extends ResettableBuilder<ShieldDamageReduction, Builder> {

        /**
         * Limits the {@link DamageType damage types} this reduction applies to.
         *
         * @param damageTypes the affected damage types
         * @return This builder, for chaining
         */
        Builder damageTypes(Set<DamageType> damageTypes);

        /**
         * Limits the {@link DamageType damage types} this reduction applies to.
         *
         * @param tag the tag defining affected damage types
         * @return This builder, for chaining
         */
        Builder damageTypes(Tag<DamageType> tag);

        /**
         * Sets the maximum angle between the users facing direction and the direction of the incoming attack.
         *
         * @param angle the maximum angle
         * @return This builder, for chaining
         */
        Builder horizontalBlockingAngle(double angle);

        /**
         * Sets the constant amount of damage to be blocked.
         *
         * @param constant a constant amount of damage to block
         * @return This builder, for chaining
         */
        Builder constantReduction(double constant);

        /**
         * Sets fractional amount of damage to block, where a factor of 1 means that all damage is blocked,
         * and a factor of 0 that no damage is blocked.
         *
         * @param fraction fractional amount of damage to block
         * @return This builder, for chaining
         */
        Builder fractionalReduction(double fraction);

        ShieldDamageReduction build();

    }

}
