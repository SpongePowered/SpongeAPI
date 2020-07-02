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
package org.spongepowered.api.command.parameter.managed.standard;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockSnapshot;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.cause.Cause;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;
import org.spongepowered.api.world.ServerLocation;
import org.spongepowered.api.world.dimension.Dimension;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.plugin.PluginContainer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * Class containing common {@link CatalogedValueParameters}s.
 */
public final class CatalogedValueParameters {

    private CatalogedValueParameters() {}

    // SORTFIELDS:ON

    /**
     * Require an argument to be a {@link BigDecimal}.
     *
     * <p>Returns a {@link BigDecimal}.</p>
     */
    public static final Supplier<CatalogedValueParameter<BigDecimal>> BIG_DECIMAL =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "BIG_DECIMAL");

    /**
     * Require an argument to be a {@link BigInteger}.
     *
     * <p>Returns a {@link BigInteger}.</p>
     */
    public static final Supplier<CatalogedValueParameter<BigInteger>> BIG_INTEGER =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "BIG_INTEGER");

    /**
     * Require an argument to be a boolean.
     *
     * <p>The recognized true values are:</p>
     *
     * <ul>
     *     <li>true</li>
     *     <li>t</li>
     *     <li>yes</li>
     *     <li>y</li>
     *     <li>veryumuchso</li>
     * </ul>
     *
     * <p>The recognized false values are:</p>
     *
     * <ul>
     *     <li>false</li>
     *     <li>f</li>
     *     <li>no</li>
     *     <li>n</li>
     *     <li>notatall</li>
     * </ul>
     *
     * <p>Returns a {@link Boolean}.</p>
     */
    public static final Supplier<CatalogedValueParameter<Boolean>> BOOLEAN =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "BOOLEAN");

    /**
     * Require an argument to be a {@link Color}
     *
     * <p>There are three types of input that may be used with this element:</p>
     *
     * <ul>
     *     <li>An inbuilt named color, as seen in the {@link Color} class</li>
     *     <li>A comma separated set of RGB values, each of which ranges from 0
     *     to 255 (eg. "125,3,75" for the red, green and blue components,
     *     respectively)</li>
     *     <li>A hex value, which <em>must</em> be prefixed with "#" or "0x"</li>
     * </ul>
     *
     * <p>Returns a {@link Color}</p>
     */
    public static final Supplier<CatalogedValueParameter<Color>> COLOR =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "COLOR");

    /**
     * Requires an argument to be a HOCON or JSON representation of a {@link DataContainer}.
     *
     * <p>Note that this parameter will consume <strong>all</strong> arguments,
     * thus, this should be put at the end of a parameter chain.</p>
     *
     * <p>Returns a {@link DataContainer}</p>
     */
    public static final Supplier<CatalogedValueParameter<DataContainer>> DATA_CONTAINER =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "DATA_CONTAINER");

    /**
     * Expect an argument to be a date-time, in the form of a
     * {@link LocalDateTime}. If no date is specified, {@link LocalDate#now()}
     * is used; if no time is specified, {@link LocalTime#MIDNIGHT} is used.
     *
     * <p>Date-times are expected in the ISO-8601 format.</p>
     *
     * <p>Returns a {@link LocalDateTime}</p>
     */
    public static final Supplier<CatalogedValueParameter<LocalDateTime>> DATE_TIME =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "DATE_TIME");

    /**
     * Expect an argument to represent a dimension.
     *
     * <p>Returns a {@link Dimension}</p>
     */
    public static final Supplier<CatalogedValueParameter<Dimension>> DIMENSION =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "DIMENSION");

    /**
     * Require an argument to be an double-precision floating point number.
     *
     * <p>Returns a {@link Double}.</p>
     */
    public static final Supplier<CatalogedValueParameter<Double>> DOUBLE =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "DOUBLE");

    /**
     * Require an argument to be a duration.
     *
     * <p>The duration can be specified in one of these ways:</p>
     *
     * <ul>
     *     <li>A number, which will be assumed to be seconds.</li>
     *     <li>An element of the form {@code D:HH:MM:SS} - days and hours can
     *     be omitted.</li>
     *     <li>An element of the form
     *     {@code [weeks]w[days]d[hours]h[minutes]m[seconds]s[millis]ms},
     *     where any zeroed unit can be omitted.</li>
     * </ul>
     *
     * <p>Returns a {@link Duration}.</p>
     */
    public static final Supplier<CatalogedValueParameter<Duration>> DURATION =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "DURATION");

    /**
     * Require an argument to select one {@link Entity}.
     *
     * <p>This parameter accepts selectors.</p>
     *
     * <p>Returns an {@link Entity}.</p>
     */
    public static final Supplier<CatalogedValueParameter<Entity>> ENTITY =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "ENTITY");

    /**
     * Expect an argument to represent a {@link GameProfile} of a user.
     *
     * <p>This parameter accepts selectors (to obtain the game profiles of online players).</p>
     *
     * <p>Returns a {@link GameProfile}.</p>
     */
    public static final Supplier<CatalogedValueParameter<GameProfile>> GAME_PROFILE =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "GAME_PROFILE");

    /**
     * Require an argument to be an integer (base 10) number.
     *
     * <p>Returns an {@link Integer}.</p>
     */
    public static final Supplier<CatalogedValueParameter<Integer>> INTEGER =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "INTEGER");

    /**
     * Require an argument to be an IP address.
     *
     * <p>Returns an {@link InetAddress}</p>
     */
    public static final Supplier<CatalogedValueParameter<InetAddress>> IP =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "IP");

    /**
     * Expect an argument to represent a {@link ServerLocation}.
     *
     * <p>Listens to:</p>
     *
     * <ul>
     *     <li>#spawn:&lt;world&gt;</li>
     *     <li>#me: Location of the current source</li>
     * </ul>
     *
     * <p>Returns a {@link ServerLocation}.</p>
     */
    public static final Supplier<CatalogedValueParameter<ServerLocation>> LOCATION =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "LOCATION");

    /**
     * Require an argument to be a long (base 10).
     *
     * <p>Returns a {@link Long}.</p>
     */
    public static final Supplier<CatalogedValueParameter<Long>> LONG =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "LONG");

    /**
     * Require an argument to select many {@link Entity entities}.
     *
     * <p>This parameter accepts selectors.</p>
     *
     * <p>Returns many {@link Entity} objects.</p>
     *
     * @see #ENTITY
     */
    public static final Supplier<CatalogedValueParameter<List<Entity>>> MANY_ENTITIES =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "MANY_ENTITIES");

    /**
     * Require an argument to select many {@link ServerPlayer players}.
     *
     * <p>This parameter accepts selectors.</p>
     *
     * <p>Returns many {@link Player} objects.</p>
     *
     * @see #PLAYER
     */
    public static final Supplier<CatalogedValueParameter<List<ServerPlayer>>> MANY_PLAYERS =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "MANY_PLAYERS");

    /**
     * Does not parse any arguments, returning nothing.
     *
     * <p>Returns nothing - no entry will be placed into any provided key.</p>
     */
    public static final Supplier<CatalogedValueParameter<Void>> NONE =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "NONE");

    /**
     * Expect an argument to represent an online player.
     *
     * <p>This parameter accepts selectors.</p>
     *
     * <p>Returns a {@link ServerPlayer}.</p>
     */
    public static final Supplier<CatalogedValueParameter<ServerPlayer>> PLAYER =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "PLAYER");

    /**
     * Expect an argument to represent a {@link PluginContainer}'s id.
     *
     * <p>Returns a {@link PluginContainer}</p>
     */
    public static final Supplier<CatalogedValueParameter<PluginContainer>> PLUGIN =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "PLUGIN");

    /**
     * Require one or more strings, without any processing, which are combined
     * into a single, space-separated string.
     *
     * <p>Returns a {@link String}.</p>
     */
    public static final Supplier<CatalogedValueParameter<String>> REMAINING_JOINED_STRINGS =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "REMAINING_JOINED_STRINGS");

    /**
     * Require one or more strings, which are combined into a single,
     * space-separated string.
     *
     * <p>Returns a {@link String}.</p>
     */
    public static final Supplier<CatalogedValueParameter<String>> REMAINING_RAW_JOINED_STRINGS =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "REMAINING_RAW_JOINED_STRINGS");

    /**
     * Require an argument to be a string.
     *
     * <p>Returns a {@link String}.</p>
     */
    public static final Supplier<CatalogedValueParameter<String>> STRING =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "STRING");

    /**
     * Does not parse any arguments, but instead returns a
     * {@link org.spongepowered.api.block.BlockSnapshot} if the
     * current root of the {@link Cause} is targeting (looking at)
     * a block.
     *
     * <p>This will always fail for non-locatable sources</p>
     *
     * <p>Returns a {@link org.spongepowered.api.block.BlockSnapshot}.</p>
     */
    public static final Supplier<CatalogedValueParameter<BlockSnapshot>> TARGET_BLOCK =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "TARGET_BLOCK");

    /**
     * Does not parse any arguments, but instead returns a
     * {@link org.spongepowered.api.entity.Entity} if the
     * current root of the {@link Cause} is such an entity (which thus
     * must be a {@link org.spongepowered.api.world.Locatable}).
     *
     * <p>This will always fail for non-locatable sources</p>
     *
     * <p>Returns a {@link org.spongepowered.api.entity.Entity}.</p>
     */
    public static final Supplier<CatalogedValueParameter<Entity>> TARGET_ENTITY =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "TARGET_ENTITY");

    /**
     * Does not parse any arguments, but instead returns a {@link ServerPlayer}
     * if the current root of the {@link Cause} is as such (which thus must be
     * a {@link org.spongepowered.api.world.Locatable}).
     *
     * <p>This will always fail for non-locatable sources</p>
     *
     * <p>Returns a {@link ServerPlayer}.</p>
     */
    public static final Supplier<CatalogedValueParameter<ServerPlayer>> TARGET_PLAYER =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "TARGET_PLAYER");

    /**
     * Expects an argument to represent some {@link Text} serialised using formatting codes.
     *
     * <p>This will only consume one argument</p>
     *
     * <p>Returns a {@link Text}</p>
     */
    public static final Supplier<CatalogedValueParameter<Text>> TEXT_FORMATTING_CODE =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "TEXT_FORMATTING_CODE");

    /**
     * Expects an argument to represent some {@link Text} serialised using formatting codes.
     *
     * <p>This will consume all remaining arguments</p>
     *
     * <p>Returns a {@link Text}</p>
     */
    public static final Supplier<CatalogedValueParameter<Text>> TEXT_FORMATTING_CODE_ALL =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "TEXT_FORMATTING_CODE_ALL");

    /**
     * Expects an argument to represent some {@link Text} serialised using Json.
     *
     * <p>This will only consume one argument</p>
     *
     * <p>Returns a {@link Text}</p>
     */
    public static final Supplier<CatalogedValueParameter<Text>> TEXT_JSON =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "TEXT_JSON");

    /**
     * Expects an argument to represent some {@link Text} serialised using Json.
     *
     * <p>This will consume all remaining arguments</p>
     *
     * <p>Returns a {@link Text}</p>
     */
    public static final Supplier<CatalogedValueParameter<Text>> TEXT_JSON_ALL =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "TEXT_JSON_ALL");

    /**
     * Require an argument to be a URL.
     *
     * <p>Returns a {@link URL}</p>
     */
    public static final Supplier<CatalogedValueParameter<URL>> URL =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "URL");

    /**
     * Expect an argument to represent a player who has been online at some
     * point, as a {@link User}.
     *
     * <p>This parameter accepts selectors (to obtain players).</p>
     *
     * <p>Returns a {@link User}.</p>
     */
    public static final Supplier<CatalogedValueParameter<User>> USER =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "USER");

    /**
     * Expect an argument to represent a {@link UUID}
     *
     * <p>Returns a {@link UUID}.</p>
     */
    public static final Supplier<CatalogedValueParameter<UUID>> UUID =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "UUID");

    /**
     * Expect an argument to represent a {@link Vector3d}.
     *
     * <p>The expected syntax is:</p>
     *
     * <blockquote><pre> x,y,z
     * x y z.</pre></blockquote>
     *
     * <p>Each element can be relative to a location -- relative is ~(num)</p>
     *
     * <p>Returns a {@link Vector3d}.</p>
     */
    public static final CatalogedValueParameter<Vector3d> VECTOR3D =
            DummyObjectProvider.createExtendedFor(CatalogedValueParameter.class, "VECTOR3D");

    /**
     * Expect an argument to represent a world.
     *
     * <p>Accepted formats:</p>
     *
     * <ul>
     *     <li>#first</li>
     *     <li>#&lt;dimension&gt;</li>
     *     <li>&lt;name&gt;</li>
     *     <li>#me</li>
     * </ul>
     *
     * <p>Returns a {@link WorldProperties}.</p>
     */
    public static final Supplier<CatalogedValueParameter<WorldProperties>> WORLD_PROPERTIES =
            Sponge.getRegistry().getCatalogRegistry().provideSupplier(CatalogedValueParameter.class, "WORLD_PROPERTIES");

    // SORTFIELDS:OFF

}
