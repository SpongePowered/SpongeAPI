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
package org.spongepowered.api.util.weighted;

import com.flowpowered.math.GenericMath;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataSerializable;
import org.spongepowered.api.data.Queries;

import java.util.Random;

/**
 * Represents a value which may vary randomly.
 * 
 * <p>Implementors of this interface using it in a fashion in which may ever be
 * serialized <strong>must</strong> implement the {@link #toContainer()}
 * method.</p>
 */
@FunctionalInterface
public interface VariableAmount extends DataSerializable {

    /**
     * Creates a new 'fixed' variable amount, calls to {@link #getAmount} will
     * always return the fixed value.
     * 
     * @param value The fixed value
     * @return A variable amount representation
     */
    static VariableAmount fixed(double value) {
        return new Fixed(value);
    }

    /**
     * Creates a new variable amount which return values between the given min
     * (inclusive) and max (exclusive).
     * 
     * @param min The minimum of the range (inclusive)
     * @param max The maximum of the range (exclusive)
     * @return A variable amount representation
     */
    static VariableAmount range(double min, double max) {
        return new BaseAndAddition(min, fixed(max - min));
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
    static VariableAmount baseWithVariance(double base, double variance) {
        return new BaseAndVariance(base, VariableAmount.fixed(variance));
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
    static VariableAmount baseWithVariance(double base, VariableAmount variance) {
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
    static VariableAmount baseWithRandomAddition(double base, double addition) {
        return new BaseAndAddition(base, VariableAmount.fixed(addition));
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
    static VariableAmount baseWithRandomAddition(double base, VariableAmount addition) {
        return new BaseAndAddition(base, addition);
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
    static VariableAmount baseWithOptionalVariance(double base, double variance, double chance) {
        return new OptionalAmount(base, chance, baseWithVariance(base, variance));
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
    static VariableAmount baseWithOptionalVariance(double base, VariableAmount variance, double chance) {
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
    static VariableAmount baseWithOptionalAddition(double base, double addition, double chance) {
        return new OptionalAmount(base, chance, baseWithRandomAddition(base, addition));
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
    static VariableAmount baseWithOptionalAddition(double base, VariableAmount addition, double chance) {
        return new OptionalAmount(base, chance, baseWithRandomAddition(base, addition));
    }

    /**
     * Gets an instance of the variable amount depending on the given random
     * object.
     * 
     * @param rand The random object
     * @return The amount
     */
    double getAmount(Random rand);

    /**
     * Gets the amount as if from {@link #getAmount(Random)} but floored to the
     * nearest integer equivalent.
     * 
     * @param rand The random object
     * @return The floored amount
     */
    default int getFlooredAmount(Random rand) {
        return GenericMath.floor(getAmount(rand));
    }

    // This is overridden to allow this to be a functional interface as this
    // greatly increases the usability of the interface.
    @Override
    default DataContainer toContainer() {
        throw new UnsupportedOperationException();
    }

    @Override
    default int getContentVersion() {
        return 0;
    }

    /**
     * Represents a fixed amount, calls to {@link #getAmount} will always return
     * the same fixed value.
     */
    class Fixed implements VariableAmount {

        private double amount;

        Fixed(double amount) {
            this.amount = amount;
        }

        @Override
        public double getAmount(Random rand) {
            return this.amount;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).add("amount", this.amount).toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Fixed)) {
                return false;
            }
            Fixed amount = (Fixed) obj;
            return amount.amount == this.amount;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 37 * result + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >> 32));
            return result;
        }

        @Override
        public DataContainer toContainer() {
            return DataContainer.createNew()
                    .set(Queries.CONTENT_VERSION, getContentVersion())
                    .set(Queries.VARIABLE_AMOUNT, this.amount);
        }

        @Override
        public int getContentVersion() {
            return 1;
        }
    }

    /**
     * Represents a base amount with a variance, the final amount will be the
     * base amount plus or minus a random amount between zero (inclusive) and
     * the variance (exclusive).
     */
    class BaseAndVariance implements VariableAmount {

        private double base;
        private VariableAmount variance;

        BaseAndVariance(double base, VariableAmount variance) {
            this.base = base;
            this.variance = variance;
        }

        @Override
        public double getAmount(Random rand) {
            double var = this.variance.getAmount(rand);
            return this.base + rand.nextDouble() * var * 2 - var;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).add("base", this.base).add("variance", this.variance).toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BaseAndVariance)) {
                return false;
            }
            BaseAndVariance amount = (BaseAndVariance) obj;
            return amount.base == this.base && amount.variance == this.variance;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 37 * result + (int) (Double.doubleToLongBits(this.base) ^ (Double.doubleToLongBits(this.base) >> 32));
            result = 37 * result + this.variance.hashCode();
            return result;
        }

        @Override
        public DataContainer toContainer() {
            return DataContainer.createNew()
                    .set(Queries.CONTENT_VERSION, getContentVersion())
                    .set(Queries.VARIABLE_BASE, this.base)
                    .set(Queries.VARIABLE_VARIANCE, this.variance);
        }

        @Override
        public int getContentVersion() {
            return 1;
        }

    }

    /**
     * Represents a base amount with a random addition, the final amount will be
     * the base amount plus a random amount between zero (inclusive) and the
     * addition (exclusive).
     */
    class BaseAndAddition implements VariableAmount {

        private double base;
        private VariableAmount addition;

        BaseAndAddition(double base, VariableAmount addition) {
            this.base = base;
            this.addition = addition;
        }

        @Override
        public double getAmount(Random rand) {
            return this.base + (rand.nextDouble() * this.addition.getAmount(rand));
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).add("base", this.base).add("addition", this.addition).toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BaseAndAddition)) {
                return false;
            }
            BaseAndAddition amount = (BaseAndAddition) obj;
            return amount.base == this.base && amount.addition == this.addition;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 37 * result + (int) (Double.doubleToLongBits(this.base) ^ (Double.doubleToLongBits(this.base) >> 32));
            result = 37 * result + this.addition.hashCode();
            return result;
        }

        @Override
        public DataContainer toContainer() {
            return DataContainer.createNew()
                    .set(Queries.CONTENT_VERSION, getContentVersion())
                    .set(Queries.VARIABLE_BASE, this.base)
                    .set(Queries.VARIABLE_VARIANCE, this.addition);
        }

        @Override
        public int getContentVersion() {
            return 1;
        }
    }

    /**
     * Represents a variable amount which has a base and a chance of varying.
     * This wraps another {@link VariableAmount} which it refers to if the
     * chance succeeds.
     */
    class OptionalAmount implements VariableAmount {

        private double chance;
        private double base;
        private VariableAmount inner;

        OptionalAmount(double base, double chance, VariableAmount inner) {
            this.base = base;
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
        public String toString() {
            return MoreObjects.toStringHelper(this).add("base", this.base).add("chance", this.chance).add("inner", this.inner).toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OptionalAmount)) {
                return false;
            }
            OptionalAmount amount = (OptionalAmount) obj;
            return this.inner.equals(amount.inner) && amount.base == this.base && this.chance == amount.chance;
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 37 * result + (int) (Double.doubleToLongBits(this.base) ^ (Double.doubleToLongBits(this.base) >> 32));
            result = 37 * result + (int) (Double.doubleToLongBits(this.chance) ^ (Double.doubleToLongBits(this.chance) >> 32));
            result = 37 * result + this.inner.hashCode();
            return result;
        }

        @Override
        public DataContainer toContainer() {
            return DataContainer.createNew()
                    .set(Queries.CONTENT_VERSION, getContentVersion())
                    .set(Queries.VARIABLE_CHANCE, this.chance)
                    .set(Queries.VARIABLE_BASE, this.base)
                    .set(Queries.VARIABLE_VARIANCE, this.inner);
        }

        @Override
        public int getContentVersion() {
            return 1;
        }
    }

}
