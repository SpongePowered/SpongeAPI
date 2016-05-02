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
package org.spongepowered.api.service.crash;

import static com.google.common.base.Preconditions.checkNotNull;

import org.spongepowered.api.Sponge;

import java.util.Optional;

/**
 * A mutable crash report.
 *
 * <p>Crash reports, and crash report categories, are not reusable due to
 * stacktraces being retained.</p>
 */
public interface CrashReport {

    /**
     * Creates a crash report from the provided {@link Throwable} and description.
     *
     * @param throwable The throwable causing the report to be generated
     * @param description The description accompanying the report
     * @return The report, if present, {@link Optional#empty()} otherwise
     */
    static Optional<CrashReport> forThrowable(Throwable throwable, String description) {
        return Sponge.getServiceManager().getRegistration(CrashReportService.class)
                .map(registration -> registration.getProvider().createReport(throwable, description));
    }

    /**
     * Gets the {@link Throwable} that was responsible for creating
     * this crash report.
     *
     * @return The throwable, if present, {@link Optional#empty()} otherwise
     */
    Throwable getCause();

    /**
     * Gets the description of this crash report.
     *
     * @return The description of this crash
     */
    String getDescription();

    /**
     * Adds a section with the given name, creating and appending to the
     * end of the error report as necessary.
     *
     * @param name The name to give the section
     * @return The created section
     */
    Category addCategory(String name);

    /**
     * Append a {@link CrashReportable} to this report.
     *
     * <p>If this {@link CrashReportable} has already been added, it will not be added again.</p>
     *
     * @param reportable The object to append information from
     * @return This crash report
     */
    CrashReport addReportable(CrashReportable reportable);

    /**
     * Dispatch this error as a fatal error.
     *
     * <p>The platform will be stopped and this crash report will be printed.</p>
     */
    void fire() throws RuntimeException;

    /**
     * Gets the string representation of this crash report.
     *
     * @return This crash report's string representation
     */
    String toText();

    /**
     * A category in a crash report.
     */
    interface Category {

        /**
         * Adds an entry to this crash report category.
         *
         * @param key The entry name
         * @param value The entry value
         * @return This category
         */
        Category addEntry(String key, Object value);

        /**
         * Gets the crash report that contains this section.
         *
         * @return The crash report
         */
        CrashReport parent();

    }

}
