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
import org.spongepowered.api.entity.attribute.type.AttributeType;
import org.spongepowered.api.item.inventory.ItemStackLike;
import org.spongepowered.api.item.inventory.equipment.EquipmentCondition;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * Represents an {@link AttributeModifier} for the specific {@link AttributeType}
 * an {@link ItemStackLike} can apply when the {@link EquipmentCondition} is met.
 */
public interface ItemAttribute {

    /**
     * Creates an item attribute with the given values.
     *
     * @param type The attribute type
     * @param modifier The attribute modifier
     * @param condition The equipment condition
     * @return The item attribute
     */
    static ItemAttribute of(final Supplier<? extends AttributeType> type, final AttributeModifier modifier, final Supplier<? extends EquipmentCondition> condition) {
        return ItemAttribute.of(Objects.requireNonNull(type, "type").get(), modifier, Objects.requireNonNull(condition, "condition").get());
    }

    /**
     * Creates an item attribute with the given values.
     *
     * @param type The attribute type
     * @param modifier The attribute modifier
     * @param condition The equipment condition
     * @return The item attribute
     */
    static ItemAttribute of(final Supplier<? extends AttributeType> type, final AttributeModifier modifier, final EquipmentCondition condition) {
        return ItemAttribute.of(Objects.requireNonNull(type, "type").get(), modifier, condition);
    }

    /**
     * Creates an item attribute with the given values.
     *
     * @param type The attribute type
     * @param modifier The attribute modifier
     * @param condition The equipment condition
     * @return The item attribute
     */
    static ItemAttribute of(final AttributeType type, final AttributeModifier modifier, final Supplier<? extends EquipmentCondition> condition) {
        return ItemAttribute.of(type, modifier, Objects.requireNonNull(condition, "condition").get());
    }

    /**
     * Creates an item attribute with the given values.
     *
     * @param type The attribute type
     * @param modifier The attribute modifier
     * @param condition The equipment condition
     * @return The item attribute
     */
    static ItemAttribute of(final AttributeType type, final AttributeModifier modifier, final EquipmentCondition condition) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(type, modifier, condition);
    }

    /**
     * Returns the attribute type.
     *
     * @return The attribute type
     */
    AttributeType type();

    /**
     * Returns the attribute modifier.
     *
     * @return The attribute modifier
     */
    AttributeModifier modifier();

    /**
     * Returns the equipment condition.
     *
     * @return The equipment condition
     */
    EquipmentCondition condition();

    interface Factory {

        ItemAttribute of(AttributeType type, AttributeModifier modifier, EquipmentCondition condition);
    }
}
