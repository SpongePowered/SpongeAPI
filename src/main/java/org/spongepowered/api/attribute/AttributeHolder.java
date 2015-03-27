/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.attribute;

import com.google.common.base.Optional;

import java.util.Collection;
import java.util.List;

/**
 * Represents some kind of object that can have {@link Attribute}s assigned to
 * it that can be modified by {@link AttributeModifier}s.
 */
public interface AttributeHolder {

    /**
     * Gets the value of a certain {@link Attribute} on this holder, as
     * calculated by an {@link AttributeCalculator}.
     *
     * @param attribute The Attribute to find the value of
     * @return The value of a certain Attribute on this holder, or
     *         Optional.absent() if the attribute is not applicable
     */
    Optional<Double> getAttributeValue(Attribute attribute);

    /**
     * Gets the base value of a certain {@link Attribute} on this holder.
     *
     * @param attribute The attribute to get the base value of
     * @return The base value of a certain Attribute on this holder, or
     *         Optional.absent() if the attribute is not applicable
     */
    Optional<Double> getBase(Attribute attribute);

    /**
     * Sets the base value of a certain {@link Attribute} on this holder.
     *
     * <p>If the attribute does not already exist, it will be created.</p>
     *
     * @param attribute The Attribute to set the base value of
     * @param base The new base value
     * @throws IllegalArgumentException If the base value exceeds the maximum or
     *         is below the minimum of the {@link Attribute}, or if the attribute
     *         is not applicable
     */
    void setBase(Attribute attribute, double base) throws IllegalArgumentException;

    /**
     * Gets a collection of all applied modifiers.
     *
     * @return A collection all applied modifiers
     */
    Collection<AttributeModifier> getAllModifiers();

    /**
     * Adds a {@link AttributeModifier} to this holder.
     *
     * @param modifier The {@link AttributeModifier} to add
     * @throws IllegalArgumentException If the AttributeModifier's
     *         {@link Attribute}'s target cannot apply to this holder, or if the
     *         AttributeModifier has already been added.
     */
    void addModifier(AttributeModifier modifier) throws IllegalArgumentException;

    /**
     * Adds multiple {@link AttributeModifier} to this holder.
     *
     * @param modifiers The AttributeModifiers to add
     * @throws IllegalArgumentException If any of the AttributeModifiers'
     *         {@link Attribute}s' targets cannot apply to this holder or any of
     *         them have already been added.
     */
    void addModifiers(Iterable<AttributeModifier> modifiers) throws IllegalArgumentException;

    /**
     * Gets all {@link AttributeModifier}s that apply to a certain
     * {@link Attribute}.
     *
     * @param attribute The attribute to find modifiers of
     * @return All AttributeModifiers that apply to a certain Attribute
     */
    List<AttributeModifier> getModifiersFor(Attribute attribute);

    /**
     * Removes a {@link AttributeModifier} from this holder.
     *
     * @param modifier The AttributeModifier to remove
     */
    void removeModifier(AttributeModifier modifier);

}
