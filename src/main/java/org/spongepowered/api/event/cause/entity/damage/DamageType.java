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
package org.spongepowered.api.event.cause.entity.damage;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.event.cause.entity.damage.source.DamageSource;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * A {@link DamageType} is a type of "grouping" for {@link DamageSource}s since
 * a {@link DamageSource} instance can be inherently different from another
 * {@link DamageSource} by virtue of the {@link Object} backing the source.
 * Furthermore, it is impossible to refer to {@link DamageSource}s statically
 * due to the nature of constructing them. It is possible however, that the
 * parent {@link Object} being referred to as the "damage source" can damage
 * an {@link Entity} with varying {@link DamageType}s depending on the
 * circumstances.
 */
@CatalogedBy(DamageTypes.class)
public interface DamageType extends CatalogType {

}
