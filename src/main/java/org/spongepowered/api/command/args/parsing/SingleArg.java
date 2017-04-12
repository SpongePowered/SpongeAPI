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
package org.spongepowered.api.command.args.parsing;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This represents a single argument with its start and end indexes
 * in the associated raw input string.
 */
public final class SingleArg {
    private final String value;
    private final int startIdx;
    private final int endIdx;

    /**
     * Create a new argument.
     *
     * @param value The argument string
     * @param startIdx The starting index of {@code value} in an input string
     * @param endIdx The ending index of {@code value} in an input string
     */
    public SingleArg(String value, int startIdx, int endIdx) {
        this.value = value;
        this.startIdx = startIdx;
        this.endIdx = endIdx;
    }

    /**
     * Gets the string used.
     *
     * @return The string used
     */
    public String getValue() {
        return this.value;
    }

    /**
     * Gets the starting index.
     *
     * @return The starting index
     */
    public int getStartIdx() {
        return this.startIdx;
    }

    /**
     * Gets the ending index.
     *
     * @return The ending index
     */
    public int getEndIdx() {
        return this.endIdx;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SingleArg)) {
            return false;
        }
        SingleArg singleArg = (SingleArg) o;
        return this.startIdx == singleArg.startIdx
               && this.endIdx == singleArg.endIdx
               && Objects.equal(this.value, singleArg.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value, this.startIdx, this.endIdx);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("value", this.value)
                .add("startIdx", this.startIdx)
                .add("endIdx", this.endIdx)
                .toString();
    }
}
