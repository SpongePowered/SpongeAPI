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
package org.spongepowered.api.util;

import java.util.Random;

/**
 * Represents a value which may vary randomly.
 */
public abstract class VariableAmount {

    /**
     * Creates a new 'fixed' variable amount, calls to {@link #getAmount} will
     * always return the fixed value.
     * 
     * @param value The fixed value
     * @return A variable amount representation
     */
    public static VariableAmount fixed(double value) {
        return new Fixed(value);
    }

    /**
     * Creates a new variable about which has a base and variance. The final
     * amount will be the base amount plus or minus a random amount between zero
     * (inclusive) and the variance (exclusive).
     * 
     * @param base The base value
     * @param variance The variance
     * @return A variable amount representation
     */
    public static VariableAmount baseWithVariance(double base, double variance) {
        return new BaseAndVariance(base, variance);
    }

    /**
     * Creates a new variable amount which has a base and an additional amount.
     * The final amount will be the base amount plus a random amount between
     * zero (inclusive) and the additional amount (exclusive).
     * 
     * @param base The base value
     * @param addition The additional amount
     * @return A variable amount representation
     */
    public static VariableAmount baseWithRandomAddition(double base, double addition) {
        return new BaseAndVariance(base + addition / 2, addition / 2);
    }

    /**
     * Creates a new variable about which has a base and a chance to apply a
     * random variance. The chance should be between zero and one with a chance
     * of one signifying that the variance will always be applied. If the chance
     * succeeds then the final amount will be the base amount plus or minus a
     * random amount between zero (inclusive) and the variance (exclusive). If
     * the chance fails then the final amount will just be the base value.
     * 
     * @param base The base value
     * @param variance The variance
     * @param chance The chance to apply the variance
     * @return A variable amount representation
     */
    public static VariableAmount baseWithOptionalVariance(double base, double variance, double chance) {
        return new OptionalAmount(base, chance, baseWithVariance(base, variance));
    }

    /**
     * Creates a new variable about which has a base and a chance to apply a
     * random additional amount. The chance should be between zero and one with
     * a chance of one signifying that the additional amount will always be
     * applied. If the chance succeeds then the final amount will be the base
     * amount plus a random amount between zero (inclusive) and the additional
     * amount (exclusive). If the chance fails then the final amount will just
     * be the base value.
     * 
     * @param base The base value
     * @param addition The additional amount
     * @param chance The chance to apply the additional amount
     * @return A variable amount representation
     */
    public static VariableAmount baseWithOptionalAddition(double base, double addition, double chance) {
        return new OptionalAmount(base, chance, baseWithRandomAddition(base, addition));
    }

    /**
     * Gets an instance of the variable amount depending on the given random
     * object.
     * 
     * @param rand The random object
     * @return The amount
     */
    public abstract double getAmount(Random rand);

    /**
     * Gets the amount as if from {@link #getAmount(Random)} but floored to the
     * nearest integer equivalent.
     * 
     * @param rand The random object
     * @return The floored amount
     */
    public int getFlooredAmount(Random rand) {
        return (int) Math.floor(getAmount(rand));
    }

    @Override
    public String toString() {
        return "a varying amount";
    }

    /**
     * Represents a fixed amount, calls to {@link #getAmount} will always return
     * the same fixed value.
     */
    public static class Fixed extends VariableAmount {

        private double amount;

        private Fixed(double amount) {
            this.amount = amount;
        }

        @Override
        public double getAmount(Random rand) {
            return this.amount;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Fixed amount = (Fixed) obj;
            return amount.amount == this.amount;
        }

    }

    /**
     * Represents a base amount with a variance, the final amount will be the
     * base amount plus or minus a random amount between zero (inclusive) and
     * the variance (exclusive).
     */
    public static class BaseAndVariance extends VariableAmount {

        private double base;
        private double variance;

        private BaseAndVariance(double base, double variance) {
            this.base = base;
            this.variance = variance;
        }

        @Override
        public double getAmount(Random rand) {
            return this.base + rand.nextDouble() * this.variance * 2 - this.variance;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            BaseAndVariance amount = (BaseAndVariance) obj;
            return amount.base == this.base && amount.variance == this.variance;
        }

    }

    /**
     * Represents a variable amount which has a base and a chance of varying.
     * This wraps another {@link VariableAmount} which it refers to if the
     * chance succeeds.
     */
    public static class OptionalAmount extends VariableAmount {

        private double chance;
        private double base;
        private VariableAmount inner;

        private OptionalAmount(double base, double chance, VariableAmount inner) {
            this.inner = inner;
            this.chance = chance;
        }

        @Override
        public double getAmount(Random rand) {
            if (rand.nextDouble() < this.chance) {
                return this.inner.getAmount(rand);
            }
            return this.base;
        }

        @Override
        public int getFlooredAmount(Random rand) {
            if (rand.nextDouble() < this.chance) {
                return this.inner.getFlooredAmount(rand);
            }
            return (int) Math.floor(this.base);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            OptionalAmount amount = (OptionalAmount) obj;
            if (!this.inner.equals(amount.inner)) {
                return false;
            }
            return amount.base == this.base && this.chance == amount.chance;
        }

    }

}
