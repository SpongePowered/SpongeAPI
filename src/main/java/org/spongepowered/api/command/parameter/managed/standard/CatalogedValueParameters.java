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

import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;
import org.spongepowered.api.world.Dimension;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.storage.WorldProperties;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

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
    public static final CatalogedValueParameter BIG_DECIMAL = DummyObjectProvider.createFor(CatalogedValueParameter.class, "BIG_DECIMAL");

    /**
     * Require an argument to be a {@link BigInteger}.
     *
     * <p>Returns a {@link BigInteger}.</p>
     */
    public static final CatalogedValueParameter BIG_INTEGER = DummyObjectProvider.createFor(CatalogedValueParameter.class, "BIG_INTEGER");

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
    public static final CatalogedValueParameter BOOLEAN = DummyObjectProvider.createFor(CatalogedValueParameter.class, "BOOLEAN");

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
    public static final CatalogedValueParameter COLOR = DummyObjectProvider.createFor(CatalogedValueParameter.class, "COLOR");

    /**
     * Requires an argument to be a HOCON or JSON representation of a {@link DataContainer}.
     *
     * <p>Note that this parameter will consume <strong>all</strong> arguments,
     * thus, this should be put at the end of a parameter chain.</p>
     *
     * <p>Returns a {@link DataContainer}</p>
     */
    public static final CatalogedValueParameter DATA_CONTAINER = DummyObjectProvider.createFor(CatalogedValueParameter.class, "DATA_CONTAINER");

    /**
     * Expect an argument to be a date-time, in the form of a
     * {@link LocalDateTime}. If no date is specified, {@link LocalDate#now()}
     * is used; if no time is specified, {@link LocalTime#MIDNIGHT} is used.
     *
     * <p>Date-times are expected in the ISO-8601 format.</p>
     *
     * <p>Returns a {@link LocalDateTime}</p>
     */
    public static final CatalogedValueParameter DATE_TIME = DummyObjectProvider.createFor(CatalogedValueParameter.class, "DATE_TIME");

    /**
     * Expect an argument to represent a dimension.
     *
     * <p>Returns a {@link Dimension}</p>
     */
    public static final CatalogedValueParameter DIMENSION = DummyObjectProvider.createFor(CatalogedValueParameter.class, "DIMENSION");

    /**
     * Require an argument to be an double-precision floating point number.
     *
     * <p>Returns a {@link Double}.</p>
     */
    public static final CatalogedValueParameter DOUBLE = DummyObjectProvider.createFor(CatalogedValueParameter.class, "DOUBLE");

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
    public static final CatalogedValueParameter DURATION = DummyObjectProvider.createFor(CatalogedValueParameter.class, "DURATION");

    /**
     * TODO: This
     *
     * <p>This parameter accepts selectors.</p>
     *
     * <p>Returns an {@link Entity}.</p>
     */
    public static final CatalogedValueParameter ENTITY = DummyObjectProvider.createFor(CatalogedValueParameter.class, "ENTITY");

    /**
     * Require an argument to be an integer (base 10) number.
     *
     * <p>Returns an {@link Integer}.</p>
     */
    public static final CatalogedValueParameter INTEGER = DummyObjectProvider.createFor(CatalogedValueParameter.class, "INTEGER");

    /**
     * Require an argument to be an IP address.
     *
     * <p>Returns an {@link InetAddress}</p>
     */
    public static final CatalogedValueParameter IP = DummyObjectProvider.createFor(CatalogedValueParameter.class, "IP");

    /**
     * Expect an argument to represent a {@link Location}.
     *
     * <p>Listens to:</p>
     *
     * <ul>
     *     <li>#spawn:&lt;world></li>
     *     <li>#me: Location of the current source</li>
     * </ul>
     *
     * <p>Returns a {@link Location}.</p>
     */
    public static final CatalogedValueParameter LOCATION = DummyObjectProvider.createFor(CatalogedValueParameter.class, "LOCATION");

    /**
     * Require an argument to be a long (base 10).
     *
     * <p>Returns a {@link Long}.</p>
     */
    public static final CatalogedValueParameter LONG = DummyObjectProvider.createFor(CatalogedValueParameter.class, "LONG");

    /**
     * Does not parse any arguments, returning nothing.
     *
     * <p>Returns nothing - no entry will be placed into any provided key.</p>
     */
    public static final CatalogedValueParameter NONE = DummyObjectProvider.createFor(CatalogedValueParameter.class, "NONE");

    /**
     * Expect an argument to represent an online player.
     *
     * <p>This parameter accepts selectors.</p>
     *
     * <p>Returns a {@link Player}.</p>
     */
    public static final CatalogedValueParameter PLAYER = DummyObjectProvider.createFor(CatalogedValueParameter.class, "PLAYER");

    /**
     * Expect an argument to represent a {@link PluginContainer}'s id.
     *
     * <p>Returns a {@link PluginContainer}</p>
     */
    public static final CatalogedValueParameter PLUGIN =
            DummyObjectProvider.createFor(CatalogedValueParameter.class, "PLUGIN");

    /**
     * Require one or more strings, without any processing, which are combined
     * into a single, space-separated string.
     *
     * <p>Returns a {@link String}.</p>
     */
    public static final CatalogedValueParameter REMAINING_JOINED_STRINGS =
            DummyObjectProvider.createFor(CatalogedValueParameter.class, "REMAINING_JOINED_STRINGS");

    /**
     * Require one or more strings, which are combined into a single,
     * space-separated string.
     *
     * <p>Returns a {@link String}.</p>
     */
    public static final CatalogedValueParameter REMAINING_RAW_JOINED_STRINGS =
            DummyObjectProvider.createFor(CatalogedValueParameter.class, "REMAINING_RAW_JOINED_STRINGS");

    /**
     * Require an argument to be a string.
     *
     * <p>Returns a {@link String}.</p>
     */
    public static final CatalogedValueParameter STRING = DummyObjectProvider.createFor(CatalogedValueParameter.class, "STRING");

    /**
     * Expects an argument to represent some {@link Text} serialised using formatting codes.
     *
     * <p>This will only consume one argument</p>
     *
     * <p>Returns a {@link Text}</p>
     */
    public static final CatalogedValueParameter TEXT_FORMATTING_CODE =
            DummyObjectProvider.createFor(CatalogedValueParameter.class, "TEXT_FORMATTING_CODE");

    /**
     * Expects an argument to represent some {@link Text} serialised using formatting codes.
     *
     * <p>This will consume all remaining arguments</p>
     *
     * <p>Returns a {@link Text}</p>
     */
    public static final CatalogedValueParameter TEXT_FORMATTING_CODE_ALL =
            DummyObjectProvider.createFor(CatalogedValueParameter.class, "TEXT_FORMATTING_CODE_ALL");

    /**
     * Expects an argument to represent some {@link Text} serialised using Json.
     *
     * <p>This will only consume one argument</p>
     *
     * <p>Returns a {@link Text}</p>
     */
    public static final CatalogedValueParameter TEXT_JSON =
            DummyObjectProvider.createFor(CatalogedValueParameter.class, "TEXT_JSON");

    /**
     * Expects an argument to represent some {@link Text} serialised using Json.
     *
     * <p>This will consume all remaining arguments</p>
     *
     * <p>Returns a {@link Text}</p>
     */
    public static final CatalogedValueParameter TEXT_JSON_ALL =
            DummyObjectProvider.createFor(CatalogedValueParameter.class, "TEXT_JSON_ALL");

    /**
     * Require an argument to be a URL.
     *
     * <p>Returns a {@link URL}</p>
     */
    public static final CatalogedValueParameter URL = DummyObjectProvider.createFor(CatalogedValueParameter.class, "URL");

    /**
     * Expect an argument to represent a player who has been online at some
     * point, as a {@link User}.
     *
     * <p>This parameter accepts selectors (to obtain players).</p>
     *
     * <p>Returns a {@link User}.</p>
     */
    public static final CatalogedValueParameter USER = DummyObjectProvider.createFor(CatalogedValueParameter.class, "USER");

    /**
     * Expect an argument to represent a {@link UUID}
     *
     * <p>Returns a {@link UUID}.</p>
     */
    public static final CatalogedValueParameter UUID = DummyObjectProvider.createFor(CatalogedValueParameter.class, "UUID");

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
    public static final CatalogedValueParameter VECTOR3D = DummyObjectProvider.createFor(CatalogedValueParameter.class, "VECTOR3D");

    /**
     * Expect an argument to represent a world.
     *
     * <p>Accepted formats:</p>
     *
     * <ul>
     *     <li>#first</li>
     *     <li>#&lt;dimension></li>
     *     <li>&lt;name></li>
     *     <li>#me</li>
     * </ul>
     *
     * <p>Returns a {@link WorldProperties}.</p>
     */
    public static final CatalogedValueParameter WORLD_PROPERTIES = DummyObjectProvider.createFor(CatalogedValueParameter.class, "WORLD_PROPERTIES");

    // SORTFIELDS:OFF

}
