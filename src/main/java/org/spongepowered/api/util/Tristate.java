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

/**
 * Represents a simple tristate.
 */
public enum Tristate {
    TRUE(true) {
        @Override
        public Tristate and(Tristate other) {
            return other == FALSE ? FALSE : TRUE;
        }

        @Override
        public Tristate or(Tristate other) {
            return TRUE;
        }

        @Override
        public Tristate not() {
            return FALSE;
        }
    },
    FALSE(false) {
        @Override
        public Tristate and(Tristate other) {
            return FALSE;
        }

        @Override
        public Tristate or(Tristate other) {
            return other == TRUE ? TRUE : FALSE;
        }

        @Override
        public Tristate not() {
            return TRUE;
        }
    },
    UNDEFINED(false) {
        @Override
        public Tristate and(Tristate other) {
            return other;
        }

        @Override
        public Tristate or(Tristate other) {
            return other;
        }

        @Override
        public Tristate not() {
            return UNDEFINED;
        }
    };

    private final boolean val;

    Tristate(boolean val) {
        this.val = val;
    }

    /**
     * Returns the appropriate tristate for a given boolean value.
     *
     * @param val The boolean value
     * @return The appropriate tristate
     */
    public static Tristate fromBoolean(boolean val) {
        return val ? TRUE : FALSE;
    }

    /**
     * Returns the appropriate tristate for a given nullable boolean value,
     * where null equates to {@link Tristate#UNDEFINED}.
     *
     * @param val The nullable boolean value
     * @return The appropriate tristate
     */
    public static Tristate fromNullableBoolean(@Nullable Boolean val) {
        if (val == null) {
            return UNDEFINED;
        } else {
            return val ? TRUE : FALSE;
        }
    }

    /**
     * ANDs this tristate with another tristate.
     *
     * @param other The tristate to AND with
     * @return The result
     */
    public abstract Tristate and(Tristate other);

    /**
     * ORs this tristate with another tristate.
     *
     * @param other The tristate to OR with
     * @return The result
     */
    public abstract Tristate or(Tristate other);

    /**
     * Negates this tristate.
     *
     * @return The result
     */
    public abstract Tristate not();

    /**
     * Returns the boolean representation of this tristate.
     *
     * @return The boolean tristate representation
     */
    public boolean asBoolean() {
        return this.val;
    }

    /**
     * Returns the nullable boolean representation of this tristate,
     * where {@link Tristate#UNDEFINED} equates to null.
     *
     * <p>Note: To ensure that there is a one-to-one mapping of nullable
     * booleans to and from {@link Tristate}, this method will return null
     * rather than use an {@link java.util.Optional Optional}.</p>
     *
     * @return The nullable boolean tristate representation
     */
    @Nullable
    public Boolean asNullableBoolean() {
        if (this == Tristate.UNDEFINED) {
            return null;
        } else {
            return this.val;
        }
    }
}
