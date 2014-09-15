/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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

package org.spongepowered.api.math;

/**
 * Holds a duration value that can be converted into various time units,
 * such as seconds and Minecraft ticks
 */
public class Duration {

    /**
     * The duration in milliseconds
     */
    long millis;

    /**
     * Creates a duration object. Made private because the factory methods should be used.
     * @param millis
     */
    private Duration(long millis) {
        this.millis = millis;
    }

    /**
     * @return the duration in milliseconds
     */
    public long getMillis() {
        return millis;
    }

    /**
     * @return the duration in seconds
     */
    public double getSeconds() {
        return getMillis() / 1000d;
    }

    /**
     * @return the duration in minutes
     */
    public double getMinutes() {
        return getSeconds() / 60d;
    }

    /**
     * @return the duration in hours
     */
    public double getHours() {
        return getMinutes() / 60d;
    }

    /**
     * @return the duration in Minecraft ticks (20 ticks per second)
     */
    public long getTicks() {
        return millis / 50;
    }

    /**
     * Gets this duration formatted as a human readable string.
     * @return
     */
    @Override
    public String toString() {
        //TODO overload method with Locale for translation
        long millis = Math.abs(this.millis);
        StringBuilder r = new StringBuilder();
        if (this.millis < 0) {
            r.append('-');
        }
        if (millis > 0) {
            double hours = getHours();
            if (hours > 0) {
                r.append(hours);
                if (hours == 1) {
                    r.append(" hour");
                } else {
                    r.append(" hours");
                }
            } else {
                double minutes = getMinutes();
                if (minutes > 0) {
                    r.append(minutes);
                    if (minutes == 1) {
                        r.append(" minute");
                    } else {
                        r.append(" minutes");
                    }
                } else {
                    double seconds = getSeconds();
                    if (seconds > 0) {
                        r.append(seconds);
                        if (seconds == 1) {
                            r.append(" second");
                        } else {
                            r.append(" seconds");
                        }
                    } else {
                        r.append(millis);
                        if (millis == 1) {
                            r.append(" millisecond");
                        } else {
                            r.append(" milliseconds");
                        }
                    }
                }
            }
        } else {
            r.append('0');
        }
        return r.toString();
    }

    /**
     * Creates a copy of this object and adds the given duration onto it.
     * @param duration time to add
     * @return the sum of this and the given duration
     */
    public Duration add(Duration duration) {
        return new Duration(getMillis() + duration.getMillis());
    }

    /**
     * Creates a copy of this object and subtracts the given duration from it.
     * @param duration time to subtract
     * @return the subtraction of this by the given duration
     */
    public Duration sub(Duration duration) {
        return new Duration(getMillis() - duration.getMillis());
    }

    /**
     * Factory method for a duration given in ticks
     * @param ticks duration in ticks
     * @return a Duration object with the given duration
     */
    public static Duration ticks(long ticks) {
        return new Duration(ticks * 50);
    }

    /**
     * Factory method for a duration given in milliseconds
     * @param millis duration in milliseconds
     * @return a Duration object with the given duration
     */
    public static Duration millis(long millis) {
        return new Duration(millis);
    }

    /**
     * Factory method for a duration given in seconds
     * @param seconds duration in seconds
     * @return a Duration object with the given duration
     */
    public static Duration seconds(double seconds) {
        return millis((long) (seconds * 1000d));
    }

    /**
     * Factory method for a duration given in minutes
     * @param minutes duration in minutes
     * @return a Duration object with the given duration
     */
    public static Duration minutes(double minutes) {
        return seconds(minutes * 60d);
    }

    /**
     * Factory method for a duration given in hours
     * @param hours duration in hours
     * @return a Duration object with the given duration
     */
    public static Duration hours(double hours) {
        return minutes(hours * 60d);
    }

}
