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
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class GoalExecutorTypes {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * {@link GoalExecutor} that is the default set of goals for most {@link Agent}s.
     */
    public static final DefaultedRegistryReference<GoalExecutorType> NORMAL = GoalExecutorTypes.key(ResourceKey.sponge("normal"));

    /**
     * {@link GoalExecutor} that is the "target" set of goals.
     *
     * <p>The objective is to formulate the target so that the
     * {@link Agent} can act on it. The best example is how monsters like zombie
     * and skeleton attack enemies: they seek out a target and if any of their non-target
     * goals see that they have a target, they act accordingly.</p>
     */
    public static final DefaultedRegistryReference<GoalExecutorType> TARGET = GoalExecutorTypes.key(ResourceKey.sponge("target"));

    // SORTFIELDS:OFF

    // @formatter:on

    private GoalExecutorTypes() {
    }

    private static DefaultedRegistryReference<GoalExecutorType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.GOAL_EXECUTOR_TYPE, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
