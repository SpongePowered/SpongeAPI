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
package org.spongepowered.api.scheduler;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class TaskPriorities {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<TaskPriority> EXTREMELY_HIGH = TaskPriorities.key(ResourceKey.sponge("extremely_high"));

    public static final DefaultedRegistryReference<TaskPriority> VERY_HIGH = TaskPriorities.key(ResourceKey.sponge("very_high"));

    public static final DefaultedRegistryReference<TaskPriority> HIGH = TaskPriorities.key(ResourceKey.sponge("high"));

    public static final DefaultedRegistryReference<TaskPriority> NORMAL = TaskPriorities.key(ResourceKey.sponge("normal"));

    public static final DefaultedRegistryReference<TaskPriority> LOW = TaskPriorities.key(ResourceKey.sponge("low"));

    public static final DefaultedRegistryReference<TaskPriority> VERY_LOW = TaskPriorities.key(ResourceKey.sponge("very_low"));

    public static final DefaultedRegistryReference<TaskPriority> EXTREMELY_LOW = TaskPriorities.key(ResourceKey.sponge("extremely_low"));

    // SORTFIELDS:OFF

    // @formatter:on

    private TaskPriorities() {
    }

    private static DefaultedRegistryReference<TaskPriority> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.TASK_PRIORITY, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
