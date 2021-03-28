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
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;

/**
 * An enumeration of vanilla {@link ProfessionType}s.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class ProfessionTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<ProfessionType> ARMORER = ProfessionTypes.key(ResourceKey.minecraft("armorer"));

    public static final DefaultedRegistryReference<ProfessionType> BUTCHER = ProfessionTypes.key(ResourceKey.minecraft("butcher"));

    public static final DefaultedRegistryReference<ProfessionType> CARTOGRAPHER = ProfessionTypes.key(ResourceKey.minecraft("cartographer"));

    public static final DefaultedRegistryReference<ProfessionType> CLERIC = ProfessionTypes.key(ResourceKey.minecraft("cleric"));

    public static final DefaultedRegistryReference<ProfessionType> FARMER = ProfessionTypes.key(ResourceKey.minecraft("farmer"));

    public static final DefaultedRegistryReference<ProfessionType> FISHERMAN = ProfessionTypes.key(ResourceKey.minecraft("fisherman"));

    public static final DefaultedRegistryReference<ProfessionType> FLETCHER = ProfessionTypes.key(ResourceKey.minecraft("fletcher"));

    public static final DefaultedRegistryReference<ProfessionType> LEATHERWORKER = ProfessionTypes.key(ResourceKey.minecraft("leatherworker"));

    public static final DefaultedRegistryReference<ProfessionType> LIBRARIAN = ProfessionTypes.key(ResourceKey.minecraft("librarian"));

    public static final DefaultedRegistryReference<ProfessionType> MASON = ProfessionTypes.key(ResourceKey.minecraft("mason"));

    public static final DefaultedRegistryReference<ProfessionType> NITWIT = ProfessionTypes.key(ResourceKey.minecraft("nitwit"));

    public static final DefaultedRegistryReference<ProfessionType> NONE = ProfessionTypes.key(ResourceKey.minecraft("none"));

    public static final DefaultedRegistryReference<ProfessionType> SHEPHERD = ProfessionTypes.key(ResourceKey.minecraft("shepherd"));

    public static final DefaultedRegistryReference<ProfessionType> TOOLSMITH = ProfessionTypes.key(ResourceKey.minecraft("toolsmith"));

    public static final DefaultedRegistryReference<ProfessionType> WEAPONSMITH = ProfessionTypes.key(ResourceKey.minecraft("weaponsmith"));

    // SORTFIELDS:OFF

    // @formatter:on

    private ProfessionTypes() {
    }

    private static DefaultedRegistryReference<ProfessionType> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.PROFESSION_TYPE, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
