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
package org.spongepowered.api.service.error;

import org.spongepowered.api.command.CommandSource;

import java.net.URL;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * An error report. This object is mutable.
 */
public interface ErrorReport {

    /**
     * Get the {@link Throwable} that was responsible for creating this error report, if any is present.
     *
     * @return The optional throwable for this error report
     */
    Optional<Throwable> getCause();

    /**
     * Check if this error is the result of a misconfiguration on the user's part, or due to an error in programming.
     * This defaults to true only if the {@link #getCause()} is a {@link UserErrorException}.
     *
     * @return Whether or not this is a user error
     */
    boolean isUserError();

    /**
     * Set whether or not this is user error.
     *
     * @param isUserError Whether or not this is a user error
     * @return this
     */
    ErrorReport setUserError(boolean isUserError);

    /**
     * Get a description of the base cause of this error.
     *
     * @return The description of this error's base cause
     */
    String getDescription();

    /**
     * Get a section with the given title, creating and appending to the end of the error report as necessary.
     *
     * @param title The title to give the section
     * @return The correct section
     */
    Category addCategory(String title);

    /**
     * Append a {@link Reportable} to this report. If this {@link Reportable} has already been added, it will not be added again.
     *
     * @param reportable The object to append information from
     * @return this
     */
    ErrorReport addReportable(Reportable reportable);

    /**
     * Dispatch this error as a fatal error. Fatal means that the server will be stopped and a full crash report will be generated.
     *
     * An exception will be used to pass the result of this error up the call stack. This exception must be passed on.
     */
    void dispatchFatal() throws RuntimeException;

    /**
     * Dispatch this error to a command source. If this command source is not the console, the error report will additionally be mirrored to the
     * console.
     *
     * @param source The source to send information about the error report to
     */
    void dispatchToCommandSource(CommandSource source);

    /**
     * Dispatch this as a non-fatal error that is sent to the console.
     */
    void dispatchToConsole();

    /**
     * Get the text of this error report.
     *
     * @return This error report's text
     */
    String toText();

    /**
     * Takes the text content of this error report and posts it to a pastebin service (implementation-determined).
     * This allows users to more easily send it to the appropriate target.
     *
     * @return a url containing the content of this error report
     */
    CompletableFuture<URL> toPastebin();

    interface Category {

        /**
         * Adds an entry to this category.
         *
         * @param key The entry name
         * @param value The entry value
         * @return This category
         */
        Category addEntry(String key, Object value);

        /**
         * Sets the exception to be contained within this section.
         *
         * @param t The exception to be used
         * @return This category
         */
        Category setException(Throwable t);

        /**
         * Gets the error report that contains this section.
         *
         * @return The report
         */
        ErrorReport parent();

    }

}
