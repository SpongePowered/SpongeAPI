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

import net.kyori.adventure.text.Component;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.command.parameter.managed.operator.Operator;
import org.spongepowered.api.command.parameter.managed.operator.Operators;
import org.spongepowered.api.data.persistence.DataContainer;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.entity.living.player.server.ServerPlayer;
import org.spongepowered.api.event.Cause;
import org.spongepowered.api.item.inventory.ItemStackSnapshot;
import org.spongepowered.api.profile.GameProfile;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.registry.RegistryTypes;
import org.spongepowered.api.util.Color;
import org.spongepowered.api.world.Locatable;
import org.spongepowered.api.world.server.ServerLocation;
import org.spongepowered.api.world.server.ServerWorld;
import org.spongepowered.api.world.storage.WorldProperties;
import org.spongepowered.math.vector.Vector2d;
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
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * Class containing common {@link ResourceKeyedValueParameter parameters}.
 */
@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class ResourceKeyedValueParameters {

    // @formatter:off

    // SORTFIELDS:ON

    /**
     * Require an argument to be a {@link BigDecimal}.
     *
     * <p>Returns a {@link BigDecimal}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<BigDecimal>> BIG_DECIMAL = ResourceKeyedValueParameters.key(ResourceKey.sponge("big_decimal"));

    /**
     * Require an argument to be a {@link BigInteger}.
     *
     * <p>Returns a {@link BigInteger}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<BigInteger>> BIG_INTEGER = ResourceKeyedValueParameters.key(ResourceKey.sponge("big_integer"));

    /**
     * Requires an argument to represent a {@link BlockState}
     *
     * <p>Returns a {@link BlockState}</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<BlockState>> BLOCK_STATE = ResourceKeyedValueParameters.key(ResourceKey.sponge("block_state"));

    /**
     * Require an argument to be a boolean.
     *
     * <p>Returns a {@link Boolean}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Boolean>> BOOLEAN = ResourceKeyedValueParameters.key(ResourceKey.sponge("boolean"));

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
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Color>> COLOR = ResourceKeyedValueParameters.key(ResourceKey.sponge("color"));

    /**
     * Requires an argument to be a HOCON or JSON representation of a {@link DataContainer}.
     *
     * <p>Note that this parameter will consume <strong>all</strong> arguments,
     * thus, this should be put at the end of a parameter chain.</p>
     *
     * <p>Returns a {@link DataContainer}</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<DataContainer>> DATA_CONTAINER = ResourceKeyedValueParameters.key(ResourceKey.sponge("data_container"));

    /**
     * Expect an argument to be a date-time, in the form of a
     * {@link LocalDateTime}. If no date is specified, {@link LocalDate#now()}
     * is used; if no time is specified, {@link LocalTime#MIDNIGHT} is used.
     *
     * <p>Date-times are expected in the ISO-8601 format.</p>
     *
     * <p>Returns a {@link LocalDateTime}</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<LocalDateTime>> DATE_TIME = ResourceKeyedValueParameters.key(ResourceKey.sponge("date_time"));

    /**
     * Require an argument to be an double-precision floating point number.
     *
     * <p>Returns a {@link Double}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Double>> DOUBLE = ResourceKeyedValueParameters.key(ResourceKey.sponge("double"));

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
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Duration>> DURATION = ResourceKeyedValueParameters.key(ResourceKey.sponge("duration"));

    /**
     * Require an argument to select one {@link Entity}.
     *
     * <p>This parameter accepts selectors.</p>
     *
     * <p>Returns an {@link Entity}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Entity>> ENTITY = ResourceKeyedValueParameters.key(ResourceKey.sponge("entity"));

    /**
     * Expect an argument to represent a {@link GameProfile} of a user.
     *
     * <p>Returns a {@link GameProfile}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<GameProfile>> GAME_PROFILE = ResourceKeyedValueParameters.key(ResourceKey.sponge("game_profile"));

    /**
     * Require an argument to be an integer (base 10) number.
     *
     * <p>Returns an {@link Integer}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Integer>> INTEGER = ResourceKeyedValueParameters.key(ResourceKey.sponge("integer"));

    /**
     * Require an argument to be an IP address.
     *
     * <p>Returns an {@link InetAddress}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<InetAddress>> IP = ResourceKeyedValueParameters.key(ResourceKey.sponge("ip"));

    /**
     * Require an argument to represent an item.
     *
     * <p>Returns a {@link ItemStackSnapshot} with a quantity of 1.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<ItemStackSnapshot>> ITEM_STACK_SNAPSHOT = ResourceKeyedValueParameters.key(ResourceKey.sponge("item_stack_snapshot"));

    /**
     * Expect an argument to represent a {@link ServerLocation}.
     *
     * <p>Returns a {@link ServerLocation}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<ServerLocation>> LOCATION = ResourceKeyedValueParameters.key(ResourceKey.sponge("location"));

    /**
     * Require an argument to be a long (base 10).
     *
     * <p>Returns a {@link Long}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Long>> LONG = ResourceKeyedValueParameters.key(ResourceKey.sponge("long"));

    /**
     * Require an argument to select many {@link Entity entities}.
     *
     * <p>This parameter accepts selectors.</p>
     *
     * <p>Returns many {@link Entity} objects.</p>
     *
     * @see #ENTITY
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<List<Entity>>> MANY_ENTITIES = ResourceKeyedValueParameters.key(ResourceKey.sponge("many_entities"));

    /**
     * Expect an argument to represent a {@link GameProfile} of a user.
     *
     * <p>This parameter accepts selectors (to obtain the game profiles of
     * online players). As a result, this may return multiple profiles.</p>
     *
     * <p>Returns a {@link GameProfile}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Collection<GameProfile>>> MANY_GAME_PROFILES = ResourceKeyedValueParameters.key(ResourceKey.sponge("many_game_profiles"));

    /**
     * Require an argument to select many {@link ServerPlayer players}.
     *
     * <p>This parameter accepts selectors.</p>
     *
     * <p>Returns many {@link Player} objects.</p>
     *
     * @see #PLAYER
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<List<ServerPlayer>>> MANY_PLAYERS = ResourceKeyedValueParameters.key(ResourceKey.sponge("many_players"));

    /**
     * Does not parse any arguments, returning nothing.
     *
     * <p>Returns nothing - no entry will be placed into any provided key.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Void>> NONE = ResourceKeyedValueParameters.key(ResourceKey.sponge("none"));

    /**
     * Expect an argument to represent an {@link Operator}
     *
     * <p>Valid operators are specified in {@link Operators}</p>
     *
     * <p>Returns an {@link Operator}</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Operator>> OPERATOR = ResourceKeyedValueParameters.key(ResourceKey.sponge("operator"));

    /**
     * Expect an argument to represent an online player.
     *
     * <p>This parameter accepts selectors.</p>
     *
     * <p>Returns a {@link ServerPlayer}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<ServerPlayer>> PLAYER = ResourceKeyedValueParameters.key(ResourceKey.sponge("player"));

    /**
     * Expect an argument to represent a {@link PluginContainer}'s id.
     *
     * <p>Returns a {@link PluginContainer}</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<PluginContainer>> PLUGIN = ResourceKeyedValueParameters.key(ResourceKey.sponge("plugin"));

    /**
     * Require one or more strings, without any processing, which are combined
     * into a single, space-separated string.
     *
     * <p>Returns a {@link String}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<String>> REMAINING_JOINED_STRINGS = ResourceKeyedValueParameters.key(ResourceKey.sponge("remaining_joined_strings"));

    /**
     * Require an argument to be a namespaced {@link ResourceKey}.
     *
     * <p>Returns a {@link ResourceKey}</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<ResourceKey>> RESOURCE_KEY = ResourceKeyedValueParameters.key(ResourceKey.sponge("resource_key"));

    /**
     * Require an argument to be a string.
     *
     * <p>Returns a {@link String}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<String>> STRING = ResourceKeyedValueParameters.key(ResourceKey.sponge("string"));

    /**
     * Does not parse any arguments, but instead returns a
     * {@link ServerLocation} if the current root of the
     * {@link Cause} is targeting (looking at) a non-air block.
     *
     * <p>This will always fail for non-locatable sources</p>
     *
     * <p>Returns a {@link ServerLocation}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<ServerLocation>> TARGET_BLOCK = ResourceKeyedValueParameters.key(ResourceKey.sponge("target_block"));

    /**
     * Does not parse any arguments, but instead returns a {@link Entity} if the
     * current root of the {@link Cause} is such an entity (which thus must be a
     * {@link Locatable}).
     *
     * <p>This will always fail for non-locatable sources</p>
     *
     * <p>Returns a {@link Entity}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Entity>> TARGET_ENTITY = ResourceKeyedValueParameters.key(ResourceKey.sponge("target_entity"));

    /**
     * Does not parse any arguments, but instead returns a {@link ServerPlayer}
     * if the current root of the {@link Cause} is as such (which thus must be
     * a {@link org.spongepowered.api.world.Locatable}).
     *
     * <p>This will always fail for non-locatable sources</p>
     *
     * <p>Returns a {@link ServerPlayer}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<ServerPlayer>> TARGET_PLAYER = ResourceKeyedValueParameters.key(ResourceKey.sponge("target_player"));

    /**
     * Expects an argument to represent some {@link Component} serialised using formatting codes.
     *
     * <p>This will only consume one argument</p>
     *
     * <p>Returns a {@link Component}</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Component>> TEXT_FORMATTING_CODE = ResourceKeyedValueParameters.key(ResourceKey.sponge("text_formatting_code"));

    /**
     * Expects an argument to represent some {@link Component} serialised using formatting codes.
     *
     * <p>This will consume all remaining arguments</p>
     *
     * <p>Returns a {@link Component}</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Component>> TEXT_FORMATTING_CODE_ALL = ResourceKeyedValueParameters.key(ResourceKey.sponge("text_formatting_code_all"));

    /**
     * Expects an argument to represent some {@link Component} serialised using Json.
     *
     * <p>This will only consume one argument</p>
     *
     * <p>Returns a {@link Component}</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Component>> TEXT_JSON = ResourceKeyedValueParameters.key(ResourceKey.sponge("text_json"));

    /**
     * Expects an argument to represent some {@link Component} serialised using Json.
     *
     * <p>This will consume all remaining arguments</p>
     *
     * <p>Returns a {@link Component}</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Component>> TEXT_JSON_ALL = ResourceKeyedValueParameters.key(ResourceKey.sponge("text_json_all"));

    /**
     * Require an argument to be a URL.
     *
     * <p>Returns a {@link URL}</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<URL>> URL = ResourceKeyedValueParameters.key(ResourceKey.sponge("url"));

    /**
     * Expect an argument to represent a player who has been online at some
     * point, as a {@link User}.
     *
     * <p>This parameter accepts selectors (to obtain players).</p>
     *
     * <p>Returns a {@link User}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<User>> USER = ResourceKeyedValueParameters.key(ResourceKey.sponge("user"));

    /**
     * Expect an argument to represent a {@link UUID}
     *
     * <p>Returns a {@link UUID}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<UUID>> UUID = ResourceKeyedValueParameters.key(ResourceKey.sponge("uuid"));

    /**
     * Expect an argument to represent a {@link Vector2d}.
     *
     * <p>The expected syntax is:</p>
     *
     * <blockquote><pre> x,y
     * x y.</pre></blockquote>
     *
     * <p>Each element can be relative to a location -- relative is ~(num)</p>
     *
     * <p>Returns a {@link Vector2d}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Vector2d>> VECTOR2D = ResourceKeyedValueParameters.key(ResourceKey.sponge("vector2d"));

    /**
     * Expect an argument to represent a {@link Vector3d}.
     *
     * <p>The expected syntax is:</p>
     *
     * <blockquote><pre>x y z</pre></blockquote>
     *
     * <p>Each element can be relative to a location -- relative is ~(num)</p>
     *
     * <p>Returns a {@link Vector3d}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<Vector3d>> VECTOR3D = ResourceKeyedValueParameters.key(ResourceKey.sponge("vector3d"));

    /**
     * Expect an argument to represent the {@link ResourceKey key} of any {@link ServerWorld world} known to the game.
     *
     * <p>Returns a {@link WorldProperties}.</p>
     */
    public static final DefaultedRegistryReference<ResourceKeyedValueParameter<ServerWorld>> WORLD = ResourceKeyedValueParameters.key(ResourceKey.sponge("world"));

    // SORTFIELDS:OFF

    // @formatter:on

    private ResourceKeyedValueParameters() {
    }

    private static <T> DefaultedRegistryReference<ResourceKeyedValueParameter<T>> key(final ResourceKey location) {
        return RegistryKey.of(RegistryTypes.REGISTRY_KEYED_VALUE_PARAMETER, location).asDefaultedReference(() -> Sponge.game().registries());
    }
}
