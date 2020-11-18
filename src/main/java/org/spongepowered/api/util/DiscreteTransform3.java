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
package org.spongepowered.api.util;

import org.spongepowered.math.GenericMath;
import org.spongepowered.math.imaginary.Quaterniond;
import org.spongepowered.math.matrix.Matrix3d;
import org.spongepowered.math.matrix.Matrix4d;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector3d;
import org.spongepowered.math.vector.Vector3i;
import org.spongepowered.math.vector.Vector4d;

import java.util.Arrays;
import java.util.Optional;

/**
 * Represents a transform. It is 3 dimensional and discrete.
 * It will never cause aliasing.
 *
 * <p>Rotations are performed around block centers unless
 * the block corner flags are set to true. To prevent
 * aliasing, quarter turn rotations are only legal on
 * block centers or corners. Half turns can be performed
 * additionally on edge and face centers.</p>
 */
public class DiscreteTransform3 {

    /**
     * Represents an identity transformation. Does nothing!
     */
    public static final DiscreteTransform3 IDENTITY = new DiscreteTransform3(Matrix4d.IDENTITY);
    private final Matrix4d matrix;
    private final Vector4d matrixRow0;
    private final Vector4d matrixRow1;
    private final Vector4d matrixRow2;

    private DiscreteTransform3(Matrix4d matrix) {
        this.matrix = matrix;
        this.matrixRow0 = matrix.getRow(0);
        this.matrixRow1 = matrix.getRow(1);
        this.matrixRow2 = matrix.getRow(2);
    }

    /**
     * Returns the matrix representation of the transform.
     * It is 4D to allow it to include a translation.
     *
     * @return The matrix for this transform
     */
    public Matrix4d getMatrix() {
        return this.matrix;
    }

    /**
     * Transforms a vector using this transforms.
     *
     * @param vector The original vector
     * @return The transformed vector
     */
    public Vector3i transform(Vector3i vector) {
        return transform(vector.getX(), vector.getY(), vector.getZ());
    }

    /**
     * Transform a vector represented as a pair of
     * coordinates using this transform.
     *
     * @param x The x coordinate of the original vector
     * @param y The y coordinate of the original vector
     * @param z The z coordinate of the original vector
     * @return The transformed vector
     */
    public Vector3i transform(int x, int y, int z) {
        return new Vector3i(transformX(x, y, z), transformY(x, y, z), transformZ(x, y, z));
    }

    /**
     * Transforms the x coordinate of a vector
     * using this transform. Only creates a new
     * object on the first call.
     *
     * @param vector The original vector
     * @return The transformed x coordinate
     */
    public int transformX(Vector3i vector) {
        return transformX(vector.getX(), vector.getY(), vector.getZ());
    }

    /**
     * Transforms the x coordinate of a vector
     * using this transform. Only creates a new
     * object on the first call.
     *
     * @param x The x coordinate of the original vector
     * @param y The y coordinate of the original vector
     * @param z The z coordinate of the original vector
     * @return The transformed x coordinate
     */
    public int transformX(int x, int y, int z) {
        return GenericMath.floor(this.matrixRow0.dot(x, y, z, 1) + GenericMath.FLT_EPSILON);
    }

    /**
     * Transforms the y coordinate of a vector
     * using this transform. Only creates a new
     * object on the first call.
     *
     * @param vector The original vector
     * @return The transformed y coordinate
     */
    public int transformY(Vector3i vector) {
        return transformY(vector.getX(), vector.getY(), vector.getZ());
    }

    /**
     * Transforms the y coordinate of a vector
     * using this transform. Only creates a new
     * object on the first call.
     *
     * @param x The x coordinate of the original vector
     * @param y The y coordinate of the original vector
     * @param z The z coordinate of the original vector
     * @return The transformed y coordinate
     */
    public int transformY(int x, int y, int z) {
        return GenericMath.floor(this.matrixRow1.dot(x, y, z, 1) + GenericMath.FLT_EPSILON);
    }

    /**
     * Transforms the z coordinate of a vector
     * using this transform. Only creates a new
     * object on the first call.
     *
     * @param vector The original vector
     * @return The transformed z coordinate
     */
    public int transformZ(Vector3i vector) {
        return transformZ(vector.getX(), vector.getY(), vector.getZ());
    }

    /**
     * Transforms the z coordinate of a vector
     * using this transform. Only creates a new
     * object on the first call.
     *
     * @param x The x coordinate of the original vector
     * @param y The y coordinate of the original vector
     * @param z The z coordinate of the original vector
     * @return The transformed z coordinate
     */
    public int transformZ(int x, int y, int z) {
        return GenericMath.floor(this.matrixRow2.dot(x, y, z, 1) + GenericMath.FLT_EPSILON);
    }

    /**
     * Inverts the transform and returns it as a new transform.
     *
     * @return The inverse of this transform
     */
    public DiscreteTransform3 invert() {
        return new DiscreteTransform3(this.matrix.invert());
    }

    /**
     * Returns a transform that is the composition of this transform and the
     * given transform. The result will apply this transformation after the
     * given one.
     *
     * @param that The transform to compose with
     * @return The new composed transform
     */
    public DiscreteTransform3 compose(DiscreteTransform3 that) {
        return new DiscreteTransform3(this.matrix.mul(that.matrix));
    }

    /**
     * Returns a transform that is the composition of the given transform with
     * this transform. The result will apply the given transformation after this
     * one.
     *
     * @param that The transform to compose with
     * @return The new composed transform
     */
    public DiscreteTransform3 andThen(DiscreteTransform3 that) {
        return that.compose(this);
    }

    /**
     * Adds a translation to this transform and returns
     * it as a new transform.
     *
     * @param vector The translation vector
     * @return The translated transform as a copy
     */
    public DiscreteTransform3 withTranslation(Vector3i vector) {
        return withTranslation(vector.getX(), vector.getY(), vector.getZ());
    }

    /**
     * Adds a translation to this transform and returns
     * it as a new transform.
     *
     * @param x The x coordinate of the translation
     * @param y The y coordinate of the translation
     * @param z The z coordinate of the translation
     * @return The translated transform as a copy
     */
    public DiscreteTransform3 withTranslation(int x, int y, int z) {
        return new DiscreteTransform3(this.matrix.translate(x, y, z));
    }

    /**
     * Adds a scale factor to this transform and returns
     * it as a new transform. This factor must be non-zero.
     *
     * @param a The scale factor
     * @return The scaled transform as a copy
     */
    public DiscreteTransform3 withScale(int a) {
        return withScale(a, a, a);
    }

    /**
     * Adds a scale factor for each axis to this transform
     * and returns it as a new transform. The factors must
     * be non-zero.
     *
     * @param vector The scale vector
     * @return The scaled transform as a copy
     */
    public DiscreteTransform3 withScale(Vector3i vector) {
        return withScale(vector.getX(), vector.getY(), vector.getZ());
    }

    /**
     * Adds a scale factor for each axis to this transform
     * and returns it as a new transform. The factors must
     * be non-zero.
     *
     * @param x The scale factor on x
     * @param y The scale factor on y
     * @param z The scale factor on z
     * @return The scaled transform as a copy
     */
    public DiscreteTransform3 withScale(int x, int y, int z) {
        if (x == 0) {
            throw new IllegalArgumentException("x == 0");
        }
        if (y == 0) {
            throw new IllegalArgumentException("y == 0");
        }
        if (z == 0) {
            throw new IllegalArgumentException("z == 0");
        }
        return new DiscreteTransform3(this.matrix.scale(x, y, z, 1));
    }

    /**
     * Adds a rotation to this transform, around an axis,
     * around the origin and returns it as a new transform.
     * The rotation is given is quarter turns.
     * The actual rotation is {@code quarterTurns * 90}.
     * The rotation is around the block center, not the corner.
     *
     * @param quarterTurns The number of quarter turns in this rotation
     * @param axis The axis to rotate around
     * @return The rotated transform as a copy
     */
    public DiscreteTransform3 withRotation(int quarterTurns, Axis axis) {
        return new DiscreteTransform3(this.matrix.rotate(Quaterniond.fromAngleDegAxis(quarterTurns * 90, axis.toVector3d())));
    }

    /**
     * Adds a a rotation to this transform, around an axis,
     * around a given point, and returns it as a new transform.
     * The rotation is given is quarter turns. The actual rotation
     * is {@code quarterTurns * 90}. The block corner flag changes
     * the point to be the block upper corner instead of the center.
     *
     * @param quarterTurns The number of quarter turns in this rotation
     * @param axis The axis to rotate around
     * @param point The point of rotation, as block coordinates
     * @param blockCorner Whether or not to use the corner of the block
     *     instead of the center
     * @return The rotated transform as a copy
     */
    public DiscreteTransform3 withRotation(int quarterTurns, Axis axis, Vector3i point, boolean blockCorner) {
        Vector3d pointDouble = point.toDouble();
        if (blockCorner) {
            pointDouble = pointDouble.add(0.5, 0.5, 0.5);
        }
        return new DiscreteTransform3(
            this.matrix.translate(pointDouble.negate()).rotate(Quaterniond.fromAngleDegAxis(quarterTurns * 90, axis.toVector3d()))
                .translate(pointDouble));
    }

    /**
     * Adds a a rotation to this transform, around an axis,
     * around a given point. The rotation is given is half turns.
     * The actual rotation is {@code halfTurns * 180}. The block corner
     * flags change the point to be the block corner or edge instead
     * of the center. When all flags are false, the center is used.
     * When only one is true the face traversed by the axis of flag is used.
     * When two are true the edge in the direction of the remaining flag
     * is used. When all are true the upper corner is used.
     *
     * @param halfTurns The number of half turns in this rotation
     * @param axis The axis to rotate around
     * @param point The point of rotation, as block coordinates
     * @param blockCornerX Whether or not to use the corner of the block
     *     instead of the center on the x axis
     * @param blockCornerY Whether or not to use the corner of the block
     *     instead of the center on the y axis
     * @param blockCornerZ Whether or not to use the corner of the block
     *     instead of the center on the z axis
     * @return The rotated transform as a copy
     */
    public DiscreteTransform3 withRotation(int halfTurns, Axis axis, Vector3i point, boolean blockCornerX, boolean blockCornerY,
        boolean blockCornerZ) {
        Vector3d pointDouble = point.toDouble();
        if (blockCornerX) {
            pointDouble = pointDouble.add(0.5, 0, 0);
        }
        if (blockCornerY) {
            pointDouble = pointDouble.add(0, 0.5, 0);
        }
        if (blockCornerZ) {
            pointDouble = pointDouble.add(0, 0, 0.5);
        }
        return new DiscreteTransform3(
            this.matrix.translate(pointDouble.negate()).rotate(Quaterniond.fromAngleDegAxis(halfTurns * 180, axis.toVector3d()))
                .translate(pointDouble));
    }

    /**
     * Adds another transformation to this transformation and
     * returns int as a new transform.
     *
     * @param transform The transformation to add
     * @return The added transforms as a copy
     */
    public DiscreteTransform3 withTransformation(DiscreteTransform3 transform) {
        return new DiscreteTransform3(transform.getMatrix().mul(getMatrix()));
    }

    /**
     * Returns a new transform from the given transformation matrix, if the
     * resulting transform would be discrete.
     *
     * @param matrix The matrix to use for the transform
     * @return The new transform, or {@link Optional#empty()}
     */
    public static Optional<DiscreteTransform3> of(Matrix4d matrix) {
        if (Arrays.stream(matrix.toArray())
                .anyMatch(value -> Math.rint(value) != value)) {
            return Optional.empty();
        }
        return Optional.of(new DiscreteTransform3(matrix));
    }

    /**
     * Returns a new transform representing a translation.
     *
     * @param vector The translation vector
     * @return The new translation transform
     */
    public static DiscreteTransform3 fromTranslation(Vector3i vector) {
        return fromTranslation(vector.getX(), vector.getY(), vector.getZ());
    }

    /**
     * Returns a new transform representing a translation.
     *
     * @param x The x coordinate of the translation
     * @param y The y coordinate of the translation
     * @param z The z coordinate of the translation
     * @return The new translation transform
     */
    public static DiscreteTransform3 fromTranslation(int x, int y, int z) {
        return new DiscreteTransform3(Matrix4d.createTranslation(x, y, z));
    }

    /**
     * Returns a new transform representing a scaling.
     * The scale factor must be non-zero.
     *
     * @param a The scale factor
     * @return The new scale transform
     */
    public static DiscreteTransform3 fromScale(int a) {
        return fromScale(a, a, a);
    }

    /**
     * Returns a new transform representing a scaling on each axis.
     * The scale factors must be non-zero.
     *
     * @param vector The scale vector
     * @return The new scale transform
     */
    public static DiscreteTransform3 fromScale(Vector3i vector) {
        return fromScale(vector.getX(), vector.getY(), vector.getZ());
    }

    /**
     * Returns a new transform representing a scaling on each axis.
     * The scale factors must be non-zero.
     *
     * @param x The scale factor on x
     * @param y The scale factor on y
     * @param z The scale factor on z
     * @return The new scale transform
     */
    public static DiscreteTransform3 fromScale(int x, int y, int z) {
        if (x == 0) {
            throw new IllegalArgumentException("x == 0");
        }
        if (y == 0) {
            throw new IllegalArgumentException("y == 0");
        }
        if (z == 0) {
            throw new IllegalArgumentException("z == 0");
        }
        return new DiscreteTransform3(Matrix4d.createScaling(x, y, z, 1));
    }

    /**
     * Returns a new transform representing a rotation around an
     * axis around the origin. The rotation is given is quarter turns.
     * The actual rotation is {@code quarterTurns * 90}.
     * The rotation is around the block center, not the corner.
     *
     * @param quarterTurns The number of quarter turns in this rotation
     * @param axis The axis to rotate around
     * @return The new rotation transform
     */
    public static DiscreteTransform3 fromRotation(int quarterTurns, Axis axis) {
        return new DiscreteTransform3(Matrix4d.createRotation(Quaterniond.fromAngleDegAxis(quarterTurns * 90, axis.toVector3d())));
    }

    /**
     * Returns a new transform representing a rotation around an axis,
     * around a given point. The rotation is given is quarter turns.
     * The actual rotation is {@code quarterTurns * 90}. The block corner
     * flag change the point to be the block corner instead of the center.
     *
     * @param quarterTurns The number of quarter turns in this rotation
     * @param axis The axis to rotate around
     * @param point The point of rotation, as block coordinates
     * @param blockCorner Whether or not to use the corner of the block
     *     instead of the center
     * @return The new rotation transform
     */
    public static DiscreteTransform3 fromRotation(int quarterTurns, Axis axis, Vector3i point, boolean blockCorner) {
        Vector3d pointDouble = point.toDouble();
        if (blockCorner) {
            pointDouble = pointDouble.add(0.5, 0.5, 0.5);
        }
        return new DiscreteTransform3(Matrix4d.createTranslation(pointDouble.negate()).rotate(Quaterniond.fromAngleDegAxis(quarterTurns * 90, axis
            .toVector3d())).translate(pointDouble));
    }

    /**
     * Returns a new transform representing a rotation around an axis,
     * around a given point. The rotation is given in half turns.
     * The actual rotation is {@code halfTurns * 180}. When all flags are
     * false, the center is used. When only one is true the face traversed
     * by the axis of flag is used. When two are true the edge in the
     * direction of the remaining flag is used. When all are true the
     * upper corner is used.
     *
     * @param halfTurns The number of half turns in this rotation
     * @param axis The axis to rotate around
     * @param point The point of rotation, as block coordinates
     * @param blockCornerX Whether or not to use the corner of the block
     *     instead of the center on the x axis
     * @param blockCornerY Whether or not to use the corner of the block
     *     instead of the center on the y axis
     * @param blockCornerZ Whether or not to use the corner of the block
     *     instead of the center on the z axis
     * @return The new rotation transform
     */
    public static DiscreteTransform3 fromRotation(int halfTurns, Axis axis, Vector3i point, boolean blockCornerX, boolean blockCornerY,
        boolean blockCornerZ) {
        Vector3d pointDouble = point.toDouble();
        if (blockCornerX) {
            pointDouble = pointDouble.add(0.5, 0, 0);
        }
        if (blockCornerY) {
            pointDouble = pointDouble.add(0, 0.5, 0);
        }
        if (blockCornerZ) {
            pointDouble = pointDouble.add(0, 0, 0.5);
        }
        return new DiscreteTransform3(
            Matrix4d.createTranslation(pointDouble.negate()).rotate(Quaterniond.fromAngleDegAxis(halfTurns * 180, axis.toVector3d())).translate(
                pointDouble));
    }

    /**
     * Returns a new transform representing a centered rotation of an volume
     * of blocks. The rotation is given is quarter turns. The actual rotation
     * is {@code quarterTurns * 90}. Volumes with differing parities on the
     * axes can only be rotated by multiples of 180 degrees.
     *
     * @param quarterTurns The amount of quarter turns in this rotation
     * @param axis Axis for rotation
     * @param size The size of the volume to rotate
     * @return The new rotation transform
     */
    public static DiscreteTransform3 rotationAroundCenter(int quarterTurns, Axis axis, Vector3i size) {
        if (size.getX() <= 0) {
            throw new IllegalArgumentException("The size on x must be positive!");
        }
        if (size.getY() <= 0) {
            throw new IllegalArgumentException("The size on y must be positive");
        }
        if (size.getZ() <= 0) {
            throw new IllegalArgumentException("The size on z must be positive!");
        }
        final Matrix4d rotation3;
        switch (axis) {
            case X: {
                final Matrix3d rotation2 = DiscreteTransform2.rotationAroundCenter(quarterTurns, new Vector2i(size.getZ(), size.getY())).getMatrix();
                rotation3 = new Matrix4d(
                    1, 0, 0, 0,
                    0, rotation2.get(1, 0), rotation2.get(1, 1), rotation2.get(1, 2),
                    0, rotation2.get(0, 0), rotation2.get(0, 1), rotation2.get(0, 2),
                    0, 0, 0, 1
                );
                break;
            }
            case Y: {
                final Matrix3d rotation2 = DiscreteTransform2.rotationAroundCenter(quarterTurns, new Vector2i(size.getX(), size.getZ())).getMatrix();
                rotation3 = new Matrix4d(
                    rotation2.get(0, 0), 0, rotation2.get(0, 1), rotation2.get(0, 2),
                    0, 1, 0, 0,
                    rotation2.get(1, 0), 0, rotation2.get(1, 1), rotation2.get(1, 2),
                    0, 0, 0, 1
                );
                break;
            }
            case Z: {
                final Matrix3d rotation2 = DiscreteTransform2.rotationAroundCenter(quarterTurns, new Vector2i(size.getX(), size.getY())).getMatrix();
                rotation3 = new Matrix4d(
                    rotation2.get(0, 0), rotation2.get(0, 1), 0, rotation2.get(0, 2),
                    rotation2.get(1, 0), rotation2.get(1, 1), 0, rotation2.get(1, 2),
                    0, 0, 1, 0,
                    0, 0, 0, 1
                );
                break;
            }
            default:
                throw new UnsupportedOperationException(axis.name());
        }
        return new DiscreteTransform3(rotation3);
    }

}
