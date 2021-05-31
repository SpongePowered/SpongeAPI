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
public interface WorldBorder {

    /**
     * Creates a new {@link Builder} instance for making {@link WorldBorder}s.
     *
     * @return The builder
     */
    static Builder builder() {
        return Sponge.game().builderProvider().provide(Builder.class);
    }

    /**
     * Gets a {@link WorldBorder} that represents the default border values for
     * a newly created overworld.
     *
     * @return A {@link WorldBorder} that represents the default values
     */
    static WorldBorder defaultBorder() {
        return WorldBorder.builder().overworldDefaults().build();
    }

    /**
     * Creates a new {@link Builder} instance for making {@link WorldBorder}s,
     * pre-populated with the values of this border.
     *
     * @return The builder
     */
    default Builder toBuilder() {
        return WorldBorder.builder().from(this);
    }

    /**
     * Gets the center of the world border.
     *
     * <p>The x coordinated can be retrieved through {@link Vector2d#x()}, while
     * the z coordinated can be retrieved through {@link Vector2d#y()}.</p>
     *
     * @return The center
     */
    Vector2d center();

    /**
     * Gets the current diameter of this world border. If this is an immutable
     * border, this is the initial diameter.
     *
     * <p>The returned diameter applies to the x and z axis. The world border
     * extends over the entire y-axis.</p>
     *
     * @return The size
     */
    double diameter();

    /**
     * Gets the target diameter the world border is expanding or contracting to.
     *
     * <p>This will return the same value as {@link #diameter()} unless
     * {@link #timeUntilTargetDiameter()} is greater than 0.</p>
     *
     * @return The diameter being changed to
     */
    double targetDiameter();

    /**
     * Gets the time remaining until the world border stops expanding or
     * contracting to the {@link #targetDiameter()}.
     *
     * <p>If {@link #diameter()} and {@link #targetDiameter()} are the same,
     * this will be {@link Duration#ZERO}.</p>
     *
     * @return The time remaining
     */
    Duration timeUntilTargetDiameter();

    /**
     * Gets the distance a player may be outside the world border before taking
     * damage.
     *
     * @return The distance
     */
    double safeZone();

    /**
     * Gets the damage done to a player per block per tick when outside the
     * buffer.
     *
     * @return The damage amount
     */
    double damagePerBlock();

    /**
     * Gets the time when a contracting world border will warn a player for whom
     * the world border will reach in {@code time} seconds.
     *
     * <p>In Minecraft, the warning is displayed in the form of a reddish
     * tint.</p>
     *
     * @return The warning time
     */
    Duration warningTime();

    /**
     * Gets the distance when a contracting world border will warn a player for
     * whom the world border is {@code distance} away.
     *
     * <p>In Minecraft, the warning is displayed in the form of a reddish
     * tint.</p>
     *
     * @return The distance
     */
    int warningDistance();

    interface Builder extends CopyableBuilder<WorldBorder, Builder>, org.spongepowered.api.util.Builder<WorldBorder, Builder> {

        /**
         * Copies the required data from the passed {@code WorldBorder}.
         *
         * @param border The world border whose data is to be copied
         * @return The builder, for chaining
         */
        @Override
        Builder from(final WorldBorder border);

        /**
         * Sets all values in this builder to the default border for a standard
         * Minecraft overworld.
         *
         * <p>This is not the same as calling {@link #reset()}, which
         * unsets all values, requiring at a {@link #targetDiameter(double)} to
         * be set befor this can be built.</p>
         *
         * @return This builder, for chaining.
         */
        Builder overworldDefaults();

        /**
         * Sets the center of this world border.
         *
         * @param x The x-coordinate of the new centre
         * @param z The z-coordinate of the new centre
         * @return The builder, for chaining
         */
        Builder center(final double x, final double z);

        /**
         * Sets the initial diameter of this world border.
         *
         * <p>If this differs from the the value supplied to
         * {@link #targetDiameter(double)}, then the border size starts at the
         * diameter specified here, growing or shrinking at a constant speed for
         * the time provided in {@link #timeToTargetDiameter(Duration)} where it
         * will stop at the supplied target. If the supplied time is zero or not
         * given, then this value is ignored and the target diameter is used.</p>
         *
         * <p>If this is set but {@link #targetDiameter(double)} has not, then
         * this also sets that target diameter.</p>
         *
         * @param size The diameter that this border will have when this
         *             {@link WorldBorder} is set.
         * @return The builder, for chaining.
         */
        Builder initialDiameter(final double size);

        /**
         * Sets the final diameter of this world border.
         *
         * <p>If no {@link #timeToTargetDiameter(Duration)} is set, or it is set
         * to {@link Duration#ZERO}, then the {@link #initialDiameter(double)}
         * is ignored and this is the only diameter used.</p>
         *
         * <p>If this is set but {@link #initialDiameter(double)} has not, then
         * this also sets that initial diameter.</p>
         *
         * @param size The diameter that this border will have.
         * @return The builder, for chaining.
         */
        Builder targetDiameter(final double size);

        /**
         * Sets how long this border will take to contract or expand from
         * {@link #initialDiameter(double) the initial diameter} to
         * {@link #targetDiameter(double) its target diameter}.
         *
         * @param time The time, as a {@link Duration}
         * @return The builder, for chaining.
         */
        Builder timeToTargetDiameter(final Duration time);

        /**
         * Sets the distance beyond this world border that an entity may travel
         * before incurring damage.
         *
         * @param safeZone The distance in blocks
         * @return The builder, for chaining.
         */
        Builder safeZone(final double safeZone);

        /**
         * Sets the damage caused by being out of the world border.
         *
         * @param damagePerBlock The damage amount
         * @return The builder, for chaining
         */
        Builder damagePerBlock(final double damagePerBlock);

        /**
         * Sets the warning time of this world border.
         *
         * @param warningTime The warning time
         * @return The builder, for chaining
         */
        Builder warningTime(final Duration warningTime);

        /**
         * Sets the warning distance of this world border.
         *
         * @param warningDistance The warning distance
         * @return The builder, for chaining
         */
        Builder warningDistance(final double warningDistance);

        /**
         * Builds the world border from the information given.
         *
         * @return The built world border
         */
        @Override
        WorldBorder build();

    }

}
