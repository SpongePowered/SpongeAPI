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
package org.spongepowered.api.entity.hanging.art;

import java.util.List;

import com.google.common.base.Optional;

/**
 * A utility class for easy access to all available {@link Art}s.
 */
public final class Arts {

    private static final ArtFactory factory = new NullArtFactory();

    private Arts() {
    }

    public static final Art KEBAB = null;
    public static final Art AZTEC = null;
    public static final Art ALBAN = null;
    public static final Art AZTEC2 = null;
    public static final Art BOMB = null;
    public static final Art PLANT = null;
    public static final Art WASTELAND = null;
    public static final Art WANDERER = null;
    public static final Art GRAHAM = null;
    public static final Art POOL = null;
    public static final Art COURBET = null;
    public static final Art SUNSET = null;
    public static final Art SEA = null;
    public static final Art CREEBET = null;
    public static final Art MATCH = null;
    public static final Art BUST = null;
    public static final Art STAGE = null;
    public static final Art VOID = null;
    public static final Art SKULL_AND_ROSES = null;
    public static final Art WITHER = null;
    public static final Art FIGHTERS = null;
    public static final Art SKELETON = null;
    public static final Art DONKEY_KONG = null;
    public static final Art POINTER = null;
    public static final Art PIGSCENE = null;
    public static final Art BURNING_SKULL = null;

    /**
     * Gets a list of all possible {@link Art}s, that are supported by this
     * implementation.
     * 
     * @return An immutable list containing all available arts
     */
    public static List<Art> getValues() {
        return factory.getArtPieces();
    }

    /**
     * Gets the {@link Art} by it's name.
     * 
     * @param name The name of the art
     * @return An {@link Optional} containing the {@link Art} with the given
     *         name, if any
     * @see Art#getName()
     */
    public static Optional<Art> valueOf(String name) {
        return Optional.fromNullable(factory.getFromName(name));
    }
}
