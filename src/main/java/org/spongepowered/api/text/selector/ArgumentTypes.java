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

import com.flowpowered.math.vector.Vector3f;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.player.gamemode.GameMode;

/**
 * ArgumentTypes is a list of the default argument types that are available in
 * Vanilla Minecraft.
 */
public final class ArgumentTypes {

    /**
     * The argument type for the "x" key. It cannot be inverted.
     */
    public static final ArgumentType<Integer, Argument<Integer>> X = null;

    /**
     * The argument type for the "y" key. It cannot be inverted.
     */
    public static final ArgumentType<Integer, Argument<Integer>> Y = null;

    /**
     * The argument type for the "z" key. It cannot be inverted.
     */
    public static final ArgumentType<Integer, Argument<Integer>> Z = null;

    /**
     * The argument type for a combination of the "x", "y", and "z" keys. It
     * cannot be inverted.
     */
    public static final ArgumentType<Vector3i, Argument<Vector3i>> POSITION = null;

    /**
     * The argument type for the "r" key. It cannot be inverted.
     */
    public static final ArgumentType<Integer, Argument<Integer>> RADIUS_MAXIMUM = null;

    /**
     * The argument type for the "rm" key. It cannot be inverted.
     */
    public static final ArgumentType<Integer, Argument<Integer>> RADIUS_MINIMUM = null;

    /**
     * The argument type for the "m" key. It cannot be inverted.
     */
    public static final ArgumentType<GameMode, Argument<GameMode>> GAMEMODE = null;

    /**
     * The argument type for the "c" key. Its inverse is made by putting a '-'
     * in front of the current number, or removing it if the number is already
     * negative.
     */
    public static final ArgumentType<Integer, InvertibleArgument<Integer, Integer>> COUNT = null;

    /**
     * The argument type for the "l" key. It cannot be inverted.
     */
    public static final ArgumentType<Integer, Argument<Integer>> LEVEL_MAXIMUM = null;

    /**
     * The argument type for the "lm" key. It cannot be inverted.
     */
    public static final ArgumentType<Integer, Argument<Integer>> LEVEL_MINIMUM = null;

    /**
     * The argument type for the "team" key. Its inverse is made by putting a
     * '!' in front of the current team, or removing it if the team is already
     * negated.
     */
    public static final ArgumentType<String, InvertibleArgument<String, String>> TEAM = null;

    /**
     * The argument type for the "name" key. Its inverse is made by putting a
     * '!' in front of the current name, or removing it if the name is already
     * negated.
     */
    public static final ArgumentType<String, InvertibleArgument<String, String>> NAME = null;

    /**
     * The argument type for the "dx" key. It cannot be inverted.
     */
    public static final ArgumentType<Integer, Argument<Integer>> DIMENSION_X = null;

    /**
     * The argument type for the "dy" key. It cannot be inverted.
     */
    public static final ArgumentType<Integer, Argument<Integer>> DIMENSION_Y = null;

    /**
     * The argument type for the "dz" key. It cannot be inverted.
     */
    public static final ArgumentType<Integer, Argument<Integer>> DIMENSION_Z = null;

    /**
     * The argument type for a combination of the "dx", "dy", and "dz" keys. It
     * cannot be inverted.
     */
    public static final ArgumentType<Vector3i, Argument<Vector3i>> BOX_DIMENSIONS = null;

    /**
     * The argument type for the "rx" key. The float will be floored to an
     * integer in Vanilla Minecraft. It cannot be inverted.
     */
    public static final ArgumentType<Float, Argument<Float>> PTICH_MAXIMUM = null;

    /**
     * The argument type for the "rxm" key. The float will be floored to an
     * integer in Vanilla Minecraft. It cannot be inverted.
     */
    public static final ArgumentType<Float, Argument<Float>> PITCH_MINIMUM = null;

    /**
     * The argument type for the "ry" key. The float will be floored to an
     * integer in Vanilla Minecraft. It cannot be inverted.
     */
    public static final ArgumentType<Float, Argument<Float>> YAW_MAXIMUM = null;

    /**
     * The argument type for the "rym" key. The float will be floored to an
     * integer in Vanilla Minecraft. It cannot be inverted.
     */
    public static final ArgumentType<Float, Argument<Float>> YAW_MINIMUM = null;

    /**
     * The argument type for a combination of the "rx" and "ry" keys. The floats
     * will be floored to integers in Vanilla Minecraft, and the third float is
     * currently ignored. It cannot be inverted.
     */
    public static final ArgumentType<Vector3f, Argument<Vector3f>> ROTATION_MAXIMUM = null;

    /**
     * The argument type for a combination of the "rxm" and "rym" keys. The
     * floats will be floored to integers in Vanilla Minecraft, and the third
     * float is currently ignored. It cannot be inverted.
     */
    public static final ArgumentType<Vector3f, Argument<Vector3f>> ROTATION_MINIMUM = null;

    /**
     * The argument type for the "type" key. Its inverse is made by putting a
     * '!' in front of the current type, or removing it if the type is already
     * negated.
     */
    public static final ArgumentType<EntityType, InvertibleArgument<EntityType, String>> TYPE = null;

    /**
     * Creates a score maximum {@linkplain ArgumentType} for the given objective
     * name.
     * 
     * @param name The objective name to use
     *
     * @return An ArgumentType for the objective name
     */
    public static final ArgumentType<Integer, Argument<Integer>> scoreMaximum(String name) {
        return Selectors.factory.createScoreMaxArgument(name);
    }

    /**
     * Creates a score minimum {@linkplain ArgumentType} for the given objective
     * name.
     * 
     * @param name The objective name to use
     *
     * @return An ArgumentType for the objective name
     */
    public static final ArgumentType<Integer, Argument<Integer>> scoreMinimum(String name) {
        return Selectors.factory.createScoreMinArgument(name);
    }

}
