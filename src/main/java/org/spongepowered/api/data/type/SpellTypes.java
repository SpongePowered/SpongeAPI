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
package org.spongepowered.api.data.type;

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class SpellTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<SpellType> BLINDNESS = SpellTypes.key(ResourceKey.sponge("blindness"));

    public static final DefaultedRegistryReference<SpellType> DISAPPEAR = SpellTypes.key(ResourceKey.sponge("disappear"));

    public static final DefaultedRegistryReference<SpellType> FANGS = SpellTypes.key(ResourceKey.sponge("fangs"));

    public static final DefaultedRegistryReference<SpellType> NONE = SpellTypes.key(ResourceKey.sponge("none"));

    public static final DefaultedRegistryReference<SpellType> SUMMON_VEX = SpellTypes.key(ResourceKey.sponge("summon_vex"));

    public static final DefaultedRegistryReference<SpellType> WOLOLO = SpellTypes.key(ResourceKey.sponge("wololo"));

    // SORTFIELDS:OFF

    // @formatter:on

    private SpellTypes() {
    }

    private static DefaultedRegistryReference<SpellType> key(final ResourceKey location) {
        return RegistryKey.of(Registries.SPELL_TYPE, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
