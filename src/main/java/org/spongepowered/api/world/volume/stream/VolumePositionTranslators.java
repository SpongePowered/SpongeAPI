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
import org.spongepowered.api.block.entity.BlockEntity;
import org.spongepowered.api.entity.Entity;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.world.volume.Volume;
import org.spongepowered.math.imaginary.Quaterniond;
import org.spongepowered.math.vector.Vector3i;

import java.util.function.Function;

public final class VolumePositionTranslators {

    public static <W extends Volume, E> VolumePositionTranslator<W, E> identity() {
        return element -> element;
    }

    public static <W extends Volume> VolumePositionTranslator<W, BlockState> rotateBlocksOn(final Vector3i center, final Rotation rotation) {
        return VolumePositionTranslators.rotateOn(center, rotation, (state) -> state.rotate(rotation));
    }

    public static <W extends Volume> VolumePositionTranslator<W, Entity> rotateEntitiesOn(final Vector3i center, final Rotation rotation) {
        return VolumePositionTranslators.rotateOn(center, rotation, (entity) -> {
            entity.setRotation(entity.getRotation().add(0, (float) rotation.getAngle() / 360, 0));
            return entity;
        });
    }

    public static <W extends Volume> VolumePositionTranslator<W, BlockEntity> rotateBlockEntitiesOn(final Vector3i center,
        final Rotation rotation
    ) {
        return VolumePositionTranslators.rotateOn(center, rotation, (blockEntity -> blockEntity.rotate(rotation)));
    }

    public static <W extends Volume, E> VolumePositionTranslator<W, E> rotateOn(final Vector3i center, final Rotation rotation,
        final Function<E, E> elementRotation
    ) {
        return element -> {
            final Quaterniond q = Quaterniond.fromAngleDegAxis(rotation.getAngle(), 0, 1, 0);
            final Vector3i v = q.rotate(element.getPosition().sub(center).toDouble()).toInt().add(center);
            return VolumeElement.of(element.getVolume(), elementRotation.apply(element.getType()), v);
        };
    }

    public static <W extends Volume, E> VolumePositionTranslator<W, E> offsetPosition(final Vector3i origin,
        Vector3i originalOrigin
    ) {
        final Vector3i diff = origin.sub(originalOrigin);
        return element -> VolumeElement.of(element.getVolume(), element.getType(), element.getPosition().add(diff));
    }

    private VolumePositionTranslators() {}
}
