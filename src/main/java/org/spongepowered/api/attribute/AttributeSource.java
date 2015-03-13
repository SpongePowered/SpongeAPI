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

import java.util.Collection;

/**
 * Represents a source of {@link AttributeModifier}s. For example some potions
 * like the speed potion also affect the entity's SPEED attribute.
 *
 * <p>
 * <b>Note:</b> You can achieve the same effects (attribute wise) if you apply
 * the {@link AttributeModifier}s from an AttributeSource (like a potion effect
 * type) to an entity without adding the potion directly. If you apply an
 * attribute modifier from an AttributeSource it will not be added another time,
 * if you apply the entire AttributeSource to that entity, but it will be
 * removed if you remove the AttributeSource from the entity.
 * </p>
 */
public interface AttributeSource {

    /**
     * Gets all {@link AttributeModifier}s on this AttributeSource.
     *
     * @return All AttributeModifiers on this AttributeSource
     */
    Collection<AttributeModifier> getAttributeModifiers();

}
