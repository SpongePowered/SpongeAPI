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
package org.spongepowered.api.data.manipulator.tileentity;

import org.spongepowered.api.block.tileentity.Sign;
import org.spongepowered.api.data.DataManipulator;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;

import java.util.List;

/**
 * Represents the data for a {@link Sign}.
 */
public interface SignData extends DataManipulator<SignData> {

    /**
     * Gets all stored {@link Text}s, representing each line of the data.
     * <p>
     * Each valid index (usually 0-3) will contain no null elements.
     * @return The lines of text
     */
    List<Text> getLines();

    /**
     * Gets the line at the given index.
     * <p>
     * If a valid index (usually 0-3), the returned line will not be null.
     * @param index The index
     * @return The line of text
     * @throws IndexOutOfBoundsException If the index is outside of the allowed indices
     */
    Text getLine(int index) throws IndexOutOfBoundsException;

    /**
     * Sets the line at the given index.
     *
     * @param index The index to set the line at
     * @param text The new text
     * @return This instance, for chaining
     * @throws IndexOutOfBoundsException If the index is outside
     *            of the allowed indices
     */
    SignData setLine(int index, Text text) throws IndexOutOfBoundsException;

    /**
     * Resets all lines to being empty ({@link Texts#of()}.
     * @return This instance, for chaining
     */
    SignData reset();
}
