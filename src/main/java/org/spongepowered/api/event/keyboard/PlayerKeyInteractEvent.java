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
import org.spongepowered.api.keyboard.KeyInteractHandler;

import java.util.List;

/**
 * Is fired when a {@link Player} interacts with the {@link KeyCode}
 * attached to a {@link KeyBinding}.
 */
public interface PlayerKeyInteractEvent extends PlayerKeyboardEvent {

    /**
     * Gets a list with all the {@link KeyInteractHandler}s that will
     * be used or were used to handle the key input.
     *
     * <p>This list may be mutable but that depends on the type of the
     * event being thrown. The default implementation will always be
     * immutable.</p>
     *
     * @return The key interaction handlers
     */
    List<KeyInteractHandler> getHandlers();

    /**
     * Is fired when a {@link Player} a {@link KeyCode} pressed
     * that is assigned to a {@link KeyBinding}.
     */
    interface Press extends PlayerKeyInteractEvent {

        /**
         * Is fired before all the {@link KeyInteractHandler}s
         * are executed.
         */
        interface Pre extends Press {

            /**
             * Gets an mutable list of the {@link KeyInteractHandler}s.
             *
             * @return A mutable list of key interaction handlers
             */
            @Override
            List<KeyInteractHandler> getHandlers();
        }

        /**
         * Is fired after all the {@link KeyInteractHandler}s
         * are executed.
         */
        interface Post extends Press {

        }
    }

    /**
     * Is fired when a {@link Player} a {@link KeyCode} releases
     * that is assigned to a {@link KeyBinding}.
     */
    interface Release extends PlayerKeyInteractEvent {

        /**
         * Gets the amount of time in ticks that the {@link KeyCode}
         * was pressed before it was released.
         *
         * @return The press time in ticks
         */
        int getPressTime();

        /**
         * Is fired before all the {@link KeyInteractHandler}s
         * are executed.
         */
        interface Pre extends Release {

            /**
             * Gets an mutable list of the {@link KeyInteractHandler}s.
             *
             * @return A mutable list of key interaction handlers
             */
            @Override
            List<KeyInteractHandler> getHandlers();
        }

        /**
         * Is fired after all the {@link KeyInteractHandler}s
         * are executed.
         */
        interface Post extends Release {

        }
    }
}
