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
package org.spongepowered.api.event.cause.entity.damage;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class DamageTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<DamageType> ATTACK = DamageTypes.key(ResourceKey.sponge("attack"));

    public static final DefaultedRegistryReference<DamageType> CONTACT = DamageTypes.key(ResourceKey.sponge("contact"));

    public static final DefaultedRegistryReference<DamageType> CUSTOM = DamageTypes.key(ResourceKey.sponge("custom"));

    public static final DefaultedRegistryReference<DamageType> DROWN = DamageTypes.key(ResourceKey.sponge("drown"));

    public static final DefaultedRegistryReference<DamageType> DRYOUT = DamageTypes.key(ResourceKey.sponge("dryout"));

    public static final DefaultedRegistryReference<DamageType> EXPLOSIVE = DamageTypes.key(ResourceKey.sponge("explosive"));

    public static final DefaultedRegistryReference<DamageType> FALL = DamageTypes.key(ResourceKey.sponge("fall"));

    public static final DefaultedRegistryReference<DamageType> FIRE = DamageTypes.key(ResourceKey.sponge("fire"));

    public static final DefaultedRegistryReference<DamageType> GENERIC = DamageTypes.key(ResourceKey.sponge("generic"));

    public static final DefaultedRegistryReference<DamageType> HUNGER = DamageTypes.key(ResourceKey.sponge("hunger"));

    public static final DefaultedRegistryReference<DamageType> MAGIC = DamageTypes.key(ResourceKey.sponge("magic"));

    public static final DefaultedRegistryReference<DamageType> MAGMA = DamageTypes.key(ResourceKey.sponge("magma"));

    public static final DefaultedRegistryReference<DamageType> PROJECTILE = DamageTypes.key(ResourceKey.sponge("projectile"));

    public static final DefaultedRegistryReference<DamageType> SUFFOCATE = DamageTypes.key(ResourceKey.sponge("suffocate"));

    public static final DefaultedRegistryReference<DamageType> SWEEPING_ATTACK = DamageTypes.key(ResourceKey.sponge("sweeping_attack"));

    public static final DefaultedRegistryReference<DamageType> VOID = DamageTypes.key(ResourceKey.sponge("void"));

    // SORTFIELDS:OFF

    // @formatter:on

    private DamageTypes() {
    }

    private static DefaultedRegistryReference<DamageType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.DAMAGE_TYPE, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
