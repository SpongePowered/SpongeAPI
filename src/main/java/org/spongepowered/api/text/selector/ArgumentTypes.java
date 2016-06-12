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
package org.spongepowered.api.text.selector;

import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3i;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.EntityType;
import org.spongepowered.api.entity.living.player.gamemode.GameMode;
import org.spongepowered.api.scoreboard.Team;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import java.util.Collection;
import java.util.Optional;

/**
 * Represents the default {@link ArgumentType}s available in Vanilla Minecraft.
 */
public final class ArgumentTypes {

    /**
     * The argument types representing the position of the selector.
     *
     * <p>In Vanilla, this is represented by the {@code x}, {@code y} and
     * {@code z} selector keys.</p>
     */
    public static final ArgumentHolder.Vector3<Vector3i, Integer> POSITION =
            DummyObjectProvider.createExtendedFor(ArgumentHolder.Vector3.class, "POSITION");

    /**
     * The argument types representing the radius of the selector.
     *
     * <p>In Vanilla, this is represented by the {@code r} (for minimum) and
     * {@code rm} (for maximum) selector keys.</p>
     */
    public static final ArgumentHolder.Limit<ArgumentType<Integer>> RADIUS =
            DummyObjectProvider.createExtendedFor(ArgumentHolder.Limit.class, "RADIUS");

    /**
     * The argument type filtering based on the {@link GameMode} of a player.
     *
     * <p>In Vanilla, this is represented by the {@code m} selector key.</p>
     *
     * <p>Note that this element is of type {@link ArgumentType.Invertible}.</p>
     */
    public static final ArgumentType<GameMode> GAME_MODE =
            DummyObjectProvider.createExtendedFor(ArgumentType.class, "GAME_MODE");

    /**
     * The argument type limiting the number of results of a {@link Selector}.
     * Negative values will reverse the order of targets - for example the
     * farthest targets will be returned first.
     *
     * <p>The default count for the {@link SelectorTypes#RANDOM} and
     * {@link SelectorTypes#NEAREST_PLAYER} is {@code 1}, therefore a higher
     * number will increase the count instead of limiting it.</p>
     *
     * <p>In Vanilla, this is represented by the {@code c} selector key.</p>
     */
    public static final ArgumentType<Integer> COUNT =
            DummyObjectProvider.createExtendedFor(ArgumentType.class, "COUNT");

    /**
     * The argument types filtering based on the number of experience levels of
     * the target.
     *
     * <p>In Vanilla, this is represented by the {@code l} (for maximum) and
     * {@code lm} (for minimum) selector keys.</p>
     */
    public static final ArgumentHolder.Limit<ArgumentType<Integer>> LEVEL =
            DummyObjectProvider.createExtendedFor(ArgumentHolder.Limit.class, "LEVEL");

    /**
     * The argument type filtering based on the {@link Team} of the target.
     * Inverting this argument type will search for all targets not on the
     * specified team instead.
     *
     * <p>In Vanilla, this is represented by the {@code team} selector key with
     * the {@code !} prefix for inverted values.</p>
     */
    public static final ArgumentType.Invertible<String> TEAM =
            DummyObjectProvider.createExtendedFor(ArgumentType.Invertible.class, "TEAM");

    /**
     * The argument type filtering based on the name of the target. Inverting
     * this argument type will search for all targets without the specified name
     * instead.
     *
     * <p>In Vanilla, this is represented by the {@code name} selector key with
     * the {@code !} prefix for inverted values.</p>
     */
    public static final ArgumentType.Invertible<String> NAME =
            DummyObjectProvider.createExtendedFor(ArgumentType.Invertible.class, "NAME");

    /**
     * The argument type filtering targets which aren't in the specified volume.
     *
     * <p>In Vanilla, this is represented by the {@code dx}, {@code dy} and
     * {@code dz} selector keys.</p>
     */
    public static final ArgumentHolder.Vector3<Vector3i, Integer> DIMENSION =
            DummyObjectProvider.createExtendedFor(ArgumentHolder.Vector3.class, "DIMENSION");

    /**
     * The argument type filtering targets within a specific rotation range.
     *
     * <p>In Vanilla, the {@link Double}s will be floored to {@link Integer}s
     * and the third float is completely ignored. It is represented by the
     * {@code rx}/{@code ry} (for minimum) and {@code rxm}/{@code rym} selector
     * keys.</p>
     */
    public static final ArgumentHolder.Limit<ArgumentHolder.Vector3<Vector3d, Double>> ROTATION =
            DummyObjectProvider.createExtendedFor(ArgumentHolder.Limit.class, "ROTATION");

    /**
     * The argument type filtering targets based on the {@link EntityType}.
     *
     * <p>In Vanilla, this is represented by the {@code type} selector key.</p>
     */
    public static final ArgumentType.Invertible<EntityType> ENTITY_TYPE =
            DummyObjectProvider.createExtendedFor(ArgumentType.Invertible.class, "ENTITY_TYPE");

    @SuppressWarnings("deprecation")
    static SelectorFactory getFactory() {
        return Sponge.getRegistry().getSelectorFactory();
    }

    /**
     * Creates a minimum and maximum {@link ArgumentType} filtering depending on
     * the score of the specified objective.
     *
     * @param name The objective name to use
     * @return The created argument type
     */
    public static ArgumentHolder.Limit<ArgumentType<Integer>> score(String name) {
        return getFactory().createScoreArgumentType(name);
    }

    /**
     * Gets the {@link ArgumentType} with the provided name.
     *
     * @param name The name of the argument type
     * @return The {@link ArgumentType} with the given name or Optional.empty()
     *         if not found
     */
    public static Optional<ArgumentType<?>> valueOf(String name) {
        return getFactory().getArgumentType(name);
    }

    /**
     * Gets a {@link Collection} of all possible {@link ArgumentType}s.
     *
     * @return The list of all available {@link ArgumentType}s
     */
    public static Collection<ArgumentType<?>> values() {
        return getFactory().getArgumentTypes();
    }

    /**
     * Creates a custom {@link ArgumentType} with the specified key.
     *
     * @param key The key to use for the argument
     * @return The created argument type
     */
    public static ArgumentType<String> create(String key) {
        return getFactory().createArgumentType(key);
    }

    /**
     * Creates a custom {@link ArgumentType} with the specified key and value.
     *
     * @param key The key to use for the argument
     * @param type The class of the argument's value type
     * @param <T> The argument's value type
     * @return The created argument type
     */
    public static <T> ArgumentType<T> create(String key, Class<T> type) {
        return getFactory().createArgumentType(key, type);
    }

    // Suppress default constructor to ensure non-instantiability.
    private ArgumentTypes() {
        throw new AssertionError("You should not be attempting to instantiate this class.");
    }

}
