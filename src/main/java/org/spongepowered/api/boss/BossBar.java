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
package org.spongepowered.api.boss;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Identifiable;

/**
 * Represents a boss bar.
 */
public interface BossBar extends Identifiable {

    /**
     * Gets the name of this boss bar.
     *
     * @return The boss bar name
     */
    Text getName();

    /**
     * Sets the name of this boss bar.
     *
     * @param name The boss bar name
     * @return This boss bar
     */
    BossBar setName(Text name);

    /**
     * Gets the percent.
     *
     * @return The percent
     */
    float getPercent();

    /**
     * Sets the percent.
     *
     * <p>The percent must be between {@code 0.0} and {@code 1.0}.</p>
     *
     * @param percent The percent
     * @return This boss bar
     */
    BossBar setPercent(float percent);

    /**
     * Gets the color.
     *
     * @return The color of the boss bar
     */
    BossBarColor getColor();

    /**
     * Sets the color.
     *
     * @param color The color of the boss bar
     * @return This boss bar
     */
    BossBar setColor(BossBarColor color);

    /**
     * Gets the overlay.
     *
     * @return The overlay
     */
    BossBarOverlay getOverlay();

    /**
     * Sets the overlay.
     *
     * @param overlay The overlay
     * @return This boss bar
     */
    BossBar setOverlay(BossBarOverlay overlay);

    /**
     * If the sky should darken.
     *
     * @return If the sky should darken
     */
    boolean shouldDarkenSky();

    /**
     * Sets if the sky should darken.
     *
     * @param darkenSky If the sky should darken
     * @return This boss bar
     */
    BossBar setDarkenSky(boolean darkenSky);

    /**
     * If the end boss music should be played.
     *
     * @return If the end boss music should be played
     */
    boolean shouldPlayEndBossMusic();

    /**
     * Sets if the end boss music should be played.
     *
     * @param playEndBossMusic If the end boss music should be played
     * @return This boss bar
     */
    BossBar setPlayEndBossMusic(boolean playEndBossMusic);

    /**
     * If fog should be created.
     *
     * @return If fog should be created
     */
    boolean shouldCreateFog();

    /**
     * Sets if fog should be created.
     *
     * @param createFog If fog should be created
     * @return This boss bar
     */
    BossBar setCreateFog(boolean createFog);

}
