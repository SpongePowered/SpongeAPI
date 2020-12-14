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

import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;

/**
 * An enumeration of {@link AttributeTypes}s.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class AttributeTypes {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<RangedAttributeType> GENERIC_ARMOR = AttributeTypes.rangedKey(ResourceKey.minecraft("generic.armor"));

    public static final DefaultedRegistryReference<RangedAttributeType> GENERIC_ARMOR_TOUGHNESS = AttributeTypes.rangedKey(ResourceKey.minecraft("generic.armor_toughness"));

    public static final DefaultedRegistryReference<RangedAttributeType> GENERIC_ATTACK_DAMAGE = AttributeTypes.rangedKey(ResourceKey.minecraft("generic.attack_damage"));

    public static final DefaultedRegistryReference<RangedAttributeType> GENERIC_ATTACK_KNOCKBACK = AttributeTypes.rangedKey(ResourceKey.minecraft("generic.attack_knockback"));

    public static final DefaultedRegistryReference<RangedAttributeType> GENERIC_ATTACK_SPEED = AttributeTypes.rangedKey(ResourceKey.minecraft("generic.attack_speed"));

    public static final DefaultedRegistryReference<RangedAttributeType> GENERIC_FLYING_SPEED = AttributeTypes.rangedKey(ResourceKey.minecraft("generic.flying_speed"));

    public static final DefaultedRegistryReference<RangedAttributeType> GENERIC_FOLLOW_RANGE = AttributeTypes.rangedKey(ResourceKey.minecraft("generic.follow_range"));

    public static final DefaultedRegistryReference<RangedAttributeType> GENERIC_KNOCKBACK_RESISTANCE = AttributeTypes.rangedKey(ResourceKey.minecraft("generic.knockback_resistance"));

    public static final DefaultedRegistryReference<RangedAttributeType> GENERIC_LUCK = AttributeTypes.rangedKey(ResourceKey.minecraft("generic.luck"));

    public static final DefaultedRegistryReference<RangedAttributeType> GENERIC_MAX_HEALTH = AttributeTypes.rangedKey(ResourceKey.minecraft("generic.max_health"));

    public static final DefaultedRegistryReference<RangedAttributeType> GENERIC_MOVEMENT_SPEED = AttributeTypes.rangedKey(ResourceKey.minecraft("generic.movement_speed"));

    public static final DefaultedRegistryReference<RangedAttributeType> HORSE_JUMP_STRENGTH = AttributeTypes.rangedKey(ResourceKey.minecraft("horse.jump_strength"));

    public static final DefaultedRegistryReference<RangedAttributeType> ZOMBIE_SPAWN_REINFORCEMENTS = AttributeTypes.rangedKey(ResourceKey.minecraft("zombie.spawn_reinforcements"));

    // SORTFIELDS:OFF

    // @formatter:on

    private AttributeTypes() {
    }

    private static DefaultedRegistryReference<RangedAttributeType> rangedKey(final ResourceKey location) {
        return RegistryKey.of(Registries.ATTRIBUTE_TYPE, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
