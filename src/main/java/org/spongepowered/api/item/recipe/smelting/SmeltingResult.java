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
package org.spongepowered.api.item.recipe.smelting;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.Objects;

/**
 * The result of fulfilling a {@link SmeltingRecipe}.
 */
public final class SmeltingResult {

    private final ItemStackSnapshot result;
    private final double experience;

    /**
     * Creates a new {@link SmeltingResult}.
     *
     * <p>Note that this may be replaced with a static of method in the
     * future.</p>
     *
     * @param result The result of the smelting recipe
     * @param experience The experience that should be created from this
     *     smelting result
     */
    @SuppressWarnings("ConstantConditions")
    public SmeltingResult(ItemStackSnapshot result, double experience) {
        checkNotNull(result, "result");
        checkArgument(result != ItemStackSnapshot.NONE, "The result must not be ItemStackSnapshot.NONE.");
        checkArgument(experience >= 0, "The experience must be non-negative.");

        this.result = result;
        this.experience = experience;
    }

    /**
     * This method should be used instead of the
     * {@link SmeltingRecipe#getExemplaryResult()} method, as it customizes the
     * result further depending on the specified ingredient
     * {@link ItemStackSnapshot}. It is advised to use the output of
     * {@link SmeltingRecipe#getExemplaryResult()}, modify it accordingly, and
     * {@code return} it.
     *
     * @return The result of fulfilling the requirements of a
     *         {@link SmeltingRecipe}
     */
    public ItemStackSnapshot getResult() {
        return this.result;
    }

    /**
     * Returns the amount of experience released after completing a recipe.
     *
     * @return The amount of experience released after fulfilling the
     *         requirements of a {@link SmeltingRecipe}
     */
    public double getExperience() {
        return this.experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SmeltingResult)) {
            return false;
        }
        SmeltingResult that = (SmeltingResult) o;
        return Double.compare(that.experience, this.experience) == 0 && Objects.equals(this.result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.result, this.experience);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("result", this.result)
                .add("experience", this.experience)
                .toString();
    }
}
