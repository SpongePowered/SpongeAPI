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
package org.spongepowered.api.state;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.annotation.CatalogedBy;

/**
 * Represents a type of {@link StateProperty} that accepts an unknown {@link Enum}
 * set of values. Due to type erasure and implementation, most all enum types
 * may not be exposed in the API.
 */
@CatalogedBy(EnumStateProperties.class)
public interface EnumStateProperty<E extends Comparable<E>> extends StateProperty<E> {

    static <E extends Comparable<E>> EnumStateProperty<E> of(String name) {
        return Sponge.game().factoryProvider().provide(Factory.class).of(name);
    }

    interface Factory {

        <E extends Comparable<E>> EnumStateProperty<E> of(String name);
    }
}
