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
import org.spongepowered.api.event.entity.living.humanoid.player.TargetPlayerEvent;
import org.spongepowered.api.keyboard.KeyBinding;

import java.util.Set;

/**
 * Is fired when a {@link Player} joins and allows you to define per player
 * to enable a {@link KeyBinding}. This is the only time you will be able to
 * modify which {@link KeyBinding} are visible/usable for a specific player.
 *
 * <p>This event will only be called for {@link Player}s that have a client
 * that supports custom key bindings.</p>
 */
public interface RegisterKeyBindingsEvent extends TargetPlayerEvent {

    /**
     * Gets a mutable set with all the {@link KeyBinding}s that will be
     * available for the {@link Player}.
     *
     * <p>This set does not contain any of the default {@link KeyBinding}s
     * because you cannot enable/disable them, adding them to the set will
     * have no effect.</p>
     *
     * @return The key bindings
     */
    Set<KeyBinding> getKeyBindings();

}
