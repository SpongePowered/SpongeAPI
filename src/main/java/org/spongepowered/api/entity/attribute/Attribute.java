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

import org.spongepowered.api.entity.attribute.type.AttributeType;
import org.spongepowered.api.item.inventory.ItemStack;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * Represents an instance of an {@link AttributeType} that contains a value.
 *
 * <p>Attributes are held in an {@link AttributeHolder}</p>
 *
 * <p>Attributes can have {@link AttributeModifier}s applied to an entity
 * through an equipped {@link ItemStack}</p>
 */
public interface Attribute {

    /**
     * Gets the type of this attribute.
     *
     * @return The attribute type.
     */
    AttributeType getType();

    /**
     * Gets the base value of this attribute.
     *
     * <p>This is the value of this attribute before any {@link AttributeModifier}s are applied.</p>
     *
     * @return The base value.
     */
    double getBaseValue();

    /**
     * Sets the base value of this attribute.
     *
     * <p>This is the value <i>before</i> modifiers are applied.</p>
     *
     * @param baseValue The base value
     */
    void setBaseValue(double baseValue);

    /**
     * Gets the value of this attribute.
     *
     * <p>This is the value with modifiers applied.</p>
     *
     * @return The value
     */
    double getValue();

    /**
     * Gets a collection of all applied modifiers.
     *
     * @return A collection of applied modifiers
     */
    Collection<AttributeModifier> getModifiers();

    /**
     * Gets a collection of applied modifiers with the provided operation.
     *
     * @return A collection of modifiers
     */
    default Collection<AttributeModifier> getModifiers(Supplier<? extends AttributeOperation> operation) {
        return this.getModifiers(operation.get());
    }

    /**
     * Gets a collection of applied modifiers with the provided operation.
     *
     * @return A collection of modifiers
     */
    Collection<AttributeModifier> getModifiers(AttributeOperation operation);

    /**
     * Checks if this attribute has the provided modifier.
     *
     * @param modifier The modifier
     * @return {@code true} if this attribute has the modifier, {@code false}
     *     otherwise
     */
    boolean hasModifier(AttributeModifier modifier);

    /**
     * Gets an attribute modifier by its unique id.
     *
     * @param uniqueId The unique id
     * @return The attribute modifier, if present, {@link Optional#empty()}
     *     otherwise
     */
    Optional<AttributeModifier> getModifier(UUID uniqueId);

    /**
     * Adds a modifier to this attribute.
     *
     * @param modifier The modifier
     */
    void addModifier(AttributeModifier modifier);

    /**
     * Removes a modifier from this attribute.
     *
     * @param modifier The modifier
     */
    void removeModifier(AttributeModifier modifier);

    /**
     * Removes a modifier from this attribute using it's unique id.
     *
     * @param uniqueId The unique id of the modifier.
     */
    void removeModifier(UUID uniqueId);
}
