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
package org.spongepowered.api.data.persistence;

import net.kyori.adventure.text.Component;
import org.spongepowered.api.ResourceKey;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.fluid.FluidState;
import org.spongepowered.api.registry.DefaultedRegistryReference;
import org.spongepowered.api.registry.Registries;
import org.spongepowered.api.registry.RegistryKey;
import org.spongepowered.api.registry.RegistryScope;
import org.spongepowered.api.registry.RegistryScopes;
import org.spongepowered.api.world.schematic.Schematic;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.math.imaginary.Complexd;
import org.spongepowered.math.imaginary.Complexf;
import org.spongepowered.math.imaginary.Quaterniond;
import org.spongepowered.math.imaginary.Quaternionf;
import org.spongepowered.math.vector.Vector2d;
import org.spongepowered.math.vector.Vector2f;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector2l;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3f;
import org.spongepowered.math.vector.Vector3i;
import org.spongepowered.math.vector.Vector3l;
import org.spongepowered.math.vector.Vector4d;
import org.spongepowered.math.vector.Vector4f;
import org.spongepowered.math.vector.Vector4i;
import org.spongepowered.math.vector.Vector4l;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@SuppressWarnings("unused")
@RegistryScopes(scopes = RegistryScope.GAME)
public final class DataTranslators {

    // @formatter:off

    // SORTFIELDS:ON

    public static final DefaultedRegistryReference<DataTranslator<BlockState>> BLOCK_STATE = DataTranslators.key(ResourceKey.sponge("block_state"));

    public static final DefaultedRegistryReference<DataTranslator<Complexd>> COMPLEXD = DataTranslators.key(ResourceKey.sponge("complexd"));

    public static final DefaultedRegistryReference<DataTranslator<Complexf>> COMPLEXF = DataTranslators.key(ResourceKey.sponge("complexf"));

    public static final DefaultedRegistryReference<DataTranslator<Component>> COMPONENT = DataTranslators.key(ResourceKey.sponge("component"));

    public static final DefaultedRegistryReference<DataTranslator<ConfigurationNode>> CONFIGURATION_NODE = DataTranslators.key(ResourceKey.sponge("configuration_node"));

    public static final DefaultedRegistryReference<DataTranslator<FluidState>> FLUID_STATE = DataTranslators.key(ResourceKey.sponge("fluid_state"));

    public static final DefaultedRegistryReference<DataTranslator<Instant>> INSTANT = DataTranslators.key(ResourceKey.sponge("instant"));

    public static final DefaultedRegistryReference<DataTranslator<Schematic>> LEGACY_SCHEMATIC = DataTranslators.key(ResourceKey.sponge("legacy_schematic"));

    public static final DefaultedRegistryReference<DataTranslator<LocalDate>> LOCAL_DATE = DataTranslators.key(ResourceKey.sponge("local_date"));

    public static final DefaultedRegistryReference<DataTranslator<LocalDateTime>> LOCAL_DATE_TIME = DataTranslators.key(ResourceKey.sponge("local_date_time"));

    public static final DefaultedRegistryReference<DataTranslator<LocalTime>> LOCAL_TIME = DataTranslators.key(ResourceKey.sponge("local_time"));

    public static final DefaultedRegistryReference<DataTranslator<Schematic>> MOJANG_TEMPLATE = DataTranslators.key(ResourceKey.sponge("mojang_template"));

    public static final DefaultedRegistryReference<DataTranslator<Quaterniond>> QUATERNIOND = DataTranslators.key(ResourceKey.sponge("quaterniond"));

    public static final DefaultedRegistryReference<DataTranslator<Quaternionf>> QUATERNIONF = DataTranslators.key(ResourceKey.sponge("quaternionf"));

    public static final DefaultedRegistryReference<DataTranslator<Schematic>> SCHEMATIC = DataTranslators.key(ResourceKey.sponge("schematic"));

    public static final DefaultedRegistryReference<DataTranslator<UUID>> UUID = DataTranslators.key(ResourceKey.sponge("uuid"));

    public static final DefaultedRegistryReference<DataTranslator<Vector2d>> VECTOR_2_D = DataTranslators.key(ResourceKey.sponge("VECTOR_2_D"));

    public static final DefaultedRegistryReference<DataTranslator<Vector2f>> VECTOR_2_F = DataTranslators.key(ResourceKey.sponge("VECTOR_2_F"));

    public static final DefaultedRegistryReference<DataTranslator<Vector2i>> VECTOR_2_I = DataTranslators.key(ResourceKey.sponge("VECTOR_2_I"));

    public static final DefaultedRegistryReference<DataTranslator<Vector2l>> VECTOR_2_L = DataTranslators.key(ResourceKey.sponge("VECTOR_2_L"));

    public static final DefaultedRegistryReference<DataTranslator<Vector3d>> VECTOR_3_D = DataTranslators.key(ResourceKey.sponge("VECTOR_3_D"));

    public static final DefaultedRegistryReference<DataTranslator<Vector3f>> VECTOR_3_F = DataTranslators.key(ResourceKey.sponge("VECTOR_3_F"));

    public static final DefaultedRegistryReference<DataTranslator<Vector3i>> VECTOR_3_I = DataTranslators.key(ResourceKey.sponge("VECTOR_3_I"));

    public static final DefaultedRegistryReference<DataTranslator<Vector3l>> VECTOR_3_L = DataTranslators.key(ResourceKey.sponge("VECTOR_3_L"));

    public static final DefaultedRegistryReference<DataTranslator<Vector4d>> VECTOR_4_D = DataTranslators.key(ResourceKey.sponge("VECTOR_4_D"));

    public static final DefaultedRegistryReference<DataTranslator<Vector4f>> VECTOR_4_F = DataTranslators.key(ResourceKey.sponge("VECTOR_4_F"));

    public static final DefaultedRegistryReference<DataTranslator<Vector4i>> VECTOR_4_I = DataTranslators.key(ResourceKey.sponge("VECTOR_4_I"));

    public static final DefaultedRegistryReference<DataTranslator<Vector4l>> VECTOR_4_L = DataTranslators.key(ResourceKey.sponge("VECTOR_4_L"));

    public static final DefaultedRegistryReference<DataTranslator<ZonedDateTime>> ZONED_DATE_TIME = DataTranslators.key(ResourceKey.sponge("zoned_date_time"));

    // SORTFIELDS:OFF

    // @formatter:on

    private DataTranslators() {
    }

    private static <T> DefaultedRegistryReference<DataTranslator<T>> key(final ResourceKey location) {
        return RegistryKey.of(Registries.DATA_TRANSLATOR, location).asDefaultedReference(() -> Sponge.getGame().registries());
    }
}
