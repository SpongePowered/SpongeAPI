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
package org.spongepowered.api.text.action;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.Objects;
import org.spongepowered.api.text.Text;

import javax.annotation.Nullable;

/**
 * Represents an action happening as a response to an event on a {@link Text}.
 *
 * @param <R> The type of the result
 *
 * @see ClickAction
 * @see HoverAction
 * @see ShiftClickAction
 */
public abstract class TextAction<R> {

    protected final R result;

    /**
     * Constructs a new {@link TextAction} with the given result.
     *
     * @param result The result of the text action
     */
    protected TextAction(R result) {
        this.result = checkNotNull(result, "result");
    }

    /**
     * Returns the result of this {@link TextAction}.
     *
     * @return The result
     */
    public final R getResult() {
        return this.result;
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        TextAction<?> that = (TextAction<?>) o;
        return this.result.equals(that.result);
    }

    @Override
    public int hashCode() {
        return this.result.hashCode();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .addValue(this.result)
                .toString();
    }

}
