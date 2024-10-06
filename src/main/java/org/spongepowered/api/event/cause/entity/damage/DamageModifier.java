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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.enchantment.Enchantment;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.ItemStackLike;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.util.CopyableBuilder;

import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Supplier;

/**
 * Represents a modifier that will apply a function on a damage value to deal
 * towards an entity such that the raw damage is the input of a
 * {@link DoubleUnaryOperator} such that the output will be the final damage
 * applied to the {@link Entity}.
 */
public interface DamageModifier {

    /**
     * Creates a new {@link Builder} for constructing a {@link DamageModifier}.
     *
     * @return A new builder
     */
    static Builder builder() {
        return new Builder();
    }

    /**
     * Gets the {@link DamageModifierType} for this {@link DamageModifier}.
     *
     * @return The damage modifier type
     */
    DamageModifierType type();

    /**
     * Returns the damage modifier group.
     * <p>Grouped modifiers calculate their damage independently from each other</p>
     *
     * @return The damage modifier group
     */
    String group();

    /**
     * Gets the cause of this {@link DamageModifier}.
     *
     * @return The cause of this damage modifier
     */
    Cause cause();

    /**
     * Gets the contributing {@link ItemStackSnapshot} that provided the
     * "reason" for this {@link DamageModifier} to exist. An example of a
     * contributing {@link ItemStack} is if an {@link ItemTypes#DIAMOND_SWORD}
     * provided an {@link Enchantment} that provided a
     * {@link DamageModifierTypes#WEAPON_ENCHANTMENT}, this modifier would have
     * the {@link ItemStackSnapshot} for the weapon used. Some modifiers however,
     * do not require an {@link ItemStack} to be the contributing factor for
     * this modifier to exist.
     *
     * @return The contributing item, if available
     */
    Optional<ItemStackSnapshot> contributingItem();

    /**
     * A builder that creates {@link DamageModifier}s, for use in both plugin and
     * implementation requirements.
     */
    final class Builder implements org.spongepowered.api.util.Builder<DamageModifier, Builder>, CopyableBuilder<DamageModifier, Builder> {

        @Nullable DamageModifierType type;
        @Nullable Cause cause;
        @Nullable String group;
        @Nullable ItemStackSnapshot snapshot;

        Builder() {
        }


        /**
         * Sets the {@link DamageModifierType} for the {@link DamageModifier} to
         * build.
         *
         * @param damageModifierType The damage modifier type
         * @return This builder, for chaining
         */
        public Builder type(final Supplier<? extends DamageModifierType> damageModifierType) {
            return this.type(damageModifierType.get());
        }

        /**
         * Sets the {@link DamageModifierType} for the {@link DamageModifier} to
         * build.
         *
         * @param damageModifierType The damage modifier type
         * @return This builder, for chaining
         */
        public Builder type(final DamageModifierType damageModifierType) {
            this.type = java.util.Objects.requireNonNull(damageModifierType);
            return this;
        }

        /**
         * The main attack damage calculated for an {@link org.spongepowered.api.event.entity.AttackEntityEvent}
         *
         * @return This builder, for chaining
         */
        public Builder attackDamageGroup() {
            return this.group("minecraft:attack_damage");
        }

        /**
         * The enchantment attack damage calculated for an {@link org.spongepowered.api.event.entity.AttackEntityEvent}
         *
         * @return This builder, for chaining
         */
        public Builder attackEnchantmentGroup() {
            return this.group("minecraft:attack_enchantment");
        }

        /**
         * The damage calculated for an {@link org.spongepowered.api.event.entity.DamageEntityEvent}
         *
         * @return This builder, for chaining
         */
        public Builder damageReductionGroup() {
            return this.group("minecraft:damage_reduction");
        }

        public Builder group(final String group) {
            this.group = group;
            return this;
        }

        public Builder item(final ItemStackLike item) {
            this.snapshot = java.util.Objects.requireNonNull(item, "item").asImmutable();
            return this;
        }

        /**
         * Sets the {@link Cause} for the {@link DamageModifier} to build.
         *
         * @param cause The cause for the damage modifier
         * @return This builder, for chaining
         */
        public Builder cause(final Cause cause) {
            this.cause = java.util.Objects.requireNonNull(cause);
            return this;
        }

        /**
         * Creates a new {@link DamageModifier} with this builder's provided
         * {@link Cause} and {@link DamageModifierType}.
         *
         * @return The newly created damage modifier
         */
        @Override
        public DamageModifier build() {
            if (this.type == null) {
                throw new IllegalStateException("The DamageModifierType must not be null!");
            }
            if (this.cause == null) {
                throw new IllegalStateException("The cause for the DamageModifier must not be null!");
            }
            return new ImplementedDamageModifier(this);
        }

        @Override
        public Builder from(final DamageModifier value) {
            this.type = value.type();
            this.cause = value.cause();
            this.snapshot = value.contributingItem().orElse(null);
            return this;
        }

        @Override
        public Builder reset() {
            this.type = null;
            this.cause = null;
            return this;
        }


        private static class ImplementedDamageModifier implements DamageModifier {
            private final DamageModifierType type;
            private final Cause cause;
            @Nullable private final ItemStackSnapshot snapshot;
            private final String group;

            ImplementedDamageModifier(final Builder builder) {
                this.type = java.util.Objects.requireNonNull(builder.type, "DamageType is null!");
                this.cause = java.util.Objects.requireNonNull(builder.cause, "Cause is null!");
                this.group = java.util.Objects.requireNonNull(builder.group, "Group is null!");
                this.snapshot = builder.snapshot;
            }

            @Override
            public DamageModifierType type() {
                return this.type;
            }

            @Override
            public Cause cause() {
                return this.cause;
            }

            @Override
            public Optional<ItemStackSnapshot> contributingItem() {
                return Optional.ofNullable(this.snapshot);
            }

            @Override
            public String group() {
                return group;
            }

            @Override
            public int hashCode() {
                return Objects.hash(this.type, this.cause);
            }

            @Override
            public boolean equals(final Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || this.getClass() != obj.getClass()) {
                    return false;
                }
                final ImplementedDamageModifier other = (ImplementedDamageModifier) obj;
                return Objects.equals(this.type, other.type)
                       && Objects.equals(this.cause, other.cause)
                       && Objects.equals(this.snapshot, other.snapshot);
            }

            @Override
            public String toString() {
                return new StringJoiner(", ", "DamageModifier[", "]")
                    .add("type=" + this.type)
                    .add("cause=" + this.cause)
                    .add("snapshot=" + this.snapshot)
                    .toString();
            }
        }

    }
}
