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

import com.google.common.base.Objects;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.util.ResettableBuilder;

import java.util.function.Function;

/**
 * Represents a modifier that will apply a function on a damage value to
 * deal towards an entity such that the raw damage is the input of a
 * {@link Function} such that the output will be the final damage applied
 * to the {@link Entity}.
 */
public interface DamageModifier {

    static Builder builder() {
        return new Builder();
    }

    /**
     * Gets the {@link DamageModifierType} for this {@link DamageModifier}.
     *
     * @return The damage modifier type
     */
    DamageModifierType getType();

    /**
     * Gets the cause of this {@link DamageModifier}.
     *
     * @return The cause of this damage modifier
     */
    Cause getCause();

    /**
     * A builder that creates {@link DamageModifier}s, for use in both plugin and
     * implementation requirements.
     */
    final class Builder implements ResettableBuilder<DamageModifier, Builder> {

        DamageModifierType type;
        Cause cause;

        Builder() {
        }


        /**
         * Sets the {@link DamageModifierType} for the {@link DamageModifier} to
         * build.
         *
         * @param damageModifierType The damage modifier type
         * @return This builder, for chaining
         */
        public Builder type(DamageModifierType damageModifierType) {
            this.type = checkNotNull(damageModifierType);
            return this;
        }

        /**
         * Sets the {@link Cause} for the {@link DamageModifier} to build.
         *
         * @param cause The cause for the damage modifier
         * @return This builder, for chaining
         */
        public Builder cause(Cause cause) {
            this.cause = checkNotNull(cause);
            return this;
        }

        /**
         * Creates a new {@link DamageModifier} with this builder's provided
         * {@link Cause} and {@link DamageModifierType}.
         *
         * @return The newly created damage modifier
         */
        public DamageModifier build() {
            checkState(this.type != null, "The DamageModifierType must not be null!");
            checkState(this.cause != null, "The cause for the DamageModifier must not be null!");
            return new ImplementedDamageModifier(this);
        }

        @Override
        public Builder from(DamageModifier value) {
            this.type = value.getType();
            this.cause = value.getCause();
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

            ImplementedDamageModifier(Builder builder) {
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

            @Override
            public int hashCode(){
                    return Objects.hashCode(this.type, this.cause);
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                final ImplementedDamageModifier other = (ImplementedDamageModifier) obj;
                return Objects.equal(this.type, other.type)
                       && Objects.equal(this.cause, other.cause);
            }

            @Override
            public String toString() {
                return Objects.toStringHelper("DamageModifier")
                    .add("type", this.type)
                    .add("cause", this.cause)
                    .toString();
            }
        }

    }
}
