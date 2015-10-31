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

import static org.spongepowered.api.util.SpongeApiTranslationHelper.t;

import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.sink.MessageSink;
import org.spongepowered.api.util.command.CommandSource;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Represents a destination that log messages may be provided to. Plugins may implement this to
 */
@FunctionalInterface
public interface LogTarget extends Consumer<LogMessage> {

    /**
     * Log a message to a specific MessageSink.
     *
     * @param sink The sink to log to
     * @return The sink target
     */
    static LogTarget toSink(final MessageSink sink) {
        return message -> {
            Optional<Throwable> error = message.getThrowable();
            if (error.isPresent()) {
                sink.sendMessage(Texts.builder().append(message.getMessage(), t("Hover for more information")).build());
            } else {
                sink.sendMessage(message.getMessage());
            }
        };
    }

    /**
     * Log a message to a specific CommandSource.
     *
     * @param source The source to log to
     * @return The source target.
     */
    static LogTarget toCommandSource(final CommandSource source) {
        return message -> {
            Optional<Throwable> error = message.getThrowable();
            if (error.isPresent()) {
                source.sendMessage(Texts.builder().append(message.getMessage(), t("Hover for more information")).build());
            } else {
                source.sendMessage(message.getMessage());
            }
        };
    }

    /**
     * TODO: Needs implementation file logging -- and patterns and stuff??.
     *
     * @param file The file to log to
     * @return The file target.
     */
    static LogTarget toFile(File file) {
        return null;
    }

    /**
     * Get a new target that acts as this target with a filter applied.
     *
     *
     * @param filter The filter to apply. If the filter is null, any existing filters will be removed.
     * @return The filtered target
     */
    default LogTarget filteredBy(Predicate<LogMessage> filter) {
        return filter == null ? this : new FilteredLogTarget(filter, this);
    }

    /**
     *
     * @param others
     * @return
     */
    default LogTarget with(LogTarget... others) {
        return new MultiLogTarget(ImmutableSet.<LogTarget>builder().addAll(Arrays.asList(others)).add(this).build());
    }

    /**
     * Returns a log target without the specified outputs.
     * @param others
     * @return
     */
    default LogTarget without(LogTarget... others) {
        List<LogTarget> othersList = Arrays.asList(others);
        if (othersList.contains(this)) {
            return new NullLogTarget();
        } else {
            return this;
        }
    }

}
