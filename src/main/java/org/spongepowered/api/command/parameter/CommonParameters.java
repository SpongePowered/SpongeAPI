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

import org.spongepowered.api.command.CommandCause;
import org.spongepowered.api.command.parameter.CommandContext;
import org.spongepowered.api.command.parameter.Parameter;
import org.spongepowered.api.command.parameter.managed.ValueParameter;
import org.spongepowered.api.command.parameter.managed.standard.CatalogedValueParameters;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.api.world.storage.WorldProperties;
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
 * <pre>
 * final Parameter.Value&lt;ServerPlayer&gt; parameter = Parameter.player().setKey("player").build();
 * final Command.Parameterized builder = Command.builder()
 *      .parameter(parameter)
 *      .executor(context -> {
 *          context.sendMessage(Component.text(context.requireOne(parameter).getName()));
 *          return CommandResult.success();
 *      }).build();
 * // registration happens here.
 * </pre>
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
 * <pre>
 * final Command.Parameterized builder = Command.builder()
 *      .parameter(CommonParameters.PLAYER)
 *      .executor(context -> {
 *          context.sendMessage(Component.text(context.requireOne(CommonParameters.PLAYER).getName()));
 *          return CommandResult.success();
 *      }).build();
 * // registration happens here.
 * </pre>
 *
 * <p>reducing object creation and slightly reducing repetition amongst commands
 * that use the same parameters.</p>
 */
public final class CommonParameters {

    // SORTFIELDS:ON

    /**
     * A {@link Parameter.Value} that parses a world id and stores it as a
     * {@link WorldProperties} under the key "world". The world in question
     * may or may not be loaded.
     *
     * @see CatalogedValueParameters#WORLD_PROPERTIES_ALL
     */
    public final static Parameter.Value<WorldProperties> ALL_WORLD_PROPERTIES = Parameter.worldProperties(false).setKey("world").build();

    /**
     * A {@link Parameter.Value} that parses a {@link Boolean} with the key name
     * "true/false".
     *
     * @see CatalogedValueParameters#BOOLEAN
     */
    public final static Parameter.Value<Boolean> BOOLEAN = Parameter.bool().setKey("true/false").build();

    /**
     * A {@link Parameter.Value} that parses a world and a position and stores
     * it as a {@link ServerLocation} under the key "location".
     *
     * @see CatalogedValueParameters#LOCATION_ONLINE_ONLY
     */
    public final static Parameter.Value<ServerLocation> LOCATION_ONLINE_ONLY = Parameter.location().setKey("location").build();

    /**
     * A {@link Parameter.Value} that parses the remainder of the string under
     * the key "message".
     *
     * @see CatalogedValueParameters#REMAINING_JOINED_STRINGS
     */
    public final static Parameter.Value<String> MESSAGE = Parameter.remainingJoinedStrings().setKey("message").build();

    /**
     * A {@link Parameter.Value} that parses a world id and stores it as a
     * {@link WorldProperties} under the key "world". The world in question
     * must be online.
     *
     * @see CatalogedValueParameters#WORLD_PROPERTIES_ONLINE_ONLY
     */
    public final static Parameter.Value<WorldProperties> ONLINE_WORLD_PROPERTIES_ONLY = Parameter.worldProperties().setKey("world").build();

    /**
     * A {@link Parameter.Value} that parses a world id and stores it as a
     * {@link WorldProperties} under the key "world". The world in question
     * must be online. The parameter is optional.
     *
     * @see CatalogedValueParameters#WORLD_PROPERTIES_ONLINE_ONLY
     */
    public final static Parameter.Value<WorldProperties> ONLINE_WORLD_PROPERTIES_ONLY_OPTIONAL = Parameter.worldProperties().setKey("world").optional().build();

    /**
     * A {@link Parameter.Value} that parses a player name or selector and
     * stores the results under the key "player".
     *
     * @see CatalogedValueParameters#PLAYER
     */
    public final static Parameter.Value<ServerPlayer> PLAYER = Parameter.player().setKey("player").build();

    /**
     * A {@link Parameter.Value} that parses a player name or selector and
     * stores the results under the key "player" if the input is valid.
     * Otherwise, this parameter is skipped.
     *
     * @see CatalogedValueParameters#PLAYER
     */
    public final static Parameter.Value<ServerPlayer> PLAYER_OPTIONAL = Parameter.player().optional().setKey("player").build();

    /**
     * A {@link Parameter.Value} that parses a player name or selector and
     * stores the results under the key "player". If no results are found but
     * the root of the {@link CommandCause} is a {@link ServerPlayer}, that
     * player is stored in the context instead.
     *
     * @see CatalogedValueParameters#PLAYER
     * @see Parameter#playerOrSource()
     */
    public final static Parameter.Value<ServerPlayer> PLAYER_OR_SOURCE = Parameter.playerOrSource().setKey("player").build();

    /**
     * A {@link Parameter.Value} that parses a position and stores it as a
     * {@link Vector3d} under the key "position".
     *
     * @see CatalogedValueParameters#VECTOR3D
     */
    public final static Parameter.Value<Vector3d> POSITION = Parameter.vector3d().setKey("position").build();

    // SORTFIELDS:OFF

    private CommonParameters() {
        throw new AssertionError("This should not be instantiated");
    }

}
