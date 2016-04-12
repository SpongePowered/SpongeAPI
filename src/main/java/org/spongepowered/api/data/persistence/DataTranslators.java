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

import com.flowpowered.math.imaginary.Complexd;
import com.flowpowered.math.imaginary.Complexf;
import com.flowpowered.math.imaginary.Quaterniond;
import com.flowpowered.math.imaginary.Quaternionf;
import com.flowpowered.math.vector.Vector2d;
import com.flowpowered.math.vector.Vector2f;
import com.flowpowered.math.vector.Vector2i;
import com.flowpowered.math.vector.Vector2l;
import com.flowpowered.math.vector.Vector3d;
import com.flowpowered.math.vector.Vector3f;
import com.flowpowered.math.vector.Vector3i;
import com.flowpowered.math.vector.Vector3l;
import com.flowpowered.math.vector.Vector4d;
import com.flowpowered.math.vector.Vector4f;
import com.flowpowered.math.vector.Vector4i;
import com.flowpowered.math.vector.Vector4l;
import ninja.leaping.configurate.ConfigurationNode;
import org.spongepowered.api.util.generator.dummy.DummyObjectProvider;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.UUID;

public final class DataTranslators {

    // sortfields:ON
    public static final DataTranslator<ConfigurationNode> CONFIGURATION_NODE = DummyObjectProvider.createExtendedFor(DataTranslator.class, "CONFIGURATION_NODE");

    public static final DataTranslator<UUID> UUID = DummyObjectProvider.createExtendedFor(DataTranslator.class, "UUID");
    public static final DataTranslator<Vector2d> VECTOR_2_D = DummyObjectProvider.createExtendedFor(DataTranslator.class, "VECTOR_2_D");
    public static final DataTranslator<Vector2f> VECTOR_2_F = DummyObjectProvider.createExtendedFor(DataTranslator.class, "VECTOR_2_F");
    public static final DataTranslator<Vector2i> VECTOR_2_I = DummyObjectProvider.createExtendedFor(DataTranslator.class, "VECTOR_2_I");
    public static final DataTranslator<Vector2l> VECTOR_2_L = DummyObjectProvider.createExtendedFor(DataTranslator.class, "VECTOR_2_L");
    public static final DataTranslator<Vector3d> VECTOR_3_D = DummyObjectProvider.createExtendedFor(DataTranslator.class, "VECTOR_3_D");
    public static final DataTranslator<Vector3f> VECTOR_3_F = DummyObjectProvider.createExtendedFor(DataTranslator.class, "VECTOR_3_F");
    public static final DataTranslator<Vector3i> VECTOR_3_I = DummyObjectProvider.createExtendedFor(DataTranslator.class, "VECTOR_3_I");
    public static final DataTranslator<Vector3l> VECTOR_3_L = DummyObjectProvider.createExtendedFor(DataTranslator.class, "VECTOR_3_L");
    public static final DataTranslator<Vector4d> VECTOR_4_D = DummyObjectProvider.createExtendedFor(DataTranslator.class, "VECTOR_4_D");
    public static final DataTranslator<Vector4f> VECTOR_4_F = DummyObjectProvider.createExtendedFor(DataTranslator.class, "VECTOR_4_F");
    public static final DataTranslator<Vector4i> VECTOR_4_I = DummyObjectProvider.createExtendedFor(DataTranslator.class, "VECTOR_4_I");
    public static final DataTranslator<Vector4l> VECTOR_4_L = DummyObjectProvider.createExtendedFor(DataTranslator.class, "VECTOR_4_L");
    public static final DataTranslator<Complexd> COMPLEXD = DummyObjectProvider.createExtendedFor(DataTranslator.class, "COMPLEXD");
    public static final DataTranslator<Complexf> COMPLEXF = DummyObjectProvider.createExtendedFor(DataTranslator.class, "COMPLEXF");
    public static final DataTranslator<Quaterniond> QUATERNIOND = DummyObjectProvider.createExtendedFor(DataTranslator.class, "QUATERNIOND");
    public static final DataTranslator<Quaternionf> QUATERNIONF = DummyObjectProvider.createExtendedFor(DataTranslator.class, "QUATERNIONF");
    public static final DataTranslator<LocalTime> LOCAL_TIME = DummyObjectProvider.createExtendedFor(DataTranslator.class, "LOCAL_TIME");
    public static final DataTranslator<LocalDate> LOCAL_DATE = DummyObjectProvider.createExtendedFor(DataTranslator.class, "LOCAL_DATE");
    public static final DataTranslator<LocalDateTime> LOCAL_DATE_TIME = DummyObjectProvider.createExtendedFor(DataTranslator.class, "LOCAL_DATE_TIME");
    public static final DataTranslator<Instant> INSTANT = DummyObjectProvider.createExtendedFor(DataTranslator.class, "INSTANT");
    public static final DataTranslator<ZonedDateTime> ZONED_DATE_TIME = DummyObjectProvider.createExtendedFor(DataTranslator.class, "ZONED_DATE_TIME");

    // sortfields:OFF

    private DataTranslators() {
    }

}