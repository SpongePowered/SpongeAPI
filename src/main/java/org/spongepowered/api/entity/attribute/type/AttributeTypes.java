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

    public static final Supplier<RangedAttributeType> GENERIC_ARMOR = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "generic.armor");

    public static final Supplier<RangedAttributeType> GENERIC_ARMOR_TOUGHNESS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "generic.armor_toughness");

    public static final Supplier<RangedAttributeType> GENERIC_ATTACK_DAMAGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "generic.attack_damage");

    public static final Supplier<RangedAttributeType> GENERIC_ATTACK_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "generic.attack_speed");

    public static final Supplier<RangedAttributeType> GENERIC_ATTACK_KNOCKBACK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "generic.attack_knockback");

    public static final Supplier<RangedAttributeType> GENERIC_FOLLOW_RANGE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "generic.follow_range");

    public static final Supplier<RangedAttributeType> GENERIC_KNOCKBACK_RESISTANCE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "generic.knockback_resistance");

    public static final Supplier<RangedAttributeType> GENERIC_LUCK = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "generic.luck");

    public static final Supplier<RangedAttributeType> GENERIC_MAX_HEALTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "generic.max_health");

    public static final Supplier<RangedAttributeType> GENERIC_MOVEMENT_SPEED = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "generic.movement_speed");

    public static final Supplier<RangedAttributeType> HORSE_JUMP_STRENGTH = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "horse.jump_strength");

    public static final Supplier<RangedAttributeType> ZOMBIE_SPAWN_REINFORCEMENTS = Sponge.getRegistry().getCatalogRegistry().provideSupplier(RangedAttributeType.class, "zombie.spawn_reinforcements");

    // SORTFIELDS:OFF

    private AttributeTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }
}
