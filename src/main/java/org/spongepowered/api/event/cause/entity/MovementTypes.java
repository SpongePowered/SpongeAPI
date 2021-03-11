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
package org.spongepowered.api.event.cause.entity;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class MovementTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<MovementType> CHORUS_FRUIT = MovementTypes.key(ResourceKey.sponge("chorus_fruit"));

    public static final DefaultedRegistryReference<MovementType> COMMAND = MovementTypes.key(ResourceKey.sponge("command"));

    public static final DefaultedRegistryReference<MovementType> END_GATEWAY = MovementTypes.key(ResourceKey.sponge("end_gateway"));

    public static final DefaultedRegistryReference<MovementType> ENDER_PEARL = MovementTypes.key(ResourceKey.sponge("ender_pearl"));

    public static final DefaultedRegistryReference<MovementType> ENTITY_TELEPORT = MovementTypes.key(ResourceKey.sponge("entity_teleport"));

    public static final DefaultedRegistryReference<MovementType> NATURAL = MovementTypes.key(ResourceKey.sponge("natural"));

    public static final DefaultedRegistryReference<MovementType> PLUGIN = MovementTypes.key(ResourceKey.sponge("plugin"));

    public static final DefaultedRegistryReference<MovementType> PORTAL = MovementTypes.key(ResourceKey.sponge("portal"));

    // SORTFIELDS:OFF

    // @formatter:on

    private MovementTypes() {
    }

    private static DefaultedRegistryReference<MovementType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.MOVEMENT_TYPE, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
