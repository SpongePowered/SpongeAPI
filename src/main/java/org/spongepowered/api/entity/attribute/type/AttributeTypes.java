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
package org.spongepowered.api.entity.attribute.type;

import org.spongepowered.api.Sponge;

import java.util.function.Supplier;

/**
 * An enumeration of {@link AttributeType}s.
 */
public final class AttributeTypes {

    // SORTFIELDS:ON

    public static final Supplier<RangedAttributeType> ARMOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "ARMOR");

    public static final Supplier<RangedAttributeType> ARMOR_TOUGHNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "ARMOR_TOUGHNESS");

    public static final Supplier<RangedAttributeType> ATTACK_DAMAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "ATTACK_DAMAGE");

    public static final Supplier<RangedAttributeType> ATTACK_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "ATTACK_SPEED");

    public static final Supplier<RangedAttributeType> ATTACK_KNOCKBACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "ATTACK_KNOCKBACK");

    public static final Supplier<RangedAttributeType> FOLLOW_RANGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "FOLLOW_RANGE");

    public static final Supplier<RangedAttributeType> HORSE_JUMP_STRENGTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "HORSE_JUMP_STRENGTH");

    public static final Supplier<RangedAttributeType> KNOCKBACK_RESISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "KNOCKBACK_RESISTANCE");

    public static final Supplier<RangedAttributeType> LUCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "LUCK");

    public static final Supplier<RangedAttributeType> MAX_HEALTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "MAX_HEALTH");

    public static final Supplier<RangedAttributeType> MOVEMENT_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "MOVEMENT_SPEED");

    public static final Supplier<RangedAttributeType> PARROT_FLYING_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "PARROT_FLYING_SPEED");

    public static final Supplier<RangedAttributeType> ZOMBIE_SPAWN_REINFORCEMENTS_CHANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "ZOMBIE_SPAWN_REINFORCEMENTS_CHANCE");

    // SORTFIELDS:OFF

    private AttributeTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
