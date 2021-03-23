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
package org.spongepowered.api.service.context;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.service.permission.PermissionService;

import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Calculates the {@link Context}s applicable for a {@link Contextual}.
 *
 * <p>Implementations of this interface should satisfy the following
 * requirements:</p>
 * <ul>
 *     <li>Context lookups should be <i>fast</i>: lookup methods are likely to
 *     be invoked frequently, and should therefore be fast to execute. If
 *     determining the current contexts involves a particularly time consuming
 *     lookup (database queries, network requests, etc), then such results
 *     should be cached ahead of time.</li>
 *
 *     <li>Context lookups should be <i>thread-safe</i>: lookups will sometimes
 *     be performed from "async" threads, and therefore should not access any
 *     part of the server only safe for access from a sync context. If
 *     necessary, such results should be determined ahead of time and stored in
 *     a thread-safe collection for retrieval later.</li>
 *
 *     <li>Context lookups should <i>not query active contexts</i>: doing so is
 *     likely to result in a stack overflow, or thread deadlock. Care should be
 *     taken to avoid (indirect) calls to {@link ContextService#contexts()} ()}.</li>
 * </ul>
 *
 * <p>Calculators should be registered with the corresponding
 * {@link ContextService} using
 * {@link ContextService#registerContextCalculator(ContextCalculator)}.</p>
 *
 * <p>Context lookups for instances provided by the platform,
 * (e.g. {@link Player}) are delegated to the active {@link PermissionService}.
 * Plugins wishing to provide contexts for these instances should register
 * calculators here.</p>
 */
@FunctionalInterface
public interface ContextCalculator {

    /**
     * Creates a new {@link ContextCalculator} that provides a single context.
     *
     * @param key The key of the context provided by the calculator
     * @param valueFunction The function used to compute the corresponding value
     *                      for each query. A context will not be "accumulated"
     *                      if the value returned is null.
     * @return The resultant calculator
     */
    static ContextCalculator forSingleContext(final String key, final Function<Cause, String> valueFunction) {
        Objects.requireNonNull(key, "key");
        Objects.requireNonNull(valueFunction, "valueFunction");
        return (target, accumulator) -> {
            final String value = valueFunction.apply(target);
                if (value != null) {
                accumulator.accept(new Context(key, value));
            }
        };
    }

    /**
     * Adds any {@link Context}s this calculator determines to be applicable to
     * the {@code target} contextual.
     *
     * <p>Care should be taken to ensure implementations of this method meet the
     * general requirements for {@link ContextCalculator}, defined in the class
     * doc.</p>
     *
     * <p>Calculators should not rely on the state of {@code accumulator} during
     * this call, and also shouldn't make calls to remove contexts added by
     * other calculators.</p>
     *
     * @param source The cause stack to draw from for this operation
     * @param accumulator a {@link Set} of {@link Context}s this operation
     *                    will accumulate to.
     */
    void accumulateContexts(final Cause source, final Consumer<Context> accumulator);

}
