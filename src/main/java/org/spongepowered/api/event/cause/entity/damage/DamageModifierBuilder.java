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
package org.spongepowered.api.event.cause.entity.damage;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.event.cause.entity.damage.source.FallingBlockDamageSource;
import org.spongepowered.api.item.Enchantment;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.potion.PotionEffect;
import org.spongepowered.api.potion.PotionEffectTypes;

/**
 * An index of known vanilla {@link DamageModifier}s that can be applied by
 * an {@link Entity}.
 */
public final class DamageModifierBuilder {

    private DamageModifierType type;
    private Cause cause;

    private DamageModifierBuilder() {
    }

    public static DamageModifierBuilder createBuilder() {
        return new DamageModifierBuilder();
    }

    public DamageModifierBuilder type(DamageModifierType damageModifierType) {
        this.type = checkNotNull(damageModifierType);
        return this;
    }

    public DamageModifierBuilder cause(Cause cause) {
        this.cause = checkNotNull(cause);
        return this;
    }

    public DamageModifier build() {
        checkState(this.type != null, "The DamageModifierType must not be null!");
        checkState(this.cause != null, "The cause for the DamageModifier must not be null!");
        return new ImplementedDamageModifier(this);
    }


    private static class ImplementedDamageModifier implements DamageModifier {
        private final DamageModifierType type;
        private final Cause cause;

        private ImplementedDamageModifier(DamageModifierBuilder builder) {
            this.type = builder.type;
            this.cause = builder.cause;
        }

        @Override
        public DamageModifierType getType() {
            return this.type;
        }

        @Override
        public Cause getCause() {
            return this.cause;
        }
    }

}
