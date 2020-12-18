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
package org.spongepowered.api.entity.ai.goal;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.Agent;
import org.spongepowered.api.entity.living.Creature;
import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.entity.living.Living;
import org.spongepowered.api.entity.living.animal.horse.Horse;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

import java.util.function.Predicate;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class GoalTypes {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * {@link Goal} where {@link Living}s avoid other {@link Agent}s based on a {@link Predicate}.
     */
    public static final DefaultedRegistryReference<GoalType> AVOID_LIVING = GoalTypes.key(ResourceKey.sponge("avoid_living"));

    public static final DefaultedRegistryReference<GoalType> ATTACK_LIVING = GoalTypes.key(ResourceKey.sponge("attack_living"));

    public static final DefaultedRegistryReference<GoalType> FIND_NEAREST_ATTACKABLE = GoalTypes.key(ResourceKey.sponge("find_nearest_attackable"));

    public static final DefaultedRegistryReference<GoalType> LOOK_AT = GoalTypes.key(ResourceKey.sponge("look_at"));

    public static final DefaultedRegistryReference<GoalType> LOOK_RANDOMLY = GoalTypes.key(ResourceKey.sponge("look_randomly"));

    /**
     * {@link Goal} where {@link Creature}s walk around.
     */
    public static final DefaultedRegistryReference<GoalType> RANDOM_WALKING = GoalTypes.key(ResourceKey.sponge("random_walking"));

    public static final DefaultedRegistryReference<GoalType> RANGED_ATTACK_AGAINST_AGENT = GoalTypes.key(ResourceKey.sponge("ranged_attack_against_agent"));

    /**
     * {@link Goal} where {@link Horse}s run around while {@link Humanoid}s attempt to tame them.
     */
    public static final DefaultedRegistryReference<GoalType> RUN_AROUND_LIKE_CRAZY = GoalTypes.key(ResourceKey.sponge("run_around_like_crazy"));

    /**
     * {@link Goal} where {@link Agent}s swim in liquids.
     */
    public static final DefaultedRegistryReference<GoalType> SWIM = GoalTypes.key(ResourceKey.sponge("swim"));

    // SORTFIELDS:OFF

    // @formatter:on

    private GoalTypes() {
    }

    private static DefaultedRegistryReference<GoalType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.GOAL_TYPE, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
