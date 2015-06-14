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
package org.spongepowered.api.scoreboard.critieria;

/**
 * Criteria names which trigger an objective to be modified by actions in-game.
 */
public final class Criteria {

    /**
     * Represents a {@link Criterion} which causes an {@link org.spongepowered.api.scoreboard.objective.Objective}
     * is only updated manually, through commands or plugins.
     */
    public static final Criterion DUMMY = null;

    /**
     * Represents a {@link Criterion} which causes an {@link org.spongepowered.api.scoreboard.objective.Objective}
     * to have a score for a player updated by the <code>/trigger</code> command.
     */
    public static final Criterion TRIGGER = null;

    /**
     * Represents a {@link Criteria} which causes an {@link org.spongepowered.api.scoreboard.objective.Objective}
     * to have a score for a player represent their current health,
     * on a scale of 0-20 (can be greater than 20 due to effects
     * such as {@link org.spongepowered.api.potion.PotionEffectTypes#HEALTH_BOOST}
     */
    public static final Criterion HEALTH = null;

    /**
     * Represents a {@link Criteria} which causes an {@link org.spongepowered.api.scoreboard.objective.Objective}
     * to have a score for a player incremented when they kill a player.
     */
    public static final Criterion PLAYER_KILLS = null;

    /**
     * Represents a {@link Criteria} which causes an {@link org.spongepowered.api.scoreboard.objective.Objective}
     * to have a score for a player incremented when they kill an entity.
     */
    public static final Criterion TOTAL_KILLS = null;

    /**
     * Represents a {@link Criteria} which causes an {@link org.spongepowered.api.scoreboard.objective.Objective}
     * to have a score for a player incremented when they die.
     */
    public static final Criterion DEATHS = null;

    private Criteria() {
    }

}
