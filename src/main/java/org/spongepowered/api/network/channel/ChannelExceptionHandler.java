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
package org.spongepowered.api.network.channel;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.network.EngineConnection;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * Represents a handler for exceptions of {@link Channel}s. This handler
 * can be implemented by plugin developers.
 *
 * @param <C> The connection type
 */
@FunctionalInterface
public interface ChannelExceptionHandler<C extends EngineConnection> {

    /**
     * Gets the {@link ChannelExceptionHandler} that will always log when a
     * {@link ChannelException} occurs. {@link CompletableFuture}s will also
     * receive the {@link ChannelException}s like expected.
     *
     * <p>This {@link ChannelExceptionHandler} is useful if you don't need
     * special handling for exceptions. This handler can be customized through
     * the suppress methods.</p>
     *
     * @return The channel exception handler
     */
    static ChannelExceptionHandler<EngineConnection> logEverything() {
        return Sponge.getRegistry().getFactoryRegistry().provideFactory(Factory.class).logEverything();
    }

    /**
     * Handles a {@link ChannelException} that occurred for a specific {@link EngineConnection}. This
     * includes exceptions caused by encoding or decoding payloads, handling packets, when a packet is
     * send to an unsupported connection, etc.
     *
     * <p>The {@link CompletableFuture} is the one that was returned by one of the send operations,
     * this one <strong>must</strong> be completed when an exception occurs. The future is always
     * null when a request packet is being handled on the other side.</p>
     *
     * @param connection The connection that the exception occurred for
     * @param channel The channel the exception occurred on
     * @param exception The exception the occurred
     * @param future The future of the send operation or receive operation
     */
    void handle(C connection, Channel channel, ChannelException exception, @Nullable CompletableFuture<?> future);

    /**
     * Returns a new {@link ChannelExceptionHandler} that suppresses every {@link ChannelException}
     * to be handled through this exception handler if a {@link CompletableFuture} is applicable.
     *
     * <p>This {@link ChannelExceptionHandler} is useful if you're planning to handle
     * <strong>every</strong> exception of the returned {@link CompletableFuture}s.</p>
     *
     * @return The new channel exception handler
     */
    default ChannelExceptionHandler<C> suppressAllIfFutureIsPresent() {
        final ChannelExceptionHandler<C> original = this;
        return (connection, channel, exception, future) -> {
            if (future != null) {
                future.completeExceptionally(exception);
            } else {
                original.handle(connection, channel, exception, null);
            }
        };
    }

    /**
     * Returns a new {@link ChannelExceptionHandler} that suppresses {@link ChannelException}
     * of the given type to be handled through this exception handler if a
     * {@link CompletableFuture} is applicable.
     *
     * <p>The returned {@link ChannelExceptionHandler} is useful if you're planning to handle
     * certain exception types of the returned {@link CompletableFuture}s.</p>
     *
     * @param exceptionType The exception type to suppress
     * @return The new channel exception handler
     */
    default ChannelExceptionHandler<C> suppressIfFutureIsPresent(final Class<? extends ChannelException> exceptionType) {
        Objects.requireNonNull(exceptionType, "exceptionType");
        final ChannelExceptionHandler<C> original = this;
        return (connection, channel, exception, future) -> {
            if (future != null && exceptionType.isInstance(exception)) {
                future.completeExceptionally(exception);
            } else {
                original.handle(connection, channel, exception, future);
            }
        };
    }

    /**
     * Returns a new {@link ChannelExceptionHandler} that suppresses a certain type of
     * {@link ChannelException} to be handled through this exception handler. The
     * {@link CompletableFuture}s will still receive the exception.
     *
     * <p>This is useful to suppress certain exceptions from being logged. For example
     * {@link ChannelNotSupportedException} can be suppressed if you don't want to log
     * the exception every time you send a payload to a connection that doesn't support
     * the channel. Then you can handle this through the {@link CompletableFuture}s.</p>
     *
     * @param exceptionType The exception type to suppress
     * @return The new channel exception handler
     */
    default ChannelExceptionHandler<C> suppress(final Class<? extends ChannelException> exceptionType) {
        Objects.requireNonNull(exceptionType, "exceptionType");
        final ChannelExceptionHandler<C> original = this;
        return (connection, channel, exception, future) -> {
            if (exceptionType.isInstance(exception)) {
                if (future != null) {
                    future.completeExceptionally(exception);
                }
            } else {
                original.handle(connection, channel, exception, future);
            }
        };
    }

    interface Factory {

        ChannelExceptionHandler<EngineConnection> logEverything();
    }
}
