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
package org.spongepowered.api.entity;


import org.spongepowered.api.data.Keys;
import org.spongepowered.api.entity.living.player.gamemode.GameModes;
import org.spongepowered.math.vector.Vector3d;

import java.util.function.Predicate;

public final class EntityPredicates {

    // TODO - decide whether we want this in the implementation or not.

    public static final Predicate<? super Entity> NO_SPECTATOR = entity -> entity.get(Keys.GAME_MODE)
        .map(gamemode -> gamemode == GameModes.SPECTATOR.get())
        .orElse(false);

    public static final Predicate<? super Entity> STILL_ALIVE = entity -> !entity.isRemoved() && entity.get(Keys.HEALTH).map(hp -> hp > 0).orElse(false);

    public static Predicate<? super Entity> withinDistance(double x, double y, double z, double distance) {
        final double distSqrd = distance * distance;
        return entity -> {
            if (entity == null) {
                return false;
            }
            final Vector3d pos = entity.getLocation().getPosition();
            final double xDist = pos.getX() - x;
            final double yDist = pos.getY() - y;
            final double zDist = pos.getZ() - z;
            return xDist*xDist + yDist * yDist + zDist * zDist <= distSqrd;
        };
    }

}
