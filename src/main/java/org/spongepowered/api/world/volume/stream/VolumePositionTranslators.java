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
package org.spongepowered.api.world.volume.stream;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.math.imaginary.Quaterniond;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public final class VolumePositionTranslators {

    public static final Vector3d BLOCK_OFFSET = new Vector3d(0.5, 0.5, 0.5);

    public static <W extends Volume, E> VolumePositionTranslator<W, E> identity() {
        return element -> element;
    }

    public static <W extends Volume> VolumePositionTranslator<W, BlockState> rotateBlocksOn(final Vector3i start, final Vector3d center, final Rotation rotation) {
        return VolumePositionTranslators.rotateOn(start, center, rotation, (position, state) -> state.rotate(rotation));
    }

    public static <W extends Volume, E> VolumePositionTranslator<W, E> rotateOn(final Vector3i start, final Vector3d center, final Rotation rotation,
        final BiFunction<Vector3d, E, E> elementRotation
    ) {
        return element -> {
            final Quaterniond q = Quaterniond.fromAngleDegAxis(rotation.angle().degrees(), 0, 1, 0);
            final Vector3d v = q.rotate(center).add(element.position().sub(start.toDouble()));
            return VolumeElement.of(element.volume(), elementRotation.apply(v, element.type()), v);
        };
    }

    public static <W extends Volume, E> VolumePositionTranslator<W, E> relativeTo(final Vector3i newOrigin) {
        return VolumePositionTranslators.relativeTo(newOrigin.toDouble().sub(VolumePositionTranslators.BLOCK_OFFSET));
    }

    public static <W extends Volume, E> VolumePositionTranslator<W, E> relativeTo(final Vector3d newOrigin) {
        return element -> VolumeElement.of(element.volume(), element.type(), element.position().add(newOrigin));
    }

    public static <W extends Volume, E> VolumePositionTranslator<W, E> offset(final Vector3i min) {
        return VolumePositionTranslators.offset(min.toDouble().add(VolumePositionTranslators.BLOCK_OFFSET));
    }

    public static <W extends Volume, E> VolumePositionTranslator<W, E> offset(final Vector3d min) {
        return element -> VolumeElement.of(element.volume(), element.type(), element.position().sub(min));
    }

    public static <W extends Volume, E> VolumePositionTranslator<W, E> position(final Function<Vector3d, Vector3d> func) {
        Objects.requireNonNull(func, "Position function cannot be null!");
        return element -> VolumeElement.of(element.volume(), element.type(), func.apply(element.position()));
    }

    private VolumePositionTranslators() {}
}
