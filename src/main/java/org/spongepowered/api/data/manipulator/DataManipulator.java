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
package org.spongepowered.api.data.manipulator;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.value.Value;
import org.spongepowered.api.data.value.ValueContainer;
import org.spongepowered.api.util.annotation.eventgen.TransformWith;

/**
 * Represents a changelist of data that can be applied to a {@link DataHolder}.
 *
 * <p>It is always possible to translate back and forth between mutable and
 * immutable forms with {@link #asMutable()} and {@link #asImmutable()}.</p>
 */
public interface DataManipulator extends ValueContainer {

    /**
     * Creates a {@link DataManipulator} view directly based on the
     * {@link Value}s. No unnecessary copies of the {@link Value}s
     * will be created.
     *
     * @param values The values
     * @return The value container view
     */
    static DataManipulator viewOf(Iterable<Value<?>> values) {
        return Sponge.getRegistry().requireFactory(Factory.class).unmodifiableViewOf(values);
    }

    static DataManipulator viewOf(ValueContainer valueContainer) {
        return Sponge.getRegistry().requireFactory(Factory.class).unmodifiableViewOf(valueContainer);
    }

    @TransformWith
    @Override
    DataManipulator copy();

    /**
     * Retrieves a mutable form of this manipulator. Due to the vague nature of the
     * manipulator itself, some cases can already provide a {@link MutableDataManipulator}
     * instance where this would simply return itself. In other cases, where the retrieved
     * manipulator is an {@link MutableDataManipulator} instance, a new mutable manipulator
     * is created with the data.
     *
     * @return A mutable data manipulator
     */
    MutableDataManipulator asMutable();

    /**
     * Retrieves a copy in the mutable form of this manipulator. The new manipulator is
     * created with the same data.
     *
     * @return A mutable data manipulator
     */
    MutableDataManipulator asMutableCopy();

    /**
     * Retrieves an immutable form of this manipulator. Due to the vague nature of the
     * value itself, some cases can already provide a {@link ImmutableDataManipulator}
     * instance where this would simply return itself. In other cases, where the retrieved
     * manipulator is a {@link ImmutableDataManipulator} instance, a new immutable
     * manipulator is created with the data.
     *
     * @return An immutable data manipulator
     */
    ImmutableDataManipulator asImmutable();

    interface Factory {

        DataManipulator unmodifiableViewOf(Iterable<Value<?>> values);

        DataManipulator unmodifiableViewOf(ValueContainer valueContainer);
    }
}
