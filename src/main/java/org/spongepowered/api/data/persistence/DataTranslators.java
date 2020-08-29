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
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.fluid.FluidState;
import org.spongepowered.api.world.schematic.Schematic;
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
import java.util.function.Supplier;

public final class DataTranslators {

    // SORTFIELDS:ON

    public static final Supplier<DataTranslator<BlockState>> BLOCK_STATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "block_state");

    public static final Supplier<DataTranslator<Complexd>> COMPLEXD = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "complexd");

    public static final Supplier<DataTranslator<Complexf>> COMPLEXF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "complexf");

    public static final Supplier<DataTranslator<Component>> COMPONENT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "component");

    public static final Supplier<DataTranslator<ConfigurationNode>> CONFIGURATION_NODE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "configuration_node");

    public static final Supplier<DataTranslator<FluidState>> FLUID_STATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "fluid_state");

    public static final Supplier<DataTranslator<Instant>> INSTANT = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "instant");

    public static final Supplier<DataTranslator<Schematic>> LEGACY_SCHEMATIC = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "legacy_schematic");

    public static final Supplier<DataTranslator<LocalDate>> LOCAL_DATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "local_date");

    public static final Supplier<DataTranslator<LocalDateTime>> LOCAL_DATE_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "local_date_time");

    public static final Supplier<DataTranslator<LocalTime>> LOCAL_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "local_time");

    public static final Supplier<DataTranslator<Schematic>> MOJANG_TEMPLATE = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "mojang_template");

    public static final Supplier<DataTranslator<Quaterniond>> QUATERNIOND = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "quaterniond");

    public static final Supplier<DataTranslator<Quaternionf>> QUATERNIONF = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "quaternionf");

    public static final Supplier<DataTranslator<Schematic>> SCHEMATIC = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "schematic");

    public static final Supplier<DataTranslator<UUID>> UUID = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "uuid");

    public static final Supplier<DataTranslator<Vector2d>> VECTOR_2_D = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "VECTOR_2_D");

    public static final Supplier<DataTranslator<Vector2f>> VECTOR_2_F = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "VECTOR_2_F");

    public static final Supplier<DataTranslator<Vector2i>> VECTOR_2_I = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "VECTOR_2_I");

    public static final Supplier<DataTranslator<Vector2l>> VECTOR_2_L = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "VECTOR_2_L");

    public static final Supplier<DataTranslator<Vector3d>> VECTOR_3_D = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "VECTOR_3_D");

    public static final Supplier<DataTranslator<Vector3f>> VECTOR_3_F = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "VECTOR_3_F");

    public static final Supplier<DataTranslator<Vector3i>> VECTOR_3_I = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "VECTOR_3_I");

    public static final Supplier<DataTranslator<Vector3l>> VECTOR_3_L = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "VECTOR_3_L");

    public static final Supplier<DataTranslator<Vector4d>> VECTOR_4_D = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "VECTOR_4_D");

    public static final Supplier<DataTranslator<Vector4f>> VECTOR_4_F = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "VECTOR_4_F");

    public static final Supplier<DataTranslator<Vector4i>> VECTOR_4_I = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "VECTOR_4_I");

    public static final Supplier<DataTranslator<Vector4l>> VECTOR_4_L = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "VECTOR_4_L");

    public static final Supplier<DataTranslator<ZonedDateTime>> ZONED_DATE_TIME = Sponge.getRegistry().getCatalogRegistry().provideSupplier(DataTranslator.class, "zoned_date_time");

    // SORTFIELDS:OFF

    private DataTranslators() {
    }
}
