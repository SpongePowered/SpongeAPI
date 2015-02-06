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

import org.spongepowered.api.text.Text;

/**
 * Utility class to create instances of {@link TitleBuilder}.
 */
public final class Titles {

    public static final Title EMPTY = new Title();
    public static final Title CLEAR = new Title(null, null, null, null, null, true, false);
    public static final Title RESET = new Title(null, null, null, null, null, false, true);

    private Titles() {
    }

    /**
     * Returns a {@link Title} that will simply do nothing when it is sent to
     * the client.
     *
     * @return An empty title instance
     */
    public static Title of() {
        return EMPTY;
    }

    /**
     * Returns a {@link Title} that will display the given main title on the
     * player's screen.
     *
     * @param title The title to display
     * @return The created title
     */
    public static Title of(Text title) {
        return builder().title(title).build();
    }

    /**
     * Returns a {@link Title} that will display the given main and subtitle on
     * the player's screen.
     *
     * @param title The title to display
     * @param subtitle The subtitle to display
     * @return The created title
     */
    public static Title of(Text title, Text subtitle) {
        return builder().title(title).subtitle(subtitle).build();
    }

    /**
     * Returns a {@link Title} that will clear the currently displayed
     * {@link Title} from the player's screen.
     *
     * @return A title configuration that will clear
     */
    public static Title clear() {
        return CLEAR;
    }

    /**
     * Returns a {@link Title} that will reset the current title back to default
     * values on the client.
     *
     * @return A title configuration that will reset
     */
    public static Title reset() {
        return RESET;
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
        return new TitleBuilder();
    }

}
