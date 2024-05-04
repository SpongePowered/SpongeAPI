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
package org.spongepowered.api.entity.display;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.data.Keys;
import org.spongepowered.api.util.Color;

public interface TextDisplay extends DisplayEntity {

    /**
     * Returns the displayed text
     *
     * @return the displayed text
     */
    default Component displayedText() {
        return this.require(Keys.DISPLAY_NAME);
    }

    /**
     * Gets the maximum line width used to split lines of text.
     *
     * @return The maximum line width used to split lines of text
     */
    default int lineWidth() {
        return this.require(Keys.LINE_WIDTH);
    }

    /**
     * Gets the opacity of the displayed text.
     *
     * @return The opacity of the displayed text
     */
    default int textOpacity() {
        return this.require(Keys.OPACITY);
    }

    /**
     * Checks if the displayed text is visible through blocks.
     *
     * @return True if the displayed text is visible through blocks, false otherwise
     */
    default boolean canSeeThroughBlocks() {
        return this.require(Keys.SEE_THROUGH_BLOCKS);
    }

    /**
     * Checks if the displayed text has a shadow.
     *
     * @return True if the displayed text has a shadow, false otherwise
     */
    default boolean hasShadow() {
        return this.require(Keys.HAS_TEXT_SHADOW);
    }

    /**
     * Gets the background color of the displayed text.
     * Note that this supports alpha values.
     *
     * @return The background color of the displayed text
     */
    default Color backgroundColor() {
        return this.require(Keys.TEXT_BACKGROUND_COLOR);
    }

    /**
     * Gets the background color of the displayed text.
     *
     * @return The background color of the displayed text
     */
    default boolean defaultBackground() {
        return this.require(Keys.HAS_DEFAULT_BACKGROUND);
    }

    /**
     * Gets the alignment direction of the displayed text.
     *
     * @return The alignment direction of the displayed text
     */
    default TextAlignment textAlignment() {
        return this.require(Keys.TEXT_ALIGNMENT);
    }

}
