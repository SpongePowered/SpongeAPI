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
package org.spongepowered.api.item.recipe.cooking;

import org.spongepowered.api.item.inventory.ItemStackSnapshot;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * The result of fulfilling a {@link CookingRecipe}.
 */
public final class CookingResult {

    private final ItemStackSnapshot result;
    private final double experience;

    /**
     * Creates a new {@link CookingResult}.
     *
     * <p>Note that this may be replaced with a static of method in the future.</p>
     *
     * @param result The result of the cooking recipe
     * @param experience The experience that should be created from this result
     */
    @SuppressWarnings("ConstantConditions")
    public CookingResult(final ItemStackSnapshot result, final double experience) {
        Objects.requireNonNull(result, "result");
        if (result.isEmpty()) {
            throw new IllegalArgumentException("The resulting snapshot must not be empty");
        }
        if (experience < 0) {
            throw new IllegalArgumentException("The experience must be non-negative.");
        }

        this.result = result;
        this.experience = experience;
    }

    /**
     * This method should be used instead of the
     * {@link CookingRecipe#getExemplaryResult()} method, as it customizes the
     * result further depending on the specified ingredient
     * {@link ItemStackSnapshot}. It is advised to use the output of
     * {@link CookingRecipe#getExemplaryResult()}, modify it accordingly, and
     * {@code return} it.
     *
     * @return The result of fulfilling the requirements of a
     *         {@link CookingRecipe}
     */
    public ItemStackSnapshot getResult() {
        return this.result;
    }

    /**
     * Returns the amount of experience released after completing a recipe.
     *
     * @return The amount of experience released after fulfilling the
     *         requirements of a {@link CookingRecipe}
     */
    public double getExperience() {
        return this.experience;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CookingResult)) {
            return false;
        }
        final CookingResult that = (CookingResult) o;
        return Double.compare(that.experience, this.experience) == 0 && Objects.equals(this.result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.result, this.experience);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CookingResult.class.getSimpleName() + "[", "]")
            .add("result=" + this.result)
            .add("experience=" + this.experience)
            .toString();
    }
}
