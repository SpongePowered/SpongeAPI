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

import com.google.common.base.Objects;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * This Exception can be used to clarify that an Exception that was thrown at
 * one location was originally caused by another location. This could be
 * unexpected return values, other unexpected Exceptions. This is especially
 * useful to check which plugin has set up the cause object.
 */
public class TraceableException extends RuntimeException {

    private static final long serialVersionUID = 3442291712478450706L;
    private final Object causeObject;
    private final StackTraceElement[] trace;

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
        super(cause);
        this.causeObject = checkNotNull(causeObject, "causeObject");
        this.trace = checkNotNull(trace, "trace");
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
        super(message, cause);
        this.causeObject = checkNotNull(causeObject, "causeObject");
        this.trace = checkNotNull(trace, "trace");
    }

    @Override
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override
    public void printStackTrace(PrintStream s) {
        synchronized (s) {
            super.printStackTrace(s);
            printStackTrace(new WrappedPrintStream(s));
        }
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        synchronized (s) {
            super.printStackTrace(s);
            printStackTrace(new WrappedPrintWriter(s));
        }
    }

    private void printStackTrace(TracePrinter s) {
        s.println("Originaly caused by improper setup of " + this.causeObject);
        for (int i = 0; i < this.trace.length; i++) {
            s.println("\tat " + this.trace[i]);
        }
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("causeObject", this.causeObject)
                .add("trace", Arrays.toString(this.trace))
                .toString();
    }

    private interface TracePrinter {

        void println(Object o);

    }

    private static class WrappedPrintStream implements TracePrinter {

        private final PrintStream printStream;

        WrappedPrintStream(PrintStream printStream) {
            this.printStream = printStream;
        }

        @Override
        public void println(Object o) {
            this.printStream.println(o);
        }

    }

    private static class WrappedPrintWriter implements TracePrinter {

        private final PrintWriter printWriter;

        WrappedPrintWriter(PrintWriter printWriter) {
            this.printWriter = printWriter;
        }

        @Override
        public void println(Object o) {
            this.printWriter.println(o);
        }

    }

}
