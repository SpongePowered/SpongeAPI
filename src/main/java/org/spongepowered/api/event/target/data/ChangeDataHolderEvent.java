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
package org.spongepowered.api.event.target.data;

import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.GameEvent;

/**
 * An event that is associated with a {@link DataHolder} that may have some
 * {@link BaseValue}s changed, offered, or removed. Note that calling any
 * methods relating to modifying a {@link DataHolder} while this event
 * is being processed may produce awkward results.
 */
public interface ChangeDataHolderEvent extends GameEvent, Cancellable {

    /**
     * Gets the {@link DataHolder} targeted in this event.
     *
     * @return The data holder targeted in this event
     */
    DataHolder getTargetHolder();

}
