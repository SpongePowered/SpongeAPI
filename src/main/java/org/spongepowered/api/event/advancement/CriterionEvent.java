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
package org.spongepowered.api.event.advancement;

import org.spongepowered.api.advancement.criteria.AdvancementCriterion;
import org.spongepowered.api.advancement.criteria.ScoreAdvancementCriterion;
import org.spongepowered.api.advancement.criteria.trigger.Trigger;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.util.annotation.eventgen.PropertySettings;

import java.time.Instant;

/**
 * A base event for {@link AdvancementCriterion} related events.
 */
public interface CriterionEvent extends AdvancementEvent {

    /**
     * Gets the {@link AdvancementCriterion} that was met.
     *
     * @return The criterion
     */
    AdvancementCriterion getCriterion();

    /**
     * Is called when a {@link AdvancementCriterion} is granted/unlocked.
     * <p>The {@link Cause} in vanilla minecraft may contain the {@link Trigger}
     * that caused this event to happen, other methods to trigger the event
     * are through commands or the api.
     */
    interface Grant extends CriterionEvent, Cancellable {

        /**
         * Gets the {@link Instant} at which the {@link AdvancementCriterion}
         * was unlocked.
         *
         * @return The time instant
         */
        Instant getTime();
    }

    /**
     * Is called when a {@link AdvancementCriterion} is revoked.
     */
    interface Revoke extends CriterionEvent, Cancellable {
    }

    /**
     * Is called when the score of a {@link ScoreAdvancementCriterion}
     * changes. This is done before any {@link CriterionEvent.Grant}
     * or {@link CriterionEvent.Revoke} events are called.
     */
    interface ScoreChange extends CriterionEvent, Cancellable {

        @Override
        ScoreAdvancementCriterion getCriterion();

        /**
         * Gets the previous score.
         *
         * @return The previous score
         */
        int getPreviousScore();

        /**
         * Gets the new score.
         *
         * @return The new score
         */
        int getNewScore();

        /**
         * Sets the new score.
         *
         * @param score The score
         */
        void setNewScore(int score);

        /**
         * Gets whether the {@link ScoreAdvancementCriterion} was granted
         * before the event was thrown.
         *
         * @return Was granted before
         */
        @PropertySettings(generateMethods = false, requiredParameter = false)
        default boolean wasGrantedBefore() {
            return getPreviousScore() >= getCriterion().getGoal();
        }

        /**
         * Gets whether the {@link ScoreAdvancementCriterion} is
         * granted after this event is processed.
         *
         * @return Is granted
         */
        @PropertySettings(generateMethods = false, requiredParameter = false)
        default boolean isGranted() {
            return getNewScore() >= getCriterion().getGoal();
        }
    }
}
