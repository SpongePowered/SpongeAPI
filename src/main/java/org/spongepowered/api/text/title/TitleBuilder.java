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

import javax.annotation.Nullable;

/**
 * Represents a builder interface to create immutable {@link Title}
 * configurations.
 */
public interface TitleBuilder {

    /**
     * Sets the title to send to the player.
     *
     * @param message The text to use as the title, or {@code null} to reset
     * @return This title builder
     */
    TitleBuilder title(@Nullable Text message);

    /**
     * Sets the subtitle to send to the player.
     *
     * @param message The text to use as the subtitle, or {@code null} to reset
     * @return This title builder
     */
    TitleBuilder subtitle(@Nullable Text message);

    /**
     * Sets the duration in ticks of the fade in effect of the title. Once this
     * period of time is over the title will stay for the amount of time
     * specified in {@link #stay(Integer)}.
     *
     * <p> The default value for Vanilla is 20 (1 second). </p>
     *
     * @param ticks The amount of ticks (1/20 second) for the fade in effect, or
     *            {@code null} to reset
     * @return This title builder
     */
    TitleBuilder fadeIn(@Nullable Integer ticks);

    /**
     * Sets the duration in ticks how long the title should stay on the screen.
     * Once this period of time is over the title will fade out using the
     * duration specified in {@link #fadeOut(Integer)}.
     *
     * <p> The default value for Vanilla is 60 (3 seconds). </p>
     *
     * @param ticks The amount of ticks (1/20 second) to stay, or {@code null}
     *            to reset
     * @return This title builder
     */
    TitleBuilder stay(@Nullable Integer ticks);

    /**
     * Sets the duration in ticks of the fade out effect of the title.
     *
     * <p> The default value for Vanilla is 20 (1 second). </p>
     *
     * @param ticks The amount of ticks (1/20 second) for the fade out effect,
     *            or {@code null} to reset
     * @return This title builder
     */
    TitleBuilder fadeOut(@Nullable Integer ticks);

    /**
     * Removes the currently displayed title from the player's screen. This will
     * keep the currently used display times and will only remove the title.
     *
     * @return This title builder
     */
    TitleBuilder clear();

    /**
     * Sets whether the the currently displayed title should be removed from the
     * player's screen and will keep the currently used display times.
     *
     * @param clear Whether this title should clear
     * @return This title builder
     */
    TitleBuilder clear(boolean clear);

    /**
     * Removes the currently displayed title from the player's screen and set
     * the configuration back to the default values.
     *
     * @return This title builder
     */
    TitleBuilder reset();

    /**
     * Sets whether the currently displayed title should be removed from the
     * player's screen and the configuration set back to the default values.
     *
     * @param reset Whether this title should reset
     * @return This title builder
     */
    TitleBuilder reset(boolean reset);

    /**
     * Builds an immutable instance of the current configuration.
     *
     * @return An immutable {@link Title} with the currently configured settings
     */
    Title build();

}
