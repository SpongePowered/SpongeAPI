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
package org.spongepowered.api.item.inventory;

import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.event.HoverEventSource;
import org.spongepowered.api.data.Key;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.data.SerializableDataHolder;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.entity.attribute.AttributeModifier;
import org.spongepowered.api.entity.attribute.type.AttributeType;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.equipment.EquipmentType;
import org.spongepowered.api.registry.DefaultedRegistryReference;

import java.util.Collection;
import java.util.function.Supplier;

/**
 * Represents a stack of a specific {@link ItemType}. Supports serialization.
 *
 * <p>{@link ItemStackLike} have a variety of properties and data. It is advised to
 * use {@link ValueContainer#get(Key)} in order to retrieve information regarding
 * this item stack.</p>
 */
public interface ItemStackLike extends SerializableDataHolder, ComponentLike, HoverEventSource<HoverEvent.ShowItem> {

    /**
     * Gets the {@link ItemType} of this {@link ItemStackLike}.
     *
     * @return The item type
     */
    ItemType type();

    /**
     * Gets the quantity of items in this stack. This may exceed the max stack
     * size of the item, and if added to an inventory will then be divided by
     * the max stack.
     *
     * @return Quantity of items
     */
    int quantity();

    /**
     * Gets the maximum quantity per stack. By default, returns
     * {@link ItemType#maxStackQuantity()}, unless a
     * different value has been set for this specific stack.
     *
     * @return Max stack quantity
     */
    default int maxStackQuantity() {
        return this.require(Keys.MAX_STACK_SIZE);
    }

    /**
     * Returns true if {@link #quantity()} is zero and therefore this
     * {@link ItemStackLike} is empty.
     *
     * <p>In Vanilla empty ItemStacks are not rendered by the client.</p>
     *
     * @return True if this ItemStackLike is empty
     */
    boolean isEmpty();

    /**
     * Gets all {@link AttributeModifier}s on this {@link ItemStackLike}.
     *
     * @param attributeType The {@link AttributeType} of the modifier.
     * @param equipmentType The {@link EquipmentType} this modifier is applied.
     * to.
     *
     * @return A collection of {@link AttributeModifier}s.
     */
    default Collection<AttributeModifier> attributeModifiers(Supplier<? extends AttributeType> attributeType, DefaultedRegistryReference<? extends EquipmentType> equipmentType) {
        return this.attributeModifiers(attributeType.get(), equipmentType.get());
    }

    /**
     * Gets all {@link AttributeModifier}s on this {@link ItemStackLike}.
     *
     * @param attributeType The {@link AttributeType} of the modifier.
     * @param equipmentType The {@link EquipmentType} this modifier is applied.
     * to.
     *
     * @return A collection of {@link AttributeModifier}s.
     */
    default Collection<AttributeModifier> attributeModifiers(AttributeType attributeType, DefaultedRegistryReference<? extends EquipmentType> equipmentType) {
        return this.attributeModifiers(attributeType, equipmentType.get());
    }

    /**
     * Gets all {@link AttributeModifier}s on this {@link ItemStackLike}.
     *
     * @param attributeType The {@link AttributeType} of the modifier.
     * @param equipmentType The {@link EquipmentType} this modifier is applied.
     * to.
     *
     * @return A collection of {@link AttributeModifier}s.
     */
    default Collection<AttributeModifier> attributeModifiers(Supplier<? extends AttributeType> attributeType, EquipmentType equipmentType) {
        return this.attributeModifiers(attributeType.get(), equipmentType);
    }

    /**
     * Gets all {@link AttributeModifier}s on this {@link ItemStackLike}.
     *
     * @param attributeType The {@link AttributeType} of the modifier.
     * @param equipmentType The {@link EquipmentType} this modifier is applied.
     * to.
     *
     * @return A collection of {@link AttributeModifier}s.
     */
    Collection<AttributeModifier> attributeModifiers(AttributeType attributeType, EquipmentType equipmentType);

    /**
     * Retrieves a mutable form of this {@link ItemStackLike}. If this
     * ItemStackLike is already mutable, this would simply return itself.
     * In other cases, a new {@link ItemStack} is created with all the
     * data currently available on this {@link ItemStackLike}.
     *
     * @return An ItemStack
     */
    ItemStack asMutable();

    /**
     * Retrieves a copy in the mutable form of this {@link ItemStackLike}.
     * The new {@link ItemStack} is created with all the data currently
     * available on this {@link ItemStackLike}.
     *
     * @return A new ItemStack
     */
    ItemStack asMutableCopy();

    /**
     * Retrieves an immutable form of this {@link ItemStackLike}. If this
     * ItemStackLike is already immutable, this would simply return itself.
     * In other cases, a new {@link ItemStackSnapshot} is created with all
     * known {@link Value}s existing on this {@link ItemStackLike} added
     * as copies to the {@link ItemStackSnapshot}.
     *
     * @return An ItemStackSnapshot
     */
    ItemStackSnapshot asImmutable();

    @Override
    ItemStackLike copy();
}
