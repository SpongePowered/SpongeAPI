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
package org.spongepowered.api.world;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.math.vector.Vector3d;

import java.time.Duration;
import java.time.temporal.TemporalUnit;

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
        return Sponge.getRegistry().getBuilderRegistry().provideBuilder(Builder.class);
    }

    /**
     * Gets the diameter the world border is expanding or contracting to.
     *
     * <p>This will return the same value as {@link #getDiameter} unless
     * {@link #getTimeRemaining} is greater than 0.</p>
     *
     * @return The diameter being changed to
     */
    double getNewDiameter();

    /**
     * Gets the diameter of the world border.
     *
     * <p>The returned diameter applies to the x and z axis. The world border
     * extends over the entire y-axis.</p>
     *
     * @return The diameter
     */
    double getDiameter();

    /**
     * Sets the diameter of the world border.
     *
     * <p>The specified diameter applies to the x and z axis. The world border
     * extends over the entire y-axis.</p>
     *
     * @param diameter The diameter
     */
    void setDiameter(double diameter);

    /**
     * Sets the diameter of the world border, over the given duration.
     *
     * <p>The world border diameter increases/decrease linearly over the
     * specified time. The specified diameter applies to the x and z axis. The
     * world border extends over the entire y-axis.</p>
     *
     * @param diameter The diameter where the border will expand/contract to
     * @param duration The duration over which to change
     * @param temporalUnit The temporal unit of the duration
     */
    default void setDiameter(double diameter, long duration, TemporalUnit temporalUnit) {
        setDiameter(diameter, Duration.of(duration, temporalUnit));
    }

    /**
     * Sets the diameter of the world border, over the given duration.
     *
     * <p>The world border diameter increases/decrease linearly over the
     * specified time. The specified diameter applies to the x and z axis. The
     * world border extends over the entire y-axis.</p>
     *
     * @param diameter The diameter where the border will expand/contract to
     * @param duration The duration over which to change
     */
    void setDiameter(double diameter, Duration duration);

    /**
     * Sets the starting diameter and the ending diameter of the world border,
     * over the given duration.
     *
     * <p>The world border diameter increases/diameter linearly over the
     * specified time. The specified diameter applies to the x and z axis. The
     * world border extends over the entire y-axis.</p>
     *
     * @param startDiameter The diameter where the border will start
     * @param endDiameter The diameter where the border will end
     * @param duration The duration over which to change
     * @param temporalUnit The temporal unit of the duration
     */
    default void setDiameter(double startDiameter, double endDiameter, long duration, TemporalUnit temporalUnit) {
        setDiameter(startDiameter, endDiameter, Duration.of(duration, temporalUnit));
    }

    /**
     * Sets the starting diameter and the ending diameter of the world border,
     * over the given duration.
     *
     * <p>The world border diameter increases/diameter linearly over the
     * specified time. The specified diameter applies to the x and z axis. The
     * world border extends over the entire y-axis.</p>
     *
     * @param startDiameter The diameter where the border will start
     * @param endDiameter The diameter where the border will end
     * @param duration The duration over which to change
     */
    void setDiameter(double startDiameter, double endDiameter, Duration duration);

    /**
     * Gets the time remaining until the world border stops expanding or
     * contracting.
     *
     * @return The time remaining
     */
    Duration getTimeRemaining();

    /**
     * Sets the center of the world border.
     *
     * @param x The x-axis center of the world border
     * @param z The z-axis center of the world border
     */
    void setCenter(double x, double z);

    /**
     * Gets the center of the world border.
     *
     * <p>The returned position is three-dimensional. As the world border
     * extends over the entire y-axis, the returned position will always have a
     * {@code y} set to 0.</p>
     *
     * @return The center
     */
    Vector3d getCenter();

    /**
     * Gets the time when a contracting world border will warn a player for whom
     * the world border will reach in {@code time} seconds.
     *
     * <p>In Minecraft, the warning is displayed in the form of a reddish
     * tint.</p>
     *
     * @return The warning time
     */
    Duration getWarningTime();

    /**
     * Sets the time when a contracting world border will warn a player for whom
     * the world border will reach in {@code time}.
     *
     * <p>In Minecraft, the warning is displayed in the form of a reddish
     * tint.</p>
     *
     * @param time The time
     * @param temporalUnit The temporal unit of the time
     */
    default void setWarningTime(long time, TemporalUnit temporalUnit) {
        setWarningTime(Duration.of(time, temporalUnit));
    }

    /**
     * Sets the time when a contracting world border will warn a player for whom
     * the world border will reach in {@code time} seconds.
     *
     * <p>In Minecraft, the warning is displayed in the form of a reddish
     * tint.</p>
     *
     * @param time The time
     */
    void setWarningTime(Duration time);

    /**
     * Gets the distance when a contracting world border will warn a player for
     * whom the world border is {@code distance} away.
     *
     * <p>In Minecraft, the warning is displayed in the form of a reddish
     * tint.</p>
     *
     * @return The distance
     */
    double getWarningDistance();

    /**
     * Sets the distance when a contracting world border will warn a player for
     * whom the world border is {@code distance} away.
     *
     * <p>In Minecraft, the warning is displayed in the form of a reddish
     * tint.</p>
     *
     * @param distance The distance
     */
    void setWarningDistance(double distance);

    /**
     * Gets the distance a player may be outside the world border before taking
     * damage.
     *
     * @return The distance
     */
    double getDamageThreshold();

    /**
     * Sets the distance a player may be be outside the world border before
     * taking damage.
     *
     * @param distance The distance
     */
    void setDamageThreshold(double distance);

    /**
     * Gets the damage done to a player per block per tick when outside the
     * buffer.
     *
     * @return The damage amount
     */
    double getDamageAmount();

    /**
     * Sets the damage done to a player per block per tick when outside the
     * buffer.
     *
     * @param damage The damage amount
     */
    void setDamageAmount(double damage);

    /**
     * Copies the properties of the passed border onto this border.
     * 
     * @param border The border whose properties are to be copied
     */
    default void copyPropertiesFrom(WorldBorder border) {
        setCenter(border.getCenter().getX(), border.getCenter().getZ());
        setDamageAmount(border.getDamageAmount());
        setDamageThreshold(border.getDamageThreshold());
        setDiameter(border.getDiameter(), border.getNewDiameter(), border.getTimeRemaining());
        setWarningDistance(border.getWarningDistance());
        setWarningTime(border.getWarningTime());
    }

    interface Builder extends CopyableBuilder<WorldBorder, Builder> {

        /**
         * Copies the required data from the passed {@code WorldBorder}.
         * 
         * @param border The world border whose data is to be copied
         * @return The builder, for chaining
         */
        @Override
        Builder from(WorldBorder border);

        /**
         * Sets the diameter of this world border.
         * 
         * @param diameter The diameter that this border will have.
         * @return The builder, for chaining.
         * @see WorldBorder#setDiameter(double)
         */
        Builder diameter(double diameter);

        /**
         * Sets the centre of this world border.
         * 
         * @param x The x-coordinate of the new centre
         * @param z The z-coordinate of the new centre
         * @return The builder, for chaining
         * @see WorldBorder#setCenter(double, double)
         */
        Builder center(double x, double z);

        /**
         * Sets the warning time of this world border.
         *
         * @param time The warning time
         * @param temporalUnit The warning time unit
         * @return The builder, for chaining
         * @see WorldBorder#setWarningTime(Duration)
         */
        default Builder warningTime(long time, TemporalUnit temporalUnit) {
            return warningTime(Duration.of(time, temporalUnit));
        }

        /**
         * Sets the warning time of this world border.
         * 
         * @param time The warning time
         * @return The builder, for chaining
         * @see WorldBorder#setWarningTime(Duration)
         */
        Builder warningTime(Duration time);

        /**
         * Sets the warning distance of this world border.
         *
         * @param distance The warning distance
         * @return The builder, for chaining
         * @see WorldBorder#setWarningDistance(double)
         */
        Builder warningDistance(double distance);

        /**
         * Sets the damage threshold of this world border.
         * 
         * @param distance The damage threshold in blocks
         * @return The builder, for chaining
         * @see WorldBorder#setDamageThreshold(double)
         */
        Builder damageThreshold(double distance);

        /**
         * Sets the damage amount of this world border.
         * 
         * @param damage The damage amount
         * @return The builder, for chaining
         * @see WorldBorder#setDamageAmount(double)
         */
        Builder damageAmount(double damage);
        
        /**
         * Builds the world border from the information given. If no information
         * is given, a {@code WorldBorder} with default properties is built.
         * 
         * @return The built world border
         */
        WorldBorder build();
    }
}
