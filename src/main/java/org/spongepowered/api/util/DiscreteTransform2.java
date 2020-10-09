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
import org.spongepowered.math.imaginary.Complexd;
import org.spongepowered.math.matrix.Matrix3d;
import org.spongepowered.math.vector.Vector2d;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector3d;

import java.util.Arrays;
import java.util.Optional;

/**
 * Represents a transform. It is 2 dimensional and discrete. It will never cause
 * aliasing.
 *
 * <p>Rotations are performed around tile centers unless the tile corner flags
 * are set to true. To prevent aliasing, quarter turn rotations are only legal
 * on block centers or corners. Half turns can be performed additionally on line
 * centers.</p>
 */
public class DiscreteTransform2 {

    /**
     * Represents an identity transformation. Does nothing!
     */
    public static final DiscreteTransform2 IDENTITY = new DiscreteTransform2(Matrix3d.IDENTITY);
    private final Matrix3d matrix;
    private final Vector3d matrixRow0;
    private final Vector3d matrixRow1;

    private DiscreteTransform2(Matrix3d matrix) {
        this.matrix = matrix;
        this.matrixRow0 = matrix.getRow(0);
        this.matrixRow1 = matrix.getRow(1);
    }

    /**
     * Returns the matrix representation of the transform. It is 3D to allow it
     * to include a translation.
     *
     * @return The matrix for this transform
     */
    public Matrix3d getMatrix() {
        return this.matrix;
    }

    /**
     * Transforms a vector using this transforms.
     *
     * @param vector The original vector
     * @return The transformed vector
     */
    public Vector2i transform(Vector2i vector) {
        return transform(vector.getX(), vector.getY());
    }

    /**
     * Transform a vector represented as a pair of coordinates using this
     * transform.
     *
     * @param x The x coordinate of the original vector
     * @param y The y coordinate of the original vector
     * @return The transformed vector
     */
    public Vector2i transform(int x, int y) {
        return new Vector2i(transformX(x, y), transformY(x, y));
    }

    /**
     * Transforms the x coordinate of a vector using this transform. Only
     * creates a new object on the first call.
     *
     * @param vector The original vector
     * @return The transformed x coordinate
     */
    public int transformX(Vector2i vector) {
        return transformX(vector.getX(), vector.getY());
    }

    /**
     * Transforms the x coordinate of a vector using this transform. Only
     * creates a new object on the first call.
     *
     * @param x The x coordinate of the original vector
     * @param y The y coordinate of the original vector
     * @return The transformed x coordinate
     */
    public int transformX(int x, int y) {
        return GenericMath.floor(this.matrixRow0.dot(x, y, 1) + GenericMath.FLT_EPSILON);
    }

    /**
     * Transforms the y coordinate of a vector using this transform. Only
     * creates a new object on the first call.
     *
     * @param vector The original vector
     * @return The transformed y coordinate
     */
    public int transformY(Vector2i vector) {
        return transformY(vector.getX(), vector.getY());
    }

    /**
     * Transforms the y coordinate of a vector using this transform. Only
     * creates a new object on the first call.
     *
     * @param x The x coordinate of the original vector
     * @param y The y coordinate of the original vector
     * @return The transformed y coordinate
     */
    public int transformY(int x, int y) {
        return GenericMath.floor(this.matrixRow1.dot(x, y, 1) + GenericMath.FLT_EPSILON);
    }

    /**
     * Inverts the transform and returns it as a new transform.
     *
     * @return The inverse of this transform
     */
    public DiscreteTransform2 invert() {
        return new DiscreteTransform2(this.matrix.invert());
    }

    /**
     * Returns a transform that is the composition of this transform and the
     * given transform. The result will apply this transformation after the
     * given one.
     *
     * @param that The transform to compose with
     * @return The new composed transform
     */
    public DiscreteTransform2 compose(DiscreteTransform2 that) {
        return new DiscreteTransform2(this.matrix.mul(that.matrix));
    }

    /**
     * Returns a transform that is the composition of the given transform with
     * this transform. The result will apply the given transformation after
     * this one.
     *
     * @param that The transform to compose with
     * @return The new composed transform
     */
    public DiscreteTransform2 andThen(DiscreteTransform2 that) {
        return that.compose(this);
    }

    /**
     * Adds a translation to this transform and returns it as a new transform.
     *
     * @param vector The translation vector
     * @return The translated transform as a copy
     */
    public DiscreteTransform2 withTranslation(Vector2i vector) {
        return withTranslation(vector.getX(), vector.getY());
    }

    /**
     * Adds a translation to this transform and returns it as a new transform.
     *
     * @param x The x coordinate of the translation
     * @param y The y coordinate of the translation
     * @return The translated transform as a copy
     */
    public DiscreteTransform2 withTranslation(int x, int y) {
        return new DiscreteTransform2(this.matrix.translate(x, y));
    }

    /**
     * Adds a scale factor to this transform and returns it as a new transform.
     * This factor must be non-zero.
     *
     * @param a The scale factor
     * @return The scaled transform as a copy
     */
    public DiscreteTransform2 withScale(int a) {
        return withScale(a, a);
    }

    /**
     * Adds a scale factor for each axis to this transform and returns it as a
     * new transform. The factors must be non-zero.
     *
     * @param vector The scale vector
     * @return The scaled transform as a copy
     */
    public DiscreteTransform2 withScale(Vector2i vector) {
        return withScale(vector.getX(), vector.getY());
    }

    /**
     * Adds a scale factor for each axis to this transform and returns it as a
     * new transform. The factors must be non-zero.
     *
     * @param x The scale factor on x
     * @param y The scale factor on y
     * @return The scaled transform as a copy
     */
    public DiscreteTransform2 withScale(int x, int y) {
        if (x == 0) {
            throw new IllegalArgumentException("x == 0");
        }
        if (y == 0) {
            throw new IllegalArgumentException("y == 0");
        }
        return new DiscreteTransform2(this.matrix.scale(x, y, 1));
    }

    /**
     * Adds a rotation to this transform, in the xy plane, around the origin and
     * returns it as a new transform. The rotation is given is quarter turns.
     * The actual rotation is {@code quarterTurns * 90}. The rotation is around
     * the block center, not the corner.
     *
     * @param quarterTurns The number of quarter turns in this rotation
     * @return The rotated transform as a copy
     */
    public DiscreteTransform2 withRotation(int quarterTurns) {
        return new DiscreteTransform2(this.matrix.rotate(Complexd.fromAngleDeg(quarterTurns * 90)));
    }

    /**
     * Adds a a rotation to this transform, in the xy plane, around a given
     * point, and returns it as a new transform. The rotation is given is
     * quarter turns. The actual rotation is {@code quarterTurns * 90}. The tile
     * corner flag changes the point to be the tile upper corner instead of the
     * center.
     *
     * @param quarterTurns The number of quarter turns in this rotation
     * @param point The point of rotation, as tile coordinates
     * @param tileCorner Whether or not to use the corner of the tile instead of
     *        the center
     * @return The rotated transform as a copy
     */
    public DiscreteTransform2 withRotation(int quarterTurns, Vector2i point, boolean tileCorner) {
        Vector2d pointDouble = point.toDouble();
        if (tileCorner) {
            pointDouble = pointDouble.add(0.5, 0.5);
        }
        return new DiscreteTransform2(
            this.matrix.translate(pointDouble.negate()).rotate(Complexd.fromAngleDeg(quarterTurns * 90)).translate(pointDouble));
    }

    /**
     * Adds a a rotation to this transform, in the xy plane, around a given
     * point, and returns it as a new transform. The rotation is given is half
     * turns. The actual rotation is {@code halfTurns * 180}. The tile corner
     * flags change the point to be the tile corner or edge instead of the
     * center. When both flags are false, the center is used. When only one is
     * true the edge on the opposite axis to the flag is used. When both are
     * true the upper corner is used.
     *
     * @param halfTurns The number of half turns in this rotation
     * @param point The point of rotation, as tile coordinates
     * @param tileCornerX Whether or not to use the corner of the tile instead
     *        of the center on the x axis
     * @param tileCornerY Whether or not to use the corner of the tile instead
     *        of the center on the y axis
     * @return The rotated transform as a copy
     */
    public DiscreteTransform2 withRotation(int halfTurns, Vector2i point, boolean tileCornerX, boolean tileCornerY) {
        Vector2d pointDouble = point.toDouble();
        if (tileCornerX) {
            pointDouble = pointDouble.add(0.5, 0);
        }
        if (tileCornerY) {
            pointDouble = pointDouble.add(0, 0.5);
        }
        return new DiscreteTransform2(
                this.matrix.translate(pointDouble.negate()).rotate(Complexd.fromAngleDeg(halfTurns * 180)).translate(pointDouble));
    }

    /**
     * Adds another transformation to this transformation and returns int as a
     * new transform.
     *
     * @param transform The transformation to add
     * @return The added transforms as a copy
     */
    public DiscreteTransform2 withTransformation(DiscreteTransform2 transform) {
        return new DiscreteTransform2(transform.getMatrix().mul(getMatrix()));
    }

    /**
     * Returns a new transform from the given transformation matrix, if the
     * resulting transform would be discrete.
     *
     * @param matrix The matrix to use for the transform
     * @return The new transform, or {@link Optional#empty()}
     */
    public static Optional<DiscreteTransform2> of(Matrix3d matrix) {
        if (Arrays.stream(matrix.toArray())
            .anyMatch(value -> Math.rint(value) != value)) {
            return Optional.empty();
        }
        return Optional.of(new DiscreteTransform2(matrix));
    }

    /**
     * Returns a new transform representing a translation.
     *
     * @param vector The translation vector
     * @return The new translation transform
     */
    public static DiscreteTransform2 fromTranslation(Vector2i vector) {
        return fromTranslation(vector.getX(), vector.getY());
    }

    /**
     * Returns a new transform representing a translation.
     *
     * @param x The x coordinate of the translation
     * @param y The y coordinate of the translation
     * @return The new translation transform
     */
    public static DiscreteTransform2 fromTranslation(int x, int y) {
        return new DiscreteTransform2(Matrix3d.createTranslation(x, y));
    }

    /**
     * Returns a new transform representing a scaling.
     * The scale factor must be non-zero.
     *
     * @param a The scale factor
     * @return The new scale transform
     */
    public static DiscreteTransform2 fromScale(int a) {
        return fromScale(a, a);
    }

    /**
     * Returns a new transform representing a scaling on each axis. The scale
     * factors must be non-zero.
     *
     * @param vector The scale vector
     * @return The new scale transform
     */
    public static DiscreteTransform2 fromScale(Vector2i vector) {
        return fromScale(vector.getX(), vector.getY());
    }

    /**
     * Returns a new transform representing a scaling on each axis. The scale
     * factors must be non-zero.
     *
     * @param x The scale factor on x
     * @param y The scale factor on y
     * @return The new scale transform
     */
    public static DiscreteTransform2 fromScale(int x, int y) {
        if (x == 0) {
            throw new IllegalArgumentException("x == 0");
        }
        if (y == 0) {
            throw new IllegalArgumentException("y == 0");
        }
        return new DiscreteTransform2(Matrix3d.createScaling(x, y, 1));
    }

    /**
     * Returns a new transform representing a rotation in the xy plane around
     * the origin. The rotation is given is quarter turns. The actual rotation
     * is {@code quarterTurns * 90}. The rotation is around the block center,
     * not the corner.
     *
     * @param quarterTurns The number of quarter turns in this rotation
     * @return The new rotation transform
     */
    public static DiscreteTransform2 fromRotation(int quarterTurns) {
        return new DiscreteTransform2(Matrix3d.createRotation(Complexd.fromAngleDeg(quarterTurns * 90)));
    }

    /**
     * Returns a new transform representing a rotation in the xy plane, around a
     * given point. The rotation is given is quarter turns. The actual rotation
     * is {@code quarterTurns * 90}. The tile corner flag change the point to be
     * the tile corner instead of the center.
     *
     * @param quarterTurns The number of quarter turns in this rotation
     * @param point The point of rotation, as tile coordinates
     * @param tileCorner Whether or not to use the corner of the tile instead of
     *        the center
     * @return The new rotation transform
     */
    public static DiscreteTransform2 fromRotation(int quarterTurns, Vector2i point, boolean tileCorner) {
        Vector2d pointDouble = point.toDouble();
        if (tileCorner) {
            pointDouble = pointDouble.add(0.5, 0.5);
        }
        return new DiscreteTransform2(
            Matrix3d.createTranslation(pointDouble.negate()).rotate(Complexd.fromAngleDeg(quarterTurns * 90)).translate(pointDouble));
    }

    /**
     * Returns a new transform representing a rotation in the xy plane, around a
     * given point. The rotation is given is half turns. The actual rotation is
     * {@code halfTurns * 180}. The tile corner flags change the point to be the
     * tile corner or edge instead of the center. When both flags are false, the
     * center is used. When only one is true the edge on the opposite axis to
     * the flag is used. When both are true the upper corner is used.
     *
     * @param halfTurns The number of half turns in this rotation
     * @param point The point of rotation, as tile coordinates
     * @param tileCornerX Whether or not to use the corner of the tile instead
     *        of the center on the x axis
     * @param tileCornerY Whether or not to use the corner of the tile instead
     *        of the center on the y axis
     * @return The new rotation transform
     */
    public static DiscreteTransform2 fromRotation(int halfTurns, Vector2i point, boolean tileCornerX, boolean tileCornerY) {
        Vector2d pointDouble = point.toDouble();
        if (tileCornerX) {
            pointDouble = pointDouble.add(0.5, 0);
        }
        if (tileCornerY) {
            pointDouble = pointDouble.add(0, 0.5);
        }
        return new DiscreteTransform2(
                Matrix3d.createTranslation(pointDouble.negate()).rotate(Complexd.fromAngleDeg(halfTurns * 180)).translate(pointDouble));
    }

    /**
     * Returns a new transform representing a centered rotation of an area of
     * tiles. The rotation is given is quarter turns. The actual rotation is
     * {@code quarterTurns * 90}. Areas with differing parities on the axes can
     * only be rotated by multiples of 180 degrees.
     *
     * @param quarterTurns The amount of quarter turns in this rotation
     * @param size The size of the area to rotate
     * @return The new rotation transform
     */
    public static DiscreteTransform2 rotationAroundCenter(int quarterTurns, Vector2i size) {
        if (size.getX() <= 0) {
            throw new IllegalArgumentException("The size on x must be positive");
        }
        if (size.getY() <= 0) {
            throw new IllegalArgumentException("The size on y must be positive");
        }
        final boolean mul180 = (quarterTurns & 1) == 0;
        final boolean xEven = (size.getX() & 1) == 0;
        final boolean yEven = (size.getY() & 1) == 0;
        if (!mul180 || xEven != yEven) {
            throw new IllegalArgumentException("The size must have the same parity on all axes for rotations that are "
                + "not a multiple of 180 degrees");
        }
        final Vector2i center = size.sub(1, 1).div(2);
        if (mul180) {
            return fromRotation(quarterTurns, center, xEven, yEven);
        }
        return fromRotation(quarterTurns, center, xEven);
    }

}
