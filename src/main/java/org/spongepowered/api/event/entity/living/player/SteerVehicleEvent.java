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
package org.spongepowered.api.event.entity.living.player;

import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Event;
import org.spongepowered.api.util.annotation.eventgen.GenerateFactoryMethod;

/**
 * Called each tick for all {@link ServerPlayer players} riding a vehicle.
 */
@GenerateFactoryMethod
public interface SteerVehicleEvent extends Event {

    /**
     * Get the {@link ServerPlayer player}.
     *
     * @return The player
     */
    ServerPlayer player();

    /**
     * Get whether the player is steering left or right.
     *
     * @return The sway
     */
    Sway sway();

    /**
     * Get whether the player is steering forwards or backwards.
     *
     * @return The surge
     */
    Surge surge();

    /**
     * Get whether the player is attempting to jump.
     *
     * @return Whether the player is attempting to jump.
     */
    boolean jump();

    /**
     * Get whether the player is attempting to dismount the entity.
     *
     * @return Whether the player is attempting to dismount the entity.
     */
    boolean unmount();

    /**
     * The possible scenarios of steering left or right.
     */
    enum Sway {

        /**
         * The player is not steering left or right.
         */
        NONE(0),

        /**
         * The player is steering right.
         */
        RIGHT(-1),

        /**
         * The player is steering left.
         */
        LEFT(1);

        private final int direction;

        Sway(int direction) {
            this.direction = direction;
        }

        /**
         * The direction represented numerically.
         *
         * @return The numeric representation of the direction.
         */
        public int direction() {
            return this.direction;
        }

        /**
         * Get the direction from it's numerical value.
         *
         * @param f The numerical value
         * @return The direction
         */
        public static Sway valueOf(float f) {
            if (f > 0) {
                return LEFT;
            } else if (f < 0) {
                return RIGHT;
            }

            return NONE;
        }

    }

    /**
     * The possible scenarios of steering forwards or backwards.
     */
    enum Surge {

        /**
         * The player is not steering forwards or backwards.
         */
        NONE(0),

        /**
         * The player is steering backwards.
         */
        BACKWARDS(-1),

        /**
         * The player is steering forwards.
         */
        FORWARDS(1);

        private final int direction;

        Surge(int direction) {
            this.direction = direction;
        }

        /**
         * The direction represented numerically.
         *
         * @return The numeric representation of the direction.
         */
        public int direction() {
            return this.direction;
        }

        /**
         * Get the direction from it's numerical value.
         *
         * @param f The numerical value
         * @return The direction
         */
        public static Surge valueOf(float f) {
            if (f > 0) {
                return FORWARDS;
            } else if (f < 0) {
                return BACKWARDS;
            }

            return NONE;
        }
    }

}
