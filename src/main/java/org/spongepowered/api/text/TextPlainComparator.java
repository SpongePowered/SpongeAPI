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
package org.spongepowered.api.text;

import java.util.Comparator;

/**
 * Represents a comparator for {@link Text} that works based on the plain version of that text,
 * or the best string representation that text can have using {@link Texts#toPlain(Text)}. Once
 * that conversion is made, the order is essentially lexicographic order with strings.
 */
public class TextPlainComparator implements Comparator<Text> {

    /**
     * The instance that is held for static access in {@link #getInstance()}.
     */
    private static final TextPlainComparator INSTANCE = new TextPlainComparator();

    @Override
    public int compare(Text o1, Text o2) {
        return Texts.toPlain(o1).compareTo(Texts.toPlain(o2));
    }

    /**
     * Retrieves the available {@link TextPlainComparator} instance from this singleton.
     *
     * @return An instance
     */
    public static TextPlainComparator getInstance() {
        return INSTANCE;
    }

}
