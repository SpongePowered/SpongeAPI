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

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Optional;

/**
 * Utility for working with {@code Optional<Boolean>}s.
 *
 * <p>This also saves memory by holding three static instances of
 * {@code Optional<Boolean>}, which represents the possible states it can
 * have.</p>
 */
public final class OptBool {

    private OptBool() {}

    /**
     * The true value.
     */
    public static final Optional<Boolean> TRUE = Optional.of(true);

    /**
     * The false value.
     */
    public static final Optional<Boolean> FALSE = Optional.of(false);

    /**
     * The absent value.
     *
     * <p>Also a shorthand for constructing instances
     * with {@code Optional.<Boolean>empty()}.</p>
     */
    public static final Optional<Boolean> EMPTY = Optional.empty();

    /**
     * Constructs a new {@code Optional<Boolean>} from the given boolean.
     *
     * @param bool The boolean
     * @return The constructed Optional
     */
    public static Optional<Boolean> of(final boolean bool) {
        return bool ? OptBool.TRUE : OptBool.FALSE;
    }

    /**
     * Constructs a new {@code Optional<Boolean>} from the given {@link Boolean}.
     *
     * @param bool The boolean
     * @return The constructed Optional, or {@link Optional#empty()}
     */
    public static Optional<Boolean> of(final @Nullable Boolean bool) {
        if (bool != null) {
            return OptBool.of(bool.booleanValue());
        }
        return OptBool.EMPTY;
    }

    /**
     * Coerces the given {@code Optional<Boolean>} into one of the three
     * stored states.
     *
     * @param bool The boolean
     * @return The constructed Optional, or {@link Optional#empty()}
     */
    public static Optional<Boolean> of(final Optional<Boolean> bool) {
        if (bool.isPresent()) {
            return OptBool.of(bool.get().booleanValue());
        }
        return OptBool.EMPTY;
    }

}
