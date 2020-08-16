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
package org.spongepowered.api.scoreboard;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * An enumeration of vanilla {@link CollisionRule}s.
 *
 * <p>The behavior of these values can be somewhat counter-intuitive. Since {@link CollisionRule}s
 * are used on the client, this behavior cannot be changed by Sponge.</p>
 *
 * <p>The following truth table shows whether or not two entities will collide,
 * given the collision rules for their respective teams.</p>
 *
 * <p>For example, two entities on different teams will not collide if one team's {@link CollisionRule}
 * is set to {@link #ALWAYS} and the other is set to {@link #PUSH_OWN_TEAM}.</p>
 *
 * <p>Same team - {@link #ALWAYS} - Yes
 * Same team - {@link #PUSH_OWN_TEAM} - Yes
 * Same team - {@link #PUSH_OTHER_TEAMS} - No
 * Same team - {@link #NEVER} - No</p>
 *
 * <p>Different teams - {@link #NEVER} - *any* - No</p>
 *
 * <p>Different teams - {@link #ALWAYS} - {@link #PUSH_OWN_TEAM} - No
 * Different teams - {@link #ALWAYS} - {@link #PUSH_OTHER_TEAMS} - Yes
 * Different teams - {@link #ALWAYS} - {@link #ALWAYS} - Yes
 * Different teams - {@link #PUSH_OWN_TEAM} - {@link #PUSH_OTHER_TEAMS} - No
 * Different teams - {@link #PUSH_OWN_TEAM} - {@link #PUSH_OWN_TEAM} - No
 * Different teams - {@link #PUSH_OTHER_TEAMS} - {@link #PUSH_OTHER_TEAMS} - Yes</p>
 *
 */
public final class CollisionRules {

    // SORTFIELDS:ON

    /**
     * Members will always collide with other entities.
     *
     * <p>This is the default value.</p>
     */
    public static final Supplier<CollisionRule> ALWAYS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(CollisionRule.class, "always");

    /**
     * Members will never collide.
     */
    public static final Supplier<CollisionRule> NEVER = Sponge.getRegistry().getCatalogRegistry().provideSupplier(CollisionRule.class, "never");

    /**
     * Members will only push members on opposing teams.
     */
    public static final Supplier<CollisionRule> PUSH_OTHER_TEAMS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(CollisionRule.class, "push_other_teams");

    /**
     * Members will only push other members on their team and mobs.
     */
    public static final Supplier<CollisionRule> PUSH_OWN_TEAM = Sponge.getRegistry().getCatalogRegistry().provideSupplier(CollisionRule.class, "push_own_team");

    // SORTFIELDS:OFF

    // Suppress default constructor to ensure non-instantiability.
    private CollisionRules() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
