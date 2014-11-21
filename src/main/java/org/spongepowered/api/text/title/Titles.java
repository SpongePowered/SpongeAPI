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
package org.spongepowered.api.text.title;

/**
 * Utility class to create instances of {@link TitleBuilder}.
 */
public final class Titles {

    private static final TitleFactory factory = new NullTitleFactory();

    private Titles() {
    }

    /**
     * Creates a new {@link Title} configuration builder that will reset the
     * currently displayed Title on the client before displaying the new
     * configured one.
     *
     * @return A new {@link TitleBuilder}
     * @see #update
     */
    public static TitleBuilder builder() {
        return update().reset();
    }

    /**
     * Creates a new empty {@link Title} configuration builder. Unlike
     * {@link #builder} this won't reset the current Title on the client before
     * displaying the current one. This has less use cases but should be used if
     * just the previously sent Title should be updated.
     *
     * @return A new {@link TitleBuilder}
     * @see #builder
     */
    public static TitleBuilder update() {
        return factory.createTitleBuilder();
    }

}
