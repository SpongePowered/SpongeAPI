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
package org.spongepowered.api.event.entity.living.humanoid;

import org.spongepowered.api.entity.living.Humanoid;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.event.entity.living.humanoid.player.TargetPlayerEvent;
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;

/**
 * Called when a {@link Humanoid} changes {@link GameMode}.
 */
@GenerateFactoryMethod
public interface ChangeGameModeEvent extends TargetHumanoidEvent, Cancellable {

    /**
     * Gets the original {@link GameMode}.
     *
     * @return The original {@link GameMode}.
     */
    GameMode getOriginalGameMode();

    /**
     * Gets the new {@link GameMode}.
     *
     * @return The new {@link GameMode}.
     */
    GameMode getGameMode();

    /**
     * Sets the new {@link GameMode}.
     *
     * @param gameMode The new {@link GameMode} value.
     */
    void setGameMode(GameMode gameMode);

    interface TargetPlayer extends ChangeGameModeEvent, TargetPlayerEvent {}
}
