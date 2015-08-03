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

import org.spongepowered.api.text.Text;

/**
 * A service for generating error reports with useful debug information.
 */
public interface ErrorReportService {

    /**
     * Create a report with the provided {@link Throwable} and a message describing the location the error was seen from.
     *
     * @param throwable The error causing this report to be generated
     * @param message The message accompanying this report
     * @return The report, ready to be dispatched
     */
    ErrorReport createReport(Throwable throwable, Text message);

    /**
     * Create a report describing an error not attached to a specific {@link Throwable}.
     *
     * @param message The message for this error
     * @return The created report
     */
    ErrorReport createReport(Text message);

    /**
     * Create a report describing an error with a throwable and no more details.
     *
     * @param throwable The throwable this report is being created in response to
     * @return The created report
     */
    ErrorReport createReport(Throwable throwable);
}
