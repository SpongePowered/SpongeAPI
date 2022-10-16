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
package org.spongepowered.api.command.parameter;

import org.spongepowered.api.command.parameter.managed.ValueParameter;
import org.spongepowered.api.command.parameter.managed.standard.ResourceKeyedValueParameters;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.math.vector.Vector3d;

/**
 * Commonly used {@link Parameter.Value parameters} that can be reused in
 * multiple commands.
 *
 * <p>The intent behind these parameters is to reduce the amount of boilerplate
 * used when creating commands and retrieving elements. A general workflow for
 * defining a command with a {@link ServerPlayer} parameter may look like this:
 * </p>
 *
 * <pre> {@code
 * final Parameter.Value<ServerPlayer> parameter = Parameter.player().setKey("player").build();
 * final Command.Parameterized builder = Command.builder()
 *      .parameter(parameter)
 *      .executor(context -> {
 *          context.sendMessage(Component.text(context.requireOne(parameter).getName()));
 *          return CommandResult.success();
 *      }).build();
 * // registration happens here.
 * }</pre>
 *
 * <p>While this is a totally valid approach, there are two particular
 * considerations that can be made:</p>
 *
 * <ul>
 *     <li>Sponge provided {@link ValueParameter}s and, by extension,
 *     {@link Parameter.Value}s are stateless and so can be reused by multiple
 *     commands, or indeed, multiple times within the same command; and</li>
 *     <li>Due to the type safety provided by the {@link CommandContext} and the
 *     requirement of retrieving parsed arguments by the {@link Parameter.Key}
 *     (or the actual {@link Parameter.Value}, which implements this key, plugin
 *     developers will either need to keep a reference to the parameter value,
 *     its key, or rebuild the key as required (paying close attention to the
 *     {@link Parameter.Value} type).</li>
 * </ul>
 *
 * <p>Given these two considerations, it generally makes sense to store one
 * {@link Parameter.Value} for a given {@link ValueParameter} and
 * {@link Parameter.Key} combination. Further, it is clear that plugins will
 * tend to use similar, if not the same, parameter/key combinations.</p>
 *
 * <p>The values held by this class are commonly used {@link Parameter.Value}s
 * with sensible key names such that plugin developers do not have to generate
 * their own parameters and can also use these as {@link Parameter.Key}s when
 * obtaining results from the {@link CommandContext}. The example above would
 * then become:</p>
 *
 * <pre> {@code
 * final Command.Parameterized builder = Command.builder()
 *      .parameter(CommonParameters.PLAYER)
 *      .executor(context -> {
 *          context.sendMessage(Component.text(context.requireOne(CommonParameters.PLAYER).getName()));
 *          return CommandResult.success();
 *      }).build();
 * // registration happens here.
 * }</pre>
 *
 * <p>reducing object creation and slightly reducing repetition amongst commands
 * that use the same parameters.</p>
 */
public final class CommonParameters {

    // SORTFIELDS:ON

    /**
     * A {@link Parameter.Value} that parses a world id and stores it as a
     * {@link ServerWorld} under the key "world".
     *
     * @see ResourceKeyedValueParameters#WORLD
     */
    public static final Parameter.Value<ServerWorld> WORLD = Parameter.world().key("world").build();

    /**
     * A {@link Parameter.Value} that parses a {@link Boolean} with the key name
     * "true/false".
     *
     * @see ResourceKeyedValueParameters#BOOLEAN
     */
    public static final Parameter.Value<Boolean> BOOLEAN = Parameter.bool().key("true/false").build();

    /**
     * A {@link Parameter.Value} that parses a world and a position and stores
     * it as a {@link ServerLocation} under the key "location".
     *
     * @see ResourceKeyedValueParameters#LOCATION
     */
    public static final Parameter.Value<ServerLocation> LOCATION_ONLINE_ONLY = Parameter.location().key("location").build();

    /**
     * A {@link Parameter.Value} that parses the remainder of the string under
     * the key "message".
     *
     * @see ResourceKeyedValueParameters#REMAINING_JOINED_STRINGS
     */
    public static final Parameter.Value<String> MESSAGE = Parameter.remainingJoinedStrings().key("message").build();

    /**
     * A {@link Parameter.Value} that parses a player name or selector and
     * stores the results under the key "player".
     *
     * @see ResourceKeyedValueParameters#PLAYER
     */
    public static final Parameter.Value<ServerPlayer> PLAYER = Parameter.player().key("player").build();

    /**
     * A {@link Parameter.Value} that parses a player name or selector and
     * stores the results under the key "player" if the input is valid.
     * Otherwise, this parameter is skipped.
     *
     * @see ResourceKeyedValueParameters#PLAYER
     */
    public static final Parameter.Value<ServerPlayer> PLAYER_OPTIONAL = Parameter.player().optional().key("player").build();

    /**
     * A {@link Parameter.Value} that parses a position and stores it as a
     * {@link Vector3d} under the key "position".
     *
     * @see ResourceKeyedValueParameters#VECTOR3D
     */
    public static final Parameter.Value<Vector3d> POSITION = Parameter.vector3d().key("position").build();

    // SORTFIELDS:OFF

    private CommonParameters() {
        throw new AssertionError("This should not be instantiated");
    }

}
