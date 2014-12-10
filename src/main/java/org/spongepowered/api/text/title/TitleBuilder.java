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
 * Represents a builder interface to create immutable {@link Title}
 * configurations.
 */
public interface TitleBuilder {

    /**
     * Set the title to send to the player.
     *
     * @param text The text to use as the title
     * @return This title builder
     */
    TitleBuilder title(Text text);

    /**
     * Set the subtitle to send to the player.
     *
     * @param text The text to use as the subtitle
     * @return This title builder
     */
    TitleBuilder subtitle(Text text);

    /**
     * Set the duration in ticks of the fade in effect of the title. Once this
     * period of time is over the title will stay for the amount of time
     * specified in {@link #stay(int)}.
     *
     * <p>
     * The default value for Vanilla is 20 (1 second).
     * </p>
     *
     * @param ticks The amount of ticks (1/20 second) for the fade in effect
     * @return This title builder
     */
    TitleBuilder fadeIn(int ticks);

    /**
     * Set the duration in ticks how long the title should stay on the screen.
     * Once this period of time is over the title will fade out using the
     * duration specified in {@link #fadeOut(int)}.
     *
     * <p>
     * The default value for Vanilla is 60 (3 seconds).
     * </p>
     *
     * @param ticks The amount of ticks (1/20 second) to stay
     * @return This title builder
     */
    TitleBuilder stay(int ticks);

    /**
     * Set the duration in ticks of the fade out effect of the title.
     *
     * <p>
     * The default value for Vanilla is 20 (1 second).
     * </p>
     *
     * @param ticks The amount of ticks (1/20 second) for the fade out effect
     * @return This title builder
     */
    TitleBuilder fadeOut(int ticks);

    /**
     * Remove the currently displayed title from the player's screen. This will
     * keep the currently used display times and will only remove the title.
     *
     * @return This title builder
     */
    TitleBuilder clear();

    /**
     * Remove the currently displayed title from the player's screen and set the
     * configuration back to the default values.
     *
     * @return This title builder
     */
    TitleBuilder reset();

    /**
     * Builds an immutable instance of the current configuration.
     *
     * @return An immutable {@link Title} with the currently configured settings
     */
    Title build();

}
