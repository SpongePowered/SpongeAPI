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
package org.spongepowered.api.event.keyboard;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.keyboard.KeyBinding;
import org.spongepowered.api.keyboard.KeyCode;

import java.util.Optional;

/**
 * Is fired when a {@link Player} the {@link KeyCode}
 * of a specific {@link KeyBinding} modifies.
 */
public interface PlayerChangeKeyCodeEvent extends PlayerKeyboardEvent {

    /**
     * Gets the previous (old) {@link KeyCode}, may be {@link Optional#empty()}
     * if it was previously not set.
     *
     * @return The old key code
     */
    Optional<KeyCode> getOldKeyCode();

    /**
     * Gets the new {@link KeyCode}, may be {@link Optional#empty()}
     * if there is no key code the assigned to the {@link KeyBinding}.
     *
     * @return The new key code
     */
    Optional<KeyCode> getNewKeyCode();
}
