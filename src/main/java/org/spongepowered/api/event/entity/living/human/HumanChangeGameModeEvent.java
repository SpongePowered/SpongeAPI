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

package org.spongepowered.api.event.entity.living.human;

import org.spongepowered.api.entity.living.Human;
import org.spongepowered.api.entity.player.gamemode.GameMode;
import org.spongepowered.api.util.event.Cancellable;

/**
 * Called when a {@link Human} changes {@link GameMode}.
 */
public interface HumanChangeGameModeEvent extends HumanEvent, Cancellable {

    /**
     * Gets the old {@link GameMode} of the human.
     *
     * @return The old {@link GameMode}.
     */
    GameMode getOldGameMode();

    /**
     * Gets the new {@link GameMode} of the human.
     *
     * @return The new {@link GameMode}.
     */
    GameMode getNewGameMode();

    /**
     * Sets the new {@link GameMode} of the human.
     *
     * @param newGameMode The new {@link GameMode} value.
     */
    void setNewGameMode(GameMode newGameMode);
}
