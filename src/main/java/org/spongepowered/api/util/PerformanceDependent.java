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

import org.spongepowered.api.util.temporal.Duration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a parameter or return type that represents a {@link Duration} as dependent
 * on server performance, and should be considered a minimum time, rather than an
 * absolute time.
 *
 * If the server operates under perfect conditions (for example, 20 ticks per
 * second (TPS) in vanilla minecraft), then the duration that has been set or
 * returned will be accurate. However, if the server performance is degraded
 * at any moment (in vanilla, a drop in the TPS), then the given duration might
 * be considered an underestimate if the underlying implementation uses tick
 * rather than wall clock time to time actions.
 *
 * The effect of server performance drops on annotated types is dependent on the
 * implementation that is being used and the settings that are applied. Therefore,
 * no assumptions should be made about how durations are calculated, it is
 * implementation dependent.
 *
 * Plugins wishing to execute tasks based on any returned duration annotated
 * with this annotation should check that the desired action has occurred rather
 * than solely relying on what is returned. Plugins setting times annotated with
 * this annotation should be aware that the underlying implementation may convert
 * the time into a different format and, as such, the stored time may not be
 * exactly the same as requested.
 *
 * Any {@link Duration} annotated with this annotation may be used with any of
 * the units provided in {@link java.time.temporal.ChronoUnit}. It's also possible
 * to construct tick based durations using {@link Duration#ofTicks(long)}, however
 * there's no guarantee that the duration will be used as ticks, this is dependent
 * on the implementation and could convert this back to a duration based on the
 * wall clock.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
public @interface PerformanceDependent {

}
