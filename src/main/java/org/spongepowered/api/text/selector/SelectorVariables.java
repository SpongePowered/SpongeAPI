/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
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
package org.spongepowered.api.text.selector;

import com.google.common.base.Optional;

import java.util.List;

/**
 * SelectorVariables is a list of the default selector variables that are
 * available in Vanilla Minecraft.
 */
public final class SelectorVariables {

    private static final SelectorVariableFactory factory = null;

    private SelectorVariables() {}

    /**
     * The all players selector variable.
     */
    public static final SelectorVariable ALL_PLAYERS = null;

    /**
     * The all entities selector variable.
     */
    public static final SelectorVariable ALL_ENTITIES = null;

    /**
     * The nearest player selector variable.
     */
    public static final SelectorVariable NEAREST_PLAYER = null;

    /**
     * The random player selector variable.
     */
    public static final SelectorVariable RANDOM_PLAYER = null;

    /**
     * Gets the {@link SelectorVariable} with the specified ID.
     *
     * @param id The identifier of the selector Variable, for example
     *        {@code "a"} for {@code ALL_PLAYERS}.
     * @return The {@link SelectorVariable} with the specified ID, or
     *         {@link Optional#absent()} if not found
     */
    public static Optional<SelectorVariable> valueOf(String id) {
        return factory.getVariableFromName(id);
    }

    /**
     * Returns a list of all available {@link SelectorVariable}s on this server.
     *
     * @return An immutable list of all selector variables
     */
    public static List<SelectorVariable> getValues() {
        return factory.getVariables();
    }

}
