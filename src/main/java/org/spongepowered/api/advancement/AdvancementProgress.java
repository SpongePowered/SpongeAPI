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
package org.spongepowered.api.advancement;

import org.spongepowered.api.advancement.criteria.AdvancementCriterion;
import org.spongepowered.api.advancement.criteria.CriterionProgress;
import org.spongepowered.api.advancement.criteria.ScoreAdvancementCriterion;
import org.spongepowered.api.advancement.criteria.ScoreCriterionProgress;

import java.util.Optional;

/**
 * Represents the progress of a {@link Advancement}.
 */
public interface AdvancementProgress extends Progressable {

    /**
     * Gets the {@link Advancement}.
     *
     * @return The advancement
     */
    Advancement getAdvancement();

    /**
     * Gets the {@link CriterionProgress} for the given
     * {@link AdvancementCriterion} if the specified criterion is
     * present on the {@link Advancement}.
     *
     * <p>For AND and OR criteria will wrapped {@link CriterionProgress} be
     * provided that will interact with the {@link CriterionProgress}s
     * for every child {@link AdvancementCriterion}s.</p>
     *
     * @param criterion The criterion
     * @return The criterion progress
     */
    Optional<CriterionProgress> get(AdvancementCriterion criterion);

    /**
     * Gets the {@link ScoreCriterionProgress} for the given
     * {@link ScoreAdvancementCriterion} if the specified criterion is
     * present on the {@link Advancement}.
     *
     * @param criterion The score criterion
     * @return The score criterion progress
     */
    Optional<ScoreCriterionProgress> get(ScoreAdvancementCriterion criterion);

    /**
     * Gets the {@link CriterionProgress} for the
     * given {@link AdvancementCriterion}.
     *
     * <p>For AND and OR criteria will wrapped {@link CriterionProgress} be
     * provided that will interact with the {@link CriterionProgress}s
     * for every child {@link AdvancementCriterion}s.</p>
     *
     * @param criterion The criterion
     * @return The criterion progress
     */
    default CriterionProgress require(AdvancementCriterion criterion) {
        return get(criterion).orElseThrow(() -> new IllegalStateException("The criterion " + criterion.getName()
            + " isn't present on the advancement '" + getAdvancement().getKey().toString() + "'."));
    }

    /**
     * Gets the {@link ScoreCriterionProgress} for the
     * given {@link ScoreAdvancementCriterion}.
     *
     * @param criterion The score criterion
     * @return The score criterion progress
     */
    default ScoreCriterionProgress require(ScoreAdvancementCriterion criterion) {
        return get(criterion).orElseThrow(() -> new IllegalStateException("The score criterion " + criterion.getName()
            + " isn't present on the advancement '" + getAdvancement().getKey().toString() + "'."));
    }

}
