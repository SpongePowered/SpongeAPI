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
package org.spongepowered.api.keyboard;

import org.spongepowered.api.entity.living.player.Player;

/**
 * Represents a {@link KeyBinding} held by a specific {@link Player}.
 */
public interface PlayerKeyBinding {

    /**
     * Gets the {@link Player} this binding is attached to.
     *
     * @return The player
     */
    Player getPlayer();

    /**
     * Gets the {@link KeyBinding}.
     *
     * @return The key binding
     */
    KeyBinding getBinding();

    /**
     * Gets whether the key of the {@link KeyBinding} is currently
     * pressed by the {@link Player}.
     *
     * @return Is pressed
     */
    boolean isPressed();

    /**
     * Gets the amount of time the key of the {@link KeyBinding} is
     * currently being pressed without releasing the key.
     *
     * @return The pressed time in ticks
     */
    int getPressedTime();

    /**
     * Gets whether the key binding is enabled for the {@link Player}. If it's
     * set to {@code false}, then will the {@link KeyBinding} be hidden on the
     * client, making the {@link Player} unable to modify it.
     *
     * @return Is enabled
     */
    boolean isEnabled();

    /**
     * Sets whether the key binding is enabled for the {@link Player}. If it's
     * set to {@code false}, then will the {@link KeyBinding} be hidden on the
     * client, making the {@link Player} unable to modify it.
     *
     * @param enabled Is enabled
     */
    void setEnabled(boolean enabled);
}
