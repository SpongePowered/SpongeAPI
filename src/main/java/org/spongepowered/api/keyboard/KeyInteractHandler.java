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

public interface KeyInteractHandler {

    /**
     * Handles that the {@link KeyCode} of the {@link PlayerKeyBinding} is
     * currently being pressed by the {@link Player}.
     *
     * @param player The player
     * @param playerKeyBinding The player key binding
     */
    void handlePress(Player player, PlayerKeyBinding playerKeyBinding);

    /**
     * Handles that the {@link KeyCode} of the {@link PlayerKeyBinding} is
     * currently being released by the {@link Player}.
     *
     * <p>It is safe to use the {@link PlayerKeyBinding#getPressedTime()}
     * inside this method, this value will be reset afterwards.</p>
     *
     * @param player The player
     * @param playerKeyBinding The player key binding
     */
    void handleRelease(Player player, PlayerKeyBinding playerKeyBinding);
}
