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
package org.spongepowered.api.world.border;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.math.vector.Vector2d;

import java.time.Duration;

/**
 * A world border is a square boundary, extending through the entire y-axis.
 *
 * <p>It can gradually grow or shrink to a radius over a period of time. A
 * warning is displayed when a contracting world border will reach the player in
 * a certain amount of time, or when the player is a certain number of blocks
 * away.</p>
 *
 * <p>In Minecraft, a warning is displayed in the form of a reddish tint.</p>
 */
public interface MutableWorldBorder extends WorldBorder {

    /**
     * Creates a new {@link Builder} instance for making {@link MutableWorldBorder}s.
     * 
     * @return The builder
     */
    static Builder builder() {
        return Sponge.getGame().getBuilderProvider().provide(Builder.class);
    }

    /**
     * Sets the center of the world border.
     *
     * @param center The center of the world border
     */
    default void setCenter(final Vector2d center) {
        this.setCenter(center.getX(), center.getY()); // (X, Z) but Vector2d uses Y in place of Z
    }

    /**
     * Sets the center of the world border.
     *
     * @param x The x-axis center of the world border
     * @param z The z-axis center of the world border
     */
    void setCenter(final double x, final double z);

    /**
     * Sets the size of the world border.
     *
     * <p>The specified size applies to the x and z axis. The world border
     * extends over the entire y-axis.</p>
     *
     * @param size The size
     */
    void setSize(final double size);

    /**
     * Sets the size of the world border, over the given duration.
     *
     * <p>The world border size increases/decrease linearly over the
     * specified time. The specified size applies to the x and z axis. The
     * world border extends over the entire y-axis.</p>
     *
     * @param size The size where the border will expand/contract to
     * @param duration The duration over which to change
     */
    default void setSize(final double size, final Duration duration) {
        this.setSize(this.getSize(), size, duration);
    }

    /**
     * Sets the starting size and the ending size of the world border,
     * over the given duration.
     *
     * <p>The world border size increases/size linearly over the
     * specified time. The specified size applies to the x and z axis. The
     * world border extends over the entire y-axis.</p>
     *
     * @param oldSize The size where the border will start
     * @param newSize The size where the border will end
     * @param duration The duration over which to change
     */
    void setSize(final double oldSize, final double newSize, final Duration duration);

    /**
     * Sets the distance a player may be be outside the world border before
     * taking damage.
     *
     * @param safeZone The distance
     */
    void setSafeZone(final double safeZone);

    /**
     * Sets the damage done to a player per block per tick when outside the
     * buffer.
     *
     * @param damagePerBlock The damage amount
     */
    void setDamagePerBlock(final double damagePerBlock);

    /**
     * Sets the time when a contracting world border will warn a player for whom
     * the world border will reach in {@code time} seconds.
     *
     * <p>In Minecraft, the warning is displayed in the form of a reddish
     * tint.</p>
     *
     * @param time The time
     */
    void setWarningTime(final Duration time);

    /**
     * Sets the distance when a contracting world border will warn a player for
     * whom the world border is {@code distance} away.
     *
     * <p>In Minecraft, the warning is displayed in the form of a reddish
     * tint.</p>
     *
     * @param warningBlocks The distance
     */
    void setWarningBlocks(final int warningBlocks);

    /**
     * Gets the snapshot.
     *
     * @return The snapshot
     */
    Snapshot createSnapshot();

    /**
     * Sets the snapshot.
     *
     * @param snapshot The snapshot
     */
    void applySnapshot(final Snapshot snapshot);

    interface Snapshot extends WorldBorder {
    }

    interface Builder extends CopyableBuilder<MutableWorldBorder, Builder> {

        /**
         * Copies the required data from the passed {@code WorldBorder}.
         * 
         * @param border The world border whose data is to be copied
         * @return The builder, for chaining
         */
        @Override
        Builder from(final MutableWorldBorder border);

        /**
         * Sets the centre of this world border.
         *
         * @param x The x-coordinate of the new centre
         * @param z The z-coordinate of the new centre
         * @return The builder, for chaining
         * @see Snapshot#setCenter(double, double)
         */
        Builder center(final double x, final double z);

        /**
         * Sets the size of this world border.
         * 
         * @param size The size that this border will have.
         * @return The builder, for chaining.
         * @see Snapshot#setSize(double)
         */
        Builder size(final double size);

        /**
         * Sets the damage threshold of this world border.
         * 
         * @param safeZone The damage threshold in blocks
         * @return The builder, for chaining
         * @see Snapshot#setSafeZone(double) (double)
         */
        Builder safeZone(final double safeZone);

        /**
         * Sets the damage amount of this world border.
         * 
         * @param damagePerBlock The damage amount
         * @return The builder, for chaining
         * @see Snapshot#setDamagePerBlock(double) (double)
         */
        Builder damagePerBlock(final double damagePerBlock);

        /**
         * Sets the warning time of this world border.
         *
         * @param warningTime The warning time
         * @return The builder, for chaining
         * @see Snapshot#setWarningTime(Duration)
         */
        Builder warningTime(final Duration warningTime);

        /**
         * Sets the warning distance of this world border.
         *
         * @param warningBlocks The warning distance
         * @return The builder, for chaining
         * @see Snapshot#setWarningBlocks(int)
         */
        Builder warningBlocks(final int warningBlocks);
        
        /**
         * Builds the world border from the information given. If no information
         * is given, a {@code WorldBorder} with default properties is built.
         * 
         * @return The built world border
         */
        MutableWorldBorder build();
    }
}
