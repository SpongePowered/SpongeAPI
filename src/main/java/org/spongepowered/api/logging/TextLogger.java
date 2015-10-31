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
package org.spongepowered.api.logging;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.spongepowered.api.text.Text;

import java.util.function.Supplier;

/**
 * Logger supporting the output of formatted Text messages.
 */
public interface TextLogger extends Logger {
    /**
     * Log a message at the TRACE level.
     *
     * @param msg the translatable message to be logged
     * @since 1.4
     */
    void trace(Text msg);

    /**
     * Log an exception (throwable) at the TRACE level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     * @since 1.4
     */
    void trace(Text msg, Throwable t);

    /**
     * Log a message with the specific Marker at the TRACE level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg    the message string to be logged
     * @since 1.4
     */
    void trace(Marker marker, Text msg);

    /**
     * This method is similar to {@link #trace(Text, Throwable)} method except that the
     * marker data is also taken into consideration.
     *
     * @param marker the marker data specific to this log statement
     * @param msg    the message accompanying the exception
     * @param t      the exception (throwable) to log
     * @since 1.4
     */
    void trace(Marker marker, Text msg, Throwable t);

    /**
     * Log a message at the DEBUG level.
     *
     * @param msg the message string to be logged
     */
    void debug(Text msg);

    /**
     * Log an exception (throwable) at the DEBUG level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    void debug(Text msg, Throwable t);

    /**
     * Log a message with the specific Marker at the DEBUG level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg    the message string to be logged
     */
    void debug(Marker marker, Text msg);

    /**
     * This method is similar to {@link #debug(Text, Throwable)} method except that the
     * marker data is also taken into consideration.
     *
     * @param marker the marker data specific to this log statement
     * @param msg    the message accompanying the exception
     * @param t      the exception (throwable) to log
     */
    void debug(Marker marker, Text msg, Throwable t);

    /**
     * Log a message at the INFO level.
     *
     * @param msg the message string to be logged
     */
    void info(Text msg);

    /**
     * Log an exception (throwable) at the INFO level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    void info(Text msg, Throwable t);

    /**
     * Log a message with the specific Marker at the INFO level.
     *
     * @param marker The marker specific to this log statement
     * @param msg    the message string to be logged
     */
    void info(Marker marker, Text msg);

    /**
     * This method is similar to {@link #info(Text, Throwable)} method
     * except that the marker data is also taken into consideration.
     *
     * @param marker the marker data for this log statement
     * @param msg    the message accompanying the exception
     * @param t      the exception (throwable) to log
     */
    void info(Marker marker, Text msg, Throwable t);

    /**
     * Log a message at the WARN level.
     *
     * @param msg the message string to be logged
     */
    void warn(Text msg);

    /**
     * Log an exception (throwable) at the WARN level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    void warn(Text msg, Throwable t);

    /**
     * Log a message with the specific Marker at the WARN level.
     *
     * @param marker The marker specific to this log statement
     * @param msg    the message string to be logged
     */
    void warn(Marker marker, Text msg);

    /**
     * This method is similar to {@link #warn(Text, Throwable)} method
     * except that the marker data is also taken into consideration.
     *
     * @param marker the marker data for this log statement
     * @param msg    the message accompanying the exception
     * @param t      the exception (throwable) to log
     */
    void warn(Marker marker, Text msg, Throwable t);

    /**
     * Log a message at the ERROR level.
     *
     * @param msg the message string to be logged
     */
    void error(Text msg);

    /**
     * Log an exception (throwable) at the ERROR level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    void error(Text msg, Throwable t);

    /**
     * Log a message with the specific Marker at the ERROR level.
     *
     * @param marker The marker specific to this log statement
     * @param msg    the message string to be logged
     */
    void error(Marker marker, Text msg);

    /**
     * This method is similar to {@link #error(Text, Throwable)}
     * method except that the marker data is also taken into
     * consideration.
     *
     * @param marker the marker data specific to this log statement
     * @param msg    the message accompanying the exception
     * @param t      the exception (throwable) to log
     */
    void error(Marker marker, Text msg, Throwable t);

    /**
     * Log a message at the TRACE level.
     *
     * @param msg the translatable message to be logged
     * @since 1.4
     */
    void trace(Supplier<Text> msg);

    /**
     * Log an exception (throwable) at the TRACE level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     * @since 1.4
     */
    void trace(Supplier<Text> msg, Throwable t);

    /**
     * Log a message with the specific Marker at the TRACE level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg    the message string to be logged
     * @since 1.4
     */
    void trace(Marker marker, Supplier<Text> msg);

    /**
     * This method is similar to {@link #trace(Supplier, Throwable)} method except that the
     * marker data is also taken into consideration.
     *
     * @param marker the marker data specific to this log statement
     * @param msg    the message accompanying the exception
     * @param t      the exception (throwable) to log
     * @since 1.4
     */
    void trace(Marker marker, Supplier<Text> msg, Throwable t);

    /**
     * Log a message at the DEBUG level.
     *
     * @param msg the message string to be logged
     */
    void debug(Supplier<Text> msg);

    /**
     * Log an exception (throwable) at the DEBUG level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    void debug(Supplier<Text> msg, Throwable t);

    /**
     * Log a message with the specific Marker at the DEBUG level.
     *
     * @param marker the marker data specific to this log statement
     * @param msg    the message string to be logged
     */
    void debug(Marker marker, Supplier<Text> msg);

    /**
     * This method is similar to {@link #debug(Supplier, Throwable)} method except that the
     * marker data is also taken into consideration.
     *
     * @param marker the marker data specific to this log statement
     * @param msg    the message accompanying the exception
     * @param t      the exception (throwable) to log
     */
    void debug(Marker marker, Supplier<Text> msg, Throwable t);

    /**
     * Log a message at the INFO level.
     *
     * @param msg the message string to be logged
     */
    void info(Supplier<Text> msg);

    /**
     * Log an exception (throwable) at the INFO level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    void info(Supplier<Text> msg, Throwable t);

    /**
     * Log a message with the specific Marker at the INFO level.
     *
     * @param marker The marker specific to this log statement
     * @param msg    the message string to be logged
     */
    void info(Marker marker, Supplier<Text> msg);

    /**
     * This method is similar to {@link #info(Supplier, Throwable)} method
     * except that the marker data is also taken into consideration.
     *
     * @param marker the marker data for this log statement
     * @param msg    the message accompanying the exception
     * @param t      the exception (throwable) to log
     */
    void info(Marker marker, Supplier<Text> msg, Throwable t);

    /**
     * Log a message at the WARN level.
     *
     * @param msg the message string to be logged
     */
    void warn(Supplier<Text> msg);

    /**
     * Log an exception (throwable) at the WARN level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    void warn(Supplier<Text> msg, Throwable t);

    /**
     * Log a message with the specific Marker at the WARN level.
     *
     * @param marker The marker specific to this log statement
     * @param msg    the message string to be logged
     */
    void warn(Marker marker, Supplier<Text> msg);

    /**
     * This method is similar to {@link #warn(Supplier, Throwable)} method
     * except that the marker data is also taken into consideration.
     *
     * @param marker the marker data for this log statement
     * @param msg    the message accompanying the exception
     * @param t      the exception (throwable) to log
     */
    void warn(Marker marker, Supplier<Text> msg, Throwable t);

    /**
     * Log a message at the ERROR level.
     *
     * @param msg the message string to be logged
     */
    void error(Supplier<Text> msg);

    /**
     * Log an exception (throwable) at the ERROR level with an
     * accompanying message.
     *
     * @param msg the message accompanying the exception
     * @param t   the exception (throwable) to log
     */
    void error(Supplier<Text> msg, Throwable t);

    /**
     * Log a message with the specific Marker at the ERROR level.
     *
     * @param marker The marker specific to this log statement
     * @param msg    the message string to be logged
     */
    void error(Marker marker, Supplier<Text> msg);

    /**
     * This method is similar to {@link #error(Supplier, Throwable)}
     * method except that the marker data is also taken into
     * consideration.
     *
     * @param marker the marker data specific to this log statement
     * @param msg    the message accompanying the exception
     * @param t      the exception (throwable) to log
     */
    void error(Marker marker, Supplier<Text> msg, Throwable t);
}
