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

import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.entity.EntityType;

import java.util.Collection;

/**
 * Arguments is a utility class to work with and create Arguments.
 */
public final class Arguments {

    private static final ArgumentFactory factory = null;

    private Arguments() {}

    /**
     * Creates an {@link Argument}.
     * 
     * @param key The key for the Argument
     * @param value The value for the Argument
     *
     * @return A new argument with {@code key} mapped to {@code value}
     */
    public static Argument create(String key, String value) {
        return factory.createArgument(key, value);
    }

    /**
     * Creates an {@link Argument}.
     * 
     * @param key The key for the Argument
     * @param value The value for the Argument
     *
     * @return A new argument with {@code key} mapped to {@code value}
     */
    public static Argument create(String key, int value) {
        return factory.createArgument(key, value);
    }

    /**
     * Creates 3 {@link Argument Arguments} with the key for x, y, and z and the
     * corresponding values from the {@link Vector3i} as the values.
     * 
     * @param center The value for the Argument
     *
     * @return 3 new arguments with {@code "x"} mapped to {@code center.getX()},
     *         {@code "y"} mapped to {@code center.getY()}, and {@code "z"}
     *         mapped to {@code center.getZ()}
     */
    public static Collection<Argument> center(Vector3i center) {
        return factory.createCenterArguments(center);
    }

    /**
     * Creates an {@link Argument} with the key for name and the given String as
     * the value.
     * 
     * @param name The value for the Argument
     *
     * @return A new argument with {@code "name"} mapped to {@code name}
     */
    public static Argument name(String name) {
        return factory.createNameArgument(name);
    }

    /**
     * Creates an {@link Argument} with the key for team and the given String as
     * the value.
     * 
     * @param team The value for the Argument
     *
     * @return A new argument with {@code "team"} mapped to {@code team}
     */
    public static Argument team(String team) {
        return factory.createTeamArgument(team);
    }

    /**
     * Creates an {@link Argument} with the key for type and the given
     * {@link EntityType} as the value.
     * 
     * @param type The EntityType value for the Argument
     *
     * @return A new argument with {@code "type"} mapped to {@code type}
     */
    public static Argument type(EntityType type) {
        return factory.createEntityTypeArgument(type);
    }

    /**
     * Parses an {@link Argument} from the given argument string.
     *
     * @param argument The raw argument string
     * @return A new Argument containing the given argument data
     * @throws IllegalArgumentException If the selector could not be parsed
     */
    public static Argument parseRaw(String argument) throws IllegalArgumentException {
        return factory.parseRawArgument(argument);
    }

}
