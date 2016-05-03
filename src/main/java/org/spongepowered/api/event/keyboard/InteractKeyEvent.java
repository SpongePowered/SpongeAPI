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
import org.spongepowered.api.event.Cancellable;
import org.spongepowered.api.keyboard.KeyBinding;

import java.util.function.BiConsumer;

/**
 * Is fired when a {@link Player} interacts with a {@link KeyBinding}.
 */
public interface InteractKeyEvent extends KeyboardEvent {

    /**
     * Is fired when a {@link Player} a pressed the
     * key assigned to a {@link KeyBinding}.
     */
    interface Press extends InteractKeyEvent {

        /**
         * Is fired before the {@link KeyBinding}s press executor, may be cancelled
         * to cancel the executor.
         *
         * @see KeyBinding.Builder#pressExecutor(BiConsumer)
         */
        interface Pre extends Press, Cancellable {

        }

        /**
         * Is fired after the {@link KeyBinding}s press executor and
         * if the {@link Pre} event wasn't cancelled.
         *
         * @see KeyBinding.Builder#pressExecutor(BiConsumer)
         */
        interface Post extends Press {

        }
    }

    /**
     * Is fired when a every tick when a {@link Player} holds the
     * key assigned to a {@link KeyBinding}.
     */
    interface Tick extends InteractKeyEvent {

        /**
         * Gets the amount of time in ticks that the key
         * is currently being pressed.
         *
         * @return The press time in ticks
         */
        int getPressTime();

        /**
         * Is fired before the {@link KeyBinding}s tick executor, may be cancelled
         * to cancel the executor.
         *
         * @see KeyBinding.Builder#tickExecutor(BiConsumer)
         */
        interface Pre extends Tick, Cancellable {

        }

        /**
         * Is fired after the {@link KeyBinding}s tick executor and
         * if the {@link Pre} event wasn't cancelled.
         *
         * @see KeyBinding.Builder#tickExecutor(BiConsumer)
         */
        interface Post extends Tick {

        }
    }

    /**
     * Is fired when a {@link Player} a released the
     * key assigned to a {@link KeyBinding}.
     */
    interface Release extends InteractKeyEvent {

        /**
         * Gets the amount of time in ticks that the key
         * was pressed before it was released.
         *
         * @return The press time in ticks
         */
        int getPressTime();

        /**
         * Is fired before the {@link KeyBinding}s release executor, may be cancelled
         * to cancel the executor.
         *
         * @see KeyBinding.Builder#releaseExecutor(BiConsumer)
         */
        interface Pre extends Release, Cancellable {

        }

        /**
         * Is fired after the {@link KeyBinding}s release executor and
         * if the {@link Pre} event wasn't cancelled.
         *
         * @see KeyBinding.Builder#releaseExecutor(BiConsumer)
         */
        interface Post extends Release {

        }
    }
}
