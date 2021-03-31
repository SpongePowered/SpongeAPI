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
package org.spongepowered.api.scoreboard.criteria;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.effect.potion.PotionEffectTypes;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.scoreboard.objective.Objective;

/**
 * Criteria names which trigger an objective to be modified by actions in-game.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class Criteria {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * Represents a {@link Criterion} which causes an {@link Objective} to have
     * a score for a player represent their current air value.
     */
    public static final DefaultedRegistryReference<Criterion> AIR = Criteria.key(ResourceKey.sponge("air"));

    /**
     * Represents a {@link Criterion} which causes an {@link Objective} to have
     * a score for a player represent their current armor value.
     */
    public static final DefaultedRegistryReference<Criterion> ARMOR = Criteria.key(ResourceKey.sponge("armor"));

    /**
     * Represents a {@link Criterion} which causes an {@link Objective}
     * to have a score for a player incremented when they die.
     */
    public static final DefaultedRegistryReference<Criterion> DEATH_COUNT = Criteria.key(ResourceKey.sponge("death_count"));

    /**
     * Represents a {@link Criterion} which causes an {@link Objective}
     * is only updated manually, through commands or plugins.
     */
    public static final DefaultedRegistryReference<Criterion> DUMMY = Criteria.key(ResourceKey.sponge("dummy"));

    /**
     * Represents a {@link Criterion} which causes an {@link Objective} to have
     * a score for a player represent their current food.
     */
    public static final DefaultedRegistryReference<Criterion> FOOD = Criteria.key(ResourceKey.sponge("food"));

    /**
     * Represents a {@link Criterion} which causes an {@link Objective} to have
     * a score for a player represent their current health, on a scale of 0-20
     * (can be greater than 20 due to effects such as
     * {@link PotionEffectTypes#HEALTH_BOOST}).
     */
    public static final DefaultedRegistryReference<Criterion> HEALTH = Criteria.key(ResourceKey.sponge("health"));

    /**
     * Represents a {@link Criterion} which causes an {@link Objective} to have
     * a score for a player represent their current level.
     */
    public static final DefaultedRegistryReference<Criterion> LEVEL = Criteria.key(ResourceKey.sponge("level"));

    /**
     * Represents a {@link Criterion} which causes an {@link Objective}
     * to have a score for a player incremented when they kill a player.
     */
    public static final DefaultedRegistryReference<Criterion> PLAYER_KILL_COUNT = Criteria.key(ResourceKey.sponge("kill_count_players"));

    /**
     * Represents a {@link Criterion} which causes an {@link Objective}
     * to have a score for a player incremented when they kill an entity.
     */
    public static final DefaultedRegistryReference<Criterion> TOTAL_KILL_COUNT = Criteria.key(ResourceKey.sponge("kill_count_all"));

    /**
     * Represents a {@link Criterion} which causes an {@link Objective}
     * to have a score for a player updated by the <code>/trigger</code>
     * command.
     */
    public static final DefaultedRegistryReference<Criterion> TRIGGER = Criteria.key(ResourceKey.sponge("trigger"));

    /**
     * Represents a {@link Criterion} which causes an {@link Objective} to have
     * a score for a player represent their current xp.
     */
    public static final DefaultedRegistryReference<Criterion> EXPERIENCE = Criteria.key(ResourceKey.sponge("experience"));

    // SORTFIELDS:OFF

    // @formatter:on

    private Criteria() {
    }

    private static DefaultedRegistryReference<Criterion> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.CRITERION, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
