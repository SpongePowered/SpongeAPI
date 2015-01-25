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

import com.google.common.base.Optional;
import org.spongepowered.api.text.Text;

/**
 * Represents an immutable configuration for an in-game title. Instances of this
 * interface can be created through the {@link TitleBuilder} by calling
 * {@link Titles#builder()}.
 *
 * <p> All properties of a title are optional - if they are not set it will use
 * the current default values from the client. </p>
 */
public interface Title {

    /**
     * Returns the title of this title configuration.
     *
     * @return The {@link Text} of the title, if it was configured
     */
    Optional<Text> getTitle();

    /**
     * Returns the subtitle of this title configuration.
     *
     * @return The {@link Text} of the subtitle, if it was configured
     */
    Optional<Text> getSubtitle();

    /**
     * Returns the specified time to fade in the title on the client. Once this
     * period of time is over, the title will stay for the amount of time from
     * {@link #getStay}.
     *
     * <p> The default value for Vanilla is 20 (1 second). </p>
     *
     * @return The amount of ticks (1/20 second) for the fade in effect
     */
    Optional<Integer> getFadeIn();

    /**
     * Returns the specified time how long the title should stay on the client.
     * Once this period of time is over, the title will fade out using the
     * duration specified from {@link #getFadeOut}.
     *
     * <p> The default value for Vanilla is 60 (3 second). </p>
     *
     * @return The amount of ticks (1/20 second) for the stay effect
     */
    Optional<Integer> getStay();

    /**
     * Returns the specified time to fade out the title on the client.
     *
     * <p> The default value for Vanilla is 20 (1 second). </p>
     *
     * @return The amount of ticks (1/20 second) for the fade out effect
     */
    Optional<Integer> getFadeOut();

    /**
     * Returns whether this configuration is clearing the current title from the
     * screen.
     *
     * @return True if the current title will be removed from the client's
     *         screen
     */
    boolean isClear();

    /**
     * Returns whether this configuration is clearing the current title from the
     * screen and resetting the current configuration to the default values.
     *
     * <p> This is recommended when you want to make sure to display a single
     * title. </p>
     *
     * @return True if the current settings will be reset to the defaults
     */
    boolean isReset();

    /**
     * Creates a new {@link TitleBuilder} using the configuration of this
     * instance.
     *
     * @return A new builder to modify this Title configuration
     */
    TitleBuilder builder();

}
