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
package org.spongepowered.api.util.transformation;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.util.Axis;
import org.spongepowered.api.util.ResettableBuilder;
import org.spongepowered.api.util.rotation.Rotation;
import org.spongepowered.api.util.rotation.Rotations;
import org.spongepowered.math.matrix.Matrix4d;
import org.spongepowered.math.vector.Vector3d;

/**
 * Performs spacial transformations on position and direction
 * {@link Vector3d}s, for general use in block transformations.
 */
public interface Transformation {

    /**
     * Gets a {@link Transformation.Builder} for creating transformations.
     *
     * @return A builder
     */
    static Transformation.Builder builder() {
        return Sponge.game().builderProvider().provide(Transformation.Builder.class);
    }

    /**
     * Transforms a {@link Vector3d} that represents a position based on the
     * transformation this object represents.
     *
     * @param original The position vector to transform
     * @return The transformed position vector
     */
    Vector3d transformPosition(Vector3d original);

    /**
     * Transforms a {@link Vector3d} that represents a direction based on the
     * transformation this object represents.
     *
     * <p>Specifically, this transformation will not apply any translational
     * transformations.</p>
     *
     * @param originalDirection The direction vector to transform
     * @return The transformed direction vector
     */
    Vector3d transformDirection(Vector3d originalDirection);

    /**
     * Gets the {@link Matrix4d matrix} used to perform this transformation
     * on position vectors.
     *
     * @return The {@link Matrix4d}
     */
    Matrix4d positionTransformationMatrix();

    /**
     * Gets the {@link Matrix4d matrix} used to perform this transformation
     * on direction vectors.
     *
     * @return The {@link Matrix4d}
     */
    Matrix4d directionTransformationMatrix();

    /**
     * Gets the origin of the {@linkplain #positionTransformationMatrix()
     * position transformation matrix}.
     *
     * @return The origin of the position transformations
     */
    Vector3d origin();

    /**
     * Gets the {@link Rotation} around the y-axis
     *
     * @return The {@link Rotation}
     */
    Rotation rotation();

    /**
     * Returns whether this transformation results in mirroring in the
     * direction of the provided axis.
     *
     * <p>This represents any mirroring that would need to occur
     * <strong>after</strong> any rotation has occurred. If you require
     * knowing what the mirror state would be pre-rotation, use
     * {@link #initialMirror(Axis)} instead.</p>
     *
     * @param axis The {@link Axis}
     * @return true if so
     */
    boolean mirror(Axis axis);

    /**
     * Returns the direction of mirroring in this transformation, if
     * mirroring was performed before rotation, at the point before
     * the mirroring occurs. The axis is in the direction of the
     * mirroring.
     *
     * <p>Unlike {@link #mirror(Axis)}, which provides a view to
     * the direction(s) of mirroring after all transformations have
     * taken place, this method returns the direction of mirroring
     * <strong>before any rotation has taken place</strong>, such
     * that if the {@link #rotation()} was set to
     * {@link Rotations#NONE}, this would be the direction of
     * mirroring.</p>
     *
     * @param axis The {@link Axis}
     * @return true if so
     */
    boolean initialMirror(Axis axis);

    /**
     * Gets the {@link Transformation} that reverses this transformation.
     *
     * @return The inverse transformation
     */
    Transformation inverse();

    /**
     * If this is {@code true}, then this transformation will attempt to round
     * the result to reduce the effects of machine precision, which may be
     * particularly useful for those who expect integer values.
     *
     * <p>The rounding should be on the order of 15 decimal places,
     * though other implementations may choose more sophisticated rounding.</p>
     *
     * @return Whether the result will have minor rounding applied.
     */
    boolean performsRounding();

    /**
     * Creates a {@link Builder} that represents this transformation.
     *
     * @return The builder.
     */
    Builder toBuilder();

    /**
     * Creates {@link Transformation transformations}.
     *
     * <p>Apart from the {@link #origin(Vector3d) origin} transformation, all
     * actions will be performed in the order specified in the builder. Thus,
     * a translation then a rotation will not produce the same results as
     * the reverse.</p>
     */
    interface Builder extends ResettableBuilder<Transformation, Builder> {

        /**
         * Specifies the origin for position transformations.
         *
         * <p>This is a special transform in that this translation is performed
         * before the rest of the transformations are made. Once all
         * transformations are performed, this transformation is undone. This
         * is especially useful if you are only transforming around a given
         * origin which is not at (0, 0, 0), as the rotation will be performed
         * around this origin instead.</p>
         *
         * <p>This does not affect
         * {@link Transformation#transformDirection(Vector3d)}</p>
         *
         * @param origin The origin to transform around
         * @return This builder, for chaining
         */
        Builder origin(Vector3d origin);

        /**
         * Performs a rotation about the provided {@link Axis} around the given
         * {@link #origin(Vector3d) origin} around the {@link Axis#Y y-axis}.
         *
         * @param rotation The {@link Rotation} to perform
         * @return This builder, for chaining
         */
        Builder rotate(Rotation rotation);

        /**
         * Performs a reflection of -1 in the direction of the given
         * {@link Axis}, where the plane from which scaling is performed is
         * normal to this axis and contains the {@link #origin(Vector3d)}.
         *
         * <p>For example, for a point (1, 2, 3), using this transformation
         * in the direction the x axis where the origin is at (0, 0, 0) will
         * result in a transformation to (-1, 2, 3).</p>
         *
         * <p>This action is effectively a scaling of -1 in the axis
         * direction.</p>
         *
         * @param axis The axis that represents the direction of scaling
         * @return This builder, for chaining
         */
        Builder mirror(Axis axis);

        /**
         * Performs a simple additive translation of a position {@link Vector3d}
         * by this supplied vector.
         *
         * <p>This does not affect
         * {@link Transformation#transformDirection(Vector3d)}</p>
         *
         * @param translate The translation
         * @return This builder, for chaining
         */
        Builder translate(Vector3d translate);

        /**
         * Attempts to round the result to attempt to compensate for
         * machine precision. Defaults to {@code true}.
         *
         * @see #performsRounding()
         *
         * @param round Whether to perform rounding
         * @return This builder, for chaining
         */
        Builder performRounding(boolean round);

        /**
         * Builds a {@link Transformation}
         *
         * @return A {@link Transformation}
         */
        Transformation build();

    }

}
