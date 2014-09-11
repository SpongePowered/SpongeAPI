/**
 * This file is part of SpongeAPI, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2014 SpongePowered <http://spongepowered.org/>
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
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.spongepowered.api.title;

import java.util.List;

import org.spongepowered.api.entity.Player;

public interface Title {

    /**
     * Get the main title from Title.
     *
     * @return The main title
     */
    String getTitle();

    /**
     * Get subtitles list from this Title.
     *
     * @return The subtitles list.
     */
    List<String> getSubTitles();

    /**
     * Get the amount of ticks (1/20 second) for the fade out effect.
     *
     * @return ticks
     */
    int getFadeOut();

    /**
     * Get the amount of ticks (1/20 second) for the fade in effect.
     *
     * @return ticks
     */
    int getFadeIn();

    /**
     * Get the amount of ticks for the stay time.
     *
     * @return ticks
     */
    int getStayTime();

    /**
     * Set the main title from Title.
     *
     * @param msg The main title.
     */
    void setTitle(String msg);

    /**
     * Set a new subtitles list for Title.
     *
     * @param titles A new subtitles list.
     */
    void setSubTitles(List<String> titles);

    /**
     * Add a new subtitle to Subtitles list.
     *
     * @param msg A subtitle.
     */
    void addSubTitle(String msg);

    /**
     * Remove a subtitle by index.
     *
     * @param index at which the specified element is to be removed.
     */
    void removeSubTitle(int index);

    /**
     * Set the duration in ticks of the fade out effect of the title.
     *
     * @param ticks The amount of ticks (1/20 second) for the fade in effect.
     */
    void setFadeOut(int ticks);

    /**
     * Set the duration in ticks how long the title should stay on the screen.
     *
     * @param ticks The amount of ticks (1/20 second) for the fade out effect.
     */
    void setFadeIn(int ticks);

    /**
     * Set the duration in ticks how long the title should stay on the screen.
     *
     * @param ticks The amount of ticks (1/20 second) for the stay time.
     */
    void setStayTime(int ticks);

    /**
     * Send this title configuration to the specified player.
     * 
     * @param player The player to send the title to.
     */
    void sendTo(Player player);
}
