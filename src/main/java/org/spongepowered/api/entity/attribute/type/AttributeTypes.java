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

import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

public final class AttributeTypes {
    // SORTFIELDS:ON

    public static final RangedAttributeType ARMOR = DummyObjectProvider.createFor(RangedAttributeType.class, "ARMOR");

    public static final RangedAttributeType ARMOR_TOUGHNESS = DummyObjectProvider.createFor(RangedAttributeType.class, "ARMOR_TOUGHNESS");

    public static final RangedAttributeType ATTACK_DAMAGE = DummyObjectProvider.createFor(RangedAttributeType.class, "ATTACK_DAMAGE");

    public static final RangedAttributeType ATTACK_SPEED = DummyObjectProvider.createFor(RangedAttributeType.class, "ATTACK_SPEED");

    public static final RangedAttributeType FOLLOW_RANGE = DummyObjectProvider.createFor(RangedAttributeType.class, "FOLLOW_RANGE");

    public static final RangedAttributeType KNOCKBACK_RESISTANCE = DummyObjectProvider.createFor(RangedAttributeType.class, "KNOCKBACK_RESISTANCE");

    public static final RangedAttributeType LUCK = DummyObjectProvider.createFor(RangedAttributeType.class, "LUCK");

    public static final RangedAttributeType MAX_HEALTH = DummyObjectProvider.createFor(RangedAttributeType.class, "MAX_HEALTH");

    public static final RangedAttributeType MOVEMENT_SPEED = DummyObjectProvider.createFor(RangedAttributeType.class, "MOVEMENT_SPEED");

    // SORTFIELDS:OFF

    private AttributeTypes() {
    }

    public static final class Horse {
        // SORTFIELDS:ON

        public static final RangedAttributeType JUMP_STRENGTH = DummyObjectProvider.createFor(RangedAttributeType.class, "JUMP_STRENGTH");

        // SORTFIELDS:OFF

        private Horse() {
        }
    }

    public static final class Zombie {
        // SORTFIELDS:ON

        public static final RangedAttributeType SPAWN_REINFORCEMENTS_CHANCE = DummyObjectProvider.createFor(RangedAttributeType.class, "SPAWN_REINFORCEMENTS_CHANCE");

        // SORTFIELDS:OFF

        private Zombie() {
        }
    }
}
