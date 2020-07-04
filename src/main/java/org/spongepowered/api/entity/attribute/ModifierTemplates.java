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
package org.spongepowered.api.entity.attribute;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * Represents an enumeration of all modifier templates.
 */
public final class ModifierTemplates {

    // SORTFIELDS:ON

    public static final Supplier<ModifierTemplate> ARMOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ModifierTemplate.class, "ARMOR");

    public static final Supplier<ModifierTemplate> ARMOR_TOUGHNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ModifierTemplate.class, "ARMOR_TOUGHNESS");

    public static final Supplier<ModifierTemplate> ATTACK_DAMAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ModifierTemplate.class, "ATTACK_DAMAGE");

    public static final Supplier<ModifierTemplate> ATTACK_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ModifierTemplate.class, "ATTACK_SPEED");

    public static final Supplier<ModifierTemplate> ATTACK_KNOCKBACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ModifierTemplate.class, "ATTACK_KNOCKBACK");

    public static final Supplier<ModifierTemplate> FOLLOW_RANGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ModifierTemplate.class, "FOLLOW_RANGE");

    public static final Supplier<ModifierTemplate> KNOCKBACK_RESISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ModifierTemplate.class, "KNOCKBACK_RESISTANCE");

    public static final Supplier<ModifierTemplate> LUCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ModifierTemplate.class, "LUCK");

    public static final Supplier<ModifierTemplate> MAX_HEALTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ModifierTemplate.class, "MAX_HEALTH");

    public static final Supplier<ModifierTemplate> MOVEMENT_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(ModifierTemplate.class, "MOVEMENT_SPEED");

    // SORTFIELDS:OFF

    private ModifierTemplates() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
