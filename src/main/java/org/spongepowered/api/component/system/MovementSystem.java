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
package org.spongepowered.api.component.system;

import org.spongepowered.api.component.Filter;
import org.spongepowered.api.component.attribute.Position;
import org.spongepowered.api.component.attribute.Velocity;

/**
 * Represents an {@link org.spongepowered.api.component.system.EntitySystem} that processes {@link org.spongepowered.api.entity.Entity}s
 * whose {@link org.spongepowered.api.component.Component}s give them attributes of entities that can move
 */
@SuppressWarnings("unchecked")
public abstract class MovementSystem implements EntitySystem {
    private final Filter vanillaFilter = new Filter(Position.class, Velocity.class);

    @Override
    public Filter getFilter() {
        return vanillaFilter;
    }
}
