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

package org.spongepowered.api.util;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * This Exception can be used to clarify that an Exception that was thrown at
 * one location was originally caused by another location. This could be
 * unexpected return values, other unexpected Exceptions. This is especially
 * useful to check which plugin has set up the cause object.
 */
public class TraceableException extends RuntimeException {

    private static final long serialVersionUID = 3442291712478450706L;

    /**
     * Creates a new traceable exception that can be used to trace the cause of
     * an exception in a callback like function.
     *
     * @param cause The exception that occurred during the callback
     * @param causeObject The causing object of that exception
     * @param trace The trace that should be used to identify the location the
     *        callback was set
     */
    public TraceableException(Throwable cause, Object causeObject, StackTraceElement[] trace) {
        super(traceToMessage(checkNotNull(cause, "cause").getMessage(), checkNotNull(causeObject, "causeObject"), checkNotNull(trace, "trace")),
                cause);
    }

    /**
     * Creates a new traceable exception that can be used to trace the cause of
     * an exception in a callback like function.
     *
     * @param message The error message to show
     * @param cause The exception that occurred during the callback
     * @param causeObject The causing object of that exception
     * @param trace The trace that should be used to identify the location the
     *        callback was set
     */
    public TraceableException(String message, Throwable cause, Object causeObject, StackTraceElement[] trace) {
        super(traceToMessage(checkNotNull(message, "message"), checkNotNull(causeObject, "causeObject"), checkNotNull(trace, "trace")),
                cause);
    }

    private static String traceToMessage(String message, Object causeObject, StackTraceElement[] trace) {
        StringBuilder builder = new StringBuilder();
        builder.append(message);
        builder.append(message + '\n');
        builder.append("Originaly caused by improper setup of " + causeObject + '\n');
        for (int i = 0; i < trace.length; i++) {
            builder.append("\tat " + trace[i] + '\n');
        }
        return builder.toString();
    }

}
