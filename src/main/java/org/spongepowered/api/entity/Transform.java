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
package org.spongepowered.api.entity;

import com.flowpowered.math.imaginary.Quaterniond;
import com.flowpowered.math.matrix.Matrix4d;
import com.flowpowered.math.vector.Vector3d;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.extent.Extent;

/**
 * Represents the world attributes of an {@link Entity}. Comprised of a
 * {@link Location} and two {@link Vector3d} representing the rotation
 * and the scale. The implementation may internally use a location or a
 * separate extent and position. Be wary that calling {@link #getLocation()}
 * could result in object creation.
 *
 * <p>A transform might not have an extent if it is invalid. In this case
 * all methods which return a reference to it will throw
 * {@link IllegalStateException}.</p>
 *
 * <p>This is an entity transform, not a model one. These values are subject
 * to interpretation by the implementation and may trigger animations
 * depending on the target model.</p>
 *
 * <p>Even though Minecraft doesn't currently support entity scales
 * it is part of the transform in case it gets added later. For now
 * this return {@link Vector3d#ONE}.</p>
 *
 * @param <E> The extent containing the transform
 */
public interface Transform<E extends Extent> {

    /**
     * Gets the {@link Location} this transform contains.
     * This is the position and the extent.
     *
     * @return The location
     * @throws IllegalStateException If the transform doesn't have an extent
     */
    Location<E> getLocation();

    /**
     * Sets the {@link Location} of this transform.
     * This sets both the position and the extent.
     *
     * @param location The new location
     * @return This object, for chaining
     */
    Transform<E> setLocation(Location<E> location);

    /**
     * Gets the {@link Extent} this transform contains.
     *
     * @return The extent
     * @throws IllegalStateException If the transform doesn't have an extent
     */
    E getExtent();

    /**
     * Sets the {@link Extent} of this transform.
     *
     * @param extent The new extent
     * @return This object, for chaining
     */
    Transform<E> setExtent(E extent);

    /**
     * Gets the coordinates of this transform.
     *
     * @return The coordinates
     */
    Vector3d getPosition();

    /**
     * Sets the coordinates of this transform.
     *
     * @param position The new position
     * @return The object, for chaining
     */
    Transform<E> setPosition(Vector3d position);

    /**
     * Gets the rotation of this transform, as a {@link Vector3d}.
     *
     * <p>The format of the rotation is represented by:</p>
     * <ul>
     *     <li><code>x -> pitch</code></li>
     *     <li><code>y -> yaw</code></li>
     *     <li><code>z -> roll</code></li>
     * </ul>
     *
     * @return The rotation vector
     */
    Vector3d getRotation();

    /**
     * Sets the rotation of this transform.
     *
     * <p>The format of the rotation is represented by:</p>
     * <ul>
     *     <li><code>x -> pitch</code></li>
     *     <li><code>y -> yaw</code></li>
     *     <li><code>z -> roll</code></li>
     * </ul>
     *
     * @param rotation The new rotation
     * @return This object, for chaining
     */
    Transform<E> setRotation(Vector3d rotation);

    /**
     * Returns the rotation as a quaternion.
     * Quaternions are objectively better than
     * the Euler angles preferred by Minecraft.
     * This is for compatibility with
     * the flow-math library.
     *
     * @return The rotation
     */
    Quaterniond getRotationAsQuaternion();

    /**
     * Sets the rotation as a quaternion.
     * Quaternions are objectively better than
     * the Euler angles preferred by Minecraft.
     * This is for compatibility with
     * the flow-math library.
     *
     * @param rotation The rotation
     * @return This object, for chaining
     */
    Transform<E> setRotation(Quaterniond rotation);

    /**
     * Gets the pitch component of this transform rotation
     *
     * @return The pitch
     */
    double getPitch();

    /**
     * Gets the yaw component of this transform rotation
     *
     * @return The yaw
     */
    double getYaw();

    /**
     * Gets the roll component of this transform rotation
     *
     * @return The roll
     */
    double getRoll();

    /**
     * Gets the scale of the transform for each axis.
     *
     * @return The scale
     */
    Vector3d getScale();

    /**
     * Sets the scale of the transform for each axis.
     *
     * @return This object, for chaining
     */
    Transform<E> setScale(Vector3d scale);

    /**
     * "Adds" another transform to this one.
     * This is equivalent to adding the
     * translation, rotation and scale
     * individually.
     *
     * @param other The transform to add
     * @return This object, for chaining
     */
    Transform<E> add(Transform<E> other);

    /**
     * Adds a translation to this transform.
     *
     * @param translation The translation to add
     * @return This object, for chaining
     */
    Transform<E> addTranslation(Vector3d translation);

    /**
     * Adds a rotation to this transform.
     *
     * @param rotation The rotation to add
     * @return This object, for chaining
     */
    Transform<E> addRotation(Vector3d rotation);

    /**
     * Adds a rotation to this transform.
     * Quaternions are objectively better than
     * the Euler angles preferred by Minecraft.
     * This is the preferred method when
     * dealing with rotation additions.
     * This is for compatibility with
     * the flow-math library.
     *
     * @param rotation The rotation to add
     * @return This object, for chaining
     */
    Transform<E> addRotation(Quaterniond rotation);

    /**
     * "Adds" a scale to this transform.
     * Scales are multiplicative, so
     * this actually multiplies the
     * current scale.
     *
     * @param scale The scale to add
     * @return This object, for chaining
     */
    Transform<E> addScale(Vector3d scale);

    /**
     * Returns a matrix representation of this transform.
     * This includes the position, rotation and scale.
     * To apply the transform to a vector, use the following
     *
     * <p><pre>{@code
     * Vector3d original = ...;
     * Transform transform = ...;
     *
     * Vector3d transformed = transform.toMatrix().transform(original.toVector4(1)).toVector3();
     * }</pre></p>
     *
     * <p>This converts the original 3D vector to 4D by appending 1 as the w coordinate,
     * applies the transformation, then converts it back to 3D by dropping the w coordinate.</p>
     *
     * <p>Using a 4D matrix and a w coordinate with value 1 is what allows for the position
     * to be included in the transformation applied by the matrix.</p>
     *
     * @return The transform as a matrix
     */
    Matrix4d toMatrix();

    /**
     * Returns if this {@link Transform} is still valid.
     * Examples of invalid Transforms are:
     * <ul>
     *     <li>A Transform without an {@link Extent}</li>
     *     <li>A Transform whose {@link Extent} object is no longer present</li>
     *     <li>A Transform whose coordinates are illegal (defined by the implementation)</li>
     * </ul>
     *
     * @return True if valid, false if not
     */
    boolean isValid();

    /**
     * Invalidates this transform. {@link #isValid()} will return false.
     */
    void invalidate();

}
