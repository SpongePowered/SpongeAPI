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
package org.spongepowered.api.title;

import org.spongepowered.api.Game;
import org.spongepowered.api.entity.Player;
import org.spongepowered.api.text.Message;

/**
 * Represents a configuration of a title. It consists of a main title and a
 * sub title and will {@link #fadeIn(int) fade in}, {@link #stay(int) stay} and
 * {@link #fadeOut(int) fade out} for a specified amount of time.
 */
public interface Title {

    /**
     * Set the title to send to the player.
     *
     * @param text The text to use as the title.
     * @return This title configuration.
     */
    Title title(String text);

    /**
     * Set the title to send to the player.
     *
     * @param message The message to use as the title.
     * @return This title configuration.
     */
    Title title(Message message);

    /**
     * Set the subtitle to send to the player.
     *
     * @param text The text to use as the subtitle.
     * @return This title configuration.
     */
    Title subTitle(String text);

    /**
     * Set the subtitle to send to the player.
     *
     * @param message The message to use as the subtitle.
     * @return This title configuration.
     */
    Title subTitle(Message message);

    /**
     * Set the duration in ticks of the fade in effect of the title. Once this
     * period of time is over the title will stay for the amount of time
     * specified in {@link #stay(int)}.
     *
     * <p>The default value for Vanilla is 20 (1 second).</p>
     *
     * @param ticks The amount of ticks (1/20 second) for the fade in effect.
     * @return This title configuration.
     */
    Title fadeIn(int ticks);

    /**
     * Set the duration in ticks how long the title should stay on the screen.
     * Once this period of time is over the title will fade out using the
     * duration specified in {@link #fadeOut(int)}.
     *
     * <p>The default value for Vanilla is 60 (3 seconds).</p>
     *
     * @param ticks The amount of ticks (1/20 second) for the fade in effect.
     * @return This title configuration.
     */
    Title stay(int ticks);

    /**
     * Set the duration in ticks of the fade out effect of the title.
     *
     * <p>The default value for Vanilla Minecraft is 60 (3 seconds).</p>
     *
     * @param ticks The amount of ticks (1/20 second) for the fade out effect.
     * @return This title configuration.
     */
    Title fadeOut(int ticks);


    /**
     * Remove the currently displayed title from the player's screen. This will
     * keep the currently used display times and will only remove the title.
     *
     * @return This title configuration.
     */
    Title clear();

    /**
     * Remove the currently displayed title from the player's screen
     * and set the configuration back to the default values.
     *
     * @return This title configuration.
     */
    Title reset();


    /**
     * Send this title configuration to the specified player. This is the same
     * as calling {@link Player#sendTitle(Title)}.
     *
     * @param player The player to send the title to.
     * @return This title configuration.
     */
    Title send(Player player);
}
