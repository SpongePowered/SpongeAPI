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

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.entity.attribute.type.AttributeTypes;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.UUID;

/**
 * Represents a template for {@link AttributeModifier} which contains the
 * default {@link AttributeModifier#getUniqueId() id} and
 * {@link AttributeModifier#getName() name} for a type of modifier.
 *
 * <p>For example, when the {@link AttributeTypes#LUCK} attribute type is applied as a modifier, a {@link UUID unique id} and name is required</p>
 */
@CatalogedBy(ModifierTemplates.class)
public interface ModifierTemplate extends CatalogType {

    /**
     * The default name of this modifier.
     * @return The default name of this modifier.
     */
    String getName();

    /**
     * The default unique id of this modifier.
     * @return The default unique id of this modifier.
     */
    UUID getUniqueId();
}
